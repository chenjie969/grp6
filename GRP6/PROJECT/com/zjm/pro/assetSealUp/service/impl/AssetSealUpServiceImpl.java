package com.zjm.pro.assetSealUp.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.assetSealUp.service.AssetSealUpService;
import com.zjm.pro.db.map.Pro_assetSealUpMapper;
import com.zjm.pro.db.map.Pro_projectLawsuitMapper;
import com.zjm.pro.db.model.Pro_assetSealUp;
import com.zjm.pro.db.model.Pro_projectLawsuit;
import com.zjm.util.Tool;


@Service("assetSeaulUpService")
@Transactional
public class AssetSealUpServiceImpl implements AssetSealUpService{	
	@Resource
	private AssetSealUpService assetSeaulUpService;
	@Resource
	private Pro_assetSealUpMapper pro_assetSealUpMapper;
	@Resource
	private Pro_projectLawsuitMapper projectLawsuitMapper;
	@Resource
	private LogService logService;
	@Override
	public Boolean insertOneSeaulUp(User userSession,Pro_assetSealUp pro_assetSealUp) {
		pro_assetSealUp.setAssetSealUp_ID(Tool.createUUID32());
		pro_assetSealUp.setUnit_uid(userSession.getUnit_uid());
		pro_assetSealUp.setCreateDateTime(userSession.getUpdatedatetime());
		pro_assetSealUp.setUpdateUserName(userSession.getUser_name());
		if ("1".equals(pro_assetSealUp.getIsConSuit())) {
			Map<String, Object> param = new HashMap<>();
			param.put("projectLawsuit_ID", pro_assetSealUp.getLawSuitID());
			param.put("assetSealUp_ID", pro_assetSealUp.getAssetSealUp_ID());
			param.put("assetSealUpName", pro_assetSealUp.getRecordNum());
			projectLawsuitMapper.updateConAsset(param);
		}
		if(pro_assetSealUpMapper.insertOneSeaulUp(pro_assetSealUp)==1){
			logService.insertOneOperatorLogInfo(userSession,"新增资产查封情况", "新增", "新增资产查封情况"+pro_assetSealUp.getAssetSealUp_ID());
		return true;
		}
		return false;
	}

	@Override
	public PageTable selectProSeaulUpPageTables(PageTable pageTable) {
		// TODO Auto-generated method stub
		List<Pro_assetSealUp> list= pro_assetSealUpMapper.selectProSeaulUpPageTables(pageTable);
		for (Pro_assetSealUp pro_assetSealUp : list) {
			if(pro_assetSealUp.getIsRecord()==1){
				pro_assetSealUp.setIsRecordName("是");
			}
			else{
				pro_assetSealUp.setIsRecordName("否");
			}
		}
		Long total=pro_assetSealUpMapper.selectSealUpPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;		
	}

	@Override
	public Boolean deleteSeaulUpsBySealUpID(String assetSealUp_ID) {
		if(pro_assetSealUpMapper.deleteSeaulUpsBySealUpID(assetSealUp_ID)==1){
			return true;
		}
		return false;
	}
   
	@Override
	public Boolean updateOneSealUpInfo(User userSession,Pro_assetSealUp pro_assetSealUp) {
		pro_assetSealUp.setUnit_uid(userSession.getUnit_uid());
		pro_assetSealUp.setUpdateUserName(userSession.getUser_name());
		Map<String, Object> param = new HashMap<>();
		param.put("projectLawsuit_ID", pro_assetSealUp.getLawSuitID());
		param.put("assetSealUpName", pro_assetSealUp.getRecordNum());
		if ("0".equals(pro_assetSealUp.getIsConSuit())) {
			param.put("assetSealUp_ID", "");
		} else {
			param.put("assetSealUp_ID", pro_assetSealUp.getAssetSealUp_ID());
		}
		projectLawsuitMapper.updateConAsset(param);
		if(pro_assetSealUpMapper.updateOneSealUpInfo(pro_assetSealUp)==1){
			logService.insertOneOperatorLogInfo(userSession,"修改资产查封情况", "修改", "修改资产查封情况" +	pro_assetSealUp.getAssetSealUp_ID());
			return true;
		}
		return false;
	}

	@Override
	public Pro_assetSealUp selectOneSealUpInfo(String whereSql) {
		
		Pro_assetSealUp pro_assetSealUp=pro_assetSealUpMapper.selectOneSealUpInfo(whereSql);
		Pro_projectLawsuit projectLawsuit = projectLawsuitMapper.selectOneProjectLawsuitInfo(" and assetSealUp_ID = \'"+pro_assetSealUp.getAssetSealUp_ID()+"\'");
		if (projectLawsuit != null) {
			pro_assetSealUp.setLawSuitID(projectLawsuit.getProjectLawsuit_ID());
			pro_assetSealUp.setLawSuitName(projectLawsuit.getRecordNum());
		}
		/*if(pro_assetSealUp.getIsRecord()==1){
			pro_assetSealUp.setIsRecordName("是");
		}
		else{
			pro_assetSealUp.setIsRecordName("否");
		}*/
		return pro_assetSealUp;
	}
	
	

}
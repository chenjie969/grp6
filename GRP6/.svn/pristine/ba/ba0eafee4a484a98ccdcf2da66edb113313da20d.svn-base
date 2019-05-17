package com.zjm.crm.spouseInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_spouseInfoMapper;
import com.zjm.crm.db.model.Crm_spouseInfo;
import com.zjm.crm.spouseInfo.service.SpouseInfoService;
import com.zjm.util.Tool;

/**
 * 客户管理
 * @author zhangkeyao add 20170426
 *  
 */
@Service("spouseInfoService")
@Transactional
public class SpouseInfoServiceImpl implements SpouseInfoService {
	@Resource
	private Crm_spouseInfoMapper crm_spouseInfoMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 查询配偶信息列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_spouseInfo> selectSpouseInfoPageTables(Crm_spouseInfo spouseInfo) {
		List<Crm_spouseInfo> cList = crm_spouseInfoMapper.selectSpouseInfoPageTables(spouseInfo);
		PageTable<Crm_spouseInfo> pageTable = new PageTable<>();
		pageTable.setRows(cList);
		pageTable.setTotal((long) cList.size());
		return pageTable;
	}
	
	
	/**
	 * 新增配偶信息
	 * @param Crm_spouseInfo
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneSpouseInfo(User user,Crm_spouseInfo spouseInfo) {
		spouseInfo.setSpouseInfo_ID(Tool.createUUID32());
		spouseInfo.setUnit_uid(user.getUnit_uid());//机构ID
		spouseInfo.setUpdateUserName(user.getUser_name());
		if(crm_spouseInfoMapper.insertOneSpouseInfo(spouseInfo)){
			logService.insertOneOperatorLogInfo(user,"配偶信息", "新增", "新增配偶信息");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个配偶信息
	 * @param Crm_spouseInfo
	 * @return
	 */
	@Override
	public boolean deleteOneSpouseInfo(User user,Crm_spouseInfo spouseInfo) {
		if(crm_spouseInfoMapper.deleteOneSpouseInfo(spouseInfo)){
			logService.insertOneOperatorLogInfo(user,"配偶信息", "删除", "删除配偶信息");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询配偶信息
	 * @param Crm_spouseInfo
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_spouseInfo selectOneSpouseInfo(Crm_spouseInfo spouseInfo) {
		return crm_spouseInfoMapper.selectOneSpouseInfo(spouseInfo);
	}

	/**
	 * 
	 * @description 修改 更新配偶信息
	 * @author chenyang
	 * @date 2017年5月5日 下午7:14:03
	 */
	@Override
	public Boolean updateOneSpouseInfo(User user,Crm_spouseInfo spouseInfo) {
		spouseInfo.setUpdateUserName(user.getUser_name());
		if(crm_spouseInfoMapper.updateOneSpouseInfo(spouseInfo)){
			logService.insertOneOperatorLogInfo(user,"配偶信息", "修改", "修改配偶信息");
			return true;			
		}else{
			return false;
		}
	}

}

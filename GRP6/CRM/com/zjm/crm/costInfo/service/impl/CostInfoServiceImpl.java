package com.zjm.crm.costInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_costInfoMapper;
import com.zjm.crm.db.model.Crm_costInfo;
import com.zjm.crm.costInfo.service.CostInfoService;
import com.zjm.util.Tool;

@Service("costInfoService")
@Transactional
public class CostInfoServiceImpl implements CostInfoService {

	@Resource
	private Crm_costInfoMapper costInfoMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 分页查询水电气费缴纳列表
	 */
	@Override
	public PageTable<Crm_costInfo> selectCostInfoPageTable(PageTable<Crm_costInfo> pageTable) {
		List<Crm_costInfo> costInfoList = costInfoMapper.selectCostInfoPageTable(pageTable);
		pageTable.setRows(costInfoList);
		Long costInfoTotal = costInfoMapper.selectCostInfoPageTable_Count(pageTable);
		pageTable.setTotal(costInfoTotal);
		return pageTable;
	}
	
	/**
	 * 查询水电气费缴纳列表
	 */
	public List<Crm_costInfo> selectCostInfoList(String wheresql){
		try {
			return costInfoMapper.selectCostInfoList(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  查询一条水电气费缴纳信息
	 */
	@Override
	public Crm_costInfo selectOneCostInfo(Crm_costInfo costInfo) {
		return costInfoMapper.selectOneCostInfo(costInfo);
	}
	
	/**
	 *  插入一条水电气费缴纳信息
	 */
	@Override
	public Boolean insertOneCostInfo(User user,Crm_costInfo costInfo) {
		//处理缴费年月
		String yearMonth = costInfo.getYearMonth();
		costInfo.setIntYear(Integer.parseInt(yearMonth.substring(0,4)));
		costInfo.setIntMonth(Integer.parseInt(yearMonth.substring(5,7)));
		//月份缴费小计
		costInfo.setCostSum(costInfo.getElectricCost()+costInfo.getWaterCost()+costInfo.getOtherCost());
		
		costInfo.setCostInfo_ID(Tool.createUUID32());
		costInfo.setUnit_uid(user.getUnit_uid());
		costInfo.setUnit_uidName(user.getUnit_uidName());
		costInfo.setUpdateUserName(user.getUser_name());
		if(costInfoMapper.insertOneCostInfo(costInfo)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "添加", "添加水电气费缴纳-"+costInfo.getIntYear()+"年"+costInfo.getIntMonth()+"月");
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条水电气费缴纳信息
	 */
	@Override
	public Boolean updateOneCostInfo(User user,Crm_costInfo costInfo) {
		//处理缴费年月
		String yearMonth = costInfo.getYearMonth();
		costInfo.setIntYear(Integer.parseInt(yearMonth.substring(0,4)));
		costInfo.setIntMonth(Integer.parseInt(yearMonth.substring(5,7)));
		//月份缴费小计
		costInfo.setCostSum(costInfo.getElectricCost()+costInfo.getWaterCost()+costInfo.getOtherCost());
		
		costInfo.setUpdateUserName(user.getUser_name());
		if(costInfoMapper.updateOneCostInfo(costInfo)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "修改","修改水电气费缴纳-"+costInfo.getIntYear()+"年"+costInfo.getIntMonth()+"月");
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条水电气费缴纳信息
	 */
	@Override
	public Boolean deleteOneCostInfo(User user,Crm_costInfo costInfo) {
		costInfo = selectOneCostInfo(costInfo);
		if(costInfoMapper.deleteOneCostInfo(costInfo)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "删除", "删除水电气费缴纳-"+costInfo.getIntYear()+"年"+costInfo.getIntMonth()+"月");
			return true;
		}else
			return false;
	}

	@Override
	public Boolean deleteCostInfoByWhereSql(String whereSql) {
		try {
			int info = costInfoMapper.deleteCostInfoByWhereSql(whereSql);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

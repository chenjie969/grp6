package com.zjm.crm.costInfo.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_costInfo;

public interface CostInfoService {

	/**
	 * 分页查询水电气费缴纳列表
	 */
	public PageTable<Crm_costInfo> selectCostInfoPageTable(PageTable<Crm_costInfo> pageTable);
	
	/**
	 * 查询水电气费缴纳列表
	 */
	public List<Crm_costInfo> selectCostInfoList(String wheresql);
	
	/**
	 *  查询一条水电气费缴纳信息
	 */
	public Crm_costInfo selectOneCostInfo(Crm_costInfo costInfo);
	
	/**
	 *  插入一条水电气费缴纳信息
	 */
	public Boolean insertOneCostInfo(User user,Crm_costInfo costInfo);
	
	/**
	 *  修改一条水电气费缴纳信息
	 */
	public Boolean updateOneCostInfo(User user,Crm_costInfo costInfo);
	
	/**
	 *  删除一条水电气费缴纳信息
	 */
	public Boolean deleteOneCostInfo(User user,Crm_costInfo costInfo);
	
	/**
	 * @description  根据wheresql  删除
	 * @author wuhn
	 * @date 2017年10月11日 下午2:30:34
	 */
	Boolean  deleteCostInfoByWhereSql(String whereSql);
}

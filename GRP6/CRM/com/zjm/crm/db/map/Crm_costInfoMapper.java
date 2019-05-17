package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_costInfo;

public interface Crm_costInfoMapper {

	/**
	 * 分页查询水电气费缴纳情况列表
	 */
	public List<Crm_costInfo> selectCostInfoPageTable(PageTable<Crm_costInfo> pageTable);
	
	/**
	 * 分页查询水电气费缴纳情况列表-查询总记录数
	 */
	public Long selectCostInfoPageTable_Count(PageTable<Crm_costInfo> pageTable);
	
	/**
	 * 查询水电气费缴纳列表
	 */
	public List<Crm_costInfo> selectCostInfoList(String wheresql);
	
	/**
	 *  查询一条水电气费缴纳情况
	 */
	public Crm_costInfo selectOneCostInfo(Crm_costInfo costInfo);
	
	/**
	 *  插入一条水电气费缴纳情况
	 */
	public Integer insertOneCostInfo(Crm_costInfo costInfo);
	
	/**
	 *  修改一条水电气费缴纳情况
	 */
	public Integer updateOneCostInfo(Crm_costInfo costInfo);
	
	/**
	 *  删除一条水电气费缴纳情况
	 */
	public Integer deleteOneCostInfo(Crm_costInfo costInfo);
	
	/**
	 * @description  根据wheresql  删除
	 * @author wuhn
	 * @date 2017年10月11日 下午2:30:34
	 */
	int  deleteCostInfoByWhereSql(String whereSql);
	
	
}

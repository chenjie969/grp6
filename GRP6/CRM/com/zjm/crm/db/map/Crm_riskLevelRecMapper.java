package com.zjm.crm.db.map;

import java.util.List;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_riskLevelRec;

public interface Crm_riskLevelRecMapper {
	
	/**
	 * 新增一条风险评级记录
	 * @author Administrator
	 *
	 */
	public Integer insertOneRiskLevelRec(Crm_riskLevelRec riskLevelRec);
	/**
	 * 查询风险等级记录表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_riskLevelRec> selectRiskLevelPageTable(PageTable<Crm_riskLevelRec> pageTable);
	
	public List<Crm_riskLevelRec> selectRiskLevelList(String whereSql);
	/**
	 * 根据客户ID查出该客户的风险等级
	 */	
	public Crm_riskLevelRec selectOneRiskLevelInfo(String wheresql);	
	/**
	 * 根据客户ID更新该客户的风险等级
	 */	
	public Integer updateOneRiskLevelInfo(Crm_riskLevelRec riskLevelRec);	
	
	/**
	 * 
	 * @description 根据客户id删除
	 * @author wuhn
	 * @date 2017年10月12日 上午10:22:17
	 */
	int deleteRiskLevelByClient_ID(String client_ID);
	
	/**
	 * 根据主键删除风险等级
	 * @param riskLevelRec_ID
	 * @return
	 */
	public Integer deleteOneRiskLevelByID(String riskLevelRec_ID);
}

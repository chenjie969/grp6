package com.zjm.crm.riskLevel.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_riskLevelRec;
import com.zjm.oa.db.model.Hr_staffCase;

public interface RiskLevelService {
	/**
	 * 新增一条风险评级记录
	 * @author Administrator
	 *
	 */
	public Boolean insertOneRiskLevelRec(User user,Crm_riskLevelRec riskLevelRec);
	/**
	 * 查询风险等级记录表
	 * @param pageTable
	 * @return
	 */
	public PageTable<Crm_riskLevelRec> selectRiskLevelPageTable(PageTable<Crm_riskLevelRec> pageTable);
	/**
	 * 根据客户ID查出该客户的风险等级
	 */	
	public Crm_riskLevelRec selectOneRiskLevelInfo(String wheresql);	
	/**
	 * 根据客户ID更新该客户的风险等级
	 */	
	public Boolean updateOneRiskLevelInfo(Crm_riskLevelRec riskLevelRec);	
	
	/**
	 * 
	 * @description 根据客户id删除
	 * @author wuhn
	 * @date 2017年10月12日 上午10:22:17
	 */
	Boolean deleteRiskLevelByClient_ID(String client_ID);
	
	List<Crm_riskLevelRec> selectRiskLevelList(String wheresql);
	/**
	 * 根据主键ID删除风险等级记录
	 * @param riskLevelRec_ID
	 * @return
	 */
	public Boolean deleteOneRiskLevelByID(User user, String riskLevelRec_ID);
	
	
}

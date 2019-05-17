package com.zjm.pro.riskAppraise.service;

import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_riskAppraise;
public interface RiskAppraiseService {
  
	/**
	 * 增加一条风险管理委员会评议
	 * @param userSession
	 * @param riskAppraise
	 * @return
	 */
	public Boolean  insertOneRiskAppraise(User userSession,Pro_riskAppraise riskAppraise);		
	/**
	 * 更新一条风险管理委员会评议
	 * @param userSession
	 * @param riskAppraise
	 * @return
	 */
	public Boolean updateOneRiskAppraise(User userSession,Pro_riskAppraise riskAppraise);
	  /**
	   * 查看一条风险管理委员会评议
	   * @param whereSql
	   * @return
	   */
	public Pro_riskAppraise selectOneRiskAppraise(String whereSql);

}

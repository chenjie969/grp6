package com.zjm.pro.db.map;

import com.zjm.pro.db.model.Pro_riskAppraise;

public interface Pro_riskAppraiseMapper {

    /**
     * 更新一个风险管理委员会评议
     * @param riskAppraise
     * @return
     */
	public Integer updateOneRiskAppraise(Pro_riskAppraise riskAppraise);


	/**
	 * 查看一条风险管理委员会评议
	 * @param wheresql
	 * @return
	 */
	public Pro_riskAppraise selectOneRiskAppraise(String wheresql);
  
	/**
	 * 增加一条风险管理委员会评议
	 * @param riskAppraise
	 * @return
	 */
	public Integer insertOneRiskAppraise(Pro_riskAppraise riskAppraise);
	

}

package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_loanPlan;
/**
 * 计划放款表 映射mapper
 */
public interface Pro_loanPlanMapper {

	public Integer insertOnePlanLoan(Pro_loanPlan loanPlan);
	
	public Integer updateOnePlanLoan(Pro_loanPlan loanPlan);
	
	public Integer deleteOnePlanLoan(String wheresql);
	
	public List<Pro_loanPlan> selectPlanLoanListByWhereSql(String wheresql);
	
	public Pro_loanPlan selectOneLoanPlan(String wheresql);
	
	public Double totalLoanSumByWhereSql(String wheresql);
	
	public Integer updatePlanLoanState(Pro_loanPlan loanPlan);
	//修改已确认放款
	public Integer updateLoanConfirm(Pro_loanPlan loanPlan);
}

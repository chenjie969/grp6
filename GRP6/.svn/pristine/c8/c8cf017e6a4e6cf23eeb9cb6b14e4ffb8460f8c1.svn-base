package com.zjm.pro.loan.service;

import java.util.List;
import java.util.Map;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_planPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;

public interface LoanService {

	public Boolean insertOnePlanLoan(User user,Pro_loanPlan loanPlan);
	
	public Boolean updateOnePlanLoan(User user,Pro_loanPlan loanPlan);
	
	public Boolean deleteOnePlanLoan(User user,String wheresql);
	
	public PageTable<Pro_loanPlan> selectPlanLoanPageTable(PageTable<Pro_loanPlan> pageTable);
	
	public Pro_loanPlan selectOneLoanPlan(String wheresql);
	
	//判断计划放款总金额是否超过了评审会同意金额
	public Boolean isMoreThanAgreeSum(Pro_loanPlan loanPlan);
	
	//判断计划还款总金额是否超过了该笔计划放款的金额 
	public Boolean isMoreThanPlanLoanSum(Pro_planPay planPay);
	
	//自动新增还款计划时校验
	public Map<String, Object> autoAddValidata(User user, Pro_planPay planPay);
	
	//判断计划还款的月份不能超过计划放款期限
	public Boolean isMoreThanPlanLoanPeriodMonth(Pro_planPay planPay);
	
	public Boolean updatePlanLoanState(Pro_loanPlan loanPlan);
	//查询附件
	public List<Pro_projectfiles> getAttachments(String entityID );
	//删除附件
	public Boolean deleteAttachment(String projectFiles_ID);
	//查询放款复核数据
	public List<Pro_loanPlan> selectLoanReviewList(String wheresql);
	//放款计划确认
	public Boolean updateLoanConfirm(User user,Pro_loanPlan loanPlan);
	//放款计划撤销
	public Boolean loanConfirmCancel(User userSession, Pro_loanPlan loanPlan);
	//新增一条放款计划 WHDB
	public Boolean insertOneLoanPlan(User userSession, Pro_loanPlan loanPlan);
	/**
	 * 删除一条放款计划
	 */
	public Boolean delOneLoanPlan(User userSession, Pro_loanPlan loanPlan);

	/**
	 * @param user
	 * @param project
	 * @return 放款复核
	 */
	public Boolean updateLoanCheck(User user, Pro_project project);

	/**
	 * 根据类型和 entityID 查询附件
	 * @param entityID
	 * @param type
	 * @return
	 */
	public List<Pro_projectfiles> getAttachmentsByType(String entityID, String type);
	
}

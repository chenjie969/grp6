package com.zjm.pro.planPay.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_planPay;

public interface PlanPayService {

	public PageTable<Pro_planPay> selectPlanPayPageTable(PageTable<Pro_planPay> pageTable);
	
	public List<Pro_planPay> selectPlanPayListByWheresql(String wheresql);

	public Boolean insertOnePlanPay(User user, Pro_planPay planPay);
	
	public Boolean updateOnePlanPay(User user, Pro_planPay planPay);
	
	public Boolean deleteOnePlanPay(User user, Pro_planPay planPay);
	public Boolean deleteOnePlanPayWhdb(User user, Pro_planPay planPay);
	
	public Boolean deletePlanPayByWheresql(String wheresql);
	
	public Pro_planPay selectOnePlanPay(String wheresql);
	
	public Double totalPlanPaySumByWheresql(String wheresql);

	/**
	 * @param user
	 * @param planPay
	 * @return 添加还款计划
	 */
	public Boolean insertPlanPay(User user, Pro_planPay planPay);
	
//	public Boolean updatePlanPayState(Pro_planPay planPay);
}

package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_planPay;
/**
 * 计划放款表 映射mapper
 */
public interface Pro_planPayMapper {

	public List<Pro_planPay> selectPlanPayListByWhereSql(String wheresql);

	public Integer insertOnePlanPay(Pro_planPay planPay);
	
	public Integer updateOnePlanPay(Pro_planPay planPay);
	
	public Integer deleteOnePlanPay(String wheresql);
	
	public Integer deletePlanPayByWheresql(String wheresql);
	
	public Pro_planPay selectOnePlanPay(String wheresql);
	
	public Integer updatePlanPayState(Pro_planPay planPay);
	
	public Double totalPlanPaySumByWheresql(String wheresql);
	
}

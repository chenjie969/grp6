package com.zjm.pro.calculationFactPay.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_calculationFactPay;

public interface CalculationFactPayService {

	/**
	 *	新增一条利息计算
	 */
	public Boolean  insertOneCalculationFactPayInfo(User user,Pro_calculationFactPay calculationFactPay);	
	
	/**
	 * 更新一条利息计算
	 * @param checkPlan
	 * @return
	 */
	public Boolean updateCalculationFactPay(Pro_calculationFactPay calculationFactPay);
	
	/**
	 * 
	 * @param whereSql
	 * @return
	 */
	public Pro_calculationFactPay selectOneCalculationFactPayByWhereSql(String whereSql);

	public List<Pro_calculationFactPay> selectCalculationFactPayListByWhereSql(String string);
}

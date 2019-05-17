package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_calculationFactPay;

public interface Pro_calculationFactPayMapper {

	Boolean insertOneCalculationFactPayInfo(Pro_calculationFactPay calculationFactPay);

	Boolean updateCalculationFactPay(Pro_calculationFactPay calculationFactPay);

	Pro_calculationFactPay selectOneCalculationFactPayByWhereSql(String whereSql);

	List<Pro_calculationFactPay> selectCalculationFactPayListByWhereSql(String string);

}

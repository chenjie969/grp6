package com.zjm.pro.calculationFactPay.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.pro.calculationFactPay.service.CalculationFactPayService;
import com.zjm.pro.db.map.Pro_calculationFactPayMapper;
import com.zjm.pro.db.model.Pro_calculationFactPay;

@Service("calculationFactPayService")
@Transactional
public class CalculationFactPayServiceImpl  implements CalculationFactPayService{

	@Resource
	private Pro_calculationFactPayMapper pro_calculationFactPayMapper;

	@Override
	public Boolean insertOneCalculationFactPayInfo(User user, Pro_calculationFactPay calculationFactPay) {
		return pro_calculationFactPayMapper.insertOneCalculationFactPayInfo(calculationFactPay);
	}

	@Override
	public Boolean updateCalculationFactPay(Pro_calculationFactPay calculationFactPay) {
		return pro_calculationFactPayMapper.updateCalculationFactPay(calculationFactPay);
	}

	@Override
	public Pro_calculationFactPay selectOneCalculationFactPayByWhereSql(String whereSql) {
		return pro_calculationFactPayMapper.selectOneCalculationFactPayByWhereSql(whereSql);
	}

	@Override
	public List<Pro_calculationFactPay> selectCalculationFactPayListByWhereSql(String string) {
		return pro_calculationFactPayMapper.selectCalculationFactPayListByWhereSql(string);
	}
}

package com.zjm.crm.financeDesc.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_financeDesc;

public interface FinanceDescService {

	/**
	 *  查询一条财务状况说明
	 */
	public Crm_financeDesc selectOneFinanceDesc(Crm_financeDesc financeDesc);
	
	/**
	 *  插入一条财务状况说明
	 */
	public Boolean insertOneFinanceDesc(User user,Crm_financeDesc financeDesc);
	
	/**
	 *  修改一条财务状况说明
	 */
	public Boolean updateOneFinanceDesc(User user,Crm_financeDesc financeDesc);
	
	
	/**
	 *  修改一条财务状况说明
	 */
	public Integer updateOneFinanceDesc(Crm_financeDesc financeDesc);
	
	/**
	 * @description  根据 wheresql  取list
	 * @author wuhn
	 * @date 2017年10月11日 下午1:49:13
	 */
	List<Crm_financeDesc>  selectFinanceDescListByWhereSql(String wheresql);
	
	/**
	 * @description  根据wheresql 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午1:49:26
	 */
	Boolean deleteFinanceDescByWhereSql(String wheresql);
	
	
}

package com.zjm.crm.payTaxInfo.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_payTaxInfo;

public interface PayTaxInfoService {

	/**
	 * 分页查询企业纳税情况列表
	 */
	public PageTable<Crm_payTaxInfo> selectPayTaxInfoPageTable(PageTable<Crm_payTaxInfo> pageTable);
	
	/**
	 * 查询企业纳税情况列表
	 */
	public List<Crm_payTaxInfo> selectPayTaxInfoList(String wheresql);
	
	/**
	 *  查询一条企业纳税情况
	 */
	public Crm_payTaxInfo selectOnePayTaxInfo(Crm_payTaxInfo payTaxInfo);
	
	/**
	 *  插入一条企业纳税情况
	 */
	public Boolean insertOnePayTaxInfo(User user,Crm_payTaxInfo payTaxInfo);
	
	/**
	 *  修改一条企业纳税情况
	 */
	public Boolean updateOnePayTaxInfo(User user,Crm_payTaxInfo payTaxInfo);
	
	/**
	 *  删除一条企业纳税情况
	 */
	public Boolean deleteOnePayTaxInfo(User user,Crm_payTaxInfo payTaxInfo);
	
	/**
	 * @description  根据客户id删除
	 * @author wuhn
	 * @date 2017年10月11日 下午4:30:16
	 */
	Boolean  deletePayTaxByClient_ID (String client_ID);
	
	
}

package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_payTaxInfo;

public interface Crm_payTaxInfoMapper {

	/**
	 * 分页查询企业纳税情况列表
	 */
	public List<Crm_payTaxInfo> selectPayTaxInfoPageTable(PageTable<Crm_payTaxInfo> pageTable);
	
	/**
	 * 分页查询企业纳税情况列表-查询总记录数
	 */
	public Long selectPayTaxInfoPageTable_Count(PageTable<Crm_payTaxInfo> pageTable);
	
	/**
	 * 分页查询企业纳税情况列表
	 */
	public List<Crm_payTaxInfo> selectPayTaxInfoList(String wheresql);
	
	/**
	 *  查询一条企业纳税情况
	 */
	public Crm_payTaxInfo selectOnePayTaxInfo(Crm_payTaxInfo payTaxInfo);
	
	/**
	 *  插入一条企业纳税情况
	 */
	public Integer insertOnePayTaxInfo(Crm_payTaxInfo payTaxInfo);
	
	/**
	 *  修改一条企业纳税情况
	 */
	public Integer updateOnePayTaxInfo(Crm_payTaxInfo payTaxInfo);
	
	/**
	 *  删除一条企业纳税情况
	 */
	public Integer deleteOnePayTaxInfo(Crm_payTaxInfo payTaxInfo);
	
	/**
	 * @description  根据客户id删除
	 * @author wuhn
	 * @date 2017年10月11日 下午4:30:16
	 */
	int  deletePayTaxByClient_ID (String client_ID);
	
	
}

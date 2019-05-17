package com.zjm.crm.billRec.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_billRec;

public interface BillRecService {

	/**
	 * 查询开票银行
	 */
	public PageTable<Crm_billRec> selectBillRecPageTable(PageTable<Crm_billRec> pageTable);
	
	/**
	 * 查询开票银行
	 */
	public List<Crm_billRec> selectBillRecList(String wheresql);
	
	/**
	 *  查询一条开票银行
	 */
	public Crm_billRec selectOneBillRec(Crm_billRec billRec);
	
	/**
	 *  插入一条开票银行
	 */
	public Boolean insertOneBillRec(User user,Crm_billRec billRec);
	
	/**
	 *  修改一条开票银行
	 */
	public Boolean updateOneBillRec(User user,Crm_billRec billRec);
	
	/**
	 *  删除一条开票银行
	 */
	public Boolean deleteOneBillRec(User user,Crm_billRec billRec);
	
	
	/**
	 * @description  根据 client_ID 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:49:17
	 */
	Boolean deleteBillRecByClient_ID(String client_ID);
	
	
}

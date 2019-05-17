package com.zjm.crm.loanRec.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_loanRec;

public interface LoanRecService {

	/**
	 * 查询贷款银行
	 */
	public PageTable<Crm_loanRec> selectLoanRecPageTable(PageTable<Crm_loanRec> pageTable);
	
	/**
	 * 查询贷款银行
	 */
	public List<Crm_loanRec> selectLoanRecList(String wheresql);
	
	/**
	 *  查询一条贷款银行
	 */
	public Crm_loanRec selectOneLoanRec(Crm_loanRec loanRec);
	
	/**
	 *  插入一条贷款银行
	 */
	public Boolean insertOneLoanRec(User user,Crm_loanRec loanRec);
	
	/**
	 *  修改一条贷款银行
	 */
	public Boolean updateOneLoanRec(User user,Crm_loanRec loanRec);
	
	/**
	 *  删除一条贷款银行
	 */
	public Boolean deleteOneLoanRec(User user,Crm_loanRec loanRec);
	
	
	/**
	 * @description  根据客户id 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:41:34
	 */
	Boolean deleteLoanRecByClient_ID (String client_ID);
	
	
}

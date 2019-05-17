package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_loanRec;

public interface Crm_loanRecMapper {

	/**
	 * 分页查询贷款银行列表
	 */
	public List<Crm_loanRec> selectLoanRecPageTable(PageTable<Crm_loanRec> pageTable);
	
	/**
	 * 分页查询贷款银行列表-查询总记录数
	 */
	public Long selectLoanRecPageTable_Count(PageTable<Crm_loanRec> pageTable);
	
	/**
	 * 查询贷款银行列表 不分页
	 */
	public List<Crm_loanRec> selectLoanRecList(PageTable<Crm_loanRec> pageTable);
	
	/**
	 * 查询贷款银行列表
	 */
	public List<Crm_loanRec> selectLoanRecListByWheresql(String wheresql);
	
	/**
	 *  查询一条贷款银行
	 */
	public Crm_loanRec selectOneLoanRec(Crm_loanRec loanRec);
	
	/**
	 *  插入一条贷款银行
	 */
	public Integer insertOneLoanRec(Crm_loanRec loanRec);
	
	/**
	 *  修改一条贷款银行
	 */
	public Integer updateOneLoanRec(Crm_loanRec loanRec);
	
	/**
	 *  删除一条贷款银行
	 */
	public Integer deleteOneLoanRec(Crm_loanRec loanRec);
	
	/**
	 * @description  根据客户id 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:41:34
	 */
	int deleteLoanRecByClient_ID (String client_ID);
	
}

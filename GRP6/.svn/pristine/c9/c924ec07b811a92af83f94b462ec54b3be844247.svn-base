package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_billRec;

public interface Crm_billRecMapper {

	/**
	 * 分页查询开票银行列表
	 */
	public List<Crm_billRec> selectBillRecPageTable(PageTable<Crm_billRec> pageTable);
	
	/**
	 * 分页查询开票银行列表-查询总记录数
	 */
	public Long selectBillRecPageTable_Count(PageTable<Crm_billRec> pageTable);
	
	/**
	 * 查询开票银行列表 不分页
	 */
	public List<Crm_billRec> selectBillRecList(PageTable<Crm_billRec> pageTable);
	
	/**
	 * 查询开票银行列表 不分页
	 */
	public List<Crm_billRec> selectBillRecListByWheresql(String wheresql);
	
	/**
	 *  查询一条开票银行
	 */
	public Crm_billRec selectOneBillRec(Crm_billRec billRec);
	
	/**
	 *  插入一条开票银行
	 */
	public Integer insertOneBillRec(Crm_billRec billRec);
	
	/**
	 *  修改一条开票银行
	 */
	public Integer updateOneBillRec(Crm_billRec billRec);
	
	/**
	 *  删除一条开票银行
	 */
	public Integer deleteOneBillRec(Crm_billRec billRec);
	
	
	/**
	 * @description  根据 client_ID 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:49:17
	 */
	int deleteBillRecByClient_ID(String client_ID);
	
}

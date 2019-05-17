package com.zjm.crm.guarantyRec.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_guarantyRec;

public interface GuarantyRecService {

	/**
	 * 查询对外担保
	 */
	public PageTable<Crm_guarantyRec> selectGuarantyRecPageTable(PageTable<Crm_guarantyRec> pageTable);
	
	/**
	 * 查询对外担保
	 */
	public List<Crm_guarantyRec> selectGuarantyRecList(String wheresql);
	
	/**
	 *  查询一条对外担保
	 */
	public Crm_guarantyRec selectOneGuarantyRec(Crm_guarantyRec guarantyRec);
	
	/**
	 *  插入一条对外担保
	 */
	public Boolean insertOneGuarantyRec(User user,Crm_guarantyRec guarantyRec);
	
	/**
	 *  修改一条对外担保
	 */
	public Boolean updateOneGuarantyRec(User user,Crm_guarantyRec guarantyRec);
	
	/**
	 *  删除一条对外担保
	 */
	public Boolean deleteOneGuarantyRec(User user,Crm_guarantyRec guarantyRec);
	
	/**
	 * @description 根据 client_ID  删除
	 * @author wuhn
	 * @date 2017年10月11日 下午5:11:49
	 */
	Boolean  deleteGuarantyRecByClient_ID(String client_ID);
	
}

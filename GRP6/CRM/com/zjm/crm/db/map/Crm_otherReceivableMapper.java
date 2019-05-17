package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_otherReceivable;

public interface Crm_otherReceivableMapper {

	
	/**
	 * 查询应收账款    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_otherReceivable> selectOtherReceivablePageTables(Crm_otherReceivable otherReceivable);
	
	/**
	 * 新增应收账款
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneOtherReceivableInfo(Crm_otherReceivable otherReceivable);

	/**
	 *	删除一个应收账款
	 * @return
	 */
	public boolean deleteOneOtherReceivableInfo(String otherReceivable_id);

	/**
	 *查询一个应收账款
	 * @author chenyang
	 * @return
	 */
	public Crm_otherReceivable selectOneOtherReceivableInfo(Crm_otherReceivable otherReceivable);

	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	public Boolean updateOneOtherReceivableInfo(Crm_otherReceivable otherReceivable);

	
	/**
	 * @description  根据客户id 删除
	 * @author wuhn
	 * @date 2017年10月11日 上午11:27:42
	 */
	int deleteOtherReceivableByClient_ID(String client_ID);
	
	
}

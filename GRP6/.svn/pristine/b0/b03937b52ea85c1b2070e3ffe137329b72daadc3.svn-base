package com.zjm.crm.otherReceivable.service;

import com.zjm.crm.db.model.Crm_otherReceivable;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

/**
 * 应收账款
 * @author chenyang
 */
public interface OtherReceivableService {
	
	/**
	 * 查询应收账户分页列表
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_otherReceivable> selectOtherReceivablePageTables(Crm_otherReceivable otherReceivable);
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_otherReceivable> selectOtherReceivableList(Crm_otherReceivable otherReceivable);
	
	/**
	 *	删除一个应收账款
	 * @return
	 */
	public boolean deleteOneOtherReceivableInfo(User user,String otherReceivable_id);

	/**
	 *	新增一个应收账款
	 * @return
	 */
	public Boolean insertOneOtherReceivableInfo(User user,Crm_otherReceivable otherReceivable);

	/**
	 * 查询一个应收账款
	 * @return
	 */
	public Crm_otherReceivable selectOneOtherReceivableInfo(Crm_otherReceivable otherReceivable);

	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	public Boolean updateOneOtherReceivableInfo(User user,Crm_otherReceivable otherReceivable);
	
	/**
	 * @description  根据客户id 删除
	 * @author wuhn
	 * @date 2017年10月11日 上午11:27:42
	 */
	Boolean deleteOtherReceivableByClient_ID(String client_ID);
	
}

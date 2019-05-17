package com.zjm.crm.receivable.service;

import com.zjm.crm.db.model.Crm_receivable;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

/**
 * 应收账款
 * @author chenyang
 */
public interface ReceivableService {
	
	/**
	 * 查询应收账户分页列表
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_receivable> selectReceivablePageTables(Crm_receivable receivable);
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_receivable> selectReceivableList(Crm_receivable receivable);
	
	/**
	 *	删除一个应收账款
	 * @return
	 */
	public boolean deleteOneReceivableInfo(User user,String receivable_id);

	/**
	 *	新增一个应收账款
	 * @return
	 */
	public Boolean insertOneReceivableInfo(User user,Crm_receivable receivable);

	/**
	 * 查询一个应收账款
	 * @return
	 */
	public Crm_receivable selectOneReceivableInfo(Crm_receivable receivable);

	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	public Boolean updateOneReceivableInfo(User user,Crm_receivable receivable);
	
	
	/**
	 * @description 根据wheresql 获取list
	 * @author wuhn
	 * @date 2017年10月11日 下午1:35:24
	 */
	List<Crm_receivable>  selectReceivableListByWhereSql(String whereSql);
	
	/**
	 * @description   根据wheresql 删除list
	 * @author wuhn
	 * @date 2017年10月11日 下午1:35:38
	 */
	Boolean deleteReceivableListByWhereSql(String whereSql);
	
	
}

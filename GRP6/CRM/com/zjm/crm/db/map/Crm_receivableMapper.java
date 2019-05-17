package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_receivable;

public interface Crm_receivableMapper {

	
	/**
	 * 查询应收账款    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_receivable> selectReceivablePageTables(Crm_receivable receivable);
	
	/**
	 * 新增应收账款
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneReceivableInfo(Crm_receivable receivable);

	/**
	 *	删除一个应收账款
	 * @return
	 */
	public boolean deleteOneReceivableInfo(String receivable_id);

	/**
	 *查询一个应收账款
	 * @author chenyang
	 * @return
	 */
	public Crm_receivable selectOneReceivableInfo(Crm_receivable receivable);

	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	public Boolean updateOneReceivableInfo(Crm_receivable receivable);

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
	int deleteReceivableListByWhereSql(String whereSql);
	
	
}

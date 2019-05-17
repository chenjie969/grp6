package com.zjm.crm.spouseInfo.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_spouseInfo;

/**
 * 客户管理
 * @author chenyang add 20170426
 */
public interface SpouseInfoService {
	
	/**
	 * 查询配偶信息分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_spouseInfo> selectSpouseInfoPageTables(Crm_spouseInfo spouseInfo);

	/**
	 *	删除一个配偶信息
	 * @param clientRelation
	 * @return
	 */
	public boolean deleteOneSpouseInfo(User user,Crm_spouseInfo spouseInfo);

	/**
	 *	新增一个配偶信息
	 * @param clientRelation
	 * @return
	 */
	public Boolean insertOneSpouseInfo(User user,Crm_spouseInfo spouseInfo);

	/**
	 * 查询一个配偶信息
	 * @param clientRelation
	 * @return
	 */
	public Crm_spouseInfo selectOneSpouseInfo(Crm_spouseInfo spouseInfo);

	/**
	 * 
	 * @description 修改 更新配偶信息信息  
	 * @author chenyang
	 * @date 2017年5月5日 下午7:14:03
	 */
	public Boolean updateOneSpouseInfo(User user,Crm_spouseInfo spouseInfo);
	
	
}

package com.zjm.crm.selfHouse.service;

import com.zjm.crm.db.model.Crm_selfHouse;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

/**
 * 客户管理
 * @author chenyang add 20170426
 */
public interface SelfHouseService {
	
	/**
	 * 查询自有住房列表
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_selfHouse> selectSelfHouseInfoPageTables(Crm_selfHouse selfHouse);

	/**
	 *	删除一个自有住房
	 * @return
	 */
	public boolean deleteOneSelfHouseInfo(User user,Crm_selfHouse selfHouse);

	/**
	 *	新增一个自有住房
	 * @return
	 */
	public Boolean insertOneSelfHouseInfo(User user,Crm_selfHouse selfHouse);

	/**
	 * 查询一个自有住房
	 * @return
	 */
	public Crm_selfHouse selectOneSelfHouseInfo(Crm_selfHouse selfHouse);

	/**
	 * 
	 * @description 修改 更新自有住房信息  
	 * @author chenyang
	 * @date 2017年5月5日 3
	 */
	public Boolean updateOneSelfHouseInfo(User user,Crm_selfHouse selfHouse);
	
	
	/**
	 * @description  根据　client_ID获取
	 * @author wuhn
	 * @date 2017年10月11日 下午4:52:55
	 */
	List<Crm_selfHouse>  selectSelfHouseListByClient_ID(String  client_ID);
	
	/**
	 * @description 根据　client_ID 　删除
	 * @author wuhn
	 * @date 2017年10月11日 下午4:53:09
	 */
	Boolean  deleteSelfHouseByClient_ID(String client_ID);
	
}

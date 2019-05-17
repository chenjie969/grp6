package com.zjm.crm.inventory.service;

import com.zjm.crm.db.model.Crm_inventory;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

/**
 * 存货
 * @author chenyang
 */
public interface InventoryService {
	
	/**
	 * 查询应收账户分页列表
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_inventory> selectInventoryPageTables(Crm_inventory inventory);
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_inventory> selectInventoryList(Crm_inventory inventory);
	
	/**
	 *	删除一个存货
	 * @return
	 */
	public boolean deleteOneInventoryInfo(User user,String inventory_id);

	/**
	 *	新增一个存货
	 * @return
	 */
	public Boolean insertOneInventoryInfo(User user,Crm_inventory inventory);

	/**
	 * 查询一个存货
	 * @return
	 */
	public Crm_inventory selectOneInventoryInfo(Crm_inventory inventory);

	/**
	 * 
	 * @description 修改 更新存货信息  
	 * @author chenyang
	 */
	public Boolean updateOneInventoryInfo(User user,Crm_inventory inventory);
	
	/**
	 * @description  根据wheresql 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:07:37
	 */
	Boolean deleteInventoryByWheresql(String wheresql);
	
}

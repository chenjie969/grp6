package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Crm_inventory;

public interface Crm_inventoryMapper {

	
	/**
	 * 查询应收账款    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_inventory> selectInventoryPageTables(Crm_inventory inventory);
	
	/**
	 * 新增应收账款
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneInventoryInfo(Crm_inventory inventory);

	/**
	 *	删除一个应收账款
	 * @return
	 */
	public boolean deleteOneInventoryInfo(String inventory_id);

	/**
	 *查询一个应收账款
	 * @author chenyang
	 * @return
	 */
	public Crm_inventory selectOneInventoryInfo(Crm_inventory inventory);

	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	public Boolean updateOneInventoryInfo(Crm_inventory inventory);

	
	/**
	 * @description  根据wheresql 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午3:07:37
	 */
	int deleteInventoryByWheresql(String wheresql);
	
}

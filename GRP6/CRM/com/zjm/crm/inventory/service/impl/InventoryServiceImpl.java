package com.zjm.crm.inventory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_inventoryMapper;
import com.zjm.crm.db.model.Crm_inventory;
import com.zjm.crm.inventory.service.InventoryService;
import com.zjm.util.Tool;

/**
 * 存货
 * @author chenYang
 *  
 */
@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {
	@Resource
	private Crm_inventoryMapper crm_inventoryMapper;
	@Resource
	private LogService logService;
	@Resource
	private ClientService clientService;
	
	/**
	 * 查询存货分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_inventory> selectInventoryPageTables(Crm_inventory inventory) {
		List<Crm_inventory> list = crm_inventoryMapper.selectInventoryPageTables(inventory);
		PageTable<Crm_inventory> pageTable = new PageTable<>();
		pageTable.setRows(list);
		pageTable.setTotal((long) list.size());
		return pageTable;
	}
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_inventory> selectInventoryList(Crm_inventory inventory){
		return crm_inventoryMapper.selectInventoryPageTables(inventory);
	}
	
	/**
	 * 新增存货
	 * @param Crm_inventory
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneInventoryInfo(User user,Crm_inventory inventory) {
		inventory.setUpdateUserName(user.getUser_name());
		inventory.setUnit_uid(user.getUnit_uid());
		inventory.setUnit_uidName(user.getUnit_uidName());
		inventory.setInventory_ID(Tool.createUUID32());
		if(crm_inventoryMapper.insertOneInventoryInfo(inventory)){
			logService.insertOneOperatorLogInfo(user,"存货", "新增", "新增存货");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个存货
	 * @param Crm_inventory
	 * @return
	 */
	@Override
	public boolean deleteOneInventoryInfo(User user,String inventory_id) {
		if(crm_inventoryMapper.deleteOneInventoryInfo(inventory_id)){
			logService.insertOneOperatorLogInfo(user,"存货", "删除", "删除存货");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询存货
	 * @param Crm_inventory
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_inventory selectOneInventoryInfo(Crm_inventory inventory) {
		return crm_inventoryMapper.selectOneInventoryInfo(inventory);
	}

	/**
	 * 
	 * @description 修改 更新存货信息  
	 * @author chenyang
	 */
	@Override
	public Boolean updateOneInventoryInfo(User user,Crm_inventory inventory) {
		inventory.setUpdateUserName(user.getUser_name());
		if(crm_inventoryMapper.updateOneInventoryInfo(inventory)){
			logService.insertOneOperatorLogInfo(user,"存货", "修改", "修改存货");
			return true;			
		}else{
			return false;
		}
	}

	@Override
	public Boolean deleteInventoryByWheresql(String wheresql) {
		try {
			int info = crm_inventoryMapper.deleteInventoryByWheresql(wheresql);
			if(info > 0 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

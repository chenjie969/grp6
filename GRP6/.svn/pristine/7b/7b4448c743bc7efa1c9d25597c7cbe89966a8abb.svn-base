package com.zjm.crm.inventory.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Crm_inventory;
import com.zjm.crm.inventory.service.InventoryService;
import com.zjm.util.SystemSession;

/**
 * 存货
 * @author chenyang
 */
@Controller
public class InventoryAction {
	@Resource
	private InventoryService inventoryService;
	
	@Resource
	private ClientService clientService;
	/**
	 * 根据Client_ID查询存货列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectInventoryPageTables")
	@ResponseBody
	public AjaxRes selectInventoryPageTables(@RequestBody Crm_inventory inventory) {
		try {
			PageTable<Crm_inventory> pageTable = new PageTable<>();
			pageTable=inventoryService.selectInventoryPageTables(inventory);
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(pageTable);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @description 新增一个存货信息
	 * @author chenyang
	 */
	@RequestMapping(value="/insertOneInventoryInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneInventoryInfo(@RequestBody Crm_inventory inventory) {
		try {
			User user = SystemSession.getUserSession();
			Boolean bool = inventoryService.insertOneInventoryInfo(user, inventory);
			AjaxRes ar = new AjaxRes();
			ar.setSucceed(bool);
			return ar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * 
	 * @description 删除一个存货信息
	 * @author chenyang
	 */
	@RequestMapping(value="/deleteOneInventoryInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneInventoryInfo(@RequestBody String inventory_ID) {
		User user = SystemSession.getUserSession();
		Boolean bool = inventoryService.deleteOneInventoryInfo(user,inventory_ID);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个存货的信息
	 * @author chenyang
	 */
	@RequestMapping(value="/selectOneInventoryInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneInventoryInfo(@RequestBody Crm_inventory  inventory ) {
		try {
			inventory = inventoryService.selectOneInventoryInfo(inventory );
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(inventory );
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @description 修改 更新存货信息  
	 * @author chenyang
	 */
	@RequestMapping(value="/updateOneInventoryInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneInventoryInfo(@RequestBody Crm_inventory inventory) { 
		try {
			User user = SystemSession.getUserSession();
			Boolean bool =  inventoryService.updateOneInventoryInfo(user,inventory);
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(bool);
			return ar;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}

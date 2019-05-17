package com.zjm.crm.receivable.web;

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
import com.zjm.crm.db.model.Crm_receivable;
import com.zjm.crm.receivable.service.ReceivableService;
import com.zjm.util.SystemSession;

/**
 * 应收账款
 * @author chenyang
 */
@Controller
public class ReceivableAction {
	@Resource
	private ReceivableService receivableService;
	
	@Resource
	private ClientService clientService;
	/**
	 * 根据Client_ID查询应收账款列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectReceivablePageTables")
	@ResponseBody
	public AjaxRes selectReceivablePageTables(@RequestBody Crm_receivable receivable) {
		try {
			PageTable<Crm_receivable> pageTable = new PageTable<>();
			pageTable=receivableService.selectReceivablePageTables(receivable);
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
	 * @description 新增一个应收账款信息
	 * @author chenyang
	 */
	@RequestMapping(value="/insertOneReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneReceivableInfo(@RequestBody Crm_receivable receivable) {
		try {
			User user = SystemSession.getUserSession();
			Boolean bool = receivableService.insertOneReceivableInfo(user, receivable);
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
	 * @description 删除一个应收账款信息
	 * @author chenyang
	 */
	@RequestMapping(value="/deleteOneReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneReceivableInfo(@RequestBody String receivable_ID) {
		User user = SystemSession.getUserSession();
		Boolean bool = receivableService.deleteOneReceivableInfo(user,receivable_ID);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个应收账款的信息
	 * @author chenyang
	 */
	@RequestMapping(value="/selectOneReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneReceivableInfo(@RequestBody Crm_receivable  receivable ) {
		try {
			receivable = receivableService.selectOneReceivableInfo(receivable );
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(receivable );
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	@RequestMapping(value="/updateOneReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneReceivableInfo(@RequestBody Crm_receivable receivable) { 
		try {
			User user = SystemSession.getUserSession();
			Boolean bool =  receivableService.updateOneReceivableInfo(user,receivable);
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

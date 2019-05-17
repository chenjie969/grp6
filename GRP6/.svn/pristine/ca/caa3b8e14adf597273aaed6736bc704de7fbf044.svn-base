package com.zjm.crm.otherReceivable.web;

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
import com.zjm.crm.db.model.Crm_otherReceivable;
import com.zjm.crm.otherReceivable.service.OtherReceivableService;
import com.zjm.util.SystemSession;

/**
 * 应收账款
 * @author chenyang
 */
@Controller
public class OtherReceivableAction {
	@Resource
	private OtherReceivableService otherReceivableService;
	
	@Resource
	private ClientService clientService;
	/**
	 * 根据Client_ID查询应收账款列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectOtherReceivablePageTables")
	@ResponseBody
	public AjaxRes selectOtherReceivablePageTables(@RequestBody Crm_otherReceivable otherReceivable) {
		try {
			PageTable<Crm_otherReceivable> pageTable = new PageTable<>();
			pageTable=otherReceivableService.selectOtherReceivablePageTables(otherReceivable);
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
	@RequestMapping(value="/insertOneOtherReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneOtherReceivableInfo(@RequestBody Crm_otherReceivable otherReceivable) {
		try {
			User user = SystemSession.getUserSession();
			Boolean bool = otherReceivableService.insertOneOtherReceivableInfo(user, otherReceivable);
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
	@RequestMapping(value="/deleteOneOtherReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneOtherReceivableInfo(@RequestBody String otherReceivable_ID) {
		User user = SystemSession.getUserSession();
		Boolean bool = otherReceivableService.deleteOneOtherReceivableInfo(user,otherReceivable_ID);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个应收账款的信息
	 * @author chenyang
	 */
	@RequestMapping(value="/selectOneOtherReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneOtherReceivableInfo(@RequestBody Crm_otherReceivable  otherReceivable ) {
		try {
			otherReceivable = otherReceivableService.selectOneOtherReceivableInfo(otherReceivable );
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(otherReceivable );
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
	@RequestMapping(value="/updateOneOtherReceivableInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneOtherReceivableInfo(@RequestBody Crm_otherReceivable otherReceivable) { 
		try {
			User user = SystemSession.getUserSession();
			Boolean bool =  otherReceivableService.updateOneOtherReceivableInfo(user,otherReceivable);
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

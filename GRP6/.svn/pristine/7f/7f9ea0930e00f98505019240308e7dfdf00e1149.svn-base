package com.zjm.crm.clientShare.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.crm.clientShare.service.ClientShareService;
import com.zjm.crm.db.model.Crm_clientShare;
import com.zjm.crm.db.model.Crm_relationClient;
import com.zjm.sys.db.model.Sys_clientCode;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;

/**
 * 授权共享
 * @author chenyang add 20170517
 */
@Controller
@RequestMapping(value="/crm/clientShare")
public class ClientShareAction {
	@Resource
	private ClientShareService clientShareService;

	/**
	 * 授权共享页面
	 * @return
	 */
	@RequestMapping(value="/selectClientSharePage")
	public ModelAndView selectClientSharePage(Crm_clientShare clientShare){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/clientShare/shareClientAdd");
		clientShare=clientShareService.selectOneClientShareInfo(clientShare);
		mv.getModel().put("clientShare",clientShare);
		return mv;
	}
	
	
	/**
	 * 
	 * @description 新增一个共享客户信息
	 * @author chenyang
	 */
	@RequestMapping(value="/insertOneClientShareInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneClientShareInfo(@RequestBody Crm_clientShare crm_clientShare) {
		Boolean bool;
		if (crm_clientShare.getClientShare_ID() != null && crm_clientShare.getClientShare_ID() != "") {
			bool = clientShareService.updateOneClientShareInfo(crm_clientShare);
		}else{
			bool = clientShareService.insertOneClientShareInfo(crm_clientShare);
		}
		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 修改一个共享客户信息
	 * @author chenyang
	 */
	@RequestMapping(value="/updateOneClientShareInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneClientShareInfo(@RequestBody Crm_clientShare crm_clientShare) {
		Boolean bool = clientShareService.updateOneClientShareInfo(crm_clientShare);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
}

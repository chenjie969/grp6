package com.zjm.sys.clientCode.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;
import com.zjm.sys.clientCode.service.ClientCodeService;
import com.zjm.sys.db.model.Sys_clientCode;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
 * 客户编号
 * @author chenyang   add 20170524
 */
@Controller
@RequestMapping(value="/sys/clientCode")
public class ClientCodeAction {
	@Resource
	private ClientCodeService clientCodeService;
    	
	/**
	 * 客户规则页面
	 * @return
	 */
	@RequestMapping(value="/selectClientRuleEditPage")
	public ModelAndView selectClientRuleEditPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/parameter/clientCodeEdit");
		Sys_clientCode clientCode = new Sys_clientCode();
		clientCode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		clientCode=clientCodeService.selectOneClientCodeInfo(clientCode);
		mv.getModel().put("clientCode",clientCode);
		return mv;
	}
	
	/**
	 * 查询一个客户编号信息
	 * @param sys_clientCode
	 * @return
	 */
	@RequestMapping(value="/selectOneClientCodeInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneClientCodeInfo(@RequestBody Sys_clientCode clientCode){
		AjaxRes ar=new AjaxRes();
		clientCode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		clientCode=clientCodeService.selectOneClientCodeInfo(clientCode);
		ar.setSucceed(clientCode);
		return ar;
	}
	
	/**
	 * 更新客户编号信息
	 * @param sys_clientCode
	 * @return
	 */
	@RequestMapping(value="/updateOneClientCodeInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneClientCodeInfo(@RequestBody Sys_clientCode clientCode){
		AjaxRes ar=new AjaxRes();
		User user = SystemSession.getUserSession();
		Boolean b=clientCodeService.updateOneClientCodeInfo(user,clientCode);
		ar.setSucceed(b);
		return ar;
	}

}

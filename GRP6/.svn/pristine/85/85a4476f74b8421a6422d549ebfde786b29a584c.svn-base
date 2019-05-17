package com.zjm.crm.upDownClient.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_upDownClient;
import com.zjm.crm.upDownClient.service.UpDownClientService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/upDownClient")
public class UpDownClientAction {

	@Resource
	private UpDownClientService upDownClientService;
	
	/**
	 * 分页查询上下游客户列表
	 */
	@RequestMapping(value="/selectUpDownClientPageTable")
	@ResponseBody
	public AjaxRes selectUpDownClientPageTable(@RequestBody PageTable<Crm_upDownClient> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = upDownClientService.selectUpDownClientPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条下游销售客户信息
	 */
	@RequestMapping(value="/showDownClientAddPage")
	public ModelAndView showDownClientAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/downClient/downClientAdd");
		return mv;
	}
	
	/**
	 *  显示页面-新增一条上游供货客户信息
	 */
	@RequestMapping(value="/showUpClientAddPage")
	public ModelAndView showUpClientAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/upClient/upClientAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条上下游客户信息
	 */
	@RequestMapping(value="/insertOneUpDownClient")
	@ResponseBody
	public AjaxRes insertOneUpDownClient(@RequestBody Crm_upDownClient upDownClient){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(upDownClientService.insertOneUpDownClient(SystemSession.getUserSession(), upDownClient));
		return ar;
	}
	
	/**
	 * 显示页面-修改一条下游销售客户信息
	 */
	@RequestMapping(value="/showDownClientEditPage")
	public ModelAndView showDownClientEditPage(Crm_upDownClient upDownClient){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		upDownClient = upDownClientService.selectOneUpDownClient(upDownClient);
		mv.getModelMap().put("downClient",upDownClient);
		mv.setViewName("/crm/client/companyBusiness/downClient/downClientEdit");
		return mv;
	}
	
	/**
	 * App-查询一条下游销售客户信息
	 */
	@RequestMapping(value="/selectOneDownClientApp")
	@ResponseBody
	public AjaxRes selectOneDownClientApp(@RequestBody Crm_upDownClient upDownClient){
		AjaxRes ar = new AjaxRes();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		upDownClient = upDownClientService.selectOneUpDownClient(upDownClient);
		ar.setSucceed(upDownClient);
		return ar;
	}
	
	/**
	 * 显示页面-修改一条上游供货客户信息
	 */
	@RequestMapping(value="/showUpClientEditPage")
	public ModelAndView showUpClientEditPage(Crm_upDownClient upDownClient){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		upDownClient = upDownClientService.selectOneUpDownClient(upDownClient);
		mv.getModelMap().put("upClient",upDownClient);
		mv.setViewName("/crm/client/companyBusiness/upClient/upClientEdit");
		return mv;
	}
	
	/**
	 * App-查询一条上游销售客户信息
	 */
	@RequestMapping(value="/selectOneUpClientApp")
	@ResponseBody
	public AjaxRes selectOneUpClientApp(@RequestBody Crm_upDownClient upDownClient){
		AjaxRes ar = new AjaxRes();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		upDownClient = upDownClientService.selectOneUpDownClient(upDownClient);
		ar.setSucceed(upDownClient);
		return ar;
	}
	
	/**
	 *  执行操作-修改一条上下游客户信息
	 */
	@RequestMapping(value="/updateOneUpDownClient")
	@ResponseBody
	public AjaxRes updateOneUpDownClient(@RequestBody Crm_upDownClient upDownClient){
		AjaxRes ar = new AjaxRes();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(upDownClientService.updateOneUpDownClient(SystemSession.getUserSession(), upDownClient));
		return ar;
	}
	
	/**
	 * 显示页面-查看一条下游销售客户信息
	 */
	@RequestMapping(value="/showDownClientViewPage")
	public ModelAndView showDownClientViewPage(Crm_upDownClient upDownClient){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		upDownClient = upDownClientService.selectOneUpDownClient(upDownClient);
		mv.getModelMap().put("downClient",upDownClient);
		mv.setViewName("/crm/client/companyBusiness/downClient/downClientView");
		return mv;
	}
	
	/**
	 * 显示页面-查看一条上游供货客户信息
	 */
	@RequestMapping(value="/showUpClientViewPage")
	public ModelAndView showUpClientViewPage(Crm_upDownClient upDownClient){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		upDownClient = upDownClientService.selectOneUpDownClient(upDownClient);
		mv.getModelMap().put("upClient",upDownClient);
		mv.setViewName("/crm/client/companyBusiness/upClient/upClientView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条上游供货客户信息
	 */
	@RequestMapping(value="/showUpClientDelPage")
	public ModelAndView showUpClientDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/upClient/upClientDel");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条下游销售客户信息
	 */
	@RequestMapping(value="/showDownClientDelPage")
	public ModelAndView showDownClientDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/downClient/downClientDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条上下游客户信息
	 */
	@RequestMapping(value="/deleteOneUpDownClient")
	@ResponseBody
	public AjaxRes deleteOneUpDownClient(@RequestBody Crm_upDownClient upDownClient){
		AjaxRes ar = new AjaxRes();
		upDownClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(upDownClientService.deleteOneUpDownClient(SystemSession.getUserSession(), upDownClient));
		return ar;
	}
}

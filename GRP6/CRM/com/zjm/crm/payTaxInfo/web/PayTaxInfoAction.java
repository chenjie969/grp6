package com.zjm.crm.payTaxInfo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_payTaxInfo;
import com.zjm.crm.db.model.Crm_upDownClient;
import com.zjm.crm.payTaxInfo.service.PayTaxInfoService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/payTaxInfo")
public class PayTaxInfoAction {

	@Resource
	private PayTaxInfoService payTaxInfoService;
	
	/**
	 * 分页查询企业纳税情况列表
	 */
	@RequestMapping(value="/selectPayTaxInfoPageTable")
	@ResponseBody
	public AjaxRes selectPayTaxInfoPageTable(@RequestBody PageTable<Crm_payTaxInfo> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = payTaxInfoService.selectPayTaxInfoPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条企业纳税情况
	 */
	@RequestMapping(value="/showPayTaxInfoAddPage")
	public ModelAndView showPayTaxInfoAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/payTaxInfo/payTaxInfoAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条企业纳税情况
	 */
	@RequestMapping(value="/insertOnePayTaxInfo")
	@ResponseBody
	public AjaxRes insertOnePayTaxInfo(@RequestBody Crm_payTaxInfo payTaxInfo){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(payTaxInfoService.insertOnePayTaxInfo(SystemSession.getUserSession(), payTaxInfo));
		return ar;
	}
	
	/**
	 * 显示页面-修改一条企业纳税情况
	 */
	@RequestMapping(value="/showPayTaxInfoEditPage")
	public ModelAndView showPayTaxInfoEditPage(Crm_payTaxInfo payTaxInfo){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		payTaxInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		payTaxInfo = payTaxInfoService.selectOnePayTaxInfo(payTaxInfo);
		mv.getModelMap().put("payTaxInfo",payTaxInfo);
		mv.setViewName("/crm/client/companyBusiness/payTaxInfo/payTaxInfoEdit");
		return mv;
	}
	
	/**
	 * App-查看一条纳税情况
	 */
	@RequestMapping(value="/showPayTaxInfoEditPageApp")
	@ResponseBody
	public AjaxRes showPayTaxInfoEditPageApp(@RequestBody Crm_payTaxInfo payTaxInfo){
		AjaxRes ar = new AjaxRes();
		payTaxInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		payTaxInfo = payTaxInfoService.selectOnePayTaxInfo(payTaxInfo);
		ar.setSucceed(payTaxInfo);
		return ar;
	}
	
	
	/**
	 *  执行操作-修改一条企业纳税情况
	 */
	@RequestMapping(value="/updateOnePayTaxInfo")
	@ResponseBody
	public AjaxRes updateOnePayTaxInfo(@RequestBody Crm_payTaxInfo payTaxInfo){
		AjaxRes ar = new AjaxRes();
		payTaxInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(payTaxInfoService.updateOnePayTaxInfo(SystemSession.getUserSession(), payTaxInfo));
		return ar;
	}
	
	/**
	 * 显示页面-查看一条企业纳税情况
	 */
	@RequestMapping(value="/showPayTaxInfoViewPage")
	public ModelAndView showPayTaxInfoViewPage(Crm_payTaxInfo payTaxInfo){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		payTaxInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		payTaxInfo = payTaxInfoService.selectOnePayTaxInfo(payTaxInfo);
		mv.getModelMap().put("payTaxInfo",payTaxInfo);
		mv.setViewName("/crm/client/companyBusiness/payTaxInfo/payTaxInfoView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条企业纳税情况
	 */
	@RequestMapping(value="/showPayTaxInfoDelPage")
	public ModelAndView showPayTaxInfoDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/payTaxInfo/payTaxInfoDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条企业纳税情况
	 */
	@RequestMapping(value="/deleteOnePayTaxInfo")
	@ResponseBody
	public AjaxRes deleteOnePayTaxInfo(@RequestBody Crm_payTaxInfo payTaxInfo){
		AjaxRes ar = new AjaxRes();
		payTaxInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(payTaxInfoService.deleteOnePayTaxInfo(SystemSession.getUserSession(), payTaxInfo));
		return ar;
	}
}

package com.zjm.crm.costInfo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_costInfo;
import com.zjm.crm.db.model.Crm_upDownClient;
import com.zjm.crm.costInfo.service.CostInfoService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/costInfo")
public class CostInfoAction {

	@Resource
	private CostInfoService costInfoService;
	
	/**
	 * 分页查询水电气费缴纳列表
	 */
	@RequestMapping(value="/selectCostInfoPageTable")
	@ResponseBody
	public AjaxRes selectCostInfoPageTable(@RequestBody PageTable<Crm_costInfo> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = costInfoService.selectCostInfoPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条水电气费缴纳信息
	 */
	@RequestMapping(value="/showCostInfoAddPage")
	public ModelAndView showCostInfoAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/costInfo/costInfoAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条水电气费缴纳信息
	 */
	@RequestMapping(value="/insertOneCostInfo")
	@ResponseBody
	public AjaxRes insertOneCostInfo(@RequestBody Crm_costInfo costInfo){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costInfoService.insertOneCostInfo(SystemSession.getUserSession(), costInfo));
		return ar;
	}
	
	/**
	 * 显示页面-修改一条水电气费缴纳信息
	 */
	@RequestMapping(value="/showCostInfoEditPage")
	public ModelAndView showCostInfoEditPage(Crm_costInfo costInfo){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		costInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		costInfo = costInfoService.selectOneCostInfo(costInfo);
		mv.getModelMap().put("costInfo",costInfo);
		mv.setViewName("/crm/client/companyBusiness/costInfo/costInfoEdit");
		return mv;
	}
	
	/**
	 * App-查询一条水电气费缴纳信息
	 */
	@RequestMapping(value="/showCostInfoEditPageApp")
	@ResponseBody
	public AjaxRes showCostInfoEditPageApp(@RequestBody Crm_costInfo costInfo){
		AjaxRes ar = new AjaxRes();
		costInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		costInfo = costInfoService.selectOneCostInfo(costInfo);
		ar.setSucceed(costInfo);
		return ar;
	}
	
	/**
	 *  执行操作-修改一条水电气费缴纳信息
	 */
	@RequestMapping(value="/updateOneCostInfo")
	@ResponseBody
	public AjaxRes updateOneCostInfo(@RequestBody Crm_costInfo costInfo){
		AjaxRes ar = new AjaxRes();
		costInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(costInfoService.updateOneCostInfo(SystemSession.getUserSession(), costInfo));
		return ar;
	}
	
	/**
	 * 显示页面-查看一条水电气费缴纳信息
	 */
	@RequestMapping(value="/showCostInfoViewPage")
	public ModelAndView showCostInfoViewPage(Crm_costInfo costInfo){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		costInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		costInfo = costInfoService.selectOneCostInfo(costInfo);
		mv.getModelMap().put("costInfo",costInfo);
		mv.setViewName("/crm/client/companyBusiness/costInfo/costInfoView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条水电气费缴纳信息
	 */
	@RequestMapping(value="/showCostInfoDelPage")
	public ModelAndView showCostInfoDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/costInfo/costInfoDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条水电气费缴纳信息
	 */
	@RequestMapping(value="/deleteOneCostInfo")
	@ResponseBody
	public AjaxRes deleteOneCostInfo(@RequestBody Crm_costInfo costInfo){
		AjaxRes ar = new AjaxRes();
		costInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(costInfoService.deleteOneCostInfo(SystemSession.getUserSession(), costInfo));
		return ar;
	}
}

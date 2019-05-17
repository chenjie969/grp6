package com.zjm.crm.order.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_order;
import com.zjm.crm.db.model.Crm_upDownClient;
import com.zjm.crm.order.service.OrderService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/order")
public class OrderAction {

	@Resource
	private OrderService orderService;
	
	/**
	 * 分页查询订单列表
	 */
	@RequestMapping(value="/selectOrderPageTable")
	@ResponseBody
	public AjaxRes selectOrderPageTable(@RequestBody PageTable<Crm_order> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = orderService.selectOrderPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条订单信息
	 */
	@RequestMapping(value="/showOrderAddPage")
	public ModelAndView showOrderAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/order/orderAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条订单信息
	 */
	@RequestMapping(value="/insertOneOrder")
	@ResponseBody
	public AjaxRes insertOneOrder(@RequestBody Crm_order order){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(orderService.insertOneOrder(SystemSession.getUserSession(), order));
		return ar;
	}
	
	/**
	 * 显示页面-修改一条订单信息
	 */
	@RequestMapping(value="/showOrderEditPage")
	public ModelAndView showOrderEditPage(Crm_order order){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		order.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		order = orderService.selectOneOrder(order);
		mv.getModelMap().put("order",order);
		mv.setViewName("/crm/client/companyBusiness/order/orderEdit");
		return mv;
	}
	/**
	 * App-查询一条订单信息
	 */
	@RequestMapping(value="/showOrderEditPageApp")
	@ResponseBody
	public AjaxRes showOrderEditPageApp(@RequestBody Crm_order order){
		AjaxRes ar = new AjaxRes();
		order.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		order = orderService.selectOneOrder(order);
		ar.setSucceed(order);
		return ar;
	}
	
	/**
	 *  执行操作-修改一条订单信息
	 */
	@RequestMapping(value="/updateOneOrder")
	@ResponseBody
	public AjaxRes updateOneOrder(@RequestBody Crm_order order){
		AjaxRes ar = new AjaxRes();
		order.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(orderService.updateOneOrder(SystemSession.getUserSession(), order));
		return ar;
	}
	
	/**
	 * 显示页面-查看一条订单信息
	 */
	@RequestMapping(value="/showOrderViewPage")
	public ModelAndView showOrderViewPage(Crm_order order){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		order.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		order = orderService.selectOneOrder(order);
		mv.getModelMap().put("order",order);
		mv.setViewName("/crm/client/companyBusiness/order/orderView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条订单信息
	 */
	@RequestMapping(value="/showOrderDelPage")
	public ModelAndView showOrderDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyBusiness/order/orderDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条订单信息
	 */
	@RequestMapping(value="/deleteOneOrder")
	@ResponseBody
	public AjaxRes deleteOneOrder(@RequestBody Crm_order order){
		AjaxRes ar = new AjaxRes();
		order.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(orderService.deleteOneOrder(SystemSession.getUserSession(), order));
		return ar;
	}
}

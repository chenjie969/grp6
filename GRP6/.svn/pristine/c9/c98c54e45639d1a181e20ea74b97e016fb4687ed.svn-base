package com.zjm.crm.billRec.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_billRec;
import com.zjm.crm.billRec.service.BillRecService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/billRec")
public class BillRecAction {

	@Resource
	private BillRecService billRecService;
	
	/**
	 * 分页查询开票银行列表
	 */
	@RequestMapping(value="/selectBillRecPageTable")
	@ResponseBody
	public AjaxRes selectBillRecPageTable(@RequestBody PageTable<Crm_billRec> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = billRecService.selectBillRecPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条开票银行
	 */
	@RequestMapping(value="/showBillRecAddPage")
	public ModelAndView showBillRecAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/liabilities/billRec/billRecAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条开票银行
	 */
	@RequestMapping(value="/insertOneBillRec")
	@ResponseBody
	public AjaxRes insertOneBillRec(@RequestBody Crm_billRec billRec){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(billRecService.insertOneBillRec(SystemSession.getUserSession(), billRec));
		return ar;
	}
	
	/**
	 * 显示页面-修改一条开票银行
	 */
	@RequestMapping(value="/showBillRecEditPage")
	public ModelAndView showBillRecEditPage(Crm_billRec billRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		billRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		billRec = billRecService.selectOneBillRec(billRec);
		mv.getModelMap().put("billRec",billRec);
		mv.setViewName("/crm/client/companyFinance/liabilities/billRec/billRecEdit");
		return mv;
	}
	
	/**
	 *  执行操作-修改一条开票银行
	 */
	@RequestMapping(value="/updateOneBillRec")
	@ResponseBody
	public AjaxRes updateOneBillRec(@RequestBody Crm_billRec billRec){
		AjaxRes ar = new AjaxRes();
		billRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(billRecService.updateOneBillRec(SystemSession.getUserSession(), billRec));
		return ar;
	}
	
	/**
	 * 显示页面-查看一条开票银行
	 */
	@RequestMapping(value="/showBillRecViewPage")
	public ModelAndView showBillRecViewPage(Crm_billRec billRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		billRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		billRec = billRecService.selectOneBillRec(billRec);
		mv.getModelMap().put("billRec",billRec);
		mv.setViewName("/crm/client/companyFinance/liabilities/billRec/billRecView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条开票银行
	 */
	@RequestMapping(value="/showBillRecDelPage")
	public ModelAndView showBillRecDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/liabilities/billRec/billRecDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条开票银行
	 */
	@RequestMapping(value="/deleteOneBillRec")
	@ResponseBody
	public AjaxRes deleteOneBillRec(@RequestBody Crm_billRec billRec){
		AjaxRes ar = new AjaxRes();
		billRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(billRecService.deleteOneBillRec(SystemSession.getUserSession(), billRec));
		return ar;
	}
}

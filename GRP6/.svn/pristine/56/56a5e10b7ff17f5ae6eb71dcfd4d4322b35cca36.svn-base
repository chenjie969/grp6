package com.zjm.crm.loanRec.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_loanRec;
import com.zjm.crm.loanRec.service.LoanRecService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/loanRec")
public class LoanRecAction {

	@Resource
	private LoanRecService loanRecService;
	
	/**
	 * 分页查询贷款银行列表
	 */
	@RequestMapping(value="/selectLoanRecPageTable")
	@ResponseBody
	public AjaxRes selectLoanRecPageTable(@RequestBody PageTable<Crm_loanRec> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = loanRecService.selectLoanRecPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条贷款银行
	 */
	@RequestMapping(value="/showLoanRecAddPage")
	public ModelAndView showLoanRecAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/liabilities/loanRec/loanRecAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条贷款银行
	 */
	@RequestMapping(value="/insertOneLoanRec")
	@ResponseBody
	public AjaxRes insertOneLoanRec(@RequestBody Crm_loanRec loanRec){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(loanRecService.insertOneLoanRec(SystemSession.getUserSession(), loanRec));
		return ar;
	}
	
	/**
	 * 显示页面-修改一条贷款银行
	 */
	@RequestMapping(value="/showLoanRecEditPage")
	public ModelAndView showLoanRecEditPage(Crm_loanRec loanRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		loanRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		loanRec = loanRecService.selectOneLoanRec(loanRec);
		mv.getModelMap().put("loanRec",loanRec);
		mv.setViewName("/crm/client/companyFinance/liabilities/loanRec/loanRecEdit");
		return mv;
	}
	
	/**
	 *  执行操作-修改一条贷款银行
	 */
	@RequestMapping(value="/updateOneLoanRec")
	@ResponseBody
	public AjaxRes updateOneLoanRec(@RequestBody Crm_loanRec loanRec){
		AjaxRes ar = new AjaxRes();
		loanRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(loanRecService.updateOneLoanRec(SystemSession.getUserSession(), loanRec));
		return ar;
	}
	
	/**
	 * 显示页面-查看一条贷款银行
	 */
	@RequestMapping(value="/showLoanRecViewPage")
	public ModelAndView showLoanRecViewPage(Crm_loanRec loanRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		loanRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		loanRec = loanRecService.selectOneLoanRec(loanRec);
		mv.getModelMap().put("loanRec",loanRec);
		mv.setViewName("/crm/client/companyFinance/liabilities/loanRec/loanRecView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条贷款银行
	 */
	@RequestMapping(value="/showLoanRecDelPage")
	public ModelAndView showLoanRecDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/liabilities/loanRec/loanRecDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条贷款银行
	 */
	@RequestMapping(value="/deleteOneLoanRec")
	@ResponseBody
	public AjaxRes deleteOneLoanRec(@RequestBody Crm_loanRec loanRec){
		AjaxRes ar = new AjaxRes();
		loanRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(loanRecService.deleteOneLoanRec(SystemSession.getUserSession(), loanRec));
		return ar;
	}
}

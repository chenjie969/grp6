package com.zjm.crm.guarantyRec.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_guarantyRec;
import com.zjm.crm.guarantyRec.service.GuarantyRecService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/guarantyRec")
public class GuarantyRecAction {

	@Resource
	private GuarantyRecService guarantyRecService;
	
	/**
	 * 分页查询对外担保列表
	 */
	@RequestMapping(value="/selectGuarantyRecPageTable")
	@ResponseBody
	public AjaxRes selectGuarantyRecPageTable(@RequestBody PageTable<Crm_guarantyRec> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = guarantyRecService.selectGuarantyRecPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条对外担保
	 */
	@RequestMapping(value="/showGuarantyRecAddPage")
	public ModelAndView showGuarantyRecAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/liabilities/guarantyRec/guarantyRecAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条对外担保
	 */
	@RequestMapping(value="/insertOneGuarantyRec")
	@ResponseBody
	public AjaxRes insertOneGuarantyRec(@RequestBody Crm_guarantyRec guarantyRec){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(guarantyRecService.insertOneGuarantyRec(SystemSession.getUserSession(), guarantyRec));
		return ar;
	}
	
	/**
	 * 显示页面-修改一条对外担保
	 */
	@RequestMapping(value="/showGuarantyRecEditPage")
	public ModelAndView showGuarantyRecEditPage(Crm_guarantyRec guarantyRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		guarantyRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		guarantyRec = guarantyRecService.selectOneGuarantyRec(guarantyRec);
		mv.getModelMap().put("guarantyRec",guarantyRec);
		mv.setViewName("/crm/client/companyFinance/liabilities/guarantyRec/guarantyRecEdit");
		return mv;
	}
	
	/**
	 *  执行操作-修改一条对外担保
	 */
	@RequestMapping(value="/updateOneGuarantyRec")
	@ResponseBody
	public AjaxRes updateOneGuarantyRec(@RequestBody Crm_guarantyRec guarantyRec){
		AjaxRes ar = new AjaxRes();
		guarantyRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(guarantyRecService.updateOneGuarantyRec(SystemSession.getUserSession(), guarantyRec));
		return ar;
	}
	
	/**
	 * 显示页面-查看一条对外担保
	 */
	@RequestMapping(value="/showGuarantyRecViewPage")
	public ModelAndView showGuarantyRecViewPage(Crm_guarantyRec guarantyRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		guarantyRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		guarantyRec = guarantyRecService.selectOneGuarantyRec(guarantyRec);
		mv.getModelMap().put("guarantyRec",guarantyRec);
		mv.setViewName("/crm/client/companyFinance/liabilities/guarantyRec/guarantyRecView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条对外担保
	 */
	@RequestMapping(value="/showGuarantyRecDelPage")
	public ModelAndView showGuarantyRecDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/liabilities/guarantyRec/guarantyRecDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条对外担保
	 */
	@RequestMapping(value="/deleteOneGuarantyRec")
	@ResponseBody
	public AjaxRes deleteOneGuarantyRec(@RequestBody Crm_guarantyRec guarantyRec){
		AjaxRes ar = new AjaxRes();
		guarantyRec.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(guarantyRecService.deleteOneGuarantyRec(SystemSession.getUserSession(), guarantyRec));
		return ar;
	}
}

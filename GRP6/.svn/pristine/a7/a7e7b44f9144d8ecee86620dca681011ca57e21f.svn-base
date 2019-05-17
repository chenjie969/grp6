package com.zjm.oa.guarantee.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_staffGuarantee;
import com.zjm.oa.guarantee.service.GuaranteeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/oa/guarantee")
public class GuaranteeAction {
	@Resource
	private GuaranteeService guaranteeService;
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  loadpage(String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		try {
			modeAndView.getModel().put("type",type);
			modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/warrantyRecord/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modeAndView;
	}
	/**
	 * 添加一份担保记录
	 * 
	 * @return
	 */
	
	@RequestMapping(value="/showGuaranteeAdd")
	public ModelAndView showGuaranteeAdd(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/warrantyRecord/guaranteeAdd");
		return mv;
	}
	
	@RequestMapping(value="/insertOneGuarantee")
	@ResponseBody
	public AjaxRes insertOneGuarantee(@RequestBody Hr_staffGuarantee guarantee){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(guaranteeService.insertOneGuarantee(SystemSession.getUserSession(), guarantee));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}

    /**
     *  更新一份担保记录
     * 
     * @return
     */
	@RequestMapping(value="/showGuaranteeUpdate")
	public ModelAndView showGuaranteeUpdate(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/warrantyRecord/guaranteeUpdate");
		return mv;
	}
	
	@RequestMapping(value="/updateOneGuarantee")
	@ResponseBody
	public AjaxRes updateOneGuarantee(@RequestBody Hr_staffGuarantee guarantee){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(guaranteeService.updateOneGuarantee(SystemSession.getUserSession(), guarantee));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 
	 * 查询担保记录表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectGuaranteeTable")
	@ResponseBody
	public AjaxRes selectGuaranteeTable(@RequestBody PageTable<Hr_staffGuarantee> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable =guaranteeService.selectGuaranteeTable(pageTable);
			ar.setSucceed(pageTable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	} 
	
	@RequestMapping(value="/selectOneGuarantee")
	public ModelAndView selectOneGuarantee(String guaranteeID,String operationType){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Hr_staffGuarantee guarantee = guaranteeService.selectOneGuarantee(guaranteeID);
		mv.getModelMap().put("guarantee",guarantee);
		if ("update".equals(operationType)) {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/warrantyRecord/guaranteeUpdate");
		} else {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/warrantyRecord/guaranteeView");
		}
		return mv;
	}
	
	
	

}

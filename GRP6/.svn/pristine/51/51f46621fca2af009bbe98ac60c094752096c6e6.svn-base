package com.zjm.oa.medical.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_medical;
import com.zjm.oa.medical.service.MedicalService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
@Controller
@RequestMapping(value="/oa/medical")
public class MedicalAction {

	@Resource
	private MedicalService medicalService;
	//加载页面表格
			@RequestMapping(value="/loadPage")
			public ModelAndView  loadpage(String staffcase_Id,String type){
				ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
				modeAndView.getModel().put("staffcase_Id", staffcase_Id);
				modeAndView.getModel().put("type",type);
				modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/medical/index");
				return modeAndView;
			}
	
	/**
	 * 
	 * 查询体检记录表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectMedicalTable")
	@ResponseBody
	public AjaxRes selectMedicalTable(@RequestBody PageTable<Hr_medical> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable =medicalService.selectMedicalTable(pageTable);
			ar.setSucceed(pageTable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	@RequestMapping(value="/selectOneMedical")
	public ModelAndView selectOneMedical(String medicalID,String operationType){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Hr_medical medical = medicalService.selectOneMedical(medicalID);
		mv.getModelMap().put("medical",medical);
		if ("update".equals(operationType)) {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/medical/medicalUpdate");
		} else {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/medical/medicalView");
		}
		return mv;
	}
	
	/**
	 * 添加一份体检记录
	 * 
	 * @return
	 */
	
	@RequestMapping(value="/showMedicalAdd")
	public ModelAndView showMedicalAdd(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/medical/medicalAdd");
		return mv;
	}
	
	@RequestMapping(value="/insertOneMedical")
	@ResponseBody
	public AjaxRes insertOneMedical(@RequestBody Hr_medical medical){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(medicalService.insertOneMedical(SystemSession.getUserSession(), medical));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
    /**
     *  更新一份体检记录
     * 
     * @return
     */
	@RequestMapping(value="/showMedicalUpdate")
	public ModelAndView showMedicalUpdate(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/medical/medicalUpdate");
		return mv;
	}
	
	@RequestMapping(value="/updateOneMedical")
	@ResponseBody
	public AjaxRes updateOneMedical(@RequestBody Hr_medical medical){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(medicalService.updateOneMedical(SystemSession.getUserSession(), medical));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
}

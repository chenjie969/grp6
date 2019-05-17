package com.zjm.oa.training.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_training;
import com.zjm.oa.training.service.TrainingService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/oa/training")
public class TrainingAction {
	@Resource
	private TrainingService trainingService;
	//加载页面表格
		@RequestMapping(value="/loadPage")
		public ModelAndView  loadpage(String staffcase_Id,String type){
			ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
			modeAndView.getModel().put("staffcase_Id", staffcase_Id);
			modeAndView.getModel().put("type",type);
			modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/trainingRecord/index");
			return modeAndView;
		}	
	  /**
	   * 查询培训记录表
	   * 
	   * @param pageTable
	   * @return
	   */
	@RequestMapping(value="/selectTrainingTable")
	@ResponseBody
	public AjaxRes selectTrainingTable(@RequestBody PageTable<Hr_training> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable =trainingService.selectTrainingTable(pageTable);
			ar.setSucceed(pageTable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 查询一条培训记录
	 * @param trainingID
	 * @param operationType
	 * @return
	 */
	@RequestMapping(value="/selectOneTraining")
	public ModelAndView selectOneTraining(String trainingID,String operationType){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Hr_training training = trainingService.selectOneTraining(trainingID);
		mv.getModelMap().put("training",training);
		if ("update".equals(operationType)) {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/trainingRecord/trainingUpdate");
		} else {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/trainingRecord/trainingView");
		}
		return mv;
	}
	
	 /**
	  * 增加一条培训记录
	  * @return
	  */
	@RequestMapping(value="/showTrainingAdd")
	public ModelAndView showTrainingAdd(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/trainingRecord/trainingAdd");
		return mv;
	}
	
	@RequestMapping(value="/insertOneTraining")
	@ResponseBody
	public AjaxRes insertOneTraining(@RequestBody Hr_training training){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(trainingService.insertOnetraining(SystemSession.getUserSession(), training));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
    /**
     *  更新一份培训记录
     * 
     * @return
     */
	@RequestMapping(value="/showTrainingUpdate")
	public ModelAndView showTrainingUpdate(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/trainingRecord/trainingUpdate");
		return mv;
	}
	
	@RequestMapping(value="/updateOneTraining")
	@ResponseBody
	public AjaxRes updateOneTraining(@RequestBody Hr_training training){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(trainingService.updateOneTraining(SystemSession.getUserSession(), training));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
}

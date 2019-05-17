package com.zjm.pro.projectTransfer.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_projChangeRec;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectTransfer.service.ProjChangeRecService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;


@Controller
@RequestMapping(value="/project/projChangeRec")
public class ProjChangeRecAction {
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private ApplyDetailService applyDetailService;
	
	@Resource
	private ProjChangeRecService projChangeRecService;
	
	/**
	 * 打开移交记录页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/openProjectTransfer")
	public ModelAndView openProjectTransfer(String project_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		mv.getModelMap().put("project",project);
		mv.setViewName("/project/apply/projectTransfer");
		return mv;
	}
	
	
	/**
	 * 打开新增移交记录页面
	 * @param project_ID
	 * @param apply_ID
	 * @return
	 */
	@RequestMapping(value="/openInsertProjectTransfer")
	public ModelAndView insertProjectTransfer(String project_ID ,String apply_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		Pro_apply apply = new Pro_apply();
		apply = projectApplyService.selectOneApplyByWhereSql("and apply_ID = \'" + apply_ID + "\'"); 
		Pro_applyDetail detail = new Pro_applyDetail();
		detail = applyDetailService.selectOneApplyDetailByWhereSql("and apply_ID = \'" + apply_ID + "\'");
		User user = SystemSession.getUserSession();
		mv.getModelMap().put("project",project);
		mv.getModelMap().put("apply",apply);
		mv.getModelMap().put("detail",detail);
		mv.getModelMap().put("user", user);
		mv.setViewName("/project/projectTransfer/projectChangeRec");
		return mv;
	}
	
	/**
	 * 新增移交记录
	 * @param projChangeRec
	 * @return
	 */
	@RequestMapping(value="/insertOneProjChangRec")
	@ResponseBody
	public AjaxRes insertOneProjChangRec(@RequestBody Pro_projChangeRec projChangeRec){
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		ar.setSucceed(projChangeRecService.insertOneProjChangeRec(projChangeRec ,user));
		return ar;
	}
	
	/**
	 * 查询移交记录列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectProjChangeRecPageTable")
	@ResponseBody
	public AjaxRes selectTrnsferLogPageTable(@RequestBody PageTable<Pro_projChangeRec> pageTable){
		PageTable<Pro_projChangeRec>  table = projChangeRecService.selectProjChangeRecPageTable(pageTable);
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(table);
		return ar;
	}
	
	/**
	 * 编辑移交记录页面
	 * @param projChangeRec_ID
	 * @return
	 */
	@RequestMapping(value="/editOneProjChangeRecPage")
	@ResponseBody
	public ModelAndView editOneProjChangeRecPage(String  projChangeRec_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_projChangeRec projChangeRec = projChangeRecService.selectOneProjChangeRec(projChangeRec_ID);
		mv.getModel().put("projChangeRec", projChangeRec);
		mv.setViewName("/project/projectTransfer/projectChangeRecEdit");
		return mv;
	}
	
	
	/**
	 *  修改移交记录
	 * @param projChangeRec
	 * @return
	 */
	@RequestMapping(value="/updateOneProjChangeRec")
	@ResponseBody
	public AjaxRes updateOneProjChangeRec(@RequestBody Pro_projChangeRec projChangeRec){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(projChangeRecService.updateOneProjChangeRec(projChangeRec));
		return ar;
	}
	
	
}

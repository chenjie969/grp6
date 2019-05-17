package com.zjm.pro.projectDetail.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;

@Controller
@RequestMapping(value="/project/projectDetail")
public class ProjectDetailAction {
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private DicTypeService dicTypeService;
	
	
	
	@RequestMapping(value="/viewProjectInfo")
	public ModelAndView viewProjectInfo(Pro_project pro_project){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply apply = new Pro_apply();
		Pro_project project = new Pro_project ();
		System.err.println(" and  apply_ID = "+pro_project.getApply_ID());
		 apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+pro_project.getApply_ID()+"\'");
		 project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+pro_project.getProject_ID()+"\'");
		mv.getModelMap().put("apply",apply);
		mv.getModelMap().put("project",project);
		
		mv.setViewName("/project/projectDetail/projectDetailIndex");
		return mv;
	}

	@RequestMapping(value="/projectview")
	public ModelAndView projectview(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/projectDetail/projectBasicInfo/stockMessageList");
		return mv;
	}
	
	@RequestMapping(value="/projectBasicInfo")
	public ModelAndView projectBasicInfo(Pro_project pro_project){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+pro_project.getApply_ID()+"\'");
		Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+pro_project.getProject_ID()+"\'");
		C_dictype type = new C_dictype();
		type.setDicTypeID(apply.getClientTypeID());
		type = dicTypeService.selectOneDicTypeInfo(type);
		mv.getModelMap().put("apply",apply);
		mv.getModelMap().put("project",project);
		mv.getModelMap().put("clientType", type);
		mv.setViewName("/project/projectDetail/projectBasicInfo/projectBasicInfo");
		return mv;
	}
	
	
}

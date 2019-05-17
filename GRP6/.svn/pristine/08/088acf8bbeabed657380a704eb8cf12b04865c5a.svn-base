package com.zjm.pro.heTong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Crm_riskLevelRec;
import com.zjm.crm.riskLevel.service.RiskLevelService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.checkPlan.service.CheckPlanService;
import com.zjm.pro.checkReport.service.CheckReportService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_checkPlan;
import com.zjm.pro.db.model.Pro_checkReport;
import com.zjm.pro.db.model.Pro_optGuaranty;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
public class HeTongAction {

	@RequestMapping(value="/addHeTongPage")
	public ModelAndView addHeTongPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/HeTong/addHeTong");
		return mv;
	}
}

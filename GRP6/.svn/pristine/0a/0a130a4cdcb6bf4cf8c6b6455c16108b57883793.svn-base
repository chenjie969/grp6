package com.zjm.oa.socialSecurity.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.gbpm.db.model.Act_re_actSort;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
@Controller
@RequestMapping("/socialSecurity")
public class SocialSecurityAction {

	@Resource
	private SysDicDataService  sysDicDataService;	
	/** 查询 */
	@RequestMapping(value="/socialSecurityView")
	public ModelAndView selectTransfer(Act_re_actSort actSort){
//		if(actSort==null){
//			actSort=new Act_re_actSort();
//		}
		/*actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		actSort=actSortService.selectOneActSortInfo(actSort);*/
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialSecurity/viewmodal");
		/*mv.getModel().put("actSort", actSort);*/
		return mv;
		
	}
	/**
	 * 修改
	 */
	@RequestMapping(value="/socialSecurityUpdate")
	public ModelAndView selectEmployeeEditPage(Act_re_actSort actSort){
		if(actSort==null){
			actSort=new Act_re_actSort();
		}
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
//		actSort=actSortService.selectOneActSortInfo(actSort);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialSecurity/upModal");
		mv.getModel().put("actSort", actSort);
		return mv;
	}	
	/** 添加 */
	@RequestMapping(value="/socialSecurityAddPage")
	public ModelAndView selectEmployeeAddPage(Act_re_actSort actSort){
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialSecurity/addModal");
		mv.getModel().put("actSort", actSort);
		return mv;
	}
	
}

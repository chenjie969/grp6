package com.zjm.oa.disMission.web;



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
import com.zjm.oa.db.model.Hr_staffCase;

import com.zjm.oa.staffCase.service.StaffCaseService;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;


@Controller
@RequestMapping(value = "/oa/disMiass")
public class DisMissionAction {
	@Resource
	private StaffCaseService staffCaseService;
	@Resource
	private DicTypeService dicTypeService; // 单级字典
	@Resource
	private UsersService usersService;

	/**
	 * 查询用户分页列表
	 */
	@RequestMapping(value = "/selectDisMissionTable")
	@ResponseBody
	public AjaxRes selectDisMissionTable(@RequestBody PageTable pageTable) {
		try {
			pageTable.setWheresql(queryConditionSql(pageTable));
			pageTable = staffCaseService.selectStaffCaseTables(pageTable);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 用户分页列表查询条件
	 */
	private String queryConditionSql(PageTable pageTable) {
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and u.user_name like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			if(pageTable.getQueryCondition().getDepart_uid()!=null 
					&& !pageTable.getQueryCondition().getDepart_uid().equals("") 
					&& !pageTable.getQueryCondition().getDepart_uid().equals("a129b9eea27a48be896697a39aa0aee7")){
				wheresql=wheresql+" and d.depart_fullcode like \'%"+pageTable.getQueryCondition().getDepart_uid().trim()+"%\'";
			}
			wheresql = wheresql + " and u.user_type  = '2' ";
		}
		return wheresql;
	}

	/*
	 * 根据员工ID查询该员工详细信息
	 */
	@RequestMapping(value = "/employeeInfo")
	public ModelAndView employeeInfo(String id, String user_name) {
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		try {			
			Hr_staffCase hr_staffCase = new Hr_staffCase();
			hr_staffCase.setUser_uid(id);
			hr_staffCase.setUser_name(user_name);
			Hr_staffCase hrstaffCase = staffCaseService.selectOneStaffCaseInfo(hr_staffCase);			
			modeAndView.getModel().put("hrstaffCase", hrstaffCase);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/employeeDetail");
		return modeAndView;
	}
	/**
	 * 离职信息页面
	 */
	@RequestMapping(value = "/disMissionPage")
	public ModelAndView disMissionPage(String user_uid,String user_name) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			Hr_staffCase hr_staffCase=new Hr_staffCase();		
			hr_staffCase.setUser_uid(user_uid);
			hr_staffCase.setUser_name(user_name);		
			Boolean result=false;			
			Hr_staffCase  isExist = staffCaseService.selectOneStaffCaseInfo1(hr_staffCase);	
			System.out.println("isExist:"+isExist);
		if(isExist == null){			
			//新增信息			
			hr_staffCase.setStaffcase_Id(Tool.createUUID32());				
			hr_staffCase.setUser_uid(user_uid);	
			hr_staffCase.setUnit_uid(SystemSession.getUserSession().getUnit_uid());	
			hr_staffCase.setUser_name(user_name);
			result = staffCaseService.insertOneStaffCaseInfo(hr_staffCase,SystemSession.getUserSession());			
		}
		Hr_staffCase  hrstaffCase = staffCaseService.selectOneStaffCaseInfo(hr_staffCase);
		mv.getModel().put("hrstaffCase",hrstaffCase);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		mv.setViewName("/oa/personfile/employeeInfo/disMission");
		
		return mv;
	}
	/**
	 * 离职
	 */
	@RequestMapping(value = "/disMissionEdit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes disMissionEdit(@RequestBody Hr_staffCase hrstaffCase) {
		Boolean b=true;
		try {		
		Sys_users sys_users = new Sys_users();
		sys_users.setUser_uid(hrstaffCase.getUser_uid());
		sys_users.setUnit_uid(SystemSession.getUserSession().getUnit_uid());	
		Sys_users user = usersService.selectOneUsersInfo(sys_users);		
		user.setUser_type("2");
		usersService.updateOneUsersInfo(SystemSession.getUserSession(), user);
		b = staffCaseService.updateOneDismissonInfo(hrstaffCase);
	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}

}

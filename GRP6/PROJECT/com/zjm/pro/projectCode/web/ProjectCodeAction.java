package com.zjm.pro.projectCode.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_projectCode;
import com.zjm.pro.projectCode.service.ProjectCodeService;
import com.zjm.util.SystemSession;

/**
 * 项目编号
 * @author chenyang   add 20170719
 */
@Controller
@RequestMapping(value="/pro/projectCode")
public class ProjectCodeAction {
	@Resource
	private ProjectCodeService projectCodeService;
	
	/**
	 * 查询一个项目编号信息
	 * @param sys_projectCode
	 * @return
	 */
	@RequestMapping(value="/selectOneProjectCodeInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneProjectCodeInfo(@RequestBody Pro_projectCode projectCode){
		AjaxRes ar=new AjaxRes();
		projectCode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		projectCode=projectCodeService.selectOneProjectCodeInfo(projectCode);
		ar.setSucceed(projectCode);
		return ar;
	}
	
	/**
	 * 更新项目编号信息
	 * @param sys_projectCode
	 * @return
	 */
	@RequestMapping(value="/updateOneProjectCodeInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneProjectCodeInfo(@RequestBody Pro_projectCode projectCode){
		AjaxRes ar=new AjaxRes();
		User user = SystemSession.getUserSession();
		Boolean b=projectCodeService.updateOneProjectCodeInfo(user,projectCode);
		ar.setSucceed(b);
		return ar;
	}

}

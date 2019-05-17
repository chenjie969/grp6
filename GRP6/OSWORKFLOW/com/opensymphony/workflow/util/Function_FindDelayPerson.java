package com.opensymphony.workflow.util;

import java.util.Map;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.sys.db.model.Sys_roles;
import com.zjm.sys.roles.service.RolesService;
import com.zjm.util.SystemSession;

public class Function_FindDelayPerson {

	public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
		//获取参数 
		WorkflowEntry entry = (WorkflowEntry) transientVars.get("entry");
		String projectid = (String) transientVars.get("projectid"); 
		String person = (String) args.get("person");
		
		//普通人员
		Sys_roles roles=new Sys_roles();
		roles.setRole_uid("cbeb758e3d824626a31aabb2a9587b0a");
		roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		RolesService rolesService = (RolesService) SpringContextUtil.getBean("rolesService");
		roles=rolesService.selectOneRolesInfo(roles);
		//查找项目ABCD人员
		ProjectApplyService projectApplyService = (ProjectApplyService) SpringContextUtil.getBean("projectApplyService");
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID=\'"+projectid+"\'");
		//
		if("A".equals(person)){
			transientVars.put("appointUser", apply.getAmanID());
		}else if("B".equals(person)){
			transientVars.put("appointUser", apply.getBmanID());
		}else if("C".equals(person)){
			transientVars.put("appointUser", apply.getReviewManID());
		}else if("D".equals(person)){
			transientVars.put("appointUser", apply.getReviewManID());
		}
		//A或者B角都要在列表 则要相应调整AbstractWorkflow
		/*else if("AorB".equals(person)){
			transientVars.put("appointUser", apply.getAmanID());
		}*/else{
			System.err.print("Function_FindProjectPerson 函数参数配置有误");
		}
	}
}

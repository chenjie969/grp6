package com.opensymphony.workflow.util;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;


/**
 * 从Apply表中取项目人员
 * 	参数定义:person 
 * 		A:A角
 * 		B:B角
 * 		C:风险复审人
 * 		D:法务审核人
 * @author weizh
 * @version 2017-11-17
 *
 */
@Component
public class Function_FindProjectPerson implements FunctionProvider {
	public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
		//获取参数 
		WorkflowEntry entry = (WorkflowEntry) transientVars.get("entry");
		String projectid = (String) transientVars.get("projectid"); 
		String person = (String) args.get("person");
		
		//查找项目人员
		ProjectApplyService projectApplyService = (ProjectApplyService) SpringContextUtil.getBean("projectApplyService");
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID=\'"+projectid+"\'");
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

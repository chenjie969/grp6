package com.opensymphony.workflow.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowInstanceService;
import com.zjm.pro.costReturn.service.CostReturnService;
import com.zjm.pro.db.model.Pro_costReturn;
import com.zjm.pro.db.model.Pro_optGuaranty;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.optGuaranty.service.OptGuarantyService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.util.SystemSession;

/**
 * 通用后置函数-调整子流程对应表单的状态
 * 参数定义:
 * 		tableName：表单名称
 * 		businessIdName:实体ID字段名称
 * 		columnName：修改字段名称
 * 		setValue：修改值
 * @author weizh
 * @version 2017-11-17
 */
@Component
public class Function_UpdateReturnGuarantySum  implements FunctionProvider{

	@Override
	public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
		WorkflowEntry entry = (WorkflowEntry) transientVars.get("entry");
		String applyId = (String) transientVars.get("projectid"); 
		
		ProjectService projectService = (ProjectService) SpringContextUtil
				.getBean("projectService");
		//根据业务id获取业务表信息;
		String wheresql = " and apply_ID = \'"+applyId+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
	    OsGworkflowInstanceService osGworkflowInstanceService = (OsGworkflowInstanceService)SpringContextUtil.getBean("osGworkflowInstanceService");
	    OsGworkflowInstance query = new OsGworkflowInstance();
	    query.setEntryId(entry.getId());
		OsGworkflowInstance instance = osGworkflowInstanceService.selectOne(query, "entryId");
		CostReturnService costReturnService = (CostReturnService) SpringContextUtil.getBean("costReturnService");
		String costReturnWheresql = " and costReturn_ID = \'"+instance.getBusinessId()+"\'";
		Pro_costReturn costReturn = costReturnService.selectOneCostReturnByWhereSql(costReturnWheresql);
		costReturn.setCostReturnState("已确认到账");
		costReturnService.updateOneCostReturn(SystemSession.getUserSession(), costReturn);
	}

}

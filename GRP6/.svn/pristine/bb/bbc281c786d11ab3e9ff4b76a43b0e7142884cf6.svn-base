package com.opensymphony.workflow.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowInstanceService;

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
public class Function_ModifyBusinessState implements FunctionProvider  {
	@Override
	public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
		WorkflowEntry entry = (WorkflowEntry) transientVars.get("entry");
		String projectid = (String) transientVars.get("projectid"); 
		
		String tableName = (String)args.get("tableName");
		String businessIdName = (String)args.get("businessIdName");
		String columnName = (String)args.get("columnName");
		String setValue = (String)args.get("setValue");
		
		//拼装SQL
		String updateSql = "update #tableName set #columnName = '#setValue' where #businessIdName = '#businessId'";
		OsGworkflowInstanceService osGworkflowInstanceService = (OsGworkflowInstanceService)SpringContextUtil.getBean("osGworkflowInstanceService");
		OsGworkflowInstance query = new OsGworkflowInstance();
		query.setEntryId(entry.getId());
		OsGworkflowInstance instance = osGworkflowInstanceService.selectOne(query, "entryId");
		
		updateSql = updateSql.replace("#tableName", tableName);
		updateSql = updateSql.replace("#columnName", columnName);
		updateSql = updateSql.replace("#setValue", setValue);
		updateSql = updateSql.replace("#businessIdName", businessIdName);
		updateSql = updateSql.replace("#businessId", instance.getBusinessId());
		System.out.println(updateSql);
		
		osGworkflowInstanceService.executeSQL(updateSql);
	}
}

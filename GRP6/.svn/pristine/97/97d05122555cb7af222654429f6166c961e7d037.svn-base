package com.opensymphony.workflow.util;

import java.util.Map;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowContext;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.opensymphony.workflow.spi.WorkflowStore;
import com.zjm.common.db.model.User;

public class ChangeProjInGuaraStatues implements FunctionProvider {

	public void execute(Map transientVars, Map args, PropertySet ps)
			throws WorkflowException {

		WorkflowContext context = (WorkflowContext) transientVars.get("context");
		//获取当前步骤操作人
		String usergid =  context.getCaller();
		
		WorkflowEntry entry = (WorkflowEntry) transientVars.get("entry");
		WorkflowStore store = (WorkflowStore) transientVars.get("store");
       // GworkFlowUtils gworkFlowUtils = new GworkFlowUtils((MySQLWorkflowStore) store); 
		
		//test
		String projectid=(String) transientVars.get("projectid");
		System.out.println("projectid:"+projectid);

	}

}

package com.opensymphony.workflow.util;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowException;
import com.zjm.common.db.model.User;




public class SetLimitDate implements FunctionProvider{
	//ApplicationContext cxt = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
	public void execute(Map transientVars, Map args, PropertySet ps)
			throws WorkflowException {
		String  projectid=(String) transientVars.get("projectid");
		if(projectid!=null && !projectid.equals("") && !projectid.equals("null") ){
			//步骤限办时间
			//autoSettingLimitDate((String) transientVars.get("projectid"),args);
		}else{
			//步骤限办时间
			//initializeautoSettingLimitDate(args);
		}
	}
	//步骤限办时间
	/*private void initializeautoSettingLimitDate(Map args) {
		//获取当前步骤限办时间
		String nowlimitDate=""+args.get("nowlimitDate");
		nowlimitDate=nowlimitDate.trim();
		//获取当前步骤限办时间单位
		String nowlimitDateUnit=""+args.get("nowlimitDateUnit");
		nowlimitDateUnit=nowlimitDateUnit.trim();
		//获取当前步骤限办时间
		String nextlimitDate=""+args.get("nextlimitDate");
		nextlimitDate=nextlimitDate.trim();
		//获取当前步骤限办时间单位
		String nextlimitDateUnit=""+args.get("nextlimitDateUnit");
		nextlimitDateUnit=nextlimitDateUnit.trim();
		OsHistorystepDao osHistorystepDao = (OsHistorystepDao) cxt.getBean("osHistorystepDao");
		//修改待办步骤的限办时间
		if(nextlimitDate!=null && !nextlimitDate.equals("") && !nextlimitDate.equals("null") && nextlimitDateUnit!=null && !nextlimitDateUnit.equals("") && !nextlimitDateUnit.equals("null")){
			String wheresql2 = " UPDATE os_currentstep SET	limitDate = \'"+nextlimitDate+"\' ,limitDateUnit = \'"+nextlimitDateUnit+"\' 	WHERE STEP_ID = \'101\' AND limitDate is null AND STEP_ID !=\'900\' ";
			Integer b = osHistorystepDao.updateOneWorkFlowStepLimitDate(wheresql2);
			
		}
		//修改历史步骤的限办时间
		if(nowlimitDate!=null && !nowlimitDate.equals("") && !nowlimitDate.equals("null") && nowlimitDateUnit!=null && !nowlimitDateUnit.equals("") && !nowlimitDateUnit.equals("null")){
			String wheresql3 = " UPDATE os_historystep SET	limitDate = \'"+nowlimitDate+"\' ,limitDateUnit = \'"+nowlimitDateUnit+"\'	WHERE STEP_ID = \'101\' AND limitDate is null AND STEP_ID !=\'900\' ";
			Integer c = osHistorystepDao.updateOneWorkFlowStepLimitDate(wheresql3);
			
		}
		
	}
	*//**
	 * 设置步骤限办时间
	 * @param transientVars
	 * @param args
	 *//*
	private void autoSettingLimitDate(String projectID, Map args) {
		
		//获取当前步骤限办时间
		String nowlimitDate=""+args.get("nowlimitDate");
		nowlimitDate=nowlimitDate.trim();
		//获取当前步骤限办时间单位
		String nowlimitDateUnit=""+args.get("nowlimitDateUnit");
		nowlimitDateUnit=nowlimitDateUnit.trim();
		
		//获取当前步骤限办时间
		String nextlimitDate=""+args.get("nextlimitDate");
		nextlimitDate=nextlimitDate.trim();
		//获取当前步骤限办时间单位
		String nextlimitDateUnit=""+args.get("nextlimitDateUnit");
		nextlimitDateUnit=nextlimitDateUnit.trim();
		
		OsHistorystepDao osHistorystepDao = (OsHistorystepDao) cxt.getBean("osHistorystepDao");
		
		//查询流程项目实例对应表，返回流程ENTRY_ID
		String wheresql = " unit_uid = \'"
				+ SystemSession.getUserSession().getUnit_uid()+"\'";
		wheresql=wheresql+" AND projectID=\'"+projectID+"\'";
		Long entryid=osHistorystepDao.returnOneWorkFlowENTRYID(wheresql);
		//修改待办步骤的限办时间
		if(nextlimitDate!=null && !nextlimitDate.equals("") && !nextlimitDate.equals("null") && nextlimitDateUnit!=null && !nextlimitDateUnit.equals("") && !nextlimitDateUnit.equals("null")){
			String wheresql2 = " UPDATE os_currentstep SET	limitDate = \'"+nextlimitDate+"\' ,limitDateUnit = \'"+nextlimitDateUnit+"\' 	WHERE ENTRY_ID = \'"+entryid+"\' AND limitDate is null  AND STEP_ID !=\'900\' ";
			Integer b = osHistorystepDao.updateOneWorkFlowStepLimitDate(wheresql2);
		}
		//修改历史步骤的限办时间
		if(nowlimitDate!=null && !nowlimitDate.equals("") && !nowlimitDate.equals("null") && nowlimitDateUnit!=null && !nowlimitDateUnit.equals("") && !nowlimitDateUnit.equals("null")){
			String wheresql3 = " UPDATE os_historystep SET	limitDate = \'"+nowlimitDate+"\' ,limitDateUnit = \'"+nowlimitDateUnit+"\'	WHERE ENTRY_ID = \'"+entryid+"\' AND limitDate is null AND STEP_ID !=\'900\' ";
			Integer c = osHistorystepDao.updateOneWorkFlowStepLimitDate(wheresql3);
		}
	}*/
}

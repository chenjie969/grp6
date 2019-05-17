package com.opensymphony.workflow.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowInstanceService;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.delay.service.impl.DelayServiceImpl;
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
public class Function_UpdateDelay implements FunctionProvider  {

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
		DelayServiceImpl delayServiceImpl = (DelayServiceImpl) SpringContextUtil
				.getBean("delayService");
		String delayWheresql = " and delay_ID = \'"+instance.getBusinessId()+"\'";
		Pro_delay delay = delayServiceImpl.selectOneDelayInfo(delayWheresql);
	    project.setDelayEndDate(delay.getDelayEndDate());//更新展期 到期日期
	    int[] monthDay = getMonthAndDay(project.getLoadBeginDate(), project.getDelayEndDate());
		project.setPeriodDay(monthDay[1]);
		project.setPeriodMonth(monthDay[0]);
		project.setPeriodMonthDay(getMonthDayByMonthAndDay(monthDay[0],monthDay[1]));
	    project.setIsDelay(1);
		//更新放款表信息
	    projectService.updateOneProjectInfo(SystemSession.getUserSession(), project);
//		String tableName = (String)args.get("tableName");
//		String businessIdName = (String)args.get("businessIdName");
//		String columnName = (String)args.get("columnName");
//		String setValue = (String)args.get("setValue");
//		
//		//拼装SQL
//		String updateSql = "update #tableName set #columnName = '#setValue' where #businessIdName = '#businessId'";
//		OsGworkflowInstanceService osGworkflowInstanceService = (OsGworkflowInstanceService)SpringContextUtil.getBean("osGworkflowInstanceService");
//		OsGworkflowInstance query = new OsGworkflowInstance();
//		query.setEntryId(entry.getId());
//		OsGworkflowInstance instance = osGworkflowInstanceService.selectOne(query, "entryId");
//		
//		updateSql = updateSql.replace("#tableName", tableName);
//		updateSql = updateSql.replace("#columnName", columnName);
//		updateSql = updateSql.replace("#setValue", setValue);
//		updateSql = updateSql.replace("#businessIdName", businessIdName);
//		updateSql = updateSql.replace("#businessId", instance.getBusinessId());
//		System.out.println(updateSql);
//		
//		osGworkflowInstanceService.executeSQL(updateSql);
	}
	private int[]  getMonthAndDay(Date fromDate,Date toDate) {
		Calendar  from  =  Calendar.getInstance();
	    from.setTime(fromDate);
	    Calendar  to  =  Calendar.getInstance();
	    to.setTime(toDate);
	    int fromYear = from.get(Calendar.YEAR);
	    int fromMonth = from.get(Calendar.MONTH);
	    int fromDay = from.get(Calendar.DAY_OF_MONTH);
	    int toYear = to.get(Calendar.YEAR);
	    int toMonth = to.get(Calendar.MONTH);
	    int toDay = to.get(Calendar.DAY_OF_MONTH);
	    int year = toYear  -  fromYear;
	    int day = toDay  - fromDay;
	    int month = year*12 + toMonth  - fromMonth;
	    if( day< 0){
	    	switch (toMonth) {
			case 0://一月
				day = 31 +day; //12月的天数加上负的天数
				break;

			default:
				Calendar cal = Calendar.getInstance(); 
		    	cal.set(Calendar.YEAR,toYear); 
		    	cal.set(Calendar.MONTH, toMonth-1);
		    	int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
		    	day =dateOfMonth+day;
				break;
			}
	    	month = year*12 + toMonth  - fromMonth -1 ;
	    }
	   
	    int[] monthDay = new int[]{month,day};
	    return monthDay;
	}
	
	//通过期限年和月获取年月
	public String getMonthDayByMonthAndDay(Integer periodMonth,Integer periodDay){
			String periodMonthDay = "";
			if(periodMonth!=null && periodMonth != 0){
				periodMonthDay +=periodMonth+"个月";
			}
			if(periodDay!=null){	
				periodMonthDay +=periodDay+"天";					
			}
			return periodMonthDay.toString();
	}
}

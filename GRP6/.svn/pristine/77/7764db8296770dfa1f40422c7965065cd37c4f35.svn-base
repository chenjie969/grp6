/**
 * 运行中任务
 * chenyang
 */

package com.zjm.gbpm.runTask.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_runTask;
import com.zjm.gbpm.runTask.service.RunTaskService;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/gbpm/runTask")
public class RunTaskAction{
	
	@Resource
	private RunTaskService runTaskService;
	
	
	/**
	 * 分页查询待办任务列表
	 */
	@RequestMapping(value="/selectWaitTaskPageTable")
	@ResponseBody
	public AjaxRes selectWaitTaskPageTable(@RequestBody PageTable<Gbpm_runTask> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = runTaskService.selectRunTaskGroupTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Gbpm_runTask> pageTable){
		StringBuffer wheresql = new StringBuffer();
		if (pageTable.getWheresql()!=null) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and runTask.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		wheresql.append(" and (runTask.handleUserID like \'%"+SystemSession.getUserSession().getUser_uid()+"%\' or INSTR(\' " + SystemSession.getUserSession().getRole_uids() + "\',runTask.handleUserID) > 0)");
		wheresql.append(" and taskStatus = \'"+ "未完成" +"\' ");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and productName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();
	}
	
	/**
	 * 分页查询待办任务列表
	 */
	@RequestMapping(value="/selectBeforeTaskNoFinish")
	@ResponseBody
	public AjaxRes isBeforeTaskStatus(@RequestBody Gbpm_runTask runTask){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			String whereSql =" and taskMangerID = \'" + runTask.getBeforeTaskID() + "\'";
			whereSql = whereSql + " and runNodeID = \'" + runTask.getRunNodeID() + "\'";
			whereSql = whereSql + " and taskStatus = \'未完成\'";
			b = runTaskService.selectBeforeTaskNoFinish(whereSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
}
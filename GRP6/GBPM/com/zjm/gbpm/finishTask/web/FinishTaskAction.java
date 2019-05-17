/**
 * 已完成任务
 * chenyang
 */

package com.zjm.gbpm.finishTask.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_finishTask;
import com.zjm.gbpm.finishTask.service.FinishTaskService;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/gbpm/finishTask")
public class FinishTaskAction{
	
	@Resource
	private FinishTaskService finishTaskService;
	
	/**
	 * 分页查询已完成任务列表
	 */
	@RequestMapping(value="/selectFinishTaskPageTable")
	@ResponseBody
	public AjaxRes selectFinishTaskPageTable(@RequestBody PageTable pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = finishTaskService.selectFinishNodeTaskTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 退回分页查询已完成任务列表
	 */
	@RequestMapping(value="/selectBackFinishTaskPageTable")
	@ResponseBody
	public AjaxRes selectBackFinishTaskPageTable(@RequestBody PageTable pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryBackConditionSql(pageTable));
		try {
			pageTable = finishTaskService.selectFinishNodeTaskTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页查询已完成任务列表
	 */
	@RequestMapping(value="/selectFinishTaskGroupTable")
	@ResponseBody
	public AjaxRes selectFinishTaskGroupTable(@RequestBody PageTable<Gbpm_finishTask> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = finishTaskService.selectFinishTaskGroupTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Gbpm_finishTask> pageTable){
		StringBuffer wheresql = new StringBuffer();
		if (pageTable.getWheresql() != null) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and finishTask.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		wheresql.append(" and handleUserID = \'"+SystemSession.getUserSession().getUser_uid()+"\'");
		wheresql.append(" and taskStatus = \'"+ "已完成" +"\'");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and productName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryBackConditionSql(PageTable<Gbpm_finishTask> pageTable){
		StringBuffer wheresql = new StringBuffer();
		if (pageTable.getWheresql() != null) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and finishTask.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		wheresql.append(" and taskStatus = \'"+ "已完成" +"\'");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and productName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();
	}
	
}
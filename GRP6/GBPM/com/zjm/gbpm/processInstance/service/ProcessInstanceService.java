package com.zjm.gbpm.processInstance.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Act_ProcessInstance;
import com.zjm.gbpm.db.model.Act_nextTask;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;

public interface ProcessInstanceService {
	/**
	 * 流程实例 活动中 分页列表
	 * @param pageTable
	 * @param userSession 
	 * @return
	 */
	public PageTable selectProcessInstanceExecutionPageTable(PageTable pageTable, User userSession);
	/**
	 * 流程实例 已完成 分页列表
	 * @param pageTable
	 * @param userSession 
	 * @return
	 */
	public PageTable selectProcessInstanceHistoryPageTable(PageTable pageTable, User userSession);
	/**
	 * 待签收 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessTaskSignPageTable(PageTable pageTable);
	/**
	 * 待办签收
	 * @return
	 */
	public Boolean createProcessTaskSign(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 已办 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessTaskHistoryTaskPageTable(PageTable pageTable, User userSession);
	/**
	 * 办理完成
	 * @return
	 */
	public Boolean createProcessTaskTaskFinish(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 任务委托
	 * @return
	 */
	public Boolean createProcessTaskTaskEntrusted(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 任务挂起/暂停
	 * @return
	 */
	public Boolean suspendProcessInstance(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 任务激活
	 * @return
	 */
	public Boolean activateProcessInstance(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 变更办理人
	 * @return
	 */
	public Boolean updateProcessTaskTaskAssignee(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 提前中止流程实例
	 * @return
	 */
	public Boolean stopProcessInstance(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 删除流程实例
	 * @return
	 */
	public Boolean deleteProcessInstance(Act_ProcessInstance processInstance, User userSession);
	
	/**
	 * 流程流转图
	 * @param processInstance
	 * @param userSession
	 */
	public InputStream selectProcessDiagram(Act_ProcessInstance processInstance, User userSession);
	/**
	 * 流程跟踪图
	 * @return  封装了各种节点信息
	 * @throws Exception 
	 */
	public List<Map<String, Object>> selectProcessTrace(String processInstanceID, User userSession) throws Exception;
	
	/**
	 * 根据当前办理任务的id获取下步任务信息集合
	 * @param taskID
	 * @return
	 */
	public List<Act_nextTask> selectNextTaskList(String taskID);
	/**
	 * 根据任务id查询一个任务上配置的任务事项
	 * @param taskID
	 * @param userSession 
	 * @return
	 */
	public List<Gbpm_dicTaskManager> selectOneTaskFormItemList(String taskID, User userSession);
	/**
	 * 根据当前办理任务的id获取历史任务信息集合
	 * @param taskID
	 * @return
	 */
	public List<Act_nextTask> selectHisTaskList(String taskID);

}

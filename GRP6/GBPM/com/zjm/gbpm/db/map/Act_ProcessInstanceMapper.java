package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Act_ProcessInstance;

public interface Act_ProcessInstanceMapper {
	/**
	 * 流程实例 流转中  分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Act_ProcessInstance> selectProcessInstanceExecutionPageTable(PageTable pageTable);
	/**
	 * 流程实例 流转中 分页列表 总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectProcessInstanceExecutionPageTable_Count(PageTable pageTable);
	
	/**
	 * 流程实例 已完成  分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Act_ProcessInstance> selectProcessInstanceHistoryPageTable(PageTable pageTable);
	/**
	 * 流程实例 已完成 分页列表 总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectProcessInstanceHistoryPageTable_Count(PageTable pageTable);
	/**
	 * 流程任务 流转中  分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Act_ProcessInstance> selectProcessTaskExecutionPageTable(PageTable pageTable);
	/**
	 * 流程任务 流转中 分页列表 总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectProcessTaskExecutionPageTable_Count(PageTable pageTable);
	
	/**
	 * 插入一个流程实例与业务对应关系信息
	 * @param pi
	 * @return
	 */
	public Integer insertOneProInstanceEntityInfo(com.zjm.gbpm.db.model.Act_ProcessInstance pi);
	/**
	 * 流程任务 已办 分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Act_ProcessInstance> selectProcessTaskHistoryTaskPageTable(PageTable pageTable);
	/**
	 * 流程任务 已办 分页列表  总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectProcessTaskHistoryTaskPageTable_Count(PageTable pageTable);
	/**
	 * 更新一个流程实例与业务对应关系信息
	 * @param processInstance
	 * @return
	 */
	public Integer updateOneProInstanceEntityInfo(Act_ProcessInstance processInstance);
	/**
	 * 删除一个流程实例与业务对应关系信息
	 * @return
	 */
	public Integer deleteOneProInstanceEntityInfo(Act_ProcessInstance processInstance);
	/**
	 * 根据任务id查询一个任务上配置的任务事项
	 * @param taskID
	 * @return
	 */
	public String selectOneTaskFormItemInfo(String taskID);
	
}

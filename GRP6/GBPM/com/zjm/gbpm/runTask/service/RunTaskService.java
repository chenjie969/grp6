package com.zjm.gbpm.runTask.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_runTask;

/**
 * 
 * @author zky
 * 运行中节点任务事项service
 */

public interface RunTaskService {

	/**
	 *  根据输入条件查询运行中任务；
	 * @param WhereSql
	 * 实例ID，
	 * @return Gbpm_runTask
	 */                   
	public Gbpm_runTask   selectOneRunTaskByWhereSql(String whereSql);

	/**
	 * 新增一个运行中任务
	 * @param runTask
	 */
	public Boolean insertOneRunTaskInfo(User user,Gbpm_runTask runTask);
	
	/**
	 * 根据节点id获取任务事项
	 * @param pageTable
	 * 运行中节点id
	 * @return
	 */
	public PageTable  selectRunningNodeTaskTable(PageTable pageTable);
	/**
	 * 更新运行中任务信息
	 * @param user
	 * @param runTask
	 * @return
	 */
    public Boolean updateOneRunTaskInfo(User user,Gbpm_runTask runTask);

	/**
	 * 根据wheresql获取任务事项
	 */
	public List<Gbpm_runTask> selectRunTaskListByWhereSql(String wheresql);

	/**
	 * 根据wheresql删除运行中任务
	 * @param wheresql
	 */
	public void deleteRunTaskByWheresql(User user,String wheresql);

	/**
	 * 按环节分组获取任务事项
	 * @param pageTable
	 * @return
	 */
	public PageTable<Gbpm_runTask> selectRunTaskGroupTable(PageTable<Gbpm_runTask> pageTable);

	public Long selectRunTaskGroupTable_count(PageTable<Gbpm_runTask> pageTable);

	/**
	 * 修改任务执行人
	 */
	public Boolean changeHandleUser(User userSession, Gbpm_runTask runTask);

	/**
	 * 查询前置任务是否完成
	 * @param whereSql
	 * @return
	 */
	public Boolean selectBeforeTaskNoFinish(String whereSql);
	
}

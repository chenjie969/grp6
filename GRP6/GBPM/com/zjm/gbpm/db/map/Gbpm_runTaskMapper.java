package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_runTask;

public interface Gbpm_runTaskMapper {
	
	/**
	 *  根据输入条件查询运行中；
	 * @param WhereSql
	 * 实例ID
	 * @return Gbpm_runTask
	 */
	public Gbpm_runTask selectOneRunTaskByWhereSql(String  whereSql);

	/**
	 * 新增一个运行中
	 * @param runTask
	 * @return
	 */
	public Integer insertOneRunTaskInfo(Gbpm_runTask runTask);
	/**
	 * 根据运行中id获取任务事项
	 * @param pageTable
	 * @return
	 */
	public List<Gbpm_runTask> selectRunningNodeTaskTable(PageTable pageTable);
	/**
	 * 按环节分组获取任务事项
	 * @param pageTable
	 * @return
	 */
	public List<Gbpm_runTask> selectRunTaskGroupTable(PageTable pageTable);
	/**
	 * 按环节分组获取任务事项总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectRunTaskGroupTable_count(PageTable pageTable);
	/**
	 *  根据运行中id获取任务事项记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectRunningNodeTaskTable_count(PageTable pageTable);
    /**
     * 更新运行中任务事项信息
     * @param runTask
     * @return
     */
	public Integer updateOneRunTaskInfo(Gbpm_runTask runTask);

	/**
	 *  根据输入条件查询运行中任务；
	 * @param WhereSql
	 */
	public List<Gbpm_runTask> selectRunTaskListByWhereSql(String whereSql);

	/**
	 * 根据wheresql删除运行中任务
	 * @param wheresql
	 */
	public void deleteRunTaskByWheresql(String wheresql);

	/**
	 * 根据wheresql查询前置任务是否完成
	 * @param whereSql
	 * @return
	 */
	public Long selectBeforeTaskNoFinish(String whereSql);

	
	
}

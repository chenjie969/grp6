package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_finishNode;
import com.zjm.gbpm.db.model.Gbpm_finishTask;

public interface Gbpm_finishTaskMapper {
	
	/**
	 * 根据运行中节点id获取已完成节点任务事项
	 * @param pageTable
	 * @return
	 */
	public List<Gbpm_finishTask> selectFinishNodeTaskTable(PageTable pageTable);
	
	/**
	 *  根据运行中节点id获取已完成节点任务事项记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectfinishNodeTaskTable_count(PageTable pageTable);
	
	/**
    * 新增已完成任务事项
    */
	public int insertOneFinishTaskInfo(Gbpm_finishTask finishTask);

	public Gbpm_finishTask selectOneFinishTaskByWhereSql(String whereSql);

	public Integer updateOneFinishTaskInfo(Gbpm_finishTask oneFinishTask);

	public List<Gbpm_finishTask> selectFinishTaskListByWhereSql(String whereSql);

	public List<Gbpm_finishTask> selectFinishTaskGroupTable(PageTable<Gbpm_finishTask> pageTable);

	public Long selectFinishTaskGroupTable_count(PageTable<Gbpm_finishTask> pageTable);

	public int deleteFinishTaskByWheresql(String wheresql);
	
}

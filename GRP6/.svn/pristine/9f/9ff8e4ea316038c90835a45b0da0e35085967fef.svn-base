package com.zjm.gbpm.finishTask.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_finishTask;

/**
 * 
 * @author zky
 * 已完成节点任务事项service
 */

public interface FinishTaskService {
	
	/**
	 * 根据已完成任务事项id获取已完成节点任务；
	 * @param pageTable
	 * @return
	 */
	public PageTable selectFinishNodeTaskTable(PageTable pageTable);
	

	
	public void insertOneFinishTaskInfo(User user, Gbpm_finishTask finishTask);

	/**
	 * 根据wheresql获取已完成任务；
	 * @param pageTable
	 * @return
	 */

	public Gbpm_finishTask selectOneFinishTaskByWhereSql(String string);

   
	public Integer updateOneFinishTaskInfo(User user,Gbpm_finishTask oneFinishTask);

	/**
	 * 根据wheresql获取已完成任务List；
	 * @return
	 */
	public List<Gbpm_finishTask> selectFinishTaskListByWhereSql(String wheresql);

	/**
	 * 按环节分组获取已完成节点任务；
	 * @param pageTable
	 * @return
	 */
	public PageTable<Gbpm_finishTask> selectFinishTaskGroupTable(PageTable<Gbpm_finishTask> pageTable);

	/**
	 * 根据wheresql删除已完成任务；
	 * @return
	 */
	public Boolean deleteFinishTaskByWheresql(User user, String wheresql);


	


	


	

}

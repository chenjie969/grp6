package com.zjm.gbpm.runTask.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_runTaskMapper;
import com.zjm.gbpm.db.model.Gbpm_finishTask;
import com.zjm.gbpm.db.model.Gbpm_runTask;
import com.zjm.gbpm.finishTask.service.FinishTaskService;
import com.zjm.gbpm.runTask.service.RunTaskService;
import com.zjm.util.Tool;
@Service("runTaskService")
@Transactional
public class RunTaskServiceImpl implements RunTaskService {
	@Resource
	private Gbpm_runTaskMapper runTaskMapper;
	@Resource
	private LogService logService;
	@Resource
	private FinishTaskService finishTaskService;
	
	/**
	 * 根据运行中任务事项id获取正在运行任务任务；
	 */
	public PageTable selectRunningNodeTaskTable(PageTable pageTable) {
		List<Gbpm_runTask> runTaskList =  new ArrayList<>();
		Long count = 0l;
		try {
			runTaskList = runTaskMapper.selectRunningNodeTaskTable(pageTable);
			count = runTaskMapper.selectRunningNodeTaskTable_count(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pageTable.setRows(runTaskList);
		pageTable.setTotal(count);
		return pageTable;
	}
	
	/**
	 * 按环节分组获取运行中任务事项
	 */
	public PageTable selectRunTaskGroupTable(PageTable pageTable) {
		List<Gbpm_runTask> runTaskList =  new ArrayList<>();
		Long count = 0l;
		try {
			runTaskList = runTaskMapper.selectRunTaskGroupTable(pageTable);
			count = runTaskMapper.selectRunTaskGroupTable_count(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pageTable.setRows(runTaskList);
		pageTable.setTotal(count);
		return pageTable;
	}
 
	/**
	 *  根据输入条件查询运行中任务；
	 * @param WhereSql
	 * 实例ID
	 * @return Gbpm_runTask
	 */
	public Gbpm_runTask selectOneRunTaskByWhereSql(String whereSql) {
		Gbpm_runTask oneRunTask = runTaskMapper.selectOneRunTaskByWhereSql(whereSql);
		return oneRunTask;
	}
	
	
	/**
	 *  根据输入条件查询运行中任务；
	 * @param WhereSql
	 * 实例ID
	 */
	public List<Gbpm_runTask> selectRunTaskListByWhereSql(String whereSql) {
		List<Gbpm_runTask> runTaskList = runTaskMapper.selectRunTaskListByWhereSql(whereSql);
		return runTaskList;
	}
	
 


	/**
	 * 新增一个运行中任务
	 * @param runTask
	 * @return
	 */
	public Boolean insertOneRunTaskInfo(User userSession,Gbpm_runTask runTask) {
//		runTask.setRunTask_ID(Tool.createUUID32());
		runTask.setUnit_uid(userSession.getUnit_uid());
		runTask.setUnit_uidName(userSession.getUnit_uidName());
		runTask.setUpdateUserName(userSession.getUser_name());
		runTask.setAssignUserID(userSession.getUser_uid());
		runTask.setAssignUserName(userSession.getUser_name());
		if (runTaskMapper.insertOneRunTaskInfo(runTask)==1) {
			logService.insertOneOperatorLogInfo(userSession,"运行中任务", "新增", "新增运行中任务"+runTask.getRunTask_ID());
			return true;
		}
		return false;
	}

	public Boolean updateOneRunTaskInfo(User user, Gbpm_runTask runTask) {
		Gbpm_runTask oneRunTask = runTaskMapper.selectOneRunTaskByWhereSql(" and runTask_ID = \'"+runTask.getRunTask_ID()+"\'");
		Gbpm_finishTask oneFinishTask = finishTaskService.selectOneFinishTaskByWhereSql(" and finishTask_ID = \'"+runTask.getRunTask_ID()+"\'");
		oneRunTask.setTaskStatus(runTask.getTaskStatus());//设置任务状态;
		oneRunTask.setHandleDateTime(runTask.getHandleDateTime());//设置处理时间
		oneRunTask.setHandleUserID(runTask.getHandleUserID());
		oneRunTask.setHandleUserName(runTask.getHandleUserName());
		oneFinishTask.setTaskStatus(runTask.getTaskStatus());//设置任务状态;
		oneFinishTask.setHandleDateTime(runTask.getHandleDateTime());//设置处理时间
		oneFinishTask.setHandleUserID(runTask.getHandleUserID());
		oneFinishTask.setHandleUserName(runTask.getHandleUserName());
		Integer rusultInt = null;
		try {
			rusultInt = runTaskMapper.updateOneRunTaskInfo(oneRunTask);
			finishTaskService.updateOneFinishTaskInfo(user, oneFinishTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(1 == rusultInt){
			logService.insertOneOperatorLogInfo(user,"运行中任务", "修改", "修改运行中任务"+runTask.getRunTask_ID());
			return true;
		}return false;
		
	}

	/**
	 * 根据wheresql删除运行中任务
	 * @param wheresql
	 */
	@Override
	public void deleteRunTaskByWheresql(User user,String wheresql) {
		runTaskMapper.deleteRunTaskByWheresql(wheresql);
		logService.insertOneOperatorLogInfo(user,"运行中任务", "删除", "删除运行中任务");
	}

	@Override
	public Long selectRunTaskGroupTable_count(PageTable<Gbpm_runTask> pageTable) {
		return runTaskMapper.selectRunTaskGroupTable_count(pageTable);
	}

	/**
	 * 修改任务实现办理人
	 */
	@Override
	public Boolean changeHandleUser(User user, Gbpm_runTask runTask) {
		Gbpm_runTask oneRunTask = runTaskMapper.selectOneRunTaskByWhereSql(" and runTask_ID = \'"+runTask.getRunTask_ID()+"\'");
		Gbpm_finishTask oneFinishTask = finishTaskService.selectOneFinishTaskByWhereSql(" and finishTask_ID = \'"+runTask.getRunTask_ID()+"\'");
		oneRunTask.setHandleUserID(runTask.getHandleUserID());//设置操作者ID
		oneRunTask.setHandleUserName(runTask.getHandleUserName());//设置操作者Name
		oneFinishTask.setHandleUserID(runTask.getHandleUserID());//设置操作者ID
		oneFinishTask.setHandleUserName(runTask.getHandleUserName());//设置操作者Name
		Integer rusultInt = null;
		try {
			rusultInt = runTaskMapper.updateOneRunTaskInfo(oneRunTask);
			finishTaskService.updateOneFinishTaskInfo(user, oneFinishTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(1 == rusultInt){
			logService.insertOneOperatorLogInfo(user,"运行中任务", "修改", "修改运行中任务"+runTask.getRunTask_ID());
			return true;
		}
		return false;
	}

	@Override
	public Boolean selectBeforeTaskNoFinish(String whereSql) {
		return (runTaskMapper.selectBeforeTaskNoFinish(whereSql) > 0);
	}
	
	
}

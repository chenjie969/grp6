package com.zjm.gbpm.taskTypeTask.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_taskTypeTaskMapper;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.db.model.Gbpm_taskTypeTask;
import com.zjm.gbpm.taskTypeTask.service.TaskTypeTaskService;


@Service("taskTypeTaskService")
@Transactional
public class TaskTypeTaskServiceImpl implements TaskTypeTaskService{

	@Resource
	private Gbpm_taskTypeTaskMapper gbpm_taskTypeTaskMapper;
	@Resource
	private LogService logService;
	/**
	 * 新增一条任务实现类型和任务对应信息
	 */
	@Override
	public Boolean insertTaskTypeTaskInfo(User user, Gbpm_taskTypeTask gbpm_taskTypeTask) {
		if(gbpm_taskTypeTaskMapper.insertTaskTypeTaskInfo(gbpm_taskTypeTask)>0){
//			logService.insertOneOperatorLogInfo(user, "任务事项与类型对应表", "添加", "添加任务事项与类型对应关系");
			return true;
		};
		return false;
	}
	/**
	 * 删除一条任务实现类型和任务对应信息
	 */
	@Override
	public Boolean deleteOneTaskTypeTask(User user, Gbpm_dicTaskManager taskManager) {
		String wheresql = " and taskManager_ID = \'" + taskManager.getTaskManager_ID() + "\'";
		if(gbpm_taskTypeTaskMapper.deleteOneTaskTypeTask(wheresql)>0){
//			logService.insertOneOperatorLogInfo(user, "任务事项与类型对应表", "删除", "删除任务事项与类型对应关系");
			return true;
		};
		return false;
	}
	/**
	 * 修改一条任务实现类型和任务对应信息
	 */
	@Override
	public Boolean updateOneTaskManager(User user, Gbpm_taskTypeTask gbpm_taskTypeTask) {
		if(gbpm_taskTypeTaskMapper.updateOneTaskManager(gbpm_taskTypeTask)>0){
//			logService.insertOneOperatorLogInfo(user, "任务事项与类型对应表", "修改", "修改任务事项与类型对应关系");
			return true;
		};
		return false;
	}
	
}
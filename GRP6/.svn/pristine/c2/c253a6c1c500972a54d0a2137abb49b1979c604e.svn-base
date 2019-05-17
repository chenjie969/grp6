package com.zjm.gbpm.dicTaskManager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_dicTaskManagerMapper;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.db.model.Gbpm_taskTypeTask;
import com.zjm.gbpm.dicTaskManager.service.DicTaskManagerService;
import com.zjm.gbpm.finishTask.service.FinishTaskService;
import com.zjm.gbpm.nodeTask.service.NodeTaskService;
import com.zjm.gbpm.runTask.service.RunTaskService;
import com.zjm.gbpm.taskTypeTask.service.TaskTypeTaskService;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.Tool;

@Service("dicTaskManagerService")
@Transactional
public class DicTaskManagerServiceImpl implements DicTaskManagerService {

	@Resource
	private Gbpm_dicTaskManagerMapper dicTaskManagerMapper;
	@Resource
	private LogService logService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private TaskTypeTaskService taskTypeTaskService;
	@Resource
	private NodeTaskService nodeTaskService;
	@Resource
	private RunTaskService runTaskService;
	@Resource
	private FinishTaskService finishTaskService;
	
	/**
	 * 分页查询任务事项管理列表
	 */
	@Override
	public PageTable<Gbpm_dicTaskManager> selectTaskManagerPageTable(PageTable<Gbpm_dicTaskManager> pageTable) {
		List<Gbpm_dicTaskManager> taskManagerList = dicTaskManagerMapper.selectTaskManagerPageTable(pageTable);
		pageTable.setRows(taskManagerList);
		Long taskManagerTotal = dicTaskManagerMapper.selectTaskManagerPageTable_Count(pageTable);
		pageTable.setTotal(taskManagerTotal);
		return pageTable;
	}
	
	/**
	 *  查询一条任务事项管理
	 */
	@Override
	public Gbpm_dicTaskManager selectOneTaskManager(Gbpm_dicTaskManager taskManager) {
		taskManager = dicTaskManagerMapper.selectOneTaskManager(taskManager);
		return taskManager;
	}
	
	/**
	 *  插入一条任务事项管理
	 */
	@Override
	public Boolean insertOneTaskManager(User user,Gbpm_dicTaskManager taskManager) {
		taskManager.setTaskUrl(Tool.formatString(taskManager.getTaskUrl()));
		taskManager.setViewTaskUrl(Tool.formatString(taskManager.getViewTaskUrl()));
		taskManager.setTaskManager_ID(Tool.createUUID32());
		taskManager.setUnit_uid(user.getUnit_uid());
		taskManager.setUnit_uidName(user.getUnit_uidName());
		taskManager.setUpdate_user(user.getUser_name());
		if(dicTaskManagerMapper.insertOneTaskManager(taskManager)==1){
			logService.insertOneOperatorLogInfo(user, "任务事项管理", "添加", "添加"+taskManager.getTaskName());
			//添加任务事项和任务事项类型对应关系
			if (taskManager.getTaskType_ID()!=null) {
				Gbpm_taskTypeTask gbpm_taskTypeTask = new Gbpm_taskTypeTask();
				gbpm_taskTypeTask.setTaskManager_ID(taskManager.getTaskManager_ID());
				gbpm_taskTypeTask.setTaskType_ID(taskManager.getTaskType_ID());
				taskTypeTaskService.insertTaskTypeTaskInfo(user,gbpm_taskTypeTask);
			}
			
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条任务事项管理
	 */
	@Override
	public Boolean updateOneTaskManager(User user,Gbpm_dicTaskManager taskManager) {
		taskManager.setUpdate_user(user.getUser_name());
		if (taskManager.getTaskType_ID()!=null && taskManager.getTaskType_ID()!="") {
			Gbpm_taskTypeTask gbpm_taskTypeTask = new Gbpm_taskTypeTask();
			gbpm_taskTypeTask.setTaskManager_ID(taskManager.getTaskManager_ID());
			gbpm_taskTypeTask.setTaskType_ID(taskManager.getTaskType_ID());
			taskTypeTaskService.updateOneTaskManager(user,gbpm_taskTypeTask);
		}
		
		if(dicTaskManagerMapper.updateOneTaskManager(taskManager)==1){
			logService.insertOneOperatorLogInfo(user, "任务事项管理", "修改","修改"+taskManager.getTaskName());
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条任务事项管理
	 */
	@Override
	public Boolean deleteOneTaskManager(User user,Gbpm_dicTaskManager taskManager) {
		taskManager = selectOneTaskManager(taskManager);
		//先删除任务事项与类型对应关系表
		taskTypeTaskService.deleteOneTaskTypeTask(user,taskManager);
		if(dicTaskManagerMapper.deleteOneTaskManager(taskManager)==1){
			/**
			 * 删除节点任务对应表数据
			 */
			String wheresql = " and unit_uid = \'" + user.getUnit_uid() +"\'";
			wheresql = wheresql + " and taskMangerID = \'" + taskManager.getTaskManager_ID() + "\'";
			nodeTaskService.deleteNodeTaskByWheresql(user, wheresql);
			/**
			 * 删除运行中任务事项
			 */
			runTaskService.deleteRunTaskByWheresql(user, wheresql);
			/**
			 * 删除已完成任务事项
			 */
			finishTaskService.deleteFinishTaskByWheresql(user, wheresql);
			/**
			 * 删除任务事项与任务实现对应表数据
			 */
			taskTypeTaskService.deleteOneTaskTypeTask(user, taskManager);
			
			logService.insertOneOperatorLogInfo(user, "任务事项管理", "删除", "删除"+taskManager.getTaskName());
			return true;
		}else
			return false;
	}

	/**
	 *  判断任务事项名称是否已存在
	 */
	@Override
	public Boolean isExistTaskName(Gbpm_dicTaskManager taskManager) {
		if(dicTaskManagerMapper.isExistTaskName(taskManager) == 0)
			return true;
		else
			return false;
	}
	
	/**
	 *  判断任务事项编号是否已存在
	 */
	@Override
	public Boolean isExistTaskCode(Gbpm_dicTaskManager taskManager) {
		if(dicTaskManagerMapper.isExistTaskCode(taskManager) == 0)
			return true;
		else
			return false;
	}

	/**
	 *  查询任务事项List
	 */
	public List<Gbpm_dicTaskManager> selectTaskManagerList(String wheresql,User userSession) {
		wheresql=wheresql+" and taskType.unit_uid=\'"+userSession.getUnit_uid()+"\'";
		return dicTaskManagerMapper.selectTaskManagerList(wheresql);
	}
}

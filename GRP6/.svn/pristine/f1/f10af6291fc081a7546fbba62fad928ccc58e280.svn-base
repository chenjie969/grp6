package com.zjm.gbpm.finishTask.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_finishTaskMapper;
import com.zjm.gbpm.db.model.Gbpm_finishTask;
import com.zjm.gbpm.finishTask.service.FinishTaskService;
@Service("finishTaskService")
@Transactional
public class FinishTaskServiceImpl implements FinishTaskService {
	@Resource
	private Gbpm_finishTaskMapper finishTaskMapper;
	@Resource
	private LogService logService;
	
	/**
     * 根据wheresql获取已完成任务;
     */
	public PageTable selectFinishNodeTaskTable(PageTable pageTable) {
		List<Gbpm_finishTask> finishTaskList =  new ArrayList<>();
		Long count = 0l;
		try {
			finishTaskList = finishTaskMapper.selectFinishNodeTaskTable(pageTable);
			count = finishTaskMapper.selectfinishNodeTaskTable_count(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageTable.setRows(finishTaskList);
		pageTable.setTotal(count);
		return pageTable;
	}
	
	/**
     * 新增已完成任务事项
     */
	@Override
	public void insertOneFinishTaskInfo(User user, Gbpm_finishTask finishTask) {
		finishTask.setUnit_uid(user.getUnit_uid());
		finishTask.setUnit_uidName(user.getUnit_uidName());
		finishTask.setUpdateUserName(user.getUser_name());
		if (finishTaskMapper.insertOneFinishTaskInfo(finishTask)==1) {
			logService.insertOneOperatorLogInfo(user,"已完成任务", "新增", "新增已完成任务"+finishTask.getFinishTask_ID());
		}
	}

	/**
	 *  根据输入条件查询已完成任务；
	 * @param WhereSql
	 * 实例ID
	 * @return Gbpm_runTask
	 */
	public Gbpm_finishTask selectOneFinishTaskByWhereSql(String whereSql) {
		Gbpm_finishTask oneRunTask = finishTaskMapper.selectOneFinishTaskByWhereSql(whereSql);
		return oneRunTask;
	}

	@Override
	public Integer updateOneFinishTaskInfo(User user,Gbpm_finishTask oneFinishTask) {
		Integer rusultInt = finishTaskMapper.updateOneFinishTaskInfo(oneFinishTask);
		if(1 == rusultInt){
			logService.insertOneOperatorLogInfo(user,"已完成任务", "修改", "修改已完成任务"+oneFinishTask.getFinishTask_ID());
		}
		return rusultInt;
	}
	
	/**
	 *  根据输入条件查询运行中任务；
	 * @param WhereSql
	 * 实例ID
	 */
	public List<Gbpm_finishTask> selectFinishTaskListByWhereSql(String whereSql) {
		List<Gbpm_finishTask> finishTaskList = finishTaskMapper.selectFinishTaskListByWhereSql(whereSql);
		return finishTaskList;
	}

	@Override
	public PageTable<Gbpm_finishTask> selectFinishTaskGroupTable(PageTable<Gbpm_finishTask> pageTable) {
		List<Gbpm_finishTask> finishTaskList =  new ArrayList<>();
		Long count = 0l;
		try {
			finishTaskList = finishTaskMapper.selectFinishTaskGroupTable(pageTable);
			count = finishTaskMapper.selectFinishTaskGroupTable_count(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageTable.setRows(finishTaskList);
		pageTable.setTotal(count);
		return pageTable;
	}

	/**
	 * 根据wheresql删除已完成任务；
	 * @return
	 */
	@Override
	public Boolean deleteFinishTaskByWheresql(User user, String wheresql) {
		if (finishTaskMapper.deleteFinishTaskByWheresql(wheresql) > 0) {
			logService.insertOneOperatorLogInfo(user,"运行中任务", "删除", "删除运行中任务");
			return true;
		};
		
		return false;
		
	}

	

}

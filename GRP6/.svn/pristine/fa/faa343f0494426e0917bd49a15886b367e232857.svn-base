package com.zjm.gbpm.dicTaskManager.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;

public interface DicTaskManagerService {

	/**
	 * 分页查询任务事项管理列表
	 */
	public PageTable<Gbpm_dicTaskManager> selectTaskManagerPageTable(PageTable<Gbpm_dicTaskManager> pageTable);
	
	/**
	 *  查询一条任务事项管理
	 */
	public Gbpm_dicTaskManager selectOneTaskManager(Gbpm_dicTaskManager taskManager);
	
	/**
	 *  插入一条任务事项管理
	 */
	public Boolean insertOneTaskManager(User user,Gbpm_dicTaskManager taskManager);
	
	/**
	 *  修改一条任务事项管理
	 */
	public Boolean updateOneTaskManager(User user,Gbpm_dicTaskManager taskManager);
	
	/**
	 *  删除一条任务事项管理
	 */
	public Boolean deleteOneTaskManager(User user,Gbpm_dicTaskManager taskManager);
	
	/**
	 *  判断任务事项名称是否已存在
	 */
	public Boolean isExistTaskName(Gbpm_dicTaskManager taskManager);
	
	/**
	 *  判断任务事项编号是否已存在
	 */
	public Boolean isExistTaskCode(Gbpm_dicTaskManager taskManager);
	/**
	 *  查询任务事项List   mashuo add 20170803
	 */
	public List<Gbpm_dicTaskManager> selectTaskManagerList(String wheresql,User userSession);
}

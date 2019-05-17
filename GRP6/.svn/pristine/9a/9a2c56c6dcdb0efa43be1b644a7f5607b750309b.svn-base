package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;

public interface Gbpm_dicTaskManagerMapper {

	/**
	 * 分页查询任务事项管理列表
	 */
	public List<Gbpm_dicTaskManager> selectTaskManagerPageTable(PageTable<Gbpm_dicTaskManager> pageTable);
	
	/**
	 * 分页查询任务事项管理列表-查询总记录数
	 */
	public Long selectTaskManagerPageTable_Count(PageTable<Gbpm_dicTaskManager> pageTable);
	
	/**
	 *  查询一条任务事项管理
	 */
	public Gbpm_dicTaskManager selectOneTaskManager(Gbpm_dicTaskManager taskManager);
	
	/**
	 *  插入一条任务事项管理
	 */
	public Integer insertOneTaskManager(Gbpm_dicTaskManager taskManager);
	
	/**
	 *  修改一条任务事项管理
	 */
	public Integer updateOneTaskManager(Gbpm_dicTaskManager taskManager);
	
	/**
	 *  删除一条任务事项管理
	 */
	public Integer deleteOneTaskManager(Gbpm_dicTaskManager taskManager);
	
	/**
	 *  判断任务事项名称是否已存在
	 */
	public Integer isExistTaskName(Gbpm_dicTaskManager taskManager);
	
	/**
	 *  判断任务事项编号是否已存在
	 */
	public Integer isExistTaskCode(Gbpm_dicTaskManager taskManager);
	/**
	 *  查询任务事项List   mashuo add 20170803
	 */
	public List<Gbpm_dicTaskManager> selectTaskManagerList(String wheresql);
	
}

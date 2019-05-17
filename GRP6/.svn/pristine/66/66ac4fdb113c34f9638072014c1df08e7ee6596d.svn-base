package com.zjm.gbpm.taskType.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_taskType;

public interface TaskTypeService{

	/**
	 * 查询所有任务事项
	 * @param string
	 * @return
	 */
	public List<Gbpm_taskType> selectAllTaskTypeList(String string);

	/**
	 * 添加时判断任务事项类型是否重复
	 * @return
	 */
	public Boolean selectTaskTypeIsExist(String wheresql);

	/**
	 * 插入一个任务事项类型
	 * @return
	 */
	public Boolean insertOneTaskType(User userSession, Gbpm_taskType gbpm_taskType);

	/**
	 * 删除一个任务事项类型
	 * @return
	 */
	public Boolean deleteOneTaskTypeInfo(User userSession, Gbpm_taskType gbpm_taskType);

	/**
	 * 更新一个任务事项类型
	 * @return
	 */
	public Boolean updateOneTaskType(User userSession, Gbpm_taskType gbpm_taskType);


}
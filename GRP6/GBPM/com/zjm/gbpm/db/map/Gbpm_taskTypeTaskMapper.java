package com.zjm.gbpm.db.map;

import com.zjm.gbpm.db.model.Gbpm_taskTypeTask;

public interface Gbpm_taskTypeTaskMapper {

	public int insertTaskTypeTaskInfo(Gbpm_taskTypeTask gbpm_taskTypeTask);

	public int deleteOneTaskTypeTask(String wheresql);

	public int updateOneTaskManager(Gbpm_taskTypeTask gbpm_taskTypeTask);

}
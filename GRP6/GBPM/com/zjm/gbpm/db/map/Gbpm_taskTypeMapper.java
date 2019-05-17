package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.gbpm.db.model.Gbpm_taskType;

public interface Gbpm_taskTypeMapper {

	public List<Gbpm_taskType> selectTaskTypeList(String wheresql);

	public int selectTaskTypeIsExist(String wheresql);

	public Integer selectTaskTypeOrderId(Gbpm_taskType gbpm_taskType);

	public Gbpm_taskType selectOneTaskTypeByWheresql(String wheresql);

	public int insertOneTaskTypeInfo(Gbpm_taskType gbpm_taskType);

	public int deleteOneTaskTypeInfo(String wheresql);

	public int updateOneTaskTypeInfo(Gbpm_taskType gbpm_taskType);

}
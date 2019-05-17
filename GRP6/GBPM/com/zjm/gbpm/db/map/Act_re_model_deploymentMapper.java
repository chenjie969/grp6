package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.gbpm.db.model.Act_re_model_deployment;

public interface Act_re_model_deploymentMapper {
	/***
	 * 插入一个activiti模型与部署关系信息 
	 * @param modelActSort
	 * @return
	 */
	public Integer insertOneModelDeploymentInfo(Act_re_model_deployment modelDeployment);
	/**
	 * 查询activiti模型与部署关系List
	 * @param wheresql
	 * @return
	 */
	public List<Act_re_model_deployment> selectModelDeploymentList(String wheresql);
	/**
	 * 删除一个activiti模型与部署关系信息 
	 * @param modelDeployment
	 * @return
	 */
	public Integer delectOneModelDeploymentInfo(Act_re_model_deployment modelDeployment);
	
}

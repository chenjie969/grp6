package com.zjm.gworkFlow.db.map;

import java.util.List;

import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;

/** 
 * @author 作者 mahuo 
 * @version 创建时间：20170914
 * 类说明： 
 */
public interface OsGworkflowFlowtemplateMapper {
	
	/**
	 * 获取所有的流程模板
	 * @param osGworkflowFlowtemplate
	 * @return
	 */
	public List<OsGworkflowFlowtemplate> returnAllFlowtemplateList(OsGworkflowFlowtemplate osGworkflowFlowtemplate);
	
	/**
	 * 取得一个流程模板的对象
	 * @param osGworkflowFlowtemplate
	 * @return
	 */
	public OsGworkflowFlowtemplate getOneGworkflowTemplate(OsGworkflowFlowtemplate osGworkflowFlowtemplate);
	/**
	 * 判断是否已有流程实例 并且尚未结束
	 */
	public Integer stateWorkFlowInstance(OsGworkflowFlowtemplate osGworkflowFlowtemplate);
	/**
	 * 获取所有的流程模板 all
	 * @param osGworkflowFlowtemplate
	 * @return
	 */
	public List<OsGworkflowFlowtemplate> returnAllFlowtemplateListAll(
			OsGworkflowFlowtemplate osGworkflowFlowtemplate);
	/**
	 * 插入一条流程模板记录
	 * @param osGworkflowFlowtemplate2
	 */
	public Integer	insertOneFlowtemplate(
			OsGworkflowFlowtemplate osGworkflowFlowtemplate2);
	/**
	 * 判断是否已有流程实例 
	 * @param os_step
	 * @return
	 */
	public Integer stateWorkFlowStartInstance(
			OsGworkflowFlowtemplate osGworkflowFlowtemplate);
	/**
	 * 获取所有的公文管理流程模板
	 * @return
	 */
	public List<OsGworkflowFlowtemplate> returnAllFlowtemplateListByFlowTypeID(
			OsGworkflowFlowtemplate osGworkflowFlowtemplate);
	
}


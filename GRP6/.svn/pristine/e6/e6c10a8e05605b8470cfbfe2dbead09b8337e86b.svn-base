package com.zjm.gworkFlow.startWorkFlow.service;

import java.util.List;
import java.util.Map;

import com.zjm.gworkFlow.db.model.PendingWorkFlow;
import com.zjm.common.db.model.UrlParam;
import com.zjm.gworkFlow.db.model.FlowRole;
import com.zjm.gworkFlow.db.model.OsGworkflowComponents;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.db.model.OsHistorystep;
import com.zjm.gworkFlow.db.model.Os_action;
import com.zjm.gworkFlow.db.model.Os_step;

/** 
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-19 下午6:51:51 
 * 类说明： 
 */
public interface GworkFlowService {
	
	/**
	 * 创建一个工作流实例     flowType 流程类型   项目 ： project 、公文 : oa     mashuo add 20150505
	 * @param os_step
	 * @param osGworkflowFlowtemplate
	 * @return
	 */
	public Long createworkflowInstance(OsGworkflowFlowtemplate osGworkflowFlowtemplate);
	
	/**
	 * 得到下一个步骤上的角色集合，下一个步骤，有可能是普通步骤，分支步骤，动态分支步骤，合并步骤
	 * @param flowid
	 * @param actionid
	 * @param projectid
	 * @return
	 */
	public FlowRole returnNextStepRoles(long flowid, int actionid, String projectid);
	
	/**
	 * 执行某一个流程实例的一个动作
	 * @param flowid
	 * @param actionid
	 * @param projectid
	 * @return
	 */
    public void doAction(long flowid,int actionid,String projectid,Map<String,String> rolemap);
    
    /**
	 * 取得步骤上的所有动作
	 * @param flowID 流程id
	 * @param stepID 步骤id
	 */
 	public List<Os_action> getStepAllActions(Long flowID, Integer stepID);
 	
 	/**
	 * 取得项目的历史步骤
	 * @param flowID
	 * @return
	 */
	public List<OsHistorystep> getStepAllHistoryStep(long flowID);

	/**
	 * 获取步骤上的业务构件
	 * @param view
	 * @return
	 */
	public List<OsGworkflowComponents> getStepAllView(String view);
	/**
	 * 删除一个项目的流程信息
	 * @param view
	 * @return
	 */
	public Boolean delOneProjectFlow(String projectID);
	
	/**
	 * 否决项目
	 * @param projID
	 * @param busiType
	 * @return
	 */
	public Boolean stopProject(UrlParam urlParam);

	/**
	 * 取得步骤上的业务构件
	 * @return
	 */
	public List<OsGworkflowComponents> getStepComponent(Long flowID, Integer stepID);
	
	/**
	 * 获取流程步骤信息
	 * @param pendingWorkFlow
	 * @return
	 */
	public PendingWorkFlow returnWorkFlowStepInfo(Long flowID,Integer stepID);
	/**
	 * 更新指定的待办人员
	 * @return
	 */
	public Boolean updateWaitUserInfo(PendingWorkFlow pendingWorkFlow);
}


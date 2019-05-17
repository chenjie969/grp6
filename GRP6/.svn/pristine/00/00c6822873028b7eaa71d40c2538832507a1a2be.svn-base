package com.zjm.gbpm.productInstance.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_productInstanceMapper;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.db.model.Gbpm_finishNode;
import com.zjm.gbpm.db.model.Gbpm_finishTask;
import com.zjm.gbpm.db.model.Gbpm_nodeTask;
import com.zjm.gbpm.db.model.Gbpm_productInstance;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.db.model.Gbpm_runNode;
import com.zjm.gbpm.db.model.Gbpm_runTask;
import com.zjm.gbpm.dicTaskManager.service.DicTaskManagerService;
import com.zjm.gbpm.finishNode.service.FinishNodeService;
import com.zjm.gbpm.finishTask.service.FinishTaskService;
import com.zjm.gbpm.nodeTask.service.NodeTaskService;
import com.zjm.gbpm.processDefinition.service.ProcessDefinitionService;
import com.zjm.gbpm.product.service.ProductService;
import com.zjm.gbpm.productInstance.service.ProductInstanceService;
import com.zjm.gbpm.productNode.service.ProductNodeService;
import com.zjm.gbpm.runNode.service.RunNodeService;
import com.zjm.gbpm.runTask.service.RunTaskService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_riskScheme;
import com.zjm.pro.riskScheme.serivce.RiskSchemeService;
import com.zjm.pro.riskScheme.web.RiskSchemeAction;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
@Service("productInstanceService")
@Transactional
public class ProductInstanceServiceImpl implements ProductInstanceService {

	@Resource
	private Gbpm_productInstanceMapper productInstanceMapper;
	@Resource
	private LogService logService;
	@Resource
	private RunNodeService runNodeService;
	@Resource
	private FinishNodeService finishNodeService;
	@Resource
	private RunTaskService runTaskService;
	@Resource
	private ProductService productService;
	@Resource
	private ProductNodeService productNodeService;
	@Resource
	private NodeTaskService nodeTaskService;
	@Resource
	private DicTaskManagerService dicTaskManagerService;
	@Resource
	private UsersService usersService;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private FinishTaskService finishTaskService;
	@Resource
	private ProcessDefinitionService processDefinitionService;
	@Resource
	private ApplyDetailService applyDetailService;
	@Resource
	private RiskSchemeService riskSchemeService;
	
	/**
	 *  根据输入条件查询单个产品实例；
	 * @param WhereSql
	 * apply_ID
	 * @return
	 */
	public Gbpm_productInstance selectOneProductInstanceByWhereSql(String whereSql) {
		Gbpm_productInstance productInstance =new Gbpm_productInstance();
		try {
			productInstance = productInstanceMapper.selectOneProductInstanceByWhereSql(whereSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productInstance;
	}

	/**
	 * 新增一个产品流程实例
	 * @param productInstance
	 * @return
	 */
	@Override
	public Boolean insertOneProductInstanceInfo(User userSession, Gbpm_productInstance productInstance) {
		productInstance.setProductInstance_ID(Tool.createUUID32());
		productInstance.setIsReturn(false);
		productInstance.setUnit_uid(userSession.getUnit_uid());
		productInstance.setCreateUserID(userSession.getUser_uid());
		productInstance.setUnit_uidName(userSession.getUnit_uidName());
		productInstance.setCreateUserName(userSession.getUser_name());
		productInstance.setUpdateUserName(userSession.getUser_name());
		productInstance.setProductStatus("运行中");
		//添加产品流程实例化
		productInstanceMapper.insertOneProductInstanceInfo(productInstance);
		
		logService.insertOneOperatorLogInfo(userSession,"流程实例化", "新增", "新增实例化流程"+productInstance.getProductName());
		
		//风险处置模块赋值
		if (productInstance.getEntityType()!=null && productInstance.getEntityType().equals("03")) {
			Pro_riskScheme riskScheme = new Pro_riskScheme();
			riskScheme.setRiskScheme_ID(productInstance.getEntityID());
			riskScheme.setProduct_ID(productInstance.getProductID());
			riskScheme.setProductName(productInstance.getProductName());
			riskScheme.setProductInstance_ID(productInstance.getProductInstance_ID());
			riskScheme.setStatus("审批中");
			riskSchemeService.updateOneRiskSchemeInfo(userSession,riskScheme);
		}
		
		nextStep(userSession,productInstance);
		return true;
	}

	/**
	 * 节点任务处理下一步  实例化下一环节任务事项
	 */
	public void nextStep(User user,Gbpm_productInstance productInstance){
		//根据产品流程ID和节点顺序获取节点的信息
		String wheresql = " and productID = \'" + productInstance.getProductID() + "\'";
		wheresql = wheresql + " and nodeSort = " + (productInstance.getNodeSort() + 1);
		Gbpm_productNode productNode = productNodeService.selectOneProductNodeInfo(wheresql);
		
		//更新项目阶段 项目阶段就是环节
		if (productInstance.getEntityType()!=null && productInstance.getEntityType().equals("03")) {
			Pro_riskScheme riskScheme = new Pro_riskScheme();
			riskScheme.setRiskScheme_ID(productInstance.getEntityID());
			riskScheme.setNodeID(productNode.getNodeID());
			riskScheme.setNodeNames(productNode.getNodeNames());
			riskSchemeService.updateOneRiskSchemeInfo(user,riskScheme);
		}else {
			Pro_apply apply = new Pro_apply();
			apply.setApply_ID(productInstance.getEntityID());
			apply.setProjectStageID(productNode.getNodeID());
			apply.setProjectStageName(productNode.getNodeNames());
			apply.setProductInstance_ID(productInstance.getProductInstance_ID()); //添加流程实例id
			projectApplyService.updateOneApplyInfo(user, apply);
			
		}
		productInstance.setIsReturn(false);
		productInstanceMapper.updateProductInstanceInfo(productInstance);
		
		Map<String,String> handleUserIDMap = new HashMap<>();
		Map<String,String> handleUserNameMap = new HashMap<>();
		//把每个任务事项对应的办理人和办理ID对应放到map里面
		if (productInstance.getHandleUserID()!=null && productInstance.getNodeTaskID()!=null) {
			String[] handleUserIDs = productInstance.getHandleUserID();
			String[] handleUserNames = productInstance.getHandleUserName();
			String[] nodeTaskIDs = productInstance.getNodeTaskID();
			for (int i = 0; i < nodeTaskIDs.length; i++) {
				handleUserIDMap.put(nodeTaskIDs[i], handleUserIDs[i]);
				handleUserNameMap.put(nodeTaskIDs[i], handleUserNames[i]);
			}
		}
		
		//添加产品流程的下一节点为运行中的节点
		Gbpm_runNode runNode = new Gbpm_runNode();
		runNode.setRunNode_ID(productInstance.getProductInstance_ID()+productNode.getNodeSort());
		runNode.setProductInstanceID(productInstance.getProductInstance_ID());
		runNode.setNodeNames(productNode.getNodeNames());
		runNode.setNodeSort(productNode.getNodeSort());
		runNode.setLimitDay(productNode.getLimitDay());
		runNodeService.insertOneRunNodeInfo(SystemSession.getUserSession(),runNode);
		
		//根据产品节点ID获取该节点下所有的任务事项
		wheresql = " and productNodeID = \'" + productNode.getProductNode_ID() + "\'"; 
		if (productInstance.getNodeTaskIDS() != null && !"".equals(productInstance.getNodeTaskIDS())) {
			String[] nodeTaskIDS =  productInstance.getNodeTaskIDS().split(",");
			wheresql = wheresql + " and nodeTask_ID in (";
			for (int i = 0; i < nodeTaskIDS.length; i++) {
				if (i == nodeTaskIDS.length - 1) {
					wheresql = wheresql + "\'" + nodeTaskIDS[i] + "\'";
				}else{
					wheresql = wheresql + "\'" + nodeTaskIDS[i] + "\',";
				}
			}
			wheresql = wheresql + ")";
		}
		List<Gbpm_nodeTask> nodeTaskList = nodeTaskService.selectNodeTaskListByWheresql(wheresql);
		
		//添加第一个节点下所有的任务事项为运行中的任务事项并且添加到已完成任务表里（任务状态是未完成）
		for (Gbpm_nodeTask nodeTask : nodeTaskList) {
			Gbpm_runTask runTask = new Gbpm_runTask();
			runTask.setProductInstanceID(productInstance.getProductInstance_ID());
			runTask.setRunNodeID(runNode.getRunNode_ID());
			runTask.setNodeNames(runNode.getNodeNames());
			
			//根据nodeTaskID设置办理人ID 和 name
			runTask.setOperatorID(nodeTask.getOperatorID());
			runTask.setOperatorName(nodeTask.getOperatorName());
			runTask.setHandleUserID(handleUserIDMap.get(nodeTask.getNodeTask_ID()));
			runTask.setHandleUserName(handleUserNameMap.get(nodeTask.getNodeTask_ID()));
			
			//从任务事项库获取任务事项类型等
			Gbpm_dicTaskManager dicTaskManager = new Gbpm_dicTaskManager();
			dicTaskManager.setTaskManager_ID(nodeTask.getTaskMangerID());
			dicTaskManager = dicTaskManagerService.selectOneTaskManager(dicTaskManager);
			//设置主键为组合主键
			runTask.setRunTask_ID(runNode.getRunNode_ID()+dicTaskManager.getTaskCode());
			
			runTask.setTaskTypeID(dicTaskManager.getTaskType_ID());
			runTask.setTaskCode(dicTaskManager.getTaskCode());
			runTask.setTaskName(nodeTask.getTaskName());
			runTask.setTaskUrl(dicTaskManager.getTaskUrl());
			runTask.setViewTaskUrl(dicTaskManager.getViewTaskUrl());
			
			runTask.setTaskSort(nodeTask.getTaskSort());
			runTask.setIsBeforeTask(nodeTask.getIsBeforeTask());
			runTask.setBeforeTaskID(nodeTask.getBeforeTaskID());
			runTask.setBeforeTaskName(nodeTask.getBeforeTaskName());
			runTask.setTaskMangerID(nodeTask.getTaskMangerID());
			runTask.setIsAfterTask(nodeTask.getIsAfterTask());
			runTask.setAfterTaskIDList(nodeTask.getAfterTaskIDList());
			runTask.setAfterTaskNameList(nodeTask.getAfterTaskNameList());
			runTask.setWarnMethodIDList(nodeTask.getWarnMethodIDList());
			runTask.setWarnMethodNameList(nodeTask.getWarnMethodNameList());
			runTask.setIsStartProcess(nodeTask.getIsStartProcess());
			runTask.setProcessID(nodeTask.getProcessID());
			runTask.setProcessName(nodeTask.getProcessName());
			runTask.setOperaterTypeID(nodeTask.getOperaterTypeID());
			runTask.setOperaterTypeName(nodeTask.getOperaterTypeName());
			runTask.setOperationType(nodeTask.getOperationType());
			runTask.setTaskStatus("未完成");
			//添加正在运行中的任务
			runTaskService.insertOneRunTaskInfo(SystemSession.getUserSession(), runTask);
			
			Gbpm_finishTask finishTask = new Gbpm_finishTask();
			finishTask.setFinishTask_ID(runTask.getRunTask_ID());
			finishTask.setAfterTaskIDList(runTask.getAfterTaskIDList());
			finishTask.setAfterTaskNameList(runTask.getAfterTaskNameList());
			finishTask.setAssignUserID(runTask.getAssignUserID());
			finishTask.setBeforeTaskID(runTask.getBeforeTaskID());
			finishTask.setBeforeTaskName(runTask.getBeforeTaskName());
			finishTask.setEntrustUserID(runTask.getEntrustUserID());
			finishTask.setEntrustUserName(runTask.getEntrustUserName());
			finishTask.setFinishTask_ID(runTask.getRunTask_ID());
			finishTask.setHandleUserID(runTask.getHandleUserID());
			finishTask.setHandleUserName(runTask.getHandleUserName());
			finishTask.setHandleDateTime(runTask.getHandleDateTime());
			finishTask.setAssignUserID(runTask.getAssignUserID());
			finishTask.setAssignUserName(runTask.getAssignUserName());
			finishTask.setAssignDateTime(runTask.getAssignDateTime());
			finishTask.setIsAfterTask(runTask.getIsAfterTask());
			finishTask.setIsBeforeTask(runTask.getIsBeforeTask());
			finishTask.setIsStartProcess(runTask.getIsStartProcess());
			finishTask.setNodeNames(runTask.getNodeNames());
			finishTask.setOperaterTypeID(runTask.getOperaterTypeID());
			finishTask.setOperaterTypeName(runTask.getOperaterTypeName());
			finishTask.setOperatorID(runTask.getOperatorID());
			finishTask.setOperatorName(runTask.getOperatorName());
			finishTask.setProcessID(runTask.getProcessID());
			finishTask.setProcessName(runTask.getProcessName());
			finishTask.setProductInstanceID(runTask.getProductInstanceID());
			finishTask.setRunNodeID(runTask.getRunNodeID());
			finishTask.setTaskCode(runTask.getTaskCode());
			finishTask.setOperationType(runTask.getOperationType());
			finishTask.setTaskName(runTask.getTaskName());
			finishTask.setTaskMangerID(runTask.getTaskMangerID());
			finishTask.setTaskSort(runTask.getTaskSort());
			finishTask.setTaskStatus(runTask.getTaskStatus());
			finishTask.setTaskTypeID(runTask.getTaskTypeID());
			finishTask.setViewTaskUrl(runTask.getViewTaskUrl());
			finishTask.setTaskUrl(runTask.getTaskUrl());
			finishTask.setUnit_uid(runTask.getUnit_uid());
			finishTask.setUnit_uidName(runTask.getUnit_uidName());
			//添加已完成的任务
			finishTaskService.insertOneFinishTaskInfo(user,finishTask);
			
		}
		//如果节点顺序不为0（不是启动流程） 把当前运行中节点移到已完成 并删除正在运行中的节点及任务
		if (productInstance.getNodeSort() !=0 ) {
			wheresql = " and productInstanceID = \'" + productInstance.getProductInstance_ID() + "\'"; 
			wheresql = wheresql + " and nodeSort = " + productInstance.getNodeSort();
			Gbpm_runNode runNode2 = runNodeService.selectOneRunNodeByWhereSql(wheresql);
			if (runNode2 != null) {
				Gbpm_finishNode finishNode = new Gbpm_finishNode();
				finishNode.setFinishNode_ID(runNode2.getRunNode_ID());
				finishNode.setNodeNames(runNode2.getNodeNames());
				finishNode.setLimitDay(runNode2.getLimitDay());
				finishNode.setNodeSort(runNode2.getNodeSort());
				finishNode.setProductInstanceID(runNode2.getProductInstanceID());
				finishNode.setUnit_uid(runNode2.getUnit_uid());
				finishNode.setUnit_uidName(runNode2.getUnit_uidName());
				finishNodeService.insertOneFinishNode(user, finishNode);
			}
			//根据运行中节点ID删除运行中表的节点和任务
			wheresql = " and runNodeID = \'" + runNode2.getRunNode_ID() + "\'";
			runTaskService.deleteRunTaskByWheresql(user,wheresql);
			wheresql = " and runNode_ID = \'" + runNode2.getRunNode_ID() + "\'";
			runNodeService.deleteRunNodeByWheresql(user,wheresql);
		}
	}
	
	
	
	/**
	 *判断流程是否被实例化
	 * @param wheresql
	 * @return
	 */
	@Override
	public Boolean isExistProductInstance(String wheresql) {
		return (productInstanceMapper.isExistProductInstance(wheresql) > 0);
	}

	/**
	 * 流程实例环节退回  
	 */
	@Override
	public Boolean backStep(User user, Gbpm_productInstance productInstance) {
		//returnType 01:修改后任务事项后直接返回当前任务节点
		if (productInstance.getReturnType().equals("01")) {
			
			//逻辑删除当前正在运行的节点
			String wheresql = " and runNode_ID = \'" + productInstance.getReturnBeforeNodeID() + "\'";
			Gbpm_runNode oldRunNode = runNodeService.selectOneRunNodeByWhereSql(wheresql);
			oldRunNode.setIsDelete(true);
			runNodeService.updateOneRunNodeInfo(SystemSession.getUserSession(),oldRunNode);
			
			//添加退回节点为运行中的节点(从已完成节点中取)
			wheresql = " and finishNode_ID = \'" + productInstance.getReturnAfterNodeID() +"\'";
			Gbpm_finishNode finishNode=  finishNodeService.selectOneFinishNodeByWhereSql(wheresql);
			Gbpm_runNode runNode = new Gbpm_runNode();
			runNode.setRunNode_ID(finishNode.getFinishNode_ID());
			runNode.setProductInstanceID(finishNode.getProductInstanceID());
			runNode.setNodeNames(finishNode.getNodeNames());
			runNode.setNodeSort(finishNode.getNodeSort());
			runNode.setLimitDay(finishNode.getLimitDay());
			runNodeService.insertOneRunNodeInfo(SystemSession.getUserSession(),runNode);
			
			//添加退回节点下的任务为运行中的节点(从已完成节点中取)
			wheresql = " and runNodeID = \'" + finishNode.getFinishNode_ID() + "\'"; 
			List<Gbpm_finishTask> finishTasks = finishTaskService.selectFinishTaskListByWhereSql(wheresql);
			for (Gbpm_finishTask finishTask : finishTasks) {
				Gbpm_runTask runTask = new Gbpm_runTask();
				runTask.setRunTask_ID(finishTask.getFinishTask_ID());
				runTask.setAfterTaskIDList(finishTask.getAfterTaskIDList());
				runTask.setAfterTaskNameList(finishTask.getAfterTaskNameList());
				runTask.setAssignDateTime(finishTask.getAssignDateTime());
				runTask.setAssignUserID(finishTask.getAssignUserID());
				runTask.setBeforeTaskID(finishTask.getBeforeTaskID());
				runTask.setBeforeTaskName(finishTask.getBeforeTaskName());
				runTask.setEntrustUserID(finishTask.getEntrustUserID());
				runTask.setEntrustUserName(finishTask.getEntrustUserName());
				runTask.setRunTask_ID(finishTask.getFinishTask_ID());
				runTask.setHandleUserID(finishTask.getHandleUserID());
				runTask.setHandleUserName(finishTask.getHandleUserName());
				runTask.setHandleDateTime(finishTask.getHandleDateTime());
				runTask.setAssignUserID(finishTask.getAssignUserID());
				runTask.setAssignUserName(finishTask.getAssignUserName());
				runTask.setAssignDateTime(finishTask.getAssignDateTime());
				runTask.setIsAfterTask(finishTask.getIsAfterTask());
				runTask.setIsBeforeTask(finishTask.getIsBeforeTask());
				runTask.setIsStartProcess(finishTask.getIsStartProcess());
				runTask.setNodeNames(finishTask.getNodeNames());
				runTask.setOperaterTypeID(finishTask.getOperaterTypeID());
				runTask.setOperaterTypeName(finishTask.getOperaterTypeName());
				runTask.setOperatorID(finishTask.getOperatorID());
				runTask.setOperatorName(finishTask.getOperatorName());
				runTask.setProcessID(finishTask.getProcessID());
				runTask.setProcessName(finishTask.getProcessName());
				runTask.setProductInstanceID(finishTask.getProductInstanceID());
				runTask.setRunNodeID(finishTask.getRunNodeID());
				runTask.setTaskCode(finishTask.getTaskCode());
				runTask.setOperationType(finishTask.getOperationType());
				runTask.setTaskName(finishTask.getTaskName());
				runTask.setTaskMangerID(finishTask.getTaskMangerID());
				runTask.setTaskSort(finishTask.getTaskSort());
				runTask.setTaskStatus(finishTask.getTaskStatus());
				runTask.setTaskTypeID(finishTask.getTaskTypeID());
				runTask.setViewTaskUrl(finishTask.getViewTaskUrl());
				runTask.setTaskUrl(finishTask.getTaskUrl());
				runTask.setUnit_uid(finishTask.getUnit_uid());
				runTask.setUnit_uidName(finishTask.getUnit_uidName());
				runTask.setTaskStatus(finishTask.getTaskStatus());
				//添加正在运行中的任务
				runTaskService.insertOneRunTaskInfo(SystemSession.getUserSession(), runTask);
			}
			//改变选中的退回任务事项完成状态为未完成
			if (productInstance.getFinishTaskIDS() != null) {
				String[] finishTaskIDS =  productInstance.getFinishTaskIDS().split(",");
				for (int i = 0; i < finishTaskIDS.length; i++) {
					String wheresql2 = " and finishTask_ID = \'" + finishTaskIDS[i] +"\'";
					Gbpm_finishTask finishTask = finishTaskService.selectOneFinishTaskByWhereSql(wheresql2);
					finishTask.setTaskStatus("未完成");
					finishTaskService.updateOneFinishTaskInfo(user, finishTask);
					wheresql2 = " and runTask_ID = \'" + finishTaskIDS[i] +"\'";
					Gbpm_runTask runTask = runTaskService.selectOneRunTaskByWhereSql(wheresql2);
					runTask.setTaskStatus("未完成");
					runTaskService.updateOneRunTaskInfo(user, runTask);
				}
			}
			
			//删除退回环节已完成节点表中记录
			wheresql = " and finishNode_ID = \'" + productInstance.getReturnAfterNodeID() + "\'"; 
			finishNodeService.deleteFinishNodeByWheresql(user,wheresql);
			//修改流程实例退回状态原因
			wheresql = " and productInstance_ID = \'" + productInstance.getProductInstance_ID() + "\'"; 
			productInstance.setIsReturn(true);
			productInstanceMapper.updateProductInstanceInfo(productInstance);
		}else if (productInstance.getReturnType().equals("02")) {
			//returnType 02:修改任务事项后重走中间的流程  直接删除退回环节到当前环节间所有已完成的节点和任务
			String wheresql = " and runNode_ID = \'" + productInstance.getReturnBeforeNodeID() + "\'";
			Gbpm_runNode runNode = runNodeService.selectOneRunNodeByWhereSql(wheresql);
			wheresql = " and finishNode_ID = \'" + productInstance.getReturnAfterNodeID() + "\'";
			Gbpm_finishNode finishNode = finishNodeService.selectOneFinishNodeByWhereSql(wheresql);
			
			//删除退回环节到当前环节间所有已完成的节点和任务并删除正在运行的节点和任务
			wheresql = " and runNode_ID = \'" + productInstance.getReturnBeforeNodeID() + "\'";
			runNodeService.deleteRunNodeByWheresql(user, wheresql);
			wheresql = " and runNodeID = \'" + productInstance.getReturnBeforeNodeID() + "\'";
			runTaskService.deleteRunTaskByWheresql(user, wheresql);
			finishTaskService.deleteFinishTaskByWheresql(user, wheresql);
			
			
			wheresql = " and productInstanceID = \'" + productInstance.getProductInstance_ID() + "\'";
			wheresql = " and nodeSort < " + runNode.getNodeSort();
			wheresql = wheresql + " and nodeSort >= " + finishNode.getNodeSort();
			finishNodeService.deleteFinishNodeByWheresql(user, wheresql);
			for (int nodeSort = finishNode.getNodeSort() + 1; nodeSort < runNode.getNodeSort(); nodeSort++) {
				wheresql = " and runNodeID = \'" + productInstance.getProductInstance_ID()+nodeSort + "\'";
				finishTaskService.deleteFinishTaskByWheresql(user,wheresql);
			}
			
			//添加退回节点为运行中的节点(从已完成节点中取)
			wheresql = " and finishNode_ID = \'" + (productInstance.getReturnAfterNodeID()) +"\'";
			Gbpm_runNode runNode2 = new Gbpm_runNode();
			runNode2.setRunNode_ID(finishNode.getFinishNode_ID());
			runNode2.setProductInstanceID(finishNode.getProductInstanceID());
			runNode2.setNodeNames(finishNode.getNodeNames());
			runNode2.setNodeSort(finishNode.getNodeSort());
			runNode2.setLimitDay(finishNode.getLimitDay());
			runNodeService.insertOneRunNodeInfo(SystemSession.getUserSession(),runNode2);
			
			wheresql = " and productInstance_ID = \'" + productInstance.getProductInstance_ID() + "\'"; 
			productInstance.setIsReturn(true);
			productInstanceMapper.updateProductInstanceInfo(productInstance);
			
			//添加退回节点下的任务为运行中的节点(从已完成节点中取)
			wheresql = " and runNodeID = \'" + finishNode.getFinishNode_ID() + "\'"; 
			List<Gbpm_finishTask> finishTasks = finishTaskService.selectFinishTaskListByWhereSql(wheresql);
			for (Gbpm_finishTask finishTask : finishTasks) {
				Gbpm_runTask runTask = new Gbpm_runTask();
				runTask.setRunTask_ID(finishTask.getFinishTask_ID());
				runTask.setAfterTaskIDList(finishTask.getAfterTaskIDList());
				runTask.setAfterTaskNameList(finishTask.getAfterTaskNameList());
				runTask.setAssignDateTime(finishTask.getAssignDateTime());
				runTask.setAssignUserID(finishTask.getAssignUserID());
				runTask.setBeforeTaskID(finishTask.getBeforeTaskID());
				runTask.setBeforeTaskName(finishTask.getBeforeTaskName());
				runTask.setEntrustUserID(finishTask.getEntrustUserID());
				runTask.setEntrustUserName(finishTask.getEntrustUserName());
				runTask.setRunTask_ID(finishTask.getFinishTask_ID());
				runTask.setHandleUserID(finishTask.getHandleUserID());
				runTask.setHandleUserName(finishTask.getHandleUserName());
				runTask.setHandleDateTime(finishTask.getHandleDateTime());
				runTask.setAssignUserID(finishTask.getAssignUserID());
				runTask.setAssignUserName(finishTask.getAssignUserName());
				runTask.setAssignDateTime(finishTask.getAssignDateTime());
				runTask.setIsAfterTask(finishTask.getIsAfterTask());
				runTask.setIsBeforeTask(finishTask.getIsBeforeTask());
				runTask.setIsStartProcess(finishTask.getIsStartProcess());
				runTask.setNodeNames(finishTask.getNodeNames());
				runTask.setOperaterTypeID(finishTask.getOperaterTypeID());
				runTask.setOperaterTypeName(finishTask.getOperaterTypeName());
				runTask.setOperatorID(finishTask.getOperatorID());
				runTask.setOperatorName(finishTask.getOperatorName());
				runTask.setProcessID(finishTask.getProcessID());
				runTask.setProcessName(finishTask.getProcessName());
				runTask.setProductInstanceID(finishTask.getProductInstanceID());
				runTask.setRunNodeID(finishTask.getRunNodeID());
				runTask.setTaskCode(finishTask.getTaskCode());
				runTask.setOperationType(finishTask.getOperationType());
				runTask.setTaskName(finishTask.getTaskName());
				runTask.setTaskMangerID(finishTask.getTaskMangerID());
				runTask.setTaskSort(finishTask.getTaskSort());
				runTask.setTaskStatus(finishTask.getTaskStatus());
				runTask.setTaskTypeID(finishTask.getTaskTypeID());
				runTask.setViewTaskUrl(finishTask.getViewTaskUrl());
				runTask.setTaskUrl(finishTask.getTaskUrl());
				runTask.setUnit_uid(finishTask.getUnit_uid());
				runTask.setUnit_uidName(finishTask.getUnit_uidName());
				runTask.setTaskStatus(finishTask.getTaskStatus());
				//添加正在运行中的任务
				runTaskService.insertOneRunTaskInfo(SystemSession.getUserSession(), runTask);
			}
			if (productInstance.getFinishTaskIDS() != null) {
				String[] finishTaskIDS =  productInstance.getFinishTaskIDS().split(",");
				for (int i = 0; i < finishTaskIDS.length; i++) {
					String wheresql2 = " and finishTask_ID = \'" + finishTaskIDS[i] +"\'";
					Gbpm_finishTask finishTask = finishTaskService.selectOneFinishTaskByWhereSql(wheresql2);
					finishTask.setTaskStatus("未完成");
					finishTaskService.updateOneFinishTaskInfo(user, finishTask);
					wheresql2 = " and runTask_ID = \'" + finishTaskIDS[i] +"\'";
					Gbpm_runTask runTask = runTaskService.selectOneRunTaskByWhereSql(wheresql2);
					runTask.setTaskStatus("未完成");
					runTaskService.updateOneRunTaskInfo(user, runTask);
				}
			}
			//修改流程实例退回状态原因
			wheresql = " and productInstance_ID = \'" + productInstance.getProductInstance_ID() + "\'"; 
			productInstance.setIsReturn(true);
			productInstanceMapper.updateProductInstanceInfo(productInstance);
			
		}
		
//		//获取退回环节的信息
//		String wheresql = " and productID = \'" + productInstance.getProductID() + "\'"; 
//		wheresql = wheresql + " and nodeSort = " + (productInstance.getNodeSort());
//		Gbpm_productNode productNode = productNodeService.selectOneProductNodeInfo(wheresql);
//		
//		//更新项目阶段 项目阶段就是环节
//		Pro_apply apply = new Pro_apply();
//		apply.setApply_ID(productInstance.getEntityID());
//		apply.setProjectStageID(productNode.getNodeID());
//		apply.setProjectStageName(productNode.getNodeNames());
//		projectApplyService.updateOneApplyInfo(user, apply);
		
		return true;
	}

	/**
	 * 重新提交到退回环节
	 */
	@Override
	public Boolean returnBackNode(User user, Gbpm_productInstance productInstance) {
		
		//把当前运行中节点移到已完成 并删除正在运行中的节点及任务
		String wheresql = " and runNode_ID = \'" + productInstance.getReturnAfterNodeID() + "\'"; 
		Gbpm_runNode runNode2 = runNodeService.selectOneRunNodeByWhereSql(wheresql);
		if (runNode2 != null) {
			Gbpm_finishNode finishNode = new Gbpm_finishNode();
			finishNode.setFinishNode_ID(runNode2.getRunNode_ID());
			finishNode.setNodeNames(runNode2.getNodeNames());
			finishNode.setLimitDay(runNode2.getLimitDay());
			finishNode.setNodeSort(runNode2.getNodeSort());
			finishNode.setProductInstanceID(runNode2.getProductInstanceID());
			finishNode.setUnit_uid(runNode2.getUnit_uid());
			finishNode.setUnit_uidName(runNode2.getUnit_uidName());
			finishNodeService.insertOneFinishNode(user, finishNode);
		}
		//根据运行中节点ID删除运行中表的节点和任务
		wheresql = " and runNodeID = \'" + runNode2.getRunNode_ID() + "\'";
		runTaskService.deleteRunTaskByWheresql(user,wheresql);
		wheresql = " and runNode_ID = \'" + runNode2.getRunNode_ID() + "\'";
		runNodeService.deleteRunNodeByWheresql(user,wheresql);
		
		wheresql = " and productInstance_ID = \'" + productInstance.getProductInstance_ID() + "\'"; 
		productInstance = productInstanceMapper.selectOneProductInstanceByWhereSql(wheresql);
		productInstance.setIsReturn(false);
		productInstanceMapper.updateProductInstanceInfo(productInstance);
		
		//讲退回前的环节逻辑删除值更新为false
		wheresql = " and runNode_ID = \'" + productInstance.getReturnBeforeNodeID() +"\'";
		Gbpm_runNode oldRunNode = runNodeService.selectOneRunNodeByWhereSql(wheresql);
		oldRunNode.setIsDelete(false);
		runNodeService.updateOneRunNodeInfo(SystemSession.getUserSession(), oldRunNode);
		return true;
	}
	
	/**
	 * 分页查询产品流程实例列表
	 */
	@Override
	public PageTable<Gbpm_productInstance> selectProductMyBuildInstancePageTable(PageTable<Gbpm_productInstance> pageTable) {
			pageTable.setRows(productInstanceMapper.selectProductMyBuildInstancePageTable(pageTable));
			pageTable.setTotal(productInstanceMapper.selectProductMyBuildInstancePageTable_Count(pageTable));
			return pageTable;
	}

	/**
	 * 项目流程实例删除
	 */
	@Override
	public Boolean delProductInstanceInfo(User user,Gbpm_productInstance gbpm_productInstance) {
		try {                         
			String wheresql = " AND productInstanceID = \'" + gbpm_productInstance.getProductInstance_ID() + "\'";
			runNodeService.deleteRunNodeByWheresql(user, wheresql);
			runTaskService.deleteRunTaskByWheresql(user, wheresql);
			finishNodeService.deleteFinishNodeByWheresql(user, wheresql);
			finishTaskService.deleteFinishTaskByWheresql(user, wheresql);
			wheresql = " AND  productInstance_ID = \'" + gbpm_productInstance.getProductInstance_ID() + "\'";
			if (productInstanceMapper.delProductInstanceInfo(wheresql) > 0) {
				logService.insertOneOperatorLogInfo(user,"流程实例", "删除", ""+gbpm_productInstance.getProductName());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 分页查询我参与的产品流程实例列表
	 */
	@Override
	public PageTable<Gbpm_productInstance> selectProductMyJoinInstancePageTable(PageTable<Gbpm_productInstance> pageTable) {
		pageTable.setRows(productInstanceMapper.selectProductMyJoinInstancePageTable(pageTable));
		pageTable.setTotal(productInstanceMapper.selectProductMyJoinInstancePageTable_Count(pageTable));
		return pageTable;
	}
	
}

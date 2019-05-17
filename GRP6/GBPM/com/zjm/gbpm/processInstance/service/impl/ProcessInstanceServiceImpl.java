package com.zjm.gbpm.processInstance.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.bpmn.behavior.SubProcessActivityBehavior;
import org.activiti.engine.impl.bpmn.behavior.NoneEndEventActivityBehavior;
import org.activiti.engine.impl.javax.el.ExpressionFactory;
import org.activiti.engine.impl.javax.el.ValueExpression;
import org.activiti.engine.impl.juel.ExpressionFactoryImpl;
import org.activiti.engine.impl.juel.SimpleContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.gbpm.db.map.Act_ProcessInstanceMapper;
import com.zjm.gbpm.db.model.Act_ProcessInstance;
import com.zjm.gbpm.db.model.Act_nextTask;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.dicTaskManager.service.DicTaskManagerService;
import com.zjm.gbpm.processInstance.service.ProcessInstanceService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
@Service("processInstanceService")
@Transactional
public class ProcessInstanceServiceImpl implements ProcessInstanceService {
	@Resource//流程实例
	Act_ProcessInstanceMapper processInstanceMapper;
	/**
	 * 提供对暴露BPM和工作流操作的所有服务的访问
	 */
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	@Resource
	private SysDicDataService sysDicDataService;
	@Resource
	private DicTaskManagerService dicTaskManagerService;
	/**
	 * 流程实例 活动中 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessInstanceExecutionPageTable(PageTable pageTable, User userSession) {
		try {
			Map<String,String> userMap=sysDicDataService.selectUsersDicMap("");
			List<Act_ProcessInstance> list=processInstanceMapper.selectProcessInstanceExecutionPageTable(pageTable);
			for (Act_ProcessInstance pi : list) {
				if(pi.getInitiatorID()!=null)
					pi.setInitiatorName(userMap.get(pi.getInitiatorID()));
				if(pi.getTransactorID()!=null)
					pi.setTransactorName(userMap.get(pi.getTransactorID()));
				pi.setTaskTotalDate(Tool.returnTotalDateMessage(pi.getTaskBeginDate(), pi.getTaskEndDate()));
			}

			Long total=processInstanceMapper.selectProcessInstanceExecutionPageTable_Count(pageTable);
			pageTable.setRows(list);
			pageTable.setTotal(total);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	/**
	 * 流程实例 已完成 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessInstanceHistoryPageTable(PageTable pageTable, User userSession) {
		try {
			Map<String,String> userMap=sysDicDataService.selectUsersDicMap("");
			List<Act_ProcessInstance> list=processInstanceMapper.selectProcessInstanceHistoryPageTable(pageTable);
			for (Act_ProcessInstance pi : list) {
				if(pi.getInitiatorID()!=null)
					pi.setInitiatorName(userMap.get(pi.getInitiatorID()));
				if(pi.getTransactorID()!=null)
					pi.setTransactorName(userMap.get(pi.getTransactorID()));
				pi.setTaskTotalDate(Tool.returnTotalDateMessage(pi.getTaskBeginDate(), pi.getTaskEndDate()));
			}

			Long total=processInstanceMapper.selectProcessInstanceHistoryPageTable_Count(pageTable);
			pageTable.setRows(list);
			pageTable.setTotal(total);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	/**
	 * 待签收 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessTaskSignPageTable(PageTable pageTable) {
		try {

			System.out.println(JSON.toJSONString(pageTable));
			Map<String,String> userMap=sysDicDataService.selectUsersDicMap("");
			List<Act_ProcessInstance> list=processInstanceMapper.selectProcessTaskExecutionPageTable(pageTable);
			Long total=processInstanceMapper.selectProcessTaskExecutionPageTable_Count(pageTable);

			for (Act_ProcessInstance pi : list) {
				if(pi.getInitiatorID()!=null)
					pi.setInitiatorName(userMap.get(pi.getInitiatorID()));
				if(pi.getTransactorID()!=null)
					pi.setTransactorName(userMap.get(pi.getTransactorID()));
				pi.setTaskTotalDate(Tool.returnTotalDateMessage(pi.getTaskBeginDate(), pi.getTaskEndDate()));
			}
			pageTable.setRows(list);
			pageTable.setTotal(total);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	/**
	 * 待办签收
	 * @return
	 */
	public Boolean createProcessTaskSign(Act_ProcessInstance processInstance, User userSession) {
		try {
			processEngine.getTaskService().setAssignee(processInstance.getTaskID(), userSession.getUser_uid());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * 已办 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectProcessTaskHistoryTaskPageTable(PageTable pageTable, User userSession) {
		Map<String,String> userMap=sysDicDataService.selectUsersDicMap("");
		List<Act_ProcessInstance> list=processInstanceMapper.selectProcessTaskHistoryTaskPageTable(pageTable);
		Long total=processInstanceMapper.selectProcessTaskHistoryTaskPageTable_Count(pageTable);

		for (Act_ProcessInstance pi : list) {
			if(pi.getInitiatorID()!=null)
				pi.setInitiatorName(userMap.get(pi.getInitiatorID()));
			if(pi.getTransactorID()!=null)
				pi.setTransactorName(userMap.get(pi.getTransactorID()));
			pi.setTaskTotalDate(Tool.returnTotalDateMessage(pi.getTaskBeginDate(), pi.getTaskEndDate()));
		}
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	/**
	 * 办理完成
	 * @return
	 */
	public Boolean createProcessTaskTaskFinish(Act_ProcessInstance processInstance, User userSession) {
		try {
			//Multiple Instances
			//${userTaskMultiple}
			String[] nextAllTaskKeys= processInstance.getNextAllTaskKeys().trim().split("<>");
			String[] nextTaskKeys=processInstance.getNextTaskKeys().trim().split("<>");
			String[] nextTaskUserIDs=processInstance.getNextTaskUserIDs().trim().split("<>");
			System.out.println("nextAllTaskKeys>>>>");
			System.out.println(JSON.toJSONString(nextAllTaskKeys));
			System.out.println("nextTaskKeys>>>>");
			System.out.println(JSON.toJSONString(nextTaskKeys));
			System.out.println("nextTaskUserIDs>>>>");
			System.out.println(JSON.toJSONString(nextTaskUserIDs));
			Map<String,Boolean> lineConditionMap=new HashMap<String,Boolean>();
			for (String allTaskKey : nextAllTaskKeys) {
				if(!allTaskKey.trim().equals("")){
					lineConditionMap.put(allTaskKey.trim(), false);
				}
				for (String taskKey : nextTaskKeys) {
					if(!taskKey.trim().equals("")){
						lineConditionMap.put(taskKey.trim(), true);
					}
				}
			}
			Map<String,String> nextUserIDMap=new HashMap<String,String>();
			for(int i=0;i<nextTaskKeys.length;i++){
				if(!nextTaskKeys[i].trim().equals("")){
					nextUserIDMap.put(nextTaskKeys[i].trim(), nextTaskUserIDs[i].trim());
				}
			}
			System.out.println("lineConditionMap>>>>");
			System.out.println(JSON.toJSONString(lineConditionMap));
			System.out.println("nextUserIDMap>>>>");
			System.out.println(JSON.toJSONString(nextUserIDMap));
			Map<String,Object> variables=new HashMap<String,Object>();
			variables.put("lineConditionMap", lineConditionMap);
			variables.put("assigneeMap", nextUserIDMap);
			//获取流程实例Id信息   
			String processInstanceId = processEngine.getTaskService().createTaskQuery().taskId(processInstance.getTaskID()).singleResult().getProcessInstanceId();  
			processEngine.getTaskService().complete(processInstance.getTaskID(), variables);
			//根据流程id获取当前任务list
			List<Task> tasks = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstanceId).list();
			for (Task task : tasks) {//设置流程第一步办理人为流程启动者
				processEngine.getTaskService().setAssignee(task.getId(), nextUserIDMap.get(task.getTaskDefinitionKey()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 任务委托
	 * @return
	 */
	public Boolean createProcessTaskTaskEntrusted(Act_ProcessInstance processInstance, User userSession) {
		try {
			processEngine.getTaskService().delegateTask(processInstance.getTaskID(), processInstance.getTransactorID());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 任务挂起/暂停
	 * @return
	 */
	public Boolean suspendProcessInstance(Act_ProcessInstance processInstance, User userSession) {
		try {
			processEngine.getRuntimeService().suspendProcessInstanceById(processInstance.getProcessInstanceID());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 任务激活
	 * @return
	 */
	public Boolean activateProcessInstance(Act_ProcessInstance processInstance, User userSession) {
		try {
			processEngine.getRuntimeService().activateProcessInstanceById(processInstance.getProcessInstanceID());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 变更办理人
	 * @return
	 */
	public Boolean updateProcessTaskTaskAssignee(Act_ProcessInstance processInstance, User userSession) {
		try {
			processEngine.getTaskService().setAssignee(processInstance.getTaskID(), processInstance.getTransactorID());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 提前中止流程实例
	 * @return
	 */
	public Boolean stopProcessInstance(Act_ProcessInstance processInstance, User userSession) {
		try {
			processEngine.getRuntimeService().deleteProcessInstance(processInstance.getProcessInstanceID(), "discontinue");
			processInstance.setUpdateUserName(userSession.getUser_name());
			processInstance.setUnit_uid(userSession.getUnit_uid());
			processInstanceMapper.updateOneProInstanceEntityInfo(processInstance);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除流程实例
	 * @return
	 */
	public Boolean deleteProcessInstance(Act_ProcessInstance processInstance, User userSession) {
		try {
			processEngine.getRuntimeService().deleteProcessInstance(processInstance.getProcessInstanceID(), "delete");
			processInstance.setUnit_uid(userSession.getUnit_uid());
			processEngine.getHistoryService().deleteHistoricProcessInstance(processInstance.getProcessInstanceID());
			processInstanceMapper.deleteOneProInstanceEntityInfo(processInstance);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}



	/**
	 * 流程流转图
	 * @param processInstance
	 * @param userSession
	 */
	public InputStream selectProcessDiagram(Act_ProcessInstance processInstance, User userSession) {
		ProcessDefinition processDefinition = processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionId(processInstance.getProcDefID())
				.singleResult();
		String resourceName = processDefinition.getDiagramResourceName();
		return   processEngine.getRepositoryService().getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
	}

	/**
	 * 流程跟踪图
	 * @return  封装了各种节点信息
	 */
	public List<Map<String, Object>> selectProcessTrace(String processInstanceID, User userSession) throws Exception{
		Execution execution = processEngine.getRuntimeService().createExecutionQuery().executionId(processInstanceID).singleResult();//执行实例
		Object property = PropertyUtils.getProperty(execution, "activityId");
		String activityId = "";
		if (property != null) {
			activityId = property.toString();
		}
		ProcessInstance processInstance = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceID)
				.singleResult();
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) processEngine.getRepositoryService())
				.getDeployedProcessDefinition(processInstance.getProcessDefinitionId());
		List<ActivityImpl> activitiList = processDefinition.getActivities();//获得当前任务的所有节点

		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();
		for (ActivityImpl activity : activitiList) {

			boolean currentActiviti = false;
			String id = activity.getId();

			// 当前节点
			if (id.equals(activityId)) {
				currentActiviti = true;
			}

			Map<String, Object> activityImageInfo = packageSingleActivitiInfo(activity, processInstance, currentActiviti);

			activityInfos.add(activityImageInfo);
		}

		return activityInfos;
	}






	/**
	 * 封装输出信息，包括：当前节点的X、Y坐标、变量信息、任务类型、任务描述
	 * @param activity
	 * @param processInstance
	 * @param currentActiviti
	 * @return
	 */
	private Map<String, Object> packageSingleActivitiInfo(ActivityImpl activity, ProcessInstance processInstance,
			boolean currentActiviti) throws Exception {
		Map<String, Object> vars = new HashMap<String, Object>();
		Map<String, Object> activityInfo = new HashMap<String, Object>();
		activityInfo.put("currentActiviti", currentActiviti);
		setPosition(activity, activityInfo);
		setWidthAndHeight(activity, activityInfo);

		Map<String, Object> properties = activity.getProperties();
		vars.put("任务类型", parseToZhType(properties.get("type").toString()));

		ActivityBehavior activityBehavior = activity.getActivityBehavior();
		//logger.debug("activityBehavior={}", activityBehavior);
		if (activityBehavior instanceof UserTaskActivityBehavior) {

			Task currentTask = null;

			/*
			 * 当前节点的task
			 */
			if (currentActiviti) {
				currentTask = getCurrentTaskInfo(processInstance);
			}

			/*
			 * 当前任务的分配角色
			 */
			UserTaskActivityBehavior userTaskActivityBehavior = (UserTaskActivityBehavior) activityBehavior;
			TaskDefinition taskDefinition = userTaskActivityBehavior.getTaskDefinition();
			Set<Expression> candidateGroupIdExpressions = taskDefinition.getCandidateGroupIdExpressions();
			if (!candidateGroupIdExpressions.isEmpty()) {

				// 任务的处理角色
				setTaskGroup(vars, candidateGroupIdExpressions);

				// 当前处理人
				if (currentTask != null) {
					setCurrentTaskAssignee(vars, currentTask);
				}
			}
		}

		vars.put("节点说明", properties.get("documentation"));

		String description = activity.getProcessDefinition().getDescription();
		vars.put("描述", description);

		//logger.debug("trace variables: {}", vars);
		activityInfo.put("vars", vars);
		return activityInfo;
	}


	/**
	 * 转换流程节点类型为中文说明
	 * 
	 * @param type
	 *          英文名称
	 * @return 翻译后的中文名称
	 */
	public String parseToZhType(String type) {
		Map<String, String> types = new HashMap<String, String>();
		types.put("userTask", "用户任务");
		types.put("serviceTask", "系统任务");
		types.put("startEvent", "开始节点");
		types.put("endEvent", "结束节点");
		types.put("exclusiveGateway", "条件判断节点(系统自动根据条件处理)");
		types.put("inclusiveGateway", "并行处理任务");
		types.put("callActivity", "子流程");
		return types.get(type) == null ? type : types.get(type);
	}



	private void setTaskGroup(Map<String, Object> vars, Set<Expression> candidateGroupIdExpressions) {
		String roles = "";
		for (Expression expression : candidateGroupIdExpressions) {
			String expressionText = expression.getExpressionText();
			String roleName = processEngine.getIdentityService().createGroupQuery().groupId(expressionText).singleResult().getName();
			roles += roleName;
		}
		vars.put("任务所属角色", roles);
	}

	/**
	 * 设置当前处理人信息
	 * @param vars
	 * @param currentTask
	 */
	private void setCurrentTaskAssignee(Map<String, Object> vars, Task currentTask) {
		String assignee = currentTask.getAssignee();
		if (assignee != null) {
			org.activiti.engine.identity.User assigneeUser = processEngine.getIdentityService().createUserQuery().userId(assignee).singleResult();
			String userInfo = assigneeUser.getFirstName() + " " + assigneeUser.getLastName();
			vars.put("当前处理人", userInfo);
		}
	}

	/**
	 * 获取当前节点信息
	 * @param processInstance
	 * @return
	 */
	private Task getCurrentTaskInfo(ProcessInstance processInstance) {
		Task currentTask = null;
		try {
			String activitiId = (String) PropertyUtils.getProperty(processInstance, "activityId");
			//logger.debug("current activity id: {}", activitiId);

			currentTask = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).taskDefinitionKey(activitiId)
					.singleResult();
			//logger.debug("current task for processInstance: {}", ToStringBuilder.reflectionToString(currentTask));

		} catch (Exception e) {
			//logger.error("can not get property activityId from processInstance: {}", processInstance);
		}
		return currentTask;
	}

	/**
	 * 设置宽度、高度属性
	 * @param activity
	 * @param activityInfo
	 */
	private void setWidthAndHeight(ActivityImpl activity, Map<String, Object> activityInfo) {
		activityInfo.put("width", activity.getWidth());
		activityInfo.put("height", activity.getHeight());
	}

	/**
	 * 设置坐标位置
	 * @param activity
	 * @param activityInfo
	 */
	private void setPosition(ActivityImpl activity, Map<String, Object> activityInfo) {
		activityInfo.put("x", activity.getX());
		activityInfo.put("y", activity.getY());
	}



















	/*public void test(String taskid){
		System.out.println(">>>>>>>>>>>>>begin>>>>>>>>>>>>>>>");
		try {


			Task task=processEngine.getTaskService().createTaskQuery().taskId(taskid).singleResult();
			System.out.println(">>>1");
			//List<FlowElement> list=new ArrayList<FlowElement>();
			ProcessInstance processInstance=processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
			System.out.println(">>>2");
			//当前活动节点  
			String activitiId = processInstance.getActivityId();
			System.out.println(">>>3"+activitiId);
			//查询流程定义（ProcessDefinitionEntity）的实体对象
			ProcessDefinitionEntity processDefinitionEntity =(ProcessDefinitionEntity) processEngine.getRepositoryService().getProcessDefinition(task.getProcessDefinitionId());
			System.out.println(">>>4");
			// 4.获取当前的活动
			ActivityImpl activityImpl = processDefinitionEntity.findActivity(activitiId);
			System.out.println(">>>5");
			// 5.获取当前活动完成之后连线的名称
			List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
			System.out.println(">>>6");
			if (pvmList != null && pvmList.size() > 0) {
				for (PvmTransition pvm : pvmList) {
					System.out.println(">>>7");
					String id = (String) pvm.getId();
					System.out.println("id:"+id);
					String type = (String) pvm.getClass().getName();
					System.out.println("type:"+type);
					String typeString = (String) pvm.getClass().toString();
					System.out.println("typeString:"+typeString);
					String name = (String) pvm.getProperty("name");
					System.out.println("name:"+name);
					PvmActivity sourceRef = pvm.getSource();
					System.out.println("sourceRef:"+sourceRef.getId());
					PvmActivity targetRef = pvm.getDestination();
					System.out.println("targetRef:"+targetRef.getId());
					if (name != null) {
						//list.add(name);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>>>end>>>>>>>>>>>>>>>");

	}*/




	/**
	 * 查询下步任务集合
	 */
	public List<Act_nextTask> selectNextTaskList(String taskid){
		List<Act_nextTask> nextTaskList=new ArrayList<Act_nextTask>();
		Map<String,String> userMap=sysDicDataService.selectUsersDicMap("");
		try {
			//Set<Expression> set=null;
			//System.out.println("=============begin=============");
			nextTaskList=	getNextTaskInfo(taskid,userMap);
			//System.out.println(">>>>>>>====="+nextTaskGroup.size());
			/*for (TaskDefinition taskDefinition : nextTaskGroup) {
				Act_nextTask nextTask=new Act_nextTask();
				nextTask=taskDefinitionToNextTask(taskDefinition,userMap);
				//System.out.println("nextTaskGroup:"+taskDefinition.getKey());
				nextTask.setNextTaskDefKey(taskDefinition.getKey());
				nextTask.setNextTaskName(taskDefinition.getNameExpression().getExpressionText());
				if(taskDefinition.getAssigneeExpression()!=null && !taskDefinition.getAssigneeExpression().equals("")){
					taskDefinition.getAssigneeExpression().getExpressionText();
					//System.out.println("实际办理人id："+taskDefinition.getAssigneeExpression().getExpressionText());
					nextTask.setNextAssigneeID(taskDefinition.getAssigneeExpression().getExpressionText());
					nextTask.setNextAssigneeName(userMap.get(taskDefinition.getAssigneeExpression().getExpressionText()));
				}
				if(taskDefinition.getCandidateGroupIdExpressions()!=null && !taskDefinition.getCandidateGroupIdExpressions().equals("")){
					set=taskDefinition.getCandidateGroupIdExpressions();
					for (Expression expression : set) {
						expression.getExpressionText();
						//System.out.println("候选组id："+expression.getExpressionText());
						nextTask.getNextGroupIDs().add(expression.getExpressionText());
						Map<String,String> roleUserMap=sysDicDataService.selectRoleUserDicMap("",expression.getExpressionText());
						nextTask.getUserMap().putAll(roleUserMap);
					}
				}
				if(taskDefinition.getCandidateUserIdExpressions()!=null && !taskDefinition.getCandidateUserIdExpressions().equals("")){
					set=taskDefinition.getCandidateUserIdExpressions();
					for (Expression expression : set) {
						expression.getExpressionText();
						//System.out.println("候选人id："+expression.getExpressionText());
						nextTask.getNextUserIDs().add(expression.getExpressionText());
						nextTask.getUserMap().put(expression.getExpressionText(), userMap.get(expression.getExpressionText()));
					}
				}
				if(taskDefinition.getFormKeyExpression()!=null && !taskDefinition.getFormKeyExpression().equals("")){
					taskDefinition.getFormKeyExpression().getExpressionText();
					//System.out.println("任务事项id："+taskDefinition.getFormKeyExpression().getExpressionText());
				}
				nextTaskList.add(nextTask);
			}*/
			/*System.out.println("=============------=============");
			System.out.println(JSON.toJSON(nextTaskGroup));
			System.out.println("=============end=============");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextTaskList;

	}
	/**
	 * 将任务定义转成下步任务
	 * @param lineName 
	 * @param taskDefinition
	 * @param userMap
	 * @return
	 */
	private Act_nextTask taskDefinitionToNextTask(String lineName, TaskDefinition taskDefinition, Map<String, String> userMap) {
		Set<Expression> set=null;
		Act_nextTask nextTask=new Act_nextTask();
		nextTask.setTaskType("userTask");
		nextTask.setNextLineName(lineName);
		//System.out.println("nextTaskGroup:"+taskDefinition.getKey());
		nextTask.setNextTaskDefKey(taskDefinition.getKey());
		nextTask.setNextTaskName(taskDefinition.getNameExpression().getExpressionText());
		if(taskDefinition.getAssigneeExpression()!=null && !taskDefinition.getAssigneeExpression().equals("")){
			taskDefinition.getAssigneeExpression().getExpressionText();
			//System.out.println("实际办理人id："+taskDefinition.getAssigneeExpression().getExpressionText());
			nextTask.setNextAssigneeID(taskDefinition.getAssigneeExpression().getExpressionText());
			nextTask.setNextAssigneeName(userMap.get(taskDefinition.getAssigneeExpression().getExpressionText()));
		}
		if(taskDefinition.getCandidateGroupIdExpressions()!=null && !taskDefinition.getCandidateGroupIdExpressions().equals("")){
			set=taskDefinition.getCandidateGroupIdExpressions();
			for (Expression expression : set) {
				expression.getExpressionText();
				//System.out.println("候选组id："+expression.getExpressionText());
				nextTask.getNextGroupIDs().add(expression.getExpressionText());
				Map<String,String> roleUserMap=sysDicDataService.selectRoleUserDicMap("",expression.getExpressionText());
				nextTask.getUserMap().putAll(roleUserMap);
			}
		}
		if(taskDefinition.getCandidateUserIdExpressions()!=null && !taskDefinition.getCandidateUserIdExpressions().equals("")){
			set=taskDefinition.getCandidateUserIdExpressions();
			for (Expression expression : set) {
				expression.getExpressionText();
				//System.out.println("候选人id："+expression.getExpressionText());
				nextTask.getNextUserIDs().add(expression.getExpressionText());
				nextTask.getUserMap().put(expression.getExpressionText(), userMap.get(expression.getExpressionText()));
			}
		}
		if(taskDefinition.getFormKeyExpression()!=null && !taskDefinition.getFormKeyExpression().equals("")){
			taskDefinition.getFormKeyExpression().getExpressionText();
			//System.out.println("任务事项id："+taskDefinition.getFormKeyExpression().getExpressionText());
		}
		return nextTask;
	}

	/** 
	 * 获取下一个用户任务信息  
	 * @param userMap 
	 * @param String taskId     任务Id信息  
	 * @return  下一个用户任务用户组信息  
	 * @throws Exception 
	 */  
	public List<Act_nextTask> getNextTaskInfo(String taskId, Map<String, String> userMap) throws Exception {  

		ProcessDefinitionEntity processDefinitionEntity = null;  

		String id = null;  

		List<Act_nextTask> task = null;  

		//获取流程实例Id信息   
		String processInstanceId = processEngine.getTaskService().createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();  

		//获取流程发布Id信息   
		String definitionId = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();  

		processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) processEngine.getRepositoryService())  
				.getDeployedProcessDefinition(definitionId);  

		ExecutionEntity execution = (ExecutionEntity) processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();  

		//当前流程节点Id信息   
		String activitiId = execution.getActivityId();    

		//获取流程所有节点信息   
		List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();   

		//遍历所有节点信息   
		for(ActivityImpl activityImpl : activitiList){      
			id = activityImpl.getId();     
			if (activitiId.equals(id)) {
				//获取下一个节点信息   
				task = nextTaskDefinition(activityImpl, activityImpl.getId(), null, processInstanceId,userMap); 
				break;
			}
		}  
		return task;  
	}  

	/**  
	 * 下一个任务节点信息,  
	 *  
	 * 如果下一个节点为用户任务则直接返回,  
	 *  
	 * 如果下一个节点为排他网关, 获取排他网关Id信息, 根据排他网关Id信息和execution获取流程实例排他网关Id为key的变量值,  
	 * 根据变量值分别执行排他网关后线路中的el表达式, 并找到el表达式通过的线路后的用户任务
	 * @param userMap 
	 * @param ActivityImpl activityImpl     流程节点信息  
	 * @param String activityId             当前流程节点Id信息  
	 * @param String elString               排他网关顺序流线段判断条件
	 * @param String processInstanceId      流程实例Id信息  
	 * @return  
	 */    
	private List<Act_nextTask> nextTaskDefinition(ActivityImpl activityImpl, String activityId, String elString, String processInstanceId, Map<String, String> userMap){   
		List<Act_nextTask> taskDefinitionList=new ArrayList<Act_nextTask>();
		PvmActivity ac = null;

		Object s = null;

		/*// 如果遍历节点为用户任务并且节点不是当前节点信息
		if ("userTask".equals(activityImpl.getProperty("type")) && !activityId.equals(activityImpl.getId())) {
			// 获取该节点下一个节点信息
			TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior()).getTaskDefinition();
			return taskDefinition;
		} else {*/
		// 获取节点所有流向线路信息
		List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();
		List<PvmTransition> outTransitionsTemp = null;
		for (PvmTransition tr : outTransitions) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			ac = tr.getDestination(); // 获取线路的终点节点
			
			/*System.out.println(">>>=============="+tr.getProperty("name"));
			System.out.println(">#################"+ac.getProperty("type"));
			System.out.println(">#################"+ac.getOutgoingTransitions());
			System.out.println(">#name:"+ac.getProperty("name"));
			System.out.println(">#toString:"+ac.toString());
			System.out.println(">#getClass:"+ac.getClass());*/
			
			// 如果流向线路为排他网关
			/*if ("exclusiveGateway".equals(ac.getProperty("type"))) {
					outTransitionsTemp = ac.getOutgoingTransitions();
					// 如果网关路线判断条件为空信息
					if (StringUtils.isEmpty(elString)) {
						// 获取流程启动时设置的网关判断条件信息
						elString = getGatewayCondition(ac.getId(), processInstanceId);
					}

					// 如果排他网关只有一条线路信息
					if (outTransitionsTemp.size() == 1) {
						taskDefinitionList.addAll(nextTaskDefinition((ActivityImpl) outTransitionsTemp.get(0).getDestination(), activityId,
								elString, processInstanceId));
					} else if (outTransitionsTemp.size() > 1) { // 如果排他网关有多条线路信息
						for (PvmTransition tr1 : outTransitionsTemp) {
							s = tr1.getProperty("conditionText"); // 获取排他网关线路判断条件信息
							// 判断el表达式是否成立
							if (isCondition(ac.getId(), StringUtils.trim(s.toString()), elString)) {
								taskDefinitionList.addAll( nextTaskDefinition((ActivityImpl) tr1.getDestination(), activityId, elString,
										processInstanceId));
							}
						}
					}
				} else*/ if ("userTask".equals(ac.getProperty("type"))) {
					taskDefinitionList.add(taskDefinitionToNextTask((String)tr.getProperty("name"),((UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).getTaskDefinition(),userMap));
					//} else if ("subProcess".equals(ac.getProperty("type"))) {
					//	taskDefinitionList.add(((SubProcessActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).);
				} else if ("endEvent".equals(ac.getProperty("type"))) {
					System.out.println(">>>>>"+((ActivityImpl) ac).getActivityBehavior().getClass());
					Act_nextTask nextTask=new Act_nextTask();
					nextTask.setNextTaskDefKey(ac.getId());
					nextTask.setNextTaskName((String)ac.getProperty("name"));
					nextTask.setNextLineName((String)tr.getProperty("name"));
					nextTask.setTaskType((String)ac.getProperty("type"));
					taskDefinitionList.add(nextTask);
					//taskDefinitionList.add(((UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).getTaskDefinition());
				} else {
					outTransitionsTemp = ac.getOutgoingTransitions();
					for (PvmTransition tr1 : outTransitionsTemp) {
						taskDefinitionList.addAll( nextTaskDefinition((ActivityImpl) tr1.getDestination(), activityId, elString,
								processInstanceId,userMap));
					}
				}
				//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		//System.out.println(">>>>>>taskDefinitionListSize"+taskDefinitionList.size());
		return taskDefinitionList;
		//}
	}  

	/** 
	 * 查询流程启动时设置排他网关判断条件信息  
	 * @param String gatewayId          排他网关Id信息, 流程启动时设置网关路线判断条件key为网关Id信息  
	 * @param String processInstanceId  流程实例Id信息  
	 * @return 
	 */  
	public String getGatewayCondition(String gatewayId, String processInstanceId) {  
		Execution execution = processEngine.getRuntimeService().createExecutionQuery().processInstanceId(processInstanceId).singleResult();
		Object object= processEngine.getRuntimeService().getVariable(execution.getId(), gatewayId);
		return object==null? "":object.toString();  
	}  

	/** 
	 * 根据key和value判断el表达式是否通过信息  
	 * @param String key    el表达式key信息  
	 * @param String el     el表达式信息  
	 * @param String value  el表达式传入值信息  
	 * @return 
	 */  
	public boolean isCondition(String key, String el, String value) {  
		ExpressionFactory factory = new ExpressionFactoryImpl();    
		SimpleContext context = new SimpleContext();    
		context.setVariable(key, factory.createValueExpression(value, String.class));    
		ValueExpression e = factory.createValueExpression(context, el, boolean.class);    
		return (Boolean) e.getValue(context);  
	}

	/**
	 * 根据任务id查询一个任务上配置的任务事项
	 * @param taskID
	 * @return
	 */
	public List<Gbpm_dicTaskManager> selectOneTaskFormItemList(String taskID, User userSession) {
		String form=processInstanceMapper.selectOneTaskFormItemInfo(taskID);
		String[] forms;
		if(form!=null && !form.equals("")){
			forms=form.split(",");
			String wheresql="";
			for (String string : forms) {
				wheresql=wheresql+"\'"+string+"\',";
			}
			wheresql=wheresql.substring(0, wheresql.length()-1);
			List<Gbpm_dicTaskManager> list=dicTaskManagerService.selectTaskManagerList(" and taskManager_ID in ("+wheresql+")",userSession);
			return list;
		}
		return null;
	}
	/**
	 * 查询历史任务集合
	 */
	public List<Act_nextTask> selectHisTaskList(String taskid){
		return null;
	}

}

package com.zjm.gbpm.db.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 运行中任务事项表gbpm_runTask
 * @author zky
 *
 */
public class Gbpm_runTask implements Serializable {
		private String 	runTask_ID	;//	运行中任务事项ID	varchar(32)
		private String 	productInstanceID	;//	产品实例ID	varchar(32)
		private String 	runNodeID	;//	运行节点ID	varchar(32)
		private String 	nodeNames	;//	节点名称	varchar(100)
		private String 	taskTypeID	;//	任务事项类型	varchar(32)
		private String 	taskCode	;//	事项编码	varchar(18)
		private String 	taskName	;//	任务事项名称	varchar(100)
		private String 	taskMangerID	;//	任务事项ID	varchar(100)
		private String 	taskUrl	;//	任务事项办理URL	varchar(200)
		private String viewTaskUrl;	//任务事项查看URL
		private Integer taskSort	;//	任务顺序	smallint
		private String 	operationType	;//	操作类型 选做类型  必做类型
		private Boolean	isBeforeTask	;//	是否有前置任务	bool
		private String 	beforeTaskID	;//	前置任务ID	varchar(32)
		private String 	beforeTaskName	;//	前置任务名称	varchar(32)
		private Boolean	isAfterTask	;//	是否有后置任务	bool
		private String	afterTaskIDList	;//	后置任务ID集合（可以多个逗号隔开）	text
		private String	afterTaskNameList	;//	后置任务ID集合（可以多个逗号隔开）	text
		private String	warnMethodIDList	;//	提醒方式ID集合（可以多个逗号隔开）	varchar(100)
		private String	warnMethodNameList	;//	提醒方式ID名称（可以多个逗号隔开）	varchar(100)
		private Boolean	isStartProcess	;//	是否启动流程	bool
		private String	operaterTypeID	;//	操作者类型ID	varchar(32)
		private String	operatorID	;//	操作者详细类型ID	varchar(32)
		private String	operatorName	;//	操作者详细类型名称	varchar(20)
		private String	operaterTypeName	;//	操作者类型名称	varchar(20)
		private String	assignUserID	;//	分配人ID	varchar(32)
		private String	assignUserName	;//	分配人名称	varchar(20)
		private Date	 assignDateTime	;//	分配时间	datetime
		private String	handleUserID	;//	办理人ID	varchar(32)
		private String	handleUserName	;//	办理人名称	varchar(20)
		private Date	handleDateTime	;//	办理完成时间	datetime
		private String	entrustUserID	;//	委托人ID	varchar(32)
		private String	entrustUserName	;//	委托人名称	varchar(20)
		private String	processID	;//	子流程ID	varchar(32)
		private String	processName	;//	子流程名称	varchar(32)
		private String	taskStatus	;//	任务状态	varchar(10)
		private String	unit_uid	;//	担保机构编号unit_uid	varchar(32)
		private String	unit_uidName	;//	担保机构名称	varchar(50)
		private String	updateUserName	;//	最后修改人姓名	varchar(20)
		private Date	updateDateTime	;//	最后修改时间	datetime
		
		private Integer number;//冗余字段 分组查询用
		
		/**=================冗余字段 productInstance表 start==============================**/
		private String entityID ; //业务ID
		private String entityName	;//	业务名称	varchar(200)
		private String productName	;//	产品名称	varchar(32)
		private String createUserName	;//	流程创建人名称	varchar(20)
		/**=================冗余字段 productInstance表 end==============================**/
		
		public String getRunTask_ID() {
			return runTask_ID;
		}
		public void setRunTask_ID(String runTask_ID) {
			this.runTask_ID = runTask_ID;
		}
		public String getProductInstanceID() {
			return productInstanceID;
		}
		public void setProductInstanceID(String productInstanceID) {
			this.productInstanceID = productInstanceID;
		}
		public String getRunNodeID() {
			return runNodeID;
		}
		public void setRunNodeID(String runNodeID) {
			this.runNodeID = runNodeID;
		}
		public String getNodeNames() {
			return nodeNames;
		}
		public void setNodeNames(String nodeNames) {
			this.nodeNames = nodeNames;
		}
		public String getTaskTypeID() {
			return taskTypeID;
		}
		public void setTaskTypeID(String taskTypeID) {
			this.taskTypeID = taskTypeID;
		}
		public String getTaskCode() {
			return taskCode;
		}
		public void setTaskCode(String taskCode) {
			this.taskCode = taskCode;
		}
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		public String getTaskUrl() {
			return taskUrl;
		}
		public void setTaskUrl(String taskUrl) {
			this.taskUrl = taskUrl;
		}
		public Integer getTaskSort() {
			return taskSort;
		}
		public void setTaskSort(Integer taskSort) {
			this.taskSort = taskSort;
		}
		public Boolean getIsBeforeTask() {
			return isBeforeTask;
		}
		public void setIsBeforeTask(Boolean isBeforeTask) {
			this.isBeforeTask = isBeforeTask;
		}
		public String getBeforeTaskID() {
			return beforeTaskID;
		}
		public void setBeforeTaskID(String beforeTaskID) {
			this.beforeTaskID = beforeTaskID;
		}
		public Boolean getIsAfterTask() {
			return isAfterTask;
		}
		public void setIsAfterTask(Boolean isAfterTask) {
			this.isAfterTask = isAfterTask;
		}
		public String getAfterTaskIDList() {
			return afterTaskIDList;
		}
		public void setAfterTaskIDList(String afterTaskIDList) {
			this.afterTaskIDList = afterTaskIDList;
		}
		public String getWarnMethodIDList() {
			return warnMethodIDList;
		}
		public void setWarnMethodIDList(String warnMethodIDList) {
			this.warnMethodIDList = warnMethodIDList;
		}
		public Boolean getIsStartProcess() {
			return isStartProcess;
		}
		public void setIsStartProcess(Boolean isStartProcess) {
			this.isStartProcess = isStartProcess;
		}
		public String getOperaterTypeID() {
			return operaterTypeID;
		}
		public void setOperaterTypeID(String operaterTypeID) {
			this.operaterTypeID = operaterTypeID;
		}
		public String getOperaterTypeName() {
			return operaterTypeName;
		}
		public void setOperaterTypeName(String operaterTypeName) {
			this.operaterTypeName = operaterTypeName;
		}
		public String getAssignUserID() {
			return assignUserID;
		}
		public void setAssignUserID(String assignUserID) {
			this.assignUserID = assignUserID;
		}
		public String getAssignUserName() {
			return assignUserName;
		}
		public void setAssignUserName(String assignUserName) {
			this.assignUserName = assignUserName;
		}
		public Date getAssignDateTime() {
			return assignDateTime;
		}
		public void setAssignDateTime(Date assignDateTime) {
			this.assignDateTime = assignDateTime;
		}
		public String getHandleUserID() {
			return handleUserID;
		}
		public void setHandleUserID(String handleUserID) {
			this.handleUserID = handleUserID;
		}
		public String getHandleUserName() {
			return handleUserName;
		}
		public void setHandleUserName(String handleUserName) {
			this.handleUserName = handleUserName;
		}
		public Date getHandleDateTime() {
			return handleDateTime;
		}
		public void setHandleDateTime(Date handleDateTime) {
			this.handleDateTime = handleDateTime;
		}
		public String getEntrustUserID() {
			return entrustUserID;
		}
		public void setEntrustUserID(String entrustUserID) {
			this.entrustUserID = entrustUserID;
		}
		public String getEntrustUserName() {
			return entrustUserName;
		}
		public void setEntrustUserName(String entrustUserName) {
			this.entrustUserName = entrustUserName;
		}
		public String getProcessID() {
			return processID;
		}
		public void setProcessID(String processID) {
			this.processID = processID;
		}
		public String getTaskStatus() {
			return taskStatus;
		}
		public void setTaskStatus(String taskStatus) {
			this.taskStatus = taskStatus;
		}
		public String getUnit_uid() {
			return unit_uid;
		}
		public void setUnit_uid(String unit_uid) {
			this.unit_uid = unit_uid;
		}
		public String getUnit_uidName() {
			return unit_uidName;
		}
		public void setUnit_uidName(String unit_uidName) {
			this.unit_uidName = unit_uidName;
		}
		public String getUpdateUserName() {
			return updateUserName;
		}
		public void setUpdateUserName(String updateUserName) {
			this.updateUserName = updateUserName;
		}
		public Date getUpdateDateTime() {
			return updateDateTime;
		}
		public void setUpdateDateTime(Date updateDateTime) {
			this.updateDateTime = updateDateTime;
		}
		public String getBeforeTaskName() {
			return beforeTaskName;
		}
		public void setBeforeTaskName(String beforeTaskName) {
			this.beforeTaskName = beforeTaskName;
		}
		public String getWarnMethodNameList() {
			return warnMethodNameList;
		}
		public void setWarnMethodNameList(String warnMethodNameList) {
			this.warnMethodNameList = warnMethodNameList;
		}
		public String getProcessName() {
			return processName;
		}
		public void setProcessName(String processName) {
			this.processName = processName;
		}
		public String getAfterTaskNameList() {
			return afterTaskNameList;
		}
		public void setAfterTaskNameList(String afterTaskNameList) {
			this.afterTaskNameList = afterTaskNameList;
		}
		public String getOperatorID() {
			return operatorID;
		}
		public void setOperatorID(String operatorID) {
			this.operatorID = operatorID;
		}
		public String getOperatorName() {
			return operatorName;
		}
		public void setOperatorName(String operatorName) {
			this.operatorName = operatorName;
		}
		public String getOperationType() {
			return operationType;
		}
		public void setOperationType(String operationType) {
			this.operationType = operationType;
		}
		public String getViewTaskUrl() {
			return viewTaskUrl;
		}
		public void setViewTaskUrl(String viewTaskUrl) {
			this.viewTaskUrl = viewTaskUrl;
		}
		public String getTaskMangerID() {
			return taskMangerID;
		}
		public void setTaskMangerID(String taskMangerID) {
			this.taskMangerID = taskMangerID;
		}
		public String getEntityName() {
			return entityName;
		}
		public void setEntityName(String entityName) {
			this.entityName = entityName;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getCreateUserName() {
			return createUserName;
		}
		public void setCreateUserName(String createUserName) {
			this.createUserName = createUserName;
		}
		public String getEntityID() {
			return entityID;
		}
		public void setEntityID(String entityID) {
			this.entityID = entityID;
		}
		public Integer getNumber() {
			return number;
		}
		public void setNumber(Integer number) {
			this.number = number;
		}
      
	
}

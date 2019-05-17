package com.zjm.gbpm.db.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 产品实例表gbpm_productInstance
 * @author chenyang
 *
 */
public class Gbpm_productInstance implements Serializable {
	
	private String productInstance_ID	;//	产品实例ID	varchar(32)
	private String entityType	;//	业务类型（区分申请、打包）	char(2) 01：申请  02：打包  03：风险方案
	private String entityID	;//	业务ID	varchar(32)
	private String entityName	;//	业务名称	varchar(200)
	private String productID	;//	产品ID	varchar(32)
	private String productName	;//	产品名称	varchar(32)
	private String createUserID	;//	创建人ID	varchar(32)
	private String createUserName	;//	创建人名称	varchar(20)
	private Date createDateTime	;//	创建时间	datetime
	private String productStatus	;//	产品状态	varchar(10)
	private Boolean isReturn;	//流程当前是否退回状态
	private String returnType;	//退回类型 01:修改后直接返回退回环节 02：修改后重走流程
	private String returnDesc;	//退回原因
	private String returnBeforeNodeID;	//退回前的环节ID
	private String unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String unit_uidName	;//	担保机构名称	varchar(50)
	private String updateUserName	;//	最后修改人姓名	varchar(20)
	private Date updateDateTime	;//	最后修改时间	datetime
	
	private String[] nodeTaskID; //冗余字段  接收前端传过来的参数
	private String[] handleUserID; //冗余字段 接收前端传过来的参数
	private String[] handleUserName; //冗余字段 接收前端传过来的参数
	private Integer nodeSort; //冗余字段 接收前端传过来的参数
	private String returnAfterNodeID; //冗余字段 退后后的环节ID
	private String finishTaskIDS; //冗余字段 选做退回环节上重做任务事项
	private String nodeTaskIDS; //冗余字段 人工分配环节上选做的任务事项
	
	public String getProductInstance_ID() {
		return productInstance_ID;
	}
	public void setProductInstance_ID(String productInstance_ID) {
		this.productInstance_ID = productInstance_ID;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityID() {
		return entityID;
	}
	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
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
	public String[] getNodeTaskID() {
		return nodeTaskID;
	}
	public void setNodeTaskID(String[] nodeTaskID) {
		this.nodeTaskID = nodeTaskID;
	}
	public String[] getHandleUserID() {
		return handleUserID;
	}
	public void setHandleUserID(String[] handleUserID) {
		this.handleUserID = handleUserID;
	}
	public String[] getHandleUserName() {
		return handleUserName;
	}
	public void setHandleUserName(String[] handleUserName) {
		this.handleUserName = handleUserName;
	}
	public Integer getNodeSort() {
		return nodeSort;
	}
	public void setNodeSort(Integer nodeSort) {
		this.nodeSort = nodeSort;
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
	public Boolean getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(Boolean isReturn) {
		this.isReturn = isReturn;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getReturnDesc() {
		return returnDesc;
	}
	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc;
	}
	public String getReturnBeforeNodeID() {
		return returnBeforeNodeID;
	}
	public void setReturnBeforeNodeID(String returnBeforeNodeID) {
		this.returnBeforeNodeID = returnBeforeNodeID;
	}
	public String getReturnAfterNodeID() {
		return returnAfterNodeID;
	}
	public void setReturnAfterNodeID(String returnAfterNodeID) {
		this.returnAfterNodeID = returnAfterNodeID;
	}
	public String getFinishTaskIDS() {
		return finishTaskIDS;
	}
	public void setFinishTaskIDS(String finishTaskIDS) {
		this.finishTaskIDS = finishTaskIDS;
	}
	public String getNodeTaskIDS() {
		return nodeTaskIDS;
	}
	public void setNodeTaskIDS(String nodeTaskIDS) {
		this.nodeTaskIDS = nodeTaskIDS;
	}

}

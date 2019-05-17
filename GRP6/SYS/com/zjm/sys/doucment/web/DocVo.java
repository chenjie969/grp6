package com.zjm.sys.doucment.web;
/**
 * @description   文档模板处理Vo
 * @company http://www.igit.com.cn/  
 * @author wuhn	
 * @date 2017年8月16日 下午7:23:13
*/
public class DocVo {
	private String  entityID; //实体id --申请id apply_ID
	private String  documentCode;// 文档编号
	private String  taskName;//文档开头
	private String  nodeID; //节点id
	private String  taskID; // 事项id
	private String  productInstanceID; //产品实例id
	
	
	public String getEntityID() {
		return entityID;
	}
	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getProductInstanceID() {
		return productInstanceID;
	}
	public void setProductInstanceID(String productInstanceID) {
		this.productInstanceID = productInstanceID;
	}
	
	
	
}

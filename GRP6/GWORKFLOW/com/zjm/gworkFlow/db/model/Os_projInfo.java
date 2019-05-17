package com.zjm.gworkFlow.db.model;

import java.sql.Timestamp;

/**
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-19 下午7:01:13 类说明：
 */
public class Os_projInfo {

	private Long FlowID; // 流程ID
	private String flowName;// 流程名称
	private String projID; // 项目id
	private String createUserID;
	private String createUserName;
	private Timestamp createTime;

	public Long getFlowID() {
		return FlowID;
	}

	public void setFlowID(Long flowID) {
		FlowID = flowID;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getProjID() {
		return projID;
	}

	public void setProjID(String projID) {
		this.projID = projID;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}

package com.zjm.gworkFlow.db.model;

import java.util.Date;

/**
 * 
 * @author mashuo
 *2015-5-27
 */
public class OsGworkflowNoticesuggest {

	private Integer opsuggest_ID;//流水号opsuggest_ID
	private String noticeID;//流水号
	private Long unit_uid;//担保机构编号unit_uid
	private Long user_uid;//用户编号user_uid
	private String stepname;//步骤中文名称stepname
	private String suggestcontent;//意见内容suggestcontent
	private String suggestresult;//意见结论suggestresult
	private Date suggesttime;// 意见填写时间suggesttime
	private Long flowid;//流程实例编号flowid
	private Long stepid;//步骤编号stepid
	private String departmentGID;//部门编号DepartmentGID

	private String user_name;//姓名
	
	
	private String wheresql;//条件sql
	private Long historyID;//历史步骤表自增id

	public Integer getOpsuggest_ID() {
		return opsuggest_ID;
	}

	public void setOpsuggest_ID(Integer opsuggest_ID) {
		this.opsuggest_ID = opsuggest_ID;
	}

	public Long getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(Long unit_uid) {
		this.unit_uid = unit_uid;
	}

	public Long getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(Long user_uid) {
		this.user_uid = user_uid;
	}

	public String getStepname() {
		return stepname;
	}

	public void setStepname(String stepname) {
		this.stepname = stepname;
	}

	public String getSuggestcontent() {
		return suggestcontent;
	}

	public void setSuggestcontent(String suggestcontent) {
		this.suggestcontent = suggestcontent;
	}

	public String getSuggestresult() {
		return suggestresult;
	}

	public void setSuggestresult(String suggestresult) {
		this.suggestresult = suggestresult;
	}

	public Date getSuggesttime() {
		return suggesttime;
	}

	public void setSuggesttime(Date suggesttime) {
		this.suggesttime = suggesttime;
	}

	public Long getFlowid() {
		return flowid;
	}

	public void setFlowid(Long flowid) {
		this.flowid = flowid;
	}

	public Long getStepid() {
		return stepid;
	}

	public void setStepid(Long stepid) {
		this.stepid = stepid;
	}

	public String getDepartmentGID() {
		return departmentGID;
	}

	public void setDepartmentGID(String departmentGID) {
		this.departmentGID = departmentGID;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getWheresql() {
		return wheresql;
	}

	public void setWheresql(String wheresql) {
		this.wheresql = wheresql;
	}

	public Long getHistoryID() {
		return historyID;
	}

	public void setHistoryID(Long historyID) {
		this.historyID = historyID;
	}

	public String getNoticeID() {
		return noticeID;
	}

	public void setNoticeID(String noticeID) {
		this.noticeID = noticeID;
	}



	
	

}

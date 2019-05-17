package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 评审会收费标准表pro_meetingCost
 */
public class Pro_meetingCost implements Serializable{
	private static final long serialVersionUID = 1L;
	private String meetingCost_ID;		//流水号
	private String meetingResolution_ID;//评审会决议ID
	private String applyID;				//业务申请ID
	private String costStandardID;		//收费标准ID
	private String remark;				//备注
	private String updateUserName;		//最后修改人姓名
	private Date updateDateTime;		//最后修改时间
	
	private String costStandardIDList;	//冗余字段,收费标准ID集合,接收前端数据用
	private String costName;			//冗余字段,费用名称
	private String costTypeName;		//冗余字段,费用类型名称
	private Float  costRate;			//冗余字段,费率
	private String costUnit;			//冗余字段,费率单位
	private Double calculateRate;		//冗余字段,计算用的费率
	private String culate;				//冗余字段,计算关系
		
	public String getMeetingCost_ID() {
		return meetingCost_ID;
	}
	public void setMeetingCost_ID(String meetingCost_ID) {
		this.meetingCost_ID = meetingCost_ID;
	}
	public String getMeetingResolution_ID() {
		return meetingResolution_ID;
	}
	public void setMeetingResolution_ID(String meetingResolution_ID) {
		this.meetingResolution_ID = meetingResolution_ID;
	}
	public String getApplyID() {
		return applyID;
	}
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}
	public String getCostStandardID() {
		return costStandardID;
	}
	public void setCostStandardID(String costStandardID) {
		this.costStandardID = costStandardID;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getCostStandardIDList() {
		return costStandardIDList;
	}
	public void setCostStandardIDList(String costStandardIDList) {
		this.costStandardIDList = costStandardIDList;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public String getCostTypeName() {
		return costTypeName;
	}
	public void setCostTypeName(String costTypeName) {
		this.costTypeName = costTypeName;
	}
	public Float getCostRate() {
		return costRate;
	}
	public void setCostRate(Float costRate) {
		this.costRate = costRate;
	}
	public String getCostUnit() {
		return costUnit;
	}
	public void setCostUnit(String costUnit) {
		this.costUnit = costUnit;
	}
	public Double getCalculateRate() {
		return calculateRate;
	}
	public void setCalculateRate(Double calculateRate) {
		this.calculateRate = calculateRate;
	}
	public String getCulate() {
		return culate;
	}
	public void setCulate(String culate) {
		this.culate = culate;
	}
	
}

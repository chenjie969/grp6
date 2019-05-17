package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 档案移交记录表Pro_arcMoveRec
 * @author sky
 *
 */
public class Pro_arcMoveRec implements Serializable{
	private static final long serialVersionUID = 1L;
	private String arcMoveRec_ID	;//档案移交ID	varchar	32
	private String apply_ID	;//	业务申请ID varchar	32
	private Date moveDate	;//	移交日期date	0
	private String moveUserName	;//移交人	varchar	20
	private Date acceptDate	;//接收日期	date	0
	private String acceptUserName	;//	接收人 varchar	20
	private String status	;//	状态:(未接收,已接收)varchar	10
	private String unit_uid	;//	结构id varchar	32
	private String updateUserName	;//	更新人 varchar	20
	private Date updateDateTime	;//更新日期	datetime	0
	
	private String operationType;//冗余字段,用于控制页面新增按钮与接收按钮
	private String type;//冗余字段,用于控制页面显示还是修改
	
	public String getArcMoveRec_ID() {
		return arcMoveRec_ID;
	}
	public void setArcMoveRec_ID(String arcMoveRec_ID) {
		this.arcMoveRec_ID = arcMoveRec_ID;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public Date getMoveDate() {
		return moveDate;
	}
	public void setMoveDate(Date moveDate) {
		this.moveDate = moveDate;
	}
	public String getMoveUserName() {
		return moveUserName;
	}
	public void setMoveUserName(String moveUserName) {
		this.moveUserName = moveUserName;
	}
	public Date getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}
	public String getAcceptUserName() {
		return acceptUserName;
	}
	public void setAcceptUserName(String acceptUserName) {
		this.acceptUserName = acceptUserName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
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
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

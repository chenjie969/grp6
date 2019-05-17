package com.zjm.oa.db.model;

import java.io.Serializable;

public class Hr_staffDuty implements Serializable {
	private String dutyID; // DutyID
	private String staffcase_Id;
	private String dutyName;//职务名称
	private String dutyDepGID; // 所属部门(DutyDepGID)
	private String dutyDepGIDName; // 所属部门Nmae(DutyDepGID)
	private String dutySuperior; // 直接上级(DutySuperior)
	private String superiorLV; // 职位等级(SuperiorLV)
	private String dutyDirection; // 晋升方向(DutyDirection)
	private String dutySalary; // 薪资标准(DutySalary)
	private String dutyNotes; // 备注(DutyNotes)
	public String getDutyID() {
		return dutyID;
	}
	public void setDutyID(String dutyID) {
		this.dutyID = dutyID;
	}
	public String getStaffcase_Id() {
		return staffcase_Id;
	}
	public void setStaffcase_Id(String staffcase_Id) {
		this.staffcase_Id = staffcase_Id;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	public String getDutyDepGID() {
		return dutyDepGID;
	}
	public void setDutyDepGID(String dutyDepGID) {
		this.dutyDepGID = dutyDepGID;
	}

	public String getDutySuperior() {
		return dutySuperior;
	}
	public void setDutySuperior(String dutySuperior) {
		this.dutySuperior = dutySuperior;
	}
	public String getSuperiorLV() {
		return superiorLV;
	}
	public void setSuperiorLV(String superiorLV) {
		this.superiorLV = superiorLV;
	}
	public String getDutyDirection() {
		return dutyDirection;
	}
	public void setDutyDirection(String dutyDirection) {
		this.dutyDirection = dutyDirection;
	}
	public String getDutySalary() {
		return dutySalary;
	}
	public void setDutySalary(String dutySalary) {
		this.dutySalary = dutySalary;
	}
	public String getDutyNotes() {
		return dutyNotes;
	}
	public void setDutyNotes(String dutyNotes) {
		this.dutyNotes = dutyNotes;
	}
	public String getDutyDepGIDName() {
		return dutyDepGIDName;
	}
	public void setDutyDepGIDName(String dutyDepGIDName) {
		this.dutyDepGIDName = dutyDepGIDName;
	}
	

}

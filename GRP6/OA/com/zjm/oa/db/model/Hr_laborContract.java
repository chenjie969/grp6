package com.zjm.oa.db.model;

import java.io.Serializable;
import java.util.Date;

public class Hr_laborContract implements Serializable {

	private String laborContractID; // laborContractID
	private String staffcase_Id;
	private Date laborContractStartDate; // 开始时间(laborContractStartDate)
	private Date laborContractEndDate; // 结束时间(laborContractEndDate)
	private String laborContractPeriod; // 签订期限(laborContractPeriod)
	private String laborContractType; // 合同类型(laborContractType)
	private Date laborContractDate; // 签订时间(laborContractDate)
	private String laborContractNotes; // 备注(laborContractNotes)
	
	public String getStaffcase_Id() {
		return staffcase_Id;
	}
	public void setStaffcase_Id(String staffcase_Id) {
		this.staffcase_Id = staffcase_Id;
	}
	public Date getLaborContractStartDate() {
		return laborContractStartDate;
	}
	public void setLaborContractStartDate(Date laborContractStartDate) {
		this.laborContractStartDate = laborContractStartDate;
	}
	public Date getLaborContractEndDate() {
		return laborContractEndDate;
	}
	public void setLaborContractEndDate(Date laborContractEndDate) {
		this.laborContractEndDate = laborContractEndDate;
	}
	public String getLaborContractPeriod() {
		return laborContractPeriod;
	}
	public void setLaborContractPeriod(String laborContractPeriod) {
		this.laborContractPeriod = laborContractPeriod;
	}
	public String getLaborContractType() {
		return laborContractType;
	}
	public void setLaborContractType(String laborContractType) {
		this.laborContractType = laborContractType;
	}
	public Date getLaborContractDate() {
		return laborContractDate;
	}
	public void setLaborContractDate(Date laborContractDate) {
		this.laborContractDate = laborContractDate;
	}
	public String getLaborContractNotes() {
		return laborContractNotes;
	}
	public void setLaborContractNotes(String laborContractNotes) {
		this.laborContractNotes = laborContractNotes;
	}
	public String getLaborContractID() {
		return laborContractID;
	}
	public void setLaborContractID(String laborContractID) {
		this.laborContractID = laborContractID;
	}
	

}

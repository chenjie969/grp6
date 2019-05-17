package com.zjm.oa.db.model;

import java.io.Serializable;
import java.util.Date;

public class Hr_medical implements Serializable {

	private String medicalID; // medicalID
	private String staffcase_Id;
	private Date medicalDate; // 体检日期(medicalDate)
	private Float medicalFees; // 体检费用(medicalFees)
	private String medicalInfo; // 体检情况(medicalInfo)
	private String medicalAgencies; // 体检医疗机构(medicalAgencies)
	private String medicalNotes; // 体检备注(medicalNotes)
	public String getMedicalID() {
		return medicalID;
	}
	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}
	public String getStaffcase_Id() {
		return staffcase_Id;
	}
	public void setStaffcase_Id(String staffcase_Id) {
		this.staffcase_Id = staffcase_Id;
	}
	public Date getMedicalDate() {
		return medicalDate;
	}
	public void setMedicalDate(Date medicalDate) {
		this.medicalDate = medicalDate;
	}
	public Float getMedicalFees() {
		return medicalFees;
	}
	public void setMedicalFees(Float medicalFees) {
		this.medicalFees = medicalFees;
	}
	public String getMedicalInfo() {
		return medicalInfo;
	}
	public void setMedicalInfo(String medicalInfo) {
		this.medicalInfo = medicalInfo;
	}
	public String getMedicalAgencies() {
		return medicalAgencies;
	}
	public void setMedicalAgencies(String medicalAgencies) {
		this.medicalAgencies = medicalAgencies;
	}
	public String getMedicalNotes() {
		return medicalNotes;
	}
	public void setMedicalNotes(String medicalNotes) {
		this.medicalNotes = medicalNotes;
	}
	

}

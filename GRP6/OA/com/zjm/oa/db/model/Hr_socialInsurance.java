package com.zjm.oa.db.model;

import java.io.Serializable;

public class Hr_socialInsurance implements Serializable {
	private String socialInsuranceID; // socialInsuranceID
	private String staffcase_Id;
	private String socialInsuranceDate; // 缴纳年月(socialInsuranceDate)
	private Float socialInsurancePension; // 养老保险(socialInsurancePension)
	private Float socialInsuranceInjury; // 工伤保险(socialInsuranceInjury)
	private Float socialInsuranceMedical; // 医疗保险(socialInsuranceMedical)
	private Float socialInsuranceFertility; // 生育保险(socialInsuranceFertility)
	private Float socialInsuranceUnemploy; // 失业保险(socialInsuranceUnemploy)
	private Float socialInsuranceCum; // 保险累计(socialInsuranceCum)
	private String socialInsuranceNotes; // 备注(socialInsuranceNotes)
	
	
	public String getSocialInsuranceID() {
		return socialInsuranceID;
	}
	public void setSocialInsuranceID(String socialInsuranceID) {
		this.socialInsuranceID = socialInsuranceID;
	}
	public String getStaffcase_Id() {
		return staffcase_Id;
	}
	public void setStaffcase_Id(String staffcase_Id) {
		this.staffcase_Id = staffcase_Id;
	}
	public String getSocialInsuranceDate() {
		return socialInsuranceDate;
	}
	public void setSocialInsuranceDate(String socialInsuranceDate) {
		this.socialInsuranceDate = socialInsuranceDate;
	}
	public Float getSocialInsurancePension() {
		return socialInsurancePension;
	}
	public void setSocialInsurancePension(Float socialInsurancePension) {
		this.socialInsurancePension = socialInsurancePension;
	}
	public Float getSocialInsuranceInjury() {
		return socialInsuranceInjury;
	}
	public void setSocialInsuranceInjury(Float socialInsuranceInjury) {
		this.socialInsuranceInjury = socialInsuranceInjury;
	}
	public Float getSocialInsuranceMedical() {
		return socialInsuranceMedical;
	}
	public void setSocialInsuranceMedical(Float socialInsuranceMedical) {
		this.socialInsuranceMedical = socialInsuranceMedical;
	}
	public Float getSocialInsuranceFertility() {
		return socialInsuranceFertility;
	}
	public void setSocialInsuranceFertility(Float socialInsuranceFertility) {
		this.socialInsuranceFertility = socialInsuranceFertility;
	}
	public Float getSocialInsuranceUnemploy() {
		return socialInsuranceUnemploy;
	}
	public void setSocialInsuranceUnemploy(Float socialInsuranceUnemploy) {
		this.socialInsuranceUnemploy = socialInsuranceUnemploy;
	}
	public Float getSocialInsuranceCum() {
		return socialInsuranceCum;
	}
	public void setSocialInsuranceCum(Float socialInsuranceCum) {
		this.socialInsuranceCum = socialInsuranceCum;
	}
	public String getSocialInsuranceNotes() {
		return socialInsuranceNotes;
	}
	public void setSocialInsuranceNotes(String socialInsuranceNotes) {
		this.socialInsuranceNotes = socialInsuranceNotes;
	}




}

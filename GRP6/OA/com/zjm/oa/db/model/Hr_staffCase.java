package com.zjm.oa.db.model;

import java.io.Serializable;
import java.util.Date;

public class Hr_staffCase implements Serializable {
	private String staffcase_Id;
	private String unit_uid; // 担保机构编号unit_uid
	private String user_uid; // user_uid
	private String staffDocuments; // 身份证编码(staffDocuments)
	private String staffPhotos; // 员工照片(staffPhotos)
	private String staffMarriage; // 员工婚姻状况(staffMarriage)
	private String staffMarriageName; // 员工婚姻状况Name(staffMarriage)
	private String staffPolitical; // 员工政治面貌(staffPolitical)
	private String staffPoliticalName; // 员工政治面貌Name(staffPolitical)
	private String staffBirthplace; // 员工籍贯(staffBirthplace)
	private String staffBirthplaceName; // 员工籍贯name(staffBirthplace)
	private String staffNational; // 员工民族(staffNational)
	private String staffNationalNmae; // 员工民族name(staffNational)
	private String staffAccountLocation; // 员工户口所在地(staffAccountLocation)
	private String staffEducation; // 员工学历(staffEducation)
	private String staffEducationName; // 员工学历name(staffEducation)
	private String staffTitle; // 员工职称(staffTitle)
	private String staffTitleName; // 员工职称Name(staffTitle)
	private String staffGraduateInstitutions; // 员工毕业院校(staffGraduateInstitutions)
	private String staffProfessional; // 员工专业(staffProfessional)
	private Date startWorkDate; // 参加工作时间(startWorkDate)
	private Date joinWorkDate; // 加入本单位时间(JoinWorkDate)
	private String staffType; // 员工类型(staffType)
	private String staffTypeName; // 员工类型(staffType)
	private String staffDuty; // 员工职务(staffDuty)
	private String staffHomeTEL; // 员工家庭电话(staffHomeTEL)
	private String staffHomeZIP; // 员工家庭邮编(staffHomeZIP)
	private String staffHomeADR; // 员工家庭地址(staffHomeADR)
	private Date staffStartContractDate; // 员工劳动合同开始时间(staffstartContractDate)
	private Date staffEndContractDate; // 员工劳动合同结束时间(staffEndContractDate)
	private Date staffRegularizedDate; // 员工转正日期(staffRegularizedDate)
	private String staffYearHoliday; // 员工年假(staffYearHoliday)
	private String staffNotes; // 员工备注(staffNotes)
	private String staffCensus; // 户籍性质(staffCensus)
	private String staffPeriod; // 试用期限(StaffPeriod)
	private String mobilphone; // 手机号mobilphone
	private String subphone; // 分机号subphone
	private String remark; // 备注remark
	private Date leavedate; // 离职日期
	private String leavereason; // 离职原因
	private String sex;//性别
	private Date borndate;//生日
	private String email;//电子邮箱	
	           
	private String user_name;//员工姓名
	private String user_bh;//员工编号
	private String depart_name;//部门名成

	


	public String getUser_bh() {
		return user_bh;
	}
	public void setUser_bh(String user_bh) {
		this.user_bh = user_bh;
	}


	private int birthdays; // 距离生日天数
	private int contractDays; // 距离合同到期日天数
	

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getStaffcase_Id() {
		return staffcase_Id;
	}
	public void setStaffcase_Id(String staffcase_Id) {
		this.staffcase_Id = staffcase_Id;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getUser_uid() {
		return user_uid;
	}
	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}
	public String getStaffDocuments() {
		return staffDocuments;
	}
	public void setStaffDocuments(String staffDocuments) {
		this.staffDocuments = staffDocuments;
	}
	public String getStaffPhotos() {
		return staffPhotos;
	}
	public void setStaffPhotos(String staffPhotos) {
		this.staffPhotos = staffPhotos;
	}
	public String getStaffMarriage() {
		return staffMarriage;
	}
	public void setStaffMarriage(String staffMarriage) {
		this.staffMarriage = staffMarriage;
	}
	public String getStaffPolitical() {
		return staffPolitical;
	}
	public void setStaffPolitical(String staffPolitical) {
		this.staffPolitical = staffPolitical;
	}
	public String getStaffBirthplace() {
		return staffBirthplace;
	}
	public void setStaffBirthplace(String staffBirthplace) {
		this.staffBirthplace = staffBirthplace;
	}
	public String getStaffNational() {
		return staffNational;
	}
	public void setStaffNational(String staffNational) {
		this.staffNational = staffNational;
	}
	public String getStaffAccountLocation() {
		return staffAccountLocation;
	}
	public void setStaffAccountLocation(String staffAccountLocation) {
		this.staffAccountLocation = staffAccountLocation;
	}
	public String getStaffEducation() {
		return staffEducation;
	}
	public void setStaffEducation(String staffEducation) {
		this.staffEducation = staffEducation;
	}
	public String getStaffTitle() {
		return staffTitle;
	}
	public void setStaffTitle(String staffTitle) {
		this.staffTitle = staffTitle;
	}
	public String getStaffGraduateInstitutions() {
		return staffGraduateInstitutions;
	}
	public void setStaffGraduateInstitutions(String staffGraduateInstitutions) {
		this.staffGraduateInstitutions = staffGraduateInstitutions;
	}
	public String getStaffProfessional() {
		return staffProfessional;
	}
	public void setStaffProfessional(String staffProfessional) {
		this.staffProfessional = staffProfessional;
	}
	public Date getStartWorkDate() {
		return startWorkDate;
	}
	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}
	public Date getJoinWorkDate() {
		return joinWorkDate;
	}
	public void setJoinWorkDate(Date joinWorkDate) {
		this.joinWorkDate = joinWorkDate;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getStaffDuty() {
		return staffDuty;
	}
	public void setStaffDuty(String staffDuty) {
		this.staffDuty = staffDuty;
	}
	public String getStaffHomeTEL() {
		return staffHomeTEL;
	}
	public void setStaffHomeTEL(String staffHomeTEL) {
		this.staffHomeTEL = staffHomeTEL;
	}
	public String getStaffHomeZIP() {
		return staffHomeZIP;
	}
	public void setStaffHomeZIP(String staffHomeZIP) {
		this.staffHomeZIP = staffHomeZIP;
	}
	public String getStaffHomeADR() {
		return staffHomeADR;
	}
	public void setStaffHomeADR(String staffHomeADR) {
		this.staffHomeADR = staffHomeADR;
	}
	public Date getStaffStartContractDate() {
		return staffStartContractDate;
	}
	public void setStaffStartContractDate(Date staffStartContractDate) {
		this.staffStartContractDate = staffStartContractDate;
	}
	public Date getStaffEndContractDate() {
		return staffEndContractDate;
	}
	public void setStaffEndContractDate(Date staffEndContractDate) {
		this.staffEndContractDate = staffEndContractDate;
	}
	public Date getStaffRegularizedDate() {
		return staffRegularizedDate;
	}
	public void setStaffRegularizedDate(Date staffRegularizedDate) {
		this.staffRegularizedDate = staffRegularizedDate;
	}
	public String getStaffYearHoliday() {
		return staffYearHoliday;
	}
	public void setStaffYearHoliday(String staffYearHoliday) {
		this.staffYearHoliday = staffYearHoliday;
	}
	public String getStaffNotes() {
		return staffNotes;
	}
	public void setStaffNotes(String staffNotes) {
		this.staffNotes = staffNotes;
	}
	public String getStaffCensus() {
		return staffCensus;
	}
	public void setStaffCensus(String staffCensus) {
		this.staffCensus = staffCensus;
	}
	public String getStaffPeriod() {
		return staffPeriod;
	}
	public void setStaffPeriod(String staffPeriod) {
		this.staffPeriod = staffPeriod;
	}
	public String getMobilphone() {
		return mobilphone;
	}
	public void setMobilphone(String mobilphone) {
		this.mobilphone = mobilphone;
	}
	public String getSubphone() {
		return subphone;
	}
	public void setSubphone(String subphone) {
		this.subphone = subphone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	public String getLeavereason() {
		return leavereason;
	}
	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBorndate() {
		return borndate;
	}
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public int getContractDays() {
		return contractDays;
	}
	public void setContractDays(int contractDays) {
		this.contractDays = contractDays;
	}
	public int getBirthdays() {
		return birthdays;
	}
	public void setBirthdays(int birthdays) {
		this.birthdays = birthdays;
	}
	public String getStaffBirthplaceName() {
		return staffBirthplaceName;
	}
	public void setStaffBirthplaceName(String staffBirthplaceName) {
		this.staffBirthplaceName = staffBirthplaceName;
	}
	public String getStaffNationalNmae() {
		return staffNationalNmae;
	}
	public void setStaffNationalNmae(String staffNationalNmae) {
		this.staffNationalNmae = staffNationalNmae;
	}
	public String getStaffEducationName() {
		return staffEducationName;
	}
	public void setStaffEducationName(String staffEducationName) {
		this.staffEducationName = staffEducationName;
	}
	public String getStaffMarriageName() {
		return staffMarriageName;
	}
	public void setStaffMarriageName(String staffMarriageName) {
		this.staffMarriageName = staffMarriageName;
	}
	public String getStaffPoliticalName() {
		return staffPoliticalName;
	}
	public void setStaffPoliticalName(String staffPoliticalName) {
		this.staffPoliticalName = staffPoliticalName;
	}
	public String getStaffTitleName() {
		return staffTitleName;
	}
	public void setStaffTitleName(String staffTitleName) {
		this.staffTitleName = staffTitleName;
	}
	public String getStaffTypeName() {
		return staffTypeName;
	}
	public void setStaffTypeName(String staffTypeName) {
		this.staffTypeName = staffTypeName;
	}

	
	
	
	
	
	
	
}

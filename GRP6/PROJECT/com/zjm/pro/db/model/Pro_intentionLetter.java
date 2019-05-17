package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 评审会产品明细表Pro_meetingDetail
 */
public class Pro_intentionLetter implements Serializable {
	private static final long serialVersionUID = 1L;
	private String intentionLetter_ID;//担保意向函ID  varchar(32)
	private String apply_ID	;//	业务申请ID	varchar(32)
	private String meetingDetail_ID	;//	评审会产品明细ID	varchar(32)
	private String intentionLetterCode;	//担保意向书编号 
	private String bankID	;//	合作机构ID(字典)	varchar(32)
	private String bankName	;//	合作机构名称 varchar(50)
	private String busiTypeID	;//	业务品种ID	varchar(32)
	private String busiTypeName	;//	业务品种名称 varchar(50)
	private Double agreeSum;// 同意金额
	private	Integer	periodMonth	;//	期限.月	Short integer
	private	Integer	periodDay	;//	期限.天	Short integer
	private	String	periodMonthDay	;//	期限.月天	Variable characters (20)
	private Date	createDate	;//	生成日期
	private	Integer	batchNumber	;//	批次
	private	String	status	;//	状态:未提交/待审批/已通过/被退回
	private	String	filePath	;//	文档路径	varchar(500)
	private	String	fileName	;//	文档名称	varchar(200)
	private String unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String unit_uidName	;//	担保机构名称	varchar(50)
	private String updateUserName	;//	最后修改人姓名	varchar(20)
	private Date updateDateTime	;//	最后修改时间	datetime
	
	private String mouldPath	;// 冗余字段, 模板文件的相对路径
	
	public String getIntentionLetter_ID() {
		return intentionLetter_ID;
	}
	public void setIntentionLetter_ID(String intentionLetter_ID) {
		this.intentionLetter_ID = intentionLetter_ID;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getMeetingDetail_ID() {
		return meetingDetail_ID;
	}
	public String getIntentionLetterCode() {
		return intentionLetterCode;
	}
	public void setIntentionLetterCode(String intentionLetterCode) {
		this.intentionLetterCode = intentionLetterCode;
	}
	public void setMeetingDetail_ID(String meetingDetail_ID) {
		this.meetingDetail_ID = meetingDetail_ID;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Double getAgreeSum() {
		return agreeSum;
	}
	public void setAgreeSum(Double agreeSum) {
		this.agreeSum = agreeSum;
	}
	public Integer getPeriodMonth() {
		return periodMonth;
	}
	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}
	public Integer getPeriodDay() {
		return periodDay;
	}
	public void setPeriodDay(Integer periodDay) {
		this.periodDay = periodDay;
	}
	public String getPeriodMonthDay() {
		return periodMonthDay;
	}
	public void setPeriodMonthDay(String periodMonthDay) {
		this.periodMonthDay = periodMonthDay;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
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
	public String getUnit_uidName() {
		return unit_uidName;
	}
	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
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
	public String getMouldPath() {
		return mouldPath;
	}
	public void setMouldPath(String mouldPath) {
		this.mouldPath = mouldPath;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBusiTypeID() {
		return busiTypeID;
	}
	public void setBusiTypeID(String busiTypeID) {
		this.busiTypeID = busiTypeID;
	}
	public String getBusiTypeName() {
		return busiTypeName;
	}
	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}
	
}

package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * 商机管理表 （咨询业务登记）
 */
public class Crm_apply implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String  capply_ID;		//流水号
	private String  applyNum;		//申请编号
	private String  receiveDeapartID;//接待部门UUID
	private String	receiveDeapartName;//接待部门名称
	private String  receiveUserID;	//接待人UUID
	private String	receiveUserName;//接待人名称
	private Date  	receiveDate;	//接待日期
	private String  approvalStatu;	//审批状态:	01受理中;02同意受理;03不同意受理
	private String	noAgreeDesc;	//不同意受理的理由
	private String  updateUserName;	//最后修改人姓名
	private Date  	updateDateTime;	//最后修改时间
	
	private String  clientType;		//客户类型:	01企业;02个人
	private String  clientName;		//客户名称
	private String  certificateCode;//统一社会信用代码（或个人的身份证）
	private String  clientSourceID;	//客户来源UUID
	private String	clientSourceName;//客户来源名称
	private String  clientSourceDesc;//来源说明
	private String  contact;		//联系人
	private String  phone;			//手机
	private String  telephone;		//固定电话
	private String  unit_uid;		//担保机构ID
	private String  unit_uidName;	//担保机构名称
	
	private String  busiTypeID;		//业务品种UUID
	private String  busiTypeName;	//业务品种名称
	private Double  applySum;		//申请金额
	private Integer  periodMonth;	//申请期限.月
	private Integer  periodDay;		//申请期限.天
	private String  periodMonthDay;	//申请期限.月天
	private String  cooperationID;	//合作机构UUID
	private String	cooperationName;//合作机构名称
	private String	loadUsed;		//贷款用途
	private String	repaymentPlan;	//还款计划与来源
	private String	provideGuaranty;//拟提供的保证措施
	
	private String receiveYear;		//冗余字段，生成编号时用
	

	public String getCapply_ID() {
		return capply_ID;
	}
	public void setCapply_ID(String capply_ID) {
		this.capply_ID = capply_ID;
	}
	public String getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCertificateCode() {
		return certificateCode;
	}
	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}
	public String getBusiTypeID() {
		return busiTypeID;
	}
	public void setBusiTypeID(String busiTypeID) {
		this.busiTypeID = busiTypeID;
	}
	public Double getApplySum() {
		return applySum;
	}
	public void setApplySum(Double applySum) {
		this.applySum = applySum;
	}
	public Integer getperiodMonth() {
		return periodMonth;
	}
	public void setperiodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}
	public Integer getperiodDay() {
		return periodDay;
	}
	public void setperiodDay(Integer periodDay) {
		this.periodDay = periodDay;
	}
	public String getPeriodMonthDay() {
		return periodMonthDay;
	}
	public void setPeriodMonthDay(String periodMonthDay) {
		this.periodMonthDay = periodMonthDay;
	}
	public String getCooperationID() {
		return cooperationID;
	}
	public void setCooperationID(String cooperationID) {
		this.cooperationID = cooperationID;
	}
	public String getClientSourceID() {
		return clientSourceID;
	}
	public void setClientSourceID(String clientSourceID) {
		this.clientSourceID = clientSourceID;
	}
	public String getClientSourceDesc() {
		return clientSourceDesc;
	}
	public void setClientSourceDesc(String clientSourceDesc) {
		this.clientSourceDesc = clientSourceDesc;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLoadUsed() {
		return loadUsed;
	}
	public void setLoadUsed(String loadUsed) {
		this.loadUsed = loadUsed;
	}
	public String getRepaymentPlan() {
		return repaymentPlan;
	}
	public void setRepaymentPlan(String repaymentPlan) {
		this.repaymentPlan = repaymentPlan;
	}
	public String getProvideGuaranty() {
		return provideGuaranty;
	}
	public void setProvideGuaranty(String provideGuaranty) {
		this.provideGuaranty = provideGuaranty;
	}
	public String getReceiveDeapartID() {
		return receiveDeapartID;
	}
	public void setReceiveDeapartID(String receiveDeapartID) {
		this.receiveDeapartID = receiveDeapartID;
	}
	public String getReceiveUserID() {
		return receiveUserID;
	}
	public void setReceiveUserID(String receiveUserID) {
		this.receiveUserID = receiveUserID;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getApprovalStatu() {
		return approvalStatu;
	}
	public void setApprovalStatu(String approvalStatu) {
		this.approvalStatu = approvalStatu;
	}
	public String getNoAgreeDesc() {
		return noAgreeDesc;
	}
	public void setNoAgreeDesc(String noAgreeDesc) {
		this.noAgreeDesc = noAgreeDesc;
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
	public String getBusiTypeName() {
		return busiTypeName;
	}
	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}
	public String getCooperationName() {
		return cooperationName;
	}
	public void setCooperationName(String cooperationName) {
		this.cooperationName = cooperationName;
	}
	public String getClientSourceName() {
		return clientSourceName;
	}
	public void setClientSourceName(String clientSourceName) {
		this.clientSourceName = clientSourceName;
	}
	public String getReceiveDeapartName() {
		return receiveDeapartName;
	}
	public void setReceiveDeapartName(String receiveDeapartName) {
		this.receiveDeapartName = receiveDeapartName;
	}
	public String getReceiveUserName() {
		return receiveUserName;
	}
	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}
	// 接待年份不提供set方法
	public String getReceiveYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(receiveDate);
        receiveYear = c.get(Calendar.YEAR)+"";
		return receiveYear;
	}
	public void setReceiveYear(String receiveYear) {
		this.receiveYear = receiveYear;
	}
	
	public String getApply_ID() {
		return capply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.capply_ID = apply_ID;
	}
	
}

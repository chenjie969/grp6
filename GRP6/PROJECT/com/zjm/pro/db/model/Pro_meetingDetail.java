package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评审会产品明细表Pro_meetingDetail
 */
public class Pro_meetingDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private String meetingDetail_ID	;//	评审会产品明细ID	varchar(32)
	private String meetingResolution_ID;//评审会决议ID  varchar(32)
	private String apply_ID	;//	业务申请ID	varchar(32)
	private String applyDetail_ID	;//	对应申请产品ID	varchar(32)
	private String busiTypeID	;//	业务品种ID	varchar(32)
	private String busiTypeName	;//	业务品种名称 varchar(50)
	private String bankTypeID	;//	合作机构类型名称ID(字典)	varchar(32)
	private String bantTypeName	;//	合作机构类型名称	varchar(20)
	private String bankID	;//	合作机构ID(字典)	varchar(32)
	private String bankName	;//	合作机构名称 varchar(50)
	private String subBankName	;//	合作子机构（或个人） varchar(100)
	private Double agreeSum;// 同意金额
	private Double guarantyScale;// 担保责任比例
	private String  guarantyScope;// 担保责任范围（本金或本息）
	private Double guarantyDutySum;// 担保责任金额
	private	Integer	periodMonth	;//	期限.月	Short integer
	private	Integer	periodDay	;//	期限.天	Short integer
	private	String	periodMonthDay	;//	期限.月天	Variable characters (20)
	private Float guarantyRate;//担保费率private	String	periodMonthDay	;
	private	String	costBase;//计费基数中文：按本息/按本金/按责任额)
	private Float reviewRate;//评审费率
	private Float serviceRate;//金融服务费率
	private Float bzScale;//保证金比例
	private Float interestRate;//利率
	private Float otherRateOne;//其他费率1
	private String otherRateOneDesc;//其他费率1说明
	private Float otherRateTwo;//其他费率2
	private String otherRateTwoDesc;//其他费率2说明
	private String unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String unit_uidName	;//	担保机构名称	varchar(50)
	private String updateUserName	;//	最后修改人姓名	varchar(20)
	private Date updateDateTime	;//	最后修改时间	datetime
	
	private List<Pro_loanPlan> loanPlanList;	//冗余字段, 此明细下的放款列表
	private List<Pro_project> projectList;	//冗余字段, 此明细下的保后（贷后）产品放款明细表列表
	
	private List<Pro_planPay> planPayList;//冗余字段,计划还款list
	private List<Pro_costMust> costMustList;//冗余字段,应收费用list
	private List<Pro_costFact> costFactList;//冗余字段,实收
	private List<Pro_costPre> costPreList;//冗余字段,预收
	private List<Pro_costReturn> costReturnList;//冗余字段,退费
	private List<Pro_cost> costList  ;//冗余字段,费用 （复核放款列表展示用）

	private List<Pro_intentionLetter> intentionLetterList;	//冗余字段, 担保意向函list
	
	public List<Pro_cost> getCostList() {
		return costList;
	}
	public void setCostList(List<Pro_cost> costList) {
		this.costList = costList;
	}
	public List<Pro_costFact> getCostFactList() {
		return costFactList;
	}
	public void setCostFactList(List<Pro_costFact> costFactList) {
		this.costFactList = costFactList;
	}
	public List<Pro_costPre> getCostPreList() {
		return costPreList;
	}
	public void setCostPreList(List<Pro_costPre> costPreList) {
		this.costPreList = costPreList;
	}
	public List<Pro_costReturn> getCostReturnList() {
		return costReturnList;
	}
	public void setCostReturnList(List<Pro_costReturn> costReturnList) {
		this.costReturnList = costReturnList;
	}
	public List<Pro_project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Pro_project> projectList) {
		this.projectList = projectList;
	}
	public List<Pro_loanPlan> getLoanPlanList() {
		return loanPlanList;
	}
	public void setLoanPlanList(List<Pro_loanPlan> loanPlanList) {
		this.loanPlanList = loanPlanList;
	}
	public String getMeetingDetail_ID() {
		return meetingDetail_ID;
	}
	public void setMeetingDetail_ID(String meetingDetail_ID) {
		this.meetingDetail_ID = meetingDetail_ID;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getApplyDetail_ID() {
		return applyDetail_ID;
	}
	public void setApplyDetail_ID(String applyDetail_ID) {
		this.applyDetail_ID = applyDetail_ID;
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
	public String getBankTypeID() {
		return bankTypeID;
	}
	public void setBankTypeID(String bankTypeID) {
		this.bankTypeID = bankTypeID;
	}
	public String getBantTypeName() {
		return bantTypeName;
	}
	public void setBantTypeName(String bantTypeName) {
		this.bantTypeName = bantTypeName;
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
	public String getSubBankName() {
		return subBankName;
	}
	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}
	public Double getAgreeSum() {
		return agreeSum;
	}
	public void setAgreeSum(Double agreeSum) {
		this.agreeSum = agreeSum;
	}
	public Double getGuarantyScale() {
		return guarantyScale;
	}
	public void setGuarantyScale(Double guarantyScale) {
		this.guarantyScale = guarantyScale;
	}
	public String getGuarantyScope() {
		return guarantyScope;
	}
	public void setGuarantyScope(String guarantyScope) {
		this.guarantyScope = guarantyScope;
	}
	public Double getGuarantyDutySum() {
		return guarantyDutySum;
	}
	public void setGuarantyDutySum(Double guarantyDutySum) {
		this.guarantyDutySum = guarantyDutySum;
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
	public Float getGuarantyRate() {
		return guarantyRate;
	}
	public void setGuarantyRate(Float guarantyRate) {
		this.guarantyRate = guarantyRate;
	}
	public String getCostBase() {
		return costBase;
	}
	public void setCostBase(String costBase) {
		this.costBase = costBase;
	}
	public Float getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(Float reviewRate) {
		this.reviewRate = reviewRate;
	}
	public Float getServiceRate() {
		return serviceRate;
	}
	public void setServiceRate(Float serviceRate) {
		this.serviceRate = serviceRate;
	}
	public Float getBzScale() {
		return bzScale;
	}
	public void setBzScale(Float bzScale) {
		this.bzScale = bzScale;
	}
	public Float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}
	public Float getOtherRateOne() {
		return otherRateOne;
	}
	public void setOtherRateOne(Float otherRateOne) {
		this.otherRateOne = otherRateOne;
	}
	public String getOtherRateOneDesc() {
		return otherRateOneDesc;
	}
	public void setOtherRateOneDesc(String otherRateOneDesc) {
		this.otherRateOneDesc = otherRateOneDesc;
	}
	public Float getOtherRateTwo() {
		return otherRateTwo;
	}
	public void setOtherRateTwo(Float otherRateTwo) {
		this.otherRateTwo = otherRateTwo;
	}
	public String getOtherRateTwoDesc() {
		return otherRateTwoDesc;
	}
	public void setOtherRateTwoDesc(String otherRateTwoDesc) {
		this.otherRateTwoDesc = otherRateTwoDesc;
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
	public String getMeetingResolution_ID() {
		return meetingResolution_ID;
	}
	public void setMeetingResolution_ID(String meetingResolution_ID) {
		this.meetingResolution_ID = meetingResolution_ID;
	}
	public List<Pro_planPay> getPlanPayList() {
		return planPayList;
	}
	public void setPlanPayList(List<Pro_planPay> planPayList) {
		this.planPayList = planPayList;
	}
	public List<Pro_costMust> getCostMustList() {
		return costMustList;
	}
	public void setCostMustList(List<Pro_costMust> costMustList) {
		this.costMustList = costMustList;
	}
	public List<Pro_intentionLetter> getIntentionLetterList() {
		return intentionLetterList;
	}
	public void setIntentionLetterList(List<Pro_intentionLetter> intentionLetterList) {
		this.intentionLetterList = intentionLetterList;
	}
	
}

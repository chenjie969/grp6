package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 业务申请产品信息表pro_applyDetail
 */
public class Pro_applyDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	private String 	applyDetail_ID;//	申请产品明细ID	varchar(32)
	private String 	apply_ID;//申请业务ID	varchar(32)
	private String 	client_ID;//客户ID	varchar(32)
	private String	clientTypeID;//	客户类型ID	varchar(32)
	private String 	clientGUID;//客户唯一标识	varchar(32)
	private String 	clientName;//客户名称	varchar(100)
	private String 	projectCode;//项目编号	varchar(20)
	private String 	busiNatureID;//业务性质ID	varchar(32)
	private String 	busiNatureName;//业务性质名称	varchar(20)
	private String 	AreaCodeID;//所属区域ID	varchar(32)
	private String  AreaCodeName;//所属区域名称	varchar(50)
	private String busiClass;//	业务大类（直接存中文名称）	Variable characters (50)
	private String 	busiTypeID;//业务品种ID	varchar(32)
	private String 	busiTypeName;//业务品种名称	varchar(50)
	private String 	projectTypeID;//项目类型ID	varchar(32)
	private String 	projectTypeName;//	项目类型名称	varchar(20)
	private String 	greenChannelID;//绿色通道ID	varchar(32)
	private String 	greenChannelName;//绿色通道名称	varchar(50)
	private String	bankTypeID;//合作机构类型ID	varchar(32)
	private String	bankTypeName;//合作机构类型名称	varchar(20)
	private String	bankID;//合作机构ID	varchar(32)
	private String	bankName;//合作机构名称	varchar(50)
	private String	subBankName;//合作子机构（或个人）	varchar(100)
	private Double	applySum;//申请金额	decimal(18,6)
	private Double	guarantyScale;//担保责任比例	decimal(18,6)
	private String	guarantyScope;//担保责任范围	varchar(20)
	private Double	guarantyDutySum;//担保责任金额	decimal(18,6)
	private Integer	periodMonth;//	申请期限.月	smallint
	private Integer	periodDay;//申请期限.天	 smallint
	private String	periodMonthDay;//申请期限.月天	varchar(20)
	private String	departID;//主办部门ID	varchar(32)
	private String	departName;//主办部门名称	varchar(50)
	private String	unit_uid;//担保机构编号unit_uid	varchar(32)
	private String	unit_uidName;//担保机构名称	varchar(50)
	private String	amanID;//A角ID	varchar(32)
	private String	amanName;//A角名称	varchar(20)
	private String	bmanID;//	B角ID	varchar(32)
	private String	bmanName;//B角名称	varchar(20)
	private String	reviewManID;//风控复核人ID	varchar(32)
	private String	reviewManName;//	风控复核人名称	varchar(20)
	private String	legalManID;//	法务评审人ID	varchar(32)
	private String	legalManName;//	法务评审人名称	varchar(20)
	private String	beforeAManID;//	移交前A角ID	varchar(32)
	private String	beforeBManID;//	移交前B角ID	varchar(32)
	private String	beforeReviewManID;//	移交前风控复核人ID	varchar(32)
	private String	beforeLegalManID;//	移交前法务评审人ID	varchar(32)
	private Date	changeDate;//移交时间	datetime
	private String	changeManID;//移交操作人ID	varchar(32)
	private Integer isMeeting;//	是否上会项目	Boolean
	//新加的字段
	private Date applyMeetingDate;//申请上会日期
	private String operationDepartID;//经办部门ID
	private String operationDepartName;//经办部门名称 
	private String applyMeetingUserName;//上会申请人名称
	private Date meetingSubmitDate;//申请上会提交日期
	private String meetingStatus;//上会状态（中文：待安排/未上会/已上会）
	
	private String	meetingTypeID;//上会类型ID	varchar(32)
	private String	meetingTypeName;//上会类型名称	varchar(20)
	private Date meetingDate;//	上会日期	Date
	//新加的字段
	private Integer	isResolution;//	是否已出具评审会决议	Boolean
	private String meetingCode;//评审会编号
	private String resolutionCode;//决议编号
	private String monitoredAsking;//在保监控要求
	private String meetingResult;//上会结果ID(字典，与决议结果字典相同)
	
	private Double	agreeSum;//评审/审批同意金额	decimal(18,6)
	private Integer	agreeMonth;//评审/审批同意期限.月	smallint
	private Integer	agreeDay;//评审/审批同意期限.天	smallint
	private String	agreeMonthDay;//评审/审批同意期限.月天	varchar(20)
	//新加字段
	private Float guarantyRate;//担保费率
	private Float reviewRate;//评审费率
	private Float serviceRate;//金融服务费率
	private Float bzScale;//保证金比例
	private Float interestRate;//利率
	private Float otherRateOne;//其他费率1
	private String otherRateOneDesc;//其他费率1说明
	private Float otherRateTwo;//其他费率2
	private String otherRateTwoDesc;//其他费率2说明
	
	
	private String	bcontractCode;//保证合同号	varchar(200)
	private String	dcontractCode;//委托担保合同号（委托贷款合同号）	varchar(200)
	private Date	contractBeginDate;//合同起始日期	date
	private Date	contractEndDate;//合同到期日期	date
	private String	jcontractCode;//借款合同号	varchar(200)
	private Integer	isCreditSubProject;//	是否综合授信子项目	Boolean
	private Integer	isStop=0;//是否否决项目	bool
	private Date	stopDate;//否决日期	date
	private String	stopTypeID;//否决类型ID	varchar(32)
	private String	stopTypeName;//否决类型名称	varchar(20)
	private String	stopDesc;//否决原因	varchar(2000)
	private String loanMethod;//	放款方式（中文：一次性放款/多次放款）	Variable characters (10)
	private String payMethod;//	还款方式（中文：一次性还款/多次还款）	Variable characters (10)
	private String InterestMethodID;//	结息方式ID（字典）
	private String InterestMethodName;//	结息方式名称
	private String	projectStageID;//项目阶段ID	varchar(32)
	private String	projectStageName;//项目阶段名称	varchar(20)
	private String	updateUserName;//最后修改人姓名	varchar(20)
	private Date	updateDateTime;//	最后修改时间	datetime
	
	
	//private String	loadUsed;//贷款（担保）用途	text
	//private Double	usedSum;//已用金额	decimal(18,6)
	private String	projectSourceID;//项目来源IDvarchar(32)( 冗余字段apply表)	
	private String	projectSourceName;//项目来源名称	varchar(20)( 冗余字段apply表)
	private String	sourceDesc;//来源说明	varchar(500)( 冗余字段apply表)
	//private String	repaymentPlan;//还款计划与来源	text
	//private String	provideGuaranty;//拟提供保证措施	text
	//private String	otherDesc;//申请其它说明	text
	//private String	juryIDs;//评委ID清单	text
	//private String	juryNames;//评委名称清单	text
	//private String	decisionTypeID;//决议结论类型ID	varchar(32)
	//private String	decisionTypeName;//决议结论类型名称	varchar(20)
	//private String	decisionContent;//	决议内容	text
	//private Double	guarantyRate;//评审/审批同意担保费率	decimal(18,6)
	//private String	guarantyUnit;//担保费率单位	varchar(10)
	//private Double	guarantyRateConverted;//担保费率换算为小数	decimal(18,6)
	//private Double	reviewRate;//	评审/审批同意评审费率	decimal(18,6)
	//private String	reviewUnit;//评审费率单位	varchar(10)
	//private Double	reviewRateConverted;//评审费率换算为小数	decimal(18,6)
	//private Double	bzScale;//评审/审批同意保证金占比	decimal(18,6)
	//private Integer	isUnpack=0;//是否拆包项目	bool
	
	private String busiDetails;//冗余字段;
	
	private String  projectType	;//单笔/多笔/关联/综合授信pro_Apply表字段
	private String	createManID;//	创建人ID(pro_Apply表字段)	
	private String	createManName;//	创建人名称(pro_Apply表字段)
	private Date	createDate;//	登记日期(pro_Apply表字段)
	private String	projectName;//	项目名称(pro_Apply表字段)
	private String 	parentApply_ID;//项目所对应的授信申请ID(pro_Apply表字段)
	private String	relationID;//	主体关联ID(pro_Apply表字段)
	private String	relationName;//	主体关联名称(pro_Apply表字段)
	private String applySumUse;//借款用途  (pro_Apply表字段)
	
	public String getApplySumUse() {
		return applySumUse;
	}
	public void setApplySumUse(String applySumUse) {
		this.applySumUse = applySumUse;
	}
	public Date getApplyMeetingDate() {
		return applyMeetingDate;
	}
	public void setApplyMeetingDate(Date applyMeetingDate) {
		this.applyMeetingDate = applyMeetingDate;
	}
	public String getOperationDepartID() {
		return operationDepartID;
	}
	public void setOperationDepartID(String operationDepartID) {
		this.operationDepartID = operationDepartID;
	}
	public String getOperationDepartName() {
		return operationDepartName;
	}
	public void setOperationDepartName(String operationDepartName) {
		this.operationDepartName = operationDepartName;
	}
	public String getApplyMeetingUserName() {
		return applyMeetingUserName;
	}
	public void setApplyMeetingUserName(String applyMeetingUserName) {
		this.applyMeetingUserName = applyMeetingUserName;
	}
	public Date getMeetingSubmitDate() {
		return meetingSubmitDate;
	}
	public void setMeetingSubmitDate(Date meetingSubmitDate) {
		this.meetingSubmitDate = meetingSubmitDate;
	}
	public String getMeetingStatus() {
		return meetingStatus;
	}
	public void setMeetingStatus(String meetingStatus) {
		this.meetingStatus = meetingStatus;
	}
	public Integer getIsResolution() {
		return isResolution;
	}
	public void setIsResolution(Integer isResolution) {
		this.isResolution = isResolution;
	}
	public String getMeetingCode() {
		return meetingCode;
	}
	public void setMeetingCode(String meetingCode) {
		this.meetingCode = meetingCode;
	}
	public String getResolutionCode() {
		return resolutionCode;
	}
	public void setResolutionCode(String resolutionCode) {
		this.resolutionCode = resolutionCode;
	}
	public String getMonitoredAsking() {
		return monitoredAsking;
	}
	public void setMonitoredAsking(String monitoredAsking) {
		this.monitoredAsking = monitoredAsking;
	}
	public String getMeetingResult() {
		return meetingResult;
	}
	public void setMeetingResult(String meetingResult) {
		this.meetingResult = meetingResult;
	}
	public Float getGuarantyRate() {
		return guarantyRate;
	}
	public void setGuarantyRate(Float guarantyRate) {
		this.guarantyRate = guarantyRate;
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
	
	
	
	//getter/setter
	
	public String getApplyDetail_ID() {
		return applyDetail_ID;
	}
	public void setApplyDetail_ID(String applyDetail_ID) {
		this.applyDetail_ID = applyDetail_ID;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getClientGUID() {
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientTypeID() {
		return clientTypeID;
	}
	public void setClientTypeID(String clientTypeID) {
		this.clientTypeID = clientTypeID;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getBusiNatureID() {
		return busiNatureID;
	}
	public void setBusiNatureID(String busiNatureID) {
		this.busiNatureID = busiNatureID;
	}
	public String getBusiNatureName() {
		return busiNatureName;
	}
	public void setBusiNatureName(String busiNatureName) {
		this.busiNatureName = busiNatureName;
	}
	public String getAreaCodeID() {
		return AreaCodeID;
	}
	public void setAreaCodeID(String areaCodeID) {
		AreaCodeID = areaCodeID;
	}
	public String getAreaCodeName() {
		return AreaCodeName;
	}
	public void setAreaCodeName(String areaCodeName) {
		AreaCodeName = areaCodeName;
	}
	public String getBusiClass() {
		return busiClass;
	}
	public void setBusiClass(String busiClass) {
		this.busiClass = busiClass;
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
	public String getProjectTypeID() {
		return projectTypeID;
	}
	public void setProjectTypeID(String projectTypeID) {
		this.projectTypeID = projectTypeID;
	}
	public String getProjectTypeName() {
		return projectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
	public String getGreenChannelID() {
		return greenChannelID;
	}
	public void setGreenChannelID(String greenChannelID) {
		this.greenChannelID = greenChannelID;
	}
	public String getGreenChannelName() {
		return greenChannelName;
	}
	public void setGreenChannelName(String greenChannelName) {
		this.greenChannelName = greenChannelName;
	}
	public String getBankTypeID() {
		return bankTypeID;
	}
	public void setBankTypeID(String bankTypeID) {
		this.bankTypeID = bankTypeID;
	}
	public String getBankTypeName() {
		return bankTypeName;
	}
	public void setBankTypeName(String bankTypeName) {
		this.bankTypeName = bankTypeName;
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
	public Double getApplySum() {
		return applySum;
	}
	public void setApplySum(Double applySum) {
		this.applySum = applySum;
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
	public String getDepartID() {
		return departID;
	}
	public void setDepartID(String departID) {
		this.departID = departID;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
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
	public String getAmanID() {
		return amanID;
	}
	public void setAmanID(String amanID) {
		this.amanID = amanID;
	}
	public String getAmanName() {
		return amanName;
	}
	public void setAmanName(String amanName) {
		this.amanName = amanName;
	}
	public String getBmanID() {
		return bmanID;
	}
	public void setBmanID(String bmanID) {
		this.bmanID = bmanID;
	}
	public String getBmanName() {
		return bmanName;
	}
	public void setBmanName(String bmanName) {
		this.bmanName = bmanName;
	}
	public String getReviewManID() {
		return reviewManID;
	}
	public void setReviewManID(String reviewManID) {
		this.reviewManID = reviewManID;
	}
	public String getReviewManName() {
		return reviewManName;
	}
	public void setReviewManName(String reviewManName) {
		this.reviewManName = reviewManName;
	}
	public String getBeforeAManID() {
		return beforeAManID;
	}
	public void setBeforeAManID(String beforeAManID) {
		this.beforeAManID = beforeAManID;
	}
	public String getBeforeBManID() {
		return beforeBManID;
	}
	public void setBeforeBManID(String beforeBManID) {
		this.beforeBManID = beforeBManID;
	}
	public String getBeforeReviewManID() {
		return beforeReviewManID;
	}
	public void setBeforeReviewManID(String beforeReviewManID) {
		this.beforeReviewManID = beforeReviewManID;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getChangeManID() {
		return changeManID;
	}
	public void setChangeManID(String changeManID) {
		this.changeManID = changeManID;
	}
	public Integer getIsMeeting() {
		return isMeeting;
	}
	public void setIsMeeting(Integer isMeeting) {
		this.isMeeting = isMeeting;
	}
	public String getMeetingTypeID() {
		return meetingTypeID;
	}
	public void setMeetingTypeID(String meetingTypeID) {
		this.meetingTypeID = meetingTypeID;
	}
	public String getMeetingTypeName() {
		return meetingTypeName;
	}
	public void setMeetingTypeName(String meetingTypeName) {
		this.meetingTypeName = meetingTypeName;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public Double getAgreeSum() {
		return agreeSum;
	}
	public void setAgreeSum(Double agreeSum) {
		this.agreeSum = agreeSum;
	}
	public Integer getAgreeMonth() {
		return agreeMonth;
	}
	public void setAgreeMonth(Integer agreeMonth) {
		this.agreeMonth = agreeMonth;
	}
	public Integer getAgreeDay() {
		return agreeDay;
	}
	public void setAgreeDay(Integer agreeDay) {
		this.agreeDay = agreeDay;
	}
	public String getAgreeMonthDay() {
		return agreeMonthDay;
	}
	public void setAgreeMonthDay(String agreeMonthDay) {
		this.agreeMonthDay = agreeMonthDay;
	}
	public String getBcontractCode() {
		return bcontractCode;
	}
	public void setBcontractCode(String bcontractCode) {
		this.bcontractCode = bcontractCode;
	}
	public String getDcontractCode() {
		return dcontractCode;
	}
	public void setDcontractCode(String dcontractCode) {
		this.dcontractCode = dcontractCode;
	}
	public Date getContractBeginDate() {
		return contractBeginDate;
	}
	public void setContractBeginDate(Date contractBeginDate) {
		this.contractBeginDate = contractBeginDate;
	}
	public Date getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public String getJcontractCode() {
		return jcontractCode;
	}
	public void setJcontractCode(String jcontractCode) {
		this.jcontractCode = jcontractCode;
	}
	public Integer getIsCreditSubProject() {
		return isCreditSubProject;
	}
	public void setIsCreditSubProject(Integer isCreditSubProject) {
		this.isCreditSubProject = isCreditSubProject;
	}
	public Integer getIsStop() {
		return isStop;
	}
	public void setIsStop(Integer isStop) {
		this.isStop = isStop;
	}
	public Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	public String getStopTypeID() {
		return stopTypeID;
	}
	public void setStopTypeID(String stopTypeID) {
		this.stopTypeID = stopTypeID;
	}
	public String getStopTypeName() {
		return stopTypeName;
	}
	public void setStopTypeName(String stopTypeName) {
		this.stopTypeName = stopTypeName;
	}
	public String getStopDesc() {
		return stopDesc;
	}
	public void setStopDesc(String stopDesc) {
		this.stopDesc = stopDesc;
	}
	public String getLoanMethod() {
		return loanMethod;
	}
	public void setLoanMethod(String loanMethod) {
		this.loanMethod = loanMethod;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getInterestMethodID() {
		return InterestMethodID;
	}
	public void setInterestMethodID(String interestMethodID) {
		InterestMethodID = interestMethodID;
	}
	public String getInterestMethodName() {
		return InterestMethodName;
	}
	public void setInterestMethodName(String interestMethodName) {
		InterestMethodName = interestMethodName;
	}
	public String getProjectStageID() {
		return projectStageID;
	}
	public void setProjectStageID(String projectStageID) {
		this.projectStageID = projectStageID;
	}
	public String getProjectStageName() {
		return projectStageName;
	}
	public void setProjectStageName(String projectStageName) {
		this.projectStageName = projectStageName;
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
	public String getBusiDetails() {
		return busiDetails;
	}
	public void setBusiDetails(String busiDetails) {
		this.busiDetails = busiDetails;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getCreateManID() {
		return createManID;
	}
	public void setCreateManID(String createManID) {
		this.createManID = createManID;
	}
	public String getCreateManName() {
		return createManName;
	}
	public void setCreateManName(String createManName) {
		this.createManName = createManName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getParentApply_ID() {
		return parentApply_ID;
	}
	public void setParentApply_ID(String parentApply_ID) {
		this.parentApply_ID = parentApply_ID;
	}
	public String getRelationID() {
		return relationID;
	}
	public void setRelationID(String relationID) {
		this.relationID = relationID;
	}
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	public String getProjectSourceID() {
		return projectSourceID;
	}
	public void setProjectSourceID(String projectSourceID) {
		this.projectSourceID = projectSourceID;
	}
	public String getProjectSourceName() {
		return projectSourceName;
	}
	public void setProjectSourceName(String projectSourceName) {
		this.projectSourceName = projectSourceName;
	}
	public String getSourceDesc() {
		return sourceDesc;
	}
	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}
	public String getLegalManID() {
		return legalManID;
	}
	public void setLegalManID(String legalManID) {
		this.legalManID = legalManID;
	}
	public String getLegalManName() {
		return legalManName;
	}
	public void setLegalManName(String legalManName) {
		this.legalManName = legalManName;
	}
	public String getBeforeLegalManID() {
		return beforeLegalManID;
	}
	public void setBeforeLegalManID(String beforeLegalManID) {
		this.beforeLegalManID = beforeLegalManID;
	}
	
}

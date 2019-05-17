package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 业务申请信息表pro_apply
 */
public class Pro_apply implements Serializable{
	private static final long serialVersionUID = 1L;
	private String	apply_ID;//	申请业务ID	varchar(32)
	private String  projectType	;//单笔/多笔/关联/综合授信	Variable characters (10)+++
	private String	client_ID;//	主体客户ID	varchar(32)
	private String	clientName;//	主体客户名称	varchar(100)
	private String	clientGUID;//	主体客户唯一标识	varchar(32)s
	private String	clientTypeID;//	客户类型ID	varchar(32)
	private String	relationID;//	主体关联ID	varchar(32)
	private String	relationName;//	主体关联名称	varchar(50)
	private String	busiCode;//	业务（授信）编号	varchar(20)
	private String	projectName;//	项目名称	varchar(200)
	private Double	applySum;//	业务/授信申请总金额	decimal(18,6)
	private String	busiTypeNameList;//	业务品种名称集合	text
	private String	bankNameList;//	合作机构名称集合	text
	private String	createManID;//	创建人ID	varchar(32)
	private String	createManName;//	创建人名称	varchar(20)
	private Date	createDate;//	登记日期	date
	private String	departID;//	部门ID	varchar(50)
	private String	departName;//	部门名称	varchar(50)
	private String	projectSourceID;//项目来源ID	varchar(32)+++
	private String	projectSourceName;//项目来源名称	varchar(20)+++
	private String	sourceDesc;//来源说明	varchar(500)+++
	private String	unit_uid;//	担保机构编号unit_uid	varchar(32)
	private String	unit_uidName;//	担保机构名称	varchar(50)
	private String	amanID;//A角ID	varchar(32)
	private String	amanName;//A角名称	varchar(20)
	private String	bmanID;//	B角ID	varchar(32)
	private String	bmanName;//B角名称	varchar(20)
	private String	reviewManID;//风控复核人ID	varchar(32)
	private String	reviewManName;//	风控复核人名称	varchar(20)
	private String	legalManID;//	法务评审人ID	varchar(32)
	private String	legalManName;//	法务评审人名称	varchar(20)
	private Integer isMeeting;// 是否上会项目, 一般根据申请金额大小自动设置是否需要上会
	private Date	applyMeetingDate;//申请上会日期
	private String	operationDepartID;//经办部门ID
	private String	operationDepartName;//经办部门名称
	private String	applyMeetingUserName;//上会申请人名称
	private Date	meetingSubmitDate;//申请上会提交日期
	private String	meetingStatus;//上会状态（中文：待安排/未上会/已上会）
	private String meetingTypeID;//上会类型ID
	private String meetingTypeName;//上会类型名称
	private Date meetingDate;//上会日期
	private Integer isResolution;//	是否已出具评审会决议	Boolean+++
	private String meetingCode;//	评审会编号	Variable characters (50)+++
	private String resolutionCode;//	决议编号	Variable characters (50)+++
	private String monitoredAsking;//	在保监控要求	Text+++
	private String meetingResult;//上会结果
	private Double	agreeSum;//	评审/审批同意金额	decimal(18,6)
	private Date	contractBeginDate;//	主合同起始日期	date
	private Date	contractEndDate;//	主合同到期日期	date
	private Integer	isPackage=0;//	是否被打包	bool
	private Integer isPutPackage=0;// 是否放入打包车	
	private String	package_ID;//	打包ID	varchar(32)
	private Integer	isStop=0;//	是否否决项目	bool
	private String	stopTypeID;//	否决类型	varchar(32)
	private String	stopTypeName;//	否决类型名称	varchar(20)
	private Date	stopDate;//	否决日期	date
	private String	stopDesc;//	否决原因	text
	private String checkCycleTypeID;//	检查周期类型ID（字典）	Variable characters (32)+++
	private String checkCycleTypeName;//	检查周期类型名称	Variable characters (20)+++
	private String	creditTypeID;//	授信类型ID	varchar(32)
	private String	creditTypeName;//	授信类型名称	varchar(20)
	private String	creditStatus;//	综合授信状态（以下字段为综合授信Begin）	Characters (2)
	private Integer	isLoopCredit;//	是否循环使用额度	bool
	private Integer	isBusiLimit;//	是否有品种限制	bool
	private Integer	isBlend;//	是否额度混用	bool
	private Double	usedSum;//	已用金额	decimal(18,6)
	private Double	usableSum;//	可用金额	decimal(18,6)
	private Date	creditBeginDate;//	授信起始日期	date
	private Date	creditEndDate;//	授信结束日期	date
	private String	dContractCode;//	最高额授委托担保合同号	varchar(200)
	private String	jContractCode;//	最高额授信借款合同号	varchar(200)
	private String	bContractCode;//	最高额授信保证合同号	varchar(200)
	private String	beforeAManID;//	移交前A角ID	varchar(32)
	private String	beforeBManID;//	移交前B角ID	varchar(32)
	private String	beforeReviewManID;//	移交前风控复核人ID	varchar(32)
	private String	beforeLegalManID;//	移交前法务评审人ID	varchar(32)
	private Date	changeDate;//移交时间	datetime
	private String	changeManID;//移交操作人ID	varchar(32)
	private Integer	isHistory=0;//	是否历史业务	bool
	private String productInstance_ID;//	产品流程实例ID	Variable characters (32)
	private String	projectStageID;//	业务阶段ID	varchar(32)
	private String	projectStageName;//	业务阶段名称	varchar(20)
	private String	projectJudge;//	项目完结评价	text
	private String	judgeManID;//	评价人ID	varchar(32)
	private String	judgeManName;//	评价人	varchar(20)
	private String	judgeDateTime;//	评价时间	date
	private String	updateUserName;//	最后修改人姓名	varchar(20)
	private Date	updateDateTime;//	最后修改时间	datetime
	private Integer	isContinue;//	是否续作项目	bool
	
	
	
	
	private String guarantyOrgName;//承保机构名称zky add 2017-9-13
	private String guarantyOrgID;//承保机构ID（字典） zky add 2017-9-13
	private String hostAreaName;//承保地区      zky add 2017-9-13
	private String hostAreaID;//承保地区  ID（字典）zky add 2017-9-13  
	private String oprationCompanyName;//经办公司名称zky add 2017-9-13:
	private String oprationCompanyID;//经办公司ID(字典)zky add 2017-9-13 
	private String attributionName;//属地划分名称zky add 2017-9-13
	private String attributionID;//属地划分ID（字典） zky add 2017-9-13:
	private String 	fundType     ;//资金方类型（中文：银行/非银行/个人）
	private String 	fundTypeID     ;//资金方类型（中文：银行/非银行/个人）ID
	private String 	fundID     ;//资金方（中文：银行/非银行/个人）ID
	private String 	fundChinese     ;//资金方中文名（中文：**银行/p2p,私募.../个人）
	private String 	fundName	;//资金方名称 (**分行/**p2p公司,../个人)
	private String 	fundSource	;//资金来源(省内/省外)
	//private String	optContractCode;//	最高额抵押合同号	text
	//private Integer	isSingle;//	是否单笔业务	bool
	//private Integer	isPlural;//	是否多笔业务	bool
	//private Integer	isCredit=0;//	是否授信客户额度业务	bool
	private String	parentApply_ID;//	授信额度ID	varchar(32)
	private Integer	isFirstApply;//	是否首次额度申请	bool
	
	private String proType;//业务类型(冗余字段);
	private String busiTableDate;	//冗余字段，授信申请有业务品种限制时，接收业务品种表格中的所有数据
	private List<Pro_applyDetail> detailList;	//冗余字段，该申请项下的所有申请明细列表
	
	private String taskName;	//冗余字段,任务事项用
	private String type;	//冗余字段,任务事项用, type=edti/view, 判断打开编辑还是修改页面
	
	private Integer applyNum;//冗余字段  查询项目进度显示每个进度下面有多少笔业务
	private String riskLevelName;//冗余字段 风险等级
	
	//以下是上会申请中用到	
	private String meetingApplyIDs ;//冗余字段, 接收申请上会时的多个id
	private String[] meetingApplyIDArr ;//冗余字段, 操作数据库批量更新上会状态时用
	//以下检查报告要用
	private String   unitAddress;//单位地址
	private String payMethod;//	放款方式（中文：一次性放款/多次放款）	Variable characters (10)
	//以下是录取评审会决议取基本信息时要用
	private String 	busiNatureID;//业务性质ID	varchar(32)
	private String 	busiNatureName;//业务性质名称	varchar(20)
	//新加字段，项目完结评价时用
	private Date endDate;//完结日期
	private Integer isEnd;//是否完结
	private String applySumUse;//借款用途  jchen add 2018-4-23
	
	public String getApplySumUse() {
		return applySumUse;
	}
	public void setApplySumUse(String applySumUse) {
		this.applySumUse = applySumUse;
	}
	public String getMeetingApplyIDs() {
		return meetingApplyIDs;
	}
	public void setMeetingApplyIDs(String meetingApplyIDs) {
		this.meetingApplyIDs = meetingApplyIDs;
	}
	private String mainStage;//业务大阶段（01保前、02保后）
	
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
	public String getMeetingResult() {
		return meetingResult;
	}
	public void setMeetingResult(String meetingResult) {
		this.meetingResult = meetingResult;
	}
	public String getMainStage() {
		return mainStage;
	}
	public void setMainStage(String mainStage) {
		this.mainStage = mainStage;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
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
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientGUID() {
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreditTypeID() {
		return creditTypeID;
	}
	public void setCreditTypeID(String creditTypeID) {
		this.creditTypeID = creditTypeID;
	}
	public String getCreditTypeName() {
		return creditTypeName;
	}
	public void setCreditTypeName(String creditTypeName) {
		this.creditTypeName = creditTypeName;
	}
	public Integer getIsLoopCredit() {
		return isLoopCredit;
	}
	public void setIsLoopCredit(Integer isLoopCredit) {
		this.isLoopCredit = isLoopCredit;
	}
	public Integer getIsBusiLimit() {
		return isBusiLimit;
	}
	public void setIsBusiLimit(Integer isBusiLimit) {
		this.isBusiLimit = isBusiLimit;
	}
	public Integer getIsBlend() {
		return isBlend;
	}
	public void setIsBlend(Integer isBlend) {
		this.isBlend = isBlend;
	}
	public Double getAgreeSum() {
		return agreeSum;
	}
	public void setAgreeSum(Double agreeSum) {
		this.agreeSum = agreeSum;
	}
	public Double getUsedSum() {
		return usedSum;
	}
	public void setUsedSum(Double usedSum) {
		this.usedSum = usedSum;
	}
	public String getBusiTypeNameList() {
		return busiTypeNameList;
	}
	public void setBusiTypeNameList(String busiTypeNameList) {
		this.busiTypeNameList = busiTypeNameList;
	}
	public String getBankNameList() {
		return bankNameList;
	}
	public void setBankNameList(String bankNameList) {
		this.bankNameList = bankNameList;
	}
	public Date getCreditBeginDate() {
		return creditBeginDate;
	}
	public void setCreditBeginDate(Date creditBeginDate) {
		this.creditBeginDate = creditBeginDate;
	}
	public Date getCreditEndDate() {
		return creditEndDate;
	}
	public void setCreditEndDate(Date creditEndDate) {
		this.creditEndDate = creditEndDate;
	}
	public String getdContractCode() {
		return dContractCode;
	}
	public void setdContractCode(String dContractCode) {
		this.dContractCode = dContractCode;
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
	public String getjContractCode() {
		return jContractCode;
	}
	public void setjContractCode(String jContractCode) {
		this.jContractCode = jContractCode;
	}
	public String getbContractCode() {
		return bContractCode;
	}
	public void setbContractCode(String bContractCode) {
		this.bContractCode = bContractCode;
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
	public Integer getIsPackage() {
		return isPackage;
	}
	public void setIsPackage(Integer isPackage) {
		this.isPackage = isPackage;
	}
	public String getPackage_ID() {
		return package_ID;
	}
	public void setPackage_ID(String package_ID) {
		this.package_ID = package_ID;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public Integer getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(Integer isHistory) {
		this.isHistory = isHistory;
	}
	public Integer getIsStop() {
		return isStop;
	}
	public void setIsStop(Integer isStop) {
		this.isStop = isStop;
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
	public Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	public String getStopDesc() {
		return stopDesc;
	}
	public void setStopDesc(String stopDesc) {
		this.stopDesc = stopDesc;
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
	public String getProductInstance_ID() {
		return productInstance_ID;
	}
	public void setProductInstance_ID(String productInstance_ID) {
		this.productInstance_ID = productInstance_ID;
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
	public Double getApplySum() {
		return applySum;
	}
	public void setApplySum(Double applySum) {
		this.applySum = applySum;
	}
	public String getBusiTableDate() {
		return busiTableDate;
	}
	public void setBusiTableDate(String busiTableDate) {
		this.busiTableDate = busiTableDate;
	}
	public void setIsPutPackage(Integer isPutPackage) {
		this.isPutPackage = isPutPackage;
	}
	public Integer getIsPutPackage() {
		return isPutPackage;
	}
	public List<Pro_applyDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<Pro_applyDetail> detailList) {
		this.detailList = detailList;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getClientTypeID() {
		return clientTypeID;
	}
	public void setClientTypeID(String clientTypeID) {
		this.clientTypeID = clientTypeID;
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
	public String getBeforeLegalManID() {
		return beforeLegalManID;
	}
	public void setBeforeLegalManID(String beforeLegalManID) {
		this.beforeLegalManID = beforeLegalManID;
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
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
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
	public String getCheckCycleTypeID() {
		return checkCycleTypeID;
	}
	public void setCheckCycleTypeID(String checkCycleTypeID) {
		this.checkCycleTypeID = checkCycleTypeID;
	}
	public String getCheckCycleTypeName() {
		return checkCycleTypeName;
	}
	public void setCheckCycleTypeName(String checkCycleTypeName) {
		this.checkCycleTypeName = checkCycleTypeName;
	}
	public String getParentApply_ID() {
		return parentApply_ID;
	}
	public void setParentApply_ID(String parentApply_ID) {
		this.parentApply_ID = parentApply_ID;
	}
	public Integer getIsFirstApply() {
		return isFirstApply;
	}
	public void setIsFirstApply(Integer isFirstApply) {
		this.isFirstApply = isFirstApply;
	}
	public Double getUsableSum() {
		return usableSum;
	}
	public void setUsableSum(Double usableSum) {
		this.usableSum = usableSum;
	}
	public String getProjectJudge() {
		return projectJudge;
	}
	public void setProjectJudge(String projectJudge) {
		this.projectJudge = projectJudge;
	}
	public String getJudgeManID() {
		return judgeManID;
	}
	public void setJudgeManID(String judgeManID) {
		this.judgeManID = judgeManID;
	}
	public String getJudgeManName() {
		return judgeManName;
	}
	public void setJudgeManName(String judgeManName) {
		this.judgeManName = judgeManName;
	}
	public String getJudgeDateTime() {
		return judgeDateTime;
	}
	public void setJudgeDateTime(String judgeDateTime) {
		this.judgeDateTime = judgeDateTime;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getGuarantyOrgName() {
		return guarantyOrgName;
	}
	public void setGuarantyOrgName(String guarantyOrgName) {
		this.guarantyOrgName = guarantyOrgName;
	}
	public String getGuarantyOrgID() {
		return guarantyOrgID;
	}
	public void setGuarantyOrgID(String guarantyOrgID) {
		this.guarantyOrgID = guarantyOrgID;
	}
	public String getHostAreaName() {
		return hostAreaName;
	}
	public void setHostAreaName(String hostAreaName) {
		this.hostAreaName = hostAreaName;
	}
	public String getHostAreaID() {
		return hostAreaID;
	}
	public void setHostAreaID(String hostAreaID) {
		this.hostAreaID = hostAreaID;
	}
	public String getOprationCompanyName() {
		return oprationCompanyName;
	}
	public void setOprationCompanyName(String oprationCompanyName) {
		this.oprationCompanyName = oprationCompanyName;
	}
	public String getOprationCompanyID() {
		return oprationCompanyID;
	}
	public void setOprationCompanyID(String oprationCompanyID) {
		this.oprationCompanyID = oprationCompanyID;
	}
	public String getAttributionName() {
		return attributionName;
	}
	public void setAttributionName(String attributionName) {
		this.attributionName = attributionName;
	}
	public String getAttributionID() {
		return attributionID;
	}
	public void setAttributionID(String attributionID) {
		this.attributionID = attributionID;
	}
	public Integer getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}
	public String getRiskLevelName() {
		return riskLevelName;
	}
	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName;
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
	public String[] getMeetingApplyIDArr() {
		return meetingApplyIDArr;
	}
	public void setMeetingApplyIDArr(String[] meetingApplyIDArr) {
		this.meetingApplyIDArr = meetingApplyIDArr;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}
	public String getFundSource() {
		return fundSource;
	}
	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}
	public Integer getIsContinue() {
		return isContinue;
	}
	public void setIsContinue(Integer isContinue) {
		this.isContinue = isContinue;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	public String getFundTypeID() {
		return fundTypeID;
	}
	public void setFundTypeID(String fundTypeID) {
		this.fundTypeID = fundTypeID;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getFundID() {
		return fundID;
	}
	public void setFundID(String fundID) {
		this.fundID = fundID;
	}
	public String getFundChinese() {
		return fundChinese;
	}
	public void setFundChinese(String fundChinese) {
		this.fundChinese = fundChinese;
	}
	
}

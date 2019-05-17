package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目诉讼登记表
 * @author jchen
 *
 */
public class Pro_projectLawsuit implements Serializable{
	private static final long serialVersionUID = 1L;
	private	String	projectLawsuit_ID	;//	流水号	varchar(32)
	private	String	recordNum	;//	案号	varchar(50)
	private	String	plaintiff	;//	原告	varchar(100)
	private	String	defendant	;//	被告	varchar(100)
	private	Double	lawsuitSum	;//	涉诉金额	decimal(18,6)
	private	Date	lawsuitDate	;//	起诉时间	date
	private	String	lawCourt	;//	管辖法院	varchar(200)
	private	String	caseInfo	;//	案件进展	text
	private	String	propertyInfo	;//	财产保全情况	text
	private	String	unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String  caseType    ;// 案件类型
	private String  dicTypeID    ;// 承保单位id
	private String  dicTypeName  ;// 承保单位名称
	private String  effectiveLegalDocuments    ;// 生效法律文书
	private String  firstSeal   ;// 财产查控情况(首封)
	private String  waiting     ;// 财产查控情况(轮候)
	private String  undertakeJudge    ;// 承办法官
	private Integer  plaintiffApplyExecute   ;// 原告是否申请执行 1是  0否 	
	private String 	executionBasisNum; //执行依据编号
	private String 	executionBasisType; //执行依据种类
	private String  province    ;//  省内/外   省内 省外
	private Integer  ifSentenceIdentical     ;// 是否与判决一致 1是  0否
	private Integer  ifReview    ;//  是否审结 1已审结 0未审结
	private String  otherPartyType    ;// 对方类型
	private Integer  ifWorkingGroup    ;// 是否工作组 1是  0否
	private String  remark      ;// 备注
	private	String	createUserName	;//	创建人姓名	varchar(20)
	private	Date	createDateTime	;//	创建时间	datetime
	private	String	updateUserName	;//	最后修改人姓名	varchar(20)
	private	Date	updateDateTime	;//	最后修改时间	datetime
	
	private String projectIDList; //关联项目id
	private String projectNameList; //关联项目名称
	private String fundDeduction; //资金扣划情况
	private String lawsuitType; //诉讼类型 01主诉 02被诉
	private String affiliateGroup; //涉及集团及所属公司
	private	String	assetSealUp_ID	;//	关联查封信息id
	private String assetSealUpName; //关联查封信息案号
	
	public String getProjectLawsuit_ID() {
		return projectLawsuit_ID;
	}
	public void setProjectLawsuit_ID(String projectLawsuit_ID) {
		this.projectLawsuit_ID = projectLawsuit_ID;
	}
	public String getRecordNum() {
		return recordNum;
	}
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	public String getPlaintiff() {
		return plaintiff;
	}
	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}
	public String getDefendant() {
		return defendant;
	}
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}
	public Double getLawsuitSum() {
		return lawsuitSum;
	}
	public void setLawsuitSum(Double lawsuitSum) {
		this.lawsuitSum = lawsuitSum;
	}
	public Date getLawsuitDate() {
		return lawsuitDate;
	}
	public void setLawsuitDate(Date lawsuitDate) {
		this.lawsuitDate = lawsuitDate;
	}
	public String getLawCourt() {
		return lawCourt;
	}
	public void setLawCourt(String lawCourt) {
		this.lawCourt = lawCourt;
	}
	public String getCaseInfo() {
		return caseInfo;
	}
	public void setCaseInfo(String caseInfo) {
		this.caseInfo = caseInfo;
	}
	public String getPropertyInfo() {
		return propertyInfo;
	}
	public void setPropertyInfo(String propertyInfo) {
		this.propertyInfo = propertyInfo;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	
	public String getDicTypeID() {
		return dicTypeID;
	}
	public void setDicTypeID(String dicTypeID) {
		this.dicTypeID = dicTypeID;
	}
	public String getDicTypeName() {
		return dicTypeName;
	}
	public void setDicTypeName(String dicTypeName) {
		this.dicTypeName = dicTypeName;
	}
	public String getEffectiveLegalDocuments() {
		return effectiveLegalDocuments;
	}
	public void setEffectiveLegalDocuments(String effectiveLegalDocuments) {
		this.effectiveLegalDocuments = effectiveLegalDocuments;
	}
	public String getFirstSeal() {
		return firstSeal;
	}
	public void setFirstSeal(String firstSeal) {
		this.firstSeal = firstSeal;
	}
	public String getWaiting() {
		return waiting;
	}
	public void setWaiting(String waiting) {
		this.waiting = waiting;
	}
	public String getUndertakeJudge() {
		return undertakeJudge;
	}
	public void setUndertakeJudge(String undertakeJudge) {
		this.undertakeJudge = undertakeJudge;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	public Integer getPlaintiffApplyExecute() {
		return plaintiffApplyExecute;
	}
	public void setPlaintiffApplyExecute(Integer plaintiffApplyExecute) {
		this.plaintiffApplyExecute = plaintiffApplyExecute;
	}
	
	public String getExecutionBasisNum() {
		return executionBasisNum;
	}
	public void setExecutionBasisNum(String executionBasisNum) {
		this.executionBasisNum = executionBasisNum;
	}
	public String getExecutionBasisType() {
		return executionBasisType;
	}
	public void setExecutionBasisType(String executionBasisType) {
		this.executionBasisType = executionBasisType;
	}
	public Integer getIfSentenceIdentical() {
		return ifSentenceIdentical;
	}
	public void setIfSentenceIdentical(Integer ifSentenceIdentical) {
		this.ifSentenceIdentical = ifSentenceIdentical;
	}
	public Integer getIfReview() {
		return ifReview;
	}
	public void setIfReview(Integer ifReview) {
		this.ifReview = ifReview;
	}
	public Integer getIfWorkingGroup() {
		return ifWorkingGroup;
	}
	public void setIfWorkingGroup(Integer ifWorkingGroup) {
		this.ifWorkingGroup = ifWorkingGroup;
	}
	public String getOtherPartyType() {
		return otherPartyType;
	}
	public void setOtherPartyType(String otherPartyType) {
		this.otherPartyType = otherPartyType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
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
	public String getProjectIDList() {
		return projectIDList;
	}
	public void setProjectIDList(String projectIDList) {
		this.projectIDList = projectIDList;
	}
	public String getProjectNameList() {
		return projectNameList;
	}
	public void setProjectNameList(String projectNameList) {
		this.projectNameList = projectNameList;
	}
	public String getFundDeduction() {
		return fundDeduction;
	}
	public void setFundDeduction(String fundDeduction) {
		this.fundDeduction = fundDeduction;
	}
	public String getLawsuitType() {
		return lawsuitType;
	}
	public void setLawsuitType(String lawsuitType) {
		this.lawsuitType = lawsuitType;
	}
	public String getAssetSealUp_ID() {
		return assetSealUp_ID;
	}
	public void setAssetSealUp_ID(String assetSealUp_ID) {
		this.assetSealUp_ID = assetSealUp_ID;
	}
	public String getAssetSealUpName() {
		return assetSealUpName;
	}
	public void setAssetSealUpName(String assetSealUpName) {
		this.assetSealUpName = assetSealUpName;
	}
	public String getAffiliateGroup() {
		return affiliateGroup;
	}
	public void setAffiliateGroup(String affiliateGroup) {
		this.affiliateGroup = affiliateGroup;
	}
	

}

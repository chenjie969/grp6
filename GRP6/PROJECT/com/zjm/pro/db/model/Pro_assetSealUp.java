package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 资产查封信息表
 * @author jchen
 *
 */
public class Pro_assetSealUp implements Serializable{
	private static final long serialVersionUID = 1L;
	private	String	assetSealUp_ID;	//流水号		
	private	String	project_ID;	//项目ID		
	private	String	serialNum;	//案件序号		
	private	String	applyPerson;	//申请人		
	private	String	busiType;	//业务类型（担保项目、委贷项目）		
	private	Double	targetSum;	//执行标的	
	private	String	plaintiff	;//	申请执行人	varchar(100)
	private	String	defendant	;//	被执行人	varchar(100)
	private	Date	lawsuitDate	;//	立案日期	date
	private String  effectiveLegalDocuments    ;// 生效法律文书
	private String  firstSeal   ;// 财产查控情况(首封)
	private String  waiting     ;// 财产查控情况(轮候)
	private Double  firstSealAssetValue    ;// 首封资产价值
	private Integer  ifWorkingGroup    ;// 是否工作组  1是  0否	
	private	String	propertyType;	//资产保全方式		
	private	Integer	isRecord;	//是否立案		
	private	String	recordNum;	//案号		
	private	String	lawCourt;	//受理法院		
	private	String	executeBasis;	//执行依据		
	private	String	remark;	//负责法院或其他备注信息		
	private	String	unit_uid;	//担保机构编号unit_uid		
	private	String	createUserName;//	创建人姓名		
	private	Date	createDateTime;	//创建时间		
	private	String	updateUserName;	//最后修改人姓名		
	private	Date 	updateDateTime;	//最后修改时间	
	private String isRecordName;//冗余字段
	
	private String projectIDList; //关联项目id
	private String projectNameList; //关联项目名称
	private String affiliateGroup; //涉及公司名称
	private String assetSealUpType; //查封类型 01 作为申请人 02作为被执行人
	
	/**冗余字段*/
	private String isConSuit; //是否关联诉讼
	private String lawSuitID; //关联诉讼id
	private String lawSuitName; //关联诉讼案号
	
	public String getAssetSealUp_ID() {
		return assetSealUp_ID;
	}
	public void setAssetSealUp_ID(String assetSealUp_ID) {
		this.assetSealUp_ID = assetSealUp_ID;
	}
	public String getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public Double getTargetSum() {
		return targetSum;
	}
	public void setTargetSum(Double targetSum) {
		this.targetSum = targetSum;
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
	public Date getLawsuitDate() {
		return lawsuitDate;
	}
	public void setLawsuitDate(Date lawsuitDate) {
		this.lawsuitDate = lawsuitDate;
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

	public Double getFirstSealAssetValue() {
		return firstSealAssetValue;
	}
	public void setFirstSealAssetValue(Double firstSealAssetValue) {
		this.firstSealAssetValue = firstSealAssetValue;
	}

	public Integer getIfWorkingGroup() {
		return ifWorkingGroup;
	}
	public void setIfWorkingGroup(Integer ifWorkingGroup) {
		this.ifWorkingGroup = ifWorkingGroup;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	public Integer getIsRecord() {
		return isRecord;
	}
	public void setIsRecord(Integer isRecord) {
		this.isRecord = isRecord;
	}
	public String getRecordNum() {
		return recordNum;
	}
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	public String getLawCourt() {
		return lawCourt;
	}
	public void setLawCourt(String lawCourt) {
		this.lawCourt = lawCourt;
	}
	public String getExecuteBasis() {
		return executeBasis;
	}
	public void setExecuteBasis(String executeBasis) {
		this.executeBasis = executeBasis;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getIsRecordName() {
		return isRecordName;
	}
	public void setIsRecordName(String isRecordName) {
		this.isRecordName = isRecordName;
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
	public String getAssetSealUpType() {
		return assetSealUpType;
	}
	public void setAssetSealUpType(String assetSealUpType) {
		this.assetSealUpType = assetSealUpType;
	}
	public String getLawSuitID() {
		return lawSuitID;
	}
	public void setLawSuitID(String lawSuitID) {
		this.lawSuitID = lawSuitID;
	}
	public String getLawSuitName() {
		return lawSuitName;
	}
	public void setLawSuitName(String lawSuitName) {
		this.lawSuitName = lawSuitName;
	}
	public String getIsConSuit() {
		return isConSuit;
	}
	public void setIsConSuit(String isConSuit) {
		this.isConSuit = isConSuit;
	}
	public String getAffiliateGroup() {
		return affiliateGroup;
	}
	public void setAffiliateGroup(String affiliateGroup) {
		this.affiliateGroup = affiliateGroup;
	}

}
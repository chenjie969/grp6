package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 代偿明细表
 */
public class Pro_replace implements Serializable{
	private static final long serialVersionUID = 1L;
	private String	replace_ID;             //代偿明细ID  varchar(32) not null,
	private String   project_ID;            //项目ID  varchar(32) not null,
	private String   apply_ID;            //申请ID  varchar(32) not null,
	private Date   replaceDate;        		//代偿日期  date,上报日期
	private Date   replaceFactDate;        		//代偿日期  date,
	private Double   replaceSum;            //代偿金额  decimal(18,6),
	private Double   replaceCapitalSum;     //分类1其中：代偿本金 decimal(18,6),
	private Double   replaceInterestSum;    //分类1其中代偿利息： decimal(18,6),
	private Double   replaceOtherSum;       //分类1其中：代偿其它	 decimal(18,6),
	private Double   selfReplaceSum ;       //分类2其中：自有资金代偿 decimal(18,6),
	private Double   dangerReplaceSum;      //分类2其中：准备金冲抵  decimal(18,6),
	private String   repalceState;          //代偿审批状态（中文：待审批/审批中/通过/未通过） varchar(10),
	private String   remark;                //备注  varchar(200),
	private String   unit_uid;              //担保机构编号 varchar(32) not null,
	private String   updateUserName;        //最后修改人姓名 varchar(20),
	private Date   updateDateTime;        //最后修改时间 datetime,
	private String   replaceReason;        //代偿原因,
	private Integer isUseRepay; //代偿是否用于还款

	private String projectName;//pro_apply冗余字段
	private String bankName;//pro_project冗余字段
	private String busiTypeName;//pro_project冗余字段
	private String projectCode;//pro_project冗余字段
	private List<Pro_projectfiles> projectfilesList ; //附件冗余字段
	
	public List<Pro_projectfiles> getProjectfilesList() {
		return projectfilesList;
	}
	public void setProjectfilesList(List<Pro_projectfiles> projectfilesList) {
		this.projectfilesList = projectfilesList;
	}
	public String getReplaceReason() {
		return replaceReason;
	}
	public void setReplaceReason(String replaceReason) {
		this.replaceReason = replaceReason;
	}
	public String getReplace_ID() {
		return replace_ID;
	}
	public void setReplace_ID(String replace_ID) {
		this.replace_ID = replace_ID;
	}
	public String getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
	}
	public Date getReplaceDate() {
		return replaceDate;
	}
	public void setReplaceDate(Date replaceDate) {
		this.replaceDate = replaceDate;
	}
	public Double getReplaceSum() {
		return replaceSum;
	}
	public void setReplaceSum(Double replaceSum) {
		this.replaceSum = replaceSum;
	}
	public Double getReplaceCapitalSum() {
		return replaceCapitalSum;
	}
	public void setReplaceCapitalSum(Double replaceCapitalSum) {
		this.replaceCapitalSum = replaceCapitalSum;
	}
	public Double getReplaceInterestSum() {
		return replaceInterestSum;
	}
	public void setReplaceInterestSum(Double replaceInterestSum) {
		this.replaceInterestSum = replaceInterestSum;
	}
	public Double getReplaceOtherSum() {
		return replaceOtherSum;
	}
	public void setReplaceOtherSum(Double replaceOtherSum) {
		this.replaceOtherSum = replaceOtherSum;
	}
	public Double getSelfReplaceSum() {
		return selfReplaceSum;
	}
	public void setSelfReplaceSum(Double selfReplaceSum) {
		this.selfReplaceSum = selfReplaceSum;
	}
	public Double getDangerReplaceSum() {
		return dangerReplaceSum;
	}
	public void setDangerReplaceSum(Double dangerReplaceSum) {
		this.dangerReplaceSum = dangerReplaceSum;
	}
	public String getRepalceState() {
		return repalceState;
	}
	public void setRepalceState(String repalceState) {
		this.repalceState = repalceState;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBusiTypeName() {
		return busiTypeName;
	}
	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public Date getReplaceFactDate() {
		return replaceFactDate;
	}
	public void setReplaceFactDate(Date replaceFactDate) {
		this.replaceFactDate = replaceFactDate;
	}
	public Integer getIsUseRepay() {
		return isUseRepay;
	}
	public void setIsUseRepay(Integer isUseRepay) {
		this.isUseRepay = isUseRepay;
	}
	
}

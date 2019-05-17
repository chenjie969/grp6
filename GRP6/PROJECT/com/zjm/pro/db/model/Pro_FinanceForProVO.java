package com.zjm.pro.db.model;

import java.io.Serializable;

/**
 * 以项目维度查询所有的财务收费信息
 * @author Administrator
 *
 */
public class Pro_FinanceForProVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String apply_ID;	//项目申请ID
	private String applyDetail_ID;	//项目申请明细ID
	private String projectCode;	//项目编号
	private String projectName;	//项目名称
	private Double agreeSum;	//同意金额
	private String agreeMonthDay;	//同意期限
	private String busiTypeID;	//业务品种ID
	private String busiTypeName;//业务品种名称
	
	//担保费金额
	private Double costSum_dbf_ying;	//应收
	private Double costSum_dbf_yu;		//预收
	private Double costSum_dbf_shi;		//实收
	//评审费金额
	private Double costSum_psf_ying;	//应收
	private Double costSum_psf_yu;		//预收
	private Double costSum_psf_shi;		//实收
	
	
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
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Double getAgreeSum() {
		return agreeSum;
	}
	public void setAgreeSum(Double agreeSum) {
		this.agreeSum = agreeSum;
	}
	public String getAgreeMonthDay() {
		return agreeMonthDay;
	}
	public void setAgreeMonthDay(String agreeMonthDay) {
		this.agreeMonthDay = agreeMonthDay;
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
	public Double getCostSum_dbf_ying() {
		return costSum_dbf_ying;
	}
	public void setCostSum_dbf_ying(Double costSum_dbf_ying) {
		this.costSum_dbf_ying = costSum_dbf_ying;
	}
	public Double getCostSum_dbf_yu() {
		return costSum_dbf_yu;
	}
	public void setCostSum_dbf_yu(Double costSum_dbf_yu) {
		this.costSum_dbf_yu = costSum_dbf_yu;
	}
	public Double getCostSum_dbf_shi() {
		return costSum_dbf_shi;
	}
	public void setCostSum_dbf_shi(Double costSum_dbf_shi) {
		this.costSum_dbf_shi = costSum_dbf_shi;
	}
	public Double getCostSum_psf_ying() {
		return costSum_psf_ying;
	}
	public void setCostSum_psf_ying(Double costSum_psf_ying) {
		this.costSum_psf_ying = costSum_psf_ying;
	}
	public Double getCostSum_psf_yu() {
		return costSum_psf_yu;
	}
	public void setCostSum_psf_yu(Double costSum_psf_yu) {
		this.costSum_psf_yu = costSum_psf_yu;
	}
	public Double getCostSum_psf_shi() {
		return costSum_psf_shi;
	}
	public void setCostSum_psf_shi(Double costSum_psf_shi) {
		this.costSum_psf_shi = costSum_psf_shi;
	}
	
	
	
}

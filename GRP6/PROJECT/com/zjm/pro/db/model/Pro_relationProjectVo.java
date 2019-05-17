package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 以关联系维度查询所有的项目信息
 * Gua:担保业务 guarantee
 * Ent:委贷业务 entrust
 * ReSum:余额 remaining sum
 * 
 */
public class Pro_relationProjectVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String	relationMain_ID;	//关联主体流水号
	private String	relationMainName;	//关联主体名称
	private String	oprationCompanyName;//报送机构
	private String	guarantyOrgName;	//承保机构
	private String	attributionName;	//属地划分
	private String	hostAreaName;		//承保地区
	private String	projectCode;		//项目编号
	private String	projectName;		//项目名称
	private	String	busiTypeName;		//业务品种名称
	private	String	bankName;			//合作机构名称
	private	Double	loadSum;			//项目金额
	private	Double	guarantySum;		//余额
	private	String	periodMonthDay;		//期限
	private	Date	delayBeginDate;		//展期起始日期（初始为借据起始日期）
	private	Date	delayEndDate;		//展期到期日期（初始为借据到期日期）
	private	String	amanName;			//项目经理A角名称
	private	String	bmanName;			//项目经理B角名称
	
	private String	project_ID;
	private String	apply_ID;
	private String	client_ID;
	
	
	public String getRelationMain_ID() {
		return relationMain_ID;
	}
	public void setRelationMain_ID(String relationMain_ID) {
		this.relationMain_ID = relationMain_ID;
	}
	public String getRelationMainName() {
		return relationMainName;
	}
	public void setRelationMainName(String relationMainName) {
		this.relationMainName = relationMainName;
	}
	public String getOprationCompanyName() {
		return oprationCompanyName;
	}
	public void setOprationCompanyName(String oprationCompanyName) {
		this.oprationCompanyName = oprationCompanyName;
	}
	public String getGuarantyOrgName() {
		return guarantyOrgName;
	}
	public void setGuarantyOrgName(String guarantyOrgName) {
		this.guarantyOrgName = guarantyOrgName;
	}
	public String getHostAreaName() {
		return hostAreaName;
	}
	public void setHostAreaName(String hostAreaName) {
		this.hostAreaName = hostAreaName;
	}
	public String getAttributionName() {
		return attributionName;
	}
	public void setAttributionName(String attributionName) {
		this.attributionName = attributionName;
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
	public String getBusiTypeName() {
		return busiTypeName;
	}
	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAmanName() {
		return amanName;
	}
	public void setAmanName(String amanName) {
		this.amanName = amanName;
	}
	public String getBmanName() {
		return bmanName;
	}
	public void setBmanName(String bmanName) {
		this.bmanName = bmanName;
	}
	public String getPeriodMonthDay() {
		return periodMonthDay;
	}
	public void setPeriodMonthDay(String periodMonthDay) {
		this.periodMonthDay = periodMonthDay;
	}
	public Date getDelayBeginDate() {
		return delayBeginDate;
	}
	public void setDelayBeginDate(Date delayBeginDate) {
		this.delayBeginDate = delayBeginDate;
	}
	public Date getDelayEndDate() {
		return delayEndDate;
	}
	public void setDelayEndDate(Date delayEndDate) {
		this.delayEndDate = delayEndDate;
	}
	public Double getLoadSum() {
		return loadSum;
	}
	public void setLoadSum(Double loadSum) {
		this.loadSum = loadSum;
	}
	public Double getGuarantySum() {
		return guarantySum;
	}
	public void setGuarantySum(Double guarantySum) {
		this.guarantySum = guarantySum;
	}
	public String getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
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
	
}

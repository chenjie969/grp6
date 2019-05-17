package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 *业务展期信息表pro_delay
 */
public class Pro_delay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String delay_ID	;//	展期明细ID	varchar(32)
	private String project_ID	;//	项目ID	varchar(32)
	private String applyID;//申请ID
	private Double delaySum	;//	展期金额	decimal(18,6)
	private Integer delayMonth	;//	展期期限.月	smallint
	private Integer delayDay	;//	展期期限.天	smallint
	private String delayMonthDay	;//	展期期限月天	varchar(20)
	private Date delayBeginDate	;//	展期起始日期	date(根据客户需求自20171213日后此字段名称改为上报日期)
	private Date factBeginDate	;//	展期起始日期	date
	private Date delayEndDate	;//	展期到期日期	date
	private float delayRate	;//	展期后担保费率%（展期后贷款利率%）	float
	private float delayServiceRate	;//	展期后融资服务费率%	float
	//private String delayContractCode	;//	展期合同号	varchar(20)
	private String delayReason	;//	展期原因	varchar(200)
	private String delayState	;//	展期审批状态	char(2)
	private String unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String updateUserName	;//	最后修改人姓名	varchar(20)
	private Date updateDateTime	;//	最后修改时间	datetime
	
	
	
	private String projectName;//pro_apply冗余字段
	private String bankName;//pro_project冗余字段
	private Double loadSum;//pro_project冗余字段
	private String busiTypeName;//pro_project冗余字段
	private String projectCode;//pro_project冗余字段
	
	
	public String getDelay_ID() {
		return delay_ID;
	}
	public void setDelay_ID(String delay_ID) {
		this.delay_ID = delay_ID;
	}
	public String getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
	}
	public Double getDelaySum() {
		return delaySum;
	}
	public void setDelaySum(Double delaySum) {
		this.delaySum = delaySum;
	}
	public Integer getDelayMonth() {
		return delayMonth;
	}
	public void setDelayMonth(Integer delayMonth) {
		this.delayMonth = delayMonth;
	}
	public Integer getDelayDay() {
		return delayDay;
	}
	public void setDelayDay(Integer delayDay) {
		this.delayDay = delayDay;
	}
	public String getDelayMonthDay() {
		return delayMonthDay;
	}
	public void setDelayMonthDay(String delayMonthDay) {
		this.delayMonthDay = delayMonthDay;
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
	public float getDelayRate() {
		return delayRate;
	}
	public void setDelayRate(float delayRate) {
		this.delayRate = delayRate;
	}
	public float getDelayServiceRate() {
		return delayServiceRate;
	}
	public void setDelayServiceRate(float delayServiceRate) {
		this.delayServiceRate = delayServiceRate;
	}
	public String getDelayReason() {
		return delayReason;
	}
	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}
	public String getDelayState() {
		return delayState;
	}
	public void setDelayState(String delayState) {
		this.delayState = delayState;
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
	public Double getLoadSum() {
		return loadSum;
	}
	public void setLoadSum(Double loadSum) {
		this.loadSum = loadSum;
	}
	public String getApplyID() {
		return applyID;
	}
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}
	public Date getFactBeginDate() {
		return factBeginDate;
	}
	public void setFactBeginDate(Date factBeginDate) {
		this.factBeginDate = factBeginDate;
	}
	

}

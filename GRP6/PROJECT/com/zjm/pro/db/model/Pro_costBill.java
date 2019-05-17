package com.zjm.pro.db.model;

import java.util.Date;

public class Pro_costBill {

	private String	costBill_ID	;	//	流水号	varchar(32)
	private String	apply_ID	;	//	申请ID	varchar(32)
	private String	applyDetail_ID	;	//	申请业务明细ID	varchar(32)
	private String	billTypeID	;	//	票据类型ID	varchar(32)
	private String	billTypeName	;	//	票据类型名称	varchar(20)
//	private String	billCode		;	//	票据编号	varchar(20)
	private Double	billSum	;	//	票据金额	decimal(18,6)
	private String	billTitle	;	//	发票抬头	varchar(50)
	private String	taxCode	;	//	纳税人识别号	varchar(20)
	private String	openBank	;	//	开户行	varchar(50)
	private String	accountNum	;	//	开户账号	varchar(20)
	private String	phone	;	//	电话	varchar(20)
	private String	address	;	//	地址	varchar(80)
	private Date	billDate	;	//	开具时间	date
	private String	unit_uid	;	//	担保机构编号	varchar(32)
	private String	updateUserName	;	//	最后修改人姓名	varchar(20)
	private Date	updateDateTime	;	//	最后修改时间	datetime
	
	private String type;	//冗余字段,任务事项用, type=edti/view, 判断打开编辑还是修改页面
	
	public String getCostBill_ID() {
		return costBill_ID;
	}
	public void setCostBill_ID(String costBill_ID) {
		this.costBill_ID = costBill_ID;
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
	public String getBillTypeID() {
		return billTypeID;
	}
	public void setBillTypeID(String billTypeID) {
		this.billTypeID = billTypeID;
	}
	public String getBillTypeName() {
		return billTypeName;
	}
	public void setBillTypeName(String billTypeName) {
		this.billTypeName = billTypeName;
	}
	public Double getBillSum() {
		return billSum;
	}
	public void setBillSum(Double billSum) {
		this.billSum = billSum;
	}
	public String getBillTitle() {
		return billTitle;
	}
	public void setBillTitle(String billTitle) {
		this.billTitle = billTitle;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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
	/*public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}*/
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

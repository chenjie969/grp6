package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Crm_landHouse implements Serializable {
	
    private String landHouse_ID;//流水号
    
    private String client_ID;//客户ID
    
    private String landHouseName;//名称
    
    private String landHousePosition;//位置
    
    private Double landHouseArea;//面积
    
    private Double buyPrice;//购买价
    
    private Integer isCertificate;//是否有证
    
    private String status;//状态
    
    private String loanBank;//贷款行
    
    private Double guarantySum;//抵押金额（万元）
    
    private String remark;//备注
    
    private String unit_uid;//担保机构ID
    
    private String unit_uidName;//担保机构名称
    
    private String updateUserName;//最后修改人姓名
    
    private Date updateDateTime;//最后修改时间
    
    
	public String getLandHouse_ID() {
		return landHouse_ID;
	}
	public void setLandHouse_ID(String landHouse_ID) {
		this.landHouse_ID = landHouse_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getLandHouseName() {
		return landHouseName;
	}
	public void setLandHouseName(String landHouseName) {
		this.landHouseName = landHouseName;
	}
	public String getLandHousePosition() {
		return landHousePosition;
	}
	public void setLandHousePosition(String landHousePosition) {
		this.landHousePosition = landHousePosition;
	}
	public Double getLandHouseArea() {
		return landHouseArea;
	}
	public void setLandHouseArea(Double landHouseArea) {
		this.landHouseArea = landHouseArea;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Integer getIsCertificate() {
		return isCertificate;
	}
	public void setIsCertificate(Integer isCertificate) {
		this.isCertificate = isCertificate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoanBank() {
		return loanBank;
	}
	public void setLoanBank(String loanBank) {
		this.loanBank = loanBank;
	}
	public Double getGuarantySum() {
		return guarantySum;
	}
	public void setGuarantySum(Double guarantySum) {
		this.guarantySum = guarantySum;
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

}
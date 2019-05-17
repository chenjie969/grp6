package com.zjm.crm.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @description   股权信息表
 * @author wuhn
 * @date 2017年5月15日 下午5:10:17
 */
public class Crm_stock implements Serializable {
	
    private String stockId;      //流水号  stock_ID
    private String client_ID;      //客户ID  client_ID
    private String stocktype;      //股东类型  stockType
    private String stockname;      //股东名称  stockName
    private String certificatetypeid;      //证件类型ID  certificateTypeID
    private String certificatename;      //证件类型名称  certificateName
    private String certificatecode;      //证件号码（或统一社会信用代码）  certificateCode
    private String address;      //地址  address
    private String phone;      //联系方式  phone
    private String investtypetime;      //出资时间与出资方式  investTypeTime
    private BigDecimal investsum;      //出资金额（万元）  investSum
    private BigDecimal factinvestsum;      //实缴金额  factInvestSum
    private Float investscale;      //占比（%）  investScale
    private String unitUid;      //担保机构ID  unit_uid
    private String updateusername;      //最后修改人姓名  updateUserName
    private Date updatedatetime;      //最后修改时间  updateDateTime
    private String remark;      //备注  remark


    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getClient_ID() {
		return client_ID;
	}

	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}

	public String getStocktype() {
        return stocktype;
    }

    public void setStocktype(String stocktype) {
        this.stocktype = stocktype;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public String getCertificatetypeid() {
        return certificatetypeid;
    }

    public void setCertificatetypeid(String certificatetypeid) {
        this.certificatetypeid = certificatetypeid;
    }

    public String getCertificatename() {
        return certificatename;
    }

    public void setCertificatename(String certificatename) {
        this.certificatename = certificatename;
    }

    public String getCertificatecode() {
        return certificatecode;
    }

    public void setCertificatecode(String certificatecode) {
        this.certificatecode = certificatecode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInvesttypetime() {
        return investtypetime;
    }

    public void setInvesttypetime(String investtypetime) {
        this.investtypetime = investtypetime;
    }

    public BigDecimal getInvestsum() {
    	
        return investsum;
    }

    public void setInvestsum(BigDecimal investsum) {
        this.investsum = investsum;
    }

    public BigDecimal getFactinvestsum() {
        return factinvestsum;
    }

    public void setFactinvestsum(BigDecimal factinvestsum) {
        this.factinvestsum = factinvestsum;
    }

    public Float getInvestscale() {
        return investscale;
    }

    public void setInvestscale(Float investscale) {
        this.investscale = investscale;
    }

    public String getUnitUid() {
        return unitUid;
    }

    public void setUnitUid(String unitUid) {
        this.unitUid = unitUid;
    }

    public String getUpdateusername() {
        return updateusername;
    }

    public void setUpdateusername(String updateusername) {
        this.updateusername = updateusername;
    }

    public Date getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(Date updatedatetime) {
        this.updatedatetime = updatedatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
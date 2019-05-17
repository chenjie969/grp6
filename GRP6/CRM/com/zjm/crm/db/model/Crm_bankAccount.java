package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @description	银行开户信息表crm_bankAccount
 * @author wuhn
 * @date 2017年5月12日 下午8:15:13
 */
public class Crm_bankAccount implements Serializable {
	
    private String bankaccountId;   //流水号    bankAccount_ID
    private String client_ID;   //客户ID    client_ID
    private String accounttypeid;   //账户类型代码ID    accountTypeID
    private String accounttype;   //账户类型名称    accountType
    private String bankname;   //开户银行名称    bankName
    private String accountnumber;   //账号    accountNumber
    private Double accountsum;   //账户余额（万元）    accountSum
    private String remark;   //备注    remark
    private String updateusername;   //最后修改人姓名    updateUserName
    private Date updatedatetime;   //最后修改时间    updateDateTime
    private String unit_uid;//机构ID

   

    public String getAccounttypeid() {
        return accounttypeid;
    }

    public void setAccounttypeid(String accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Double getAccountsum() {
        return accountsum;
    }

    public void setAccountsum(Double accountsum) {
        this.accountsum = accountsum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

	public String getBankaccountId() {
		return bankaccountId;
	}

	public void setBankaccountId(String bankaccountId) {
		this.bankaccountId = bankaccountId;
	}

	public String getClient_ID() {
		return client_ID;
	}

	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}

	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	
    
}
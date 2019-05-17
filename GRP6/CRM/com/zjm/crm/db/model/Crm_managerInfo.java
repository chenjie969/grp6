package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @description  股东信息--主要管理人员情况
 * @author wuhn
 * @date 2017年5月12日 下午8:12:18
 */
public class Crm_managerInfo implements Serializable {
	
    private String managerinfoId;   //流水号  managerInfo_ID
    private String client_ID;   //客户ID  client_ID
    private String developevolution;   //企业发展沿革  developEvolution
    private String productdesc;   //主导产品介绍及其工艺流程  productDesc
    private String stockstructure;   //股权结构历史沿革  stockStructure
    private String legalpersoninfo;   //法定代表人及其配偶情况  legalPersonInfo
    private String controlpersoninfo;   //实际控制人及其配偶情况  controlPersonInfo
    private String otherstockinfo;   //其他股东情况  otherStockInfo
    private String managerinfo;   //公司主要高管人员情况  managerInfo
    private String employeeinfo;   //公司员工概况  employeeInfo
    private String unitUid;   //担保机构ID  unit_uid
    private String updateusername;   //最后修改人姓名  updateUserName
    private Date updatedatetime;   //最后修改时间  updateDateTime


    public String getManagerinfoId() {
        return managerinfoId;
    }

    public void setManagerinfoId(String managerinfoId) {
        this.managerinfoId = managerinfoId;
    }

   

    public String getClient_ID() {
		return client_ID;
	}

	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
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

    public String getDevelopevolution() {
        return developevolution;
    }

    public void setDevelopevolution(String developevolution) {
        this.developevolution = developevolution;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getStockstructure() {
        return stockstructure;
    }

    public void setStockstructure(String stockstructure) {
        this.stockstructure = stockstructure;
    }

    public String getLegalpersoninfo() {
        return legalpersoninfo;
    }

    public void setLegalpersoninfo(String legalpersoninfo) {
        this.legalpersoninfo = legalpersoninfo;
    }

    public String getControlpersoninfo() {
        return controlpersoninfo;
    }

    public void setControlpersoninfo(String controlpersoninfo) {
        this.controlpersoninfo = controlpersoninfo;
    }

    public String getOtherstockinfo() {
        return otherstockinfo;
    }

    public void setOtherstockinfo(String otherstockinfo) {
        this.otherstockinfo = otherstockinfo;
    }

    public String getManagerinfo() {
        return managerinfo;
    }

    public void setManagerinfo(String managerinfo) {
        this.managerinfo = managerinfo;
    }

    public String getEmployeeinfo() {
        return employeeinfo;
    }

    public void setEmployeeinfo(String employeeinfo) {
        this.employeeinfo = employeeinfo;
    }
}
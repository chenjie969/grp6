package com.zjm.sys.db.model;

import java.io.Serializable;
import java.util.Date;

public class Sys_logoperator implements Serializable{
	private static final long serialVersionUID = 1L;
		private String logoperatorid;        //操作日志流水号logOperatorID	
	    private String unitUid;        //担保机构编号unit_uid	
	    private String  unit_uidName;    //担保机构名称  unit_uidName
	    private Date operatordatetime;        //操作时间loperatorDateTime	
	    private String username;        //上机人姓名userName	
	    private String departname;        //上机部门名称departName	
	    private String modname;        //操作功能模块	
	    private String logdescr;        //操作描述logDescr	
	    private String openratortype;        //操作类型openratorType	
	    private String loginaccount;        //登录账号loginAccount	
	    private String ipaddress;        //ip地址ipAddress	



    public String getLogoperatorid() {
		return logoperatorid;
	}

	public void setLogoperatorid(String logoperatorid) {
		this.logoperatorid = logoperatorid;
	}

	public String getUnitUid() {
		return unitUid;
	}

	public void setUnitUid(String unitUid) {
		this.unitUid = unitUid;
	}

	public Date getOperatordatetime() {
        return operatordatetime;
    }

    public void setOperatordatetime(Date operatordatetime) {
        this.operatordatetime = operatordatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getModname() {
        return modname;
    }

    public void setModname(String modname) {
        this.modname = modname;
    }

    public String getLogdescr() {
        return logdescr;
    }

    public void setLogdescr(String logdescr) {
        this.logdescr = logdescr;
    }

    public String getOpenratortype() {
        return openratortype;
    }

    public void setOpenratortype(String openratortype) {
        this.openratortype = openratortype;
    }

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

	public String getUnit_uidName() {
		return unit_uidName;
	}

	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
	}


    
}
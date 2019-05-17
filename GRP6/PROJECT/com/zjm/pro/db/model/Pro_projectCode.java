package com.zjm.pro.db.model;

import java.io.Serializable;

/**
 * 客户编号     
 * @author chenyang   add 20170719
 */
public class Pro_projectCode implements Serializable{
	private static final long serialVersionUID = 1L;
	private String  projectCode_ID;	//流水号
	private Integer	years;			//年份
	private Integer	applyCode;	//受理登记编号
	private Integer	projectCode;	//项目编号
	private Integer	creditCode;		//授信编号
	private String   unit_uid;		//机构ID
	/*private String   updateUserName;//
	private Date   updateDateTime;	//
*/
	
	public String getProjectCode_ID() {
		return projectCode_ID;
	}
	public void setProjectCode_ID(String projectCode_ID) {
		this.projectCode_ID = projectCode_ID;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getApplyCode() {
		return applyCode;
	}
	public void setApplyCode(Integer applyCode) {
		this.applyCode = applyCode;
	}
	public Integer getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(Integer creditCode) {
		this.creditCode = creditCode;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public Integer getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(Integer projectCode) {
		this.projectCode = projectCode;
	}
	
	
			
}

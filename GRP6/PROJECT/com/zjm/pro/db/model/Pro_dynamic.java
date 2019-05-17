package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pro_dynamic implements Serializable{
	private static final long serialVersionUID = 1L;
    private String	dynamic_ID;
	private  String apply_ID;
	private String dynamicContent;
	private String dynamicContentShort;
	private Date createDateTime;
	private String createUserID;
	private String createUserName;
	private String readerUserIDList;
	private String readerUserNameList;
	private String unit_uid;
	private String updateUserName;
	private Date updateDateTime;
	
	private  String projectName;//冗余字段
	private  Integer messageNumber;//冗余字段
	private String pageNumber;
	private String  total;
	private  List<Pro_dynamic> dynamicList=new ArrayList<Pro_dynamic>();
	
	public String getDynamic_ID() {
		return dynamic_ID;
	}
	public void setDynamic_ID(String dynamic_ID) {
		this.dynamic_ID = dynamic_ID;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getDynamicContent() {
		return dynamicContent;
	}
	public void setDynamicContent(String dynamicContent) {
		this.dynamicContent = dynamicContent;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getReaderUserIDList() {
		return readerUserIDList;
	}
	public void setReaderUserIDList(String readerUserIDList) {
		this.readerUserIDList = readerUserIDList;
	}
	public String getReaderUserNameList() {
		return readerUserNameList;
	}
	public void setReaderUserNameList(String readerUserNameList) {
		this.readerUserNameList = readerUserNameList;
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
	public Integer getMessageNumber() {
		return messageNumber;
	}
	public void setMessageNumber(Integer messageNumber) {
		this.messageNumber = messageNumber;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public List<Pro_dynamic> getDynamicList() {
		return dynamicList;
	}
	public void setDynamicList(List<Pro_dynamic> dynamicList) {
		this.dynamicList = dynamicList;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDynamicContentShort() {
		if (dynamicContent != null && !"".equals(dynamicContent)) {
			if (dynamicContent.length() > 15) {
				dynamicContentShort = dynamicContent.substring(0, 15) + "......";
			} else {
				dynamicContentShort = dynamicContent;
			}
		} else {
			return null;
		}
		return dynamicContentShort;
		
	}
	public void setDynamicContentShort(String dynamicContentShort) {
		this.dynamicContentShort = dynamicContentShort;
	}
	
	
}

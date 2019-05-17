package com.zjm.crm.db.model;
// default package

import java.io.Serializable;
import java.util.Date;


/**
 * 公共附件
 * @author mashuo 1144689809@qq.com 2016-12-20
 */
public class Crm_clientfiles implements Serializable{
	private String clientFiles_ID;   //附件id
	private String fileType;//附件入口类型/
	private String client_ID;//客户ID
	private String sourceFileName;  //附件原文件名称
	private String pathFile;  //存储路径与文件
	private String extend; //文件扩展名
	private String uploadManID;  //上传人Id
	private String uploadManName;//上传人名称
	private Date uploadDateTime;  //上传时间
	private String fileSize;  //附件大小
	private String updateUserName; //最后修改人姓名
	private Date updateDateTime; // 最后修改时间
	private String unit_uid;//机构id
	
	private Boolean isFile;//是否文档附件;
	private String clientFileType;//客户附件类型;
	
	private String materialDetail_ID;//客户资料清单明细id
	
	
	private String whereSql;//查询条件
	//==============get/set===================================
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	

	public String getClientFiles_ID() {
		return clientFiles_ID;
	}

	public void setClientFiles_ID(String clientFiles_ID) {
		this.clientFiles_ID = clientFiles_ID;
	}

	public String getClient_ID() {
		return client_ID;
	}

	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getUploadManID() {
		return uploadManID;
	}

	public void setUploadManID(String uploadManID) {
		this.uploadManID = uploadManID;
	}

	public Date getUploadDateTime() {
		return uploadDateTime;
	}

	public void setUploadDateTime(Date uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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

	public String getWhereSql() {
		return whereSql;
	}

	public void setWhereSql(String whereSql) {
		this.whereSql = whereSql;
	}

	public String getUploadManName() {
		return uploadManName;
	}

	public void setUploadManName(String uploadManName) {
		this.uploadManName = uploadManName;
	}

	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}

	public Boolean getIsFile() {
		return isFile;
	}

	public void setIsFile(Boolean isFile) {
		this.isFile = isFile;
	}

	public String getClientFileType() {
		return clientFileType;
	}

	public void setClientFileType(String clientFileType) {
		this.clientFileType = clientFileType;
	}

	public String getMaterialDetail_ID() {
		return materialDetail_ID;
	}

	public void setMaterialDetail_ID(String materialDetail_ID) {
		this.materialDetail_ID = materialDetail_ID;
	}
	

}
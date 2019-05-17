package com.zjm.gworkFlow.db.model;

import java.sql.Date;


/**
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-19 下午1:42:53 类说明：
 */
public class OsGworkflowFlowtemplate {

	private Integer id;
	private String flowTemplateID;
	private String flowTypeID;
	private String flowTypeName;
	private String flowTemplateName;
	private String flowTempaleMapName;
	private String flowXmlFile;
	private String funDesrc;
	private String version;
	private Date releaseDate;
	private Boolean isActive;
	private Boolean isDel;
	
	//zhongzk add
	private String unit_uid;//担保机构id
	
	//ls add
	private String otherTemplate;//其他模板
	private String projectID;//项目 id
	
	private String user_uid;
	private String flowType;//流程类型
	private String entityName;//业务实体名称
	
	private String businessId;
	private String businessType;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlowTemplateID() {
		return flowTemplateID;
	}

	public void setFlowTemplateID(String flowTemplateID) {
		this.flowTemplateID = flowTemplateID;
	}

	public String getFlowTypeID() {
		return flowTypeID;
	}

	public void setFlowTypeID(String flowTypeID) {
		this.flowTypeID = flowTypeID;
	}

	public String getFlowTypeName() {
		return flowTypeName;
	}

	public void setFlowTypeName(String flowTypeName) {
		this.flowTypeName = flowTypeName;
	}

	public String getFlowTemplateName() {
		return flowTemplateName;
	}

	public void setFlowTemplateName(String flowTemplateName) {
		this.flowTemplateName = flowTemplateName;
	}

	public String getFlowTempaleMapName() {
		return flowTempaleMapName;
	}

	public void setFlowTempaleMapName(String flowTempaleMapName) {
		this.flowTempaleMapName = flowTempaleMapName;
	}

	public String getFlowXmlFile() {
		return flowXmlFile;
	}

	public void setFlowXmlFile(String flowXmlFile) {
		this.flowXmlFile = flowXmlFile;
	}

	public String getFunDesrc() {
		return funDesrc;
	}

	public void setFunDesrc(String funDesrc) {
		this.funDesrc = funDesrc;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}

	public String getOtherTemplate() {
		return otherTemplate;
	}

	public void setOtherTemplate(String otherTemplate) {
		this.otherTemplate = otherTemplate;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}



	
	

	
}

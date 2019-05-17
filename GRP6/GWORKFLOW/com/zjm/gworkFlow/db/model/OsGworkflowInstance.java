package com.zjm.gworkFlow.db.model;

import java.util.Date;

/**
 * 流程对应申请表
 * @author Administrator
 *
 */
public class OsGworkflowInstance {
	private Integer	id ;
	private String  applyId ;	//主项目申请表id
	private String  businessId ;	//实体ID
	private String  businessType ;	//实体类别
	private Long	entryId ;	//流程实例ID
	private String  flowTemplateId ;	//流程模板ID
	private Date  createTime ;		//创建时间
	private String  user_uid ;	//创建人
	private String  unit_uid ;	//部门
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
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
	public Long getEntryId() {
		return entryId;
	}
	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}
	public String getFlowTemplateId() {
		return flowTemplateId;
	}
	public void setFlowTemplateId(String flowTemplateId) {
		this.flowTemplateId = flowTemplateId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUser_uid() {
		return user_uid;
	}
	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	
	
}

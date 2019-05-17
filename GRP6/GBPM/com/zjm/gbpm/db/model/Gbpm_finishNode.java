package com.zjm.gbpm.db.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 已完成节点表gbpm_finishNode
 * @author zky
 *
 */
public class Gbpm_finishNode implements Serializable {
	private String	finishNode_ID;//		已完成节点ID	varchar(32)
	private String	productInstanceID	;//产品实例ID		varchar(32)
	private String	nodeNames		;//节点名称		varchar(100)
	private Integer	nodeSort		;//节点顺序	smallint
	private Integer	limitDay		;//限办天数
	private String	transferResultID	;//流转结论ID		varchar(32)
	private String	transferResultName	;//流转结论名称		varchar(20)
	private Date assignDateTime;//节点创建时间
	private String	unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String	unit_uidName	;//	担保机构名称	varchar(50)
	private String	updateUserName	;//最后修改人姓名		varchar(20)
	private Date	updateDateTime	;//最后修改时间		datetime
	
	
	private String overDay	;//剩余天数
	
	public String getFinishNode_ID() {
		return finishNode_ID;
	}
	public void setFinishNode_ID(String finishNode_ID) {
		this.finishNode_ID = finishNode_ID;
	}
	public String getProductInstanceID() {
		return productInstanceID;
	}
	public void setProductInstanceID(String productInstanceID) {
		this.productInstanceID = productInstanceID;
	}
	public String getNodeNames() {
		return nodeNames;
	}
	public void setNodeNames(String nodeNames) {
		this.nodeNames = nodeNames;
	}
	public Integer getNodeSort() {
		return nodeSort;
	}
	public void setNodeSort(Integer nodeSort) {
		this.nodeSort = nodeSort;
	}
	public String getTransferResultID() {
		return transferResultID;
	}
	public void setTransferResultID(String transferResultID) {
		this.transferResultID = transferResultID;
	}
	public String getTransferResultName() {
		return transferResultName;
	}
	public void setTransferResultName(String transferResultName) {
		this.transferResultName = transferResultName;
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
	public Integer getLimitDay() {
		return limitDay;
	}
	public void setLimitDay(Integer limitDay) {
		this.limitDay = limitDay;
	}
	public Date getAssignDateTime() {
		return assignDateTime;
	}
	public void setAssignDateTime(Date assignDateTime) {
		this.assignDateTime = assignDateTime;
	}
	public String getOverDay() {
		return overDay;
	}
	public void setOverDay(String overDay) {
		this.overDay = overDay;
	}
	
}

package com.zjm.gbpm.db.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 运行中节点表gbpm_runNode
 * @author zky
 *
 */
public class Gbpm_runNode implements Serializable {
	
	private String runNode_ID;//	运行中节点ID	varchar(32)
	private String productInstanceID;//	产品实例ID	varchar(32)
	private String nodeNames	;//节点名称	varchar(100)
	private Boolean isDelete;  //逻辑删除
	private Integer limitDay	;//限办天数
	private Integer  nodeSort;//	节点顺序	smallint
	private String transferResultID;//	流转结论ID	varchar(32)
	private String transferResultName;//	流转结论名称	varchar(20)
	private Date assignDateTime;//节点创建时间
	private String unit_uid;//	担保机构编号unit_uid	varchar(32)
	private String unit_uidName	;//担保机构名称	varchar(50)
	private String updateUserName;//	最后修改人姓名	varchar(20)
	private Date updateDateTime;//	最后修改时间	datetime
	
	
	private String overDay	;//剩余天数
	//getter/setter
	public String getRunNode_ID() {
		return runNode_ID;
	}
	public void setRunNode_ID(String runNode_ID) {
		this.runNode_ID = runNode_ID;
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
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getOverDay() {
		return overDay;
	}
	public void setOverDay(String overDay) {
		this.overDay = overDay;
	}
	public Date getAssignDateTime() {
		return assignDateTime;
	}
	public void setAssignDateTime(Date assignDateTime) {
		this.assignDateTime = assignDateTime;
	}

}

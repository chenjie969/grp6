package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Crm_oldClientName implements Serializable {

	private String   oldClient_ID;//主键
	private String   client_ID;//客户ID
	private String   clientGUID;//共享人IDs
	private String   oldClientName;//老客户名称
	private String   newClientName;//新客户名称
	private String   unit_uid;//担保机构ID
	private String   unit_uidName;//担保机构名称
	private String   updateUserName;//最后修改人姓名
	private Date  updateDateTime;//最后修改时间
	
	
	public String getOldClient_ID() {
		return oldClient_ID;
	}
	public void setOldClient_ID(String oldClient_ID) {
		this.oldClient_ID = oldClient_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getClientGUID() {
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	public String getOldClientName() {
		return oldClientName;
	}
	public void setOldClientName(String oldClientName) {
		this.oldClientName = oldClientName;
	}
	public String getNewClientName() {
		return newClientName;
	}
	public void setNewClientName(String newClientName) {
		this.newClientName = newClientName;
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
	
}

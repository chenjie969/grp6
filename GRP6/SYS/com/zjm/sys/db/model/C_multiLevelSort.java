package com.zjm.sys.db.model;

import java.io.Serializable;
import java.util.Date;

public class C_multiLevelSort implements Serializable{
		private static final long serialVersionUID = 1L;
		private String multilevelsortid;      //担保机构编号unit_uid		
	    private String unitUid;      //节点编号multiLevelSortID		
	    private String pmultilevelsortid;      //父节点编号pmultiLevelSortID		
	    private String multilevelsortname;      //节点名称multiLevelSortName		
	    private String multilevelsortfullcode;      //节点编号全称multiLevelSortFullCode		
	    private String url;      //节点链接url		
	    private Integer orderId;      //节点排序顺序order_id		
	    private Date createdatetime;      //创建时间createdatetime		
	    private String createUser;      //创建人create_user		
	    private Date upatedatetime;      //最后更新时间upatedatetime		
	    private String updateUser;      //最后更新人update_user		
	    private String unificationid;      //统一编码unificationID		
		private Integer iseable;      //是否可禁用isEable		
		private Integer isedit;      //是否可编辑isEdit		
		private Integer isDefault;      //系统自带还是用户自定义isDefault		
		public String getMultilevelsortid() {
			return multilevelsortid;
		}
		public void setMultilevelsortid(String multilevelsortid) {
			this.multilevelsortid = multilevelsortid;
		}
		public String getUnitUid() {
			return unitUid;
		}
		public void setUnitUid(String unitUid) {
			this.unitUid = unitUid;
		}
		public String getPmultilevelsortid() {
			return pmultilevelsortid;
		}
		public void setPmultilevelsortid(String pmultilevelsortid) {
			this.pmultilevelsortid = pmultilevelsortid;
		}
		public String getMultilevelsortname() {
			return multilevelsortname;
		}
		public void setMultilevelsortname(String multilevelsortname) {
			this.multilevelsortname = multilevelsortname;
		}
		public String getMultilevelsortfullcode() {
			return multilevelsortfullcode;
		}
		public void setMultilevelsortfullcode(String multilevelsortfullcode) {
			this.multilevelsortfullcode = multilevelsortfullcode;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public Integer getOrderId() {
			return orderId;
		}
		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}
		public Date getCreatedatetime() {
			return createdatetime;
		}
		public void setCreatedatetime(Date createdatetime) {
			this.createdatetime = createdatetime;
		}
		public String getCreateUser() {
			return createUser;
		}
		public void setCreateUser(String createUser) {
			this.createUser = createUser;
		}
		public Date getUpatedatetime() {
			return upatedatetime;
		}
		public void setUpatedatetime(Date upatedatetime) {
			this.upatedatetime = upatedatetime;
		}
		public String getUpdateUser() {
			return updateUser;
		}
		public void setUpdateUser(String updateUser) {
			this.updateUser = updateUser;
		}
		public String getUnificationid() {
			return unificationid;
		}
		public void setUnificationid(String unificationid) {
			this.unificationid = unificationid;
		}
		public Integer getIseable() {
			return iseable;
		}
		public void setIseable(Integer iseable) {
			this.iseable = iseable;
		}
		public Integer getIsedit() {
			return isedit;
		}
		public void setIsedit(Integer isedit) {
			this.isedit = isedit;
		}
		public Integer getIsDefault() {
			return isDefault;
		}
		public void setIsDefault(Integer isDefault) {
			this.isDefault = isDefault;
		}
		
		
		
}
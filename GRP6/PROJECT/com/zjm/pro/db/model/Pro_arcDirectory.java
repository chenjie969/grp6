package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wzk
 *	 档案目录表pro_arcDirectory
 */
public class Pro_arcDirectory implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String arcDirectory_ID;//流水号
	private String apply_ID;//对应申请ID
	private String arcTypeID;//档案类别ID(字典)
	private String arcTypeName;//档案类别名称
	private String fileTitle;//文件标题
	private Integer pageCount;//页码（份数）
	private Integer isOldArc;//是否原件
	private String remark;//备注
	private Date createDate;//日期
	private String unit_uid;//担保机构编号unit_uid
	private String updateUserName;//最后修改人姓名
	private Date updateDateTime;//最后修改时间
	
	public String getArcDirectory_ID() {
		return arcDirectory_ID;
	}
	public void setArcDirectory_ID(String arcDirectory_ID) {
		this.arcDirectory_ID = arcDirectory_ID;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getArcTypeID() {
		return arcTypeID;
	}
	public void setArcTypeID(String arcTypeID) {
		this.arcTypeID = arcTypeID;
	}
	public String getArcTypeName() {
		return arcTypeName;
	}
	public void setArcTypeName(String arcTypeName) {
		this.arcTypeName = arcTypeName;
	}
	public String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getIsOldArc() {
		return isOldArc;
	}
	public void setIsOldArc(Integer isOldArc) {
		this.isOldArc = isOldArc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	
	
}

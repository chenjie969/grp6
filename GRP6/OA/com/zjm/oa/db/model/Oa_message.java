package com.zjm.oa.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author dj
 * 公告信息实体类
 */
public class Oa_message implements Serializable {

	private String  messageId;			//信息id	 
	private String  messageTypeId;  	//信息类型id,数据字典获取,公司公告/公司公示		 
	private String  messageTypeName;  	//(数据字典获取的)信息类型名称
	private String  messageTypePID;  	//信息类型id,数据字典获取,公司公告/公司公示		 
	private String  messageTypePName;  	//(数据字典获取的)信息类型名称
	private String  title;   			//信息标题
	private String  isSign = "1";				//是否需要签收	//设置默认值为1,所有信息都需要签收--2017/8/14 20:07 xuyz
	private String receiveUserIdList;      //接收人id
	private String receiveUserNameList;    //接收人姓名
	private String  templetId; 			//模板类型,(数据字典获取)
	private String  content;			//信息内容
	private String  createUserId;		//创建人id
	private String  createUserName;		//创建人姓名
	private Date    createDateTime;		//创建时间
	private String  unitUid;			//担保机构编号
	private String	unitUidName;		//担保机构名称
	private String	updateUserName;		// 最后一次修改人姓名
	private Date	updateDateTime;		//最后一次修改时间
	private String  approvalStatus;     //01：暂存 02：待审核03：被退回 04：审核通过,
	private String  returnDesc;        //退回原因
	private Date    returnDateTime;		//退回时间
	private String  approvalUserId;		//审核人id	
	private Date  approvalDateTime;   //审核时间
	private String  approvalUserName;   //审核人姓名
	
	private  String  noSignUserIdList;		//未签收人id集合
	private  String  signedUserIdList;       //已签收人id集合
	private  String  readUserIdList;   		//已查阅人id集合
	private  String  noSignUserNameList;	//未签收人集合
	private  String  signedUserNameList; //已签收人集合
	private  String  readUserNameList;    //已查阅人集合
	
	private String[] auditIds;          //冗余数据
	private String[] deleteIds;			//冗余数据,关联删除的信息id
	private  String noSignCount;        //冗余数据,未签收人数
	private  String signedCount;		//冗余数据,已签收人数
	private  String readCount;			//冗余数据,已阅人数
	private  String userIsSignStatus;//冗余数据,当前用户是否签收 0:未签收;1,签收;-1:无需签收
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessageTypeId() {
		return messageTypeId;
	}
	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}
	public String getMessageTypeName() {
		return messageTypeName;
	}
	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReceiveUserIdList() {
		return receiveUserIdList;
	}
	public void setReceiveUserIdList(String receiveUserIdList) {
		this.receiveUserIdList = receiveUserIdList;
	}
	public String getReceiveUserNameList() {
		return receiveUserNameList;
	}
	public void setReceiveUserNameList(String receiveUserNameList) {
		this.receiveUserNameList = receiveUserNameList;
	}
	
	
	public String getTempletId() {
		return templetId;
	}
	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getUnitUid() {
		return unitUid;
	}
	public void setUnitUid(String unitUid) {
		this.unitUid = unitUid;
	}
	public String getUnitUidName() {
		return unitUidName;
	}
	public void setUnitUidName(String unitUidName) {
		this.unitUidName = unitUidName;
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
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getReturnDesc() {
		return returnDesc;
	}
	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc;
	}
	public Date getReturnDateTime() {
		return returnDateTime;
	}
	public void setReturnDateTime(Date returnDateTime) {
		this.returnDateTime = returnDateTime;
	}
	public String getNoSignUserIdList() {
		return noSignUserIdList;
	}
	public void setNoSignUserIdList(String noSignUserIdList) {
		this.noSignUserIdList = noSignUserIdList;
	}
	public String getSignedUserIdList() {
		return signedUserIdList;
	}
	public void setSignedUserIdList(String signedUserIdList) {
		this.signedUserIdList = signedUserIdList;
	}
	public String getReadUserIdList() {
		return readUserIdList;
	}
	public void setReadUserIdList(String readUserIdList) {
		this.readUserIdList = readUserIdList;
	}
	public String getNoSignUserNameList() {
		return noSignUserNameList;
	}
	public void setNoSignUserNameList(String noSignUserNameList) {
		this.noSignUserNameList = noSignUserNameList;
	}
	public String getSignedUserNameList() {
		return signedUserNameList;
	}
	public void setSignedUserNameList(String signedUserNameList) {
		this.signedUserNameList = signedUserNameList;
	}
	public String getReadUserNameList() {
		return readUserNameList;
	}
	public void setReadUserNameList(String readUserNameList) {
		this.readUserNameList = readUserNameList;
	}
	public String getApprovalUserId() {
		return approvalUserId;
	}
	public void setApprovalUserId(String approvalUserId) {
		this.approvalUserId = approvalUserId;
	}
	public Date getApprovalDateTime() {
		return approvalDateTime;
	}
	public void setApprovalDateTime(Date approvalDateTime) {
		this.approvalDateTime = approvalDateTime;
	}
	public String getApprovalUserName() {
		return approvalUserName;
	}
	public void setApprovalUserName(String approvalUserName) {
		this.approvalUserName = approvalUserName;
	}
	public String getNoSignCount() {
		return noSignCount;
	}
	public void setNoSignCount(String noSignCount) {
		this.noSignCount = noSignCount;
	}
	public String getSignedCount() {
		return signedCount;
	}
	public void setSignedCount(String signedCount) {
		this.signedCount = signedCount;
	}
	public String getReadCount() {
		return readCount;
	}
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	public String getIsSign() {
		return isSign;
	}
	public void setIsSign(String isSign) {
		this.isSign = isSign;
	}
	public String[] getDeleteIds() {
		return deleteIds;
	}
	public void setDeleteIds(String[] deleteIds) {
		this.deleteIds = deleteIds;
	}
	public String getUserIsSignStatus() {
		return userIsSignStatus;
	}
	public void setUserIsSignStatus(String userIsSignStatus) {
		this.userIsSignStatus = userIsSignStatus;
	}
	public String[] getAuditIds() {
		return auditIds;
	}
	public void setAuditIds(String[] auditIds) {
		this.auditIds = auditIds;
	}
	public String getMessageTypePID() {
		return messageTypePID;
	}
	public void setMessageTypePID(String messageTypePID) {
		this.messageTypePID = messageTypePID;
	}
	public String getMessageTypePName() {
		return messageTypePName;
	}
	public void setMessageTypePName(String messageTypePName) {
		this.messageTypePName = messageTypePName;
	}
}

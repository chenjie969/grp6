package com.zjm.sys.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户编号     
 * @author chenyang   add 20170524
 */
public class Sys_clientCode implements Serializable{
	private static final long serialVersionUID = 1L;
	private String  clientCodeID;	//客户编号规则ID
	private String	ruleType;		//规则类型 :'01共同生成规则02各自生成规则03手工录入',
	private String	ruleName;		//规则类型名称
	private String	commonWord;		//共同生成规则.字号
	private Integer	commonCode;		//共同生成规则.最新编号
	private String	companyWord;	//企业客户编号.字号
	private Integer	companyCode;	//企业客户编号.最新编号
	private String	operateWord;	//个人（经营性）.字号
	private Integer	operateCode;	//个人（经营性）.最新编号
	private String	consumeWord;	//个人（消费性）.字号
	private Integer	consumeCode;	//个人（消费性）.最新编号
	private String   updateUserName;//最后修改人姓名
	private Date   updateDateTime;	//最后修改时间
	private String   unit_uid;		//担保机构ID
	
	
	
	public String getClientCodeID() {
		return clientCodeID;
	}
	public void setClientCodeID(String clientCodeID) {
		this.clientCodeID = clientCodeID;
	}
	public String getRuleType() {
		return ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getCommonWord() {
		return commonWord;
	}
	public void setCommonWord(String commonWord) {
		this.commonWord = commonWord;
	}
	public Integer getCommonCode() {
		return commonCode;
	}
	public void setCommonCode(Integer commonCode) {
		this.commonCode = commonCode;
	}
	public String getCompanyWord() {
		return companyWord;
	}
	public void setCompanyWord(String companyWord) {
		this.companyWord = companyWord;
	}
	public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}
	public String getOperateWord() {
		return operateWord;
	}
	public void setOperateWord(String operateWord) {
		this.operateWord = operateWord;
	}
	public Integer getOperateCode() {
		return operateCode;
	}
	public void setOperateCode(Integer operateCode) {
		this.operateCode = operateCode;
	}
	public String getConsumeWord() {
		return consumeWord;
	}
	public void setConsumeWord(String consumeWord) {
		this.consumeWord = consumeWord;
	}
	public Integer getConsumeCode() {
		return consumeCode;
	}
	public void setConsumeCode(Integer consumeCode) {
		this.consumeCode = consumeCode;
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
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
			
}

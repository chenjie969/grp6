package com.zjm.crm.report.model;

import java.io.Serializable;

/**
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2015-3-3 上午11:04:14 类说明：
 */
public class ReportedReport implements Serializable {
	private String projectID;//项目ID
	private String bankFullCode;// 银行代码全称
	private String bankID;// 一级银行编码
	private String bankName;// 一级银行的名称
	private String subBnakID;// 二级银行编码
	private String subBankName;// 二级银行的名称
	private String fullClientName;// 被担保人
	private String regORpersonID;// 被担保人组织机构代码/身份证
	private String fieldValue;// *企业规模
	private String tradeID;// *所在行业编码
	private String tradeName;// 所属行业中文名称
	private String busiTypeID;// 业务品种编号
	private String busiTypeName;// *业务品种
	private String guaraSum;// *新增担保额
	private String guarContractCode;// *合同号
	private String guaraBeginDate;// *担保责任发生日期
	private String guaraEndDate;// *担保责任解除日期
	private String isRelateGuar;// 是否关联担保
	private String optFinanceCost;// 反担保措施
	private String thirdPartyGuar;// 第三方担保人
	private String thirdPartyGuarCode;// 第三方担保人组织机构代码/身份证
	private String thirdPartyGuar_2;// 第三方担保人
	private String thirdPartyGuarCode_2;// 第三方担保人组织机构代码/身份证
	private String thirdPartyGuar_3;// 第三方担保人
	private String thirdPartyGuarCode_3;// 第三方担保人组织机构代码/身份证
	private String singlePayGuarSum;// 缴纳的单笔存出保证金额
	private String gatherGuarSum;// *收取存入保证金金额
	private String guarEarning;// *担保费收入
	private String remark;// 备注

	private String reportedCountIfDate;//上报统计的日期
	private String tableName;//表名
	private Long unit_uid;//担保机构ID
	
	//代偿字段
	private String replaceType;//解除类型
	private String replaceSum; //代偿/提前还款金额
	private String freeDate;//代偿/提前还款日期
	private String replaceInterestSum;//代偿利息 
	private String replaceOtherSum;//其他费用
	
	//追偿字段
	private String recoverSum;//本月追回金额
	private String recoverDate;//追回日期
	private String isOverRecover;//是否结束追偿
	private String totalReplaceSum;//累计代偿回收成本
	private String totalLossSum;//累计损失金额
	
	/**
	 * 格式化Double, 保留四位 (万元:保留四位)
	 * @param srcVal
	 * @return
	 */
	/*
	private String formatDouble(String srcVal){
		if(srcVal != null && !srcVal.equals("") && !isNumeric(srcVal)){
			DecimalFormat df=new DecimalFormat("#.0000"); 
			return df.format(srcVal);
		}else{
			return srcVal;
		}
	}
	*/
	
	/**
	 * 判断字符串是否能转换为double
	 * @param numb
	 * @return
	 */
	/*
	private Boolean isNumeric(String numb){
		Pattern pattern = Pattern.compile("^[0-9]+\\.{0,1}[0-9]{0,9}$"); 
		Matcher isNum = pattern.matcher(numb);
	    if(!isNum.matches()){
	       return false; 
	    } 
	    return true;
	}
	*/
	
	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getBankFullCode() {
		return bankFullCode;
	}

	public void setBankFullCode(String bankFullCode) {
		this.bankFullCode = bankFullCode;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSubBnakID() {
		return subBnakID;
	}

	public void setSubBnakID(String subBnakID) {
		this.subBnakID = subBnakID;
	}

	public String getSubBankName() {
		return subBankName;
	}

	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}

	public String getFullClientName() {
		return fullClientName;
	}

	public void setFullClientName(String fullClientName) {
		this.fullClientName = fullClientName;
	}

	public String getRegORpersonID() {
		return regORpersonID;
	}

	public void setRegORpersonID(String regORpersonID) {
		this.regORpersonID = regORpersonID;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getBusiTypeID() {
		return busiTypeID;
	}

	public void setBusiTypeID(String busiTypeID) {
		this.busiTypeID = busiTypeID;
	}

	public String getBusiTypeName() {
		return busiTypeName;
	}

	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}

	public String getGuaraSum() {
		return guaraSum;
	}

	public void setGuaraSum(String guaraSum) {
		this.guaraSum = guaraSum;
	}

	public String getGuarContractCode() {
		return guarContractCode;
	}

	public void setGuarContractCode(String guarContractCode) {
		this.guarContractCode = guarContractCode;
	}

	public String getGuaraBeginDate() {
		return guaraBeginDate;
	}

	public void setGuaraBeginDate(String guaraBeginDate) {
		this.guaraBeginDate = guaraBeginDate;
	}

	public String getGuaraEndDate() {
		return guaraEndDate;
	}

	public void setGuaraEndDate(String guaraEndDate) {
		this.guaraEndDate = guaraEndDate;
	}

	public String getIsRelateGuar() {
		return isRelateGuar;
	}

	public void setIsRelateGuar(String isRelateGuar) {
		this.isRelateGuar = isRelateGuar;
	}

	public String getOptFinanceCost() {
		return optFinanceCost;
	}

	public void setOptFinanceCost(String optFinanceCost) {
		this.optFinanceCost = optFinanceCost;
	}

	public String getThirdPartyGuar() {
		return thirdPartyGuar;
	}

	public void setThirdPartyGuar(String thirdPartyGuar) {
		this.thirdPartyGuar = thirdPartyGuar;
	}

	public String getThirdPartyGuarCode() {
		return thirdPartyGuarCode;
	}

	public void setThirdPartyGuarCode(String thirdPartyGuarCode) {
		this.thirdPartyGuarCode = thirdPartyGuarCode;
	}

	public String getThirdPartyGuar_2() {
		return thirdPartyGuar_2;
	}

	public void setThirdPartyGuar_2(String thirdPartyGuar_2) {
		this.thirdPartyGuar_2 = thirdPartyGuar_2;
	}

	public String getThirdPartyGuarCode_2() {
		return thirdPartyGuarCode_2;
	}

	public void setThirdPartyGuarCode_2(String thirdPartyGuarCode_2) {
		this.thirdPartyGuarCode_2 = thirdPartyGuarCode_2;
	}

	public String getThirdPartyGuar_3() {
		return thirdPartyGuar_3;
	}

	public void setThirdPartyGuar_3(String thirdPartyGuar_3) {
		this.thirdPartyGuar_3 = thirdPartyGuar_3;
	}

	public String getThirdPartyGuarCode_3() {
		return thirdPartyGuarCode_3;
	}

	public void setThirdPartyGuarCode_3(String thirdPartyGuarCode_3) {
		this.thirdPartyGuarCode_3 = thirdPartyGuarCode_3;
	}

	public String getSinglePayGuarSum() {
		return singlePayGuarSum;
	}

	public void setSinglePayGuarSum(String singlePayGuarSum) {
		this.singlePayGuarSum = singlePayGuarSum;
	}

	public String getGatherGuarSum() {
		return gatherGuarSum;
	}

	public void setGatherGuarSum(String gatherGuarSum) {
		this.gatherGuarSum = gatherGuarSum;
	}

	public String getGuarEarning() {
		return guarEarning;
	}

	public void setGuarEarning(String guarEarning) {
		this.guarEarning = guarEarning;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReportedCountIfDate() {
		return reportedCountIfDate;
	}

	public void setReportedCountIfDate(String reportedCountIfDate) {
		this.reportedCountIfDate = reportedCountIfDate;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(Long unit_uid) {
		this.unit_uid = unit_uid;
	}

	public String getReplaceType() {
		return replaceType;
	}

	public void setReplaceType(String replaceType) {
		this.replaceType = replaceType;
	}

	public String getReplaceSum() {
		return replaceSum;
	}

	public void setReplaceSum(String replaceSum) {
		this.replaceSum = replaceSum;
	}

	public String getFreeDate() {
		return freeDate;
	}

	public void setFreeDate(String freeDate) {
		this.freeDate = freeDate;
	}

	public String getReplaceInterestSum() {
		return replaceInterestSum;
	}

	public void setReplaceInterestSum(String replaceInterestSum) {
		this.replaceInterestSum = replaceInterestSum;
	}

	public String getReplaceOtherSum() {
		return replaceOtherSum;
	}

	public void setReplaceOtherSum(String replaceOtherSum) {
		this.replaceOtherSum = replaceOtherSum;
	}

	public String getRecoverSum() {
		return recoverSum;
	}

	public void setRecoverSum(String recoverSum) {
		this.recoverSum = recoverSum;
	}

	public String getRecoverDate() {
		return recoverDate;
	}

	public void setRecoverDate(String recoverDate) {
		this.recoverDate = recoverDate;
	}

	public String getIsOverRecover() {
		return isOverRecover;
	}

	public void setIsOverRecover(String isOverRecover) {
		this.isOverRecover = isOverRecover;
	}

	public String getTotalReplaceSum() {
		return totalReplaceSum;
	}

	public void setTotalReplaceSum(String totalReplaceSum) {
		this.totalReplaceSum = totalReplaceSum;
	}

	public String getTotalLossSum() {
		return totalLossSum;
	}

	public void setTotalLossSum(String totalLossSum) {
		this.totalLossSum = totalLossSum;
	}
	
	
}

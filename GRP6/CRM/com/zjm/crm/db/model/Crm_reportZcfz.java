package com.zjm.crm.db.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author zky
 * @time  :2017-5-27
 *       财务报表-资产负债表crm_reportZcfz实体;
 */
public class Crm_reportZcfz implements Serializable {
	private String 	reportZcfz_ID;//流水号	Variable characters (32)
	private String 	client_ID;//客户iD	Variable characters (32)
	private String reportTypeUuid ;//报表类型UUID	reportTypeUuid	Variable characters (32)
	private String reportTypeName;//报表类型名称		Variable characters (20)
	private String yearMonth;//年月		Variable characters (20)
	private Double currencyFunds;//货币资金	currencyFunds	Decimal (18,6)
	private Double shorttermInvest;//短期投资		Decimal (18,6)
	private Double notesReceivable;//应收票据	notesReceivable	Decimal (18,6)
	private Double dividendsReceivable;//应收股利	dividendsReceivable	Decimal (18,6)
	private Double interestReceivable;//应收利息	interestReceivable	Decimal (18,6)
	private Double accountsReceivable;//应收账款		Decimal (18,6)
	private Double otherReceivables;//其他应收款		Decimal (18,6)
	private Double prepaidAccount;//预付帐款		Decimal (18,6)
	private Double subsidiesReceivable;//应收补贴款		Decimal (18,6)
	private Double stock;//存货		Decimal (18,6)
	private Double deferredExpenses;//待摊费用		Decimal (18,6)
	private Double oneYearInvest;//一年内到期的长期债券投资		Decimal (18,6)
	private Double otherCurrentAssets;//其他流动资产		Decimal (18,6)
	private Double currentAssetsSum;//流动资产合计		Decimal (18,6)
	private Double longtermEquity;//长期股利投资		Decimal (18,6)
	private Double longtermInvest;//长期债权投资		Decimal (18,6)
	private Double longtermInvestSum;//长期投资合计		Decimal (18,6)
	private Double fixedAssetsOldValue;//固定资产原值		Decimal (18,6)
	private Double fixedAssetsDepreciation;//减：累计折旧		Decimal (18,6)
	private Double fixedAssetsValue;//固定资产净值		Decimal (18,6)
	private Double fixedAssetsDevalue;//固定资产减值准备		Decimal (18,6)
	private Double fixedAssetsAmount;//固定资产净额		Decimal (18,6)
	private Double engineeringMaterials;//工程物资		Decimal (18,6)
	private Double constructionEngineering;//在建工程		Decimal (18,6)
	private Double fixedAssetsClean;//固定资产清理		Decimal (18,6)
	private Double fixedAssetsSum;//固定资产合计		Decimal (18,6)
	private Double intangibleAssets;//无形资产		Decimal (18,6)
	private Double prepaidExpenses;//长期待摊费用		Decimal (18,6)
	private Double intangibleAssetsSum;//无形资产及其他资产合计		Decimal (18,6)
	private Double deferredTaxDebit;//递延税款借项		Decimal (18,6)
	private Double assetsSum;//资产合计		Decimal (18,6)
	private Double shortTermBorrowings;//短期借款		Decimal (18,6)
	private Double notesPayable;//应付票据		Decimal (18,6)
	private Double accountPayable;//应付账款		Decimal (18,6)
	private Double receivableAdvance;//预收账款		Decimal (18,6)
	private Double employeeSalary;//应付职工薪酬		Decimal (18,6)
	private Double dividendPayable;//应付股利		Decimal (18,6)
	private Double taxPayable;//应付税金		Decimal (18,6)
	private Double otherPayment;//其他应交款		Decimal (18,6)
	private Double otherPayables;//其他应付款		Decimal (18,6)
	private Double accruedExpenses;//预提费用		Decimal (18,6)
	private Double totalLiabilities;//预计负债		Decimal (18,6)
	private Double oneYearLiabilities;//一年内到期的长期负债		Decimal (18,6)
	private Double otherCurrentLiabilities;//其他流动负债		Decimal (18,6)
	private Double currentLiabilitiesSum;//流动负债合计		Decimal (18,6)
	private Double longtermLoans;//长期借款		Decimal (18,6)
	private Double bondsPayable;//应付债券		Decimal (18,6)
	private Double longtermPayables;//长期应付款		Decimal (18,6)
	private Double otherLiabilitiesSum;//其他长期负债		Decimal (18,6)
	private Double longtermLiabilitiesSum;//长期负债合计		Decimal (18,6)
	private Double deferredTax;//递延税款贷项		Decimal (18,6)
	private Double liabilitiesSum;//负债合计		Decimal (18,6)
	private Double paidCapital;//实收资本		Decimal (18,6)
	private Double capitalReserve;//资本公积		Decimal (18,6)
	private Double surplusReserve;//盈余公积		Decimal (18,6)
	private Double statutoryReserve;//其中：法定公益金		Decimal (18,6)
	private Double undistributedProfit;//未分配利润		Decimal (18,6)
	private Double owerRigtSum;//所有者权益合计		Decimal (18,6)
	private Double piabilitiesOwerRigtSum;//负债及所有者权益合计		Decimal (18,6)
	private String unit_uid;//担保机构ID		Variable characters (32)
	private String unit_uidName;//担保机构名称		Variable characters (50)
	private String updateUserName;//最后修改人名称		Variable characters (20)
	private Date updateDateTime;//最后修改时间		Date & Time
	
	private  Double  otherLongtermAssets;//其他长期资产
	
	
	//getter/setter
	
	
	
	public String getReportZcfz_ID() {
		return reportZcfz_ID;
	}
	public void setReportZcfz_ID(String reportZcfz_ID) {
		this.reportZcfz_ID = reportZcfz_ID;
	}
	public String getReportTypeUuid() {
		return reportTypeUuid;
	}
	public void setReportTypeUuid(String reportTypeUuid) {
		this.reportTypeUuid = reportTypeUuid;
	}
	public String getReportTypeName() {
		return reportTypeName;
	}
	public void setReportTypeName(String reportTypeName) {
		this.reportTypeName = reportTypeName;
	}
	public String getYearMonth() {
		
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		//将2017-04格式 转换为2017年04月格式;
		String year = yearMonth.substring(0,4)+"年";
		year=year +yearMonth.subSequence(5,7)+"月";
		this.yearMonth = year;
	}
	public Double getCurrencyFunds() {
		return currencyFunds;
	}
	public void setCurrencyFunds(Double currencyFunds) {
		this.currencyFunds = currencyFunds;
	}
	public Double getShorttermInvest() {
		return shorttermInvest;
	}
	public void setShorttermInvest(Double shorttermInvest) {
		this.shorttermInvest = shorttermInvest;
	}
	public Double getNotesReceivable() {
		return notesReceivable;
	}
	public void setNotesReceivable(Double notesReceivable) {
		this.notesReceivable = notesReceivable;
	}
	public Double getDividendsReceivable() {
		return dividendsReceivable;
	}
	public void setDividendsReceivable(Double dividendsReceivable) {
		this.dividendsReceivable = dividendsReceivable;
	}
	public Double getInterestReceivable() {
		return interestReceivable;
	}
	public void setInterestReceivable(Double interestReceivable) {
		this.interestReceivable = interestReceivable;
	}
	public Double getAccountsReceivable() {
		return accountsReceivable;
	}
	public void setAccountsReceivable(Double accountsReceivable) {
		this.accountsReceivable = accountsReceivable;
	}
	public Double getOtherReceivables() {
		return otherReceivables;
	}
	public void setOtherReceivables(Double otherReceivables) {
		this.otherReceivables = otherReceivables;
	}
	public Double getPrepaidAccount() {
		return prepaidAccount;
	}
	public void setPrepaidAccount(Double prepaidAccount) {
		this.prepaidAccount = prepaidAccount;
	}
	public Double getSubsidiesReceivable() {
		return subsidiesReceivable;
	}
	public void setSubsidiesReceivable(Double subsidiesReceivable) {
		this.subsidiesReceivable = subsidiesReceivable;
	}
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public Double getDeferredExpenses() {
		return deferredExpenses;
	}
	public void setDeferredExpenses(Double deferredExpenses) {
		this.deferredExpenses = deferredExpenses;
	}
	public Double getOneYearInvest() {
		return oneYearInvest;
	}
	public void setOneYearInvest(Double oneYearInvest) {
		this.oneYearInvest = oneYearInvest;
	}
	public Double getOtherCurrentAssets() {
		return otherCurrentAssets;
	}
	public void setOtherCurrentAssets(Double otherCurrentAssets) {
		this.otherCurrentAssets = otherCurrentAssets;
	}
	public Double getCurrentAssetsSum() {
		return currentAssetsSum;
	}
	public void setCurrentAssetsSum(Double currentAssetsSum) {
		this.currentAssetsSum = currentAssetsSum;
	}
	public Double getLongtermEquity() {
		return longtermEquity;
	}
	public void setLongtermEquity(Double longtermEquity) {
		this.longtermEquity = longtermEquity;
	}
	public Double getLongtermInvest() {
		return longtermInvest;
	}
	public void setLongtermInvest(Double longtermInvest) {
		this.longtermInvest = longtermInvest;
	}
	public Double getLongtermInvestSum() {
		return longtermInvestSum;
	}
	public void setLongtermInvestSum(Double longtermInvestSum) {
		this.longtermInvestSum = longtermInvestSum;
	}
	public Double getFixedAssetsOldValue() {
		return fixedAssetsOldValue;
	}
	public void setFixedAssetsOldValue(Double fixedAssetsOldValue) {
		this.fixedAssetsOldValue = fixedAssetsOldValue;
	}
	public Double getFixedAssetsDepreciation() {
		return fixedAssetsDepreciation;
	}
	public void setFixedAssetsDepreciation(Double fixedAssetsDepreciation) {
		this.fixedAssetsDepreciation = fixedAssetsDepreciation;
	}
	public Double getFixedAssetsValue() {
		return fixedAssetsValue;
	}
	public void setFixedAssetsValue(Double fixedAssetsValue) {
		this.fixedAssetsValue = fixedAssetsValue;
	}
	public Double getFixedAssetsDevalue() {
		return fixedAssetsDevalue;
	}
	public void setFixedAssetsDevalue(Double fixedAssetsDevalue) {
		this.fixedAssetsDevalue = fixedAssetsDevalue;
	}
	public Double getFixedAssetsAmount() {
		return fixedAssetsAmount;
	}
	public void setFixedAssetsAmount(Double fixedAssetsAmount) {
		this.fixedAssetsAmount = fixedAssetsAmount;
	}
	public Double getEngineeringMaterials() {
		return engineeringMaterials;
	}
	public void setEngineeringMaterials(Double engineeringMaterials) {
		this.engineeringMaterials = engineeringMaterials;
	}
	public Double getConstructionEngineering() {
		return constructionEngineering;
	}
	public void setConstructionEngineering(Double constructionEngineering) {
		this.constructionEngineering = constructionEngineering;
	}
	public Double getFixedAssetsClean() {
		return fixedAssetsClean;
	}
	public void setFixedAssetsClean(Double fixedAssetsClean) {
		this.fixedAssetsClean = fixedAssetsClean;
	}
	public Double getFixedAssetsSum() {
		return fixedAssetsSum;
	}
	public void setFixedAssetsSum(Double fixedAssetsSum) {
		this.fixedAssetsSum = fixedAssetsSum;
	}
	public Double getIntangibleAssets() {
		return intangibleAssets;
	}
	public void setIntangibleAssets(Double intangibleAssets) {
		this.intangibleAssets = intangibleAssets;
	}
	public Double getPrepaidExpenses() {
		return prepaidExpenses;
	}
	public void setPrepaidExpenses(Double prepaidExpenses) {
		this.prepaidExpenses = prepaidExpenses;
	}
	public Double getIntangibleAssetsSum() {
		return intangibleAssetsSum;
	}
	public void setIntangibleAssetsSum(Double intangibleAssetsSum) {
		this.intangibleAssetsSum = intangibleAssetsSum;
	}
	public Double getDeferredTaxDebit() {
		return deferredTaxDebit;
	}
	public void setDeferredTaxDebit(Double deferredTaxDebit) {
		this.deferredTaxDebit = deferredTaxDebit;
	}
	public Double getAssetsSum() {
		return assetsSum;
	}
	public void setAssetsSum(Double assetsSum) {
		this.assetsSum = assetsSum;
	}
	
	public Double getNotesPayable() {
		return notesPayable;
	}
	public void setNotesPayable(Double notesPayable) {
		this.notesPayable = notesPayable;
	}
	public Double getAccountPayable() {
		return accountPayable;
	}
	public void setAccountPayable(Double accountPayable) {
		this.accountPayable = accountPayable;
	}
	public Double getReceivableAdvance() {
		return receivableAdvance;
	}
	public void setReceivableAdvance(Double receivableAdvance) {
		this.receivableAdvance = receivableAdvance;
	}
	public Double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public Double getDividendPayable() {
		return dividendPayable;
	}
	public void setDividendPayable(Double dividendPayable) {
		this.dividendPayable = dividendPayable;
	}
	public Double getTaxPayable() {
		return taxPayable;
	}
	public void setTaxPayable(Double taxPayable) {
		this.taxPayable = taxPayable;
	}
	public Double getOtherPayment() {
		return otherPayment;
	}
	public void setOtherPayment(Double otherPayment) {
		this.otherPayment = otherPayment;
	}
	public Double getOtherPayables() {
		return otherPayables;
	}
	public void setOtherPayables(Double otherPayables) {
		this.otherPayables = otherPayables;
	}
	public Double getAccruedExpenses() {
		return accruedExpenses;
	}
	public void setAccruedExpenses(Double accruedExpenses) {
		this.accruedExpenses = accruedExpenses;
	}
	public Double getTotalLiabilities() {
		return totalLiabilities;
	}
	public void setTotalLiabilities(Double totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
	}
	public Double getOneYearLiabilities() {
		return oneYearLiabilities;
	}
	public void setOneYearLiabilities(Double oneYearLiabilities) {
		this.oneYearLiabilities = oneYearLiabilities;
	}
	public Double getOtherCurrentLiabilities() {
		return otherCurrentLiabilities;
	}
	public void setOtherCurrentLiabilities(Double otherCurrentLiabilities) {
		this.otherCurrentLiabilities = otherCurrentLiabilities;
	}
	public Double getCurrentLiabilitiesSum() {
		return currentLiabilitiesSum;
	}
	public void setCurrentLiabilitiesSum(Double currentLiabilitiesSum) {
		this.currentLiabilitiesSum = currentLiabilitiesSum;
	}
	public Double getLongtermLoans() {
		return longtermLoans;
	}
	public void setLongtermLoans(Double longtermLoans) {
		this.longtermLoans = longtermLoans;
	}
	public Double getBondsPayable() {
		return bondsPayable;
	}
	public void setBondsPayable(Double bondsPayable) {
		this.bondsPayable = bondsPayable;
	}
	public Double getLongtermPayables() {
		return longtermPayables;
	}
	public void setLongtermPayables(Double longtermPayables) {
		this.longtermPayables = longtermPayables;
	}
	public Double getOtherLiabilitiesSum() {
		return otherLiabilitiesSum;
	}
	public void setOtherLiabilitiesSum(Double otherLiabilitiesSum) {
		this.otherLiabilitiesSum = otherLiabilitiesSum;
	}
	public Double getLongtermLiabilitiesSum() {
		return longtermLiabilitiesSum;
	}
	public void setLongtermLiabilitiesSum(Double longtermLiabilitiesSum) {
		this.longtermLiabilitiesSum = longtermLiabilitiesSum;
	}
	public Double getDeferredTax() {
		return deferredTax;
	}
	public void setDeferredTax(Double deferredTax) {
		this.deferredTax = deferredTax;
	}
	public Double getLiabilitiesSum() {
		return liabilitiesSum;
	}
	public void setLiabilitiesSum(Double liabilitiesSum) {
		this.liabilitiesSum = liabilitiesSum;
	}
	public Double getPaidCapital() {
		return paidCapital;
	}
	public void setPaidCapital(Double paidCapital) {
		this.paidCapital = paidCapital;
	}
	public Double getCapitalReserve() {
		return capitalReserve;
	}
	public void setCapitalReserve(Double capitalReserve) {
		this.capitalReserve = capitalReserve;
	}
	public Double getSurplusReserve() {
		return surplusReserve;
	}
	public void setSurplusReserve(Double surplusReserve) {
		this.surplusReserve = surplusReserve;
	}
	public Double getStatutoryReserve() {
		return statutoryReserve;
	}
	public void setStatutoryReserve(Double statutoryReserve) {
		this.statutoryReserve = statutoryReserve;
	}
	public Double getUndistributedProfit() {
		return undistributedProfit;
	}
	public void setUndistributedProfit(Double undistributedProfit) {
		this.undistributedProfit = undistributedProfit;
	}
	public Double getOwerRigtSum() {
		return owerRigtSum;
	}
	public void setOwerRigtSum(Double owerRigtSum) {
		this.owerRigtSum = owerRigtSum;
	}
	public Double getPiabilitiesOwerRigtSum() {
		return piabilitiesOwerRigtSum;
	}
	public void setPiabilitiesOwerRigtSum(Double piabilitiesOwerRigtSum) {
		this.piabilitiesOwerRigtSum = piabilitiesOwerRigtSum;
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
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public Double getShortTermBorrowings() {
		return shortTermBorrowings;
	}
	public void setShortTermBorrowings(Double shortTermBorrowings) {
		this.shortTermBorrowings = shortTermBorrowings;
	}
	public Double getOtherLongtermAssets() {
		return otherLongtermAssets;
	}
	public void setOtherLongtermAssets(Double otherLongtermAssets) {
		this.otherLongtermAssets = otherLongtermAssets;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

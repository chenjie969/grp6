package com.zjm.crm.db.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author zky
 * @time  :2017-5-27
 *        财务报表-现金流量表 crm_reportXjl 实体;
 */
public class Crm_reportXjl implements Serializable {
	
	
	private String reportXjl_ID;//流水号		Variable characters (32)
	private String 	client_ID;//客户iD	Variable characters (32)
	private String reportTypeUuid;//报表类型UUID		Variable characters (32)
	private String reportTypeName;//报表类型名称		Variable characters (20)
	private String yearMonth;//年月		Variable characters (20)
	private Double servicesGoodsCash;//销售商品、提供劳务收到的现金		Decimal (18,6)
	private Double receivedTax;//收到的税费返还	receivedTax	Decimal (18,6)
	private Double operatingCash;//收到的其他与经营活动有关的现金		Decimal (18,6)
	private Double operatingCashSum;//经营活动现金流入小计		Decimal (18,6)
	private Double goodsLaborPayCash;//购买商品、接受劳务支付的现金		Decimal (18,6)
	private Double employeesToPayCash;//支付给职工以及为职工支付的现金		Decimal (18,6)
	private Double taxPayment;//支付的各项税费		Decimal (18,6)
	private Double otherOperatingActivities;//支付的其他与经营活动有关的现金		Decimal (18,6)
	private Double operatingCashFlow;//经营活动现金流出小计		Decimal (18,6)
	private Double activitiesNetCashFlow;//经营活动产生的现金流量净额		Decimal (18,6)
	private Double disinvestmentCash;//收回投资所收到的现金		Decimal (18,6)
	private Double investmentIncome;//取得投资收益所收到的现金		Decimal (18,6)
	private Double otherAssetsNetCash;// 处置固定资产、无形资产和其他长期资产所收回的现金净额		Decimal (18,6)
	private Double investmentActivitiesCash;//收到的其他与投资活动有关的现金		Decimal (18,6)
	private Double inflowsOfCash;//投资现金流入小计		Decimal (18,6)
	private Double longTermAssetsCash;//购建固定资产、无形资产和其他长期资产所支付的现金		Decimal (18,6)
	private Double paymentForInvestment;//投资所支付的现金		Decimal (18,6)
	private Double otherInvestingActivities;//支付的其他与投资活动有关的现金		Decimal (18,6)
	private Double cashOutflow;//投资现金流出小计		Decimal (18,6)
	private Double investmentActivities;//投资活动产生的现金流量净额		Decimal (18,6)
	private Double cashReceivedInvestment;//吸收投资收到的现金		Decimal (18,6)
	private Double cashReceivedLoan;//借款所收到的现金		Decimal (18,6)
	private Double financingActivities;//收到的其他与筹资活动有关的现金		Decimal (18,6)
	private Double financingCashFlows;//筹资现金流入小计		Decimal (18,6)
	private Double cashPayment;//偿还债务所支付的现金		Decimal (18,6)
	private Double profitCashPayment;//分配股利、利润或偿付利息所支付的现金		Decimal (18,6)
	private Double cashPayments;//支付的其他与筹资活动有关的现金		Decimal (18,6)
	private Double cashfFlowFinancing;//筹资现金流出小计		Decimal (18,6)
	private Double netCashFlow;//筹资活动产生的现金流量净额		Decimal (18,6)
	private Double exchangeRateCash;//汇率变动对现金的影响		Decimal (18,6)
	private Double cashEquivalentsAmount;//现金及现金等价物净增加额		Decimal (18,6)
	private Double netProfit;//净利润		Decimal (18,6)
	private Double stockholderLoss;//加：少数股东损益		Decimal (18,6)
	private Double unconfirmed;//减：未确认投资损失		Decimal (18,6)
	private Double assetsLoss;//加：计提的资产减值准备		Decimal (18,6)
	private Double plantAssetsLoss;//固定资产折旧	plantAssetsLoss	Decimal (18,6)
	private Double intangibleAssets;//无形资产摊销		Decimal (18,6)
	private Double longTermPrepaidExpenses;//长期待摊费用		Decimal (18,6)
	private Double otherLongTermAssetsLoss;//处置固定资产、无形资产和其他长期资产的损失（减：收益）		Decimal (18,6)
	private Double disposalFixedAssets;//固定资产报废损失		Decimal (18,6)
	private Double financialExpenses;//财务费用		Decimal (18,6)
	private Double investmentLoss ;//投资损失（减：收益）		Decimal (18,6)
	private Double deferredTax;//递延税款贷项（减：借项）		Decimal (18,6)
	private Double decreaseLoss;//存货的减少（减：增加）		Decimal (18,6)
	private Double decreaseOperatingLoss;//经营性应收项目的减少（减：增加）		Decimal (18,6)
	private Double increaseOperatingAdd;//经营性应付项目的增加（减：减少）		Decimal (18,6)
	private Double otherCash;//其它		Decimal (18,6)
	private Double activitiesNetCash;//经营活动产生的现金净额		Decimal (18,6)
	private Double convertedCapital;//债务转为资本		Decimal (18,6)
	private Double switchingCompanyBonds;//一年内到期的可转换公司债券		Decimal (18,6)
	private Double financeLease;//融资租入固定资产		Decimal (18,6)
	private Double other;//其 它		Decimal (18,6)
	private Double cashEnd;//现金的期末金额		Decimal (18,6)
	private Double cashBegin;//减：现金的期初余额		Decimal (18,6)
	private Double cashEquivalentsEnd;//加：现金等价物的期末余额		Decimal (18,6)
	private Double cashEquivalentsBegin;//减：现金等价物的期初余额		Decimal (18,6)
	private Double cashEquivalentsNetCash;//现金及现金等价物净增 加额		Decimal (18,6)
	private String unit_uid;//担保机构ID		Variable characters (32)
	private String unit_uidName;//担保机构名称		Variable characters (50)
	private String updateUserName;//最后修改人名称		Variable characters (20)
	private Date updateDateTime;//最后修改时间		Date & Time
	
	private  Double prepaidExpensesLoss;//待摊费用减少（减：增加）
	private  Double accruedExpensesAdd;//预提费用增加（减：减少）
	
	
	
	
	
	
	public String getReportXjl_ID() {
		return reportXjl_ID;
	}
	public void setReportXjl_ID(String reportXjl_ID) {
		this.reportXjl_ID = reportXjl_ID;
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
	public Double getServicesGoodsCash() {
		return servicesGoodsCash;
	}
	public void setServicesGoodsCash(Double servicesGoodsCash) {
		this.servicesGoodsCash = servicesGoodsCash;
	}
	public Double getReceivedTax() {
		return receivedTax;
	}
	public void setReceivedTax(Double receivedTax) {
		this.receivedTax = receivedTax;
	}
	public Double getOperatingCash() {
		return operatingCash;
	}
	public void setOperatingCash(Double operatingCash) {
		this.operatingCash = operatingCash;
	}
	public Double getOperatingCashSum() {
		return operatingCashSum;
	}
	public void setOperatingCashSum(Double operatingCashSum) {
		this.operatingCashSum = operatingCashSum;
	}
	public Double getGoodsLaborPayCash() {
		return goodsLaborPayCash;
	}
	public void setGoodsLaborPayCash(Double goodsLaborPayCash) {
		this.goodsLaborPayCash = goodsLaborPayCash;
	}
	public Double getEmployeesToPayCash() {
		return employeesToPayCash;
	}
	public void setEmployeesToPayCash(Double employeesToPayCash) {
		this.employeesToPayCash = employeesToPayCash;
	}
	public Double getTaxPayment() {
		return taxPayment;
	}
	public void setTaxPayment(Double taxPayment) {
		this.taxPayment = taxPayment;
	}
	public Double getOtherOperatingActivities() {
		return otherOperatingActivities;
	}
	public void setOtherOperatingActivities(Double otherOperatingActivities) {
		this.otherOperatingActivities = otherOperatingActivities;
	}
	public Double getOperatingCashFlow() {
		return operatingCashFlow;
	}
	public void setOperatingCashFlow(Double operatingCashFlow) {
		this.operatingCashFlow = operatingCashFlow;
	}
	public Double getActivitiesNetCashFlow() {
		return activitiesNetCashFlow;
	}
	public void setActivitiesNetCashFlow(Double activitiesNetCashFlow) {
		this.activitiesNetCashFlow = activitiesNetCashFlow;
	}
	public Double getDisinvestmentCash() {
		return disinvestmentCash;
	}
	public void setDisinvestmentCash(Double disinvestmentCash) {
		this.disinvestmentCash = disinvestmentCash;
	}
	public Double getInvestmentIncome() {
		return investmentIncome;
	}
	public void setInvestmentIncome(Double investmentIncome) {
		this.investmentIncome = investmentIncome;
	}
	public Double getOtherAssetsNetCash() {
		return otherAssetsNetCash;
	}
	public void setOtherAssetsNetCash(Double otherAssetsNetCash) {
		this.otherAssetsNetCash = otherAssetsNetCash;
	}
	public Double getInvestmentActivitiesCash() {
		return investmentActivitiesCash;
	}
	public void setInvestmentActivitiesCash(Double investmentActivitiesCash) {
		this.investmentActivitiesCash = investmentActivitiesCash;
	}
	public Double getInflowsOfCash() {
		return inflowsOfCash;
	}
	public void setInflowsOfCash(Double inflowsOfCash) {
		this.inflowsOfCash = inflowsOfCash;
	}
	public Double getLongTermAssetsCash() {
		return longTermAssetsCash;
	}
	public void setLongTermAssetsCash(Double longTermAssetsCash) {
		this.longTermAssetsCash = longTermAssetsCash;
	}
	public Double getPaymentForInvestment() {
		return paymentForInvestment;
	}
	public void setPaymentForInvestment(Double paymentForInvestment) {
		this.paymentForInvestment = paymentForInvestment;
	}
	public Double getOtherInvestingActivities() {
		return otherInvestingActivities;
	}
	public void setOtherInvestingActivities(Double otherInvestingActivities) {
		this.otherInvestingActivities = otherInvestingActivities;
	}
	public Double getCashOutflow() {
		return cashOutflow;
	}
	public void setCashOutflow(Double cashOutflow) {
		this.cashOutflow = cashOutflow;
	}
	public Double getInvestmentActivities() {
		return investmentActivities;
	}
	public void setInvestmentActivities(Double investmentActivities) {
		this.investmentActivities = investmentActivities;
	}
	public Double getCashReceivedInvestment() {
		return cashReceivedInvestment;
	}
	public void setCashReceivedInvestment(Double cashReceivedInvestment) {
		this.cashReceivedInvestment = cashReceivedInvestment;
	}
	public Double getCashReceivedLoan() {
		return cashReceivedLoan;
	}
	public void setCashReceivedLoan(Double cashReceivedLoan) {
		this.cashReceivedLoan = cashReceivedLoan;
	}
	public Double getFinancingActivities() {
		return financingActivities;
	}
	public void setFinancingActivities(Double financingActivities) {
		this.financingActivities = financingActivities;
	}
	public Double getFinancingCashFlows() {
		return financingCashFlows;
	}
	public void setFinancingCashFlows(Double financingCashFlows) {
		this.financingCashFlows = financingCashFlows;
	}
	public Double getCashPayment() {
		return cashPayment;
	}
	public void setCashPayment(Double cashPayment) {
		this.cashPayment = cashPayment;
	}
	public Double getProfitCashPayment() {
		return profitCashPayment;
	}
	public void setProfitCashPayment(Double profitCashPayment) {
		this.profitCashPayment = profitCashPayment;
	}
	public Double getCashPayments() {
		return cashPayments;
	}
	public void setCashPayments(Double cashPayments) {
		this.cashPayments = cashPayments;
	}
	public Double getCashfFlowFinancing() {
		return cashfFlowFinancing;
	}
	public void setCashfFlowFinancing(Double cashfFlowFinancing) {
		this.cashfFlowFinancing = cashfFlowFinancing;
	}
	public Double getNetCashFlow() {
		return netCashFlow;
	}
	public void setNetCashFlow(Double netCashFlow) {
		this.netCashFlow = netCashFlow;
	}
	public Double getExchangeRateCash() {
		return exchangeRateCash;
	}
	public void setExchangeRateCash(Double exchangeRateCash) {
		this.exchangeRateCash = exchangeRateCash;
	}
	public Double getCashEquivalentsAmount() {
		return cashEquivalentsAmount;
	}
	public void setCashEquivalentsAmount(Double cashEquivalentsAmount) {
		this.cashEquivalentsAmount = cashEquivalentsAmount;
	}
	public Double getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}
	public Double getStockholderLoss() {
		return stockholderLoss;
	}
	public void setStockholderLoss(Double stockholderLoss) {
		this.stockholderLoss = stockholderLoss;
	}
	public Double getUnconfirmed() {
		return unconfirmed;
	}
	public void setUnconfirmed(Double unconfirmed) {
		this.unconfirmed = unconfirmed;
	}
	public Double getAssetsLoss() {
		return assetsLoss;
	}
	public void setAssetsLoss(Double assetsLoss) {
		this.assetsLoss = assetsLoss;
	}
	public Double getPlantAssetsLoss() {
		return plantAssetsLoss;
	}
	public void setPlantAssetsLoss(Double plantAssetsLoss) {
		this.plantAssetsLoss = plantAssetsLoss;
	}
	public Double getIntangibleAssets() {
		return intangibleAssets;
	}
	public void setIntangibleAssets(Double intangibleAssets) {
		this.intangibleAssets = intangibleAssets;
	}
	public Double getLongTermPrepaidExpenses() {
		return longTermPrepaidExpenses;
	}
	public void setLongTermPrepaidExpenses(Double longTermPrepaidExpenses) {
		this.longTermPrepaidExpenses = longTermPrepaidExpenses;
	}
	public Double getOtherLongTermAssetsLoss() {
		return otherLongTermAssetsLoss;
	}
	public void setOtherLongTermAssetsLoss(Double otherLongTermAssetsLoss) {
		this.otherLongTermAssetsLoss = otherLongTermAssetsLoss;
	}
	public Double getDisposalFixedAssets() {
		return disposalFixedAssets;
	}
	public void setDisposalFixedAssets(Double disposalFixedAssets) {
		this.disposalFixedAssets = disposalFixedAssets;
	}
	public Double getFinancialExpenses() {
		return financialExpenses;
	}
	public void setFinancialExpenses(Double financialExpenses) {
		this.financialExpenses = financialExpenses;
	}
	public Double getInvestmentLoss() {
		return investmentLoss;
	}
	public void setInvestmentLoss(Double investmentLoss) {
		this.investmentLoss = investmentLoss;
	}
	public Double getDeferredTax() {
		return deferredTax;
	}
	public void setDeferredTax(Double deferredTax) {
		this.deferredTax = deferredTax;
	}
	public Double getDecreaseLoss() {
		return decreaseLoss;
	}
	public void setDecreaseLoss(Double decreaseLoss) {
		this.decreaseLoss = decreaseLoss;
	}
	public Double getDecreaseOperatingLoss() {
		return decreaseOperatingLoss;
	}
	public void setDecreaseOperatingLoss(Double decreaseOperatingLoss) {
		this.decreaseOperatingLoss = decreaseOperatingLoss;
	}
	public Double getIncreaseOperatingAdd() {
		return increaseOperatingAdd;
	}
	public void setIncreaseOperatingAdd(Double increaseOperatingAdd) {
		this.increaseOperatingAdd = increaseOperatingAdd;
	}
	public Double getOtherCash() {
		return otherCash;
	}
	public void setOtherCash(Double otherCash) {
		this.otherCash = otherCash;
	}
	public Double getActivitiesNetCash() {
		return activitiesNetCash;
	}
	public void setActivitiesNetCash(Double activitiesNetCash) {
		this.activitiesNetCash = activitiesNetCash;
	}
	public Double getConvertedCapital() {
		return convertedCapital;
	}
	public void setConvertedCapital(Double convertedCapital) {
		this.convertedCapital = convertedCapital;
	}
	public Double getSwitchingCompanyBonds() {
		return switchingCompanyBonds;
	}
	public void setSwitchingCompanyBonds(Double switchingCompanyBonds) {
		this.switchingCompanyBonds = switchingCompanyBonds;
	}
	public Double getFinanceLease() {
		return financeLease;
	}
	public void setFinanceLease(Double financeLease) {
		this.financeLease = financeLease;
	}
	public Double getOther() {
		return other;
	}
	public void setOther(Double other) {
		this.other = other;
	}
	public Double getCashEnd() {
		return cashEnd;
	}
	public void setCashEnd(Double cashEnd) {
		this.cashEnd = cashEnd;
	}
	public Double getCashBegin() {
		return cashBegin;
	}
	public void setCashBegin(Double cashBegin) {
		this.cashBegin = cashBegin;
	}
	public Double getCashEquivalentsEnd() {
		return cashEquivalentsEnd;
	}
	public void setCashEquivalentsEnd(Double cashEquivalentsEnd) {
		this.cashEquivalentsEnd = cashEquivalentsEnd;
	}
	public Double getCashEquivalentsBegin() {
		return cashEquivalentsBegin;
	}
	public void setCashEquivalentsBegin(Double cashEquivalentsBegin) {
		this.cashEquivalentsBegin = cashEquivalentsBegin;
	}
	public Double getCashEquivalentsNetCash() {
		return cashEquivalentsNetCash;
	}
	public void setCashEquivalentsNetCash(Double cashEquivalentsNetCash) {
		this.cashEquivalentsNetCash = cashEquivalentsNetCash;
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
	public Double getPrepaidExpensesLoss() {
		return prepaidExpensesLoss;
	}
	public void setPrepaidExpensesLoss(Double prepaidExpensesLoss) {
		this.prepaidExpensesLoss = prepaidExpensesLoss;
	}
	public Double getAccruedExpensesAdd() {
		return accruedExpensesAdd;
	}
	public void setAccruedExpensesAdd(Double accruedExpensesAdd) {
		this.accruedExpensesAdd = accruedExpensesAdd;
	}
   
	
	
	
	
}

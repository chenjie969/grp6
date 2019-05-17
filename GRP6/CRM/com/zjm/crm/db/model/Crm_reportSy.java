package com.zjm.crm.db.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author zky
 * @time  :2017-5-25
 *        财务报表-损益表Crm_reportSy实体;
 */
public class Crm_reportSy implements Serializable {
	private String 	reportSy_ID;//流水号	
	private String 	client_ID;//客户ID 
	private String 	reportTypeUuid;//报表类型UUID	
	private String  yearMonth;//年月	
	private String 	reportTypeName;//报表类型名称	
	private Double	mainIncome;//主营业收入
	private Double mainCost;//主营成本 
	private Double mainBusiTax;//主营业务税金及附加	
	private Double mainOperatingProfit;//主营业务利润
	private Double otherBusiProfit;//加：其它业务利润
	private Double busiFee;//减：营业费用
	private Double managementFee;//管理费用 
	private Double financialFee;//财务费用
	private Double exchangeLoss;//汇兑损失
	private Double operatingProfit;//营业利润	
	private Double incomeInvestment;//加：投资收益
	private Double subsidizeRevenue;//补贴收入 
	private Double operatingIncome;//营业外收入
	private Double busiExpenditure;//减：营业外支出
	private Double 	annualProfitLoss;//加：以前年度损益调整
	private Double profitSum;//利润总额
	private Double	incomeTax;//减：所得税
	private Double netProfit;//净利润		
	private String unit_uid;//担保机构id	
	private String unit_uidName;//担保机构名称		
	private String updateUserName;//最后修改人名称		
	private Date updateDateTime;//最后修改时间
     
	
	
	
	//getter/setter;
	public String getReportSy_ID() {
		return reportSy_ID;
	}
	public void setReportSy_ID(String reportSy_ID) {
		this.reportSy_ID = reportSy_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getReportTypeUuid() {
		return reportTypeUuid;
	}
	public void setReportTypeUuid(String reportTypeUuid) {
		this.reportTypeUuid = reportTypeUuid;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {//2017-04
		//将2017-04 转换为2017年04月;
		String year = yearMonth.substring(0,4)+"年";
		year=year +yearMonth.subSequence(5,7)+"月";
		
		this.yearMonth = year;
	}
	public String getReportTypeName() {
		return reportTypeName;
	}
	public void setReportTypeName(String reportTypeName) {
		this.reportTypeName = reportTypeName;
	}
	public Double getMainIncome() {
		return mainIncome;
	}
	public void setMainIncome(Double mainIncome) {
		this.mainIncome = mainIncome;
	}
	public Double getMainCost() {
		return mainCost;
	}
	public void setMainCost(Double mainCost) {
		this.mainCost = mainCost;
	}
	public Double getMainBusiTax() {
		return mainBusiTax;
	}
	public void setMainBusiTax(Double mainBusiTax) {
		this.mainBusiTax = mainBusiTax;
	}
	public Double getOtherBusiProfit() {
		return otherBusiProfit;
	}
	public void setOtherBusiProfit(Double otherBusiProfit) {
		this.otherBusiProfit = otherBusiProfit;
	}
	public Double getBusiFee() {
		return busiFee;
	}
	public void setBusiFee(Double busiFee) {
		this.busiFee = busiFee;
	}
	public Double getManagementFee() {
		return managementFee;
	}
	public void setManagementFee(Double managementFee) {
		this.managementFee = managementFee;
	}
	public Double getFinancialFee() {
		return financialFee;
	}
	public void setFinancialFee(Double financialFee) {
		this.financialFee = financialFee;
	}
	public Double getExchangeLoss() {
		return exchangeLoss;
	}
	public void setExchangeLoss(Double exchangeLoss) {
		this.exchangeLoss = exchangeLoss;
	}
	public Double getOperatingProfit() {
		return operatingProfit;
	}
	public void setOperatingProfit(Double operatingProfit) {
		this.operatingProfit = operatingProfit;
	}
	public Double getIncomeInvestment() {
		return incomeInvestment;
	}
	public void setIncomeInvestment(Double incomeInvestment) {
		this.incomeInvestment = incomeInvestment;
	}
	public Double getSubsidizeRevenue() {
		return subsidizeRevenue;
	}
	public void setSubsidizeRevenue(Double subsidizeRevenue) {
		this.subsidizeRevenue = subsidizeRevenue;
	}
	public Double getOperatingIncome() {
		return operatingIncome;
	}
	public void setOperatingIncome(Double operatingIncome) {
		this.operatingIncome = operatingIncome;
	}
	public Double getBusiExpenditure() {
		return busiExpenditure;
	}
	public void setBusiExpenditure(Double busiExpenditure) {
		this.busiExpenditure = busiExpenditure;
	}
	public Double getAnnualProfitLoss() {
		return annualProfitLoss;
	}
	public void setAnnualProfitLoss(Double annualProfitLoss) {
		this.annualProfitLoss = annualProfitLoss;
	}
	public Double getProfitSum() {
		return profitSum;
	}
	public void setProfitSum(Double profitSum) {
		this.profitSum = profitSum;
	}
	public Double getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
	}
	public Double getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
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
	public Double getMainOperatingProfit() {
		return mainOperatingProfit;
	}
	public void setMainOperatingProfit(Double mainOperatingProfit) {
		this.mainOperatingProfit = mainOperatingProfit;
	}
	
	
}

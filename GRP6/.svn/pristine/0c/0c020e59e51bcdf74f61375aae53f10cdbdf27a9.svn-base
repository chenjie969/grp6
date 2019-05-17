package com.zjm.crm.reportXjl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_reportXjlMapper;
import com.zjm.crm.db.model.Crm_reportXjl;
import com.zjm.crm.reportXjl.service.ReportXjlService;
import com.zjm.util.Tool;

@Service("reportXjlService")
@Transactional
public class ReportXjlServiceImpl implements ReportXjlService {

	@Resource
	private Crm_reportXjlMapper reportXjlMapper;
	
	@Resource
	private LogService logService;
	
	/***
	 *  返回现金流表分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectReportXjlPageTables(PageTable pageTable) {
		List<Crm_reportXjl> ReportXjlList = reportXjlMapper.selectReportXjlPageTables(pageTable);
		Long total = reportXjlMapper.selectReportXjlPageTables_Count(pageTable);
		pageTable.setRows(ReportXjlList);
		pageTable.setTotal(total);
		return pageTable;
	}
	
	/**
	 * 插入一个现金流表信息
	 * @param crm_reportXjl
	 * @return
	 */
	public Boolean insertOneReportXjlInfo(User user,Crm_reportXjl crm_reportXjl) {
		try {
			crm_reportXjl.setReportXjl_ID(Tool.createUUID32());//设置现金流表流水号
			crm_reportXjl.setUpdateUserName(user.getUser_name());//设置创建人
			crm_reportXjl.setUnit_uid(user.getUnit_uid());//设置担保机构id
			crm_reportXjl.setUnit_uidName(user.getUnit_uidName());//设置担保机构名称;
		  if(reportXjlMapper.insertOneReportXjlInfo(crm_reportXjl) == 1){
			  logService.insertOneOperatorLogInfo(user,"财务情况", "新增", "新增现金流表");
			  return true;
		  }
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return false;
		
	}
	/**
	 * 根据wheresql查询一个现金流表信息
	 * @param wheresql:reportXjl_ID,unit_uid
	 * @return
	 */
	public Crm_reportXjl selectOneReportXjlWhereSql(String wheresql) {	
		Crm_reportXjl OneReportXjl = new Crm_reportXjl();
		try {
			OneReportXjl = reportXjlMapper.selectOneReportXjlWhereSql(wheresql);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return OneReportXjl;
	}
	/**
	 * 更新一个现金流表信息
	 * @param crm_reportXjl
	 * @return
	 */
	public Boolean updateOneReportXjlInfo(User user,Crm_reportXjl reportXjl) {
		reportXjl.setUnit_uid(user.getUnit_uid());
		Crm_reportXjl oldReportXjl = reportXjlMapper.selectOneReportXjlWhereSql(" and reportXjl_ID = \'"+reportXjl.getReportXjl_ID()+"\'"+" and unit_uid  = \'"+reportXjl.getUnit_uid()+"\'");	
		if(oldReportXjl != null){
			oldReportXjl.setServicesGoodsCash(reportXjl.getServicesGoodsCash());//更新销售商品、提供劳务收到的现金
			oldReportXjl.setReceivedTax(reportXjl.getReceivedTax());//更新收到的税费返还
			oldReportXjl.setNetProfit(reportXjl.getNetProfit());//更新净利润
			oldReportXjl.setOperatingCash(reportXjl.getOperatingCash());//更新收到的其它与经营活动有关的现金
			oldReportXjl.setStockholderLoss(reportXjl.getStockholderLoss());//更新加：少数股东损益
			oldReportXjl.setOperatingCashSum(reportXjl.getOperatingCashSum());//更新经营现金流入小计
			oldReportXjl.setUnconfirmed(reportXjl.getUnconfirmed());//更新减：未确认投资损失
			oldReportXjl.setGoodsLaborPayCash(reportXjl.getGoodsLaborPayCash());//更新购买商品、接受劳务支付的现金
			oldReportXjl.setAssetsLoss(reportXjl.getAssetsLoss());//更新加：计提的资产减值准备
			oldReportXjl.setEmployeesToPayCash(reportXjl.getEmployeesToPayCash());//更新支付给职工以及为职工支付的现金
			oldReportXjl.setPlantAssetsLoss(reportXjl.getPlantAssetsLoss());//更新固定资产折旧
			oldReportXjl.setTaxPayment(reportXjl.getTaxPayment());//更新支付的各项税费
			oldReportXjl.setIntangibleAssets(reportXjl.getIntangibleAssets());//更新无形资产摊销
			oldReportXjl.setOtherOperatingActivities(reportXjl.getOtherOperatingActivities());//更新支付的其它与经营活动有关的现金
			oldReportXjl.setLongTermPrepaidExpenses(reportXjl.getLongTermPrepaidExpenses());//更新长期待摊费用
			oldReportXjl.setOperatingCashFlow(reportXjl.getOperatingCashFlow());//更新经营现金流出小计
			oldReportXjl.setPrepaidExpensesLoss(reportXjl.getPrepaidExpensesLoss());//更新待摊费用减少（减：增加）
			oldReportXjl.setActivitiesNetCashFlow(reportXjl.getActivitiesNetCashFlow());//更新经营活动产生的现金流量净额
			oldReportXjl.setAccruedExpensesAdd(reportXjl.getAccruedExpensesAdd());//更新预提费用增加（减：减少）
			oldReportXjl.setOtherLongTermAssetsLoss(reportXjl.getOtherLongTermAssetsLoss());//更新处置固定资产、无形资产和其它长期资产的损失（减：收益）
			oldReportXjl.setDisinvestmentCash(reportXjl.getDisinvestmentCash());//更新收回投资所收到的现金
			oldReportXjl.setDisposalFixedAssets(reportXjl.getDisposalFixedAssets());//更新固定资产报废损失
			oldReportXjl.setInvestmentIncome(reportXjl.getInvestmentIncome());//更新取得投资收益所收到的现金
			oldReportXjl.setFinancialExpenses(reportXjl.getFinancialExpenses());//更新财务费用
			oldReportXjl.setOtherAssetsNetCash(reportXjl.getOtherAssetsNetCash());//更新处置固定资产、无形资产和其它长期资产所回收的现金净额
			oldReportXjl.setInvestmentLoss(reportXjl.getInvestmentLoss());//更新投资损失（减：收益）
			oldReportXjl.setInvestmentActivitiesCash(reportXjl.getInvestmentActivitiesCash());//更新收到的其它与投资活动有关的现金
			oldReportXjl.setDeferredTax(reportXjl.getDeferredTax());//更新递延税款贷项（减：借项）
			oldReportXjl.setInflowsOfCash(reportXjl.getInflowsOfCash());//更新投资现金流入小计
			oldReportXjl.setDecreaseLoss(reportXjl.getDecreaseLoss());//更新存货的减少（减：增加）
			oldReportXjl.setLongTermAssetsCash(reportXjl.getLongTermAssetsCash());//更新购建固定资产、无形资产和其它长期资产所支付的现金
			oldReportXjl.setDecreaseOperatingLoss(reportXjl.getDecreaseOperatingLoss());//更新经营性应收项目的减少（减：增加）
			oldReportXjl.setPaymentForInvestment(reportXjl.getPaymentForInvestment());//更新投资所支付的现金
			oldReportXjl.setIncreaseOperatingAdd(reportXjl.getIncreaseOperatingAdd());//更新经营性应付项目的增加（减：减少）
			oldReportXjl.setOtherInvestingActivities(reportXjl.getOtherInvestingActivities());//更新支付的其它与投资活动有关的现金
			oldReportXjl.setOtherCash(reportXjl.getOtherCash());//更新其它
			oldReportXjl.setCashOutflow(reportXjl.getCashOutflow());//更新投资现金流出小计
			oldReportXjl.setActivitiesNetCash(reportXjl.getActivitiesNetCash());//更新经营活动产生的现金流量净额
			oldReportXjl.setInvestmentActivities(reportXjl.getInvestmentActivities());//更新投资活动产生的现金流量净额
			oldReportXjl.setConvertedCapital(reportXjl.getConvertedCapital());//更新债务转为资本
			oldReportXjl.setCashReceivedInvestment(reportXjl.getCashReceivedInvestment());//更新吸收投资所收到的现金
			oldReportXjl.setSwitchingCompanyBonds(reportXjl.getSwitchingCompanyBonds());//更新一年内到期的可转换公司债券
			oldReportXjl.setCashReceivedLoan(reportXjl.getCashReceivedLoan());//更新借款所收到的现金
			oldReportXjl.setFinanceLease(reportXjl.getFinanceLease());//更新融资租入固定资产
			oldReportXjl.setFinancingActivities(reportXjl.getFinancingActivities());//更新收到的其它与筹资活动有关的现金
			oldReportXjl.setOther(reportXjl.getOther());//更新其它
			oldReportXjl.setFinancingCashFlows(reportXjl.getFinancingCashFlows());//更新筹资现金流入小计
			oldReportXjl.setCashPayment(reportXjl.getCashPayment());//更新偿还债务所支付的现金
			oldReportXjl.setCashEnd(reportXjl.getCashEnd());//更新现金的期末余额
			oldReportXjl.setProfitCashPayment(reportXjl.getProfitCashPayment());//更新分配股利、利润或偿付利息所支付的现金
			oldReportXjl.setCashBegin(reportXjl.getCashBegin());//更新减：现金的期初余额
			oldReportXjl.setCashPayments(reportXjl.getCashPayments());//更新支付的其它与筹资活动有关的现金
			oldReportXjl.setCashEquivalentsEnd(reportXjl.getCashEquivalentsEnd());//更新加：现金等价物的期末余额
			oldReportXjl.setCashfFlowFinancing(reportXjl.getCashfFlowFinancing());//更新筹资现金流出小计
			oldReportXjl.setCashEquivalentsBegin(reportXjl.getCashEquivalentsBegin());//更新减：现金等价物的期初余额
			oldReportXjl.setNetCashFlow(reportXjl.getNetCashFlow());//更新筹资活动产生的现金流量净额
			oldReportXjl.setCashEquivalentsNetCash(reportXjl.getCashEquivalentsNetCash());//更新现金及现金等价物净增加额
			oldReportXjl.setExchangeRateCash(reportXjl.getExchangeRateCash());//更新四、汇率变动对现金的影响
			oldReportXjl.setCashEquivalentsAmount(reportXjl.getCashEquivalentsAmount());//更新五、现金及现金等价物净增加额
			oldReportXjl.setUpdateUserName(user.getUser_name());//设置最后更新人;
		}
		try {
			reportXjlMapper.updateOneReportXjlInfo(oldReportXjl);
			logService.insertOneOperatorLogInfo(user,"财务情况", "修改", "修改现金流表");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 根据wheresql删除一个现金流表信息
	 * @param wheresql :reportXjl_ID,unit_uid
	 * @return
	 */
	public Boolean delectReportXjlByWhereSql(User user,String wheresql) {
		if(reportXjlMapper.delectReportXjlByWhereSql(wheresql) == 1){
			logService.insertOneOperatorLogInfo(user,"财务情况", "删除", "删除现金流表");
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<Crm_reportXjl> selectCrm_ReportXjlList(String wheresql) {
		return reportXjlMapper.selectCrm_ReportXjlList(wheresql);
	}

	
	
	
}

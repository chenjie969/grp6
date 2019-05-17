package com.zjm.crm.reportSy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_reportSyMapper;
import com.zjm.crm.db.model.Crm_reportSy;
import com.zjm.crm.reportSy.service.ReportSyService;
import com.zjm.util.Tool;

@Service("reportSyService")
@Transactional
public class ReportSyServiceImpl implements ReportSyService {

	@Resource
	private Crm_reportSyMapper reportSyMapper;
	
	@Resource
	private LogService logService;
	
	/***
	 *  返回损益变表分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectReportSyPageTables(PageTable pageTable) {
		List<Crm_reportSy> ReportSyList = reportSyMapper.selectReportSyPageTables(pageTable);
		Long total = reportSyMapper.selectReportSyPageTables_Count(pageTable);
		pageTable.setRows(ReportSyList);
		pageTable.setTotal(total);
		return pageTable;
	}
	
	/**
	 * 插入一个损益变表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Boolean insertOneReportSyInfo(User user,Crm_reportSy crm_reportSy) {
		try {
			crm_reportSy.setReportSy_ID(Tool.createUUID32());//设置损益表流水号;
			crm_reportSy.setUpdateUserName(user.getUser_name());//设置更新人名称;
			crm_reportSy.setUnit_uid(user.getUnit_uid());//设置担保机构id
			crm_reportSy.setUnit_uidName(user.getUnit_uidName());//设置担保机构名称;
		  if(reportSyMapper.insertOneReportSyInfo(crm_reportSy) == 1){
			  logService.insertOneOperatorLogInfo(user,"财务情况", "新增", "新增损益表");
			  return true;
		  }
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return false;
		
	}
	/**
	 * 根据wheresql查询一个损益表信息
	 * @param wheresql:reportSy_ID,unit_uid
	 * @return
	 */
	public Crm_reportSy selectOneReportSyWhereSql(String wheresql) {	
		Crm_reportSy OneReportSy = new Crm_reportSy();
		try {
			OneReportSy = reportSyMapper.selectOneReportSyWhereSql(wheresql);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return OneReportSy;
	}
	/**
	 * 更新一个损益变表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Boolean updateOneReportSyInfo(User user,Crm_reportSy reportSy) {
		reportSy.setUnit_uid(user.getUnit_uid());
		Crm_reportSy oldReportSy = reportSyMapper.selectOneReportSyWhereSql(" and reportSy_ID = \'"+reportSy.getReportSy_ID()+"\'"+" and unit_uid  = \'"+reportSy.getUnit_uid()+"\'");	
		if(oldReportSy != null ){
			oldReportSy.setMainIncome(reportSy.getMainIncome());//更新主营业务收入;
			oldReportSy.setMainCost(reportSy.getMainCost());//更新主营成本;
			oldReportSy.setMainBusiTax(reportSy.getMainBusiTax());//更新主营业务税金及附加
			oldReportSy.setMainOperatingProfit(reportSy.getMainOperatingProfit());//更新主营业务利润;
			oldReportSy.setOtherBusiProfit(reportSy.getOtherBusiProfit());//更新加：其它业务利润
			oldReportSy.setBusiFee(reportSy.getBusiFee());//更新  减：营业费用
			oldReportSy.setManagementFee(reportSy.getManagementFee());//更新管理费用
			oldReportSy.setFinancialFee(reportSy.getFinancialFee());//更新财务费用;
			oldReportSy.setExchangeLoss(reportSy.getExchangeLoss());//更新兑汇损失;
			oldReportSy.setOperatingProfit(reportSy.getOperatingProfit());//更新营业利润;
			oldReportSy.setIncomeInvestment(reportSy.getIncomeInvestment());//更新加：投资收益
			oldReportSy.setSubsidizeRevenue(reportSy.getSubsidizeRevenue());//更新补贴收入;
			oldReportSy.setOperatingIncome(reportSy.getOperatingIncome());//更新营业外是收入;
			oldReportSy.setBusiExpenditure(reportSy.getBusiExpenditure());//减：营业外支出
			oldReportSy.setAnnualProfitLoss(reportSy.getAnnualProfitLoss());//更新加：以前年度损益调整
			oldReportSy.setProfitSum(reportSy.getProfitSum());//更新加：以前年度损益调整
			oldReportSy.setIncomeTax(reportSy.getIncomeTax());//更新减：所得税
			oldReportSy.setNetProfit(reportSy.getNetProfit());//更新净利润;
			oldReportSy.setMainOperatingProfit(reportSy.getMainOperatingProfit());//更新主营业务利润;		
			oldReportSy.setUpdateUserName(user.getUser_name());//设置最后更新人;
		}
		try {
			reportSyMapper.updateOneReportSyInfo(oldReportSy);
			logService.insertOneOperatorLogInfo(user,"财务情况", "修改", "修改损益表");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 根据wheresql删除一个损益变表信息
	 * @param wheresql :reportSy_ID,unit_uid
	 * @return
	 */
	public Boolean delectReportSyByWhereSql(User user,String wheresql) {
		if(reportSyMapper.delectReportSyByWhereSql(wheresql) == 1){
			logService.insertOneOperatorLogInfo(user,"财务情况", "删除", "删除损益表");
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * 查询损益表List
	 */
	@Override
	public List<Crm_reportSy> selectReportSyList(String wheresql) {
		try {
			return reportSyMapper.selectReportSyList(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}

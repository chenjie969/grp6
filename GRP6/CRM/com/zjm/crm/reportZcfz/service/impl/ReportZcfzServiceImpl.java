package com.zjm.crm.reportZcfz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_reportZcfzMapper;
import com.zjm.crm.db.model.Crm_reportZcfz;
import com.zjm.crm.reportZcfz.service.ReportZcfzService;
import com.zjm.util.Tool;
/**
 * 
 * 资产负债service 实现类;
 * @author zky
 * @time  2017-5-27
 *
 */
@Service("reportZcfzService")
@Transactional
public class ReportZcfzServiceImpl implements ReportZcfzService {

	@Resource
	private Crm_reportZcfzMapper reportZcfzMapper;
	
	@Resource
	private LogService logService;
	
	/***
	 *  返回资产负债表分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectReportZcfzPageTables(PageTable pageTable) {
		List<Crm_reportZcfz> reportZcfzList = reportZcfzMapper.selectReportZcfzPageTables(pageTable);
		Long total = reportZcfzMapper.selectReportZcfzPageTables_Count(pageTable);
		pageTable.setRows(reportZcfzList);
		pageTable.setTotal(total);
		return pageTable;
	}
	
	/**
	 * 插入一个资产负债表信息
	 * @param crm_reportSy
	 * @return
	 */
	public Boolean insertOneReportZcfzInfo(User user,Crm_reportZcfz reportZcfz) {
		try {
			reportZcfz.setReportZcfz_ID(Tool.createUUID32());//设置资产负债流水号;
			reportZcfz.setUpdateUserName(user.getUser_name());//设置更新人名称;		
			reportZcfz.setUnit_uid(user.getUnit_uid());//设置担保机构id
			reportZcfz.setUnit_uidName(user.getUnit_uidName());//设置担保机构名称;
		  if(reportZcfzMapper.insertOneReportZcfzInfo(reportZcfz) == 1){
			  logService.insertOneOperatorLogInfo(user,"财务情况", "新增", "新增资产负债表");
			  return true;
		  }
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return false;
		
	}
	/**
	 * 根据wheresql查询一个资产负债表信息
	 * @param wheresql:reportZcfz_ID,unit_uid
	 * @return
	 */
	public Crm_reportZcfz selectOneReportZcfzWhereSql(String wheresql) {	
		Crm_reportZcfz reportZcfz = new Crm_reportZcfz();
		try {
			reportZcfz = reportZcfzMapper.selectOneReportZcfzWhereSql(wheresql);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return reportZcfz;
	}
	/**
	 * 更新一个资产负债表信息
	 * @param crm_reportZcfz
	 * @return
	 */
	public Boolean updateOneReportZcfzInfo(User user,Crm_reportZcfz reportZcfz) {
		reportZcfz.setUnit_uid(user.getUnit_uid());
		Crm_reportZcfz oldReportZcfz = reportZcfzMapper.selectOneReportZcfzWhereSql(" and reportZcfz_ID = \'"+reportZcfz.getReportZcfz_ID()+"\'"+" and unit_uid  = \'"+reportZcfz.getUnit_uid()+"\'");			
		if(oldReportZcfz != null ){
			oldReportZcfz.setCurrencyFunds(reportZcfz.getCurrencyFunds());//更新货币资金
			oldReportZcfz.setShortTermBorrowings(reportZcfz.getShortTermBorrowings());//更新短期借款
			oldReportZcfz.setShorttermInvest(reportZcfz.getShorttermInvest());//更新短期投资
			oldReportZcfz.setNotesPayable(reportZcfz.getNotesPayable());//更新应付票据;
			oldReportZcfz.setNotesReceivable(reportZcfz.getNotesReceivable());//更新应收票据
			oldReportZcfz.setAccountPayable(reportZcfz.getAccountPayable());//更新应付账款
			oldReportZcfz.setDividendsReceivable(reportZcfz.getDividendsReceivable());//更新应收股利
			oldReportZcfz.setReceivableAdvance(reportZcfz.getReceivableAdvance());//更新预收账款
			oldReportZcfz.setInterestReceivable(reportZcfz.getInterestReceivable());//更新应收利息
			oldReportZcfz.setEmployeeSalary(reportZcfz.getEmployeeSalary());//更新应付职工薪酬
			oldReportZcfz.setAccountsReceivable(reportZcfz.getAccountsReceivable());//更新应收账款
			oldReportZcfz.setDividendPayable(reportZcfz.getDividendPayable());//更新应付股利
			oldReportZcfz.setOtherReceivables(reportZcfz.getOtherReceivables());//更新其它应收款
			oldReportZcfz.setTaxPayable(reportZcfz.getTaxPayable());//更新应付税金
			oldReportZcfz.setPrepaidAccount(reportZcfz.getPrepaidAccount());//更新预付账款
			oldReportZcfz.setOtherPayment(reportZcfz.getOtherPayment());//更新其他应交款;
			oldReportZcfz.setSubsidiesReceivable(reportZcfz.getSubsidiesReceivable());//更新应收补贴
			oldReportZcfz.setOtherPayables(reportZcfz.getOtherPayables());//更新其他应付款;
			oldReportZcfz.setStock(reportZcfz.getStock());//更新存货;
			oldReportZcfz.setAccruedExpenses(reportZcfz.getAccruedExpenses());//更新预提费用
			oldReportZcfz.setDeferredExpenses(reportZcfz.getDeferredExpenses());//更新待摊费用
			oldReportZcfz.setTotalLiabilities(reportZcfz.getTotalLiabilities());//更新预计负债
			oldReportZcfz.setOneYearInvest(reportZcfz.getOneYearInvest());//更新一年内到期的长期债券投资
			oldReportZcfz.setOneYearLiabilities(reportZcfz.getOneYearLiabilities());//更新一年内到期的长期负债
			oldReportZcfz.setOtherCurrentAssets(reportZcfz.getOtherCurrentAssets());//更新其他流动资产
			oldReportZcfz.setOtherCurrentLiabilities(reportZcfz.getOtherCurrentLiabilities());//更新其他流动负债
			oldReportZcfz.setCurrentAssetsSum(reportZcfz.getCurrentAssetsSum());//更新流动资产合计
			oldReportZcfz.setCurrentLiabilitiesSum(reportZcfz.getCurrentLiabilitiesSum());//更新流动负债合计
			oldReportZcfz.setLongtermEquity(reportZcfz.getLongtermEquity());//更新长期股利投资
			oldReportZcfz.setLongtermLoans(reportZcfz.getLongtermLoans());//更新长期借款
			oldReportZcfz.setLongtermInvest(reportZcfz.getLongtermInvest());//更新长期债权投资
			oldReportZcfz.setBondsPayable(reportZcfz.getBondsPayable());//更新应付债券
			oldReportZcfz.setLongtermInvestSum(reportZcfz.getLongtermInvestSum());//更新长期投资合计
			oldReportZcfz.setLongtermPayables(reportZcfz.getLongtermPayables());//更新长期应付款
			oldReportZcfz.setFixedAssetsOldValue(reportZcfz.getFixedAssetsOldValue());//更新固定资产
			oldReportZcfz.setOtherLiabilitiesSum(reportZcfz.getOtherLiabilitiesSum());//更新其他长期负债
			oldReportZcfz.setLongtermLiabilitiesSum(reportZcfz.getLongtermLiabilitiesSum());//更新长期负债合计
			oldReportZcfz.setFixedAssetsDepreciation(reportZcfz.getFixedAssetsDepreciation());//更新减 ： 累计折旧
			oldReportZcfz.setFixedAssetsValue(reportZcfz.getFixedAssetsValue());//更新固定资产净值
			oldReportZcfz.setDeferredTax(reportZcfz.getDeferredTax());//更新递延税款贷项
			oldReportZcfz.setFixedAssetsDevalue(reportZcfz.getFixedAssetsDevalue());//更新固定资产减值准备
			oldReportZcfz.setLiabilitiesSum(reportZcfz.getLiabilitiesSum());//更新负债合计
			oldReportZcfz.setFixedAssetsAmount(reportZcfz.getFixedAssetsAmount());//更新固定资产净额
			oldReportZcfz.setEngineeringMaterials(reportZcfz.getEngineeringMaterials());//更新工程物资
			oldReportZcfz.setConstructionEngineering(reportZcfz.getConstructionEngineering());//更新在建工程
			oldReportZcfz.setFixedAssetsClean(reportZcfz.getFixedAssetsClean());//更新固定资产清理
			oldReportZcfz.setFixedAssetsSum(reportZcfz.getFixedAssetsSum());//更新固定资产合计
			oldReportZcfz.setIntangibleAssets(reportZcfz.getIntangibleAssets());//更新无形资产
			oldReportZcfz.setPaidCapital(reportZcfz.getPaidCapital());//更新实收资本
			oldReportZcfz.setPrepaidExpenses(reportZcfz.getPrepaidExpenses());//更新长期待摊费用
			oldReportZcfz.setCapitalReserve(reportZcfz.getCapitalReserve());//更新资本公积
			oldReportZcfz.setSurplusReserve(reportZcfz.getSurplusReserve());//更新盈余公积
			oldReportZcfz.setIntangibleAssetsSum(reportZcfz.getIntangibleAssetsSum());//更新无形资产及其他资产合计
			oldReportZcfz.setStatutoryReserve(reportZcfz.getStatutoryReserve());//更新其中 ： 法定公益金
			oldReportZcfz.setUndistributedProfit(reportZcfz.getUndistributedProfit());//更新未分配利润
			oldReportZcfz.setDeferredTaxDebit(reportZcfz.getDeferredTaxDebit());//更新递延税款借项
			oldReportZcfz.setOwerRigtSum(reportZcfz.getOwerRigtSum());//更新所有者权益合计
			oldReportZcfz.setAssetsSum(reportZcfz.getAssetsSum());//更新资产总计;
			oldReportZcfz.setPiabilitiesOwerRigtSum(reportZcfz.getPiabilitiesOwerRigtSum());//更新负债及所有者权益合计		
			oldReportZcfz.setUpdateUserName(user.getUser_name());//更新设置最后更新人;
			oldReportZcfz.setOtherLongtermAssets(reportZcfz.getOtherLongtermAssets());//更新其他长期资产
		}
		try {
			reportZcfzMapper.updateOneReportZcfzInfo(oldReportZcfz);
			logService.insertOneOperatorLogInfo(user,"财务情况", "修改", "修改资产负债表");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 根据wheresql删除一个资产负债表信息
	 * @param wheresql :reportSy_ID,unit_uid
	 * @return
	 */            
	public Boolean delectReportZcfzByWhereSql(User user,String wheresql) {
		if(reportZcfzMapper.delectReportZcfzByWhereSql(wheresql) == 1){
			logService.insertOneOperatorLogInfo(user,"财务情况", "删除", "删除资产负债表");
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<Crm_reportZcfz> selectReportZcfzByList(String wheresql) {
		return reportZcfzMapper.selectReportZcfzByList(wheresql);
	}

	

	

	
	
	
}

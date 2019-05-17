package com.zjm.pro.planPay.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.db.map.Pro_planPayMapper;
import com.zjm.pro.db.model.Pro_planPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.planPay.service.PlanPayService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.util.Tool;

@Service("planPayService")
@Transactional
public class PlanPayServiceImpl implements PlanPayService {

	@Resource
	private Pro_planPayMapper pro_planPayMapper;
	@Resource
	private ApplyDetailService applyDetailService;
	@Resource
	private CostMustService costMustService;
	@Resource
	private LogService logService;
	@Resource
	private ProjectService projectService;
	
	@Override
	public PageTable<Pro_planPay> selectPlanPayPageTable(PageTable<Pro_planPay> pageTable) {
		try {
			List<Pro_planPay> planPayList = pro_planPayMapper.selectPlanPayListByWhereSql(" and ppp.apply_id='"+pageTable.getQueryCondition().getApply_ID()+"'");
			pageTable.setRows(planPayList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	@Override
	public Boolean insertOnePlanPay(User user, Pro_planPay planPay) {
		try {
			/*Pro_applyDetail applyDetail = applyDetailService.selectApplyDetailList(" and applyDetail_ID='"+planPay.getApplyDetail_ID()+"'").get(0);
			planPay.setBankID(applyDetail.getBankID());
			planPay.setBankName(applyDetail.getBankName());
			planPay.setBusiTypeID(applyDetail.getBusiTypeID());
			planPay.setBusiTypeName(applyDetail.getBusiTypeName());*/
			planPay.setPlanPay_ID(Tool.createUUID32());
			planPay.setPayStatus("未还款");
			planPay.setUnit_uid(user.getUnit_uid());
			planPay.setUpdateUserName(user.getUser_name());
			if(1==pro_planPayMapper.insertOnePlanPay(planPay)){
				logService.insertOneOperatorLogInfo(user, "还款计划", "新增", "新增一条还款计划, planPay_ID="+planPay.getPlanPay_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改还款计划
	 * 同时也要删除该还款计划对应的放款计划下的应收费用
	 */
	@Override
	public Boolean updateOnePlanPay(User user, Pro_planPay planPay) {
		try {
			costMustService.deleteCostMustByWheresql(" and loanPlan_ID='"+planPay.getLoanPlan_ID()+"'");
			planPay.setUpdateUserName(user.getUser_name());
			if(1==pro_planPayMapper.updateOnePlanPay(planPay)){
				logService.insertOneOperatorLogInfo(user, "还款计划", "修改", "修改一条还款计划, planPay_ID="+planPay.getPlanPay_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除还款计划
	 * 同时也要删除该还款计划对应的放款计划下的应收费用
	 */
	@Override
	public Boolean deleteOnePlanPay(User user, Pro_planPay planPay) {
		try {
			Integer result1 = pro_planPayMapper.deleteOnePlanPay(" and planPay_ID='"+planPay.getPlanPay_ID()+"'");
			costMustService.deleteCostMustByWheresql(" and planPay_ID='"+planPay.getLoanPlan_ID()+"'");
			if(1==result1){
				logService.insertOneOperatorLogInfo(user, "还款计划", "删除", "删除一条还款计划");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Pro_planPay selectOnePlanPay(String wheresql) {
		try {
			Pro_planPay planPay = pro_planPayMapper.selectOnePlanPay(wheresql);
			return planPay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Pro_planPay> selectPlanPayListByWheresql(String wheresql) {
		try {
			List<Pro_planPay> planPayList = pro_planPayMapper.selectPlanPayListByWhereSql(wheresql);
			return planPayList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询计划还款总金额
	 */
	@Override
	public Double totalPlanPaySumByWheresql(String wheresql) {
		try {
			return pro_planPayMapper.totalPlanPaySumByWheresql(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除还款计划, 同时删除同一放款计划下的应收费用
	 */
	@Override
	public Boolean deletePlanPayByWheresql(String wheresql) {
		try {
			costMustService.deleteCostMustByWheresql(wheresql);
			pro_planPayMapper.deletePlanPayByWheresql(wheresql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	// 添加还款计划  WHDB
	@Override
	public Boolean insertPlanPay(User user, Pro_planPay planPay) {
		try {
			String project_ID = planPay.getProject_ID();
			// 查询 保后（贷后）产品放款明细
			Pro_project project = projectService
					.selectOneProjectInfoByWheresql(" and project_ID='" + project_ID + "' ");

			if (project != null) {
				planPay.setApply_ID(project.getApply_ID());
				planPay.setApplyDetail_ID(project.getApplyDetail_ID());
				planPay.setLoanPlan_ID(project.getLoanPlan_ID());
			}
			planPay.setPayStatus("未还款");// 还款状态（中文：未还款/部分还款/已还清
			planPay.setUnit_uid(user.getUnit_uid());
			planPay.setUpdateUserName(user.getUser_name());

			String payCount = planPay.getPayCount();
			//Double loadSum = project.getLoadSum() == null ? 0D : project.getLoadSum();
			Double loadSum = planPay.getNotPlanPaySum() == null ? 0D : planPay.getNotPlanPaySum();
			Date billEndDate = project.getBillEndDate();//借据到期日期
			
			if (null != payCount && "one".equals(payCount)) {// 一次还款
				planPay.setPlanPay_ID(Tool.createUUID32());
				if (1 == pro_planPayMapper.insertOnePlanPay(planPay)) {
					logService.insertOneOperatorLogInfo(user, "还款计划", "新增",
							"新增一条还款计划, planPay_ID=" + planPay.getPlanPay_ID());
					return true;
				}
			} else if (null != payCount && "many".equals(payCount)) {// 多次还款
				Integer count = insertIntoPlanPay(loadSum,planPay,billEndDate);
				if (count>0) {
					logService.insertOneOperatorLogInfo(user, "还款计划", "新增",
							"新增一条还款计划, planPay");
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private Integer insertIntoPlanPay(Double loadSum,Pro_planPay planPay,Date billEndDate){
		Double planPaySum = planPay.getPlanPaySum() ==null ? 0D : planPay.getPlanPaySum();//计划每次还款金额
		Integer monthNum = planPay.getMonthNum();// 每隔几个月还一次款
		Date planPayDate = planPay.getPlanPayDate();// 计划首次还款日期
		
		int num=0;//还款次数
		Integer count = 0;
		if(planPayDate.getTime() == billEndDate.getTime()){
			planPay.setPlanPay_ID(Tool.createUUID32());
			planPay.setPlanPaySum(loadSum);
			planPay.setPlanPayDate(billEndDate);
			count = pro_planPayMapper.insertOnePlanPay(planPay);
		}else{
			if(loadSum.intValue()%planPaySum.intValue()==0){
				num = loadSum.intValue()/planPaySum.intValue();
				for(int i=1;i <= num; i++){
					planPay.setPlanPay_ID(Tool.createUUID32());
					planPay.setPlanPaySum(planPaySum);
					if(i==1){//
						planPay.setPlanPayDate(planPayDate);
					}else{
						Calendar cal = Calendar.getInstance();
						cal.setTime(planPayDate);
						cal.add(Calendar.MONTH, monthNum*(i-1));
						Date currentTime = cal.getTime();
						//int ii = currentTime.compareTo(billEndDate); 
						if(currentTime.getTime() > billEndDate.getTime()){//currentTime 在  billEndDate 之后
							//billEndDate;
							//(num-i)*planPaySum
							planPay.setPlanPaySum((num-(i-1))*planPaySum);
							planPay.setPlanPayDate(billEndDate);
							count = pro_planPayMapper.insertOnePlanPay(planPay);
							break;
						}
							
						planPay.setPlanPayDate(currentTime);
					}
					count = pro_planPayMapper.insertOnePlanPay(planPay);
				}
			}else{
				num = loadSum.intValue()/planPaySum.intValue()+1;
				for(int i=1;i <= num; i++){
					planPay.setPlanPay_ID(Tool.createUUID32());
					if(i==1){//第一次
						planPay.setPlanPaySum(planPaySum);
						planPay.setPlanPayDate(planPayDate);
					}else if(1<i && i<num){//中间
						planPay.setPlanPaySum(planPaySum);
						Calendar cal = Calendar.getInstance();
						cal.setTime(planPayDate);
						cal.add(Calendar.MONTH, monthNum*(i-1));
						Date currentTime = cal.getTime();
						if(currentTime.getTime() > billEndDate.getTime()){//currentTime 在  billEndDate 之后
							planPay.setPlanPaySum(loadSum-(i-1)*planPaySum);
							planPay.setPlanPayDate(billEndDate);
							count = pro_planPayMapper.insertOnePlanPay(planPay);
							break;
						}
						planPay.setPlanPayDate(currentTime);
					}else if(i==num){//最后一次
						planPay.setPlanPaySum(loadSum%planPaySum);
						Calendar cal = Calendar.getInstance();
						cal.setTime(planPayDate);
						cal.add(Calendar.MONTH, monthNum*(i-1));
						Date currentTime = cal.getTime();
						if(currentTime.getTime() > billEndDate.getTime()){//currentTime 在  billEndDate 之后
							planPay.setPlanPayDate(billEndDate);
							count = pro_planPayMapper.insertOnePlanPay(planPay);
							break;
						}
						planPay.setPlanPayDate(currentTime);
					}
					count = pro_planPayMapper.insertOnePlanPay(planPay);
				}
			}
		}
		return count;
	}
	/**
	 * 删除还款计划
	 */
	@Override
	public Boolean deleteOnePlanPayWhdb(User user, Pro_planPay planPay) {
		try {
			Integer result = pro_planPayMapper.deleteOnePlanPay(" and planPay_ID='"+planPay.getPlanPay_ID()+"'");
			if(1==result){
				logService.insertOneOperatorLogInfo(user, "还款计划", "删除", "删除一条还款计划");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

package com.opensymphony.workflow.util;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.FunctionProvider;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.spi.WorkflowEntry;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowInstanceService;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_replace;
import com.zjm.pro.delay.service.impl.DelayServiceImpl;
import com.zjm.pro.factPay.service.FactPayService;
import com.zjm.pro.factPay.service.impl.FactPayServiceImpl;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.replace.service.ReplaceService;
import com.zjm.util.SystemSession;

/**
 * 通用后置函数-调整子流程对应表单的状态
 * 参数定义:
 * 		tableName：表单名称
 * 		businessIdName:实体ID字段名称
 * 		columnName：修改字段名称
 * 		setValue：修改值
 * @author weizh
 * @version 2017-11-17
 */
@Component
public class Function_UpdateFactPayStatus implements FunctionProvider{

	@Override
	public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
		WorkflowEntry entry = (WorkflowEntry) transientVars.get("entry");
		String applyId = (String) transientVars.get("projectid"); 
		
		ProjectService projectService = (ProjectService) SpringContextUtil
				.getBean("projectService");
		//根据业务id获取业务表信息;
		String wheresql = " and apply_ID = \'"+applyId+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
	    OsGworkflowInstanceService osGworkflowInstanceService = (OsGworkflowInstanceService)SpringContextUtil.getBean("osGworkflowInstanceService");
	    OsGworkflowInstance query = new OsGworkflowInstance();
	    query.setEntryId(entry.getId());
		OsGworkflowInstance instance = osGworkflowInstanceService.selectOne(query, "entryId");
		FactPayService factPayService = (FactPayService) SpringContextUtil
				.getBean("factPayService");
		String delayWheresql = " and factPay_ID = \'"+instance.getBusinessId()+"\'";
		Pro_factPay factPay = factPayService.selectOneFactPayByWhereSql(delayWheresql);
		factPay.setIsCheck(0);
		//更新业务表数据;
  		if(project != null){
  			//更新在保余额   
//  			Double gGuarantySum=0d;
//  			gGuarantySum=project.getGuarantySum() ==null ? 0d :project.getGuarantySum();   //拿到之前的在保余额
//  			Double fGuarantySum=gGuarantySum-(factPay.getPayCapitalSum()==null?0d:factPay.getPayCapitalSum());
  			project.setGuarantySum(this.getGuarantySumByProject(project));
  			
  			//如果是逾期项目  更新逾期余额
  			/*if (1==project.getIsOver()) {
  				Double gOverplusSum = 0d;
  				gOverplusSum = project.getOverplusSum() == null? 0d :project.getOverplusSum();
  				project.setOverplusSum(gOverplusSum-(factPay.getPayCapitalSum()==null?0d:factPay.getPayCapitalSum()));
  			}	*/
  			//更新无代偿解除总金额
  			Double nNormalFreeSum=0d;
  			nNormalFreeSum=project.getNormalFreeSum()==null ?0d :project.getNormalFreeSum();//拿到之前的无代偿总金额
  			project.setNormalFreeSum(nNormalFreeSum+(factPay.getPaySum()==null ?0d:factPay.getPaySum()));
  			
  			//更新无代偿解除本金
  			Double nNormalCapitalSum=0d;
  			nNormalCapitalSum=project.getNormalCapitalSum()==null ?0d:project.getNormalCapitalSum(); //拿到之前的无代偿本金
  			project.setNormalCapitalSum(nNormalCapitalSum+(factPay.getPayCapitalSum()==null ?0d:factPay.getPayCapitalSum()));
  			
  			//更新无代偿解除利息
  			Double nNormalInterestSum=0d;
  			nNormalInterestSum=project.getNormalInterestSum()==null ?0d :project.getNormalInterestSum();//拿到之前的无代偿利息
  			project.setNormalInterestSum(nNormalInterestSum+(factPay.getPayInterestSum()==null?0d:factPay.getPayInterestSum()));
  			
  			
  			//更新无代偿解除日期
  			//project.setFreeDate(factPay.getPayDate());
  			projectService.updateOneProjectInfo(SystemSession.getUserSession(),project);
  			factPayService.updateOneFactPay(SystemSession.getUserSession(), factPay);
  		}
		
	}
	/**
	 * 计算项目的在保余额
	 * @param project
	 * @return
	 */
	public Double getGuarantySumByProject(Pro_project project){
		Double loadSum = project.getLoadSum()==null ? 0d :project.getLoadSum();
		FactPayService factPayService = (FactPayService) SpringContextUtil.getBean("factPayService");
		ReplaceService replaceService = (ReplaceService) SpringContextUtil.getBean("replaceService");
		List<Pro_factPay> list = factPayService.selectFactPayListByWhereSql(" and project_ID ='"+project.getProject_ID()+"'");
		Double paySum = 0d;
		if (list != null && list.size() > 0) {
			for (Pro_factPay factPya : list){
				paySum += factPya.getPayCapitalSum();
  			}
		}
		
		List<Pro_replace> replaceList = replaceService.selectReplaceList(" and project_ID ='"+project.getProject_ID()+"'");
		if (replaceList != null) {
			for (Pro_replace replace : replaceList){
				paySum += replace.getReplaceCapitalSum();
  			}
		}
		return (loadSum - paySum);
	}

}

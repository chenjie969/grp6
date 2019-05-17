package com.zjm.pro.factPay.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.startWorkFlow.service.GworkFlowService;
import com.zjm.pro.db.map.Pro_factPayMapper;
import com.zjm.pro.db.map.Pro_projectMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_replace;
import com.zjm.pro.factPay.service.FactPayService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.replace.service.ReplaceService;
import com.zjm.util.BigDecimalUtil;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Service("factPayService")
@Transactional
public class FactPayServiceImpl implements FactPayService {
    
	@Resource
	private ProjectService  projectService;
	@Resource
	private ReplaceService  replaceService;
	@Resource
	private Pro_factPayMapper pro_factPayMapper;
	@Resource
	private Pro_projectMapper pro_projectMapper;
	@Resource
	private Pro_projectfilesMapper projectfilesMapper;
	@Resource
	private LogService logService;
	@Resource
	private GworkFlowService gworkFlowService;
	BigDecimalUtil bigDecimal = new BigDecimalUtil();
	
	/***
	 *  还款情况信息表 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectFactPayTables(PageTable pageTable) {
		List<Pro_factPay> applyList = null;
		try {
			applyList = pro_factPayMapper.selectFactPayTables(pageTable);
			Long total = pro_factPayMapper.selectFactPayTables_Count(pageTable);
			pageTable.setRows(applyList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	
	/**
	 * 计算项目的在保余额
	 * @param project
	 * @return
	 */
	public Double getGuarantySumByProject(Pro_project project){
		Double loadSum = project.getLoadSum()==null ? 0d :project.getLoadSum();
			List<Pro_factPay> list = this.selectFactPayListByWhereSql(" and project_ID ='"+project.getProject_ID()+"'");
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
	
	
	/**
	 * 插入一个 还款情况信息
	 * @param 
	 * @return
	 */
	public Boolean insertOneFactPayInfo(User user, Pro_factPay factPay) {
		Integer returnInt2=0;
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+factPay.getProject_ID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
	    factPay.setFactPay_ID(Tool.createUUID32());
	    //新增一笔放款表信息;
	    factPay.setIsCheck(1);//默认没有通过还款流程
	    factPay.setUnit_uid(user.getUnit_uid());
	    factPay.setUpdateUserName(user.getUser_name());
	    Integer returnInt = pro_factPayMapper.insertOneFactPayInfo(factPay);
		if(project.getBusiClass().equals("02")){//委贷业务还款（还款流程）
			//新增委贷还款流程:
			OsGworkflowFlowtemplate flow = new OsGworkflowFlowtemplate();
			flow.setUnit_uid(user.getUnit_uid());
			flow.setUser_uid(user.getUser_uid());
			flow.setProjectID(factPay.getApplyID());
			flow.setEntityName("委贷还款");
			
			flow.setBusinessId(factPay.getFactPay_ID());
			flow.setBusinessType(factPay.getClass().getName());
			
			flow.setFlowTemplateName("委贷还款流程");
			flow.setFlowTemplateID("G401");
			flow.setFlowType("02");
			Long startResult = gworkFlowService.createworkflowInstance(flow);
			if(startResult == 0){
				throw new RuntimeException("流程模板配置有误");
			}
			b= true;
		}else{//担保业务还款
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
	  			project.setUpdateUserName(user.getUser_name());
	  		 returnInt2=pro_projectMapper.updateOneProjectInfo(project);
	  		}
	  		if(1==returnInt&&1==returnInt2){
				logService.insertOneOperatorLogInfo(user,"还款登记", "更新", "更新一条项目还款信息project_ID="+factPay.getProject_ID());
				logService.insertOneOperatorLogInfo(user,"还款登记", "新增", "新增一条还款表信息factPay_ID="+factPay.getFactPay_ID());
				b= true;
			}
		}
		return b;
	}

	/**
	 * 根据输入条件查询单个还款信息
	 * 
	 */
	public Pro_factPay selectOneFactPayByWhereSql(String whereSql) {
		Pro_factPay factPay = pro_factPayMapper.selectOneFactPayByWhereSql(whereSql);
		return factPay;
	}
	/**
	 * 修改还款登记信息
	 */
	public Boolean updateOneFactPay(User user, Pro_factPay pro_factPay) {
		Boolean b = false;
		Integer returnInt2=0;
		Integer returnInt = 0 ;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+pro_factPay.getProject_ID()+"\'";
	    Pro_project oldProject = projectService.selectOneProjectInfoByWheresql(wheresql);
	    //根据还款id获取还款表信息;
	    String wheresql1 = " and factPay_ID = \'"+pro_factPay.getFactPay_ID()+"\'";
	    Pro_factPay oldFactPay = pro_factPayMapper.selectOneFactPayByWhereSql(wheresql1);
	    if(null != oldProject && null != oldFactPay){
	    	//更新在保余额-----start
		    Double oldGuarantySum=0d;
		    oldGuarantySum=oldProject.getGuarantySum() ==null ? 0d :oldProject.getGuarantySum();   //拿到之前的在保余额
			Double newPayCapitalSum = (pro_factPay.getPayCapitalSum()==null?0d:pro_factPay.getPayCapitalSum());//拿到新的还款本金
			Double oldPayCapitalSum = (oldFactPay.getPayCapitalSum()==null?0d:oldFactPay.getPayCapitalSum());//拿到之前的还款本金
			Double newGuarantySum=oldGuarantySum-(newPayCapitalSum-oldPayCapitalSum);
			oldProject.setGuarantySum(newGuarantySum);//更新新的在保余额;
		    //更新在保余额-----end 
		    //更新无代偿解除总金额-----start
			Double oldNormalFreeSum=0d;
			oldNormalFreeSum=oldProject.getNormalFreeSum()==null ?0d :oldProject.getNormalFreeSum();//拿到之前的无代偿总金额
			Double newPaySum = (pro_factPay.getPaySum()==null ?0d:pro_factPay.getPaySum());
			Double oldPaySum = (oldFactPay.getPaySum()==null ?0d:oldFactPay.getPaySum());
			oldProject.setNormalFreeSum(oldNormalFreeSum+(newPaySum-oldPaySum));
			//更新无代偿解除总金额-----end 	
			//更新无代偿解除本金------start
			Double oldNormalCapitalSum=0d;
			
			oldNormalCapitalSum=oldProject.getNormalCapitalSum()==null ?0d:oldProject.getNormalCapitalSum(); //拿到之前的无代偿本金
			
			oldProject.setNormalCapitalSum(oldNormalCapitalSum+(newPayCapitalSum-oldPayCapitalSum));
			//更新无代偿解除本金------end	
			//更新无代偿解除利息---start
			Double oldNormalInterestSum=0d;
			oldNormalInterestSum=oldProject.getNormalInterestSum()==null ?0d :oldProject.getNormalInterestSum();//拿到之前的无代偿利息
			Double newPayInterestSum = (pro_factPay.getPayInterestSum()==null?0d:pro_factPay.getPayInterestSum());
			Double oldPayInterestSum = (oldFactPay.getPayInterestSum()==null?0d:oldFactPay.getPayInterestSum());
			oldProject.setNormalInterestSum(oldNormalInterestSum+(newPayInterestSum-oldPayInterestSum));
			//更新无代偿解除利息---start	
			//更新无代偿解除日期
			oldProject.setFreeDate(pro_factPay.getPayDate());
			oldProject.setUpdateUserName(user.getUser_name());
			returnInt2=pro_projectMapper.updateOneProjectInfo(oldProject);
		    returnInt=pro_factPayMapper.updateOneFactPay(pro_factPay);
	    }
	    if(returnInt>0&&returnInt2>0){
	    	logService.insertOneOperatorLogInfo(user,"保后跟踪还款登记", "新增", "新增一条还款表信息factPay_ID="+pro_factPay.getFactPay_ID());
	    	logService.insertOneOperatorLogInfo(user,"保后跟踪还款登记", "更新", "更新一条项目还款信息project_ID="+pro_factPay.getProject_ID());
	    	b=true;
	    }
		return b;
	}
	/**
	 * 删除单个还款表信息
	 */
	public Boolean deleteOneFactPay(User user, Pro_factPay pro_factPay) {
		Boolean b = false;
		Integer returnInt2 = 0;
		Integer returnInt = 0;
		String wheresql=" and factPay_ID = '"+pro_factPay.getFactPay_ID()+"'".trim();
		String wheresql2 = " and project_ID = \'"+pro_factPay.getProject_ID()+"\'";
		//根据还款id获取还款表信息;
	    Pro_factPay oldFactPay = pro_factPayMapper.selectOneFactPayByWhereSql(wheresql);
	    //根据业务id获取所有还款表信息
	   List<Pro_factPay> factPayList = pro_factPayMapper.selectFactPayListByWheresql(wheresql2);
	   
	   //根据业务id获取业务表信息;
  	    Pro_project oldProject = projectService.selectOneProjectInfoByWheresql(wheresql2);
		if(null != oldFactPay && null != oldProject){
			 //更新在保余额-----start
		    Double oldGuarantySum=0d;
		    oldGuarantySum=oldProject.getGuarantySum() ==null ? 0d :oldProject.getGuarantySum();   //拿到现在的在保余额
			Double oldPayCapitalSum = (oldFactPay.getPayCapitalSum()==null?0d:oldFactPay.getPayCapitalSum());//拿到删除还款新的 还款本金
			Double newGuarantySum=oldGuarantySum+oldPayCapitalSum;
			oldProject.setGuarantySum(newGuarantySum);//更新新的在保余额;
		    //更新在保余额-----end 
			//更新无代偿解除总金额-----start
			Double oldNormalFreeSum=0d;
			oldNormalFreeSum=oldProject.getNormalFreeSum()==null ?0d :oldProject.getNormalFreeSum();//拿到之前的无代偿总金额
			Double oldPaySum = (oldFactPay.getPaySum()==null ?0d:oldFactPay.getPaySum());
			oldProject.setNormalFreeSum(oldNormalFreeSum-oldPaySum);
			//更新无代偿解除本金------start
			Double oldNormalCapitalSum=0d;
			oldNormalCapitalSum=oldProject.getNormalCapitalSum()==null ?0d:oldProject.getNormalCapitalSum(); //拿到之前的无代偿本金
			oldProject.setNormalCapitalSum(oldNormalCapitalSum-oldPayCapitalSum);
			//更新无代偿解除本金------end
			//更新无代偿解除利息---start
			Double oldNormalInterestSum=0d;
			oldNormalInterestSum=oldProject.getNormalInterestSum()==null ?0d :oldProject.getNormalInterestSum();//拿到之前的无代偿利息
			Double oldPayInterestSum = (oldFactPay.getPayInterestSum()==null?0d:oldFactPay.getPayInterestSum());
			oldProject.setNormalInterestSum(oldNormalInterestSum-oldPayInterestSum);
			//更新无代偿解除利息---start	
			oldProject.setUpdateUserName(user.getUser_name());
			Integer factPayListLength = factPayList.size();
			if(2 == factPayListLength){//如果list长度等于2条数据;
				if(pro_factPay.getFactPay_ID().equals(factPayList.get(0).getFactPay_ID())){
					//如果要删除的对象与list中第一个元素相同;
					oldProject.setFreeDate(factPayList.get(1).getPayDate());
				}else{
					//如果要删除的对象与list中第一个元素不相同;
					oldProject.setFreeDate(factPayList.get(0).getPayDate());
				}
			}else{
				if(2 < factPayListLength){//如果list长度大于2条数据;
					if(pro_factPay.getFactPay_ID().equals(factPayList.get(factPayListLength-1).getFactPay_ID())){
						//如果要删除的对象与list中倒数第二个相同;
						oldProject.setFreeDate(factPayList.get(factPayListLength-2).getPayDate());
					}else{
						oldProject.setFreeDate(factPayList.get(factPayListLength-1).getPayDate());
					}
				}else{
					oldProject.setFreeDate(oldProject.getLoadEndDate());//如果小于2条数据,将解除日期设置为到期日期
				}
			}
			returnInt2 = pro_projectMapper.updateOneProjectInfo(oldProject);
			returnInt  = pro_factPayMapper.deleteOneFactPay(wheresql);
		}
		if(returnInt>0 && returnInt2 > 0){
			logService.insertOneOperatorLogInfo(user,"保后跟踪还款登记", "删除", "删除一条还款表信息factPay_ID="+pro_factPay.getFactPay_ID());
	    	logService.insertOneOperatorLogInfo(user,"保后跟踪还款登记", "更新", "更新一条项目还款信息project_ID="+pro_factPay.getProject_ID());
			b = true;
		}
		return b;
	}
	//查询多个还款表信息
	public List<Pro_factPay> selectFactPayListByWhereSql(String string) {
		List<Pro_factPay> factPayList = pro_factPayMapper.selectFactPayListByWheresql(string);
		return factPayList;
	}

	//查询项目对应的还款列表
	@Override
	public PageTable<Pro_factPay> selectPayTables(PageTable<Pro_factPay> pageTable) {
		List<Pro_factPay> applyList = null;
		try {
			applyList = pro_factPayMapper.selectPayTables(pageTable);
			Long total = pro_factPayMapper.selectPayTables_Count(pageTable);
			pageTable.setRows(applyList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	/** 
	 * 查一条还款信息
	 */
	@Override
	public Pro_factPay selectOneFactPayByID(String value) {
		Pro_factPay factPay = new Pro_factPay();
		try {
			factPay = pro_factPayMapper.selectOneFactPayByID(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factPay;
	}
	/**
	 * 删除一条还款信息
	 */
	@Override
	public Boolean cancelOneFactPayDel(Pro_factPay factPay) {
		//查询还款信息
		factPay = selectOneFactPayByID(" and factPay_ID = \'"+factPay.getFactPay_ID()+"\'");
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+factPay.getProject_ID()+"\'");
		
		updateProJect(factPay, project);
		
		Integer count = 0;
		Boolean isTrue = false;
		try {
			count = pro_factPayMapper.cancelOneFactPayDel(factPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count>0){
			logService.insertOneOperatorLogInfo(SystemSession.getUserSession(),"撤销还款", "撤销", "撤销一条还款信息");
			isTrue = true;
		}
		
		return isTrue;
	}


	//修改pro_project表
	private void updateProJect(Pro_factPay factPay,Pro_project project) {
		
		Pro_project project1 = new Pro_project();
		
		Double guarantySum = project.getGuarantySum();//在保余额
		Double guarantyDutyResSum = project.getGuarantyDutyResSum();//担保责任余金额
		Double guarantyScale = project.getGuarantyScale();//担保责任比例
		
		Double normalFreeSum = project.getNormalFreeSum();//还款总金额
		Double normalCapitalSum = project.getNormalCapitalSum();//其中：还款本金
		Double normalInterestSum = project.getNormalInterestSum();//其中：还款利息
		
		Double normalFreeSum1 = factPay.getPaySum();//还款总金额
		Double normalCapitalSum1 = factPay.getPayCapitalSum();//其中：还款本金
		Double normalInterestSum1 = factPay.getPayInterestSum();//其中：还款利息
		project1.setProject_ID(factPay.getProject_ID());
		try {
			project1.setNormalFreeSum(bigDecimal.sub(normalFreeSum, normalFreeSum1));
			project1.setNormalCapitalSum(bigDecimal.sub(normalCapitalSum, normalCapitalSum1));
			project1.setNormalInterestSum(bigDecimal.sub(normalInterestSum, normalInterestSum1));
			
			project1.setGuarantySum(bigDecimal.add(guarantySum, normalCapitalSum1));
			//project1.setGuarantyDutyResSum(bigDecimal.add(guarantyDutyResSum, normalCapitalSum1));
			Double normalCapitalSum2 = 0D;
			if(null!=guarantyScale){
				normalCapitalSum2 = bigDecimal.mul(normalCapitalSum1, guarantyScale)/100;
			}
			project1.setGuarantyDutyResSum(bigDecimal.add(guarantyDutyResSum, normalCapitalSum2));
			//更新项目表
			 pro_projectMapper.updateDutyRemove(project1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加一条还款信息
	 */
	@Override
	public Boolean addOneFactPay(Pro_factPay factPay) {
		factPay.setFactPay_ID(Tool.createUUID32());
		Pro_project project = new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'" + factPay.getProject_ID() + "\'");

		updateProJectAdd(factPay, project);

		Integer count = 0;
		Boolean isTrue = false;
		User user = SystemSession.getUserSession();
		factPay.setUnit_uid(user.getUnit_uid());
		factPay.setUpdateUserName(user.getUser_name());
		try {
			count = pro_factPayMapper.insertOneFactPayInfo(factPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0) {
			logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "部分还款", "添加", "添加一条还款信息");
			isTrue = true;
		}

		return isTrue;
	}
	
	//修改pro_project表
	private void updateProJectAdd(Pro_factPay factPay, Pro_project project) {

		Pro_project project1 = new Pro_project();

		Double guarantySum = project.getGuarantySum();// 在保余额
		Double guarantyDutyResSum = project.getGuarantyDutyResSum();// 担保责任余金额
		Double guarantyScale = project.getGuarantyScale();//担保责任比例

		Double normalFreeSum = project.getNormalFreeSum();// 还款总金额
		Double normalCapitalSum = project.getNormalCapitalSum();// 其中：还款本金
		Double normalInterestSum = project.getNormalInterestSum();// 其中：还款利息

		Double normalFreeSum1 = factPay.getPaySum();// 还款总金额
		Double normalCapitalSum1 = factPay.getPayCapitalSum();// 其中：还款本金
		Double normalInterestSum1 = factPay.getPayInterestSum();// 其中：还款利息
		project1.setProject_ID(factPay.getProject_ID());
		try {
			project1.setNormalFreeSum(bigDecimal.add(normalFreeSum, normalFreeSum1));
			project1.setNormalCapitalSum(bigDecimal.add(normalCapitalSum, normalCapitalSum1));
			project1.setNormalInterestSum(bigDecimal.add(normalInterestSum, normalInterestSum1));

			project1.setGuarantySum(bigDecimal.sub(guarantySum, normalCapitalSum1));
			Double normalCapitalSum2 = 0D;
			if(null!=guarantyScale){
				normalCapitalSum2 = bigDecimal.mul(normalCapitalSum1, guarantyScale)/100;
			}
			project1.setGuarantyDutyResSum(bigDecimal.sub(guarantyDutyResSum, normalCapitalSum2));
			// 更新项目表
			pro_projectMapper.updateDutyRemove(project1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查询正常解除申请信息
	@Override
	public List<Pro_factPay> selectFactPayList(String condition) {
		List<Pro_factPay> applyList = null;
		try {
			applyList = pro_factPayMapper.selectFactPayList(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return applyList;
	}
	
	/**
	 * 插入一个 还款情况信息
	 * @param 
	 * @return
	 */
	public Boolean insertOneFactPayWHDB(User user, Pro_factPay factPay) {
		Integer returnInt2=0;
		Boolean b = false;
		//根据业务id获取业务表信息;
		String wheresql = " and project_ID = \'"+factPay.getProject_ID()+"\'";
	    Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
		
	    //新增一笔放款表信息;
	    factPay.setPayState("审批中");
	    factPay.setApplyID(project.getApply_ID());
	    factPay.setOperationManID(user.getUser_id());
	    factPay.setOperationManName(user.getUser_name());
	    factPay.setUnit_uid(user.getUnit_uid());
	    factPay.setUpdateUserName(user.getUser_name());
	    Integer returnInt = pro_factPayMapper.insertOneFactPayInfo(factPay);
		
	    //更新业务表数据;
  		if(project != null){
  			//更新在保余额   
  			Double gGuarantySum=0d;
  			gGuarantySum=project.getGuarantySum() ==null ? 0d :project.getGuarantySum();   //拿到之前的在保余额
  			Double fGuarantySum=gGuarantySum-(factPay.getPaySum()==null?0d:factPay.getPaySum());
  			project.setGuarantySum(fGuarantySum);
  			//担保责任比例
  			Double guarantyScale = project.getGuarantyScale()==null ?0d : project.getGuarantyScale();
  			Double guarantyDutyResSum = (fGuarantySum*guarantyScale)/100;
  			project.setGuarantyDutyResSum(guarantyDutyResSum);
  			//更新无代偿解除日期
  			project.setFreeDate(factPay.getPayDate());
  			project.setUpdateUserName(user.getUser_name());
  		 returnInt2=pro_projectMapper.updateOneProjectInfo(project);
  		}
		if(1==returnInt&&1==returnInt2){
			logService.insertOneOperatorLogInfo(user,"还款登记", "更新", "更新一条项目还款信息project_ID="+factPay.getProject_ID());
			logService.insertOneOperatorLogInfo(user,"还款登记", "新增", "新增一条还款表信息factPay_ID="+factPay.getFactPay_ID());
			b= true;
		}
		return b;
	}
	//删除还款信息
	@Override
	public Object deleteOneFactPay(Pro_factPay factPay) {
		User user = SystemSession.getUserSession();
		Integer returnInt2=0;
		Boolean b = false;
		try {
			//删除附件表pro_projectfiles对应的信息
			projectfilesMapper.deleteOneProFilesByEntityID(" and entityID='"+factPay.getFactPay_ID()+"'");
			factPay = pro_factPayMapper.selectOneFactPayByID(" and factPay.factPay_ID ='"+factPay.getFactPay_ID()+"' ");
			//根据业务id获取业务表信息;
			String wheresql = " and project_ID = \'"+factPay.getProject_ID()+"\'";
			Pro_project project = projectService.selectOneProjectInfoByWheresql(wheresql);
			Integer returnInt=0;
			//更新业务表数据;
			if(project != null){
				//更新在保余额   
				Double gGuarantySum=0d;
				gGuarantySum=project.getGuarantySum() ==null ? 0d :project.getGuarantySum();   //拿到之前的在保余额
				Double fGuarantySum=gGuarantySum+(factPay.getPaySum()==null?0d:factPay.getPaySum());
				project.setGuarantySum(fGuarantySum);
				//担保责任比例
				Double guarantyScale = project.getGuarantyScale()==null ?0d : project.getGuarantyScale();
				Double guarantyDutyResSum = (fGuarantySum*guarantyScale)/100;
				project.setGuarantyDutyResSum(guarantyDutyResSum);
				project.setUpdateUserName(user.getUser_name());
				returnInt2 = pro_projectMapper.updateOneProjectInfo(project);
				returnInt = pro_factPayMapper.cancelOneFactPayDel(factPay);
			}
			if(1==returnInt&&1==returnInt2){
				logService.insertOneOperatorLogInfo(user,"还款登记", "删除", "删除一条项目还款信息project_ID="+factPay.getProject_ID());
				logService.insertOneOperatorLogInfo(user,"还款登记", "新增", "新增一条还款表信息factPay_ID="+factPay.getFactPay_ID());
				b= true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}

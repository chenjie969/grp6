package com.zjm.pro.cost.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.UrlParam;
import com.zjm.pro.costDelay.service.CostDelayService;
import com.zjm.pro.costFact.service.CostFactService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.costReturn.service.CostReturnService;
import com.zjm.pro.db.model.Pro_costDelay;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.db.model.Pro_costReturn;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_planPay;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.meetingCost.service.MeetingCostService;
import com.zjm.pro.planPay.service.PlanPayService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
 * 事项中收费登记 
 */
@Controller
@RequestMapping(value="/project/cost")
public class CostAction {
	
	@Resource
	private MeetingCostService meetingCostService;
	@Resource
	private CostMustService costMustService;
	@Resource
	private CostDelayService costDelayService;
	@Resource
	private CostPreService costPreService;
	@Resource
	private CostFactService costFactService;
	@Resource
	private CostReturnService costReturnService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private LoanService loanService;
	@Resource
	private PlanPayService planPayService;
	/**
	 * 显示收费登记页面 
	 */
	@RequestMapping(value="/showCostRecordPage")
	public ModelAndView showCostRecordPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		List<Pro_meetingDetail> meetingDetailList = new ArrayList<>();
		//meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and apply_ID=   \'"+"d30782cd61cc4d8ab797c4eddd1c4605"+"\'");
		meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and apply_ID ='"+urlParam.getEntityID()+"'");
		/*//全部放在meetingDetailList
		 for (Pro_meetingDetail pro_meetingDetail : meetingDetailList) {
			  //循环评审会产品明细获取计划放款信息;
				 List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+pro_meetingDetail.getMeetingDetail_ID()+"'");
				 pro_meetingDetail.setLoanPlanList(loanPlanList);
				// 查询放款计划下的还款计划
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");
					pro_meetingDetail.setPlanPayList(planPayList);
				}
			    //查询放款计划下的应收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
					pro_meetingDetail.setCostMustList(costMustList);
				}
				
				
			
		}*/
		 
		// 查询评审会详情下的放款计划
			for (Pro_meetingDetail meetingDetail : meetingDetailList) {
				List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"'");
				meetingDetail.setLoanPlanList(loanPlanList);
				// 查询放款计划下的还款计划
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");
					loanPlan.setPlanPayList(planPayList);
				}
				
				// 查询放款计划下的应收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
					loanPlan.setCostMustList(costMustList);
				}
				// 查询放款计划下的预收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
					loanPlan.setCostPreList(costPreList);
					HashMap<String, Double> costPreSumMap= new HashMap<>();
					
					for (Pro_costPre pro_costPre : costPreList) {
						Double double1 = costPreSumMap.get(pro_costPre.getCostTypeName());
						Double preCostSum = pro_costPre.getPreCostSum();
						if(null == double1){//如果map中不存在此费用类型
							costPreSumMap.put(pro_costPre.getCostTypeName(), preCostSum);
						}else{//存在--相加
							preCostSum = pro_costPre.getPreCostSum();
							costPreSumMap.put(pro_costPre.getCostTypeName(), preCostSum+double1);
						}
						
					}
					loanPlan.setCostPreSumMap(costPreSumMap);
					
				}
				// 查询放款计划下的实收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					 String whereSql =" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'";
					 whereSql += " and costFactState != '未确认' ";
					 List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(whereSql);
					 loanPlan.setCostFactList(costFactList);
				}
				// 查询放款计划下的实收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					 List<Pro_costReturn> costReturnList = new ArrayList<>();
					 String whereSql =" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'";
					 costReturnList = costReturnService.selectCostReturnListByWhereSql(whereSql);
					 loanPlan.setCostReturnList(costReturnList);
				}
				
			}
		
		
		
		
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("meetingDetailList",meetingDetailList);
		modelMap.put("urlParam",urlParam);
		mv.setViewName("/project/cost/costRecordIndex");
		return mv;
	}
	/**
	 *手机端--- 显示收费登记页面 
	 */
	@RequestMapping(value="/showCostRecordPageApp")
	@ResponseBody
	public AjaxRes showCostRecordPageApp(UrlParam urlParam){
		AjaxRes ar = new AjaxRes();
		List<Pro_meetingDetail> meetingDetailList = new ArrayList<>();
		//meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and apply_ID=   \'"+"d30782cd61cc4d8ab797c4eddd1c4605"+"\'");
		meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and apply_ID ='"+urlParam.getEntityID()+"'");
		// 查询评审会详情下的放款计划
			for (Pro_meetingDetail meetingDetail : meetingDetailList) {
				List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"'");
				meetingDetail.setLoanPlanList(loanPlanList);
				// 查询放款计划下的还款计划
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");
					loanPlan.setPlanPayList(planPayList);
				}
				
				// 查询放款计划下的应收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
					loanPlan.setCostMustList(costMustList);
				}
				// 查询放款计划下的预收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
					loanPlan.setCostPreList(costPreList);
					HashMap<String, Double> costPreSumMap= new HashMap<>();
					
					for (Pro_costPre pro_costPre : costPreList) {
						Double double1 = costPreSumMap.get(pro_costPre.getCostTypeName());
						Double preCostSum = pro_costPre.getPreCostSum();
						if(null == double1){//如果map中不存在此费用类型
							costPreSumMap.put(pro_costPre.getCostTypeName(), preCostSum);
						}else{//存在--相加
							preCostSum = pro_costPre.getPreCostSum();
							costPreSumMap.put(pro_costPre.getCostTypeName(), preCostSum+double1);
						}
						
					}
					loanPlan.setCostPreSumMap(costPreSumMap);
					
				}
				// 查询放款计划下的实收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					 String whereSql =" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'";
					 whereSql += " and costFactState != '未确认' ";
					 List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(whereSql);
					 loanPlan.setCostFactList(costFactList);
				}
				// 查询放款计划下的实收费用
				for (Pro_loanPlan loanPlan : loanPlanList) {
					 List<Pro_costReturn> costReturnList = new ArrayList<>();
					 String whereSql =" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'";
					 costReturnList = costReturnService.selectCostReturnListByWhereSql(whereSql);
					 loanPlan.setCostReturnList(costReturnList);
				}
				
			}
		
		
		
		
		//modelMap.put("meetingDetailList",meetingDetailList);
		//modelMap.put("urlParam",urlParam);
		List<Object> objectList	 = new ArrayList<>();
		objectList.add(meetingDetailList);
		objectList.add(urlParam);
		ar.setSucceed(objectList);
		return ar;
	}
	/**
	 * 查询应收费用列表
	 */
	@RequestMapping(value="/selectCostMustPageTable")
	@ResponseBody
	public AjaxRes selectCostMustPageTable(@RequestBody PageTable<Pro_costMust> pageTable){
		AjaxRes ar = new AjaxRes();
		 PageTable<Pro_costMust> costMustPageTable = costMustService.selectCostMustPageTable(pageTable);
		ar.setSucceed(costMustPageTable);
		return ar;
	}
	
	/**
	 * 查询缓收费用列表
	 */
	@RequestMapping(value="/selectCostDelayPageTable")
	@ResponseBody
	public AjaxRes selectCostDelayPageTable(@RequestBody PageTable<Pro_costDelay> pageTable){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costDelayService.selectCostDelayPageTable(pageTable));
		return ar;
	}
	
	
	/**
	 * 查询退费列表
	 */
	@RequestMapping(value="/selectCostReturnPageTable")
	@ResponseBody
	public AjaxRes selectCostReturnPageTable(@RequestBody PageTable<Pro_costReturn> pageTable){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costReturnService.selectCostReturnPageTable(pageTable));
		return ar;
	}
	
	/**
	 * 查询实收费用列表
	 */
	@RequestMapping(value="/selectCostFactPageTable")
	@ResponseBody
	public AjaxRes selectCostFactPageTable(@RequestBody PageTable<Pro_costFact> pageTable){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costFactService.selectCostFactPageTable(pageTable));
		return ar;
	}
	

	/**
	 * 显示页面:编辑一条应收费用信息
	 */
	@RequestMapping(value="/showCostMustEditPage")
	public ModelAndView showCostMustEditPage(Pro_costMust costMust){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/costMustEdit");
		ModelMap modelMap = mv.getModelMap();
		Pro_costMust result = costMustService.selectOneCostMust(costMust);
		modelMap.put("costMust", result);
//		List<Pro_meetingCost> meetingCostList = meetingCostService.selectMeetingCostList(" and applyID = '"+costMust.getApply_ID()+"'");
//		modelMap.put("meetingCostList", meetingCostList);
		return mv;
	}
	
	/**
	 * 更新一条应收费用信息
	 */
	@RequestMapping(value="/updateOneCostMust")
	@ResponseBody
	public AjaxRes updateOneCostMust(@RequestBody Pro_costMust costMust){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costMustService.updateOneCostMust(SystemSession.getUserSession(), costMust));
		return ar;
	}
	
	/**
	 * 显示页面:删除一条应收费用信息
	 */
	@RequestMapping(value="/showCostMustDelPage")
	public ModelAndView showCostMustDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/costMustDel");
		return mv;
	}
	
	
	/**
	 * 显示应收转缓收页面
	 */
	@RequestMapping(value="/showCostMustToDelayPage")
	public ModelAndView showCostMustToDelayPage(Pro_costMust costMust){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/cost/costMustToDelay");
		ModelMap modelMap = mv.getModelMap();
		Pro_costMust result = costMustService.selectOneCostMust(costMust);
		modelMap.put("costMust", result);
		return mv;
	}
	
	/**
	 * 应收转缓收 操作
	 */
	@RequestMapping(value="/costMustToDelay")
	@ResponseBody
	public AjaxRes costMustToDelay(@RequestBody Pro_costDelay costDelay){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costDelayService.insertOneCostDelay(SystemSession.getUserSession(), costDelay));
		return ar;
	}
	
	/**
	 * 显示应收转预收页面
	 */
	@RequestMapping(value="/showCostMustToPrePage")
	public ModelAndView showCostMustToPrePage(Pro_costMust costMust){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/cost/costMustToPre");
		ModelMap modelMap = mv.getModelMap();
		Pro_costMust result = costMustService.selectOneCostMust(costMust);
		modelMap.put("costMust", result);
		return mv;
	}
	
	/**
	 * 应收转预收 操作
	 */
	@RequestMapping(value="/costMustToPre")
	@ResponseBody
	public AjaxRes costMustToPre(@RequestBody Pro_costPre costPre){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costPreService.insertOneCostPre(SystemSession.getUserSession(), costPre));
		return ar;
	}
	
	/**
	 * 显示缓收转预收页面
	 */
	@RequestMapping(value="/showCostDelayToPrePage")
	public ModelAndView showCostDelayToPrePage(Pro_costDelay costDelay){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/cost/costDelayToPre");
		ModelMap modelMap = mv.getModelMap();
		Pro_costDelay result = costDelayService.selectOneCostDelay(costDelay);
		modelMap.put("costDelay", result);
		return mv;
	}
	
	/**
	 * 缓收转预收 操作
	 */
	@RequestMapping(value="/costDelayToPre")
	@ResponseBody
	public AjaxRes costDelayToPre(@RequestBody Pro_costPre costPre){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costPreService.insertOneCostPre(SystemSession.getUserSession(), costPre));
		return ar;
	}
	
	
	/**
	 * 预收转实收 操作
	 */
	@RequestMapping(value="/costPreToFact")
	@ResponseBody
	public AjaxRes costPreToFact(@RequestBody Pro_costFact costFact){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costFactService.insertOneCostFact(SystemSession.getUserSession(), costFact));
		return ar;
	}

	
	/**
	 * 预收转实收 操作
	 */
	@RequestMapping(value="/costPreToReturn")
	@ResponseBody
	public AjaxRes costPreToReturn(@RequestBody Pro_costReturn costReturn){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(costReturnService.insertOneCostReturn(SystemSession.getUserSession(), costReturn));
		return ar;
	}
}

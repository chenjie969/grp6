package com.zjm.pro.costMust.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.UrlParam;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_planPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.planPay.service.PlanPayService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
 * 事项中收费登记 -应收费用action
 */
@Controller
@RequestMapping(value="/project/costMust")
public class CostMustAction {
	@Resource
	private CostMustService costMustService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private LoanService loanService;
	@Resource
	private PlanPayService planPayService;
	@Resource
	private DicTypeService dicTypeService;
	
	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_costMust> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		//根据计划放款id(loanPlan_ID)
		if(pageTable.getQueryCondition().getLoanPlan_ID() != null && !"".equals(pageTable.getQueryCondition().getLoanPlan_ID())){
			wheresql.append(" and loanPlan_ID = \'"+pageTable.getQueryCondition().getLoanPlan_ID()+"\'");
		}
		
		return wheresql.toString();		
	}
	
	
	
	
	/**
	 * 查询应收费用页面分页列表
	 * @param PageTable<Pro_costMust> pageTable
	 */
	@RequestMapping(value="/selectCostMustPageTable")
	@ResponseBody
	public AjaxRes selectCostMustPageTable(@RequestBody PageTable<Pro_costMust> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = costMustService.selectCostMustPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * confirmationCostMust
	 * 应收费用-确认已到账
	 * @param  
	 * @return
	 */
	@RequestMapping(value="/costMustToPre", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes costMustToPre(@RequestBody Pro_costMust  pro_costMust){
		Boolean b= costMustService.costMustToPre(SystemSession.getUserSession(),pro_costMust);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示担保收费事项页面  2017/10/23 修改后停用
	 */
	@RequestMapping(value="/showCostMustPage")
	public ModelAndView showCostMustPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		List<Pro_meetingDetail> meetingDetailList = new ArrayList<>();
		meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and apply_ID ='"+urlParam.getEntityID()+"'");
		// 查询评审会详情下的放款计划
		for (Pro_meetingDetail meetingDetail : meetingDetailList) {
			List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"'");
			meetingDetail.setLoanPlanList(loanPlanList);
			
			for (Pro_loanPlan loanPlan : loanPlanList) {
				// 查询放款计划下的还款计划
				List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");	
				loanPlan.setPlanPayList(planPayList);
				// 查询放款计划下的应收费用
				List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
				loanPlan.setCostMustList(costMustList);
			}
		}
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("meetingDetailList",meetingDetailList);
		modelMap.put("urlParam",urlParam);
		mv.setViewName("/project/costMust/costMust");
		return mv;
	}
	
	/**
	 * 显示应收费用新增页面
	 */
	@RequestMapping(value="/showCostMustAddPage")
	public ModelAndView showCostMustAddPage(Pro_costMust costMust){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/costMust/costMustAdd");
		mv.getModelMap().put("costMust", costMust);
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		mv.getModelMap().put("costTypeList", costTypeList);
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID='"+costMust.getMeetingDetail_ID()+"'");
		mv.getModelMap().put("meetingDetail", meetingDetail);
		Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(" and loanPlan_ID='"+costMust.getLoanPlan_ID()+"'");
		mv.getModelMap().put("loanPlan", loanPlan);
		return mv;
	}
	
	/**
	 * 显示应收费用修改页面
	 */
	@RequestMapping(value="/showCostMustEditPage")
	public ModelAndView showCostMustEditPage(Pro_costMust costMust){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/costMust/costMustEdit");
		
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		mv.getModelMap().put("costTypeList", costTypeList);
		
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID='"+costMust.getMeetingDetail_ID()+"'");
		mv.getModelMap().put("meetingDetail", meetingDetail);
		
		costMust = costMustService.selectOneCostMustByWhereSql(" and costMust_ID='"+costMust.getCostMust_ID()+"'");
		mv.getModelMap().put("costMust", costMust);
		
		Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(" and loanPlan_ID='"+costMust.getLoanPlan_ID()+"'");
		mv.getModelMap().put("loanPlan", loanPlan);
		return mv;
	}
	
	/**
	 * 执行应收费用新增操作
	 */
	@RequestMapping(value="/insertOneCostMust")
	@ResponseBody
	public AjaxRes insertOneCostMust(@RequestBody Pro_costMust costMust){
		AjaxRes ar = new AjaxRes();
		Boolean b = costMustService.insertOneCostMust(SystemSession.getUserSession(), costMust);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 执行应收费用修改操作
	 */
	@RequestMapping(value="/updateOneCostMust")
	@ResponseBody
	public AjaxRes updateOneCostMust(@RequestBody Pro_costMust costMust){
		AjaxRes ar = new AjaxRes();
		Boolean b = costMustService.updateOneCostMust(SystemSession.getUserSession(), costMust);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 执行应收费用删除操作
	 */
	@RequestMapping(value="/deleteOneCostMust")
	@ResponseBody
	public AjaxRes deleteOneCostMust(@RequestBody Pro_costMust costMust){
		AjaxRes ar = new AjaxRes();
		Boolean b = costMustService.deleteOneCostMust(SystemSession.getUserSession(), costMust);
		ar.setSucceed(b);
		return ar;
	}
	/*******************************************************************************************/
	/**********************************以下是放款复核确认收费****************************************/
	/*******************************************************************************************/
	/**
     * @param meetingDetail_ID
     * @return 添加应收 ———— 展示页面
     */
    @RequestMapping(value="/showAddCostMustPage")
	public ModelAndView showAddCostMustPage(String  meetingDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("meetingDetail",meetingDetail);
		
		mv.setViewName("/project/loan/singleLoanReview/costMustAdd");
		return mv;
	}
    /**
     * @param costMust_ID
     * @return 修改应收 ———— 展示页面
     */
    @RequestMapping(value="/showUpdateCostMustPage")
	public ModelAndView showUpdateCostMustPage(String  costMust_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		Pro_costMust costMust = costMustService.selectOneCostMustByWhereSql(" and costMust_ID='"+costMust_ID+"' ");
		
		String condition = " and meetingDetail_ID='"+costMust.getMeetingDetail_ID()+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		mv.getModel().put("meetingDetail",meetingDetail);
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("costMust",costMust);
		
		mv.setViewName("/project/loan/singleLoanReview/costMustUpdate");
		return mv;
	}
    /**
     * @return 删除应收 ———— 展示页面
     */
    @RequestMapping(value="/showDelCostMustPage")
    public ModelAndView showDelCostMustPage(){
    	ModelAndView mv=CustomDispatchServlet.getModeAndView();
    	mv.setViewName("/project/loan/singleLoanReview/costMustDel");
    	return mv;
    }
    /**
     * @return 应收转预收 ———— 展示页面
     */
    @RequestMapping(value="/showMustTransPre")
    public ModelAndView showMustTransPre(){
    	ModelAndView mv=CustomDispatchServlet.getModeAndView();
    	mv.setViewName("/project/loan/singleLoanReview/mustTransPre");
    	return mv;
    }
	
}

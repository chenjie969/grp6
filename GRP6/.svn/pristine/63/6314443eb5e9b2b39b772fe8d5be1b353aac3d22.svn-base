package com.zjm.pro.loanPlan.web;

import java.util.List;
import java.util.Map;

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
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_planPay;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.planPay.service.PlanPayService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/loanPlan")
public class LoanPlanAction {
	
	@Resource
	private ApplyDetailService proApplyDetailService;
	@Resource
	private LoanService loanService;
	@Resource
	private DicTypeService dicTypeService;
	
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private PlanPayService planPayService;
	@Resource
	private CostMustService costMustService;
	
	/**
	 * 显示放款计划与还款计划页面 
	 */
	@RequestMapping(value="/showLoanPlanPage")
	public ModelAndView showPlanLoanPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/NEWLoanPlan/planLoanAndPay");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("urlParam", urlParam);
		// 查询评审会审批通过详情
		List<Pro_meetingDetail> meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"'");
		// 查询评审会详情下的放款计划
		for (Pro_meetingDetail meetingDetail : meetingDetailList) {
			List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"'");
			meetingDetail.setLoanPlanList(loanPlanList);
			for (Pro_loanPlan loanPlan : loanPlanList) {
				// 查询放款计划下的还款计划
//				List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"' order by planPayDate ASC");	//按计划还款日期排序
				List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");	//按放款后第n个月排序, 写在了.xml中
				loanPlan.setPlanPayList(planPayList);
				// 查询放款计划下的应收费用
				List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
				loanPlan.setCostMustList(costMustList);
			}
		}
		mv.getModelMap().put("meetingDetailList",meetingDetailList);
		return mv;
	}
	
	/**
	 * APP-放款计划、还款计划与应收费用数据
	 */
	@RequestMapping(value="/selectLoanPlanApp")
	@ResponseBody
	public AjaxRes selectLoanPlanApp(@RequestBody  UrlParam urlParam){
		AjaxRes ar = new AjaxRes();
		// 查询评审会审批通过详情
		List<Pro_meetingDetail> meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"'");
		// 查询评审会详情下的放款计划
		for (Pro_meetingDetail meetingDetail : meetingDetailList) {
			List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"'");
			meetingDetail.setLoanPlanList(loanPlanList);
			for (Pro_loanPlan loanPlan : loanPlanList) {
				// 查询放款计划下的还款计划
//				List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"' order by planPayDate ASC");	//按计划还款日期排序
				List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");	//按放款后第n个月排序, 写在了.xml中
				loanPlan.setPlanPayList(planPayList);
				// 查询放款计划下的应收费用
				List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(" and loanPlan_ID = \'"+loanPlan.getLoanPlan_ID()+"\'");
				loanPlan.setCostMustList(costMustList);
			}
		}
		ar.setSucceed(meetingDetailList);
		return ar;
	}
	
	
	/**
	 * 显示计划放款添加页面
	 */
	@RequestMapping(value="/showLoanPlanAddPage")
	public ModelAndView showLoanPlanAddPage(Pro_meetingDetail meetingDetail){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/NEWLoanPlan/planLoanAdd");
		meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"'");
		mv.getModelMap().put("meetingDetail", meetingDetail);
		return mv;
	}
	
	/**
	 * 新增一条放款计划
	 */
	@RequestMapping(value="/insertOnePlanLoan")
	@ResponseBody
	public AjaxRes insertOnePlanLoan(@RequestBody Pro_loanPlan loanPlan){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.insertOnePlanLoan(SystemSession.getUserSession(),loanPlan);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 判断计划放款总金额是否超过了评审会同意金额 
	 */
	@RequestMapping(value="/isMoreThanAgreeSum")
	@ResponseBody
	public AjaxRes isMoreThanAgreeSum(@RequestBody Pro_loanPlan loanPlan){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.isMoreThanAgreeSum(loanPlan);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示计划放款修改页面
	 */
	@RequestMapping(value="/showLoanPlanEditPage")
	public ModelAndView showLoanPlanEditPage(Pro_loanPlan loanPlan){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/NEWLoanPlan/planLoanEdit");
		loanPlan = loanService.selectOneLoanPlan(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("loanPlan", loanPlan);
		return mv;
	}
	
	/**
	 * 修改一条放款计划
	 */
	@RequestMapping(value="/updateOnePlanLoan")
	@ResponseBody
	public AjaxRes updateOnePlanLoan(@RequestBody Pro_loanPlan loanPlan){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.updateOnePlanLoan(SystemSession.getUserSession(),loanPlan);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 删除一条放款计划
	 */
	@RequestMapping(value="/deleteOnePlanLoan")
	@ResponseBody
	public AjaxRes deleteOnePlanLoan(@RequestBody Pro_loanPlan loanPlan){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.deleteOnePlanLoan(SystemSession.getUserSession(),loanPlan.getLoanPlan_ID());
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示计划还款添加页面
	 */
	@RequestMapping(value="/showPlanPayAddPage")
	public ModelAndView showPlanPayAddPage(Pro_planPay planPay){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/NEWLoanPlan/planPayAdd");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("planPay", planPay);
		return mv;
	}
	
	/**
	 * 新增一条还款计划
	 */
	@RequestMapping(value="/insertOnePlanPay")
	@ResponseBody
	public AjaxRes insertOnePlanPay(@RequestBody Pro_planPay planPay){
		AjaxRes ar = new AjaxRes();
		Boolean b = planPayService.insertOnePlanPay(SystemSession.getUserSession(),planPay);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 判断计划还款总金额是否超过了该笔计划放款的金额 
	 */
	@RequestMapping(value="/isMoreThanPlanLoanSum")
	@ResponseBody
	public AjaxRes isMoreThanPlanLoanSum(@RequestBody Pro_planPay planPay){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.isMoreThanPlanLoanSum(planPay);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 判断计划还款的月份不能超过计划放款期限
	 */
	@RequestMapping(value="/isMoreThanPlanLoanPeriodMonth")
	@ResponseBody
	public AjaxRes isMoreThanPlanLoanPeriodMonth(@RequestBody Pro_planPay planPay){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.isMoreThanPlanLoanPeriodMonth(planPay);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 自动生成还款计划时校验, 判断计划还款总金额是否超过了该笔计划放款的金额 
	 */
	@RequestMapping(value="/autoAddValidata")
	@ResponseBody
	public AjaxRes autoAddIsMoreThanPlanLoanSum(@RequestBody Pro_planPay planPay){
		AjaxRes ar = new AjaxRes();
		Map<String, Object> map = loanService.autoAddValidata(SystemSession.getUserSession(), planPay);
		ar.setSucceed(map);
		return ar;
	}
	
	/**
	 * 显示计划还款修改页面
	 */
	@RequestMapping(value="/showPlanPayEditPage")
	public ModelAndView showPlanPayEditPage(Pro_planPay planPay){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/NEWLoanPlan/planPayEdit");
		ModelMap modelMap = mv.getModelMap();
		planPay = planPayService.selectOnePlanPay(" and planPay_ID='"+planPay.getPlanPay_ID()+"'");
		modelMap.put("planPay", planPay);
		return mv;
	}
	
	/**
	 * 修改一条还款计划
	 */
	@RequestMapping(value="/updateOnePlanPay")
	@ResponseBody
	public AjaxRes updateOnePlanPay(@RequestBody Pro_planPay planPay){
		AjaxRes ar = new AjaxRes();
		Boolean b = planPayService.updateOnePlanPay(SystemSession.getUserSession(),planPay);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 删除一条还款计划
	 */
	@RequestMapping(value="/deleteOnePlanPay")
	@ResponseBody
	public AjaxRes deleteOnePlanPay(@RequestBody Pro_planPay planPay){
		AjaxRes ar = new AjaxRes();
		Boolean b = planPayService.deleteOnePlanPay(SystemSession.getUserSession(),planPay);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示自动生成还款计划页面
	 */
	@RequestMapping(value="/showAutoAddConfirmPage")
	public ModelAndView showAutoAddConfirmPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/NEWLoanPlan/autoAddConfirm");
		return mv;
	}
	
	/**
	 * 显示自动生成还款计划页面
	 */
	@RequestMapping(value="/showAutoAddPlanPayPage")
	public ModelAndView showAutoAddPlanPayPage(Pro_planPay planPay){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/NEWLoanPlan/planPayAutoAdd");
		mv.getModelMap().put("planPay", planPay);
		return mv;
	}
	
/* ******************************下面的不用了*****************************************************************************/
	/**
	 * 查询放款计划列表
	 */
	@RequestMapping(value="/selectPlanLoanPageTable")
	@ResponseBody
	public AjaxRes selectPlanLoanPageTable(@RequestBody PageTable<Pro_loanPlan> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable = loanService.selectPlanLoanPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 显示计划放款删除页面
	 */
	@RequestMapping(value="/showLoanPlanDelPage")
	public ModelAndView showLoanPlanDelPage(Pro_loanPlan loanPlan){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/planLoanDel");
		return mv;
	}
	
	/**
	 * 显示放款复核总页面 
	 */
	@RequestMapping(value="/showReviewLoanPage")
	public ModelAndView showReviewLoanPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/reviewLoan/reviewLoan");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("apply_ID", urlParam.getEntityID());
		modelMap.put("openType", urlParam.getType());
		return mv;
	}
	
	/**
	 * 显示放款复核新增页面 
	 */
	@RequestMapping(value="/showConfirmLoanPage")
	public ModelAndView showConfirmLoanPage(Pro_loanPlan loanPlan){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		loanPlan = loanService.selectOneLoanPlan(" and loanPlan_ID='"+loanPlan.getLoanPlan_ID()+"'");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("loanPlan", loanPlan);
		if("01".equals(loanPlan.getBusiClass())){	//融资担保业务
			List<C_dictype> creditorTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID = 'f00382a3b40346af8bdd9404f3ee3a38'");
			modelMap.put("creditorTypeList", creditorTypeList);
			mv.setViewName("/project/loan/reviewLoan/confrimLoanForFinancing");
		}else if("02".equals(loanPlan.getBusiClass())){	//委托贷款业务
			mv.setViewName("/project/loan/reviewLoan/confrimLoanForEntrust");
		}
		return mv;
	}
	
}

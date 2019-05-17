package com.zjm.pro.loan.web;

import java.util.ArrayList;
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
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_meetingResolution;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value="/project/loan")
public class LoanAction {
	
	@Resource
	private ApplyDetailService proApplyDetailService;
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private LoanService loanService;
	@Resource
	private DicTypeService dicTypeService;
	
	@Resource
	private MeetingResolutionService meetingResolutionService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private ProjectService projectService;
	/**
	 * 显示计划放款页面 
	 */
	@RequestMapping(value="/showPlanLoanPage")
	public ModelAndView showPlanLoanPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/planLoan");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("apply_ID", urlParam.getEntityID());
		modelMap.put("openType", urlParam.getType());
		return mv;
	}
	
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
	 * 显示计划放款添加页面
	 */
	@RequestMapping(value="/showLoanPlanAddPage")
	public ModelAndView showLoanPlanAddPage(String applyID){
		List<Pro_applyDetail> applyDetailList = proApplyDetailService.selectApplyDetailList(" and apply_ID='"+applyID+"'");
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/planLoanAdd");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("applyID", applyID);
		modelMap.put("applyDetailList", applyDetailList);
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
	 * 显示计划放款修改页面
	 */
	@RequestMapping(value="/showLoanPlanEditPage")
	public ModelAndView showLoanPlanEditPage(Pro_loanPlan loanPlan){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/planLoanEdit");
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
	 * 显示计划放款删除页面
	 */
	@RequestMapping(value="/showLoanPlanDelPage")
	public ModelAndView showLoanPlanDelPage(Pro_loanPlan loanPlan){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/planLoanDel");
		return mv;
	}
	
	/**
	 * 删除一条放款计划
	 */
	@RequestMapping(value="/deleteOnePlanLoan")
	@ResponseBody
	public AjaxRes deleteOnePlanLoan(@RequestBody Pro_loanPlan loanPlan){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.deleteOnePlanLoan(SystemSession.getUserSession()," and ");
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
	 * 显示计划还款添加页面
	 */
	@RequestMapping(value="/showRepayPlanAddPage")
	public ModelAndView showRepayPlanAddPage(String applyID){
		List<Pro_applyDetail> applyDetailList = proApplyDetailService.selectApplyDetailList(" and apply_ID='"+applyID+"'");
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/planLoan/planLoanAdd");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("applyID", applyID);
		modelMap.put("applyDetailList", applyDetailList);
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
	/************************放款复核*****************************/
	/**
     * 根据ID获取该会议关联的附件
     * @param entityID
     * @return 查询附件
     */
    @ResponseBody
    @RequestMapping(value = "/getAttachments")
    public AjaxRes getAttachments(String entityID , String type) {
        Pro_projectfiles files = new Pro_projectfiles();
        List<Pro_projectfiles> listFiles = new ArrayList<Pro_projectfiles>();
        listFiles = loanService.getAttachmentsByType(entityID,type);
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(listFiles);
        return ar;
    }
    /**
     * 根据文件ID删除该文件
     *
     * @param files_ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAttachment")
    public AjaxRes deleteAttachment(String projectFiles_ID) {
        AjaxRes ar = new AjaxRes();
        ar.setSucceed(loanService.deleteAttachment(projectFiles_ID));
        return ar;
    }
    
    /**
     * @param urlParam
     * @return 查询放款复核信息
     */
    @RequestMapping(value="/selectLoanReviewList")
	public ModelAndView selectLoanReviewList(UrlParam urlParam){
    	List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try{
			String apply_ID = null;
			if (urlParam != null){
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'"+apply_ID+"\'"+ " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			if (meetingResolution != null) {
				
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"'");
				List<Pro_loanPlan> loanPlanList = new ArrayList<Pro_loanPlan>();
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String meetingDetail_ID = meetingDetail.getMeetingDetail_ID();
					loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+meetingDetail_ID+"'");
					List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
					for (Pro_loanPlan loanPlan : loanPlanList) {
						projectfilesList = loanService.getAttachments(loanPlan.getLoanPlan_ID());
						
						List<Pro_project> projectList = projectService.selectProjectListByWheresql(" and loanPlan_ID=\'"+loanPlan.getLoanPlan_ID()+"\'");
						Pro_project project = null;
						if(projectList!=null && projectList.size()>0){
							project = projectList.get(0);
						}
						loanPlan.setProject(project);
						loanPlan.setProjectfilesList(projectfilesList);
					}
					
					meetingDetail.setLoanPlanList(loanPlanList);
				}
				
			}
			
			mv.getModelMap().put("urlParam",urlParam);
			mv.getModelMap().put("meetingDetailList",meetingDetailList);
			mv.setViewName("/project/loan/reviewLoan/loanReview");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    
	/**
	 * 已确认放款——显示页面
	 */
	@RequestMapping(value="/showLoanConfirmAddPage")
	public ModelAndView showLoanConfirmAddPage(String loanPlan_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_loanPlan loanPlan = new Pro_loanPlan();
		loanPlan.setLoanPlan_ID(loanPlan_ID);
		loanPlan = loanService.selectOneLoanPlan(" and loanPlan_ID=\'"+loanPlan.getLoanPlan_ID()+"\'");
		mv.getModelMap().put("loanPlan", loanPlan);
		mv.setViewName("/project/loan/reviewLoan/loanConfirmAdd");
		return mv;
	}
	
	/**
	 * @param loanPlan
	 * @return 确认放款
	 */
	@ResponseBody
    @RequestMapping(value = "/updateLoanConfirm")
    public AjaxRes updateLoanConfirm(@RequestBody Pro_loanPlan loanPlan) {
		
        AjaxRes ar = new AjaxRes();
        
        ar.setSucceed(loanService.updateLoanConfirm(SystemSession.getUserSession(),loanPlan));
        return ar;
    }
	/**
	 * 放款撤销——显示页面
	 */
	@RequestMapping(value="/showLoanConfirmCancelPage")
	public ModelAndView showLoanConfirmCancelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/reviewLoan/loanConfirmCancel");
		return mv;
	}
	/**
	 * @param loanPlan
	 * @return 确认放款---撤销
	 */
	@ResponseBody
    @RequestMapping(value = "/loanConfirmCancel")
    public AjaxRes loanConfirmCancel(@RequestBody Pro_loanPlan loanPlan) {
		
        AjaxRes ar = new AjaxRes();
        
        ar.setSucceed(loanService.loanConfirmCancel(SystemSession.getUserSession(),loanPlan));
        return ar;
    }
	
	/****************************************************************************************************/
	/*********************************以下是放款子流程（文旦）*************************************/
	/****************************************************************************************************/
    
    /**
     * @param urlParam
     * @return 查询放款申请信息
     */
    @RequestMapping(value="/selectLoanApply")
	public ModelAndView selectLoanApply(UrlParam urlParam){
    	List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try{
			String apply_ID = null;
			if (urlParam != null){
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'"+apply_ID+"\'"+ " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			if (meetingResolution != null) {
				
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"'");
				List<Pro_loanPlan> loanPlanList = new ArrayList<Pro_loanPlan>();
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String meetingDetail_ID = meetingDetail.getMeetingDetail_ID();
					loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+meetingDetail_ID+"'");
					List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
					for (Pro_loanPlan loanPlan : loanPlanList) {
						projectfilesList = loanService.getAttachments(loanPlan.getLoanPlan_ID());
						
						//Pro_project project = projectService.selectOneProjectInfoByWheresql(" and loanPlan_ID=\'"+loanPlan.getLoanPlan_ID()+"\'");
						//loanPlan.setProject(project);
						loanPlan.setProjectfilesList(projectfilesList);
					}
					meetingDetail.setLoanPlanList(loanPlanList);
				}
			}
			mv.getModelMap().put("meetingDetailList",meetingDetailList);
			mv.getModelMap().put("urlParam",urlParam);
			mv.setViewName("/project/WHDB/loanApply/loanApply");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    
    /**
     * @return 放款审批子流程 ———— 展示页面  WHDB
     */
    @RequestMapping(value="/showLoanApprovalPage")
	public ModelAndView showLoanApprovalPage(String meetingDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//查询放款计划信息
		List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(condition);
		Double agreeSum = meetingDetail.getAgreeSum() == null ? 0D : meetingDetail.getAgreeSum();//同意放款金额
		Double haveLoanSum = 0D;//已经放款金额
		Double notLoanSum = 0D;//未放款金额
		for (Pro_loanPlan loanPlan : loanPlanList) {
			Double loanSum = loanPlan.getLoanSum() == null ? 0D : loanPlan.getLoanSum();//放款金额
			haveLoanSum += loanSum;
		}
		notLoanSum = agreeSum-haveLoanSum;
		
		//查询业务/授信申请信息表
		String apply_ID = meetingDetail.getApply_ID();
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
		
		mv.getModel().put("loanPlan_ID",Tool.createUUID32());
		mv.getModel().put("haveLoanSum",haveLoanSum);
		mv.getModel().put("notLoanSum",notLoanSum);
		mv.getModelMap().put("meetingDetail", meetingDetail);
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/project/WHDB/loanApply/loanApproval");
		return mv;
	}
    /**
	 * 新增一条放款计划 WHDB
	 */
	@RequestMapping(value="/insertOneLoanPlan")
	@ResponseBody
	public AjaxRes insertOneLoanPlan(@RequestBody Pro_loanPlan loanPlan){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.insertOneLoanPlan(SystemSession.getUserSession(),loanPlan);
		ar.setSucceed(b);
		return ar;
	}
    
    /**
     * @param loanPlan_ID
     * @return 查看一条放款计划记录 ———— 展示页面  WHDB
     */
    @RequestMapping(value="/showLoanApplyViewPage")
	public ModelAndView showLoanApplyViewPage(String loanPlan_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and loanPlan_ID='"+loanPlan_ID+"' ";
		try {
			Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(condition);
			
			List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
			projectfilesList = loanService.getAttachments(loanPlan.getLoanPlan_ID());
			loanPlan.setProjectfilesList(projectfilesList);
			
			mv.getModelMap().put("loanPlan", loanPlan);
			mv.setViewName("/project/WHDB/loanApply/loanApplyView");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    
    /**
     * @param businessId
     * @return 查看一条放款计划记录，流程查看事项
     */
    @RequestMapping(value="/showLoanApplyViewPage_onFlow")
	public ModelAndView showLoanApplyViewPage_onFlow(String businessId){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and loanPlan_ID='"+businessId+"' ";
		try {
			Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(condition);
			
			List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
			projectfilesList = loanService.getAttachments(loanPlan.getLoanPlan_ID());
			loanPlan.setProjectfilesList(projectfilesList);
			
			String apply_ID = loanPlan.getApplyID();
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
			condition = " and meetingDetail_ID='"+loanPlan.getMeetingDetail_ID()+"' ";
			//评审会产品明细表
			Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
			
			mv.getModelMap().put("loanPlan", loanPlan);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("meetingDetail", meetingDetail);
			mv.setViewName("/project/WHDB/loanApply/loanApplyView_Flow");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    /**
     * @param loanPlan_ID
     * @return 撤销一条放款计划记录 ———— 展示页面  WHDB
     */
    @RequestMapping(value="/showDelLoanPlanPage")
    public ModelAndView showDelLoanPlanPage(){
    	ModelAndView mv=CustomDispatchServlet.getModeAndView();
    	mv.setViewName("/project/WHDB/loanApply/loanPlanDel");
    	return mv;
    }
    /**
	 * 删除一条放款计划
	 */
	@RequestMapping(value="/delOneLoanPlan")
	@ResponseBody
	public AjaxRes delOneLoanPlan(@RequestBody Pro_loanPlan loanPlan){
		AjaxRes ar = new AjaxRes();
		Boolean b = loanService.delOneLoanPlan(SystemSession.getUserSession(),loanPlan);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
     * @param loanPlan_ID
     * @return 审批链接 ———— 展示页面  WHDB
     */
    @RequestMapping(value="/showLoanApprovalLink")
	public ModelAndView showLoanApprovalLink(String loanPlan_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and loanPlan_ID='"+loanPlan_ID+"' ";
		try {
			Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(condition);
			
			
			Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID='"+loanPlan.getMeetingDetail_ID()+"' ");
			//查询放款计划信息
			List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(" and meetingDetail_ID='"+loanPlan.getMeetingDetail_ID()+"' ");
			Double agreeSum = meetingDetail.getAgreeSum() == null ? 0D : meetingDetail.getAgreeSum();//同意放款金额
			Double haveLoanSum = 0D;//已经放款金额
			Double notLoanSum = 0D;//未放款金额
			for (Pro_loanPlan loanPlan1 : loanPlanList) {
				Double loanSum = loanPlan1.getLoanSum() == null ? 0D : loanPlan1.getLoanSum();//放款金额
				haveLoanSum += loanSum;
			}
			notLoanSum = agreeSum-haveLoanSum;
			
			//查询业务/授信申请信息表
			String apply_ID = meetingDetail.getApply_ID();
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
			List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
			projectfilesList = loanService.getAttachments(loanPlan.getLoanPlan_ID());
			
			loanPlan.setProjectfilesList(projectfilesList);
			
			mv.getModel().put("haveLoanSum",haveLoanSum);
			mv.getModel().put("notLoanSum",notLoanSum);
			mv.getModelMap().put("meetingDetail", meetingDetail);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("loanPlan", loanPlan);
			mv.setViewName("/project/WHDB/loanApply/approvalLink");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    /**
     * @param urlParam
     * @return 查询放款复核信息（文旦）WHDB
     */
    @RequestMapping(value="/selectLoanReview")
	public ModelAndView selectLoanReview(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try{
			String apply_ID = null;
			if (urlParam != null){
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = " and approvalState='审批通过' and applyID = \'"+apply_ID+"\'"+ " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			//String whereSql = " and applyID = \'"+apply_ID+"\'"+ " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
				
			List<Pro_loanPlan> loanPlanList = loanService.selectLoanReviewList(whereSql);
			//Map<String,Object>
			List<Pro_project> projectList = new ArrayList<Pro_project>();
			if(loanPlanList != null){
				for (Pro_loanPlan loanPlan : loanPlanList) {
					List<Pro_project> projectList1 = projectService.selectProjectListByWheresql(" and loanPlan_ID=\'"+loanPlan.getLoanPlan_ID()+"\'");
					for (Pro_project project : projectList1) {
						List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
						projectfilesList = loanService.getAttachments(project.getProject_ID());
						project.setProjectfilesList(projectfilesList);
						project.setLoanPlanSum(loanPlan.getLoanSum());
					}
					projectList.addAll(projectList1);
					
				}
			}
			
			mv.getModelMap().put("loanPlanList",loanPlanList);
			mv.getModelMap().put("projectList",projectList);
			mv.getModelMap().put("urlParam",urlParam);
			mv.setViewName("/project/WHDB/loanReview/loanReview");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    
    /**
	 * 查看计划放款页面  （文旦）WHDB
	 */
	@RequestMapping(value="/showLoanPlanViewPage")
	public ModelAndView showLoanPlanViewPage(String loanPlan_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(" and loanPlan_ID='"+loanPlan_ID+"'");
		
		List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
		projectfilesList = loanService.getAttachments(loanPlan_ID);
		loanPlan.setProjectfilesList(projectfilesList);
		
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("loanPlan", loanPlan);
		mv.setViewName("/project/WHDB/loanReview/loanPlanView");
		return mv;
	}
	/**
	 * @param loanPlan_ID
	 * @return 放款复核 ——显示页面
	 */
	@RequestMapping(value="/showLoanPlanCheckPage")
	public ModelAndView showLoanPlanCheckPage(String loanPlan_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		//查询放款计划
		Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(" and loanPlan_ID=\'"+loanPlan_ID+"\'");
		//查询业务/授信申请信息表
		String apply_ID = loanPlan.getApplyID();
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
		String condition = " and meetingDetail_ID='"+loanPlan.getMeetingDetail_ID()+"' ";
		//评审会产品明细表
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//项目总金额
		Double agreeSum = meetingDetail.getAgreeSum()==null ? 0 : meetingDetail.getAgreeSum();
		//放款通知书总金额
		Double loanSum = loanPlan.getLoanSum()==null ? 0 : loanPlan.getLoanSum();
		
		Double haveLoanSum = 0D;//银行已放款额度
		Double notLoanSum = 0D;//银行未放款额度
		List<Pro_project> projectList = projectService.selectProjectListByWheresql(" and loanPlan_ID=\'"+loanPlan_ID+"\'");
		for (Pro_project project : projectList) {
			Double loadSum = project.getLoadSum() ==null ? 0D : project.getLoadSum();
			haveLoanSum += loadSum;
		}
		notLoanSum = loanSum-haveLoanSum;
		
		mv.getModelMap().put("loanPlan", loanPlan);
		mv.getModelMap().put("meetingDetail", meetingDetail);
		mv.getModelMap().put("apply", apply);
		mv.getModelMap().put("agreeSum", agreeSum);//项目总金额
		mv.getModelMap().put("loanSum", loanSum);//放款通知书总金额
		mv.getModelMap().put("haveLoanSum", haveLoanSum);//银行已放款额度
		mv.getModelMap().put("notLoanSum", notLoanSum);//银行未放款额度
		mv.getModelMap().put("project_ID", Tool.createUUID32());
		mv.setViewName("/project/WHDB/loanReview/loanPlanCheck");
		return mv;
	}
	/**
	 * @param loanPlan
	 * @return 放款复核
	 */
	@ResponseBody
    @RequestMapping(value = "/updateLoanCheck")
    public AjaxRes updateLoanCheck(@RequestBody Pro_project project) {
		Boolean b = false;
        AjaxRes ar = new AjaxRes();
        try {
        	b = loanService.updateLoanCheck(SystemSession.getUserSession(),project);
		} catch (Exception e) {
			e.printStackTrace();
		}
        ar.setSucceed(b);
        return ar;
    }
}

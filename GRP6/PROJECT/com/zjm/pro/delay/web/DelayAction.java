package com.zjm.pro.delay.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.UrlParam;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.gworkFlow.db.map.OsGworkflowInstanceMapper;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.db.model.OsGworkflowProjsuggest;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowProjsuggestService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_meetingResolution;
import com.zjm.pro.db.model.Pro_optGuaranty;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.db.model.pro_manageRreviewModeExcel;
import com.zjm.pro.db.model.pro_meetingExportModeExcel;
import com.zjm.pro.db.model.pro_reviewCommitteeModeExcel;
import com.zjm.pro.delay.service.DelayService;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.pro.optGuaranty.service.OptGuarantyService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.sys.db.model.Sys_docMould;
import com.zjm.sys.docMould.service.DocMouldService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.DateUtil;
import com.zjm.util.PriceUtil;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
import com.zjm.util.excel.ExportExcel2;
import com.zjm.xdocreport.util.ContractUtil;

@Controller
@RequestMapping(value="/project/delay")
public class DelayAction {
	
	private Logger log = LoggerFactory.getLogger(DelayAction.class);
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private DelayService delayService;
	@Resource
	private ProjectService projectService;
	@Resource
	private MeetingResolutionService meetingResolutionService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private LoanService loanService;
	@Resource
	private OsGworkflowInstanceMapper osGworkflowInstanceMapper;
	@Resource
	private OsGworkflowProjsuggestService osGworkflowProjsuggestService;
	@Resource
	private ProjectfilesService  projectfilesService;
	@Resource
	private ClientService clientService;
	@Resource
	private DocMouldService docMouldService;
	@Resource
	private OptGuarantyService  optGuarantyService;
	@Resource
	private ApplyDetailService applyDetailService;
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_delay> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and delay.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		//根据申请ID(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			wheresql.append(" and delay.applyID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		return wheresql.toString();		
	}
	/**
	 * 跳转到展期登记页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnProjectDelayPage")
	public ModelAndView returnProjectDelayPage(String  project_ID,String apply_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_apply apply = new Pro_apply();
		Pro_project project  = new Pro_project();
	    if(null != apply_ID){
		   //根据apply_id获取项目摘要信息;
		   apply= projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+apply_ID+"\'");
		   //根据project_ID获取放款表信息
		   project= projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		   
	    }
		mv.getModel().put("project",project);
		mv.getModel().put("apply",apply);
		mv.setViewName("/project/factPay/projectDelay");
		mv.getModel().put("project_ID",project_ID);
		return mv;
	}
	
	/**
	 * insertOneFactPay
	 * 新增展期登记;
	 * 
	 */
	@RequestMapping(value="/insertOneDelay", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneDelay(@RequestBody Pro_delay pro_delay){
		Boolean b = true;	
		if(pro_delay  != null){		
			try {
				pro_delay.setDelay_ID(Tool.createUUID32());
				b=delayService.insertOneDelayInfo(SystemSession.getUserSession(),pro_delay);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 查询展期情况分页列表
	 * @param PageTable<Pro_delay> pageTable
	 * @author ZKY   project_ID
	 * @time :2017-8-24 
	 */  
	@RequestMapping(value="/selectDelayTable")
	@ResponseBody
	public AjaxRes selectDelayTable(@RequestBody PageTable<Pro_delay> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = delayService.selectDelayTables(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 跳转到展期登记修改页面
	 * @param project_ID
	 * returnProjectDelayEditPage
	 * @return
	 */
	@RequestMapping(value="/returnProjectDelayEditPage")
	public ModelAndView returnProjectDelayEditPage(Pro_delay  pro_delay){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_delay  delay = new Pro_delay();
		if(null != pro_delay){
			//根据delay_ID获取展期信息;
			delay = delayService.selectOneDelayByWhereSql(" and delay_ID= \'"+pro_delay.getDelay_ID()+"\'");
		}
		mv.getModel().put("delay",delay);
		mv.setViewName("/project/apply/projectDelayEdit");
		return mv;
	}
	/**
	 * updateOneDelay
	 * 修改展期登记;
	 * 
	 */
	@RequestMapping(value="/updateOneDelay", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneDelay(@RequestBody Pro_delay pro_delay){
		Boolean b = true;	
		if(pro_delay  != null){		
			try {
				b=delayService.updateOneDelay(SystemSession.getUserSession(),pro_delay);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 删除一个展期表信息
	 * @param Pro_delay delay
	 * @return
	 */
	@RequestMapping(value="/delOneDelay", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOneDelay(@RequestBody Pro_delay  delay){
		delay.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		String whereSql=" and delay_ID = '"+delay.getDelay_ID()+"'".trim();
		Boolean b= delayService.deleteDelayByWhereSql(SystemSession.getUserSession(),whereSql);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 删除一个展期表信息
	 * @param Pro_delay delay
	 * @return
	 */
	@RequestMapping(value="/delOneDelayRT", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOneDelayRT(@RequestBody Pro_delay  delay){
		delay.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		
		Boolean b= delayService.deleteOneDelay(SystemSession.getUserSession(),delay);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/****************************以下是项目展期********************************/
	
	/**
     * @param urlParam
     * @return 查询放款复核信息
     */
    @RequestMapping(value="/selectProDelayList")
	public ModelAndView selectLoanReviewList(UrlParam urlParam){
		List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try{
			String apply_ID = null;
			if (urlParam != null){
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'"+apply_ID+"\'" + " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			/*if (meetingResolution != null) {
				
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"'");
				List<Pro_loanPlan> loanPlanList = new ArrayList<Pro_loanPlan>();
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String meetingDetail_ID = meetingDetail.getMeetingDetail_ID();
					loanPlanList = loanService.selectLoanReviewList(" and loanState='已放款' and meetingDetail_ID='"+meetingDetail_ID+"'");
					List<Pro_projectfiles> projectfilesList1 = new ArrayList<Pro_projectfiles>();
					List<Pro_projectfiles> projectfilesList2 = new ArrayList<Pro_projectfiles>();
					for (Pro_loanPlan loanPlan : loanPlanList) {
						projectfilesList1 = loanService.getAttachments(loanPlan.getLoanPlan_ID());
						
						Pro_project project = projectService.selectOneProjectInfoByWheresql(" and loanPlan_ID=\'"+loanPlan.getLoanPlan_ID()+"\'");
						projectfilesList2 = loanService.getAttachments(project.getProject_ID());
						Pro_delay delay = delayService.selectOneDelayInfo(" and delay.project_ID='"+project.getProject_ID()+"'");
						
						project.setProjectfilesList(projectfilesList2);
						project.setDelay(delay);
						loanPlan.setProject(project);
						loanPlan.setProjectfilesList(projectfilesList1);
					}
					meetingDetail.setLoanPlanList(loanPlanList);
				}
			}*/
			if (meetingResolution != null) {
				
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"'");
				List<Pro_project> projectList = new ArrayList<Pro_project>();
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String meetingDetail_ID = meetingDetail.getMeetingDetail_ID();
					projectList = projectService.selectProjectListByWheresql(" and meetingDetail_ID='"+meetingDetail_ID+"'");
					List<Pro_projectfiles> projectfilesList = new ArrayList<Pro_projectfiles>();
					for (Pro_project project : projectList) {
						
						Pro_delay delay = delayService.selectOneDelayInfo(" and delay.project_ID='"+project.getProject_ID()+"'");
						if(null != delay){
							projectfilesList = loanService.getAttachments(delay.getDelay_ID());
						}
						
						project.setProjectfilesList(projectfilesList);
						project.setDelay(delay);
					}
					meetingDetail.setProjectList(projectList);
				}
				mv.getModelMap().put("urlParam",urlParam);
				mv.getModelMap().put("meetingDetailList",meetingDetailList);
				mv.setViewName("/project/loan/proDelay/proDelay");
			}else{
				List<Pro_delay> delayList = delayService.selectDelayListByWhereSql(" and applyID='"+apply_ID+"'");
				Pro_project project = projectService.selectOneProjectInfoByWheresql(" and apply_ID='"+apply_ID+"'");
				mv.getModelMap().put("delayList",delayList);
				mv.getModelMap().put("project",project);
				mv.setViewName("/project/loan/proDelay/proDelayTwo");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
     * @param urlParam
     * @return 查询放款复核信息
     * 查看展期列表APP
     */
    @RequestMapping(value="/selectProDelayListAPP")
    @ResponseBody
	public AjaxRes selectProDelayListAPP(@RequestBody UrlParam urlParam){
		List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
		AjaxRes ar = new AjaxRes();
		try{
			String apply_ID = null;
			if (urlParam != null){
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'"+apply_ID+"\'" + " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			if (meetingResolution != null) {
				
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"'");
				List<Pro_loanPlan> loanPlanList = new ArrayList<Pro_loanPlan>();
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String meetingDetail_ID = meetingDetail.getMeetingDetail_ID();
					loanPlanList = loanService.selectLoanReviewList(" and loanState='已放款' and meetingDetail_ID='"+meetingDetail_ID+"'");
					List<Pro_projectfiles> projectfilesList1 = new ArrayList<Pro_projectfiles>();
					List<Pro_projectfiles> projectfilesList2 = new ArrayList<Pro_projectfiles>();
					for (Pro_loanPlan loanPlan : loanPlanList) {
						projectfilesList1 = loanService.getAttachments(loanPlan.getLoanPlan_ID());
						
						Pro_project project = projectService.selectOneProjectInfoByWheresql(" and loanPlan_ID=\'"+loanPlan.getLoanPlan_ID()+"\'");
						projectfilesList2 = loanService.getAttachments(project.getProject_ID());
						Pro_delay delay = delayService.selectOneDelayInfo(" and delay.project_ID='"+project.getProject_ID()+"'");
						
						project.setProjectfilesList(projectfilesList2);
						project.setDelay(delay);
						loanPlan.setProject(project);
						loanPlan.setProjectfilesList(projectfilesList1);
					}
					meetingDetail.setLoanPlanList(loanPlanList);
				}
			}
			
			//mv.getModelMap().put("urlParam",urlParam);
			//mv.getModelMap().put("meetingDetailList",meetingDetailList);
			//mv.setViewName("/project/loan/proDelay/proDelay");
			ar.setSucceed(meetingDetailList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	
	
	/**
	 * @return 展期添加——显示页面
	 */
	@RequestMapping(value="/showProDelayAddPage")
	@ResponseBody
	public ModelAndView showProDelayAddPage(@RequestParam Map<String, Object> paramMap){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String project_ID = "";
		if(null != paramMap){
			project_ID = (String) paramMap.get("project_ID");
		}
		Pro_project project = new Pro_project();
		try {
			project = projectService.selectOneProjectInfoByWheresql(" and project_ID=\'"+project_ID+"\'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		mv.getModelMap().put("delay_ID", Tool.createUUID32());
		mv.getModelMap().put("project", project);
		mv.setViewName("/project/loan/proDelay/proDelayAdd");
		return mv;
	}
	/**
	 * @param loanPlan
	 * @return 展期添加
	 */
	@ResponseBody
    @RequestMapping(value = "/addOneDelayInfo")
    public AjaxRes updateLoanConfirm(@RequestBody Pro_delay delay) {
		
        AjaxRes ar = new AjaxRes();
        try {
        	
        	ar.setSucceed(delayService.insertOneDelayInfo(SystemSession.getUserSession(), delay));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ar;
    }
	/**
	 * @return 展期修改——显示页面
	 */
	@ResponseBody
	@RequestMapping(value="/showProDelayEditPage")
	public ModelAndView showProDelayEditPage(@RequestParam Map<String, Object> paramMap){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_delay delay = new Pro_delay();
		String delay_ID = "";
		if(null != paramMap){
			delay_ID = (String) paramMap.get("delay_ID");
		}
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+delay_ID+"\' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("delay", delay);
		mv.setViewName("/project/loan/proDelay/proDelayEdit");
		return mv;
	}
	
	/**
	 * @param delay
	 * @return 展期修改
	 */
	@ResponseBody
    @RequestMapping(value = "/updateProDelay")
    public AjaxRes updateProDelay(@RequestBody Pro_delay delay) {
		
        AjaxRes ar = new AjaxRes();
        try {
        	ar.setSucceed(delayService.updateProDelay(SystemSession.getUserSession(),delay));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ar;
    }
	
	/**
	 * @return 展期删除——显示页面
	 */
	@RequestMapping(value="/showProDelayDelPage")
	public ModelAndView showProDelayDelPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/proDelay/proDelayDel");
		return mv;
	}
	/**
	 * @param delay
	 * @return 展期删除
	 */
	@ResponseBody
    @RequestMapping(value = "/delProDelay")
    public AjaxRes delProDelay(@RequestBody Pro_delay delay) {
		
        AjaxRes ar = new AjaxRes();
        //delayService.deleteDelayByWhereSql(SystemSession.getUserSession(), " ");
        ar.setSucceed(delayService.delProDelay(SystemSession.getUserSession(),delay));
        return ar;
    }

	/**
	 * 展期子流程（企业续保申请）办理 - 查看
	 */
	@RequestMapping(value="/renewalNotRequired")
	public ModelAndView showProDelayProcess(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_delay delay = null;
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID=\'"+delay.getApplyID()+"\' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_delay.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			String whereSql = "and apply_ID = '"+apply.getApply_ID()+"'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			List<Pro_projectfiles> list = projectfilesService.selectListProFilesByWhereSql(" and entityID = \'"+apply.getApply_ID()+"\'" + " and fileType = \'"+"010"+"\'");
			List<Pro_optGuaranty> guaranties = optGuarantyService.selectOptGuarantyByWheresql(" and apply_ID = \'"+apply.getApply_ID()+"\'");
			mv.getModelMap().put("fileList", list);
			mv.getModelMap().put("guaranties", guaranties);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("flowID", instance.getEntryId());//流程实例id
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("delay", delay);
			mv.getModelMap().put("meetingResolution",meetingResolution);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/delay/renewalNotRequired");
		return mv;
	}
	
	/**
	 * 显示文档模板类型选择页面
	 */
	@RequestMapping(value="/showMouldTypePage")
	public ModelAndView showMouldTypePage(String flowID, String applyID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gworkFlow/delay/selectMouldType");
		ModelMap modelMap = mv.getModelMap();
		// 查询担保意向函列表
		List<Sys_docMould> mouldList = docMouldService.selectDocMouldListByWheresql("");	//ID值取自单级字典   and mouldTypeID='afe85ee6277b4b048810725524dcf852'
		modelMap.put("mouldList", mouldList);
		modelMap.put("flowID", flowID);
		modelMap.put("applyID", applyID);
		return mv;
	}
	
	/**
	 * 展期子流程（地市立项尽调）办理 - 查看
	 */
	@RequestMapping(value="/inspectApproval")
	public ModelAndView inspectApproval(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_delay delay = null;
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+delay.getApplyID()+"' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_delay.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			String whereSql = "and apply_ID = '"+apply.getApply_ID()+"'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = 011 ";
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("flowID", instance.getEntryId());//流程实例id
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("delay", delay);
			mv.getModelMap().put("meetingResolution",meetingResolution);
			mv.getModelMap().put("projectfiles",projectfiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/delay/inspectApproval");
		return mv;
	}
	
	/**
	 * 展期子流程（档案移交登记）办理 - 查看
	 */
	@RequestMapping(value="/fileTransfer")
	public ModelAndView fileTransfer(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_delay delay = null;
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+delay.getApplyID()+"' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_delay.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			String whereSql = "and apply_ID = '"+apply.getApply_ID()+"'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = 012 ";
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("flowID", instance.getEntryId());//流程实例id
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("delay", delay);
			mv.getModelMap().put("meetingResolution",meetingResolution);
			mv.getModelMap().put("projectfiles",projectfiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/delay/fileTransfer");
		return mv;
	}
	
	/**
	 * 展期子流程（档案接收确认）办理 - 查看
	 */
	@RequestMapping(value="/fileTransferConfirmation")
	public ModelAndView fileTransferConfirmation(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_delay delay = null;
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+delay.getApplyID()+"' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_delay.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			String whereSql = "and apply_ID = '"+apply.getApply_ID()+"'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = 012 ";
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("delay", delay);
			mv.getModelMap().put("projectfiles", projectfiles);
			mv.getModelMap().put("meetingResolution",meetingResolution);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/delay/fileTransferConfirmation");
		return mv;
	}
	
	/**
	 * 展期子流程（子公司风险管理部审核）办理 - 查看
	 */
	@RequestMapping(value="/riskExamination")
	public ModelAndView riskExamination(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_delay delay = null;
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+delay.getApplyID()+"' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_delay.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			String whereSql = "and apply_ID = '"+apply.getApply_ID()+"'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = 015 ";
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("flowID", instance.getEntryId());//流程实例id
			mv.getModelMap().put("projectfiles",projectfiles);//流程实例id
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("delay", delay);
			mv.getModelMap().put("meetingResolution",meetingResolution);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/delay/riskExamination");
		return mv;
	}
	
	/**
	 * 展期子流程（集团风险管理部审核）办理 - 查看
	 */
	@RequestMapping(value="/blocRiskExamination")
	public ModelAndView blocRiskExamination(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_delay delay = null;
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+delay.getApplyID()+"' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_delay.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			String whereSql = "and apply_ID = '"+apply.getApply_ID()+"'";
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			String fileswhereSql = "and entityID='" + apply.getApply_ID() +  "'and flowID='" + instance.getEntryId()+"'";//"' and fileType = '014' " +
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("delay", delay);
			mv.getModelMap().put("projectfiles", projectfiles);
			mv.getModelMap().put("meetingResolution",meetingResolution);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/delay/blocRiskExamination");
		return mv;
	}
	
	/**
	 * 展期子流程（集团总办会纪要）办理 - 查看
	 */
	@RequestMapping(value="/blocSummary")
	public ModelAndView blocSummary(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_delay delay = null;
		try {
			delay = delayService.selectOneDelayInfo(" and delay.delay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+delay.getApplyID()+"' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_delay.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			String whereSql = "and apply_ID = '"+apply.getApply_ID()+"'";
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = 016 ";
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			mv.getModelMap().put("projectfiles", projectfiles);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("delay", delay);
			mv.getModelMap().put("meetingResolution",meetingResolution);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/delay/blocSummary");
		return mv;
	}
	
	/**
	 * @description	根据文档模板生成文档
	 * @author wuhn
	 * @date 2017年8月9日 下午5:03:22
	 * tmps 模板文件路径
	 */
	@RequestMapping(value="/generateDocument")
	@ResponseBody
	public AjaxRes generateDocument(@RequestBody Pro_projectfiles projectfiles,HttpServletRequest request){
		AjaxRes  ar =new AjaxRes();
		projectfiles.setFileType("010");
		Boolean bool = createDocument(projectfiles,request);
		ar.setSucceed(bool);
		return ar;
	}

	
	/**
	 * @description	  根据模板生成文档
	 * @author wuhn
	 * @date 2017年8月9日 下午6:24:10
	 */
	private Boolean createDocument(Pro_projectfiles projectfiles,HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/");
		String templatePath=realPath+ projectfiles.getMouldPath(); //模板路径
		String tempPath=projectfiles.getMouldPath();
		tempPath=tempPath.substring(0,tempPath.lastIndexOf("/")).replace("docMould", "projFiles");
		String destPath=realPath+tempPath; //目标存储路径 //目标存储路径
		File file = new File(destPath);
		if(!file.exists()){
			file.mkdirs();
		}
		String newDocName="/"+Tool.createUUID32()+".docx";
		projectfiles.setPathFile(tempPath+newDocName);
		destPath=destPath+newDocName;
		//查询业务/授信申请信息表
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+projectfiles.getEntityID()+"' ");
		Pro_applyDetail applyDetail = applyDetailService.selectOneApplyDetailByWhereSql(" and apply_ID='"+projectfiles.getEntityID()+"' ");
		Client client = clientService.selectMainClientByClient_ID(apply.getClient_ID());
		//根据业务id获取业务表信息;
		String wheresql = " and apply_ID = \'"+apply.getApply_ID()+"\'";
	    List<Pro_project> project = projectService.selectProjectListByWheresql(wheresql);
//	    List<Pro_optGuaranty> listopt = optGuarantyService.selectOptGuarantyByWheresql(wheresql);
	    String guaranteeRemarks = optGuarantyService.getGuaranteeRemarkByWheresql(wheresql);
		Map map = getMapData(client,apply,project.get(0),guaranteeRemarks,applyDetail);
		try {
		ContractUtil.generateWord(templatePath, destPath, map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		projectfiles.setProjectFiles_ID(Tool.createUUID32());
		projectfiles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		projectfiles.setUpdateUserName(SystemSession.getUserSession().getUser_name());
		projectfiles.setUploadManID(SystemSession.getUserSession().getUser_id());
		projectfiles.setUploadManName(SystemSession.getUserSession().getUser_name());
		projectfiles.setFileSize(new File(destPath).length()+"");
		projectfiles.setSourceFileName("委托申请担保书");
		projectfiles.setExtend("doxc");
		Boolean bool = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), projectfiles);
		return bool;
	}
	/**
	 * 处理路径中的分隔符, 路径保存到数据库时调用
	 */
	public String getPath(String sysPath){
		return sysPath.replace("\\", "/");
	}
	
	/**
	 * @description	  获取生成文档数据
	 * @author wuhn
	 * @date 2017年8月10日 上午10:31:29
	 */
	private Map getMapData(Client client,Pro_apply apply,Pro_project project,String guaranteeRemarks,Pro_applyDetail applyDetail) {
		Map<String,Object> map =new HashMap<>();
		map.put("client", client);
		map.put("apply", apply);
		map.put("guaranteeRemarks", guaranteeRemarks);
		map.put("bigRegisterSum", PriceUtil.getRMB((long) (client.getRegisterSum()*100)));//注册金额大写
		map.put("applyDetail", applyDetail);
		map.put("createTime", DateUtil.dateStr(DateUtil.getNow(), DateUtil.DATE_PATTERN));
		return map;
	}
	
	// TODO 续保续贷任务事项

	/**
	 **  生成经理办公会评议项目情况简表（Ⅰ/Ⅱ）
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageReviewExport")
	@ResponseBody
	public AjaxRes manageReviewExport(HttpServletRequest request,@RequestBody Pro_projectfiles projectfiles) throws Exception {//Pro_projectfiles projectfiles
		String filename = "经理办公会评议项目情况简表（Ⅱ）.xls";
		String applyID = projectfiles.getEntityID();
		String flowID =  projectfiles.getFlowID();
		AjaxRes  ar =new AjaxRes();
		String ccolumnArr[]={"**经理办公会评议项目情况简表(Ⅰ)"};
		String ccolumnArr2[]={"**经理办公会评议项目情况简表（Ⅱ）"};
		String title = "经理办公会（Ⅰ）";
		String title2 = "经理办公会（Ⅱ）";
		ExportExcel2<pro_manageRreviewModeExcel> ex = new ExportExcel2<pro_manageRreviewModeExcel>();
		OutputStream out = new  ByteArrayOutputStream();
		//对json对象进行转换
//		String entityID = "a34d63cc92ab11e7b87d000000143522";
//		if(null != paramMap){
 // 			entityID =  (String) paramMap.get("entityID");
//		}
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+applyID+"' ");
		List<pro_manageRreviewModeExcel> list1 = delayService.packageManageReviewExport(SystemSession.getUserSession(),apply);
		
        String filePath = request.getSession().getServletContext().getRealPath("/");
        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("title", title);
        map.put("ccolumnArr", ccolumnArr);
        map.put("list", list1);
        map.put("a", null);
        listMap.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("title", title2);
        map2.put("ccolumnArr", ccolumnArr2);
        map2.put("list", list1);
        map2.put("a", null);
        listMap.add(map2);
        Pro_projectfiles pro_projectfiles = ex.exportExcel(listMap, out, filePath, applyID,flowID,list1.size());
        pro_projectfiles.setSourceFileName(filename);
        pro_projectfiles.setExtend("xls");
        pro_projectfiles.setFileType("011");
        boolean a = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), pro_projectfiles);
//		out.close();
		ar.setSucceed(a);
		return ar;
	}
	
	/**
	 ** 生成《拟推荐上会项目清单（Ⅰ/Ⅱ）》
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/meetingExport")
	@ResponseBody
	public AjaxRes meetingExport(HttpServletRequest request,@RequestBody Pro_projectfiles projectfiles) throws Exception {
		String filename = "《拟推荐上会项目清单（Ⅰ/Ⅱ）》.xls";
		String ccolumnArr[]={"生成《拟推荐上会项目清单（Ⅱ）》"};
		String ccolumnArr2[]={"生成《拟推荐上会项目清单（Ⅰ）》"};
		String title = "经理办公会评议项目情况简表（Ⅱ）";
		String title2 = "经理办公会评议项目情况简表（Ⅰ）";
		AjaxRes  ar =new AjaxRes();
		String applyID = projectfiles.getEntityID();
		String flowID =  projectfiles.getFlowID();
		ExportExcel2<pro_meetingExportModeExcel> ex = new ExportExcel2<pro_meetingExportModeExcel>();
		OutputStream out = new  ByteArrayOutputStream();
		//对json对象进行转换
//		String entityID = "a34d63cc92ab11e7b87d000000143522";
//		if(null != paramMap){
// 			entityID =  (String) paramMap.get("entityID");
//		}
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+applyID+"' ");
		List<pro_meetingExportModeExcel> list1 = delayService.packageMeetingExport(apply);
		
        String filePath = request.getSession().getServletContext().getRealPath("/");
//		ex.exportExcel(title, ccolumnArr, list1, out, null,filePath,entityID);
		List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("title", title);
        map.put("ccolumnArr", ccolumnArr);
        map.put("list", list1);
        map.put("a", null);
        listMap.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("title", title2);
        map2.put("ccolumnArr", ccolumnArr2);
        map2.put("list", list1);
        map2.put("a", null);
        listMap.add(map2);
        Pro_projectfiles pro_projectfiles = ex.exportExcel(listMap, out, filePath, applyID,flowID,list1.size());
        pro_projectfiles.setSourceFileName(filename);
        pro_projectfiles.setExtend("xls");
        pro_projectfiles.setFileType("011");
        boolean a = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), pro_projectfiles);
        ar.setSucceed(a);
		return ar;
		//out.close();
	}
	
	/**
	 ** 生成项目评议委员会评审通过项目情况简表(Ⅰ)
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/reviewCommitteeExport")
	@ResponseBody
	public AjaxRes reviewCommitteeExport(HttpServletRequest request,@RequestBody Pro_projectfiles projectfiles) throws Exception {
		String filename = "项目评议委员会评审通过项目情况简表(Ⅰ).xls";
		AjaxRes ar =new AjaxRes();
		String applyID = projectfiles.getEntityID();
		String flowID =  projectfiles.getFlowID();
		String ccolumnArr[]={"项目评议委员会评审通过项目情况简表(Ⅰ)"};
		String ccolumnArr2[]={"项目评议委员会评审通过项目情况简表(Ⅰ)"};
		String title = "集团3000以下";
		String title2 = "中瑞3000以下";
		ExportExcel2<pro_reviewCommitteeModeExcel> ex = new ExportExcel2<pro_reviewCommitteeModeExcel>();
		OutputStream out = new  ByteArrayOutputStream();
		//对json对象进行转换
//		String entityID = "a34d63cc92ab11e7b87d000000143522";
//		if(null != paramMap){
// 			entityID =  (String) paramMap.get("entityID");
//		}
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+applyID+"' ");
		
		List<pro_reviewCommitteeModeExcel> list1 = delayService.packageCommitteeExport(apply);
		List<Map<String,Object>> listMap = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
        map.put("title", title);
        map.put("ccolumnArr", ccolumnArr);
        map.put("list", list1);
        map.put("a", null);
        listMap.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("title", title2);
        map2.put("ccolumnArr", ccolumnArr2);
        map2.put("list", list1);
        map2.put("a", null);
        listMap.add(map2);
        String filePath = request.getSession().getServletContext().getRealPath("/");
        Pro_projectfiles projectfiles1 = ex.exportExcel(listMap, out, filePath, applyID,flowID,list1.size());
        projectfiles1.setSourceFileName(filename);
        projectfiles1.setExtend("xls");
        projectfiles1.setFileType("015");
        boolean a = projectfilesService.insertOneProFilesInfo(SystemSession.getUserSession(), projectfiles1);
	    ar.setSucceed(a);
		return ar;
	}
	
	/**
	 *  子公司风险部上传《项目评议委员会评审通过项目情况简表（Ⅱ）》、《党政联席会会议材料》
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value="/riskUpload")
	public ModelAndView riskUpload(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"' ");
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = '015' " ;
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("fileType", "015");
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("files", projectfiles);
			mv.getModelMap().put("type", urlParam.getType()==null?"view":urlParam.getType());//默认为查看页面
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		mv.setViewName("/project/renewal/riskUpload");
		return mv;
	}
	
	/**
	 *  子公司审核放款通知和放款凭证 
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value="/loanCheck")
	public ModelAndView loanCheck(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"' ");
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = '016' " ;
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("files", projectfiles);
			mv.getModelMap().put("type", urlParam.getType()==null?"view":urlParam.getType());//默认为查看页面
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		mv.setViewName("/project/renewal/loanCheck");
		return mv;
	}
	
	/**
	 *  上传放款通知和放款凭证 
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value="/loanFilesUpload")
	public ModelAndView loanFilesUpload(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+urlParam.getEntityID()+"' ");
			String fileswhereSql = "and entityID='" + apply.getApply_ID() + "' and fileType = '016' " ;
			List<Pro_projectfiles> projectfiles = projectfilesService.selectListProFilesByWhereSql(fileswhereSql);
			mv.getModelMap().put("fileTpe", "016");
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("files", projectfiles);
			mv.getModelMap().put("type", urlParam.getType()==null?"view":urlParam.getType());//默认为查看页面
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		mv.setViewName("/project/renewal/loanFilesUpload");
		return mv;
	}
	
}

package com.zjm.pro.costReturn.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gworkFlow.db.map.OsGworkflowInstanceMapper;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.db.model.OsGworkflowProjsuggest;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowProjsuggestService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.costReturn.service.CostReturnService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costReturn;
import com.zjm.pro.db.model.Pro_creditor;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
 * 事项中收费登记 -退费action
 */
@Controller
@RequestMapping(value="/project/costReturn")
public class CostReturnAction {
	@Resource
	private CostMustService costMustService;
	@Resource
	private CostReturnService costReturnService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private ProjectService projectService;
	@Resource
	private OsGworkflowInstanceMapper osGworkflowInstanceMapper;
	@Resource
	private OsGworkflowProjsuggestService osGworkflowProjsuggestService;
	@Resource
	private ProjectfilesService  projectfilesService;
	
	
	/**
	 * confirmationCostMust
	 * 退费-确认退费
	 * @param  
	 * @return
	 */
	@RequestMapping(value="/costReturnToCostPre", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes costReturnToCostPre(@RequestBody Pro_costReturn  pro_costReturn){
		
		Boolean b= costReturnService.costReturnToCostPre(SystemSession.getUserSession(),pro_costReturn);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(true);
		return ar;
	}
	
	/*******************************************************************************************/
	/**********************************以下是放款复核确认收费****************************************/
	/*******************************************************************************************/
	/**
     * @param meetingDetail_ID
     * @return 添加退费 ———— 展示页面
     */
    @RequestMapping(value="/showAddCostReturnPage")
	public ModelAndView showAddCostReturnPage(String  meetingDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("meetingDetail",meetingDetail);
		
		mv.setViewName("/project/loan/singleLoanReview/costReturnAdd");
		return mv;
	}
    /**
	 * 执行退费新增操作
	 */
	@RequestMapping(value="/insertOneCostReturn")
	@ResponseBody
	public AjaxRes insertOneCostReturn(@RequestBody Pro_costReturn costReturn){
		AjaxRes ar = new AjaxRes();
		Boolean b = costReturnService.insertOneCostReturn(SystemSession.getUserSession(), costReturn);
		ar.setSucceed(b);
		return ar;
	}
	/**
     * @param costReturn_ID
     * @return 修改退费 ———— 展示页面
     */
    @RequestMapping(value="/showUpdateCostReturnPage")
	public ModelAndView showUpdateCostReturnPage(String costReturn_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		Pro_costReturn costReturn = costReturnService.selectOneCostReturnByWhereSql(" and costReturn_ID='"+costReturn_ID+"' ");
		
		String condition = " and meetingDetail_ID='"+costReturn.getMeetingDetail_ID()+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		mv.getModel().put("meetingDetail",meetingDetail);
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("costReturn",costReturn);
		
		mv.setViewName("/project/loan/singleLoanReview/costReturnUpdate");
		return mv;
	}
    /**
	 * 执行退费修改操作
	 */
	@RequestMapping(value="/updateOneCostReturn")
	@ResponseBody
	public AjaxRes updateOneCostReturn(@RequestBody Pro_costReturn costReturn){
		AjaxRes ar = new AjaxRes();
		Boolean b = costReturnService.updateOneCostReturn(SystemSession.getUserSession(), costReturn);
		ar.setSucceed(b);
		return ar;
	}
	/**
     * @return 删除退费 ———— 展示页面
     */
    @RequestMapping(value="/showDelCostReturnPage")
	public ModelAndView showDelCostReturnPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		
		mv.setViewName("/project/loan/singleLoanReview/costReturnDel");
		return mv;
	}
    /**
	 * 执行退费删除操作
	 */
	@RequestMapping(value="/delOneCostReturn")
	@ResponseBody
	public AjaxRes delOneCostReturn(@RequestBody Pro_costReturn costReturn){
		AjaxRes ar = new AjaxRes();
		Boolean b = costReturnService.delOneCostReturn(SystemSession.getUserSession(), costReturn);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 退费分页列表
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/selectProjectCostReturnPageTables", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes  selectProjectCostReturnPageTables(@RequestBody PageTable<Pro_costReturn>  pageTable){
		AjaxRes  ar =new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		String queryCondition = queryProjectCreditorCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable= costReturnService.selectCostReturnPageTable(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryProjectCreditorCondition(PageTable<Pro_costReturn>  pageTable) {
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		//根据申请ID(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			sb.append(" and apply_ID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		return sb.toString();
	}
	
	/**
	 * 跳转到退费修改页面
	 * @param project_ID
	 * returnProjectDelayEditPage
	 * @return
	 */
	@RequestMapping(value="/returnProjectCostReturnEditPage")
	public ModelAndView returnProjectDelayEditPage(Pro_costReturn  pro_costReturn){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_costReturn  costReturn = new Pro_costReturn();
		if(null != pro_costReturn){
			//根据delay_ID获取展期信息;
			costReturn = costReturnService.selectOneCostReturnByWhereSql(" and costReturn_ID= \'"+pro_costReturn.getCostReturn_ID()+"\'");
		}
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		mv.getModel().put("costReturn",costReturn);
		mv.getModel().put("costTypeList",costTypeList);
		mv.setViewName("/project/apply/projectCostReturnEdit");
		return mv;
	}
	
	/**
	 * 跳转到退保证金修改页面
	 * @param project_ID
	 * returnProjectDelayEditPage
	 * @return
	 */
	@RequestMapping(value="/returnProjectOptReturnEditPage")
	public ModelAndView returnProjectOptReturnEditPage(Pro_costReturn  pro_costReturn){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_costReturn  costReturn = new Pro_costReturn();
		if(null != pro_costReturn){
			//根据delay_ID获取展期信息;
			costReturn = costReturnService.selectOneCostReturnByWhereSql(" and costReturn_ID= \'"+pro_costReturn.getCostReturn_ID()+"\'");
		}
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		mv.getModel().put("costReturn",costReturn);
		mv.getModel().put("costTypeList",costTypeList);
		mv.setViewName("/project/opt/optManager/projectCostReturnEdit");
		return mv;
	}
	
	
	/**
	 * 项目组上传退费审批单
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value="/gworkFlowUploadFile")
	public ModelAndView gworkFlowUploadFile(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_costReturn costReturn = null;
		try {
			costReturn = costReturnService.selectOneCostReturnByWhereSql(" and costReturn_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID=\'"+costReturn.getApply_ID()+"\' ");
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and apply_ID=\'"+costReturn.getApply_ID()+"\' ");
			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_costReturn.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			List<Pro_projectfiles> list = projectfilesService.selectListProFilesByWhereSql(" and entityID = \'"+apply.getApply_ID()+"\'" + " and fileType = \'"+"03"+"\'");
			mv.getModelMap().put("projectfiles", list);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("flowID", instance.getEntryId());//流程实例id
			mv.getModelMap().put("project", project);
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("costReturn", costReturn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/costReturn/gworkFlowUploadFile");
		return mv;
	}
	
	/**
	 * 委贷还款办理 --财务审核文件
	 */
	@RequestMapping(value="/gworkFlowSelectFile")
	public ModelAndView gworkFlowSelectFile(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_costReturn costReturn = null;
		try {
			costReturn = costReturnService.selectOneCostReturnByWhereSql(" and costReturn_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID=\'"+costReturn.getApply_ID()+"\' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_costReturn.class.getName());
			instance = osGworkflowInstanceMapper.getOneByBusiness(instance);
			
			OsGworkflowProjsuggest osGworkflowProjsuggest = new OsGworkflowProjsuggest();
			osGworkflowProjsuggest.setFlowID(instance.getEntryId());
			List<OsGworkflowProjsuggest> osSuggestList=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());

			// 考虑到有些项目不需要上会, 评审会决议表信息会在项目刚申请的时候就插入一条, 所以此处meetingResolution一定能查出一条
			List<Pro_projectfiles> list = projectfilesService.selectListProFilesByWhereSql(" and entityID = \'"+apply.getApply_ID()+"\'" + " and fileType = \'"+"03"+"\'");
			mv.getModelMap().put("projectfiles", list);
			mv.getModelMap().put("osSuggestList", osSuggestList);
			mv.getModelMap().put("flowID", instance.getEntryId());//流程实例id
			mv.getModelMap().put("apply", apply);
			mv.getModelMap().put("apply_ID", apply.getApply_ID());
			mv.getModelMap().put("costReturn", costReturn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/costReturn/gworkFlowSelectFile");
		return mv;
	}

	
}

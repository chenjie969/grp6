package com.zjm.pro.factPay.web;

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
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.factPay.service.FactPayService;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value="/project/factPay")
public class FactPayAction {
	@Resource
	private FactPayService factPayService;
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private ProjectService projectService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private LoanService loanService;
	@Resource
	private OsGworkflowInstanceMapper osGworkflowInstanceMapper;
	@Resource
	private OsGworkflowProjsuggestService osGworkflowProjsuggestService;
	@Resource
	private ProjectfilesService  projectfilesService;

	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_factPay> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and factPay.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		if (pageTable.getWheresql() != null) {
			wheresql.append(pageTable.getWheresql());
		}
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		//根据申请id(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			wheresql.append(" and factPay.applyID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		return wheresql.toString();		
	}
	
	/**
	 * 事项-办理-跳转到还款登记/展期/逾期确认列表页面
	 * @param suggest
	 * @return
	 * @throws  
	 */
	@RequestMapping(value="/projectRegisterPayTable")
	public ModelAndView projectRegisterPayTable(String entityID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		mv.getModelMap().put("entityID",entityID);
		mv.setViewName("/project/factPay/projectPayDelayOverTable");
		return mv;
	}
	
	/**
	 * 跳转到还款登记页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnProjectPayPage")
	public ModelAndView returnProjectPayPage(String  project_ID,String apply_ID){
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
		mv.getModel().put("project_ID",project_ID);
		mv.setViewName("/project/factPay/projectPay");
		return mv;
	}
	/**
	 * 跳转到还款登记修改页面
	 * returnProjectPayEditPage
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnProjectPayEditPage")
	public ModelAndView returnProjectPayEditPage(Pro_factPay pro_factPay){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_factPay  factPay = new Pro_factPay();
		if(null != pro_factPay){
			//根据factPay_ID获取还款信息信息;
		  factPay = factPayService.selectOneFactPayByWhereSql(" and factPay_ID = \'"+pro_factPay.getFactPay_ID()+"\'");
			
		}
		mv.getModel().put("factPay",factPay);
		mv.setViewName("/project/apply/projectPayEdit");
		return mv;
	}
	/**
	 * insertOneFactPay
	 * 新增还款登记;
	 * 
	 */
	@RequestMapping(value="/insertOneFactPay", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneFactPay(@RequestBody Pro_factPay pro_factPay){
		Boolean b = true;	
		if(pro_factPay  != null){		
			try {
				b=factPayService.insertOneFactPayInfo(SystemSession.getUserSession(),pro_factPay);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * updateOneFactPay
	 * 修改还款登记;
	 * 
	 */
	@RequestMapping(value="/updateOneFactPay", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneFactPay(@RequestBody Pro_factPay pro_factPay){
		Boolean b = true;	
		if(pro_factPay  != null){		
			try {
				b=factPayService.updateOneFactPay(SystemSession.getUserSession(),pro_factPay);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 查询还款情况分页列表
	 * @param PageTable<Pro_factPay> pageTable
	 * @author ZKY   project_ID
	 * @time :2017-8-24 
	 */  
	@RequestMapping(value="/selectFactPayTable")
	@ResponseBody
	public AjaxRes selectFactPayTable(@RequestBody PageTable<Pro_factPay> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = factPayService.selectFactPayTables(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		ar.setSucceed(pageTable);
		return ar;
	}

	
	/**
	 * 删除一个还款表信息
	 * @param Pro_factPay factPay
	 * @return
	 */
	@RequestMapping(value="/delOneFactPay", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOneFactPay(@RequestBody Pro_factPay factPay){
		factPay.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b = false;
		try {
			b= factPayService.deleteOneFactPay(SystemSession.getUserSession(),factPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 查询项目对应还款情况分页列表
	 */  
	@RequestMapping(value="/selectPayTable")
	@ResponseBody
	public AjaxRes selectPayTable(@RequestBody PageTable<Pro_factPay> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryPayConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = factPayService.selectPayTables(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		ar.setSucceed(pageTable);
		return ar;
	}


	/**
	 * 分页列表查询条件
	 */
	private String queryPayConditionSql(PageTable<Pro_factPay> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and factPay.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		if (pageTable.getWheresql() != null) {
			wheresql.append(pageTable.getWheresql());
		}
		/*//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}*/
		return wheresql.toString();		
	}
	
	/**
	 * 撤销还款——显示页面
	 * @return
	 */
	@RequestMapping(value="/showFactPayDelPage")
	public ModelAndView showFactPayDelPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/apply/dutyRemove/factPayDel");
		return mv;
	}
	/**
	 * 撤销还款
	 */
	@RequestMapping(value="/cancelOneFactPayDel")
	@ResponseBody
	public AjaxRes cancelOneFactPayDel(@RequestBody Pro_factPay  factPay){
		AjaxRes ar = new AjaxRes();
		try {
			//删除还款信息
			ar.setSucceed(factPayService.cancelOneFactPayDel(factPay));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 部分还款——显示页面
	 * @return
	 */
	@RequestMapping(value="/showFactPayAddPage")
	public ModelAndView showFactPayAddPage(String project_ID,String apply_ID){
		
		List<C_dictype> freeTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='9df927d50f8a48b9b6bcf313f5551530'");//获取担保责任解除类型下拉框;
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		
		mv.getModelMap().put("freeTypeList",freeTypeList);
		mv.getModelMap().put("project_ID",project_ID);
		mv.getModelMap().put("apply_ID",apply_ID);
		
		
		mv.setViewName("/project/apply/dutyRemove/factPayAdd");
		return mv;
	}
	
	/**
	 * 部分还款添加
	 */
	@RequestMapping(value="/addOneFactPay")
	@ResponseBody
	public AjaxRes addOneFactPay(@RequestBody Pro_factPay  factPay){
		AjaxRes ar = new AjaxRes();
		try {
			//添加还款信息
			ar.setSucceed(factPayService.addOneFactPay(factPay));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面-查看代偿信息
	 */
	@RequestMapping(value="/showFactPayViewPage")
	public ModelAndView showFactPayViewPage(String factPay_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_factPay factPay = null;
		try {
			factPay = factPayService.selectOneFactPayByID(" and factPay.factPay_ID=\'"+factPay_ID+"\'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("factPay",factPay);
		mv.setViewName("/project/apply/dutyRemove/factPayView");
		return mv;
	}
	/****************************************************************************************************/
	/*********************************以下是正常解除申请（文旦）*************************************/
	/****************************************************************************************************/
	/**
     * @return 正常解除申请 ———— 展示页面  WHDB
     */
    @RequestMapping(value="/showWHDBFactPayAddPage")
	public ModelAndView showWHDBFactPayAddPage(String project_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+project_ID+"' ");
			//查询业务/授信申请信息表
			String apply_ID = project.getApply_ID();
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
			
			mv.getModel().put("factPay_ID",Tool.createUUID32());
			mv.getModelMap().put("project", project);
			mv.getModelMap().put("apply", apply);
			mv.setViewName("/project/WHDB/removePay/factPayAdd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    
    
    /**
	 * 正常解除申请
	 */
	@RequestMapping(value="/insertOneFactPayWHDB")
	@ResponseBody
	public AjaxRes insertOneFactPayWHDB(@RequestBody Pro_factPay  factPay){
		AjaxRes ar = new AjaxRes();
		try {
			//正常解除申请
			ar.setSucceed(factPayService.insertOneFactPayWHDB(SystemSession.getUserSession(),factPay));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 撤销还款——显示页面
	 * @return WHDB
	 */
	@RequestMapping(value="/showFactPayDelWHDBPage")
	public ModelAndView showFactPayDelWHDBPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/WHDB/removePay/factPayDel");
		return mv;
	}
	/**
	 * 撤销还款
	 */
	@RequestMapping(value="/deleteOneFactPay")
	@ResponseBody
	public AjaxRes deleteOneFactPay(@RequestBody Pro_factPay  factPay){
		AjaxRes ar = new AjaxRes();
		try {
			//删除还款信息
			ar.setSucceed(factPayService.deleteOneFactPay(factPay));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 显示页面-查看正常解除信息
	 */
	@RequestMapping(value="/showFactPayViewWHDBPage")
	public ModelAndView showFactPayViewWHDBPage(String factPay_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_factPay factPay = null;
		try {
			factPay = factPayService.selectOneFactPayByID(" and factPay.factPay_ID=\'"+factPay_ID+"\'");
			List<Pro_projectfiles> projectfilesList = loanService.getAttachments(factPay.getFactPay_ID());
			
			factPay.setProjectfilesList(projectfilesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("factPay",factPay);
		mv.setViewName("/project/WHDB/removePay/factPayView");
		return mv;
	}
	
	/**
	 * 正常解除  审批链接
	 */
	@RequestMapping(value="/showApprovalLink")
	public ModelAndView showApprovalLink(String factPay_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_factPay factPay = null;
		try {
			factPay = factPayService.selectOneFactPayByID(" and factPay.factPay_ID=\'"+factPay_ID+"\'");
			
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+factPay.getProject_ID()+"' ");
			//查询业务/授信申请信息表
			String apply_ID = project.getApply_ID();
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
			
			List<Pro_projectfiles> projectfilesList = loanService.getAttachments(factPay.getFactPay_ID());
			
			factPay.setProjectfilesList(projectfilesList);
			
			mv.getModelMap().put("project", project);
			mv.getModelMap().put("apply", apply);
			
			mv.getModelMap().put("factPay",factPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/project/WHDB/removePay/factApprovalLink");
		return mv;
	}
	
	/**
	 * 委贷还款办理 - 查看（项目组上传通知单）
	 */
	@RequestMapping(value="/gworkFlowUploadFile")
	public ModelAndView gworkFlowUploadFile(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_factPay pro_factPay = null;
		try {
			pro_factPay = factPayService.selectOneFactPayByWhereSql(" and factPay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID=\'"+pro_factPay.getApplyID()+"\' ");
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+pro_factPay.getProject_ID()+"' ");
			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_factPay.class.getName());
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
			mv.getModelMap().put("pro_factPay", pro_factPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/factPay/gworkFlowUploadFile");
		return mv;
	}
	
	/**
	 * 委贷还款办理 --审核文件
	 */
	@RequestMapping(value="/gworkFlowSelectFile")
	public ModelAndView gworkFlowSelectFile(String businessId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_factPay pro_factPay = null;
		try {
			pro_factPay = factPayService.selectOneFactPayByWhereSql(" and factPay_ID=\'"+businessId+"\' ");
			//查询业务/授信申请信息表
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID=\'"+pro_factPay.getApplyID()+"\' ");

			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setBusinessId(businessId);
			instance.setBusinessType(Pro_factPay.class.getName());
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
			mv.getModelMap().put("pro_factPay", pro_factPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gworkFlow/factPay/gworkFlowSelectFile");
		return mv;
	}

}

package com.zjm.pro.replace.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vaadin.data.util.filter.And;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.db.model.Pro_replace;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.replace.service.ReplaceService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;


@Controller
@RequestMapping(value="/project/Replace")
public class ReplaceAction{
	
	@Resource
	private ReplaceService replaceService;
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private ProjectService projectService;
	@Resource
	private LoanService loanService;
	
	/**
	 * 跳转到代偿与追偿任务事项页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/replaceProPage")
	public ModelAndView replaceProPage(){
		ModelAndView mv =CustomDispatchServlet.getModeAndView();
		try {
			mv.setViewName("/project/replacePro/replacePro");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	
	
	
	/**
	 * 跳转到代偿登记页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnProjectReplacePage")
	public ModelAndView returnProjectReplacePage(String  project_ID,String apply_ID){
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
		mv.setViewName("/project/factPay/projectReplace");
		return mv;
	}
	/**
	 * 跳转到代偿修改页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/projectReplaceEditPage")
	public ModelAndView projectReplaceEditPage(String  replace_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_replace replace = new Pro_replace();
		if(null != replace_ID){
			//根据apply_id获取项目摘要信息;
			replace= replaceService.selectOneReplaceInfo(" and replace_ID = \'"+replace_ID+"\'");
			
		}
		mv.getModel().put("replace",replace);
		mv.setViewName("/project/factPay/projectReplaceEdit");
		return mv;
	}
	/**
	 * 修改代偿信息;
	 * 
	 */
	@RequestMapping(value="/updateOneReplace", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneReplace(@RequestBody Pro_replace pro_replace){
		Boolean b = true;	
		if(pro_replace  != null){		
			try {
				b=replaceService.updateOneReplaceInfo(SystemSession.getUserSession(),pro_replace);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * insertOneReplace
	 * 新增代偿登记;
	 * 
	 */
	@RequestMapping(value="/insertOneReplace", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneReplace(@RequestBody Pro_replace pro_replace){
		Boolean b = true;	
		if(pro_replace  != null){		
			try {
				b=replaceService.insertOneReplaceInfo(SystemSession.getUserSession(),pro_replace);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 分页查询代偿列表
	 */
	@RequestMapping(value="/selectReplacePageTable")
	@ResponseBody
	public AjaxRes selectReplacePageTable(@RequestBody PageTable<Pro_replace> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = replaceService.selectReplacePageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_replace> pageTable){
		if(pageTable==null){
			StringBuffer wheresql = new StringBuffer();
			wheresql.append(" and pro_replace.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		if (pageTable.getWheresql()!=null) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and pro_replace.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		//根据申请id(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			wheresql.append(" and pro_replace.applyID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		
		return wheresql.toString();
	}
	
	
	/**
	 * 分页查询代偿列表  —— 项目对应
	 */
	@RequestMapping(value="/selectReplaceTable")
	@ResponseBody
	public AjaxRes selectReplaceTable(@RequestBody PageTable<Pro_replace> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryReplaceConditionSql(pageTable));
		try {
			pageTable = replaceService.selectReplaceTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件  —— 项目对应
	 */
	private String queryReplaceConditionSql(PageTable<Pro_replace> pageTable){
		if(pageTable==null){
			StringBuffer wheresql = new StringBuffer();
			wheresql.append(" and pro_replace.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			return "";
		}
		
		StringBuffer wheresql = new StringBuffer();
		if(pageTable.getWheresql()!=null){
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and pro_replace.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		//根据申请id(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			wheresql.append(" and pro_replace.apply_ID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		
		return wheresql.toString();
	}
	/**
	 * 显示页面-查看代偿信息
	 */
	@RequestMapping(value="/showRepalceViewPage")
	public ModelAndView showRepalceViewPage(String replace_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_replace replace = null;
		try {
			replace = replaceService.showRepalceViewPage(" and replace_ID='"+replace_ID+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("replace",replace);
		mv.setViewName("/project/apply/dutyRemove/replaceView");
		return mv;
	}
	/**
	 * 撤销代款——显示页面
	 * @return
	 */
	@RequestMapping(value="/showReplaceDelPage")
	public ModelAndView showFactPayDelPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/apply/dutyRemove/replaceDel");
		return mv;
	}
	
	/**
	 * 撤销还款
	 */
	@RequestMapping(value="/cancelReplaceDel")
	@ResponseBody
	public AjaxRes cancelReplaceDel(@RequestBody Pro_replace replace){
		AjaxRes ar = new AjaxRes();
		try {
			//删除还款信息
			ar.setSucceed(replaceService.cancelReplaceDel(replace));
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
	@RequestMapping(value="/showReplaceAddPage")
	public ModelAndView showReplaceAddPage(String project_ID,String apply_ID ){
		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		
		mv.getModelMap().put("project_ID",project_ID);
		mv.getModelMap().put("apply_ID",apply_ID);
		
		
		mv.setViewName("/project/apply/dutyRemove/replaceAdd");
		return mv;
	}
	
	
	/**
	 * 部分代偿添加
	 */
	@RequestMapping(value="/addOneReplace")
	@ResponseBody
	public AjaxRes addOneReplace(@RequestBody Pro_replace replace){
		AjaxRes ar = new AjaxRes();
		try {
			//添加代偿信息
			ar.setSucceed(replaceService.addOneReplace(replace));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	/****************************************************************************************************/
	/*********************************以下是代偿解除申请（文旦）*************************************/
	/****************************************************************************************************/
	/**
     * @return 代偿解除申请 ———— 展示页面  WHDB
     */
    @RequestMapping(value="/showWHDBReplaceAddPage")
	public ModelAndView showWHDBReplaceAddPage(String project_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+project_ID+"' ");
			//查询业务/授信申请信息表
			String apply_ID = project.getApply_ID();
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
			
			mv.getModel().put("replace_ID",Tool.createUUID32());
			mv.getModelMap().put("project", project);
			mv.getModelMap().put("apply", apply);
			mv.setViewName("/project/WHDB/removePay/replaceAdd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * @param pro_replace
	 * @return 代偿解除申请
	 */
	@RequestMapping(value="/insertOneReplaceWHDB", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneReplaceWHDB(@RequestBody Pro_replace pro_replace){
		Boolean b = true;	
		if(pro_replace  != null){		
			try {
				b=replaceService.insertOneReplaceWHDB(SystemSession.getUserSession(),pro_replace);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 撤销代款——显示页面
	 * @return
	 */
	@RequestMapping(value="/showReplaceDelWHDBPage")
	public ModelAndView showReplaceDelWHDBPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/WHDB/removePay/replaceDel");
		return mv;
	}
	
	/**
	 * 撤销代偿解除申请
	 */
	@RequestMapping(value="/deleteOneReplace")
	@ResponseBody
	public AjaxRes deleteOneReplace(@RequestBody Pro_replace replace){
		AjaxRes ar = new AjaxRes();
		try {
			//删除还款信息
			ar.setSucceed(replaceService.deleteOneReplace(SystemSession.getUserSession(),replace));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 显示页面-查看代偿信息
	 */
	@RequestMapping(value="/showRepalceViewWHDBPage")
	public ModelAndView showRepalceViewWHDBPage(String replace_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_replace replace = null;
		try {
			replace = replaceService.showRepalceViewPage(" and replace_ID='"+replace_ID+"'");
			List<Pro_projectfiles> projectfilesList = loanService.getAttachments(replace.getReplace_ID());
			replace.setProjectfilesList(projectfilesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("replace",replace);
		mv.setViewName("/project/WHDB/removePay/replaceView");
		return mv;
	}
	/**
	 * 代偿解除 审批链接
	 */
	@RequestMapping(value="/showApprovalLink")
	public ModelAndView showApprovalLink(String replace_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_replace replace = null;
		try {
			replace = replaceService.showRepalceViewPage(" and replace_ID='"+replace_ID+"'");
			
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+replace.getProject_ID()+"' ");
			//查询业务/授信申请信息表
			String apply_ID = project.getApply_ID();
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID='"+apply_ID+"' ");
			
			List<Pro_projectfiles> projectfilesList = loanService.getAttachments(replace.getReplace_ID());
			
			replace.setProjectfilesList(projectfilesList);
			
			mv.getModelMap().put("project", project);
			mv.getModelMap().put("apply", apply);
			
			mv.getModelMap().put("replace",replace);
			mv.setViewName("/project/WHDB/removePay/replaceApprovalLink");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
}
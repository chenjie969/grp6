package com.zjm.pro.afterCheck.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.db.model.UrlParam;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Crm_riskLevelRec;
import com.zjm.crm.riskLevel.service.RiskLevelService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.checkPlan.service.CheckPlanService;
import com.zjm.pro.checkReport.service.CheckReportService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_checkPlan;
import com.zjm.pro.db.model.Pro_checkReport;
import com.zjm.pro.db.model.Pro_optGuaranty;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value = "/project/afterCheck")
public class AfterCheckAction {

	@Resource
	private CheckPlanService checkPlanService;
	@Resource
	private CheckReportService checkReportService;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private RiskLevelService riskLevelService;
	@Resource
	private SysDicDataService sysDicDataService;
	@Resource
	private DicTypeService dicTypeService;
	
	@Resource
	private ClientService clientService;
	
	@Resource
	private LogService  logService; // 日志接口
	
	@Resource
	private ProjectfilesService  projectfilesService;
	
	
	/**
	 * @param proCheckPlan
	 * @return 进入保后检查列表
	 */
	@RequestMapping(value = "/selectCheckRegister")
	public ModelAndView selectCheckRegister(UrlParam urlParam) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("urlParam", urlParam);
		mv.setViewName("/project/afterCheck/checkRegister");
		return mv;
	}
	/**
	 * 查询信息 列表
	 */
	@RequestMapping(value = "/selectCheckPlanListPageTables", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectCheckPlanListPageTables(@RequestBody PageTable<Pro_checkPlan> pageTable) {
		try {
			String queryCondition = "and plan.apply_ID='" + pageTable.getQueryCondition().getApply_ID() 
					+ "' and plan.unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"' ";
			List<Pro_checkPlan> list = checkPlanService.selectProCheckPlanPageList(queryCondition);
			//查询人员信息
			List<Map<String, Object>> userList=sysDicDataService.selectDepartsUserTree("");
			for (Pro_checkPlan pro_checkPlan : list) {
				Pro_apply apply  = new Pro_apply();
				String applyID =  pro_checkPlan.getApply_ID();
				if(null != applyID && !"".equals(applyID)){			
					String whereSql = "and apply_ID = \'"+applyID+"\'";
					//根据业务id获取申请明细表信息
					apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
				}
				//查询一条 保后检查报告 信息
				String checkPlan_ID = pro_checkPlan.getCheckPlan_ID();
				Pro_checkReport checkReport = checkReportService.selectOneCheckReportInfo(checkPlan_ID);
				String riskLevelName = null;//原风险等级
				String newRiskLevelName = null;//调整后风险等级
				if(checkReport != null){
					newRiskLevelName = checkReport.getNewRiskLevelName();
					riskLevelName = checkReport.getRiskLevelName();
				}
				
				if(null != riskLevelName){
					pro_checkPlan.setRiskLevelName(riskLevelName);
				}
				if(null != newRiskLevelName){
					pro_checkPlan.setNewRiskLevelName(newRiskLevelName);
				}
				
				for (Map<String, Object> userMap : userList) {
					String OperatorID = pro_checkPlan.getOperatorID();
					if(OperatorID!=null && OperatorID.equals(userMap.get("id"))){
						pro_checkPlan.setOperatorName((String)userMap.get("name"));
					}
				}
				//查询相关附件
				List<Pro_projectfiles> fileList=projectfilesService.selectProFilesListByEntityID(new User(), pro_checkPlan.getCheckPlan_ID());
				pro_checkPlan.setFilesList(fileList);
			}
			pageTable.setRows(list);
			System.out.println(list.size());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 添加信息页面
	 * 
	 */
	@RequestMapping(value = "/selectCheckAddPage")
	public ModelAndView selectCheckAddPage(Pro_checkPlan proCheckPlan) {
		proCheckPlan.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/afterCheck/addCheck");
		mv.getModelMap().put("proCheckPlan", proCheckPlan);
		
		return mv;
	}
	
	/**
	 * 添加信息页面
	 * 
	 */
	@RequestMapping(value = "/selectAfterCheckRegister")
	public ModelAndView selectAfterCheckRegister(String apply_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("apply_ID", apply_ID);
		mv.setViewName("/project/afterCheck/checkRegisterAfter");
		
		return mv;
	}
	
	/**
	 * 插入一个检查计划
	 * 
	 */
	@RequestMapping(value = "/insertOneCheckPlanInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneCheckPlanInfo(@RequestBody Pro_checkPlan proCheckPlan) {
		
		proCheckPlan.setCheckPlan_ID(Tool.createUUID32());
		proCheckPlan.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		proCheckPlan.setCreate_user(SystemSession.getUserSession().getUser_name());
		Boolean b = checkPlanService.insertOneCheckPlan(SystemSession.getUserSession(),proCheckPlan);
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}

	/**
	 * 删除信息页面
	 * 
	 */
	@RequestMapping(value = "/selectCheckDelPage")
	public ModelAndView selectCheckDelPage(Pro_checkPlan proCheckPlan) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/afterCheck/delCheck");
		mv.getModelMap().put("proCheckPlan", proCheckPlan);
		return mv;
	}

	/**
	 * 删除一个信息
	 * 
	 */
	@RequestMapping(value = "/delectOneCheckInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneCheckInfo(@RequestBody Pro_checkPlan proCheckPlan) {

		Boolean boolean1 = checkPlanService.deleteCheckPlansByApplyID(proCheckPlan.getApply_ID());
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(boolean1);
		return ar;
	}
	//----------------------------------检查详情-------------------------------------------------------------------
		/**
		 * 查看检查详情页面
		 */
	
	@RequestMapping(value = "/selectCheckDetailPage")
	public ModelAndView selectCheckDetailPage(String checkPlan_ID,String applyID,String project_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			Pro_apply apply  = new Pro_apply();
			if(null != applyID && !"".equals(applyID)){			
				String whereSql = "and apply_ID = \'"+applyID+"\'";
				//根据业务id获取申请明细表信息
				apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
			}
			Pro_checkReport proCheckReport = checkReportService.selectOneCheckReportInfo(checkPlan_ID);
			if (proCheckReport == null) {
				proCheckReport = new Pro_checkReport();
				proCheckReport.setCheckReport_ID(Tool.createUUID32());
				proCheckReport.setCheckPlan_ID(checkPlan_ID);
				proCheckReport.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
				proCheckReport.setUpdateUserName(SystemSession.getUserSession().getUser_name());
				proCheckReport.setProject_ID(project_ID);
				proCheckReport.setApplyID(applyID);
				checkReportService.insertOneCheckReport(proCheckReport);
			}
			List<C_dictype> riskLevelList = dicTypeService.selectAllDicTypeList(" and dicTypePID='50f858be37284937af4e6a8d3c9bee4b'");
			
			List<C_dictype> checkTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='6e9f258a6c134715a17a919ca46a2eb7'");

			List<C_dictype> newRiskLevelList = dicTypeService.selectAllDicTypeList(" and dicTypePID='50f858be37284937af4e6a8d3c9bee4b'");
			mv.setViewName("/project/afterCheck/addCheck");
			mv.getModelMap().put("newRiskLevelList",newRiskLevelList);
			mv.getModelMap().put("checkTypeList",checkTypeList);
			mv.getModel().put("proCheckReport", proCheckReport);
			mv.getModel().put("apply", apply);
			mv.getModel().put("riskLevelList", riskLevelList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mv;
	}
	/**
	 * @param apply_ID
	 * @return 添加保后检查计划——展示页面
	 */
	@RequestMapping(value = "/showCheckRegisterAddPage")
	public ModelAndView showCheckRegisterAddPage(String apply_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			mv.getModel().put("apply_ID", apply_ID);
			mv.setViewName("/project/afterCheck/checkRegiAdd");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * @param proCheckPlan
	 * @return 添加保后检查计划
	 */
	@RequestMapping(value = "/addOneCheckRegister", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes addOneCheckRegister(@RequestBody Pro_checkPlan proCheckPlan) {
		AjaxRes ar = new AjaxRes();
		try {	
			User user = SystemSession.getUserSession();
			proCheckPlan.setCheckPlan_ID(Tool.createUUID32());
			proCheckPlan.setCreate_user(user.getCreate_user());
			proCheckPlan.setUnit_uid(user.getUnit_uid());
			proCheckPlan.setIsFinish("0");
			
			Boolean b = checkPlanService.insertOneCheckPlan(user,proCheckPlan);
			
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;
	}
	/**
	 * 更新一条检查报告信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updateOneReportInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneReportInfo(@RequestBody Pro_checkReport proCheckReport) {
		AjaxRes ar = new AjaxRes();
		try {	
			proCheckReport.setUpdateUserName(SystemSession.getUserSession().getUser_name());
			//保后检查报告pro_checkReport
			Boolean b = checkReportService.updateOneCheckReportInfo(proCheckReport);
			//保后检查计划表pro_checkPlan
			Pro_checkPlan checkPlan = new Pro_checkPlan();
			checkPlan.setCheckPlan_ID(proCheckReport.getCheckPlan_ID());
			checkPlan.setFactCheckDate(proCheckReport.getCheckdate());
			checkPlan.setOperatorID(proCheckReport.getCheckUserID());
			checkPlan.setCheckContent(proCheckReport.getRiskLevelDesc());
			checkPlan.setIsFinish("1");
			//保后检查计划表pro_checkPlan
			Integer count = checkPlanService.updateOneCheckPlan(checkPlan);
			
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;
	}
	
	/**
	 * @return 自动生成保后计划——页面
	 */
	/*@RequestMapping(value = "/showAutoGenePlanPage")
	public ModelAndView showAutoGenePlanPage() {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			mv.setViewName("/project/afterCheck/autoGenerTip");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mv;
	}*/
	
	/**
	 * @return 自动生成保后计划
	 */
	/*@RequestMapping(value = "/autoGeneAfterPlan", method = RequestMethod.POST)
	public AjaxRes autoGeneAfterPlan(String apply_ID) {
		AjaxRes ar = new AjaxRes();
		try {	
			ar.setSucceed(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}*/
}

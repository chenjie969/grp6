package com.zjm.pro.project.web;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.zjm.common.db.model.UrlParam;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Index;
import com.zjm.gbpm.index.service.IndexService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.costFact.service.CostFactService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.costReturn.service.CostReturnService;
import com.zjm.pro.creditor.service.CreditorService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_cost;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.db.model.Pro_costReturn;
import com.zjm.pro.db.model.Pro_creditor;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_loanPlan;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_meetingResolution;
import com.zjm.pro.db.model.Pro_planPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_projectForProVo;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.db.model.Pro_relationProjectVo;
import com.zjm.pro.db.model.Pro_replace;
import com.zjm.pro.factPay.service.FactPayService;
import com.zjm.pro.finish.service.Pro_finishService;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.pro.planPay.service.PlanPayService;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.pro.replace.service.ReplaceService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;


@Controller
@RequestMapping(value="/project/project")
public class ProjectAction {
	DecimalFormat df = new DecimalFormat("#,###");
	@Resource
	private ProjectService projectService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private IndexService indexService;
	
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private ApplyDetailService applyDetailService;
	@Resource
	private MeetingResolutionService meetingResolutionService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private CostMustService costMustService;//应收
	@Resource
	private CostFactService costFactService;//实收
	@Resource
	private CostPreService costPreService;//预收
	@Resource
	private CostReturnService costReturnService;//退费
	@Resource
	private ProjectfilesService projectfilesService;//附件
	@Resource
	private LoanService loanService;
	@Resource
	private PlanPayService planPayService;
	@Resource
	private CreditorService creditorService;
	@Resource
	private FactPayService factPayService;
	@Resource
	private ReplaceService replaceService;
	@Resource
	private Pro_finishService finishService;
	
	public void  initSelect(ModelAndView mv){
		List<C_dictype> projectSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'");//获取项目(客户)来源下拉框;
		mv.getModelMap().put("projectSourceList",projectSourceList);		
		
		List<C_dictype> busiNatureList = dicTypeService.selectAllDicTypeList(" and dicTypePID='53b3870104de46f99940750515404048'");//获取业务性质下拉框;
		mv.getModelMap().put("busiNatureList",busiNatureList);
		
		List<C_dictype> projectTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='d80f39f02f4a4578aa15bd337062a6fd'");//获取项目类型下拉框;
		mv.getModelMap().put("projectTypeList",projectTypeList);
		
		List<C_dictype> clientTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='2624e18b06c34fdabd0df26d51eca41c'");//获取客户类型下拉框;
		mv.getModelMap().put("clientTypeList",clientTypeList);
		
		List<C_dictype> greenChannelList = dicTypeService.selectAllDicTypeList(" and dicTypePID='70c0e21474174350856987e442c7cd37'");//获取绿色通道下拉框;
		mv.getModelMap().put("greenChannelList",greenChannelList);
		
		
		List<C_dictype> oprationCompanyList = dicTypeService.selectAllDicTypeList(" and dicTypePID='456d03e9cd634a4ab1158492c23510bf'");//获取报送机构下拉框;
		mv.getModelMap().put("oprationCompanyList",oprationCompanyList);
		
		List<C_dictype> guarantyOrgList = dicTypeService.selectAllDicTypeList(" and dicTypePID='78ae83f6524d458dbbd522324c80723d'");//获取承保机构下拉框;
		mv.getModelMap().put("guarantyOrgList",guarantyOrgList);
	
		
		List<C_dictype> attributionList = dicTypeService.selectAllDicTypeList(" and dicTypePID='97fcca5785d14a1e9968db411a524883'");//获取属地划分下拉框;
		mv.getModelMap().put("attributionList",attributionList);
		
		List<C_dictype> hostAreaList = dicTypeService.selectAllDicTypeList(" and dicTypePID='be8ae49cd7b944b6ad20743671f1d964'");//获取承办地下拉框;
		mv.getModelMap().put("hostAreaList",hostAreaList);
		
		List<C_dictype> fundTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='fb51e0117ccf47488f0ccd0e811fec03'");//获取资金方类型下拉框;
		mv.getModelMap().put("fundTypeList",fundTypeList);
		
		List<C_dictype> fundSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='9c153f83aca84d299a2e6733efcc4e82'");//获取资金来源下拉框;
		mv.getModelMap().put("fundSourceList",fundSourceList);
		
		List<C_dictype> finishTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='10090c83ee964159a456b6510ab8faf5'");//获取项目完结方式下拉框;
		mv.getModelMap().put("finishTypeList",finishTypeList);
		
		List<C_dictype> areaTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='97fcca5785d14a1e9968db411a524883'");//获取项目完结方式下拉框;
		mv.getModelMap().put("areaTypeList",areaTypeList);
		
		List<C_dictype> applyTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='7262e0635f4a49dfa4b03a9619ad4c19'");//获取项目完结方式下拉框;
		mv.getModelMap().put("applyTypeList",applyTypeList);
		
		List<C_dictype> interestMethodList = dicTypeService.selectAllDicTypeList(" and dicTypePID='3e11e41344ce41f8930f49ab2fbc1831'");//获取项目结息方式下拉框;
		mv.getModelMap().put("interestMethodList",interestMethodList);
		
	}
	
	
	/**
	 * 跳转到逾期确认页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnProjectOverPage")
	public ModelAndView returnProjectOverPage(String  project_ID,String apply_ID){
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
		mv.setViewName("/project/factPay/projectOver");
		mv.getModel().put("project_ID",project_ID);
		return mv;
	}
	
	
	/**
	 * 
	 * 新增项目逾期;
	 * 
	 */
	@RequestMapping(value="/insertOneProjectOver", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneProjectOver(@RequestBody Pro_project pro_project){
		Boolean b = false;	
		AjaxRes ar=new AjaxRes();
		if( null != pro_project){		
			try {
				b=projectService.insertOneProjectOver(SystemSession.getUserSession(),pro_project);
			} catch (Exception e) {
				e.printStackTrace();
				return ar;
			}
		}
		ar.setSucceed(b);
		return ar;
	}	
	
	
	/**
	 * @description	到期、逾期催收通知函列表---放款列表
	 * @author wuhn
	 * @date 2017年8月25日 下午3:24:22
	 */
	@RequestMapping(value="/selectProjectPageTables")
	@ResponseBody
	public AjaxRes selectProjectPageTables(@RequestBody PageTable<Pro_project>  pageTable){
		AjaxRes  ar =new AjaxRes();
//		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable= projectService.selectProjectPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * @description	到期、逾期催收通知函列表---放款列表
	 * @author wuhn
	 * @date 2017年8月25日 下午3:24:22
	 */
	@RequestMapping(value="/selectProjectPageTablesWD")
	@ResponseBody
	public AjaxRes selectProjectPageTablesWD(@RequestBody PageTable<Pro_project>  pageTable){
		AjaxRes  ar =new AjaxRes();
//		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable= projectService.selectProjectPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * @description	添加保证措施 -- 选择可添加保证措施的项目列表
	 * @author rd_xujy
	 * @date 2018年8月25日 下午3:29:22
	 */
	@RequestMapping(value="/selectProjectAddOptGuarantyPageTable")
	@ResponseBody
	public AjaxRes selectProjectAddOptGuarantyPageTable(@RequestBody PageTable<Pro_project>  pageTable){
		AjaxRes  ar =new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable= projectService.selectProjectPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String createWhereSql(String str){
		StringBuilder sb = new StringBuilder();
		String[] tem = str.split(",");
		for (String s : tem) {
			sb.append("'"+s+"',");
		}
		sb.append("'0'");
		return sb.toString();
	}
	
	private String queryCondition(PageTable<Pro_project> pageTable) {
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByABC(pageTable.getQueryCondition().getUser_uid(), "pp.");
			if( null != sql){
				sb.append(sql);
			}
		} 
		
		sb.append(" and pp.unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		
		//搜索框功能
		
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			sb.append(" and pp.projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		
		//根据申请id(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			sb.append(" and pp.apply_ID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		//根据项目id(project_ID)
		if(pageTable.getQueryCondition().getProject_ID() != null && !"".equals(pageTable.getQueryCondition().getProject_ID())){
			sb.append(" and pp.project_ID = \'"+pageTable.getQueryCondition().getProject_ID()+"\'");
		}
		
		//根据项目名称(projectName)
		if(pageTable.getQueryCondition().getProjectName() != null && !"".equals(pageTable.getQueryCondition().getProjectName())){
			sb.append(" and pp.projectName like \'%"+pageTable.getQueryCondition().getProjectName()+"%\'");
		}
		//根据客户类型ID(clientTypeID)
		if(pageTable.getQueryCondition().getClientTypeID() != null && !"".equals(pageTable.getQueryCondition().getClientTypeID())){
			sb.append(" and pa.clientTypeID = \'"+pageTable.getQueryCondition().getClientTypeID()+"\'");
		}
		//根据客户名称(clientName)
		if(pageTable.getQueryCondition().getClientName() != null && !"".equals(pageTable.getQueryCondition().getClientName())){
			sb.append(" and pa.clientName like \'%"+pageTable.getQueryCondition().getClientName()+"%\'");
		}
		//根据业务品种(busiTypeName)
		if(pageTable.getQueryCondition().getBusiTypeName() != null && !"".equals(pageTable.getQueryCondition().getBusiTypeName())){
			sb.append(" and pp.busiTypeName in ("+createWhereSql(pageTable.getQueryCondition().getBusiTypeName()) +") ");
		}
		//根据业务大类(busiClass：01担保，02委贷)
		if(pageTable.getQueryCondition().getBusiClass() != null && !"".equals(pageTable.getQueryCondition().getBusiClass())){
			sb.append(" and pp.busiClass like \'%"+pageTable.getQueryCondition().getBusiClass()+"%\'");
		}
		//根据项目金额(registerSumStart-registerSumEnd)		
		if(pageTable.getQueryCondition().getLoadSumStart() != null && !"".equals(pageTable.getQueryCondition().getLoadSumStart())){
       		if(pageTable.getQueryCondition().getLoadSumEnd() != null && !"".equals(pageTable.getQueryCondition().getLoadSumEnd())){
       			
       			sb.append(" and pp.loadSum >= "+pageTable.getQueryCondition().getLoadSumStart() +" and pp.loadSum <="+pageTable.getQueryCondition().getLoadSumEnd());
       		}else{
       			sb.append(" and pp.loadSum >="+pageTable.getQueryCondition().getLoadSumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getLoadSumEnd() !=null && !"".equals(pageTable.getQueryCondition().getLoadSumEnd())){
       			sb.append(" and pp.loadSum <="+pageTable.getQueryCondition().getLoadSumEnd());
       		}
       	}
		//根据合作机构ID(bankName)
		
		if(pageTable.getQueryCondition().getBankName() != null && !"".equals(pageTable.getQueryCondition().getBankName())){
			sb.append(" and bankName like \'%"+pageTable.getQueryCondition().getBankName()+"%\'");
		}
		//根据经办部门名称(departName)
//		if(pageTable.getQueryCondition().getDepartName() != null && !"".equals(pageTable.getQueryCondition().getDepartName())){
//			wheresql.append(" and departName = \'"+pageTable.getQueryCondition().getDepartName()+"\'");
//		}
		//根据经办人名(createManName)
//		if(pageTable.getQueryCondition().getCreateManName() != null && !"".equals(pageTable.getQueryCondition().getCreateManName())){
//			wheresql.append(" and createManName like \'%"+pageTable.getQueryCondition().getCreateManName()+"%\'");
//		}
		
		//根据合作子机构查询
		if (pageTable.getQueryCondition().getSubBankName() != null && !"".equals(pageTable.getQueryCondition().getSubBankName())){
			sb.append(" and pp.subBankName like \'%"+pageTable.getQueryCondition().getSubBankName()+"%\'");
		}
		
		//根据在保余额查询
		if(pageTable.getQueryCondition().getGuarantySumStart() != null && !"".equals(pageTable.getQueryCondition().getGuarantySumStart())){
       		if(pageTable.getQueryCondition().getGuarantySumEnd() != null && !"".equals(pageTable.getQueryCondition().getGuarantySumEnd())){
       			
       			sb.append(" and pp.guarantySum >= "+pageTable.getQueryCondition().getGuarantySumStart() +" and pp.guarantySum <="+pageTable.getQueryCondition().getGuarantySumEnd());
       		}else{
       			sb.append(" and pp.guarantySum >="+pageTable.getQueryCondition().getGuarantySumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getGuarantySumEnd() !=null && !"".equals(pageTable.getQueryCondition().getGuarantySumEnd())){
       			sb.append(" and pp.guarantySum <="+pageTable.getQueryCondition().getGuarantySumEnd());
       		}
       	}
		
		//根据展期金额查询
		if(pageTable.getQueryCondition().getDelaySumStart() != null && !"".equals(pageTable.getQueryCondition().getDelaySumStart())){
       		if(pageTable.getQueryCondition().getDelaySumEnd() != null && !"".equals(pageTable.getQueryCondition().getDelaySumEnd())){
       			
       			sb.append(" and pd.delaySum >= "+pageTable.getQueryCondition().getDelaySumStart() +" and pd.delaySum <="+pageTable.getQueryCondition().getDelaySumEnd());
       		}else{
       			sb.append(" and pd.delaySum >="+pageTable.getQueryCondition().getDelaySumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getDelaySumEnd() !=null && !"".equals(pageTable.getQueryCondition().getDelaySumEnd())){
       			sb.append(" and pd.delaySum <="+pageTable.getQueryCondition().getDelaySumEnd());
       		}
       	}
		
		//根据代偿总金额
		if(pageTable.getQueryCondition().getReplaceFreeSumStart() != null && !"".equals(pageTable.getQueryCondition().getReplaceFreeSumStart())){
       		if(pageTable.getQueryCondition().getReplaceFreeSumEnd() != null && !"".equals(pageTable.getQueryCondition().getReplaceFreeSumEnd())){
       			
       			sb.append(" and pr.replaceCapitalSum >= "+pageTable.getQueryCondition().getReplaceFreeSumStart() +" and pr.replaceCapitalSum <="+pageTable.getQueryCondition().getReplaceFreeSumEnd());
       		}else{
       			sb.append(" and pr.replaceCapitalSum >="+pageTable.getQueryCondition().getReplaceFreeSumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getReplaceFreeSumEnd() !=null && !"".equals(pageTable.getQueryCondition().getReplaceFreeSumEnd())){
       			sb.append(" and pr.replaceCapitalSum <="+pageTable.getQueryCondition().getReplaceFreeSumEnd());
       		}
       	}
		
		//追偿日期
		if(null==pageTable.getQueryCondition().getSelectlDateStart()&&null!=pageTable.getQueryCondition().getReplaceDateStart()){
			pageTable.getQueryCondition().setReplaceDateStart(pageTable.getQueryCondition().getReplaceDateStart());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateStart()&&null==pageTable.getQueryCondition().getReplaceDateStart()){
			pageTable.getQueryCondition().setReplaceDateStart(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setReplaceDateStart(new Date());
		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateEnd()&&null!=pageTable.getQueryCondition().getReplaceDateEnd()){
			pageTable.getQueryCondition().setReplaceDateEnd(pageTable.getQueryCondition().getReplaceDateEnd());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateEnd()&&null==pageTable.getQueryCondition().getReplaceDateEnd()){
			pageTable.getQueryCondition().setReplaceDateEnd(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setReplaceDateEnd(new Date());
		}
		
		//根据追偿总金额
		if(pageTable.getQueryCondition().getReturnSumStart() != null && !"".equals(pageTable.getQueryCondition().getReturnSumStart())){
       		if(pageTable.getQueryCondition().getReturnSumEnd() != null && !"".equals(pageTable.getQueryCondition().getReturnSumEnd())){
       			
       			sb.append(" and prd.returnCapitalSum >= "+pageTable.getQueryCondition().getReturnSumStart() +" and prd.returnCapitalSum <="+pageTable.getQueryCondition().getReturnSumEnd());
       		}else{
       			sb.append(" and prd.returnCapitalSum >="+pageTable.getQueryCondition().getReturnSumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getReplaceFreeSumEnd() !=null && !"".equals(pageTable.getQueryCondition().getReturnSumEnd())){
       			sb.append(" and prd.returnCapitalSum <="+pageTable.getQueryCondition().getReturnSumEnd());
       		}
       	}
		
		//是否债权转让
		if (pageTable.getQueryCondition().getIsCreditorMark() != null && !"".equals(pageTable.getQueryCondition().getIsCreditorMark())){
			sb.append(" and pp.isCreditorMark = "+pageTable.getQueryCondition().getIsCreditorMark()+"");
		}
		
		//客户所属系
		if(pageTable.getQueryCondition().getRelationMainName() != null && !"".equals(pageTable.getQueryCondition().getRelationMainName())) {
			sb.append(" and cr.relationMainName like \'%"+pageTable.getQueryCondition().getRelationMainName()+"%\'");
		}
		
		//原债权人，现债权人
		if(pageTable.getQueryCondition().getCreditor() != null && !"".equals(pageTable.getQueryCondition().getCreditor())) {
			sb.append(" and (pp2.clientName like \'%"+pageTable.getQueryCondition().getCreditor()+"\'");
			sb.append(" or pa.clientName like \'%"+pageTable.getQueryCondition().getCreditor()+"%\')");
		}
		
		//债权人数量
		if(pageTable.getQueryCondition().getCreditorCountStart() != null && !"".equals(pageTable.getQueryCondition().getCreditorCountStart())){
       		if(pageTable.getQueryCondition().getCreditorCountEnd() != null && !"".equals(pageTable.getQueryCondition().getCreditorCountEnd())){
       			
       			sb.append(" and pp.creditorCount >= "+pageTable.getQueryCondition().getCreditorCountStart() +" and pp.returnSum <="+pageTable.getQueryCondition().getCreditorCountEnd());
       		}else{
       			sb.append(" and pp.creditorCount >="+pageTable.getQueryCondition().getCreditorCountStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getReplaceFreeSumEnd() !=null && !"".equals(pageTable.getQueryCondition().getCreditorCountEnd())){
       			sb.append(" and pp.creditorCount <="+pageTable.getQueryCondition().getCreditorCountEnd());
       		}
       	}

		//是否是敏感债权人
		if (pageTable.getQueryCondition().getIsCreditor() != null && !"".equals(pageTable.getQueryCondition().getIsCreditor())){
			sb.append(" and pp.isCreditor = "+pageTable.getQueryCondition().getIsCreditor()+"");
		}
		
		//资金来源
		if (pageTable.getQueryCondition().getFundSource() != null && !"".equals(pageTable.getQueryCondition().getFundSource())){
			sb.append(" and pp.fundSource = '"+pageTable.getQueryCondition().getFundSource()+"'");
		}
		
		//申请期限.月天
		if(pageTable.getQueryCondition().getPeriodMonthStart() != null && !"".equals(pageTable.getQueryCondition().getPeriodMonthStart())){
       		if(pageTable.getQueryCondition().getPeriodMonthEnd() != null && !"".equals(pageTable.getQueryCondition().getPeriodMonthEnd())){
       			
       			sb.append(" and pp.periodMonth >= "+pageTable.getQueryCondition().getPeriodMonthStart() +" and pp.periodMonth <="+pageTable.getQueryCondition().getPeriodMonthEnd());
       		}else{
       			sb.append(" and pp.periodMonth >="+pageTable.getQueryCondition().getPeriodMonthStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getPeriodMonthEnd() !=null && !"".equals(pageTable.getQueryCondition().getPeriodMonthEnd())){
       			sb.append(" and pp.periodMonth <="+pageTable.getQueryCondition().getPeriodMonthEnd());
       		}
       	}
		if(pageTable.getQueryCondition().getPeriodDayStart() != null && !"".equals(pageTable.getQueryCondition().getPeriodDayStart())){
       		if(pageTable.getQueryCondition().getPeriodDayEnd() != null && !"".equals(pageTable.getQueryCondition().getPeriodDayEnd())){
       			
       			sb.append(" and pp.periodDay >= "+pageTable.getQueryCondition().getPeriodDayStart() +" and pp.periodDay <="+pageTable.getQueryCondition().getPeriodDayEnd());
       		}else{
       			sb.append(" and pp.periodDay >="+pageTable.getQueryCondition().getPeriodDayStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getPeriodDayEnd() !=null && !"".equals(pageTable.getQueryCondition().getPeriodDayEnd())){
       			sb.append(" and pp.periodDay <="+pageTable.getQueryCondition().getPeriodDayEnd());
       		}
       	}
		
		//根据还款金额查询
		if(pageTable.getQueryCondition().getNormalFreeSumStart() != null && !"".equals(pageTable.getQueryCondition().getNormalFreeSumStart())){
       		if(pageTable.getQueryCondition().getNormalFreeSumEnd() != null && !"".equals(pageTable.getQueryCondition().getNormalFreeSumEnd())){
       			
       			sb.append(" and pf.payCapitalSum >= "+pageTable.getQueryCondition().getNormalFreeSumStart() +" and pf.payCapitalSum <="+pageTable.getQueryCondition().getNormalFreeSumEnd());
       		}else{
       			sb.append(" and pf.payCapitalSum >="+pageTable.getQueryCondition().getNormalFreeSumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getNormalFreeSumEnd() !=null && !"".equals(pageTable.getQueryCondition().getNormalFreeSumEnd())){
       			sb.append(" and pf.payCapitalSum <="+pageTable.getQueryCondition().getNormalFreeSumEnd());
       		}
       	}
		
		//根据还款日期查询
//		if(pageTable.getQueryCondition().getPayDateStart() != null && !"".equals(pageTable.getQueryCondition().getPayDateStart())){
//			String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getPayDateStart());
//			if(pageTable.getQueryCondition().getPayDateEnd() != null && !"".equals(pageTable.getQueryCondition().getPayDateEnd())){
//       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getPayDateEnd());
//       			sb.append(" and pf.payDate  >= \'"+Time1 +"\' and pf.payDate  <=\'"+Time2+"\'");
//       		}else{
//       			sb.append(" and pf.payDate <=\'"+Time1+"\'");
//       		}
//       	}else{
//       		if(pageTable.getQueryCondition().getPayDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getPayDateEnd())){
//       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getPayDateEnd());
//       			sb.append(" and pf.payDate <=\'"+Time2+"\'");
//       		}
//       	}
		
		
		if(null==pageTable.getQueryCondition().getSelectlDateStart()&&null!=pageTable.getQueryCondition().getPayDateStart()){
			pageTable.getQueryCondition().setPayDateStart(pageTable.getQueryCondition().getPayDateStart());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateStart()&&null==pageTable.getQueryCondition().getPayDateStart()){
			pageTable.getQueryCondition().setPayDateStart(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setPayDateStart(new Date());
		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateEnd()&&null!=pageTable.getQueryCondition().getPayDateEnd()){
			pageTable.getQueryCondition().setPayDateEnd(pageTable.getQueryCondition().getPayDateEnd());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateEnd()&&null==pageTable.getQueryCondition().getPayDateEnd()){
			pageTable.getQueryCondition().setPayDateEnd(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setPayDateEnd(new Date());
		}
		
		//根据追偿日期查询
//		if(pageTable.getQueryCondition().getReturnDateStart() != null && !"".equals(pageTable.getQueryCondition().getReturnDateStart())){
//			String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getReturnDateStart());
//			if(pageTable.getQueryCondition().getReturnDateEnd() != null && !"".equals(pageTable.getQueryCondition().getReturnDateEnd())){
//       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getReturnDateEnd());
//       			sb.append(" and pr.returnDate >= \'"+Time1 +"\' and pr.returnDate <=\'"+Time2+"\'");
//       		}else{
//       			sb.append(" and pr.returnDate <=\'"+Time1+"\'");
//       		}
//       	}else{
//       		if(pageTable.getQueryCondition().getReturnDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getReturnDateEnd())){
//           		String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getReturnDateEnd());
//           		sb.append(" and pr.returnDate <=\'"+Time2+"\'");
//       		}
//       	}
		
		if(null==pageTable.getQueryCondition().getSelectlDateStart()&&null!=pageTable.getQueryCondition().getReturnDateStart()){
			pageTable.getQueryCondition().setReturnDateStart(pageTable.getQueryCondition().getReturnDateStart());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateStart()&&null==pageTable.getQueryCondition().getReturnDateStart()){
			pageTable.getQueryCondition().setReturnDateStart(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setReturnDateStart(new Date());
		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateEnd()&&null!=pageTable.getQueryCondition().getReturnDateEnd()){
			pageTable.getQueryCondition().setReturnDateEnd(pageTable.getQueryCondition().getPayDateEnd());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateEnd()&&null==pageTable.getQueryCondition().getReturnDateEnd()){
			pageTable.getQueryCondition().setReturnDateEnd(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setReturnDateEnd(new Date());
		}
		
		//根据转让金额查询
		if(pageTable.getQueryCondition().getCreditorSumStart() != null && !"".equals(pageTable.getQueryCondition().getCreditorSumStart())){
       		if(pageTable.getQueryCondition().getCreditorSumEnd() != null && !"".equals(pageTable.getQueryCondition().getCreditorSumEnd())){
       			sb.append(" and pc.creditor_sum >= "+pageTable.getQueryCondition().getCreditorSumStart() +" and pc.creditor_sum <="+pageTable.getQueryCondition().getCreditorSumEnd());
       		}else{
       			sb.append(" and pc.creditor_sum >="+pageTable.getQueryCondition().getCreditorSumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getCreditorSumEnd() !=null && !"".equals(pageTable.getQueryCondition().getCreditorSumEnd())){
       			sb.append(" and pc.creditor_sum <="+pageTable.getQueryCondition().getCreditorSumEnd());
       		}
       	}
		
		//根据转让日期查询
//		if(pageTable.getQueryCondition().getCreditorDateStart() != null && !"".equals(pageTable.getQueryCondition().getCreditorDateStart())){
//			String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreditorDateStart());
//			if(pageTable.getQueryCondition().getCreditorDateEnd() != null && !"".equals(pageTable.getQueryCondition().getCreditorDateEnd())){
//       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreditorDateEnd());
//       			sb.append(" and pc.creditor_date  >= \'"+Time1 +"\' and pc.creditor_date  <=\'"+Time2+"\'");
//       		}else{
//       			sb.append(" and pc.creditor_date <=\'"+Time1+"\'");
//       		}
//       	}else{
//       		if(pageTable.getQueryCondition().getCreditorDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getCreditorDateEnd())){
//       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreditorDateEnd());
//       			sb.append(" and pc.creditor_date <=\'"+Time2+"\'");
//       		}
//       	}
		
		
		if(null==pageTable.getQueryCondition().getSelectlDateStart()&&null!=pageTable.getQueryCondition().getCreditorDateStart()){
			pageTable.getQueryCondition().setCreditorDateStart(pageTable.getQueryCondition().getCreditorDateStart());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateStart()&&null==pageTable.getQueryCondition().getCreditorDateStart()){
			pageTable.getQueryCondition().setCreditorDateStart(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setCreditorDateStart(new Date());
		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateEnd()&&null!=pageTable.getQueryCondition().getCreditorDateEnd()){
			pageTable.getQueryCondition().setCreditorDateEnd(pageTable.getQueryCondition().getCreditorDateEnd());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateEnd()&&null==pageTable.getQueryCondition().getCreditorDateEnd()){
			pageTable.getQueryCondition().setCreditorDateEnd(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setCreditorDateEnd(new Date());
		}
		
		//根据五级分类查询
		if (pageTable.getQueryCondition().getRiskLevelID() != null && !"".equals(pageTable.getQueryCondition().getRiskLevelID())){
			//sb.append(" and cc.riskLevelName like \'%"+pageTable.getQueryCondition().getRiskLevelID()+"%\'");
			sb.append(" and  \'"+pageTable.getQueryCondition().getRiskLevelID()+"\' like CONCAT(CONCAT('%', cc.riskLevelID), '%')");
		}
		
		
		//根据起始日期(loadBeginDateStart-loadBeginDateEnd)
//		if(pageTable.getQueryCondition().getDelayBeginDateStart() !=null && !"".equals(pageTable.getQueryCondition().getDelayBeginDateStart())){
//       		//输入日期 转换格式
//       		String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getDelayBeginDateStart());
//       		if(pageTable.getQueryCondition().getDelayBeginDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getDelayBeginDateEnd())){
//       			//把输入框日期2转换格式
//       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getDelayBeginDateEnd());
//       			sb.append(" and loadBeginDate >= \'"+Time1 +"\' and loadBeginDate <=\'"+Time2+"\'");
//       		}else{
//       			sb.append(" and loadBeginDate >=\'"+Time1+"\'");
//       		}
//       	}else{
//       		if(pageTable.getQueryCondition().getDelayBeginDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getDelayBeginDateEnd())){
//       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getDelayBeginDateEnd());
//       			sb.append(" and loadBeginDate <=\'"+Time2+"\'");
//       		}
//       	}
		
		if(null==pageTable.getQueryCondition().getSelectlDateStart()&&null!=pageTable.getQueryCondition().getDelayBeginDateStart()){
			pageTable.getQueryCondition().setDelayBeginDateStart(pageTable.getQueryCondition().getDelayBeginDateStart());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateStart()&&null==pageTable.getQueryCondition().getDelayBeginDateStart()){
			pageTable.getQueryCondition().setDelayBeginDateStart(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setDelayBeginDateStart(new Date());
		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateEnd()&&null!=pageTable.getQueryCondition().getDelayBeginDateEnd()){
			pageTable.getQueryCondition().setDelayBeginDateEnd(pageTable.getQueryCondition().getDelayBeginDateEnd());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateEnd()&&null==pageTable.getQueryCondition().getDelayBeginDateEnd()){
			pageTable.getQueryCondition().setDelayBeginDateEnd(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setDelayBeginDateEnd(new Date());
		}
		
		//根据结束日期(createDateStart-createDateEnd)
//		if(pageTable.getQueryCondition().getDelayEndDateStart() !=null && !"".equals(pageTable.getQueryCondition().getDelayEndDateStart())){
//			//输入日期 转换格式
//			String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getDelayEndDateStart());
//			if(pageTable.getQueryCondition().getDelayEndDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getDelayEndDateEnd())){
//				//把输入框日期2转换格式
//				String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getDelayEndDateEnd());
//				sb.append(" and delayEndDate >= \'"+Time1 +"\' and delayEndDate <=\'"+Time2+"\'");
//			}else{
//				sb.append(" and delayEndDate >=\'"+Time1+"\'");
//			}
//		}else{
//			if(pageTable.getQueryCondition().getDelayEndDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getDelayEndDateEnd())){
//				
//				String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getDelayEndDateEnd());
//				sb.append(" and delayEndDate <=\'"+Time2+"\'");
//			}
//		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateStart()&&null!=pageTable.getQueryCondition().getDelayEndDateStart()){
			pageTable.getQueryCondition().setDelayEndDateStart(pageTable.getQueryCondition().getDelayEndDateStart());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateStart()&&null==pageTable.getQueryCondition().getDelayEndDateStart()){
			pageTable.getQueryCondition().setDelayEndDateStart(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setDelayEndDateStart(new Date());
		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateEnd()&&null!=pageTable.getQueryCondition().getDelayEndDateEnd()){
			pageTable.getQueryCondition().setDelayEndDateEnd(pageTable.getQueryCondition().getDelayEndDateEnd());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateEnd()&&null==pageTable.getQueryCondition().getDelayEndDateEnd()){
			pageTable.getQueryCondition().setDelayEndDateEnd(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setDelayEndDateEnd(new Date());
		}
		
		
		
		//根据承保机构查询
		/*if(null != pageTable.getQueryCondition().getGuarantyOrgName() && !"".equals(pageTable.getQueryCondition().getGuarantyOrgName())){
			sb.append(" and pa.guarantyOrgName like \'%"+pageTable.getQueryCondition().getGuarantyOrgName()+"%\' ");
		}*/
		//根据承保机构查询
		if(null != pageTable.getQueryCondition().getGuarantyOrgID() && !"".equals(pageTable.getQueryCondition().getGuarantyOrgID())){
			//sb.append(" and cd.dicTypeName like \'%"+pageTable.getQueryCondition().getGuarantyOrgName()+"%\' ");
			sb.append(" and  \'"+pageTable.getQueryCondition().getGuarantyOrgID()+"\' like CONCAT(CONCAT('%', pa.guarantyOrgID), '%')");
		}
		//根据属地划分
		if(null != pageTable.getQueryCondition().getAttributionsID() && !"".equals(pageTable.getQueryCondition().getAttributionsID())){
			//sb.append(" and pa.attributionName like \'%"+pageTable.getQueryCondition().getAttributionName()+"%\' ");
			sb.append(" and  \'"+pageTable.getQueryCondition().getAttributionsID()+"\' like CONCAT(CONCAT('%', pa.attributionID), '%')");
		}
		//根据报送机构
		if(null != pageTable.getQueryCondition().getOprationCompanysID() && !"".equals(pageTable.getQueryCondition().getOprationCompanysID())){
			//sb.append(" and pa.oprationCompanyName like \'%"+pageTable.getQueryCondition().getOprationCompanyName()+"%\' ");
			sb.append(" and  \'"+pageTable.getQueryCondition().getOprationCompanysID()+"\' like CONCAT(CONCAT('%', pa.oprationCompanyID), '%')");
		}
		//根据承办地区查询
		if(null != pageTable.getQueryCondition().getHostAreasID() && !"".equals(pageTable.getQueryCondition().getHostAreasID())){
			//sb.append(" and pa.hostAreaName like \'%"+pageTable.getQueryCondition().getHostAreaName()+"%\' ");
			sb.append(" and  \'"+pageTable.getQueryCondition().getHostAreasID()+"\' like CONCAT(CONCAT('%', pa.hostAreaID), '%')");
		}
		//根据项目编号
		if(null != pageTable.getQueryCondition().getProjectCode() && !"".equals(pageTable.getQueryCondition().getProjectCode())){
			sb.append(" and pp.projectCode like \'%"+pageTable.getQueryCondition().getProjectCode()+"%\' ");
		}
		//根据a角名字
		if(null != pageTable.getQueryCondition().getAmanName() && !"".equals(pageTable.getQueryCondition().getAmanName())){
			sb.append(" and pp.amanName like \'%"+pageTable.getQueryCondition().getAmanName()+"%\' ");
		}
		//根据b角名字
		if(null != pageTable.getQueryCondition().getBmanName() && !"".equals(pageTable.getQueryCondition().getBmanName())){
			sb.append(" and pp.bmanName like \'%"+pageTable.getQueryCondition().getBmanName()+"%\' ");
		}
		//根据资金方id查询
		/*if(null != pageTable.getQueryCondition().getFundID() && !"".equals(pageTable.getQueryCondition().getFundID())){
			//sb.append(" and pa.fundID like \'%"+pageTable.getQueryCondition().getFundID()+"%\' ");
			sb.append(" and  \'"+pageTable.getQueryCondition().getFundID()+"\' like CONCAT(CONCAT('%', pa.fundID), '%')");
		}*/
		
		//根据资金方类型查询
		if(null != pageTable.getQueryCondition().getFundTypesName() && !"".equals(pageTable.getQueryCondition().getFundTypesName())){
			sb.append(" and  pa.fundType in (\'"+pageTable.getQueryCondition().getFundTypesName()+"\') " );
		}
		
		//根据资金方名称查询
		if(null != pageTable.getQueryCondition().getFundChinese() && !"".equals(pageTable.getQueryCondition().getFundChinese())){
			//sb.append(" and pa.fundID like \'%"+pageTable.getQueryCondition().getFundID()+"%\' ");
			sb.append(" and  pa.fundChinese like \'%"+pageTable.getQueryCondition().getFundChinese()+"%\' ");
		}
		
		//根据资金方名称子机构查询
		if(null != pageTable.getQueryCondition().getFundName() && !"".equals(pageTable.getQueryCondition().getFundName())){
			sb.append(" and  pa.fundName in ("+createWhereSql(pageTable.getQueryCondition().getFundName())+") ");
		}
		
		//根据放款日期
//		if(pageTable.getQueryCondition().getLoanDateStart() !=null && !"".equals(pageTable.getQueryCondition().getLoanDateStart())){
//			//输入日期 转换格式
//			String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getLoanDateStart());
//			if(pageTable.getQueryCondition().getLoanDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getLoanDateEnd())){
//				//把输入框日期2转换格式
//				String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getLoanDateEnd());
//				sb.append(" and pp.loanDate >= \'"+Time1 +"\' and pp.loanDate <=\'"+Time2+"\'");
//			}else{
//				sb.append(" and pp.loanDate >=\'"+Time1+"\'");
//			}
//		}else{
//			if(pageTable.getQueryCondition().getLoanDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getLoanDateEnd())){
//				
//				String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getLoanDateEnd());
//				sb.append(" and pp.loanDate <=\'"+Time2+"\'");
//			}
//		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateStart()&&null!=pageTable.getQueryCondition().getLoanDateStart()){
			pageTable.getQueryCondition().setLoanDateStart(pageTable.getQueryCondition().getLoanDateStart());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateStart()&&null==pageTable.getQueryCondition().getLoanDateStart()){
			pageTable.getQueryCondition().setLoanDateStart(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setLoanDateStart(new Date());
		}
		
		if(null==pageTable.getQueryCondition().getSelectlDateEnd()&&null!=pageTable.getQueryCondition().getLoanDateEnd()){
			pageTable.getQueryCondition().setLoanDateEnd(pageTable.getQueryCondition().getLoanDateEnd());
		}else if(null!=pageTable.getQueryCondition().getSelectlDateEnd()&&null==pageTable.getQueryCondition().getLoanDateEnd()){
			pageTable.getQueryCondition().setLoanDateEnd(pageTable.getQueryCondition().getSelectlDateStart());
		}else{
			pageTable.getQueryCondition().setLoanDateEnd(new Date());
		}
		
		return sb.toString();
	}
	
	/**
	 * 核销损失页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/badProEditPage")
	public ModelAndView badProEditPage(String project_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.getModel().put("project_ID",project_ID);
		mv.setViewName("/project/replacePro/badProEdit");
		return mv;
	}
	
	@RequestMapping(value="/badProInfo")
	public ModelAndView badProInfo(String entityID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.getModel().put("entityID", entityID);
		mv.setViewName("/project/replacePro/replacePros");
		return mv;
	}
	
	/**
	 * 放款复核后, 新增一条保(贷)后信息
	 */
	@RequestMapping(value="/insertOneProjectInfo")
	@ResponseBody
	public AjaxRes insertOneProjectInfo(@RequestBody Pro_project project){
		AjaxRes  ar =new AjaxRes();
		Boolean  b = projectService.insertOneProjectInfo(SystemSession.getUserSession(),project);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 
	 * 核销损失;
	 * 
	 */
	@RequestMapping(value="/updateProjectBadInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateProjectBadInfo(@RequestBody Pro_project pro_project){
		Boolean b = true;	
		AjaxRes ar=new AjaxRes();
		if(pro_project  != null){		
			try {
				b=projectService.updateOneProjectInfo(SystemSession.getUserSession(),pro_project);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ar;
		}
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 显示提前到期页面
	 */
	@RequestMapping(value="/showBeforeEndPage")
	public ModelAndView showBeforeEndPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/beforeEnd/beforeEnd");
		mv.getModelMap().put("apply_ID", urlParam.getEntityID());
		return mv;
	}
	
	/**
	 * 显示提前到期确认添加页面
	 */
	@RequestMapping(value="/showBeforeEndAddPage")
	public ModelAndView showBeforeEndAddPage(Pro_project project){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/beforeEnd/beforeEndAdd");
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = '"+project.getProject_ID()+"'");
		mv.getModelMap().put("project", project);
		return mv;
	}
	
	/**
	 * 更新放款提前到期信息
	 */
	@RequestMapping(value="/updateBeforeEndInfo")
	@ResponseBody
	public AjaxRes updateBeforeEndInfo(@RequestBody Pro_project project){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(projectService.updateBeforeEndInfo(SystemSession.getUserSession(), project));
		return ar;
	}
	
	
	/**
	 * 保后跟踪修改页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/returnProjectAfterEditPage")
	public ModelAndView returnProjectAfterEditPage(Pro_project pro_project){
		 ModelAndView mv = CustomDispatchServlet.getModeAndView();
		 Pro_project project=new Pro_project();
		Pro_apply apply = new Pro_apply();
		Pro_applyDetail applyDetail  = new Pro_applyDetail();
		try {
			project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+pro_project.getProject_ID()+"\'");
			if(null != project){
				if(null == project.getPeriodDay()){
					project.setPeriodDay(0);
				}
			} 
			apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+pro_project.getApply_ID()+"\'");
			
			applyDetail = applyDetailService.selectOneApplyDetailByWhereSql(" and applyDetail_ID = \'"+project.getApplyDetail_ID()+"\'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		  initSelect(mv);//获取下拉框
		 mv.getModelMap().put("apply",apply);
		 mv.getModelMap().put("applyDetail",applyDetail);
		 mv.getModelMap().put("project",project);
		 
		 if("02".equals(project.getBusiClass())) {
			 //获取委贷资金方类型
			 List<C_dictype> fundTypeList = dicTypeService.selectAllDicTypeList(" and dicTypeID='41035961f6674ebcb34139c0e68bbe83'");//获取资金方类型下拉框;
			 mv.getModelMap().put("fundTypeList",fundTypeList);
			 mv.setViewName("/project/apply/projectAfterEntrustEdit");
		 } else {
			 mv.setViewName("/project/apply/projectAfterEdit");
		 }
		 return mv;		
	}
	/**
	 * 保后跟踪修改
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/updateProjectAfter", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateProjectApply(@RequestBody Pro_project pro_project){
		Boolean b = false;	
		if(pro_project  != null){	
		try {
			pro_project.setDelayBeginDate(pro_project.getLoadBeginDate());
			pro_project.setDelayEndDate(pro_project.getLoadEndDate());
			pro_project.setGuarantorsName(pro_project.getGuarantyOrgName());
//			pro_project.setPeriodMonthDay(getMonthDayByMonthAndDay(pro_project.getPeriodMonth(),pro_project.getPeriodDay()));
			//更新再保余额
			pro_project.setGuarantySum(getGuarantySumByProject(pro_project));
			b = projectService.updateOneProjectAfter(SystemSession.getUserSession(),pro_project);
//			b1 = projectService.updateOneProjectInfo(SystemSession.getUserSession(), pro_project);
//		    b2 =  projectApplyService.updateOneApplyByApply_ID(SystemSession.getUserSession(), pro_project);
//		    b3 = applyDetailService.updateOneApplyDetailByApplyDetail_ID(SystemSession.getUserSession(), pro_project);	 
				 
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	//通过期限年和月获取年月
	public String getMonthDayByMonthAndDay(Integer periodMonth,Integer periodDay){
		String periodMonthDay = "";
		if(periodMonth!=null && periodMonth != 0){
			periodMonthDay +=periodMonth+"个月";
		}
		if(periodDay!=null && periodDay != 0){	
			periodMonthDay +=periodDay+"天";					
		}
		return periodMonthDay.toString();
	}
	
	
	/**
	 * 保后跟踪高级查询
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/projectAfterSelectPage")
	public ModelAndView projectAfterSelectPage(Pro_project pro_project){
		 ModelAndView mv = CustomDispatchServlet.getModeAndView();
//		 Pro_project project=new Pro_project();
//		Pro_apply apply = new Pro_apply();
//		try {
//			project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+pro_project.getProject_ID()+"\'");
//			 apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+pro_project.getApply_ID()+"\'");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		  initSelect(mv);//获取下拉框
//		 mv.getModelMap().put("apply",apply);
//		 mv.getModelMap().put("project",project);
		 mv.setViewName("/project/apply/projectAfterSelect");
		return mv;		
	}
	
	@RequestMapping(value="/projectAfterSelectOutPage")
	public ModelAndView projectAfterSelectOutPage(Pro_project pro_project){
		 ModelAndView mv = CustomDispatchServlet.getModeAndView();
		 mv.setViewName("/project/apply/projectAfterOutSelect");
		return mv;		
	}
	
	/**
	 * 保后跟踪新增保后项目页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/returnProjectAfterAddPage")
	public ModelAndView returnProjectAfterAddPage(String projectType){
		 ModelAndView mv = CustomDispatchServlet.getModeAndView();
		 initSelect(mv);//获取下拉框
		 if("委贷".equals(projectType)){
			 mv.getModelMap().put("busiClass", "02");
			 //获取委贷资金方类型
			 List<C_dictype> fundTypeList = dicTypeService.selectAllDicTypeList(" and dicTypeID='41035961f6674ebcb34139c0e68bbe83'");//获取资金方类型下拉框;
			 mv.getModelMap().put("fundTypeList",fundTypeList);
			 mv.setViewName("/project/apply/projectAfterEntrustAdd");
		 } else {
			 mv.getModelMap().put("busiClass", "01");
			 mv.setViewName("/project/apply/projectAfterAdd");
		 }
		 return mv;		
	}
	
	/**
	 * 新增保后项目
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/insertOneProjectAfter", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneProjectAfter(@RequestBody Pro_project pro_project){
		Boolean b = false;	
		Boolean b1 = false;	
		if(pro_project  != null){	
		try {
			
			b1 = projectService.insertOneProjectAfter(SystemSession.getUserSession(), pro_project);
		   // b2 =  projectApplyService.updateOneApplyByApply_ID(SystemSession.getUserSession(), pro_project);
		   // b3 = applyDetailService.updateOneApplyDetailByApplyDetail_ID(SystemSession.getUserSession(), pro_project);	 
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}		
		if(b1){
			b=true;
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 打开债权页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/projectCreditorPage")
	public ModelAndView projectCreditorPage(String project_ID){
//		ModelAndView mv = CustomDispatc	hServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		Pro_apply apply = new Pro_apply(); // 还款页面中的放款机构数据抽取为资金方数据
		apply = projectApplyService.selectOneApplyByWhereSql("and apply_ID = \'"+project.getApply_ID()+"\' ");
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("apply", apply);
		initSelect(mv);//获取下拉框
		mv.getModelMap().put("project",project);
//		mv.setViewName("/project/apply/projectAfterAdd");
		mv.setViewName("/project/apply/projectCreditor");
		return mv;		
	}
	
	
	/**
	 * 跳转债权分页列表
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/showProjectCreditorPageTables", method=RequestMethod.POST)
	public ModelAndView  showProjectCreditorPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/creditor/projectCreditorPageTables");
		return mv;		
	}
	
	/**
	 * 债权分页列表
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/selectProjectCreditorPageTables", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes  selectProjectCreditorPageTables(@RequestBody PageTable<Pro_creditor>  pageTable){
		AjaxRes  ar =new AjaxRes();
	
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		String queryCondition = queryProjectCreditorCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable= creditorService.selectProjectCreditorPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryProjectCreditorCondition(PageTable<Pro_creditor>  pageTable) {
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			sb.append(" and pa.projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		//根据申请ID(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			sb.append(" and pc.apply_id = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		return sb.toString();
	}
	
	/**
	 * 新增债权
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/insertOneProjectCreditor", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneProjectCreditor(@RequestBody Pro_creditor pro_creditor){
		Boolean b = false;	
		Boolean b1 = false;	
		if(pro_creditor  != null){	
			try {
				b1 = creditorService.insertOneCreditorInfoByApplyInfo(SystemSession.getUserSession(),pro_creditor);
			} catch (Exception e) {
					e.printStackTrace();
			}		   
		}		
		if(b1){
			b=true;
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 跳转到债权修改页面
	 * @param project_ID
	 * returnProjectDelayEditPage
	 * @return
	 */
	@RequestMapping(value="/returnProjectCreditorEditPage")
	public ModelAndView returnProjectCreditorEditPage(Pro_creditor pro_creditor){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_creditor  creditor = new Pro_creditor();
		if(null != pro_creditor){
			//根据delay_ID获取展期信息;
			creditor = creditorService.selectOneCreditorByWhereSql(" and creditor_id= \'"+pro_creditor.getCreditorId()+"\'");
		}
		mv.getModel().put("creditor",creditor);
		mv.setViewName("/project/apply/projectCreditorEdit");
		return mv;
	}
	
	/**
	 * 删除一个债权表信息
	 * @param Pro_delay delay
	 * @return
	 */
	@RequestMapping(value="/delOneCreditorEdit", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOneCreditorEdit(@RequestBody Pro_creditor  pro_creditor){
		Boolean b= creditorService.deleteCreditorByWhereSql(" and creditor_id= \'"+pro_creditor.getCreditorId()+"\'");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 打开退费页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/projectCostReturnPage")
	public ModelAndView projectCostReturnPage(String project_ID){
//		ModelAndView mv = CustomDispatc	hServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		Pro_apply apply = new Pro_apply(); // 还款页面中的放款机构数据抽取为资金方数据
		apply = projectApplyService.selectOneApplyByWhereSql("and apply_ID = \'"+project.getApply_ID()+"\' ");
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
//		List<Pro_costReturn> costReturns = costReturnService.selectCostReturnListByWhereSql("and apply_ID = \'"+project.getApply_ID()+"\' ");
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("apply", apply);
		initSelect(mv);//获取下拉框
		mv.getModelMap().put("project",project);
		mv.getModelMap().put("costTypeList",costTypeList);
		mv.setViewName("/project/apply/projectCostReturn");
		return mv;		
	}
	
	/**
	 * 打开退保证金页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/projectReturnOptSumPage")
	public ModelAndView projectReturnOptSumPage(String apply_ID){
		Pro_apply apply = new Pro_apply(); // 还款页面中的放款机构数据抽取为资金方数据
		apply = projectApplyService.selectOneApplyByWhereSql("and apply_ID = \'"+apply_ID+"\' ");
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and apply_ID = \'"+apply.getApply_ID()+"\'");
		
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
//		List<Pro_costReturn> costReturns = costReturnService.selectCostReturnListByWhereSql("and apply_ID = \'"+project.getApply_ID()+"\' ");
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("apply", apply);
		initSelect(mv);//获取下拉框
		mv.getModelMap().put("project",project);
		mv.getModelMap().put("costTypeList",costTypeList);
		mv.setViewName("/project/opt/optManager/projectCostReturn");
		return mv;		
	}
	
	/**
	 * 打开还款登记页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/openFactPayRegisterPage")
	public ModelAndView openFactPayRegisterPage(String project_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		mv.getModelMap().put("project",project);
		Pro_apply apply = new Pro_apply(); // 还款页面中的放款机构数据抽取为资金方数据
		apply = projectApplyService.selectOneApplyByWhereSql("and apply_ID = \'"+project.getApply_ID()+"\' ");
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/project/apply/factPayRegister");
		return mv;		
	}
	
	
	/**
	 * 打开展期页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/openProjectDelayPage")
	public ModelAndView openProjectDelayPage(String project_ID, String comming){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		Pro_apply apply = new Pro_apply();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		if(project != null) {
			apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+project.getApply_ID()+"\'");
		}
		mv.getModelMap().put("apply", apply);
		mv.getModelMap().put("project",project);
		if(null != comming && "projectDetail".equals(comming)){
			mv.getModelMap().put("comming", comming);
			mv.setViewName("/project/apply/projectDetailProjectDelay");
		} else {
			mv.setViewName("/project/apply/projectDelayRegister");
		}
		return mv;		
	}
	/**
	 * 逾期确认页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/openProjectOverRegisterPage")
	public ModelAndView openProjectOverRegisterPage(String project_ID ,String comming){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		Pro_apply apply = new Pro_apply();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		mv.getModelMap().put("project",project);
		if (project != null) {
			apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+project.getApply_ID()+"\'");
		}
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/project/apply/projectOverRegister");
		
		if( null != comming && "projectDetail".equals(comming)){//项目详情跳转到项目详情页面
			mv.getModelMap().put("comming",comming);
			mv.setViewName("/project/apply/projectOverInfo");
		}
		return mv;		
	}
	/**
	 * 代偿与追偿页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/openProjectReplaceAndReturnPage")
	public ModelAndView openProjectReplaceAndReturnPage(String project_ID ,String comming){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		mv.getModelMap().put("project",project);
		mv.setViewName("/project/apply/projectReplaceAndReturn");
		if( null != comming && "projectDetail".equals(comming)){
			mv.setViewName("/project/apply/projectReplaceAndReturnInfo");
		}
		return mv;		
	}
	
	/***********************************以下是还款与代偿*********************************/
	
	/**
	 * 还款与代偿详情
	 */
	@RequestMapping(value="/showReimAndCompen")
	public ModelAndView showReimAndCompen(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/apply/dutyRemove/reimAndCompen");
		return mv;		
	}
	
	/**
	 * @description	还款与代偿列表
	 * @author wzk
	 */
	@RequestMapping(value="/selectReimAndCompenPage")
	@ResponseBody
	public AjaxRes selectReimAndCompenPage(@RequestBody PageTable<Pro_project>  pageTable){
		AjaxRes  ar =new AjaxRes();
		
		String queryCondition = queryReimAndCompenCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable= projectService.selectDutyRemovePage(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryReimAndCompenCondition(PageTable<Pro_project> pageTable) {
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		String apply_ID = pageTable.getQueryCondition().getApply_ID();
		//sb.append(" and pp.unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		sb.append(" and pp.unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		if(null !=apply_ID){
			sb.append(" and pp.apply_ID= \'"+apply_ID+"\'");
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			sb.append(" and pp.projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return sb.toString();
	}
	
	/**
	 * 还款与代偿详情
	 */
	@RequestMapping(value="/viewReimAndCompenInfo")
	public ModelAndView viewReimAndCompenInfo(String project_ID,String type ,String comming){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		mv.getModelMap().put("project",project);
		mv.getModelMap().put("type",type);
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+project.getApply_ID()+"\'");
		mv.getModelMap().put("apply", apply);
		mv.setViewName("/project/apply/dutyRemove/reimAndCompenDetial");
		if( null != comming && "projectDetail".equals(comming)){
			mv.setViewName("/project/apply/dutyRemove/reimDetailInfo");
		}
		return mv;		
	}
	
	/**
	 * 还款与代偿详情
	 */
	@RequestMapping(value="/dutyReleaseModal")
	public ModelAndView dutyReleaseModal(String project_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		List<C_dictype> freeMethodList = dicTypeService.selectAllDicTypeList(" and dicTypePID='96190ce8289940319e0ffc699b9eb44a'");//获取担保责任解除方式下拉框;
		List<C_dictype> freeTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='9df927d50f8a48b9b6bcf313f5551530'");//获取担保责任解除类型下拉框;
		
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		
		mv.getModelMap().put("freeMethodList",freeMethodList);
		mv.getModelMap().put("freeTypeList",freeTypeList);
		mv.getModelMap().put("project",project);
		mv.setViewName("/project/apply/dutyRemove/dutyReleaseModal");
		return mv;		
	}
	/**
	 * 责任解除确认
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/updateDutyRemove")
	@ResponseBody
	public AjaxRes updateDutyRemove(@RequestBody Pro_project pro_project){
		Boolean b = false;	
		if(pro_project.getFreeMethodID() != null){
			try {
				b = projectService.updateDutyRemove(SystemSession.getUserSession(), pro_project);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}else{
			b = true;
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 跳转到逾期确认页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/projectAfterTrackingPage")
	public ModelAndView projectAfterTrackingPage(String  project_ID,String apply_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Index indexData = new Index();
		indexData = indexService.selectProData(SystemSession.getUserSession());
		mv.getModel().put("indexData",indexData);
		mv.setViewName("/project/apply/projectAfterTracking");
		return mv;
	}
	
	/**
	 * 打开项目完结页面
	 * project_ID
	 * @return
	 */
	@RequestMapping(value="/openProjectFinish")
	public ModelAndView openProjectFinish(String project_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		mv.getModelMap().put("project",project);
		mv.setViewName("/project/projectFinish/projectFinishRegister");
		initSelect(mv);
		if ("02".equals(project.getBusiClass())) {
			List<C_dictype> finishTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='fb05e09103d541ef86c2c51e3c6b7f62'");//获取委贷项目完结方式下拉框;
			mv.getModelMap().put("finishTypeList",finishTypeList);
		}
		return mv;		
	}
	
	/**
	 * 核销损失
	 * @param  project_ID
	 * @return
	 */
	@RequestMapping(value="/projectFinishLoss", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes projectFinishLoss(@RequestBody Pro_project pro_project){
		Boolean b = false;
		AjaxRes ar=new AjaxRes();
		try {
			b= projectService.projectFinishLoss(SystemSession.getUserSession(),pro_project);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
    /**
     * 项目完结
     * @param pro_project
     * @return
     */
	@RequestMapping(value="/projectFinishRegister", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes projectFinishRegister(@RequestBody Pro_project pro_project){
		Boolean b = false;
		AjaxRes ar=new AjaxRes();
		try {
			b= projectService.projectFinishRegister(SystemSession.getUserSession(),pro_project);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	
	
	
	/**
	 * 显示页面-所有项目的信息
	 */
	@RequestMapping(value="/showMultiProjectPageTable")
	public ModelAndView showMultiProjectPageTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/riskResponse/keyProject/keyProject");
		return mv;
	}
	
	
	
	/**
	 * 显示高级查询页面
	 */
	@RequestMapping(value="/openApplySelectPage")
	public ModelAndView openApplySelectPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		initSelect(mv);//获取下拉框
		mv.setViewName("/project/riskResponse/keyProject/hightSelectkeyProject");
		return mv;
	}
	
	
	/**
	 * 查询所有重点项目的信息列表
	 */
	@RequestMapping(value="/selectMultiProjectPageTable")
	@ResponseBody
	public AjaxRes selectMultiProjectPageTable(@RequestBody PageTable<Pro_projectForProVo> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and projectTypeID!='504eb19d1e4440deb70934ee195c559e'");
		if ( null != pageTable.getQueryCondition().getProjectName()&&""!=pageTable.getQueryCondition().getProjectName()) {
			wheresql.append(" and cr.projectTypeName like \'%"+pageTable.getQueryCondition().getProjectName()+"%\'");
		}
		if(null != pageTable.getQueryCondition().getRelationMainName()&&""!=pageTable.getQueryCondition().getRelationMainName()){
			wheresql.append(" and cr.relationMainName LIKE \'%"+pageTable.getQueryCondition().getRelationMainName()+"%\'");
		}
		if(null != pageTable.getQueryCondition().getFullAreaName()&&""!=pageTable.getQueryCondition().getFullAreaName()){
			wheresql.append(" and cc.fullAreaName LIKE \'%"+pageTable.getQueryCondition().getFullAreaName()+"%\'");
		}
		if(null != pageTable.getSearchText() && !"".equals(pageTable.getSearchText()) ){
			wheresql.append(" and cr.relationMainName LIKE \'%"+pageTable.getSearchText()+"%\'");
		}
		pageTable.setWheresql(wheresql.toString());
		pageTable = projectService.selectMultiProjectPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**重点项目的信息列表 高级查询
	 * @param pageTable
	 * @return
	 */
	private String queryConditionForRelationPro(PageTable<Pro_projectForProVo> pageTable){
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		
		sb.append(" and projectTypeID!='504eb19d1e4440deb70934ee195c559e'");
		if ( null != pageTable.getSearchText()) {
			sb.append(" and (cr.projectTypeName like \'%"+pageTable.getSearchText().trim()+"%\' OR cr.relationMainName LIKE \'%"+pageTable.getSearchText().trim()+"%\' OR cc.fullAreaName LIKE \'%"+pageTable.getSearchText().trim()+"%\')");
		}
		
		//根据项目类型
		if( null != pageTable.getQueryCondition().getProjectTypeName() && !"".equals(pageTable.getQueryCondition().getProjectTypeName())){
			sb.append(" and cr.projectTypeName like \'%"+pageTable.getQueryCondition().getProjectTypeName()+"%\' ");
		}
		//根据关联系
		if( null != pageTable.getQueryCondition().getRelationMainName() && !"".equals(pageTable.getQueryCondition().getRelationMainName())){
			sb.append(" and cr.relationMainName like \'%"+pageTable.getQueryCondition().getRelationMainName()+"%\' ");
		}
		//根据所属区域
		if( null != pageTable.getQueryCondition().getFullAreaName() && !"".equals(pageTable.getQueryCondition().getFullAreaName())){
			sb.append(" and cc.fullAreaName like \'%"+pageTable.getQueryCondition().getFullAreaName()+"%\' ");
		}
		
		return sb.toString();
	}
	
	/**
	 * 查询某关联系下的所有项目
	 */
	@RequestMapping(value="/selectRelationProjectTable")
	@ResponseBody
	public AjaxRes selectRelationProjectTable(@RequestBody PageTable<Pro_relationProjectVo> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and cr.relationMain_ID='"+pageTable.getQueryCondition().getRelationMain_ID()+"'");
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and (pp.projectName like \'%"+pageTable.getSearchText().trim()+"%\' OR pp.projectCode LIKE \'%"+pageTable.getSearchText().trim()+"%\' OR pp.amanName LIKE \'%"+pageTable.getSearchText().trim()+"%\' OR pp.bmanName LIKE \'%"+pageTable.getSearchText().trim()+"%\')");
		}
		
		pageTable.setWheresql(wheresql.toString());
		pageTable = projectService.selectRelationProjectTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	
	
	/**
	 * 查询某关联系下的所有关联企业及项目信息
	 */
	@RequestMapping(value="/selectRelationClientProTable")
	@ResponseBody
	public AjaxRes selectRelationClientProTable(@RequestBody PageTable<Pro_project> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and cr.relationMain_ID=\'"+pageTable.getQueryCondition().getRelationMain_ID()+"\'");
		wheresql.append(" and pp.isCreditorAll!=1");
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and pp.projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		pageTable.setWheresql(wheresql.toString());
		pageTable = projectService.selectRelationClientProTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	/****************************************************************************************************/
	/*********************************以下是放款复核（单笔）*************************************/
	/****************************************************************************************************/
	
	/**
     * @param urlParam
     * @return 查询放款复核信息（单笔）
     */
    @RequestMapping(value="/selectSingleLoanReview")
	public ModelAndView selectSingleLoanReview(UrlParam urlParam ,String comming){
    	List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try{
			String apply_ID = null;
			if (urlParam != null){
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'"+apply_ID+"\'"+ " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			
			//项目详情
			Pro_project project = projectService.selectOneProjectInfoByWheresql(whereSql);
			mv.getModelMap().put("project", project);
			
			//查看  评审会决议表
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			if (meetingResolution != null) {
				//查看  评审会产品明细信息
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"' ");
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String condition = " and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"' ";
					//保后（贷后）产品放款信息
					List<Pro_project> projectList = projectService.selectProjectListByWheresql(condition);
					for (Pro_project pro_project : projectList) {
						List<Pro_projectfiles> projectfilesList = projectfilesService.selectProFilesListByEntityID(SystemSession.getUserSession(), pro_project.getProject_ID());
						pro_project.setProjectfilesList(projectfilesList);
					}
					//获取费用类别
					List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
					//应收
					//List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(condition);
					//实收
					//List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(condition);
					//预收
					//List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresql(condition);
					//退费
					//List<Pro_costReturn> costReturnList = costReturnService.selectCostReturnListByWhereSql(condition);
					//应收 
					String condition1 = " and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"' group by costTypeID,costName";
					List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresqlGroup(condition1);
					String condition2 = " and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"' group by costTypeID,costTypeName";
					//实收
					List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSqlGroup(condition2);
					//预收
					List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresqlGroup(condition2);
					//退费
					List<Pro_costReturn> costReturnList = costReturnService.selectCostReturnListByWhereSqlGroup(condition2);
					
					// Pro_cost为冗余实体类
					List<Pro_cost> costList = new ArrayList<Pro_cost>();
					
					Double agreeSum = meetingDetail.getAgreeSum();
					String agreeSum1 = "0万元";
					if(agreeSum != null){
						agreeSum1 = df.format(agreeSum.doubleValue())+"万元";
					}
					String loanAgreeSum	= meetingDetail.getBusiTypeName()+agreeSum1;
					
					for (C_dictype costType : costTypeList) {
						String dicTypeName = costType.getDicTypeName(); //费用类型名称
						//String dicTypeID = costType.getDicTypeID(); //费用类型ID
						Pro_cost cost = new Pro_cost(); // Pro_cost为冗余实体类
						
						cost.setCostTypeName(dicTypeName);
						cost.setLoanAgreeSum(loanAgreeSum);
						for (Pro_costMust costMust : costMustList) {
							//String costTypeID = costMust.getCostTypeID();//	费用类型ID
							String costTypeName	= costMust.getCostName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setMustCostSum(costMust.getMustCostSum());
							}
						}
						for (Pro_costFact costFact : costFactList) {
							//String costTypeID = costFact.getCostTypeID(); //	费用类型ID
							String costTypeName	= costFact.getCostTypeName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setFactCostSum(costFact.getFactCostSum());
							}
						}
						for (Pro_costPre costPre : costPreList) {
							//String costTypeID = costPre.getCostTypeID(); //	费用类型ID
							String costTypeName	= costPre.getCostTypeName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setPreCostSum(costPre.getPreCostSum());
							}
						}
						for (Pro_costReturn costReturn : costReturnList) {
							//String costTypeID = costReturn.getCostTypeID(); //	费用类型ID
							String costTypeName	= costReturn.getCostTypeName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setReturnCostSum(costReturn.getReturnCostSum());
							}
						}
						costList.add(cost);
					}
					// Pro_cost为冗余实体类
					List<Pro_cost> costList1 = new ArrayList<Pro_cost>();
					for (Pro_cost cost : costList) {
						Pro_cost cost1 = new Pro_cost();
						if(cost.getFactCostSum() !=null || cost.getMustCostSum()!=null || cost.getPreCostSum()!=null || cost.getReturnCostSum()!=null){
							cost1=cost;
							costList1.add(cost1);
						}
					}
					
					meetingDetail.setCostList(costList1);
					meetingDetail.setProjectList(projectList);
				}
			}
			
			mv.getModelMap().put("meetingDetailList",meetingDetailList);
			mv.getModelMap().put("urlParam",urlParam);
			mv.getModelMap().put("comming", comming);
			mv.setViewName("/project/loan/singleLoanReview/singleLoanReview");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    
    /**手机App放款复核事项查看
     * @param urlParam
     * @return 查询放款复核信息（单笔）
     */
    @RequestMapping(value="/selectSingleLoanReviewApp")
    @ResponseBody
	public AjaxRes selectSingleLoanReviewApp(@RequestBody UrlParam urlParam){
    	List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
    	AjaxRes ar = new AjaxRes();
		try{
			String apply_ID = null;
			if (urlParam != null){
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'"+apply_ID+"\'"+ " and unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			//查看  评审会决议表
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			if (meetingResolution != null) {
				//查看  评审会产品明细信息
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(" and meetingResolution_ID='"+meetingResolution.getMeetingResolution_ID()+"' ");
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String condition = " and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"' ";
					//保后（贷后）产品放款信息
					List<Pro_project> projectList = projectService.selectProjectListByWheresql(condition);
					for (Pro_project pro_project : projectList) {
						List<Pro_projectfiles> projectfilesList = projectfilesService.selectProFilesListByEntityID(SystemSession.getUserSession(), pro_project.getProject_ID());
						pro_project.setProjectfilesList(projectfilesList);
					}
					//获取费用类别
					List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
					//应收
					//List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(condition);
					//实收
					//List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(condition);
					//预收
					//List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresql(condition);
					//退费
					//List<Pro_costReturn> costReturnList = costReturnService.selectCostReturnListByWhereSql(condition);
					//应收 
					String condition1 = " and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"' group by costTypeID,costName";
					List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresqlGroup(condition1);
					String condition2 = " and meetingDetail_ID='"+meetingDetail.getMeetingDetail_ID()+"' group by costTypeID,costTypeName";
					//实收
					List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSqlGroup(condition2);
					//预收
					List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresqlGroup(condition2);
					//退费
					List<Pro_costReturn> costReturnList = costReturnService.selectCostReturnListByWhereSqlGroup(condition2);
					
					// Pro_cost为冗余实体类
					List<Pro_cost> costList = new ArrayList<Pro_cost>();
					
					Double agreeSum = meetingDetail.getAgreeSum();
					String agreeSum1 = "0万元";
					if(agreeSum != null){
						agreeSum1 = df.format(agreeSum.doubleValue())+"万元";
					}
					String loanAgreeSum	= meetingDetail.getBusiTypeName()+agreeSum1;
					
					for (C_dictype costType : costTypeList) {
						String dicTypeName = costType.getDicTypeName(); //费用类型名称
						//String dicTypeID = costType.getDicTypeID(); //费用类型ID
						Pro_cost cost = new Pro_cost(); // Pro_cost为冗余实体类
						
						cost.setCostTypeName(dicTypeName);
						cost.setLoanAgreeSum(loanAgreeSum);
						for (Pro_costMust costMust : costMustList) {
							//String costTypeID = costMust.getCostTypeID();//	费用类型ID
							String costTypeName	= costMust.getCostName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setMustCostSum(costMust.getMustCostSum());
							}
						}
						for (Pro_costFact costFact : costFactList) {
							//String costTypeID = costFact.getCostTypeID(); //	费用类型ID
							String costTypeName	= costFact.getCostTypeName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setFactCostSum(costFact.getFactCostSum());
							}
						}
						for (Pro_costPre costPre : costPreList) {
							//String costTypeID = costPre.getCostTypeID(); //	费用类型ID
							String costTypeName	= costPre.getCostTypeName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setPreCostSum(costPre.getPreCostSum());
							}
						}
						for (Pro_costReturn costReturn : costReturnList) {
							//String costTypeID = costReturn.getCostTypeID(); //	费用类型ID
							String costTypeName	= costReturn.getCostTypeName(); // 费用类型名称
							if(dicTypeName.equals(costTypeName)){
								cost.setReturnCostSum(costReturn.getReturnCostSum());
							}
						}
						costList.add(cost);
					}
					// Pro_cost为冗余实体类
					List<Pro_cost> costList1 = new ArrayList<Pro_cost>();
					for (Pro_cost cost : costList) {
						Pro_cost cost1 = new Pro_cost();
						if(cost.getFactCostSum() !=null || cost.getMustCostSum()!=null || cost.getPreCostSum()!=null || cost.getReturnCostSum()!=null){
							cost1=cost;
							costList1.add(cost1);
						}
					}
					
					meetingDetail.setCostList(costList1);
					meetingDetail.setProjectList(projectList);
				}
			}
			
			//mv.getModelMap().put("meetingDetailList",meetingDetailList);
			ar.setSucceed(meetingDetailList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
    
    
    /**
     * @param meetingDetail_ID
     * @return 已确认放款 ———— 展示页面
     */
    @RequestMapping(value="/showConfirmLoanPage")
	public ModelAndView showConfirmLoanPage(String  meetingDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//保后（贷后）产品放款信息
		List<Pro_project> projectList = projectService.selectProjectListByWheresql(condition);
		Double agreeSum = meetingDetail.getAgreeSum() == null ? 0D : meetingDetail.getAgreeSum();//同意放款金额
		Double haveLoanSum = 0D;//已经放款金额
		Double notLoanSum = 0D;//未放款金额
		for (Pro_project pro_project : projectList) {
			Double loanSum = pro_project.getLoadSum() == null ? 0D : pro_project.getLoadSum();//放款金额
			haveLoanSum += loanSum;
		}
		notLoanSum = agreeSum-haveLoanSum;
		String project_ID = Tool.createUUID32(); //项目ID
		mv.getModel().put("project_ID",project_ID);
		mv.getModel().put("meetingDetail",meetingDetail);
		mv.getModel().put("haveLoanSum",haveLoanSum);
		mv.getModel().put("notLoanSum",notLoanSum);
		mv.setViewName("/project/loan/singleLoanReview/loanConfirm");
		return mv;
	}
    /**
     * @param pro_project
     * @return  已确认放款
     */
    @RequestMapping(value="/addConfirmLoan")
	@ResponseBody
	public AjaxRes addConfirmLoan(@RequestBody Pro_project pro_project){
    	AjaxRes ar=new AjaxRes();
		try {
			Boolean b = projectService.addConfirmLoan(SystemSession.getUserSession(), pro_project);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}		   
		return ar;
	}
    /**
     * @return 撤销已确认放款 ———— 展示页面
     */
    @RequestMapping(value="/showCancelLoanConfirmPage")
	public ModelAndView showCancelLoanConfirmPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/singleLoanReview/singleLoanCancel");
		return mv;
	}
    /**
     * @param pro_project
     * @return  撤销已确认放款
     */
    @RequestMapping(value="/cancelLoanConfirm")
	@ResponseBody
	public AjaxRes cancelLoanConfirm(@RequestBody Pro_project pro_project){
    	AjaxRes ar=new AjaxRes();
		try {
			Boolean b = projectService.cancelLoanConfirm(SystemSession.getUserSession(), pro_project);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}		   
		return ar;
	}
    
    /**
     * @param meetingDetail_ID
     * @return 确认收费 ———— 显示页面
     */
    @RequestMapping(value="/showConfirmFeePage")
	public ModelAndView showConfirmFeePage(String meetingDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//应收
		List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(condition);
		//实收
		List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(condition);
		//预收
		List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresql(condition);
		//退费
		List<Pro_costReturn> costReturnList = costReturnService.selectCostReturnListByWhereSql(condition);
		
		mv.getModel().put("meetingDetail_ID",meetingDetail_ID);
		mv.getModel().put("meetingDetail",meetingDetail);
		mv.getModel().put("costMustList",costMustList);
		mv.getModel().put("costFactList",costFactList);
		mv.getModel().put("costPreList",costPreList);
		mv.getModel().put("costReturnList",costReturnList);
		mv.setViewName("/project/loan/singleLoanReview/confirmFee");
		return mv;
	}
    
    /****************************************************************************************************/
	/*********************************以下是解除子流程（文旦）*************************************/
	/****************************************************************************************************/
	
    /**
	 * 解除子流程  WHDB
	 */
	@RequestMapping(value="/showDutyRemove")
	public ModelAndView showDutyRemove(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("ttyyppee",urlParam.getType());
		mv.setViewName("/project/WHDB/removePay/dutyRemove");
		return mv;		
	}
    /**
	 * 解除详细信息 WHDB
	 */
	@RequestMapping(value="/showDutyRemoveDetial")
	public ModelAndView showDutyRemoveDetial(String project_ID,String ttyyppee){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		mv.getModelMap().put("project",project);
		mv.getModelMap().put("ttyyppee",ttyyppee);
		mv.setViewName("/project/WHDB/removePay/dutyRemoveDetial");
		return mv;		
	}
	
	/**
     * @param project_ID
     * @return 查询放款复核信息
     */
    @RequestMapping(value="/selectOneProjectInfo")
	public ModelAndView selectOneProjectInfo(String project_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			String condition = " and project_ID='" + project_ID + "' ";
			// 保后（贷后）产品放款信息
			Pro_project project = projectService.selectOneProjectInfoByWheresql(condition);
			List<Pro_projectfiles> projectfilesList = projectfilesService
						.selectProFilesListByEntityID(SystemSession.getUserSession(),project.getProject_ID());
			
			project.setProjectfilesList(projectfilesList);
			Pro_loanPlan loanPlan = loanService.selectOneLoanPlan(" and  loanPlan_ID ='"+project.getLoanPlan_ID()+"' ");

			mv.getModelMap().put("project", project);
			mv.getModelMap().put("loanPlan", loanPlan);
			mv.setViewName("/project/WHDB/loanReview/projectView");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    /**
     * @return 删除放款信息——显示页面
     */
    @RequestMapping(value="/showDelOneProjectPage")
	public ModelAndView showDelOneProjectPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/WHDB/loanReview/projectDel");
		return mv;
	}
    /**
	 * @param loanPlan_ID
	 * @return 还款计划 ——显示页面
	 */
	@RequestMapping(value="/showPayPlanPage")
	public ModelAndView showPayPlanPage(String project_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		//查询保后（贷后）产品放款
		Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+project_ID+"' ");
		List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and project_ID='"+project_ID+"' ");
		Double loadSum = project.getLoadSum()==null ? 0D : project.getLoadSum();
		Double totalNum = 0D;//计划已经还款
		Double notNum = 0D;//计划未还款
		for (Pro_planPay planPay : planPayList) {
			Double planPaySum = planPay.getPlanPaySum()==null ? 0D : planPay.getPlanPaySum();
			totalNum += planPaySum;
		}
		notNum = loadSum-totalNum;
		mv.getModelMap().put("project", project);
		mv.getModelMap().put("totalNum", totalNum);
		mv.getModelMap().put("notNum", notNum);
		mv.getModelMap().put("planPayList", planPayList);
		mv.setViewName("/project/WHDB/loanReview/planPay");
		return mv;
	}
    /**
     * @param project_ID
     * @return 一次还款计划 ——显示页面
     */
    @RequestMapping(value="/showOnePlanPayPage")
	public ModelAndView showOnePlanPayPage(String project_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			String condition = " and project_ID='" + project_ID + "' ";
			// 保后（贷后）产品放款信息
			Pro_project project = projectService.selectOneProjectInfoByWheresql(condition);
			List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and project_ID='"+project_ID+"' ");
			Double loadSum = project.getLoadSum()==null ? 0D : project.getLoadSum();
			Double totalNum = 0D;//计划已经还款
			Double notNum = 0D;//计划未还款
			for (Pro_planPay planPay : planPayList) {
				Double planPaySum = planPay.getPlanPaySum()==null ? 0D : planPay.getPlanPaySum();
				totalNum += planPaySum;
			}
			notNum = loadSum-totalNum;
			mv.getModelMap().put("notNum", notNum);
			mv.getModelMap().put("project", project);
			mv.setViewName("/project/WHDB/loanReview/onePlanPay");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
    /**
     * @param project_ID
     * @return 多次还款计划 ——显示页面
     */
    @RequestMapping(value="/showManyPlanPayPage")
    public ModelAndView showManyPlanPayPage(String project_ID){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		String condition = " and project_ID='" + project_ID + "' ";
    		// 保后（贷后）产品放款信息
    		Pro_project project = projectService.selectOneProjectInfoByWheresql(condition);
    		List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and project_ID='"+project_ID+"' ");
			Double loadSum = project.getLoadSum()==null ? 0D : project.getLoadSum();
			Double totalNum = 0D;//计划已经还款
			Double notNum = 0D;//计划未还款
			for (Pro_planPay planPay : planPayList) {
				Double planPaySum = planPay.getPlanPaySum()==null ? 0D : planPay.getPlanPaySum();
				totalNum += planPaySum;
			}
			notNum = loadSum-totalNum;
			mv.getModelMap().put("notNum", notNum);
    		mv.getModelMap().put("project", project);
    		mv.setViewName("/project/WHDB/loanReview/manyPlanPay");
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return mv;
    }
    
    /**
     * @param planPay
     * @return  添加还款计划
     */
    @RequestMapping(value="/insertPlanPay")
	@ResponseBody
	public AjaxRes insertPlanPay(@RequestBody Pro_planPay planPay){
    	AjaxRes ar=new AjaxRes();
		try {
			User user = SystemSession.getUserSession();
			Boolean b = planPayService.insertPlanPay(user, planPay);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}		   
		return ar;
	}
    
	/**
     * @return 删除还款计划 ——显示页面
     */
    @RequestMapping(value="/showDelPlanPayPage")
    public ModelAndView showDelPlanPayPage(){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	mv.setViewName("/project/WHDB/loanReview/planPayDel");
    	return mv;
    }
    /**
     * @param planPay
     * @return  删除还款计划
     */
    @RequestMapping(value="/deleteOnePlanPay")
	@ResponseBody
	public AjaxRes deleteOnePlanPay(@RequestBody Pro_planPay planPay){
    	AjaxRes ar=new AjaxRes();
		try {
			User user = SystemSession.getUserSession();
			Boolean b = planPayService.deleteOnePlanPayWhdb(user, planPay);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}		   
		return ar;
	}
	/**
     * @param project_ID
     * @return 查看还款计划页面
     */
    @RequestMapping(value="/showViewPlanPayPage")
    public ModelAndView showViewPlanPayPage(String planPay_ID){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		String condition = " and planPay_ID='" + planPay_ID + "' ";
    		Pro_planPay planPay = planPayService.selectOnePlanPay(condition);
    		// 保后（贷后）产品放款信息
    		Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+planPay.getProject_ID()+"' ");
    		
    		mv.getModelMap().put("project", project);
    		mv.getModelMap().put("planPay", planPay);
    		mv.setViewName("/project/WHDB/loanReview/planPayView");
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return mv;
    }
    /**
     * @param planPay_ID
     * @return 修改还款计划——显示页面
     */
    @RequestMapping(value="/showEditPlanPayPage")
    public ModelAndView showEditPlanPayPage(String planPay_ID){
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	try {
    		String condition = " and planPay_ID='" + planPay_ID + "' ";
    		Pro_planPay planPay = planPayService.selectOnePlanPay(condition);
    		// 保后（贷后）产品放款信息
    		Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID='"+planPay.getProject_ID()+"' ");
    		
    		List<Pro_planPay> planPayList = planPayService.selectPlanPayListByWheresql(" and project_ID='"+project.getProject_ID()+"' ");
			Double loadSum = project.getLoadSum()==null ? 0D : project.getLoadSum();
			Double totalNum = 0D;//计划已经还款
			Double notNum = 0D;//计划未还款
			for (Pro_planPay planPay1 : planPayList) {
				Double planPaySum = planPay1.getPlanPaySum()==null ? 0D : planPay1.getPlanPaySum();
				totalNum += planPaySum;
			}
			notNum = loadSum-totalNum;
			planPay.setNotPlanPaySum(notNum);
			
    		mv.getModelMap().put("project", project);
    		mv.getModelMap().put("planPay", planPay);
    		mv.setViewName("/project/WHDB/loanReview/planPayEdit");
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return mv;
    }
    /**
     * @param planPay
     * @return 修改还款计划
     */
    @RequestMapping(value="/updateOnePlanPay")
	@ResponseBody
	public AjaxRes updateOnePlanPay(@RequestBody Pro_planPay planPay){
    	AjaxRes ar=new AjaxRes();
		try {
			User user = SystemSession.getUserSession();
			Boolean b = planPayService.updateOnePlanPay(user, planPay);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}		   
		return ar;
	}
    
    
    /**
     * 核保放款 项目信息填报-后
     * @param pro_project
     * @return
     */
    @RequestMapping(value="/showEditProjectInfoAfter")
    public ModelAndView showCheckProjectInfo(UrlParam urlParam){
    	//数据 页面显示的数据
    	ModelAndView mv = CustomDispatchServlet.getModeAndView();
    	Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
    	Pro_project project = projectService.selectOneProjectInfoByWheresql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
    	mv.getModelMap().put("project", project);
		mv.getModelMap().put("apply", apply);
    	mv.setViewName("/project/apply/editProjectInfToCheck");
		return mv;
    }
    
    
    /**
     * 核保放款  保存项目信息填报-后
     * @param pro_project
     * @return
     */
	@RequestMapping(value="/insertProjectInfoAfter", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertProjectInfoAfter(@RequestBody Pro_project pro_project){
    	//数据 页面显示的数据
    	Boolean b = false;	
		AjaxRes ar=new AjaxRes();
		if( null != pro_project){		
			try {
				if("" != pro_project.getProject_ID()&&null !=pro_project.getProject_ID())
					b = projectService.updateOneProjectInfo(SystemSession.getUserSession(),pro_project);
				else
					b=projectService.insertProjectInfoAfter(SystemSession.getUserSession(),pro_project);
			} catch (Exception e) {
				e.printStackTrace();
				return ar;
			}
		}
		ar.setSucceed(b);
		return ar;
    }
    
	/**
	 *  计算再保余额
	 * @param project
	 * @return
	 */
	public Double getGuarantySumByProject(Pro_project project){
		Double loadSum = project.getLoadSum()==null ? 0d :project.getLoadSum();
			List<Pro_factPay> list = factPayService.selectFactPayListByWhereSql(" and project_ID ='"+project.getProject_ID()+"'");
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
	 * 打开催告函页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/projectUrgeLetterPage")
	public ModelAndView projectUrgeLetterPage(String project_ID){
//		ModelAndView mv = CustomDispatc	hServlet.getModeAndView();
		Pro_project  project= new Pro_project();
		project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+project_ID+"\'");
		Pro_apply apply = new Pro_apply(); // 还款页面中的放款机构数据抽取为资金方数据
		apply = projectApplyService.selectOneApplyByWhereSql("and apply_ID = \'"+project.getApply_ID()+"\' ");
		List<Pro_projectfiles> listFiles = new ArrayList<Pro_projectfiles>();
	    //fileType: 09为完结解保附件  此处在续保任务事项调用  故不做查询参数穿进去
		if(null!=apply){
			listFiles = finishService.getAttachments(apply.getApply_ID(), " and fileType = \'"+"101"+"\'");
		}
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("apply", apply);
		initSelect(mv);//获取下拉框
		mv.getModelMap().put("projectfiles",listFiles);
		mv.getModelMap().put("project",project);
//		mv.setViewName("/project/apply/projectAfterAdd");
		mv.setViewName("/project/apply/projectUrgeLetterPage");
		return mv;		
	}
	
	/**
     * 修改项目是否有催告函
     * @param pro_project
     * @return
     */
	@RequestMapping(value="/updateOneProjectIsUrgeLetter", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneProjectIsUrgeLetter(@RequestBody Pro_project pro_project){
		User user = SystemSession.getUserSession();
    	//数据 页面显示的数据
    	Boolean b = false;	
		AjaxRes ar=new AjaxRes();
		if(null != pro_project&&pro_project.getIsUrgeLetter()!=null){
			Pro_project project = projectService.selectOneProjectInfoByWheresql(" and project_ID = \'"+pro_project.getProject_ID()+"\'");
			project.setIsUrgeLetter(pro_project.getIsUrgeLetter());
			b = projectService.updateOneProjectInfo(user, project);
		}
		ar.setSucceed(b);
		return ar;
    }
	
	
	/**
	 * 选择业务类型页面
	 * @return
	 */
	@RequestMapping(value="/projectTypeSelectPage")
	public ModelAndView projectTypeSelectPage(){
		 ModelAndView mv = CustomDispatchServlet.getModeAndView();
		 //获取业务类型下拉框
		 List<C_dictype> projectTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='ca1b5395c0254bf1a412722bd756a45b'");
		 mv.getModelMap().put("projectTypeList", projectTypeList);
		 mv.setViewName("/project/apply/projectTypeSelect");
		return mv;		
	}
	
}

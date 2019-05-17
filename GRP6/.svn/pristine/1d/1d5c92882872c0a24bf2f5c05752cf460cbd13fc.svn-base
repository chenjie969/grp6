package com.zjm.pro.credit.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_relationMain;
import com.zjm.crm.relationMain.service.RelationMainService;
import com.zjm.pro.credit.service.CreditApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/credit")
public class CreditApplyAction {

	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private CreditApplyService creditApplyService;
	@Resource
	private RelationMainService relationMainService;
	
	/**
	 * 显示页面-授信申请登记列表
	 */
	@RequestMapping(value="/showCreditApplyPageTables")
	public ModelAndView showCreditApplyPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/apply/creditApply");
		return mv;
	}
	
	/**
	 * 查询授信申请列表-分页
	 */
	@RequestMapping(value="/selectCreditApplyPageTables")
	@ResponseBody
	public AjaxRes selectCreditApplyPageTables(@RequestBody PageTable<Pro_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = creditApplyService.selectCreditApplyPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_apply> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByRole(pageTable.getQueryCondition().getUser_uid(),RolesDataAccreditUtil.PRO_CREATE_SQL_STR,"");
			if( null != sql ){
				wheresql.append(sql);
			}
		}
		
		wheresql.append(" and unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"'");
		wheresql.append(" and projectType='综合授信'");
		if(null == pageTable.getQueryCondition().getCreditStatus()){	//审批完成后的授信申请不能在登记列表中查出
			wheresql.append(" and creditStatus IS NULL");
		}else{
			wheresql.append(" and creditStatus IS NOT NULL");
		}
		if(null != pageTable.getQueryCondition().getProjectStageID()){
			wheresql.append(" and creditStatus = '"+pageTable.getQueryCondition().getProjectStageID()+"'");
		}else{		//审批中的授信申请不能在登记列表中查出
			wheresql.append(" and projectStageID IS NULL");
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		//高级查询功能
		if(null != pageTable.getQueryCondition().getBusiCode() && !"".equals(pageTable.getQueryCondition().getBusiCode())){	//授信编号
			wheresql.append(" and busiCode like \'%"+pageTable.getQueryCondition().getBusiCode().trim()+"%\'");
		}
		if(null != pageTable.getQueryCondition().getProjectName() && !"".equals(pageTable.getQueryCondition().getProjectName())){	//授信项目名称
			wheresql.append(" and projectName like \'%"+pageTable.getQueryCondition().getProjectName().trim()+"%\'");
		}
		if(null != pageTable.getQueryCondition().getCreditTypeID() && !"".equals(pageTable.getQueryCondition().getCreditTypeID())){	//授信项目类型
			wheresql.append(" and creditTypeID like \'%"+pageTable.getQueryCondition().getCreditTypeID().trim()+"%\'");
		}
		if(null != pageTable.getQueryCondition().getClientTypeID() && !"".equals(pageTable.getQueryCondition().getClientTypeID())){	//授信客户类型
			if(pageTable.getQueryCondition().getClientTypeID().equals("01")){	//企业客户
				wheresql.append(" and relationID = \'\'");
			}else if(pageTable.getQueryCondition().getClientTypeID().equals("02")){	//集团/关联客户
				wheresql.append(" and relationID != \'\'");
			}
		}
		if(null != pageTable.getQueryCondition().getClientName() && !"".equals(pageTable.getQueryCondition().getClientName())){	//客户名称
			wheresql.append(" and clientName like \'%"+pageTable.getQueryCondition().getClientName().trim()+"%\'");
		}
		if(null != pageTable.getQueryCondition().getApplySumLow() && !"".equals(pageTable.getQueryCondition().getApplySumLow())){	//授信申请金额 下限
			wheresql.append(" and applySum >= "+ pageTable.getQueryCondition().getApplySumLow());
		}
		if(null != pageTable.getQueryCondition().getApplySumHigh() && !"".equals(pageTable.getQueryCondition().getApplySumHigh())){	//授信申请金额 上限
			wheresql.append(" and applySum <= "+ pageTable.getQueryCondition().getApplySumHigh());
		}
		if(null != pageTable.getQueryCondition().getCreditBeginDateLow() && !"".equals(pageTable.getQueryCondition().getCreditBeginDateLow())){	//授信起始日期 下限
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and creditBeginDate >= \'"+format.format(pageTable.getQueryCondition().getCreditBeginDateLow())+"\'");
		}
		if(null != pageTable.getQueryCondition().getCreditBeginDateHigh() && !"".equals(pageTable.getQueryCondition().getCreditBeginDateHigh())){	//授信起始日期 上限
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and creditBeginDate <= \'"+format.format(pageTable.getQueryCondition().getCreditBeginDateHigh())+"\'");
		}
		if(null != pageTable.getQueryCondition().getCreditEndDateLow() && !"".equals(pageTable.getQueryCondition().getCreditEndDateLow())){	//授信结束日期 下限
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and creditEndDate >= \'"+format.format(pageTable.getQueryCondition().getCreditEndDateLow())+"\'");
		}
		if(null != pageTable.getQueryCondition().getCreditEndDateHigh() && !"".equals(pageTable.getQueryCondition().getCreditEndDateHigh())){	//授信结束日期 上限
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and creditEndDate <= \'"+format.format(pageTable.getQueryCondition().getCreditEndDateHigh())+"\'");
		}
		if(null != pageTable.getQueryCondition().getCreateDateStart() && !"".equals(pageTable.getQueryCondition().getCreateDateStart())){	//受理日期 下限
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and createDate >= \'"+format.format(pageTable.getQueryCondition().getCreateDateStart())+"\'");
		}
		if(null != pageTable.getQueryCondition().getCreateDateEnd() && !"".equals(pageTable.getQueryCondition().getCreateDateEnd())){	//受理日期 上限
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			wheresql.append(" and createDate <= \'"+format.format(pageTable.getQueryCondition().getCreateDateEnd())+"\'");
		}
		if(null != pageTable.getQueryCondition().getDepartName() && !"".equals(pageTable.getQueryCondition().getDepartName())){	//经办部门
			wheresql.append(" and departName like \'%"+pageTable.getQueryCondition().getDepartName()+"%\'");
		}
		if(null != pageTable.getQueryCondition().getCreateManName() && !"".equals(pageTable.getQueryCondition().getCreateManName())){	//经办人
			wheresql.append(" and createManName like \'%"+pageTable.getQueryCondition().getCreateManName()+"%\'");
		}
		//授信管理高级查询
		if(null != pageTable.getQueryCondition().getAgreeSumLow() && !"".equals(pageTable.getQueryCondition().getAgreeSumLow())){	//授信同意金额 下限
			wheresql.append(" and agreeSum >= "+ pageTable.getQueryCondition().getAgreeSumLow());
		}
		if(null != pageTable.getQueryCondition().getAgreeSumHigh() && !"".equals(pageTable.getQueryCondition().getAgreeSumHigh())){	//授信同意金额 上限
			wheresql.append(" and agreeSum <= "+ pageTable.getQueryCondition().getAgreeSumHigh());
		}
		if(null != pageTable.getQueryCondition().getUsedSumLow() && !"".equals(pageTable.getQueryCondition().getUsedSumLow())){	//已用金额 下限
			wheresql.append(" and usedSum >= "+ pageTable.getQueryCondition().getUsedSumLow());
		}
		if(null != pageTable.getQueryCondition().getUsedSumHigh() && !"".equals(pageTable.getQueryCondition().getUsedSumHigh())){	//已用金额 上限
			wheresql.append(" and usedSum <= "+ pageTable.getQueryCondition().getUsedSumHigh());
		}
		if(null != pageTable.getQueryCondition().getUsableSumLow() && !"".equals(pageTable.getQueryCondition().getUsableSumLow())){	//可用金额 下限
			wheresql.append(" and (agreeSum-usedSum) >= "+ pageTable.getQueryCondition().getUsableSumLow());
		}
		if(null != pageTable.getQueryCondition().getUsableSumHigh() && !"".equals(pageTable.getQueryCondition().getUsableSumHigh())){	//可用金额 上限
			wheresql.append(" and (agreeSum-usedSum) <= "+ pageTable.getQueryCondition().getUsableSumHigh());
		}
		
		return wheresql.toString();
	}
	
	/**
	 * 显示页面-新增授信申请
	 */
	@RequestMapping(value="/showCreditApplyAddPage")
	public ModelAndView showCreditApplyAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/apply/creditApplyAdd");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("creditTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='c115ccb51f6d42b98321f571326c2ed2'"));	//授信类型
		modelMap.put("projectTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='d80f39f02f4a4578aa15bd337062a6fd'"));	//项目类型
		modelMap.put("busiNatureList", dicTypeService.selectAllDicTypeList(" and dicTypePID='53b3870104de46f99940750515404048'"));	//业务性质
		modelMap.put("projectSourceList", dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'"));	//项目来源
		modelMap.put("greenChannelList", dicTypeService.selectAllDicTypeList(" and dicTypePID='70c0e21474174350856987e442c7cd37'"));	//绿色通道
		return mv;
	}
	
	/**
	 * 执行操作-新增授信申请
	 */
	@RequestMapping(value="/insertOneCreditApply")
	@ResponseBody
	public AjaxRes insertOneCreditApply(@RequestBody Pro_apply creditApply){
		AjaxRes ar = new AjaxRes();
		String apply_ID = creditApplyService.insertOneCreditApply(SystemSession.getUserSession(), creditApply);
		ar.setSucceed(apply_ID);
		return ar;
	}
	
	/*
	 * 执行操作-修改授信申请
	@RequestMapping(value="/updateOneCreditApply")
	@ResponseBody
	public AjaxRes updateOneCreditApply(@RequestBody Pro_apply creditApply){
		AjaxRes ar = new AjaxRes();
		String apply_ID = creditApplyService.insertOneCreditApply(SystemSession.getUserSession(), creditApply);
		ar.setSucceed(apply_ID);
		return ar;
	}*/
	
	/**
	 * 执行操作-新增授信项下的项目申请
	 */
	@RequestMapping(value="/insertOneCreditProjectApply")
	@ResponseBody
	public AjaxRes insertOneCreditProjectApply(@RequestBody Pro_applyDetail applyDetail){
		AjaxRes ar = new AjaxRes();
		Boolean flag = creditApplyService.insertOneCreditProjectApply(SystemSession.getUserSession(), applyDetail);
		ar.setSucceed(flag);
		return ar;
	}
	
	/*
	 * 显示页面-查看一条授信申请_弹窗显示
	 
	@RequestMapping(value="/viewOneCreditApply")
	public ModelAndView viewOneCreditApply(Pro_apply creditApply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/apply/creditApplyView");
		ModelMap modelMap = mv.getModelMap();
		// 先查询授信申请的信息
		creditApply = creditApplyService.selectOneCreditApply(creditApply,"credit");
		modelMap.put("creditApply", creditApply);
		// 再查询授信项下项目申请的信息
		Pro_apply creditProjectApply = new Pro_apply();
		creditProjectApply.setParentApply_ID(creditApply.getApply_ID());
		creditProjectApply = creditApplyService.selectOneCreditApply(creditProjectApply,"project");
		modelMap.put("creditProjectApply", creditProjectApply);
		
		return mv;
	}
	*/
	
	/**
	 * 显示页面-查看一条授信申请
	 */
	@RequestMapping(value="/viewOneCreditApply")
	public ModelAndView viewOneCreditApply(String apply_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/apply/creditApplyView");
		ModelMap modelMap = mv.getModelMap();
		// 先查询授信申请的信息
		Pro_apply creditApply = new Pro_apply();
		creditApply.setApply_ID(apply_ID);
		creditApply = creditApplyService.selectOneCreditApply(creditApply,"credit");
		modelMap.put("creditApply", creditApply);
		// 再查询授信项下项目申请的信息
		Pro_apply creditProjectApply = new Pro_apply();
		creditProjectApply.setParentApply_ID(creditApply.getApply_ID());
		creditProjectApply = creditApplyService.selectOneCreditApply(creditProjectApply,"project");
		modelMap.put("creditProjectApply", creditProjectApply);
		
		return mv;
	}
	
	/**
	 * APP-查看一条授信申请
	 */
	@RequestMapping(value="/AppViewOneCreditApply")
	@ResponseBody
	public AjaxRes AppViewOneCreditApply(@RequestBody Pro_apply apply){
		String apply_ID = apply.getApply_ID();
		AjaxRes ar = new AjaxRes();
		List<Pro_apply> data = new ArrayList<>();
		// 先查询授信申请的信息
		Pro_apply creditApply = new Pro_apply();
		creditApply.setApply_ID(apply_ID);
		creditApply = creditApplyService.selectOneCreditApply(creditApply,"credit");
		data.add(creditApply);
		// 再查询授信项下项目申请的信息
		Pro_apply creditProjectApply = new Pro_apply();
		creditProjectApply.setParentApply_ID(creditApply.getApply_ID());
		creditProjectApply = creditApplyService.selectOneCreditApply(creditProjectApply,"project");
		data.add(creditProjectApply);
		ar.setSucceed(data);
		return ar;
	}
	
	/**
	 * 显示页面-删除授信申请
	 */
	@RequestMapping(value="/showCreditApplyDelPage")
	public ModelAndView showCreditApplyDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/apply/creditApplyDel");
		return mv;
	}
	
	/**
	 * 执行操作-删除授信申请
	 */
	@RequestMapping(value="/deleteOneCreditApply")
	@ResponseBody
	public AjaxRes deleteOneCreditApply(@RequestBody Pro_apply creditApply){
		AjaxRes ar = new AjaxRes();
		Boolean flag = creditApplyService.deleteOneCreditApply(SystemSession.getUserSession(), creditApply);
		ar.setSucceed(flag);
		return ar;
	}
	
	/**
	 * 显示页面-授信申请 高级查询
	 */
	@RequestMapping(value="/showCreditApplyAdQueryPage")
	public ModelAndView showCreditApplyAdQueryPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/apply/creditApplyAdQuery");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("creditTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='c115ccb51f6d42b98321f571326c2ed2'"));	//授信类型
		return mv;
	}
	
	/**
	 * 显示页面-同意立项
	 */
	@RequestMapping(value="/showApprovalPage")
	public ModelAndView showApprovalPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/approvalPage");
		return mv;
	}
	
	/**
	 * 显示页面-不予立项
	 */
	@RequestMapping(value="/showDisapprovalPage")
	public ModelAndView showDisapprovalPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/disapprovalPage");
		return mv;
	}

//=======================================================授信项目管理（额度使用情况）部分    begin===================================================================================	
	
	/**
	 * 显示页面-额度使用情况（原名 授信项目管理）
	 */
	@RequestMapping(value="/showCreditManagerPage")
	public ModelAndView showCreditManagerPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/manager/creditManager");
		return mv;
	}
	
	/**
	 * 显示页面-用款申请
	 */
	@RequestMapping(value="/showFundsApplyAddPage")
	public ModelAndView showFundsApplyAddPage(String apply_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		ModelMap modelMap = mv.getModelMap();
		// 查询该授信项的详细信息
		Pro_apply creditApply = new Pro_apply();
		creditApply.setApply_ID(apply_ID);
		creditApply = creditApplyService.selectOneCreditApply(creditApply,"credit");
		modelMap.put("creditApply", creditApply);
		// 将业务品种明细转成json字符串传递到页面
		String strDetailList = JSONArray.toJSONString(creditApply.getDetailList());
		modelMap.put("strDetailList", strDetailList);
		// 如果该授信项是集团/关联客户，要查出其关联企业，返回页面
		Crm_relationMain relationMain = new Crm_relationMain();
		if(creditApply.getRelationID()!=null && !"".equals(creditApply.getRelationID())){
			relationMain.setRelationMain_ID(creditApply.getRelationID());
			relationMain.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			relationMain = relationMainService.selectOneRelationMainById(relationMain);
		}
		modelMap.put("relationMain", relationMain);
		//设置下拉框的值
		modelMap.put("busiNatureList", dicTypeService.selectAllDicTypeList(" and dicTypePID='53b3870104de46f99940750515404048'"));	//业务性质
		modelMap.put("projectTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='d80f39f02f4a4578aa15bd337062a6fd'"));	//项目类型
		modelMap.put("projectSourceList", dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'"));	//项目来源
		modelMap.put("greenChannelList", dicTypeService.selectAllDicTypeList(" and dicTypePID='70c0e21474174350856987e442c7cd37'"));	//绿色通道
		
		mv.setViewName("/project/credit/manager/fundsApplyAdd");
		return mv;
	}
	
	/**
	 * 显示页面-某授信项下的用款明细 
	 */
	@RequestMapping(value="/showFundsDetailPage")
	public ModelAndView showFundsDetailPage(String apply_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/manager/fundsDetail");
		ModelMap modelMap = mv.getModelMap();
		// 先查询授信申请的信息
		Pro_apply creditApply = new Pro_apply();
		creditApply.setApply_ID(apply_ID);
		creditApply = creditApplyService.selectOneCreditApply(creditApply,"credit");
		modelMap.put("creditApply", creditApply);
		
		return mv;
	}
	
	/**
	 * 查询授信项下的项目记录（用款明细）分页
	 */
	@RequestMapping(value="/selectFundsDetailPageTables")
	@ResponseBody
	public AjaxRes selectFundsDetailPageTables(@RequestBody PageTable<Pro_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = creditApplyService.selectFundsDetailPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 显示页面-授信项下某一条项目申请（用款明细）的详情
	 */
	@RequestMapping(value="showFundsApplyViewPage")
	public ModelAndView showFundsApplyViewPage(String apply_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/manager/fundsApplylView");
		Pro_apply fundsApply = new Pro_apply();
		fundsApply.setApply_ID(apply_ID);
		fundsApply = creditApplyService.selectOneCreditApply(fundsApply, "credit");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("fundsApply", fundsApply);
		return mv;
	}
	
	/**
	 * 显示页面-改变授信项状态
	 */
	@RequestMapping(value="showChangeStatusPage")
	public ModelAndView showChangeStatusPage(String apply_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/manager/changeStatus");
		Pro_apply creditApply = new Pro_apply();
		creditApply.setApply_ID(apply_ID);
		creditApply = creditApplyService.selectOneCreditApply(creditApply, "credit");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("creditApply", creditApply);
		return mv;
	}
	
	/**
	 * 执行操作-改变授信项状态
	 */
	@RequestMapping(value="/changeCreditStatus")
	@ResponseBody
	public AjaxRes changeCreditStatus(@RequestBody Pro_apply creditApply){
		AjaxRes ar = new AjaxRes();
		Pro_apply result = creditApplyService.selectOneCreditApply(creditApply, "credit");
		result.setCreditStatus(creditApply.getCreditStatus());
		Boolean bool = creditApplyService.updateApply(result);
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 显示页面-授信管理 高级查询
	 */
	@RequestMapping(value="/showCreditManagerAdQueryPage")
	public ModelAndView showCreditManagerAdQueryPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/credit/manager/creditManagerAdQuery");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("creditTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='c115ccb51f6d42b98321f571326c2ed2'"));	//授信类型
		return mv;
	}
}

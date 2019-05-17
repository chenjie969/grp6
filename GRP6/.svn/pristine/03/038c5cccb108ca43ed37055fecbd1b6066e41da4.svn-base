package com.zjm.pro.projectCost.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_FinanceForProVO;
import com.zjm.pro.finance.service.FinanceService;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/finance")
public class ProjectCostAction {

	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private FinanceService financeService;
	
	/**
	 * 显示页面-所有通过项目的费用统计列表
	 */
	@RequestMapping(value="/showProjectsCostPageTables")
	public ModelAndView showProjectsCostPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/projectsCost");
//		mv.setViewName("/project/finance/projectCostSelfMake/projectCost");
		return mv;
	}
	
	/**
	 * 查询所有项目的开票信息列表
	 */
	@RequestMapping(value="/selectProjectsCostPageTables")
	@ResponseBody
	public AjaxRes selectMultiProsBillPageTable(@RequestBody PageTable<Pro_FinanceForProVO> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = financeService.selectMultiPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 所有项目的票据 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_FinanceForProVO> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();		
	}
	
	/**
	 * 显示页面-查看费用明细
	 */
	@RequestMapping(value="/showProjectsCostViewPage")
	public ModelAndView showProjectsCostViewPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/projectsCostView");
		return mv;
	}
	
	/**
	 * 显示页面-一个项目的不同费用类别登记列表
	 */
	@RequestMapping(value="/showOneProjectCostPageTables")
	public ModelAndView showOneProjectCostPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/oneProjectCost");
		return mv;
	}
	
	/**
	 * 显示页面-新增应收费用
	 */
	@RequestMapping(value="/showMustChargeAddPage")
	public ModelAndView showMustChargeAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/mustChargeAdd");
		return mv;
	}
	
	/**
	 * 显示页面-新增退费
	 */
	@RequestMapping(value="/showRefundAddPage")
	public ModelAndView showRefundAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/refundAdd");
		return mv;
	}
	
	/**
	 * 显示页面-转收付确认
	 */
	@RequestMapping(value="/showJumpToConfirmPaymentPage")
	public ModelAndView showJumpToConfirmPaymentPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/jumpToConfirmPayment");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("billTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='598fab5167dd4df79fedda5d7a81d5b4'"));	//票据类型
		return mv;
	}
	
	/**
	 * 显示页面-票据信息管理列表
	 */
	@RequestMapping(value="/showProjectBillInfoPageTables")
	public ModelAndView showProjectBillInfoPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/projectBillInfo");
		return mv;
	}
	
	/**
	 * 显示页面-票据信息新增
	 */
	@RequestMapping(value="/showProjectBillInfoAddPage")
	public ModelAndView showProjectBillInfoAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/projectBillInfoAdd");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("billTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='598fab5167dd4df79fedda5d7a81d5b4'"));	//票据类型
		return mv;
	}
	
	/**
	 * 显示页面-票据信息修改
	 */
	@RequestMapping(value="/showProjectBillInfoUpdatePage")
	public ModelAndView showProjectBillInfoUpdatePage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/projectBillInfoEdit");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("billTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='598fab5167dd4df79fedda5d7a81d5b4'"));	//票据类型
		return mv;
	}
	
	/**
	 * 显示页面-票据信息查看
	 */
	@RequestMapping(value="/showProjectBillInfoViewPage")
	public ModelAndView showProjectBillInfoViewPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/projectBillInfoView");
		return mv;
	}
	
	/**
	 * 显示页面-票据信息删除
	 */
	@RequestMapping(value="/showProjectBillInfoDelPage")
	public ModelAndView showProjectBillInfoDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/projectBillInfoDel");
		return mv;
	}
	
	/**
	 * 显示页面-收付确认项目列表
	 */
	@RequestMapping(value="/showConfirmPaymentPageTables")
	public ModelAndView showConfirmPaymentPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/confirmPayment/confirmPayment");
		return mv;
	}
	
	/**
	 * 显示页面-收付确认页面,显示费用详情
	 */
	@RequestMapping(value="/showConfirmPaymentPage")
	public ModelAndView showConfirmPaymentPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/confirmPayment/paymentDetail");
		return mv;
	}
	
	/**
	 * 显示页面-撤销收付确认
	 */
	@RequestMapping(value="/showBackToNoConfirmPage")
	public ModelAndView showBackToNoConfirmPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/confirmPayment/backToNoConfirm");
		return mv;
	}
	
	/**
	 * 显示页面-应收计算和缴费通知单
	 */
	@RequestMapping(value="/showComputeAndNoticePage")
	public ModelAndView showComputeAndNoticePage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/computeAndNotice");
		return mv;
	}
	
	/**
	 * 显示页面-应收计算和缴费通知单
	 */
	@RequestMapping(value="/showChargeAddPage")
	public ModelAndView showChargeAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/projectCost/chargeAdd");
		return mv;
	}
}

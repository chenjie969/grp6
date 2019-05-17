package com.zjm.pro.billManage.web;

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
import com.zjm.pro.billManage.service.BillManageService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_costBill;
import com.zjm.pro.db.model.Pro_billForProVO;
import com.zjm.pro.db.model.Pro_costBill;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/billManage")
public class BillManageAction {

	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private BillManageService billManageService;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private ApplyDetailService proApplyDetailService;
	
	/**
	 * 显示页面-所有项目的开票次数信息
	 */
	@RequestMapping(value="/showMultiProsBillPageTable")
	public ModelAndView showMultiProsBillPageTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/billManage/billManage");
		return mv;
	}
	
	/**
	 * 查询所有项目的开票信息列表
	 */
	@RequestMapping(value="/selectMultiProsBillPageTable")
	@ResponseBody
	public AjaxRes selectMultiProsBillPageTable(@RequestBody PageTable<Pro_billForProVO> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = billManageService.selectMultiProsBillPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 显示页面-单个项目的开票信息
	 */
	@RequestMapping(value="/showSglProBillPageTable")
	public ModelAndView showSglProBillPageTable(Pro_costBill bill){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/billManage/singleProjectBill");
		ModelMap modelMap = mv.getModelMap();
		Pro_apply pro_apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = '"+bill.getApply_ID()+"'");
		modelMap.put("apply", pro_apply);
		List<Pro_applyDetail> applyDetailList = proApplyDetailService.selectApplyDetailList(" and applyDetail_ID = '"+bill.getApplyDetail_ID()+"'");
		modelMap.put("applyDetail", applyDetailList.get(0));
		return mv;
	}
	
	/**
	 * 查询单个项目的开票信息列表
	 */
	@RequestMapping(value="/selectSglProBillPageTable")
	@ResponseBody
	public AjaxRes selectSglProBillPageTable(@RequestBody PageTable<Pro_costBill> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable = billManageService.selectSglProBillPageTable(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	/**
	 * 显示页面-单个项目新增一条发票信息
	 */
	@RequestMapping(value="/showSglProBillAddPage")
	public ModelAndView showSglProBillAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/billManage/singleProjectBillAdd");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("billTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='598fab5167dd4df79fedda5d7a81d5b4'"));	//票据类型
		return mv;
	}
	
	/**
	 * 执行操作-单个项目下新增一条票据信息
	 */
	@RequestMapping(value="/insertOneBill")
	@ResponseBody
	public AjaxRes insertOneBill(@RequestBody Pro_costBill bill){
		AjaxRes ar = new AjaxRes();
		Boolean flag = billManageService.insertOneBill(SystemSession.getUserSession(), bill);
		ar.setSucceed(flag);
		return ar;
	}
	
	/**
	 * 显示页面-单个项目修改一条发票信息
	 */
	@RequestMapping(value="/showSglProBillEditPage")
	public ModelAndView showSglProBillEditPage(Pro_costBill bill){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/billManage/singleProjectBillEdit");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("billTypeList", dicTypeService.selectAllDicTypeList(" and dicTypePID='598fab5167dd4df79fedda5d7a81d5b4'"));	//票据类型
		modelMap.put("bill", billManageService.selectOneBill(bill));
		return mv;
	}
	
	/**
	 * 执行操作-单个项目下修改一条票据信息
	 */
	@RequestMapping(value="/updateOneBill")
	@ResponseBody
	public AjaxRes updateOneBill(@RequestBody Pro_costBill bill){
		AjaxRes ar = new AjaxRes();
		Boolean flag = billManageService.updateOneBill(SystemSession.getUserSession(), bill);
		ar.setSucceed(flag);
		return ar;
	}
	
	/**
	 * 显示页面-单个项目查看一条发票信息
	 */
	@RequestMapping(value="/showSglProBillViewPage")
	public ModelAndView showSglProBillViewPage(Pro_costBill bill){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/billManage/singleProjectBillView");
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("bill", billManageService.selectOneBill(bill));
		return mv;
	}
	
	/**
	 * 显示页面-单个项目删除一条发票信息
	 */
	@RequestMapping(value="/showSglProBillDelPage")
	public ModelAndView showSglProBillDelPage(Pro_costBill bill){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/billManage/singleProjectBillDel");
		return mv;
	}
	
	/**
	 * 执行操作-单个项目下删除一条票据信息
	 */
	@RequestMapping(value="/deleteOneBill")
	@ResponseBody
	public AjaxRes deleteOneBill(@RequestBody Pro_costBill bill){
		AjaxRes ar = new AjaxRes();
		Boolean flag = billManageService.deleteOneBill(SystemSession.getUserSession(), bill);
		ar.setSucceed(flag);
		return ar;
	}
	
	/**
	 * 所有项目的票据 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_billForProVO> pageTable){
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
	 * 显示页面-单个项目的开票信息-任务事项专用
	 */
	@RequestMapping(value="/showProBillGBPMPageTable")
	public ModelAndView showProBillGBPMPageTable(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/billManage/singleProjectBill_GBPM");
		ModelMap modelMap = mv.getModelMap();
		Pro_apply pro_apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = '"+urlParam.getEntityID()+"'");
		pro_apply.setType(urlParam.getType());		//任务事项 设置打开方式 : edit/view
		modelMap.put("apply", pro_apply);
//		List<Pro_applyDetail> applyDetailList = proApplyDetailService.selectApplyDetailList(" and applyDetail_ID = '"+bill.getApplyDetail_ID()+"'");
		List<Pro_applyDetail> applyDetailList = proApplyDetailService.selectApplyDetailList(" and apply_ID = '"+urlParam.getEntityID()+"'");
		modelMap.put("applyDetail", applyDetailList.get(0));
		return mv;
	}
}

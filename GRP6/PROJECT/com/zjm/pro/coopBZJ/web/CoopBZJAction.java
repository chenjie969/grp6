package com.zjm.pro.coopBZJ.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.coopBZJ.service.CoopBZJService;
import com.zjm.sys.db.model.C_bankSort;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/finance")
public class CoopBZJAction {

	@Resource
	private  CoopBZJService coopBZJService;
	
	/**
	 * 显示页面-合作机构保证金列表
	 */
	@RequestMapping(value="/showCoopBZJPageTables")
	public ModelAndView showCoopBZJPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/coopBZJManager/coopBZJManager");
		return mv;
	}
	
	/**
	 * 查询合作机构保证金列表-分页
	 */
	@RequestMapping(value="/selectCoopBZJPageTables")
	@ResponseBody
	public AjaxRes selectCoopBZJPageTables(@RequestBody PageTable<C_bankSort> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = coopBZJService.selectbankSortPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 合作机构保证金的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<C_bankSort> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"'");
		String pBankSortid = pageTable.getQueryCondition().getPbanksortid();		//银行字典父id
		if(pBankSortid!=null && !pBankSortid.equals("") && !pBankSortid.equals("1")){
			wheresql.append(" and pBankSortid =\'"+pBankSortid+"\'");
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and clientName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		
		return wheresql.toString();
	}
	
	/**
	 * 显示页面-修改合作机构保证金
	 */
	@RequestMapping(value="showBankSortEditPage")
	public ModelAndView showBankSortEditPage(C_bankSort bankSort){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/coopBZJManager/coopBZJManagerEdit");
		bankSort.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		bankSort = coopBZJService.selectOneBankSort(bankSort);
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("bankSort", bankSort);
		return mv;
	}
	
	/**
	 * 执行操作-修改合作机构保证金
	 */
	@RequestMapping(value="updateOneBankSort")
	@ResponseBody
	public AjaxRes updateOneBankSort(@RequestBody C_bankSort bankSort){
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(coopBZJService.updateOneBankSort(SystemSession.getUserSession(),bankSort));
		return ar;
	}
	
	/**
	 * 显示页面-查看合作机构保证金
	 */
	@RequestMapping(value="showBankSortViewPage")
	public ModelAndView showBankSortViewPage(C_bankSort bankSort){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/finance/coopBZJManager/coopBZJManagerView");
		bankSort.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		bankSort = coopBZJService.selectOneBankSort(bankSort);
		ModelMap modelMap = mv.getModelMap();
		modelMap.put("bankSort", bankSort);
		return mv;
	}
}

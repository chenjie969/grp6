package com.zjm.sys.costStandard.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.costStandard.service.CostStandardService;
import com.zjm.sys.db.model.C_bankSort;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.db.model.Sys_costStandard;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;


@Controller
@RequestMapping(value="/sys/costStandard")
public class CostStandardAction {
	@Resource
	private CostStandardService costStandardService;
	@Resource
	private DicTypeService dicTypeService;
	/**
	 * 
	 * 查询收费标准表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectCostStandardTable")
	@ResponseBody
	public AjaxRes selectCostStandardTable(@RequestBody PageTable<Sys_costStandard> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable.setWheresql(queryConditionSql1(pageTable));
			ar.setSucceed(costStandardService.selectCostStandardTable((pageTable)));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	
	
	/**
	 * 已安排的分页列表查询条件
	 */
	private String queryConditionSql1(PageTable<Sys_costStandard> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and (costName like \'%"+pageTable.getSearchText().trim()+"%\'OR costTypeName like \'%"+pageTable.getSearchText().trim()+"%\')");
		}
		return wheresql.toString();		
	}
   
	/**
	 * 查询收费标准
	 * @param costStandard_ID
	 * @param operationType
	 * @return
	 */
	@RequestMapping(value="/selectOneCostStandard")
	public ModelAndView selectOneCostStandard(String costStandard_ID,String operationType){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Sys_costStandard costStandard = costStandardService.selectOneCostStandard(costStandard_ID);
		mv.getModelMap().put("costStandard",costStandard);
			mv.setViewName("/sys/costStandard/costStandardView");
		return mv;
	}
	
	/**
	 * 添加收费标准类型
	 * 
	 * @return
	 */
	
	@RequestMapping(value="/showCostStandardAdd")
	public ModelAndView showCostStandardAdd(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		List<C_dictype> costStandardList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		mv.getModelMap().put("costStandardList",costStandardList);	
		mv.setViewName("/sys/costStandard/costStandardAdd");
		return mv;
	}
	
	@RequestMapping(value="/insertOneCostStandard")
	@ResponseBody
	public AjaxRes insertOneCostStandard(@RequestBody Sys_costStandard costStandard){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(costStandardService.insertOneCostStandard(costStandard));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 删除收费标准类型
	 * 
	 */
	@RequestMapping(value="/deleteOneCostStandard")
	@ResponseBody
	public AjaxRes deleteOneCostStandard(@RequestBody Sys_costStandard costStandard){
		AjaxRes ar=new AjaxRes();
		try {
			Boolean b=costStandardService.deleteOneCostStandard(SystemSession.getUserSession(), costStandard.getCostStandard_ID());
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ar;
	}
}

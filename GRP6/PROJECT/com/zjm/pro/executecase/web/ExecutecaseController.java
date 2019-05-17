package com.zjm.pro.executecase.web;

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
import com.zjm.pro.db.model.Pro_executecase;
import com.zjm.pro.executecase.service.ExecutecaseService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value = "/project/executecase")
public class ExecutecaseController {
	
	@Resource
	private ExecutecaseService executecaseService;
	@Resource
	private DicTypeService dicTypeService;
	
	/**
	 * 打开案件执行登记页面
	 * @return
	 */
	@RequestMapping(value="/openExecutecasePage")
	public ModelAndView openExecutecasePage(String executecaseId){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		if (executecaseId != null && !"".equals(executecaseId)) {
			Pro_executecase executecase = executecaseService.findByPrimary(executecaseId);
			mv.getModelMap().put("executecase", executecase);
		}
		//执行依据种类
		List<C_dictype> executionBasisTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='d8d61af21d0b4e86946f050db5b8950e'");
		mv.getModelMap().put("executionBasisTypeList",executionBasisTypeList);
		//单位名称
		List<C_dictype> guarantyOrgList = dicTypeService.selectAllDicTypeList(" and dicTypePID='78ae83f6524d458dbbd522324c80723d'");
		mv.getModelMap().put("guarantyOrgList",guarantyOrgList);
		mv.setViewName("/project/lawExecutecase/executecase");
		return mv;
	}
	
	/**
	 * 新增或修改案件执行记录
	 * @param bankruptcy
	 * @return
	 */
	@RequestMapping(value="/insertOrUpdateExecutecase", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOrUpdateExecutecase(@RequestBody Pro_executecase executecase){
		AjaxRes ar=new AjaxRes();
		if (executecase.getExecutecaseId() != null && !"".equals(executecase.getExecutecaseId() )) {
			ar.setSucceed(executecaseService.update(SystemSession.getUserSession(), executecase));
		} else {
			ar.setSucceed(executecaseService.save(SystemSession.getUserSession(), executecase));
		}
		return ar;
	}
	
	/**
	 * 查询案件执行记录列表
	 * 
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectExecutecasePageTables")
	@ResponseBody
	public AjaxRes selectExecutecasePageTables(@RequestBody PageTable<Pro_executecase> pageTable){
		AjaxRes ar =new AjaxRes();
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable = executecaseService.selectExecutecasePageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryCondition(PageTable<Pro_executecase> pageTable){
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		
		if (pageTable.getSearchText() != null && !"".equals(pageTable.getSearchText())) {
			sb.append(" and ( ");
			sb.append(" plaintiff like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or defendant like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or project_name_list like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or `group` like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" ) ");
		}
		return sb.toString();
	}

}

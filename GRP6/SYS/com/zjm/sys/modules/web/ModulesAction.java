package com.zjm.sys.modules.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_modules;
import com.zjm.sys.modules.service.ModulesService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
 * 菜单设置
 * @author mashuo add 20170411
 */
@Controller
public class ModulesAction {
	@Resource
	private ModulesService modulesService;
    	
	/**
	 * 查询所有菜单
	 * @return
	 */
	@RequestMapping(value="/selectAllModulesList", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllModulesList(){
		List<Sys_modules>  modulesList=modulesService.selectAllModulesList("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(modulesList);
		return ar;
	}
	/**
	 * 查询所有菜单
	 * @return
	 */
	@RequestMapping(value="/selectModulesListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectModulesListJSON(@RequestBody Sys_modules sys_modules){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		if(sys_modules!=null){
			if(sys_modules.getPmod_id()!=null){
				wheresql=wheresql+" and pmod_id = \'"+ sys_modules.getPmod_id()+"\'";
			}
		}
		List<Sys_modules>  modulesList=modulesService.selectAllModulesList(wheresql);
		for (Sys_modules sys_module : modulesList) {
			map = new HashMap<String, String>();
			map.put(sys_module.getMod_uid(), sys_module.getMod_name());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	

	
	
	
	
	/**
	 * 查询所有菜单  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectAllModulesListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllModulesListTree(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "9cf65ae4911a4e7bac532be9e492af23");
		map.put("pId", "-1");
		map.put("name", "担保管理");
		map.put("open",true);
		map.put("mod_type","1");
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "361afd038b914df597e546e2625ff9c4");
		map.put("pId", "-1");
		map.put("name", "OA");
		map.put("open",true);
		map.put("mod_type","2");
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "ac0f1a8e29964a808e5a26509222171b");
		map.put("pId", "-1");
		map.put("name", "流程管理");
		map.put("open",true);
		map.put("mod_type","3");
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "88196758091d4b80949f917355845716");
		map.put("pId", "-1");
		map.put("name", "系统管理");
		map.put("open",true);
		map.put("mod_type","4");
		mapList.add(map);
		List<Sys_modules>  modulesList=modulesService.selectAllModulesList("");
		for (Sys_modules sys_modules : modulesList) {
			map = new HashMap<String, Object>();
			map.put("id", sys_modules.getMod_uid());
			map.put("pId", sys_modules.getPmod_id());
			map.put("name", sys_modules.getMod_name());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 插入一个菜单信息
	 * @return
	 */
	@RequestMapping(value="/insertOneModulesInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneModulesInfo(@RequestBody Sys_modules sys_modules){
		AjaxRes ar=new AjaxRes();
		sys_modules.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		sys_modules.setMod_uid(Tool.createUUID32());
		Boolean b=modulesService.insertOneModulesInfo(sys_modules);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询一个菜单信息
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value="/selectOneModulesInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneModulesInfo(@RequestBody Sys_modules sys_modules){
		AjaxRes ar=new AjaxRes();
		Sys_modules  modules=modulesService.selectOneModulesInfo(sys_modules);
		ar.setSucceed(modules);
		return ar;
	}
	/**
	 * 更新一个菜单信息
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value="/updateOneModulesInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneModulesInfo(@RequestBody Sys_modules sys_modules){
		AjaxRes ar=new AjaxRes();
		Boolean b=modulesService.updateOneModulesInfo(sys_modules);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 删除一个菜单信息
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value="/deleteOneModulesInfo")
	@ResponseBody
	public AjaxRes deleteOneModulesInfo(@RequestBody Sys_modules sys_modules){
		AjaxRes ar=new AjaxRes();
		Boolean b=modulesService.deleteOneModulesInfo(sys_modules);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询菜单分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectModulesPageTables")
	@ResponseBody
	public AjaxRes selectModulesPageTables(@RequestBody PageTable pageTable) {
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=modulesService.selectModulesPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 菜单分页列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and mod_name like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			if ( null == pageTable.getSearchText()) {
				if(pageTable.getQueryCondition().getMod_uid()!=null && !pageTable.getQueryCondition().getMod_uid().equals("") && !pageTable.getQueryCondition().getMod_uid().equals("-1")){
					wheresql=wheresql+" and mod_uid =\'"+pageTable.getQueryCondition().getMod_uid().trim()+"\'";
				}
				String pmod_id = pageTable.getQueryCondition().getPmod_id();
				if(null != pmod_id && !"".equals(pmod_id)){
					wheresql+=" and pmod_id= '"+pmod_id+"'";
				}
			}
			
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY order_id ";
		}
		return wheresql;
	}
	/**
	 * 添加时判断菜单名称是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectAddModulesNameIsExist")
	@ResponseBody
	public AjaxRes selectAddModulesNameIsExist(@RequestBody Sys_modules sys_modules){
		String wheresql="";
		if(sys_modules!=null){
			if(sys_modules.getMod_name()!=null){
				wheresql=wheresql+" and mod_name = \'"+((String) sys_modules.getMod_name()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=modulesService.selectModulesIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 修改时判断菜单名称是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectEditModulesNameIsExist")
	@ResponseBody
	public AjaxRes selectEditModulesNameIsExist(@RequestBody Sys_modules sys_modules){
		String wheresql="";
		if(sys_modules!=null){
			if(sys_modules.getMod_uid()!=null){
				wheresql=wheresql+" and mod_uid != \'"+ sys_modules.getMod_uid()+"\'";
			}
			if(sys_modules.getMod_name()!=null){
				wheresql=wheresql+" and mod_name = \'"+((String) sys_modules.getMod_name()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=modulesService.selectModulesIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}

}

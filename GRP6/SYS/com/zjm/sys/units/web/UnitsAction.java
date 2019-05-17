package com.zjm.sys.units.web;

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

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_units;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.units.service.UnitsService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
 * 担保机构设置
 * @author duanhuawei add 20170425
 */
@Controller
public class UnitsAction {
	@Resource
	private UnitsService unitsService;
	

	
	/**
	 * 插入一个机构信息
	 * @return
	 */
	@RequestMapping(value="/insertOneUnitsInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneUnitsInfo(@RequestBody Sys_units sys_units){
		AjaxRes ar=new AjaxRes();
		sys_units.setUnit_uid(Tool.createUUID32());//添加机构唯一id
		Boolean b=unitsService.insertOneUnitsInfo(SystemSession.getUserSession(),sys_units);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询所有担保机构  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectAllUnitsListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllUnitsListTree(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		String wheresql="";
		String unit_uid = SystemSession.getUserSession().getUnit_uid();
		if(unit_uid!=null && !unit_uid.equals("") && !unit_uid.equals("cbeb758e3d824626a31aabb2a9587b0a")){
			wheresql=wheresql+" and unit_uid =\'"+unit_uid.trim()+"\'";
		}
		List<Sys_units>  unitsList=unitsService.selectAllUnitsList(wheresql);
		for (Sys_units sys_units : unitsList) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(sys_units !=null){
				map.put("open",true);
			}
			map.put("id", sys_units.getUnit_uid());
			map.put("pId", sys_units.getPunit_uid());
			map.put("name", sys_units.getUnit_uidName());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 查询机构分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectUnitsPageTables")
	@ResponseBody
	public AjaxRes selectUnitsPageTables(@RequestBody PageTable pageTable) {
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=unitsService.selectUnitsPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 机构分页列表查询条件
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
			wheresql=wheresql+" and unit_uidName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		String unit_uid = SystemSession.getUserSession().getUnit_uid();
		if(unit_uid!=null && !unit_uid.equals("") && !unit_uid.equals("cbeb758e3d824626a31aabb2a9587b0a")){
			wheresql=wheresql+" and unit_uid =\'"+unit_uid.trim()+"\'";
		}
		if(pageTable.getQueryCondition()!=null){
			String punit_uid = pageTable.getQueryCondition().getPunit_uid();
			if(punit_uid != null && !"".equals(punit_uid)){
				wheresql+=" and punit_uid ='"+ punit_uid +"'";
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
	 * 查询一个机构信息
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value="/selectOneUnitsInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneUnitsInfo(@RequestBody Sys_units sys_units){
		AjaxRes ar=new AjaxRes();
		Sys_units  units=unitsService.selectOneUnitsInfo(sys_units);
		System.out.println("selectOneUnitsInfo:"+JSON.toJSONString(units));
		ar.setSucceed(units);
		return ar;
	}
	/**
	 * 更新一个机构信息
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value="/updateOneUnitsInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneModulesInfo(@RequestBody Sys_units sys_units){
		AjaxRes ar=new AjaxRes();
		sys_units.setUpdate_user("admin");
		System.out.println("前台传过来的数据：");
		System.out.println(JSON.toJSONString(sys_units));
		Boolean b=unitsService.updateOneUnitsInfo(SystemSession.getUserSession(),sys_units);
		ar.setSucceed(b);
		return ar;
	}
	//deleteOneUnitsInfo
	/**
	 * 删除一个机构信息
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value="/deleteOneUnitsInfo")
	@ResponseBody
	public AjaxRes deleteOneUnitsInfo(@RequestBody Sys_units sys_units){
		AjaxRes ar=new AjaxRes();
		Boolean b=unitsService.deleteOneUnitsInfo(SystemSession.getUserSession(),sys_units);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询所有机构json
	 * @return
	 */
	@RequestMapping(value="/selectUnitsListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectUnitsListJSON(@RequestBody Sys_units sys_units){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		if(sys_units!=null){
			if(sys_units.getPunit_uid()!=null){
				wheresql=wheresql+" and punit_uid = \'"+ sys_units.getPunit_uid()+"\'";
			}
		}
		List<Sys_units>  unitsList=unitsService.selectAllUnitsList(wheresql);
		for (Sys_units sys_unit : unitsList) {
			map = new HashMap<String, String>();
			map.put(sys_unit.getUnit_uid(), sys_unit.getUnit_uidName());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 添加时判断机构名称是否重复
	 * @param sys_units
	 * @return
	 */
	@RequestMapping(value = "/selectAddUnitsNameIsExist")
	@ResponseBody
	public AjaxRes selectAddUnitsNameIsExist(@RequestBody Sys_units sys_units){
		String wheresql="";
		if(sys_units!=null){
			if(sys_units.getUnit_uidName()!=null){
				wheresql=wheresql+" and unit_uidName = \'"+((String) sys_units.getUnit_uidName()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=unitsService.selectUnitsIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 修改时判断机构名称是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectEditUnitsNameIsExist")
	@ResponseBody
	public AjaxRes selectEditUnitsNameIsExist(@RequestBody Sys_units sys_units){
		String wheresql="";
		if(sys_units!=null){
			if(sys_units.getUnit_uid()!=null){
				wheresql=wheresql+" and unit_uid != \'"+ sys_units.getUnit_uid()+"\'";
			}
			if(sys_units.getUnit_uidName()!=null){
				wheresql=wheresql+" and unit_uidName = \'"+((String) sys_units.getUnit_uidName()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=unitsService.selectUnitsIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}

}

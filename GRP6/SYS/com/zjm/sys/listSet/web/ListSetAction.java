package com.zjm.sys.listSet.web;

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
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_listSet;
import com.zjm.sys.fieldName.service.FieldNameService;
import com.zjm.sys.listSet.service.ListSetService;
import com.zjm.util.SystemSession;

@Controller
public class ListSetAction {
	@Resource
	private ListSetService listSetService;
	@Resource
	private FieldNameService fieldNameService;
    
	/**
	 * 获取一个自定义列表信息
	 * @return
	 */
	@RequestMapping(value="/selectOneListSetInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneListSetInfo(@RequestBody Sys_listSet sys_listSet){
		AjaxRes ar=new AjaxRes();
		Sys_listSet  listSet =listSetService.selectOneListSetInfo(SystemSession.getUserSession(),sys_listSet.getListBH());
		ar.setSucceed(listSet);
		return ar;
	}
	/**
	 * 修改一个自定义列表信息
	 * @return
	 */
	@RequestMapping(value="/updateOneListSetInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneListSetInfo(@RequestBody Sys_listSet sys_listSet){
		AjaxRes ar=new AjaxRes();
		Sys_listSet  listSet =listSetService.selectOneListSetInfo(SystemSession.getUserSession(),sys_listSet.getListBH());
		User user = SystemSession.getUserSession();
		if (listSet.getUnit_uid() == null) {
			listSet.setChoosableColumns(sys_listSet.getChoosableColumns());
			listSet.setChoosableColumnNames(sys_listSet.getChoosableColumnNames());
			listSet.setSelectedColumns(sys_listSet.getSelectedColumns());
			listSet.setSelectedColumnNames(sys_listSet.getSelectedColumnNames());
			Boolean  b = listSetService.insertOneListSetInfo(user,listSet);
			ar.setSucceed(b);
		}else{
			Boolean  b =listSetService.updateOneListSetInfo(user,sys_listSet);
			ar.setSucceed(b);
		}
		return ar;
	}
	
	/**
	 * 获取可选字段树
	 * @return
	 */
	@RequestMapping(value="/selectChoosableColumnsJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectChoosableColumnsJSON(@RequestBody Sys_listSet sys_listSet){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		Sys_listSet  listSet =listSetService.selectOneListSetInfo(SystemSession.getUserSession(),sys_listSet.getListBH());
		String[] choosableArray = null; 
		String[] choosableArrayName = null; 
		if (listSet.getChoosableColumns()!="") {
			choosableArray = listSet.getChoosableColumns().split(",");
			choosableArrayName = listSet.getChoosableColumnNames().split(",");
			for (int i=0; i < choosableArray.length;i++) {
				map = new HashMap<String, String>();
				map.put(choosableArray[i], choosableArrayName[i]);
				mapList.add(map);
			}
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 * 获取已选字段树
	 * @return
	 */
	@RequestMapping(value="/selectSelectedColumnsJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectSelectedColumnsJSON(@RequestBody Sys_listSet sys_listSet){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		Sys_listSet  listSet =listSetService.selectOneListSetInfo(SystemSession.getUserSession(),sys_listSet.getListBH());
		String[] selectedArray = null;   
		String[] selectedArrayName = null;   
		if (listSet.getSelectedColumns()!="") {
			selectedArray = listSet.getSelectedColumns().split(",");
			selectedArrayName = listSet.getSelectedColumnNames().split(",");
			for (int i=0; i < selectedArray.length;i++) {
				map = new HashMap<String, String>();
				map.put(selectedArray[i], selectedArrayName[i]);
				mapList.add(map);
			}
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}

}

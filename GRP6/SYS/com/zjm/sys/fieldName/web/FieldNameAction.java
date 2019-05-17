package com.zjm.sys.fieldName.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.zjm.sys.fieldName.service.FieldNameService;

@Controller
public class FieldNameAction {
	@Resource
	private FieldNameService fieldNameService;
    
	/**
	 * 获取字段与字段名Map
	 * @return
	 *//*
	@RequestMapping(value="/selectFieldNameMap", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> selectOneListSetInfo(@RequestBody String listID){
		List<Sys_fieldName> fieldNameList =fieldNameService.selectFieldNameList(listID);
		Map<String, String> map =new HashMap<>();
		for(Sys_fieldName fieldName:fieldNameList){
			map.put(fieldName.getField(), fieldName.getFieldName());
		}
		return map;
	}*/

}

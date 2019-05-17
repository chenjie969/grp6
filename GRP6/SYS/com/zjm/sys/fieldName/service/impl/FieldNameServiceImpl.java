package com.zjm.sys.fieldName.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.Sys_fieldNameMapper;
import com.zjm.sys.db.model.Sys_fieldName;
import com.zjm.sys.fieldName.service.FieldNameService;
@Service("fieldNameService")
@Transactional
public class FieldNameServiceImpl implements FieldNameService{
	@Resource 
	private Sys_fieldNameMapper  sys_fieldNameMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 获取字段与字段名Map
	 * @return
	 */
	@Override
	public Map<String,String> selectFieldNameMap(String listID) {
		List<Sys_fieldName> fieldNameList = sys_fieldNameMapper.selectFieldNameList(listID);
		Map<String, String> map =new HashMap<>();
		for(Sys_fieldName fieldName:fieldNameList){
			map.put(fieldName.getField(), fieldName.getFieldName());
		}
		return map;
	}

}

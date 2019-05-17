package com.zjm.pro.dynamic.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.map.Pro_dynamicMapper;
import com.zjm.pro.db.model.Pro_dynamic;
import com.zjm.pro.dynamic.service.DynamicService;
import com.zjm.sys.db.model.Sys_roles;


@Service("dynamicService")
@Transactional
public class DynamicServiceImpl implements DynamicService{
	
	@Resource
	private DynamicService dynamicService;
	@Resource
	private Pro_dynamicMapper pro_dynamicMapper;
	
	@Override
	public Boolean insertOneProDynamic(Pro_dynamic prodynamic) {
	if(pro_dynamicMapper.insertOneProDynamic(prodynamic)==1){
		return true;
	}
		return false;
	}
	@Override
	public List<Pro_dynamic> selectProDynamicList(String whereSql) {
		List<Pro_dynamic> list=new ArrayList<Pro_dynamic>();
		try {
			list = pro_dynamicMapper.selectProDynamicList(whereSql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Pro_dynamic> selectIndexProDynamicList(String whereSql) {
		List<Pro_dynamic> list=new ArrayList<Pro_dynamic>();
		try {
			list = pro_dynamicMapper.selectIndexProDynamicList(whereSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Boolean deleteProDynamicByDynamicID(String applyID) {
		if(pro_dynamicMapper.deleteProDynamicByDynamicID(applyID)==1){
			return true;
		}
		return false;
	}
	@Override
	public Pro_dynamic selectOneProDynamic(String dynamic_ID) {
		
		return pro_dynamicMapper.selectOneProDynamic(dynamic_ID);
	}
	@Override
	public Integer selectProDynamicCount(String applyID) {
		// TODO Auto-generated method stub
	int a=1;
	try {
		a = pro_dynamicMapper.selectProDynamicCount(applyID);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return a;
	}
	@Override
	public Boolean updateProDynamicList(String whereSql) {
if( pro_dynamicMapper.updateProDynamicList(whereSql)==1)
	{
	return true;
	}
return false;
	}
	@Override
	public PageTable selectProDynamicTables(PageTable pageTable) {
		List<Pro_dynamic> list=pro_dynamicMapper.selectProDynamicTables(pageTable);
		Long total=pro_dynamicMapper.selectProDynamicTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	
	

}

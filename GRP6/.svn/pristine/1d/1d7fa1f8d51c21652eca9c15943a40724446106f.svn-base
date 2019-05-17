package com.zjm.sys.listSet.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.Sys_listSetMapper;
import com.zjm.sys.db.model.Sys_listSet;
import com.zjm.sys.listSet.service.ListSetService;
import com.zjm.util.Tool;
@Service("listSetService")
@Transactional
public class ListSetServiceImpl implements ListSetService{
	@Resource 
	private Sys_listSetMapper  sys_listSetMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 获取一个自定义列表信息
	 * @return
	 */
	@Override
	public Sys_listSet selectOneListSetInfo(User user,String listBH) {
		String wheresql="  and listBH = \'"+listBH+"\'";
		wheresql = wheresql + "  and unit_uid = \'"+(user.getUnit_uid())+"\'";
		Sys_listSet selectOneListSetInfo = sys_listSetMapper.selectOneListSetInfo(wheresql);
		if (selectOneListSetInfo == null) {
			wheresql="  and listBH = \'"+listBH+"\'";
			selectOneListSetInfo = sys_listSetMapper.selectOneListSetInfo(wheresql);
		}
		
		return selectOneListSetInfo;
	}

	/**
	 * 修改一个自定义列表信息
	 * @return
	 */
	@Override
	public Boolean updateOneListSetInfo(User user,Sys_listSet sys_listSet) {
		try {
			sys_listSet.setUnit_uid(user.getUnit_uid());
			sys_listSetMapper.updateOneListSetInfo(sys_listSet);
			logService.insertOneOperatorLogInfo(user,"自定义栏目列表", "修改", "修改列表设置表信息");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 添加一个自定义列表信息
	 * @return
	 */
	@Override
	public Boolean insertOneListSetInfo(User user,Sys_listSet sys_listSet) {
		try {
			sys_listSet.setListSetID(Tool.createUUID32());
			sys_listSet.setUnit_uid(user.getUnit_uid());
			sys_listSetMapper.insertOneListSetInfo(sys_listSet);
			logService.insertOneOperatorLogInfo(user,"自定义栏目列表", "添加", "添加列表设置表信息");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

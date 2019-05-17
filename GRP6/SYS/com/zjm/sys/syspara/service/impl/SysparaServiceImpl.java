package com.zjm.sys.syspara.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.map.Sys_sysparaMapper;
import com.zjm.sys.db.model.Sys_syspara;
import com.zjm.sys.syspara.service.SysparaService;

@Service("sysparaService")
@Transactional
public class SysparaServiceImpl implements SysparaService{

	@Resource
	Sys_sysparaMapper sysparaMapper;
	/**
	 * 系统参数列表
	 */
	@Override
	public PageTable selectSysparaPageTables(PageTable pageTable) {
		List<Sys_syspara> sysparaPageTables = sysparaMapper.selectSysparaPageTables(pageTable);
		Long number = sysparaMapper.selectSysparaPageTables_Count(pageTable);
		pageTable.setRows(sysparaPageTables);
		pageTable.setTotal(number);
		return pageTable;
	}
	
	/**
	 * 查询一个系统参数信息
	 * @return
	 */
	@Override
	public Sys_syspara selectOneSysparaInfo(String syspara_ID) {
		return sysparaMapper.selectOneSysparaInfo(syspara_ID);
	}

	/**
	 * 更新一个系统参数信息
	 * @return
	 */
	@Override
	public Boolean updateOneSysparaInfo(User user,Sys_syspara sys_syspara) {
		sys_syspara.setUpdate_user(user.getUser_name());
		return sysparaMapper.updateOneSysparaInfo(sys_syspara);
	}
	
	
	
}
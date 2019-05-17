package com.zjm.sys.syspara.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_syspara;

public interface SysparaService{

	/**
	 * 系统参数列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectSysparaPageTables(PageTable pageTable);

	/**
	 * 查询一个系统参数信息
	 * @return
	 */
	public Sys_syspara selectOneSysparaInfo(String syspara_ID);

	/**
	 * 更新一个系统参数信息
	 * @param user 
	 * @return
	 */
	public Boolean updateOneSysparaInfo(User user, Sys_syspara sys_syspara);

	
}
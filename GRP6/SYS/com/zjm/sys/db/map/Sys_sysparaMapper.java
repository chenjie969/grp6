package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_syspara;

public interface Sys_sysparaMapper {

	/**
	 * 获取系统参数分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Sys_syspara> selectSysparaPageTables(PageTable pageTable);

	/**
	 * 获取系统参数分页列表总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectSysparaPageTables_Count(PageTable pageTable);

	/**
	 * 查询一个系统参数信息
	 * @return
	 */
	public Sys_syspara selectOneSysparaInfo(String syspara_ID);

	/**
	 * 更新一个系统参数信息
	 * @return
	 */
	public Boolean updateOneSysparaInfo(Sys_syspara sys_syspara);
	
}

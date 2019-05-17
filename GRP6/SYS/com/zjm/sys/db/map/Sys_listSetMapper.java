package com.zjm.sys.db.map;

import com.zjm.sys.db.model.Sys_listSet;

public interface Sys_listSetMapper {

	/**
	 * 获取一个自定义列表信息
	 * @return
	 */
	public Sys_listSet selectOneListSetInfo(String wheresql);

	
	/**
	 * 修改一个自定义列表信息
	 * @return
	 */
	public Boolean updateOneListSetInfo(Sys_listSet sys_listSet);

	/**
	 * 添加一个自定义列表信息
	 * @return
	 */
	public Boolean insertOneListSetInfo(Sys_listSet sys_listSet);
	

    
}
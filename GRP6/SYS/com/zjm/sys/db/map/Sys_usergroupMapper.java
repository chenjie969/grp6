package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_usergroup;

public interface Sys_usergroupMapper {
	/***
	 *  返回项目组分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Sys_usergroup> selectUserGroupPageTables(PageTable pageTable);
	/**
	 *  返回项目组分页列表记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectUserGroupPageTables_Count(PageTable pageTable);
	/**
	 * 插入一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Integer insertOneUserGroupInfo(Sys_usergroup sys_usergroup);
	/**
	 * 判断项目组名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Integer selectUserGroupNameIsExist(String wheresql);
	/**
	 * 查询一个项目组信息
	 * @param usergroup
	 * @return
	 */
	public Sys_usergroup selectOneUserGroupInfo(Sys_usergroup usergroup);
	/**
	 * 更新一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Integer updateOneUserGroupInfo(Sys_usergroup sys_usergroup);
	/**
	 * 删除一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Integer delectOneUserGroupInfo(Sys_usergroup sys_usergroup);
	/**
	 * 查询项目组列表List
	 * @param wheresql
	 * @return
	 */
	public List<Sys_usergroup> selectUserGroupList(String wheresql);

}

package com.zjm.sys.userGroup.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_usergroup;

/**
 * 项目组设置
 * @author mashuo  add 20170512
 *
 */
public interface UserGroupService {
	/**
	 * 返回项目组分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectUserGroupPageTables(PageTable pageTable);
	/**
	 * 插入一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Boolean insertOneUserGroupInfo(Sys_usergroup sys_usergroup);
	/**
	 * 判断项目组名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Boolean selectUserGroupNameIsExist(String wheresql);
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
	public Boolean updateOneUserGroupInfo(Sys_usergroup sys_usergroup);
	/**
	 * 删除一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	public Boolean delectOneUserGroupInfo(Sys_usergroup sys_usergroup);
	/**
	 * 查询项目组列表List
	 * @param wheresql
	 * @return
	 */
	public java.util.List<Sys_usergroup> selectUserGroupList(String wheresql);

}

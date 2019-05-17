package com.zjm.sys.roles.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_roles;

/**
 * 角色设置
 * @author mashuo  add 20170524
 *
 */
public interface RolesService {
	/**
	 * 返回角色分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectRolesPageTables(PageTable pageTable);
	/**
	 * 插入一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Boolean insertOneRolesInfo(Sys_roles sys_roles);
	/**
	 * 判断角色名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Boolean selectRolesNameIsExist(String wheresql);
	/**
	 * 查询一个角色信息
	 * @param usergroup
	 * @return
	 */
	public Sys_roles selectOneRolesInfo(Sys_roles usergroup);
	/**
	 * 更新一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Boolean updateOneRolesInfo(Sys_roles sys_roles);
	/**
	 * 删除一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Boolean delectOneRolesInfo(Sys_roles sys_roles);
	/**
	 * 查询角色列表List
	 * @param wheresql
	 * @return
	 */
	public java.util.List<Sys_roles> selectRolesList(String wheresql);
	/**
	 * 对一个角色授权
	 * @param sys_roles
	 * @return
	 */
	public Boolean updateOneRolesAccreditInfo(Sys_roles sys_roles);
	
	/**
	 * 测试sql
	 */
	public void testSql();

}

package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_roles;

public interface Sys_rolesMapper {
	/***
	 *  返回角色分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Sys_roles> selectRolesPageTables(PageTable pageTable);
	/**
	 *  返回角色分页列表记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectRolesPageTables_Count(PageTable pageTable);
	/**
	 * 插入一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Integer insertOneRolesInfo(Sys_roles sys_roles);
	/**
	 * 判断角色名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Integer selectRolesNameIsExist(String wheresql);
	/**
	 * 查询一个角色信息
	 * @param roles
	 * @return
	 */
	public Sys_roles selectOneRolesInfo(Sys_roles roles);
	/**
	 * 更新一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Integer updateOneRolesInfo(Sys_roles sys_roles);
	/**
	 * 删除一个角色信息
	 * @param sys_roles
	 * @return
	 */
	public Integer delectOneRolesInfo(Sys_roles sys_roles);
	/**
	 * 查询角色列表List
	 * @param wheresql
	 * @return
	 */
	public List<Sys_roles> selectRolesList(String wheresql);

}

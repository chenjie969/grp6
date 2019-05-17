package com.zjm.sys.db.map;


import com.zjm.sys.db.model.Sys_role_module;
import com.zjm.sys.db.model.Sys_roles;

public interface Sys_role_moduleMapper {
	/**
	 * 插入一个菜单与角色关联表信息
	 * @param sys_role_user
	 * @return
	 */
	public Integer insertOneModuleAndRolesInfo(Sys_role_module sys_role_module);
	/**
	 * 删除一个菜单与角色关联表信息
	 * @param sys_roles
	 * @return
	 */
	public Integer delectModuleAndRolesInfo(Sys_roles sys_roles);

}

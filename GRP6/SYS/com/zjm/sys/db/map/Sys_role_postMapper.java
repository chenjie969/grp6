package com.zjm.sys.db.map;

import com.zjm.sys.db.model.Sys_role_post;
import com.zjm.sys.db.model.Sys_roles;

public interface Sys_role_postMapper {
	/**
	 * 插入一个岗位与角色关联表信息
	 * @param sys_role_user
	 * @return
	 */
	public Integer insertOnePostAndRolesInfo(Sys_role_post sys_role_post);
	/**
	 * 删除一个岗位与角色关联表信息
	 * @param sys_roles
	 * @return
	 */
	public Integer delectPostAndRolesInfo(Sys_roles sys_roles);

}

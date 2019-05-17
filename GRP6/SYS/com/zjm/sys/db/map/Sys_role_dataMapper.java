package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.Sys_role_data;
import com.zjm.sys.db.model.Sys_roles;

/**
 * @author xujy@erongdu.com
 * 2017-12-27 
 *
 */
public interface Sys_role_dataMapper {
	
	/**
	 * 新增角色与数据授权记录
	 * @param roleData
	 * @return
	 */
	Integer insertOneDataAndRolesInfo(Sys_role_data roleData);
	
	/**
	 * 根据角色id，删除角色与授权记录
	 * @param roleData
	 * @return
	 */
	Integer deleteDataAndRolesInfoByRoleId(Sys_roles sysRole);
	
	/**
	 * 根据roleID，查询角色数据。
	 * @param roleId
	 * @return
	 */
	List<Sys_role_data> selectByRoleId(String roleId);
	
	/**
	 * 根据角色id和operationId更新
	 * @param roleData
	 * @return
	 */
	int updateOneSysRolesData(Sys_role_data roleData);
	
	/**
	 * 根据用户查id查用户的数据授权信息
	 * @param userId
	 * @return
	 */
	List<Sys_role_data> selectClientDataByUserId( String userId);
	
	/**
	 * 根据用户查id查项目的数据授权信息
	 * @param userId
	 * @return
	 */
	List<Sys_role_data> selectProDataByUserId(String userId);
	
	/**根据角色id 和 业务类型确定一条数据
	 * @param roleData
	 * @return
	 */
	Sys_role_data selectOneData(Sys_role_data roleData);

	void testSqlOne();

	void testSqlTwo();
	
}

package com.zjm.sys.users.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_users;
/**
 * 用户设置
 * @author duanhuawei add 20170427
 */
public interface UsersService {
	/**
	 * 查询所有用户
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<Sys_users> selectAllUsersList(String wheresql);
	/**
	 * 插入一个用户信息
	 * @param sys_users
	 * @return
	 */
	public Boolean insertOneUsersInfo(User user,Sys_users sys_users);
	/**
	 * 查询一个用户信息
	 * @param sys_users
	 * @return
	 */
	public Sys_users selectOneUsersInfo(Sys_users sys_users);
	/**
	 * 更新一个用户信息
	 * @param sys_users
	 * @return
	 */
	public Boolean updateOneUsersInfo(User user,Sys_users sys_users);
	/**
	 * 删除一个用户信息
	 * @param sys_users
	 * @return
	 */
	public Boolean deleteOneUsersInfo(User user,Sys_users sys_users);
	/**
	 * 查询用户列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<Sys_users> selectUsersPageTables(PageTable<Sys_users> pageTable);
	
	/**
	 * 查询同岗位下的用户列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<Sys_users> selectPostUsersPageTables(PageTable<Sys_users> pageTable);
	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectUsersIsExist(String wheresql);
	/**
	 * 判断密码是否修改
	 * @param wheresql
	 * @return  true修改了 false没修改
	 */
	public Boolean selectUsersIsUpdatePwd(Sys_users sys_user);
	
	/**
	 * 获取部门下的人员
	 * @param wheresql
	 */
	public List<Sys_users> selectUsersListByDepartUid(String wheresql);

	/**
	 * 根据用户id获取用户所在部门
	 * @param userId
	 * @return
	 */
	public Sys_departs getDepartByUserId(String userId);
}

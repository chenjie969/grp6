package com.zjm.sys.users.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.sys.db.map.Sys_dep_userMapper;
import com.zjm.sys.db.map.Sys_post_userMapper;
import com.zjm.sys.db.map.Sys_role_userMapper;
import com.zjm.sys.db.map.Sys_user_usergroupMapper;
import com.zjm.sys.db.map.Sys_usersMapper;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.model.Sys_dep_user;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_post;
import com.zjm.sys.db.model.Sys_post_user;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.post.service.PostService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.Tool;
/**
 * 用户设置
 * @author duanhuawei add 20170427
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService{
	@Resource 
	private Sys_usersMapper  sys_usersMapper;
	@Resource 
	private Sys_dep_userMapper  sys_dep_userMapper;
	@Resource
	private LogService logService;
	@Resource
	private Sys_post_userMapper  sys_post_userMapper;
	@Resource
	private PostService postService;
	@Resource
	private Sys_role_userMapper sys_role_userMapper;
	@Resource
	private Sys_user_usergroupMapper sys_user_usergroupMapper;
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Sys_users> selectAllUsersList(String wheresql) {
		return sys_usersMapper.selectAllUsersList(wheresql);
	}

	/**
	 * 插入一个用户信息
	 * @return
	 */
	public Boolean insertOneUsersInfo(User user,Sys_users sys_users) {
		sys_users.setUser_uid(Tool.createUUID32());
		//sys_users.setUnit_uid(user.getUnit_uid());
		//sys_users.setUnit_uidName(user.getUnit_uidName());
		sys_users.setUser_bh(this.getUserBh());
		sys_users.setCreate_user(user.getUser_name());
		sys_users.setOrder_id(sys_usersMapper.selectUsersOrderId(sys_users));
		int count = sys_usersMapper.insertOneUsersInfo(sys_users);
		// 添加部门与用户关联关系
		Sys_dep_user sys_dep_user = new Sys_dep_user();
		sys_dep_user.setDepart_uid(sys_users.getDepart_uid());
		sys_dep_user.setUser_uid(sys_users.getUser_uid());
		sys_dep_user.setUnit_uid(sys_users.getUnit_uid());
		sys_dep_user.setIs_otherdep(0);
		sys_dep_userMapper.insertOneDepUserInfo(sys_dep_user);
		
		//添加岗位和用户 对应关系表
		if( null!= sys_users.getPost_ID() && !"".equals(sys_users.getPost_ID())){  // 岗位id不为空
			Sys_post_user  postUser=new Sys_post_user();
			postUser.setUnit_uid(sys_users.getUnit_uid());
			postUser.setPost_ID(sys_users.getPost_ID());
			postUser.setUser_uid(sys_users.getUser_uid());
			sys_post_userMapper.insertOnePostUserInfo(postUser);
		}
		
		if(count==1){
			logService.insertOneOperatorLogInfo(user,"用户管理", "添加", sys_users.getUser_name());
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 自动生成3位用户编号，最大值加1，补满3位
	 * @return
	 */
	private String getUserBh(){
		String retMaxUserBh = null;
		String maxUserBh = sys_usersMapper.selectMaxUserBh();
		if (maxUserBh != null && !"".equals(maxUserBh)) {
			int intUserBh = Integer.parseInt(maxUserBh);
			retMaxUserBh = (intUserBh + 1) + "";
			if (retMaxUserBh.length() == 1) {
				retMaxUserBh = "00" + retMaxUserBh;
			} else if (retMaxUserBh.length() == 2) {
				retMaxUserBh = "0" + retMaxUserBh;
			}
		}
		return retMaxUserBh;
	}
	
	/**
	 * 查询一个用户信息
	 * @return
	 */
	public Sys_users selectOneUsersInfo(Sys_users sys_users) {
		//获取岗位id --- sys_post_user 关联表
		String wheresql=" and unit_uid='"+sys_users.getUnit_uid()+"' and user_uid ='"+sys_users.getUser_uid()+"'";
		List<Sys_post_user> postUserList = sys_post_userMapper.selectPostUserList(wheresql);
		//获取岗位名称
		Sys_users user = sys_usersMapper.selectOneUsersInfo(sys_users);
		if(postUserList.size() > 0){
			Sys_post	sys_post =new Sys_post();
			sys_post.setPost_ID(postUserList.get(0).getPost_ID());
			Sys_post postInfo = postService.selectOnePostInfo(sys_post);
			// set 岗位名称
			user.setPostName(postInfo.getPostName());
		}
		return user;
	}
	/**
	 * 更新一个用户信息
	 * @return
	 */
	public Boolean updateOneUsersInfo(User user,Sys_users sys_users) {
		
		if(selectUsersIsUpdatePwd(sys_users)){
			//修改了
			sys_users.setUserpassword(Tool.MD5(sys_users.getUserpassword()));
		}
		// 清空 岗位与用户关联表
		Sys_post_user  postUser=new Sys_post_user();
		postUser.setUnit_uid(sys_users.getUnit_uid());
		postUser.setUser_uid(sys_users.getUser_uid());
	 	sys_post_userMapper.deleteOnePostUserInfo(postUser);
		// 添加岗位与用户关联表
	 	if(null !=sys_users.getPost_ID() && !"".equals(sys_users.getPost_ID())){ // 岗位id不为空
	 		postUser.setPost_ID(sys_users.getPost_ID());
	 		sys_post_userMapper.insertOnePostUserInfo(postUser);
	 	}
	 	//如果部门id不为空,即进行了部门的变更;
	 	if(null !=sys_users.getDepartUid() && !"".equals(sys_users.getDepartUid())){
	 		Sys_dep_user  depUser=new Sys_dep_user();
		 	depUser.setUnit_uid(sys_users.getUnit_uid());
		 	depUser.setUser_uid(sys_users.getUser_uid());
		 	Sys_dep_user depUserInfo = sys_dep_userMapper.selectOneDepUserInfo(depUser);
		 	depUserInfo.setDepart_uid(sys_users.getDepartUid());
		 	depUserInfo.setDepart_uid_old(sys_users.getDepartOldId());//存入带上来的原部门id用于确定一条数据。
		 	sys_dep_userMapper.updateOneDepUserInfo(depUserInfo);
	 	}
		if(sys_usersMapper.updateOneUsersInfo(sys_users)==1){
			logService.insertOneOperatorLogInfo(user,"用户管理", "修改", sys_users.getUser_name());
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除一个用户信息
	 * @return
	 */
	public Boolean deleteOneUsersInfo(User user,Sys_users sys_users) {
		Sys_dep_user dUser = new Sys_dep_user();
		dUser.setUser_uid(sys_users.getUser_uid());
		sys_dep_userMapper.deleteOneDepUserInfoByUserId(dUser);
		Sys_post_user  postUser=new Sys_post_user();
		postUser.setUnit_uid(sys_users.getUnit_uid());
		postUser.setUser_uid(sys_users.getUser_uid());
		// 删除岗位和用户关联表
		try {
			sys_post_userMapper.deleteOnePostUserInfo(postUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//根据用户user_uid删除用户组和用户的关系
		sys_user_usergroupMapper.delectUserAndUserGroupInfoByUserUid(sys_users.getUser_uid());
		//根据用户user_uid删除角色和用户的关系
		sys_role_userMapper.delectUserAndRolesInfoByUserUid(sys_users.getUser_uid());
		Integer deleteOneUsersInfo=0;
		try {
			deleteOneUsersInfo = sys_usersMapper.deleteOneUsersInfo(sys_users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(deleteOneUsersInfo==1){
			logService.insertOneOperatorLogInfo(user,"用户管理", "删除", sys_users.getUser_name());
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 查询用户列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<Sys_users> selectUsersPageTables(PageTable<Sys_users> pageTable) {
		
		List<Sys_users> list=sys_usersMapper.selectUsersPageTables(pageTable);
		for (Sys_users sys_users : list) {
			//获取 岗位和用户关联表信息
			String wheresql=" and unit_uid= '"+sys_users.getUnit_uid()+"' and user_uid= '"+sys_users.getUser_uid()+"'";
			List<Sys_post_user> postUserList = sys_post_userMapper.selectPostUserList(wheresql);
			if(postUserList.size() > 0){
				Sys_post sys_post=new Sys_post();
				sys_post.setPost_ID(postUserList.get(0).getPost_ID());
				Sys_post postInfo = postService.selectOnePostInfo(sys_post);
				sys_users.setPostName(postInfo.getPostName());
			}
		}
		Long total=sys_usersMapper.selectUsersPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	
	
	/**
	 * 此机构此岗位下的用户列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<Sys_users> selectPostUsersPageTables(PageTable<Sys_users> pageTable) {
		
		List<Sys_users> list=sys_usersMapper.selectPostUsersPageTables(pageTable);
		Long total=sys_usersMapper.selectPostUsersPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectUsersIsExist(String wheresql) {
		if(sys_usersMapper.selectUsersIdIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断密码是否修改
	 * @param wheresql
	 * @return  true修改了 false没修改
	 */
	public Boolean selectUsersIsUpdatePwd(Sys_users sys_user) {
		if(sys_usersMapper.selectUsersIsUpdatePwd(sys_user)==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Sys_users> selectUsersListByDepartUid(String wheresql) {
		List<Sys_users> usersList =  sys_usersMapper.selectUsersListByDepartUid(wheresql);
		return usersList;
	}

	@Override
	public Sys_departs getDepartByUserId(String userId) {
		Sys_departs depart = sys_usersMapper.getDepartByUserId(userId);
		return depart;
	}
	
}

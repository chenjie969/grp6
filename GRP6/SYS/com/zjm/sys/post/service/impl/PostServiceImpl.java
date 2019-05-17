package com.zjm.sys.post.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.Sys_dep_postMapper;
import com.zjm.sys.db.map.Sys_postMapper;
import com.zjm.sys.db.map.Sys_post_userMapper;
import com.zjm.sys.db.map.Sys_usersMapper;
import com.zjm.sys.db.model.Sys_dep_post;
import com.zjm.sys.db.model.Sys_post;
import com.zjm.sys.db.model.Sys_post_user;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.post.service.PostService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
/**
 * 岗位设置
 * @author zky  add 20170504
 */
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{
	@Resource 
	private Sys_postMapper  sys_postMapper;
	@Resource 
	private Sys_post_userMapper  sys_post_userMapper;
	@Resource
	private LogService logService;
	@Resource 
	private Sys_usersMapper  sys_usersMapper;
	
	@Resource
	private Sys_dep_postMapper  sys_dep_postMapper;
	
	
	/**
	 * 插入一个岗位信息
	 * @return
	 */
	public Boolean insertOnePostInfo(Sys_post sys_post,User user ) {
		try{
			sys_post.setPost_ID(Tool.createUUID32());
			Sys_post pSys_post = sys_postMapper.selectParentPostInfo(sys_post);
			String postFullCode = null;
			if (pSys_post != null) {
				postFullCode = pSys_post.getPostFullCode()+sys_post.getPost_ID()+"/";
			} else {
				postFullCode = sys_post.getPost_ID()+"/";
			}
			sys_post.setPostFullCode(postFullCode);
			if(sys_postMapper.insertOnePostInfo(sys_post)==1){
				logService.insertOneOperatorLogInfo(user,"岗位设置", "添加", sys_post.getPostName());
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询岗位信息分页列表;
	 * @param pageTable
	 * @return :PageTable 
	 */
	public PageTable selectPostPageTables(PageTable pageTable) {
		List<Sys_post> postList = sys_postMapper.selectPostPageTables(pageTable);
		getUserName(postList);
		Long total = sys_postMapper.selectPostPageTables_Count(pageTable);
		pageTable.setRows(postList);
	    pageTable.setTotal(total);
		return pageTable;
	}
	/**
	 * 
	 * @description	通过 岗位id 和机构id,获取该岗位下的用户id
	 * @author wuhn
	 * @date 2017年6月7日 上午10:45:46
	 */
	private void getUserName(List<Sys_post> postList) {
		for (Sys_post post : postList) {
			String sql=" and unit_uid= '"+post.getUnit_uid() +"'"+"	and	post_ID = '"+post.getPost_ID()+"'";
			List<Sys_post_user> postUserList = sys_post_userMapper.selectPostUserList(sql); //岗位和用户关联集合
			//用户信息存入到 岗位集合中
			String post_UserName="";
			int index=0;
			for (Sys_post_user post_user : postUserList) {
				Sys_users   users= new  Sys_users();
				users.setUser_uid(post_user.getUser_uid());
				Sys_users usersInfo = sys_usersMapper.selectOneUsersInfo(users);
				if( index == 0){
					post_UserName+=""+usersInfo.getUser_name();
					index++;
				}else{
					post_UserName+=","+usersInfo.getUser_name();
				}
			}
			post.setPost_User(post_UserName);
		}
		
	}
	/**
	 *查询所有岗位信息
	 *@return : List<Sys_post>
	 *@param  : wheresql
	 */
	public List<Sys_post> selectAllPostList(String wheresql) {
		List<Sys_post> postList = sys_postMapper.selectAllPostList(wheresql);
		return postList;
	}
	/**
	  *查询一个岗位信息
	 *@return : Sys_post
	 *@param  : sys_post
	 */
	public Sys_post selectOnePostInfo(Sys_post sys_post) {
		Sys_post onePost = sys_postMapper.selectOnePostInfo(sys_post);
		Sys_post pPost = sys_postMapper.selectParentPostInfo(onePost);
		if (pPost != null) {
			onePost.setParentPostName(pPost.getPostName());
		}
		List<Sys_post> postList=new ArrayList<>();
		postList.add(onePost);
		getUserName(postList);
		return onePost;
	}
	/**
	 * 修改一个岗位信息
	 *@return : Sys_post
	 *@param  : Boolean
	 */
	public Boolean updateOnePostInfo(Sys_post sys_post,User user ) {
		try{
			Sys_post post = sys_postMapper.selectOnePostInfo(sys_post);	
			 post.setPostCode(sys_post.getPostCode());//更相信岗位代码;
			 post.setPostName(sys_post.getPostName());
			 post.setPostDescription(sys_post.getPostDescription());
			Integer returnInt = sys_postMapper.updateOnePostInfo(post);
			if(returnInt == 1){
				logService.insertOneOperatorLogInfo(user,"岗位设置", "修改", sys_post.getPostName());
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除一个岗位信息;
	 * @return boolean
	 * @param sys_post
	 */
	public Boolean deleteOnePostInfo(Sys_post sys_post,User user ) {
		
		deleteOneDownPostInfo(sys_post,user);
				
		Integer returnInt = sys_postMapper.deleteOnePostInfo(sys_post);
		
		if(returnInt == 1){
			logService.insertOneOperatorLogInfo(user,"岗位设置", "删除", sys_post.getPostName());
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * 判断岗位名称是否存在;
	 * @return: Boolean
	 * @param : wheresql
	 */
	public Boolean selectPostIsExist(String wheresql) {
		if(sys_postMapper.selectPostIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 子方法删除子岗位;
	 * @param : sys_post;
	 * @return : boolean;
	 */	
	public Boolean deleteOneDownPostInfo(Sys_post sys_post,User user ) {
		try {
			//判断是否有下级岗位;
			List<Sys_post> allPostList = sys_postMapper
					.selectAllPostList(" and parentPostID = \'" + sys_post.getPost_ID() + "\'");
			for (Sys_post post : allPostList) {
				deleteOneDownPostInfo(post,user);
				sys_postMapper.deleteOnePostInfo(post);
				logService.insertOneOperatorLogInfo(user,"岗位设置", "修改", post.getPostName());
			} 
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 为岗位分配用户
	 * 
	 * 
	 */
	public Boolean assignPostUser(String post_ID, String[] userIds,String unit_uid) {
		
		try {
			if (post_ID != null) {
				sys_post_userMapper.deleteOnePostUserInfo(null);
				for (String user_uid : userIds) {
					Sys_post_user post_user = new Sys_post_user();
					post_user.setPost_ID(post_ID);
					post_user.setUser_uid(user_uid);
					post_user.setUnit_uid(unit_uid);
					sys_post_userMapper.insertOnePostUserInfo(post_user);
				}
			} 
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	/**
	 * @description	获取岗位信息 list  由部门id和机构id获取岗位信息
	 * @author wuhn
	 * @date 2017年6月7日 下午8:25:09
	 */
	@Override
	public List<Sys_post> selectPostListByDepart(Sys_dep_post sys_dep_post) {
		List<Sys_dep_post> depPostList = sys_dep_postMapper.selectDepPostList(sys_dep_post);
		String wheresql="";
		if(depPostList.size() > 0){
			wheresql+=" and post_ID in ('";
			for (Sys_dep_post dep_post : depPostList) {
				wheresql+=dep_post.getPost_ID()+"' , '";
			}
			wheresql = wheresql.substring(0,wheresql.lastIndexOf(","))+")"; // 拼接sql
		}else{
			wheresql+="and unit_uid= ' unknow'"; //若部门下未设置岗位
		}
		List<Sys_post> postList=new ArrayList<>();
		try {
			postList = sys_postMapper.selectAllPostList(wheresql);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return postList;
	}

	

}

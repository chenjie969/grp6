package com.zjm.sys.post.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_dep_post;
import com.zjm.sys.db.model.Sys_post;
/**
 * 岗位设置
 * @author zky add 20170504
 */
public interface PostService {
	
	/**
	 * 插入一个岗位
	 * @param 
	 * @return
	 */
	public Boolean insertOnePostInfo(Sys_post sys_post,User user );
	/**
	 * 查询岗位分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectPostPageTables(PageTable pageTable);
	/**
	 * 查询所有岗位
	 * @param wheresql 
	 * @param searchText 
	 * @param pageNumber 
	 * @param pageSize 
	 * @return
	 */
	public List<Sys_post> selectAllPostList(String wheresql);
	/**
	 * 查询一个岗位
	 * @param sys_post
	 * @return
	 */
	public Sys_post selectOnePostInfo(Sys_post sys_post);
	/**
	 * 更新一个岗位
	 * @param sys_post
	 * @return
	 */
	public Boolean updateOnePostInfo(Sys_post sys_post,User user );
	/**
	 * 删除一个岗位
	 * @param sys_post
	 * @return
	 */
	public Boolean deleteOnePostInfo(Sys_post sys_post,User user );
	/**
	 * 查看岗位名字是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectPostIsExist(String wheresql);
	
	
	/**
	 * 为岗位分配用户
	 * @param post_ID
	 * @param userIds
	 * @return
	 */
	public Boolean assignPostUser(String post_ID, String[] userIds,String unit_uid);
	
	/**
	 * @description	由部门id 和机构id 获取岗位信息
	 * @author wuhn
	 * @date 2017年6月7日 下午8:30:56
	 */
	public List<Sys_post> selectPostListByDepart(Sys_dep_post  sys_dep_post);
}

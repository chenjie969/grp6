package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.Sys_post_user;


/**
 * 岗位用户关联mapper   
 * @author zky  add 20170506
 */
public interface Sys_post_userMapper {
	/**
	 * 删除一条岗位用户关联记录  根据用户id
	 * @param Post_ID
	 * @return
	 */
    public Integer deleteOnePostUserInfo(Sys_post_user  sys_post_user);
    /**
     * 插入一条关联记录
     * @param sys_post_user
     * @return
     */
    public Integer insertOnePostUserInfo(Sys_post_user sys_post_user);
	
    /**
	 * 查询此机构此岗位上是否存在此用户
	 * @param post_ID
	 * @param user_uid
	 * @param unit_uid
	 * @return
	 */
    public Long getPostUserCountByIds(String post_ID, String user_uid, String unit_uid);
    
    
    /**
     * 
     * @description	根据机构id 和用户id 查询岗位信息
     * @author wuhn
     * @date 2017年6月7日 上午11:03:07
     */
    List<Sys_post_user>  selectPostUserList(String wheresql);
	
}








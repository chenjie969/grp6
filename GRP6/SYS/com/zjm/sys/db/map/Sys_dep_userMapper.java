package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.Sys_dep_user;


/**
 * 部门用户关联mapper   
 * @author duanhuawei  add 20170426
 */
public interface Sys_dep_userMapper {
	/**
	 * 删除一条关联记录根据部门ID
	 * @param sys_dep_user
	 * @return
	 */
    public Integer deleteOneDepUserInfo(Sys_dep_user sys_dep_user);
    /**
     * 插入一条关联记录
     * @param sys_dep_user
     * @return
     */
    public Integer insertOneDepUserInfo(Sys_dep_user sys_dep_user);
    /**
	 * 删除一条关联记录根据用户ID
	 * @param sys_dep_user
	 * @return
	 */
    public Integer deleteOneDepUserInfoByUserId(Sys_dep_user sys_dep_user);
    
    /**
     * 
     * @description	根据用户id 获取部门信息
     * @author wuhn
     * @date 2017年6月8日 下午5:23:30
     */
    public Sys_dep_user selectOneDepUserInfo(Sys_dep_user sys_dep_user);
    
    /**
     * @description	 根据部门id,获取部门下的用户信息
     * @author wuhn
     * @date 2017年6月8日 下午7:47:24
     */
    public List<Sys_dep_user>	selectOneDepUserListByDepart(Sys_dep_user sys_dep_user);
	/**
	 * 修改部门用户关联
	 * @param depUserInfo
	 */
    public Integer updateOneDepUserInfo(Sys_dep_user depUserInfo);
    
    /**根据用户id 查出同部门的所有用户的用户id
     * @param user_uid 用户id
     * @return 同部门的用户id 
     */
    public List<String> selectUserListByCommonDepUser(String user_uid);
    
    /**根据部门id获取下级部门所有用户的id
     * @param depart_uid 部门id
     * @return
     */
    public List<String> selectfollowDepUserByDepart(String depart_uid);
    
}


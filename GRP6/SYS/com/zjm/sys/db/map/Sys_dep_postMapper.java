package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.sys.db.model.Sys_dep_post;

/**
*  @description 部门与岗位关联表Mapper
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年6月7日 下午7:19:13
*/
public interface Sys_dep_postMapper {
	
	/**
	 * @description	由部门id 和机构id 获取岗位信息
	 * @author wuhn
	 * @date 2017年6月7日 下午7:20:05
	 */
	List<Sys_dep_post> selectDepPostList(Sys_dep_post sys_dep_post);
	
	/**
	 * @description	删除关联表信息
	 * @author wuhn
	 * @date 2017年6月7日 下午7:20:50
	 */
	int deleteDepPostInfo(String wheresql);
	
	/**
	 * 
	 * @description	添加一条 部门--岗位关联记录
	 * @author wuhn
	 * @date 2017年6月7日 下午7:21:33
	 */
	int insertOneDepPostInfo(Sys_dep_post  sys_dep_post);
	
}

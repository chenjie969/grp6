package com.zjm.oa.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.db.model.Hr_staffPosts;

public interface Hr_staffPostsMapper {
	/**
	 * 查询用户列表    分页列表
	 */
	
	List<Hr_staffPosts> selectTransferListByCase_ID(String staffCase_ID);
	
	//根据岗位ID查询
	
		public Hr_staffPosts selectOneByPostId(String postsID);
		//增加
		
		public Integer insertOnePostsInfo(Hr_staffPosts hrstaffPosts);
	
		/**
		 * 更新	
		 */
		public Integer updateOnePostsInfo(Hr_staffPosts hrstaffPosts);
	
}

package com.zjm.oa.db.map;

import java.util.List;

import com.zjm.oa.db.model.Hr_staffPosts;
import com.zjm.oa.db.model.Hr_staffSocialRelations;

public interface Hr_staffSocialRelationsMapper {

	/**
	 * 查询用户列表    分页列表
	 */
	
	List<Hr_staffSocialRelations> selectrelationListByCase_ID(String staffCase_ID);
	
	//根据岗位ID查询
	
		public Hr_staffSocialRelations selectBySocialId(String socialID);
		//增加
		
		public Integer insertSocialrelation(Hr_staffSocialRelations socialRelations);
	
		/**
		 * 更新	
		 */
		public Integer updateSocial(Hr_staffSocialRelations socialRelations);
	
	
	
	
}

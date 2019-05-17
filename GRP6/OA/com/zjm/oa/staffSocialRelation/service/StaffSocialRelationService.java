package com.zjm.oa.staffSocialRelation.service;

import java.util.List;
import com.zjm.oa.db.model.Hr_staffSocialRelations;
public interface StaffSocialRelationService {
	/**
	 * 查询用户列表    分页列表
	 */
	
	List<Hr_staffSocialRelations> selectrelationListByCase_ID(String staffCase_ID);
	
	//根据岗位ID查询
	
		public Hr_staffSocialRelations selectBySocialId(String socialID);
		//增加
		
		public Boolean insertSocialrelation(Hr_staffSocialRelations socialRelations);
	
		/**
		 * 更新	
		 */
		public Boolean updateSocial(Hr_staffSocialRelations socialRelations);
	

}

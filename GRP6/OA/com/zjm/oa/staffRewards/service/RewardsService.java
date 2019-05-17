package com.zjm.oa.staffRewards.service;

import java.util.List;
import com.zjm.oa.db.model.Hr_staffPosts;
import com.zjm.oa.db.model.Hr_staffRewards;
import com.zjm.sys.db.model.Sys_roles;

public interface RewardsService {
	/**
	 * 查询用户列表    分页列表
	 */
	
	List<Hr_staffRewards> selectRewardsrListBy_ID(String staffCase_ID);
	
	//根据岗位ID查询
	
		public Hr_staffRewards selectOneByRewardId(String rewardsID);
		//增加
		
		public Boolean insertOneRewardsInfo(Hr_staffRewards rewardPunishment);
	
		/**
		 * 更新	
		 */
		public Boolean updateOneRewardsInfo(Hr_staffRewards rewardPunishment);

}

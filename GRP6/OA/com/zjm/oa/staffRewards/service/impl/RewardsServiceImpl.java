package com.zjm.oa.staffRewards.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.oa.db.map.Hr_staffRewardsMapper;
import com.zjm.oa.db.model.Hr_staffPosts;
import com.zjm.oa.db.model.Hr_staffRewards;
import com.zjm.oa.staffRewards.service.RewardsService;
import com.zjm.sys.post.service.PostService;

@Service("rewardsService")
@Transactional
public class RewardsServiceImpl implements RewardsService {
	@Resource
	private Hr_staffRewardsMapper hr_staffRewardsMapper;	
	@Resource
	private RewardsService rewardsService;

	@Override
	public List<Hr_staffRewards> selectRewardsrListBy_ID(String staffCase_ID) {
		// TODO Auto-generated method stub
		return hr_staffRewardsMapper.selectRewardsrListBy_ID(staffCase_ID);
	}
	@Override
	public Hr_staffRewards selectOneByRewardId(String rewardsID) {
		// TODO Auto-generated method stub
		return hr_staffRewardsMapper.selectOneByRewardId(rewardsID);
	}
	@Override
	public Boolean insertOneRewardsInfo(Hr_staffRewards rewardPunishment) {
		if(hr_staffRewardsMapper.insertOneRewardsInfo(rewardPunishment)==1){
			return true;
		}
		return false;
	}
	@Override
	public Boolean updateOneRewardsInfo(Hr_staffRewards rewardPunishment) {
	if(hr_staffRewardsMapper.updateOneRewardsInfo(rewardPunishment)==1){
		return true;
	}
		return false;
	}



	
	
	
}

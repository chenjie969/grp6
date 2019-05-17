package com.zjm.oa.staffSocialRelation.service.impl;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.oa.db.map.Hr_staffPostsMapper;
import com.zjm.oa.db.map.Hr_staffSocialRelationsMapper;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.db.model.Hr_staffPosts;
import com.zjm.oa.db.model.Hr_staffSocialRelations;
import com.zjm.oa.staffPosts.service.StaffPostsService;
import com.zjm.oa.staffSocialRelation.service.StaffSocialRelationService;
import com.zjm.sys.post.service.PostService;

@Service("staffSocialRelationService")
@Transactional
public class StaffSocialRelationServiceImpl implements StaffSocialRelationService {
	@Resource
	private Hr_staffSocialRelationsMapper hr_staffSocialRelationsMapper;	
	@Resource
	private StaffSocialRelationService staffSocialRelationService;
	@Override
	public List<Hr_staffSocialRelations> selectrelationListByCase_ID(String staffCase_ID) {
		// TODO Auto-generated method stub
		return hr_staffSocialRelationsMapper.selectrelationListByCase_ID(staffCase_ID);
	}
	@Override
	public Hr_staffSocialRelations selectBySocialId(String socialID) {
		// TODO Auto-generated method stub
		return hr_staffSocialRelationsMapper.selectBySocialId(socialID);
	}
	@Override
	public Boolean insertSocialrelation(Hr_staffSocialRelations socialRelations) {
		
		if(hr_staffSocialRelationsMapper.insertSocialrelation(socialRelations)==1){
			return true;
		}
		return false;
	}
	@Override
	public Boolean updateSocial(Hr_staffSocialRelations socialRelations) {
		// TODO Auto-generated method stub
		if(hr_staffSocialRelationsMapper.updateSocial(socialRelations)==1){
			return true;
		}
		return false;
	}



	
	
	
}

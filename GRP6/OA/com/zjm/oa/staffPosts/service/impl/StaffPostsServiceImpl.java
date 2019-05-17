package com.zjm.oa.staffPosts.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.oa.db.map.Hr_staffPostsMapper;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.db.model.Hr_staffPosts;
import com.zjm.oa.staffPosts.service.StaffPostsService;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.post.service.PostService;

@Service("staffPostsService")
@Transactional
public class StaffPostsServiceImpl implements StaffPostsService {
	@Resource
	private Hr_staffPostsMapper hr_staffPostsMapper;	
	@Resource
	private PostService postService;
	@Resource
	private SysDicDataService sysDicDataService;
	@Override
	public List<Hr_staffPosts> selectTransferListByCase_ID(String staffCase_ID) {
		Map<String,String> bumenMap = sysDicDataService.selectDepartsDicNoEableMap("");			
		List<Hr_staffPosts> postList=hr_staffPostsMapper.selectTransferListByCase_ID(staffCase_ID);		
		for (Hr_staffPosts hr_staffPosts : postList) {
			
			if(hr_staffPosts.getAgoPostsDep()!=null&& !hr_staffPosts.getAgoPostsDep().equals(""))
			{
			
			hr_staffPosts.setAgoPostsDepNmae(bumenMap.get(hr_staffPosts.getAgoPostsDep()));	
			}
			if(hr_staffPosts.getNowPostsDep()!=null && !hr_staffPosts.getNowPostsDep().equals("")){
			
			hr_staffPosts.setNowPostsDepName(bumenMap.get(hr_staffPosts.getNowPostsDep()));
			}			
		}
		
		return postList;
	}
	@Override
	public Hr_staffPosts selectOneByPostId(String postsID) {
		Map<String,String> bumenMap = sysDicDataService.selectDepartsDicNoEableMap("");			
		Hr_staffPosts	hr_staffPosts=hr_staffPostsMapper.selectOneByPostId(postsID);
		
		if(hr_staffPosts.getAgoPostsDep()!=null&& !hr_staffPosts.getAgoPostsDep().equals(""))
		{
		
		hr_staffPosts.setAgoPostsDepNmae(bumenMap.get(hr_staffPosts.getAgoPostsDep()));	
		}
		if(hr_staffPosts.getNowPostsDep()!=null && !hr_staffPosts.getNowPostsDep().equals("")){
		
		hr_staffPosts.setNowPostsDepName(bumenMap.get(hr_staffPosts.getNowPostsDep()));
		}	
		return hr_staffPosts;
	}
	@Override
	public Boolean insertOnePostsInfo(Hr_staffPosts hrstaffPosts) {
		if(hr_staffPostsMapper.insertOnePostsInfo(hrstaffPosts)==1){
			return true;
		}else{
			return false;
		}		
	}
	@Override
	public Boolean updateOnePostsInfo(Hr_staffPosts hrstaffPosts) {
		Map<String,String> bumenMap = sysDicDataService.selectDepartsDicNoEableMap("");			
		if(hrstaffPosts.getAgoPostsDep()!=null&& !hrstaffPosts.getAgoPostsDep().equals(""))
		{		
			hrstaffPosts.setAgoPostsDepNmae(bumenMap.get(hrstaffPosts.getAgoPostsDep()));	
		}
		if(hrstaffPosts.getNowPostsDep()!=null && !hrstaffPosts.getNowPostsDep().equals("")){		
			hrstaffPosts.setNowPostsDepName(bumenMap.get(hrstaffPosts.getNowPostsDep()));
		}	
		if (hr_staffPostsMapper.updateOnePostsInfo(hrstaffPosts) == 1) {
			return true;
		} else {
			return false;
		}
	}



	
	
	
}

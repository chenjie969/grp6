package com.zjm.oa.staffJob.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.oa.db.map.Hr_staffJobMapper;
import com.zjm.oa.db.model.Hr_staffJob;

import com.zjm.oa.staffJob.service.StaffJobService;

@Service("staffJobService")
@Transactional
public class StaffJobServiceImpl implements StaffJobService {
	@Resource
	private Hr_staffJobMapper hr_staffJobMapper;	
	@Resource
	private StaffJobService staffJobService;
	@Override
	public List<Hr_staffJob> selectJobListByCase_ID(String staffCase_ID) {
		
		return hr_staffJobMapper.selectJobListByCase_ID(staffCase_ID);
		
	}
	@Override
	public Hr_staffJob selectOneByJobId(String jobID) {
		
		return hr_staffJobMapper.selectOneByJobId(jobID);
	}
	@Override
	public Boolean insertOneJobInfo(Hr_staffJob hrstaffJob) {
	if(hr_staffJobMapper.insertOneJobInfo(hrstaffJob)==1){
		return true;
	}
		return false;
	}
	@Override
	public Boolean updateOneJobInfo(Hr_staffJob hrstaffJob) {
		if(hr_staffJobMapper.updateOneJobInfo(hrstaffJob)==1){
			return true;
		}
		return false;
	}	
	
}

package com.zjm.oa.staffEducation.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.oa.db.map.Hr_staffEducationMapper;
import com.zjm.oa.db.model.Hr_staffEducation;
import com.zjm.oa.staffEducation.service.StaffEducationService;


@Service("staffEducationService")
@Transactional
public class StaffEducationServiceImpl implements StaffEducationService {

	@Resource
	private Hr_staffEducationMapper hr_staffEducationMapper;	
	@Resource
	private StaffEducationService staffEducationService;
	@Resource
	private SysDicDataService sysDicDataService;
	// 查询列表    分页列表
	@Override
	public List<Hr_staffEducation> selectEduListByCase_ID(String staffCase_ID) {
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("","1d5c390cc0ac4a8ab77270ef0debe823");	
		List<Hr_staffEducation> list =	hr_staffEducationMapper.selectEduListByCase_ID(staffCase_ID);
		for (Hr_staffEducation hr_staffEducation : list) {
			if(hr_staffEducation.getEducationRecord()!=null&& !hr_staffEducation.getEducationRecord().equals("")){           
				hr_staffEducation.setEducationRecordName(EducationMap.get(hr_staffEducation.getEducationRecord()));
			}
			
		}
		
		return list;
	}
	//	//根据ID查询
	@Override
	public Hr_staffEducation selectOneByEducationId(String educationID) {
		Hr_staffEducation hr_staffEducation=hr_staffEducationMapper.selectOneByEducationId(educationID);
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("","1d5c390cc0ac4a8ab77270ef0debe823");	
		if(hr_staffEducation.getEducationRecord()!=null && !hr_staffEducation.getEducationRecord().equals("")){           
			hr_staffEducation.setEducationRecordName(EducationMap.get(hr_staffEducation.getEducationRecord()));
		}		
		return hr_staffEducation;
	}
	@Override
	public Boolean insertOneEducationInfo(Hr_staffEducation hr_staffEducation) {
		if(hr_staffEducationMapper.insertOneEducationInfo(hr_staffEducation)==1){
			return true;
		}else{
			return false;
		}	
	}
	@Override
	public Boolean updateOneEducationInfo(Hr_staffEducation hr_staffEducation) {
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("","1d5c390cc0ac4a8ab77270ef0debe823");	
		if(hr_staffEducation.getEducationRecord()!=null && !hr_staffEducation.getEducationRecord().equals("")){           
			hr_staffEducation.setEducationRecordName(EducationMap.get(hr_staffEducation.getEducationRecord()));
		}		
		if(hr_staffEducationMapper.updateOneEducationInfo(hr_staffEducation)==1){
			return true;
		}else{
			return false;
		}	
	}
	
	
	
}

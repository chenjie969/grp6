package com.zjm.oa.staffDuty.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.oa.db.map.Hr_staffDutyMapper;
import com.zjm.oa.db.model.Hr_staffDuty;

import com.zjm.oa.staffDuty.service.StaffDutyService;

import com.zjm.sys.departs.service.DepartsService;


@Service("staffDutyService")
@Transactional
public class StaffDutyServiceImpl implements StaffDutyService {
	@Resource
	private Hr_staffDutyMapper hr_staffDutyMapper;
	@Resource
	private StaffDutyService staffDutyService;
	@Resource
	private DepartsService departsService;
	@Resource
	private SysDicDataService sysDicDataService;
	/**
	 * 查询列表
	 */
	@Override
	public List<Hr_staffDuty> selectDutyListByCase_ID(String staffCase_ID) {
		Map<String,String> bumenMap = sysDicDataService.selectDepartsDicNoEableMap("");			

		List<Hr_staffDuty> dutyList = hr_staffDutyMapper.selectDutyListByCase_ID(staffCase_ID);
		for (Hr_staffDuty hr_staffDuty : dutyList) {
			if (hr_staffDuty.getDutyDepGID() != null && !hr_staffDuty.getDutyDepGID().equals("")) {				
				hr_staffDuty.setDutyDepGIDName(bumenMap.get(hr_staffDuty.getDutyDepGID()));
			}
		}
		return dutyList;
	}
	/**
	 * 查询一条记录
	 */
	@Override
	public Hr_staffDuty selectOneByDutyId(String dutyID) {
		Map<String,String> bumenMap = sysDicDataService.selectDepartsDicNoEableMap("");			

		Hr_staffDuty hr_staffDuty=hr_staffDutyMapper.selectOneByDutyId(dutyID);

		if (hr_staffDuty.getDutyDepGID() != null&& !hr_staffDuty.getDutyDepGID().equals("")) {
			
			hr_staffDuty.setDutyDepGIDName(bumenMap.get(hr_staffDuty.getDutyDepGID()));
		}
		return hr_staffDuty;
	}
	/**
	 * 插入一条记录
	 */
	@Override
	public Boolean insertOneDutyInfo(Hr_staffDuty hrstaffDuty) {

		if (hr_staffDutyMapper.insertOneDutyInfo(hrstaffDuty) == 1) {
			return true;
		}
		return false;
	}
	/**
	 * 更新一条记录
	 */
	@Override
	public Boolean updateOneDutyInfo(Hr_staffDuty hrstaffDuty) {
		Map<String,String> bumenMap = sysDicDataService.selectDepartsDicNoEableMap("");		

		if (hrstaffDuty.getDutyDepGID() != null&& !hrstaffDuty.getDutyDepGID().equals("")) {
			
			hrstaffDuty.setDutyDepGIDName(bumenMap.get(hrstaffDuty.getDutyDepGID()));
		}
		if (hr_staffDutyMapper.updateOneDutyInfo(hrstaffDuty) == 1) {
			return true;
		}
		return false;
	}

}

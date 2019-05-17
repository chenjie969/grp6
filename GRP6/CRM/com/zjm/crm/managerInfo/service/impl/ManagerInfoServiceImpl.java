package com.zjm.crm.managerInfo.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_managerInfoMapper;
import com.zjm.crm.db.model.Crm_managerInfo;
import com.zjm.crm.managerInfo.service.ManagerInfoService;
@Service(value="managerInfoService")
@Transactional
public class ManagerInfoServiceImpl implements ManagerInfoService {

	@Resource
	private Crm_managerInfoMapper crm_managerInfoMapper;
	
	@Resource
	private LogService logService ;// 日志接口
	
	@Override
	public Boolean deleteOneManagerInfo(String managerinfoId,User user) {
		 try {
				 int deleteOneManagerInfo = crm_managerInfoMapper.deleteOneManagerInfo(managerinfoId);
				 if(deleteOneManagerInfo > 0){
					 logService.insertOneOperatorLogInfo(user,"股东主要管理人员", "删除", "删除股东主要管理人员情况");
					 return true;
				 }
		} catch (Exception e) {
			e.printStackTrace();
		}
			 return false;
	}

	@Override
	public Boolean insertOneManagerInfo(Crm_managerInfo crm_managerInfo,User user) {
		try {
			int insertOneManagerInfo = crm_managerInfoMapper.insertOneManagerInfo(crm_managerInfo);
			if( insertOneManagerInfo > 0){
				logService.insertOneOperatorLogInfo(user,"股东主要管理人员", "添加", "添加股东主要管理人员");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public Crm_managerInfo selectOneManagerInfo(String wheresql) {
		return crm_managerInfoMapper.selectOneManagerInfo(wheresql);
	}

	@Override
	public Boolean updateOneManagerInfo(Crm_managerInfo crm_managerInfo,User user) {
		try {
			logService.insertOneOperatorLogInfo(user,"股东主要管理人员", "修改", "修改股东主要管理人员");
			int updateOneManagerInfo = crm_managerInfoMapper.updateOneManagerInfo(crm_managerInfo);
			if( updateOneManagerInfo > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public Boolean deleteManagerInfoByClient_ID(String client_ID) {
		try {
			int info = crm_managerInfoMapper.deleteManagerInfoByClient_ID(client_ID);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}

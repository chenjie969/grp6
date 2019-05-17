package com.zjm.crm.creditInfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.creditInfo.service.CreditInfoService;
import com.zjm.crm.db.map.Crm_clientMapper;
import com.zjm.crm.db.map.Crm_creditInfoMapper;
import com.zjm.crm.db.model.Crm_creditInfo;
import com.zjm.util.Tool;

@Service(value="creditInfoService")
@Transactional
public class CreditInfoServiceImpl implements CreditInfoService {

	@Resource
	private Crm_creditInfoMapper creditInfoMapper;
	@Resource
	private LogService logService;
	@Resource
	private Crm_clientMapper clientMapper;
	
	/**
	 * 查询一条企业信用信息
	 */
	@Override
	public Crm_creditInfo selectOneCreditInfo(Crm_creditInfo creditInfo){
		return creditInfoMapper.selectOneCreditInfo(creditInfo);
	}

	/**
	 * 新增一条企业信用信息
	 */
	@Override
	public Boolean insertOneCreditInfo(User user,Crm_creditInfo creditInfo) {
		creditInfo.setCreditInfo_ID(Tool.createUUID32());
		creditInfo.setUpdateUserName(user.getUser_name());
		creditInfo.setUnit_uid(user.getUnit_uid());
		creditInfo.setUnit_uidName(user.getUnit_uidName());
		String clientName = clientMapper.selectNameById(creditInfo.getClient_ID());
		if(creditInfoMapper.insertOneCreditInfo(creditInfo)==1){
			logService.insertOneOperatorLogInfo(user,"企业客户详情", "添加", clientName+"添加企业信用信息及银企往来情况");
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 更新一条企业信用信息
	 */
	@Override
	public Boolean updateOneCreditInfo(User user,Crm_creditInfo creditInfo) {
		creditInfo.setUpdateUserName(user.getUser_name());
		creditInfo.setUnit_uid(user.getUnit_uid());
		String clientName = clientMapper.selectNameById(creditInfo.getClient_ID());
		try {
			Integer integer = creditInfoMapper.updateOneCreditInfo(creditInfo);
			if(integer==1){
				logService.insertOneOperatorLogInfo(user,"企业客户详情", "修改", clientName+"修改企业信用信息及银企往来情况");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteCreditInfoByClient_ID(String client_ID) {
		try {
			int deleteCreditInfoByClient_ID = creditInfoMapper.deleteCreditInfoByClient_ID(client_ID);
			if( deleteCreditInfoByClient_ID > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

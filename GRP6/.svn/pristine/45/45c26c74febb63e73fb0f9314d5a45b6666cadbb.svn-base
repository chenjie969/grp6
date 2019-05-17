package com.zjm.crm.clientShare.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.crm.clientShare.service.ClientShareService;
import com.zjm.crm.db.map.Crm_clientShareMapper;
import com.zjm.crm.db.model.Crm_clientShare;
import com.zjm.crm.db.model.Crm_relationClient;
import com.zjm.common.db.model.PageTable;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
 * 共享客户
 *  
 */
@Service("clientShareService")
@Transactional
public class ClientShareServiceImpl implements ClientShareService {
	@Resource
	private Crm_clientShareMapper crm_clientShareMapper;
	
	/**
	 * 新增共享客户
	 * @author 
	 * @return
	 */
	@Override
	public Boolean insertOneClientShareInfo(Crm_clientShare crm_clientShare) {
		crm_clientShare.setClientShare_ID(Tool.createUUID32());
		crm_clientShare.setShareUserID(SystemSession.getUserSession().getUser_uid());
		crm_clientShare.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		return crm_clientShareMapper.insertOneClientShareInfo(crm_clientShare);
	}

	/**
	 * 根据Client_ID查询共享客户信息
	 * @return
	 */
	@Override
	public Crm_clientShare selectOneClientShareInfo(Crm_clientShare crm_clientShare) {
		crm_clientShare.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		crm_clientShare = crm_clientShareMapper.selectOneClientShareInfo(crm_clientShare);
		return crm_clientShare;
	}

	/**
	 * 修改共享客户
	 * @author 
	 * @return
	 */
	@Override
	public Boolean updateOneClientShareInfo(Crm_clientShare crm_clientShare) {
		crm_clientShare.setUpdateUserName(SystemSession.getUserSession().getUser_name());
		return crm_clientShareMapper.updateOneClientShareInfo(crm_clientShare);
	}
	
}

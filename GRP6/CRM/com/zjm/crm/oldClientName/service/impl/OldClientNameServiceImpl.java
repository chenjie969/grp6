package com.zjm.crm.oldClientName.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.crm.db.map.Crm_oldClientNameMapper;
import com.zjm.crm.db.model.Crm_oldClientName;
import com.zjm.crm.oldClientName.service.OldClientNameService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
 * 曾用名
 *  
 */
@Service("oldClientNameService")
@Transactional
public class OldClientNameServiceImpl implements OldClientNameService {
	@Resource
	private Crm_oldClientNameMapper crm_oldClientNameMapper;
	
	/**
	 * 新增曾用名户
	 * @author 
	 * @return
	 */
	@Override
	public Boolean insertOneOldClientNameInfo(Crm_oldClientName crm_oldClientName) {
		crm_oldClientName.setOldClient_ID(Tool.createUUID32());
		crm_oldClientName.setUpdateUserName(SystemSession.getUserSession().getUser_name());
		crm_oldClientName.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
		crm_oldClientName.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		return crm_oldClientNameMapper.insertOneOldClientNameInfo(crm_oldClientName);
	}

	/**
	 * 查询客户曾用名
	 * @author 
	 * @return
	 */
	@Override
	public List<Crm_oldClientName> selectOldClientNameList(String wheresql) {
		return crm_oldClientNameMapper.selectOldClientNameList(wheresql);
	}

	
}

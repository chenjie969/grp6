package com.zjm.sys.rolesData.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.sys.db.map.Sys_role_dataMapper;
import com.zjm.sys.db.model.Sys_role_data;
import com.zjm.sys.rolesData.RolesDataService;
/**
 * @author xujy@erongdu.com
 * 2017-12-27 
 *
 */
@Service(value="rolesDataService")
@Transactional
public class RolesDataServiceImpl implements RolesDataService {

	@Resource
	private Sys_role_dataMapper sys_role_dataMapper; 
	
	@Override
	public List<Sys_role_data> selectClientDataByUserId(String userId) {
		return sys_role_dataMapper.selectClientDataByUserId(userId);
	}

	@Override
	public List<Sys_role_data> selectByRoleId(String roleId) {
		return sys_role_dataMapper.selectByRoleId(roleId);
	}

	@Override
	public List<Sys_role_data> selectProDataByUserId(String userId) {
		return sys_role_dataMapper.selectProDataByUserId(userId);
	}

}

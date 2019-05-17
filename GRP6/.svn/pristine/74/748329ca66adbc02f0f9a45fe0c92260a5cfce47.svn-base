package com.zjm.crm.upDownClient.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_upDownClientMapper;
import com.zjm.crm.db.model.Crm_upDownClient;
import com.zjm.crm.upDownClient.service.UpDownClientService;
import com.zjm.util.Tool;

@Service("upDownClientService")
@Transactional
public class UpDownClientServiceImpl implements UpDownClientService {

	@Resource
	private Crm_upDownClientMapper upDownClientMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 分页查询上下游客户列表
	 */
	@Override
	public PageTable<Crm_upDownClient> selectUpDownClientPageTable(PageTable<Crm_upDownClient> pageTable) {
		List<Crm_upDownClient> upDownClientList = upDownClientMapper.selectUpDownClientPageTable(pageTable);
		pageTable.setRows(upDownClientList);
		Long upDownClientTotal = upDownClientMapper.selectUpDownClientPageTable_Count(pageTable);
		pageTable.setTotal(upDownClientTotal);
		return pageTable;
	}
	
	/**
	 * 查询上下游客户列表
	 */
	@Override
	public List<Crm_upDownClient> selectUpDownClientList(String wheresql) {
		try {
			return upDownClientMapper.selectUpDownClientList(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  查询一条上下游客户信息
	 */
	@Override
	public Crm_upDownClient selectOneUpDownClient(Crm_upDownClient upDownClient) {
		return upDownClientMapper.selectOneUpDownClient(upDownClient);
	}
	
	/**
	 *  插入一条上下游客户信息
	 */
	@Override
	public Boolean insertOneUpDownClient(User user,Crm_upDownClient upDownClient) {
		upDownClient.setUpDownClient_ID(Tool.createUUID32());
		upDownClient.setUnit_uid(user.getUnit_uid());
		upDownClient.setUnit_uidName(user.getUnit_uidName());
		upDownClient.setUpdateUserName(user.getUser_name());
		if(upDownClientMapper.insertOneUpDownClient(upDownClient)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "添加", 
					"添加"+(upDownClient.getUpDownFlag().equals("01")?"上游供货":"下游销售")+"客户-"+upDownClient.getCustomerName());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条上下游客户信息
	 */
	@Override
	public Boolean updateOneUpDownClient(User user,Crm_upDownClient upDownClient) {
		upDownClient.setUpdateUserName(user.getUser_name());
		if(upDownClientMapper.updateOneUpDownClient(upDownClient)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "修改","修改"+(upDownClient.getUpDownFlag().equals("01")?"上游供货":"下游销售")+"客户-"+upDownClient.getCustomerName());
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条上下游客户信息
	 */
	@Override
	public Boolean deleteOneUpDownClient(User user,Crm_upDownClient upDownClient) {
		upDownClient = selectOneUpDownClient(upDownClient);
		if(upDownClientMapper.deleteOneUpDownClient(upDownClient)==1){
			logService.insertOneOperatorLogInfo(user, "企业经营情况", "删除", 
					"删除"+(upDownClient.getUpDownFlag().equals("01")?"上游供货":"下游销售")+"客户-"+upDownClient.getCustomerName());
			return true;
		}else
			return false;
	}

	@Override
	public Boolean deleteUpDownClientByWhereSql(String wheresql) {
		try {
			int info = upDownClientMapper.deleteUpDownClientByWhereSql(wheresql);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

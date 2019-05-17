package com.zjm.crm.relationClient.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_relationClientMapper;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_client_relationMain;
import com.zjm.crm.db.model.Crm_relationClient;
import com.zjm.crm.db.model.Crm_relationMain;
import com.zjm.crm.relationClient.service.RelationClientService;
import com.zjm.util.Tool;

/**
 * 客户管理
 * @author zhangkeyao add 20170426
 *  
 */
@Service("relationClientService")
@Transactional
public class RelationClientServiceImpl implements RelationClientService {
	@Resource
	private Crm_relationClientMapper crm_relationClientMapper;
	@Resource
	private LogService logService;
	@Resource
	private ClientService clientService;
	
	/**
	 * 查询关联企业分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_relationClient> selectRelationClientPageTables(Crm_relationClient relationClient) {
		List<Crm_relationClient> cList = crm_relationClientMapper.selectRelationClientPageTables(relationClient);
		PageTable<Crm_relationClient> pageTable = new PageTable<>();
		pageTable.setRows(cList);
		pageTable.setTotal((long) cList.size());
		return pageTable;
	}
	
	/**
	 * 查询关联客户列表
	 */
	public List<Crm_relationClient> selectRelationClientList(String wheresql){
		try {
			return crm_relationClientMapper.selectRelationClientList(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 新增关联企业
	 * @param Crm_relationClient
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneRelationClientInfo(User user,Crm_relationClient relationClient) {
		relationClient.setUpdateUserName(user.getUser_name());
		relationClient.setUnit_uid(user.getUnit_uid());
		relationClient.setRelation_id(Tool.createUUID32());
		//更新客户表信息
		Client client = new Client();
		client.setClient_ID(relationClient.getRelationClientID());
		client.setIsRelation(true);
		clientService.updateOneCompanyClientInfo(user, client);
		if(crm_relationClientMapper.insertOneRelationClientInfo(relationClient)){
			logService.insertOneOperatorLogInfo(user,"关联企业", "新增", "新增关联企业");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个关联企业
	 * @param Crm_relationClient
	 * @return
	 */
	@Override
	public boolean deleteOneRelationClientInfo(User user,String relation_id) {
		if(crm_relationClientMapper.deleteOneRelationClientInfo(relation_id)){
			logService.insertOneOperatorLogInfo(user,"关联企业", "删除", "删除关联企业");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询关联企业
	 * @param Crm_relationClient
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_relationClient selectOneRelationClientInfo(Crm_relationClient relationClient) {
		return crm_relationClientMapper.selectOneRelationClientInfo(relationClient);
	}

	/**
	 * 
	 * @description 修改 更新关联企业信息  
	 * @author chenyang
	 * @date 2017年5月4日 下午7:14:03
	 */
	@Override
	public Boolean updateOneRelationClientInfo(User user,Crm_relationClient relationClient) {
		Crm_relationClient relationClient2 =new Crm_relationClient();
		relationClient2= this.selectOneRelationClientInfo(relationClient);
		relationClient2.setRelationDesc(relationClient.getRelationDesc());
		relationClient2.setUpdateUserName(user.getUser_name());
		if(crm_relationClientMapper.updateOneRelationClientInfo(relationClient2)){
			logService.insertOneOperatorLogInfo(user,"关联企业", "修改", "修改关联企业");
			return true;			
		}else{
			return false;
		}
	}

	@Override
	public Boolean deleteRelationClientByClient_ID(String client_ID) {
		try {
			int deleteRelationClientByClient_ID = crm_relationClientMapper.deleteRelationClientByClient_ID(client_ID);
			if(deleteRelationClientByClient_ID > 0 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean insertRelationEachCompany(User user, Crm_relationMain relationMain) {
		
		if("".equals(relationMain.getClientIDs())){ //没有需要添加
			return true;
		}
		boolean falg = false;
		try{
			int insertRelationCount = 0;
			String[] clientIds = relationMain.getClientIDs().split(",");
			for (int i = 0; i < clientIds.length; i++) {
				for (int j = 0; j < clientIds.length; j++) {
					Crm_relationClient relationClient = new Crm_relationClient();
					if(clientIds[i].equals(clientIds[j])){//相同时不添加
						continue;
					}
					relationClient.setClient_ID(clientIds[i]);
					relationClient.setRelation_id(Tool.createUUID32());
					relationClient.setRelationClientID(clientIds[j]);
					relationClient.setRelationDesc("同关联系");
					relationClient.setUnit_uid(user.getUnit_uid());
					relationClient.setUpdateDateTime(new Date());
					relationClient.setUpdateUserName(user.getUser_name());
					if(crm_relationClientMapper.insertOneRelationClientInfo(relationClient)){
						logService.insertOneOperatorLogInfo(user,"关联企业", "新增", "新增关联企业");
						insertRelationCount ++;
					}
				}
			}
			if(insertRelationCount == clientIds.length*(clientIds.length-1)){
				falg = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return falg;
	}

	@Override
	public void deleteEachCompany(List<Crm_client_relationMain> crmList) {
		ArrayList<String> clientIds = new ArrayList<>();
		for (int i = 0; i < crmList.size(); i++) {
			clientIds.add(crmList.get(i).getClient_ID());
		}
		
		for (int i = 0; i < crmList.size(); i++) {
			crm_relationClientMapper.deletConnectionClient(crmList.get(i).getClient_ID(),clientIds);
		}
		
	}

}

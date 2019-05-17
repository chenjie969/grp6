package com.zjm.crm.relationMain.service;

import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_client_relationMain;
import com.zjm.crm.db.model.Crm_relationMain;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;

public interface RelationMainService {
	
	/**
	 * 分页查询关联主体列表
	 */
	public PageTable selectRelationMainPageTables(PageTable pageTable);
	
	/**
	 * 插入一个关联主体
	 */
	public Boolean insertOneRelationMain(User user,Crm_relationMain relationMain);
	
	/**
	 * 判断主体名是否重复
	 */
	public Boolean isExistMainName(Crm_relationMain relationMain);
	
	/**
	 * 批量删除关联主体
	 */
	public Boolean batchDeleteRelationMainByIDs(User user,Crm_relationMain relationMain);
	
	/**
	 * 根据ID查询一个关联主体
	 */
	public Crm_relationMain selectOneRelationMainById(Crm_relationMain relationMain);
	
	/**
	 * 更新一个关联主体
	 */
	public Boolean updateOneRelationMain(User user,Crm_relationMain relationMain);
	
	/**
	 * 批量 移出重点项目
	 */
	public Boolean removeKeyProject(User user,Crm_relationMain relationMain);

	/**
	 * 根据关联企业查询关联主体
	 * @param relationClientName
	 * @return
	 */
	public List<Crm_client_relationMain> selectRelationMain(String relationClientName);
	
	/**
	 * 查询关系名下的所有客户公司
	 * @param pageTable
	 * @return
	 */
	public List<Client> selectAllCompangById(PageTable<Client> pageTable);


}

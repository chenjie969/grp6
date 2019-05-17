package com.zjm.crm.relationClient.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_client_relationMain;
import com.zjm.crm.db.model.Crm_relationClient;
import com.zjm.crm.db.model.Crm_relationMain;

/**
 * 客户管理
 * @author chenyang add 20170426
 */
public interface RelationClientService {
	
	/**
	 * 查询关联客户分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_relationClient> selectRelationClientPageTables(Crm_relationClient relationClient);
	
	/**
	 * 查询关联客户列表
	 */
	public List<Crm_relationClient> selectRelationClientList(String wheresql);
	
	/**
	 *	删除一个关联企业
	 * @param clientRelation
	 * @return
	 */
	public boolean deleteOneRelationClientInfo(User user,String relation_id);

	/**
	 *	新增一个关联企业
	 * @param clientRelation
	 * @return
	 */
	public Boolean insertOneRelationClientInfo(User user,Crm_relationClient relationClient);

	/**
	 * 查询一个关联企业
	 * @param clientRelation
	 * @return
	 */
	public Crm_relationClient selectOneRelationClientInfo(Crm_relationClient relationClient);

	/**
	 * 
	 * @description 修改 更新关联企业信息  
	 * @author chenyang
	 * @date 2017年5月4日 下午7:14:03
	 */
	public Boolean updateOneRelationClientInfo(User user,Crm_relationClient relationClient);
	
	
	/**
	 * @description  根据　client_ID　　删除
	 * @author wuhn
	 * @date 2017年10月11日 下午4:46:57
	 */
	Boolean deleteRelationClientByClient_ID(String client_ID);
	
	/**
	 * 添加关联各企业之间的相互关联关系
	 * @param user
	 * @param relationMain
	 * @return
	 */
	public Boolean insertRelationEachCompany(User user ,Crm_relationMain relationMain );

	
	/**
	 * 根据关联系里面的所有用户，删除个用户之间的关联关系
	 * @param Cmlist
	 */
	public void deleteEachCompany(List<Crm_client_relationMain> crmList);
}

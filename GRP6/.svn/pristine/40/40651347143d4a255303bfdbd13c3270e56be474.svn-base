package com.zjm.crm.db.map;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_relationClient;
import com.zjm.common.db.model.PageTable;

public interface Crm_relationClientMapper {

	
	/**
	 * 查询关联企业    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_relationClient> selectRelationClientPageTables(Crm_relationClient relationClient);
	
	
	/**
	 * 查询关联企业    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectClientPageTables_Count(PageTable<Crm_relationClient> pageTable);
	
	/**
	 * 查询关联企业 
	 */
	public List<Crm_relationClient> selectRelationClientList(String wheresql);

	/**
	 * 新增关联企业
	 * @param client
	 * @author chenyang
	 * @return
	 */
	public Boolean insertOneRelationClientInfo(Crm_relationClient relationClient);

	/**
	 *	删除一个关联企业
	 * @param clientRelation
	 * @return
	 */
	public boolean deleteOneRelationClientInfo(String relation_id);

	/**
	 *查询一个关联企业
	 * @param Crm_relationClient
	 * @author chenyang
	 * @return
	 */
	public Crm_relationClient selectOneRelationClientInfo(Crm_relationClient relationClient);

	/**
	 * 
	 * @description 修改 更新关联企业信息  
	 * @author chenyang
	 * @date 2017年5月4日 
	 */
	public Boolean updateOneRelationClientInfo(Crm_relationClient relationClient);

	
	/**
	 * @description  根据　client_ID　　删除
	 * @author wuhn
	 * @date 2017年10月11日 下午4:46:57
	 */
	int deleteRelationClientByClient_ID(String client_ID);
	
	/**
	 * @param client_ID 
	 * @param clientIds 
	 * @return
	 */
	int deletConnectionClient(@Param("client_ID")String client_ID, @Param("list")ArrayList<String> 	relationClientIds);
}

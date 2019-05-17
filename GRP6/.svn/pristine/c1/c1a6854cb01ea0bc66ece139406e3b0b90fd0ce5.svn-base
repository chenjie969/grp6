package com.zjm.crm.db.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zjm.crm.db.model.Crm_client_relationMain;
import com.zjm.crm.db.model.Crm_relationMain;

@Repository
public interface Crm_client_relationMainMapper {
	/**
	 * 查询某主体下的所有企业
	 */
	public List<Crm_client_relationMain> selectClientByRelationMain_ID(String relationMain_ID);
	/**
	 * 删除关联关系
	 */
	public void deleteRelationByID(Crm_relationMain crm_relationMain);
	/**
	 * 新增关联主体与关联企业的关系
	 */
	public Integer insertOneClient_relationMain(Crm_client_relationMain crm_client_relationMain);
	
	/**
	 * 删除用户时删除关联关系
	 * @param Client_ID
	 * @return
	 */
	public Integer deleteRelationByClient_ID(String client_ID);
	
	/**
	 * 根据关联企业名称查询
	 * @param clientName
	 * @return
	 */
	public List<Crm_client_relationMain> selectByClientName(@Param("clientName") String clientName);
}

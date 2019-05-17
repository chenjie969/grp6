package com.zjm.crm.upDownClient.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_upDownClient;

public interface UpDownClientService {

	/**
	 * 分页查询上下游客户列表
	 */
	public PageTable<Crm_upDownClient> selectUpDownClientPageTable(PageTable<Crm_upDownClient> pageTable);
	
	/**
	 * 查询上下游客户列表
	 */
	public List<Crm_upDownClient> selectUpDownClientList(String wheresql);
	
	/**
	 *  查询一条上下游客户列表
	 */
	public Crm_upDownClient selectOneUpDownClient(Crm_upDownClient upDownClient);
	
	/**
	 *  插入一条上下游客户信息
	 */
	public Boolean insertOneUpDownClient(User user,Crm_upDownClient upDownClient);
	
	/**
	 *  修改一条上下游客户信息
	 */
	public Boolean updateOneUpDownClient(User user,Crm_upDownClient upDownClient);
	
	/**
	 *  删除一条上下游客户信息
	 */
	public Boolean deleteOneUpDownClient(User user,Crm_upDownClient upDownClient);
	
	/**
	 * @description  根据wheresql 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午2:36:57
	 */
	Boolean deleteUpDownClientByWhereSql(String wheresql);
}

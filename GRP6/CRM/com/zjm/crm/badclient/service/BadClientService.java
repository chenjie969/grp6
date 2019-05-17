package com.zjm.crm.badclient.service;

import java.util.List;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_badClient;

public interface BadClientService {
	
	/**
	 * 查询黑名单分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable<Crm_badClient> selectBadClientPageTables(PageTable<Crm_badClient> pageTable);
	
	/**
	 * @description  添加/插入一个黑名单信息
	 */
	public Boolean insertOneBadClientInfo(User user,Crm_badClient crm_badClient);
	
	/**
	 * 查询一条黑名单信息
	 * @param crm_badClient
	 * @return
	 */
	public Crm_badClient selectOneBadClientInfo(Crm_badClient crm_badClient);
	
	/**
	 * 更新一条黑名单信息
	 * @param user
	 * @param crm_badClient
	 * @return
	 */
	public Boolean updateOneBadClientInfo(User user,Crm_badClient crm_badClient);
	
	/**
     * 转入黑名单;
     * @return
     */
	public Boolean returnBadClientByClientID(User user,Crm_badClient badClient);
	
	
	/**
     * 移出黑名单;
     * @return
     */
	public Boolean removeBadClientByClientID(User user,Crm_badClient badClient);
	 public  void expotExcel(HttpServletRequest request,HttpServletResponse response,List<Crm_badClient> list) throws IOException;

	public List<Crm_badClient> selectBadClientLists();
	public Crm_badClient selectOneBadClientInfoByclent_id( String client_id) ;
	
	/**
	 * @description  根据wheresql 获取list
	 * @author wuhn
	 * @date 2017年10月11日 下午2:52:58
	 */
	List<Crm_badClient>  selectBadClientListByWhereSql(String wheresql);
	
	/**
	 * @description    根据wheresql 删除
	 * @author wuhn
	 * @date 2017年10月11日 下午2:53:06
	 */
	Boolean deleteBadClientByWhereSql(String wheresql);
	
}

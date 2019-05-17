package com.zjm.crm.db.map;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjm.crm.db.model.Crm_badClient;
import com.zjm.common.db.model.PageTable;

@Repository
public interface Crm_badClientMapper {
	/**
	 * 查询黑名单列表    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Crm_badClient> selectBadClientPageTables(PageTable<Crm_badClient> pageTable);
	/**
	 * 查询黑名单列表    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectBadClientPageTables_Count(PageTable<Crm_badClient> pageTable);
	/**
	 * 查询一条黑名单信息
	 * @param crm_badClient
	 * @return
	 */
	public Crm_badClient selectOneBadClientInfo(Crm_badClient crm_badClient);
	/**
	 * 更新一条黑名单信息
	 * @param crm_badClient
	 * @return
	 */
	public Integer updateOneBadClientInfo(Crm_badClient crm_badClient);
	
	/**
	 * @description  添加/插入一个黑名单信息
	 */
	public Integer insertOneBadClientInfo(Crm_badClient crm_badClient);
	
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
	int deleteBadClientByWhereSql(String wheresql);
	
	public List<Crm_badClient> selectBadClientLists();
	public Crm_badClient selectOneBadClientInfoByclent_id( String client_id) ;

}

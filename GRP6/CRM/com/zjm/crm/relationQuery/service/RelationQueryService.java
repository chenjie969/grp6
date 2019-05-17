package com.zjm.crm.relationQuery.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Client;
/**
 * 关联查询接口
 * @author LiKM add 20170613
 *
 */
public interface RelationQueryService {
	/**
	 * 关联查询企业客户列表
	 * @param pageTable
	 * @author zhangkeyao
	 * @return
	 */
	public PageTable relationQueryClient(PageTable pageTable);
	
	/**
	 * 关联查询个人客户列表
	 * @param pageTable
	 * @author zhangkeyao
	 * @return
	 */
	public PageTable relationQueryPerson(PageTable pageTable);
}

package com.zjm.crm.oldClientName.service;

import java.util.List;

import com.zjm.crm.db.model.Crm_oldClientName;

/**
 * 曾用名
 */
public interface OldClientNameService {
	

	/**
	 *	新增一个曾用名
	 * @return
	 */
	public Boolean insertOneOldClientNameInfo(Crm_oldClientName crm_oldClientName);

	/**
	 *	查询客户曾用名
	 * @return
	 */
	public List<Crm_oldClientName> selectOldClientNameList(String wheresql);

	
}

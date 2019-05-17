package com.zjm.pro.bankruptcy.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_bankruptcy;

/**
 * 破产记录表Service
 * 
 * @author chenjianwei
 * @version 1.0.0
 * @date 2018-07-20 13:46:23
 * Copyright 杭州融都科技股份有限公司  All Rights Reserved
 * 官方网站：www.erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public interface BankruptcyService {
	
	/**
	 * 保存一条记录
	 * @param bankruptcy
	 * @return
	 */
	public boolean save(User userSession, Pro_bankruptcy bankruptcy);
	
	/**
	 * 编辑一条记录
	 * @param bankruptcy
	 * @return
	 */
	public boolean update(User userSession, Pro_bankruptcy bankruptcy);
	
	/**
	 * 分页查询-破产列表
	 * @param pageTable
	 * @return
	 */
	public PageTable<Pro_bankruptcy> selectBankruptcyPageTables(PageTable<Pro_bankruptcy> pageTable);

	/**
	 * 根据破产记录id查询
	 * @param bankruptcyId
	 * @return
	 */
	public Pro_bankruptcy findByPrimary(String bankruptcyId);
}

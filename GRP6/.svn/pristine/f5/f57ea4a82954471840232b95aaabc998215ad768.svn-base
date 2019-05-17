package com.zjm.pro.executecase.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_executecase;

/**
 * 案件执行记录表Service
 * 
 * @author chenjianwei
 * @version 1.0.0
 * @date 2018-07-23 17:53:04
 * Copyright 杭州融都科技股份有限公司  All Rights Reserved
 * 官方网站：www.erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public interface ExecutecaseService {
	
	/**
	 * 保存一条记录
	 * @param executecase
	 * @return
	 */
	public boolean save(User userSession, Pro_executecase executecase);
	
	/**
	 * 编辑一条记录
	 * @param executecase
	 * @return
	 */
	public boolean update(User userSession, Pro_executecase executecase);
	
	/**
	 * 分页查询-执行案件列表
	 * @param pageTable
	 * @return
	 */
	public PageTable<Pro_executecase> selectExecutecasePageTables(PageTable<Pro_executecase> pageTable);

	/**
	 * 根据破产记录id查询
	 * @param executecaseId
	 * @return
	 */
	public Pro_executecase findByPrimary(String executecaseId);
	
}

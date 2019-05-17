package com.zjm.pro.db.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_executecase;

/**
 * 案件执行记录表Dao
 * 
 * @author chenjianwei
 * @version 1.0.0
 * @date 2018-07-23 17:53:04
 * Copyright 杭州融都科技股份有限公司   All Rights Reserved
 * 官方网站：www.erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public interface Pro_executecaseMapper  {

	/**
	 * 保存一条记录
	 * @param executecase
	 * @return
	 */
	public int save(Pro_executecase executecase);

	/**
	 * 编辑一条记录
	 * @param executecase
	 * @return
	 */
	public int update(Pro_executecase executecase);
	
	/**
	 * 根据条件修改
	 * @param param
	 * @return
	 */
	public boolean updateSelective(Map<String, Object> param);
	
	/**
	 * 根据主键查询一条记录
	 * @param executecaseId
	 * @return
	 */
	public Pro_executecase findByPrimary(@Param("executecaseId") String executecaseId);
	
	/**
	 * 根据条件查询一条记录
	 * @param param
	 * @return
	 */
	public Pro_executecase findSelective(Map<String, Object> param);
	
	/**
	 * 根据条件查询list
	 * @param param
	 * @return
	 */
	public List<Pro_executecase> listSelective(Map<String, Object> param);
	
	/**
	 * 分页查询-破产列表
	 * @param pageTable
	 * @return
	 */
	public List<Pro_executecase> selectExecutecaseTable(PageTable<Pro_executecase> pageTable);

	/**
	 * 分页查询-统计破产记录数量
	 * @param pageTable
	 * @return
	 */
	public Long selectExecutecaseTable_count(PageTable<Pro_executecase> pageTable);
}

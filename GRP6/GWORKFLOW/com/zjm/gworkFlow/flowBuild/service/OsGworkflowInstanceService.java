package com.zjm.gworkFlow.flowBuild.service;

import com.zjm.gworkFlow.db.model.OsGworkflowInstance;

public interface OsGworkflowInstanceService {
	/**
	 * 执行sql语句，通常用来修改表单状态值
	 * @param sql
	 */
	public void executeSQL(String sql);
	
	/**
	 * 查询OsGworkflowInstance
	 */
	public OsGworkflowInstance selectOne(OsGworkflowInstance instance, String type);
}

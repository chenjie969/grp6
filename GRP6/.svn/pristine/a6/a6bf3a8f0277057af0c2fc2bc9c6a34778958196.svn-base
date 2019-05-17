package com.zjm.gworkFlow.db.map;

import com.zjm.gworkFlow.db.model.OsGworkflowInstance;

public interface OsGworkflowInstanceMapper {
	/**
	 * 取得一个对象:根据业务实体ID和业务实体类型(BusinessId,BusinessType)
	 * @param osGworkflowFlowtemplate
	 * @return
	 */
	public OsGworkflowInstance getOneByBusiness(OsGworkflowInstance instance);
	
	/**
	 * 取得一个对象:根据流程实例entryId
	 * @param instance
	 * @return
	 */
	public OsGworkflowInstance getOneByEntryId(OsGworkflowInstance instance);
	
	/**
	 * 插入一条记录
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public Integer insertOne(OsGworkflowInstance instance);
	
	/**
	 * 执行任意sql语句
	 * @param sql
	 */
	public void executeSql(String sql);
}

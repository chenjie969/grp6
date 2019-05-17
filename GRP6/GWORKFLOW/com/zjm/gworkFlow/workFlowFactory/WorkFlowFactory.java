package com.zjm.gworkFlow.workFlowFactory;


import com.zjm.gworkFlow.db.model.OsGworkFlowProjIDFlowID;

/** 
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-20 上午9:28:25 
 * 类说明： 
 */
public interface WorkFlowFactory {
	
	/**
	 * 项目号和流程实例关系表中插入一个记录
	 * @param osGworkFlowProjIDFlowID
	 * @return
	 */
	public Boolean insertOneprojAndflowID(OsGworkFlowProjIDFlowID osGworkFlowProjIDFlowID);

}


package com.zjm.gworkFlow.workFlowFactory.Impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.opensymphony.workflow.Workflow;
import com.zjm.gworkFlow.db.map.FlowProjRelationMapper;
import com.zjm.gworkFlow.db.model.OsGworkFlowProjIDFlowID;
import com.zjm.gworkFlow.workFlowFactory.WorkFlowFactory;

/** 
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-20 上午9:31:17 
 * 类说明： 
 */
@Service("workFlowFactory")
public class WorkFlowFactoryImpl implements WorkFlowFactory{
	
	//流程 项目关系
	@Resource
	private FlowProjRelationMapper flowProjRelationMapper;
	

	/**
	 * 项目号和流程实例关系表中插入一个记录
	 * @param osGworkFlowProjIDFlowID
	 * @return
	 */
	public Boolean insertOneprojAndflowID(OsGworkFlowProjIDFlowID osGworkFlowProjIDFlowID){
		Integer resultCount = flowProjRelationMapper.insertOneprojAndflowID(osGworkFlowProjIDFlowID);
		if(resultCount == 1){
			return true;
		}else{
			return false;
		}
	}
}


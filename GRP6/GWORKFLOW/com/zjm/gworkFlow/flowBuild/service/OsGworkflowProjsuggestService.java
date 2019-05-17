package com.zjm.gworkFlow.flowBuild.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.gworkFlow.db.model.OsGworkflowProjsuggest;
import com.zjm.gworkFlow.db.model.Os_gworkflow_files;

/** 
 * @author mashuo add 20170928
 * 类说明： 
 */
public interface OsGworkflowProjsuggestService {
	/**
	 * 查询一个用户意见
	 */
	public OsGworkflowProjsuggest selectOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest,User userSession);
	/**
	 * 更新一个用户意见
	 */
	public Boolean updateOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest, User userSession);
	/**
	 * 查询一个流程的所有用户意见
	 */
	public List<OsGworkflowProjsuggest> selectAllOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest,
			User userSession);
}


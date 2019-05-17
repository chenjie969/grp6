package com.zjm.gworkFlow.db.map;

import java.util.List;

import com.zjm.gworkFlow.db.model.OsGworkflowComponents;
import com.zjm.gworkFlow.db.model.OsGworkflowProjsuggest;

/** 
 * @author 作者 mashuo 
 * @version 创建时间：20170914
 * 类说明： 
 */
public interface OsGworkflowProjsuggestMapper {

	//根据动作ID后3位,取得对应业务构件的actionURL
	public OsGworkflowComponents getActionURLByID(OsGworkflowComponents osGworkflowComponents);
	
	/**
	 * 取得一条意见信息
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public OsGworkflowProjsuggest selectOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest);
	
	/**
	 * 插入一条 意见记录
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public Integer insertOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest);
	
	/**
	 * 更新一条意见 
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public Integer updateOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest);
	
	/**
	 * 查询意见记录是否存在
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public Integer selectSuggestIsExist(OsGworkflowProjsuggest osGworkflowProjsuggest);
	/**
	 *  查询一个流程的所有用户意见
	 * @param osGworkflowProjsuggest
	 * @return
	 */
	public List<OsGworkflowProjsuggest> selectAllOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest);
	
	
}


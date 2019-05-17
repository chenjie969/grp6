package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Act_re_model_actSort;

public interface Act_re_model_actSortMapper {
	/**
	 * 插入一个activiti模型与流程分类关系信息
	 * @param modelActSort
	 * @return
	 */
	public Integer insertOneModelActSortInfo(Act_re_model_actSort modelActSort);
	/**
	 * 删除一个activiti模型与流程分类关系信息 
	 * @param modelActSort
	 * @return
	 */
	public Integer delectOneModelActSortInfo(Act_re_model_actSort modelActSort);
	/**
	 * 查询activiti模型与流程分类关系List
	 * @param wheresql
	 * @return
	 */
	public List<Act_re_model_actSort> selectModelActSortList(String wheresql);
	/**
	 *  查询所有的模型    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Act_re_model_actSort> selectProcessDefinitionPageTable(PageTable pageTable);
	/**
	 * 查询所有的模型  分页列表 总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectProcessDefinitionPageTable_Count(PageTable pageTable);
	
}

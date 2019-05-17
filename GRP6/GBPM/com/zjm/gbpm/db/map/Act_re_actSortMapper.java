package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Act_re_actSort;

public interface Act_re_actSortMapper {
	/***
	 *  返回流程分类分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Act_re_actSort> selectActSortPageTables(PageTable pageTable);
	/**
	 *  返回流程分类分页列表记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectActSortPageTables_Count(PageTable pageTable);
	/**
	 * 插入一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Integer insertOneActSortInfo(Act_re_actSort actSort);
	/**
	 * 判断流程分类名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Integer selectActSortNameIsExist(String wheresql);
	/**
	 * 查询一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Act_re_actSort selectOneActSortInfo(Act_re_actSort actSort);
	/**
	 * 更新一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Integer updateOneActSortInfo(Act_re_actSort actSort);
	/**
	 * 删除一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Integer delectOneActSortInfo(Act_re_actSort actSort);
	/**
	 * 查询流程分类列表List
	 * @param wheresql
	 * @return
	 */
	public List<Act_re_actSort> selectActSortList(String wheresql);
}

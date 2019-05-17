package com.zjm.gbpm.actSort.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Act_re_actSort;

public interface ActSortService {
	/**
	 * 返回流程分类分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectActSortPageTables(PageTable pageTable);
	/**
	 * 插入一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Boolean insertOneActSortInfo(Act_re_actSort actSort);
	/**
	 * 判断流程分类名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Boolean selectActSortNameIsExist(String wheresql);
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
	public Boolean updateOneActSortInfo(Act_re_actSort actSort);
	/**
	 * 删除一个流程分类信息
	 * @param actSort
	 * @return
	 */
	public Boolean delectOneActSortInfo(Act_re_actSort actSort,User userSession);
	/**
	 * 查询流程分类列表List
	 * @param wheresql
	 * @return
	 */
	public java.util.List<Act_re_actSort> selectActSortList(String wheresql);
}

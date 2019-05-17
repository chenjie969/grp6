package com.zjm.pro.suggest.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_suggest;
/**
 * 项目意见信息表service suggest
 * @author zky
 *
 */
public interface ProjectSuggestService {
	
	
	/**
	 * 插入一个项目意见信息
	 * @param 
	 * @return
	 */
	public Boolean insertOneSuggestInfo(User user,Pro_suggest suggest);
	/**
	 * 根据wheresql查询一个项目意见信息
	 * @param wheresql:
	 * @return
	 */
	public Pro_suggest selectOneSuggestByWhereSql(String wheresql);
	/**
	 * 更新一个项目意见信息
	 * @param Pro_suggest
	 * @return
	 */
	public Boolean updateOneSuggestInfo(User user,Pro_suggest suggest);
	
	
	/**
	 * 根据wheresql查询项目意见信息list
	 * @param wheresql:
	 * @return
	 */
	public List<Pro_suggest> selectSuggestListByWhereSql(String wheresql);
	/**
	 * 删除单个意见表信息
	 * @param user
	 * @param suggest
	 * @return
	 */
	public  Boolean deleteOneSuggestInfo(User user,Pro_suggest suggest);
	
	
	
	
}

package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_project;
/**
 * 数据分析 映射mapper
 * @author zky
 * @time 2017-7-28;
 */
public interface AnalysisMapper {

	/**
	 * 统计分析公共查询
	 * @param whereSql 
	 * @author zhangkeyao
	 * @return
	 */
	public List<Pro_project> selectDynamicProject(String whereSql);	
	
}

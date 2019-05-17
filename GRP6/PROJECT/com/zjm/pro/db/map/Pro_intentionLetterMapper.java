package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_intentionLetter;


public interface Pro_intentionLetterMapper {
	
	/**
	 * 查询多条评审会记录
	 */
	public List<Pro_intentionLetter> selectIntentionLetterListByWheresql(String wheresql);
	
	/**
	 * 增加一条担保意向函
	 */
	public Integer insertOneIntentionLetter(Pro_intentionLetter intentionLetter);
	
	/**
	 * 删除一条担保意向函
	 */
	public Integer deleteOneIntentionLetter(String intentionLetter_ID);

	/**
	 * 修改担保意向函状态
	 */
	public Integer updateStatus(Pro_intentionLetter intentionLetter);
	
	/**
	 * 查看一条担保意向函
	 */
	public Pro_intentionLetter selectOneIntentionLetterByWhereSql(String wheresql);
	
	/**
	 * 查询担保意向函批次号
	 */
	public Integer selectBatchNumber(String wheresql);
	
}

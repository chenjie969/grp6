package com.zjm.pro.db.map;

import com.zjm.pro.db.model.Pro_projectoverdue;

/**
 * @author shsong
 * 
 */
public interface Pro_projectoverdueMapper {
	
	
	/**
	 * 新增一条记录
	 * @param pro_projectoverdue
	 * @return
	 */
	public Integer insertOneOverdueInfo(Pro_projectoverdue pro_projectoverdue);
	
	
	/**
	 * 查询最后一条记录
	 * @param whereSql
	 * @return
	 */
	public Pro_projectoverdue selectOneOverdueInfo(String whereSql);

	

}

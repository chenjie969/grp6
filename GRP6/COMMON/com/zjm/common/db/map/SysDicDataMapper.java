package com.zjm.common.db.map;

import java.util.List;

import com.zjm.common.db.model.SysDicData;

public interface SysDicDataMapper {
	/**
	 * 公用字典List查询方法
	 * @param string
	 * @return
	 */
	public List<SysDicData> selectAllSysDicDataList(String string);

}

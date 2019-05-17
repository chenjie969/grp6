package com.zjm.sys.sort.service;

public interface SortService {
	/**
	 * 顺序调整
	 * @return
	 */
	public Boolean updateSortOrder(String tableName, String tableFileName, String tableFileIds);

}

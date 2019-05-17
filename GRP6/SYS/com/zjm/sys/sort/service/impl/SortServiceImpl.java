package com.zjm.sys.sort.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.sys.db.map.Sys_modulesMapper;
import com.zjm.sys.sort.service.SortService;
@Service("sortService")
@Transactional
public class SortServiceImpl implements SortService {
	@Resource 
	private Sys_modulesMapper  sys_modulesMapper;
	/**
	 * 顺序调整
	 * @return
	 */
	public Boolean updateSortOrder(String tableName, String tableFileName, String tableFileIds) {
		String[] SortIds=tableFileIds.split(",");//id集合，传换成数组
		for(int i=0;i<SortIds.length;i++){
			String wheresql="UPDATE "+tableName.trim()+" SET order_id='"+i+"' WHERE "+tableFileName.trim()+"='"+SortIds[i].trim()+"'";
			sys_modulesMapper.updateSortOrder(wheresql);
		}
		return true;
	}

}

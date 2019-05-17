package com.zjm.gworkFlow.db.map;

import com.zjm.gworkFlow.db.model.OsGworkflowComponents;

/** 
 * @author 作者 mashuo
 * @version 创建时间：20170914
 * 类说明： 
 */
public interface OsGworkflowComponentsMapper {
	
	/**
	 * 返回步骤对应业务构件
	 * @param osGworkflowComponents
	 * @return
	 */
	public OsGworkflowComponents returnComponent(OsGworkflowComponents osGworkflowComponents);

}


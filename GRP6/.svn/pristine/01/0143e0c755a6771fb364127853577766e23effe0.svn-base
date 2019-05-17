package com.zjm.gbpm.runNode.service;

import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_runNode;

/**
 * 
 * @author zky
 * 运行中节点service
 */

public interface RunNodeService {
	/**
	 *  根据输入条件查询运行中节点；
	 * @param WhereSql
	 * 实例ID，节点顺序
	 * @return Gbpm_runNode
	 */                   
	public Gbpm_runNode   selectOneRunNodeByWhereSql(String whereSql);

	/**
	 * 新增一个运行中节点
	 * @param runNode
	 */
	public Boolean insertOneRunNodeInfo(User user,Gbpm_runNode runNode);

	/**
	 * 删除一个运行中节点
	 * @param wheresql
	 */
	public void deleteRunNodeByWheresql(User user,String wheresql);

	public Boolean updateOneRunNodeInfo(User userSession, Gbpm_runNode runNode);
	
	
}

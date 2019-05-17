package com.zjm.gbpm.finishNode.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_finishNode;

/**
 * 
 * @author zky
 * 已完成节点service
 */

public interface FinishNodeService {
	/**
	 *  根据输入条件查询已完成节点；
	 * @param WhereSql
	 * 实例ID，节点顺序
	 * @return Gbpm_finishNode
	 */                   
	public Gbpm_finishNode   selectOneFinishNodeByWhereSql(String whereSql);

	/**
	 * 插入一条已完成节点
	 * @param finishNode
	 */
	public void insertOneFinishNode(User user, Gbpm_finishNode finishNode);

	/**
	 * 根据wheresql删除已完成节点
	 * @param finishNode
	 */
	public Boolean deleteFinishNodeByWheresql(User user, String wheresql);

	/**
	 * 根据wheresql获取已完成节点List
	 * @param finishNode
	 */
	public List<Gbpm_finishNode> selectFinishNodeListByWheresql(String wheresql);
    
}

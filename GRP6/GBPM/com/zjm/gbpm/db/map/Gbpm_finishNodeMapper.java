package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.gbpm.db.model.Gbpm_finishNode;

public interface Gbpm_finishNodeMapper {

	/**
	 *  根据输入条件查询完成的节点；
	 * @param WhereSql
	 * 实例ID,节点顺序
	 * @return Gbpm_finishNode
	 */                   
	public Gbpm_finishNode selectOneFinishNodeByWhereSql(String whereSql);

	/**
	 * 插入一条已完成节点
	 * @param finishNode
	 */
	public Integer insertOneFinishNode(Gbpm_finishNode finishNode);

	/**
	 * 根据wheresql删除已完成节点
	 * @param finishNode
	 */
	public int deleteFinishNodeByWheresql(String wheresql);

	/**
	 * 根据wheresql获取已完成节点List
	 * @param finishNode
	 */
	public List<Gbpm_finishNode> selectFinishNodeListByWheresql(String wheresql);


	
}

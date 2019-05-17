package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_dicNode;

public interface Gbpm_dicNodeMapper {

	/**
	 * 分页查询节点列表
	 */
	public List<Gbpm_dicNode> selectDicNodePageTable(PageTable<Gbpm_dicNode> pageTable);
	
	/**
	 * 分页查询节点列表-查询总记录数
	 */
	public Long selectDicNodePageTable_Count(PageTable<Gbpm_dicNode> pageTable);
	
	/**
	 *  查询一条节点
	 */
	public Gbpm_dicNode selectOneDicNode(Gbpm_dicNode dicNode);
	
	/**
	 *  插入一条节点
	 */
	public Integer insertOneDicNode(Gbpm_dicNode dicNode);
	
	/**
	 *  修改一条节点
	 */
	public Integer updateOneDicNode(Gbpm_dicNode dicNode);
	
	/**
	 *  删除一条节点
	 */
	public Integer deleteOneDicNode(Gbpm_dicNode dicNode);
	
	/**
	 *  判断节点名称是否已存在
	 */
	public Integer isExistDicNodeNames(Gbpm_dicNode dicNode);

	/**
	 * 获取所有节点
	 * @param dicNode
	 * @return
	 */
	public List<Gbpm_dicNode> selectAllNodeList(Gbpm_dicNode dicNode);

	/**
	 * 判断节点编号是否存在
	 * @param dicNode
	 * @return
	 */
	public int isExistNodeCode(Gbpm_dicNode dicNode);
	
}

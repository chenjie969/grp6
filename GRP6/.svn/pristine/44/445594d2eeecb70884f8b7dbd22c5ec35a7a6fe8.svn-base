package com.zjm.gbpm.dicNode.service;

import java.util.List;
import java.util.Map;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_dicNode;

public interface DicNodeService {

	/**
	 * 分页查询节点列表
	 */
	public PageTable<Gbpm_dicNode> selectDicNodePageTable(PageTable<Gbpm_dicNode> pageTable);
	
	/**
	 *  查询一条节点
	 */
	public Gbpm_dicNode selectOneDicNode(Gbpm_dicNode dicNode);
	
	/**
	 *  插入一条节点
	 */
	public Boolean insertOneDicNode(User user,Gbpm_dicNode dicNode);
	
	/**
	 *  修改一条节点
	 */
	public Boolean updateOneDicNode(User user,Gbpm_dicNode dicNode);
	
	/**
	 *  删除一条节点
	 */
	public Boolean deleteOneDicNode(User user,Gbpm_dicNode dicNode);
	
	/**
	 *  判断节点名称是否已存在
	 */
	public Boolean isExistDicNodeNames(Gbpm_dicNode dicNode);

	/**
	 * 查询所有节点
	 * @param dicNode
	 * @return
	 */
	public List<Gbpm_dicNode> selectAllNodeList(Gbpm_dicNode dicNode);

	/**
	 * 判断节点编号是否存在
	 * @param dicNode
	 * @return
	 */
	public Boolean isExistNodeCode(Gbpm_dicNode dicNode);

	/**
	 * 获取节点树
	 * @param userSession
	 * @return
	 */
	public List<Map<String, Object>> selectNodeTree(User userSession);

}

package com.zjm.gbpm.productNode.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.gbpm.db.model.Gbpm_productNode;

public interface ProductNodeService{
	/**
	 * 分页查询产品节点列表
	 */
	public PageTable<Gbpm_productNode> selectProductNodePageTable(PageTable<Gbpm_productNode> pageTable);

	/**
	 * 新增/修改时判断产品节点名称是否存在
	 */
	public Boolean isExistProductNodeNames(Gbpm_productNode productNode);

	/**
	 *  插入一条产品节点
	 */
	public Boolean insertOneProductNode(User user, Gbpm_productNode productNode);

	/**
	 *  查询一条产品节点信息
	 */
	public Gbpm_productNode selectOneProductNodeInfo(String wheresql);

	/**
	 *  修改一条产品节点信息
	 */
	public Boolean updateOneProductNodeInfo(User userSession, Gbpm_productNode productNode);

	/**
	 *  执行操作-删除一条产品节点
	 */
	public Boolean deleteOneProductNode(User user, Gbpm_productNode productNode);

	/**
	 * 根据产品节点ID获取产品节点List
	 * @param product
	 * @return
	 */
	public List<Gbpm_productNode> selectProductNodeListByProductID(String wheresql);

	/**
	 * 修改节点顺序
	 * @param userSession
	 * @param productNode
	 * @return
	 */
	public Object updateOneProductNode(User userSession, Gbpm_productNode productNode);

	/**
	 *  执行操作-根据whereslq删除产品节点
	 */
	public void delProductNodeByWheresql(User userSession,String wheresql);


}
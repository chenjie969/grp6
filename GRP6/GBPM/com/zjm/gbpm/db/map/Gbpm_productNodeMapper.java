package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.gbpm.db.model.Gbpm_productNode;

public interface Gbpm_productNodeMapper {

	/**
	 * 分页查询流程节点列表
	 */
	public List<Gbpm_productNode> selectProductNodePageTable(PageTable<Gbpm_productNode> pageTable);
	
	/**
	 * 分页查询流程节点列表-查询总记录数
	 */
	public Long selectProductNodePageTable_Count(PageTable<Gbpm_productNode> pageTable);
	
	/**
	 *  查询一条流程节点
	 */
	public Gbpm_productNode selectOneProductNode(String wheresql);
	
	/**
	 *  插入一条流程节点
	 */
	public Integer insertOneProductNode(Gbpm_productNode productNode);
	
	/**
	 *  修改一条流程节点
	 */
	public Integer updateOneProductNode(Gbpm_productNode productNode);
	
	/**
	 *  删除一条流程节点
	 */
	public Integer deleteOneProductNode(Gbpm_productNode productNode);
	
	/**
	 *  判断流程节点名称是否已存在
	 */
	public Integer isExistProductNodeNames(Gbpm_productNode productNode);

	/**
	 *  根据流程获取流程下的所有节点
	 */
	public List<Gbpm_productNode> selectProductNodeListByProductID(String wheresql);

	/**
	 *  根据whereslq删除产品流程
	 */
	public void delProductNodeByWheresql(String wheresql);
	
}

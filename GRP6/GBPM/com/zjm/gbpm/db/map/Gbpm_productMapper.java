package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_product;

public interface Gbpm_productMapper {

	/**
	 * 分页查询产品流程列表
	 */
	public List<Gbpm_product> selectProductPageTable(PageTable<Gbpm_product> pageTable);
	
	/**
	 * 分页查询产品流程列表-查询总记录数
	 */
	public Long selectProductPageTable_Count(PageTable<Gbpm_product> pageTable);
	
	/**
	 *  查询一条产品流程
	 */
	public Gbpm_product selectOneProduct(Gbpm_product product);
	
	/**
	 *  插入一条产品流程
	 */
	public Integer insertOneProduct(Gbpm_product product);
	
	/**
	 *  修改一条产品流程
	 */
	public Integer updateOneProduct(Gbpm_product product);
	
	/**
	 *  删除一条产品流程
	 */
	public Integer deleteOneProduct(Gbpm_product product);
	
	/**
	 *  判断产品流程名称是否已存在
	 */
	public Integer isExistProductName(Gbpm_product product);

	/**
	 * 查询产品列表
	 * @param wheresql
	 * @return
	 */
	public List<Gbpm_product> selectProductList(String wheresql);

	
}

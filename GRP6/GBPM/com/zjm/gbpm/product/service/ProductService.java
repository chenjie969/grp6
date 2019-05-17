package com.zjm.gbpm.product.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gbpm.db.model.Gbpm_product;

public interface ProductService{
	/**
	 * 分页查询产品流程列表
	 */
	public PageTable<Gbpm_product> selectProductPageTable(PageTable<Gbpm_product> pageTable);

	/**
	 * 新增/修改时判断产品流程名称是否存在
	 */
	public Boolean isExistProductName(Gbpm_product product);

	/**
	 *  插入一条产品流程
	 */
	public Object insertOneProductInfo(User userSession, Gbpm_product product);

	/**
	 *  查询一条产品流程信息
	 */
	public Gbpm_product selectOneProductInfo(Gbpm_product product);

	/**
	 *  查询一条产品流程信息
	 */
	public Boolean updateOneProductInfo(User userSession, Gbpm_product product);

	/**
	 *  执行操作-删除一条产品流程
	 */
	public Boolean deleteOneProduct(User userSession, Gbpm_product product);

	/**
	 *  执行操作-创建新版本产品流程
	 */
	public Boolean copyProduct(User userSession, Gbpm_product product);

	/**
	 * 查询产品列表
	 * @return
	 */
	public List<Gbpm_product> selectProductList(String wheresql);

}
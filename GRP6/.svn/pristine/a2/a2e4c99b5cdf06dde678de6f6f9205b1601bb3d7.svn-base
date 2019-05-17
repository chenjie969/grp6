package com.zjm.gbpm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_productInstance;

public interface Gbpm_productInstanceMapper {


	/**
	 *  查询一条产品实例
	 *  @param whereSql
	 *  apply_ID
	 */
	public Gbpm_productInstance selectOneProductInstanceByWhereSql(String  whereSql);

	/**
	 * 新增一个产品流程实例
	 * @param productInstance
	 * @return
	 */
	public Integer insertOneProductInstanceInfo(Gbpm_productInstance productInstance);
	/**
	 * 新增一个产品流程实例
	 * @param productInstance
	 * @return
	 */
	public Integer isExistProductInstance(String wheresql);

	/**
	 * 分页查询我发起的产品流程实例列表
	 */
	public List<Gbpm_productInstance> selectProductMyBuildInstancePageTable(PageTable<Gbpm_productInstance> pageTable);

	/**
	 * 分页查询我发起的产品流程实例列表总数
	 */
	public Long selectProductMyBuildInstancePageTable_Count(PageTable<Gbpm_productInstance> pageTable);

	/**
	 * 分页查询我参与的产品流程实例列表
	 */
	public List<Gbpm_productInstance> selectProductMyJoinInstancePageTable(PageTable<Gbpm_productInstance> pageTable);

	/**
	 * 分页查询我参与的产品流程实例列表总数
	 */
	public Long selectProductMyJoinInstancePageTable_Count(PageTable<Gbpm_productInstance> pageTable);

	/**
	 * 修改产品实例信息
	 * @param productInstance
	 * @return
	 */
	public Boolean updateProductInstanceInfo(Gbpm_productInstance productInstance);

	/**
	 * 删除产品实例信息
	 * @return
	 */
	public Integer delProductInstanceInfo(String wheresql);


	
}

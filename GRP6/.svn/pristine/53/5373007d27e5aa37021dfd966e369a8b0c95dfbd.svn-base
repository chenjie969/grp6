package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_materialTree;

public interface Crm_materialTreeMapper {

	/**
	 * 查询申请分页列表
	 */
	public List<Crm_materialTree> selectMaterialTreeList(String whereSql);
     /**
      * 新增客户资料类型
      * @param crm_materialTree
      * @return
      */
	public Integer insertOneMaterialTree(Crm_materialTree crm_materialTree);
	/**
	 *  添加时判断客户资料类型名称是否重复
	 * @param wheresql
	 * @return
	 */
	public Integer isExistMaterialTree(String wheresql);
	/*
	 * 根据条件查询客户资料类型信息
	 */
	public Crm_materialTree selectOneMaterialTreeByWhereSql(String materialTree_ID);
	/**
	 *  修改客户资料类型
	 * @param crm_materialTree
	 * @return
	 */
	public Integer updateOneaterialTree(Crm_materialTree crm_materialTree);
	/**
	 * 删除客户资料类型
	 * @param wheresql
	 * @return
	 */
	public Integer deleteOneMaterialTreeBySql(String wheresql);
	
	
}

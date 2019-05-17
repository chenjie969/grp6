package com.zjm.crm.materialTree.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_materialTree;
/**
 * 客户资料类型树表crm_materialTree service
 * @author Administrator
 *
 */
public interface MaterialTreeService {
	
	
	/**
	 * 查询多个客户资料类型
	 * 
	 */
   public List<Crm_materialTree>  selectMaterialTreeList(String  whereSql);
    /**
     * 新增单个客户资料类型
     * @param userSession
     * @param crm_materialTree
     * @return
     */
	public Boolean insertOneMaterialTree(User userSession, Crm_materialTree crm_materialTree);
	/**
	 * 
	 * @param wheresql
	 * @return
	 */
	public Boolean isExistMaterialTree(String wheresql);
	
	
	/*
	 * 根据条件查询客户资料类型信息
	 */
	public Crm_materialTree selectOneMaterialTreeByWhereSql(String materialTree_ID);
	/**
	 * 修改单个客户资料类型
	 * @param userSession
	 * @param crm_materialTree
	 * @return
	 */
	public Boolean updateOneaterialTree(User userSession, Crm_materialTree crm_materialTree);
	/**
	 * 删除单个客户资料类型
	 * @param userSession
	 * @param crm_materialTree
	 * @return
	 */
	public Boolean deleteOneMaterialTree(User userSession, Crm_materialTree crm_materialTree);
	/**
	 * 查询多个客户资料类型
	 * @param wheresql
	 * @return
	 */
	public List<Crm_materialTree> selectMaterialTreeByWhereSqL(String wheresql);
   
   
}

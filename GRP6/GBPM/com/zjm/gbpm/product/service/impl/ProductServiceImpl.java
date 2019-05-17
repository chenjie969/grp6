package com.zjm.gbpm.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_productMapper;
import com.zjm.gbpm.db.model.Gbpm_nodeTask;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.nodeTask.service.NodeTaskService;
import com.zjm.gbpm.product.service.ProductService;
import com.zjm.gbpm.productNode.service.ProductNodeService;
import com.zjm.util.Tool;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Resource
	private Gbpm_productMapper productMapper;
	@Resource
	private LogService logService;
	@Resource
	private ProductNodeService productNodeService;
	@Resource
	private NodeTaskService nodeTaskService;
	
	/**
	 * 查询产品流程分页列表
	 */
	@Override
	public PageTable<Gbpm_product> selectProductPageTable(PageTable<Gbpm_product> pageTable) {
		pageTable.setRows(productMapper.selectProductPageTable(pageTable));
		pageTable.setTotal(productMapper.selectProductPageTable_Count(pageTable));
		return pageTable;
	}

	/**
	 * 新增/修改时判断产品流程名称是否存在
	 */
	@Override
	public Boolean isExistProductName(Gbpm_product product) {
		if (productMapper.isExistProductName(product) == 0) {
			return true;
		}
		return false;
	}

	/**
	 *  插入一条产品流程
	 */
	@Override
	public Object insertOneProductInfo(User user, Gbpm_product product) {
		product.setProduct_ID(Tool.createUUID32());
		product.setUnit_uid(user.getUnit_uid());
		product.setUnit_uidName(user.getUnit_uidName());
		product.setUpdateUserName(user.getUser_name());
		if(productMapper.insertOneProduct(product)==1){
			logService.insertOneOperatorLogInfo(user, "产品流程管理", "添加", "添加"+product.getProductName());
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 *  查询一条产品流程信息
	 */
	@Override
	public Gbpm_product selectOneProductInfo(Gbpm_product product) {
		return productMapper.selectOneProduct(product);
	}

	/**
	 *  修改一条产品流程信息
	 */
	@Override
	public Boolean updateOneProductInfo(User user, Gbpm_product product) {
		product.setUpdateUserName(user.getUser_name());
		if(productMapper.updateOneProduct(product)==1){
			logService.insertOneOperatorLogInfo(user, "产品流程管理", "修改","修改"+product.getProductName());
			return true;
		}else{
			return false;
		}
	}

	/**
	 *  删除一条产品流程信息
	 */
	@Override
	public Boolean deleteOneProduct(User user, Gbpm_product product) {
		if(productMapper.deleteOneProduct(product)==1){
			String wheresql=" and productID = \'" + product.getProduct_ID() +"\'";
			logService.insertOneOperatorLogInfo(user, "产品流程管理", "删除", "删除"+product.getProduct_ID());
			productNodeService.delProductNodeByWheresql(user,wheresql);
			nodeTaskService.deleteNodeTaskByWheresql(user, wheresql);
			return true;
		}else
			return false;
	}

	/**
	 *  执行操作-复制产品流程
	 */
	@Override
	public Boolean copyProduct(User user, Gbpm_product newProduct) {
		Gbpm_product product = new Gbpm_product();
		product.setProduct_ID(newProduct.getProduct_ID());
		product = productMapper.selectOneProduct(product);
		
		newProduct.setProduct_ID(Tool.createUUID32());
		newProduct.setIsUsed(product.getIsUsed());
		newProduct.setProductTypeID(product.getProductTypeID());
		newProduct.setProductTypeName(product.getProductTypeName());
		newProduct.setUnit_uid(user.getUnit_uid());
		newProduct.setUnit_uidName(user.getUnit_uidName());
		newProduct.setUpdateUserName(user.getUser_name());
		if(productMapper.insertOneProduct(newProduct)==1){
			logService.insertOneOperatorLogInfo(user, "产品流程管理", "添加", "复制产品流程"+newProduct.getProduct_ID());
			
			//根据产品ID获取产品下的所有节点
			String wheresql = " and productID = \'" + product.getProduct_ID() + "\'";
			List<Gbpm_productNode> productNodeList = productNodeService.selectProductNodeListByProductID(wheresql);
			//复制所有的节点到新版本 product_ID
			for (Gbpm_productNode gbpm_productNode : productNodeList) {
				//根据产品节点ID获取产品节点下的任务
				wheresql = " and productNodeID = \'" + gbpm_productNode.getProductNode_ID() + "\'";
				List<Gbpm_nodeTask> nodeTaskList = nodeTaskService.selectNodeTaskListByWheresql(wheresql);
				gbpm_productNode.setProductID(newProduct.getProduct_ID());
				productNodeService.insertOneProductNode(user, gbpm_productNode);
				//复制所有任务到新版本 product_ID
				for (Gbpm_nodeTask gbpm_nodeTask : nodeTaskList) {
					gbpm_nodeTask.setProductID(newProduct.getProduct_ID());
					gbpm_nodeTask.setProductNodeID(gbpm_productNode.getProductNode_ID());
					nodeTaskService.insertOneNodeTask(user, gbpm_nodeTask);
				}
				
			};
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 查询产品列表
	 */
	@Override
	public List<Gbpm_product> selectProductList(String wheresql) {
		return productMapper.selectProductList(wheresql);
	}
	
}
package com.zjm.gbpm.productNode.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_productNodeMapper;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.dicNode.service.DicNodeService;
import com.zjm.gbpm.nodeTask.service.NodeTaskService;
import com.zjm.gbpm.productNode.service.ProductNodeService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Service("productNodeService")
@Transactional
public class ProductNodeServiceImpl implements ProductNodeService{
	
	@Resource
	private Gbpm_productNodeMapper productNodeMapper;
	@Resource
	private LogService logService;
	@Resource
	private DicNodeService dicNodeService;
	@Resource
	private NodeTaskService nodeTaskService;
	
	/**
	 * 查询流程节点分页列表
	 */
	@Override
	public PageTable<Gbpm_productNode> selectProductNodePageTable(PageTable<Gbpm_productNode> pageTable) {
		pageTable.setRows(productNodeMapper.selectProductNodePageTable(pageTable));
		pageTable.setTotal(productNodeMapper.selectProductNodePageTable_Count(pageTable));
		return pageTable;
	}

	/**
	 * 新增/修改时判断流程节点名称是否存在
	 */
	@Override
	public Boolean isExistProductNodeNames(Gbpm_productNode productNode) {
		if (productNodeMapper.isExistProductNodeNames(productNode) == 0) {
			return true;
		}
		return false;
	}

	/**
	 *  插入一条流程节点
	 */
	@Override
	public Boolean insertOneProductNode(User user, Gbpm_productNode productNode) {
		productNode.setProductNode_ID(Tool.createUUID32());
		productNode.setUnit_uid(user.getUnit_uid());
		productNode.setUnit_uidName(user.getUnit_uidName());
		productNode.setUpdateUserName(user.getUser_name());
		if(productNodeMapper.insertOneProductNode(productNode)==1){
			//新增的时候排序 如果是复制新版本就不需要排序
			if (productNode.getNodeSort() == null) {
				String wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
				wheresql = wheresql + " and productID = \'" + productNode.getProductID() +"\' ORDER BY  case when nodeSort is null then 1 else 0 end ,nodeSort" ;
				List<Gbpm_productNode>  productNodeList=productNodeMapper.selectProductNodeListByProductID(wheresql);
				for(int i = 0 ; i < productNodeList.size() ; i++) {
					Gbpm_productNode gbpm_productNode = productNodeList.get(i);
					gbpm_productNode.setNodeSort(i+1);
					productNodeMapper.updateOneProductNode(gbpm_productNode);
				}
			}
			
			logService.insertOneOperatorLogInfo(user, "流程节点管理", "添加", "添加"+productNode.getProductNode_ID());
			return true;
		}
		else
			return false;
	}

	/**
	 *  查询一条流程节点信息
	 */
	@Override
	public Gbpm_productNode selectOneProductNodeInfo(String wheresql) {
		Gbpm_productNode productNode = productNodeMapper.selectOneProductNode(wheresql);
		return productNode;
	}

	/**
	 *  修改一条流程节点信息
	 */
	@Override
	public Boolean updateOneProductNodeInfo(User user, Gbpm_productNode productNode) {
		productNode.setUpdateUserName(user.getUser_name());
		if(productNodeMapper.updateOneProductNode(productNode)==1){
			logService.insertOneOperatorLogInfo(user, "流程节点管理", "修改","修改"+productNode.getProductNode_ID());
			return true;
		}else
			return false;
	}

	/**
	 *  删除一条流程节点信息
	 */
	@Override
	public Boolean deleteOneProductNode(User user, Gbpm_productNode productNode) {
		String wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
		wheresql= wheresql + " and productNode_ID=\'"+productNode.getProductNode_ID()+"\'";
		Gbpm_productNode oldProductNode = productNodeMapper.selectOneProductNode(wheresql);
		if(productNodeMapper.deleteOneProductNode(productNode)==1){
			wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
			wheresql = wheresql + " and productID = \'" + oldProductNode.getProductID() +"\' ORDER BY  case when nodeSort is null then 1 else 0 end ,nodeSort" ;
			List<Gbpm_productNode>  productNodeList=productNodeMapper.selectProductNodeListByProductID(wheresql);
			for(int i = 0 ; i < productNodeList.size() ; i++) {
				Gbpm_productNode gbpm_productNode = productNodeList.get(i);
				gbpm_productNode.setNodeSort(i+1);
				productNodeMapper.updateOneProductNode(gbpm_productNode);
			}
			logService.insertOneOperatorLogInfo(user, "流程节点管理", "删除", "删除"+productNode.getProductNode_ID());
			wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
			wheresql = wheresql + " and productNodeID = \'" + productNode.getProductNode_ID() +"\'" ;
			nodeTaskService.deleteNodeTaskByWheresql(user,wheresql);
			return true;
		}else
			return false;
	}

	/**
	 *根据流程ID取该流程下的所有节点 
	 */
	@Override
	public List<Gbpm_productNode> selectProductNodeListByProductID(String wheresql) {
		List<Gbpm_productNode> productNodeList = productNodeMapper.selectProductNodeListByProductID(wheresql);
		return productNodeList;
	}

	/**
	 * 修改节点顺序
	 */
	@Override
	public Boolean updateOneProductNode(User userSession, Gbpm_productNode productNode) {
		productNode.setUpdateUserName(userSession.getUser_name());
		if(productNodeMapper.updateOneProductNode(productNode)==1){
			logService.insertOneOperatorLogInfo(userSession, "产品流程节点", "修改","修改"+productNode.getProductNode_ID());
			return true;
		}else{
			return false;
		}
	}

	/**
	 *  根据wheresql删除流程节点信息
	 */
	@Override
	public void delProductNodeByWheresql(User userSession,String wheresql) {
		productNodeMapper.delProductNodeByWheresql(wheresql);
		logService.insertOneOperatorLogInfo(userSession, "产品流程节点", "删除","删除");
	}
	
}
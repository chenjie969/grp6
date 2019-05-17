package com.zjm.gbpm.dicNode.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_dicNodeMapper;
import com.zjm.gbpm.db.model.Gbpm_dicNode;
import com.zjm.gbpm.dicNode.service.DicNodeService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Service("dicNodeService")
@Transactional
public class DicNodeServiceImpl implements DicNodeService {

	@Resource
	private Gbpm_dicNodeMapper dicNodeMapper;
	@Resource
	private LogService logService;
	
	
	/**
	 * 分页查询节点列表
	 */
	
	@Override
	public PageTable<Gbpm_dicNode> selectDicNodePageTable(PageTable<Gbpm_dicNode> pageTable) {
		List<Gbpm_dicNode> dicNodeList = dicNodeMapper.selectDicNodePageTable(pageTable);
		pageTable.setRows(dicNodeList);
		Long dicNodeTotal;
		try {
			dicNodeTotal = dicNodeMapper.selectDicNodePageTable_Count(pageTable);
			pageTable.setTotal(dicNodeTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	
	/**
	 *  查询一条节点
	 */
	@Override
	public Gbpm_dicNode selectOneDicNode(Gbpm_dicNode dicnode) {
		try {
			dicnode = dicNodeMapper.selectOneDicNode(dicnode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dicnode;
	}
	
	/**
	 *  插入一条节点
	 */
	@Override
	public Boolean insertOneDicNode(User user,Gbpm_dicNode dicnode) {
		dicnode.setNode_ID(Tool.createUUID32());
		dicnode.setUnit_uid(user.getUnit_uid());
		dicnode.setUnit_uidName(user.getUnit_uidName());
		dicnode.setUpdateUserName(user.getUser_name());
		if(dicNodeMapper.insertOneDicNode(dicnode)==1){
			try {
				logService.insertOneOperatorLogInfo(user, "节点", "添加", "添加"+dicnode.getNodeNames());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 *  修改一条节点
	 */
	@Override
	public Boolean updateOneDicNode(User user,Gbpm_dicNode dicnode) {
		dicnode.setUpdateUserName(user.getUser_name());
		if(dicNodeMapper.updateOneDicNode(dicnode)==1){
			try {
				logService.insertOneOperatorLogInfo(user, "节点", "修改","修改"+dicnode.getNodeNames());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 *  删除一条节点
	 */
	@Override
	public Boolean deleteOneDicNode(User user,Gbpm_dicNode dicnode) {
		dicnode = selectOneDicNode(dicnode);
		if(dicNodeMapper.deleteOneDicNode(dicnode)==1){
			try {
				logService.insertOneOperatorLogInfo(user, "节点", "删除", "删除"+dicnode.getNodeNames());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 *  判断节点名称是否已存在
	 */
	@Override
	public Boolean isExistDicNodeNames(Gbpm_dicNode dicnode) {
		if(dicNodeMapper.isExistDicNodeNames(dicnode) == 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查询所有节点
	 */
	@Override
	public List<Gbpm_dicNode> selectAllNodeList(Gbpm_dicNode dicNode) {
		return dicNodeMapper.selectAllNodeList(dicNode);
	}

	/**
	 * 判断节点编号是否存在
	 * @param dicNode
	 * @return
	 */
	@Override
	public Boolean isExistNodeCode(Gbpm_dicNode dicNode) {
		if(dicNodeMapper.isExistNodeCode(dicNode) == 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 获取节点树
	 */
	@Override
	public List<Map<String, Object>> selectNodeTree(User userSession) {
			List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
			
	    	Map<String,Object> map =new HashMap<String,Object>();
	    
//				map =new HashMap<String,Object>();
//				map.put("id", "");
//				map.put("pId", "");
//				map.put("name", dicNode.getNodeNames());
//				map.put("type", "depart");
//				mapList.add(map);
			Gbpm_dicNode gbpm_dicNode = new Gbpm_dicNode();
			gbpm_dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());//获取机构
			List<Gbpm_dicNode> dicNodeList = dicNodeMapper.selectAllNodeList(gbpm_dicNode);
			for (Gbpm_dicNode dicNode : dicNodeList) {
				map =new HashMap<String,Object>();
				map.put("id", dicNode.getNode_ID());
				map.put("pId", "");
				map.put("name", dicNode.getNodeNames());
				map.put("type", "user");
				mapList.add(map);
			}
		    return mapList;
	}
}

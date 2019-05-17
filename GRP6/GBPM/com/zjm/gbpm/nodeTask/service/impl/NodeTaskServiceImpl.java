package com.zjm.gbpm.nodeTask.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.gbpm.db.map.Gbpm_nodeTaskMapper;
import com.zjm.gbpm.db.model.Gbpm_nodeTask;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.nodeTask.service.NodeTaskService;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_roles;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.roles.service.RolesService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;


@Service("nodeTaskService")
@Transactional
public class NodeTaskServiceImpl implements NodeTaskService{
	
	@Resource
	private Gbpm_nodeTaskMapper nodeTaskMapper;
	@Resource
	private LogService logService;
	@Resource
	private RolesService rolesService;
	@Resource
	private DepartsService departsService;
	
	/**
	 * 查询节点任务事项分页列表
	 */
	@Override
	public PageTable<Gbpm_nodeTask> selectNodeTaskPageTable(PageTable<Gbpm_nodeTask> pageTable) {
		List<Gbpm_nodeTask> nodeTaskList = nodeTaskMapper.selectNodeTaskPageTable(pageTable);
		List<Gbpm_nodeTask> nodeTasks = new ArrayList<>();
		for (Gbpm_nodeTask nodeTask : nodeTaskList) {
			//实例化流程任务 如果是角色  冗余角色人员到前台选具体办理人 如果是部门负责人 取登录人所在部门的负责人 如果是流程发起人和当前办理人 去页面取
			
			if (nodeTask.getOperaterTypeID() == "58ff15c6871c4656998a4f2d411f41e8") {
				//部门负责人
				Sys_departs departs = new Sys_departs();
				departs.setDepart_uid(SystemSession.getUserSession().getDepart_uid());
				departs = departsService.selectOneDepartsInfo(departs);
				nodeTask.setHandleUserID(departs.getLeve1_user_id()==null?"1":departs.getLeve1_user_id());
				nodeTask.setHandleUserName(departs.getLeve1_user_name()==null?"无部门负责人":departs.getLeve1_user_name());
			}else if (nodeTask.getOperaterTypeName().equals("角色中某一人")) {
				Sys_roles roles = new Sys_roles();
				roles.setRole_uid(nodeTask.getOperatorID());
				roles.setUnit_uid(pageTable.getQueryCondition().getUnit_uid());
				roles = rolesService.selectOneRolesInfo(roles);
				if (roles != null && roles.getUser_uids() != null && !roles.getUser_uids().equals("")) {
					String [] user_uids= roles.getUser_uids().split(",");
					String [] user_names= roles.getUser_names().split(",");
					Map<String, String> map = new HashMap<>();
					for(int i=0;i<user_uids.length;i++){
						map.put(user_uids[i], user_names[i]);
					}
					nodeTask.setHandleUserMap(map);
				}
			}
//			else if (nodeTask.getOperaterTypeName().equals("角色中任何人")) {
//				Sys_roles roles = new Sys_roles();
//				roles.setRole_uid(nodeTask.getOperatorID());
//				roles.setUnit_uid(pageTable.getQueryCondition().getUnit_uid());
//				roles = rolesService.selectOneRolesInfo(roles);
//				if (roles != null && roles.getUser_uids() != null && !roles.getUser_uids().equals("")) {
//					String handleUserID = roles.getUser_uids().replace(",",".");
//					nodeTask.setHandleUserID(handleUserID);
//					nodeTask.setHandleUserName(roles.getRole_name()==null?"无角色":roles.getRole_name());
//				}
//			}
			nodeTasks.add(nodeTask);
		}
		pageTable.setRows(nodeTasks);
		pageTable.setTotal(nodeTaskMapper.selectNodeTaskPageTable_Count(pageTable));
		return pageTable;
	}

	/**
	 * 新增/修改时判断节点任务事项名称是否存在
	 */
	@Override
	public Boolean isExistNodeTaskName(Gbpm_nodeTask nodeTask) {
		if (nodeTaskMapper.isExistNodeTaskName(nodeTask) == 0) {
			return true;
		}
		return false;
	}

	/**
	 *  插入一条节点任务事项
	 */
	@Override
	public Boolean insertOneNodeTask(User user, Gbpm_nodeTask nodeTask) {
		nodeTask.setNodeTask_ID(Tool.createUUID32());
		nodeTask.setUnit_uid(user.getUnit_uid());
		nodeTask.setUnit_uidName(user.getUnit_uidName());
		nodeTask.setUpdateUserName(user.getUser_name());
		if(nodeTaskMapper.insertOneNodeTask(nodeTask)==1){
			//新增的时候排序 如果是创建新版本就不需要排序
			if (nodeTask.getTaskSort() == null) {
				String wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
				wheresql = wheresql + " and productNodeID = \'" + nodeTask.getProductNodeID() +"\' ORDER BY updatedatetime " ;
				List<Gbpm_nodeTask> nodeTaskList = nodeTaskMapper.selectNodeTaskListByWheresql(wheresql);
				System.out.println(nodeTaskList);
				for(int i = 0 ; i < nodeTaskList.size() ; i++) {
					Gbpm_nodeTask gbpm_nodeTask = nodeTaskList.get(i);
					gbpm_nodeTask.setTaskSort(i+1);
					nodeTaskMapper.updateOneNodeTask(gbpm_nodeTask);
				}
			}
			logService.insertOneOperatorLogInfo(user, "节点任务事项管理", "节点任务事项管理添加", "添加"+nodeTask.getNodeTask_ID());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  插入一条节点任务事项
	 */
	@Override
	public Boolean insertMuchNodeTask(User user, Gbpm_nodeTask nodeTask) {
		String[] taskMangerIDs = nodeTask.getTaskMangerID().split(",");
		String[] taskNames = nodeTask.getTaskName().split(",");
		for (int n = 0; n < taskMangerIDs.length; n++) {
			nodeTask.setNodeTask_ID(Tool.createUUID32());
			nodeTask.setUnit_uid(user.getUnit_uid());
			nodeTask.setUnit_uidName(user.getUnit_uidName());
			nodeTask.setUpdateUserName(user.getUser_name());
			nodeTask.setTaskMangerID(taskMangerIDs[n]);
			nodeTask.setTaskName(taskNames[n]);
			if(nodeTaskMapper.insertOneNodeTask(nodeTask)==1){
				//新增的时候排序 如果是创建新版本就不需要排序
				if (nodeTask.getTaskSort() == null) {
					String wheresql=" and unit_uid=\'"+user.getUnit_uid()+"\'";
					wheresql = wheresql + " and productNodeID = \'" + nodeTask.getProductNodeID() +"\' ORDER BY updatedatetime " ;
					List<Gbpm_nodeTask> nodeTaskList = nodeTaskMapper.selectNodeTaskListByWheresql(wheresql);
					for(int i = 0 ; i < nodeTaskList.size() ; i++) {
						Gbpm_nodeTask gbpm_nodeTask = nodeTaskList.get(i);
						gbpm_nodeTask.setTaskSort(i+1);
						nodeTaskMapper.updateOneNodeTask(gbpm_nodeTask);
					}
				}
				logService.insertOneOperatorLogInfo(user, "节点任务事项管理", "节点任务事项管理添加", "添加"+nodeTask.getNodeTask_ID());
			}
		}
		
		return true;
			
	}

	/**
	 *  查询一条节点任务事项信息
	 */
	@Override
	public Gbpm_nodeTask selectOneNodeTaskInfo(Gbpm_nodeTask nodeTask) {
		return nodeTaskMapper.selectOneNodeTask(nodeTask);
	}

	/**
	 *  修改一条节点任务事项信息
	 */
	@Override
	public Boolean updateOneNodeTaskInfo(User user, Gbpm_nodeTask nodeTask) {
		nodeTask.setUpdateUserName(user.getUser_name());
		nodeTask.setUnit_uid(user.getUnit_uid());
		nodeTask.setUnit_uidName(user.getUnit_uidName());
		nodeTask.setUpdateUserName(user.getUser_name());
		if(nodeTaskMapper.updateOneNodeTask(nodeTask)==1){
			logService.insertOneOperatorLogInfo(user, "节点任务事项管理", "节点任务事项管理修改","修改"+nodeTask.getNodeTask_ID());
			return true;
		}else
			return false;
	}

	/**
	 *  删除一条节点任务事项信息
	 */
	@Override
	public Boolean deleteOneNodeTask(User user, Gbpm_nodeTask nodeTask) {
		nodeTask = nodeTaskMapper.selectOneNodeTask(nodeTask);
		if(nodeTaskMapper.deleteOneNodeTask(nodeTask)==1){
			logService.insertOneOperatorLogInfo(user, "节点任务事项管理", "节点任务事项管理删除", "删除"+nodeTask.getNodeTask_ID());
			return true;
		}else
			return false;
	}
	
	/**
	 *  根据whresql查询节点任务事项Lisgt
	 */
	@Override
	public List<Gbpm_nodeTask> selectNodeTaskListByWheresql(String wheresql) {
		List<Gbpm_nodeTask> nodeTasklist = nodeTaskMapper.selectNodeTaskListByWheresql(wheresql);
		return nodeTasklist;
	}

	/**
	 *  根据wheresql删除产品节点任务事项
	 */
	@Override
	public void deleteNodeTaskByWheresql(User user, String wheresql) {
		nodeTaskMapper.deleteNodeTaskByWheresql(wheresql);
		logService.insertOneOperatorLogInfo(user, "节点任务事项管理", "节点任务事项管理删除", "删除");
	}

	/**
	 *  执行操作-修改节点顺序
	 */
	@Override
	public Boolean updateSortNodeTask(User userSession, Gbpm_nodeTask nodeTask) {
		nodeTask.setUpdateUserName(userSession.getUser_name());
		if(nodeTaskMapper.updateSortNodeTask(nodeTask)==1){
			logService.insertOneOperatorLogInfo(userSession, "产品流程管理", "修改","修改"+nodeTask.getNodeTask_ID());
			return true;
		}else{
			return false;
		}
	}
	
}
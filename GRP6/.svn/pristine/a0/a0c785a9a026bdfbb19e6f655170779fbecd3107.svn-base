package com.zjm.gbpm.nodeTask.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.db.model.Gbpm_nodeTask;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.dicNode.service.DicNodeService;
import com.zjm.gbpm.dicTaskManager.service.DicTaskManagerService;
import com.zjm.gbpm.nodeTask.service.NodeTaskService;
import com.zjm.gbpm.processDefinition.service.ProcessDefinitionService;
import com.zjm.gbpm.product.service.ProductService;
import com.zjm.gbpm.productNode.service.ProductNodeService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.db.model.Sys_roles;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.roles.service.RolesService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/gbpm/nodeTask")
public class NodeTaskAction{
	
	@Resource
	ProductService productService;
	@Resource
	DicNodeService dicNodeService;
	@Resource
	ProductNodeService productNodeService;
	@Resource
	NodeTaskService nodeTaskService;
	@Resource
	DicTaskManagerService dicTaskManagerService;
	@Resource
	DicTypeService dicTypeService;
	@Resource
	RolesService rolesService;
	@Resource
	ProcessDefinitionService processDefinitionService;
	
	
	/**
	 * 节点任务事项分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectNodeTaskPageTable")
	@ResponseBody
	public AjaxRes selectNodeTaskPageTable(@RequestBody PageTable<Gbpm_nodeTask> pageTable) {
		try {
			pageTable.setWheresql(queryConditionSql(pageTable));
			pageTable=nodeTaskService.selectNodeTaskPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 节点任务事项分页列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable<Gbpm_nodeTask> pageTable){
		String wheresql=" and taskmanager.unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			//wheresql=wheresql+" and dicTypeName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			if (pageTable.getQueryCondition().getNodeSort()!=null && !pageTable.getQueryCondition().getNodeSort().equals("") ) {
				pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
				String sqlString=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
				sqlString=sqlString+" and productID =\'"+pageTable.getQueryCondition().getProductID().trim()+"\'";
				sqlString=sqlString+" and nodeSort = "+(pageTable.getQueryCondition().getNodeSort()+1);
				//如果传入产品节点顺序，取产品流程下该顺序的节点下的所有任务  项目处理用
				wheresql=wheresql+" and productID =\'"+pageTable.getQueryCondition().getProductID().trim()+"\'";
				wheresql=wheresql+" and nodeSort = "+(pageTable.getQueryCondition().getNodeSort()+1);
				Gbpm_productNode productNode = productNodeService.selectOneProductNodeInfo(sqlString);
				wheresql=" and taskmanager.unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
				wheresql=wheresql+" and productNodeID=\'"+productNode.getProductNode_ID()+"\'";
			}else{
				//根据传入的产品流程ID或产品流程节点ID获取任务事项
				if(pageTable.getQueryCondition().getProductID()!=null && !pageTable.getQueryCondition().getProductID().equals("") ){
					wheresql=wheresql+" and productID =\'"+pageTable.getQueryCondition().getProductID().trim()+"\'";
				}else if (pageTable.getQueryCondition().getProductNodeID()!=null && !pageTable.getQueryCondition().getProductNodeID().equals("")){
					wheresql=wheresql+" and productNodeID =\'"+pageTable.getQueryCondition().getProductNodeID().trim()+"\'";
				}
			}
		}
		return wheresql;
	}
	
	/**
	 * 返回页面---添加节点任务事项
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/addNodeTaskPage")
	@ResponseBody
	public ModelAndView addNodeTaskPage(Gbpm_productNode productNode){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			String wheresql = " and productNode_ID = \'" + productNode.getProductNode_ID() + "\'"; 
			productNode = productNodeService.selectOneProductNodeInfo(wheresql);
			//获取任务事项类型集合
			//List<C_dictype> taskTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='327397a3b5ec46df92113edb0326d5aa'");
			//获取任务事项集合
			//List<Gbpm_dicTaskManager> taskList = dicTaskManagerService.selectTaskManagerList("", SystemSession.getUserSession());
			//获取前置任务集合
			//List<Gbpm_dicTaskManager> beforeTaskList = dicTaskManagerService.selectTaskManagerList("and isPersonTask = 1", SystemSession.getUserSession());
			//获取后置任务集合
			//List<Gbpm_dicTaskManager> afterTaskList = dicTaskManagerService.selectTaskManagerList(" ", SystemSession.getUserSession());
			
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql=wheresql+" and dicTypePID = \'"+"1f481faa15094ffcac5ae6fba65af25c"+"\'";
			List<C_dictype>  warnMethodList=dicTypeService.selectAllDicTypeList(wheresql);
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql=wheresql+" and dicTypePID = \'"+"c692ccec1a7440fcaecebe1686cb7123"+"\'";
			List<C_dictype>  operaterTypeList=dicTypeService.selectAllDicTypeList(wheresql);
			//获取角色List
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			List<Sys_roles> rolesList = rolesService.selectRolesList(wheresql);
			mv.getModel().put("productNode", productNode);
			mv.getModel().put("warnMethodList", warnMethodList);
			mv.getModel().put("operaterTypeList", operaterTypeList);
			mv.getModel().put("rolesList", rolesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/nodeTaskAdd");
		return mv;
	}
	
	/**
	 * 返回页面---批量添加节点任务事项
	 * @return
	 */
	@RequestMapping(value="/addMuchNodeTaskPage")
	@ResponseBody
	public ModelAndView addMuchNodeTaskPage(Gbpm_productNode productNode){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			String wheresql = " and productNode_ID = \'" + productNode.getProductNode_ID() + "\'"; 
			productNode = productNodeService.selectOneProductNodeInfo(wheresql);
			
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql=wheresql+" and dicTypePID = \'"+"1f481faa15094ffcac5ae6fba65af25c"+"\'";
			List<C_dictype>  warnMethodList=dicTypeService.selectAllDicTypeList(wheresql);
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql=wheresql+" and dicTypePID = \'"+"c692ccec1a7440fcaecebe1686cb7123"+"\'";
			List<C_dictype>  operaterTypeList=dicTypeService.selectAllDicTypeList(wheresql);
			//获取角色List
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			List<Sys_roles> rolesList = rolesService.selectRolesList(wheresql);
			mv.getModel().put("productNode", productNode);
			mv.getModel().put("warnMethodList", warnMethodList);
			mv.getModel().put("operaterTypeList", operaterTypeList);
			mv.getModel().put("rolesList", rolesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/nodeTaskMuchAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条节点任务
	 */
	@RequestMapping(value="/insertOneNodeTask")
	@ResponseBody
	public AjaxRes insertOneNodeTask(@RequestBody Gbpm_nodeTask nodeTask){
		AjaxRes ar = new AjaxRes();
		try {
			Boolean b = false;
			b = nodeTaskService.insertOneNodeTask(SystemSession.getUserSession(), nodeTask);
			ar.setSucceed(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 *  执行操作-新增多个节点任务
	 */
	@RequestMapping(value="/insertMuchNodeTask")
	@ResponseBody
	public AjaxRes insertMuchNodeTask(@RequestBody Gbpm_nodeTask nodeTask){
		AjaxRes ar = new AjaxRes();
		try {
			Boolean b = false;
			b = nodeTaskService.insertMuchNodeTask(SystemSession.getUserSession(), nodeTask);
			ar.setSucceed(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 返回页面---修改节点任务事项
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/editNodeTaskPage")
	@ResponseBody
	public ModelAndView editNodeTaskPage(Gbpm_nodeTask nodeTask){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			nodeTask = nodeTaskService.selectOneNodeTaskInfo(nodeTask);
			String wheresql = " and productNode_ID = \'" + nodeTask.getProductNodeID() + "\'"; 
			Gbpm_productNode productNode = productNodeService.selectOneProductNodeInfo(wheresql);
			
			//获取任务事项类型集合
			List<C_dictype> taskTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='327397a3b5ec46df92113edb0326d5aa'");
			String taskWhereSql = "";
			if (nodeTask.getTaskTypeID()!=null) {
				taskWhereSql = " and taskTypeID = \'" + nodeTask.getTaskTypeID()  + "\'";
			}
			//获取任务事项集合
			List<Gbpm_dicTaskManager> taskList = dicTaskManagerService.selectTaskManagerList(taskWhereSql, SystemSession.getUserSession());
			//获取前置任务集合
			List<Gbpm_dicTaskManager> beforeTaskList = dicTaskManagerService.selectTaskManagerList("and isPersonTask = 1", SystemSession.getUserSession());
			//获取后置任务集合
			List<Gbpm_dicTaskManager> afterTaskList = dicTaskManagerService.selectTaskManagerList(" and isPersonTask = 0", SystemSession.getUserSession());
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql=wheresql+" and dicTypePID = \'"+"1f481faa15094ffcac5ae6fba65af25c"+"\'";
			List<C_dictype>  warnMethodList=dicTypeService.selectAllDicTypeList(wheresql);
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql=wheresql+" and dicTypePID = \'"+"c692ccec1a7440fcaecebe1686cb7123"+"\'";
			List<C_dictype>  operaterTypeList=dicTypeService.selectAllDicTypeList(wheresql);
			//获取角色List
			wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			List<Sys_roles> rolesList = rolesService.selectRolesList(wheresql);
			//获取子流程模板
			List<Map<String, Object>> processDefinitionList = processDefinitionService.selectProcessDefinitionDeployList();
			mv.getModel().put("taskTypeList", taskTypeList);
			mv.getModel().put("taskList", taskList);
			mv.getModel().put("beforeTaskList", beforeTaskList);
			mv.getModel().put("afterTaskList", afterTaskList);
			mv.getModel().put("nodeTask", nodeTask);
			mv.getModel().put("productNode", productNode);
			mv.getModel().put("warnMethodList", warnMethodList);
			mv.getModel().put("operaterTypeList", operaterTypeList);
			mv.getModel().put("rolesList", rolesList);
			mv.getModel().put("processDefinitionList", processDefinitionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/nodeTaskEdit");
		return mv;
	}
	
	/**
	 *  执行操作-修改一条节点任务
	 */
	@RequestMapping(value="/updateOneNodeTask")
	@ResponseBody
	public AjaxRes updateOneNodeTask(@RequestBody Gbpm_nodeTask nodeTask){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(nodeTaskService.updateOneNodeTaskInfo(SystemSession.getUserSession(), nodeTask));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 *  执行操作-删除一条节点任务
	 */
	@RequestMapping(value="/deleteOneNodeTask")
	@ResponseBody
	public AjaxRes deleteOneNodeTask(@RequestBody Gbpm_nodeTask nodeTask){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(nodeTaskService.deleteOneNodeTask(SystemSession.getUserSession(), nodeTask));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 查询一个节点下所有的任务  用于顺序调整
	 * @return
	 */
	@RequestMapping(value="/sortNodeTask", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView sortNodeTask(Gbpm_nodeTask nodeTask){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			nodeTask.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql = wheresql + " and productNodeID = \'" + nodeTask.getProductNodeID() +"\' ORDER BY taskSort ASC";
			List<Gbpm_nodeTask>  nodeTaskList=nodeTaskService.selectNodeTaskListByWheresql(wheresql);
			mv.getModel().put("nodeTaskList", nodeTaskList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/nodeTaskSort");
		return mv;
		
	}
	
	/**
	 *  执行操作-修改节点顺序
	 */
	@RequestMapping(value="/updateSortNodeTask")
	@ResponseBody
	public AjaxRes updateSortNodeTask(@RequestBody Gbpm_nodeTask nodeTask){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(nodeTaskService.updateSortNodeTask(SystemSession.getUserSession(), nodeTask));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
}
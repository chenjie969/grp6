package com.zjm.gworkFlow.startWorkFlow.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.opensymphony.workflow.Workflow;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.workflow.loader.WorkflowDescriptor;
import com.zjm.gworkFlow.db.model.PendingWorkFlow;
import com.zjm.common.db.model.UrlParam;
import com.zjm.gworkFlow.db.map.FlowProjRelationMapper;
import com.zjm.gworkFlow.db.map.OsGworkflowComponentsMapper;
import com.zjm.gworkFlow.db.map.OsGworkflowInstanceMapper;
import com.zjm.gworkFlow.db.map.OsGworkflowProjsuggestMapper;
import com.zjm.gworkFlow.db.map.OsHistorystepMapper;
import com.zjm.gworkFlow.db.model.FlowRole;
import com.zjm.gworkFlow.db.model.OsGworkFlowProjIDFlowID;
import com.zjm.gworkFlow.db.model.OsGworkflowComponents;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.db.model.OsGworkflowInstance;
import com.zjm.gworkFlow.db.model.OsHistorystep;
import com.zjm.gworkFlow.db.model.Os_action;
import com.zjm.gworkFlow.db.model.Os_step;
import com.zjm.gworkFlow.flowtemplate.service.FlowtemplateService;
import com.zjm.gworkFlow.pendingWorkFlow.service.PendingWorkFlowService;
import com.zjm.gworkFlow.startWorkFlow.service.GworkFlowService;
import com.zjm.gworkFlow.workFlowFactory.WorkFlowFactory;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-19 下午6:52:11 类说明：
 */
@Service("gworkFlowService")
@Transactional
public class GworkFlowServiceImpl implements GworkFlowService {

	// workFlow prototype	
	@Resource(name = "workflow")
	private Workflow workflow;


	// 流程 项目关系
	//@Resource(name = "flowProjRelationDao")
	//private FlowProjRelationDao flowProjRelationDao;

	// 流程 项目关系
	@Resource
	private FlowProjRelationMapper flowProjRelationMapper;
	
	@Resource(name = "osGworkflowInstanceMapper")
	private OsGworkflowInstanceMapper osGworkflowInstanceMapper;

	// 流程 流程模板
	@Resource(name = "flowtemplateService")
	private FlowtemplateService flowtemplateService;

	//
	@Resource(name = "workFlowFactory")
	private WorkFlowFactory workFlowFactory;

	// 流程构建
	//@Resource(name = "osGworkflowProjsuggestDao")
	//private OsGworkflowProjsuggestDao osGworkflowProjsuggestDao;
	// 流程构建
	@Resource
	private OsGworkflowProjsuggestMapper osGworkflowProjsuggestMapper;

	//历史步骤
	//@Resource(name="osHistorystepDao")
	//private OsHistorystepDao osHistorystepDao;
	@Resource
	private OsHistorystepMapper osHistorystepMapper;

	//业务构件
	/*@Resource(name="osGworkflowComponentsDao")
	private OsGworkflowComponentsDao osGworkflowComponentsDao;*/

	@Resource
	private OsGworkflowComponentsMapper osGworkflowComponentsMapper;

	// 流程 流程模板
	@Resource(name = "pendingWorkFlowService")
	private PendingWorkFlowService pendingWorkFlowService;


	/**
	 * 创建一个工作流实例
	 * 
	 * flowType 流程类型   项目 ： project 、公文 : oa     mashuo add 20150505
	 */
	@Transactional
	public Long createworkflowInstance(OsGworkflowFlowtemplate osGworkflowFlowtemplate) {
		Long id = 0L;
		try {
			// 情况一：启动并初始流程测试
			// 参数1：流程的名称
			String flowTemplateID = osGworkflowFlowtemplate.getFlowTemplateID(); // 根据流程模板id和担保机构id取得流程模板对象
			osGworkflowFlowtemplate.setUnit_uid(osGworkflowFlowtemplate.getUnit_uid());

			OsGworkflowFlowtemplate osGworkflowFlowtemplatetmp = flowtemplateService.getOneGworkflowTemplate(osGworkflowFlowtemplate);
			String flowTempaleMapName = osGworkflowFlowtemplatetmp.getFlowTempaleMapName();
			String flowTemplateName = osGworkflowFlowtemplatetmp.getFlowTemplateName();
			//			System.out.println("flowTemplateName:" + flowTemplateName);

			// 创建流程实例		
			/*
			ApplicationContext cxt = new ClassPathXmlApplicationContext(
					"classpath:/spring/applicationContext.xml");
			Workflow wf = (Workflow) cxt.getBean("workflow");
			 */

			Map<String, String> map = new HashMap<String, String>();
			//id = wf.initialize(flowTempaleMapName, 100, map);// 返回流程实例的id
			id = workflow.initialize(flowTempaleMapName, 100, map);// 返回流程实例的id

			// 建立项目和流程实例的关联关系
			OsGworkFlowProjIDFlowID osGworkFlowProjIDFlowID = new OsGworkFlowProjIDFlowID();
			osGworkFlowProjIDFlowID.setProjectID(osGworkflowFlowtemplate.getProjectID());
			osGworkFlowProjIDFlowID.setFlowTemplateID(flowTemplateID);
			osGworkFlowProjIDFlowID.setFlowTemplateName(flowTemplateName);
			osGworkFlowProjIDFlowID.setEnter_ID(id);
			osGworkFlowProjIDFlowID.setFlowCtreatorID(osGworkflowFlowtemplate.getUser_uid());
			osGworkFlowProjIDFlowID.setUnit_uid(osGworkflowFlowtemplate.getUnit_uid());
			osGworkFlowProjIDFlowID.setEntityName(osGworkflowFlowtemplate.getEntityName());
			osGworkFlowProjIDFlowID.setFlowType(osGworkflowFlowtemplate.getFlowType());
			System.out.println(">>>>>>>>>>>>>");
			System.out.println(JSON.toJSONString(osGworkFlowProjIDFlowID));
			workFlowFactory.insertOneprojAndflowID(osGworkFlowProjIDFlowID);
			
			//添加业务实体和流程实例的关联关系
			OsGworkflowInstance instance = new OsGworkflowInstance();
			instance.setApplyId(osGworkflowFlowtemplate.getProjectID());
			instance.setBusinessId(osGworkflowFlowtemplate.getBusinessId());
			instance.setBusinessType(osGworkflowFlowtemplate.getBusinessType());
			instance.setEntryId(id);
			instance.setFlowTemplateId(osGworkflowFlowtemplate.getFlowTemplateID());
			
			instance.setUser_uid(osGworkflowFlowtemplate.getUser_uid());
			instance.setUnit_uid(osGworkflowFlowtemplate.getUnit_uid());
			System.out.println();
			System.out.println("OsGworkflowInstance insert:"+JSON.toJSONString(instance));
			osGworkflowInstanceMapper.insertOne(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}// 返回流程实例的id
		return id;
	}

	/**
	 * 得到下一个步骤上的角色集合，下一个步骤，有可能是普通步骤，分支步骤，动态分支步骤，合并步骤
	 * @param flowid
	 * @param actionid
	 * @param projectid
	 * @return
	 */
	public FlowRole returnNextStepRoles(long flowid, int actionid, String projectid){
		Map<String, String> map = new HashMap<String, String>();
		map.put("projectid", projectid);
		FlowRole flowRoleTmp = new FlowRole();
		try {
			flowRoleTmp = workflow.getNextStepRoles(flowid, actionid, map);
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
		return flowRoleTmp;
	}

	/**
	 * 执行某一个流程实例的一个动作
	 */
	public void doAction(long flowid, int actionid, String projectid,Map<String,String> rolemap) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("projectid", projectid);
			map.put("busiType", "融资担保");
			workflow.doAction(flowid, actionid, map,rolemap);
		} catch (Exception e) {
			System.out.println("do action in error:" + e);
			e.printStackTrace();
		}
		/*//添加项目成员记录
		//转换角色Map信息
		if(rolemap != null && rolemap.size() != 0){
			//Map<Long,String> sysUserMap = sysDicService.sysUserAndAdminDicMap();
			Map<String,String> membersMap = new HashMap<String,String>();
			Set<Entry<String, Long>> meamberSet = rolemap.entrySet();
			Iterator<Entry<String, Long>>  meamberIterator = meamberSet.iterator();
			while(meamberIterator.hasNext()){
				Map.Entry<String,Long> entry = (Entry<String,Long>) meamberIterator.next();
				String key = entry.getKey();
				Long value = entry.getValue();
				membersMap.put(key.replace("R",""), String.valueOf(value));
			}
			projectmembersService.appendProjectmembers(projectid,membersMap);
		}*/
	}

	/**
	 * 取得步骤上的所有动作
	 * @param flowID 流程id
	 * @param stepID 步骤id
	 */
	public List<Os_action> getStepAllActions(Long flowID, Integer stepID) {
		String userUid = String.valueOf(SystemSession.getUserSession().getUser_uid());
		// 取得某个步骤上的所有动作ID测试
		int[] actions = workflow.getOneCurStepAvailableActions(flowID,stepID,userUid, null);
		WorkflowDescriptor wd = workflow.getWorkflowDescriptor(workflow.getWorkflowName(flowID));
		// 取得步骤上的所有动作
		List<Os_action> actionList = new ArrayList<Os_action>();
		for (int i = 0; i < actions.length; i++) {
			Os_action osaction = new Os_action();
			osaction.setActionID(actions[i]);//设置动作id
			String name = wd.getAction(actions[i]).getName();// 根据动作ID,取得动作名称
			osaction.setActionName(name);
			String view = wd.getAction(actions[i]).getView();// 根据动作ID,取得动作名称
			osaction.setView(view);
			// 从业务构件中取得此动作ID，对应的action地址
			//osaction.setActionURL(getActionURL(osaction.getActionID()));
			osaction.setFlowid(flowID);
			actionList.add(osaction);
		}
		return actionList;
	}

	/**
	 * 获取步骤上的业务构件
	 * @param view
	 * @return
	 */
	public List<OsGworkflowComponents> getStepAllView(String view){
		List<OsGworkflowComponents> OsGworkflowComponentsList = new ArrayList<OsGworkflowComponents>();
		if(view.trim() != null && !view.trim().equals("")){
			String[] Components = view.split(",");
			for (String component : Components) {
				OsGworkflowComponents osGworkflowComponents = new OsGworkflowComponents();
				osGworkflowComponents.setComponentID(component);
				OsGworkflowComponentsList.add(osGworkflowComponentsMapper.returnComponent(osGworkflowComponents));
			}
		}

		return OsGworkflowComponentsList;
	}

	// 通过动作ID,取得业务构件的action url
	private String getActionURL(Integer actionid) {
		String sActionid = actionid.toString();// 转换为字符串
		sActionid = sActionid.toString().substring(sActionid.length() - 3,sActionid.length());// 取后三位;
		// 获取编辑业务构件编辑页面action url
		OsGworkflowComponents osGworkflowComponents = new OsGworkflowComponents();
		osGworkflowComponents.setComponentID(sActionid);
		OsGworkflowComponents osaction = osGworkflowProjsuggestMapper.getActionURLByID(osGworkflowComponents);
		return osaction.getEditAction();
	}

	/**
	 * 取得项目的历史步骤
	 * @param flowID
	 * @return
	 */
	public List<OsHistorystep> getStepAllHistoryStep(long flowID){
		//历史步骤集合
		List<OsHistorystep> historylist_new = new ArrayList<OsHistorystep>();
		//当前步骤集合
		List<OsHistorystep> curlist_new = new ArrayList<OsHistorystep>();
		//历史步骤对象
		OsHistorystep osHistorystep = new OsHistorystep();
		osHistorystep.setEntry_ID(flowID);
		//获取所有的历史步骤
		List<OsHistorystep> osHistorystepList = osHistorystepMapper.getAllHistoryStep(osHistorystep);
		List<OsHistorystep> osHistorystepPrevList = null;
		//遍历所有的历史步骤
		for (OsHistorystep osHisstep : osHistorystepList) {
			//得到上一个步骤的id
			String prevName = "";
			osHistorystepPrevList = osHistorystepMapper.getHistoryPREVIOUS_ID(osHisstep.getId());
			for (OsHistorystep osHistorystepPrev : osHistorystepPrevList) {
				List<OsHistorystep> osHistorystepName = osHistorystepMapper.getHistoryPREVIOUS_stepName(osHistorystepPrev.getPrevious_ID());
				if(osHistorystepName.size() > 0){
					prevName = osHistorystepName.get(0).getStepName();
				}
			}
			osHisstep.setPrevious_Name(prevName);
			historylist_new.add(osHisstep);
		}
		List<OsHistorystep> curStepList = osHistorystepMapper.getAllCurSteps(flowID);
		for (OsHistorystep curStep : curStepList) {
			//得到上一个步骤的id
			String curName = "";
			List<OsHistorystep> curStepPrevList = osHistorystepMapper.getAllCurPreviousSteps(curStep.getId());
			for (OsHistorystep curStepPrev : curStepPrevList) {
				List<OsHistorystep> curStepPrevNameList = osHistorystepMapper.getHistoryPREVIOUS_stepName(curStepPrev.getPrevious_ID());
				if(curStepPrevNameList.size() > 0){
					curName = curStepPrevNameList.get(0).getStepName();
				}
			}
			curStep.setPrevious_Name(curName);
			curlist_new.add(curStep);
		}
		historylist_new.addAll(curlist_new);
		for(int i=0;i<historylist_new.size();i++){
			//超出限办时间
			historylist_new.get(i).setLimitDateMessage(Tool.returnLimitDateMessage(historylist_new.get(i).getStart_date(),historylist_new.get(i).getFinish_date(),historylist_new.get(i).getLimitDate(),historylist_new.get(i).getLimitDateUnit()));
		}

		return historylist_new;
	}
	/**
	 * 删除一个项目的流程信息
	 * @param view
	 * @return
	 */
	public Boolean delOneProjectFlow(String projectID){
		String wheresql="A.projectID=\'"+projectID+"\' AND A.unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		//删除流程信息
		if(osHistorystepMapper.delOneProjectFlow(wheresql)!=0){};
		//删除流程附件
		return null;
	}

	/**
	 * 否决项目
	 * @param projID
	 * @param busiType
	 * @return
	 */
	public Boolean stopProject(UrlParam urlParam){
		//否决项目  改变结案方式
		//Boolean chengeResault =  chengeProjEndType(urlParam);
		//手动否决项目
		Boolean chengeResault =pendingTOHistory(urlParam.getEntityID());
		/*
		OsGworkFlowProjIDFlowID osGworkFlowProjIDFlowID = new OsGworkFlowProjIDFlowID();
		osGworkFlowProjIDFlowID.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		osGworkFlowProjIDFlowID.setProjectID(garauProjects.getProjectID());
		List<OsGworkFlowProjIDFlowID> flowByProjectIDList = flowProjRelationDao.selectFlowIDByProjectID(osGworkFlowProjIDFlowID);

		for(OsGworkFlowProjIDFlowID flowByProjectID : flowByProjectIDList){
			try {
				Map<String, String> map = new HashMap<String, String>();
				map.put("projectid", flowByProjectID.getProjectID());
				workflow.doAction(flowByProjectID.getEnter_ID(),999555, map,null);
			} catch (Exception e) {
				System.out.println("do action in error:" + e);
				e.printStackTrace();
			}
		}
		 */
		return chengeResault;
	}

	/**
	 * 否决项目  改变结案方式
	 * @param projID
	 * @param busiType
	 * @return
	 */
	/*private Boolean chengeProjEndType(UrlParam urlParam){
			   financingService.updateOpProjStopReason(garauProjects);
			   garauProjects.setIsguaranted(false);
			   financingService.updateOpProjIsGuarantedInfo(garauProjects);//修改是否进入正式担保阶段isguaranted
		return financingService.updateOpProjEndInfo(garauProjects);
	}*/

	/**
	 * 获取项目的所有待办流程
	 * @param projectID 项目ID
	 * @return
	 */
	private List<OsHistorystep> returnProjPendingList(String projID){
		PendingWorkFlow pendingWorkFlow = new PendingWorkFlow();
		pendingWorkFlow.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pendingWorkFlow.setProjectID(projID);
		return osHistorystepMapper.returnProjPendingList(pendingWorkFlow);
	}

	/**
	 * 待办 转换 带历史记录 , 删除待办
	 * @param projID
	 * @return
	 */
	private Boolean pendingTOHistory(String projID){
		List<OsHistorystep> pendingList = returnProjPendingList(projID);
		//待办转 历史
		for (OsHistorystep osHistorystep : pendingList) {
			//2015-03-10修改为不将代办插入历史
			//osHistorystepMapper.insertOneHistoryStep(osHistorystep);
			//改变流程状态
			updateWfentryStatus("3",osHistorystep.getEntry_ID());
		}
		//删除待办
		for (OsHistorystep osHistorystep : pendingList) {
			//			System.out.println("ID :" + osHistorystep.getId() + "  流程ID : " + osHistorystep.getEntry_ID() + " 步骤ID :  " + osHistorystep.getStep_ID());
			osHistorystepMapper.deletePendingOfBeforeStep(osHistorystep);
			osHistorystepMapper.deletePending(osHistorystep);
		}
		return true;
	}

	/**
	 * 改变流程状态
	 * @return
	 */
	private Boolean updateWfentryStatus(String status , Long flowID){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", status);
			map.put("flowID", flowID);
			osHistorystepMapper.updateWfentryStatus(map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	/**
	 * 取得步骤上的业务构件
	 * @return
	 */
	public List<OsGworkflowComponents> getStepComponent(Long flowID, Integer stepID) {
		String userUid = String.valueOf(SystemSession.getUserSession().getUser_uid());
		// 取得某个步骤上的所有动作ID测试
		int[] actions = workflow.getOneCurStepAvailableActions(flowID,stepID,userUid, null);
		WorkflowDescriptor wd = workflow.getWorkflowDescriptor(workflow.getWorkflowName(flowID));
		// 取得步骤上的所有动作
		List<Os_action> actionList = new ArrayList<Os_action>();
		for (int i = 0; i < actions.length; i++) {
			Os_action osaction = new Os_action();
			osaction.setActionID(actions[i]);//设置动作id
			String name = wd.getAction(actions[i]).getName();// 根据动作ID,取得动作名称
			osaction.setActionName(name);
			String view = wd.getAction(actions[i]).getView();// 根据动作ID,取得动作名称
			osaction.setView(view);
			// 从业务构件中取得此动作ID，对应的action地址
			//osaction.setActionURL(getActionURL(osaction.getActionID()));
			osaction.setFlowid(flowID);
			actionList.add(osaction);
		}

		List<OsGworkflowComponents> viewList = new ArrayList<OsGworkflowComponents>();
		for(Os_action action : actionList){
			List<OsGworkflowComponents> componentList =  getStepAllView(action.getView());
			if(componentList != null && componentList.size() != 0){
				viewList.addAll(componentList);
			}
		}
		return viewListRemoveRepeat(viewList);
	}

	/**
	 * 业务构建去重
	 * @param viewList
	 * @return
	 */
	private List<OsGworkflowComponents> viewListRemoveRepeat(List<OsGworkflowComponents> viewList){
		List<String> viewIDList = new ArrayList<String>();
		for(OsGworkflowComponents components : viewList){
			viewIDList.add(components.getComponentID());
		}
		List<String> viewIDNotRepeatList = new ArrayList<String>();
		for(String viewID : viewIDList){
			if(!viewIDNotRepeatList.contains(viewID)){
				viewIDNotRepeatList.add(viewID);
			}
		}
		List<OsGworkflowComponents> componentList = new ArrayList<OsGworkflowComponents>();
		for(String viewID : viewIDNotRepeatList){
			componentList.add(getIndexList(viewList, viewID));
		}
		return componentList;
	}

	private OsGworkflowComponents getIndexList(List<OsGworkflowComponents> viewList,String viewID){
		OsGworkflowComponents components = null;
		for(OsGworkflowComponents component : viewList){
			if(component.getComponentID().equals(viewID)){
				components = component;
				break;
			}
		}
		return components;
	}



	/**
	 * 获取流程步骤信息
	 * @param pendingWorkFlow
	 * @return
	 */
	public PendingWorkFlow returnWorkFlowStepInfo(Long flowID,Integer stepID){
		PendingWorkFlow pendingWorkFlow = new PendingWorkFlow();
		pendingWorkFlow.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pendingWorkFlow.setFlowID(flowID);
		pendingWorkFlow.setStepID(stepID);
		List<PendingWorkFlow> list = pendingWorkFlowService.returnWorkFlowStepInfo(pendingWorkFlow);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 更新指定的待办人员
	 * @return
	 */
	public Boolean updateWaitUserInfo(PendingWorkFlow pendingWorkFlow) {
		if(osHistorystepMapper.updateWaitUserInfo(pendingWorkFlow)!=0){
			return true;
		}else{
			return false;
		}
	}
}

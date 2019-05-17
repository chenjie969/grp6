package com.zjm.gworkFlow.startWorkFlow.web;


import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.CheckResultInfo;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.gworkFlow.db.model.FlowRole;
import com.zjm.gworkFlow.db.model.OsGworkFlowProjIDFlowID;
import com.zjm.gworkFlow.db.model.OsGworkflowComponents;
import com.zjm.gworkFlow.db.model.OsGworkflowFlowtemplate;
import com.zjm.gworkFlow.db.model.OsHistorystep;
import com.zjm.gworkFlow.db.model.Os_action;
import com.zjm.gworkFlow.db.model.Os_projInfo;
import com.zjm.gworkFlow.db.model.Os_step;
import com.zjm.gworkFlow.db.model.PendingWorkFlow;
import com.zjm.gworkFlow.flowtemplate.service.FlowtemplateService;
import com.zjm.gworkFlow.startWorkFlow.service.GworkFlowService;
import com.zjm.gworkFlow.util.FlowTools;
import com.zjm.sys.db.model.Sys_roles;
import com.zjm.sys.syspara.service.SysparaService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/** 
 * @author 作者 E-mail: java_lishuai@163.com
 * @version 创建时间：2014-11-19 下午1:36:44 
 * 类说明： 
 */
@Controller
public class GworkFlowAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//流程模板
	@Resource(name="flowtemplateService")
	private FlowtemplateService flowtemplateService;
	//启动流程
	@Resource
	private GworkFlowService gworkFlowService;
	
	private OsGworkflowFlowtemplate osGworkflowFlowtemplate;
	private List<OsGworkflowFlowtemplate> osGworkflowFlowtemplateList;
	//
	private OsGworkFlowProjIDFlowID osGworkFlowProjIDFlowID;
	
	//
	private Os_projInfo os_projInfo;
	
	//zhongzk add
	private Os_step os_step;
	
	//ls add
	//private Long flowID;//流程id
	//private Integer stepID;//步骤id
	//private String stepName;//步骤名称
	//private Integer actionID;//动作id
	//private String projectID;//项目id
	//private String actionName;//步骤中文名称
	//private String view;//业务构件
	private List<Os_action> osactionList;
	//private String roleid;//角色id
	private Map<String,Map<String, String>> osRoleMap;//流程角色人员列表
	private String singleRoleName;//角色中文名称
	private String[] roleName;//角色中文名称
	private String[] rolrUserUid;
	private List<OsHistorystep> osHistorystepList;
	private Map<String, String> userMap;//用户列表
	private List<OsGworkflowComponents> componentList;
	
	
	private String autoUserName;//自动提交 name
	private String autoUserID;//自动提交的ID
	
	
	
	private String projectHeaderA;//项目A角
	private String aroleName;//A角 名称
	private String projectHeaderB; // 项目B角
	private String broleName;//B角 名称
	private String projectHeaderC; // 项目C角
	private String croleName;//C角 名称
	
	
	private PendingWorkFlow pendingWorkFlow;
	
	@Resource(name = "sysparaService")   //系统参数
	private SysparaService sysparaService; 
	@Resource(name = "sysDicDataService")   //系统字典
	private SysDicDataService sysDicDataService; 
	
	/**
	 * 加载此担保机构所有的流程模板
	 * @return
	 */
	@RequestMapping(value="/gworkFlow/returnAllFlowtemplate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes returnAllFlowtemplate(){
		if(osGworkflowFlowtemplate==null){
			osGworkflowFlowtemplate=new OsGworkflowFlowtemplate();
		}
		osGworkflowFlowtemplate.setUnit_uid(SystemSession.getUserSession().getUnit_uid());	
		try {
		osGworkflowFlowtemplateList = flowtemplateService.returnAllFlowtemplateList(osGworkflowFlowtemplate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageTable pageTable=new PageTable();
		pageTable.setRows(osGworkflowFlowtemplateList);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 启动流程      启动项目流程
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/gworkFlow/startWorkFlowInstance", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes startWorkFlowInstance(@RequestBody OsGworkflowFlowtemplate osGworkflowFlowtemplate){
		//zhongzk add
		osGworkflowFlowtemplate.setUser_uid(SystemSession.getUserSession().getUser_uid());
		osGworkflowFlowtemplate.setUnit_uid(SystemSession.getUserSession().getUnit_uid());	
		Long startResult = gworkFlowService.createworkflowInstance(osGworkflowFlowtemplate);
		
		AjaxRes ar=new AjaxRes();
		if(startResult <= 0){
			ar.setSucceed(false);
		}else{
			ar.setSucceed(true);
		}
		return ar;
	}
	
	/**
	 * 否决项目的界面
	 * @return
	 */
	public String returnStopProjectPage(){
		//stopTypeMap = sysDicDataService.sysDicTypeMap("08");
		return "SUCCESS";
	}
	
	/**
	 * 否决项目
	 * @return
	 */
	public String stopProject(){
		/**
		 * 否决项目
		 * @param projectID
		 * @param busiType
		 * @return
		 */
		//gworkFlowService.stopProject(garauProjects,busiType);
		
		
		return "SUCCESS";
	}
	

	//*********************************************************李帅代码段
	/**
	 * 办理 待办 流程
	 * @return
	 */
	@RequestMapping(value = "/gworkFlow/tranPendingWorkFlow")
	@ResponseBody
	public ModelAndView tranPendingWorkFlow(PendingWorkFlow pendingWorkFlow){
		pendingWorkFlow.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pendingWorkFlow = gworkFlowService.returnWorkFlowStepInfo(pendingWorkFlow.getFlowID(),pendingWorkFlow.getStepID());
		System.out.println("tranPendingWorkFlow");
		System.out.println(JSON.toJSONString(pendingWorkFlow));
		try {
			osactionList = gworkFlowService.getStepAllActions(pendingWorkFlow.getFlowID(), pendingWorkFlow.getStepID());
			System.out.println(JSON.toJSONString(osactionList));
			componentList = gworkFlowService.getStepComponent(pendingWorkFlow.getFlowID(), pendingWorkFlow.getStepID());
			System.out.println(JSON.toJSONString(componentList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gworkFlow/transactIndex");
		mv.getModel().put("pendingWorkFlow", pendingWorkFlow);//步骤信息
		mv.getModel().put("osactionList", osactionList);//当前步骤上的所有动作
		mv.getModel().put("componentList", componentList);//当前步骤上所有业务构件
		return mv;
	}
	
	/**
	 * 执行某一个流程实例的一个动作    nodynamicsplitrole 非动态分支
	 * @return
	 */
	@RequestMapping(value = "/gworkFlow/nodynamicDoAction")
	@ResponseBody
	public AjaxRes nodynamicDoAction(@RequestBody PendingWorkFlow pendingWorkFlow){
		Map<String,String> rolemap = new IdentityHashMap<String,String>();
		for (int i = 0 ; i < pendingWorkFlow.getRolrUserUids().length ; i++ ) {
			rolemap.put(pendingWorkFlow.getRoleNames()[i], pendingWorkFlow.getRolrUserUids()[i]);
		}
		
		Boolean b=false;
		try {
			gworkFlowService.doAction(pendingWorkFlow.getFlowID(), pendingWorkFlow.getActionID(), pendingWorkFlow.getProjectID(),rolemap);
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
			b=false;
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 执行某一个流程实例的一个动作    dynamicsplitrole: 动态分支角色
	 * @return
	 */
	public String dynamicDoAction(){
		Map<String,String> rolemap = new IdentityHashMap<String,String>();
		for (int i = 0 ; i < rolrUserUid.length ; i++ ) {
			rolemap.put(i+singleRoleName, rolrUserUid[i]);
		}
		gworkFlowService.doAction(pendingWorkFlow.getFlowID(), pendingWorkFlow.getActionID(), pendingWorkFlow.getProjectID(),rolemap);
		return "SUCCESS";
	}
	
	/**
	 * 执行某一个流程实例的一个动作    prestepowner 前面某个步骤的操作人
	 * @return
	 */
	@RequestMapping(value = "/gworkFlow/prestepownerDoAction")
	@ResponseBody
	public AjaxRes prestepownerDoAction(@RequestBody PendingWorkFlow pendingWorkFlow){
		Map<String,String> rolemap = new IdentityHashMap<String,String>();
		for (int i = 0 ; i < pendingWorkFlow.getRolrUserUids().length ; i++ ) {
			rolemap.put(pendingWorkFlow.getRoleNames()[i], pendingWorkFlow.getRolrUserUids()[i]);
		}
		Boolean b=false;
		try {
			//这里是系统自动提交的,rolemap本应该是null,但是需要进行对项目成员表进行处理,需要把人员信息传过去
			gworkFlowService.doAction(pendingWorkFlow.getFlowID(),pendingWorkFlow.getActionID(),pendingWorkFlow.getProjectID(),null);
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
			b=false;
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 执行分支步骤指定角色操作
	 * @return
	 */
	public String assignRoleaDoAction(){
		Map<String,String> roleMap = new HashMap<String, String>();
		if(projectHeaderA != null && aroleName != null){
			roleMap.put(aroleName,projectHeaderA);
		}
		if(projectHeaderB != null && broleName != null){
			roleMap.put(broleName,projectHeaderB);	
		}
		if(projectHeaderC != null && croleName != null){
			roleMap.put(croleName,projectHeaderC);
		}
		
		//更新项目信息中的角色信息
		//financingService.updateProjectHeaderInfoToFolw(pendingWorkFlow.getProjectID(),roleMap);
		//执行下一步动作
		gworkFlowService.doAction(pendingWorkFlow.getFlowID(), pendingWorkFlow.getActionID(), pendingWorkFlow.getProjectID(),roleMap);
		return "SUCCESS";
	}
	
	
	/**
	 * 返回doaction标识
	 * @return
	 */
	@RequestMapping(value = "/gworkFlow/returnDoActionFlag")
	@ResponseBody
	public ModelAndView returnDoActionFlag(PendingWorkFlow pendingWorkFlow){
		System.out.println("============>>>>");
		System.out.println(JSON.toJSONString(pendingWorkFlow));
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.getModel().put("flowID", pendingWorkFlow.getFlowID());
		mv.getModel().put("actionID", pendingWorkFlow.getActionID());
		mv.getModel().put("projectID", pendingWorkFlow.getProjectID());
		//return mv;
		
			
		
		// 非动态分支  nosplitrole  nodynamicsplitrole  动态分支  splitrole
		FlowRole flowRole = gworkFlowService.returnNextStepRoles(pendingWorkFlow.getFlowID(), pendingWorkFlow.getActionID(), pendingWorkFlow.getProjectID());
		System.out.println(JSON.toJSONString(flowRole));
		//角色类型
		String roleType = flowRole.getRoleType();
		//角色Map
		Map<Long, String> roleMap = flowRole.getRoleMap();
		osRoleMap = new HashMap<String, Map<String,String>>();
		mv.getModel().put("osRoleMap", osRoleMap);
		//
		if (roleType.equals("nodynamicsplitrole") 
				|| roleType.equals("dynamicsplitrole")
				|| roleType.equals("autodynamicsplitrole")
				|| roleType.equals("rolenousers")){
			Set<Entry<Long, String>> set = roleMap.entrySet();
			Iterator<Entry<Long, String>> iterator = set.iterator();
			while(iterator.hasNext()){
				Map.Entry<Long,String> entry = (Entry<Long, String>) iterator.next();
				Long key  = (Long)entry.getKey();
				String value = (String)entry.getValue();
				//获取用户列表
				Map<String,String> flRoleMap = getUserListByRoleName(pendingWorkFlow.getProjectID(),value);
				System.out.println("=====获取用户列表====");
				System.out.println(JSON.toJSONString(flRoleMap));
				if(flRoleMap.size() == 0){
					mv.setViewName("/gworkFlow/doTask/op_userNull");

		        	mv.getModel().put("doAction", "");
					//return "ERROR";
					return mv;
				}
				osRoleMap.put(value.replace("R",""), flRoleMap);
				mv.getModel().put("osRoleMap", osRoleMap);
			}
		}
		
			
		
		//非分支步骤
		/* 1.nodynamicsplitrole: 非动态分支角色
		   2. dynamicsplitrole: 动态分支角色  
		   3.autodynamicsplitrole 自动动态分支角色  
		   4.prestepowner 前面某个步骤的操作人
		   5.rolenoexit 角色不存在    
		   6.rolenousers 角色没有人
		*/
		if (roleType.equals("nodynamicsplitrole")){ //owner配的角色有多个用户，需要人工指定一个用户
			mv.setViewName("/gworkFlow/doTask/op_nosplitroleUserList");
			
        	mv.getModel().put("doAction", "nodynamicDoAction");
			return mv;
    	   //return "nodynamicsplitrole"; //转到选择人员页面
        }else if(roleType.equals("dynamicsplitrole")){//动态分支
        	mv.setViewName("/gworkFlow/doTask/op_splitroleUserList");

        	mv.getModel().put("doAction", "dynamicDoAction");
			return mv;
        	//return "dynamicsplitrole"; //转到选择人员页面
        }else if(roleType.equals("autodynamicsplitrole")){//自动动态分支角色  
        	mv.setViewName("/gworkFlow/doTask/op_autodynamicsplitrole");

        	mv.getModel().put("doAction", "dynamicDoAction");
			return mv;
        	//return "autodynamicsplitrole";
        }else if(roleType.equals("prestepowner")){//前面某个步骤的操作人
        	autoUserName = sysDicDataService.selectUsersDicNoEableMap("").get(roleMap.get(1L));
        	autoUserID = roleMap.get(1L);
        	System.out.println("autoUserName"+autoUserName);
        	System.out.println("autoUserID"+autoUserID);
        	mv.getModel().put("autoUserName", autoUserName);
        	mv.getModel().put("autoUserID", autoUserID);
        	mv.setViewName("/gworkFlow/doTask/op_prestepowner");
        	
        	mv.getModel().put("doAction", "prestepownerDoAction");
			return mv;
        	//return "prestepowner";
        }else if(roleType.equals("rolenoexit")){//角色不存在  
        	mv.setViewName("/gworkFlow/doTask/op_userNull");

        	mv.getModel().put("doAction", "");
			return mv;
        	//return "rolenoexit";
        }else if(roleType.equals("rolenousers")){//角色不存在  
        	mv.setViewName("/gworkFlow/doTask/op_userNull");

        	mv.getModel().put("doAction", "");
			return mv;
        	//return "rolenousers";
        }else if(roleType.equals("autosyschooseuser")){//角色不存在  
        	autoUserName = sysDicDataService.selectUsersDicNoEableMap("").get(roleMap.get("userid")); 
        	mv.getModel().put("autoUserName", autoUserName);
        	mv.setViewName("/gworkFlow/doTask/op_userNull");

        	mv.getModel().put("doAction", "");
			return mv;
        	//return "rolenousers";
        }else{  
        	mv.setViewName("/gworkFlow/doTask/op_userNull");

        	mv.getModel().put("doAction", "");
			return mv;
        	//return "ERROR";
        }
		
	}
	
	
	/**
	 * 更具角色名称取出成员列表
	 * @param roleName
	 * @return
	 */
	private Map<String,String> getUserListByRoleName(String projectID,String roleName){
		/*//从项目成员表获取角色名称信息
		Map<String,List<String>> membersMap = getMembersRoleMap(projectID);
		String isR = roleName.substring(0,1);
		if(membersMap == null || !isR.equals("R")){
			return getSysRoleMap(roleName);
		}else{
			String markRoleName = roleName.substring(1,roleName.length());
			//如果项目成员表存在此角色
			if(membersMap.containsKey(markRoleName)){
				Map<String,String> sysUserMap = sysDicDataService.selectUsersDicNoEableMap("");
				List<String> userList = membersMap.get(markRoleName);
				Map<Long,String> userMap = new LinkedHashMap<Long, String>();
				for(String userID : userList){
					Long userUid = null;
					if(isNumber(userID)){
						userUid = Long.valueOf(userID);
					}else{
						continue;
					}
					String userName = sysUserMap.get(userUid);
					userMap.put(userUid, userName);
				}
				return userMap;
			}else{
				return getSysRoleMap(markRoleName);
			}
		}*/
		//String markRoleName = roleName.substring(1,roleName.length());
		return getSysRoleMap(roleName);
	}
	
	/**
	 * 获取项目成员表 信息
	 * @param projectID
	 * @return
	 */
	/*private Map<String,List<String>> getMembersRoleMap(String projectID){
		//从项目成员表获取角色名称信息
		Opprojectmembers projectmembers = new Opprojectmembers();
		projectmembers.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		projectmembers.setProjectID(projectID);
		Opprojectmembers projectmembersNew = projectmembersService.returnOneProjectmembersInfo(projectmembers);
		if(projectmembersNew != null){
			String membersMapJson = projectmembersNew.getUserIDs();
			Map<String,List<String>> membersMap = new HashMap<String, List<String>>();
			if(membersMapJson == null && membersMapJson.equals("")){
				return null;
			}else{
				try {
					membersMap = JSON.parseObject(membersMapJson,membersMap.getClass());
					return membersMap;
				} catch (Exception e) {
					return null;
				}
			}
		}else{
			return null;
		}
		
	}*/
	
	/**
	 * 从系统中获取角色信息
	 * @param roleName
	 * @return
	 */
	private Map<String,String> getSysRoleMap(String roleName){
		Map<String,String> flRoleMap = sysDicDataService.selectRoleDicMap(" and role_name=\'"+roleName+"\'");
		String roleKey="";
		for(Entry<String, String> vo : flRoleMap.entrySet()){ 
			roleKey=vo.getKey(); 
        }
		flRoleMap=sysDicDataService.selectRoleUserDicMap(" and role_name=\'"+roleName+"\'",roleKey);
		return flRoleMap;
	}
	
	/**
	 * 判断字符串 是否是 数字
	 * @param number
	 * @return
	 */
	private Boolean isNumber(String number){
		Pattern pattern = Pattern.compile("[0-9]*"); 
		if(number != null && !number.equals("") && !number.equals("null")){
			Matcher isNum = pattern.matcher(number);
			if(!isNum.matches()){
			  return false; 
			}else{
				return true;
			}
		}else{
			return false;
		}
		
	}
	
	/**
	 * 取得项目的历史步骤
	 * @return
	 */
	public String getStepAllHistoryStep(){
		// 用户列表
		userMap = sysDicDataService.selectUsersDicNoEableMap("");
		osHistorystepList = gworkFlowService.getStepAllHistoryStep(pendingWorkFlow.getFlowID());
		return "SUCCESS";
	}
	
	
	
	/**
	 * 判断是否已有流程实例 并且尚未结束
	 * @return
	 */
	public String stateWorkFlowInstance(){
		//mashuo add 判断是否已有流程实例 并且尚未结束
		osGworkflowFlowtemplate.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		System.out.println(osGworkflowFlowtemplate.getProjectID());
		Boolean stateResult =flowtemplateService.stateWorkFlowInstance(osGworkflowFlowtemplate);
		//checkResultInfo = Tool.validataMsg("", stateResult);
		return "SUCCESS";
	}
	
	//**********************************************************
	
	
	/**
	 * 判断是否已有流程实例 
	 * @return
	 */
	public String stateWorkFlowStartInstance(){
		//mashuo add 判断是否已有流程实例 
		osGworkflowFlowtemplate.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		System.out.println(osGworkflowFlowtemplate.getProjectID());
		Boolean stateResult =flowtemplateService.stateWorkFlowStartInstance(osGworkflowFlowtemplate);
		//checkResultInfo = Tool.validataMsg("", stateResult);
		return "SUCCESS";
	}
	
	
	/**
	 * 取得步骤上的所有动作和配置的业务构件
	 * @return
	 */
	public String getStepAllComponentsAndActions(){
		osactionList = gworkFlowService.getStepAllActions(pendingWorkFlow.getFlowID(), pendingWorkFlow.getStepID());
		componentList = gworkFlowService.getStepComponent(pendingWorkFlow.getFlowID(), pendingWorkFlow.getStepID());
		return "SUCCESS";
	}
	/**
	 * 返回指定的待办人员
	 * @return
	 */
	public String returnWaitUserInfo(){
//		pendingWorkFlow=gworkFlowService.returnWaitUserInfo(pendingWorkFlow);
		return "SUCCESS";
	}
	/**
	 * 更新指定的待办人员
	 * @return
	 */
	public String updateWaitUserInfo(){
		Boolean b=gworkFlowService.updateWaitUserInfo(pendingWorkFlow);
		return "SUCCESS";
	}
	/**
	 * 删除一个项目的流程实例
	 * @return
	 */
	public String deleteOneProjectWorkFlow(){
		//删除流程实例
		Boolean b=gworkFlowService.delOneProjectFlow(pendingWorkFlow.getProjectID());
		return "SUCCESS";
	}

	
}


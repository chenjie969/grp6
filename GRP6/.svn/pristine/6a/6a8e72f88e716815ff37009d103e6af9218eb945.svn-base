package com.zjm.gbpm.processInstance.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.gbpm.db.model.Act_ProcessInstance;
import com.zjm.gbpm.db.model.Act_nextTask;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.processInstance.service.ProcessInstanceService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProcessInstanceAction {

	@Resource
	private ProcessInstanceService processInstanceService;
	@Resource
	private SysDicDataService sysDicDataService;


	/**
	 * 流程分类列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql="";
		wheresql=wheresql+" and f.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and f.entityName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if (null != pageTable.getWheresql()) {
			wheresql = wheresql + pageTable.getWheresql();
		}
		if ( null != pageTable.getQueryCondition()) {
			if ( null != pageTable.getQueryCondition().getEntityID()) {
				wheresql=wheresql+" and f.entityID = \'"+pageTable.getQueryCondition().getEntityID().trim()+"\'";
			}
			if ( null != pageTable.getQueryCondition().getEntityType()) {
				wheresql=wheresql+" and f.entityType = \'"+pageTable.getQueryCondition().getEntityType().trim()+"\'";
			}
			
		}
		return wheresql;
	}

	/**
	 * 流程实例 列表页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessInstancePage")
	@ResponseBody
	public ModelAndView selectProcessInstancePage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processInstance/processInstanceList");
		return mv;
	}
	/**
	 * 流程实例 活动中 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessInstanceExecutionPageTable")
	public AjaxRes selectProcessInstanceExecutionPageTable(@RequestBody PageTable pageTable){
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=processInstanceService.selectProcessInstanceExecutionPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 流程实例 已完成 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessInstanceHistoryPageTable")
	public AjaxRes selectProcessInstanceHistoryPageTable(@RequestBody PageTable pageTable){
		String whereSql=" and e.END_TIME_ IS NOT NULL ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessInstanceHistoryPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}




	/**
	 * 待签收 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTaskSignPageTable")
	public AjaxRes selectProcessTaskSignPageTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		String whereSql=" and a.ASSIGNEE_ IS NULL AND d.TYPE_ = 'candidate' AND (d.USER_ID_ = \'"+SystemSession.getUserSession().getUser_uid()+"\'  OR d.GROUP_ID_ IN ( "+
				"SELECT g.ID_ FROM ACT_ID_GROUP g, ACT_ID_MEMBERSHIP membership WHERE g.ID_ = membership.GROUP_ID_ AND membership.USER_ID_ = \'"+SystemSession.getUserSession().getUser_uid()+"\' ))";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessTaskSignPageTable(pageTable);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 待办 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTaskWaitTaskPageTable")
	public AjaxRes selectProcessTaskWaitTaskPageTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		String whereSql=" and a.ASSIGNEE_ =\'"+SystemSession.getUserSession().getUser_uid()+"\' ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessTaskSignPageTable(pageTable);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}


	/**
	 * 待办签收
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/createProcessTaskSign", method=RequestMethod.POST)
	public AjaxRes createProcessTaskSign(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.createProcessTaskSign(processInstance,SystemSession.getUserSession()));
		return ar;
	}
	/**
	 * 办理完成
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/createProcessTaskTaskFinish", method=RequestMethod.POST)
	public AjaxRes createProcessTaskTaskFinish(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.createProcessTaskTaskFinish(processInstance,SystemSession.getUserSession()));
		return ar;
	}
	/**
	 * 任务委托
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/createProcessTaskTaskEntrusted", method=RequestMethod.POST)
	public AjaxRes createProcessTaskTaskEntrusted(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.createProcessTaskTaskEntrusted(processInstance,SystemSession.getUserSession()));
		return ar;
	}

	/**
	 * 已办 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTaskHistoryTaskPageTable")
	public AjaxRes selectProcessTaskHistoryTaskPageTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		String whereSql=" and a.ASSIGNEE_ =\'"+SystemSession.getUserSession().getUser_uid()+"\' and a.END_TIME_ IS NOT NULL ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessTaskHistoryTaskPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}



	/**
	 * 委托他人任务 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTaskEntrustedPageTable")
	public AjaxRes selectProcessTaskEntrustedPageTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		String whereSql=" and a.OWNER_=\'"+SystemSession.getUserSession().getUser_uid()+"\' and a.ASSIGNEE_ IS NOT NULL  ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessTaskHistoryTaskPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 被委托任务 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTaskDelegatePageTable")
	public AjaxRes selectProcessTaskDelegatePageTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		String whereSql=" and a.OWNER_ IS NOT NULL and a.ASSIGNEE_ =\'"+SystemSession.getUserSession().getUser_uid()+"\'  ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessTaskHistoryTaskPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}



	/**
	 * 我发起的流程 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessInstanceExecutionMyStartTable")
	public AjaxRes selectProcessInstanceExecutionMyStartTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		String whereSql=" and e.START_USER_ID_=\'"+SystemSession.getUserSession().getUser_uid()+"\' and e.END_TIME_ IS NULL ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessInstanceExecutionPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 我发起的流程 已完成 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessInstanceHistoryMyStartPageTable")
	public AjaxRes selectProcessInstanceHistoryMyStartPageTable(@RequestBody PageTable pageTable){
		String whereSql=" and e.START_USER_ID_=\'"+SystemSession.getUserSession().getUser_uid()+"\' and e.END_TIME_ IS NOT NULL ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessInstanceHistoryPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 我参与的流程 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessInstanceExecutionMyInPageTable")
	public AjaxRes selectProcessInstanceExecutionMyInPageTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		String whereSql=" and (a.OWNER_ =\'"+SystemSession.getUserSession().getUser_uid()+"\' OR a.ASSIGNEE_ =\'"+SystemSession.getUserSession().getUser_uid()+"\' ) and e.END_TIME_ IS NULL ";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessInstanceExecutionPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 我参与的流程 已完成 分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessInstanceHistoryMyInPageTable")
	public AjaxRes selectProcessInstanceHistoryMyInPageTable(@RequestBody PageTable pageTable){
		String whereSql=" and (a.OWNER_ =\'"+SystemSession.getUserSession().getUser_uid()+"\' OR a.ASSIGNEE_ =\'"+SystemSession.getUserSession().getUser_uid()+"\' ) and e.END_TIME_ IS NOT NULL";
		pageTable.setWheresql(queryConditionSql(pageTable)+whereSql);
		pageTable=processInstanceService.selectProcessInstanceHistoryPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}


	/**
	 * 任务挂起/暂停
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/suspendProcessInstance", method=RequestMethod.POST)
	public AjaxRes suspendProcessInstance(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.suspendProcessInstance(processInstance,SystemSession.getUserSession()));
		return ar;
	}


	/**
	 * 任务激活
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/activateProcessInstance", method=RequestMethod.POST)
	public AjaxRes activateProcessInstance(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.activateProcessInstance(processInstance,SystemSession.getUserSession()));
		return ar;
	}

	/**
	 * 变更办理人
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/updateProcessTaskTaskAssignee", method=RequestMethod.POST)
	public AjaxRes updateProcessTaskTaskAssignee(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.updateProcessTaskTaskAssignee(processInstance,SystemSession.getUserSession()));
		return ar;
	}


	/**
	 * 提前中止流程实例 页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/stopProcessInstancePage")
	@ResponseBody
	public ModelAndView stopProcessInstancePage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processInstance/processInstanceStop");
		mv.getModel().put("stopMap", sysDicDataService.selectDicTypeDicNoEableMap("","f7fd34633c704e23a5934582f9c2ac81"));
		return mv;
	}
	/**
	 * 提前中止流程实例
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/stopProcessInstance", method=RequestMethod.POST)
	public AjaxRes stopProcessInstance(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.stopProcessInstance(processInstance,SystemSession.getUserSession()));
		return ar;
	}

	/**
	 * 删除流程实例
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/deleteProcessInstance", method=RequestMethod.POST)
	public AjaxRes deleteProcessInstance(@RequestBody Act_ProcessInstance processInstance){
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(processInstanceService.deleteProcessInstance(processInstance,SystemSession.getUserSession()));
		return ar;
	}





	/**
	 * 项目办理 页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTaskPageTablePage")
	@ResponseBody
	public ModelAndView selectProcessTaskPageTablePage(HttpServletRequest request,@RequestParam("instanceEntity_ID") String instanceEntity_ID,@RequestParam("taskID") String taskID,@RequestParam("entityID") String entityID,@RequestParam("entityType") String entityType,@RequestParam("entityName") String entityName,@RequestParam("procDefID") String procDefID,@RequestParam("processInstanceID") String processInstanceID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processTransact/transactIndex");
		mv.getModel().put("instanceEntity_ID", instanceEntity_ID);//流程与业务实体对应表主键
		mv.getModel().put("entityID", entityID);//业务实体id
		mv.getModel().put("entityType", entityType);//业务实体类型
		mv.getModel().put("entityName", entityName);//业务实体名称
		mv.getModel().put("procDefID", procDefID);//activiti流程定义id
		mv.getModel().put("processInstanceID", processInstanceID);//流程实例id
		mv.getModel().put("taskID", taskID);//任务id
		
		List<Gbpm_dicTaskManager> list=processInstanceService.selectOneTaskFormItemList(taskID,SystemSession.getUserSession());
		mv.getModel().put("taskFormList", list);//当前任务所需办理的任务事项
		
		/*ProcessInstance processInstance=new ProcessInstance();
		processInstance.setProcDefID(procDefID);
		processInstance.setProcessInstanceID(processInstanceID);
		String imagePath=processInstanceService.selectProcessDiagram(processInstance,SystemSession.getUserSession());
		mv.getModel().put("imagePath", imagePath);*/
		return mv;
	}




	/**
	 * 流程流转图
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessDiagram")
	public void selectProcessDiagram(@RequestParam("procDefID") String procDefID,@RequestParam("processInstanceID") String processInstanceID,HttpServletResponse response) throws IOException{
		 
		Act_ProcessInstance processInstance=new Act_ProcessInstance();
		processInstance.setProcDefID(procDefID);
		processInstance.setProcessInstanceID(processInstanceID);
		System.out.println(JSON.toJSONString(processInstance));
		InputStream imageStream=processInstanceService.selectProcessDiagram(processInstance,SystemSession.getUserSession());
		byte[] b = new byte[1024];
	    int len = -1;
	    while ((len = imageStream.read(b, 0, 1024)) != -1) {
	      response.getOutputStream().write(b, 0, len);
	    }
	}
	
	/**
	 * 流程跟踪图
	 * @return  封装了各种节点信息
	 * @throws Exception 
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTrace")
	public AjaxRes selectProcessTrace(@RequestParam("processInstanceID") String processInstanceID) throws Exception{
		List<Map<String, Object>> activityInfos=processInstanceService.selectProcessTrace(processInstanceID,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(activityInfos);
		return ar;
	}



	/**
	 * 流程办理任务列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectProcessTaskPageTable")
	public AjaxRes selectProcessTaskPageTable(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		//String whereSql=" and f.entityID =\'"+SystemSession.getUserSession().getUser_uid()+"\' and a.END_TIME_ IS NOT NULL ";
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=processInstanceService.selectProcessTaskHistoryTaskPageTable(pageTable,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 项目办理 页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectNextTaskPage")
	@ResponseBody
	public ModelAndView selectNextTaskPage(@RequestParam("taskID") String taskID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processTransact/transact");
		//List<Act_nextTask> list=processInstanceService.selectNextTaskList(taskID);
		//mv.getModel().put("nextTaskList", list);
		return mv;
	} 


	/**
	 * 根据当前办理任务的id获取下步任务信息集合分页列表
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectNextTaskPageTable")
	public AjaxRes selectNextTaskPageTable(@RequestBody PageTable pageTable){
		AjaxRes ar=new AjaxRes();
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		pageTable.setRows(processInstanceService.selectNextTaskList(pageTable.getQueryCondition().getTaskID()));
		ar.setSucceed(pageTable);
		return ar;
	}


	/**
	 * 项目办理 退回页面
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectHisTaskPage")
	@ResponseBody
	public ModelAndView selectHisTaskPage(@RequestParam("taskID") String taskID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/processTransact/transact");
		//List<Act_nextTask> list=processInstanceService.selectNextTaskList(taskID);
		//mv.getModel().put("nextTaskList", list);
		return mv;
	}
	
	
	/**
	 * 根据当前办理任务的id获取历史任务信息集合分页列表
	 * @return
	 */
	@RequestMapping(value = "/gbpm/processInstance/selectHisTaskPageTable")
	public AjaxRes selectHisTaskPageTable(@RequestBody PageTable pageTable){
		AjaxRes ar=new AjaxRes();
		if(pageTable==null){
			pageTable=new PageTable<>();
		}
		pageTable.setRows(processInstanceService.selectHisTaskList(pageTable.getQueryCondition().getTaskID()));
		ar.setSucceed(pageTable);
		return ar;
	}




}

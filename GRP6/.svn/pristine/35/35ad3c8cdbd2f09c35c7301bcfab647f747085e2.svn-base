package com.zjm.gbpm.taskType.web;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.db.model.Gbpm_taskType;
import com.zjm.gbpm.dicTaskManager.service.DicTaskManagerService;
import com.zjm.gbpm.taskType.service.TaskTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/gbpm/taskType")
public class TaskTypeAction{
	@Resource
	private TaskTypeService taskTypeService;
	@Resource
	private DicTaskManagerService dicTaskManagerService;
	
	/**
	 * 查询所有任务事项类型  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectAllTaskTypeListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllTaskTypeListTree(){
		AjaxRes ar=new AjaxRes();
		try {
			List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			List<Gbpm_taskType>  taskTypeList=taskTypeService.selectAllTaskTypeList(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
			for (Gbpm_taskType taskType : taskTypeList) {
				map = new HashMap<String, Object>();
				if(taskType != null && taskType.getpTaskType_ID() != null && taskType.getpTaskType_ID() == "ff467932922a4ccdad57b15d665cac6f"){
					map.put("open",true);
				}
				map.put("id", taskType.getTaskType_ID());
				map.put("pId", taskType.getpTaskType_ID());
				map.put("name", taskType.getTaskTypeName());
				mapList.add(map);
			}
			ar.setSucceed(mapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 查询所有任务事项类型与任务事项  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectAllTaskTypeTaskListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllTaskTypeTaskListTree(){
		AjaxRes ar=new AjaxRes();
		try {
			List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
			List<Gbpm_taskType>  taskTypeList=taskTypeService.selectAllTaskTypeList(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
			for (Gbpm_taskType taskType : taskTypeList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", taskType.getTaskType_ID());
				map.put("pId", taskType.getpTaskType_ID());
				map.put("name", taskType.getTaskTypeName());
				map.put("type", "depart");
				mapList.add(map);
				
				
				String wheresql = " and taskType.unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'" ;
				wheresql = wheresql + " and taskTypeTask.taskType_ID = \'" + taskType.getTaskType_ID() +"\'";
				List<Gbpm_dicTaskManager> taskManagerList = dicTaskManagerService.selectTaskManagerList(wheresql, SystemSession.getUserSession());
				for (Gbpm_dicTaskManager taskManager : taskManagerList) {
					map =new HashMap<String,Object>();
					map.put("id", taskManager.getTaskManager_ID());
					map.put("pId", taskManager.getTaskType_ID());
					map.put("name", taskManager.getTaskName());
					map.put("type", "user");
					mapList.add(map);
				}
				
				if(taskType != null && taskType.getpTaskType_ID() != null && taskType.getpTaskType_ID() == "ff467932922a4ccdad57b15d665cac6f"){
					map.put("open",true);
				}
				
			}
			
			ar.setSucceed(mapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 查询任务事项类型与前置任务事项  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectBeforeTaskTypeTaskListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectBeforeTaskTypeTaskListTree(){
		AjaxRes ar=new AjaxRes();
		try {
			List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
			List<Gbpm_taskType>  taskTypeList=taskTypeService.selectAllTaskTypeList(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
			for (Gbpm_taskType taskType : taskTypeList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", taskType.getTaskType_ID());
				map.put("pId", taskType.getpTaskType_ID());
				map.put("name", taskType.getTaskTypeName());
				map.put("type", "depart");
				mapList.add(map);
				
				String wheresql = " and isPersonTask = 1 and taskType.unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'" ;
				wheresql = wheresql + " and taskTypeTask.taskType_ID = \'" + taskType.getTaskType_ID() +"\'";
				List<Gbpm_dicTaskManager> taskManagerList = dicTaskManagerService.selectTaskManagerList(wheresql, SystemSession.getUserSession());
				for (Gbpm_dicTaskManager taskManager : taskManagerList) {
					map =new HashMap<String,Object>();
					map.put("id", taskManager.getTaskManager_ID());
					map.put("pId", taskManager.getTaskType_ID());
					map.put("name", taskManager.getTaskName());
					map.put("type", "user");
					mapList.add(map);
				}
				
				if(taskType != null && taskType.getpTaskType_ID() != null && taskType.getpTaskType_ID() == "ff467932922a4ccdad57b15d665cac6f"){
					map.put("open",true);
				}
				
			}
			
			ar.setSucceed(mapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 查询任务事项类型与后置任务事项  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectAfterTaskTypeTaskListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAfterTaskTypeTaskListTree(){
		AjaxRes ar=new AjaxRes();
		try {
			List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
			List<Gbpm_taskType>  taskTypeList=taskTypeService.selectAllTaskTypeList(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
			for (Gbpm_taskType taskType : taskTypeList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", taskType.getTaskType_ID());
				map.put("pId", taskType.getpTaskType_ID());
				map.put("name", taskType.getTaskTypeName());
				map.put("type", "depart");
				mapList.add(map);
				
				String wheresql = " and isPersonTask = 0 and taskType.unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'" ;
				wheresql = wheresql + " and taskTypeTask.taskType_ID = \'" + taskType.getTaskType_ID() +"\'";
				List<Gbpm_dicTaskManager> taskManagerList = dicTaskManagerService.selectTaskManagerList(wheresql, SystemSession.getUserSession());
				for (Gbpm_dicTaskManager taskManager : taskManagerList) {
					map =new HashMap<String,Object>();
					map.put("id", taskManager.getTaskManager_ID());
					map.put("pId", taskManager.getTaskType_ID());
					map.put("name", taskManager.getTaskName());
					map.put("type", "user");
					mapList.add(map);
				}
				
				if(taskType != null && taskType.getpTaskType_ID() != null && taskType.getpTaskType_ID() == "ff467932922a4ccdad57b15d665cac6f"){
					map.put("open",true);
				}
				
			}
			
			ar.setSucceed(mapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	
	/**
	 * 返回页面---添加节点任务事项类型
	 * @return
	 */
	@RequestMapping(value="/addTaskTypePage")
	@ResponseBody
	public ModelAndView addTaskTypePage(Gbpm_taskType gbpm_taskType){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/taskManager/taskTypeAdd");
		return mv;
	}
	
	/**
	 * 返回页面---修改节点任务事项类型
	 * @return
	 */
	@RequestMapping(value="/editTaskTypePage")
	@ResponseBody
	public ModelAndView editTaskTypePage(Gbpm_taskType gbpm_taskType){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/taskManager/taskTypeEdit");
		return mv;
	}
	
	/**
	 * 插入一个任务事项类型
	 * @return
	 */
	@RequestMapping(value="/insertOneTaskType", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneTaskType(@RequestBody Gbpm_taskType gbpm_taskType){
		AjaxRes ar=new AjaxRes();
		Boolean b = false;
		try {
			b = taskTypeService.insertOneTaskType(SystemSession.getUserSession(),gbpm_taskType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 修改一个任务事项类型
	 * @return
	 */
	@RequestMapping(value="/updateOneTaskType", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneTaskType(@RequestBody Gbpm_taskType gbpm_taskType){
		AjaxRes ar=new AjaxRes();
		Boolean b = false;
		try {
			b = taskTypeService.updateOneTaskType(SystemSession.getUserSession(),gbpm_taskType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 添加时判断任务事项类型名称是否重复
	 * @return
	 */
	@RequestMapping(value = "/selectTaskTypeNameIsExist")
	@ResponseBody
	public AjaxRes selectAddTaskTypeNameIsExist(@RequestBody Gbpm_taskType gbpm_taskType){
		AjaxRes ar=new AjaxRes();
		Boolean b = true;
		try {
			String wheresql="";
			if(gbpm_taskType!=null){
				if (gbpm_taskType.getTaskType_ID()!=null) {
					wheresql=wheresql+" and taskType_ID != \'"+gbpm_taskType.getTaskType_ID()+"\'";
				}
				if(gbpm_taskType.getTaskTypeName()!=null){
					wheresql=wheresql+" and taskTypeName = \'"+((String) gbpm_taskType.getTaskTypeName()).trim()+"\'";
				}
				// 同级部门不能重复
				if(gbpm_taskType.getpTaskType_ID()!=null){
					wheresql=wheresql+" and pTaskType_ID = \'"+((String) gbpm_taskType.getpTaskType_ID()).trim()+"\'";
				}
			}
			b = taskTypeService.selectTaskTypeIsExist(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 删除一个任务事项类型
	 * @return
	 */
	@RequestMapping(value="/deleteOneTaskTypeInfo")
	@ResponseBody
	public AjaxRes deleteOneTaskTypeInfo(@RequestBody Gbpm_taskType gbpm_taskType){
		
		AjaxRes ar=new AjaxRes();		
		Boolean b = false;
		try {
			b = taskTypeService.deleteOneTaskTypeInfo(SystemSession.getUserSession(),gbpm_taskType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 返回页面---修改节点任务事项类型顺序
	 * @return
	 */
	@RequestMapping(value="/sortNodeTaskPage")
	@ResponseBody
	public ModelAndView sortNodeTaskPage(Gbpm_taskType gbpm_taskType){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			String wheresql = " and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
			wheresql = wheresql + " and pTaskType_ID = \'" + gbpm_taskType.getpTaskType_ID() + "\'";
			List<Gbpm_taskType>  taskTypeList=taskTypeService.selectAllTaskTypeList(wheresql);
			mv.getModelMap().put("taskTypeList", taskTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/taskManager/taskTypeSort");
		return mv;
	}

}
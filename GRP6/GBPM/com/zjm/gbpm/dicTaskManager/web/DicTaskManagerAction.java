package com.zjm.gbpm.dicTaskManager.web;

import java.util.ArrayList;
import java.util.List;

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
import com.zjm.gbpm.dicTaskManager.service.DicTaskManagerService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value="/gbpm/dicTaskManager")
public class DicTaskManagerAction {

	@Resource
	private DicTaskManagerService dicTaskManagerService;
	@Resource
	private DicTypeService dicTypeService;
	/**
	 *  显示页面-分页查询任务事项管理列表
	 */
	@RequestMapping(value="/showTaskManagerPageTable")
	//@ResponseBody
	public ModelAndView showTaskManagerPageTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/taskManager/taskManagerIndex");
		return mv;
	}
	
	/**
	 * 分页查询任务事项管理列表
	 */
	@RequestMapping(value="/selectTaskManagerPageTable")
	@ResponseBody
	public AjaxRes selectTaskManagerPageTable(@RequestBody PageTable<Gbpm_dicTaskManager> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = dicTaskManagerService.selectTaskManagerPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 *  显示页面-新增一条任务事项管理
	 */
	@RequestMapping(value="/showTaskManagerAddPage")
	public ModelAndView showTaskManagerAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			List<C_dictype> taskTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='327397a3b5ec46df92113edb0326d5aa'");
			mv.getModelMap().put("taskTypeList", taskTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/taskManager/taskManagerAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条任务事项管理
	 */
	@RequestMapping(value="/insertOneTaskManager")
	@ResponseBody
	public AjaxRes insertOneTaskManager(@RequestBody Gbpm_dicTaskManager taskManager){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			b = dicTaskManagerService.insertOneTaskManager(SystemSession.getUserSession(), taskManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示页面-修改一条任务事项管理
	 */
	@RequestMapping(value="/showTaskManagerEditPage")
	public ModelAndView showTaskManagerEditPage(Gbpm_dicTaskManager taskManager){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			taskManager.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			taskManager = dicTaskManagerService.selectOneTaskManager(taskManager);
			mv.getModelMap().put("taskManager",taskManager);
			List<C_dictype> taskTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='327397a3b5ec46df92113edb0326d5aa'");
			mv.getModelMap().put("taskTypeList", taskTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/taskManager/taskManagerEdit");
		return mv;
	}
	
	/**
	 *  执行操作-修改一条任务事项管理
	 */
	@RequestMapping(value="/updateOneTaskManager")
	@ResponseBody
	public AjaxRes updateOneTaskManager(@RequestBody Gbpm_dicTaskManager taskManager){
		AjaxRes ar = new AjaxRes();
		try {
			taskManager.setTaskUrl(Tool.formatString(taskManager.getTaskUrl()));
			taskManager.setViewTaskUrl(Tool.formatString(taskManager.getViewTaskUrl()));
			taskManager.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			taskManager.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
			ar.setSucceed(dicTaskManagerService.updateOneTaskManager(SystemSession.getUserSession(), taskManager));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面-查看一条任务事项管理
	 */
	@RequestMapping(value="/showTaskManagerViewPage")
	public ModelAndView showTaskManagerViewPage(Gbpm_dicTaskManager taskManager){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		taskManager.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		taskManager = dicTaskManagerService.selectOneTaskManager(taskManager);
		mv.getModelMap().put("taskManager",taskManager);
		mv.setViewName("/gbpm/product/taskManager/taskManagerView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条任务事项管理
	 */
	@RequestMapping(value="/showTaskManagerDelPage")
	public ModelAndView showTaskManagerDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/taskManager/taskManagerDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条任务事项管理
	 */
	@RequestMapping(value="/deleteOneTaskManager")
	@ResponseBody
	public AjaxRes deleteOneTaskManager(@RequestBody Gbpm_dicTaskManager taskManager){
		AjaxRes ar = new AjaxRes();
		taskManager.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(dicTaskManagerService.deleteOneTaskManager(SystemSession.getUserSession(), taskManager));
		return ar;
	}
	
	/**
	 * 新增/修改时判断任务事项名称是否存在
	 */
	@RequestMapping(value="/isExistTaskName")
	@ResponseBody
	public AjaxRes isExistTaskName(@RequestBody Gbpm_dicTaskManager taskManager){
		AjaxRes ar = new AjaxRes();
		taskManager.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(dicTaskManagerService.isExistTaskName(taskManager));
		return ar;
	}
	
	/**
	 * 新增/修改时判断任务事项编号是否存在
	 */
	@RequestMapping(value="/isExistTaskCode")
	@ResponseBody
	public AjaxRes isExistTaskCode(@RequestBody Gbpm_dicTaskManager taskManager){
		AjaxRes ar = new AjaxRes();
		taskManager.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(dicTaskManagerService.isExistTaskCode(taskManager));
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Gbpm_dicTaskManager> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and taskManager.unit_uid = \'" +SystemSession.getUserSession().getUnit_uid() +"\'");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and taskName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		if ( null != pageTable.getQueryCondition().getTaskType_ID()) {
			wheresql.append(" and taskType.taskTypeFullCode like \'%"+pageTable.getQueryCondition().getTaskType_ID()+"%\'");
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql.append(" order by "+pageTable.getSortName().trim()+",taskManager.taskCode");
		}else{
			wheresql.append(" ORDER BY taskManager.taskmanagerSort,taskManager.taskCode DESC ");
		}
		return wheresql.toString();
	}
	
	
	/**
	 *  查询任务事项List   mashuo add 20170803
	 */
	@RequestMapping(value="/selectTaskManagerList")
	@ResponseBody
	public AjaxRes selectTaskManagerList(@RequestBody Gbpm_dicTaskManager dicTaskManager){
		AjaxRes ar = new AjaxRes();
		String wheresql = "";
//		if (dicTaskManager!=null && dicTaskManager.getTaskTypeID()!=null && !dicTaskManager.getTaskTypeID().equals("")) {
//			wheresql = " and taskTypeID = \'" + dicTaskManager.getTaskTypeID() + "\'";
//		}
		ar.setSucceed(dicTaskManagerService.selectTaskManagerList(wheresql,SystemSession.getUserSession()));
		return ar;
	}
	
	/**
	 * 返回页面  查询任务事项List  用于顺序调整
	 * @return
	 */
	@RequestMapping(value="/selectTaskManagerListPage", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView selectTaskManagerListPage(String taskType_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			String wheresql = ""; ;
			if (taskType_ID!=null && !taskType_ID.equals("")) {
				wheresql = wheresql + " and taskType.taskType_ID = \'" + taskType_ID +"\'"; 
			}
			List<Gbpm_dicTaskManager> dicTaskManagerList = new ArrayList<>();
			dicTaskManagerList = dicTaskManagerService.selectTaskManagerList(wheresql,SystemSession.getUserSession());
			mv.getModel().put("dicTaskManagerList", dicTaskManagerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/taskManager/taskManagerSort");
		return mv;
		
	}
}

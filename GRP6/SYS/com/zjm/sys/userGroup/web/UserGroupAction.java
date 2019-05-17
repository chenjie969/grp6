package com.zjm.sys.userGroup.web;

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
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_usergroup;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.sys.userGroup.service.UserGroupService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
/**
 * 项目组设置
 * @author mashuo  add 20170512
 *
 */
@Controller
@RequestMapping("/sys")
public class UserGroupAction {
	@Resource
	private UserGroupService userGroupService;
	@Resource
	private SysDicDataService sysDicDataService;
	
	
	
	
	/**
	 * 返回项目组分页列表页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectUserGroupPage")
	public ModelAndView selectUserGroupPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/userGroup/index");
		return mv;
	}
	/**
	 * 返回项目组分页列表数据
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectUserGroupPageTables")
	@ResponseBody
	public AjaxRes selectUserGroupPageTables(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<Sys_usergroup>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=userGroupService.selectUserGroupPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 项目组列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql="";
		wheresql=wheresql+" and e.unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and e.userGroupName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by e."+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY e.order_id ";
		}
		return wheresql;
	}
	
	
	/**
	 * 添加项目组信息页面
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectUserGroupAddPage")
	public ModelAndView selectUserGroupAddPage(Sys_usergroup usergroup){
		usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/userGroup/add");
		mv.getModel().put("usergroup", usergroup);
		return mv;
	}
	
	/**
	 * 插入一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/insertOneUserGroupInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneUserGroupInfo(@RequestBody Sys_usergroup sys_usergroup){
		sys_usergroup.setUserGroup_uuid(Tool.createUUID32());
		sys_usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		sys_usergroup.setUpdate_user(SystemSession.getUserSession().getUser_name());
		sys_usergroup.setCreate_user(SystemSession.getUserSession().getUser_name());
		Boolean b= userGroupService.insertOneUserGroupInfo(sys_usergroup);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 添加项目组时判断名称是否重复
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectAddUserGroupNameIsExist", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAddUserGroupNameIsExist(@RequestBody  Sys_usergroup sys_usergroup){
		String wheresql="";
		wheresql=wheresql+" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(sys_usergroup!=null){
			if(sys_usergroup.getUserGroupName()!=null){
				wheresql=wheresql+" and userGroupName = \'"+sys_usergroup.getUserGroupName().trim()+"\'";
			}
		}
		Boolean b=userGroupService.selectUserGroupNameIsExist(wheresql);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查看项目组信息页面
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectUserGroupViewPage")
	public ModelAndView selectUserGroupViewPage(Sys_usergroup usergroup){
		if(usergroup==null){
			usergroup=new Sys_usergroup();
		}
		usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		usergroup=userGroupService.selectOneUserGroupInfo(usergroup);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/userGroup/view");
		mv.getModel().put("usergroup", usergroup);
		return mv;
	}
	/**
	 * 修改项目组信息页面
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectUserGroupEditPage")
	public ModelAndView selectUserGroupEditPage(Sys_usergroup usergroup){
		if(usergroup==null){
			usergroup=new Sys_usergroup();
		}
		usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		usergroup=userGroupService.selectOneUserGroupInfo(usergroup);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/userGroup/edit");
		mv.getModel().put("usergroup", usergroup);
		return mv;
	}
	/**
	 * 修改项目组时判断名称是否重复
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectEditUserGroupNameIsExist", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEditUserGroupNameIsExist(@RequestBody  Sys_usergroup sys_usergroup){
		String wheresql="";
		wheresql=wheresql+" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(sys_usergroup!=null){
			if(sys_usergroup.getUserGroup_uuid()!=null){
				wheresql=wheresql+" and userGroup_uuid != \'"+sys_usergroup.getUserGroup_uuid().trim()+"\'";
			}
			if(sys_usergroup.getUserGroupName()!=null){
				wheresql=wheresql+" and userGroupName = \'"+sys_usergroup.getUserGroupName().trim()+"\'";
			}
		}
		Boolean b=userGroupService.selectUserGroupNameIsExist(wheresql);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 更新一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/updateOneUserGroupInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneUserGroupInfo(@RequestBody Sys_usergroup sys_usergroup){
		sys_usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		sys_usergroup.setUpdate_user(SystemSession.getUserSession().getUser_name());
		Boolean b= userGroupService.updateOneUserGroupInfo(sys_usergroup);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 删除项目组信息页面
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/selectUserGroupDelPage")
	public ModelAndView selectUserGroupDelPage(Sys_usergroup usergroup){
		if(usergroup==null){
			usergroup=new Sys_usergroup();
		}
		usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		usergroup=userGroupService.selectOneUserGroupInfo(usergroup);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/userGroup/del");
		mv.getModel().put("usergroup", usergroup);
		return mv;
	}
	
	/**
	 * 删除一个项目组信息
	 * @param sys_usergroup
	 * @return
	 */
	@RequestMapping(value="/delectOneUserGroupInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneUserGroupInfo(@RequestBody Sys_usergroup sys_usergroup){
		sys_usergroup.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= userGroupService.delectOneUserGroupInfo(sys_usergroup);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 查询所有项目组 用于排序
	 * @return
	 */
	@RequestMapping(value="/selectUserGroupListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectUserGroupListJSON(){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		List<Sys_usergroup>  List=userGroupService.selectUserGroupList(wheresql);
		for (Sys_usergroup info : List) {
			map = new HashMap<String, String>();
			map.put(info.getUserGroup_uuid(), info.getUserGroupName());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
}

package com.zjm.sys.roles.web;

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
import com.zjm.common.db.model.SysDicData;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.sys.db.model.Sys_role_data;
import com.zjm.sys.db.model.Sys_roles;
import com.zjm.sys.roles.service.RolesService;
import com.zjm.sys.rolesData.RolesDataService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
/**
 * 角色设置
 * @author mashuo  add 20170524
 *
 */
@Controller
public class RolesAction {
	@Resource
	private RolesService rolesService;
	@Resource
	private SysDicDataService sysDicDataService;
	@Resource 
	private RolesDataService rolesDataService;
	
	
	
	/**
	 * 返回角色分页列表页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesPage")
	public ModelAndView selectRolesPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/roles/index");
		return mv;
	}
	/**
	 * 返回角色分页列表数据
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesPageTables")
	@ResponseBody
	public AjaxRes selectRolesPageTables(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<Sys_roles>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=rolesService.selectRolesPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 角色列表查询条件
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
			wheresql=wheresql+" and e.role_name like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by e."+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY e.order_id ";
		}
		return wheresql;
	}
	
	
	/**
	 * 添加角色信息页面
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesAddPage")
	public ModelAndView selectRolesAddPage(Sys_roles roles){
		roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/roles/add");
		mv.getModel().put("roles", roles);
		return mv;
	}
	
	/**
	 * 插入一个角色信息
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/insertOneRolesInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneRolesInfo(@RequestBody Sys_roles sys_roles){
		sys_roles.setRole_uid(Tool.createUUID32());
		sys_roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		sys_roles.setUpdate_user(SystemSession.getUserSession().getUser_name());
		sys_roles.setCreate_user(SystemSession.getUserSession().getUser_name());
		Boolean b= rolesService.insertOneRolesInfo(sys_roles);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 添加角色时判断名称是否重复
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectAddRolesNameIsExist", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAddRolesNameIsExist(@RequestBody  Sys_roles sys_roles){
		String wheresql="";
		wheresql=wheresql+" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(sys_roles!=null){
			if(sys_roles.getRole_name()!=null){
				wheresql=wheresql+" and role_name = \'"+sys_roles.getRole_name().trim()+"\'";
			}
		}
		Boolean b=rolesService.selectRolesNameIsExist(wheresql);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查看角色信息页面
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesViewPage")
	public ModelAndView selectRolesViewPage(Sys_roles roles){
		if(roles==null){
			roles=new Sys_roles();
		}
		roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		roles=rolesService.selectOneRolesInfo(roles);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/roles/view");
		mv.getModel().put("roles", roles);
		return mv;
	}
	/**
	 * 修改角色信息页面
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesEditPage")
	public ModelAndView selectRolesEditPage(Sys_roles roles){
		if(roles==null){
			roles=new Sys_roles();
		}
		roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		roles=rolesService.selectOneRolesInfo(roles);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/roles/edit");
		mv.getModel().put("roles", roles);
		return mv;
	}
	/**
	 * 修改角色时判断名称是否重复
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectEditRolesNameIsExist", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEditRolesNameIsExist(@RequestBody  Sys_roles sys_roles){
		String wheresql="";
		wheresql=wheresql+" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(sys_roles!=null){
			if(sys_roles.getRole_uid()!=null){
				wheresql=wheresql+" and role_uid != \'"+sys_roles.getRole_uid().trim()+"\'";
			}
			if(sys_roles.getRole_name()!=null){
				wheresql=wheresql+" and role_name = \'"+sys_roles.getRole_name().trim()+"\'";
			}
		}
		Boolean b=rolesService.selectRolesNameIsExist(wheresql);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 更新一个角色信息
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/updateOneRolesInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneRolesInfo(@RequestBody Sys_roles sys_roles){
		sys_roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		sys_roles.setUpdate_user(SystemSession.getUserSession().getUser_name());
		Boolean b= rolesService.updateOneRolesInfo(sys_roles);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 删除角色信息页面
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesDelPage")
	public ModelAndView selectRolesDelPage(Sys_roles roles){
		if(roles==null){
			roles=new Sys_roles();
		}
		roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		roles=rolesService.selectOneRolesInfo(roles);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/roles/del");
		mv.getModel().put("roles", roles);
		return mv;
	}
	
	/**
	 * 删除一个角色信息
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/delectOneRolesInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneRolesInfo(@RequestBody Sys_roles sys_roles){
		sys_roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= rolesService.delectOneRolesInfo(sys_roles);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 查询所有角色 用于排序
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectRolesListJSON(){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		List<Sys_roles>  List=rolesService.selectRolesList(wheresql);
		for (Sys_roles info : List) {
			map = new HashMap<String, String>();
			map.put(info.getRole_uid(), info.getRole_name());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	
	/**
	 * 返回角色授权页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/sys/roles/selectRolesAccreditPage")
	public ModelAndView selectRolesAccreditPage(Sys_roles roles){
		if(roles==null){
			roles=new Sys_roles();
		}
		roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		roles=rolesService.selectOneRolesInfo(roles);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/sys/roles/accredit");
		mv.getModel().put("roles", roles);
		//查询所有功能权限分类集合
		List<SysDicData> funTypeList=sysDicDataService.selectFunctionsTypeDicList("");
		mv.getModel().put("funTypeList", funTypeList);
		//查询所有功能权限集合
		List<SysDicData> functionsList=sysDicDataService.selectFunctionsDicList("");
		mv.getModel().put("functionsList", functionsList);
		//查询所有授权数据
		List<Sys_role_data> sys_role_datas = rolesDataService.selectByRoleId(roles.getRole_uid());
		for (int i = 0; i < sys_role_datas.size(); i++) {
			Sys_role_data data = sys_role_datas.get(i);
			if(1 == data.getOperation_type()){
				mv.getModel().put("clientTypeData", data);
				continue;
			}
			mv.getModel().put("proTypeData", data);
		}
		return mv;
	}
	
	
	
	
	/**
	 * 对一个角色授权
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/updateOneRolesAccreditInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneRolesAccreditInfo(@RequestBody Sys_roles sys_roles){
		sys_roles.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= rolesService.updateOneRolesAccreditInfo(sys_roles);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 对一个角色授权
	 * @param sys_roles
	 * @return
	 */
	@RequestMapping(value="/sys/roles/testSql")
	public void testSql(){
		rolesService.testSql();
	}
}

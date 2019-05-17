package com.zjm.sys.users.web;

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

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.map.Sys_post_userMapper;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.SystemSession;

/**
 * 用户设置
 * @author duanhuawei add 20170427
 */
@Controller
public class UsersAction {
	@Resource
	private UsersService usersService;
	@Resource
	private DepartsService  departsService;
	@Resource 
	private Sys_post_userMapper  sys_post_userMapper;


	/**
	 * 查询所有用户
	 * @return
	 */
	@RequestMapping(value="/selectUsersListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectUsersListJSON(@RequestBody Sys_users sys_users){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		if(sys_users!=null){
			if(sys_users.getDepart_uid()!=null){
				wheresql=wheresql+" and du.depart_uid = \'"+ sys_users.getDepart_uid()+"\'";
			}
		}
		List<Sys_users>  usersList=usersService.selectAllUsersList(wheresql);
		for (Sys_users sys_user : usersList) {
			map = new HashMap<String, String>();
			map.put(sys_user.getUser_uid(), sys_user.getUser_name());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 * 插入一个用户信息
	 * @return
	 */
	@RequestMapping(value="/insertOneUsersInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneUsersInfo(@RequestBody Sys_users sys_users){
		AjaxRes ar=new AjaxRes();
		sys_users.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b=usersService.insertOneUsersInfo(SystemSession.getUserSession(),sys_users);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询一个用户信息
	 * @param sys_users
	 * @return
	 */
	@RequestMapping(value="/selectOneUsersInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneUsersInfo(@RequestBody Sys_users sys_users){
		AjaxRes ar=new AjaxRes();
		sys_users.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Sys_users  users=usersService.selectOneUsersInfo(sys_users);
		ar.setSucceed(users);
		return ar;
	}
	/**
	 * 更新一个用户信息
	 * @param sys_users
	 * @return
	 */
	@RequestMapping(value="/updateOneUsersInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneUsersInfo(@RequestBody Sys_users sys_users){
		AjaxRes ar=new AjaxRes();
		sys_users.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		User user = SystemSession.getUserSession();
		sys_users.setUpdate_user(user.getUser_id());
		Boolean b=usersService.updateOneUsersInfo(user,sys_users);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 删除一个用户信息
	 * @param sys_users
	 * @return
	 */
	@RequestMapping(value="/deleteOneUsersInfo")
	@ResponseBody
	public AjaxRes deleteOneUsersInfo(@RequestBody Sys_users sys_users){
		AjaxRes ar=new AjaxRes();
		sys_users.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b=usersService.deleteOneUsersInfo(SystemSession.getUserSession(),sys_users);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询用户分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectUsersPageTables")
	@ResponseBody
	public AjaxRes selectUsersPageTables(@RequestBody PageTable pageTable) {
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=usersService.selectUsersPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 用户分页列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and u.user_name like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			if(pageTable.getQueryCondition().getDepart_uid()!=null 
					&& !pageTable.getQueryCondition().getDepart_uid().equals("") 
					&& !pageTable.getQueryCondition().getDepart_uid().equals("a129b9eea27a48be896697a39aa0aee7")){
				wheresql=wheresql+" and d.depart_fullcode like \'%"+pageTable.getQueryCondition().getDepart_uid().trim()+"%\'";
			}
		}
		if(pageTable.getSortName()!=null 
				&& !pageTable.getSortName().equals("") 
				&& pageTable.getSortOrder()!=null 
				&& !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY u.order_id ";
		}
		return wheresql;
	}
	/**
	 * 添加时判断登录账号是否重复
	 * @param sys_users
	 * @return
	 */
	@RequestMapping(value = "/selectAddUsersIdIsExist")
	@ResponseBody
	public AjaxRes selectAddUsersIdIsExist(@RequestBody Sys_users sys_users){
		String wheresql="";
		if(sys_users!=null){
			if(sys_users.getUser_id()!=null){
				wheresql=wheresql+" and user_id = \'"+((String) sys_users.getUser_id()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=usersService.selectUsersIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 修改时判断用户id是否重复
	 * @param sys_users
	 * @return
	 */
	@RequestMapping(value = "/selectEditUsersIdIsExist")
	@ResponseBody
	public AjaxRes selectEditUsersIdIsExist(@RequestBody Sys_users sys_users){
		String wheresql="";
		if(sys_users!=null){
			if(sys_users.getUser_id()!=null){
				wheresql=wheresql+" and user_uid != \'"+ sys_users.getUser_uid()+"\'";
			}
			if(sys_users.getUser_id()!=null){
				wheresql=wheresql+" and user_id = \'"+((String) sys_users.getUser_id()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=usersService.selectUsersIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	  
	/**
	 * 获取机构-用户树;
	 * @return
	 */
	/*@RequestMapping(value = "/selectDepartsUserTree")
	@ResponseBody
	public AjaxRes selectDepartsUserTree(String post_ID){
		String unit_uid = SystemSession.getUserSession().getUnit_uid();//获取担保机构id				
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();

    	//Map<String,Object> map =new HashMap<String,Object>();
		map.put("id", "1");
		map.put("pId", "-1");
		map.put("name", "机构");
		map.put("open",true);
		mapList.add(map);		
		//获取此机构下的部门;
		List<Sys_departs> departsList = departsService.selectAllDepartsList(" and unit_uid = \'"+unit_uid+"\'");	    
	    for (int i = 0; i < departsList.size(); i++) {
	    	Map<String,Object> map =new HashMap<String,Object>();
	    	Sys_departs thisDeparts = departsList.get(i);
	    	thisDeparts.setUnit_uid(unit_uid);//获取机构
			map =new HashMap<String,Object>();			
			map.put("id", thisDeparts.getDepart_uid());
			map.put("pId", thisDeparts.getPdepart_id());
			map.put("name", thisDeparts.getDepart_name());
			map.put("type", "depart");
			map.put("nocheck",true);
			mapList.add(map);
			List<Sys_departs> departOfUser = departsService.returnDepartOfUser(thisDeparts);
			for (Sys_departs departsUser : departOfUser) {
				map =new HashMap<String,Object>();				
				map.put("id", departsUser.getUser_uid());
				map.put("pId", thisDeparts.getDepart_uid());
				map.put("name", departsUser.getUser_name());
				map.put("type", "user");
				map.put("nocheck",true);
				Long  count =sys_post_userMapper.getPostUserCountByIds(post_ID,departsUser.getUser_uid(),unit_uid);
				  if(count >0){
					  map.put("checked", true);
					  map.put("open", true);//节点展开
				  }
				
				mapList.add(map);
			}
		}
	    AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}*/
	
	/**
	 * 查询用户分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectPostUsersPageTables")
	@ResponseBody
	public AjaxRes selectPostUsersPageTables(@RequestBody PageTable pageTable) {
		//pageTable.setWheresql(queryConditionSql(pageTable));
		String unit_uid = SystemSession.getUserSession().getUnit_uid();//获取担保机构id			
		String wheresql="";
		if(pageTable.getQueryCondition().getPost_ID() != null){			
			wheresql =wheresql + " AND post_user.post_ID = \'"+pageTable.getQueryCondition().getPost_ID()+"\'";
		}
		if(unit_uid != null){
			wheresql =wheresql + " AND post_user.unit_uid = \'"+unit_uid+"\'";
		}
		pageTable.setWheresql(wheresql);
		pageTable=usersService.selectPostUsersPageTables(pageTable);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
}

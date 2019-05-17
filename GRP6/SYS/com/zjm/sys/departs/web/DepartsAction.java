package com.zjm.sys.departs.web;

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

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
 * 部门设置
 * @author duanhuawei add 20170426
 */
@Controller
public class DepartsAction {
	@Resource
	private DepartsService departsService;
	@Resource
	private UsersService usersService;

	/**
	 * 查询所有部门
	 * @return
	 */
	@RequestMapping(value="/selectAllDepartsList", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllDepartsList(){
		List<Sys_departs>  departsList=departsService.selectAllDepartsList(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(departsList);
		return ar;
	}
	/**
	 * 查询所有部门
	 * @return
	 */
	@RequestMapping(value="/selectDepartsListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectDepartsListJSON(@RequestBody Sys_departs sys_departs){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String, String>();
		String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(sys_departs!=null){
			if(sys_departs.getPdepart_id()!=null){
				wheresql=wheresql+" and pdepart_id = \'"+ sys_departs.getPdepart_id()+"\'";
			}
		}
		List<Sys_departs>  departsList=departsService.selectAllDepartsList(wheresql);
		for (Sys_departs sys_depart : departsList) {
			map = new HashMap<String, String>();
			map.put(sys_depart.getDepart_uid(), sys_depart.getDepart_name());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 查询所有部门  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectAllDepartsListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllDepartsListTree(){
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Sys_departs>  departsList=departsService.selectAllDepartsList(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
/*		map.put("id", "1");
		map.put("pId", "-1");
		map.put("name", "市场部");
		mapList.add(map);
*/		for (Sys_departs sys_departs : departsList) {
			map = new HashMap<String, Object>();
			if(sys_departs != null && sys_departs.getPdepart_id() != null && sys_departs.getPdepart_id() == "-1"){
				map.put("open",true);
			}
			map.put("id", sys_departs.getDepart_uid());
			map.put("pId", sys_departs.getPdepart_id());
			map.put("name", sys_departs.getDepart_name());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 插入一个部门信息
	 * @return
	 */
	@RequestMapping(value="/insertOneDepartsInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneDepartsInfo(@RequestBody Sys_departs sys_departs){
		AjaxRes ar=new AjaxRes();
		sys_departs.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b=departsService.insertOneDepartsInfo(SystemSession.getUserSession(),sys_departs);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询一个部门信息
	 * @param sys_departs
	 * @return
	 */
	@RequestMapping(value="/selectOneDepartsInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneDepartsInfo(@RequestBody Sys_departs sys_departs){
		AjaxRes ar=new AjaxRes();
		Sys_departs  departs=departsService.selectOneDepartsInfo(sys_departs);
		ar.setSucceed(departs);
		return ar;
	}
	/**
	 * 更新一个部门信息
	 * @param sys_departs
	 * @return
	 */
	@RequestMapping(value="/updateOneDepartsInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneDepartsInfo(@RequestBody Sys_departs sys_departs){
		System.out.println(JSON.toJSONString(sys_departs));
		AjaxRes ar=new AjaxRes();
		User user = SystemSession.getUserSession();
		sys_departs.setUpdate_user(user.getUser_id());
		Boolean b=departsService.updateOneDepartsInfo(user,sys_departs);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 删除一个部门信息
	 * @param sys_departs
	 * @return
	 */
	@RequestMapping(value="/deleteOneDepartsInfo")
	@ResponseBody
	public AjaxRes deleteOneDepartsInfo(@RequestBody Sys_departs sys_departs){
		
		AjaxRes ar=new AjaxRes();		
		Boolean b=departsService.deleteOneDepartsInfo(SystemSession.getUserSession(),sys_departs);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 添加时判断部门名称是否重复
	 * @param sys_departs
	 * @return
	 */
	@RequestMapping(value = "/selectAddDepartsNameIsExist")
	@ResponseBody
	public AjaxRes selectAddDepartsNameIsExist(@RequestBody Sys_departs sys_departs){
		String wheresql="";
		if(sys_departs!=null){
			if(sys_departs.getDepart_name()!=null){
				wheresql=wheresql+" and depart_name = \'"+((String) sys_departs.getDepart_name()).trim()+"\'";
			}
			// 同级部门不能重复
			if(sys_departs.getPdepart_id()!=null){
				wheresql=wheresql+" and pdepart_id = \'"+((String) sys_departs.getPdepart_id()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=departsService.selectDepartsIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 修改时判断部门名称是否重复
	 * @param sys_departs
	 * @return
	 */
	@RequestMapping(value = "/selectEditDepartsNameIsExist")
	@ResponseBody
	public AjaxRes selectEditDepartsNameIsExist(@RequestBody Sys_departs sys_departs){
		String wheresql="";
		if(sys_departs!=null){
			if(sys_departs.getDepart_uid()!=null){
				wheresql=wheresql+" and depart_uid != \'"+ sys_departs.getDepart_uid()+"\'";
			}
			if(sys_departs.getDepart_name()!=null){
				wheresql=wheresql+" and depart_name = \'"+((String) sys_departs.getDepart_name()).trim()+"\'";
			}
			// 同级部门不能重复
			if(sys_departs.getPdepart_id()!=null){
				wheresql=wheresql+" and pdepart_id = \'"+((String) sys_departs.getPdepart_id()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=departsService.selectDepartsIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 
	 * @description		设置部门下的岗位信息
	 * @author wuhn
	 * @date 2017年6月7日 下午7:40:16
	 */
	@RequestMapping(value = "/updateSetDepartPostInfo")
	@ResponseBody
	public AjaxRes updateSetDepartPostInfo(@RequestBody Sys_departs sys_departs){
		
		AjaxRes ar=new AjaxRes();
		Boolean b=departsService.updateSetDepartPostInfo(SystemSession.getUserSession(), sys_departs);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 返回设置部门负责人页面
	 * @return
	 */
	@RequestMapping(value="/setDepartLeaderPage")
	public ModelAndView setDepartLeaderPage(String depart_uid){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Sys_departs departs = new Sys_departs();
		departs.setDepart_uid(depart_uid);
		departs = departsService.selectOneDepartsInfo(departs);
		mv.getModelMap().put("departs", departs);
		if(depart_uid!=null 
				&& !depart_uid.equals("") 
				&& !depart_uid.equals("a129b9eea27a48be896697a39aa0aee7")){
			String wheresql=" and d.depart_fullcode like \'%"+depart_uid.trim()+"%\'";
			List<Sys_users> usersList = usersService.selectUsersListByDepartUid(wheresql);
			mv.getModelMap().put("usersList", usersList);
		}else{
			String wheresql=" and d.depart_fullcode like \'%"+"a129b9eea27a48be896697a39aa0aee7"+"%\'";
			List<Sys_users> usersList = usersService.selectUsersListByDepartUid(wheresql);
			mv.getModelMap().put("usersList", usersList);
		}
		mv.setViewName("/sys/departs/setDepartLeader");
		return mv;
	}

	/**
	 * 
	 * @description		设置部门下负责人
	 */
	@RequestMapping(value = "/setDepartLeader")
	@ResponseBody
	public AjaxRes setDepartLeader(@RequestBody Sys_departs sys_departs){
		AjaxRes ar=new AjaxRes();
		Sys_departs departs = departsService.selectOneDepartsInfo(sys_departs);
		departs.setLeve1_user_id(sys_departs.getLeve1_user_id());
		departs.setLeve1_user_name(sys_departs.getLeve1_user_name());
		Boolean b=departsService.updateOneDepartsInfo(SystemSession.getUserSession(), departs);
		ar.setSucceed(b);
		return ar;
	}
	
}

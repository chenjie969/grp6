package com.zjm.oa.employee.web;

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
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.gbpm.db.model.Act_re_actSort;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.staffCase.service.StaffCaseService;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
@Controller
@RequestMapping("/oa/employee")
public class EmployeeAction {
	@Resource
	private DepartsService departsService;
	@Resource
	private SysDicDataService  sysDicDataService;
	@Resource
	private UsersService usersService;
	@Resource
	private StaffCaseService staffCaseService ;
	/**
	 * 查询员工分类 用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectEmployeeListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEmployeeListTree(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Sys_departs>  departsList=departsService.selectAllDepartsList("");
		for (Sys_departs sys_departs : departsList) {
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
	 * 删除员工信息页面

	 */
	@RequestMapping(value="/selectEmployeeDelPage")
	public ModelAndView selectActSortDelPage(Act_re_actSort actSort){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/personfileEmployeedel");	
		return mv;
	}

	/**
	 * 删除一个员工信息
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/delectOneEmployeeInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneActSortInfo(@RequestBody Act_re_actSort actSort){
		AjaxRes ar=new AjaxRes();
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		return ar;
	}

	
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  fasdfdsafq(String name){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/basicInfo/index");
		return modeAndView;
	}

	
	
}

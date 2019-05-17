package com.zjm.pro.meetingJury.web;


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
import com.zjm.pro.db.model.Pro_meetingJury;
import com.zjm.pro.meetingJury.service.MeetingJuryService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/pro/meetingJury")
public class MeetingJuryAction {

	@Resource
	private MeetingJuryService meetingJuryService;
	
	
	/**
	 * 评委设置列表页面
	 */
	@RequestMapping(value="/showMeetingJuryPageTables")
	public ModelAndView showMeetingJuryPageTables(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingJury/meetingJury");
		return mv;
	}
	
	/**
	 * 查询评委分页列表
	 */
	@RequestMapping(value="/selectMeetingJuryPageTables")
	@ResponseBody
	public AjaxRes selectMeetingJuryPageTables(@RequestBody PageTable<Pro_meetingJury> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = meetingJuryService.selectMeetingJuryPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_meetingJury> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and userName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();
	}
	
	/**
	 * 评委添加页面
	 */
	@RequestMapping(value="/showJuryAddPage")
	public ModelAndView showJuryAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/meeting/meetingJury/meetingJuryAdd");
		return mv;
	}
	
	/**
	 * 评委修改页面
	 */
	@RequestMapping(value="/showJuryEditPage")
	public ModelAndView showJuryEditPage(Pro_meetingJury meetingJury){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		meetingJury = meetingJuryService.selectOneMeetingJury(meetingJury);
		mv.getModelMap().put("meetingJury", meetingJury);
		mv.setViewName("/project/meeting/meetingJury/meetingJuryEdit");
		return mv;
	}
	
	/**
	 * 添加评委
	 */
	@RequestMapping(value="/addMeetingJury")
	@ResponseBody
	public AjaxRes addMeetingJury(@RequestBody Pro_meetingJury meetingJury){
		AjaxRes ar = new AjaxRes();
		Boolean b = meetingJuryService.addMeetingJuries(SystemSession.getUserSession(), meetingJury);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 修改评委
	 */
	@RequestMapping(value="/editMeetingJury")
	@ResponseBody
	public AjaxRes editMeetingJury(@RequestBody Pro_meetingJury meetingJury){
		AjaxRes ar = new AjaxRes();
		Boolean b = meetingJuryService.editMeetingJury(SystemSession.getUserSession(), meetingJury);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 删除评委
	 */
	@RequestMapping(value="/delMeetingJury")
	@ResponseBody
	public AjaxRes delMeetingJury(@RequestBody Pro_meetingJury meetingJury){
		AjaxRes ar = new AjaxRes();
		Boolean b = meetingJuryService.delMeetingJury(SystemSession.getUserSession(), meetingJury);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 显示可用评委树
	 */
	@RequestMapping(value="/selectEnableJuryTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEnableJuryTree(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		List<Pro_meetingJury> meetingJuryList = meetingJuryService.selectMeetingJuryListByWheresql(" and unit_uid='"+SystemSession.getUserSession().getUnit_uid()+"' and juryStatus = '01'");
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("id", 1);
		map.put("name", "可用评委");
		map.put("open",true);
		mapList.add(map);
		for (int i = 0; i < meetingJuryList.size(); i++) {
			Pro_meetingJury meetingJury = meetingJuryList.get(i);
			meetingJury.setUnit_uid(SystemSession.getUserSession().getUnit_uid());//获取机构
			map =new HashMap<String,Object>();
//			map.put("id", meetingJury.getMeetingJury_ID());
			map.put("id", meetingJury.getUserUid());	//不使用评委库ID, 直接使用评委自身的用户ID
			map.put("pId", 1);
			map.put("name", meetingJury.getUserName());
			map.put("type", "user");
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
}

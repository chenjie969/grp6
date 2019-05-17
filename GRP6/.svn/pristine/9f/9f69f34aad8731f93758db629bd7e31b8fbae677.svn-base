package com.zjm.gbpm.actSort.web;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.actSort.service.ActSortService;
import com.zjm.gbpm.db.model.Act_re_actSort;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
/**
 * 流程分类设置
 * @author mashuo  add 20170512
 *
 */
@RestController
@RequestMapping("/gbpm/actSort")
public class ActSortAction {
	@Resource
	private ActSortService actSortService;
	
	
	
	
	/**
	 * 返回流程分类分页列表页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectActSortPage")
	public ModelAndView selectActSortPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/actSort/index");
		return mv;
	}
	/**
	 * 返回流程分类分页列表数据
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectActSortPageTables")
	@ResponseBody
	public AjaxRes selectActSortPageTables(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<Act_re_actSort>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=actSortService.selectActSortPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 流程分类列表查询条件
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
			wheresql=wheresql+" and e.actSortName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if( null != pageTable.getQueryCondition().getPactSortID()){
			wheresql=wheresql+" and e.pactSortID = \'"+pageTable.getQueryCondition().getPactSortID().trim()+"\'";
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by e."+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY e.order_id ";
		}
		return wheresql;
	}
	
	
	/**
	 * 添加流程分类信息页面
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/selectActSortAddPage")
	public ModelAndView selectActSortAddPage(Act_re_actSort actSort){
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/actSort/add");
		mv.getModel().put("actSort", actSort);
		return mv;
	}
	
	/**
	 * 插入一个流程分类信息
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/insertOneActSortInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneActSortInfo(@RequestBody Act_re_actSort actSort){
		AjaxRes ar=new AjaxRes();
		try {
			
		
		actSort.setActSortID(Tool.createUUID32());
		actSort.setActSortFullCode(actSort.getActSortFullCode()+actSort.getActSortID()+"/");
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		actSort.setUpdate_user(SystemSession.getUserSession().getUser_name());
		actSort.setCreate_user(SystemSession.getUserSession().getUser_name());
		Boolean b= actSortService.insertOneActSortInfo(actSort);
		
		ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 添加流程分类时判断名称是否重复
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/selectAddActSortNameIsExist", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAddActSortNameIsExist(@RequestBody  Act_re_actSort actSort){
		String wheresql="";
		wheresql=wheresql+" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(actSort!=null){
			if(actSort.getActSortName()!=null){
				wheresql=wheresql+" and actSortName = \'"+actSort.getActSortName().trim()+"\'";
			}
			
		}
		Boolean b=actSortService.selectActSortNameIsExist(wheresql);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查看流程分类信息页面
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/selectActSortViewPage")
	public ModelAndView selectActSortViewPage(Act_re_actSort actSort){
		if(actSort==null){
			actSort=new Act_re_actSort();
		}
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		actSort=actSortService.selectOneActSortInfo(actSort);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/actSort/view");
		mv.getModel().put("actSort", actSort);
		return mv;
	}
	/**
	 * 修改流程分类信息页面
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/selectActSortEditPage")
	public ModelAndView selectActSortEditPage(Act_re_actSort actSort){
		if(actSort==null){
			actSort=new Act_re_actSort();
		}
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		actSort=actSortService.selectOneActSortInfo(actSort);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/actSort/edit");
		mv.getModel().put("actSort", actSort);
		return mv;
	}
	/**
	 * 修改流程分类时判断名称是否重复
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/selectEditActSortNameIsExist", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEditActSortNameIsExist(@RequestBody  Act_re_actSort actSort){
		String wheresql="";
		wheresql=wheresql+" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ";
		if(actSort!=null){
			if(actSort.getActSortID()!=null){
				wheresql=wheresql+" and actSortID != \'"+actSort.getActSortID().trim()+"\'";
			}
			if(actSort.getActSortName()!=null){
				wheresql=wheresql+" and actSortName = \'"+actSort.getActSortName().trim()+"\'";
			}
		}
		Boolean b=actSortService.selectActSortNameIsExist(wheresql);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 更新一个流程分类信息
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/updateOneActSortInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneActSortInfo(@RequestBody Act_re_actSort actSort){
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		actSort.setUpdate_user(SystemSession.getUserSession().getUser_name());
		Boolean b= actSortService.updateOneActSortInfo(actSort);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 删除流程分类信息页面
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/selectActSortDelPage")
	public ModelAndView selectActSortDelPage(Act_re_actSort actSort){
		if(actSort==null){
			actSort=new Act_re_actSort();
		}
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		actSort=actSortService.selectOneActSortInfo(actSort);
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/actSort/del");
		mv.getModel().put("actSort", actSort);
		return mv;
	}
	
	/**
	 * 删除一个流程分类信息
	 * @param actSort
	 * @return
	 */
	@RequestMapping(value="/delectOneActSortInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneActSortInfo(@RequestBody Act_re_actSort actSort){
		AjaxRes ar=new AjaxRes();
		actSort.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= actSortService.delectOneActSortInfo(actSort,SystemSession.getUserSession());
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 查询所有流程分类 用于排序
	 * @return
	 */
	@RequestMapping(value="/selectActSortListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectActSortListJSON(@RequestBody Act_re_actSort actSort){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		if(actSort!=null){
			if(actSort.getPactSortID()!=null && !actSort.getPactSortID().equals("")){
				wheresql=wheresql+" and pactSortID = \'"+ actSort.getPactSortID()+"\'";
			}
		}
		List<Act_re_actSort>  list=actSortService.selectActSortList(wheresql);
		for (Act_re_actSort info : list) {
			map = new HashMap<String, String>();
			map.put(info.getActSortID(), info.getActSortName());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	
	
	
	/**
	 * 查询所有流程分类 用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectActSortListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectActSortListTree(){
		AjaxRes ar=new AjaxRes();
		String wheresql="";
		List<Act_re_actSort>  list=actSortService.selectActSortList(wheresql);
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (Act_re_actSort info : list) {
			map = new HashMap<String, Object>();
			map.put("id", info.getActSortID());
			map.put("pId", info.getPactSortID());
			map.put("name", info.getActSortName());
			map.put("fullCode", info.getActSortFullCode());
			map.put("open", info.getIsOpen());
			mapList.add(map);
		}
		ar.setSucceed(mapList);
		return ar;
	}
}

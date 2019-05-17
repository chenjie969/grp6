package com.zjm.oa.jobStatus.web;

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
import com.zjm.oa.db.model.Hr_staffDuty;
import com.zjm.oa.staffDuty.service.StaffDutyService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.Tool;

@Controller
@RequestMapping("/oa/staffDuty")
public class staffDutyAction {
	@Resource
	private StaffDutyService  staffDutyService;
	
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  loadpage(String staffcase_Id,String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("staffcase_Id", staffcase_Id);
		modeAndView.getModel().put("type",type);
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/jobStatus/index");
		return modeAndView;
	}	
	/**
 		查询信息 列表 
	 */

	@RequestMapping(value="/selectDutyListPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectDutyListPageTables(@RequestBody PageTable<Hr_staffDuty> pageTable){		
		String queryCondition = queryCondition(pageTable);		
		List<Hr_staffDuty> list=new ArrayList<Hr_staffDuty>();
		try {
		 list = staffDutyService.selectDutyListByCase_ID(queryCondition);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageTable.setRows(list);
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(pageTable);
		return ar;
	}			
	private String queryCondition(PageTable<Hr_staffDuty> pageTable) {
		String wheresql="";
		if(null == pageTable){
			return "";
		}
		String staffcase_Id = pageTable.getQueryCondition().getStaffcase_Id();
		if(staffcase_Id != null && !"".equals(staffcase_Id)){
			wheresql=staffcase_Id;
		}
		return wheresql;
	}	
	//查看
	@RequestMapping(value="/selectDutyViewPage")
	public ModelAndView selectDutyViewPage(String dutyID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try{
			Hr_staffDuty hrstaffDuty=staffDutyService.selectOneByDutyId(dutyID);				
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/jobStatus/viewmodal");
			mv.getModel().put("hrstaffDuty", hrstaffDuty);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;		
	}
	
	/**
	 * 添加信息页面	
	 */
	@RequestMapping(value="/selectDutyAddPage")
	public ModelAndView selectDutyAddPage(Hr_staffDuty hrstaffDuty){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/jobStatus/addModal");
		mv.getModel().put("hrstaffDuty", hrstaffDuty);
		return mv;
	}
	
	/**
	 * 插入一个
	 */
	@RequestMapping(value="/insertOneDutyInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneDutyInfo(@RequestBody Hr_staffDuty hrstaffDuty){
		AjaxRes ar=new AjaxRes();
			try{
				hrstaffDuty.setDutyID(Tool.createUUID32());
				Boolean b= staffDutyService.insertOneDutyInfo(hrstaffDuty);	
				ar.setSucceed(b);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
		
		return ar;
	}	
		
		/**
		 * 修改信息页面

		 */
		@RequestMapping(value="/selectDutyEditPage")
		public ModelAndView selectDutyEditPage(Hr_staffDuty hrstaffDuty){
			ModelAndView mv=CustomDispatchServlet.getModeAndView();
			try{
			if(hrstaffDuty==null){
				hrstaffDuty=new Hr_staffDuty();
			}
			hrstaffDuty=staffDutyService.selectOneByDutyId(hrstaffDuty.getDutyID());			
		}catch(Exception e){
			e.printStackTrace();
		}
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/jobStatus/upModal");	
			mv.getModel().put("hrstaffDuty", hrstaffDuty);
			return mv;	
		}
		/**
		 * 更新		
		 */
		@RequestMapping(value="/updateOneDutyInfo", method=RequestMethod.POST)
		@ResponseBody
		public AjaxRes updateOneDutyInfo(@RequestBody Hr_staffDuty hrstaffDuty){	
			Boolean result=true;
			Hr_staffDuty isExist=staffDutyService.selectOneByDutyId(hrstaffDuty.getDutyID());
			if(isExist != null){
				result=staffDutyService.updateOneDutyInfo(hrstaffDuty);
			}
			AjaxRes ar = new AjaxRes();
			if(result){
				ar.setSucceed("1");
			}else{
				ar.setSucceed("0");
			}
			return ar;
		}
	
	
}

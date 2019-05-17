package com.zjm.oa.resume.web;

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
import com.zjm.oa.db.model.Hr_staffJob;

import com.zjm.oa.staffJob.service.StaffJobService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.Tool;

@Controller
@RequestMapping("/oa/job")
public class ResumeAction {
	@Resource
	private StaffJobService  staffJobService;
	
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  loadpage(String staffcase_Id,String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("staffcase_Id", staffcase_Id);
		modeAndView.getModel().put("type", type);
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/resume/index");
		return modeAndView;
	}	
	/**
 		查询信息 列表 
	 */

	@RequestMapping(value="/selectResumeListPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectResumeListPageTables(@RequestBody PageTable<Hr_staffJob> pageTable){
		String queryCondition = queryCondition(pageTable);
		List<Hr_staffJob> list = staffJobService.selectJobListByCase_ID(queryCondition);	
		pageTable.setRows(list);
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(pageTable);
		return ar;
	}			
	private String queryCondition(PageTable<Hr_staffJob> pageTable) {
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
	@RequestMapping(value="/selectJobViewPage")
	public ModelAndView selectJobViewPage(String jobID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try{
			Hr_staffJob hrstaffJob=staffJobService.selectOneByJobId(jobID);			
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/resume/viewModal");
			mv.getModel().put("hrstaffJob", hrstaffJob);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;		
	}
	
	/**
	 * 添加信息页面	
	 */
	@RequestMapping(value="/selectJobAddPage")
	public ModelAndView selectTransferAddPage(Hr_staffJob hrstaffJob){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/resume/addModal");
		mv.getModel().put("hrstaffJob", hrstaffJob);
		return mv;
	}
	
	/**
	 * 插入一个
	 */
	@RequestMapping(value="/insertOneJobInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneJobInfo(@RequestBody Hr_staffJob hrstaffJob){
		hrstaffJob.setJobID(Tool.createUUID32());
		Boolean b= staffJobService.insertOneJobInfo(hrstaffJob);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
		
		/**
		 * 修改信息页面

		 */
		@RequestMapping(value="/selectJobEditPage")
		public ModelAndView selectJobEditPage(Hr_staffJob hrstaffJob){
			ModelAndView mv=CustomDispatchServlet.getModeAndView();
			try{
			if(hrstaffJob==null){
				hrstaffJob=new Hr_staffJob();
			}
			hrstaffJob=staffJobService.selectOneByJobId(hrstaffJob.getJobID());			
		}catch(Exception e){
			e.printStackTrace();
		}
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/resume/upModal");	
			mv.getModel().put("hrstaffJob", hrstaffJob);
			return mv;	
		}
		/**
		 * 更新		
		 */
		@RequestMapping(value="/updateOnePostInfo", method=RequestMethod.POST)
		@ResponseBody
		public AjaxRes updateOnePostInfo(@RequestBody Hr_staffJob hrstaffJob){	
			Boolean result=true;			
			Hr_staffJob isExist=staffJobService.selectOneByJobId(hrstaffJob.getJobID());
			
			if(isExist != null){
				result=staffJobService.updateOneJobInfo(hrstaffJob);
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

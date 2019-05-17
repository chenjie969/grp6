package com.zjm.oa.staffPosts.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.itextpdf.text.log.SysoCounter;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.db.model.Hr_staffPosts;
import com.zjm.oa.staffPosts.service.StaffPostsService;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_roles;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping("/oa/staffPosts")
public class staffPostsAction {
	@Resource
	private StaffPostsService  staffPostsService;

	
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  loadpage(String staffcase_Id,String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("staffcase_Id", staffcase_Id);
		modeAndView.getModel().put("type",type);
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/transfer/index");
		return modeAndView;
	}	
	/**
 		查询信息 列表 
	 */

	@RequestMapping(value="/selectPostListPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectPostListPageTables(@RequestBody PageTable<Hr_staffPosts> pageTable){
		String queryCondition = queryCondition(pageTable);
		List<Hr_staffPosts> list = staffPostsService.selectTransferListByCase_ID(queryCondition);		
		pageTable.setRows(list);
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(pageTable);
		return ar;
	}			
	private String queryCondition(PageTable<Hr_staffPosts> pageTable) {
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
	@RequestMapping(value="/selectPostViewPage")
	public ModelAndView selectPostViewPage(String postsID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try{
			Hr_staffPosts hrstaffPosts=staffPostsService.selectOneByPostId(postsID);			
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/transfer/viewModal");
			mv.getModel().put("hrstaffPosts", hrstaffPosts);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;		
	}
	
	/**
	 * 添加信息页面	
	 */
	@RequestMapping(value="/selectPostsAddPage")
	public ModelAndView selectPostsAddPage(Hr_staffPosts hrstaffPosts){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/transfer/addModal");
		mv.getModel().put("hrstaffPosts", hrstaffPosts);
		return mv;
	}
	
	/**
	 * 插入一个
	 */
	@RequestMapping(value="/insertOnePostsInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOnePostsInfo(@RequestBody Hr_staffPosts hrstaffPosts){
		hrstaffPosts.setStaffcase_Id(hrstaffPosts.getStaffcase_Id());
		AjaxRes ar=new AjaxRes();
		hrstaffPosts.setPostsID(Tool.createUUID32());
		try{
		Boolean b= staffPostsService.insertOnePostsInfo(hrstaffPosts);	
		ar.setSucceed(b);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return ar;
	}	
		
		/**
		 * 修改信息页面

		 */
		@RequestMapping(value="/selectPostEditPage")
		public ModelAndView selecttransferEditPage(Hr_staffPosts hrstaffPosts){	
			ModelAndView mv=CustomDispatchServlet.getModeAndView();
			try{
			if(hrstaffPosts==null){
				hrstaffPosts=new Hr_staffPosts();
			}
			hrstaffPosts=staffPostsService.selectOneByPostId(hrstaffPosts.getPostsID());			
		}catch(Exception e){
			e.printStackTrace();
		}
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/transfer/upModal");	
			mv.getModel().put("hrstaffPosts", hrstaffPosts);
			return mv;	
		}
		/**
		 * 更新		
		 */
		@RequestMapping(value="/updateOnePostInfo", method=RequestMethod.POST)
		@ResponseBody
		public AjaxRes updateOnePostInfo(@RequestBody Hr_staffPosts hrstaffPosts){
		
			Boolean result=true;
			Hr_staffPosts isExist=staffPostsService.selectOneByPostId(hrstaffPosts.getPostsID());
			if(isExist != null){
				result=staffPostsService.updateOnePostsInfo(hrstaffPosts);
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

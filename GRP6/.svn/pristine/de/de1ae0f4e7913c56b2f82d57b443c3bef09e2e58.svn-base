package com.zjm.oa.socialRelation.web;
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
import com.zjm.oa.db.model.Hr_staffSocialRelations;
import com.zjm.oa.staffSocialRelation.service.StaffSocialRelationService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.Tool;

@Controller
@RequestMapping("/oa/socialRelation")
public class SocialRelationAction {
	@Resource
	private StaffSocialRelationService staffSocialRelationService;
	
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  loadpage(String staffcase_Id,String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("staffcase_Id", staffcase_Id);
		modeAndView.getModel().put("type", type);
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/socialRelation/index");
		return modeAndView;
	}	
	/**
 		查询信息 列表 
	 */

	@RequestMapping(value="/selectRelationListPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectRelationListPageTables(@RequestBody PageTable<Hr_staffSocialRelations> pageTable){
		String queryCondition = queryCondition(pageTable);
		List<Hr_staffSocialRelations> list = staffSocialRelationService.selectrelationListByCase_ID(queryCondition);
		pageTable.setRows(list);
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(pageTable);
		return ar;
	}			
	private String queryCondition(PageTable<Hr_staffSocialRelations> pageTable) {
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
	@RequestMapping(value="/selectRelationViewPage")
	public ModelAndView selectRelationViewPage(String socialID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try{
			Hr_staffSocialRelations hrstaffRelation=staffSocialRelationService.selectBySocialId(socialID);			
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialRelation/viewModal");
			mv.getModel().put("hrstaffRelation", hrstaffRelation);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;		
	}
	
	/**
	 * 添加信息页面	
	 */
	@RequestMapping(value="/selectRelationAddPage")
	public ModelAndView selectRelationAddPage(Hr_staffSocialRelations hrstaffRelation){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialRelation/addModal");
		mv.getModel().put("hrstaffRelation", hrstaffRelation);
		return mv;
	}
	
	/**
	 * 插入一个
	 */
	@RequestMapping(value="/insertOneRelationInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneRelationInfo(@RequestBody Hr_staffSocialRelations hrstaffRelation){
			
		hrstaffRelation.setSocialID(Tool.createUUID32());
		Boolean b= staffSocialRelationService.insertSocialrelation(hrstaffRelation);	
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
		
		/**
		 * 修改信息页面

		 */
		@RequestMapping(value="/selectRelationEditPage")
		public ModelAndView selectRelationEditPage(Hr_staffSocialRelations hrstaffRelation){
			ModelAndView mv=CustomDispatchServlet.getModeAndView();
			try{
			if(hrstaffRelation==null){
				hrstaffRelation=new Hr_staffSocialRelations();
			}
			hrstaffRelation=staffSocialRelationService.selectBySocialId(hrstaffRelation.getSocialID());			
		}catch(Exception e){
			e.printStackTrace();
		}
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialRelation/upModal");	
			mv.getModel().put("hrstaffRelation", hrstaffRelation);
			return mv;	
		}
		/**
		 * 更新		
		 */
		@RequestMapping(value="/updateOneRelationInfo", method=RequestMethod.POST)
		@ResponseBody
		public AjaxRes updateOneRelationInfo(@RequestBody Hr_staffSocialRelations hrstaffRelation){	
			Boolean result=true;
			Hr_staffSocialRelations isExist=staffSocialRelationService.selectBySocialId(hrstaffRelation.getSocialID());
			if(isExist != null){
				result=staffSocialRelationService.updateSocial(hrstaffRelation);
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

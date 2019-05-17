package com.zjm.oa.socialInsurance.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_socialInsurance;
import com.zjm.oa.socialInsurance.service.SocialInsuranceService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping("/oa/socialInsurance")
public class SocialInsuranceAction {
     @Resource   
	private SocialInsuranceService socialInsuranceService;
     
   //加载页面表格
   		@RequestMapping(value="/loadPage")
   		public ModelAndView  loadpage(String staffcase_Id,String type){
   			ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
   			modeAndView.getModel().put("staffcase_Id", staffcase_Id);
   			modeAndView.getModel().put("type",type);
   			modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/socialInsurance/index");
   			return modeAndView;
   		}
     
      /**
       * 插入一条保险记录
       * @return
       */
 	@RequestMapping(value="/showSocialInsuranceAdd")
 	public ModelAndView showSocialInsuranceAdd(){
 		ModelAndView mv=CustomDispatchServlet.getModeAndView();
 		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialInsurance/socialInsuranceAdd");
 		return mv;
 	}
 	
 	@RequestMapping(value="/insertOneSocialInsurance")
 	@ResponseBody
 	public AjaxRes insertOneSocialInsurance(@RequestBody Hr_socialInsurance socialInsurance){
 		AjaxRes ar = new AjaxRes();
 		try{
 			ar.setSucceed(socialInsuranceService.insertOneSocialInsurance(SystemSession.getUserSession(), socialInsurance));
 		}catch (Exception e) {
 			e.printStackTrace();
 		}
 		return ar;
 	}
 	
 	/**
 	 * 更改社会保险
 	 * @return
 	 */
 	
 	@ResourceMapping(value="/showSocialInsuranceUpdate")
 	public ModelAndView showSocialInsuranceUpdate(){
 		ModelAndView mv= CustomDispatchServlet.getModeAndView();
 		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialInsurance/socialInsuranceUpdate");
 		return mv;
 		
 }
 		
    @RequestMapping(value="/updateOneSocialInsurance")	
    @ResponseBody
 	public AjaxRes updateOneSocialInsurance(@RequestBody Hr_socialInsurance socialInsurance){
    	    AjaxRes ar = new AjaxRes();
    	    ar.setSucceed(socialInsuranceService.updateOneSocialInsurance(SystemSession.getUserSession(), socialInsurance));
    	    return ar;
	
 	}
 	
 	/**
 	 * 查询社会保险表
 	 * @param pageTable
 	 * @return
 	 */
    
    @RequestMapping(value="/selectSocialInsuranceTable")
	@ResponseBody
	public AjaxRes selectSocialInsuranceTable(@RequestBody PageTable<Hr_socialInsurance> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable =socialInsuranceService.selectSocialInsuranceTable(pageTable);
			ar.setSucceed(pageTable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
    
	
	@RequestMapping(value="/selectOneSocialInsurance")
	public ModelAndView selectOneSocialInsurance(String socialInsuranceID,String operationType){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try{
			Hr_socialInsurance socialInsurance = socialInsuranceService.selectOneSocialInsurance(socialInsuranceID);
			mv.getModelMap().put("socialInsurance",socialInsurance);
			if ("update".equals(operationType)) {
				mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialInsurance/socialInsuranceUpdate");
			} else {
				mv.setViewName("/oa/personfile/employeeInfo/basicInfo/socialInsurance/socialInsuranceView");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}





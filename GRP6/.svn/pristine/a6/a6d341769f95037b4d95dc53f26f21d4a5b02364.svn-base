package com.zjm.pro.meetingSummary.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.UrlParam;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_meetingSummary;
import com.zjm.pro.meetingSummary.service.MeetingSummaryService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value = "/project/meetingSummary")
public class MeetingSummaryAction {
	@Resource
	private MeetingSummaryService meetingSummaryService;
	@Resource
	private ProjectApplyService projectApplyService;
	
	
	
	/* *//**
     * 查看总办会纪要页面
     * @param 
     * @return
     */
	@RequestMapping(value="/showMeetSummaryPage")
	public ModelAndView showMeetSummaryPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String apply_ID = urlParam.getEntityID();
		Pro_apply  apply= new Pro_apply();
		apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+apply_ID+"\'");
		Pro_meetingSummary meetingSummary = meetingSummaryService.selectOneMeetSummary(" and apply_ID = \'"+apply_ID+"\'");
		if (meetingSummary == null) {
			Pro_meetingSummary newMeetingSummary = new Pro_meetingSummary();
			newMeetingSummary.setApply_ID(apply_ID);
			meetingSummaryService.insertOneMeetSummary(SystemSession.getUserSession(), newMeetingSummary);
			mv.getModelMap().put("meetingSummary",newMeetingSummary);
		}else {
			mv.getModelMap().put("meetingSummary",meetingSummary);
		}
		mv.getModelMap().put("apply",apply);
		mv.getModelMap().put("urlParam",urlParam);
		mv.setViewName("/project/meetingSummary/meetingSummary");
		return mv;		
	}
	
	
	/**
	 * 更新总办会纪要
	 * @param meetingSummary
	 * @return
	 */
	@RequestMapping(value="/updateOneMeetSummary", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneMeetSummary(@RequestBody Pro_meetingSummary meetingSummary){
		AjaxRes ar=new AjaxRes();
		try{
			ar.setSucceed ( meetingSummaryService.updateOneMeetSummary(SystemSession.getUserSession(), meetingSummary));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	
	 /**
     * 查看总办会纪要页面
     * @param 
     * @return
     */
	/*@RequestMapping(value="/showMeetSummaryPage")
	public ModelAndView showMeetSummaryPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String apply_ID = urlParam.getEntityID();
		try {
			Pro_apply  apply= new Pro_apply();
			apply.setApply_ID(apply_ID);
		apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+apply_ID+"\'");
		Pro_meetingSummary meetingSummary = meetingSummaryService.selectOneMeetSummary(" and apply_ID = \'"+apply_ID+"\'");
		if (meetingSummary == null) {
			meetingSummary = new  Pro_meetingSummary();
			meetingSummary.setApply_ID(apply_ID);
		}
		mv.getModelMap().put("apply",apply);
		mv.getModelMap().put("meetingSummary",meetingSummary);
		mv.getModelMap().put("urlParam",urlParam);
		mv.setViewName("/project/meetingSummary/meetingSummary");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;		
	}*/
	/**
	 * 更新
	 * @param meetingSummary
	 * @return
	 *//*
	@RequestMapping(value="/updateOneMeetSummary", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneMeetSummary(@RequestBody  Pro_meetingSummary meetingSummary){
		AjaxRes ar=new AjaxRes();
		try{
			if (meetingSummary != null && (meetingSummary.getMeetingSummary_ID() == null || "".equals(meetingSummary.getMeetingSummary_ID()))) {
				ar.setSucceed ( meetingSummaryService.insertOneMeetSummary(SystemSession.getUserSession(), meetingSummary));
			} else {
				ar.setSucceed ( meetingSummaryService.updateOneMeetSummary(SystemSession.getUserSession(), meetingSummary));
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}*/
}

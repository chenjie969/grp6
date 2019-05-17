package com.zjm.gworkFlow.flowBuild.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.gworkFlow.db.model.OsGworkflowProjsuggest;
import com.zjm.gworkFlow.db.model.PendingWorkFlow;
import com.zjm.gworkFlow.flowBuild.service.OsGworkflowProjsuggestService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
 * @author mashuo add 20170928
 */
@Controller
public class FlowBuildAction  {
	//意见构建
	@Resource
	private OsGworkflowProjsuggestService osGworkflowProjsuggestService;
	
	/**
	 * 查询一个用户意见
	 */
	@RequestMapping(value = "/gworkFlow/flowBuild/selectOneOsGworkflowProjsuggest")
	public @ResponseBody ModelAndView selectOneOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest){
		osGworkflowProjsuggest.setStepName(Tool.toChinese(osGworkflowProjsuggest.getStepName()));
		osGworkflowProjsuggest=osGworkflowProjsuggestService.selectOneOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gworkFlow/components/component_sugget_edit");
		mv.getModel().put("osSuggest", osGworkflowProjsuggest);//意见信息
		return mv;
	}
	/**
	 * 更新一个用户意见
	 */
	@RequestMapping(value="/gworkFlow/flowBuild/updateOneOsGworkflowProjsuggest", method=RequestMethod.POST)
	public @ResponseBody AjaxRes updateOneOsGworkflowProjsuggest(@RequestBody OsGworkflowProjsuggest osGworkflowProjsuggest){
		Boolean result=osGworkflowProjsuggestService.updateOneOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(result);
		return ar;
	}
	
	/**
	 * 查询一个流程的所有用户意见
	 */
	@RequestMapping(value="/gworkFlow/flowBuild/selectAllOsGworkflowProjsuggest")
	public @ResponseBody ModelAndView selectAllOsGworkflowProjsuggest(OsGworkflowProjsuggest osGworkflowProjsuggest){
		List<OsGworkflowProjsuggest> list=osGworkflowProjsuggestService.selectAllOsGworkflowProjsuggest(osGworkflowProjsuggest,SystemSession.getUserSession());
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gworkFlow/components/component_sugget_view");
		mv.getModel().put("osSuggestList", list);//意见信息
		return mv;
	}
	
}

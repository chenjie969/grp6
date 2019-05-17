package com.zjm.pro.lawsuitProgress.web;


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
import com.zjm.common.db.model.UrlParam;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_lawsuitProgress;
import com.zjm.pro.lawsuitProgress.service.LawsuitProgressService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;


@Controller
@RequestMapping(value="/project/lawsuitProgress")
public class LawsuitProgressAction{
	
	@Resource
	private LawsuitProgressService lawsuitProgressService;
	@Resource
  	private ProjectApplyService projectApplyService;
	
	
	
	/**
	 * 跳转到添加案件诉讼情况页面
	 * @return
	 */
	@RequestMapping(value="/lawsuitProgressAddPage")
	public ModelAndView lawsuitProgressAddPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/lawsuitPro/lawsuitProgressAdd");
		return mv;
	}
	/**
	 * 新增诉讼情况;
	 * 
	 */
	@RequestMapping(value="/insertOneLawsuitProgressInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneLawsuitProgressInfo(@RequestBody Pro_lawsuitProgress pro_lawsuitProgress){
		Boolean b = true;	
		if(pro_lawsuitProgress  != null){
			try {
				b=lawsuitProgressService.insertOneLawsuitProgressInfo(SystemSession.getUserSession(),pro_lawsuitProgress);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	

	/**
	 * 删除诉讼情况;
	 * 
	 */
	@RequestMapping(value="/delOneLawsuitProgressInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOneLawsuitProgressInfo(@RequestBody Pro_lawsuitProgress pro_lawsuitProgress){
		Boolean b = true;	
		if(pro_lawsuitProgress  != null){
			try {
				String wheresql = " and lawsuitProgress_ID = \'" + pro_lawsuitProgress.getLawsuitProgress_ID() +"\'";
				b=lawsuitProgressService.delOneLawsuitProgressInfo(SystemSession.getUserSession(),wheresql);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 跳转到修改案件诉讼情况页面
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/lawsuitProgressEditPage")
	public ModelAndView lawsuitProgressEditPage(Pro_lawsuitProgress pro_lawsuitProgress){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			String wheresql = " and lawsuitProgress_ID = \'" + pro_lawsuitProgress.getLawsuitProgress_ID() +"\'";
			pro_lawsuitProgress = lawsuitProgressService.selectOneLawsuitProgressInfo(wheresql);
			mv.getModel().put("lawsuitProgress", pro_lawsuitProgress);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/project/lawsuitPro/lawsuitProgressEdit");
		return mv;
	}
	/**
	 * 修改诉讼情况;
	 * 
	 */
	@RequestMapping(value="/updateOneLawsuitProgressInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneLawsuitProgressInfo(@RequestBody Pro_lawsuitProgress pro_lawsuitProgress){
		Boolean b = true;	
		if(pro_lawsuitProgress  != null){
			try {
				b=lawsuitProgressService.updateOneLawsuitProgressInfo(SystemSession.getUserSession(),pro_lawsuitProgress);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
    /**
     * 
     * 跳转到案件诉讼情况页面
     * @param urlParam
     * @return
     */
	@RequestMapping(value="/selectLawsuitProgressTable")
	public ModelAndView selectLawsuitProgressTable(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("urlParam", urlParam);
		mv.setViewName("/project/lawsuitPro/lawsuitSituation");
		return mv;
	}
	
	/**
	 * 
	 * 进入案件诉讼页面   手机APP
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectLawsuitProgressTableAPP")
	public AjaxRes selectLawsuitProgressTableAPP(UrlParam  urlParam){
		AjaxRes ar=new AjaxRes();
		List<Object> lawsuitProgressList = new ArrayList<>();
		String apply_ID = urlParam.getEntityID();
		String whereSql = "and apply_ID='" + apply_ID + "' and unit_uid ='"+SystemSession.getUserSession().getUnit_uid()+"' ";
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
		Pro_lawsuitProgress lawsuit  = lawsuitProgressService.selectOneLawsuitProgressInfo(whereSql);
		lawsuitProgressList.add(lawsuit);
		lawsuitProgressList.add(apply);
		lawsuitProgressList.add(urlParam);
		ar.setSucceed(lawsuitProgressList);
		return ar;
	}
	
	/**
	 * 分页查询案件诉讼
	 */
	@RequestMapping(value="/selectLawsuitProgressPageTable")
	@ResponseBody
	public AjaxRes selectLawsuitProgressPageTable(@RequestBody PageTable<Pro_lawsuitProgress> pageTable){
		AjaxRes ar = new AjaxRes();
		String whereSql = queryConditionSql(pageTable);
		String apply_ID = pageTable.getQueryCondition().getApply_ID();
		if(apply_ID!=null){
			whereSql += " and applyID='"+apply_ID+"' ";
		}
		
		pageTable.setWheresql(whereSql);
		
		
		try {
			pageTable = lawsuitProgressService.selectLawsuitProgressPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_lawsuitProgress> pageTable){
		if(pageTable==null){
			StringBuffer wheresql = new StringBuffer();
			wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		if (pageTable.getWheresql() != null) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		return wheresql.toString();
	}
	
	
}
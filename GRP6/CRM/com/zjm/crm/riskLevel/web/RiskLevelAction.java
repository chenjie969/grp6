package com.zjm.crm.riskLevel.web;

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
import com.zjm.crm.db.model.Crm_riskLevelRec;
import com.zjm.crm.riskLevel.service.RiskLevelService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_contractdoc;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/riskLevel")
public class RiskLevelAction {
	@Resource
   private RiskLevelService riskLevelService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
  	private ProjectApplyService projectApplyService;
	/**
	 * 
	 * 查询风险评级评定记录表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectRiskLevelTable")
	public ModelAndView selectRiskLevelTable(UrlParam  urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("urlParam", urlParam);
		mv.setViewName("/crm/riskLevel/riskLevel");
		return mv;
	}
	/**
	 * 
	 * 进入风险评级评定记录表   手机APP
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectRiskLevelTableAPP")
	@ResponseBody
	public AjaxRes selectRiskLevelTableAPP(@RequestBody UrlParam  urlParam){
		AjaxRes ar=new AjaxRes();
		List<Object> riskLevelRecList = new ArrayList<>();
		String apply_ID = urlParam.getEntityID();
		String whereSql = "and apply_ID='" + apply_ID + "' and unit_uid ='"+SystemSession.getUserSession().getUnit_uid()+"' ";
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
		List<Crm_riskLevelRec> list = riskLevelService.selectRiskLevelList(whereSql);
		/*for (Crm_riskLevelRec riskLevelRec : list) {
			String entityID = riskLevelRec.getRiskLevelRec_ID();
		}*/
		riskLevelRecList.add(list);
		riskLevelRecList.add(apply);
		riskLevelRecList.add(urlParam);
		ar.setSucceed(riskLevelRecList);
		return ar;
	}
	/**
	 * 执行操作，查看风险等级评定表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectRiskLevelPageTable")
	@ResponseBody
	public AjaxRes selectRiskLevelPageTable(@RequestBody PageTable<Crm_riskLevelRec> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
			pageTable =riskLevelService.selectRiskLevelPageTable(pageTable);
			ar.setSucceed(pageTable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面，添加一份风险评级评定记录
	 * 
	 * @return
	 */
	
	@RequestMapping(value="/showRiskLevelAdd")
	public ModelAndView showRiskLevelAdd(String apply_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String wheresql = " and apply_ID = '"+apply_ID+"'";
		Pro_apply pro_apply = projectApplyService.selectOneApplyByWhereSql(wheresql);
		//获取风险等级来源下拉框;
		List<C_dictype> riskLevelList = dicTypeService.selectAllDicTypeList(" and dicTypePID='50f858be37284937af4e6a8d3c9bee4b'");
		mv.getModelMap().put("riskLevelList",riskLevelList);
		//获取项目分类处置划分来源下拉框;
		List<C_dictype> divisionNameList = dicTypeService.selectAllDicTypeList(" and dicTypePID='cb2b7adef9c740daa4c43fda3d4d4d11'");
		mv.getModelMap().put("divisionNameList",divisionNameList);
		mv.getModelMap().put("client_ID", pro_apply.getClient_ID());
		mv.setViewName("/crm/riskLevel/addRiskLevel");
		return mv;
	}
	/**
	 * 显示页面，删除
	 * 
	 * @return
	 *//*
	
	@RequestMapping(value="/showRiskDelPage")
	public ModelAndView showRiskDelPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/riskLevel/relationMainDel");
		return mv;
	}*/
	/**
	 * 执行操作，添加一份风险等级评定记录
	 * @param riskLevelRec
	 * @return
	 */
	@RequestMapping(value="/insertOneRiskLevelRec")
	@ResponseBody
	public AjaxRes insertOneRiskLevelRec(@RequestBody Crm_riskLevelRec riskLevelRec){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(riskLevelService.insertOneRiskLevelRec(SystemSession.getUserSession(), riskLevelRec));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 
	 * 删除风险等级
	 * @param riskLevelRec
	 * @return
	 */
	@RequestMapping(value="/deleteOneRiskLevelByID")
	@ResponseBody
	public AjaxRes deleteOneRiskLevelByID(@RequestBody Crm_riskLevelRec riskLevelRec){
		AjaxRes ar=new AjaxRes();
		try {
			Boolean b=riskLevelService.deleteOneRiskLevelByID(SystemSession.getUserSession(),riskLevelRec.getRiskLevelRec_ID());
			ar.setSucceed(b);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return ar;
	}
}

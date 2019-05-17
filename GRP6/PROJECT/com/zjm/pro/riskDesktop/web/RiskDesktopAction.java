package com.zjm.pro.riskDesktop.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;
import com.zjm.pro.analysis.service.AnalysisService;
import com.zjm.pro.db.model.EChart;
import com.zjm.pro.db.model.Pro_riskScheme;
import com.zjm.pro.riskScheme.serivce.RiskSchemeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value = "/project/riskDesktop")
public class RiskDesktopAction {
	@Resource
	private AnalysisService analysisService;
	@Resource
	private RiskSchemeService riskSchemeService;
	
	/**
	 * 显示风险处置首页
	 */
	@RequestMapping(value="/showRiskDesktopIndexPage")
	public ModelAndView showRiskDesktopIndexPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/riskResponse/index/riskIndex");
		ModelMap map = mv.getModelMap();
		User user = SystemSession.getUserSession();
		map.put("harfMonth",riskSchemeService.selectSchemeNoticeList_count(user,"harfMonth"));
		map.put("oneMonth",riskSchemeService.selectSchemeNoticeList_count(user,"oneMonth"));
		map.put("twoMonth",riskSchemeService.selectSchemeNoticeList_count(user,"twoMonth"));
		List<Pro_riskScheme> riskSchemeList = riskSchemeService.selectRiskSchemeStageList();
		mv.getModelMap().put("riskSchemeList",riskSchemeList);
		return mv;
	}
	
	/**
	 * 2017年担保压降额及预测
	 * @para 折线图
	 * @return
	 */
	@RequestMapping(value="/analysisOfGuarantySumDrop")
	@ResponseBody
	public AjaxRes analysisOfGuarantySumDrop(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.analysisOfGuarantySumDrop();
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	
	/**
	 * 获取本年 委贷余额统计图
	 * @return
	 */
	@RequestMapping(value="/analysisOfEntrustGuarantySumDrop")
	@ResponseBody
	public AjaxRes analysisOfEntrustGuarantySumDrop(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.analysisOfEntrustGuarantySumDrop();
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	/**
	 * 2017年五级分类各担保余额压降比例
	 * @param 柱状图
	 * @return
	 */
	@RequestMapping(value="/analysisOfFiveClass")
	@ResponseBody
	public AjaxRes analysisOfFiveClass(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.analysisOfFiveClass();
			//echarts = analysisService.analysisOfGuarantySumDrop();
			
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	
	/**
	 * 2017年担保集团各公司清收清欠占比(环形圆)
	 * @param
	 * @return
	 */
	@RequestMapping(value="/analysisOfEachCompany")
	@ResponseBody
	public AjaxRes analysisOfEachCompany(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.analysisOfEachCompany();
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	/**
	 * 2017年清收清欠费用占比
	 * @param圆
	 * @return
	 */
	@RequestMapping(value="/analysisOfCostCompare")
	@ResponseBody
	public AjaxRes analysisOfCostCompare(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.analysisOfCostCompareF();
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
	
	
	
	/**
	 * 按业务大类统计
	 * @param圆
	 * @return
	 */
	@RequestMapping(value="/busiClassStatistics")
	@ResponseBody
	public AjaxRes busiClassStatistics(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.busiClassStatistics();
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
	}
}

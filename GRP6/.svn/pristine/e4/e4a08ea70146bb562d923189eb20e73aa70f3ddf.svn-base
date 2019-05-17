package com.zjm.pro.analysis.web;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.pro.analysis.service.AnalysisService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.EChart;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.util.CustomDispatchServlet;
@Controller
@RequestMapping(value="/project/analysis")
public class AnalysisAction {
	@Resource
	private AnalysisService analysisService;
	
	@Resource
	private ApplyDetailService applyDetailService;
	
	@Resource
	private ProjectApplyService projectApplyService;
	
	/**
	 * 1-12月统计金额(表格)
	 * @param wheresql
	 * @return
	 */
	@RequestMapping(value="/analysisByMonth")
	public ModelAndView analysisByMonth(String wheresql){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		if("".equals(wheresql) || null == wheresql){
			SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
			wheresql = df.format(new Date());			
		}
		ArrayList<ArrayList<Double>> sumLists = analysisService.analysisTableOfMonthSum(wheresql);//表格金额		
		ArrayList<ArrayList<Integer>> countLists=analysisService.analysisTableOfMonthCount(wheresql);
		mv.getModelMap().put("countLists",countLists);//1-12月份:笔数统计		
		mv.getModelMap().put("sumLists",sumLists);//1-12月份:金额统计				
		mv.getModelMap().put("wheresql",wheresql);		
		mv.setViewName("/project/analysis/analysisByMonth");
		return mv;		
	}
	
	
	
	
	/**
	 * 1-12月统计金额(折线图)
	 * @param wheresql(年份参数)
	 * @return
	 */
	@RequestMapping(value="/analysisOfMonthSum")
	@ResponseBody
	public AjaxRes analysisOfMonthSum(String wheresql){
		AjaxRes ar = new AjaxRes();
		if("".equals(wheresql) || null == wheresql){
			SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
			wheresql = df.format(new Date());			
		}
		EChart echarts;
		try {
			echarts = analysisService.analysisOfMonthSum(wheresql);
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
		
		
	}
	
	/**
	 * 1-12月统计笔数(折线图)
	 * @param wheresql(年份参数)
	 * @return
	 */
	@RequestMapping(value="/analysisEchartsOfMonthCount")
	@ResponseBody
	public AjaxRes analysisEchartsOfMonthCount(String wheresql){
		AjaxRes ar = new AjaxRes();
		if("".equals(wheresql) || null == wheresql){
			SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
			wheresql = df.format(new Date());			
		}
		EChart echarts;
		try {
			echarts = analysisService.analysisEchartsOfMonthCount(wheresql);
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
		
		
	}
	
	/**
	 * 统计分析:按分类统计
	 * @return
	 */
	@RequestMapping(value="/analysisByClass")
	public ModelAndView analysisByClass(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();	
		try {
			ArrayList<ArrayList<String>>  busiTypeLists = analysisService.analysisByClassOfBusiType();//根据业务品种分类查询	
			ArrayList<ArrayList<String>> bankNameLists = analysisService.analysisByClassOfBankName();//按合作机构分类查询
			ArrayList<ArrayList<String>>  aManLists = analysisService.analysisByClassOfAMan();//根据部门经理分类查询	
			ArrayList<ArrayList<String>>  departMentLists = analysisService.analysisByClassOfDepartMent();//根据业务部门分类查询
			mv.getModelMap().put("bankNameLists",bankNameLists);//按合作机构分类查询
			mv.getModelMap().put("aManLists",aManLists);//按部门经理分类查询
			mv.getModelMap().put("busiTypeLists",busiTypeLists);//按业务品种分类查询
			mv.getModelMap().put("departMentLists",departMentLists);//按业务部门分类查询			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		mv.setViewName("/project/analysis/analysisByClass");
		return mv;				
	}
	
	/**
	 * 按年份统计金额(表格)
	 * @param wheresql
	 * @return
	 */
	@RequestMapping(value="/analysisByYears")
	public ModelAndView analysisByYears(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		try {
			ArrayList<Pro_project> sumLists = analysisService.analysisTableOfYearsSum();//表格金额		
			ArrayList<Pro_project> countLists = analysisService.analysisTableOfYearsCount();//表格笔数		
			
			mv.getModelMap().put("sumLists",sumLists);//年份:金额统计	
			mv.getModelMap().put("countLists",countLists);//年份:笔数统计	
			mv.setViewName("/project/analysis/analysisByYears");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;		
	}
	/**
	 * 按年份 ----统计金额(折线图)
	 * @param wheresql(年份参数)
	 * @return
	 */
	@RequestMapping(value="/analysisOfYearsSum")
	@ResponseBody
	public AjaxRes analysisOfYearsSum(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.analysisOfYearsSum();
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
		
		
	}
	
	/**
	 * 按年份 统计笔数(折线图)
	 * @return
	 */
	@RequestMapping(value="/analysisEchartsOfYearsCount")
	@ResponseBody
	public AjaxRes analysisEchartsOfYearsCount(){
		AjaxRes ar = new AjaxRes();
		EChart echarts;
		try {
			echarts = analysisService.analysisEchartsOfYearsCount();
			ar.setSucceed(echarts);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ar;
		
		
	}
}

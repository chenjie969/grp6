package com.zjm.crm.report.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.crm.report.model.ReportParam;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;

@Controller
@RequestMapping("/report")

public class ReportCountryAction  {
	
	@Resource
	private DicTypeService dicTypeService;
	
	
	@RequestMapping(value="/returnReportDefaultviewer")
	public ModelAndView returnReportDefaultviewer(@RequestBody ReportParam reportParam){				
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.getModel().put("reportParam",reportParam);
		mv.setViewName("/tools/defaultviewer");
		
		return mv;
	}
	
	
	@RequestMapping(value="/returnReportDefaultviewer2")
	public ModelAndView returnReportDefaultviewer2(ReportParam reportParam){				
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.getModel().put("file", reportParam.getFile());
		mv.getModel().put("begindatesql", reportParam.getBegindatesql());
		mv.getModel().put("enddatesql", reportParam.getEnddatesql());
		mv.getModel().put("endyearmonthsql", reportParam.getEndyearmonthsql());
		mv.getModel().put("endyearsql", reportParam.getEndyearsql());
		
		mv.setViewName("/tools/defaultviewer");
		return mv;
	}
	
	/**
	 * 跳转到条件选择页面
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/returnReportSelectPage")
	public ModelAndView returnReportSelectPage(ReportParam reportParam){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String pageType = reportParam.getPageType();
		String viewName="";
		if(pageType.equals("reportSelect_beginAndEnd")){
			viewName="/report/reportSelect_beginAndEnd";
		}else if(pageType.equals("reportSelect_yearMonth")){
			viewName="/report/reportSelect_yearMonth";
		}else if(pageType.equals("reportSelect_endDate")){
			viewName="/report/reportSelect_endDate";
		}else if(pageType.equals("reportSelect_yearMonth_group")){
			viewName="/report/reportSelect_yearMonth_group";
	    }else if(pageType.equals("reportSelect_year_group")){
			viewName="/report/reportSelect_year_group";
	    }else if(pageType.equals("reportSelect_beginAndEnd_group")){
			viewName="/report/reportSelect_beginAndEnd_group";
	    }
		initSelect(mv);
		mv.setViewName(viewName);
		return mv;
	}
	
	public void  initSelect(ModelAndView mv){
		List<C_dictype> projectSourceList = dicTypeService.selectAllDicTypeList(" and dicTypePID='3fafef23e87a4b9c99807207f618883d'");//获取项目(客户)来源下拉框;
		mv.getModelMap().put("projectSourceList",projectSourceList);		
		
		List<C_dictype> busiNatureList = dicTypeService.selectAllDicTypeList(" and dicTypePID='53b3870104de46f99940750515404048'");//获取业务性质下拉框;
		mv.getModelMap().put("busiNatureList",busiNatureList);
		
		List<C_dictype> projectTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='d80f39f02f4a4578aa15bd337062a6fd'");//获取项目类型下拉框;
		mv.getModelMap().put("projectTypeList",projectTypeList);
		
		List<C_dictype> clientTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='2624e18b06c34fdabd0df26d51eca41c'");//获取客户类型下拉框;
		mv.getModelMap().put("clientTypeList",clientTypeList);
		
		List<C_dictype> greenChannelList = dicTypeService.selectAllDicTypeList(" and dicTypePID='70c0e21474174350856987e442c7cd37'");//获取绿色通道下拉框;
		mv.getModelMap().put("greenChannelList",greenChannelList);
		
		List<C_dictype> groupTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='f13d6968b5624d119075c6db6f5a3a27'");//获取分组类型下拉框;
		mv.getModelMap().put("groupTypeList",groupTypeList);
		
		
	}
	
}

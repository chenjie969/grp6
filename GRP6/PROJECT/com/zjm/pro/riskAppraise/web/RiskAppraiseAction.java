package com.zjm.pro.riskAppraise.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.UrlParam;
import com.zjm.pro.db.model.Pro_riskAppraise;
import com.zjm.pro.db.model.Pro_riskScheme;
import com.zjm.pro.riskAppraise.service.RiskAppraiseService;
import com.zjm.pro.riskMeetingRec.serivce.RiskMeetingRecService;
import com.zjm.pro.riskScheme.serivce.RiskSchemeService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

import java.util.List;

@Controller
@RequestMapping(value = "/project/riskAppraise")
public class RiskAppraiseAction {
	@Resource
	private RiskAppraiseService riskAppraiseService;
	@Resource
	private RiskMeetingRecService riskMeetingRecService;
	@Resource
	private RiskSchemeService  riskSchemeService;
	@Resource
	private DicTypeService dicTypeService;
	
	
	//初始化下拉框数据
		public void  initSelect(ModelAndView mv){
			
			List<C_dictype> reportUnitList = dicTypeService.selectAllDicTypeList(" and dicTypePID='78ae83f6524d458dbbd522324c80723d'");//承保机构结果下拉框
			mv.getModelMap().put("reportUnitList",reportUnitList);		
		}
	
/**
 * 查看风险管理委员会的页面
 * @param riskScheme_ID
 * @param urlParam
 * @return
 */

	@RequestMapping(value="/showRiskAppraisePage")
	public ModelAndView showRiskAppraisePage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String riskScheme_ID = urlParam.getEntityID();
		try {
		Pro_riskScheme riskScheme = new Pro_riskScheme();
		riskScheme.setRiskScheme_ID(riskScheme_ID);
		riskScheme = riskSchemeService.selectOneRiskShemeInfo(" and riskScheme_ID = \'"+riskScheme_ID+"\'");
		Pro_riskAppraise riskAppraise = riskAppraiseService.selectOneRiskAppraise(" and riskScheme_ID = \'"+riskScheme_ID+"\'");
		if (riskAppraise == null) {
			riskAppraise = new Pro_riskAppraise();
			riskAppraise.setRiskAppraise_ID(Tool.createUUID32());
			riskAppraise.setRiskScheme_ID(riskScheme_ID);
			riskAppraiseService.insertOneRiskAppraise(SystemSession.getUserSession(), riskAppraise);
		}
		List<C_dictype> reportUnitList = dicTypeService.selectAllDicTypeList(" and dicTypePID='78ae83f6524d458dbbd522324c80723d'");//承保机构结果下拉框
		mv.getModelMap().put("reportUnitList",reportUnitList);
		mv.getModelMap().put("riskAppraise",riskAppraise);
		mv.getModelMap().put("riskScheme",riskScheme);
		mv.getModelMap().put("urlParam",urlParam);
		mv.setViewName("/project/riskAppraise/riskAppraise");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;		
	}
	
	/**
	 * 更新一个风险管理委员会评议表
	 * @param riskAppraise
	 * @return
	 */
	@RequestMapping(value="/updateOneRiskAppraise", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneRiskAppraise(@RequestBody Pro_riskAppraise riskAppraise){
		AjaxRes ar=new AjaxRes();
		try{
//			if (riskAppraise != null && (riskAppraise.getRiskAppraise_ID() == null || "".equals(riskAppraise.getRiskAppraise_ID()))) {
//				ar.setSucceed ( riskAppraiseService.insertOneRiskAppraise(SystemSession.getUserSession(), riskAppraise));
//			} else {
//				
//			}
			ar.setSucceed ( riskAppraiseService.updateOneRiskAppraise(SystemSession.getUserSession(), riskAppraise));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	
	
	
}

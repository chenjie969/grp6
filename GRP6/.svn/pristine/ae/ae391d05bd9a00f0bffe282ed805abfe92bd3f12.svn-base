package com.zjm.pro.costFact.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.pro.costFact.service.CostFactService;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
 * 事项中收费登记 -实收费用action	
 */
@Controller
@RequestMapping(value="/project/costFact")
public class CostFactAction {
	@Resource
	private CostFactService costFactService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private DicTypeService dicTypeService;
	/**
	 * costFactToCostPre
	 * 实收费用--撤销---实收转应预收
	 * @param  
	 * @return
	 */
	@RequestMapping(value="/costFactToCostPre", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes costFactToCostPre(@RequestBody Pro_costFact  pro_costFact){
		AjaxRes ar=new AjaxRes();
		Boolean b= costFactService.costFactToCostPre(SystemSession.getUserSession(),pro_costFact);
		if(b){
			ar.setSucceed(true);
		}
		return ar;
	}
	
	
	/**
	 * 跳转到实收费用---修改页面
	 * @param costPre_ID
	 * @return
	 */
	@RequestMapping(value="/returnCostFactEditPage")
	public ModelAndView returnProjectPayPage(String  costFact_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		
		Pro_costFact  costFact= new Pro_costFact();
	    if(null != costFact_ID){
	    	costFact = costFactService.selectOneCostFactByWhereSql("and costFact_ID = \'"+costFact_ID+"\'");
	    
	    }
		mv.getModelMap().put("costFact",costFact);
		mv.setViewName("/project/cost/costFactEdit");
		return mv;
	}
	/**
	 * insertCostPlanToCostFact
	 * 收入确认-----调整计划收入
	 * @param  
	 * @return
	 */
	@RequestMapping(value="/insertCostPlanToCostFact", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertCostPlanToCostFact(@RequestBody Pro_costFact  pro_costFact){
		AjaxRes ar=new AjaxRes();
		Boolean b= costFactService.insertCostPlanToCostFact(SystemSession.getUserSession(),pro_costFact);
		if(b){
			ar.setSucceed(true);
		}
		return ar;
	}
	/**
	 * 删除一个实收费用表信息
	 * @param Pro_costFact  pro_costFact
	 * @return
	 */
	@RequestMapping(value="/deleteOneCostFact", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneCostFact(@RequestBody Pro_costFact  pro_costFact){
		Boolean b= costFactService.deleteOneCostFact(SystemSession.getUserSession(), pro_costFact);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * changeCostFact
	 * 实收费用表信息--到账确认
	 * @param Pro_costFact  pro_costFact
	 * @return
	 */
	@RequestMapping(value="/changeCostFact", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes changeCostFact(@RequestBody Pro_costFact  pro_costFact){
		Boolean b = false;	
		if(pro_costFact  != null){		
			try {
				pro_costFact.setCostFactState("已确认");
				b = costFactService.updateOneCostFact(SystemSession.getUserSession(), pro_costFact);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * updateOneCostFact
	 * 更新实收费用表信息
	 * 
	 */
	@RequestMapping(value="/updateOneCostFact", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneCostFact(@RequestBody Pro_costFact  pro_costFact){
		Boolean b = false;	
		if(pro_costFact  != null){		
			try {
				b = costFactService.updateOneCostFact(SystemSession.getUserSession(), pro_costFact);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/*******************************************************************************************/
	/**********************************以下是放款复核确认收费****************************************/
	/*******************************************************************************************/
	/**
     * @param meetingDetail_ID
     * @return 添加实收 ———— 展示页面
     */
    @RequestMapping(value="/showAddCostFactPage")
	public ModelAndView showAddCostFactPage(String  meetingDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("meetingDetail",meetingDetail);
		
		mv.setViewName("/project/loan/singleLoanReview/costFactAdd");
		return mv;
	}
	
    /**
	 * 执行实收费用新增操作
	 */
	@RequestMapping(value="/insertOneCostFact")
	@ResponseBody
	public AjaxRes insertOneCostFact(@RequestBody Pro_costFact costFact){
		AjaxRes ar = new AjaxRes();
		Boolean b = costFactService.insertOneCostFact(SystemSession.getUserSession(), costFact);
		ar.setSucceed(b);
		return ar;
	}
	/**
     * @param costFact_ID
     * @return 修改实收 ———— 展示页面
     */
    @RequestMapping(value="/showUpdateCostFactPage")
	public ModelAndView showUpdateCostFactPage(String costFact_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		Pro_costFact costFact = costFactService.selectOneCostFactByWhereSql(" and costFact_ID='"+costFact_ID+"' ");
		
		String condition = " and meetingDetail_ID='"+costFact.getMeetingDetail_ID()+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		mv.getModel().put("meetingDetail",meetingDetail);
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("costFact",costFact);
		
		mv.setViewName("/project/loan/singleLoanReview/costFactUpdate");
		return mv;
	}
    /**
	 * costFact
	 * 修改实收费用表信息
	 */
	@RequestMapping(value="/updateOneCostFacts", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneCostFacts(@RequestBody Pro_costFact  costFact){
		Boolean b = false;	
		if(costFact  != null){		
			try {
				b = costFactService.updateOneCostFacts(SystemSession.getUserSession(), costFact);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
     * @return 删除实收 ———— 展示页面
     */
    @RequestMapping(value="/showDelCostFactPage")
	public ModelAndView showDelCostFactPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/singleLoanReview/costFactDel");
		return mv;
	}
	
}

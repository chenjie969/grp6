package com.zjm.pro.costPre.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;
import com.zjm.pro.costFact.service.CostFactService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.loan.service.LoanService;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.planPay.service.PlanPayService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
 * 事项中收费登记 -预收费用action
 */
@Controller
@RequestMapping(value="/project/costPre")
public class CostPreAction {
	@Resource
	private CostPreService costPreService;
	@Resource
	private CostFactService costFactService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private DicTypeService dicTypeService;
	/**
	 * costPreToCostMust
	 * 预收费用--撤销---预收转应收
	 * @param  
	 * @return
	 */
	@RequestMapping(value="/costPreToCostMust", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes costPreToCostMust(@RequestBody Pro_costPre  pro_costPre){
		AjaxRes ar=new AjaxRes();
		Boolean b= costPreService.costPreToCostMust(SystemSession.getUserSession(),pro_costPre);
		
		if(b){
			ar.setSucceed(true);
		}
		return ar;
	}
	/**
	 * 跳转到预收费用---到账确认页面
	 * @param costPre_ID
	 * @return
	 */
	@RequestMapping(value="/returnCostPreToCostFactPage")
	public ModelAndView returnProjectPayPage(String  costPre_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_costPre  costPre = new Pro_costPre();
		
	    if(null != costPre_ID){
	    	costPre = costPreService.selectOneCostPreByWhereSql(" and costPre_ID = \'"+costPre_ID+"\'");
		   //根据预收费用id在实收费用列表中查询,如果查询出数据则在页面直接显示;如果为空,将此预收费用插入到实收费用列表 
	    List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(" and costPre_ID = \'"+costPre_ID+"\'");
	      if(null == costFactList || costFactList.size() ==0){//为空:将此预收费用信息插入实收费用表中;然后在查询出来;
	    	  List<Pro_costFact> costFactList2  = new ArrayList<>();
	    	  Boolean returnBool = copyCostPreToCostFact(SystemSession.getUserSession(),costPre);
	    	   if(returnBool){
	    		   costFactList2  = costFactService.selectCostFactListByWhereSql(" and costPre_ID = \'"+costPre_ID+"\'");
	    		  
	    	   }
	    	   mv.getModel().put("costFactList",costFactList2);
	      }else{//不为空:在页面进行显示
	    	  mv.getModel().put("costFactList",costFactList);
	      }
	    	
	    	//再在进行查询
	    }
	    mv.getModel().put("costPre",costPre);
		mv.setViewName("/project/cost/costPreToFact");
		return mv;
	}
	
	//拷贝预收费用信息到实收费用表中
	public Boolean  copyCostPreToCostFact(User user, Pro_costPre costPre){
		Boolean b = false;
		Boolean returnBool = false;
		if(null != costPre){
			Pro_costFact  costFact = new Pro_costFact();
	 		costFact.setApply_ID(costPre.getApply_ID());//	申请业务ID	varchar(32)
	 		costFact.setApplyDetail_ID(costPre.getApplyDetail_ID());	//	申请产品ID	varchar(32)
	 		costFact.setCostTypeID(costPre.getCostTypeID());	//	费用类型ID	varchar(32)
	 		costFact.setCostTypeName(costPre.getCostTypeName());	//	费用名称	varchar(50)
	 		costFact.setCostRate(costPre.getCostRate()); 	//	费率	float
	 		costFact.setCostUnit(costPre.getCostUnit());	//	费率单位	varchar(10)
	 		costFact.setFactCostSum(costPre.getPreCostSum());	//	实收金额	decimal(18,6)
	 		costFact.setRemark(costPre.getRemark());	;//	备注	varchar(100)
	 		costFact.setLoanPlan_ID(costPre.getLoanPlan_ID());;//计划放款表id
	 		costFact.setCostPre_ID(costPre.getCostPre_ID());;//预收费用表id
	 		costFact.setPlanFactCostDate(costPre.getPreCostDate());//将预收日期转为计划实收日期
	 		costFact.setCostFactState("未确认");//状态
	 		returnBool  = costFactService.insertOneCostFact(user, costFact);
	 		if(returnBool){
	 			b = true;
	 		}
	 		
		}
		return b;
	}
	
	
	//
	/**
	 * 跳转到实收费用---修改页面
	 * @param costPre_ID
	 * @return
	 */
	@RequestMapping(value="/returnCostPreToplanPage")
	public ModelAndView returnCostPreToplanPage(String  costPre_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_costPre  costPre= new Pro_costPre();
	    if(null != costPre_ID){
	    	costPre = costPreService.selectOneCostPreByWhereSql("and costPre_ID = \'"+costPre_ID+"\'");
	    	mv.getModel().put("costPre",costPre);
	    }
		mv.setViewName("/project/cost/costPreToPlan");
		return mv;
	}
	/*******************************************************************************************/
	/**********************************以下是放款复核确认收费****************************************/
	/*******************************************************************************************/
	/**
     * @param meetingDetail_ID
     * @return 添加预收 ———— 展示页面
     */
    @RequestMapping(value="/showAddCostPrePage")
	public ModelAndView showAddCostPrePage(String  meetingDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String condition = " and meetingDetail_ID='"+meetingDetail_ID+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("meetingDetail",meetingDetail);
		
		mv.setViewName("/project/loan/singleLoanReview/costPreAdd");
		return mv;
	}
    /**
	 * 执行预收费用新增操作
	 */
	@RequestMapping(value="/insertOneCostPre")
	@ResponseBody
	public AjaxRes insertOneCostPre(@RequestBody Pro_costPre costPre){
		AjaxRes ar = new AjaxRes();
		Boolean b = costPreService.insertOneCostPre(SystemSession.getUserSession(), costPre);
		ar.setSucceed(b);
		return ar;
	}
	/**
     * @param costPre_ID
     * @return 修改预收 ———— 展示页面
     */
    @RequestMapping(value="/showUpdateCostPrePage")
	public ModelAndView showUpdateCostPrePage(String  costPre_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		//获取费用类别
		List<C_dictype> costTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='386a21c7b12a45c88a70e462fb0cfdc7'");
		Pro_costPre costPre = costPreService.selectOneCostPreByWhereSql(" and costPre_ID='"+costPre_ID+"' ");
		
		String condition = " and meetingDetail_ID='"+costPre.getMeetingDetail_ID()+"' ";
		//评审会产品明细
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(condition);
		mv.getModel().put("meetingDetail",meetingDetail);
		mv.getModel().put("costTypeList",costTypeList);
		mv.getModel().put("costPre",costPre);
		mv.setViewName("/project/loan/singleLoanReview/costPreUpdate");
		return mv;
	}
    /**
	 * 执行预收费用修改操作
	 */
	@RequestMapping(value="/updateOneCostPre")
	@ResponseBody
	public AjaxRes updateOneCostPre(@RequestBody Pro_costPre costPre){
		AjaxRes ar = new AjaxRes();
		Boolean b = costPreService.updateOneCostPre(SystemSession.getUserSession(), costPre);
		ar.setSucceed(b);
		return ar;
	}
	/**
     * @return 修改预收 ———— 展示页面
     */
    @RequestMapping(value="/showDelCostPrePage")
	public ModelAndView showDelCostPrePage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/singleLoanReview/costPreDel");
		return mv;
	}
	/**
	 * 执行预收费用删除操作
	 */
	@RequestMapping(value="/deleteOneCostPre")
	@ResponseBody
	public AjaxRes deleteOneCostPre(@RequestBody Pro_costPre costPre){
		AjaxRes ar = new AjaxRes();
		Boolean b = costPreService.deleteOneCostPre(SystemSession.getUserSession(), costPre);
		ar.setSucceed(b);
		return ar;
	}
	/**
     * @return 预收转实收 ———— 展示页面
     */
    @RequestMapping(value="/showPreTransFact")
	public ModelAndView showPreTransFact(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/loan/singleLoanReview/preTransFact");
		return mv;
	}
    /**
	 * 预收费用-预收转实收
	 * @param  costPre
	 * @return
	 */
	@RequestMapping(value="/costPreToFact", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes costPreToFact(@RequestBody Pro_costPre costPre){
		Boolean b= costPreService.costPreToFact(SystemSession.getUserSession(),costPre);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
}

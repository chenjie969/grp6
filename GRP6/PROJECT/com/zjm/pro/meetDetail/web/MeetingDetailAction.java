package com.zjm.pro.meetDetail.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.UrlParam;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.costFact.service.CostFactService;
import com.zjm.pro.costMust.service.CostMustService;
import com.zjm.pro.costPre.service.CostPreService;
import com.zjm.pro.costReturn.service.CostReturnService;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_costFact;
import com.zjm.pro.db.model.Pro_costMust;
import com.zjm.pro.db.model.Pro_costPre;
import com.zjm.pro.db.model.Pro_costReturn;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.db.model.Pro_meetingResolution;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value = "/pro/meetResolution/meetingResolution")
public class MeetingDetailAction {
	@Resource
	private MeetingResolutionService meetingResolutionService;
	@Resource
	private MeetingDetailService meetingDetailService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private ApplyDetailService applyDetailService;
	@Resource
	private CostMustService costMustService;// 应收
	@Resource
	private CostFactService costFactService;// 实收
	@Resource
	private CostPreService costPreService;// 预收
	@Resource
	private CostReturnService costReturnService;// 退费

	/**
	 * 添加评审会产品明细内容
	 * 
	 * @param meetingDetail
	 * @return
	 */
	@RequestMapping(value = "/showMeetingDetailAdd")
	public ModelAndView showMeetingDetailAdd(String meetingResolution_ID, String apply_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_meetingDetail meetingDetail = new Pro_meetingDetail();
		meetingDetail.setMeetingResolution_ID(meetingResolution_ID);
		meetingDetail.setApply_ID(apply_ID);
		mv.getModelMap().put("meetingDetail", meetingDetail);

		List<Pro_applyDetail> applyDetailList = applyDetailService
				.selectApplyDetailList(" and apply_ID = '" + apply_ID + "'");
		mv.getModelMap().put("applyDetailList", applyDetailList);
		mv.setViewName("/project/meetResolution/meetingResolution/meetingDetail/meetingDetailAdd");
		return mv;

	}

	@RequestMapping(value = "/insertOneMeetingDetail")
	@ResponseBody
	public AjaxRes insertOneMeetingDetail(@RequestBody Pro_meetingDetail meetingDetail) {
		AjaxRes ar = new AjaxRes();
		try {
			meetingDetail.setMeetingDetail_ID(Tool.createUUID32());
			ar.setSucceed(meetingDetailService.insertOneMeetingDetail(SystemSession.getUserSession(), meetingDetail));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}

	/**
	 * 
	 * 查看评审会产品明细内容
	 * 
	 * @param apply_ID
	 * @return
	 */
	@RequestMapping(value = "/selectOneMeetingDetailByWhereSql")
	public ModelAndView selectOneMeetingDetailByWhereSql(String meetingDetail_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_meetingDetail meetingDetail = meetingDetailService.selectOneMeetingDetailByWhereSql(meetingDetail_ID);
		mv.getModelMap().put("meetingDetail", meetingDetail);
		mv.setViewName("/project/meetResolution/meetingResolution/meetingResolution");
		return mv;
	}

	/**
	 * 删除一个评审会产品内容
	 * 
	 * @param meetingDetail
	 * @return
	 */
	@RequestMapping(value = "/deleteOnemeetingDetail")
	@ResponseBody
	public AjaxRes deleteOnemeetingDetail(@RequestBody Pro_meetingDetail meetingDetail) {
		AjaxRes ar = new AjaxRes();
		try {
			Boolean b = meetingDetailService.deleteOnemeetingDetail(SystemSession.getUserSession(),
					meetingDetail.getMeetingDetail_ID());
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;
	}

	/**
	 * 
	 * 修改评审会产品明细内容
	 * 
	 * @return
	 */
	@RequestMapping(value = "/showMeetingDetailEdit")
	public ModelAndView showMeetingDetailEdit(String meetingDetail_ID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_meetingDetail meetingDetail = meetingDetailService
				.selectOneMeetingDetailByWhereSql(" and meetingDetail_ID = '" + meetingDetail_ID + "'");
		mv.getModelMap().put("meetingDetail", meetingDetail);
		mv.setViewName("/project/meetResolution/meetingResolution/meetingDetail/meetingDetailEdit");
		return mv;
	}

	@RequestMapping(value = "/updateOneMeetingDetail")
	@ResponseBody
	public AjaxRes updateOneMeetingDetail(@RequestBody Pro_meetingDetail meetingDetail) {
		AjaxRes ar = new AjaxRes();
		try {
			Pro_applyDetail applyDetail = applyDetailService
					.selectOneApplyDetailByWhereSql(" and apply_ID ='" + meetingDetail.getApply_ID() + "'");
			if (applyDetail != null) {
				applyDetail.setGuarantyRate(meetingDetail.getGuarantyRate());
				applyDetail.setReviewRate(meetingDetail.getReviewRate());
				applyDetail.setBzScale(meetingDetail.getBzScale());
				applyDetail.setAgreeSum(meetingDetail.getAgreeSum());
				applyDetail.setAgreeMonthDay(meetingDetail.getPeriodMonthDay());
				applyDetail.setAgreeMonth(meetingDetail.getPeriodMonth());
				applyDetail.setAgreeDay(meetingDetail.getPeriodDay());
				applyDetailService.updateOneApplyDetail(SystemSession.getUserSession(), applyDetail);
			}
			ar.setSucceed(meetingDetailService.updateOneMeetingDetail(SystemSession.getUserSession(), meetingDetail));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}

	/******************************************************************************/
	/***************************** 以下是收费登记 *********************************/
	/******************************************************************************/
	/**
	 * @param urlParam
	 * @return 查询放款复核信息（单笔）
	 */
	@RequestMapping(value = "/selectFeeRegister")
	public ModelAndView selectFeeRegister(UrlParam urlParam) {
		List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			String apply_ID = null;
			if (urlParam != null) {
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'" + apply_ID + "\'" + " and unit_uid= \'"
					+ SystemSession.getUserSession().getUnit_uid() + "\'";
			// 查看 评审会决议表
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			if (meetingResolution != null) {
				// 查看 评审会产品明细信息
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(
						" and meetingResolution_ID='" + meetingResolution.getMeetingResolution_ID() + "' ");
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String condition = " and meetingDetail_ID='" + meetingDetail.getMeetingDetail_ID() + "' ";

					// 应收
					List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(condition);
					// 实收
					List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(condition);
					// 预收
					List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresql(condition);
					// 退费
					List<Pro_costReturn> costReturnList = costReturnService.selectCostReturnListByWhereSql(condition);

					meetingDetail.setCostMustList(costMustList);
					meetingDetail.setCostFactList(costFactList);
					meetingDetail.setCostPreList(costPreList);
					meetingDetail.setCostReturnList(costReturnList);
				}
			}

			mv.getModelMap().put("urlParam", urlParam);
			mv.getModelMap().put("meetingDetailList", meetingDetailList);
			mv.setViewName("/project/loan/feeRegister/feeRegister");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	/**
	 * @param urlParam
	 * @return 查询放款复核信息（单笔）查看收费等级App
	 */
	@RequestMapping(value = "/selectFeeRegisterApp")
	@ResponseBody
	public AjaxRes selectFeeRegisterApp(@RequestBody UrlParam urlParam) {
		List<Pro_meetingDetail> meetingDetailList = new ArrayList<Pro_meetingDetail>();
		AjaxRes ar = new AjaxRes();
		try {
			String apply_ID = null;
			if (urlParam != null) {
				apply_ID = urlParam.getEntityID();
			}
			String whereSql = "and apply_ID = \'" + apply_ID + "\'" + " and unit_uid= \'"
					+ SystemSession.getUserSession().getUnit_uid() + "\'";
			// 查看 评审会决议表
			Pro_meetingResolution meetingResolution = meetingResolutionService.selectOneResolutionByWhereSql(whereSql);
			if (meetingResolution != null) {
				// 查看 评审会产品明细信息
				meetingDetailList = meetingDetailService.selectMeetingDetailListByWhereSql(
						" and meetingResolution_ID='" + meetingResolution.getMeetingResolution_ID() + "' ");
				for (Pro_meetingDetail meetingDetail : meetingDetailList) {
					String condition = " and meetingDetail_ID='" + meetingDetail.getMeetingDetail_ID() + "' ";

					// 应收
					List<Pro_costMust> costMustList = costMustService.selectCostMustListByWheresql(condition);
					// 实收
					List<Pro_costFact> costFactList = costFactService.selectCostFactListByWhereSql(condition);
					// 预收
					List<Pro_costPre> costPreList = costPreService.selectCostPreListByWheresql(condition);
					// 退费
					List<Pro_costReturn> costReturnList = costReturnService.selectCostReturnListByWhereSql(condition);

					meetingDetail.setCostMustList(costMustList);
					meetingDetail.setCostFactList(costFactList);
					meetingDetail.setCostPreList(costPreList);
					meetingDetail.setCostReturnList(costReturnList);
				}
			}

			//mv.getModelMap().put("meetingDetailList", meetingDetailList);
			//mv.setViewName("/project/loan/feeRegister/feeRegister");
			ar.setSucceed(meetingDetailList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}

}

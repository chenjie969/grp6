package com.zjm.oa.rewardsPunish.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_staffRewards;
import com.zjm.oa.staffRewards.service.RewardsService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.Tool;

@Controller
@RequestMapping("/oa/rewards")
public class RewardsPunishmentAction {
	@Resource
	private RewardsService  rewardsService;
	
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  loadpage(String staffcase_Id,String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("staffcase_Id", staffcase_Id);
		modeAndView.getModel().put("type", type);
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/rewardsPunishment/index");
		return modeAndView;
	}	
	/**
 		查询信息 列表 
	 */

	@RequestMapping(value="/selectRewardsListPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectRewardsListPageTables(@RequestBody PageTable<Hr_staffRewards> pageTable){
		try{String queryCondition = queryCondition(pageTable);
		List<Hr_staffRewards> list = rewardsService.selectRewardsrListBy_ID(queryCondition);	
		System.out.println(list.size());
		pageTable.setRows(list);}
		catch(Exception e){
			e.printStackTrace();
		}
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(pageTable);
		return ar;
	}			
	private String queryCondition(PageTable<Hr_staffRewards> pageTable) {
		String wheresql="";
		if(null == pageTable){
			return "";
		}
		String staffcase_Id = pageTable.getQueryCondition().getStaffcase_Id();
		if(staffcase_Id != null && !"".equals(staffcase_Id)){
			wheresql=staffcase_Id;
		}
		return wheresql;
	}	
	//查看
	@RequestMapping(value="/selectRewardsViewPage")
	public ModelAndView selectRewardsViewPage(String rewardsID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try{
			Hr_staffRewards rewardPunishment=rewardsService.selectOneByRewardId(rewardsID);				
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/rewardsPunishment/viewmodal");
			mv.getModel().put("rewardPunishment", rewardPunishment);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;		
	}
	
	/**
	 * 添加信息页面	
	 */
	@RequestMapping(value="/selectRewardsAddPage")
	public ModelAndView selectRewardsAddPage(Hr_staffRewards rewardPunishment){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/rewardsPunishment/addModal");
		mv.getModel().put("rewardPunishment", rewardPunishment);
		return mv;
	}
	
	/**
	 * 插入一个
	 */
	@RequestMapping(value="/insertOneRewardsferInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneRewardsferInfo(@RequestBody Hr_staffRewards rewardPunishment){
		rewardPunishment.setRewardsID(Tool.createUUID32());		
		Boolean b= rewardsService.insertOneRewardsInfo(rewardPunishment);	
		System.out.println("bb"+b);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
		
		/**
		 * 修改信息页面

		 */
		@RequestMapping(value="/selectRewardsEditPage")
		public ModelAndView selectRewardsEditPage(Hr_staffRewards rewardPunishment){
			ModelAndView mv=CustomDispatchServlet.getModeAndView();
			try{
			if(rewardPunishment==null){
				rewardPunishment=new Hr_staffRewards();
			}
			rewardPunishment=rewardsService.selectOneByRewardId(rewardPunishment.getRewardsID());			
		}catch(Exception e){
			e.printStackTrace();
		}
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/rewardsPunishment/upModal");	
			mv.getModel().put("rewardPunishment", rewardPunishment);
			return mv;	
		}
		/**
		 * 更新		
		 */
		@RequestMapping(value="/updateOneRewardsInfo", method=RequestMethod.POST)
		@ResponseBody
		public AjaxRes updateOneRewardsInfo(@RequestBody Hr_staffRewards rewardPunishment){	
			Boolean result=true;
			Hr_staffRewards isExist=rewardsService.selectOneByRewardId(rewardPunishment.getRewardsID());
			if(isExist != null){
				
				result=rewardsService.updateOneRewardsInfo(rewardPunishment);
			
			}
			AjaxRes ar = new AjaxRes();
			if(result){
				ar.setSucceed("1");
			}else{
				ar.setSucceed("0");
			}
			return ar;
		}
	
	
}

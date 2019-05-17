package com.zjm.gworkFlow.pendingWorkFlow.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.gworkFlow.pendingWorkFlow.service.PendingWorkFlowService;
import com.zjm.util.SystemSession;
@Controller
public class PendingWorkFlowAction {

	//流程模板
	@Resource
	private PendingWorkFlowService pendingWorkFlowService;
	
	
	@RequestMapping(value="/pendingWorkFlow/returnMonitoringWorkFlowPageTable", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes returnMonitoringWorkFlowPageTable(@RequestBody PageTable pageTable){
		try {
			System.out.println(JSON.toJSONString(pageTable));
			pageTable=pendingWorkFlowService.returnMonitoringWorkFlowPageTable(pageTable);
			System.out.println(JSON.toJSONString(pageTable));
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	//代办审批
	@RequestMapping(value="/pendingWorkFlow/waitTaskPageTable", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes waitTaskPageTable(@RequestBody PageTable pageTable){
		try {
			User user = SystemSession.getUserSession();
			pageTable.setWheresql(" and H.user_uid = '" + user.getUser_uid() + "'");
			System.out.println(JSON.toJSONString(pageTable));
			pageTable=pendingWorkFlowService.returnPendingWorkFlowPageTable(pageTable);
			System.out.println(JSON.toJSONString(pageTable));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
}

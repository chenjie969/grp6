package com.zjm.crm.managerInfo.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.crm.db.model.Crm_managerInfo;
import com.zjm.crm.managerInfo.service.ManagerInfoService;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
*  @description  股东 主要管理人员信息 action
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月14日17:50:56
*/
@Controller
public class ManagerInfoAction {
	
	@Resource
	private  ManagerInfoService  managerInfoService;
	
	/**
	 * 修改 股东主要管理人员信息
	 * @param crm_managerInfo
	 * @return
	 */
	@RequestMapping(value="/updateOneManagerInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneManagerInfo(@RequestBody Crm_managerInfo crm_managerInfo){
		//判断管理人员信息是否存在
		String sql="and client_ID= '"+crm_managerInfo.getClient_ID()+"'";
		Crm_managerInfo managerInfo = managerInfoService.selectOneManagerInfo(sql);
		Boolean bool=false;
		if(null != managerInfo){//id 存在,修改
			 bool = managerInfoService.updateOneManagerInfo(crm_managerInfo,SystemSession.getUserSession());
		}else{// id 不存在，新增一条记录
			crm_managerInfo.setManagerinfoId(Tool.createUUID32());// 添加 uuid
			User userSession = SystemSession.getUserSession();
			crm_managerInfo.setUnitUid(userSession.getUnit_uid()); //担保机构id
			crm_managerInfo.setUpdateusername(userSession.getUser_name()); //修改人姓名
			bool =managerInfoService.insertOneManagerInfo(crm_managerInfo,SystemSession.getUserSession());
		}
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 查找一条  股东主要管理人员信息
	 * @param crm_managerInfo
	 * @return
	 */
	@RequestMapping(value="/selectOneManagerInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneManagerInfo(@RequestBody Crm_managerInfo crm_managerInfo){
		String wheresql="";
		String client_ID = crm_managerInfo.getClient_ID();//客户id
		if( null != client_ID &&  !"".equals(client_ID)){
			wheresql+=" and client_ID = '"+client_ID +"'";
		}
		String managerinfoId = crm_managerInfo.getManagerinfoId();
		if( null != managerinfoId && !"".equals(managerinfoId)){
			wheresql+=" and managerInfo_ID '"+managerinfoId+"'";
		}
		Crm_managerInfo managerInfo = managerInfoService.selectOneManagerInfo(wheresql);
		if(null == managerInfo){
			managerInfo=new Crm_managerInfo();
			managerInfo.setClient_ID(client_ID);
		}
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(managerInfo);
		return ar;
	}
	
}

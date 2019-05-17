package com.zjm.crm.creditInfo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.crm.creditInfo.service.CreditInfoService;
import com.zjm.crm.db.model.Crm_creditInfo;
import com.zjm.util.SystemSession;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;

@Controller
public class CreditInfoAction {

	@Resource
	private CreditInfoService creditInfoService;
	
	/**
	 * 查询一条企业信用信息
	 * 优先根据流水号creditInfo_ID查询，也可根据client_ID查询。 creditInfo_ID与client_ID应该是一对一的关系 
	 * @param creditInfo
	 * @return
	 */
	@RequestMapping(value = "/selectOneCreditInfo" ,method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneCreditInfo(@RequestBody Crm_creditInfo creditInfo) {
		AjaxRes ar = new AjaxRes();
		creditInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Crm_creditInfo result = creditInfoService.selectOneCreditInfo(creditInfo);
		if(result !=null){
			ar.setSucceed(result);
		}else{
			ar.setSucceed(creditInfo);
		}
		return ar;
	}
	
	/**
	 * 更新/插入一条企业信用信息
	 * @param creditInfo
	 * @return
	 */
	@RequestMapping(value = "/updateOneCreditInfo" ,method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneCreditInfo(@RequestBody Crm_creditInfo creditInfo) {
		creditInfo.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Crm_creditInfo isExist = creditInfoService.selectOneCreditInfo(creditInfo);
		User user = SystemSession.getUserSession();
		Boolean result;
		if(isExist == null){		//新增信息
			result = creditInfoService.insertOneCreditInfo(user,creditInfo);
		}else{		//更新信息
			result = creditInfoService.updateOneCreditInfo(user,creditInfo);
		}
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(result);
		return ar;
	}
}

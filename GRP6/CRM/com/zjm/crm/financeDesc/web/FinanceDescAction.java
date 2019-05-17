package com.zjm.crm.financeDesc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.crm.db.model.Crm_financeDesc;
import com.zjm.crm.financeDesc.service.FinanceDescService;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/crm/financeDesc")
public class FinanceDescAction {

	@Resource
	private FinanceDescService financeDescService;
	
	/**
	 *  新增/修改一条财务状况说明
	 */
	@RequestMapping(value="/updateOneFinanceDesc")
	@ResponseBody
	public AjaxRes updateOneFinanceDesc(@RequestBody Crm_financeDesc financeDesc){
		AjaxRes ar = new AjaxRes();
		financeDesc.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		if(financeDescService.selectOneFinanceDesc(financeDesc) == null){	//先查询财务说明表中是否有该企业的记录，查不到就新增一条
			ar.setSucceed(financeDescService.insertOneFinanceDesc(SystemSession.getUserSession(), financeDesc));
		}else{
			ar.setSucceed(financeDescService.updateOneFinanceDesc(SystemSession.getUserSession(), financeDesc));
		}
		return ar;
	}
	
	/**
	 * 查看一条财务状况说明
	 */
	@RequestMapping(value="/selectOneFinanceDesc")
	@ResponseBody
	public AjaxRes selectOneFinanceDesc(@RequestBody Crm_financeDesc financeDesc){
		AjaxRes ar = new AjaxRes();
		financeDesc.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(financeDescService.selectOneFinanceDesc(financeDesc));
		return ar;
	}

}

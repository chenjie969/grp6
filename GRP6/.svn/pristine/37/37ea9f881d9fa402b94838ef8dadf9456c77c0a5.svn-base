package com.zjm.crm.bankAccount.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zjm.crm.bankAccount.service.BankAccountService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_bankAccount;
import com.zjm.util.SystemSession;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;

/**
*  @description  开户信息action
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月5日 下午12:57:24
*/
@Controller
public class BankAccountAction {
	
	@Resource
	private BankAccountService  bankAccountService;
	
	@Resource
	private ClientService   clientService;
	
	/**
	 * 
	 * @description 查询银行开户信息分页列表  wuhn
	 * @author wuhn
	 * @date 2017年5月5日 下午1:41:32
	 */
	@RequestMapping(value="/selectCompanysCrm_bankAccountPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectCompanysCrm_bankAccountPageTables(@RequestBody PageTable<Crm_bankAccount> pageTable){
		pageTable.setWheresql(queryConditionSql(pageTable));//添加分页查询条件
		pageTable = bankAccountService.selectCompanysCrm_bankAccountPageTables(pageTable);
		pageTable.setWheresql("");// 清空查询条件
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	/**
	 * 开户信息 列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable<Crm_bankAccount> pageTable){
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		String client_ID = pageTable.getQueryCondition().getClient_ID();
		if(null != client_ID){
			wheresql+="and client_ID='"+client_ID+"'";
		}
		return wheresql;
	}
	
	
	/**
	 * 
	 * @description	 添加/插入一个银行开户信息信息
	 * @author wuhn
	 * @date 2017年5月5日 下午1:42:41
	 */
	@RequestMapping(value="/insertOneCompanyCrm_bankAccountInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneCompanyCrm_bankAccountInfo(@RequestBody Crm_bankAccount crm_bankAccount){
		AjaxRes ar=new AjaxRes();
		crm_bankAccount.setUpdateusername(SystemSession.getUserSession().getUser_name());//添加修改用户姓名
		crm_bankAccount.setUnit_uid(SystemSession.getUserSession().getUnit_uid());//设置机构id;
		//判断当前客户id在客户基表中是否存在
		List<Crm_bankAccount> list = bankAccountService.selectCompanyCrm_bankAccountByClient_ID(crm_bankAccount);
		Client client =new Client();
		client.setClient_ID(crm_bankAccount.getClient_ID());
		Client clientInfo = clientService.selectOneClientInfo(client);
		if(null ==  clientInfo){
			new RuntimeException("客户基表crm_client中无此记录信息"); //是否需要，待定
		}
		
		Boolean bool = bankAccountService.insertOneCompanyCrm_bankAccountInfo(crm_bankAccount,SystemSession.getUserSession());
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description	更新 修改一个银行开户信息信息
	 * @author wuhn
	 * @date 2017年5月5日 下午1:42:48
	 */
	@RequestMapping(value="/updateOneCompanyCrm_bankAccountInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneCompanyCrm_bankAccountInfo(@RequestBody Crm_bankAccount crm_bankAccount){
		crm_bankAccount.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		crm_bankAccount.setUpdatedatetime(new Date());
		Boolean bool = true;
		try {
			bool = bankAccountService.updateOneCompanyCrm_bankAccountInfo(crm_bankAccount,
					SystemSession.getUserSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description	删除 移除一个银行开户信息信息 根据银行开户id删除
	 * @author wuhn
	 * @date 2017年5月5日 下午1:43:16
	 */
	@RequestMapping(value="/deleteOneCompanyCrm_bankAccountInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneCompanyCrm_bankAccountInfo(@RequestBody Crm_bankAccount crm_bankAccount){
		crm_bankAccount.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean bool = bankAccountService.deleteOneCompanyCrm_bankAccountInfo(crm_bankAccount,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 根据银行id查询一个银行开户信息  
	 * @description
	 * @author wuhn
	 * @date 2017年5月5日 下午1:43:37
	 */
	@RequestMapping(value="/selectOneBankAccountInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneBankAccountInfo(@RequestBody Crm_bankAccount crm_bankAccount){
		Crm_bankAccount	crm_bankAccountInfo = bankAccountService.selectOneCompanyCrm_bankAccountInfo(crm_bankAccount);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(crm_bankAccountInfo);
		return ar;
	}
	
	
}

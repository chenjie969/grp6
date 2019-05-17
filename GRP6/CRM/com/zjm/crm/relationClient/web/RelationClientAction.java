package com.zjm.crm.relationClient.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Crm_relationClient;
import com.zjm.crm.relationClient.service.RelationClientService;
import com.zjm.util.SystemSession;

/**
 * 关联客户
 * @author chenyang add 20170504
 */
@Controller
public class RelationClientAction {
	@Resource
	private RelationClientService relationClientService;
	
	@Resource
	private ClientService clientService;
	/**
	 * 根据Client_ID查询关联企业列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectRelationClientPageTables")
	@ResponseBody
	public AjaxRes selectRelationClientPageTables(@RequestBody Crm_relationClient relationClient) {
		PageTable<Crm_relationClient> pageTable = new PageTable<>();
		pageTable=relationClientService.selectRelationClientPageTables(relationClient);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 
	 * @description 新增一个关联企业信息
	 * @author chenyang
	 * @date 2017年5月4日
	 */
	@RequestMapping(value="/insertOneRelationClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneRelationClientInfo(@RequestBody Crm_relationClient relationClient) {
		User user = SystemSession.getUserSession();
		Boolean bool = relationClientService.insertOneRelationClientInfo(user,relationClient);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 删除一个关联企业信息
	 * @author chenyang
	 * @date 2017年5月4日
	 */
	@RequestMapping(value="/deleteOneRelationClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneRelationClientInfo(@RequestBody String relation_id) {
		User user = SystemSession.getUserSession();
		Boolean bool = relationClientService.deleteOneRelationClientInfo(user,relation_id);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个关联企业的信息
	 * @author chenyang
	 * @date 2017年5月4日 下午3:33:11
	 */
	@RequestMapping(value="/selectOneRelationClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneRelationClientInfo(@RequestBody Crm_relationClient  relationClient ) {
		relationClient = relationClientService.selectOneRelationClientInfo(relationClient );
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(relationClient );
		return ar;
	}
	
	/**
	 * 
	 * @description 修改 更新关联企业信息  
	 * @author chenyang
	 * @date 2017年5月4日 下午7:14:03
	 */
	@RequestMapping(value="/updateOneRelationClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneRelationClientInfo(@RequestBody Crm_relationClient relationClient) { 
		User user = SystemSession.getUserSession();
		Boolean bool =  relationClientService.updateOneRelationClientInfo(user,relationClient);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
}

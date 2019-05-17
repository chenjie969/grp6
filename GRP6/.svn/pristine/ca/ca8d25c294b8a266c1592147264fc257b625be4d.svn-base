package com.zjm.crm.relationQuery.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.relationQuery.service.RelationQueryService;
import com.zjm.util.SystemSession;

/**
 * 关联查询
 * @author LiKM add 20170613
 */
@Controller
@RequestMapping(value="/crm/relationQuery")
public class RelationQueryAction {
	
	@Resource
	private RelationQueryService relationQueryService;
	
	/**
	 * 关联查询企业客户分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/relationQueryClientPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes relationQueryClientPageTables(@RequestBody PageTable pageTable) {
		try {
			AjaxRes ar=new AjaxRes();
			User user = SystemSession.getUserSession();
//			pageTable.getQueryCondition().setUser_uid(user.getUser_uid());//设置用户id通过匹配用户权限来查询
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			ar.setSucceed(relationQueryService.relationQueryClient(pageTable));
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关联查询个人客户分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/relationQueryPersonPageTables")
	@ResponseBody
	public AjaxRes relationQueryPersonPageTables(@RequestBody PageTable pageTable) {
		try {
			AjaxRes ar=new AjaxRes();
//			pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			ar.setSucceed(relationQueryService.relationQueryPerson(pageTable));
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

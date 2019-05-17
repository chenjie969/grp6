package com.zjm.crm.selfHouse.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_selfHouse;
import com.zjm.crm.selfHouse.service.SelfHouseService;
import com.zjm.util.SystemSession;

/**
 * 自有住房
 * @author chenyang add 20170504
 */
@Controller
public class SelfHouseAction {
	@Resource
	private SelfHouseService selfHouseService;
	
	/**
	 * 查询自有住房列表
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectSelfHouseInfoPageTables")
	@ResponseBody
	public AjaxRes selectSelfHouseInfoPageTables(@RequestBody Crm_selfHouse selfHouse) {
		PageTable<Crm_selfHouse> pageTable = new PageTable<>();
		pageTable=selfHouseService.selectSelfHouseInfoPageTables(selfHouse);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 
	 * @description 新增一个自有住房信息
	 * @author chenyang
	 * @date 2017年5月5日
	 */
	@RequestMapping(value="/insertOneSelfHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneSelfHouseInfo(@RequestBody Crm_selfHouse selfHouse) {
		User user = SystemSession.getUserSession();
		Boolean bool = selfHouseService.insertOneSelfHouseInfo(user,selfHouse);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 删除一个自有住房信息
	 * @author chenyang
	 * @date 2017年5月5日
	 */
	@RequestMapping(value="/deleteOneSelfHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneSelfHouseInfo(@RequestBody Crm_selfHouse selfHouse) {
		User user = SystemSession.getUserSession();
		Boolean bool = selfHouseService.deleteOneSelfHouseInfo(user,selfHouse);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个自有住房
	 * @author chenyang
	 * @date 2017年5月5日 下午3:33:11
	 */
	@RequestMapping(value="/selectOneSelfHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneSelfHouseInfo(@RequestBody Crm_selfHouse selfHouse ) {
		selfHouse = selfHouseService.selectOneSelfHouseInfo(selfHouse );
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(selfHouse );
		return ar;
	}
	
	/**
	 * 
	 * @description 修改 更新自有住房
	 * @author chenyang
	 * @date 2017年5月5日 下午7:14:03
	 */
	@RequestMapping(value="/updateOneSelfHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneSelfHouseInfo(@RequestBody Crm_selfHouse selfHouse) { 
		Crm_selfHouse selfHouse2  = selfHouseService.selectOneSelfHouseInfo(selfHouse);
		Boolean bool;
		if (selfHouse2 == null) {
			User user = SystemSession.getUserSession();
			bool = selfHouseService.insertOneSelfHouseInfo(user,selfHouse);
		}else {
			User user = SystemSession.getUserSession();
			bool =  selfHouseService.updateOneSelfHouseInfo(user,selfHouse);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
}

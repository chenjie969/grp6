package com.zjm.crm.spouseInfo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Crm_spouseInfo;
import com.zjm.crm.spouseInfo.service.SpouseInfoService;
import com.zjm.util.SystemSession;

/**
 * 配偶信息
 * @author chenyang add 20170504
 */
@Controller
public class SpouseInfoAction {
	@Resource
	private SpouseInfoService spouseInfoService;
	
	/**
	 * 查询配偶信息列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectSpouseInfoPageTables")
	@ResponseBody
	public AjaxRes selectSpouseInfoPageTables(@RequestBody Crm_spouseInfo spouseInfo) {
		PageTable<Crm_spouseInfo> pageTable = new PageTable<>();
		pageTable=spouseInfoService.selectSpouseInfoPageTables(spouseInfo);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 
	 * @description 新增一个配偶信息信息
	 * @author chenyang
	 * @date 2017年5月5日
	 */
	@RequestMapping(value="/insertOneSpouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneSpouseInfo(@RequestBody Crm_spouseInfo spouseInfo) {
		User user = SystemSession.getUserSession();
		Boolean bool = spouseInfoService.insertOneSpouseInfo(user,spouseInfo);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 删除一个配偶信息信息
	 * @author chenyang
	 * @date 2017年5月5日
	 */
	@RequestMapping(value="/deleteOneSpouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneSpouseInfo(@RequestBody Crm_spouseInfo spouseInfo) {
		User user = SystemSession.getUserSession();
		Boolean bool = spouseInfoService.deleteOneSpouseInfo(user,spouseInfo);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个配偶信息
	 * @author chenyang
	 * @date 2017年5月5日 下午3:33:11
	 */
	@RequestMapping(value="/selectOneSpouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneSpouseInfo(@RequestBody Crm_spouseInfo  spouseInfo ) {
		try {
			spouseInfo = spouseInfoService.selectOneSpouseInfo(spouseInfo );
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(spouseInfo );
		return ar;
	}
	
	/**
	 * 
	 * @description 修改 更新配偶信息
	 * @author chenyang
	 * @date 2017年5月5日 下午7:14:03
	 */
	@RequestMapping(value="/updateOneSpouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneSpouseInfo(@RequestBody Crm_spouseInfo spouseInfo) { 
		Crm_spouseInfo spouseInfo2  = spouseInfoService.selectOneSpouseInfo(spouseInfo);
		Boolean bool;
		if (spouseInfo2 == null) {
			User user = SystemSession.getUserSession();
			bool = spouseInfoService.insertOneSpouseInfo(user,spouseInfo);
		}else {
			User user = SystemSession.getUserSession();
			bool =  spouseInfoService.updateOneSpouseInfo(user,spouseInfo);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
}

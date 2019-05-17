package com.zjm.crm.landHouse.web;

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
import com.zjm.crm.db.model.Crm_landHouse;
import com.zjm.crm.landHouse.service.LandHouseService;
import com.zjm.util.SystemSession;

/**
 * 住宅
 * @author chenyang
 */
@Controller
public class LandHouseAction {
	@Resource
	private LandHouseService landHouseService;
	
	@Resource
	private ClientService clientService;
	/**
	 * 根据Client_ID查询住宅列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectLandHousePageTables")
	@ResponseBody
	public AjaxRes selectLandHousePageTables(@RequestBody Crm_landHouse landHouse) {
		try {
			PageTable<Crm_landHouse> pageTable = new PageTable<>();
			pageTable=landHouseService.selectLandHousePageTables(landHouse);
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(pageTable);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @description 新增一个住宅信息
	 * @author chenyang
	 */
	@RequestMapping(value="/insertOneLandHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneLandHouseInfo(@RequestBody Crm_landHouse landHouse) {
		try {
			User user = SystemSession.getUserSession();
			Boolean bool = landHouseService.insertOneLandHouseInfo(user, landHouse);
			AjaxRes ar = new AjaxRes();
			ar.setSucceed(bool);
			return ar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * 
	 * @description 删除一个住宅信息
	 * @author chenyang
	 */
	@RequestMapping(value="/deleteOneLandHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneLandHouseInfo(@RequestBody String landHouse_ID) {
		User user = SystemSession.getUserSession();
		Boolean bool = landHouseService.deleteOneLandHouseInfo(user,landHouse_ID);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个住宅的信息
	 * @author chenyang
	 */
	@RequestMapping(value="/selectOneLandHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneLandHouseInfo(@RequestBody Crm_landHouse  landHouse ) {
		try {
			landHouse = landHouseService.selectOneLandHouseInfo(landHouse );
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(landHouse );
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @description 修改 更新住宅信息  
	 * @author chenyang
	 */
	@RequestMapping(value="/updateOneLandHouseInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneLandHouseInfo(@RequestBody Crm_landHouse landHouse) { 
		try {
			User user = SystemSession.getUserSession();
			Boolean bool =  landHouseService.updateOneLandHouseInfo(user,landHouse);
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(bool);
			return ar;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}

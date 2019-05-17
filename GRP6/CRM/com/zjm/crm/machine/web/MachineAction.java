package com.zjm.crm.machine.web;

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
import com.zjm.crm.db.model.Crm_machine;
import com.zjm.crm.machine.service.MachineService;
import com.zjm.util.SystemSession;

/**
 * 机械
 * @author chenyang
 */
@Controller
public class MachineAction {
	@Resource
	private MachineService machineService;
	
	@Resource
	private ClientService clientService;
	/**
	 * 根据Client_ID查询机械列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectMachinePageTables")
	@ResponseBody
	public AjaxRes selectMachinePageTables(@RequestBody Crm_machine machine) {
		try {
			PageTable<Crm_machine> pageTable = new PageTable<>();
			pageTable=machineService.selectMachinePageTables(machine);
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
	 * @description 新增一个机械信息
	 * @author chenyang
	 */
	@RequestMapping(value="/insertOneMachineInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneMachineInfo(@RequestBody Crm_machine machine) {
		try {
			User user = SystemSession.getUserSession();
			Boolean bool = machineService.insertOneMachineInfo(user, machine);
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
	 * @description 删除一个机械信息
	 * @author chenyang
	 */
	@RequestMapping(value="/deleteOneMachineInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneMachineInfo(@RequestBody String machine_ID) {
		User user = SystemSession.getUserSession();
		Boolean bool = machineService.deleteOneMachineInfo(user,machine_ID);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 查询一个机械的信息
	 * @author chenyang
	 */
	@RequestMapping(value="/selectOneMachineInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneMachineInfo(@RequestBody Crm_machine  machine ) {
		try {
			machine = machineService.selectOneMachineInfo(machine );
			AjaxRes ar=new AjaxRes();
			ar.setSucceed(machine );
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @description 修改 更新机械信息  
	 * @author chenyang
	 */
	@RequestMapping(value="/updateOneMachineInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneMachineInfo(@RequestBody Crm_machine machine) { 
		try {
			User user = SystemSession.getUserSession();
			Boolean bool =  machineService.updateOneMachineInfo(user,machine);
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

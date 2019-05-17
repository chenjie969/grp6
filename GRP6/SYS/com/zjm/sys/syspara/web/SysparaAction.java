package com.zjm.sys.syspara.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_syspara;
import com.zjm.sys.syspara.service.SysparaService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
public class SysparaAction {
	@Resource
	SysparaService sysparaService;
	
	/**
	 * 系统参数页面
	 * @return
	 */
	@RequestMapping(value = "/sys/syspara/sysparaPage")
	@ResponseBody
	public ModelAndView indexPackge(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		
		mv.setViewName("/sys/syspara/syspara");
		return mv;
	}
	
	/**
	 * 系统参数查看页面
	 * @return
	 */
	@RequestMapping(value = "/syspara/syspara/sysparaViewPage")
	@ResponseBody
	public ModelAndView sysparaViewPage(Sys_syspara sys_syspara){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Sys_syspara para = sysparaService.selectOneSysparaInfo(sys_syspara.getSyspara_ID());
			mv.getModel().put("para", para);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/sys/syspara/sysparaView");
		return mv;
	}
	
	/**
	 * 系统参数修改页面
	 * @return
	 */
	@RequestMapping(value = "/syspara/syspara/sysparaEditPage")
	@ResponseBody
	public ModelAndView sysparaEditPage(Sys_syspara sys_syspara){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Sys_syspara para = sysparaService.selectOneSysparaInfo(sys_syspara.getSyspara_ID());
			mv.getModel().put("para", para);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/sys/syspara/sysparaEdit");
		return mv;
	}
	
	/**
	 * 系统参数修改
	 * @return
	 */
	@RequestMapping(value = "/syspara/syspara/updateOneSysparaInfo")
	@ResponseBody
	public AjaxRes updateOneSysparaInfo(@RequestBody Sys_syspara sys_syspara) {
		Boolean b = false;
		try {
			b =sysparaService.updateOneSysparaInfo(SystemSession.getUserSession(),sys_syspara);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 系统参数列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/sys/syspara/selectSysparaPageTables")
	@ResponseBody
	public AjaxRes selectSysparaPageTables(@RequestBody PageTable pageTable) {
		//pageTable.setWheresql(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		try {
			pageTable=sysparaService.selectSysparaPageTables(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
}

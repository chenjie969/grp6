package com.zjm.oa.laborContract.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_laborContract;
import com.zjm.oa.laborContract.service.LaborContractService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
@Controller
@RequestMapping(value="/oa/laborContract")
public class LaborContractAction {

	@Resource
	private LaborContractService laborContractService;
	//加载页面表格
	@RequestMapping(value="/loadPage")
	public ModelAndView  loadpage(String staffcase_Id,String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("staffcase_Id", staffcase_Id);
		modeAndView.getModel().put("type",type);
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/laborContract/index");
		return modeAndView;
	}
	
	/**
	 * 
	 * 查询合同表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectContractTable")
	@ResponseBody
	public AjaxRes selectContractTable(@RequestBody PageTable<Hr_laborContract> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
		//	pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable =laborContractService.selectContractTable(pageTable);
			ar.setSucceed(pageTable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	/**
	 * 
	 * 查询详细劳动合同
	 * @param laborContractID
	 * @param operationType
	 * @return
	 */
	@RequestMapping(value="/selectOneContract")
	public ModelAndView selectOneContract(String laborContractID,String operationType){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Hr_laborContract laborContract = laborContractService.selectOneContract(laborContractID);
		mv.getModelMap().put("laborContract",laborContract);
		if ("update".equals(operationType)) {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/laborContract/laborContractUpdate");
		} else {
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/laborContract/laborContractView");
		}
		return mv;
	}
	
	/**
	 * 添加一份合同
	 * 
	 * @return
	 */
	
	@RequestMapping(value="/showLaborContractAdd")
	public ModelAndView showLaborContractAdd(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/laborContract/laborContractAdd");
		return mv;
	}
	
	@RequestMapping(value="/insertOneLaborContract")
	@ResponseBody
	public AjaxRes insertOneLaborContract(@RequestBody Hr_laborContract laborContract){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(laborContractService.insertOneLaborContract(SystemSession.getUserSession(), laborContract));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
    /**
     *  更新一份合同
     * 
     * @return
     */
	@RequestMapping(value="/showLaborContractUpdate")
	public ModelAndView showLaborContractUpdate(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/laborContract/laborContractUpdate");
		return mv;
	}
	
	@RequestMapping(value="/updateOneContract")
	@ResponseBody
	public AjaxRes updateOneContract(@RequestBody Hr_laborContract laborContract){
		AjaxRes ar = new AjaxRes();
		try{
			ar.setSucceed(laborContractService.updateOneContract(SystemSession.getUserSession(), laborContract));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
}

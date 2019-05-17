package com.zjm.crm.reportSy.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_reportSy;
import com.zjm.crm.reportSy.service.ReportSyService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
/**
 * 损益表action
 * @author zky  add 20170525
 *
 */
@Controller
@RequestMapping("/reportSy")
public class ReportSyAction {
	@Resource
	private ReportSyService reportSyService;
	@Resource
	private ClientService  clientService;
	
	@Resource
	private DicTypeService  dicTypeService;
	
	
	/**
	 * 损益表列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		StringBuffer wheresql = new StringBuffer();
		if(pageTable==null){
			return "";
		}
		 wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
	
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and reportTypeName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}	    
		if (pageTable.getQueryCondition().getClient_ID() != null && !"".equals(pageTable.getQueryCondition().getClient_ID())){
			wheresql.append(" and client_ID = \'"+pageTable.getQueryCondition().getClient_ID()+"\'");
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
			wheresql=wheresql.append(" ORDER BY "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"");
		}else{
			wheresql=wheresql.append(" ORDER BY reportTypeName desc,yearMonth desc");
		}		
		return wheresql.toString();
	}
	
	/**
	 * 打开现损益表新增信息页面
	 * @param String client_ID
	 * @return
	 */
	@RequestMapping(value="/openReportSyAddPage")
	public ModelAndView openReportSyAddPage(String client_ID){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/reportSy/reportSyAdd");
		List<C_dictype> reportTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='5048855d72fe4364af60245c3a4cb2d1'");//获取报表类型下拉框;
		mv.getModelMap().put("reportTypeList",reportTypeList);
		Client client = this.selectCompanyClientInfo(client_ID);
		mv.getModel().put("client",client);
		return mv;
	}
	
	/**
	 * 插入一个损益报表信息
	 * @param Crm_reportSy reportSy
	 * @return
	 */
	@RequestMapping(value="/insertOneReportSyInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneUserGroupInfo(@RequestBody Crm_reportSy reportSy){	
		Boolean b = false;
		if(reportSy != null){
			b = reportSyService.insertOneReportSyInfo(SystemSession.getUserSession(),reportSy);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 更新一个损益报表信息
	 * @param Crm_reportSy reportSy
	 * @return
	 */
	@RequestMapping(value="/updateOneReportSyInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneReportSyInfo(@RequestBody Crm_reportSy reportSy){
		Boolean b = false;
		if(reportSy != null){			
			b= reportSyService.updateOneReportSyInfo(SystemSession.getUserSession(),reportSy);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 返回损益报表信息分页列表数据
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectReportSyPageTables")
	@ResponseBody
	public AjaxRes selectReportSyPageTables(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<Crm_reportSy>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=reportSyService.selectReportSyPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 查看损益报表信息页面
	 * @param String reportSy_ID
	 * @return
	 */
	@RequestMapping(value="/selectReportSyViewPage")
	public ModelAndView selectReportSyViewPage(String reportSy_ID){		
			
		Crm_reportSy reportSy =	reportSyService.selectOneReportSyWhereSql(" and reportSy_ID = \'"+reportSy_ID+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
	    mv.setViewName("/crm/client/companyFinance/reportSy/reportSyInfo");
		mv.getModel().put("reportSy",reportSy);
		Client client = this.selectCompanyClientInfo(reportSy.getClient_ID());
		mv.getModel().put("client",client);		
		return mv;
	}
	
	
	//根据客户id和机构id 客户对象中的客户名称和编码;
	public Client selectCompanyClientInfo(String  client_ID){
		Client client = new Client ();
		client.setClient_ID(client_ID);
		client.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Client oneClient = clientService.selectOneClientInfo(client);
		return oneClient;
	}
	
	
	
	
	
	/**
	 * 打开修改损益报表信息页面
	 * @param String reportSy_ID
	 * @return
	 */
	@RequestMapping(value="/openReportSyEditPage")
	public ModelAndView openReportSyEditPage(String reportSy_ID){
		Crm_reportSy reportSy =	reportSyService.selectOneReportSyWhereSql(" and reportSy_ID = \'"+reportSy_ID+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/reportSy/reportSyEdit");
		mv.getModel().put("reportSy",reportSy);
		Client client = this.selectCompanyClientInfo(reportSy.getClient_ID());
		mv.getModel().put("client",client);
		return mv;
	}
	
	/**
	 * 删除一个损益表信息
	 * @param Crm_reportSy reportSy
	 * @return
	 */
	@RequestMapping(value="/delectOneReportSyInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneReportSyInfo(@RequestBody Crm_reportSy reportSy){
		reportSy.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= reportSyService.delectReportSyByWhereSql(SystemSession.getUserSession()," and reportSy_ID = \'"+reportSy.getReportSy_ID()+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 两期损益表对比
	 * @param String reportSy_IDArry[损益表_ID,损益表_ID,客户_ID]
	 * @return
	 */
	
	@RequestMapping(value="/reportSyCompare")
	public ModelAndView reportSyCompare(String reportSy_IDArry){		
		Crm_reportSy reportSy1 = new Crm_reportSy();				
		Crm_reportSy reportSy2 = new Crm_reportSy();
		Client client  = new Client();
		if(reportSy_IDArry != null ){			
			String[] reportSy_IDArr = reportSy_IDArry.split(",");
			reportSy1 = reportSyService.selectOneReportSyWhereSql(" and reportSy_ID = \'"+reportSy_IDArr[0]+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			reportSy2 = reportSyService.selectOneReportSyWhereSql(" and reportSy_ID = \'"+reportSy_IDArr[1]+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			client = this.selectCompanyClientInfo(reportSy_IDArr[2]);
		}		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
	    mv.setViewName("/crm/client/companyFinance/reportSy/reportSyCompare");
		mv.getModel().put("reportSy1",reportSy1);
		mv.getModel().put("reportSy2",reportSy2);		 
		mv.getModel().put("client",client);		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
}

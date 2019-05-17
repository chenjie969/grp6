package com.zjm.crm.reportXjl.web;

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
import com.zjm.crm.db.model.Crm_reportXjl;
import com.zjm.crm.reportXjl.service.ReportXjlService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
/**
 * 现金流表action
 * @author zky  add 20170525
 *
 */
@Controller
@RequestMapping("/reportXjl")
public class ReportXjlAction {
	@Resource
	private ReportXjlService reportXjlService;
	@Resource
	private ClientService  clientService;
	
	@Resource
	private DicTypeService  dicTypeService;
	
	
	/**
	 * 现金流表列表查询条件
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
	 * 打开现金流报表新增信息页面
	 * @param String client_ID
	 * @return
	 */
	@RequestMapping(value="/openReportXjlAddPage")
	public ModelAndView openReportXjlAddPage(String client_ID){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/reportXjl/reportXjlAdd");
		List<C_dictype> reportTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='5048855d72fe4364af60245c3a4cb2d1'");//获取报表类型下拉框;
		mv.getModelMap().put("reportTypeList", reportTypeList);
		Client client = this.selectCompanyClientInfo(client_ID);
		mv.getModel().put("client",client);
		return mv;
	}
	
	
	
	
	/**
	 * 插入一个现金流报表信息
	 * @param Crm_reportXjl reportXjl
	 * @return
	 */
	@RequestMapping(value="/insertOneReportXjlInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneUserGroupInfo(@RequestBody Crm_reportXjl reportXjl){		
		Boolean b = false;
		if(reportXjl != null){			
			b= reportXjlService.insertOneReportXjlInfo(SystemSession.getUserSession(),reportXjl);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 更新一个现金流报表信息
	 * @param Crm_reportXjl reportXjl
	 * @return
	 */
	@RequestMapping(value="/updateOneReportXjlInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneReportXjlInfo(@RequestBody Crm_reportXjl reportXjl){
		Boolean b = true;
		if(reportXjl != null){			
			b= reportXjlService.updateOneReportXjlInfo(SystemSession.getUserSession(),reportXjl);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 返回现金流报表信息分页列表数据
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectReportXjlPageTables")
	@ResponseBody
	public AjaxRes selectReportXjlPageTables(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<Crm_reportXjl>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=reportXjlService.selectReportXjlPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 查看现金流报表信息页面
	 * @param String reportXjl_ID
	 * @return
	 */
	@RequestMapping(value="/selectReportXjlViewPage")
	public ModelAndView selectReportXjlViewPage(String reportXjl_ID){		
		Crm_reportXjl reportXjl =reportXjlService.selectOneReportXjlWhereSql(" and reportXjl_ID = \'"+reportXjl_ID+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");	
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
	    mv.setViewName("/crm/client/companyFinance/reportXjl/reportXjlInfo");
		mv.getModel().put("reportXjl",reportXjl);
		Client client = this.selectCompanyClientInfo(reportXjl.getClient_ID());
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
	 * 打开修改现金流报表信息页面
	 * @param String reportXjl_ID
	 * @return
	 */
	@RequestMapping(value="/openReportXjlEditPage")
	public ModelAndView openReportXjlEditPage(String reportXjl_ID){
		Crm_reportXjl reportXjl =	reportXjlService.selectOneReportXjlWhereSql(" and reportXjl_ID = \'"+reportXjl_ID+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/reportXjl/reportXjlEdit");
		mv.getModel().put("reportXjl",reportXjl);
		Client client = this.selectCompanyClientInfo(reportXjl.getClient_ID());
		mv.getModel().put("client",client);
		return mv;
	}
	
	/**
	 * 删除一个现金流表信息
	 * @param Crm_reportXjl reportXjl
	 * @return
	 */
	@RequestMapping(value="/delectOneReportXjlInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneReportXjlInfo(@RequestBody Crm_reportXjl reportXjl){
		//reportXjl.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= reportXjlService.delectReportXjlByWhereSql(SystemSession.getUserSession()," and reportXjl_ID = \'"+reportXjl.getReportXjl_ID()+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 两期现金流表对比
	 * @param String reportXjl_IDArry
	 * @return
	 */
	
	@RequestMapping(value="/reportXjlCompare")
	public ModelAndView reportXjlCompare(String reportXjl_IDArry){		
		Crm_reportXjl reportXjl1 = new Crm_reportXjl();			
		Crm_reportXjl reportXjl2 = new Crm_reportXjl();
		Client client  = new Client();
		if(reportXjl_IDArry != null ){		
			String[] reportXjl_IDArr = reportXjl_IDArry.split(",");
			reportXjl1 = reportXjlService.selectOneReportXjlWhereSql(" and reportXjl_ID = \'"+reportXjl_IDArr[0]+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			reportXjl2 = reportXjlService.selectOneReportXjlWhereSql(" and reportXjl_ID = \'"+reportXjl_IDArr[1]+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			client = this.selectCompanyClientInfo(reportXjl_IDArr[2]);
		}		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
	    mv.setViewName("/crm/client/companyFinance/reportXjl/reportXjlCompare");
		mv.getModel().put("reportXjl1",reportXjl1);
		mv.getModel().put("reportXjl2",reportXjl2);		 
		mv.getModel().put("client",client);		
		return mv;
	}
	
}

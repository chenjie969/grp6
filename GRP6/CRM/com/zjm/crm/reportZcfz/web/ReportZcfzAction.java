package com.zjm.crm.reportZcfz.web;

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
import com.zjm.crm.db.model.Crm_reportZcfz;
import com.zjm.crm.reportZcfz.service.ReportZcfzService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
/**
 * 资产负债表action
 * @author zky  add 20170527
 *
 */
@Controller
@RequestMapping("/reportZcfz")
public class ReportZcfzAction {
	@Resource
	private ReportZcfzService reportZcfzService;
	@Resource
	private ClientService  clientService;
	
	@Resource
	private DicTypeService  dicTypeService;
	
	
	/**
	 * 资产负债表列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		StringBuffer wheresql = new StringBuffer();
		if(pageTable==null){
			return "";
		}
		 wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
	
		 if (null != pageTable.getSearchText()) {
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
	 * 插入一个资产负债报表信息
	 * @param Crm_reportZcfz reportZcfz
	 * @return
	 */
	@RequestMapping(value="/insertOneReportZcfzInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneReportZcfzInfo(@RequestBody Crm_reportZcfz reportZcfz){	
		Boolean b = false;
		if(reportZcfz != null){
			b= reportZcfzService.insertOneReportZcfzInfo(SystemSession.getUserSession(),reportZcfz);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 更新一个资产负债报表信息
	 * @param Crm_reportZcfz reportZcfz
	 * @return
	 */
	@RequestMapping(value="/updateOneReportZcfzInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneReportZcfzInfo(@RequestBody Crm_reportZcfz reportZcfz){
		Boolean b = false;
		if(reportZcfz != null){			
			b= reportZcfzService.updateOneReportZcfzInfo(SystemSession.getUserSession(),reportZcfz);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 返回资产负债报表信息分页列表数据
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectReportZcfzPageTables")
	@ResponseBody
	public AjaxRes selectReportZcfzPageTables(@RequestBody PageTable pageTable){
		if(pageTable==null){
			pageTable=new PageTable<Crm_reportZcfz>();
		}
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=reportZcfzService.selectReportZcfzPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 查看资产负债报表信息页面
	 * @param String reportZcfz_ID
	 * @return
	 */
	@RequestMapping(value="/selectReportZcfzViewPage")
	public ModelAndView selectReportZcfzViewPage(String reportZcfz_ID){		
			
		Crm_reportZcfz reportZcfz =	reportZcfzService.selectOneReportZcfzWhereSql(" and reportZcfz_ID = \'"+reportZcfz_ID+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
	    mv.setViewName("/crm/client/companyFinance/reportZcfz/reportZcfzInfo");
		mv.getModel().put("reportZcfz",reportZcfz);
		Client client = this.selectCompanyClientInfo(reportZcfz.getClient_ID());
		mv.getModel().put("client",client);		
		return mv;
	}
	
	/**
	 * 打开资产负债报表新增信息页面
	 * @param String client_ID
	 * @return
	 */
	@RequestMapping(value="/openReportZcfzAddPage")
	public ModelAndView openReportZcfzAddPage(String client_ID){	
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		List<C_dictype> reportTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='5048855d72fe4364af60245c3a4cb2d1'");//获取报表类型下拉框;
		mv.getModelMap().put("reportTypeList", reportTypeList);
		mv.setViewName("/crm/client/companyFinance/reportZcfz/reportZcfzAdd");
		Client client = this.selectCompanyClientInfo(client_ID);
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
	 * 打开修改资产负债报表信息页面
	 * @param String reportZcfz_ID
	 * @return
	 */
	@RequestMapping(value="/openReportZcfzEditPage")
	public ModelAndView openReportZcfzEditPage(String reportZcfz_ID){
		Crm_reportZcfz reportZcfz =	reportZcfzService.selectOneReportZcfzWhereSql(" and reportZcfz_ID = \'"+reportZcfz_ID+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/client/companyFinance/reportZcfz/reportZcfzEdit");
		mv.getModel().put("reportZcfz",reportZcfz);
		Client client = this.selectCompanyClientInfo(reportZcfz.getClient_ID());//获取客户名和编号;
		mv.getModel().put("client",client);
		return mv;
	}
	
	/**
	 * 删除一个资产负债表信息
	 * @param reportZcfz
	 * @return
	 */
	@RequestMapping(value="/delectOneReportZcfzInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneReportZcfzInfo(@RequestBody Crm_reportZcfz reportZcfz){
		reportZcfz.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= reportZcfzService.delectReportZcfzByWhereSql(SystemSession.getUserSession()," and reportZcfz_ID = \'"+reportZcfz.getReportZcfz_ID()+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 两期资产负债对比
	 * @param String reportZcfz_IDArry:[资产负债ID,资产负债ID,客户ID]
	 * @return
	 */
	@RequestMapping(value="/reportZcfzCompare")
	public ModelAndView reportZcfzCompare(String reportZcfz_IDArry){		
		Crm_reportZcfz reportZcfz1 = new Crm_reportZcfz();				
		Crm_reportZcfz reportZcfz2 = new Crm_reportZcfz();
		Client client  = new Client();
		if(reportZcfz_IDArry != null ){			
			String[] reportZcfz_IDArr = reportZcfz_IDArry.split(",");
			reportZcfz1 = reportZcfzService.selectOneReportZcfzWhereSql(" and reportZcfz_ID = \'"+reportZcfz_IDArr[0]+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			reportZcfz2 = reportZcfzService.selectOneReportZcfzWhereSql(" and reportZcfz_ID = \'"+reportZcfz_IDArr[1]+"\'"+" and  unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			client = this.selectCompanyClientInfo(reportZcfz_IDArr[2]);
		}		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
	    mv.setViewName("/crm/client/companyFinance/reportZcfz/reportZcfzCompare");
		mv.getModel().put("reportZcfz1",reportZcfz1);
		mv.getModel().put("reportZcfz2",reportZcfz2);		 
		mv.getModel().put("client",client);		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

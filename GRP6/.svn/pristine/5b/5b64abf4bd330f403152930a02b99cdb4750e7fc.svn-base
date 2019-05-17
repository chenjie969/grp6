package com.zjm.pro.arcTransfer.web;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.UrlParam;
import com.zjm.gbpm.db.model.Gbpm_dicNode;
import com.zjm.pro.arcTransfer.service.ArcTransferService;
import com.zjm.pro.db.model.Pro_arcTransfer;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
 * @author wzk
 * 档案移交
 */
@Controller
@RequestMapping(value="/project/arcTransfer")
public class ArcTransferAction {

	@Resource
	private ArcTransferService arcTransferService;
	
	/**
	 * @param proCheckPlan
	 * @return 档案移交
	 */
	@RequestMapping(value = "/arcTransfer")
	public ModelAndView selectCheckRegister() {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/arccTransfer/arcTransfer");
		return mv;
	}
	/**
	 * 分页查询档案移交列表
	 */
	@RequestMapping(value="/selectTransferRecordsTable")
	@ResponseBody
	public AjaxRes selectTransferRecordsPageTable(@RequestBody PageTable<Pro_arcTransfer> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = arcTransferService.selectTransferRecordsPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryConditionSql(PageTable<Pro_arcTransfer> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		String apply_ID = pageTable.getQueryCondition().getApply_ID();
		if(null != apply_ID){
			wheresql.append(" and apply_ID = \'"+apply_ID+"\'");
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and nodeNames like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql.append(" order by "+pageTable.getSortName().trim());
		}else{
			wheresql.append(" ORDER BY updateDateTime DESC ");
		}
		return wheresql.toString();
	}
	
}

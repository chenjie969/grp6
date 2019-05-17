package com.zjm.pro.returnDetail.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.pro.db.model.Pro_replace;
import com.zjm.pro.db.model.Pro_returnDetail;
import com.zjm.pro.replace.service.ReplaceService;
import com.zjm.pro.returnDetail.service.ReturnDetailService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;


@Controller
@RequestMapping(value="/project/returnDetail")
public class ReturnDetailAction{
	@Resource
	private ReturnDetailService returnDetailService;
	
	/**
	 * 添加页面--追偿情况
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnDetailAddPage")
	public ModelAndView returnDetailAddPage(String project_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.getModel().put("project_ID",project_ID);
		mv.setViewName("/project/replacePro/returnDetailAdd");
		return mv;
	}
	/**
	 * 修改页面--追偿情况
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnDetailEditPage")
	public ModelAndView returnDetailEditPage(String returnDetail_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_returnDetail returnDetail = returnDetailService.selectOneReturnDetailInfo(" and returnDetail_ID = \'"+returnDetail_ID+"\'");
		mv.getModel().put("returnDetail",returnDetail);
		mv.setViewName("/project/replacePro/returnDetailEdit");
		return mv;
	}
	
	/**
	 * insertOneReplace
	 * 新增代偿登记;
	 * 
	 */
	@RequestMapping(value="/insertOneReturnDetailInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneReplace(@RequestBody Pro_returnDetail pro_returnDetail){
		Boolean b = true;	
		if(pro_returnDetail != null){		
			try {
				b=returnDetailService.insertOneReturnDetailInfo(SystemSession.getUserSession(),pro_returnDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 修改追偿信息;
	 * 
	 */
	@RequestMapping(value="/updateOneReturnDetailInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneReturnDetailInfo(@RequestBody Pro_returnDetail pro_returnDetail){
		Boolean b = true;	
		if(pro_returnDetail != null){		
			try {
				b=returnDetailService.updateOneReturnDetailInfo(SystemSession.getUserSession(),pro_returnDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 分页查询追偿列表
	 */
	@RequestMapping(value="/selectReturnDetailPageTable")
	@ResponseBody
	public AjaxRes selectReturnDetailPageTable(@RequestBody PageTable<Pro_returnDetail> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = returnDetailService.selectReturnDetailPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_returnDetail> pageTable){
		if(pageTable==null){
			StringBuffer wheresql = new StringBuffer();
			wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		if (pageTable.getWheresql() != null) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		return wheresql.toString();
	}
}
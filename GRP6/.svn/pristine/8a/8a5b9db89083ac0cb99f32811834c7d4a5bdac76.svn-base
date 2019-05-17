package com.zjm.crm.materialDetail.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_materialDetail;
import com.zjm.crm.db.model.Crm_materialTree;
import com.zjm.crm.materialDetail.service.MaterialDetailService;
import com.zjm.crm.materialModel.service.MaterialModelService;
import com.zjm.crm.materialTree.service.MaterialTreeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;	

@Controller  
@RequestMapping(value="/client/materialDetail")
public class MaterialDetailAction {

	
	@Resource
	private MaterialTreeService materialTreeService;
	@Resource
	private MaterialModelService materialModelService;
	@Resource
	private MaterialDetailService materialDetailService;
		
	/**
	 * 跳转到客户资料新增页面
	 * @param materialTree_ID
	 * returnMaterialDetailAddPage
	 * @return
	 */
	@RequestMapping(value="/returnMaterialDetailAddPage")
	public ModelAndView returnMaterialDetailAddPage(Crm_materialDetail crm_materialDetail){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();		
		if(null != crm_materialDetail.getMaterialTree_ID()){
			Crm_materialTree materialTree = materialTreeService.selectOneMaterialTreeByWhereSql(" and materialTree_ID = \'"+crm_materialDetail.getMaterialTree_ID()+"\'");
			mv.getModelMap().put("materialTree",materialTree);
		}
		mv.setViewName("/crm/client/clientMaterialSet/materialDetailAdd");
		return mv;
	}	
	/**insertOneMaterialDetail
	 *新增一条客户资料
	 */
	@RequestMapping(value="/insertOneMaterialDetail")
	@ResponseBody
	public AjaxRes insertOneMaterialDetail(@RequestBody Crm_materialDetail crm_materialDetail){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			b = materialDetailService.insertOneMaterialDetail(SystemSession.getUserSession(), crm_materialDetail);
			if(b){
			   b = true;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 客户资料分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectMaterialDetailPageTable")
	@ResponseBody
	public AjaxRes selectMaterialDetailPageTable(@RequestBody PageTable<Crm_materialDetail> pageTable) {
		try {
			pageTable.setWheresql(queryConditionSql(pageTable));
			pageTable=materialDetailService.selectMaterialDetailPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 条件查询
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable<Crm_materialDetail> pageTable){
		String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and materialName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		
		//根据传入的客户资料模板ID或客户资料类型树ID获取任务事项
		if(pageTable.getQueryCondition().getMaterialModel_ID()!=null && !pageTable.getQueryCondition().getMaterialModel_ID().equals("") ){
			wheresql=wheresql+" and materialModel_ID =\'"+pageTable.getQueryCondition().getMaterialModel_ID().trim()+"\'";
		}else if (pageTable.getQueryCondition().getMaterialTree_ID()!=null && !pageTable.getQueryCondition().getMaterialTree_ID().equals("")){
			wheresql=wheresql+" and materialTree_ID =\'"+pageTable.getQueryCondition().getMaterialTree_ID().trim()+"\'";
		}
		return wheresql;
	}
	/**
	 * materialDetailViewPage
	 * 跳转到客户资料清单查看页面
	 */
	@RequestMapping(value="/materialDetailViewPage")
	public ModelAndView materialDetailViewPage(Crm_materialDetail crm_materialDetail){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Crm_materialDetail materialDetail = new Crm_materialDetail();
		if(null != crm_materialDetail.getMaterialDetail_ID()){
			String  materialDetail_ID = " and materialDetail_ID = \'"+crm_materialDetail.getMaterialDetail_ID()+"\'";
			materialDetail  = materialDetailService.selectOneMaterialDetailByWheresql(materialDetail_ID);
		}
		mv.getModelMap().put("materialDetail",materialDetail);
		mv.setViewName("/crm/client/clientMaterialSet/materialDetailInfo");
		return mv;
	}
	/**
	 * deleteOneMaterialDetail
	 * 删除一个客户资料清单
	 * @param  
	 * @return
	 */
	@RequestMapping(value="/deleteOneMaterialDetail", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneMaterialDetail(@RequestBody Crm_materialDetail crm_materialDetail){
		crm_materialDetail.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= materialDetailService.deleteOneMaterialDetail(SystemSession.getUserSession(),crm_materialDetail);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 跳转到客户资料修改页面
	 * @param materialDetail_ID
	 * returnMaterialDetailEditPage
	 * @return
	 */
	@RequestMapping(value="/returnMaterialDetailEditPage")
	public ModelAndView returnMaterialDetailEditPage(Crm_materialDetail crm_materialDetail){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();		
		if(null != crm_materialDetail.getMaterialDetail_ID()){
			Crm_materialDetail materialDetail = materialDetailService.selectOneMaterialDetailByWheresql(" and materialDetail_ID = \'"+crm_materialDetail.getMaterialDetail_ID()+"\'");
			mv.getModelMap().put("materialDetail",materialDetail);
		}
		mv.setViewName("/crm/client/clientMaterialSet/materialDetailEdit");
		return mv;
	}
	/**
	 * updateOneMaterialDetail
	 * 更新客户资料;
	 * 
	 */
	@RequestMapping(value="/updateOneMaterialDetail", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneMaterialDetail(@RequestBody Crm_materialDetail crm_materialDetail){
		Boolean b = true;	
		if(crm_materialDetail  != null){		
			try {
				b = materialDetailService.updateOneMaterialDetail(SystemSession.getUserSession(), crm_materialDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	/**
	 * 查询一个客户资料类型下所有的客户资料名称  用于顺序调整
	 * @return
	 */
	@RequestMapping(value="/sortMaterialDetail", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView sortMaterialDetail(Crm_materialDetail crm_materialDetail){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			crm_materialDetail.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql = wheresql + " and materialTree_ID = \'" + crm_materialDetail.getMaterialTree_ID() +"\' ORDER BY order_id";
			List<Crm_materialDetail>  materialDetailList=materialDetailService.selectMaterialDetailListByWheresql(wheresql);
			
			mv.getModel().put("materialDetailList", materialDetailList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/crm/client/clientMaterialSet/materialDetailSort");
		return mv;
		
	}
	
	/**
	 * updateSortMaterialDetail
	 * 更新客户资料名称顺序;
	 * 
	 */
	@RequestMapping(value="/updateSortMaterialDetail", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateSortMaterialDetail(@RequestBody Crm_materialDetail crm_materialDetail){
		Boolean b = true;	
		if(crm_materialDetail  != null){		
			try {
				b = materialDetailService.updateOneMaterialDetail(SystemSession.getUserSession(), crm_materialDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 查询客户资料名称json
	 * @param Crm_materialDetail
	 * @return
	 */
	@RequestMapping(value="/selectMaterialDetailListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectMaterialDetailListJSON(@RequestBody Crm_materialDetail crm_materialDetail){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		if(crm_materialDetail!=null){
			if(crm_materialDetail.getMaterialTree_ID()!=null){
				wheresql=wheresql+" and materialTree_ID = \'"+ crm_materialDetail.getMaterialTree_ID()+"\' ORDER BY order_id ";
			}
		}
		List<Crm_materialDetail> materialDetailList = materialDetailService.selectMaterialDetailListByWheresql(wheresql);
		for (Crm_materialDetail crm_materialDetail2 : materialDetailList) {
			map = new HashMap<String, String>();
			map.put(crm_materialDetail2.getMaterialDetail_ID(), crm_materialDetail2.getMaterialName());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	
}

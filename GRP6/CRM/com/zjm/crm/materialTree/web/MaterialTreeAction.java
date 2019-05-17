package com.zjm.crm.materialTree.web;

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
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Crm_materialModel;
import com.zjm.crm.db.model.Crm_materialTree;
import com.zjm.crm.materialDetail.service.MaterialDetailService;
import com.zjm.crm.materialModel.service.MaterialModelService;
import com.zjm.crm.materialTree.service.MaterialTreeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller  
@RequestMapping(value="/client/materialTree")
public class MaterialTreeAction {

	@Resource
	private ClientService clientService;
	
	@Resource
	private MaterialTreeService materialTreeService;
	@Resource
	private MaterialModelService materialModelService;
	@Resource
	private MaterialDetailService materialDetailService;
		
		
	/**
	 * selectMaterialTreeByModelID
	 * 查询一个模板所有的节点  树形显示出来
	 * @return
	 */
	@RequestMapping(value="/selectMaterialTreeByModelID", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectMaterialTreeByModelID(Crm_materialModel crm_materialModel){
		List<Map<String, Object>> mapList;
		mapList = new ArrayList<Map<String,Object>>();
		try {
			Crm_materialModel materialModel = materialModelService.selectOneMaterialModelByWheresql(" and materialModel_ID= \'"+crm_materialModel.getMaterialModel_ID()+"\'");			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", materialModel.getMaterialModel_ID());
			map.put("pId", "1");
			map.put("name", materialModel.getMaterialModelName());
			mapList.add(map);
			map.put("open",true);
			materialModel.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql = wheresql + " and materialModel_ID = \'" + materialModel.getMaterialModel_ID() +"\' order by order_id ";			
			List<Crm_materialTree> materialTreeList = null;
			try {
				materialTreeList = materialTreeService.selectMaterialTreeList(wheresql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (Crm_materialTree crm_materialTree : materialTreeList) {
				map = new HashMap<String, Object>();
				map.put("id", crm_materialTree.getMaterialTree_ID());
				map.put("pId", crm_materialTree.getPmaterialTree_ID());
				map.put("name", crm_materialTree.getMaterialTreeName());
				mapList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 *  跳转到客户资料类型添加页面
	 * returnMaterialTreeAddPage
	 * @return
	 */
	@RequestMapping(value="/returnMaterialTreeAddPage")
	public ModelAndView returnMaterialTreeAddPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();		
		mv.setViewName("/crm/client/clientMaterialSet/materialTreeAdd");
		return mv;
	}
	/**
	 * 跳转到客户资料类型修改页面
	 * returnMaterialTreeEditPage
	 * @return
	 */
	@RequestMapping(value="/returnMaterialTreeEditPage")
	public ModelAndView returnMaterialTreeEditPage(Crm_materialTree crm_materialTree){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();	
		if(null != crm_materialTree.getMaterialTree_ID()){
			Crm_materialTree materialTree = materialTreeService.selectOneMaterialTreeByWhereSql(" and materialTree_ID = \'"+crm_materialTree.getMaterialTree_ID()+"\'");
			mv.getModelMap().put("materialTree",materialTree);
		}
		mv.setViewName("/crm/client/clientMaterialSet/materialTreeEdit");
		return mv;
	}
	/**
	 *新增一条客户资料清单模板
	 */
	@RequestMapping(value="/insertOneMaterialTree")
	@ResponseBody
	public AjaxRes insertOneMaterialTree(@RequestBody Crm_materialTree crm_materialTree){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			b = materialTreeService.insertOneMaterialTree(SystemSession.getUserSession(), crm_materialTree);
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
	 * 添加时判断客户资料类型名称是否重复
	 * isExistMaterialTree
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/isExistMaterialTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes isExistMaterialTree(@RequestBody Crm_materialTree crm_materialTree){
		String wheresql="";
		if(crm_materialTree!=null){
			if(crm_materialTree.getMaterialTreeName()!=null){
				wheresql=wheresql+" and materialTreeName = \'"+((String) crm_materialTree.getMaterialTreeName()).trim()+"\'";
				wheresql +="and pmaterialTree_ID = \'"+crm_materialTree.getPmaterialTree_ID()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=materialTreeService.isExistMaterialTree(wheresql);
		if(b){//存在置为false
			b=false;
		}else{
			b=true;
		}
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * updateOneaterialTree
	 * 更新客户资料类型;
	 * 
	 */
	@RequestMapping(value="/updateOneaterialTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneaterialTree(@RequestBody Crm_materialTree crm_materialTree){
		Boolean b = true;	
		if(crm_materialTree  != null){		
			try {
				b = materialTreeService.updateOneaterialTree(SystemSession.getUserSession(), crm_materialTree);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * updateSortMaterialTree
	 * 更新客户资料类型顺序;
	 * 
	 */
	@RequestMapping(value="/updateSortMaterialTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateSortMaterialTree(@RequestBody Crm_materialTree crm_materialTree){
		Boolean b = true;	
		if(crm_materialTree  != null){		
			try {
				b = materialTreeService.updateOneaterialTree(SystemSession.getUserSession(), crm_materialTree);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	
	/**
	 * deleteOneMaterialTree
	 * 删除一个客户资料类型
	 * @param  
	 * @return
	 */
	@RequestMapping(value="/deleteOneMaterialTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneMaterialTree(@RequestBody Crm_materialTree crm_materialTree){
		crm_materialTree.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= materialTreeService.deleteOneMaterialTree(SystemSession.getUserSession(),crm_materialTree);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询一个客户资料类型下所有的节点  用于顺序调整
	 * @return
	 */
	@RequestMapping(value="/sortMaterialTree", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView sortMaterialTree(Crm_materialTree crm_materialTree){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			crm_materialTree.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql = wheresql + " and pmaterialTree_ID = \'" + crm_materialTree.getPmaterialTree_ID() +"\' ORDER BY order_id";
			List<Crm_materialTree>  materialTreeList=materialTreeService.selectMaterialTreeByWhereSqL(wheresql);
			mv.getModel().put("materialTreeList", materialTreeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/crm/client/clientMaterialSet/materialTreeSort");
		return mv;
		
	}
	/**
	 * 查询客户资料类型json
	 * @param crm_materialTree
	 * @return
	 */
	@RequestMapping(value="/selectMaterialTreeListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectMaterialTreeListJSON(@RequestBody Crm_materialTree crm_materialTree){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		if(crm_materialTree!=null){
			if(crm_materialTree.getPmaterialTree_ID()!=null){
				wheresql=wheresql+" and pmaterialTree_ID = \'"+ crm_materialTree.getPmaterialTree_ID()+"\' ORDER BY order_id ";
			}
		}
		List<Crm_materialTree>  materialTreeList=materialTreeService.selectMaterialTreeList(wheresql);
		for (Crm_materialTree crm_materialTree2 : materialTreeList) {
			map = new HashMap<String, String>();
			map.put(crm_materialTree2.getMaterialTree_ID(), crm_materialTree2.getMaterialTreeName());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
}

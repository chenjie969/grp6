package com.zjm.gbpm.dicNode.web;


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
import com.zjm.gbpm.db.model.Gbpm_dicNode;
import com.zjm.gbpm.db.model.Gbpm_dicTaskManager;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.dicNode.service.DicNodeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/gbpm/dicNode")
public class DicNodeAction {

	@Resource
	private DicNodeService dicNodeService;
	/**
	 *  显示页面-分页查询节点列表
	 */
	@RequestMapping(value="/showDicNodePageTable")
	//@ResponseBody
	public ModelAndView showTaskManagerPageTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/dicnode/dicNodeIndex");
		return mv;
	}
	
	/**
	 * 返回页面 查询所有的节点  用于顺序调整
	 * @return
	 */
	@RequestMapping(value="/selectAllDicNode", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView selectAllDicNode(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Gbpm_dicNode dicNode = new Gbpm_dicNode();
			dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			List<Gbpm_dicNode>  dicNodeList=dicNodeService.selectAllNodeList(dicNode);
			mv.getModel().put("dicNodeList", dicNodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/dicnode/dicNodeSort");
		return mv;
		
	}
	
	/**
	 * 分页查询节点列表
	 */
	@RequestMapping(value="/selectDicNodePageTable")
	@ResponseBody
	public AjaxRes selectTaskManagerPageTable(@RequestBody PageTable<Gbpm_dicNode> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			pageTable = dicNodeService.selectDicNodePageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Gbpm_dicNode> pageTable){
		if(pageTable==null){
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and nodeNames like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql.append(" order by "+pageTable.getSortName().trim()+",updatedatetime");
		}else{
			wheresql.append(" ORDER BY updateDateTime DESC ");
		}
		return wheresql.toString();
	}
	/**
	 *  显示页面-新增一条节点
	 */
	@RequestMapping(value="/showDicNodeAddPage")
	public ModelAndView showTaskManagerAddPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/dicnode/dicNodeAdd");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条节点
	 */
	@RequestMapping(value="/insertOneDicNode")
	@ResponseBody
	public AjaxRes insertOneDicNode(@RequestBody Gbpm_dicNode dicNode){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(dicNodeService.insertOneDicNode(SystemSession.getUserSession(), dicNode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面-修改一条节点
	 */
	@RequestMapping(value="/showDicNodeEditPage")
	public ModelAndView showDicNodeEditPage(Gbpm_dicNode dicNode){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			dicNode = dicNodeService.selectOneDicNode(dicNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("dicNode",dicNode);
		mv.setViewName("/gbpm/product/dicnode/dicNodeEdit");
		return mv;
	}
	
	/**
	 *  执行操作-修改一条节点
	 */
	@RequestMapping(value="/updateOneDicNode")
	@ResponseBody
	public AjaxRes updateOneDicNode(@RequestBody Gbpm_dicNode dicNode){
		AjaxRes ar = new AjaxRes();
		dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		dicNode.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
		try {
			ar.setSucceed(dicNodeService.updateOneDicNode(SystemSession.getUserSession(), dicNode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面-查看一条节点
	 */
	@RequestMapping(value="/showDicNodeViewPage")
	public ModelAndView showDicNodeViewPage(Gbpm_dicNode dicNode){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			dicNode = dicNodeService.selectOneDicNode(dicNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.getModelMap().put("dicNode",dicNode);
		mv.setViewName("/gbpm/product/dicnode/dicNodeView");
		return mv;
	}
	
	/**
	 * 显示页面-删除一条节点
	 */
	@RequestMapping(value="/showDicNodeDelPage")
	public ModelAndView showDicNodeDelPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/dicnode/dicNodeDel");
		return mv;
	}
	
	/**
	 *  执行操作-删除一条节点
	 */
	@RequestMapping(value="/deleteOneDicNodeDel")
	@ResponseBody
	public AjaxRes deleteOneDicNode(@RequestBody Gbpm_dicNode dicNode){
		AjaxRes ar = new AjaxRes();
		dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			ar.setSucceed(dicNodeService.deleteOneDicNode(SystemSession.getUserSession(), dicNode));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 新增/修改时判断节点名称是否存在
	 */
	@RequestMapping(value="/isExistNodeNames")
	@ResponseBody
	public AjaxRes isExistNodeNames(@RequestBody Gbpm_dicNode dicNode){
		AjaxRes ar = new AjaxRes();
		dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			ar.setSucceed(dicNodeService.isExistDicNodeNames(dicNode));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 新增/修改时判断节点编号是否存在
	 */
	@RequestMapping(value="/isExistNodeCode")
	@ResponseBody
	public AjaxRes isExistNodeCode(@RequestBody Gbpm_dicNode dicNode){
		AjaxRes ar = new AjaxRes();
		dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		ar.setSucceed(dicNodeService.isExistNodeCode(dicNode));
		return ar;
	}
	
	/***
	 * 节点树形多选方法
	 * @return
	 */
	@RequestMapping(value="/selectNodeTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectNodeTree(){
		AjaxRes ar=new AjaxRes();
		try {
			List<Map<String, Object>> list=dicNodeService.selectNodeTree(SystemSession.getUserSession());
			ar.setSucceed(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
}

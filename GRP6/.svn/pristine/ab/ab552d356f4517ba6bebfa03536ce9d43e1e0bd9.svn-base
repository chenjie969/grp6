package com.zjm.gbpm.productNode.web;

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
import com.zjm.gbpm.db.model.Gbpm_dicNode;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.dicNode.service.DicNodeService;
import com.zjm.gbpm.product.service.ProductService;
import com.zjm.gbpm.productNode.service.ProductNodeService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

import jatools.component.chart.servlet.barApp;

@Controller
@RequestMapping(value="/gbpm/productNode")
public class ProductNodeAction{
	
	@Resource
	private ProductService productService;
	@Resource
	private ProductNodeService productNodeService;
	@Resource
	private DicNodeService dicNodeService;
	@Resource
	private DepartsService departsService;
	@Resource
	private ProjectApplyService projectApplyService;
	
	/**
	 * 返回节点设置页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/productNodePage")
	public ModelAndView productNodePage(Gbpm_product product){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Gbpm_product product2 = productService.selectOneProductInfo(product);
			mv.getModel().put("product", product2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/productNode");
		return mv;
	}
	
	/**
	 * 返回设置节点下任务事项办理人页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/setNodeTaskPage")
	public ModelAndView setNodeTaskPage(Gbpm_productNode productNode){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Gbpm_product product = new Gbpm_product();
			product.setProduct_ID(productNode.getProductID());
			product = productService.selectOneProductInfo(product);
			String wheresql = " and apply_ID = \'" + productNode.getEntityID() + "\'";
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(wheresql);
			wheresql = " and productID = \'" + product.getProduct_ID() + "\'";
			wheresql =wheresql + " and nodeSort = \'" + (productNode.getNodeSort()+1) + "\'";
			productNode = productNodeService.selectOneProductNodeInfo(wheresql);
			Sys_departs departs = new Sys_departs();
			departs.setDepart_uid(SystemSession.getUserSession().getDepart_uid());
			departs = departsService.selectOneDepartsInfo(departs);
			mv.getModel().put("apply", apply);
			mv.getModel().put("product", product);
			mv.getModel().put("productNode", productNode);
			mv.getModel().put("departs", departs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/project/setNodeTask/nodeTaskModal");
		return mv;
	}
	
	/**
	 * 查询一个流程下所有的节点  用于顺序调整
	 * @return
	 */
	@RequestMapping(value="/sortProudctNode", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView sortProudctNode(Gbpm_product product){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql = wheresql + " and productID = \'" + product.getProduct_ID() +"\' ORDER BY nodeSort";
			List<Gbpm_productNode>  productNodeList=productNodeService.selectProductNodeListByProductID(wheresql);
			mv.getModel().put("productNodeList", productNodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/productNodeSort");
		return mv;
		
	}
	
	/**
	 * 查询一个流程下所有的节点  树形显示出来
	 * @return
	 */
	@RequestMapping(value="/selectProductNodeListByProductID", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectProductNodeListByProductID(Gbpm_product product){
		List<Map<String, Object>> mapList;
		mapList = new ArrayList<Map<String,Object>>();
		try {
			product = productService.selectOneProductInfo(product);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", product.getProduct_ID());
			map.put("pId", "1");
			map.put("name", product.getProductName());
			mapList.add(map);
			map.put("open",true);
			product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql = wheresql + " and productID = \'" + product.getProduct_ID() +"\' ORDER BY nodeSort";
			List<Gbpm_productNode>  productNodeList=productNodeService.selectProductNodeListByProductID(wheresql);
			for (Gbpm_productNode productNode : productNodeList) {
				map = new HashMap<String, Object>();
				map.put("id", productNode.getProductNode_ID());
				map.put("pId", product.getProduct_ID());
				map.put("name", productNode.getNodeNames());
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
	 * 返回添加节点页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/addProductNodePage")
	public ModelAndView addProductNodePage(Gbpm_product product){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Gbpm_product product2 = productService.selectOneProductInfo(product);
			Gbpm_dicNode dicNode = new Gbpm_dicNode();
			dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			List<Gbpm_dicNode> nodeList = dicNodeService.selectAllNodeList(dicNode);
			mv.getModel().put("nodeList", nodeList);
			mv.getModel().put("product", product2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/productNodeAdd");
		return mv;
	}
	
	/**
	 * 返回批量添加节点页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/addMuchProductNodePage")
	public ModelAndView addMuchProductNodePage(Gbpm_product product){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			Gbpm_product product2 = productService.selectOneProductInfo(product);
			Gbpm_dicNode dicNode = new Gbpm_dicNode();
			dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			List<Gbpm_dicNode> nodeList = dicNodeService.selectAllNodeList(dicNode);
			mv.getModel().put("nodeList", nodeList);
			mv.getModel().put("product", product2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/productNodeMuchAdd");
		return mv;
	}
	
	/**
	 * 返回修改节点页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/editProductNodePage")
	public ModelAndView editProductNodePage(Gbpm_productNode productNode){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try {
			String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
			wheresql = wheresql + " and productNode_ID = \'" + productNode.getProductNode_ID() +"\'";
			productNode = productNodeService.selectOneProductNodeInfo(wheresql);
			Gbpm_product product = new Gbpm_product();
			product.setProduct_ID(productNode.getProductID());
			product = productService.selectOneProductInfo(product);
			Gbpm_dicNode dicNode = new Gbpm_dicNode();
			dicNode.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			List<Gbpm_dicNode> nodeList = dicNodeService.selectAllNodeList(dicNode);
			mv.getModel().put("nodeList", nodeList);
			mv.getModel().put("product", product);
			mv.getModel().put("productNode", productNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/gbpm/product/product/productNodeEdit");
		return mv;
	}
	
	/**
	 *  执行操作-新增一条节点
	 */
	@RequestMapping(value="/insertOneProductNode")
	@ResponseBody
	public AjaxRes insertOneProductNode(@RequestBody Gbpm_productNode productNode){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			String[] nodeIDs = productNode.getNodeID().split(",");
			String[] nodeNames = productNode.getNodeNames().split(",");
			for (int i = 0; i < nodeIDs.length; i++) {
				Gbpm_dicNode dicNode = new Gbpm_dicNode();
				dicNode.setNode_ID(nodeIDs[i]);
				dicNode = dicNodeService.selectOneDicNode(dicNode);
				productNode.setNodeCode(dicNode.getNodeCode());
				productNode.setNodeID(nodeIDs[i]);
				productNode.setNodeNames(nodeNames[i]);
				b = productNodeService.insertOneProductNode(SystemSession.getUserSession(), productNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 *  执行操作-修改一条节点
	 */
	@RequestMapping(value="/updateOneProductNodeInfo")
	@ResponseBody
	public AjaxRes updateOneProductNodeInfo(@RequestBody Gbpm_productNode productNode){
		AjaxRes ar = new AjaxRes();
		Boolean b = false;
		try {
			Gbpm_dicNode dicNode = new Gbpm_dicNode();
			dicNode.setNode_ID(productNode.getNodeID());
			dicNode = dicNodeService.selectOneDicNode(dicNode);
			productNode.setNodeCode(dicNode.getNodeCode());
			b = productNodeService.updateOneProductNodeInfo(SystemSession.getUserSession(), productNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 *  执行操作-删除一条节点
	 */
	@RequestMapping(value="/deleteOneProductNode")
	@ResponseBody
	public AjaxRes deleteOneProductNode(@RequestBody Gbpm_productNode productNode){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(productNodeService.deleteOneProductNode(SystemSession.getUserSession(), productNode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 *  执行操作-修改节点顺序
	 */
	@RequestMapping(value="/updateSortProductNode")
	@ResponseBody
	public AjaxRes updateSortProductNode(@RequestBody Gbpm_productNode productNode){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(productNodeService.updateOneProductNode(SystemSession.getUserSession(), productNode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
}
package com.zjm.gbpm.productInstance.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.UrlParam;
import com.zjm.gbpm.db.model.Gbpm_finishNode;
import com.zjm.gbpm.db.model.Gbpm_productInstance;
import com.zjm.gbpm.db.model.Gbpm_productNode;
import com.zjm.gbpm.finishNode.service.FinishNodeService;
import com.zjm.gbpm.productInstance.service.ProductInstanceService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
/**
 * 
 * @author chenyang
 * 产品实例action
 */

@Controller
@RequestMapping(value="/gbpm/productInstance")
public class ProductInstanceAction {
	@Resource
	private ProductInstanceService productInstanceService;
	@Resource
	private FinishNodeService finishNodeService;
	
	/**
	 *  执行操作-同意立项-新增一条产品流程
	 */
	@RequestMapping(value="/insertOneProductInstanceInfo")
	@ResponseBody
	public AjaxRes insertOneProductInstanceInfo(@RequestBody Gbpm_productInstance productInstance){
		AjaxRes ar = new AjaxRes();
		try {
			//如果productInstance_ID为空  是流程实例化
			if (productInstance.getProductInstance_ID()==null || productInstance.getProductInstance_ID().equals("")){
				productInstanceService.insertOneProductInstanceInfo(SystemSession.getUserSession(), productInstance);
			}else {
				productInstanceService.nextStep(SystemSession.getUserSession(),productInstance);
			}
			ar.setSucceed(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 *  查询产品流程模板是否被实例化
	 */
	@RequestMapping(value="/isExistProductInstance")
	@ResponseBody
	public AjaxRes isExistProductInstance(@RequestBody Gbpm_productInstance productInstance){
		AjaxRes ar = new AjaxRes();
		String wheresql = " ";
		if (productInstance.getProductID()!=null) {
			wheresql = " and productID = \'" + productInstance.getProductID() + "\'";
		}
		if (productInstance.getEntityID()!=null) {
			wheresql = " and entityID = \'" + productInstance.getEntityID() + "\'";
		}
		try {
			ar.setSucceed(!productInstanceService.isExistProductInstance(wheresql));
		} catch (Exception e) {
			e.printStackTrace();
			ar.setSucceed(true);
		}
		return ar;
	}
	
	/**
	 *  流程实例环节退回
	 */
	@RequestMapping(value="/backStep")
	@ResponseBody
	public AjaxRes backStep(@RequestBody Gbpm_productInstance productInstance){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(productInstanceService.backStep(SystemSession.getUserSession(),productInstance));
		} catch (Exception e) {
			e.printStackTrace();
			ar.setSucceed(true);
		}
		return ar;
	}
	
	/**
	 *  流程实例重新提交到退回环节
	 */
	@RequestMapping(value="/returnBackNode")
	@ResponseBody
	public AjaxRes returnBackNode(@RequestBody Gbpm_productInstance productInstance){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(productInstanceService.returnBackNode(SystemSession.getUserSession(),productInstance));
		} catch (Exception e) {
			e.printStackTrace();
			ar.setSucceed(true);
		}
		return ar;
	}
	
	/**
	 * 分页查询我发起的产品流程列表
	 */
	@RequestMapping(value="/selectProductMyBuildInstancePageTable")
	@ResponseBody
	public AjaxRes selectProductMyBuildInstancePageTable(@RequestBody PageTable<Gbpm_productInstance> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable)+" and createUserID = \'" + SystemSession.getUserSession().getUser_uid() + "\'");
		try {
			pageTable = productInstanceService.selectProductMyBuildInstancePageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页查询我参与的产品流程列表
	 */
	@RequestMapping(value="/selectProductMyJoinInstancePageTable")
	@ResponseBody
	public AjaxRes selectProductMyInstancePageTable(@RequestBody PageTable<Gbpm_productInstance> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = productInstanceService.selectProductMyJoinInstancePageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Gbpm_productInstance> pageTable){
		StringBuffer wheresql = new StringBuffer();
		if ( null != pageTable.getWheresql()) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and productName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();
	}
	
	/**
	 *流程退回页面
	 */
	@RequestMapping(value="/backNodeTaskPage")
	public ModelAndView backNodeTaskPage(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String wheresql=" and productInstanceID=\'"+urlParam.getProductInstanceID()+"\'";
		wheresql = wheresql + " and nodeSort < \'" + urlParam.getNodeSort() +"\' ORDER BY nodeSort ASC";
		List<Gbpm_finishNode> finishNodeList = finishNodeService.selectFinishNodeListByWheresql(wheresql);
		mv.getModel().put("finishNodeList", finishNodeList);
		mv.setViewName("/project/apply/projectBeforeTracking/backNodeTaskModal");
		return mv;
	}
}

package com.zjm.gbpm.product.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_product;
import com.zjm.gbpm.product.service.ProductService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/gbpm/product")
public class ProductAction{
	
	@Resource
	private ProductService productService;
	@Resource
	private DicTypeService dicTypeService;
	/**
	 * 返回产品流程页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectProductPage")
	public ModelAndView selectProductPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/gbpm/product/product/product");
		return mv;
	}
	
	/**
	 * 返回产品流程添加页面
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/productAddPage")
	public ModelAndView productAddPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		wheresql=wheresql+" and dicTypePID = \'"+"bd5d52a378724631816385105dcc28cf"+"\'";
		List<C_dictype> productTypeList = dicTypeService.selectAllDicTypeList(wheresql);
		mv.getModel().put("productTypeList", productTypeList);
		mv.setViewName("/gbpm/product/product/productAdd");
		return mv;
	}
	
	/**
	 * 返回产品流程顺序调整页面
	 * @return
	 */
	@RequestMapping(value="/selectAllProductPage")
	public ModelAndView selectAllProductPage(){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		List<Gbpm_product> productList = productService.selectProductList(wheresql);
		mv.getModel().put("productList", productList);
		mv.setViewName("/gbpm/product/product/productSort");
		return mv;
	}
	
	/**
	 * 分页查询产品流程实例列表
	 */
	@RequestMapping(value="/selectProductPageTable")
	@ResponseBody
	public AjaxRes selectProductPageTable(@RequestBody PageTable<Gbpm_product> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		try {
			pageTable = productService.selectProductPageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Gbpm_product> pageTable){
		if(pageTable==null){
			StringBuffer wheresql = new StringBuffer();
			wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
			return "";
		}
		StringBuffer wheresql = new StringBuffer();
		if (null!=pageTable.getWheresql()) {
			wheresql.append(pageTable.getWheresql());
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and productName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		if ( null != pageTable.getQueryCondition() && null!= pageTable.getQueryCondition().getIsUsed() && pageTable.getQueryCondition().getIsUsed()) {
			wheresql.append(" and isUsed = 1 ");
		}
		return wheresql.toString();
	}
	
	/**
	 *  执行操作-新增一条产品流程
	 */
	@RequestMapping(value="/insertOneProductInfo")
	@ResponseBody
	public AjaxRes insertOneProductInfo(@RequestBody Gbpm_product product){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(productService.insertOneProductInfo(SystemSession.getUserSession(), product));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面-复制产品流程
	 */
	@RequestMapping(value="/copyProductPage")
	public ModelAndView copyProductPage(Gbpm_product product){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		product = productService.selectOneProductInfo(product);
		String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		wheresql=wheresql+" and dicTypePID = \'"+"bd5d52a378724631816385105dcc28cf"+"\'";
		List<C_dictype> productTypeList = dicTypeService.selectAllDicTypeList(wheresql);
		mv.getModel().put("productTypeList", productTypeList);
		mv.getModelMap().put("product",product);
		mv.setViewName("/gbpm/product/product/productCopy");
		return mv;
	}
	
	/**
	 *  执行操作-复制产品流程
	 */
	@RequestMapping(value="/copyProduct")
	@ResponseBody
	public AjaxRes copyProduct(@RequestBody Gbpm_product product){
		AjaxRes ar = new AjaxRes();
		try {
			ar.setSucceed(productService.copyProduct(SystemSession.getUserSession(), product));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 新增/修改时判断产品流程名称是否存在
	 */
	@RequestMapping(value="/isExistProductName")
	@ResponseBody
	public AjaxRes isExistProductName (@RequestBody Gbpm_product product){
		AjaxRes ar = new AjaxRes();
		product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			ar.setSucceed(productService.isExistProductName(product));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 复制新版本时判断产品流程名称是否存在
	 */
	@RequestMapping(value="/isExistProductNameByCopy")
	@ResponseBody
	public AjaxRes isExistProductNameByCopy (@RequestBody Gbpm_product product){
		AjaxRes ar = new AjaxRes();
		product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		try {
			Gbpm_product product2 =new Gbpm_product();
			product2.setProductName(product.getProductName());
			product2.setUnit_uid(product.getUnit_uid());
			product2.setVersion(product.getVersion());
			ar.setSucceed(productService.isExistProductName(product2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 显示页面-修改一条产品流程
	 */
	@RequestMapping(value="/productEditPage")
	public ModelAndView productEditPage(Gbpm_product product){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		product = productService.selectOneProductInfo(product);
		String wheresql=" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		wheresql=wheresql+" and dicTypePID = \'"+"bd5d52a378724631816385105dcc28cf"+"\'";
		List<C_dictype> productTypeList = dicTypeService.selectAllDicTypeList(wheresql);
		mv.getModel().put("productTypeList", productTypeList);
		mv.getModelMap().put("product",product);
		mv.setViewName("/gbpm/product/product/productEdit");
		return mv;
	}
	
	/**
	 *  执行操作-修改一条产品流程
	 */
	@RequestMapping(value="/updateOneProduct")
	@ResponseBody
	public AjaxRes updateOneProduct(@RequestBody Gbpm_product product){
		AjaxRes ar = new AjaxRes();
		product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		product.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
		Boolean b = false;
		try {
			b = productService.updateOneProductInfo(SystemSession.getUserSession(), product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 *  执行操作-删除一条产品流程
	 */
	@RequestMapping(value="/deleteOneProduct")
	@ResponseBody
	public AjaxRes deleteOneProduct(@RequestBody Gbpm_product product){
		AjaxRes ar = new AjaxRes();
		try {
			product.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			ar.setSucceed(productService.deleteOneProduct(SystemSession.getUserSession(), product));
		} catch (Exception e) {
			e.printStackTrace();
			ar.setSucceed(false);
		}
		return ar;
	}
	
}
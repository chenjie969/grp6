package com.zjm.crm.stock.web;
/**
*  @description 股权结构 action
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月15日 下午6:40:08
*/

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.crm.db.model.Crm_stock;
import com.zjm.crm.stock.service.StockService;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
public class StockAction {

	@Resource
	private StockService  stockService;
	
	/**
	 * @description  查询股权机构信息 列表 
	 * @author wuhn
	 * @date 2017年5月15日 下午6:51:51
	 */
	@RequestMapping(value="/selectStockListPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectStockListPageTables(@RequestBody PageTable<Crm_stock> pageTable){
		String queryCondition = queryCondition(pageTable);
		List<Crm_stock> list = stockService.selectStockListByClient_ID(queryCondition);
		pageTable.setTotal(new Long(list.size()));
		pageTable.setRows(list);
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(pageTable);
		return ar;
	}
	

	
	private String queryCondition(PageTable<Crm_stock> pageTable) {
		String wheresql="";
		if(null == pageTable){
			return "";
		}
		String client_ID = pageTable.getQueryCondition().getClient_ID();
		if(client_ID != null && !"".equals(client_ID)){
			wheresql=client_ID;
		}
		return wheresql;
	}



	/**
	 * 
	 * @description 添加一条股权信息
	 * @author wuhn
	 * @date 2017年5月15日 下午6:57:47
	 */
	@RequestMapping(value="/insertOneStockInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneStockInfo(@RequestBody Crm_stock crm_stock){
		User userSession = SystemSession.getUserSession();
		crm_stock.setUnitUid(userSession.getUnit_uid()); //添加担保机构id
		crm_stock.setUpdateusername(userSession.getUser_name());
		crm_stock.setStockId(Tool.createUUID32()); //添加id-- uuid
		Boolean bool = stockService.insertOneStockInfo(crm_stock,SystemSession.getUserSession());
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description	查询一条股权信息
	 * @author wuhn
	 * @date 2017年5月15日 下午7:01:49
	 */
	@RequestMapping(value="/selectOneStockInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneStockInfo(@RequestBody Crm_stock crm_stock){
		Crm_stock stockInfo = stockService.selectOneStockInfo(crm_stock.getStockId());
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(stockInfo);
		return ar;
	}
	
	/**
	 * 
	 * @description 更新 修改股权信息
	 * @author wuhn
	 * @date 2017年5月15日 下午7:08:58
	 */
	@RequestMapping(value="/updateOneStockInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneStockInfo(@RequestBody Crm_stock crm_stock){
		crm_stock.setUpdateusername(SystemSession.getUserSession().getUser_name()); //最后修改人
		Boolean bool = stockService.updateOneStockInfo(crm_stock,SystemSession.getUserSession());
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description  根据 股权id 删除一条股权信息
	 * @author wuhn
	 * @date 2017年5月15日 下午7:10:02
	 */
	@RequestMapping(value="/deleteOneStockInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneStockInfo(@RequestBody Crm_stock crm_stock){
		Boolean bool = stockService.deleteOneStockInfo(crm_stock.getStockId(),SystemSession.getUserSession());
		AjaxRes  ar =new  AjaxRes() ;
		ar.setSucceed(bool);
		return ar;
	}

}

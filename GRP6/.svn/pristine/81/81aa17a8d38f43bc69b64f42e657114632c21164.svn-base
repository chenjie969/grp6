package com.zjm.crm.cooperation.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.QueryCondition;
import com.zjm.sys.banksort.service.BankSortService;
import com.zjm.sys.db.model.C_bankSort;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

/**
*  @description 额度使用情况action
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月26日 下午1:19:54
*/
@Controller
@RequestMapping(value="/crm/creditConditions")
public class CreditConditionsAction {
	
	@Resource
	private  BankSortService  bankSortService;
	
	/**
	 * @description	 初始化进入额度使用情况列表页面
	 * @author wuhn
	 * @date 2017年5月25日 下午2:46:57
	 */
	@RequestMapping(value="/initCreditConditions")
	public ModelAndView initCreditConditions(){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.setViewName("/cooperation/creditConditions/creditConditionsList");
		return modeAndView;
	}
	
	/**
	 * @description	获取 额度使用情况 分页列表数据
	 * @author wuhn
	 * @date 2017年5月26日 下午2:41:43
	 */
	@RequestMapping(value="/selectCreditConditionsPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes  selectCreditConditionsPageTables(@RequestBody PageTable<C_bankSort>  pageTable){
		AjaxRes ar =new AjaxRes();
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable = bankSortService.selectCreditConditionsPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * @description	分页列表查询条件
	 * @author wuhn
	 * @date 2017年5月26日 下午2:42:12
	 */
	private String queryCondition(PageTable<C_bankSort> pageTable) {
		String wheresql=" and unit_uid ='"+ SystemSession.getUserSession().getUnit_uid() +"'";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		wheresql+=" and banksortId != '4649d725753a4f00bd6bfe7c346b0dc5'";//不需要显示根节点
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY banksortname ";
		}
		
		return wheresql;
	}

	/**
	 * @description	查看额度使用情况详情
	 * @author wuhn
	 * @date 2017年5月25日 下午2:46:57
	 */
	@RequestMapping(value="/selectCreditConditionsView")
	public ModelAndView selectCreditConditionsView(C_bankSort  c_bankSort){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		if(null == c_bankSort){
			c_bankSort=new C_bankSort();
		}
		C_bankSort creditInfo = bankSortService.selectOnebankSortInfo(c_bankSort);
		modeAndView.setViewName("/cooperation/creditConditions/creditConditionsDetail");
		modeAndView.getModel().put("creditInfo", creditInfo);
		return modeAndView;
	}
}

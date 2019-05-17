package com.zjm.sys.banksort.web;
/**
*  @description 
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  
*/

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

import com.zjm.sys.banksort.service.BankSortService;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.sys.db.model.C_bankSort;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
/**
 * 银行字典action
 * @description
 * @author wuhn
 * @date 2017年5月3日 下午1:22:36
 */
@Controller
public class BankSortAction {
	
	@Resource
	private BankSortService  bankSortService;
	
	
	/**
	 * 查询所有银行字典 树形结构，用于index.jsp 左侧 初始化页面显示
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 下午8:30:11
	 */
	@RequestMapping(value="/selectAllBankSortListTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllbankSortListTree(){
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		Map<String,Object> map =new HashMap<String,Object>();
		/*map.put("id", "1");
		map.put("pId", "-1");
		map.put("name", "银行字典设置");
		map.put("open",true);
		mapList.add(map);*/
		String sql="";
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//sql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		List<C_bankSort> list = bankSortService.selectAllbankSortList(sql);
		for (C_bankSort c : list) {
			map =new HashMap<String,Object>();
			map.put("id", c.getBanksortid());
			map.put("pId", c.getPbanksortid());
			map.put("name", c.getBanksortname());
			if("4649d725753a4f00bd6bfe7c346b0dc5".equals(c.getBanksortid())){
				map.put("open", true);
			}
			mapList.add(map);
		}
		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 *  获得所有银行字典 key-value : 银行id-- 银行名称 JSON格式
	 * @description: 用于排序显示--同级顺序调整
	 * @author wuhn
	 * @date 2017年4月28日 下午8:42:29
	 */						
	@RequestMapping(value="/selectAllbankSortListJSON",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllbankSortListJSON(@RequestBody C_bankSort c_bankSort){
		List<Map<String,String>> mapList=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		String wheresql="";
		
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//wheresql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		
		if(null!=c_bankSort){
			if(null!=c_bankSort.getPbanksortid()){//不是根节点
				wheresql+="and Pbanksortid='"+c_bankSort.getPbanksortid()+"'";
			}
		}
		List<C_bankSort> list = bankSortService.selectAllbankSortList(wheresql);
		for (C_bankSort c : list) {
			 map =new HashMap<String,String>();
			 map.put(c.getBanksortid(), c.getBanksortname());
			 mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	
	/**
	 * 单击节点，获取 右侧列表 分页显示，包含搜索条件
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 20:52:57
	 */
	@RequestMapping(value="/selectBankSortsPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectBankSortsPageTables(@RequestBody PageTable<C_bankSort> pageTable){
		String queryConditionSql = queryConditionSql(pageTable);
		pageTable.setWheresql(queryConditionSql);
		pageTable = bankSortService.selectbankSortPageTables(pageTable);
		pageTable.setWheresql("");// 清空查询条件
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	/**
	 * 银行字典  分页列表查询条件  
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable<C_bankSort> pageTable){
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and BankSortname like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			String pBankSortid = pageTable.getQueryCondition().getPbanksortid();//银行字典父id
			if(pBankSortid!=null && !pBankSortid.equals("") && !pBankSortid.equals("1")){
				wheresql=wheresql+" and pBankSortid =\'"+pBankSortid+"\'";
			}
			String banksortid = pageTable.getQueryCondition().getBanksortid();
			if(banksortid != null && !banksortid.equals("")){
				wheresql+=" and banksortid = '"+ banksortid+"'";
			}
		}
		
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//wheresql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY order_id ";
		}
		return wheresql;
	}
	
	

	/**
	 * 插入/添加 一个 银行字典
	 * @description
	 * @author wuhn
	 * @date 2017年4月25日 下午8:16:21
	 */
	@RequestMapping(value="/insertOneBankSortInfo" , method=RequestMethod.POST,consumes = "application/json")
	@ResponseBody			
	public AjaxRes insertOneBankSortInfo(@RequestBody C_bankSort c_BankSort){
		User sys_users = SystemSession.getUserSession();
		if(null != sys_users){
			c_BankSort.setUnitUid(sys_users.getUnit_uid());
			c_BankSort.setCreateUser(sys_users.getUser_name());
			c_BankSort.setUpdateUser(sys_users.getUpdate_user());
		}
		String bankFullCode="";
		//判断是否是根节点,初始化根节点id为:4649d725753a4f00bd6bfe7c346b0dc5
		if(null != c_BankSort && !"4649d725753a4f00bd6bfe7c346b0dc5".equals(c_BankSort.getPbanksortid())){ 
			C_bankSort bank=new C_bankSort();
			bank.setBanksortid(c_BankSort.getPbanksortid());
			bank.setUnitUid(c_BankSort.getUnitUid());
			C_bankSort bankSortInfo = bankSortService.selectOnebankSortInfo(bank); //获取父节点的信息
			bankFullCode=bankSortInfo==null?"": bankSortInfo.getBankfullcode(); // 获取父节点的完整编号
			c_BankSort.setBankfullcode(bankFullCode); 
		}else{
			bankFullCode="4649d725753a4f00bd6bfe7c346b0dc5/";
		}
		c_BankSort.setBanksortid(Tool.createUUID32());// id用uuid来实现
		bankFullCode+=c_BankSort.getBanksortid()+"/"; //完整
		c_BankSort.setBankfullcode(bankFullCode);
		Boolean bool = bankSortService.insertOnebankSortInfo(c_BankSort,SystemSession.getUserSession());
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 查询一个银行字典信息
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 上午11:35:39
	 */
	@RequestMapping(value="/selectOneBankSortsInfo" , method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneBankSortsInfo(@RequestBody C_bankSort c_BankSort){
		C_bankSort c = bankSortService.selectOnebankSortInfo(c_BankSort);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(c);
		return ar;
	}
	
	
	/**
	 * 更新一个 银行字典信息 
	 * @description 修改
	 * @author wuhn
	 * @date 2017年4月26日 下午1:00:54
	 */
	@RequestMapping(value="/updateOneBankSortsInfo" , method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneBankSortsInfo(@RequestBody C_bankSort c_BankSort){
		c_BankSort.setUpdateUser(SystemSession.getUserSession().getUser_name());
		Boolean updateOneBankSortInfo = bankSortService.updateOnebankSortInfo(c_BankSort,SystemSession.getUserSession());
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(updateOneBankSortInfo);
		return ar;
	}
	
	
	/**
	 * 删除一个银行字典信息
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 下午1:01:53
	 */
	@RequestMapping(value="/deleteOneBankSortsInfo" , method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneBankSortsInfo(@RequestBody C_bankSort c_BankSort){
		Boolean deleteOneBankSortInfo = bankSortService.deleteOnebankSortInfo(c_BankSort,SystemSession.getUserSession());
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(deleteOneBankSortInfo);
		return ar;
	}
	
	/**
	 * 添加时判断银行字典是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectAddBankSortNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAddBankSortNameIsExist(@RequestBody C_bankSort c_BankSort){
		String wheresql="";
		if(c_BankSort!=null){
			if(c_BankSort.getBanksortname()!=null){
				wheresql=wheresql+" and BankSortname = \'"+((String) c_BankSort.getBanksortname()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=bankSortService.selectbankSortIsExist(wheresql);
		if(b){//存在 置为false
			b=false;
		}else{
			b=true;
		}
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 修改时判断银行字典是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectEditBankSortNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEditBankSortNameIsExist(@RequestBody  C_bankSort c_BankSort){
		AjaxRes ar=new AjaxRes();
		String wheresql="";
		String banksortname = c_BankSort.getBanksortname();
		C_bankSort bankSortInfo = bankSortService.selectOnebankSortInfo(c_BankSort);
		if(bankSortInfo.getBanksortname().equals(banksortname)){// 若数据库中的名称和提交上来的一致，不做处理。--> 名称未做修改
			ar.setSucceed(true);
			return ar;
		}
		if( banksortname !=null){
			wheresql=wheresql+" and banksortname = \'"+((String) banksortname).trim()+"\'";
		}
		Boolean b=bankSortService.selectbankSortIsExist(wheresql);
		if(b){
			b=false; //若存在，只为false，验证不通过
		}else{
			b=true; // 不存在，true,验证通过
		}
		ar.setSucceed(b);
		return ar;
	}
	

}

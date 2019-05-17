package com.zjm.crm.cooperation.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.banksort.service.BankSortService;
import com.zjm.sys.db.model.C_bankSort;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
*  @description  合作机构管理
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月24日 下午2:41:58
*/
@Controller
@RequestMapping(value="/crm/cooperation")
public class CooperationAction {
	
	@Resource 
	private BankSortService  bankSortService;
	
	@Resource
	private DicTypeService  dicTypeService; //单级字典
	
	/**
	 * @description	初始化--合作机构设置
	 * @author wuhn
	 * @date 2017年5月24日 下午3:19:50
	 */
	@RequestMapping(value="/initCooperation")
	public ModelAndView initCooperation(){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		// 原 /cooperation/cooperationSet/cooperationList.jsp 
		modeAndView.setViewName("/cooperation/cooperationSet/cooperationList");
		return modeAndView;
	}
	
	/**
	 * @description 合作机构--左侧 树形结构
	 * @author wuhn
	 * @date 2017年5月24日 下午3:29:34
	 */
//	@RequestMapping(value="/selectAllCooperationListTree",method=RequestMethod.POST)
//	@ResponseBody
//	public AjaxRes selectAllCooperationListTree(){
//		String sql=" and unit_uid = '"+SystemSession.getUserSession().getUnit_uid()+"'";
//		List<C_bankSort> bankSortList = bankSortService.selectAllbankSortList(sql);
//		Map<String,Object> map=new LinkedHashMap<String,Object>();
//		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
//		for (C_bankSort bank : bankSortList) {
//			map=new LinkedHashMap<String,Object>();
//			map.put("id", bank.getBanksortid());
//			map.put("pId", bank.getPbanksortid());
//			map.put("name", bank.getBanksortname());
//			if("4649d725753a4f00bd6bfe7c346b0dc5".equals(bank.getBanksortid())){
//				map.put("open", true);// 默认展开根节点
//			}
//			mapList.add(map);
//		}
//		AjaxRes ar =new AjaxRes();
//		ar.setSucceed(mapList);
//		return ar;
//	}
	
	
	/**
	 * @description 合作机构--左侧 树形结构
	 * @author wuhn
	 * @date 2017年5月24日 下午3:29:34
	 */
	@RequestMapping(value="/selectCooperationListTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectCooperationListTree(){
		String sql=" and unit_uid = '"+SystemSession.getUserSession().getUnit_uid()+"'";
		List<C_bankSort> bankSortList = bankSortService.selectAllbankSortList(sql);
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		for (C_bankSort bank : bankSortList) {
			map=new LinkedHashMap<String,Object>();
			map.put("id", bank.getBanksortid());
			map.put("pId", bank.getPbanksortid());
			map.put("name", bank.getBanksortname());
			if("4649d725753a4f00bd6bfe7c346b0dc5".equals(bank.getBanksortid())){
				map.put("open", true);// 默认展开根节点
			}
			mapList.add(map);
		}
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 * @description 合作机构--左侧 树形结构
	 * @author wuhn
	 * @date 2017年5月24日 下午3:29:34
	 */
	@RequestMapping(value="/selectAllCooperationListTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllCooperationListTree(@RequestBody C_bankSort bankSort){
		String sql="";
		if(!"".equals(bankSort.getPbanksortid()) && null != bankSort.getPbanksortid()){
			sql = sql +" and ( pbankSortID = \'"+bankSort.getPbanksortid()+"\' or pbankSortID = '1' or  bankSortID = \'"+bankSort.getPbanksortid()+"\' ) ";
		}else{
			sql=" and unit_uid = '"+SystemSession.getUserSession().getUnit_uid()+"'"+" and pbankSortID not in ('1066ead43c16455587fc191aba8a566d',"
					+ "'2b648b78f8914afaa8c3432fa5a290a6','47ebc673aeda4551908b8f91d710e281','97af005f8168488790444432945410b8','c4f86026656a455498fe9e25b72bdc84',"
					+ "'e321491c2c42483bbac0dc711638203f','ff9e06eb0b2049afa60214c168986cab')";
		}
		List<C_bankSort> bankSortList = bankSortService.selectAllbankSortList(sql);
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		for (C_bankSort bank : bankSortList) {
			map=new LinkedHashMap<String,Object>();
			map.put("id", bank.getBanksortid());
			map.put("pId", bank.getPbanksortid());
			map.put("name", bank.getBanksortname());
			if("4649d725753a4f00bd6bfe7c346b0dc5".equals(bank.getBanksortid())){
				map.put("open", true);// 默认展开根节点
			}
			mapList.add(map); 
		}
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * @description 资金方 树形结构
	 * @author zky
	 * @date 2018年1月30日 
	 */
	@RequestMapping(value="/selectAllFundListTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllFundListTree(@RequestBody C_bankSort bankSort){
		String sql=" and unit_uid = '"+SystemSession.getUserSession().getUnit_uid()+"'";
		if(null!=bankSort.getBanksortname()&&""!=bankSort.getBanksortname()){
			sql = sql + "bankSortName like "+bankSort.getBanksortname()+"%";
		}
		if(!"".equals(bankSort.getPbanksortid()) && null != bankSort.getPbanksortid()){
			sql = sql +" and ( pbankSortID = \'"+bankSort.getPbanksortid()+"\' or pbankSortID = '1' or  bankSortID = \'"+bankSort.getPbanksortid()+"\' ) ";
		}
		
		if (!"".equals(bankSort.getFundType()) && bankSort.getFundType() != null
				&& !"".equals(bankSort.getBusiClass()) && bankSort.getBusiClass() != null
				&& "02".equals(bankSort.getBusiClass()) && bankSort.getBanksortid() != null
				&& !"".equals(bankSort.getBanksortid())) {
			//委贷业务获取资金方名称（只有国企）
			if ("01".equals(bankSort.getFundType())) {
				sql += "and (bankSortID = '2b648b78f8914afaa8c3432fa5a290a6' or bankSortID = \'"+bankSort.getBanksortid()+"\') ";
			}
			//委贷业务获取资金方子机构（只有融投系及下属公司）
			if ("02".equals(bankSort.getFundType())) {
				sql += "and (bankSortName like '%融投%' or bankSortID = \'"+bankSort.getBanksortid()+"\')";
			}
		}
		
		List<C_bankSort> bankSortList = bankSortService.selectAllbankSortList(sql);
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		for (C_bankSort bank : bankSortList) {
			map=new LinkedHashMap<String,Object>();
			map.put("id", bank.getBanksortid());
			map.put("pId", bank.getPbanksortid());
			map.put("name", bank.getBanksortname());
			if("4649d725753a4f00bd6bfe7c346b0dc5".equals(bank.getBanksortid())){
				map.put("open", true);// 默认展开根节点
				map.put("name","资金方");
			}
			mapList.add(map);
		}
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 * @description  合作机构 右则分页列表
	 * @author wuhn
	 * @date 2017年5月24日 下午3:27:23
	 */
	@RequestMapping(value="/selectCooperationPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectCooperationPageTables(@RequestBody PageTable<C_bankSort> pageTable){
		AjaxRes ar =new AjaxRes();
		String queryCondition = queryCondition(pageTable);//分页列表查询条件
		pageTable.setWheresql(queryCondition);
		pageTable = bankSortService.selectbankSortPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	/**
	 * @description  合作机构 右则分页列表
	 * @author wuhn
	 * @date 2017年5月24日 下午3:27:23
	 */
	@RequestMapping(value="/selectCooperationPageTablesApp",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectCooperationPageTablesApp(@RequestBody PageTable<C_bankSort> pageTable){
		AjaxRes ar =new AjaxRes();
		String queryCondition = queryConditionNew(pageTable);//分页列表查询条件
		pageTable.setWheresql(queryCondition);
		pageTable = bankSortService.selectbankSortPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	/**
	 * @description 分页列表查询 条件
	 * @author wuhn
	 * @date 2017年5月24日 下午3:25:08
	 */
	private String queryCondition(PageTable<C_bankSort> pageTable) {
		String wheresql=" and unit_uid ='"+ SystemSession.getUserSession().getUnit_uid() +"'";
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
			if(banksortid != null && !"".equals(banksortid)){
				wheresql+=" and banksortid ='"+banksortid+"'";
			}
			
		}
		
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY order_id ";
		}
		return wheresql;
	}
	
	/**
	 * @description 分页列表查询 条件
	 * @author wuhn
	 * @date 2017年5月24日 下午3:25:08
	 */
	private String queryConditionNew(PageTable<C_bankSort> pageTable) {
		String wheresql=" and unit_uid ='"+ SystemSession.getUserSession().getUnit_uid() +"'";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and BankSortname like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			String banksortid = pageTable.getQueryCondition().getBanksortid();
			if(banksortid != null && !banksortid.equals("")){
					wheresql+=" and pbanksortid = '"+ banksortid+"'";
			}
		}
		
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY order_id ";
		}
		return wheresql;
	}


	/**
	 * @description	  同级顺序调整  获取机构id --机构名称 key--value格式数据
	 * @author wuhn
	 * @date 2017年5月24日 下午4:41:18
	 */
	@RequestMapping(value="/selectCooperationSortJSON",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectCooperationSortJSON(@RequestBody C_bankSort  c_bankSort){
		AjaxRes ar =new AjaxRes();
		Map<String,Object> map=new HashMap<>();
		List<Map<String,Object>> mapList=new ArrayList<>();
		String wheresql=" and unit_uid ='"+ SystemSession.getUserSession().getUnit_uid() +"'";
		if(null != c_bankSort.getPbanksortid()){//不是根节点
			wheresql+=" and pbanksortid= '"+ c_bankSort.getPbanksortid()+"'";
		}
		List<C_bankSort> bankList = bankSortService.selectAllbankSortList(wheresql);
		for (C_bankSort bank : bankList) {
			map.put(bank.getBanksortid(), bank.getBanksortname()); // 机构id -- 机构名称
			mapList.add(map);
			map=new HashMap<>();
		}
		ar.setSucceed(mapList);
		return ar;
	}
	
	
	/**
	 * @description	查看一个合作机构信息
	 * @author wuhn
	 * @date 2017年5月24日 下午3:19:50
	 */
	@RequestMapping(value="/selectOneCooperationInfo")
	public ModelAndView selectOnebankSortInfo(C_bankSort  c_bankSort){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		if(null == c_bankSort){
			c_bankSort =new C_bankSort();
		}
		C_bankSort CooperationInfo = bankSortService.selectOnebankSortInfo(c_bankSort);
		modeAndView.setViewName("/cooperation/cooperationSet/cooperationView");
		modeAndView.getModel().put("CooperationInfo", CooperationInfo);
		return modeAndView;
	}
	
	/**
	 * @description	查看一个合作机构信息
	 * @author wuhn
	 * @date 2017年5月24日 下午3:19:50
	 */
	@RequestMapping(value="/selectOnebankSortInfoApp")
	@ResponseBody
	public AjaxRes selectOnebankSortInfoApp(@RequestBody C_bankSort  c_bankSort){
		if(null == c_bankSort){
			c_bankSort =new C_bankSort();
		}
		AjaxRes ar = new AjaxRes();
		C_bankSort CooperationInfo = bankSortService.selectOnebankSortInfo(c_bankSort);
		ar.setSucceed(CooperationInfo);
		return ar;
	}
	
	/**
	 * @description	 添加一个机构信息 
	 * @author wuhn 
	 * @date 2017年5月24日 下午5:30:29
	 */
	@RequestMapping(value="/insertOneCooperationInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneCooperationInfo(@RequestBody C_bankSort  c_bankSort){
		c_bankSort.setUnitUid(SystemSession.getUserSession().getUnit_uid());
		c_bankSort.setCreateUser(SystemSession.getUserSession().getUser_name());
		c_bankSort.setUpdateUser(SystemSession.getUserSession().getUpdate_user());
		String bankFullCode="";
		//判断是否是根节点,初始化根节点id为:4649d725753a4f00bd6bfe7c346b0dc5
		if(null != c_bankSort && !"4649d725753a4f00bd6bfe7c346b0dc5".equals(c_bankSort.getPbanksortid())){ 
			C_bankSort bank=new C_bankSort();
			bank.setBanksortid(c_bankSort.getPbanksortid());
			bank.setUnitUid(c_bankSort.getUnitUid());
			C_bankSort bankSortInfo = bankSortService.selectOnebankSortInfo(bank); //获取父节点的信息
			bankFullCode=bankSortInfo==null?"": bankSortInfo.getBankfullcode(); // 获取父节点的完整编号
			c_bankSort.setBankfullcode(bankFullCode); 
		}else{
			bankFullCode="4649d725753a4f00bd6bfe7c346b0dc5/";
		}
		c_bankSort.setBanksortid(Tool.createUUID32());// id用uuid来实现
		bankFullCode+=c_bankSort.getBanksortid()+"/"; //完整
		c_bankSort.setBankfullcode(bankFullCode);
		Boolean bool = bankSortService.insertOnebankSortInfo(c_bankSort,SystemSession.getUserSession());
		 AjaxRes ar = new AjaxRes();
		 if(bool){ //若添加成功,将对象返回给前台
			 ar.setSucceed(c_bankSort);
		 }else{
			 ar.setSucceed(null);
		 }
		return ar;
	}
	
	/**
	 * @description	进入 修改合作机构信息页面
	 * @author wuhn
	 * @date 2017年5月24日 下午3:19:50
	 */
	@RequestMapping(value="/selectCooperationEditPage")
	public ModelAndView selectCooperationEditPage(C_bankSort  c_bankSort){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		if(null == c_bankSort){
			c_bankSort =new C_bankSort();
		}
		C_bankSort CooperationInfo = bankSortService.selectOnebankSortInfo(c_bankSort);
		modeAndView.setViewName("/cooperation/cooperationSet/cooperationEdit");
		modeAndView.getModel().put("CooperationInfo", CooperationInfo);
		return modeAndView;
	}
	
	/**
	 * @description	修改合作机构信息 
	 * @author wuhn
	 * @date 2017年5月24日 下午5:31:05
	 */
	@RequestMapping(value="/updateOneCooperationInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneCooperationInfo(@RequestBody C_bankSort  c_bankSort){
		c_bankSort.setUpdateUser(SystemSession.getUserSession().getUser_name());
		AjaxRes ar =new AjaxRes();
		Boolean bool =bankSortService.updateOnebankSortInfo(c_bankSort,SystemSession.getUserSession());
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * @description	进入 删除合作机构页面
	 * @author wuhn
	 * @date 2017年5月24日 下午3:19:50
	 */
	@RequestMapping(value="/selectCooperationDelPage")
	public ModelAndView selectCooperationDelPage(){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.setViewName("/cooperation/cooperationSet/cooperationDel");
		return modeAndView;
	}
	
	
	/**
	 * @description	删除一个机构信息  
	 * @author wuhn
	 * @date 2017年5月24日 下午5:31:20
	 */
	@RequestMapping(value="/deleteOneCooperationInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneCooperationInfo(@RequestBody C_bankSort  c_bankSort){
		AjaxRes ar =new AjaxRes();
		Boolean bool = bankSortService.deleteOnebankSortInfo(c_bankSort,SystemSession.getUserSession());
		ar.setSucceed(bool);
		return ar;
	}
	
	
	/**
	 * 添加时判断合作机构是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectAddCooperationNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAddCooperationNameIsExist(@RequestBody C_bankSort c_BankSort){
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
	 * 修改时判断合作机构是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectEditCooperationNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEditCooperationNameIsExist(@RequestBody  C_bankSort c_BankSort){
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

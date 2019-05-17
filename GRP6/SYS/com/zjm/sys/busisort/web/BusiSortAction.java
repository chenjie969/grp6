package com.zjm.sys.busisort.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.busisort.service.BusiSortService;
import com.zjm.sys.db.model.C_busiSort;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;


/**
*  @description  业务品种 action
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年4月25日 下午4:02:25
*/
@Controller
public class BusiSortAction {
	
	@Resource
	private BusiSortService busiSortService;
	
	
	/**
	 * 查询所有业务品种   目前没使用
	 * @description
	 * @author wuhn
	 * @date 2017年4月25日 下午4:08:17
	 */
	@RequestMapping(value="/selectAllBusiSortList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllBusiSortList(){
		List<C_busiSort> list = busiSortService.selectAllBusiSortList(null);
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(list);
		
		return ar;
	}
	

	/**
	 * 
	 * @description 查询所有业务品种,用于初始化树形显示 
	 */
	@RequestMapping(value="selectAllBusiSortListTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllBusiSortListTree(){
	
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		Map<String,Object> map =new LinkedHashMap<String,Object>();
	/*	map.put("id", "1");
		map.put("pId", "-1");
		map.put("name", "业务品种设置");
		map.put("open",true);
		mapList.add(map);*/
		String sql="";
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//sql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		
		List<C_busiSort> list =busiSortService.selectAllBusiSortList(sql);
		for (C_busiSort c : list) {
			map =new LinkedHashMap<String,Object>();
			map.put("id", c.getBusisortid());
			map.put("pId", c.getPbusisortid());
			map.put("name", c.getBusisortname());
			if("418f0975f373470581711826bf5b3711".equals(c.getBusisortid())){//默认根节点进行展开
				map.put("open", true);
			}
			mapList.add(map);
		}
		
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 * 查询所有业务品种 JSON格式 --- 同级顺序调整 列表获取
	 * @description
	 * @author wuhn
	 * @date 2017年4月25日 下午7:56:21
	 */
	@RequestMapping(value="selectBusiSortsListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectBusiSortsListJSON(@RequestBody C_busiSort c_busiSort){
		List<Map<String,String>> mapList=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		String wheresql="";
		if(null!=c_busiSort){
			if(null!=c_busiSort.getPbusisortid()){//不是新增的业务品种
				wheresql+="and pbusisortid ='"+c_busiSort.getPbusisortid()+"'";
			}
		}
		
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//wheresql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		
		List<C_busiSort> list = busiSortService.selectAllBusiSortList(wheresql);
		for (C_busiSort c : list) {
			map=new HashMap<String,String>();
			map.put(c.getBusisortid(), c.getBusisortname());
			mapList.add(map);
		}
		
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	
	
	
	/**
	 * 单击节点，获取 右侧列表 分页显示
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 上午11:33:12
	 */
	@RequestMapping(value="selectBusiSortsPageTables")
	@ResponseBody
	public AjaxRes selectBusiSortsPageTables(@RequestBody PageTable<C_busiSort> pageTable){
		String queryConditionSql = queryConditionSql(pageTable);//获取查询条件
		pageTable.setWheresql(queryConditionSql);//传入查询条件
		pageTable = busiSortService.selectBusiSortPageTables(pageTable);
		pageTable.setWheresql("");// 清空查询条件
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 业务品种 分页列表查询条件  
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(@RequestBody PageTable<C_busiSort> pageTable){
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and busisortname like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		
		if(pageTable.getQueryCondition()!=null){
			if ( null == pageTable.getSearchText()) {
				String pbusisortid = pageTable.getQueryCondition().getPbusisortid();// 业务品种父类id: 父类根id 默认为: 1
				if(pbusisortid!=null && !pbusisortid.equals("") && !pbusisortid.equals("1")){
					//wheresql=wheresql+" and pbusisortid =\'"+pbusisortid+"\'";
					wheresql=wheresql+" and pbusisortid like \'%"+pageTable.getQueryCondition().getPbusisortid().trim()+"%\'";
				}
				String busisortid = pageTable.getQueryCondition().getBusisortid();
				if(busisortid != null && !busisortid.equals("")){
					wheresql+=" and busisortid='"+busisortid +"'";
				}
			}
		}
		
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//wheresql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		
		String sortName = pageTable.getSortName();// 排序字段名
		String sortOrder = pageTable.getSortOrder(); // 
		if(sortName!=null && !sortName.equals("") && sortOrder!=null && !sortOrder.equals("")){
				wheresql=wheresql+" order by "+sortName.trim()+"  " +sortOrder+"";
		}else{
			wheresql=wheresql+" ORDER BY order_id ";
		}
		return wheresql;
	}
	
	
	
	/**
	 * 插入一个业务品种
	 * @description
	 * @author wuhn
	 * @date 2017年4月25日 下午8:16:21
	 */
	@RequestMapping(value="/insertOneBusiSortInfo" , method=RequestMethod.POST ,consumes = "application/json")
	@ResponseBody
	public AjaxRes insertOneBusiSortInfo(@RequestBody C_busiSort c_busiSort){
		User sys_users = SystemSession.getUserSession();
		if(null != sys_users){
			c_busiSort.setUnitUid(sys_users.getUnit_uid());
			c_busiSort.setCreateUser(sys_users.getUser_name());
			c_busiSort.setUpdateUser(sys_users.getUpdate_user());
		}
		c_busiSort.setBusisortid(Tool.createUUID32());//添加唯一编号
		String busisortfullcode=""; // 业务品种完整编号
		 // 判断是否是根节点：根节点默认为: 418f0975f373470581711826bf5b3711
		if( null != c_busiSort.getPbusisortid() && !"418f0975f373470581711826bf5b3711".equals(c_busiSort.getPbusisortid())){
			C_busiSort busiSort= new C_busiSort();
			busiSort.setBusisortid(c_busiSort.getPbusisortid());
			busiSort.setUnitUid(c_busiSort.getUnitUid());
			C_busiSort busisortInfo = busiSortService.selectOneBusiSortInfo(busiSort);
			busisortfullcode=busisortInfo==null?"":busisortInfo.getBusisortfullcode();
			c_busiSort.setBusisortfullcode(busisortfullcode);//业务品种完整编号
		}else{
			busisortfullcode="418f0975f373470581711826bf5b3711/";
		}
		busisortfullcode+=c_busiSort.getBusisortid()+"/";
		c_busiSort.setBusisortfullcode(busisortfullcode);
		Boolean bool = busiSortService.insertOneBusiSortInfo(c_busiSort,SystemSession.getUserSession());
		AjaxRes ar = new AjaxRes();
		if(bool){ //若完成修改,则返回当前对象
			ar.setSucceed(c_busiSort);
		}else{
			ar.setSucceed(null);
		}
		return ar;
	}
	
	/**
	 * 查询一个业务品种信息
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 上午11:35:39
	 */
	@RequestMapping(value="/selectOneBusiSortsInfo" , method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneBusiSortsInfo(@RequestBody C_busiSort c_busiSort){
		C_busiSort c = busiSortService.selectOneBusiSortInfo(c_busiSort);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(c);
		return ar;
	}
	
	
	/**
	 * 更新一个 业务品种信息 
	 * @description 修改
	 * @author wuhn
	 * @date 2017年4月26日 下午1:00:54
	 */
	@RequestMapping(value="/updateOneBusiSortsInfo" , method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneBusiSortsInfo(@RequestBody C_busiSort c_busiSort){
		c_busiSort.setUpdateUser(SystemSession.getUserSession().getUser_name());
		Boolean updateOneBusiSortInfo = busiSortService.updateOneBusiSortInfo(c_busiSort,SystemSession.getUserSession());
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(updateOneBusiSortInfo);
		return ar;
	}
	
	
	/**
	 * 删除一个业务品种信息
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 下午1:01:53
	 */
	@RequestMapping(value="/deleteOneBusiSortsInfo" , method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneBusiSortsInfo(@RequestBody C_busiSort c_busiSort){
		Boolean deleteOneBusiSortInfo = busiSortService.deleteOneBusiSortInfo(c_busiSort,SystemSession.getUserSession());
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(deleteOneBusiSortInfo);
		return ar;
	}
	
	/**
	 * 添加时判断业务品种名称是否重复
	 * @param c_busiSort
	 * @return
	 */
	@RequestMapping(value = "/selectAddBusiSortNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAddBusiSortNameIsExist(@RequestBody C_busiSort c_busiSort){
		String wheresql="";
		if(c_busiSort!=null){
			if(c_busiSort.getBusisortname()!=null){
				wheresql=wheresql+" and busisortname = \'"+((String) c_busiSort.getBusisortname()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=busiSortService.selectBusiSortIsExist(wheresql);
		if(b){//存在置为false
			b=false;
		}else{
			b=true;
		}
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 修改时判断业务品种名称是否重复
	 * @param c_busiSort
	 * @return
	 */
	@RequestMapping(value = "/selectEditBusiSortNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEditBusiSortNameIsExist(@RequestBody  C_busiSort c_busiSort){
		String wheresql="";
		AjaxRes ar=new AjaxRes();
		String busisortname = c_busiSort.getBusisortname();
		C_busiSort BusiSortInfo = busiSortService.selectOneBusiSortInfo(c_busiSort);
		if(busisortname.equals(BusiSortInfo.getBusisortname())){ //取当前名称和数据库中的名称进行对比,若一致，不进行处理
			ar.setSucceed(true);
			return ar;
		}
		if(busisortname != null){
			wheresql=wheresql+" and busisortname = \'"+((String) busisortname).trim()+"\'";
		}
		Boolean b=busiSortService.selectBusiSortIsExist(wheresql);
		if(b){
			b=false; //若存在，只为false，验证不通过
		}else{
			b=true; // 不存在，true,验证通过
		}
		ar.setSucceed(b);
		return ar;
	}
	
}

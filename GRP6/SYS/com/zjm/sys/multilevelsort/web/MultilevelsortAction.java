package com.zjm.sys.multilevelsort.web;

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

import com.zjm.common.db.model.AjaxRes;
import com.zjm.sys.db.model.C_multiLevelSort;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.sys.multilevelsort.service.MultiLevelSortService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

/**
*  @description 多级字典
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年5月2日 19:22:18
*/
@Controller
public class MultilevelsortAction {
	
	@Resource
	private	MultiLevelSortService  multiLevelSortService;
	
	/**
	 * 
	 * @description  初始化多级字典,获得左侧树形菜单
	 * @author wuhn
	 * @date 2017年5月2日 下午7:40:40
	 */
	@RequestMapping(value="/selectAllmultilevelsortListTree",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllmultilevelsortListTree(){
		Map<String, Object> map=new HashMap<>();
		List<Map<String, Object>> mapList=new ArrayList<>();
//		//初始化设置值
//		map.put("id", "1");
//		map.put("pId", "-1");
//		map.put("name", "多级字典设置");
//		map.put("open", true);
//		mapList.add(map);
		String sql="";
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//sql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		List<C_multiLevelSort> list = multiLevelSortService.selectAllmultilevelsortList(sql);
		for (C_multiLevelSort multiLevel : list) {
			map=new HashMap<>();
			map.put("id", multiLevel.getMultilevelsortid());
			map.put("pId", multiLevel.getPmultilevelsortid());
			map.put("name", multiLevel.getMultilevelsortname());
			if("f1ab5bf4aa3948e690e808d9127e7d6b".equals(multiLevel.getMultilevelsortid())){//默认展开根节点
				map.put("open", true);
			}
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 
	 * @description  根据字典类型,获得树型下拉框
	 * @author zky
	 * @date 2017年5月2日 下午7:40:40
	 */
	@RequestMapping(value="/selectMultilevelsortTreeByFullCode",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectMultilevelsortTreeByFullCode(){
		Map<String, Object> map=new HashMap<>();
		List<Map<String, Object>> mapList=new ArrayList<>();
		List<C_multiLevelSort> list = multiLevelSortService.selectAllmultilevelsortList("");
		for (C_multiLevelSort multiLevel : list) {
			map=new HashMap<>();
			map.put("id", multiLevel.getMultilevelsortid());
			map.put("pId", multiLevel.getPmultilevelsortid());
			map.put("name", multiLevel.getMultilevelsortname());
			mapList.add(map);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	/**
	 * 
	 * @description 多级字典 获取右侧分页列表--单击/点击节点执行的action
	 * @author wuhn
	 * @date 2017年5月2日 下午8:16:02
	 */
	@RequestMapping(value="/selectAllmultilevelsortListPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllmultilevelsortListPageTables(@RequestBody PageTable<C_multiLevelSort> pageTable){
		String wheresql = queryConditionSql(pageTable);//获取查询条件
		pageTable.setWheresql(wheresql);//拼接查询条件
		pageTable=multiLevelSortService.selectmultilevelsortPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 多级字典  右侧分页列表查询条件  
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(@RequestBody PageTable<C_multiLevelSort> pageTable){
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and multilevelsortname like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//wheresql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		
		if(pageTable.getQueryCondition()!=null){
			if ( null == pageTable.getSearchText()) {
				String pmultilevelsortid = pageTable.getQueryCondition().getPmultilevelsortid();// 多级字典父类id
				if(pmultilevelsortid!=null && !pmultilevelsortid.equals("") && !pmultilevelsortid.equals("1")){
					wheresql=wheresql+" and pmultilevelsortid  like \'%"+pmultilevelsortid+"%\'";
				}
				String multilevelsortid = pageTable.getQueryCondition().getMultilevelsortid();
				if(multilevelsortid != null && !multilevelsortid.equals("")){
					wheresql+=" and multilevelsortid='"+ multilevelsortid+"'";
				}
				
				
			}
			
		}
		String sortName = pageTable.getSortName();
		String sortOrder = pageTable.getSortOrder();
		if(sortName!=null && !sortName.equals("") && sortOrder!=null && !sortOrder.equals("")){
				wheresql=wheresql+" order by "+sortName.trim()+"  " +sortOrder+"";
		}else{
			wheresql=wheresql+" ORDER BY order_id ";
		}
		return wheresql;
	}
	
	/**
	 * 
	 * @description  多级字典同级顺序调整， 排序
	 * @author wuhn
	 * @date 2017年5月2日 下午8:17:38
	 */
	@RequestMapping(value="/selectMultilevelsortListJSON",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectMultilevelsortListJSON(@RequestBody C_multiLevelSort c_multiLevelSort){
		Map<String,String> map=new HashMap<>();
		List<Map<String,String>> mapList=new ArrayList<>();
		String wheresql="" ;
		if(null != c_multiLevelSort){ //添加父节点
			wheresql=wheresql+" and pmultilevelsortid = '"+c_multiLevelSort.getPmultilevelsortid()+"'";
		}
		
		User userSession = SystemSession.getUserSession();
		if(userSession != null){
			//wheresql+=" and unit_uid ='"+ userSession.getUnit_uid()+"'";
		}
		
		List<C_multiLevelSort> lsit = multiLevelSortService.selectAllmultilevelsortList(wheresql);
		for (C_multiLevelSort mulitLevelSort : lsit) {
			//拼接 id--name 格式的map
			map.put(mulitLevelSort.getMultilevelsortid(), mulitLevelSort.getMultilevelsortname());
			mapList.add(map);
			map=new HashMap<>();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	
	
	/**
	 * 
	 * @description 插入/添加/新增一个多级字典
	 * @author wuhn
	 * @date 2017年5月2日 下午8:42:38
	 */
	@RequestMapping(value="/insertOneMultilevelsortInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneMultilevelsortInfo(@RequestBody C_multiLevelSort c_multiLevelSort){
		User sys_users = SystemSession.getUserSession();//获取机构id
		if(null != sys_users){
			c_multiLevelSort.setUnitUid(sys_users.getUnit_uid());
			c_multiLevelSort.setCreateUser(sys_users.getCreate_user());
			c_multiLevelSort.setUpdateUser(sys_users.getUpdate_user());
		}
		String multilevelsortfullcode =""; //拼接完整编码
		//判断是否是根节点,默认为: f1ab5bf4aa3948e690e808d9127e7d6b
		if(null != c_multiLevelSort && !"f1ab5bf4aa3948e690e808d9127e7d6b".equals(c_multiLevelSort.getPmultilevelsortid())){ 
			C_multiLevelSort  multileve=new C_multiLevelSort();
			multileve.setMultilevelsortid(c_multiLevelSort.getPmultilevelsortid());
			multileve.setUnitUid(c_multiLevelSort.getUnitUid());
			C_multiLevelSort multileveInfo = multiLevelSortService.selectOnemultilevelsortInfo(multileve);//获取父节点信息
			multilevelsortfullcode=multileveInfo==null?"":	multileveInfo.getMultilevelsortfullcode();
			c_multiLevelSort.setMultilevelsortfullcode(multilevelsortfullcode);
		}else{
			multilevelsortfullcode="f1ab5bf4aa3948e690e808d9127e7d6b/";
		}
		
		c_multiLevelSort.setMultilevelsortid(Tool.createUUID32()); //添加 多级字典id(uuid格式)
		multilevelsortfullcode+=c_multiLevelSort.getMultilevelsortid()+"/";
		c_multiLevelSort.setMultilevelsortfullcode(multilevelsortfullcode);
		Boolean bool = multiLevelSortService.insertOnemultilevelsortInfo(c_multiLevelSort,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		if(bool){//若添加成功,则将添加对象返回给前台
			ar.setSucceed(c_multiLevelSort);
		}else{
			ar.setSucceed(null);
		}
		return ar;
	}
	
	
	/**
	 * 
	 * @description 查询一个多级字典的信息
	 * @author wuhn
	 * @date 2017年5月2日 下午9:40:10
	 */
	@RequestMapping(value="/selectOneMultilevelsortInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneMultilevelsortInfo(@RequestBody C_multiLevelSort c_multiLevelSort){
		C_multiLevelSort multilevelsortInfo = multiLevelSortService.selectOnemultilevelsortInfo(c_multiLevelSort);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(multilevelsortInfo);
		return ar;
	}
	
	/**
	 * 
	 * @description 更新 修改一个 多级字典信息
	 * @author wuhn
	 * @date 2017年5月2日 下午9:35:41
	 */
	@RequestMapping(value="/updateOneMultilevelsortInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneMultilevelsortInfo(@RequestBody C_multiLevelSort c_multiLevelSort){
		c_multiLevelSort.setUpdateUser(SystemSession.getUserSession().getUser_name());
		Boolean bool = multiLevelSortService.updateOnemultilevelsortInfo(c_multiLevelSort,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	
	/**
	 * 
	 * @description  删除 移除 一个多级字典信息
	 * @author wuhn
	 * @date 2017年5月2日 下午9:35:57
	 */
	@RequestMapping(value="/deleteOneMultilevelsortInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneMultilevelsortInfo(@RequestBody C_multiLevelSort c_multiLevelSort){
		Boolean bool = multiLevelSortService.deleteOnemultilevelsortInfo(c_multiLevelSort,SystemSession.getUserSession());
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	
	
	/**
	 * 
	 * @description  添加多级字典时,判断 多级字典名称是否重复
	 * @author wuhn
	 * @date 2017年5月3日 上午10:09:38
	 */
	@RequestMapping(value="/selectAddMmultilevelSortNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selecAddMmultilevelSortNameIsExist(@RequestBody C_multiLevelSort c_multiLevelSort){
		String wheresql="";
		if(null != c_multiLevelSort){
			if(null != c_multiLevelSort.getMultilevelsortname()){
				wheresql+="and multilevelsortname= '"+c_multiLevelSort.getMultilevelsortname()+"'";
			}
		}
		Boolean bool = multiLevelSortService.selectmultilevelsortIsExist(wheresql);
		if(bool){
			bool=false;
		}else{
			bool=true;
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	
	/**
	 * 
	 * @description  修改的时候判断多级字典名称是否重复
	 * @author wuhn
	 * @date 2017年5月3日 上午10:33:37
	 */
	@RequestMapping(value="/selectEditMmultilevelSortNameIsExist",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEditMmultilevelSortNameIsExist(@RequestBody C_multiLevelSort c_multiLevelSort){
		String wheresql="";
		AjaxRes ar=new AjaxRes();
		String multilevelsortname = c_multiLevelSort.getMultilevelsortname();
		C_multiLevelSort multilevelsortInfo = multiLevelSortService.selectOnemultilevelsortInfo(c_multiLevelSort);
		if(multilevelsortInfo.getMultilevelsortname().equals(multilevelsortname)){
			ar.setSucceed(true); //若前台传的值和数据库中存储的一致 --》名称没有修改
			return ar;
		}
		if(null != multilevelsortname){
			wheresql+=" and multilevelsortname='"+multilevelsortname.trim()+"'";
		}
		Boolean bool = multiLevelSortService.selectmultilevelsortIsExist(wheresql);
		if(bool){ //存在置为false,验证不通过
			bool=false;
		}else{
			bool=true;
		}
		ar.setSucceed(bool);
		return ar;
	}
	
}

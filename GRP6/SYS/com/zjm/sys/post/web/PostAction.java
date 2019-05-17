package com.zjm.sys.post.web;

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
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.map.Sys_dep_userMapper;
import com.zjm.sys.db.model.Sys_dep_post;
import com.zjm.sys.db.model.Sys_dep_user;
import com.zjm.sys.db.model.Sys_post;
import com.zjm.sys.post.service.PostService;
import com.zjm.util.SystemSession;

/**
 * 岗位设置
 * @author zky add 20170504
 */
@Controller
public class PostAction {
	@Resource
	private PostService postService;
	@Resource
	private Sys_dep_userMapper  sys_dep_userMapper;
	
	/**
	 * 插入一个岗位信息
	 * @return
	 */
	@RequestMapping(value="/insertOnePostInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOnePostInfo(@RequestBody Sys_post sys_post){
		AjaxRes ar=new AjaxRes();
		sys_post.setUnit_uid(SystemSession.getUserSession().getUnit_uid());//获取担保机构id
		sys_post.setCreateUserName(SystemSession.getUserSession().getUser_name());
		Boolean bool=postService.insertOnePostInfo(sys_post,SystemSession.getUserSession());
		ar.setSucceed(bool);
		return ar;
	}
	/**
	 * 查询所有岗位信息  用于树形显示
	 * @return
	 */
	@RequestMapping(value="/selectAllPostListTree", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectAllPostListTree(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map =new HashMap<String,Object>();
		List<Sys_post> postList = postService.selectAllPostList(" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		for (Sys_post post : postList) {
			map =new HashMap<String,Object>();
			map.put("id", post.getPost_ID());
			map.put("pId", post.getParentPostID());
			map.put("name", post.getPostName());
			mapList.add(map);
		}		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 查询岗位分页列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectPostPageTables")
	@ResponseBody
	public AjaxRes selectPostPageTables(@RequestBody PageTable pageTable) {
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=postService.selectPostPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 岗位分页列表查询条件
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql="";
		if(pageTable==null){
			return "";
		}
		wheresql=wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and postName like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			String post_ID = pageTable.getQueryCondition().getPost_ID();
			if(post_ID!=null && !post_ID.equals("") && !post_ID.equals("1d6036039f5949e7b2b8a02be61bd7d2")){
				wheresql=wheresql+" and post_ID =\'"+post_ID.trim()+"\'";
			}
			String parentPostID = pageTable.getQueryCondition().getParentPostID();
			if(parentPostID !=null && !"".equals(parentPostID)){
				wheresql+=" and parentPostID= '"+parentPostID+"'"; 
			}
		}
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql+" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"";
		}else{
			wheresql=wheresql+" ORDER BY post_ID ";
		}
		return wheresql;
	}
	/**
	 * 查询一个岗位信息
	 * @param sys_post
	 * @return
	 */
	@RequestMapping(value="/selectOnePostInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOnePostInfo(@RequestBody Sys_post sys_post){
		AjaxRes ar=new AjaxRes();
		Sys_post post = postService.selectOnePostInfo(sys_post);
		ar.setSucceed(post);
		return ar;
	}
	/**
	 * 更新一个岗位信息
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value="/updateOnePostInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOnePostInfo(@RequestBody Sys_post  sys_post){
		AjaxRes ar=new AjaxRes();
		Boolean bool = postService.updateOnePostInfo(sys_post,SystemSession.getUserSession());
		ar.setSucceed(bool);
		return ar;
	}
	/**
	 * 删除一个岗位信息
	 * @param sys_post
	 * @return
	 */
	@RequestMapping(value="/deleteOnePostInfo")
	@ResponseBody
	public AjaxRes deleteOnePostInfo(@RequestBody Sys_post sys_post){
		AjaxRes ar=new AjaxRes();
		Boolean b=postService.deleteOnePostInfo(sys_post,SystemSession.getUserSession());
		ar.setSucceed(b);
		return ar;
	}
	/**
	 * 查询所有岗位json
	 * @return
	 */
	@RequestMapping(value="/selectPostListJSON", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectPostListJSON(@RequestBody Sys_post sys_post){
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		String wheresql="";
		wheresql=wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		if(sys_post!=null){
			if(sys_post.getParentPostID() != null){
				wheresql = wheresql+ "and parentPostID = \'"+sys_post.getParentPostID()+"\'";
			}
		}
		List<Sys_post> postList = postService.selectAllPostList(wheresql);
		for (Sys_post post : postList) {
			map = new HashMap<String, String>();
			map.put(post.getPost_ID(), post.getPostName());
			mapList.add(map);
			
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	/**
	 * 添加时判断岗位名是否重复
	 * @param sys_modules
	 * @return
	 */
	@RequestMapping(value = "/selectAddPostNameIsExist")
	@ResponseBody
	public AjaxRes selectAddPostNameIsExist(@RequestBody Sys_post sys_post){
		String wheresql="";
		wheresql=wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		if(sys_post!=null){
			if(sys_post.getPostName() !=null){
				wheresql=wheresql+" and postName = \'"+((String) sys_post.getPostName()).trim()+"\'";
			}
			// 同级岗位不能重复
			if(sys_post.getParentPostID() != null){
				wheresql=wheresql+" and parentPostID = \'"+((String) sys_post.getParentPostID()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=postService.selectPostIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 修改时判断部门名称是否重复
	 * @param sys_departs
	 * @return
	 */
	@RequestMapping(value = "/selectEditPostNameIsExist")
	@ResponseBody
	public AjaxRes selectEditPostNameIsExist(@RequestBody Sys_post sys_post){
		String wheresql="";
		wheresql=wheresql+" and unit_uid=\'"+SystemSession.getUserSession().getUnit_uid()+"\'";
		if(sys_post!=null){
			if(sys_post.getPost_ID() != null){
				wheresql=wheresql+" and post_ID != \'"+((String) sys_post.getPost_ID()).trim()+"\'";
			}
			if(sys_post.getPostName() !=null){
				wheresql=wheresql+" and postName = \'"+((String) sys_post.getPostName()).trim()+"\'";
			}
			// 同级岗位不能重复
			if(sys_post.getParentPostID() != null){
				wheresql=wheresql+" and parentPostID = \'"+((String) sys_post.getParentPostID()).trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=postService.selectPostIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 
	 * @description	获取岗位信息 list  由部门id和机构id获取岗位信息
	 * @author wuhn
	 * @date 2017年6月7日 下午8:25:09
	 */
	@RequestMapping(value = "/selectPostList")
	@ResponseBody
	public AjaxRes selectPostList(@RequestBody Sys_dep_post sys_dep_post){
		sys_dep_post.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		//获取用户所在的部门 --- >根据用户id 获取所在部门id
		if( null != sys_dep_post.getUser_uid()){
			Sys_dep_user depUser=new Sys_dep_user();
			depUser.setUser_uid(sys_dep_post.getUser_uid()); 
			depUser = sys_dep_userMapper.selectOneDepUserInfo(depUser);
			sys_dep_post.setDepart_uid(depUser.getDepart_uid());
		}
		
		List<Sys_post> postList = postService.selectPostListByDepart(sys_dep_post);
		AjaxRes ar=new AjaxRes();
		List<Map<String,String>> mapList=new ArrayList<>();
		Map<String,String> map=new HashMap<>();
		for (Sys_post post : postList) {
			map.put(post.getPost_ID(), post.getPostName());
			mapList.add(map);
			map=new HashMap<>();
		}
		ar.setSucceed(mapList);
		return ar;
	}
	
	
	
}

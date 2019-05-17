package com.zjm.pro.suggest.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_suggest;
import com.zjm.pro.suggest.service.ProjectSuggestService;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/suggest")
public class SuggestAction {
	
	
	@Resource
	private ProjectSuggestService projectSuggestService;
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private DicTypeService dicTypeService;
	
	
	/**
	 * 申请的分页列表查询条件
	 */
	private String queryConditionSql(Pro_suggest suggest){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(suggest==null){
			return "";
		}
		//wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		if(suggest.getTaskID() != null && !"".equals(suggest.getTaskID())){
			//wheresql.append(" and taskID like \'%"+pageTable.getQueryCondition().getProjectName()+"%\'");
			wheresql.append(" and taskID = \'"+suggest.getTaskID()+"\'");
		}
		if(suggest.getEntityID() != null && !"".equals(suggest.getEntityID())){
			wheresql.append(" and entityID = \'"+suggest.getEntityID()+"\'");
		}
		if(suggest.getTaskName() != null && !"".equals(suggest.getTaskName())){
			wheresql.append(" and taskName = \'"+suggest.getTaskName()+"\'");
		}
		if(suggest.getProductInstanceID() != null && !"".equals(suggest.getProductInstanceID())){
			wheresql.append(" and productInstanceID = \'"+suggest.getProductInstanceID()+"\'");
		}
		return wheresql.toString();		
	}
	
	/**
	 * 事项-办理-跳转到意见修办理页面
	 * @param suggest
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/projectSuggetEditPage")
	public ModelAndView projectSuggetEditPage(Pro_suggest pro_suggest) throws UnsupportedEncodingException{
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		List<Pro_suggest> projectSuggestList = new ArrayList<>();
		Pro_apply apply = new Pro_apply();
		pro_suggest.setTaskName(java.net.URLDecoder.decode(pro_suggest.getTaskName(),"UTF-8"));
	    String  wheresql = queryConditionSql(pro_suggest);	    
		Pro_suggest suggest= projectSuggestService.selectOneSuggestByWhereSql(wheresql);
		projectSuggestList = projectSuggestService.selectSuggestListByWhereSql(" and entityID = \'"+pro_suggest.getEntityID()+"\'");//获取意见集合;
		apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+pro_suggest.getEntityID()+"\'");
		if(null != suggest){
			pro_suggest.setSuggest_ID(suggest.getSuggest_ID());
			pro_suggest.setSuggestContent(suggest.getSuggestContent());
		}
		mv.getModelMap().put("suggest",pro_suggest);
		mv.getModelMap().put("apply",apply);
		mv.getModelMap().put("projectSuggestList",projectSuggestList);//历史项目意见list
		mv.setViewName("/project/suggest/projectSuggest/projectSuggest");
		return mv;
	}
	/**
	 * 手机事项-办理-跳转到意见 查看办理页面
	 * @param suggest
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/projectSuggetEditPageAPP", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes projectSuggetEditPageAPP(@RequestBody Pro_suggest pro_suggest) throws UnsupportedEncodingException{
		AjaxRes ar=new AjaxRes();
		List<Pro_suggest> projectSuggestLists = new ArrayList<>();
		List<Object> projectSuggestList = new ArrayList<>();
		Pro_apply apply = new Pro_apply();
		pro_suggest.setTaskName(java.net.URLDecoder.decode(pro_suggest.getTaskName(),"UTF-8"));
	    String  wheresql = queryConditionSql(pro_suggest);	    
		Pro_suggest suggest= projectSuggestService.selectOneSuggestByWhereSql(wheresql);
		projectSuggestLists = projectSuggestService.selectSuggestListByWhereSql(" and entityID = \'"+pro_suggest.getEntityID()+"\'");//获取意见集合;
		apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+pro_suggest.getEntityID()+"\'");
		if(null != suggest){
			pro_suggest.setSuggest_ID(suggest.getSuggest_ID());
			pro_suggest.setSuggestContent(suggest.getSuggestContent());
		}
		pro_suggest.setSuggestList(projectSuggestLists);
		projectSuggestList.add(pro_suggest);
		projectSuggestList.add(apply);
		ar.setSucceed(projectSuggestList);
		return ar;
	}
	/**
	 * insertProjectSuggest
	 * 新增项目意见信息;
	 *  
	 */
	@RequestMapping(value="/insertProjectSuggest", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertProjectSuggest(@RequestBody Pro_suggest suggest){
		Boolean b = false;	
		if(suggest  != null){
			try {
				b = projectSuggestService.insertOneSuggestInfo(SystemSession.getUserSession(), suggest);
			} catch (Exception e) {
				e.printStackTrace();
			}		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 *事项办理-意见查看
	 */
	@RequestMapping(value="/selectProjectSuggestInfo")
	public ModelAndView selectProjectSuggestInfo(Pro_suggest pro_suggest){		
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		String  wheresql = queryConditionSql(pro_suggest);
		
		Pro_suggest suggest= projectSuggestService.selectOneSuggestByWhereSql(wheresql);
		mv.getModelMap().put("suggest",suggest);
		mv.setViewName("/project/suggest/projectSuggest/projectSuggestInfo");
		return mv;
	}
	
	
	
	
	
	/**
	 * 跳转到意见修改页面
	 * @param project_ID
	 * @return
	 */
	@RequestMapping(value="/returnProjectSuggestEditPage")
	public ModelAndView returnProjectSuggestEditPage(String suggest_ID,String entityID, String type){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Pro_apply apply = new Pro_apply();
		Pro_suggest suggest  = new Pro_suggest (); 
	    if(null != entityID){
		   //根据apply_id获取项目摘要信息;
		   apply= projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+entityID+"\'");
		   
	    }
	    if(null != suggest_ID){
	    	suggest= projectSuggestService.selectOneSuggestByWhereSql(" and suggest_ID = \'"+suggest_ID+"\'");
	    }
		mv.getModel().put("apply",apply);
		mv.getModel().put("suggest",suggest);
		mv.getModel().put("type", type);
		/*List<C_dictype> suggestContentList = dicTypeService.selectAllDicTypeList(" and dicTypePID='52b9eab7bbe343f2955ef878b83dd20e'");//获取意见常用语来源下拉框;
		mv.getModelMap().put("suggestContentList",suggestContentList);	*/
		mv.setViewName("/project/suggest/projectSuggest/projectSuggestEdit");
		return mv;
	}
	
	/**
	 *手机端---- 跳转到意见修改页面
	 * @param project_ID,apply_ID
	 * @return
	 */
	@RequestMapping(value="/returnProjectSuggestEditPageApp")
	@ResponseBody
	public AjaxRes returnProjectSuggestEditPageApp(String suggest_ID,String apply_ID){
		AjaxRes ar = new AjaxRes();
		Pro_apply apply = new Pro_apply();
		Pro_suggest suggest  = new Pro_suggest (); 
	    if(null != apply_ID){
		   //根据apply_id获取项目摘要信息;
		   apply= projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+apply_ID+"\'");
		   
	    }
	    if(null != suggest_ID){
	    	suggest= projectSuggestService.selectOneSuggestByWhereSql(" and suggest_ID = \'"+suggest_ID+"\'");
	    }
	    List<Object> objectList = new ArrayList<>();
		//mv.getModel().put("apply",apply);
		//mv.getModel().put("suggest",suggest);
		objectList.add(apply);
		objectList.add(suggest);
		/*List<C_dictype> suggestContentList = dicTypeService.selectAllDicTypeList(" and dicTypePID='52b9eab7bbe343f2955ef878b83dd20e'");//获取意见常用语来源下拉框;
		mv.getModelMap().put("suggestContentList",suggestContentList);	*/
		ar.setSucceed(objectList);
		return ar;
	}
	
	
	
	
	
	
	/**
	 *APP  事项-办理-跳转到意见修办理页面
 * @param entityID,entityType,taskID,taskName,productInstanceID
	 * @return
	 * @throws  
	 * 
	 */
	/*@RequestMapping(value="/projectSuggetEditPageAPP")
	@ResponseBody
	public AjaxRes stopProjectViewPageAPP(@RequestBody Pro_suggest pro_suggest) throws UnsupportedEncodingException{
		pro_suggest.setTaskName(java.net.URLDecoder.decode(pro_suggest.getTaskName(),"UTF-8"));
	    String  wheresql = queryConditionSql(pro_suggest);	    
		Pro_suggest suggest= projectSuggestService.selectOneSuggestByWhereSql(wheresql);
		if(null != suggest){
			pro_suggest.setSuggest_ID(suggest.getSuggest_ID());
			pro_suggest.setSuggestContent(suggest.getSuggestContent());
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pro_suggest);
		return ar;
	}*/
	
	
}

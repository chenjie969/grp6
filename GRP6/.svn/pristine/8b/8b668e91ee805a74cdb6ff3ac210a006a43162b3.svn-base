package com.zjm.pro.arcMoveRec.web;
import java.io.UnsupportedEncodingException;
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
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.arcMoveRec.service.ArcMoveRecService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_arcMoveRec;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.projectfiles.service.ProjectfilesService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;
/**
 * 档案移交记录Action
 * @author zky
 *
 */
@Controller
@RequestMapping(value="/project/arcMoveRec")
public class arcMoveRecAction {
	
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private ArcMoveRecService arcMoveRecService;
	@Resource
	private ProjectfilesService filesService;
	
	/**
	 * 档案移交记录分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_arcMoveRec> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		//根据业务ID(apply_ID)
		if(pageTable.getQueryCondition().getApply_ID() != null && !"".equals(pageTable.getQueryCondition().getApply_ID())){
			wheresql.append(" and apply_ID = \'"+pageTable.getQueryCondition().getApply_ID()+"\'");
		}
		//根据状态值(status)
		if(pageTable.getQueryCondition().getStatus() != null && !"".equals(pageTable.getQueryCondition().getStatus())){
			wheresql.append(" and status = \'"+pageTable.getQueryCondition().getStatus()+"\'");
		}
		return wheresql.toString();		
	}
	
	/**
	 * 
	 * @Title: returArcMoveIndex   
	 * @Description: 跳转到档案移交目录及清单页面
	 *  携带参数operationType:accept 用于控制按钮的显示与隐藏
	 * @param: @param urlParam
	 * @param: @return
	 * @param: @throws UnsupportedEncodingException      
	 * @return: ModelAndView      
	 * @throws
	 */
	@RequestMapping(value="/returArcMoveRecIndex")
	public ModelAndView returArcMoveRecIndex(UrlParam urlParam) throws UnsupportedEncodingException{
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply apply = new Pro_apply();
		urlParam.setTaskName(java.net.URLDecoder.decode(urlParam.getTaskName(),"UTF-8"));
		apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		List<Pro_projectfiles> files = filesService.selectListProFilesByWhereSql(" and entityID = '"+urlParam.getEntityID()+"'");
		
		mv.getModelMap().put("files", files);
		mv.getModelMap().put("operationType","accept");
		mv.getModelMap().put("apply",apply);
		mv.setViewName("/project/arcMove/arcMoveRec");
		return mv;
	}
	/**
	 * 
	 * @Title: returArcMoveIndex   
	 * @Description: 跳转到新增档案移交目录及清单页面:
	 *  携带参数operationType:add 用于控制按钮的显示与隐藏
	 * @param: @param urlParam
	 * @param: @return
	 * @param: @throws UnsupportedEncodingException      
	 * @return: ModelAndView      
	 * @throws
	 */
	@RequestMapping(value="/returArcMoveRecAddIndex")
	public ModelAndView returArcMoveRecAddIndex(UrlParam urlParam) throws UnsupportedEncodingException{
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		Pro_apply apply = new Pro_apply();
		urlParam.setTaskName(java.net.URLDecoder.decode(urlParam.getTaskName(),"UTF-8"));
		apply = projectApplyService.selectOneApplyByWhereSql(" and apply_ID = \'"+urlParam.getEntityID()+"\'");
		mv.getModelMap().put("operationType","add");
		mv.getModelMap().put("apply",apply);
		mv.setViewName("/project/arcMove/arcMoveRec");
		return mv;
	}
	
	/**
	 * 获取档案移交记录table
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value="/selectArcMoveRecPageTable")
	@ResponseBody
	public AjaxRes selectArcMoveRecPageTable(@RequestBody PageTable<Pro_arcMoveRec> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = arcMoveRecService.selectArcMoveRecPageTables(pageTable);		
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	/**
	 * @Description: 跳转到新增档案移交页面
	 * @param apply_ID
	 * @return
	 */
	@RequestMapping(value="/returnArcMoveRecAddPage")
	public ModelAndView returnArcMoveRecAddPage(Pro_arcMoveRec arcMoveRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("arcMoveRec",arcMoveRec);
		mv.setViewName("/project/arcMove/arcMoveRecAdd");
		return mv;
	}
	/***
	 * 新增一条档案移交记录信息
	 * @param arcMoveRec
	 * @return
	 */
	@RequestMapping(value="/insertOneArcMoveRec")
	@ResponseBody
	public AjaxRes insertOneArcMoveRec(@RequestBody Pro_arcMoveRec arcMoveRec){
		AjaxRes ar = new AjaxRes();
		arcMoveRec.setArcMoveRec_ID(Tool.createUUID32());
		Boolean returnBool = arcMoveRecService.insertOneArcMoveRecInfo(SystemSession.getUserSession(), arcMoveRec);
		ar.setSucceed(returnBool);
		return ar;
	}
	
	/**
	 * @Description: 跳转到新增档案移交页面主页面
	 * @param arcTypeID
	 * @return
	 */
	@RequestMapping(value="/openArcMoveAddIndex")
	public ModelAndView openArcMoveAddIndex(Pro_arcMoveRec arcMoveRec){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModelMap().put("arcMoveRec",arcMoveRec);
		mv.setViewName("/project/arcMove/arcMoveAddIndex");
		return mv;
	}
	/**
	 * 删除单个档案记录
	 * @param arcMoveRec
	 * @return
	 */
	@RequestMapping(value="/delOneArcMoveRec")
	@ResponseBody
	public AjaxRes delOneArcMoveRec(@RequestBody Pro_arcMoveRec arcMoveRec){
		AjaxRes ar = new AjaxRes();
		Boolean returnBool = false;
		try {
			returnBool = arcMoveRecService.deleteOneArcMoveRecInfo(SystemSession.getUserSession(), arcMoveRec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(returnBool);
		return ar;
	}
	
	
}

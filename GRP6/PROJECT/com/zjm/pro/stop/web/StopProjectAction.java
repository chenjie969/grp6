package com.zjm.pro.stop.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.crm.db.model.Crm_relationMain;
import com.zjm.crm.relationMain.service.RelationMainService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/stop")
public class StopProjectAction {

	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private ApplyDetailService applyDetailService;
	
	@Resource
	private RelationMainService relationMainService;
	
	@Resource
	private DicTypeService dicTypeService;
	
	Crm_relationMain relationMain= new Crm_relationMain();
	
	
	
	/**
	 *否决项目分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_apply> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendProSqlByRole(pageTable.getQueryCondition().getUser_uid(),RolesDataAccreditUtil.PRO_CREATE_SQL_STR,"");
			if( null != sql){
				wheresql.append(sql);
			}
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		wheresql.append(" and isPutPackage = 0  ");//是否放入打包车
		wheresql.append(" and isStop = 1 ");//是否终止
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		
		return wheresql.toString();		
	}
	
	/**
	 * 显示页面-否决项目列表页面
	 * @param
	 * @author ZKY
	 * @time :2017-8-12
	 */
	@RequestMapping(value="/stopProjectTablePage")
	public ModelAndView applyTable(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/project/stop/stopProjectTable");
		return mv;
	}
	
	/**
	 * 查询否决项目列表页面分页列表
	 * @param PageTable<Pro_apply> pageTable
	 * @author ZKY
	 * @time :2017-8-12
	 */
	@RequestMapping(value="/selectStopProjectPageTable")
	@ResponseBody
	public AjaxRes selectStopProjectPageTable(@RequestBody PageTable<Pro_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = projectApplyService.selectApplyPageTables(pageTable);		
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 *项目管理-否决项目-查看页面
	 */
	@RequestMapping(value="/stopProjectViewPage")
	public ModelAndView stopProjectViewPage(Pro_apply pro_apply){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String whereSql = " and apply_ID = \'"+pro_apply.getApply_ID()+"\'";
		//根据apply_ID查询Pro_apply表信息;	
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
		mv.getModelMap().put("apply",apply);
		mv.setViewName("/project/stop/stopProjectInfo");
		return mv;
	}
}

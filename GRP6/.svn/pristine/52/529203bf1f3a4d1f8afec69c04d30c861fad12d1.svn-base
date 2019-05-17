package com.zjm.pro.projectFinish.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/projectFinish")
public class ProjectFinishAction {
	
	@Resource
	private ProjectService projectService;
	
	private String queryCondition(PageTable<Pro_project> pageTable) {
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		sb.append(" and pp.unit_uid= \'"+SystemSession.getUserSession().getUnit_uid()+"\'");
		sb.append(" and  ( pp.finishDate != '' and pp.finishDate is not NULL )  ");
		
		//根据当前用户所处的角色的数据权限以及是否属于项目的abc角进行查看项目的权限追加
		if( null != pageTable.getQueryCondition().getUser_uid()){
			String sql = RolesDataAccreditUtil.appendProSqlByABC(pageTable.getQueryCondition().getUser_uid(), "pp.");
			if(null != sql && !"".equals(sql)){
				sb.append(sql);
			}
		}
		//搜索框功能
		
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			sb.append(" and pp.projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return sb.toString();
	}
	/**
	 * @description完结项目列表
	 */
	@RequestMapping(value="/selectProjectFinishPageTables")
	@ResponseBody
	public AjaxRes selectProjectFinishPageTables(@RequestBody PageTable<Pro_project>  pageTable){
		AjaxRes  ar =new AjaxRes();
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable= projectService.selectProjectPageTables(pageTable);
		pageTable.setWheresql("");
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 完结项目列表：续作
	 * @description
	 */
	@RequestMapping(value="/projectContinue")
	@ResponseBody
	public AjaxRes projectContinue(@RequestBody  Pro_project  pro_project){
		AjaxRes  ar =new AjaxRes();
		Boolean b = false;
		try {
			b  = projectService.projectContinue(SystemSession.getUserSession(), pro_project);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(b);
		return ar;
	}
	
	
	
}

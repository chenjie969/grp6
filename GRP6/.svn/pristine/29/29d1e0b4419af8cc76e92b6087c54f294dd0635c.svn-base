package com.zjm.pro.projectLawsuit.web;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.index.service.IndexService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_projectLawsuit;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.projectLawsuit.service.ProjectLawsuitService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value = "/project/projectLawsuit")
public class ProjectLawsuitAction {
	@Resource
	private ProjectLawsuitService lawSuitService;		
	@Resource
	private ProjectService projectService;
	@Resource
	private IndexService indexService;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private DicTypeService dicTypeService;
	
	
	
	/**
	 * 项目诉讼登记页面
	 * pro_project
	 * @return
	 */
	@RequestMapping(value="/openProjectLawsuitPage")
	public ModelAndView openProjectLawsuitPage(String projectLawsuit_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		initDate(mv);
		if (projectLawsuit_ID != null && !"".equals(projectLawsuit_ID)){
			Pro_projectLawsuit projectLawsuit = lawSuitService.selectOneProjectLawsuitInfo(" and projectLawsuit_ID = \'"+projectLawsuit_ID+"\'");
			mv.getModelMap().put("projectLawsuit", projectLawsuit);
		}
		mv.setViewName("/project/lawsuit/projectLawsuit");
		return mv;		
	}

	private void initDate(ModelAndView mv){
		//单位名称
		List<C_dictype> guarantyOrgList = dicTypeService.selectAllDicTypeList(" and dicTypePID='78ae83f6524d458dbbd522324c80723d'");
		mv.getModelMap().put("guarantyOrgList",guarantyOrgList);
		
		//执行依据种类
		List<C_dictype> executionBasisTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='d8d61af21d0b4e86946f050db5b8950e'");
		mv.getModelMap().put("executionBasisTypeList",executionBasisTypeList);
		
		//对方类型
		List<C_dictype> otherPartyTypeList = dicTypeService.selectAllDicTypeList(" and dicTypePID='077a6326219540c68dae398846623579'");
		mv.getModelMap().put("otherPartyTypeList",otherPartyTypeList);
	}
//	/**
//	 * 跳转到项目诉讼页面
//	 * @param project_ID
//	 * @return
//	 */
	/*@RequestMapping(value="/projectAfterTrackingPage")
	public ModelAndView projectAfterTrackingPage(String apply_ID,String project_ID){
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		Index indexData = new Index();
		indexData = indexService.selectProData(SystemSession.getUserSession());
		mv.getModel().put("indexData",indexData);
		mv.setViewName("/project/apply/projectAfterTracking");	
		return mv;
	}*/
	
	/**
	 * 新增一个项目诉讼信息
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/insertOrUpdateProjectLawsuit", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOrUpdateProjectLawsuit(@RequestBody Pro_projectLawsuit projectLawsuit){
		AjaxRes ar=new AjaxRes();
		try{
			if (projectLawsuit != null && projectLawsuit.getProjectLawsuit_ID() != null && !"".equals(projectLawsuit.getProjectLawsuit_ID())) {
				String ifReview = String.valueOf(projectLawsuit.getIfReview()); 
				if(ifReview !=null && ifReview.equals("0")){ //未审结
					Pro_projectLawsuit proProjectLawsuit = lawSuitService.selectOneProjectLawsuitInfo(" and projectLawsuit_ID = \'"+projectLawsuit.getProjectLawsuit_ID()+"\'");
					if(proProjectLawsuit.getIfReview().equals("1")){ //判断此案审结后  被告是否上诉重启此案  上诉则保留原始数据  再进行新增
						projectLawsuit.setProjectLawsuit_ID(Tool.createUUID32());
						projectLawsuit.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
						projectLawsuit.setCreateUserName(SystemSession.getUserSession().getUser_name());
						ar.setSucceed ( lawSuitService.insertOneProjectLawsuit(SystemSession.getUserSession(), projectLawsuit));
					}else{
						projectLawsuit.setUpdateUserName(SystemSession.getUserSession().getUpdate_user());
						ar.setSucceed ( lawSuitService.updateOneProjectLawsuitInfo(SystemSession.getUserSession(), projectLawsuit));
					}
				}else{
					projectLawsuit.setUpdateUserName(SystemSession.getUserSession().getUpdate_user());
					ar.setSucceed ( lawSuitService.updateOneProjectLawsuitInfo(SystemSession.getUserSession(), projectLawsuit));
				}
				
			} else {
				projectLawsuit.setProjectLawsuit_ID(Tool.createUUID32());
				projectLawsuit.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
				projectLawsuit.setCreateUserName(SystemSession.getUserSession().getUser_name());
				ar.setSucceed ( lawSuitService.insertOneProjectLawsuit(SystemSession.getUserSession(), projectLawsuit));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 查询诉讼登记列表
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectProjectLawPageTables")
	@ResponseBody
	public AjaxRes selectProjectLawPageTables(@RequestBody PageTable<Pro_projectLawsuit> pageTable){
		AjaxRes ar =new AjaxRes();
		String queryCondition = queryCondition(pageTable);
		pageTable.setWheresql(queryCondition);
		pageTable = lawSuitService.selectProjectLawPageTables(pageTable);
		ar.setSucceed(pageTable);
		return ar;
	}
	
	private String queryCondition(PageTable<Pro_projectLawsuit> pageTable){
		StringBuffer sb=new StringBuffer();
		if (pageTable.getWheresql() != null) {
			sb.append(pageTable.getWheresql());
		}
		
		if (pageTable.getSearchText() != null && !"".equals(pageTable.getSearchText())) {
			sb.append(" and ( ");
			sb.append(" plaintiff like \'%"+pageTable.getSearchText()+"%\' ");
			sb.append(" or defendant like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or `group` like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" or projectNameList like \'%"+pageTable.getSearchText()+"%\'");
			sb.append(" )");
		}
		
		//根据主诉，被诉查询
		if (pageTable.getQueryCondition().getLawSuitType() != null && !"".equals(pageTable.getQueryCondition().getLawSuitType())) {
			sb.append(" and lawsuitType = \'"+pageTable.getQueryCondition().getLawSuitType()+"\'");
		}
		return sb.toString();
	}
	
	/**
	 * 打开案件执行页面
	 * @param projectLawsuit_ID
	 * @return
	 */
	@RequestMapping(value="/openExecuteCasePage")
	public ModelAndView openExecuteCasePage(String projectLawsuit_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		if (projectLawsuit_ID != null && !"".equals(projectLawsuit_ID)){
			Pro_projectLawsuit projectLawsuit = lawSuitService.selectOneProjectLawsuitInfo(" and projectLawsuit_ID = \'"+projectLawsuit_ID+"\'");
			mv.getModelMap().put("projectLawsuit", projectLawsuit);
		}
		mv.setViewName("/project/lawsuit/projectLawsuit");
		return mv;
	}
}

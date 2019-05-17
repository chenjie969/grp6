package com.zjm.pro.projectPackage.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_package;
import com.zjm.pro.projectPackage.service.PackageService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;

@Controller
@RequestMapping(value="/project/package")
public class PackageAction {

	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private PackageService packageService;
	
	
	/**
	 * 待打包项目页面分页列表
	 * @author chenyang
	 * @time :2017-7-5 
	 */
	@RequestMapping(value="/selectNoPackagePageTable")
	@ResponseBody
	public AjaxRes selectNoPackagePageTable(@RequestBody PageTable<Pro_apply> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable!=null){
			wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
			wheresql.append(" and isPutPackage = true" + " and isStop = false" + " and isPackage = false");
			
			//设置数据权限
			String sql = RolesDataAccreditUtil.appendProSqlByRole(SystemSession.getRealUserSession().getUser_uid(),RolesDataAccreditUtil.PRO_CREATE_SQL_STR,"");
			if( sql != null){
				wheresql.append(sql);
			}
			
			//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
			if ( null != pageTable.getSearchText()) {
				wheresql.append(" and projectName like \'%"+pageTable.getSearchText().trim()+"%\'");
			}
			/*if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql=wheresql.append(" ORDER BY "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"");
			}else{
				wheresql=wheresql.append(" ORDER BY createDate desc");
			}*/		
		}
		
		AjaxRes ar = new AjaxRes();
		pageTable.setWheresql(wheresql.toString());
		pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		pageTable = projectApplyService.selectApplyPageTables(pageTable);		
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 打包项目的分页列表查询条件
	 */
	private String queryConditionSql(PageTable<Pro_apply> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		/*wheresql.append(" and packageStatus = '\'打包阶段'\'");*/
		
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and packageName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
	/*	if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
			wheresql=wheresql.append(" ORDER BY "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"");
		}else{
			wheresql=wheresql.append(" ORDER BY createDateTime desc");
		}	*/	
		return wheresql.toString();		
	}
	
	/**
	 * 打包项目页面分页列表
	 * @author chenyang
	 * @time :2017-7-5 
	 */
	@RequestMapping(value="/selectPackagePageTable")
	@ResponseBody
	public AjaxRes selectPackagePageTable(@RequestBody PageTable<Pro_apply> pageTable){
		try {
			AjaxRes ar = new AjaxRes();
			pageTable.setWheresql(queryConditionSql(pageTable));
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable = packageService.selectPackagePageTables(pageTable);		
			ar.setSucceed(pageTable);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *待打包项目-打包所选页面
	 */
	@RequestMapping(value="/addPackagePage")
	public ModelAndView addPackagePage(String applyIDS){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String[] applyIDArray = applyIDS.split(",");
		List<Pro_apply> applyList = new ArrayList<>();
        for (int i = 0; i < applyIDArray.length; i++) {
        	String whereSql = " and apply_ID = \'"+applyIDArray[i]+"\'";
    		//根据apply_ID查询Pro_apply表信息;	
    		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
    		applyList.add(apply);
        }
		mv.getModelMap().put("applyList", applyList);
		mv.getModelMap().put("applyIDS", applyIDS);
		mv.setViewName("/project/package/packageAddModal");
		return mv;
	}
	
	/**
	 * 打包项目;
	 * 
	 */
	@RequestMapping(value="/insertOnePackageInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOnePackageInfo(@RequestBody Pro_package pro_package){
		Boolean b = false;	
		String applyIDS = pro_package.getApplyIDS();
		String[] split = applyIDS.split(",");
		String str ="'"+StringUtils.join(split,"','")+"'";
		if(pro_package  != null){		
			b= packageService.insertOnePackageInfo(SystemSession.getUserSession(), pro_package);		   
		}
		
		String sql =" update  pro_apply  set  isPackage = '1' ,  package_ID= '"
										+pro_package.getPackage_ID()+"' where 1=1 and apply_ID in ("+str+")";
		projectApplyService.updateApplyYesPackage(sql);
		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 撤销打包;
	 * 
	 */
	@RequestMapping(value="/delOnePackageInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOnePackageInfo(@RequestBody String package_ID){
		Boolean b = false;	
		if(package_ID  != null){
			List<Pro_apply> appList = packageService.selectApplyListByPackageID(" and  package_ID ='"+package_ID+"'");
			String[] arr=new String[appList.size()];
			for (int i = 0; i < appList.size(); i++) {
				arr[i]=appList.get(0).getApply_ID();
			}
			String args="'"+org.apache.commons.lang3.StringUtils.join(arr,"','")+"'";
			String sql=" update pro_apply set isPackage='1'  where 1=1 and apply_ID in ("+args+")";
			Boolean pppp = projectApplyService.updateApplyYesPackage(sql);
			System.out.println(pppp);
			b = packageService.delOnePackageInfo(SystemSession.getUserSession(), package_ID);		   
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}	
	
	/**
	 * 移出打包车;
	 * 
	 */
	@RequestMapping(value="/delOnePackageBusInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delOnePackageBusInfo(@RequestBody String apply_ID){
		Boolean b = false;	
		if(apply_ID  != null){
			String whereSql = " and apply_ID = \'"+apply_ID+"\'";
			try {
				Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
				apply.setIsPutPackage(0);
				b = projectApplyService.updateOneApplyInfo(SystemSession.getUserSession(), apply);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}			
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 *已打包项目-列表查看页面
	 */
	@RequestMapping(value="/packageViewPage")
	public ModelAndView packageViewPage(String package_ID){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String whereSql = " and package_ID = \'"+package_ID+"\'";
		//查询打包信息
		Pro_package pro_package = packageService.selectOnePackageByWhereSql(whereSql);
		mv.getModelMap().put("pro_package", pro_package);
		//查询打包项目下的子项目
		List<Pro_apply> applyList = packageService.selectApplyListByPackageID(whereSql);
		mv.getModelMap().put("applyList", applyList);
		mv.setViewName("/project/package/packageViewModal");
		return mv;
	}
	//以下是上会申请
	/**
	 * 打包项目页面分页列表
	 * @author chenyang
	 * @time :2017-7-5 
	 */
	@RequestMapping(value="/selectMeetingPackagePageTable")
	@ResponseBody
	public AjaxRes selectMeetingPackagePageTable(@RequestBody PageTable<Pro_apply> pageTable){
		StringBuffer wheresql = new StringBuffer();
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		wheresql.append(" and isUnPackage = 0 ");//是否上会:0代表没有被安排上会
		
		try {
			AjaxRes ar = new AjaxRes();
			pageTable.setWheresql(wheresql.toString());
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable = packageService.selectPackagePageTables(pageTable);		
			ar.setSucceed(pageTable);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 打包项目的分页列表查询条件
	 */
	private String queryMeetConditionSql(PageTable<Pro_apply> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		wheresql.append(" and unit_uid = \'"+SystemSession.getUserSession().getUnit_uid()+"\' ");
		wheresql.append(" and isArrangeMeeting = 0 ");//是否上会:0代表没有被安排上会
		
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and packageName like \'%"+pageTable.getSearchText().trim()+"%\'");
		}
		return wheresql.toString();		
	}
}

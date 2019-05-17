package com.zjm.oa.staffCase.web;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.staffCase.service.StaffCaseService;

import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
@RequestMapping(value="/oa/staffCase")
public class StaffCaseAction {
	@Resource
	private StaffCaseService staffCaseService ;
	@Resource
	private UsersService  usersService; 
	@Resource
	private SysDicDataService sysDicDataService;
	/**
	 * 查询用户分页列表	
	 */
	@RequestMapping(value = "/selectEmployeeTable")
	@ResponseBody
	public AjaxRes selectEmployeeTable(@RequestBody PageTable pageTable) {
		try {
			pageTable.setWheresql(queryConditionSql(pageTable));
			
			pageTable=staffCaseService.selectStaffCaseTables(pageTable);
			
			pageTable.setWheresql("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	/**
	 * 用户分页列表查询条件	
	 */
	private String queryConditionSql(PageTable pageTable){
		String wheresql="";
	
		if(pageTable==null){
			return "";
		}
		//搜索框功能
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql=wheresql+" and u.user_name like \'%"+pageTable.getSearchText().trim()+"%\'";
		}
		if(pageTable.getQueryCondition()!=null){
			if(pageTable.getQueryCondition().getDepart_uid()!=null 
					&& !pageTable.getQueryCondition().getDepart_uid().equals("") 
					&& !pageTable.getQueryCondition().getDepart_uid().equals("a129b9eea27a48be896697a39aa0aee7")){
				wheresql=wheresql+" and d.depart_fullcode like \'%"+pageTable.getQueryCondition().getDepart_uid().trim()+"%\'";
			}
			wheresql = wheresql + " and u.user_type  <> '2' ";
		}
		
//		//根据身份证号			
//		if(pageTable.getQueryCondition().getStaffDocuments() != null && !"".equals(pageTable.getQueryCondition().getStaffDocuments())){
//		    wheresql=wheresql+" and staffDocuments = \'"+pageTable.getQueryCondition().getStaffDocuments()+"\'";
//		}		
//		//根据员工编号
//		if(pageTable.getQueryCondition().getStaffcase_Id() != null && !"".equals(pageTable.getQueryCondition().getStaffcase_Id())){
//			wheresql.append(" and staffcase_Id = \'"+pageTable.getQueryCondition().getStaffcase_Id()+"\'");
//		}
		/*//根据员工性别
		if(pageTable.getQueryCondition().getSex() != null && !"".equals(pageTable.getQueryCondition().getSex())){
			wheresql.append(" and sex = \'"+pageTable.getQueryCondition().getSex()+"\'");
		}
		//根据民族
		if(pageTable.getQueryCondition().getStaffNational() != null && !"".equals(pageTable.getQueryCondition().getStaffNational())){
			wheresql.append(" and staffNational = \'"+pageTable.getQueryCondition().getStaffNational()+"\'");
		}	
		//根据籍贯			
		if(pageTable.getQueryCondition().getStaffBirthplace() != null && !"".equals(pageTable.getQueryCondition().getStaffBirthplace())){
			wheresql.append(" and staffBirthplace = \'"+pageTable.getQueryCondition().getStaffBirthplace()+"\'");
		}
		
		//根据婚姻状况
		if(pageTable.getQueryCondition().getStaffMarriage()!= null && !"".equals(pageTable.getQueryCondition().getStaffMarriage())){
			wheresql.append(" and staffMarriage = \'"+pageTable.getQueryCondition().getStaffMarriage()+"\'");
		}
		//根据政治面貌
		if(pageTable.getQueryCondition().getStaffPolitical()!= null && !"".equals(pageTable.getQueryCondition().getStaffPolitical())){
			wheresql.append(" and staffPolitical = \'"+pageTable.getQueryCondition().getStaffPolitical()+"\'");
		}
		//根据学历
		if(pageTable.getQueryCondition().getStaffEducation()!= null && !"".equals(pageTable.getQueryCondition().getStaffEducation())){
			wheresql.append(" and staffEducation = \'"+pageTable.getQueryCondition().getStaffEducation()+"\'");
		}
		//根据员工类型
		if(pageTable.getQueryCondition().getStaffType()!= null && !"".equals(pageTable.getQueryCondition().getStaffType())){
			wheresql.append(" and staffType = \'"+pageTable.getQueryCondition().getStaffType()+"\'");
		}
		//根据员工职称
		if(pageTable.getQueryCondition().getStaffTitle()!= null && !"".equals(pageTable.getQueryCondition().getStaffTitle())){
			wheresql.append(" and staffTitle = \'"+pageTable.getQueryCondition().getStaffTitle()+"\'");
		}*/
		return wheresql;
	}
	/*
	 * 根据员工ID查询该员工详细信息
	 * */
	@RequestMapping(value="/employeeInfo")
	public ModelAndView  employeeInfo(String id,String user_name,String type){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();	
		try{
			getDicTypeMap(modeAndView);
			Hr_staffCase hr_staffCase=new Hr_staffCase();		
			hr_staffCase.setUser_uid(id);
			hr_staffCase.setUser_name(user_name);		
			Boolean result=false;			
			Hr_staffCase  isExist = staffCaseService.selectOneStaffCaseInfo1(hr_staffCase);			
			

		if(isExist == null){			
			//新增信息			
			hr_staffCase.setStaffcase_Id(Tool.createUUID32());				
			hr_staffCase.setUser_uid(id);	
			hr_staffCase.setUnit_uid(SystemSession.getUserSession().getUnit_uid());	
			hr_staffCase.setUser_name(user_name);
			
			result = staffCaseService.insertOneStaffCaseInfo(hr_staffCase,SystemSession.getUserSession());			
		}
		Hr_staffCase  hrstaffCase = staffCaseService.selectOneStaffCaseInfo(hr_staffCase);
		modeAndView.getModel().put("hrstaffCase",hrstaffCase);
		modeAndView.getModel().put("type",type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/employeeDetail");
		return modeAndView;
	}
	/**
	 * 修改信息页面
	 */
	@RequestMapping(value="/selectEmployeeEditPage")
	public ModelAndView selectEmployeeEditPage(String user_uid,String user_name){		
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		try{			
			Hr_staffCase hr_staffCase=new Hr_staffCase();
			hr_staffCase.setUser_uid(user_uid);
			hr_staffCase.setUser_name(user_name);
			Hr_staffCase	hrstaffCase=staffCaseService.selectOneStaffCaseInfo(hr_staffCase);			
			getDicTypeMapUp(mv);			
			mv.getModel().put("hrstaffCase",hrstaffCase);
		}catch(Exception e){
			e.printStackTrace();					
		}		
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/basicInfo/update");
		return mv;
	}
	/**
	 * 更新
	 */
	@RequestMapping(value = "/updateOneemployeeInfo" ,method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneCreditInfo(@RequestBody Hr_staffCase hrstaffCase) {		
		hrstaffCase.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		AjaxRes ar = new AjaxRes();
		try{
	Boolean	result=staffCaseService.updateOneStaffCaseInfo(hrstaffCase);
	ar.setSucceed(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	
		return ar;
	}	
	
	/**
	 * @description  获取单级字典 ---
	 */
	private void getDicTypeMapUp(ModelAndView modeAndView) {
		//民族
				Map<String,String> minzuMap = sysDicDataService.selectDicTypeDicNoEableMap("","0d9eb537552f4965a6013edb8deb5fd7");
				//政治面貌
				Map<String,String> ZhengzhiMap = sysDicDataService.selectDicTypeDicNoEableMap("","de47b08fe98446dda0928d31d4fd4246");
				//婚姻状况
				Map<String,String> MarriageMap = sysDicDataService.selectDicTypeDicNoEableMap("","c703889e4187459e9c5fd74f8d1ad743");
				// 籍贯
			//	Map<String,String> BirthpalceMap = sysDicDataService.selectDicTypeDicNoEableMap("","ab653dd759ff4f229a91dbce1a5dcadc");
				// 员工类型
				Map<String,String> ygMap = sysDicDataService.selectDicTypeDicNoEableMap("","8bdedd1a6a474c3aafe2d7b51c9b84d8");
				// 学历
				Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("","1d5c390cc0ac4a8ab77270ef0debe823");
				//职称 
				Map<String,String> ZhichengMap = sysDicDataService.selectDicTypeDicNoEableMap("","96c78db0fb224f37a740ea6561566968");
				modeAndView.getModel().put("minzuMap", minzuMap);
				modeAndView.getModel().put("ZhengzhiMap", ZhengzhiMap); 
				modeAndView.getModel().put("MarriageMap", MarriageMap); 
			//	modeAndView.getModel().put("BirthpalceMap", BirthpalceMap); 
				modeAndView.getModel().put("ygMap", ygMap); 
				modeAndView.getModel().put("EducationMap", EducationMap); 
				modeAndView.getModel().put("ZhichengMap", ZhichengMap); 
	}
	/**
	 * @description  获取单级字典 ---
	 */
	private void getDicTypeMap(ModelAndView modeAndView) {
		//民族
		Map<String,String> minzuMap = sysDicDataService.selectDicTypeDicMap("","0d9eb537552f4965a6013edb8deb5fd7");
		//政治面貌
		Map<String,String> ZhengzhiMap = sysDicDataService.selectDicTypeDicMap("","de47b08fe98446dda0928d31d4fd4246");
		//婚姻状况
		Map<String,String> MarriageMap = sysDicDataService.selectDicTypeDicMap("","c703889e4187459e9c5fd74f8d1ad743");
		// 籍贯
	//	Map<String,String> BirthpalceMap = sysDicDataService.selectDicTypeDicMap("","ab653dd759ff4f229a91dbce1a5dcadc");
		// 员工类型
		Map<String,String> ygMap = sysDicDataService.selectDicTypeDicMap("","8bdedd1a6a474c3aafe2d7b51c9b84d8");
		// 学历
		Map<String,String> EducationMap = sysDicDataService.selectDicTypeDicMap("","1d5c390cc0ac4a8ab77270ef0debe823");
		//职称 
		Map<String,String> ZhichengMap = sysDicDataService.selectDicTypeDicMap("","96c78db0fb224f37a740ea6561566968");
		modeAndView.getModel().put("minzuMap", minzuMap);
		modeAndView.getModel().put("ZhengzhiMap", ZhengzhiMap); 
		modeAndView.getModel().put("MarriageMap", MarriageMap); 
	//	modeAndView.getModel().put("BirthpalceMap", BirthpalceMap); 
		modeAndView.getModel().put("ygMap", ygMap); 
		modeAndView.getModel().put("EducationMap", EducationMap); 
		modeAndView.getModel().put("ZhichengMap", ZhichengMap); 
	}
	


	@RequestMapping(value="/selectContractBirthdayPageTable")
	@ResponseBody
	public AjaxRes selectContractBirthdayPageTable(@RequestBody PageTable<Hr_staffCase> pageTable){
		AjaxRes ar = new AjaxRes();
		try{
			pageTable.getQueryCondition().setUnit_uid(SystemSession.getUserSession().getUnit_uid());
			pageTable.setWheresql(queryContractBirthdayConditionSql(pageTable));
			pageTable = staffCaseService.selectContractBirthdayPageTable(pageTable);
			ar.setSucceed(pageTable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	
	/**
	 * 劳动合同、员工生日分页列表查询条件
	 */
	private String queryContractBirthdayConditionSql(PageTable<Hr_staffCase> pageTable){
		StringBuffer wheresql = new StringBuffer();
		//搜索框功能
		if(pageTable==null){
			return "";
		}
		//当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if ( null != pageTable.getSearchText()) {
			wheresql.append(" and (u.user_name like \'%"+pageTable.getSearchText().trim()+"%\' OR d.depart_name like \'%"+pageTable.getSearchText().trim()+"%\')");
		}
		
		if(pageTable.getQueryCondition()!=null){
			if(pageTable.getQueryCondition().getBorndate()!=null 
					&& !pageTable.getQueryCondition().getBorndate().equals("")){
				wheresql.append(" and DATE_FORMAT(sc.borndate,'%m') = '"+pageTable.getQueryCondition().getBorndate()+"'");
			}
		}
		if(pageTable.getQueryCondition()!=null){
			if(pageTable.getQueryCondition().getContractEndDate()!=null 
					&& !pageTable.getQueryCondition().getContractEndDate().equals("")){
				wheresql.append("and DATE_FORMAT(sc.StaffEndContractDate,'%Y-%m')='"+pageTable.getQueryCondition().getContractEndDate()+"'");
			}
		}
		
		wheresql.append(" order by u.user_name");
		return wheresql.toString();		
	}
	
	/**
	 * 删除信息页面
	 */
	@RequestMapping(value="/selectCaseDelPage")
	public ModelAndView selectCaseDelPage(Hr_staffCase hrstaffCase){
		if(hrstaffCase==null){
			hrstaffCase=new Hr_staffCase();
		}
		hrstaffCase=staffCaseService.selectOneStaffCaseInfo(hrstaffCase);	
		ModelAndView mv=CustomDispatchServlet.getModeAndView();
		mv.setViewName("/oa/personfile/employeeInfo/employeedel");
		
		mv.getModel().put("hrstaffCase", hrstaffCase);
		return mv;
	}
	
	/**
	 * 删除一个员工信息	 
	 */
	@RequestMapping(value="/delectOneCaseInfo", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delectOneCaseInfo(@RequestBody Hr_staffCase hrstaffCase){
		hrstaffCase.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Boolean b= staffCaseService.deleteOneStaffCaseInfo(hrstaffCase);	
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 高级条件查询页面;
	 */
	@RequestMapping(value="/openCaseSelectPage")
	public ModelAndView openApplySelectPage(){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		getDicTypeMapUp(mv);//获取下拉框
		mv.setViewName("/oa/personfile/employeeInfo/hightSelectEmployee");
		return mv;
	}

	
	
	
	
	
	
	
}

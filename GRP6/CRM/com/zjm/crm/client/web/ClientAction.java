package com.zjm.crm.client.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.UrlParam;
import com.zjm.common.db.model.User;
import com.zjm.crm.apply.service.ApplyService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_clientMapper;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_oldClientName;
import com.zjm.crm.db.model.Crm_selfHouse;
import com.zjm.crm.db.model.Crm_spouseInfo;
import com.zjm.crm.oldClientName.service.OldClientNameService;
import com.zjm.crm.selfHouse.service.SelfHouseService;
import com.zjm.crm.spouseInfo.service.SpouseInfoService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.map.Pro_applyMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.DateUtil;
import com.zjm.util.SystemSession;
import com.zjm.util.excel.ExcelUtilToMap;
import com.zjm.xdocreport.util.StringUtil;

/**
 * 客户管理
 * @author chenyang add 20170426
 */
@Controller
public class ClientAction {
	@Resource
	private Crm_clientMapper crm_clientMapper;
	@Resource
	private ClientService clientService;
	@Resource
	private DicTypeService dicTypeService;
	@Resource
	private ApplyService applyService;
	@Resource
	private Pro_applyMapper pro_applyMapper;
	@Resource
	private ProjectService projectService;
	@Resource
	private SelfHouseService selfHouseService;	//自有住宅表
	@Resource
	private SpouseInfoService spouseInfoService;	//配偶信息表
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private OldClientNameService oldClientNameService;
	/**
	 * 客户分页列表查询条件
	 * @param pageTable
	 * wheresql.append(" and clientTypeID in ("+clientTypeID+")");
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable){
		StringBuffer wheresql = new StringBuffer();
		if(pageTable==null){
			return "";
		}
		
		//根据用户角色的数据权限拼接sql
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendClientSqlByRole(pageTable.getQueryCondition().getUser_uid(),"");
			if (null != sql){
				wheresql.append(sql);
			}
		}
		
		/*if(pageTable.getQueryCondition()!=null){
			if(pageTable.getQueryCondition().getMod_uid()!=null && !pageTable.getQueryCondition().getMod_uid().equals("") && !pageTable.getQueryCondition().getMod_uid().equals("-1")){
				wheresql=wheresql+" and pmod_id =\'"+pageTable.getQueryCondition().getMod_uid().trim()+"\'";
			}
		}*/
		String clientTypeID = pageTable.getQueryCondition().getClientTypeID();
		if(null != clientTypeID){
			wheresql.append(" and clientTypeID in ("+clientTypeID+")");
			if(clientTypeID.equals("01")){
				if ( null != pageTable.getSearchText()) {
					wheresql.append(" and (c.clientName like \'%"+pageTable.getSearchText().trim()+"%\' or oc.oldClientName like \'%" +pageTable.getSearchText().trim()+"%\')");
				}
			}else {
				if ( null != pageTable.getSearchText()) {
					wheresql.append(" and personName like \'%"+pageTable.getSearchText().trim()+"%\'");
				}
			}
		}
		//企业客户高级条件查询---start----
		
		//根据客户名称查询(clientName)
		if(pageTable.getQueryCondition().getClientName() != null && !"".equals(pageTable.getQueryCondition().getClientName())){
			wheresql.append(" and (c.clientName like \'%"+pageTable.getQueryCondition().getClientName().trim()+"%\' or oc.oldClientName like \'%" +pageTable.getQueryCondition().getClientName().trim()+"%\')");
		}
		//根据所属区域查询(fullAreaName)
		if(pageTable.getQueryCondition().getFullAreaName() != null && !"".equals(pageTable.getQueryCondition().getFullAreaName())){
			wheresql.append(" and fullAreaName = \'"+pageTable.getQueryCondition().getFullAreaName()+"\'");
		}
		//根据所属行业查询(fullTradeName);
		if(pageTable.getQueryCondition().getFullTradeName() != null && !"".equals(pageTable.getQueryCondition().getFullTradeName())){
			wheresql.append(" and fullTradeName = \'"+pageTable.getQueryCondition().getFullTradeName()+"\'");
		}
		//根据币别(currencyID)
		if(pageTable.getQueryCondition().getCurrencyID() != null && !"".equals(pageTable.getQueryCondition().getCurrencyID())){
			wheresql.append(" and currencyID = \'"+pageTable.getQueryCondition().getCurrencyID()+"\'");
		}
		
		//根据企业性质查询(natureID);
		if(pageTable.getQueryCondition().getNatureID() != null && !"".equals(pageTable.getQueryCondition().getNatureID())){
			wheresql.append(" and natureID = \'"+pageTable.getQueryCondition().getNatureID()+"\'");
		}
		//根据注册资金查询
		if(pageTable.getQueryCondition().getRegisterSumStart() != null && !"".equals(pageTable.getQueryCondition().getRegisterSumStart())){
       		if(pageTable.getQueryCondition().getRegisterSumEnd() != null && !"".equals(pageTable.getQueryCondition().getRegisterSumEnd())){
       			
       			wheresql.append(" and registerSum >= "+pageTable.getQueryCondition().getRegisterSumStart() +" and registerSum <="+pageTable.getQueryCondition().getRegisterSumEnd());
       		}else{
       			wheresql.append(" and registerSum >="+pageTable.getQueryCondition().getRegisterSumStart());
       		}
       	}else{
       		if(pageTable.getQueryCondition().getRegisterSumEnd() !=null && !"".equals(pageTable.getQueryCondition().getRegisterSumEnd())){
       			wheresql.append(" and A.replaceFreeSum <="+pageTable.getQueryCondition().getRegisterSumEnd());
       		}
       	}
		//根据成立日期查询(CreateDateStart-CreateDateEnd);		
		if(pageTable.getQueryCondition().getCreateDateStart() !=null && !"".equals(pageTable.getQueryCondition().getCreateDateStart())){
       		//输入日期 转换格式
       		String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreateDateStart());
       		if(pageTable.getQueryCondition().getCreateDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getCreateDateEnd())){
       			//把输入框日期2转换格式
       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreateDateEnd());
       			wheresql.append(" and createDate >= \'"+Time1 +"\' and createDate <=\'"+Time2+"\'");
       		}else{
       			wheresql.append(" and createDate >=\'"+Time1+"\'");
       		}
       	}else{
       		if(pageTable.getQueryCondition().getCreateDateEnd() !=null && !"".equals(pageTable.getQueryCondition().getCreateDateEnd())){
       			
       			String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreateDateEnd());
       			wheresql.append(" and createDate <=\'"+Time2+"\'");
       		}
       	}
		//根据客户来源(clientSourceID)
		if(pageTable.getQueryCondition().getClientSourceID() != null && !"".equals(pageTable.getQueryCondition().getClientSourceID())){
			wheresql.append(" and clientSourceID = \'"+pageTable.getQueryCondition().getClientSourceID()+"\'");
		}
		//根据法定代表人(legalPerson)
		if(pageTable.getQueryCondition().getLegalPerson() != null && !"".equals(pageTable.getQueryCondition().getLegalPerson())){
			wheresql.append(" and legalPerson like \'%"+pageTable.getQueryCondition().getLegalPerson()+"%\'");
		}
		//根据实际控制人(controlPerson)
		if(pageTable.getQueryCondition().getControlPerson() != null && !"".equals(pageTable.getQueryCondition().getControlPerson())){
			wheresql.append(" and controlPerson like \'%"+pageTable.getQueryCondition().getControlPerson()+"%\'");
		}
		//根据创建机构(unit_uidName)
		if(pageTable.getQueryCondition().getUnit_uidName() != null && !"".equals(pageTable.getQueryCondition().getUnit_uidName())){
			wheresql.append(" and unit_uidName like \'%"+pageTable.getQueryCondition().getUnit_uidName()+"%\'");
		}
		
		//根据创建部门(fullDepartName)
		if(pageTable.getQueryCondition().getFullDepartName() != null && !"".equals(pageTable.getQueryCondition().getFullDepartName())){
			wheresql.append(" and fullDepartName = \'"+pageTable.getQueryCondition().getFullDepartName()+"\'");
		}
		//根据创建人(createUserName)
		if(pageTable.getQueryCondition().getCreateUserName() != null && !"".equals(pageTable.getQueryCondition().getCreateUserName())){
			wheresql.append(" and createUserName like \'%"+pageTable.getQueryCondition().getCreateUserName()+"%\'");
		}
		
		//根据创建日期查询;		
		if(pageTable.getQueryCondition().getCreateDateTimeStart() !=null && !"".equals(pageTable.getQueryCondition().getCreateDateTimeStart())){
			//输入日期 转换格式
			String Time1=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreateDateTimeStart());
			if(pageTable.getQueryCondition().getCreateDateTimeEnd() !=null && !"".equals(pageTable.getQueryCondition().getCreateDateTimeEnd())){
				//把输入框日期2转换格式
				String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreateDateTimeEnd());
				wheresql.append(" and createDateTime >= \'"+Time1 +"\' and createDateTime <=\'"+Time2+"\'");
			}else{
				wheresql.append(" and createDateTime >=\'"+Time1+"\'");
			}
		}else{
			if(pageTable.getQueryCondition().getCreateDateTimeEnd() !=null && !"".equals(pageTable.getQueryCondition().getCreateDateTimeEnd())){
				
				String Time2=new SimpleDateFormat("yyyy-MM-dd").format(pageTable.getQueryCondition().getCreateDateTimeEnd());
				wheresql.append(" and createDateTime <=\'"+Time2+"\'");
			}
		}
		
		//企业客户高级条件查询---end----
		
		//个人客户高级条件查询 ---start----
		//根据申请人姓名查询(personName)
		if(pageTable.getQueryCondition().getPersonName() != null && !"".equals(pageTable.getQueryCondition().getPersonName())){
			wheresql.append(" and personName like \'%"+pageTable.getQueryCondition().getPersonName().trim()+"%\'");
		}
		//根据申请人身份证号码查询(personNum)
		if(pageTable.getQueryCondition().getPersonNum() != null && !"".equals(pageTable.getQueryCondition().getPersonNum())){
			wheresql.append(" and personNum like \'%"+pageTable.getQueryCondition().getPersonNum().trim()+"%\'");
		}
		//根据申请人联系方式查询(phone)
		if(pageTable.getQueryCondition().getPhone() != null && !"".equals(pageTable.getQueryCondition().getPhone())){
			wheresql.append(" and phone like \'%"+pageTable.getQueryCondition().getPhone().trim()+"%\'");
		}
		
		//个人客户高级条件查询 ---end---
		
		
		
		if(pageTable.getSortName()!=null && !pageTable.getSortName().equals("") && pageTable.getSortOrder()!=null && !pageTable.getSortOrder().equals("")){
				wheresql.append(" order by "+pageTable.getSortName().trim()+"  " +pageTable.getSortOrder()+"");
		}else{
			wheresql.append(" ORDER BY createDateTime desc");
		}
		return wheresql.toString();
	}
	
	/**
	 * 查询个人客户分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	@RequestMapping(value = "/selectPersonClientPageTables")
	@ResponseBody
	public AjaxRes selectPersonClientPageTables(@RequestBody PageTable pageTable) {
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询企业表
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=clientService.selectPersonClientPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	/* ************************企业客户信息********************************* */
	/**
	 * 查询企业客户分页列表
	 * @param pageTable
	 * @author wuhn
	 * @return
	 */
	@RequestMapping(value="/selectCompanyClientPageTables",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectCompanyClientPageTables(@RequestBody PageTable pageTable) {
//		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询企业表
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable=clientService.selectCompanysClientPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	/**
	 * 添加一个客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:51:39
	 */
	@RequestMapping(value="/insertOneCompanyClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneCompanyClientInfo(@RequestBody Client client) {
		AjaxRes ar=new AjaxRes();
		Boolean bool=false;
		 User user = SystemSession.getUserSession();
		try {
			if (null == client.getCreateUserID()) {
				client.setCreateUserID(user.getUser_uid());
				client.setCreateUserName(user.getUser_name());
			}
			bool =clientService.insertOneCompanyClientInfo(user,client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 添加一条个人客户（经营性）信息
	 * @description
	 * @author chenyang
	 * @date 2017年5月4日 上午10:51:39
	 */
	@RequestMapping(value="/insertOnePersonClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOnePersonClientInfo(@RequestBody Client client) {
		AjaxRes ar=new AjaxRes();
		//根据企业客户名称查询客户信息  如果存在 将数据库中企业资料添加到个人客户中
		String clientName = client.getClientName().trim();
		Client companyClient = clientService.selectOneClientInfoByClientName(clientName);
		if(companyClient!=null){
			companyClient.setPersonName(client.getPersonName());
			companyClient.setPersonNum(client.getPersonNum());
			companyClient.setClientTypeID(client.getClientTypeID());
			Boolean bool =clientService.insertOneCompanyClientInfo(SystemSession.getUserSession(),companyClient);
			ar.setSucceed(bool);
			return ar;
		}else{
			Boolean bool =clientService.insertOneCompanyClientInfo(SystemSession.getUserSession(),client);
			ar.setSucceed(bool);
			return ar;
		}
	}
	
	/**
	 * 添加一条个人客户（消费性）信息
	 * @description
	 * @author chenyang
	 * @date 2017年5月4日 上午10:51:39
	 */
	@RequestMapping(value="/insertOneXPersonClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneXPersonClientInfo(@RequestBody Client client) {
		AjaxRes ar=new AjaxRes();
		Boolean bool =clientService.insertOneCompanyClientInfo(SystemSession.getUserSession(),client);
		ar.setSucceed(bool);
		return ar;
	}
	
	/**
	 * 
	 * @description 删除一个企业客户信息
	 * @author wuhn
	 * @date 2017年5月4日 下午1:18:15
	 */
	@RequestMapping(value="/deleteOneCompanyClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes deleteOneCompanyClientInfo(@RequestBody Client client) {
		Boolean bool = clientService.deleteOneCompanyClientInfo(SystemSession.getUserSession(),client);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	
	/**
	 * 
	 * @description 查询一个企业客户的信息
	 * @author wuhn
	 * @date 2017年5月4日 下午3:33:11
	 */
	@RequestMapping(value="/selectOneCompanyClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneCompanyClientInfo(@RequestBody Client client) {
		client = clientService.selectOneClientInfo(client);
		String wheresql = "";
		wheresql = " and client_ID = \'" + client.getClient_ID() + "\'"; 
		String oldClientName = "";
		List<Crm_oldClientName> oldClientNames = oldClientNameService.selectOldClientNameList(wheresql);
		if (oldClientNames !=null) {
			for (Crm_oldClientName crm_oldClientName : oldClientNames) {
				oldClientName = oldClientName + crm_oldClientName.getOldClientName()+ ",";
			}
			client.setOldClientName(oldClientName);
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(client);
		return ar;
	}
	
	/**
	 * 
	 * @description 修改 更新企业客户信息  (更新基本信息,更新客户来源)
	 * @author wuhn
	 * @date 2017年5月4日 下午7:14:03
	 */
	@RequestMapping(value="/updateOneCompanyClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneCompanyClientInfo(@RequestBody Client client) { //
		Client oldClient = clientService.selectOneClientInfo(client);
		if(StringUtil.isNotBlank(client.getRiskLevelName())) {
			client.setGzwRiskLevel(client.getRiskLevelName());
		}
		Boolean bool = false;
		try {
			if ( !"03".equals(oldClient.getClientTypeID()) && !oldClient.getClientName().equals(client.getClientName()) ) {
				Crm_oldClientName crm_oldClientName = new Crm_oldClientName();
				crm_oldClientName.setClient_ID(oldClient.getClient_ID());
				crm_oldClientName.setClientGUID(oldClient.getClientGUID());
				crm_oldClientName.setNewClientName(client.getClientName());
				crm_oldClientName.setOldClientName(oldClient.getClientName());
				bool = oldClientNameService.insertOneOldClientNameInfo(crm_oldClientName);
			}
			bool = clientService.updateOneCompanyClientInfo(SystemSession.getUserSession(),client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}
	
	
	
	
	
	/**
	 * 添加时判断企业客户名称是否重复
	 * @param 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/selectAddClientNameIsExist")
	@ResponseBody
	public AjaxRes selectAddClientNameIsExist(@RequestBody Client client) throws UnsupportedEncodingException{
		//clientName=URLDecoder.decode(clientName, "utf-8");
		String wheresql=" and  isMainVersion='01' ";
		if(client.getClientName() != null){
			
				wheresql=wheresql+"  and clientName = \'"+(client.getClientName()).trim()+"\'";
			
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=clientService.selectClientNameIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 添加个人时判断身份证号是否重复
	 * @param 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/selectPersonNameIsExist")
	@ResponseBody
	public AjaxRes selectPersonNameIsExist(@RequestBody Client client) throws UnsupportedEncodingException{
		String wheresql="and  isMainVersion='01' and clientTypeID IN (02, 03)";
		//判断申请人姓名是否存在
		String personNum = client.getPersonNum().trim();
		if(personNum != null){ 			
			wheresql = wheresql+" and personNum =\'"+personNum+"\'";
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=clientService.selectClientNameIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	
	/**
	 * 修改时判断个人名称是否重复
	 * @return
	 */
	@RequestMapping(value = "/selectEditPersonNameIsExist")
	@ResponseBody
	public AjaxRes selectEditPersonNameIsExist(@RequestBody Client client) throws UnsupportedEncodingException{
		String wheresql="and  isMainVersion='01' ";
		if(client!=null){
			if(client.getClient_ID()!=null){
				wheresql=wheresql+" and client_ID != \'"+ client.getClient_ID()+"\'";
			}
			if(client.getPersonNum()!=null){
				wheresql=wheresql+" and personNum = \'"+client.getPersonNum().trim()+"\'";
			}
		}
		AjaxRes ar=new AjaxRes();
		Boolean b=clientService.selectClientNameIsExist(wheresql);
		ar.setSucceed(b);
		return ar;
	}
	
	
	/**
	 * 添加一个客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:51:39
	 */
	@RequestMapping(value="/insertOneClientInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneClientInfo(@RequestBody Client client) {
		AjaxRes ar=new AjaxRes();
		User user = SystemSession.getUserSession();
		if (null == client.getCreateUserID()) {
			client.setCreateUserID(user.getUser_uid());
			client.setCreateUserName(user.getUser_name());
		}
		Client newClient = clientService.insertClientAndReturnClientID(user,client);
		ar.setSucceed(newClient);
		return ar;
	}
	
	/************************同步******************************/
	@RequestMapping(value="/selectProjectPageTableByClient")
	@ResponseBody
	public AjaxRes selectProjectPageTableByClient(@RequestBody PageTable<Pro_apply> pageTable){
		AjaxRes ar = new AjaxRes();
		try {	
				String clientGUID = pageTable.getQueryCondition().getClientGUID();
				String[] split = clientGUID.split(",");
				 clientGUID= "'"+StringUtils.join(split, "','")+"'";
				pageTable.setWheresql("and clientguid in (" + clientGUID + ")");
				pageTable=projectApplyService.selectApplyPageTables(pageTable);
				ar.setSucceed(pageTable);
		} catch (Exception e) {
			e.printStackTrace();			
		}	
		return ar;
	}
	
	@RequestMapping(value="/updateClientProject")
	@ResponseBody
	public AjaxRes updateClientProject(@RequestBody String client_ID){
		AjaxRes ar = new AjaxRes();
		try {
			JSONObject sort=JSON.parseObject(client_ID);
			System.out.println("client_ID"+client_ID);
			//根据传过来的参数找到副版本的client对象
			Client clientF=clientService.selectOneClientByWheresql("and client_ID='" + (String) sort.get("client_ID")+ "' ");				
			//通过副版本的clientId找到GUID再通过GUID找到主版本的客户对象clientMain
			Client clientMain = clientService.selectOneClientByWheresql("and clientGUID='"+clientF.getClientGUID()+"' and isMainVersion=TRUE");		
			System.out.println("client_ID"+clientMain.getClient_ID());
			clientMain.setClient_ID(clientF.getClient_ID());
			clientMain.setIsMainVersion(false);
			crm_clientMapper.updateOneCompanyClientInfo(clientMain);
			//重新查找主版本
			Client clientMainnew = clientService.selectOneClientByWheresql("and clientGUID='"+clientMain.getClientGUID()+"' and isMainVersion=TRUE");
			System.out.println("33333333333client_ID"+clientMainnew.getClient_ID());
			//更新客户表下面得其他表
			User user=SystemSession.getUserSession();
			Crm_selfHouse selfHouse = new Crm_selfHouse();
			selfHouse.setClient_ID(clientMainnew.getClient_ID());
			//主版本信息
			Crm_selfHouse selfHouse2 = selfHouseService.selectOneSelfHouseInfo(selfHouse);
			//副版本信息
			Crm_selfHouse selfHouse1 = new Crm_selfHouse();
			selfHouse1.setClient_ID(client_ID);
			Crm_selfHouse selfHouse3 = selfHouseService.selectOneSelfHouseInfo(selfHouse1);
			if(selfHouse2!=null&&selfHouse3!=null){	
				System.out.println("aaaaaaaaaaaaa"+selfHouse2.getArea());
				if(selfHouse2.getArea()!=null && !"".equals(selfHouse2.getArea())){
			selfHouse3.setArea(selfHouse2.getArea());
			}
				if(selfHouse2.getClient_ID()!=null && !"".equals(selfHouse2.getClient_ID())){
			selfHouse3.setClient_ID(selfHouse2.getClient_ID());
				}
				if(selfHouse2.getOwnership()!=null && !"".equals(selfHouse2.getOwnership())){
			selfHouse3.setOwnership(selfHouse2.getOwnership());
				}
				if(selfHouse2.getPersonNum()!=null && !"".equals(selfHouse2.getPersonNum())){
			selfHouse3.setPersonNum(selfHouse2.getPersonNum());
				}	if(selfHouse2.getAddress()!=null && !"".equals(selfHouse2.getAddress())){
			selfHouse3.setAddress(selfHouse2.getAddress());
				}	if(selfHouse2.getRelation()!=null && !"".equals(selfHouse2.getRelation())){
			selfHouse3.setRelation(selfHouse2.getRelation());
				}	if(selfHouse2.getRemark()!=null && !"".equals(selfHouse2.getRemark())){
			selfHouse3.setRemark(selfHouse2.getRemark());
				}	if(selfHouse2.getSelfHosuse_ID()!=null && !"".equals(selfHouse2.getSelfHosuse_ID())){
			selfHouse3.setSelfHosuse_ID(selfHouse2.getSelfHosuse_ID());
				}	if(selfHouse2.getThirdName()!=null && !"".equals(selfHouse2.getThirdName())){
			selfHouse3.setThirdName(selfHouse2.getThirdName());
				}	if(selfHouse2.getUnit_uid()!=null){
			selfHouse3.setUnit_uid(selfHouse2.getUnit_uid());}	if(selfHouse2.getUpdateDateTime()!=null){
			selfHouse3.setUpdateDateTime(selfHouse2.getUpdateDateTime());}	
			if(selfHouse2.getUpdateUserName()!=null){
			selfHouse3.setUpdateUserName(user.getUser_name());				
			}
			}
			//配偶信息表  Crm_spouseInfo.java
			//主版本信息
			Crm_spouseInfo spouseInfo = new Crm_spouseInfo();
			spouseInfo.setClient_ID(clientMainnew.getClient_ID());			
			Crm_spouseInfo spouseInfo2 = spouseInfoService.selectOneSpouseInfo(spouseInfo);
			//副版本信息
			Crm_spouseInfo spouseInfo1 = new Crm_spouseInfo();
			spouseInfo1.setClient_ID(client_ID);			
			Crm_spouseInfo spouseInfo3 = spouseInfoService.selectOneSpouseInfo(spouseInfo1);
			if(spouseInfo3!=null&&spouseInfo2!=null){
				if(spouseInfo2.getClient_ID()!=null && !"".equals(spouseInfo2.getClient_ID())){
				spouseInfo3.setClient_ID(spouseInfo2.getClient_ID());}
				if(spouseInfo2.getContact()!=null  && !"".equals(spouseInfo2.getContact())){
				spouseInfo3.setContact(spouseInfo2.getContact());}
				if(spouseInfo2.getMonthIncome()!=null  && !"".equals(spouseInfo2.getMonthIncome())){
				spouseInfo3.setMonthIncome(spouseInfo2.getMonthIncome());}
				if(spouseInfo2.getPersonNum()!=null  && !"".equals(spouseInfo2.getPersonNum())){
				spouseInfo3.setPersonNum(spouseInfo2.getPersonNum());}
				if(spouseInfo2.getRemark()!=null  && !"".equals(spouseInfo2.getRemark())){
				spouseInfo3.setRemark(spouseInfo2.getRemark());}
				if(spouseInfo2.getSpouseName()!=null  && !"".equals(spouseInfo2.getSpouseName())){
				spouseInfo3.setSpouseName(spouseInfo2.getSpouseName());}
				if(spouseInfo2.getUnit_uid()!=null  && !"".equals(spouseInfo2.getUnit_uid())){
				spouseInfo3.setUnit_uid(spouseInfo2.getUnit_uid());}
				if(spouseInfo2.getUnitAddress()!=null  && !"".equals(spouseInfo2.getUnitAddress())){
				spouseInfo3.setUnitAddress(spouseInfo2.getUnitAddress());}
				if(spouseInfo2.getUnitName()!=null  && !"".equals(spouseInfo2.getUnitName())){
				spouseInfo3.setUnitName(spouseInfo2.getUnitName());}
				if(spouseInfo2.getUnitPhone()!=null  && !"".equals(spouseInfo2.getUnitPhone())){
				spouseInfo3.setUnitPhone(spouseInfo2.getUnitPhone());}
				if(spouseInfo2.getUnitPost()!=null  && !"".equals(spouseInfo2.getUnitPost())){
				spouseInfo3.setUnitPost(spouseInfo2.getUnitPost());
				}
				spouseInfo3.setUpdateDateTime(spouseInfo2.getUpdateDateTime());
				spouseInfo3.setUpdateUserName(user.getUser_name());
			}		
			if(crm_clientMapper.updateOneCompanyClientInfo(clientMain)==1){
			ar.setSucceed(1);
			}
			else{
				ar.setSucceed(0);
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}	
		return ar;
	}
	
	/**
	 * @description  前往客户副版本列表页面
	 * @author wuhn
	 * @date 2017年9月29日 上午9:27:08
	 */
	@RequestMapping(value="/toSlaveClientPage")
	public ModelAndView toSlaveClientPage(String clientGUIDs){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		/*String[] split = clientGUIDs.split(",");
		StringBuffer sb = new StringBuffer();
		for (String s : split) {
			String wheresql=" and clientGUID='"+s+"' and isMainVersion ='"+false+"'";
			 List<Client> clientList = clientService.selectClientListByWheresql(wheresql);
			if(clientList != null && clientList.size()>0 ){
				for (Client c : clientList) {
					// 副版本的客户id集合
					sb.append(c.getClient_ID()+",");
				}
			}
		}*/
		modeAndView.getModel().put("clientGUIDs", clientGUIDs); 
		modeAndView.setViewName("/crm/client/companyClient/companyClientSynchro");
		return modeAndView;
	}
	
	
	/**
	 * @description  项目客户资料同步到客户库 （同步到客户库） ---> 客户资料主版本同步到副版本
	 * @author wuhn
	 * @date 2017年9月28日 下午3:43:38
	 */
	@RequestMapping(value="/MainSyncSlaveClient")
	@ResponseBody
	public AjaxRes MainSyncSlaveClient(String client_ID){
		AjaxRes ar =new AjaxRes();
		Boolean info = clientService.MainSyncSlaveClient(SystemSession.getUserSession(), client_ID);
		System.out.println(client_ID);
		ar.setSucceed(info);
		return ar;
	}


	
	/**
	 * 事项办理客户资料
	 */
	@RequestMapping(value="/clientDetailGBPM")
	public ModelAndView clientDetailGBPM(UrlParam urlParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String viewName ="";
		if(null != urlParam.getEntityID()){
			String whereSql = " and apply_ID = \'"+urlParam.getEntityID()+"\'";
			//根据apply_ID查询Pro_apply表信息;	
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
			if(null != apply.getClient_ID()){
				Client client = clientService.selectOneClientByWheresql(" and client_ID = \'"+apply.getClient_ID()+"\'");
				mv.getModelMap().put("client",client);
			    if("01".equals(client.getClientTypeID())){//企业客户
			    	viewName = "/crm/client/companyClient/companyClientDetailGBPM";
			    }else{//个人客户
			    	viewName = "/crm/client/personClient/personClientDetailGBPM";
			    }
			}
			
			
		}
		mv.getModelMap().put("urlParam",urlParam);
		mv.setViewName(viewName);
		return mv;
	}

	/**
	 *手机端-- 事项办理客户资料
	 */
	@RequestMapping(value="/clientDetailGBPMApp")
	@ResponseBody
	public AjaxRes clientDetailGBPMApp(UrlParam urlParam){
		AjaxRes ar = new AjaxRes();
		if(null != urlParam.getEntityID()){
			String whereSql = " and apply_ID = \'"+urlParam.getEntityID()+"\'";
			//根据apply_ID查询Pro_apply表信息;	
			Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
			if(null != apply.getClient_ID()){
				Client client = clientService.selectOneClientByWheresql(" and client_ID = \'"+apply.getClient_ID()+"\'");
				ar.setSucceed(client);
			}
			
			
		}
		return ar;
	}

	/**
	 * 修改客户五级分类
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/updateClientRiskLevelExcel")
	public void fileBatchSaveOaHrSalary(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
//		try {
			File salaryFile = new File("E:\\国资委五级分类.xlsx");
			User sysUser = SystemSession.getUserSession();
	    	String fileName = salaryFile.getName();
	    	// 获取文件后缀
	        String prefix=fileName.substring(fileName.lastIndexOf("."));
	        //用uuid作为文件名，防止生成的临时文件重复
//	        File excelFile = File.createTempFile(UUIDGenerator.getUUID(), prefix);
//	        ((MultipartFile) salaryFile).transferTo(excelFile);//生成一个临时文件
	    	ExcelUtilToMap excelUtilToMap = new ExcelUtilToMap();
	    	List<Map> list2 = excelUtilToMap.readExcel(salaryFile);//[{员工姓名=陈杰, 岗位工资=2000, 绩效工资=1000}]
	    	clientService.updateClientRiskLevelExcel(fileName.substring(0, fileName.indexOf(".xlsx")),list2,sysUser,DateUtil.getNow());
//	    	deleteFile(excelFile);//删除临时文件
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	/**  
     * 删除  
     *   
     * @param files  
     */  
    private void deleteFile(File... files) {  
        for (File file : files) {  
            if (file.exists()) {  
                file.delete();  
            }  
        }  
    }

//    /**
//	 * 修改客户五级分类
//	 * @param repayFile
//	 * @param type
//     * @throws ServiceException 
//	 */
//	@SuppressWarnings({ "rawtypes", "static-access" })
//	@RequestMapping(value = "/updateClientRiskLevelExcel", method = {RequestMethod.POST })
//	public void updateClientRiskLevelExcel(@RequestParam(value = "salaryFile") MultipartFile salaryFile){
//	    ReportModel reportModel = new ReportModel();
//		if (!multipartFile.isEmpty()) {
//			// 文件名称
//			String fileName = multipartFile.getOriginalFilename();
//			// 取文件后缀名
//			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//			if (FileTypeUtil.isExcel(suffix)) {
//				List<List<String>> sheetList = new ArrayList<List<String>>();
//				// 获取报表的内容
//				switch (reportType) {
//				case ReportConstant.ENTERPRISE_BALANCE_SHEET:
//					sheetList = ExcelUtil.readExcel(multipartFile, BALANCE_SHEET_NAME);
//					reportModel = reportInfoService.importReportInfo(sheetList, customerId, reportType, BALANCE_SHEET_NAME, 2, 4, 56, 58);
//					break;
//				case ReportConstant.ENTERPRISE_PROFIT_SHEET:
//					sheetList = ExcelUtil.readExcel(multipartFile, PROFIT_SHEET_NAME);
//					reportModel = reportInfoService.importReportInfo(sheetList, customerId, reportType, PROFIT_SHEET_NAME, 2, 4, 23, 25);
//					break;
//				case ReportConstant.ENTERPRISE_CASH_FLOW_SHEET:
//					sheetList = ExcelUtil.readExcel(multipartFile, CASH_FLOW_SHEET_NAME);
//					reportModel = reportInfoService.importReportInfo(sheetList, customerId, reportType, CASH_FLOW_SHEET_NAME, 2, 4, 23, 25);
//					break;
//				case ReportConstant.LEGAL_BALANCE_SHEET:
//					sheetList = ExcelUtil.readExcel(multipartFile, BALANCE_SHEET_NAME);
//					reportModel = reportInfoService.importReportInfo(sheetList, customerId, reportType, BALANCE_SHEET_NAME, 2, 4, 56, 58);
//					break;
//				case ReportConstant.LEGAL_PROFIT_SHEET:
//					sheetList = ExcelUtil.readExcel(multipartFile, PROFIT_SHEET_NAME);
//					reportModel = reportInfoService.importReportInfo(sheetList, customerId, reportType, PROFIT_SHEET_NAME, 2, 4, 23, 25);
//					break;
//				case ReportConstant.LEGAL_CASH_FLOW_SHEET:
//					sheetList = ExcelUtil.readExcel(multipartFile, CASH_FLOW_SHEET_NAME);
//					reportModel = reportInfoService.importReportInfo(sheetList, customerId, reportType, CASH_FLOW_SHEET_NAME, 2, 4, 23, 25);
//					break;
//				}
//			} else {
//				throw new ServiceException(Constant.FAIL_CODE_VALUE, "请上传Excel类型报表文件.");
//			}
//		}
//	}

}
	

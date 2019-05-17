package com.zjm.crm.apply.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.apply.service.ApplyService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_applyMapper;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_apply;
import com.zjm.pro.applyDetail.service.ApplyDetailService;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.util.Tool;

@Service("applyService")
@Transactional
public class ApplyServiceImpl implements ApplyService {

	@Resource
	private Crm_applyMapper crmApplyMapper;
	@Resource
	private LogService logService;
	@Resource
	private ClientService clientService;
	@Resource
	private ApplyDetailService proApplyDetailService;

	/**
	 * 查询申请分页列表 
	 */
	@Override
	public PageTable<Crm_apply> selectApplyPageTable(PageTable<Crm_apply> pageTable) {
		List<Crm_apply> applyList = crmApplyMapper.selectApplyPageTable(pageTable);		
		Long applyTotal = crmApplyMapper.selectApplyPageTable_Count(pageTable);
		pageTable.setRows(applyList);
		pageTable.setTotal(applyTotal);
		return pageTable;
	}

	/**
	 * 插入一条申请记录
	 */
	@Override
	public Boolean insertOneApply(User user,Crm_apply apply) {	
		apply.setCapply_ID(Tool.createUUID32());
		apply.setPeriodMonthDay(concatMonthDay(apply));
		//设置编号，接待日期年份 + 四位序号，如 20170001，不区分企业和个人
		String applyNum = crmApplyMapper.selectMaxApplyNum(apply);
		if(applyNum == null || "".equals(applyNum)){
			applyNum = apply.getReceiveYear()+"0001";
		}else{
			applyNum = (Integer.parseInt(applyNum)+1)+"";
		}
		apply.setApplyNum(applyNum);
		if(apply.getperiodDay()==null){
			apply.setperiodDay(0);
		}
		if(crmApplyMapper.insertOneApply(apply)==1){
			String clientType = "";
			if(apply.getClientType().equals("01")){
				clientType = "企业";
			}else if(apply.getClientType().equals("02")){
				clientType = "个人";
			}
			logService.insertOneOperatorLogInfo(user,clientType+"咨询登记","添加", apply.getClientName());
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查询一条申请记录
	 */
	@Override
	public Crm_apply selectOneApply(Crm_apply apply) {
		try {
			return crmApplyMapper.selectOneApply(apply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 更新一条申请记录
	 */
	@Override
	public Boolean updateOneApply(User user,Crm_apply apply) {
		apply.setPeriodMonthDay(concatMonthDay(apply));
		String status = "";
		String clientType = "";
		if(apply.getperiodDay()==null){
			apply.setperiodDay(0);
		}
		if(crmApplyMapper.updateOneApply(apply)==1){
			if(apply.getClientType().equals("01")){
				clientType = "企业";
			}else if(apply.getClientType().equals("02")){
				clientType = "个人";
			}
			if(apply.getApprovalStatu().equals("01")){
				status = "咨询登记";
			}else if(apply.getApprovalStatu().equals("03")){
				status = "储备库";
			}else{
				status = "已受理项目";
			}
			logService.insertOneOperatorLogInfo(user,clientType+status, "修改", apply.getClientName());
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 删除一条申请记录
	 */
	@Override
	public Boolean deleteOneApply(User user,Crm_apply apply) {
		apply = selectOneApply(apply);
		String status = "";
		String clientType = "";
		if(crmApplyMapper.deleteOneApply(apply)==1){
			if(apply.getClientType().equals("01")){
				clientType = "企业";
			}else if(apply.getClientType().equals("02")){
				clientType = "个人";
			}
			if(apply.getApprovalStatu().equals("01")){
				status = "咨询登记";
			}else if(apply.getApprovalStatu().equals("03")){
				status = "储备库";
			}else{
				status = "已受理项目";
			}
			logService.insertOneOperatorLogInfo(user,clientType+status, "删除", apply.getClientName());
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 同意受理，将一条申请记录转入 受理登记.操作步骤:
	 * 	1.判断此申请的类型:企业/个人, 将申请信息拆分成两部分:客户基本信息 和 项目申请信息
	 *  2.客户基本信息	
	 *    企业咨询登记 对应 企业客户, 个人咨询登记 对应 个人消费性
	 *    	对于企业,要判断企业名称 在客户表crm_clinet中是否已存在; 对于个人,要判断个人身份证号码  在客户表crm_clinet中是否已存在.
	 *   	如果不存在,要在客户表中创建一条新数据, 同时,不论是否已存在,都要在客户表中创建一条该客户的副版本,作为项目中使用.
	 * 	3.项目申请信息
	 * 	      在项目申请表pro_apply和项目申请明细表pro_applyDetail中创建一条新数据
	 */
	@Override
	public Boolean agreeToAccept(User user,Crm_apply apply) {
		try {
			apply = selectOneApply(apply);
			String clientType = "";
			String sql = " and isMainVersion='1'";
			if(apply.getClientType().equals("01")){
				clientType = "企业";
				sql += " and clientName='"+apply.getClientName()+"'";		//企业客户根据企业名称查询是否重复
				Client client = clientService.selectOneClientByWheresql(sql);
				Pro_applyDetail proApplyDetail = new Pro_applyDetail();
				if(client==null){	//不存在, 先创建一个主版本, 且业务类型为新增业务
					/* * 新增客户必填项中的所属区域字段, 在咨询登记时没有
					 * fullAreaCode: "d8cdf8a52f6649c188cd2ef95300990d"
					 * fullAreaName: "省外"
					 * */
					client = new Client();
					client.setClientTypeID("01");
					client.setClientName(apply.getClientName());
					client.setCertificateCode(apply.getCertificateCode());	//统一社会信用代码
					client.setClientSourceID(apply.getClientSourceID());
					client.setClientSourceName(apply.getClientSourceName());
					client.setClientSourceDesc(apply.getClientSourceDesc());
					client.setCreateUserID(user.getUser_uid());
					client.setCreateUserName(user.getUser_name());
					client.setCreateDateTime(new Date());
					client.setContactOne(apply.getContact());
					client.setPhoneOne(apply.getPhone());
					client.setUnit_uid(user.getUnit_uid());
					client.setUnit_uidName(user.getUnit_uidName());
					clientService.insertOneCompanyClientInfo(user, client);
					
					proApplyDetail.setBusiNatureID("dbf065faffd948ed9e39d73eb5eb7bf6");
					proApplyDetail.setBusiNatureName("新增业务");
				}else{
					proApplyDetail.setBusiNatureID("f11443ed9b444a2db6242925c4f5a1dd");
					proApplyDetail.setBusiNatureName("存量业务");
				}
				
				proApplyDetail.setClient_ID(client.getClient_ID());
				proApplyDetail.setClientGUID(client.getClientGUID());
				proApplyDetail.setClientName(client.getClientName());
				proApplyDetail.setClientTypeID("53b8495782324d91a0c52be0203b7920");	//企业客户
				proApplyDetail.setCreateDate(client.getCreateDateTime());
				proApplyDetail.setCreateManID(client.getCreateUserID());
				proApplyDetail.setCreateManName(client.getCreateUserName());
				proApplyDetail.setDepartID(client.getFullDepartCode());
				proApplyDetail.setDepartName(client.getFullDepartName());
				proApplyDetail.setProjectType("单笔");
				proApplyDetail.setIsStop(0);
//				proApplyDetail.setIsUnpack(0);
//				proApplyDetail.setLoadUsed(apply.getLoadUsed());
				proApplyDetail.setPeriodMonth(apply.getperiodMonth());
				proApplyDetail.setPeriodDay(apply.getperiodDay());
				proApplyDetail.setPeriodMonthDay(apply.getPeriodMonthDay());
				proApplyDetail.setProjectName(apply.getClientName());
				proApplyDetail.setProjectSourceID(apply.getClientSourceID());
				proApplyDetail.setProjectSourceName(apply.getClientSourceName());
				proApplyDetail.setSourceDesc(apply.getClientSourceDesc());
				proApplyDetail.setProjectStageID("流程未启动");
				proApplyDetail.setProjectStageName("流程未启动");
				/*proApplyDetail.setProvideGuaranty(apply.getProvideGuaranty());
				proApplyDetail.setRepaymentPlan(apply.getRepaymentPlan());*/
				
				StringBuffer busiDetails = new StringBuffer();
				busiDetails.append(client.getClientName()+",");
				busiDetails.append(client.getClient_ID()+",");
				busiDetails.append(",,");	//项目类型  (中小企业项目/三农（农户）项目/....) 名称及字典ID
				busiDetails.append(apply.getCooperationName()+",");
				busiDetails.append(apply.getCooperationID()+",");
				busiDetails.append(apply.getBusiTypeName()+",");
				busiDetails.append(apply.getBusiTypeID()+",");
//				busiDetails.append(",,");	//绿色通道(大学生计划/瞪羚计划/...) 名称及字典ID	//项目申请时删除了绿色通道选项  2017/10/30
				busiDetails.append(apply.getApplySum()+",");
				busiDetails.append(apply.getperiodMonth()+",");
				proApplyDetail.setBusiDetails(busiDetails.toString());
				
				/* 创建项目登记申请, 在调用的方法中创建副版本 */   
				proApplyDetailService.insertProjectApply(user, proApplyDetail);
				
			}else if(apply.getClientType().equals("02")){
				clientType = "个人";
				/*	clientTypeID:"03"
					createDateTime:"2017-08-22"
					createUserID:"32a3e2cbd422451ba333802e123a2391"
					createUserName:"管理员"
					personName:"1"
					personNum:"111111111111111111"*/
				sql += " and personNum='"+apply.getCertificateCode()+"'";	//个人客户根据身份证号码查询是否重复
				Client client = clientService.selectOneClientByWheresql(sql);
				Pro_applyDetail proApplyDetail = new Pro_applyDetail();
				if(client==null){	
					client = new Client();
					client.setClientTypeID("03");
					client.setPersonName(apply.getClientName());
					client.setPersonNum(apply.getCertificateCode());
					client.setClientSourceID(apply.getClientSourceID());
					client.setClientSourceName(apply.getClientSourceName());
					client.setClientSourceDesc(apply.getClientSourceDesc());
					client.setCreateUserID(user.getUser_uid());
					client.setCreateUserName(user.getUser_name());
					client.setCreateDateTime(new Date());
					client.setPhone(apply.getPhone());
					client.setHouseTel(apply.getTelephone());
					client.setUnit_uid(user.getUnit_uid());
					client.setUnit_uidName(user.getUnit_uidName());
					clientService.insertOneCompanyClientInfo(user, client);
					
					proApplyDetail.setBusiNatureID("dbf065faffd948ed9e39d73eb5eb7bf6");
					proApplyDetail.setBusiNatureName("新增业务");
				}else{
					proApplyDetail.setBusiNatureID("f11443ed9b444a2db6242925c4f5a1dd");
					proApplyDetail.setBusiNatureName("存量业务");
				}
				proApplyDetail.setClient_ID(client.getClient_ID());
				proApplyDetail.setClientGUID(client.getClientGUID());
				proApplyDetail.setClientName(client.getPersonName());
				proApplyDetail.setClientTypeID("00a49b5305d248a18d54e54adb6123f4");	//个人消费性客户
				proApplyDetail.setCreateDate(client.getCreateDateTime());
				proApplyDetail.setCreateManID(client.getCreateUserID());
				proApplyDetail.setCreateManName(client.getCreateUserName());
				proApplyDetail.setDepartID(client.getFullDepartCode());
				proApplyDetail.setDepartName(client.getFullDepartName());
				proApplyDetail.setProjectType("单笔");
				proApplyDetail.setIsStop(0);
				/*proApplyDetail.setIsUnpack(0);
				proApplyDetail.setLoadUsed(apply.getLoadUsed());*/
				proApplyDetail.setPeriodMonth(apply.getperiodMonth());
				proApplyDetail.setPeriodDay(apply.getperiodDay());
				proApplyDetail.setPeriodMonthDay(apply.getPeriodMonthDay());
				proApplyDetail.setProjectName(apply.getClientName());
				proApplyDetail.setProjectSourceID(apply.getClientSourceID());
				proApplyDetail.setProjectSourceName(apply.getClientSourceName());
				proApplyDetail.setSourceDesc(apply.getClientSourceDesc());
				proApplyDetail.setProjectStageID("流程未启动");
				proApplyDetail.setProjectStageName("流程未启动");
//				proApplyDetail.setProvideGuaranty(apply.getProvideGuaranty());
//				proApplyDetail.setRepaymentPlan(apply.getRepaymentPlan());
				
				StringBuffer busiDetails = new StringBuffer();
				busiDetails.append(client.getClientName()+",");
				busiDetails.append(client.getClient_ID()+",");
				busiDetails.append(",,");	//项目类型  (中小企业项目/三农（农户）项目/....) 名称及字典ID
				busiDetails.append(apply.getCooperationName()+",");
				busiDetails.append(apply.getCooperationID()+",");
				busiDetails.append(apply.getBusiTypeName()+",");
				busiDetails.append(apply.getBusiTypeID()+",");
//				busiDetails.append(",,");	//绿色通道(大学生计划/瞪羚计划/...) 名称及字典ID 	//项目申请时删除了绿色通道选项  2017/10/30
				busiDetails.append(apply.getApplySum()+",");
				busiDetails.append(apply.getperiodMonth()+",");
				proApplyDetail.setBusiDetails(busiDetails.toString());
				
				/* 创建项目登记申请, 在调用的方法中创建副版本 */   
				proApplyDetailService.insertProjectApply(user, proApplyDetail);
			}
			
			if(crmApplyMapper.agreeToAccept(apply)==1){
				logService.insertOneOperatorLogInfo(user,clientType+"咨询登记", "转入受理申请", apply.getClientName());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * 不同意受理，将一条申请记录转入客户储备库
	 */
	@Override
	public Boolean disagreeToAccept(User user,Crm_apply apply) {
		String clientType = "";
		if(crmApplyMapper.disagreeToAccept(apply)==1){
			if(apply.getClientType().equals("01")){
				clientType = "企业";
			}else if(apply.getClientType().equals("02")){
				clientType = "个人";
			}
			logService.insertOneOperatorLogInfo(user,clientType+"咨询登记", "转入"+clientType+"储备库", apply.getClientName());
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 拼接申请期限字符串
	 */
	private String concatMonthDay(Crm_apply apply){
		Integer month = apply.getperiodMonth();
		Integer day = apply.getperiodDay();
		StringBuffer periodMonthDay = new StringBuffer();
		if( month!=null && !month.equals(0)){
			periodMonthDay.append(month+"个月");
			if(day!=null && day!=0){
				periodMonthDay.append(day+"天");
			}
		}else if(day!=null && day!=0){
			periodMonthDay.append(day+"天");
		}/*else{	//申请期限改为非必填项后注释此段代码
			periodMonthDay.append("0天");
		}*/
		return periodMonthDay.toString();
	}

	/**
	 * 判断客户名称是否重复 
	 */
	@Override
	public Boolean isExistClientName(Crm_apply apply) {
		if(crmApplyMapper.isExistClientName(apply)==0){
			return true;
		}else{
			return false;
		}
	}
//记录添加
	@Override
	public PageTable<Crm_apply> selectRegisterPageTable(PageTable<Crm_apply> pageTable) {
		List<Crm_apply> applyList = crmApplyMapper.selectRegisterPageTable(pageTable);		
		Long applyTotal = crmApplyMapper.selectRegisterPageTable_Count(pageTable);
		pageTable.setRows(applyList);
		pageTable.setTotal(applyTotal);
		return pageTable;
	
	}

	/**
	 * 根据企业名称判断是否是黑名单企业
	 */
	@Override
	public Boolean isExistBadClient(Crm_apply apply) {
		try {
			return clientService.selectClientNameIsExist(" and isBadClient='1' and clientName='"+apply.getClientName()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据身份证号码判断是否是黑名单个人
	 */
	@Override
	public Boolean isExistBadPerson(Crm_apply apply) {
		try {
			return clientService.selectClientNameIsExist(" and isBadClient='1' and personNum='"+apply.getCertificateCode()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

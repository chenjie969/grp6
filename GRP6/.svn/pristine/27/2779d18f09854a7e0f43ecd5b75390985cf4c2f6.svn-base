package com.zjm.pro.credit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.credit.service.CreditApplyService;
import com.zjm.pro.db.map.Pro_applyDetailMapper;
import com.zjm.pro.db.map.Pro_applyMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_projectCode;
import com.zjm.pro.projectCode.service.ProjectCodeService;
import com.zjm.util.Tool;

@Service("creditApplyService")
@Transactional
public class CreditApplyServiceImpl implements CreditApplyService {

	@Resource
	private Pro_applyMapper applyMapper;
	@Resource
	private Pro_applyDetailMapper applyDetailMapper;
	@Resource
	private LogService logService;
	
	@Resource
	private ProjectCodeService projectCodeService;
	
	/**
	 * 查询授信申请分页列表
	 */
	public PageTable<Pro_apply> selectCreditApplyPageTables(PageTable<Pro_apply> pageTable){
		try{
			List<Pro_apply> list = applyMapper.selectApplyPageTables(pageTable);
			Long count = applyMapper.selectApplyPageTables_Count(pageTable);
			pageTable.setRows(list);
			pageTable.setTotal(count);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	
	/**
	 *	新增授信申请记录，返回新增的主键ID 
	 */
	public String insertOneCreditApply(User user,Pro_apply creditApply){
		try {
		//先在pro_apply表中插入主要数据
			String apply_ID = Tool.createUUID32();
			creditApply.setApply_ID(apply_ID);
			//设置编号
			Pro_projectCode projectCode = new Pro_projectCode();
			projectCode=projectCodeService.returnOneProjectCode(user, "credit");
			//格式化客户编号之后再设置
			String projectBH = projectCode.getYears() + projectCodeFormat(projectCode.getCreditCode());
			creditApply.setBusiCode(projectBH);
			creditApply.setProjectType("综合授信");
			creditApply.setUnit_uid(user.getUnit_uid());
			creditApply.setUnit_uidName(user.getUnit_uidName());
			creditApply.setUpdateUserName(user.getUser_name());
			creditApply.setUsedSum(new Double(0));		//设置初始已用额度为0
			creditApply.setAgreeSum(creditApply.getApplySum());		//审批金额先默认成申请金额，待完成审批流程后再按审批结果修改 agreeSum
			String tableDate = creditApply.getBusiTableDate();
			String[] rowDate = tableDate.split(";");	//public String[] split(String regex, int limit)，limit不写默认为0，结尾空字符串被丢弃
			int rowNum = rowDate.length;
			String tdDate[][] = new String[rowNum][];
			//有业务品种限制，定义一个二维数组，接收表格中的数据
			if(creditApply.getIsBusiLimit()==1){
				for(int i = 0; i < rowNum; i++){
					tdDate[i] = rowDate[i].split(",",-1);	//设置limit=-1，保留结尾空字符串
				}
				StringBuffer sb_busiTypeName = new StringBuffer();
				StringBuffer sb_bankName = new StringBuffer();
				for(int i = 0; i < rowNum; i++){
					sb_busiTypeName.append(tdDate[i][0]);	//业务品种在tdDate第0列，合作机构在第3列
					sb_bankName.append(tdDate[i][3]);
					if( i < rowNum-1 ){
						sb_busiTypeName.append(",");
						sb_bankName.append(",");
					}
				}
				creditApply.setBusiTypeNameList(sb_busiTypeName.toString());
				creditApply.setBankNameList(sb_bankName.toString());
			}
			Integer applyFlag = applyMapper.insertOneApplyInfo(creditApply);
			
			//由于主外键关系的存在，必须先执行上面的程序，在pro_apply表中插入一条数据后，才能向pro_applyDetail表中插入业务数据，每有一种业务(表格一行)，就插入一条数据
			int applyDetailFlag = 0;		//记录pro_applyDetail表中插入了多少条数据
			if(creditApply.getIsBusiLimit()==1){
				for(int i = 0; i < rowNum; i++){
					Pro_applyDetail applyDetail = new Pro_applyDetail();
					applyDetail.setApplyDetail_ID(Tool.createUUID32());
					applyDetail.setApply_ID(apply_ID);
					applyDetail.setClient_ID(creditApply.getClient_ID());
					applyDetail.setClientName(creditApply.getClientName());
					applyDetail.setBusiTypeName(tdDate[i][0]);
					applyDetail.setBusiTypeID(tdDate[i][1]);
					applyDetail.setApplySum(new Double(tdDate[i][2]));
					applyDetail.setAgreeSum(new Double(tdDate[i][2]));	//申请时默认审批金额等于申请金额，审批结束后再修改此值
					applyDetail.setBankName(tdDate[i][3]);
					applyDetail.setBankID(tdDate[i][4]);
					//applyDetail.setUsedSum(new Double(0));		//设置初始已用额度为0
					applyDetail.setUnit_uid(user.getUnit_uid());	
					applyDetail.setUnit_uidName(user.getUnit_uidName());
					applyDetail.setUpdateUserName(user.getUser_name());
					if(applyDetailMapper.insertOneApplyDetailInfo(applyDetail)==1){
						applyDetailFlag++;
					}
				}
			}
			
			if(creditApply.getIsBusiLimit()==1){	//有品种限制，要判断pro_apply和pro_applyDetail表同时操作成功
				if(applyFlag==1 && applyDetailFlag==rowNum){
					logService.insertOneOperatorLogInfo(user, "授信管理", "添加", "添加授信项-"+creditApply.getProjectName());
					return apply_ID;
				}
			}else{	//没有品种限制，只判断pro_apply表是否插入成功
				if(applyFlag==1){
					logService.insertOneOperatorLogInfo(user, "授信管理", "添加", "添加授信项-"+creditApply.getProjectName());
					return apply_ID;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *	新增授信项下项目申请记录
	 */
	public Boolean insertOneCreditProjectApply(User user,Pro_applyDetail applyDetail){
	// 先插入pro_apply表，封装实体
		Pro_apply apply = new Pro_apply();
		apply.setApply_ID(Tool.createUUID32());
		//设置编号
		Pro_projectCode projectCode = new Pro_projectCode();
		projectCode=projectCodeService.returnOneProjectCode(user, "apply");
		//格式化客户编号之后再设置
		String projectBH = projectCode.getYears() + projectCodeFormat(projectCode.getApplyCode());
		apply.setBusiCode(projectBH);
		apply.setProjectName(applyDetail.getProjectName());
		apply.setApplySum(applyDetail.getApplySum());
		
		apply.setParentApply_ID(applyDetail.getParentApply_ID());
		
		apply.setBusiTypeNameList(applyDetail.getBusiTypeName());
		apply.setBankNameList(applyDetail.getBankName());
		apply.setUnit_uid(user.getUnit_uid());
		apply.setUnit_uidName(user.getUnit_uidName());
		apply.setUpdateUserName(user.getUser_name());
		apply.setDepartID(applyDetail.getDepartID());
		apply.setDepartName(applyDetail.getDepartName());
		apply.setCreateManID(applyDetail.getCreateManID());
		apply.setCreateManName(applyDetail.getCreateManName());
		apply.setCreateDate(applyDetail.getCreateDate());
		List<Pro_apply> fundsList = applyMapper.selectApplyListByWhereSql(" and parentApply_ID='"+applyDetail.getParentApply_ID()+"'");
		if(fundsList==null || fundsList.size()==0){
			apply.setIsFirstApply(1);									//新增项目申请，是否首次额度申请设为1
		}
	// 再插入pro_applyDetail表，封装实体	
		applyDetail.setApplyDetail_ID(Tool.createUUID32());
		applyDetail.setApply_ID(apply.getApply_ID());
		applyDetail.setUnit_uid(user.getUnit_uid());
		applyDetail.setUnit_uidName(user.getUnit_uidName());
		applyDetail.setUpdateUserName(user.getUser_name());
		applyDetail.setIsCreditSubProject(1);		//是否授信客户真实项目设置为1
		Integer month = applyDetail.getPeriodMonth();
		Integer day = applyDetail.getPeriodDay();
		StringBuffer periodMonthDay = new StringBuffer();
		if(month==0 && day==0){
			periodMonthDay.append("0天");
		}else{
			if(month != 0){
				periodMonthDay.append(month+"个月");
			}
			if(day != 0){
				periodMonthDay.append(day+"天");
			}
		}
		applyDetail.setPeriodMonthDay(periodMonthDay.toString());
		
		try{
			Integer applyNum = applyMapper.insertOneApplyInfo(apply);
			Integer applyDetailNum = applyDetailMapper.insertOneApplyDetailInfo(applyDetail);
			if( applyNum==1 && applyDetailNum==1){
				logService.insertOneOperatorLogInfo(user, "授信管理", "添加", "添加授信项下项目-"+applyDetail.getProjectName());
				
				//项目一经申请，申请金额就要马上加到授信项的已用额度中
				Pro_apply creditApply = applyMapper.selectOneApplyWhereSql(" and apply_ID='"+applyDetail.getParentApply_ID()+"'");	//查出项目对应的授信项
				Double usedSum = creditApply.getUsedSum();
				creditApply.setUsedSum(usedSum+applyDetail.getApplySum());
				applyMapper.updateOneApplyInfo(creditApply);
				//先判断是否额度混用，若不混用，授信项下必有两条以上的业务明细，还要把项目申请的业务品种的申请金额加到对应授信明细的已用额度中
				if(creditApply.getIsBlend()!=null && creditApply.getIsBlend()==0){
					List<Pro_applyDetail> creditDetailList = applyDetailMapper.selectApplyDetailList(" and apply_ID='"+creditApply.getApply_ID()+"'");
					Boolean bankNotFindFlag = true;
					for (Pro_applyDetail creditDetail : creditDetailList) {
						if(applyDetail.getBusiTypeID().equals(creditDetail.getBusiTypeID())){	//遍历结束前，一定能找到一个对应的业务
							if(applyDetail.getBankID().equals(creditDetail.getBankID())){	//业务品种一致的前提下，再比较合作机构是否一致
								/*Double detailUsedSum = creditDetail.getUsedSum();
								creditDetail.setUsedSum(detailUsedSum+applyDetail.getApplySum());*/
								applyDetailMapper.updateOneApplyDetailInfo(creditDetail);
								bankNotFindFlag = false;
							}
						}
					}
					if(bankNotFindFlag){
						for (Pro_applyDetail creditDetail : creditDetailList) {
							if(applyDetail.getBusiTypeID().equals(creditDetail.getBusiTypeID())){	//遍历结束前，一定能找到一个对应的业务
								if("".equals(creditDetail.getBankID())){	//业务品种一致的前提下，找合作机构为空的明细信息
									/*Double detailUsedSum = creditDetail.getUsedSum();
									creditDetail.setUsedSum(detailUsedSum+applyDetail.getApplySum());*/
									applyDetailMapper.updateOneApplyDetailInfo(creditDetail);
									bankNotFindFlag = false;
								}
							}
						}
					}
				}
				
				
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查询一条授信申请信息_带明细
	 */
	public Pro_apply selectOneCreditApply(Pro_apply creditApply,String selectType){
		Pro_apply result = null;
		try{
			if("credit".equals(selectType)){	//查询授信申请
				result = applyMapper.selectOneApplyWhereSql(" and apply_ID='"+creditApply.getApply_ID()+"'");
			}else{
				result = applyMapper.selectOneApplyWhereSql(" and parentApply_ID='"+creditApply.getParentApply_ID()+"'");
			}
			if(result != null){
				List<Pro_applyDetail> applyDetailList = applyDetailMapper.selectApplyDetailList(" and apply_ID='"+result.getApply_ID()+"'");
				result.setDetailList(applyDetailList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 删除一条授信申请信息
	 */
	public Boolean deleteOneCreditApply(User user,Pro_apply creditApply){
		try{
			creditApply = selectOneCreditApply(creditApply, "credit");
			applyMapper.delectApplyByWhereSql(" and apply_ID='"+creditApply.getApply_ID()+"'");
			if(creditApply.getIsBusiLimit()==1){	//有业务品种限制，删除明细表
				applyDetailMapper.deleteApplyDetailByWhereSql(" and apply_ID='"+creditApply.getApply_ID()+"'");
			}
			//查询该授信项下是否有项目，有的话也要删除
			Pro_apply creditProjectApply = new Pro_apply();
			creditProjectApply.setParentApply_ID(creditApply.getApply_ID());
			creditProjectApply = selectOneCreditApply(creditProjectApply,"project");
			if(creditProjectApply!=null){	//删除授信项下的项目申请及其明细
				applyMapper.delectApplyByWhereSql(" and apply_ID='"+creditProjectApply.getApply_ID()+"'");
				applyDetailMapper.deleteApplyDetailByWhereSql(" and apply_ID='"+creditProjectApply.getApply_ID()+"'");
			}
			logService.insertOneOperatorLogInfo(user, "授信管理", "删除", "删除授信项下的项目-"+creditApply.getProjectName());
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查询某授信项的用款明细
	 */
	public PageTable<Pro_apply> selectFundsDetailPageTables(PageTable<Pro_apply> pageTable){
		try{
			pageTable.setWheresql(" and unit_uid='"+pageTable.getQueryCondition().getUnit_uid()+"'"+
									" and parentApply_ID = '"+pageTable.getQueryCondition().getParentApply_ID()+"'");
			pageTable.setSortName("updateDateTime");
			List<Pro_apply> fundsList = applyMapper.selectApplyPageTables(pageTable);
			Long count = applyMapper.selectApplyPageTables_Count(pageTable);
			for (Pro_apply pro_apply : fundsList) {
				List<Pro_applyDetail> detailList = applyDetailMapper.selectApplyDetailList(" and apply_ID = '"+pro_apply.getApply_ID()+"'");
				pro_apply.setDetailList(detailList);
			}
			pageTable.setRows(fundsList);
			pageTable.setTotal(count);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	
	/**
	 * 根据 apply_ID 修改 pro_apply表 的内容
	 */
	public Boolean updateApply(Pro_apply apply){
		try{
			Integer updateNum = applyMapper.updateOneApplyInfo(apply);
			if(updateNum==1){
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//编号位数生成
	private String projectCodeFormat(Integer number) {
		String projectcodes="" + number;
		for(int i=0;projectcodes.length()<4;i++){
			projectcodes="0"+projectcodes;
		}
		return projectcodes;
	}
}

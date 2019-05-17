package com.zjm.pro.project.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.crm.db.map.Crm_badClientMapper;
import com.zjm.crm.db.map.Crm_bankAccountMapper;
import com.zjm.crm.db.map.Crm_billRecMapper;
import com.zjm.crm.db.map.Crm_clientMapper;
import com.zjm.crm.db.map.Crm_clientShareMapper;
import com.zjm.crm.db.map.Crm_client_relationMainMapper;
import com.zjm.crm.db.map.Crm_clientfilesMapper;
import com.zjm.crm.db.map.Crm_costInfoMapper;
import com.zjm.crm.db.map.Crm_creditInfoMapper;
import com.zjm.crm.db.map.Crm_financeDescMapper;
import com.zjm.crm.db.map.Crm_guarantyRecMapper;
import com.zjm.crm.db.map.Crm_inventoryMapper;
import com.zjm.crm.db.map.Crm_landHouseMapper;
import com.zjm.crm.db.map.Crm_loanRecMapper;
import com.zjm.crm.db.map.Crm_machineMapper;
import com.zjm.crm.db.map.Crm_managerInfoMapper;
import com.zjm.crm.db.map.Crm_oldClientNameMapper;
import com.zjm.crm.db.map.Crm_orderMapper;
import com.zjm.crm.db.map.Crm_otherReceivableMapper;
import com.zjm.crm.db.map.Crm_payTaxInfoMapper;
import com.zjm.crm.db.map.Crm_receivableMapper;
import com.zjm.crm.db.map.Crm_relationClientMapper;
import com.zjm.crm.db.map.Crm_relationMainMapper;
import com.zjm.crm.db.map.Crm_reportSyMapper;
import com.zjm.crm.db.map.Crm_reportXjlMapper;
import com.zjm.crm.db.map.Crm_reportZcfzMapper;
import com.zjm.crm.db.map.Crm_riskLevelRecMapper;
import com.zjm.crm.db.map.Crm_selfHouseMapper;
import com.zjm.crm.db.map.Crm_spouseInfoMapper;
import com.zjm.crm.db.map.Crm_stockMapper;
import com.zjm.crm.db.map.Crm_upDownClientMapper;
import com.zjm.crm.db.model.Client;
import com.zjm.gbpm.db.map.Gbpm_finishNodeMapper;
import com.zjm.gbpm.db.map.Gbpm_finishTaskMapper;
import com.zjm.gbpm.db.map.Gbpm_productInstanceMapper;
import com.zjm.gbpm.db.map.Gbpm_runNodeMapper;
import com.zjm.gbpm.db.map.Gbpm_runTaskMapper;
import com.zjm.gbpm.db.model.Gbpm_productInstance;
import com.zjm.pro.db.map.Pro_applyDetailMapper;
import com.zjm.pro.db.map.Pro_applyMapper;
import com.zjm.pro.db.map.Pro_assetSealUpMapper;
import com.zjm.pro.db.map.Pro_delayMapper;
import com.zjm.pro.db.map.Pro_factPayMapper;
import com.zjm.pro.db.map.Pro_meetingDetailMapper;
import com.zjm.pro.db.map.Pro_meetingResolutionMapper;
import com.zjm.pro.db.map.Pro_optGuarantyMapper;
import com.zjm.pro.db.map.Pro_projChangeRecMapper;
import com.zjm.pro.db.map.Pro_projectLawsuitMapper;
import com.zjm.pro.db.map.Pro_projectMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.map.Pro_replaceMapper;
import com.zjm.pro.db.map.Pro_returnDetailMapper;
import com.zjm.pro.db.map.Pro_riskSchemeMapper;
import com.zjm.pro.db.map.Pro_suggestMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_riskScheme;
import com.zjm.pro.project.service.TestService;
import com.zjm.sys.db.map.C_bankSortMapper;
import com.zjm.sys.db.map.C_multiLevelSortMapper;
import com.zjm.sys.db.model.C_bankSort;
import com.zjm.sys.db.model.C_multiLevelSort;
import com.zjm.sys.multilevelsort.service.MultiLevelSortService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {

	@Resource
	Pro_projectMapper pro_projectMapper;
	@Resource
	Pro_applyMapper pro_applyMapper;
	@Resource
	Pro_applyDetailMapper pro_applyDetailMapper;
	/*********用户mapper***********/
	@Resource  
	Crm_clientMapper crm_clientMapper;
	@Resource
	Crm_badClientMapper crm_badclientMapper;
	@Resource
	Crm_bankAccountMapper crm_bankAccountMapper;
	@Resource
	Crm_billRecMapper crm_billRecMapper;
//	crm_clientout
	@Resource
	Crm_guarantyRecMapper crm_guarantyRecMapper;
	@Resource
	Crm_loanRecMapper	crm_loanRecMapper;
	@Resource
	Crm_managerInfoMapper	crm_managerInfoMapper;
	@Resource
	Crm_oldClientNameMapper	crm_oldClientNameMapper;
	@Resource
	Crm_relationClientMapper	crm_relationClientMapper;
	@Resource
	Crm_client_relationMainMapper crm_client_relationMainMapper;
	@Resource
	Crm_clientfilesMapper		crm_clientfilesMapper;
	@Resource
	Crm_clientShareMapper	crm_clientShareMapper;
	@Resource
	Crm_costInfoMapper		crm_costInfoMapper;
	@Resource
	Crm_creditInfoMapper	crm_creditInfoMapper;
	@Resource
	Crm_financeDescMapper 	crm_financeDescMapper;
	@Resource
	Crm_inventoryMapper		crm_inventoryMapper;
	@Resource
	Crm_landHouseMapper	 	crm_landHouseMapper;
	@Resource
	Crm_machineMapper		crm_machineMapper;
	@Resource
	Crm_orderMapper			crm_orderMapper;
	@Resource
	Crm_otherReceivableMapper	crm_otherReceivableMapper;
	@Resource
	Crm_payTaxInfoMapper	crm_payTaxInfoMapper;
	@Resource
	Crm_receivableMapper	crm_receivableMapper;
	@Resource
	Crm_relationMainMapper	crm_relationMainMapper;
	@Resource
	Crm_reportSyMapper		crm_reportSyMapper;
	@Resource
	Crm_reportXjlMapper		crm_reportXjlMapper;
	@Resource
	Crm_reportZcfzMapper	crm_reportZcfzMapper;
	@Resource
	Crm_riskLevelRecMapper	crm_riskLevelRecMapper;
	@Resource
	Crm_selfHouseMapper		crm_selfHouseMapper;
	@Resource
	Crm_spouseInfoMapper	crm_spouseInfoMapper;
	@Resource
	Crm_stockMapper			crm_stockMapper;
	@Resource
	Crm_upDownClientMapper	crm_upDownClientMapper;
	
	/******项目mapper*******/
	@Resource
	Pro_factPayMapper 		pro_factPayMapper;
	@Resource
	Pro_delayMapper			pro_delayMapper;
	@Resource
	Pro_replaceMapper		pro_replaceMapper;
	@Resource
	Pro_returnDetailMapper	pro_returnDetailMapper;
	@Resource
	Pro_projectLawsuitMapper	pro_projectLawsuitMapper;
	@Resource
	Pro_assetSealUpMapper		pro_assetSealUpMapper;
	@Resource
	Pro_projChangeRecMapper		pro_projChangeRecMapper;
	
	@Resource
	Pro_optGuarantyMapper			pro_optGuarantyMapper;
	@Resource
	Pro_meetingDetailMapper			pro_meetingDetailMapper;
	@Resource
	Pro_meetingResolutionMapper		pro_meetingResolutionMapper;
	
	/**********流程mapper**********/
	@Resource
	Gbpm_productInstanceMapper  gbpm_productInstanceMapper;
	@Resource
	Gbpm_finishNodeMapper		gbpm_finishNodeMapper;
	@Resource
	Gbpm_finishTaskMapper		gbpm_finishTaskMapper;
	@Resource
	Gbpm_runNodeMapper			gbpm_runNodeMapper;
	@Resource
	Gbpm_runTaskMapper			gbpm_runTaskMapper;
	@Resource
	Pro_projectfilesMapper		pro_projectfilesMapper;
	@Resource
	Pro_suggestMapper			pro_suggestMapper;
	@Resource
	Pro_riskSchemeMapper		pro_riskSchemeMapper;
	@Resource
	C_bankSortMapper		c_bankSortMapper;
	@Resource
	private C_multiLevelSortMapper c_multiLevelSortMapper;
	
	@Override
	public int updateDelayPerio() {
		List<Pro_project> list = pro_projectMapper.selectDelay();
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			Pro_project project = list.get(i);
			Date loadBeginDate = project.getLoadBeginDate();
			Date loadEndDate = project.getLoadEndDate();
			Date  delayEndDate = project.getDelayEndDate();
			int[] oldmd = getMonthAndDay(loadBeginDate, loadEndDate);//获取项目的老期限日，月
			String oldPeriodMonthDay = getMonthDayByMonthAndDay(oldmd[0],oldmd[1]);
			int oldPeriodDay = oldmd[1];
			int oldPeriodMonth = oldmd[0];
			int[] delaymd = getMonthAndDay(loadBeginDate, delayEndDate);//获取项目的老期限日，月
			int periodMonth = delaymd[0]; 
			int periodDay = delaymd[1];
			String periodMonthDay = getMonthDayByMonthAndDay(delaymd[0],delaymd[1]);
			project.setOldPeriodDay(oldPeriodDay);
			project.setOldPeriodMonth(oldPeriodMonth);
			project.setOldPeriodMonthDay(oldPeriodMonthDay);
			project.setPeriodDay(periodDay);
			project.setPeriodMonth(periodMonth);
			project.setPeriodMonthDay(periodMonthDay);
			int a = pro_projectMapper.updatePeriod(project);
			if(a>0){
				count ++;
				System.out.println(project.getProject_ID()+"\n");
			}
			
		}
		return count;
		
	}

	@Override
	public int updateUnDelayPerio() {
		List<Pro_project> list = pro_projectMapper.selectUnDelay();
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			Pro_project project = list.get(i);
			Date loadBeginDate = project.getLoadBeginDate();
			Date loadEndDate = project.getLoadEndDate();
			Date  delayEndDate = project.getDelayEndDate();
			int[] oldmd = getMonthAndDay(loadBeginDate, loadEndDate);//获取项目的老期限日，月
			String oldPeriodMonthDay = getMonthDayByMonthAndDay(oldmd[0],oldmd[1]);
			int oldPeriodDay = oldmd[1];
			int oldPeriodMonth = oldmd[0];
//			int[] delaymd = getMonthAndDay(loadBeginDate, delayEndDate);//获取项目的老期限日，月
//			int periodMonth = delaymd[0]; 
//			int periodDay = delaymd[1];
//			String periodMonthDay = getMonthDayByMonthAndDay(delaymd[0],delaymd[1]);
			project.setOldPeriodDay(oldPeriodDay);
			project.setOldPeriodMonth(oldPeriodMonth);
			project.setOldPeriodMonthDay(oldPeriodMonthDay);
			project.setPeriodDay(oldPeriodDay);
			project.setPeriodMonth(oldPeriodMonth);
			project.setPeriodMonthDay(oldPeriodMonthDay);
			pro_projectMapper.updatePeriod(project);
			int a = pro_projectMapper.updatePeriod(project);
			if(a>0){
				count ++;
				System.out.println(project.getProject_ID()+"\n");
			}
		}
		return count;
		
	}
	
	
	public  int[]  getMonthAndDay(Date fromDate,Date toDate) {
		Calendar  from  =  Calendar.getInstance();
	    from.setTime(fromDate);
	    Calendar  to  =  Calendar.getInstance();
	    to.setTime(toDate);
	    int fromYear = from.get(Calendar.YEAR);
	    int fromMonth = from.get(Calendar.MONTH);
	    int fromDay = from.get(Calendar.DAY_OF_MONTH);
	    int toYear = to.get(Calendar.YEAR);
	    int toMonth = to.get(Calendar.MONTH);
	    int toDay = to.get(Calendar.DAY_OF_MONTH);
	    int year = toYear  -  fromYear;
	    int day = toDay  - fromDay;
	    int month = year*12 + toMonth  - fromMonth;
	    if( day< 0){
	    	switch (toMonth) {
			case 0://一月
				day = 31 +day; //1月的时间加上负的天数
				break;

			default:
				Calendar cal = Calendar.getInstance(); 
		    	cal.set(Calendar.YEAR,toYear); 
		    	cal.set(Calendar.MONTH, toMonth-1);
		    	int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
		    	day =dateOfMonth+day;
				break;
			}
	    	month = year*12 + toMonth  - fromMonth -1 ;
	    }
	   
	    int[] monthDay = new int[]{month,day};
	    return monthDay;
	}
	
	
	public  String getMonthDayByMonthAndDay(Integer periodMonth,Integer periodDay){
		String periodMonthDay = "";
		if(periodMonth!=null && periodMonth != 0){
			periodMonthDay +=periodMonth+"个月";
		}
		if(periodDay!=null){	
			periodMonthDay +=periodDay+"天";					
		}
		return periodMonthDay.toString();
}

	@Override
	public Boolean deleteProjectAndRelationInfo(String projectId) {
		//查询 项目，查询申请信息，申请信息详情,获取与项目绑定的客户信息
		String wheresql = "select * from pro_project where project_ID = '"+projectId+"' ";
		Pro_project project = pro_projectMapper.selectProjectDataWhereSql(wheresql );
		if(null == project){
			return true;
		}
		Pro_apply apply = pro_applyMapper.selectOneApplyWhereSql("and apply_id = '"+project.getApply_ID()+"' ");
		Pro_applyDetail applyDetail = pro_applyDetailMapper.selectOneApplyDetailWhereSql(" and applyDetail_id = '"+project.getApplyDetail_ID()+"' ");
		Client client = crm_clientMapper.selectOneClientByWheresql("and client_ID = '"+apply.getClient_ID()+"' "); 
		//删除用户关联表
		if(!client.getIsMainVersion()){//不是主版本删除客户信息
			String clientId = client.getClient_ID();
			wheresql = "and client_ID = '"+clientId+"'";
			crm_badclientMapper.deleteBadClientByWhereSql(wheresql);
			crm_bankAccountMapper.deleteOneCompanyCrm_bankAccountByClient_ID(clientId);
			crm_billRecMapper.deleteBillRecByClient_ID(clientId);
//			crm_clientout
			crm_guarantyRecMapper.deleteGuarantyRecByClient_ID(clientId);
			crm_loanRecMapper.deleteLoanRecByClient_ID(clientId);
			crm_managerInfoMapper.deleteManagerInfoByClient_ID(clientId);
			crm_oldClientNameMapper.deleteOldClientMapperByClientId(clientId);
			crm_relationClientMapper.deleteRelationClientByClient_ID(clientId);
			crm_client_relationMainMapper.deleteRelationByClient_ID(clientId);
			crm_clientfilesMapper.deleteClientFilesByClient_ID(clientId);
			crm_clientShareMapper.deleteClientShareByClient_ID(clientId);
			crm_costInfoMapper.deleteCostInfoByWhereSql(wheresql);
			crm_creditInfoMapper.deleteCreditInfoByClient_ID(clientId);
			crm_financeDescMapper.deleteFinanceDescByWhereSql(wheresql);
			crm_inventoryMapper.deleteInventoryByWheresql(wheresql);
			crm_landHouseMapper.deleteLandHouseByClient_ID(clientId);
			crm_machineMapper.deleteMachineByClient_ID(clientId);
			crm_orderMapper.deleteOrderByWheresql(wheresql);
			crm_otherReceivableMapper.deleteOtherReceivableByClient_ID(clientId);
			crm_payTaxInfoMapper.deletePayTaxByClient_ID(clientId);
			crm_receivableMapper.deleteReceivableListByWhereSql(wheresql);
			crm_relationMainMapper.deleteByClient_ID(clientId);
			crm_reportSyMapper.delectReportSyByWhereSql(wheresql);
			crm_reportXjlMapper.delectReportXjlByWhereSql(wheresql);
			crm_reportZcfzMapper.delectReportZcfzByWhereSql(wheresql);
			crm_riskLevelRecMapper.deleteRiskLevelByClient_ID(clientId);
			crm_selfHouseMapper.deleteSelfHouseByClient_ID(clientId);
			crm_spouseInfoMapper.deleteSpouseByClient_ID(clientId);
			crm_stockMapper.deleteStockInfoByClient_ID(clientId);
			crm_upDownClientMapper.deleteUpDownClientByWhereSql(wheresql);
		}
		
		//删除项目信息
		if(null != project){
			String proWheresql = " and project_ID = '"+projectId +"' ";
			pro_factPayMapper.deletefactPayByProject_ID(projectId);
			pro_delayMapper.deleteDelayByWhereSql(proWheresql);
			pro_replaceMapper.deleteReplaceByProject_ID(projectId);
			pro_returnDetailMapper.deleteReturnDetailByProject_ID(projectId);
			pro_projectLawsuitMapper.deleteLawsuitMapperByProject_ID(projectId);
			pro_assetSealUpMapper.deleteSeaulUpsByProject_ID(projectId);
			pro_projChangeRecMapper.deleteProjChangeRecByProject_ID(projectId);
		}
		if( null != apply){//需修改
			String applyId = apply.getApply_ID();
			String applyWhereSql = " and apply_ID = '"+applyId+"' ";
			pro_optGuarantyMapper.deleteOptGuarantyByApply_Id(applyId);
			pro_meetingDetailMapper.deleteMeetingDetailByApply_ID(applyId);
			pro_meetingResolutionMapper.delMeetingResolutionBySql(applyWhereSql);
		}
		
		//删除流程信息以及项目中的消息记录，以及上传的文件信息
		if(null != apply){
			String applyId = apply.getApply_ID();
			Gbpm_productInstance productInstance = gbpm_productInstanceMapper.selectOneProductInstanceByWhereSql(" and entityID = '"+applyId+"' ");
			if(productInstance != null){
				String gbpmWhereSql = " and productInstanceID = '"+productInstance.getProductInstance_ID()+"' ";
				//删除流程中的项目数据
				pro_suggestMapper.deleteOneSuggestByWhereSql(gbpmWhereSql);
				pro_projectfilesMapper.deleteOneProFilesByEntityID(" and entityID = '"+applyId+"'");
				gbpm_finishTaskMapper.deleteFinishTaskByWheresql(gbpmWhereSql);
				gbpm_finishNodeMapper.deleteFinishNodeByWheresql(gbpmWhereSql);
				gbpm_runTaskMapper.deleteRunTaskByWheresql(gbpmWhereSql);
				gbpm_runNodeMapper.deleteRunNodeByWheresql(gbpmWhereSql);
				gbpm_productInstanceMapper.delProductInstanceInfo("and productInstance_ID = '"+productInstance.getProductInstance_ID()+"' ");
			}
		}
		
		
		if(!client.getIsMainVersion()){//不是主版本删除客户
			crm_clientMapper.deleteOneCompanyClientInfo(client);
		}
		
		//删除apply applydetail project
		int a1 = pro_applyDetailMapper.deleteApplyDetailByWhereSql(" and applyDetail_ID = '"+applyDetail.getApplyDetail_ID()+"'");
		int a2 =pro_applyMapper.delectApplyByWhereSql(" and apply_ID = '"+apply.getApply_ID()+"'");
		int a3 = pro_projectMapper.deleteOneProjectAfterBySql("and project_ID = '"+projectId+"' ");
		if(a1>0&&a2>0&&a3>0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteRiskInfo(String riskSchemeID) {
		
		Pro_riskScheme riskScheme = pro_riskSchemeMapper.selectOneRiskShemeInfo(" and riskScheme_ID = '"+riskSchemeID+"' ");
		if(null != riskScheme){
			String entityId = riskScheme.getRiskScheme_ID();
			Gbpm_productInstance productInstance = gbpm_productInstanceMapper.selectOneProductInstanceByWhereSql(" and entityID = '"+entityId+"' ");
			if(productInstance != null){
				String gbpmWhereSql = " and productInstanceID = '"+productInstance.getProductInstance_ID()+"' ";
				//删除流程中的项目数据
				pro_suggestMapper.deleteOneSuggestByWhereSql(gbpmWhereSql);
				pro_projectfilesMapper.deleteOneProFilesByEntityID(" and entityID = '"+entityId+"'");
				gbpm_finishTaskMapper.deleteFinishTaskByWheresql(gbpmWhereSql);
				gbpm_finishNodeMapper.deleteFinishNodeByWheresql(gbpmWhereSql);
				gbpm_runTaskMapper.deleteRunTaskByWheresql(gbpmWhereSql);
				gbpm_runNodeMapper.deleteRunNodeByWheresql(gbpmWhereSql);
				gbpm_productInstanceMapper.delProductInstanceInfo("and productInstance_ID = '"+productInstance.getProductInstance_ID()+"' ");
			}
		}
		int  a = pro_riskSchemeMapper.deleteByRiskSchemeId(riskSchemeID);
		return a>0?true :false;
	}

	@Override
	public void updateFundExcel(String substring, List<Map> list2, User sysUser, Date now) {
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < list2.size(); i++) {
			Set set = list2.get(i).entrySet();  
	        Iterator it = set.iterator();  
	        List<Pro_apply> applys = new ArrayList<>();
	        List<C_bankSort> bankSorts = new ArrayList<>();
	        String isNullKey = "";
	        
	        while ( it.hasNext() ) {  
	            Entry entry= (Entry) it.next();
	            if(null!=entry.getKey()){
		            String key = entry.getKey().toString();
		            if(key.equals("资金来源")&&null!=entry.getValue()){
		            	String wheresql=" and fundName ='"+entry.getValue().toString()+"'";
		            	isNullKey = entry.getValue().toString();
		            	applys = pro_applyMapper.selectApplyListByWhereSql(wheresql);
		            	if (applys.size()<1) {
		            		lists.add("不存在的用户："+isNullKey);
						}
		            }
		            if(key.equals("分类")&&null!=entry.getValue()){
		            	String wheresql = " and bankSortName ='"+entry.getValue().toString()+"'";
		            	bankSorts = c_bankSortMapper.selectAllbankSortList(wheresql);
		            }
	            }
	        }
	        if(applys.size()>0&&bankSorts.size()>0){
	        	C_bankSort bankSort = bankSorts.get(0);
	        	for (Pro_apply pro_apply : applys) {
	        		pro_apply.setFundChinese(bankSort.getBanksortname());
	        		pro_apply.setFundTypeID("41035961f6674ebcb34139c0e68bbe83");
	        		pro_apply.setFundType("非银行");
	        		pro_apply.setFundID(bankSort.getBanksortid());
	        		pro_applyMapper.updateOneApplyInfo(pro_apply);
				}
	        }
		}
		
	}

	@Override
	public void updateBankExcel(String substring, List<Map> list2, User sysUser, Date now) {
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < list2.size(); i++) {
			Set set = list2.get(i).entrySet();  
	        Iterator it = set.iterator();  
	        List<C_bankSort> bankSorts = new ArrayList<>();
	        String isNullKey = "";
	        
	        while ( it.hasNext() ) {  
	            Entry entry= (Entry) it.next();
	            if(null!=entry.getKey()){
		            String key = entry.getKey().toString();
		            if(key.equals("资金来源")&&null!=entry.getValue()){
		            	String wheresql=" and fundName ='"+entry.getValue().toString()+"'";
		            	isNullKey = entry.getValue().toString();
//		            	applys = pro_applyMapper.selectApplyListByWhereSql(wheresql);
//		            	if (applys.size()<1) {
//		            		lists.add("不存在的用户："+isNullKey);
//						}
		            }
		            if(key.equals("分类")&&null!=entry.getValue()){
		            	String wheresql = " and bankSortName ='"+entry.getValue().toString()+"'";
		            	bankSorts = c_bankSortMapper.selectAllbankSortList(wheresql);
		            }
	            }
	        }
	        if(bankSorts.size()>0){
	        	C_bankSort bankSort = bankSorts.get(0);
	        	C_bankSort newBankSort = new C_bankSort();
	        	newBankSort.setBanksortname(isNullKey);
	        	newBankSort.setPbanksortid(bankSort.getBanksortid());
	        	newBankSort.setUnitUid(newBankSort.getUnitUid());
				//C_bankSort bankSortInfo = c_bankSortMapper.selectOnebankSortInfo(newBankSort); //获取父节点的信息
				String bankFullCode=bankSort.getBankfullcode();//bankSortInfo==null?"": bankSortInfo.getBankfullcode(); // 获取父节点的完整编号
				newBankSort.setBankfullcode(bankFullCode); 
				newBankSort.setBanksortid(Tool.createUUID32());
				bankFullCode+=newBankSort.getBanksortid()+"/"; //完整
				newBankSort.setBankfullcode(bankFullCode);
				Integer oderId = c_bankSortMapper.selectbankSortOrderId(newBankSort);
				newBankSort.setUnitUid("cbeb758e3d824626a31aabb2a9587b0a");
				newBankSort.setIseable(0);
				newBankSort.setIsedit(1);
				newBankSort.setIsDefault(0);
				newBankSort.setOrderId(oderId);
				c_bankSortMapper.insertOnebankSortInfo(newBankSort);
	        }
		}
		
		
	}

	@Override
	public void updateFinishPro(String substring, List<Map> list2, User sysUser, Date now) {
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < list2.size(); i++) {
			Set set = list2.get(i).entrySet();  
	        Iterator it = set.iterator();  
//	        List<C_bankSort> bankSorts = new ArrayList<>();
	        while ( it.hasNext() ) {  
	            Entry entry= (Entry) it.next();
	            if(null!=entry.getKey()){
		            String key = entry.getKey().toString();
		            Pro_apply apply = new Pro_apply();
		            Pro_project project = new Pro_project();
		            if(key.equals("业务id")&&null!=entry.getValue()){
		            	String wheresql=" and apply_ID ='"+entry.getValue().toString()+"'";
		            	apply = pro_applyMapper.selectOneApplyWhereSql(wheresql);
		            }
		            if(key.equals("项目id")&&null!=entry.getValue()){
		            	String wheresql = " and project_ID ='"+entry.getValue().toString()+"'";
		            	project = pro_projectMapper.selectOneProjectWhereSql(wheresql);
		            }
		            if(null!=project&&null!=apply){
		            	String proWheresql = " and project_ID = '"+project.getProject_ID() +"' "+"ORDER BY factDate DESC LIMIT 1 ";
		    			Pro_factPay factPay = pro_factPayMapper.selectOneFactPayByWhereSql(proWheresql);
		    			if(factPay!=null){
		    				project.setFinishDate(factPay.getFactDate());
		    				pro_projectMapper.updateOneProjectInfo(project);
		    				apply.setEndDate(factPay.getFactDate());
		    				apply.setIsEnd(1);
		    				pro_applyMapper.updateOneApplyInfo(apply);
			            }
		            }
	            }
	        }
		}
		
	}

	@Override
	public void updateFinishPro() {
		String proWheresql = "AND guarantySum=0 AND project_ID NOT IN ('b9f90ce992ad11e7b87d000000143522','8fded6b0ea7e4f99b9928f0b599f388b','6475295a57094ef4b190a2390c039e08','ba8b54cb92ad11e7b87d000000143522','ba8b556992ad11e7b87d000000143522','ba8b59c092ad11e7b87d000000143522','ba91c79a92ad11e7b87d000000143522','ba92e50392ad11e7b87d000000143522','617c43db3d654488ae74a4c5393d2c60','8baeae764b4240fe983ace94176b0c05','ba94b21c92ad11e7b87d000000143522','ba950aad92ad11e7b87d000000143522','ba950a0992ad11e7b87d000000143522','ba94e2ad92ad11e7b87d000000143522','ba94e43092ad11e7b87d000000143522','7edaf9624bf4476683327d1c464e01f4','04d265e245cb4eb8bfdac296000550ba','0808e3ebadac45539413be60a4a31e94','5d2a52aaa2f846108e282c97afb240ca','5ec1ede916184007b3e47e9ed10b03c0')";
		List<Pro_project> projects = pro_projectMapper.selectProjectListByWheresql(proWheresql);
		for (Pro_project project : projects) {
			String wheresql = " and project_ID = '"+project.getProject_ID() +"' "+"ORDER BY payDate DESC LIMIT 1 ";
			Pro_factPay factPay = pro_factPayMapper.selectOneFactPayByWhereSql(wheresql);
			Pro_apply apply = pro_applyMapper.selectOneApplyWhereSql(" and apply_ID = '"+project.getApply_ID() +"' ");
			if(factPay!=null){
				project.setFinishDate(factPay.getPayDate());
				pro_projectMapper.updateOneProjectInfo(project);
				apply.setEndDate(factPay.getFactDate());
				apply.setIsEnd(1);
				pro_applyMapper.updateOneApplyInfo(apply);
            }
		}
	}

	@Override
	public void updateClientFullTrade(String substring, List<Map> list2, User sysUser, Date now) {
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < list2.size(); i++) {
			Set set = list2.get(i).entrySet();  
	        Iterator it = set.iterator();  
//	        List<C_bankSort> bankSorts = new ArrayList<>();
	        List<Client> clients = new ArrayList<>();
            C_multiLevelSort multiLevelSort = null;
	        while ( it.hasNext() ) {  
	            Entry entry= (Entry) it.next();
	            if(null!=entry.getKey()){
		            String key = entry.getKey().toString();
		            if(key.equals("项目名称")&&null!=entry.getValue()){
		            	String wheresql=" and clientName ='"+entry.getValue().toString()+"'";
		            	clients = crm_clientMapper.selectClientListByWheresql(wheresql);
		            }
	            	if(key.equals("行业")&&null!=entry.getValue()){
	            		String wheresql=" and multiLevelSortName ='"+entry.getValue().toString()+"'";
		            	multiLevelSort = c_multiLevelSortMapper.selectOnemultiLevelSortInfoByWheresql(wheresql);
		            }
	            }
	        }
	        if(clients.size()>0&&null!=multiLevelSort){
	        	for (Client client : clients) {
	        		System.out.println("id:"+multiLevelSort.getMultilevelsortid()+"======name:"+multiLevelSort.getMultilevelsortname()+"==========code:"+multiLevelSort.getMultilevelsortfullcode());
	        		client.setFullTradeName(multiLevelSort.getMultilevelsortname());
	        		if(null!=multiLevelSort.getMultilevelsortfullcode()){
	        			client.setFullAreaCode(multiLevelSort.getMultilevelsortfullcode().replace("c9ee6e6d3b5a41faafb263b1baff7b2e/", ""));
	        		}
	        		crm_clientMapper.updateOneCompanyClientInfo(client);
				}
            }
		}
		
	}

	/**
	 * 展期表日期与项目表展期日期同步
	 */
	@Override
	public int updateProJectDelayDate() {
		String wheresql = "";
		int i = 0;
    	List<Pro_project> project = pro_projectMapper.selectProjectListByWheresql(wheresql);
		for (Pro_project pro_project : project) {
//			String proWheresql = " and project_ID = '"+projectId +"' ";
			Pro_delay pro_delay = pro_delayMapper.selectOneDelayByWhereSql(" and project_ID = '"+pro_project.getProject_ID() +"' "+"ORDER BY delayEndDate DESC LIMIT 1 ");
			//项目展期日期与展期表展期日期不一致
			if(null!=pro_delay&&(pro_project.getDelayEndDate()!=pro_delay.getDelayEndDate())){
				pro_project.setDelayEndDate(pro_delay.getDelayEndDate());
			}
			i = pro_projectMapper.updateOneProjectInfo(pro_project);
		}
		return i;
	}


}
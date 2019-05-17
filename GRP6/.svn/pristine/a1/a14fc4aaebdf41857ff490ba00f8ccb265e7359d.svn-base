package com.zjm.crm.client.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.badclient.service.BadClientService;
import com.zjm.crm.bankAccount.service.BankAccountService;
import com.zjm.crm.billRec.service.BillRecService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.clientfiles.service.ClientFilesService;
import com.zjm.crm.costInfo.service.CostInfoService;
import com.zjm.crm.creditInfo.service.CreditInfoService;
import com.zjm.crm.db.map.Crm_clientMapper;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_badClient;
import com.zjm.crm.db.model.Crm_bankAccount;
import com.zjm.crm.db.model.Crm_billRec;
import com.zjm.crm.db.model.Crm_clientfiles;
import com.zjm.crm.db.model.Crm_costInfo;
import com.zjm.crm.db.model.Crm_creditInfo;
import com.zjm.crm.db.model.Crm_financeDesc;
import com.zjm.crm.db.model.Crm_guarantyRec;
import com.zjm.crm.db.model.Crm_inventory;
import com.zjm.crm.db.model.Crm_landHouse;
import com.zjm.crm.db.model.Crm_loanRec;
import com.zjm.crm.db.model.Crm_machine;
import com.zjm.crm.db.model.Crm_managerInfo;
import com.zjm.crm.db.model.Crm_order;
import com.zjm.crm.db.model.Crm_otherReceivable;
import com.zjm.crm.db.model.Crm_payTaxInfo;
import com.zjm.crm.db.model.Crm_receivable;
import com.zjm.crm.db.model.Crm_relationClient;
import com.zjm.crm.db.model.Crm_reportSy;
import com.zjm.crm.db.model.Crm_reportXjl;
import com.zjm.crm.db.model.Crm_reportZcfz;
import com.zjm.crm.db.model.Crm_riskLevelRec;
import com.zjm.crm.db.model.Crm_selfHouse;
import com.zjm.crm.db.model.Crm_spouseInfo;
import com.zjm.crm.db.model.Crm_stock;
import com.zjm.crm.db.model.Crm_upDownClient;
import com.zjm.crm.financeDesc.service.FinanceDescService;
import com.zjm.crm.guarantyRec.service.GuarantyRecService;
import com.zjm.crm.inventory.service.InventoryService;
import com.zjm.crm.landHouse.service.LandHouseService;
import com.zjm.crm.loanRec.service.LoanRecService;
import com.zjm.crm.machine.service.MachineService;
import com.zjm.crm.managerInfo.service.ManagerInfoService;
import com.zjm.crm.order.service.OrderService;
import com.zjm.crm.otherReceivable.service.OtherReceivableService;
import com.zjm.crm.payTaxInfo.service.PayTaxInfoService;
import com.zjm.crm.receivable.service.ReceivableService;
import com.zjm.crm.relationClient.service.RelationClientService;
import com.zjm.crm.reportSy.service.ReportSyService;
import com.zjm.crm.reportXjl.service.ReportXjlService;
import com.zjm.crm.reportZcfz.service.ReportZcfzService;
import com.zjm.crm.riskLevel.service.RiskLevelService;
import com.zjm.crm.selfHouse.service.SelfHouseService;
import com.zjm.crm.spouseInfo.service.SpouseInfoService;
import com.zjm.crm.stock.service.StockService;
import com.zjm.crm.upDownClient.service.UpDownClientService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.sys.clientCode.service.ClientCodeService;
import com.zjm.sys.db.model.Sys_clientCode;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.db.model.Sys_users;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;


/**
 * 客户管理
 * @author zhangkeyao add 20170426
 *  
 */
@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
	@Resource
	private Crm_clientMapper crm_clientMapper;
	@Resource
	private BadClientService badClientService;
	@Resource
	private BankAccountService bankAccountService;// 银行开户信息表
	@Resource
	private ManagerInfoService  managerInfoService; // 股东背景及主要管理人员情况
	@Resource
	private StockService  stockService ;//股权结构表
	@Resource
	private ReportZcfzService reportZcfzService;	//资产负债表
	@Resource	
	private ReportSyService reportSyService;		//损益表
	@Resource
	private ReportXjlService reportXjlService;		//现金流表
	@Resource
	private ReceivableService receivableService;	//应收账款表
	@Resource
	private OtherReceivableService otherReceivableService;	//其他应收账款表
	@Resource
	private InventoryService inventoryService;	//存货表
	@Resource
	private LandHouseService landHouseService;	//土地房产表
	@Resource
	private MachineService machineService;	//机器设备及车辆表
	@Resource
	private LoanRecService loanRecService;	//贷款情况表
	@Resource
	private BillRecService billRecService;	//票据信息表
	@Resource
	private GuarantyRecService guarantyRecService;	//对外担保情况表
	@Resource
	private FinanceDescService financeDescService;	//对外担保情况表
	@Resource
	private UpDownClientService upDownClientService;	//上下游客户表
	@Resource
	private OrderService orderService;	//客户订单情况表
	@Resource
	private CostInfoService costInfoService;	//水电气费缴纳情况表
	@Resource
	private PayTaxInfoService payTaxInfoService;	//企业纳税情况表
	@Resource
	private RelationClientService relationClientService;	//关联客户表 
	@Resource
	private CreditInfoService creditInfoService;	//信用信息及银企往来表
	@Resource
	private ClientFilesService clientFilesService;	//客户附件表
	@Resource
	private SelfHouseService selfHouseService;	//自有住宅表
	@Resource
	private SpouseInfoService spouseInfoService;	//配偶信息表
	
	@Resource
	private UsersService usersService;
	@Resource
	private DepartsService departsService;
	
	@Resource
	private ClientCodeService clientCodeService;
	
	@Resource
	private LogService logService;
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private  RiskLevelService  riskLevelService ;
	
	
	/**
	 * 查询个人客户分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Client> selectPersonClientPageTables(PageTable<Client> pageTable) {
		List<Client> cList = crm_clientMapper.selectPersonClientPageTables(pageTable);
		Long total=crm_clientMapper.selectClientPageTables_Count(pageTable);
		pageTable.setRows(cList);
		pageTable.setTotal(total);
		return pageTable;
	}
	
	/* ************************企业客户信息********************************* */
	/**
	 * 查询企业客户分页列表
	 * @param pageTable
	 * @author zhangkeyao
	 * @return
	 */
	@Override
	public PageTable<Client> selectCompanysClientPageTables(PageTable<Client> pageTable) {
		List<Client> list = crm_clientMapper.selectCompanysClientPageTables(pageTable);//企业客户分页列表
		Long total=crm_clientMapper.selectCompanyClientPageTables_Count(pageTable);// 总记录数
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	
	/**
	 * @description  添加/插入一个企业客户信息
	 * @author wuhn
	 * @date 2017年5月4日 10:31:48
	 */
	@Override
	public Boolean insertOneCompanyClientInfo(User user,Client client) {
		client.setIsMainVersion(true);
 		client.setIsBadClient(false);
 		client.setClient_ID(Tool.createUUID32());;//添加客户ID
 		client.setClientGUID(Tool.createUUID32());//添加客户唯一标识
		client.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		client.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());//设置担保机构;
		if(client.getCreateUserID()!=null){
			Sys_users users = new Sys_users();
			users.setUser_uid(client.getCreateUserID());
			Sys_users sys_users = usersService.selectOneUsersInfo(users);
			Sys_departs sys_departs = new Sys_departs();
			sys_departs.setDepart_uid(sys_users.getDepart_uid());
			Sys_departs depart = departsService.selectOneDepartsInfo(sys_departs);
			if(depart != null){				
				client.setFullDepartName(depart.getDepart_name());
				
			}
			client.setFullDepartCode(sys_users.getDepart_uid());
		}
		//设置编号
		Sys_clientCode clientCode = new Sys_clientCode();
		clientCode=clientCodeService.returnOneClientCode(user,client.getClientTypeID());
		//先判断编号规则，如果是各自生成规则，则根据客户类型设置客户编号
		if(clientCode.getRuleType().equals("01")){
			//格式化客户编号之后再设置
			String clientBH = clientCode.getCommonWord() + clientCodeFormat(clientCode.getCommonCode());
			client.setClientBH(clientBH);
		}else if (clientCode.getRuleType().equals("02")) {
			if (client.getClientTypeID().equals("01")) {
				//格式化客户编号之后再设置
				String clientBH = clientCode.getCompanyWord() + clientCodeFormat(clientCode.getCompanyCode());
				client.setClientBH(clientBH);
			}else if (client.getClientTypeID().equals("02")) {
				//格式化客户编号之后再设置
				String clientBH = clientCode.getOperateWord() + clientCodeFormat(clientCode.getOperateCode());
				client.setClientBH(clientBH);
			}else if (client.getClientTypeID().equals("03")) {
				//格式化客户编号之后再设置
				String clientBH = clientCode.getConsumeWord() + clientCodeFormat(clientCode.getConsumeCode());
				client.setClientBH(clientBH);
			}
		}
		if(crm_clientMapper.insertOneCompanyClientInfo(client)>0){
			 logService.insertOneOperatorLogInfo(user,"企业客户", "新增", "新增企业客户"+client.getClientName());
			return true;
		}else{
			return false;
		}
		
	}

	
	
	
	
	
	
	/**
	 * 更新 修改一个企业客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 10:32:51
	 */
	@Override
	public Boolean updateOneCompanyClientInfo(User user,Client client) {
		try {
			if(crm_clientMapper.updateOneCompanyClientInfo(client)>0){
				logService.insertOneOperatorLogInfo(user,"企业客户", "修改", "修改企业客户"+client.getClientName());
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * 删除 移除一个企业客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 10:33:54
	 */
	@Override
	public Boolean deleteOneCompanyClientInfo(User user,Client client) {
		// 删除客户表，关联表
		deleteClientRelevanceTable(client);
		if(crm_clientMapper.deleteOneCompanyClientInfo(client)>0){
			logService.insertOneOperatorLogInfo(user,"企业客户", "删除", "删除企业客户");
			return true;
		}else{
			
			return false;
		}
	}
	
	/**
	 * @description	删除客户表 --- 关联表
	 * @author wuhn
	 * @date 2017年5月16日 下午6:58:13
	 */
	private void deleteClientRelevanceTable(Client client) {
		//TODO:还需删除客户关联表的信息，待添加--------2017年5月16日 18:59:08 wuhn 
		String client_ID = client.getClient_ID();
		
		//	水电汽费缴纳情况crm_costInfo
		
		//订单情况crm_order
		
		//上下游客户表crm_upDownClient
		
		// 银行开户信息表crm_bankAccount
 		bankAccountService.deleteOneCompanyCrm_bankAccountByClient_ID(client_ID,SystemSession.getUserSession()); //银行开户表
		
		// 股权结构表crm_stock
		stockService.deleteStockInfoByClient_ID(client_ID,SystemSession.getUserSession());
		
		// 股东背景及主要管理人员情况  crm_managerInfo
		String sql="and client_ID='"+client_ID+"'";
		managerInfoService.deleteOneManagerInfo(sql,SystemSession.getUserSession());
		
		//黑名单登记表crm_badClient
		
		//客户附件表crm_clientFiles
		
		//客户共享表crm_clientShare
		
		//客户曾用名表 crm_oldClientName
		
		// 客户与关联主体关联表crm_client_relationMain  
		// 关联主体表crm_relationMain
		
		// 关联企业表crm_relationClient
		
		// 自有住房情况表crm_selfHouse
		
		// 配偶信息表crm_spouseInfo
		
		// 企业纳税情况 crm_payTaxInfo
		
		// 信用信息及银企往来情况 crm_creditInfo
		
		
	}


	/**
	 * @description 根据客户名称查询客户信息
	 * @author wuhn
	 * @date 2017年5月4日 11:25:27
	 */
	@Override
	public Client selectOneClientInfoByClientName(String clientName) {
		return crm_clientMapper.selectOneClientInfoByClientName(clientName);
	}
	
	/**
	 * 查询企业客户 总记录数
	 */
	@Override
	public Long selectCompanyClientPageTables_Count(PageTable pageTable) {
		return crm_clientMapper.selectCompanyClientPageTables_Count(pageTable);
	}

	/**
	 * 查询一个企业客户的信息,客户id ，客户类型
	 */
	@Override
	public Client selectOneClientInfo(Client client) {
		
		return crm_clientMapper.selectOneClientInfo(client);
	}
	
	/**
	 * 根据条件查询单个客户信息  
	 * xuyz 
	 * 商机管理受理申请时用 
	 */
	@Override
	public Client selectOneClientByWheresql(String wheresql) {
		return crm_clientMapper.selectOneClientByWheresql(wheresql);
	}


	/**
	 * 判断客户名是否存在
	 */
	public Boolean selectClientNameIsExist(String wheresql) {
		if(crm_clientMapper.selectClientNameIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}
	
	//编号位数生成
	private String clientCodeFormat(Integer number) {
		String clientcodes="" + number;
		for(int i=0;clientcodes.length()<4;i++){
			clientcodes="0"+clientcodes;
		}
		return clientcodes;
	}
	
	/**
	 * @description	添加一条客户信息，并返回当前对象
	 * @author wuhn
	 * @date 2017年7月13日 上午11:14:09
	 */
	@Override
	public Client insertClientAndReturnClientID(User user, Client client) {
		
		insertOneCompanyClientInfo(user, client);
		return client;
	}


	/**
	 * 通过传入的apply_ID,创建客户副版本并返回客户id
	 * @param apply_ID
	 * @return
	 * 
	 * 没有用到此方法----xuyz
	 */
	public String getNewClientIDByApplyID(String apply_ID) {//根据业务id获取业务表信息
		Client client = new Client();
		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(" apply_ID = \'"+apply_ID+"\'");
		client.setClient_ID(apply.getClient_ID());
		Client mainClient = crm_clientMapper.selectOneClientInfo(client);//获取主版本客户信息
		mainClient.setIsMainVersion(false);//创建副版本
		String newClientID = Tool.createUUID32();
		mainClient.setClient_ID(newClientID);//设置newClientID
		Integer resultInt = crm_clientMapper.insertOneCompanyClientInfo(mainClient);
		if(1 == resultInt){
			return newClientID;
		}else {
			return null;
		}
		
	}
	
	/**
	 * 将与主版本客户有关的信息copy到副版本客户中
	 * @param mainClientID
	 * @param newClientID
	 */
	public void copyMainClientToNewClient(User user, String mainClientID,String newClientID){
	//客户信息主表  Crm_client.java
		Client client = selectOneClientByWheresql(" and client_ID='"+mainClientID+"'");
		client.setClient_ID(newClientID);
		client.setIsMainVersion(false);
		crm_clientMapper.insertOneCompanyClientInfo(client);
	//客户文件表 Crm_clientfiles.java
		List<Crm_clientfiles> fileList = clientFilesService.selectPictureFileList(" and client_ID='"+mainClientID+"'");
		if(fileList != null && fileList.size() > 0){
			for (Crm_clientfiles crm_clientfiles : fileList) {
				crm_clientfiles.setClient_ID(newClientID);
				crm_clientfiles.setClientFiles_ID(Tool.createUUID32());
				clientFilesService.insertOneClientFiles(crm_clientfiles);
			}
		}
		
		if("01".equals(client.getClientTypeID())){
		//企业客户详情
			//企业基本情况
				//银行开户信息表   Crm_bankAccount.java
				Crm_bankAccount  crm_bankAccount = new  Crm_bankAccount();
				crm_bankAccount.setClient_ID(mainClientID);
				List<Crm_bankAccount> bankAccountList = bankAccountService.selectCompanyCrm_bankAccountByClient_ID(crm_bankAccount);
				if(bankAccountList != null && bankAccountList.size()>0){
					for(Crm_bankAccount  bankAccount : bankAccountList){
						bankAccount.setClient_ID(newClientID);
						bankAccountService.insertOneCompanyCrm_bankAccountInfo(bankAccount, user);
					}
				}
			//股东背景及主要管理人员
				//股权信息表  Crm_stock.java
				List<Crm_stock> stockList = stockService.selectStockListByClient_ID(mainClientID);
				if(stockList !=null && stockList.size()>0){
					for (Crm_stock stock : stockList) {
						stock.setClient_ID(newClientID);
						stock.setStockId(Tool.createUUID32());
						stockService.insertOneStockInfo(stock, user);
					}
				}
				//股东背景及主要管理人员信息表  Crm_managerInfo.java
				Crm_managerInfo managerInfo = managerInfoService.selectOneManagerInfo(" and client_ID='"+mainClientID+"'");
				if(managerInfo != null){
					managerInfo.setClient_ID(newClientID);
					managerInfo.setManagerinfoId(Tool.createUUID32());
					managerInfoService.insertOneManagerInfo(managerInfo, user);
				}
			//企业财务状况
				//资产负债表  Crm_reportZcfz.java
				List<Crm_reportZcfz> reportZcfzByList = reportZcfzService.selectReportZcfzByList(" and client_ID='"+mainClientID+"'");
				if(reportZcfzByList!=null && reportZcfzByList.size()>0){
					for (Crm_reportZcfz crm_reportZcfz : reportZcfzByList) {
						crm_reportZcfz.setClient_ID(newClientID);
						reportZcfzService.insertOneReportZcfzInfo(user, crm_reportZcfz);
					}
				}
				//损益表 Crm_reportSy.java
				List<Crm_reportSy> reportSyList = reportSyService.selectReportSyList(" and client_ID='"+mainClientID+"'");
				if(reportSyList != null && reportSyList.size()>0){
					for (Crm_reportSy crm_reportSy : reportSyList) {
						crm_reportSy.setClient_ID(newClientID);
						reportSyService.insertOneReportSyInfo(user, crm_reportSy);
					}
				}
				//现金流表  Crm_reportXjl.java
				List<Crm_reportXjl> reportXjlList = reportXjlService.selectCrm_ReportXjlList(" and client_ID='"+mainClientID+"'");
				if(reportXjlList!=null && reportXjlList.size()>0){
					for (Crm_reportXjl crm_reportXjl : reportXjlList) {
						crm_reportXjl.setClient_ID(newClientID);
						reportXjlService.insertOneReportXjlInfo(user, crm_reportXjl);
					}
				}
				//应收账款表  Crm_receivable.java
				Crm_receivable receivable = new Crm_receivable();
				receivable.setClient_ID(mainClientID);
				List<Crm_receivable> receivableList = receivableService.selectReceivableList(receivable);
				if(receivableList!=null && receivableList.size()>0){
					for (Crm_receivable crm_receivable : receivableList) {
						crm_receivable.setClient_ID(newClientID);
						receivableService.insertOneReceivableInfo(user, crm_receivable);
					}
				}
				//其他应收账款表  Crm_otherReceivable.java
				Crm_otherReceivable otherReceivable = new Crm_otherReceivable();
				otherReceivable.setClient_ID(mainClientID);
				List<Crm_otherReceivable> otherReceivableList = otherReceivableService.selectOtherReceivableList(otherReceivable);
				if(otherReceivableList!=null && otherReceivableList.size()>0){
					for (Crm_otherReceivable crm_otherReceivable : otherReceivableList) {
						crm_otherReceivable.setClient_ID(newClientID);
						otherReceivableService.insertOneOtherReceivableInfo(user, crm_otherReceivable);
					}
				}
				//存货表  Crm_inventory.java
				Crm_inventory inventory = new Crm_inventory();
				inventory.setClient_ID(mainClientID);
				List<Crm_inventory> inventoryList = inventoryService.selectInventoryList(inventory);
				if(inventoryList!=null && inventoryList.size()>0){
					for (Crm_inventory crm_inventory : inventoryList) {
						crm_inventory.setClient_ID(newClientID);
						inventoryService.insertOneInventoryInfo(user, crm_inventory);
					}
				}
				//土地房产表  Crm_landHouse.java
				Crm_landHouse landHouse = new Crm_landHouse();
				landHouse.setClient_ID(mainClientID);
				List<Crm_landHouse> landHouseList = landHouseService.selectLandHouseList(landHouse);
				if(landHouseList!=null && landHouseList.size()>0){
					for (Crm_landHouse crm_landHouse : landHouseList) {
						crm_landHouse.setClient_ID(newClientID);
						landHouseService.insertOneLandHouseInfo(user, crm_landHouse);
					}
				}
				//机器设备及车辆表 Crm_machine.java
				Crm_machine machine = new Crm_machine();
				machine.setClient_ID(mainClientID);
				List<Crm_machine> machineList = machineService.selectMachineList(machine);
				if(machineList!=null && machineList.size()>0){
					for (Crm_machine crm_machine : machineList) {
						crm_machine.setClient_ID(newClientID);
						machineService.insertOneMachineInfo(user, crm_machine);
					}
				}
				//贷款情况表  Crm_loanRec.java
				List<Crm_loanRec> loanRecList = loanRecService.selectLoanRecList(" and client_ID='"+mainClientID+"'");
				if(loanRecList!=null && loanRecList.size()>0){
					for (Crm_loanRec crm_loanRec : loanRecList) {
						crm_loanRec.setClient_ID(newClientID);
						loanRecService.insertOneLoanRec(user, crm_loanRec);
					}
				}
				//开票银行及票据信息  Crm_billRec.java
				List<Crm_billRec> billRecList = billRecService.selectBillRecList(" and client_ID='"+mainClientID+"'");
				if(billRecList!=null && billRecList.size()>0){
					for (Crm_billRec crm_billRec : billRecList) {
						crm_billRec.setClient_ID(newClientID);
						billRecService.insertOneBillRec(user, crm_billRec);
					}
				}
				//对外担保情况表  Crm_guarantyRec.java
				List<Crm_guarantyRec> guarantyRecList = guarantyRecService.selectGuarantyRecList(" and client_ID='"+mainClientID+"'");
				if(guarantyRecList!=null && guarantyRecList.size()>0){
					for (Crm_guarantyRec crm_guarantyRec : guarantyRecList) {
						crm_guarantyRec.setClient_ID(newClientID);
						guarantyRecService.insertOneGuarantyRec(user, crm_guarantyRec);
					}
				}
				//财务状况说明表  Crm_financeDesc.java
				Crm_financeDesc financeDesc = new Crm_financeDesc();
				financeDesc.setClient_ID(mainClientID);
				financeDesc.setUnit_uid(user.getUnit_uid());
				Crm_financeDesc financeDesc2 = financeDescService.selectOneFinanceDesc(financeDesc);
				if(financeDesc2!=null){
					financeDesc2.setClient_ID(newClientID);
					financeDescService.insertOneFinanceDesc(user, financeDesc2);
				}
			//企业经营情况
				//上下游客户表  Crm_upDownClient.java
				List<Crm_upDownClient> upDownClientList = upDownClientService.selectUpDownClientList(" and client_ID='"+mainClientID+"'");
				if(upDownClientList!=null && upDownClientList.size()>0){
					for (Crm_upDownClient crm_upDownClient : upDownClientList) {
						crm_upDownClient.setClient_ID(newClientID);
						upDownClientService.insertOneUpDownClient(user, crm_upDownClient);
					}
				}
				//企业订单情况表  Crm_order.java
				List<Crm_order> orderList = orderService.selectOrderList(" and client_ID='"+mainClientID+"'");
				if(orderList!=null && orderList.size()>0){
					for (Crm_order crm_order : orderList) {
						crm_order.setClient_ID(newClientID);
						orderService.insertOneOrder(user, crm_order);
					}
				}
				//水电气费缴纳情况表  Crm_costInfo.java
				List<Crm_costInfo> costInfoList = costInfoService.selectCostInfoList(" and client_ID='"+mainClientID+"'");
				if(costInfoList!=null && costInfoList.size()>0){
					for (Crm_costInfo crm_costInfo : costInfoList) {
						crm_costInfo.setClient_ID(newClientID);
						costInfoService.insertOneCostInfo(user, crm_costInfo);
					}
				}
				//企业纳税情况表  Crm_payTaxInfo.java
				List<Crm_payTaxInfo> payTaxInfoList = payTaxInfoService.selectPayTaxInfoList(" and client_ID='"+mainClientID+"'");
				if(payTaxInfoList!=null && payTaxInfoList.size()>0){
					for (Crm_payTaxInfo crm_payTaxInfo : payTaxInfoList) {
						crm_payTaxInfo.setClient_ID(newClientID);
						payTaxInfoService.insertOnePayTaxInfo(user, crm_payTaxInfo);
					}
				}
			//关联企业
				//关联企业表  Crm_relationClient.java
				List<Crm_relationClient> relationClientList = relationClientService.selectRelationClientList(" and client_ID='"+mainClientID+"'");
				if(relationClientList!=null && relationClientList.size()>0){
					for (Crm_relationClient crm_relationClient : relationClientList) {
						crm_relationClient.setClient_ID(newClientID);
						relationClientService.insertOneRelationClientInfo(user, crm_relationClient);
					}
				}
			//信用信息及银企往来情况
				//信用信息及银企往来情况crm_creditInfo
				Crm_creditInfo creditInfo = new Crm_creditInfo();
				creditInfo.setClient_ID(mainClientID);
				creditInfo.setUnit_uid(user.getUnit_uid());
				Crm_creditInfo creditInfo2 = creditInfoService.selectOneCreditInfo(creditInfo);
				if(creditInfo2!=null){
					creditInfo2.setClient_ID(newClientID);
					creditInfoService.insertOneCreditInfo(user, creditInfo2);
				}
		}
		else{
		//个人客户详情	
			//自有住宅表  Crm_selfHouse.java
			Crm_selfHouse selfHouse = new Crm_selfHouse();
			selfHouse.setClient_ID(mainClientID);
			Crm_selfHouse selfHouse2 = selfHouseService.selectOneSelfHouseInfo(selfHouse);
			if(selfHouse2!=null){
				selfHouse2.setClient_ID(newClientID);
				selfHouseService.insertOneSelfHouseInfo(user, selfHouse2);
			}
			//配偶信息表  Crm_spouseInfo.java
			Crm_spouseInfo spouseInfo = new Crm_spouseInfo();
			spouseInfo.setClient_ID(mainClientID);
			Crm_spouseInfo spouseInfo2 = spouseInfoService.selectOneSpouseInfo(spouseInfo);
			if(spouseInfo2!=null){
				spouseInfo2.setClient_ID(newClientID);
				spouseInfoService.insertOneSpouseInfo(user, spouseInfo2);
			}
		}
	}
	
    /**
     * 
     * 更改风险评级
     */
	@Override
	public Boolean updateRiskLevelByClient_ID(User user, Crm_riskLevelRec riskLevelRec) {
		Boolean b = false;
		Client client = new Client();
		client.setClient_ID(riskLevelRec.getClient_ID());
		client.setRiskLevelID(riskLevelRec.getRiskLevelID());
		client.setRiskLevelName(riskLevelRec.getRiskLevelName());
		client.setRiskLevelDesc(riskLevelRec.getRiskLevelIDDesc());
		client.setUpdateUserName(user.getUser_name());
		client.setUpdateDateTime(new Date());
		client.setDivisionID(riskLevelRec.getDivisionID());
		client.setDivisionName(riskLevelRec.getDivisionName());
		Integer ruturnInt = 0;
		try {
			ruturnInt=crm_clientMapper.updateRiskLevelByClient_ID(client);
		} catch (Exception e) {
			e.printStackTrace();
		 }
		
		if(ruturnInt>0){
			 b= true;
			}
			return b;
	    }

	/**
	 * 更新企业所属的关联主体名称
	 */
	@Override
	public void updateRelationMainName(Client client) {
		try {
			crm_clientMapper.updateRelationMainName(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 将与主版本客户有关的信息更新到副版本客户中
	 * @param mainClientID
	 */
	@Override
	public Integer updateMainClientToNewClient(User user, String mainClientID) {
		
		//客户信息主表  Crm_client
		//查出主版本的客户	
			Client client1 = selectOneClientByWheresql(" and client_ID='"+mainClientID+"'");		
			Client client=selectOneClientByWheresql("and clientGUID='"+client1.getClientGUID()+"' and isMainVersion=TRUE");
			client.setClient_ID(mainClientID );
			
			crm_clientMapper.updateOneCompanyClientInfo(client);
		//客户文件表 Crm_clientfiles.java
//			List<Crm_clientfiles> fileList = clientFilesService.selectPictureFileList(" and client_ID='"+mainClientID+"'");
//			if(fileList != null && fileList.size() > 0){
//				for (Crm_clientfiles crm_clientfiles : fileList) {					
////					clientFilesService.up(crm_clientfiles);
//				}
//			}		
			//个人客户详情	
				//自有住宅表  Crm_selfHouse.java
				Crm_selfHouse selfHouse = new Crm_selfHouse();
				selfHouse.setClient_ID(client.getClient_ID());
				Crm_selfHouse selfHouse2 = selfHouseService.selectOneSelfHouseInfo(selfHouse);
				if(selfHouse2!=null){
					
					selfHouseService.updateOneSelfHouseInfo(user, selfHouse2);
				}
				//配偶信息表  Crm_spouseInfo.java
				Crm_spouseInfo spouseInfo = new Crm_spouseInfo();
				spouseInfo.setClient_ID(client.getClient_ID());
				Crm_spouseInfo spouseInfo2 = spouseInfoService.selectOneSpouseInfo(spouseInfo);
				if(selfHouse2!=null){
					spouseInfoService.updateOneSpouseInfo(user, spouseInfo2);
				}
				if(crm_clientMapper.updateOneCompanyClientInfo(client)==1 &&selfHouseService.updateOneSelfHouseInfo(user, selfHouse2)==true && spouseInfoService.updateOneSpouseInfo(user, spouseInfo2)==true){
					return 1;
				}
				else{
					return 0;
				}
				
			}

	
	
	@Override
	public List<Client> selectClientListByWheresql(String wheresql) {
		return crm_clientMapper.selectClientListByWheresql(wheresql);
	}
	
	
	/**
	 * @description	根据客户id，获取客户主版本信息
	 * @author wuhn
	 * @date 2017年10月13日 下午1:48:08
	 */
	@Override
	public Client selectMainClientByClient_ID(String client_ID) {
		try {
			return crm_clientMapper.selectMainClientByClient_ID(client_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
	
	/**
	 * @description  项目客户资料同步到客户库 （同步到项目库） ---> 客户资料主版本同步到副版本
	 * @author wuhn
	 * @date 2017年9月28日 15:55:45
	 */
	public Boolean MainSyncSlaveClient(User user, String client_ID) {
		String[] split = client_ID.split(",");
		Client mainClient = this.selectMainClientByClient_ID(split[0]); //客户主版本信息
		String clientIDS="'"+org.apache.commons.lang3.StringUtils.join(split, "','")+"'";	
		String wheresql=" and client_ID in ("+clientIDS+") and isMainVersion=false";
		List<Client> slaveClientList = this.selectClientListByWheresql(wheresql);
		boolean flag= execMainSlaveListSynchroidzed(mainClient,slaveClientList,user);
		
		return flag;
	}
	
	/**
	 * @description  主版本客户信息 关联表 同步到 副版本客户信息关联表
	 * @author wuhn
	 * @date 2017年9月29日 下午2:29:29
	 */
	private Boolean execMainSlaveListSynchroidzed(Client mainClient, List<Client> slaveClientList,User user) {
		
		int updateCount = 0;
		
		for (Client c : slaveClientList) {
			try {
				String slaveClient_ID = c.getClient_ID();
				BeanUtils.copyProperties(mainClient, c);
				c.setClient_ID(slaveClient_ID);
				c.setIsMainVersion(false);
				this.updateAllClientInfo(c, user); //客户主版本同步到 副版本
				
				//1、财务报表-资产负债表crm_reportZcfz
				execReportZcfzSynchronized(mainClient, slaveClientList, user);
				
				//2、财务报表-现金流量表crm_reportXjl
				execReportXjlSynchronized(mainClient, slaveClientList, user);
				
				//3、 财务报表-损益表crm_reportSy
				execReportSySynchronized(mainClient, slaveClientList, user);
				
				//4、订单情况crm_order
				execOrderSynchronized(mainClient, slaveClientList, user);
				
				//5、股权结构表crm_stock
				execStockSynchronized(mainClient, slaveClientList, user);
				
				//6、其他应收账款表crm_otherReceivable
				execOtherReceivableSynchronized(mainClient, slaveClientList, user);
				
				//7、应收账款表crm_receivable
				execReceivableSynchronized(mainClient, slaveClientList, user);
				
				//8、财务状况说明表crm_financeDesc
				execFinanceDescSynchronized(mainClient, slaveClientList, user);
				
				//9、水电汽费缴纳情况crm_costInfo
				execCostInfoSynchronized(mainClient, slaveClientList, user);
				
				//10、上下游客户表crm_upDownClient
				execUpDownClientSynchronized(mainClient, slaveClientList, user);
				
				//11、股东背景及主要管理人员情况crm_managerInfo
				execManagerInfoSynchronized(mainClient, slaveClientList, user);
				
				//12、银行开户信息表crm_bankAccount
				execBankAccountSynchronized(mainClient, slaveClientList, user);
				
				//13、黑名单登记表crm_badClient
				execBadClientSynchronized(mainClient, slaveClientList, user);
				
				//14、客户附件表crm_clientFiles
				execClientFilesSynchronized(mainClient, slaveClientList, user);
				
				//15、存货表crm_inventory
				execInventorySynchronized(mainClient, slaveClientList, user);
				
				//16、土地房产表crm_landHouse
				execLandHouseSynchronized(mainClient, slaveClientList, user);
				
				//17、机器设备及车辆表crm_machine
				execMachineSynchronized(mainClient, slaveClientList, user);
				
				//18、贷款情况表crm_loanRec
				execLoanRecSynchronized(mainClient, slaveClientList, user);
				
				//19、票据信息表crm_billRec
				execBillRecSynchronized(mainClient, slaveClientList, user);
				
				//20、企业纳税情况crm_payTaxInfo
				execPayTaxInfoSynchronized(mainClient, slaveClientList, user);
				
				//21、配偶信息表crm_spouseInfo
				execSpouseInfoSynchronized(mainClient, slaveClientList, user);
				
				//22、关联企业表crm_relationClient
				execRelationClientSynchronized(mainClient, slaveClientList, user);
				
				//23、自有住房情况表crm_selfHouse
				execSelfHouseSynchronized(mainClient, slaveClientList, user);
				
				//24、信用信息及银企往来情况crm_creditInfo
				execCreditInfoSynchronized(mainClient, slaveClientList, user);
				
				//25、对外担保情况表crm_guarantyRec
				execGuarantyRecSynchronized(mainClient, slaveClientList, user);

				//26、风险等级变更记录表crm_riskLevelRec
				execRiskLevelRecSynchronized(mainClient, slaveClientList, user);
				updateCount ++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if( updateCount == slaveClientList.size() ){
			return true;
		}
		return false;
	}
	
	/** 
	 * @description  
	 * @author wuhn
	 * @date 2017年9月29日 下午5:03:35
	 */
	private void execRiskLevelRecSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String mainClient_ID = mainClient.getClient_ID();
		Crm_riskLevelRec mainRiskInfo = riskLevelService.selectOneRiskLevelInfo(" and client_ID = '"+mainClient_ID+"'");
		for (Client slaveClient : slaveClientList) {
			riskLevelService.deleteRiskLevelByClient_ID(slaveClient.getClient_ID());
			if(mainRiskInfo != null){
				Crm_riskLevelRec slaveRiskLevel = new Crm_riskLevelRec();
				BeanUtils.copyProperties(mainRiskInfo, slaveRiskLevel);
				slaveRiskLevel.setClient_ID(slaveClient.getClient_ID());
				slaveRiskLevel.setRiskLevelID(Tool.createUUID32());
				riskLevelService.insertOneRiskLevelRec(user,slaveRiskLevel);
			}
		}
	}

	private void execGuarantyRecSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql ="and client_ID = '"+mainClient.getClient_ID()+"'";
		List<Crm_guarantyRec> mainGuarantyRecList = guarantyRecService.selectGuarantyRecList(wheresql);
		for (Client slaveClient : slaveClientList) {
			guarantyRecService.deleteGuarantyRecByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(mainGuarantyRecList)){
				Crm_guarantyRec  slaveGuarantyRec = new Crm_guarantyRec();
				for (Crm_guarantyRec mainGuarantyRec : mainGuarantyRecList) {
					BeanUtils.copyProperties(mainGuarantyRec, slaveGuarantyRec);
					slaveGuarantyRec.setClient_ID(slaveClient.getClient_ID());
					slaveGuarantyRec.setGuarantyRec_ID(Tool.createUUID32());
					guarantyRecService.insertOneGuarantyRec(user, slaveGuarantyRec);
				}
			}
		}
	}

	private void execCreditInfoSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		Crm_creditInfo  creditInfo = new Crm_creditInfo();
		creditInfo.setClient_ID(mainClient.getClient_ID());
		creditInfo.setUnit_uid(user.getUnit_uid());
		Crm_creditInfo mainCreditInfo = creditInfoService.selectOneCreditInfo(creditInfo);
		for (Client slaveClient : slaveClientList) {
			creditInfoService.deleteCreditInfoByClient_ID(slaveClient.getClient_ID());
			if( null != mainCreditInfo){
				Crm_creditInfo  slaveCreditInfo = new Crm_creditInfo();
				BeanUtils.copyProperties(mainCreditInfo, slaveCreditInfo);
				slaveCreditInfo.setClient_ID(slaveClient.getClient_ID());
				slaveCreditInfo.setCreditInfo_ID(Tool.createUUID32());
				creditInfoService.insertOneCreditInfo(user, slaveCreditInfo);
			}
		}
	}

	private void execSelfHouseSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		List<Crm_selfHouse> mainSelfHouseList = selfHouseService.selectSelfHouseListByClient_ID(mainClient.getClient_ID());
		for (Client slaveClient : slaveClientList) {
			selfHouseService.deleteSelfHouseByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(mainSelfHouseList)){
				Crm_selfHouse  slaveSelfHouse = new Crm_selfHouse();
				for (Crm_selfHouse mainSelfHouse : mainSelfHouseList) {
					BeanUtils.copyProperties(mainSelfHouse, slaveSelfHouse);
					slaveSelfHouse.setClient_ID(slaveClient.getClient_ID());
					slaveSelfHouse.setSelfHosuse_ID(Tool.createUUID32());
					selfHouseService.insertOneSelfHouseInfo(user, slaveSelfHouse);
				}
			}
		}
	}

	private void execRelationClientSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql ="and client_ID = '"+mainClient.getClient_ID()+"'";
		List<Crm_relationClient> mainRelationClientList = relationClientService.selectRelationClientList(wheresql);
		for (Client slaveClient : slaveClientList) {
			relationClientService.deleteRelationClientByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(mainRelationClientList)){
				Crm_relationClient  slaveRelationClient =new Crm_relationClient();
				for (Crm_relationClient mainRelationClient : mainRelationClientList) {
					BeanUtils.copyProperties(mainRelationClient, slaveRelationClient);
					slaveRelationClient.setClient_ID(slaveClient.getClient_ID());
					slaveRelationClient.setRelation_id(Tool.createUUID32());
					relationClientService.insertOneRelationClientInfo(user, slaveRelationClient);
				}
			}
		}
	}

	private void execSpouseInfoSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		Crm_spouseInfo  spouseInfo = new Crm_spouseInfo();
		spouseInfo.setClient_ID(mainClient.getClient_ID());
		Crm_spouseInfo mainSpouseInfo = spouseInfoService.selectOneSpouseInfo(spouseInfo);
		for (Client slaveClient : slaveClientList) {
			Crm_spouseInfo  slaveSpouseInfo =new Crm_spouseInfo();
			slaveSpouseInfo.setClient_ID(slaveClient.getClient_ID());
			spouseInfoService.deleteOneSpouseInfo(user, slaveSpouseInfo);
			if(mainSpouseInfo != null){
				BeanUtils.copyProperties(mainSpouseInfo, slaveSpouseInfo);
				slaveSpouseInfo.setClient_ID(slaveClient.getClient_ID());
				slaveSpouseInfo.setSpouseInfo_ID(Tool.createUUID32());
				spouseInfoService.insertOneSpouseInfo(user, slaveSpouseInfo);
			}
		}
	}

	private void execPayTaxInfoSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql ="and client_ID = '"+mainClient.getClient_ID()+"'";
		List<Crm_payTaxInfo> mainPayTaxInfoList = payTaxInfoService.selectPayTaxInfoList(wheresql);
		for (Client slaveClient : slaveClientList) {
			payTaxInfoService.deletePayTaxByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(mainPayTaxInfoList)){ 
				Crm_payTaxInfo  slavePayTaxInfo = new Crm_payTaxInfo();
				for (Crm_payTaxInfo mainPayTaxInfo : mainPayTaxInfoList) {
					BeanUtils.copyProperties(mainPayTaxInfo, slavePayTaxInfo);
					slavePayTaxInfo.setClient_ID(slaveClient.getClient_ID());
					slavePayTaxInfo.setPayTaxInfo_ID(Tool.createUUID32());
					payTaxInfoService.insertOnePayTaxInfo(user, slavePayTaxInfo);
				}
			}
		}
		
	}

	private void execBillRecSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql ="and client_ID = '"+mainClient.getClient_ID()+"'";
		List<Crm_billRec> mainBillRecList = billRecService.selectBillRecList(wheresql);
		for (Client slaveClient : slaveClientList) {
			billRecService.deleteBillRecByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(mainBillRecList)){ 
				Crm_billRec  slaveBillRec = new Crm_billRec();
				for (Crm_billRec mainBillRec : mainBillRecList) {
					BeanUtils.copyProperties(mainBillRec, slaveBillRec);
					slaveBillRec.setClient_ID(slaveClient.getClient_ID());
					slaveBillRec.setBillRec_ID(Tool.createUUID32());
					billRecService.insertOneBillRec(user, slaveBillRec);
				}
			}
		}
	}

	private void execLoanRecSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql ="and client_ID = '"+mainClient.getClient_ID()+"'";
		List<Crm_loanRec> maintLoanRecList = loanRecService.selectLoanRecList(wheresql);
		for (Client slaveClient : slaveClientList) {
			loanRecService.deleteLoanRecByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(maintLoanRecList)){ 
				Crm_loanRec  slaveLoanRec = new Crm_loanRec();
				for (Crm_loanRec maintLoanRec : maintLoanRecList) {
					BeanUtils.copyProperties(maintLoanRec, slaveLoanRec);
					slaveLoanRec.setClient_ID(slaveClient.getClient_ID());
					slaveLoanRec.setLoanRec_ID(Tool.createUUID32());
					loanRecService.insertOneLoanRec(user, slaveLoanRec);
				}
			}
		}
	}

	private void execMachineSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		Crm_machine  machine =new Crm_machine();
		machine.setClient_ID(mainClient.getClient_ID());
		List<Crm_machine> mainMachineList = machineService.selectMachineList(machine);
		for (Client slaveClient : slaveClientList) {
			machineService.deleteMachineByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(mainMachineList)){ 
				Crm_machine  slaveMachine =new Crm_machine();
				for (Crm_machine mainMachine : mainMachineList) {
					BeanUtils.copyProperties(mainMachine, slaveMachine);
					slaveMachine.setClient_ID(slaveClient.getClient_ID());
					slaveMachine.setMachine_ID(Tool.createUUID32());
					machineService.insertOneMachineInfo(user, slaveMachine);
				}
			}
		}

	}

	private void execLandHouseSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		Crm_landHouse  landHouse = new Crm_landHouse();
		landHouse.setClient_ID(mainClient.getClient_ID());
		List<Crm_landHouse> mainLandHouseList = landHouseService.selectLandHouseList(landHouse);
		for (Client slaveClient : slaveClientList) {
			landHouseService.deleteLandHouseByClient_ID(slaveClient.getClient_ID());
			if(CollectionUtils.isNotEmpty(mainLandHouseList)){ 
				Crm_landHouse  slaveLandHouse = new Crm_landHouse();
				for (Crm_landHouse mainLandHouse : mainLandHouseList) {
					BeanUtils.copyProperties(mainLandHouse, slaveLandHouse);
					slaveLandHouse.setClient_ID(slaveClient.getClient_ID());
					slaveLandHouse.setLandHouse_ID(Tool.createUUID32());
					landHouseService.insertOneLandHouseInfo(user, slaveLandHouse);
				}
			}
		}
	}

	private void execInventorySynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		Crm_inventory inventory =new Crm_inventory();
		inventory.setClient_ID(mainClient.getClient_ID());
		List<Crm_inventory> mainInventoryList = inventoryService.selectInventoryList(inventory);
		for (Client slaveClient : slaveClientList) {
			inventoryService.deleteInventoryByWheresql(" and client_ID ='"+slaveClient.getClient_ID()+"'");
			if(CollectionUtils.isNotEmpty(mainInventoryList)){ 
				Crm_inventory  slaveInventory =new Crm_inventory();
				for (Crm_inventory mainInventory : mainInventoryList) {
					BeanUtils.copyProperties(mainInventory, slaveInventory);
					slaveInventory.setClient_ID(slaveClient.getClient_ID());
					slaveInventory.setInventory_ID(Tool.createUUID32());
					inventoryService.insertOneInventoryInfo(user, slaveInventory);
				}
			}
		}
	}
	
	
	private void execClientFilesSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		List<Crm_clientfiles> mainClientFiles = clientFilesService.selectPictureFileList(" and client_ID = '"+mainClient.getClient_ID()+"'");
		for (Client c : slaveClientList) {
			clientFilesService.deleteClientFilesByClient_ID(c.getClient_ID(), user); //清空副版本客户的 附件
			if(CollectionUtils.isNotEmpty(mainClientFiles)){ //客户和客户附件是一对多的关系
				Crm_clientfiles  clientFiles = new Crm_clientfiles();
				for (Crm_clientfiles mainFile : mainClientFiles) {
					BeanUtils.copyProperties(mainFile, clientFiles);
					clientFiles.setClientFiles_ID(Tool.createUUID32());
					clientFiles.setClient_ID(c.getClient_ID()); // 副版本的客户id
					clientFilesService.insertOneClientFiles(clientFiles);
				}
			}
		}
	}

	private void execBadClientSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		List<Crm_badClient> mainBadClientList = badClientService.selectBadClientListByWhereSql(mainClient.getClient_ID());
		for (Client slaveClient : slaveClientList) {
			badClientService.deleteBadClientByWhereSql(" and client_ID ='"+slaveClient.getClient_ID()+"'");
			if(CollectionUtils.isNotEmpty(mainBadClientList)){
				Crm_badClient  slaveBadClient =new Crm_badClient();
				for (Crm_badClient mainBadClient : mainBadClientList) {
					BeanUtils.copyProperties(mainBadClient, slaveBadClient);
					slaveBadClient.setClient_ID(slaveClient.getClient_ID());
					slaveBadClient.setBadClient_ID(Tool.createUUID32());
					badClientService.insertOneBadClientInfo(user, slaveBadClient);
				}
			}
		}
	}

	private void execBankAccountSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		Crm_bankAccount  bank =new Crm_bankAccount();
		bank.setClient_ID(mainClient.getClient_ID());
		List<Crm_bankAccount> mainBankAccountList = bankAccountService.selectCompanyCrm_bankAccountByClient_ID(bank);
		for (Client slaveClient : slaveClientList) {
			bankAccountService.deleteOneCompanyCrm_bankAccountByClient_ID(slaveClient.getClient_ID(), user);
			if(CollectionUtils.isNotEmpty(mainBankAccountList)){
				Crm_bankAccount  slaveBankAccount=new Crm_bankAccount();
				for (Crm_bankAccount mianBankAccount : mainBankAccountList) {
					BeanUtils.copyProperties(mianBankAccount, slaveBankAccount);
					slaveBankAccount.setClient_ID(slaveClient.getClient_ID());
					slaveBankAccount.setBankaccountId(Tool.createUUID32());
					bankAccountService.insertOneCompanyCrm_bankAccountInfo(slaveBankAccount, user);
				}
			}
		}
	}

	private void execManagerInfoSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String sql=" and  client_ID ='"+mainClient.getClient_ID()+"'";
		Crm_managerInfo mainManagerInfo = managerInfoService.selectOneManagerInfo(sql);
		for (Client slaveClient : slaveClientList) {
			managerInfoService.deleteManagerInfoByClient_ID(slaveClient.getClient_ID());
			if(null != mainManagerInfo){
				Crm_managerInfo  slaveManagerInfo=new Crm_managerInfo();
				BeanUtils.copyProperties(mainManagerInfo, slaveManagerInfo);
				slaveManagerInfo.setClient_ID(slaveClient.getClient_ID());
				slaveManagerInfo.setManagerinfoId(Tool.createUUID32());
				managerInfoService.insertOneManagerInfo(slaveManagerInfo, user);
			}
		}
	}

	private void execUpDownClientSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String sql=" and client_ID ='"+mainClient.getClient_ID()+"'";
		List<Crm_upDownClient>  mainUpDownClientList = upDownClientService.selectUpDownClientList(sql);
		for (Client slaveClient : slaveClientList) {
			sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
			upDownClientService.deleteUpDownClientByWhereSql(sql);
			if(CollectionUtils.isNotEmpty(mainUpDownClientList)){
				Crm_upDownClient slaveUpDownClient = new Crm_upDownClient();
				for (Crm_upDownClient mainUpDownClient : mainUpDownClientList) {
					BeanUtils.copyProperties(mainUpDownClient, slaveUpDownClient);
					slaveUpDownClient.setClient_ID(slaveClient.getClient_ID());
					slaveUpDownClient.setUpDownClient_ID(Tool.createUUID32());
					upDownClientService.insertOneUpDownClient(user, slaveUpDownClient);
				}
			}
		}
	}

	private void execCostInfoSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String sql=" and client_ID ='"+mainClient.getClient_ID()+"'";
		List<Crm_costInfo> mainCostInfoList = costInfoService.selectCostInfoList(sql);
		for (Client slaveClient : slaveClientList) {
			sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
			costInfoService.deleteCostInfoByWhereSql(sql);
			if(CollectionUtils.isNotEmpty(mainCostInfoList)){
				Crm_costInfo slaveCostInfo =new Crm_costInfo();
				for (Crm_costInfo mainCostInfo : mainCostInfoList) {
					BeanUtils.copyProperties(mainCostInfo, slaveCostInfo);
					slaveCostInfo.setClient_ID(slaveClient.getClient_ID());
					slaveCostInfo.setCostInfo_ID(Tool.createUUID32());
					costInfoService.insertOneCostInfo(user, slaveCostInfo);
				}
			}
		}
	}

	private void execFinanceDescSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String sql=" and client_ID ='"+mainClient.getClient_ID()+"'";
		List<Crm_financeDesc> mainFinanceDescList = financeDescService.selectFinanceDescListByWhereSql(sql);
		for (Client slaveClient : slaveClientList) {
			sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
			financeDescService.deleteFinanceDescByWhereSql(sql);
			if(CollectionUtils.isNotEmpty(mainFinanceDescList)){
				Crm_financeDesc  slaveFinanceDesc=new Crm_financeDesc();
				for (Crm_financeDesc mainFinanceDesc : mainFinanceDescList) {
					BeanUtils.copyProperties(mainFinanceDesc, slaveFinanceDesc);
					slaveFinanceDesc.setClient_ID(slaveClient.getClient_ID());
					slaveFinanceDesc.setFinanceDesc_ID(Tool.createUUID32());
					financeDescService.insertOneFinanceDesc(user, slaveFinanceDesc);
				}
			}
		}
	}

	private void execReceivableSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String sql=" and client_ID ='"+mainClient.getClient_ID()+"'";
		List<Crm_receivable> mainReceivableList = receivableService.selectReceivableListByWhereSql(sql);
		for (Client slaveClient : slaveClientList) {
			sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
			receivableService.deleteReceivableListByWhereSql(sql);
			if(CollectionUtils.isNotEmpty(mainReceivableList)){
				Crm_receivable  slaveReceivable= new Crm_receivable();
				for (Crm_receivable mainReceivable : mainReceivableList) {
					BeanUtils.copyProperties(mainReceivable, slaveReceivable);
					slaveReceivable.setClient_ID(slaveClient.getClient_ID());
					slaveReceivable.setReceivable_ID(Tool.createUUID32());
					receivableService.insertOneReceivableInfo(user, slaveReceivable);
				}
			}
		}
	}

	private void execOtherReceivableSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
			Crm_otherReceivable otherReceivable =new Crm_otherReceivable();
			otherReceivable.setClient_ID(mainClient.getClient_ID());
			List<Crm_otherReceivable> mainOtherReceivableList = otherReceivableService.selectOtherReceivableList(otherReceivable);
			for (Client slaveClient : slaveClientList) {
				otherReceivableService.deleteOtherReceivableByClient_ID(slaveClient.getClient_ID());
				if(CollectionUtils.isNotEmpty(mainOtherReceivableList)){
					Crm_otherReceivable slaveOtherReceivable =new Crm_otherReceivable();
					for (Crm_otherReceivable mainOtherReceivable : mainOtherReceivableList) {
						BeanUtils.copyProperties(mainOtherReceivable, slaveOtherReceivable);
						slaveOtherReceivable.setClient_ID(slaveClient.getClient_ID());
						slaveOtherReceivable.setOtherReceivable_ID(Tool.createUUID32());
						otherReceivableService.insertOneOtherReceivableInfo(user, slaveOtherReceivable);
					}
				}
			}
	}

	private void execStockSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		List<Crm_stock> mainStockList = stockService.selectStockListByClient_ID(mainClient.getClient_ID());
		for (Client slaveClient : slaveClientList) {
			stockService.deleteStockInfoByClient_ID(slaveClient.getClient_ID(), user);
			if(CollectionUtils.isNotEmpty(mainStockList)){
				Crm_stock  slaveStock =new Crm_stock();
				for (Crm_stock mainStock : mainStockList) {
					BeanUtils.copyProperties(mainStock, slaveStock);
					slaveStock.setClient_ID(slaveClient.getClient_ID());
					slaveStock.setStockId(Tool.createUUID32());
					stockService.insertOneStockInfo(slaveStock, user);
				}
			}	
		}
	}

	private void execOrderSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql=" and client_ID='"+mainClient.getClient_ID()+"'";
		List<Crm_order> mainOrderList = orderService.selectOrderList(wheresql);
		for (Client slaveClient : slaveClientList) {
			wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
			orderService.deleteOrderByWheresql(wheresql);
			if(CollectionUtils.isNotEmpty(mainOrderList)){
				Crm_order  slaveOrder =new Crm_order();
				for (Crm_order mainOrder : mainOrderList) {
					BeanUtils.copyProperties(mainOrder, slaveOrder);
					slaveOrder.setClient_ID(slaveClient.getClient_ID());
					slaveOrder.setOrder_ID(Tool.createUUID32());
					orderService.insertOneOrder(user, slaveOrder);
				}
			}
		}
	}
	
	
	private void execReportSySynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql=" and client_ID='"+mainClient.getClient_ID()+"'";
		List<Crm_reportSy> syList = reportSyService.selectReportSyList(wheresql);
		for (Client slaveClient : slaveClientList) {
			wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
			reportSyService.delectReportSyByWhereSql(user, wheresql);
			if(CollectionUtils.isNotEmpty(syList)){
				Crm_reportSy  slaveSy=new Crm_reportSy();
				for (Crm_reportSy mainSy : syList) {
					BeanUtils.copyProperties(mainSy, slaveSy);
					slaveSy.setClient_ID(slaveClient.getClient_ID());
					slaveSy.setReportSy_ID(Tool.createUUID32());
					reportSyService.insertOneReportSyInfo(user, slaveSy);
				}
			}
		}
	}

	private void execReportXjlSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql=" and client_ID='"+mainClient.getClient_ID()+"'";
		List<Crm_reportXjl> xjlList = reportXjlService.selectCrm_ReportXjlList(wheresql);
		for (Client slaveClient : slaveClientList) {
			wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
			reportXjlService.delectReportXjlByWhereSql(user, wheresql);
			if(CollectionUtils.isNotEmpty(xjlList)){
				Crm_reportXjl  slaveXjl = new Crm_reportXjl();
				for (Crm_reportXjl mainXjl : xjlList) {
					BeanUtils.copyProperties(mainXjl, slaveXjl);
					slaveXjl.setClient_ID(slaveClient.getClient_ID());
					slaveXjl.setReportXjl_ID(Tool.createUUID32());
					reportXjlService.insertOneReportXjlInfo(user, slaveXjl);
				}
			}
		}
		
	}

	/**
	 * @description 财务报表-资产负债表crm_reportZcfz 信息同步
	 * @author wuhn
	 * @date 2017年9月29日 下午4:36:03
	 */
	private void execReportZcfzSynchronized(Client mainClient, List<Client> slaveClientList, User user) {
		String wheresql=" and client_ID='"+mainClient.getClient_ID()+"'";
		List<Crm_reportZcfz> zcfzList = reportZcfzService.selectReportZcfzByList(wheresql);
		for (Client slaveClient : slaveClientList) {
			wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
			reportZcfzService.delectReportZcfzByWhereSql(user, wheresql);
			if(CollectionUtils.isNotEmpty(zcfzList)){
				Crm_reportZcfz  slaveZcfz=new Crm_reportZcfz();
				for (Crm_reportZcfz mainZcfz : zcfzList) {
					BeanUtils.copyProperties(mainZcfz, slaveZcfz);
					slaveZcfz.setClient_ID(slaveClient.getClient_ID());
					slaveZcfz.setReportZcfz_ID(Tool.createUUID32());
					reportZcfzService.insertOneReportZcfzInfo(user, slaveZcfz);
				}
			}
		}
	}

	@Override
	public Boolean updateAllClientInfo(Client client, User user) {
		int info = 0;
		try {
			info = crm_clientMapper.updateAllClientInfo(client);
			if(info >0){
				logService.insertOneOperatorLogInfo(user, "客户管理", "修改", "修改客户"+client.getClientName());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @description	  客户副版本同步到客户主版本
	 * @author wuhn
	 * @date 2017年10月13日 13:35:35
	 */
	@Override
	public Boolean slaveSyncMainClient(User user,String client_ID) {
		Client mainClient = this.selectMainClientByClient_ID(client_ID);
		if(null == mainClient){
			System.out.println("客户表中主版本记录不存在,请联系管理员。。。");
		}
		
		String wheresql=" and client_ID ='"+client_ID+"' and isMainVersion=false";
		List<Client> slaveClientList = this.selectClientListByWheresql(wheresql);
		return execSlaveSyncMainClient(mainClient,slaveClientList,user);
	}
	
	
	private Boolean execSlaveSyncMainClient(Client mainClient, List<Client> slaveClientList, User user) {
		//副版本同步到主版本
		Client slaveClient = slaveClientList.get(0);
		String client_ID = mainClient.getClient_ID();
		BeanUtils.copyProperties(slaveClient, mainClient);
		mainClient.setClient_ID(client_ID);
		mainClient.setIsMainVersion(true);
		try {
			crm_clientMapper.updateAllClientInfo(mainClient);
			
			//1、财务报表-资产负债表crm_reportZcfz
			execReportZcfzSynchronizedToMain(mainClient, slaveClient, user);
			
			//2、财务报表-现金流量表crm_reportXjl
			execReportXjlSynchronizedToMain(mainClient, slaveClient, user);
			
			//3、 财务报表-损益表crm_reportSy
			execReportSySynchronizedToMain(mainClient, slaveClient, user);
			
			//4、订单情况crm_order
			execOrderSynchronizedToMain(mainClient, slaveClient, user);
			
			//5、股权结构表crm_stock
			execStockSynchronizedToMain(mainClient, slaveClient, user);
			
			//6、其他应收账款表crm_otherReceivable
			execOtherReceivableSynchronizedToMain(mainClient, slaveClient, user);
			
			//7、应收账款表crm_receivable
			execReceivableSynchronizedToMain(mainClient, slaveClient, user);
			
			//8、财务状况说明表crm_financeDesc
			execFinanceDescSynchronizedToMain(mainClient, slaveClient, user);
			
			//9、水电汽费缴纳情况crm_costInfo
			execCostInfoSynchronizedToMain(mainClient, slaveClient, user);
			
			//10、上下游客户表crm_upDownClient
			execUpDownClientSynchronizedToMain(mainClient, slaveClient, user);
			
			//11、股东背景及主要管理人员情况crm_managerInfo
			execManagerInfoSynchronizedToMain(mainClient, slaveClient, user);
			
			//12、银行开户信息表crm_bankAccount
			execBankAccountSynchronizedToMain(mainClient, slaveClient, user);
			
			//13、黑名单登记表crm_badClient
			execBadClientSynchronizedToMain(mainClient, slaveClient, user);
			
			//14、客户附件表crm_clientFiles
			execClientFilesSynchronizedToMain(mainClient, slaveClient, user);
			
			//15、存货表crm_inventory
			execInventorySynchronizedToMain(mainClient, slaveClient, user);
			
			//16、土地房产表crm_landHouse
			execLandHouseSynchronizedToMain(mainClient, slaveClient, user);
			
			//17、机器设备及车辆表crm_machine
			execMachineSynchronizedToMain(mainClient, slaveClient, user);
			
			//18、贷款情况表crm_loanRec
			execLoanRecSynchronizedToMain(mainClient, slaveClient, user);
			
			//19、票据信息表crm_billRec
			execBillRecSynchronizedToMain(mainClient, slaveClient, user);
			
			//20、企业纳税情况crm_payTaxInfo
			execPayTaxInfoSynchronizedToMain(mainClient, slaveClient, user);
			
			//21、配偶信息表crm_spouseInfo
			execSpouseInfoSynchronizedToMain(mainClient, slaveClient, user);
			
			//22、关联企业表crm_relationClient
			execRelationClientSynchronizedToMain(mainClient, slaveClient, user);
			
			//23、自有住房情况表crm_selfHouse
			execSelfHouseSynchronizedToMain(mainClient, slaveClient, user);
			
			//24、信用信息及银企往来情况crm_creditInfo
			execCreditInfoSynchronizedToMain(mainClient, slaveClient, user);
			
			//25、对外担保情况表crm_guarantyRec
			execGuarantyRecSynchronizedToMain(mainClient, slaveClient, user);

			//26、风险等级变更记录表crm_riskLevelRec
			execRiskLevelRecSynchronizedToMain(mainClient, slaveClient, user);
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	private void execRiskLevelRecSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String mainClient_ID = mainClient.getClient_ID();
		Crm_riskLevelRec mainRiskInfo = riskLevelService.selectOneRiskLevelInfo(" and client_ID = '"+slaveClient.getClient_ID()+"'");
			riskLevelService.deleteRiskLevelByClient_ID(slaveClient.getClient_ID());
			if(mainRiskInfo != null){
				Crm_riskLevelRec slaveRiskLevel = new Crm_riskLevelRec();
				BeanUtils.copyProperties(mainRiskInfo, slaveRiskLevel);
				slaveRiskLevel.setClient_ID(mainClient_ID);
				slaveRiskLevel.setRiskLevelID(Tool.createUUID32());
				riskLevelService.insertOneRiskLevelRec(user,slaveRiskLevel);
			}
	}

	private void execGuarantyRecSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql ="and client_ID = '"+slaveClient.getClient_ID()+"'";
		List<Crm_guarantyRec> mainGuarantyRecList = guarantyRecService.selectGuarantyRecList(wheresql);
		guarantyRecService.deleteGuarantyRecByClient_ID(mainClient.getClient_ID());
		if(CollectionUtils.isNotEmpty(mainGuarantyRecList)){
			Crm_guarantyRec  slaveGuarantyRec = new Crm_guarantyRec();
			for (Crm_guarantyRec mainGuarantyRec : mainGuarantyRecList) {
				BeanUtils.copyProperties(mainGuarantyRec, slaveGuarantyRec);
				slaveGuarantyRec.setClient_ID(client_ID);
				slaveGuarantyRec.setGuarantyRec_ID(Tool.createUUID32());
				guarantyRecService.insertOneGuarantyRec(user, slaveGuarantyRec);
			}
		}
		
	}

	private void execCreditInfoSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		Crm_creditInfo  creditInfo = new Crm_creditInfo();
		creditInfo.setClient_ID(slaveClient.getClient_ID());
		Crm_creditInfo mainCreditInfo = creditInfoService.selectOneCreditInfo(creditInfo);
		creditInfoService.deleteCreditInfoByClient_ID(mainClient.getClient_ID());
		if( null != mainCreditInfo){
			Crm_creditInfo  slaveCreditInfo = new Crm_creditInfo();
			BeanUtils.copyProperties(mainCreditInfo, slaveCreditInfo);
			slaveCreditInfo.setClient_ID(client_ID);
			slaveCreditInfo.setCreditInfo_ID(Tool.createUUID32());
			creditInfoService.insertOneCreditInfo(user, slaveCreditInfo);
		}
	}

	private void execSelfHouseSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		List<Crm_selfHouse> mainSelfHouseList = selfHouseService.selectSelfHouseListByClient_ID(slaveClient.getClient_ID());
		selfHouseService.deleteSelfHouseByClient_ID(client_ID);
		if(CollectionUtils.isNotEmpty(mainSelfHouseList)){
			Crm_selfHouse  slaveSelfHouse = new Crm_selfHouse();
			for (Crm_selfHouse mainSelfHouse : mainSelfHouseList) {
				BeanUtils.copyProperties(mainSelfHouse, slaveSelfHouse);
				slaveSelfHouse.setClient_ID(client_ID);
				slaveSelfHouse.setSelfHosuse_ID(Tool.createUUID32());
				selfHouseService.insertOneSelfHouseInfo(user, slaveSelfHouse);
			}
		}
		
	}

	private void execRelationClientSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql ="and client_ID = '"+slaveClient.getClient_ID()+"'";
		List<Crm_relationClient> mainRelationClientList = relationClientService.selectRelationClientList(wheresql);
		relationClientService.deleteRelationClientByClient_ID(client_ID);
		if(CollectionUtils.isNotEmpty(mainRelationClientList)){
			Crm_relationClient  slaveRelationClient =new Crm_relationClient();
			for (Crm_relationClient mainRelationClient : mainRelationClientList) {
				BeanUtils.copyProperties(mainRelationClient, slaveRelationClient);
				slaveRelationClient.setClient_ID(client_ID);
				slaveRelationClient.setRelation_id(Tool.createUUID32());
				relationClientService.insertOneRelationClientInfo(user, slaveRelationClient);
			}
		}
	}

	private void execSpouseInfoSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		Crm_spouseInfo  spouseInfo = new Crm_spouseInfo();
		spouseInfo.setClient_ID(slaveClient.getClient_ID());
		Crm_spouseInfo mainSpouseInfo = spouseInfoService.selectOneSpouseInfo(spouseInfo);
		Crm_spouseInfo  slaveSpouseInfo =new Crm_spouseInfo();
		slaveSpouseInfo.setClient_ID(client_ID);
		spouseInfoService.deleteOneSpouseInfo(user, slaveSpouseInfo);
		if(mainSpouseInfo != null){
			BeanUtils.copyProperties(mainSpouseInfo, slaveSpouseInfo);
			slaveSpouseInfo.setClient_ID(client_ID);
			slaveSpouseInfo.setSpouseInfo_ID(Tool.createUUID32());
			spouseInfoService.insertOneSpouseInfo(user, slaveSpouseInfo);
		}
	}

	private void execPayTaxInfoSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql ="and client_ID = '"+slaveClient.getClient_ID()+"'";
		List<Crm_payTaxInfo> mainPayTaxInfoList = payTaxInfoService.selectPayTaxInfoList(wheresql);
		payTaxInfoService.deletePayTaxByClient_ID(client_ID);
		if(CollectionUtils.isNotEmpty(mainPayTaxInfoList)){ 
			Crm_payTaxInfo  slavePayTaxInfo = new Crm_payTaxInfo();
			for (Crm_payTaxInfo mainPayTaxInfo : mainPayTaxInfoList) {
				BeanUtils.copyProperties(mainPayTaxInfo, slavePayTaxInfo);
				slavePayTaxInfo.setClient_ID(client_ID);
				slavePayTaxInfo.setPayTaxInfo_ID(Tool.createUUID32());
				payTaxInfoService.insertOnePayTaxInfo(user, slavePayTaxInfo);
			}
		}
	}

	private void execBillRecSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql ="and client_ID = '"+slaveClient.getClient_ID()+"'";
		List<Crm_billRec> mainBillRecList = billRecService.selectBillRecList(wheresql);
		billRecService.deleteBillRecByClient_ID(client_ID);
		if(CollectionUtils.isNotEmpty(mainBillRecList)){ 
			Crm_billRec  slaveBillRec = new Crm_billRec();
			for (Crm_billRec mainBillRec : mainBillRecList) {
				BeanUtils.copyProperties(mainBillRec, slaveBillRec);
				slaveBillRec.setClient_ID(client_ID);
				slaveBillRec.setBillRec_ID(Tool.createUUID32());
				billRecService.insertOneBillRec(user, slaveBillRec);
			}
		}
	}

	private void execLoanRecSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql ="and client_ID = '"+slaveClient.getClient_ID()+"'";
		List<Crm_loanRec> maintLoanRecList = loanRecService.selectLoanRecList(wheresql);
		loanRecService.deleteLoanRecByClient_ID(slaveClient.getClient_ID());
		if(CollectionUtils.isNotEmpty(maintLoanRecList)){ 
			Crm_loanRec  slaveLoanRec = new Crm_loanRec();
			for (Crm_loanRec maintLoanRec : maintLoanRecList) {
				BeanUtils.copyProperties(maintLoanRec, slaveLoanRec);
				slaveLoanRec.setClient_ID(client_ID);
				slaveLoanRec.setLoanRec_ID(Tool.createUUID32());
				loanRecService.insertOneLoanRec(user, slaveLoanRec);
			}
		}
		
	}

	private void execMachineSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		Crm_machine  machine =new Crm_machine();
		machine.setClient_ID(slaveClient.getClient_ID());
		List<Crm_machine> mainMachineList = machineService.selectMachineList(machine);
		machineService.deleteMachineByClient_ID(client_ID);
		if(CollectionUtils.isNotEmpty(mainMachineList)){ 
			Crm_machine  slaveMachine =new Crm_machine();
			for (Crm_machine mainMachine : mainMachineList) {
				BeanUtils.copyProperties(mainMachine, slaveMachine);
				slaveMachine.setClient_ID(client_ID);
				slaveMachine.setMachine_ID(Tool.createUUID32());
				machineService.insertOneMachineInfo(user, slaveMachine);
			}
		}
	}

	private void execLandHouseSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		Crm_landHouse  landHouse = new Crm_landHouse();
		landHouse.setClient_ID(slaveClient.getClient_ID());
		List<Crm_landHouse> mainLandHouseList = landHouseService.selectLandHouseList(landHouse);
		landHouseService.deleteLandHouseByClient_ID(client_ID);
		if(CollectionUtils.isNotEmpty(mainLandHouseList)){ 
			Crm_landHouse  slaveLandHouse = new Crm_landHouse();
			for (Crm_landHouse mainLandHouse : mainLandHouseList) {
				BeanUtils.copyProperties(mainLandHouse, slaveLandHouse);
				slaveLandHouse.setClient_ID(client_ID);
				slaveLandHouse.setLandHouse_ID(Tool.createUUID32());
				landHouseService.insertOneLandHouseInfo(user, slaveLandHouse);
			}
		}
	}

	private void execInventorySynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		Crm_inventory inventory =new Crm_inventory();
		inventory.setClient_ID(slaveClient.getClient_ID());
		List<Crm_inventory> mainInventoryList = inventoryService.selectInventoryList(inventory);
		inventoryService.deleteInventoryByWheresql(" and client_ID ='"+client_ID+"'");
		if(CollectionUtils.isNotEmpty(mainInventoryList)){ 
			Crm_inventory  slaveInventory =new Crm_inventory();
			for (Crm_inventory mainInventory : mainInventoryList) {
				BeanUtils.copyProperties(mainInventory, slaveInventory);
				slaveInventory.setClient_ID(client_ID);
				slaveInventory.setInventory_ID(Tool.createUUID32());
				inventoryService.insertOneInventoryInfo(user, slaveInventory);
			}
		}
	}

	private void execClientFilesSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		List<Crm_clientfiles> mainClientFiles = clientFilesService.selectPictureFileList(" and client_ID = '"+slaveClient.getClient_ID()+"'");
		clientFilesService.deleteClientFilesByClient_ID(client_ID, user); //清空副版本客户的 附件
		if(CollectionUtils.isNotEmpty(mainClientFiles)){ //客户和客户附件是一对多的关系
			Crm_clientfiles  clientFiles = new Crm_clientfiles();
			for (Crm_clientfiles mainFile : mainClientFiles) {
				BeanUtils.copyProperties(mainFile, clientFiles);
				clientFiles.setClientFiles_ID(Tool.createUUID32());
				clientFiles.setClient_ID(client_ID); // 副版本的客户id
				clientFilesService.insertOneClientFiles(clientFiles);
			}
		}
	}

	private void execBadClientSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		List<Crm_badClient> mainBadClientList = badClientService.selectBadClientListByWhereSql(slaveClient.getClient_ID());
		badClientService.deleteBadClientByWhereSql(" and client_ID ='"+client_ID+"'");
		if(CollectionUtils.isNotEmpty(mainBadClientList)){
			Crm_badClient  slaveBadClient =new Crm_badClient();
			for (Crm_badClient mainBadClient : mainBadClientList) {
				BeanUtils.copyProperties(mainBadClient, slaveBadClient);
				slaveBadClient.setClient_ID(client_ID);
				slaveBadClient.setBadClient_ID(Tool.createUUID32());
				badClientService.insertOneBadClientInfo(user, slaveBadClient);
			}
		}
	}
	
	private void execBankAccountSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		Crm_bankAccount  bank =new Crm_bankAccount();
		bank.setClient_ID(slaveClient.getClient_ID());
		List<Crm_bankAccount> mainBankAccountList = bankAccountService.selectCompanyCrm_bankAccountByClient_ID(bank);
		bankAccountService.deleteOneCompanyCrm_bankAccountByClient_ID(client_ID, user);
		if(CollectionUtils.isNotEmpty(mainBankAccountList)){
			Crm_bankAccount  slaveBankAccount=new Crm_bankAccount();
			for (Crm_bankAccount mianBankAccount : mainBankAccountList) {
				BeanUtils.copyProperties(mianBankAccount, slaveBankAccount);
				slaveBankAccount.setClient_ID(client_ID);
				slaveBankAccount.setBankaccountId(Tool.createUUID32());
				bankAccountService.insertOneCompanyCrm_bankAccountInfo(slaveBankAccount, user);
			}
		}
	}
	
	private void execManagerInfoSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String sql=" and  client_ID ='"+slaveClient.getClient_ID()+"'";
		Crm_managerInfo mainManagerInfo = managerInfoService.selectOneManagerInfo(sql);
		managerInfoService.deleteManagerInfoByClient_ID(client_ID);
		if(null != mainManagerInfo){
			Crm_managerInfo  slaveManagerInfo=new Crm_managerInfo();
			BeanUtils.copyProperties(mainManagerInfo, slaveManagerInfo);
			slaveManagerInfo.setClient_ID(client_ID);
			slaveManagerInfo.setManagerinfoId(Tool.createUUID32());
			managerInfoService.insertOneManagerInfo(slaveManagerInfo, user);
		}
		
	}

	private void execUpDownClientSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
		List<Crm_upDownClient>  mainUpDownClientList = upDownClientService.selectUpDownClientList(sql);
		sql=" and client_ID ='"+client_ID+"'";
		upDownClientService.deleteUpDownClientByWhereSql(sql);
		if(CollectionUtils.isNotEmpty(mainUpDownClientList)){
			Crm_upDownClient slaveUpDownClient = new Crm_upDownClient();
			for (Crm_upDownClient mainUpDownClient : mainUpDownClientList) {
				BeanUtils.copyProperties(mainUpDownClient, slaveUpDownClient);
				slaveUpDownClient.setClient_ID(client_ID);
				slaveUpDownClient.setUpDownClient_ID(Tool.createUUID32());
				upDownClientService.insertOneUpDownClient(user, slaveUpDownClient);
			}
		}
	}

	private void execCostInfoSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
		List<Crm_costInfo> mainCostInfoList = costInfoService.selectCostInfoList(sql);
		sql=" and client_ID ='"+client_ID+"'";
		costInfoService.deleteCostInfoByWhereSql(sql);
		if(CollectionUtils.isNotEmpty(mainCostInfoList)){
			Crm_costInfo slaveCostInfo =new Crm_costInfo();
			for (Crm_costInfo mainCostInfo : mainCostInfoList) {
				BeanUtils.copyProperties(mainCostInfo, slaveCostInfo);
				slaveCostInfo.setClient_ID(client_ID);
				slaveCostInfo.setCostInfo_ID(Tool.createUUID32());
				costInfoService.insertOneCostInfo(user, slaveCostInfo);
			}
		}
		
	}

	private void execFinanceDescSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
		List<Crm_financeDesc> mainFinanceDescList = financeDescService.selectFinanceDescListByWhereSql(sql);
		sql=" and client_ID ='"+client_ID+"'";
		financeDescService.deleteFinanceDescByWhereSql(sql);
		if(CollectionUtils.isNotEmpty(mainFinanceDescList)){
			Crm_financeDesc  slaveFinanceDesc=new Crm_financeDesc();
			for (Crm_financeDesc mainFinanceDesc : mainFinanceDescList) {
				BeanUtils.copyProperties(mainFinanceDesc, slaveFinanceDesc);
				slaveFinanceDesc.setClient_ID(client_ID);
				slaveFinanceDesc.setFinanceDesc_ID(Tool.createUUID32());
				financeDescService.insertOneFinanceDesc(user, slaveFinanceDesc);
			}
		}
	}
	
	
	private void execReceivableSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String sql=" and client_ID ='"+slaveClient.getClient_ID()+"'";
		List<Crm_receivable> mainReceivableList = receivableService.selectReceivableListByWhereSql(sql);
		sql=" and client_ID ='"+client_ID+"'";
		receivableService.deleteReceivableListByWhereSql(sql);
		if(CollectionUtils.isNotEmpty(mainReceivableList)){
			Crm_receivable  slaveReceivable= new Crm_receivable();
			for (Crm_receivable mainReceivable : mainReceivableList) {
				BeanUtils.copyProperties(mainReceivable, slaveReceivable);
				slaveReceivable.setClient_ID(client_ID);
				slaveReceivable.setReceivable_ID(Tool.createUUID32());
				receivableService.insertOneReceivableInfo(user, slaveReceivable);
			}
		}
		
	}

	
	private void execOtherReceivableSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		Crm_otherReceivable otherReceivable =new Crm_otherReceivable();
		otherReceivable.setClient_ID(slaveClient.getClient_ID());
		List<Crm_otherReceivable> mainOtherReceivableList = otherReceivableService.selectOtherReceivableList(otherReceivable);
		otherReceivableService.deleteOtherReceivableByClient_ID(client_ID);
		if(CollectionUtils.isNotEmpty(mainOtherReceivableList)){
			Crm_otherReceivable slaveOtherReceivable =new Crm_otherReceivable();
			for (Crm_otherReceivable mainOtherReceivable : mainOtherReceivableList) {
				BeanUtils.copyProperties(mainOtherReceivable, slaveOtherReceivable);
				slaveOtherReceivable.setClient_ID(client_ID);
				slaveOtherReceivable.setOtherReceivable_ID(Tool.createUUID32());
				otherReceivableService.insertOneOtherReceivableInfo(user, slaveOtherReceivable);
			}
		}
	}

	private void execStockSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		List<Crm_stock> mainStockList = stockService.selectStockListByClient_ID(slaveClient.getClient_ID());
		stockService.deleteStockInfoByClient_ID(client_ID, user);
		if(CollectionUtils.isNotEmpty(mainStockList)){
			Crm_stock  slaveStock =new Crm_stock();
			for (Crm_stock mainStock : mainStockList) {
				BeanUtils.copyProperties(mainStock, slaveStock);
				slaveStock.setClient_ID(client_ID);
				slaveStock.setStockId(Tool.createUUID32());
				stockService.insertOneStockInfo(slaveStock, user);
			}
		}	
	}

	private void execOrderSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
		List<Crm_order> mainOrderList = orderService.selectOrderList(wheresql);
		wheresql=" and client_ID='"+client_ID+"'";
		orderService.deleteOrderByWheresql(wheresql);
		if(CollectionUtils.isNotEmpty(mainOrderList)){
			Crm_order  slaveOrder =new Crm_order();
			for (Crm_order mainOrder : mainOrderList) {
				BeanUtils.copyProperties(mainOrder, slaveOrder);
				slaveOrder.setClient_ID(client_ID);
				slaveOrder.setOrder_ID(Tool.createUUID32());
				orderService.insertOneOrder(user, slaveOrder);
			}
		}
	}

	private void execReportSySynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
		List<Crm_reportSy> syList = reportSyService.selectReportSyList(wheresql);
		wheresql=" and client_ID='"+client_ID+"'";
		reportSyService.delectReportSyByWhereSql(user, wheresql);
		if(CollectionUtils.isNotEmpty(syList)){
			Crm_reportSy  slaveSy=new Crm_reportSy();
			for (Crm_reportSy mainSy : syList) {
				BeanUtils.copyProperties(mainSy, slaveSy);
				slaveSy.setClient_ID(client_ID);
				slaveSy.setReportSy_ID(Tool.createUUID32());
				reportSyService.insertOneReportSyInfo(user, slaveSy);
			}
		}
	}

	private void execReportXjlSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
		List<Crm_reportXjl> xjlList = reportXjlService.selectCrm_ReportXjlList(wheresql);
		wheresql=" and client_ID='"+client_ID+"'";
		reportXjlService.delectReportXjlByWhereSql(user, wheresql);
		if(CollectionUtils.isNotEmpty(xjlList)){
			Crm_reportXjl  slaveXjl = new Crm_reportXjl();
			for (Crm_reportXjl mainXjl : xjlList) {
				BeanUtils.copyProperties(mainXjl, slaveXjl);
				slaveXjl.setClient_ID(client_ID);
				slaveXjl.setReportXjl_ID(Tool.createUUID32());
				reportXjlService.insertOneReportXjlInfo(user, slaveXjl);
			}
		}
	}

	private void execReportZcfzSynchronizedToMain(Client mainClient, Client slaveClient, User user) {
		String client_ID = mainClient.getClient_ID();
		String wheresql=" and client_ID='"+slaveClient.getClient_ID()+"'";
		List<Crm_reportZcfz> zcfzList = reportZcfzService.selectReportZcfzByList(wheresql);
		wheresql=" and client_ID='"+client_ID+"'";
		reportZcfzService.delectReportZcfzByWhereSql(user, wheresql);
		if(CollectionUtils.isNotEmpty(zcfzList)){
			Crm_reportZcfz  slaveZcfz=new Crm_reportZcfz();
			for (Crm_reportZcfz mainZcfz : zcfzList) {
				BeanUtils.copyProperties(mainZcfz, slaveZcfz);
				slaveZcfz.setClient_ID(client_ID);
				slaveZcfz.setReportZcfz_ID(Tool.createUUID32());
				reportZcfzService.insertOneReportZcfzInfo(user, slaveZcfz);
			}
		}
	}

	/**
	 * 更新国资委五级分类
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void updateClientRiskLevelExcel(String substring, List<Map> list2, User sysUser, Date now) {
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < list2.size(); i++) {
			Set set = list2.get(i).entrySet();  
	        Iterator it = set.iterator();  
	        List<Client> clients = new ArrayList<>();
	        String riskLeve = "";
	        String isNullKey = "";
	        
	        while ( it.hasNext() ) {  
	            Entry entry= (Entry) it.next();
	            if(null!=entry.getKey()){
		            String key = entry.getKey().toString();
		            if(key.equals("正常月户名")&&null!=entry.getValue()){
		            	String wheresql=" and clientName ='"+entry.getValue().toString()+"'";
		            	isNullKey = entry.getValue().toString();
		            	clients = crm_clientMapper.selectClientListByWheresql(wheresql);
		            	if (clients.size()<1) {
		            		lists.add("不存在的用户："+isNullKey);
						}
		            }
		            if(key.equals("五级分类（国资委）")&&null!=entry.getValue()){
		            	riskLeve = entry.getValue().toString();
		            }
	            }
	        }
	        if(clients.size()>0){
	        	for (Client client : clients) {
	        		client.setGzwRiskLevel(riskLeve);
	        		crm_clientMapper.updateOneCompanyClientInfo(client);
				}
	        }
		}
		for (String string : lists) {
			System.out.println(string);
		}
		
	}

	
	
	
	
	
	
	
	
}

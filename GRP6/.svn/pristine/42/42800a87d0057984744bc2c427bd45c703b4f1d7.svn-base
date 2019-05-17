package com.zjm.crm.client.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_riskLevelRec;

/**
 * 客户管理
 * @author chenyang add 20170426
 */
public interface ClientService {
	
	/**
	 * 查询个人客户分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Client> selectPersonClientPageTables(PageTable<Client> pageTable);
	


	/* ************************企业客户信息********************************* */
	
	/**
	 * 查询企业 客户 分页列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<Client> selectCompanysClientPageTables(PageTable<Client> pageTable);
	
	/**
	 * 
	 * @description   查询所有的企业客户 分页列表 总记录数
	 * @author wuhn
	 * @date 2017年5月4日 下午1:24:51
	 */
	public Long selectCompanyClientPageTables_Count(PageTable pageTable);
	
	
	/**
	 * @description  添加/插入一个企业客户信息
	 * @author wuhn
	 * @date 2017年5月4日 10:31:48
	 */
	public Boolean insertOneCompanyClientInfo(User user,Client client);
	
	/**
	 * 更新 修改一个企业客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 10:32:51
	 */
	public Boolean updateOneCompanyClientInfo(User user,Client client);
	
	/**
	 * 删除 移除一个企业客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 10:33:54
	 */
	public Boolean deleteOneCompanyClientInfo(User user,Client client);
	
	/**
	 * @description 根据客户名称查询客户信息
	 * @author wuhn
	 * @date 2017年5月4日 上午10:37:31
	 */
	public Client selectOneClientInfoByClientName(String clientName);
	
	/**
	 * 
	 * @description  查询一个企业客户的信息- 客户id,客户类型
	 * @author wuhn
	 * @date 2017年5月4日 15:31:06
	 */
	public Client  selectOneClientInfo(Client  client) ;

	/**
	 * 根据条件查询单个客户信息  
	 * xuyz 
	 * 商机管理受理申请时用 
	 */
	public Client selectOneClientByWheresql(String wheresql);
	
    /**
     * 判断客户名称是否存在;
     * @param wheresql
     * @return
     */
	public Boolean selectClientNameIsExist(String wheresql);
	
	/**
	 * @description	添加一条客户信息，并返回当前对象
	 * @author wuhn
	 * @date 2017年7月13日 上午11:14:09
	 */
	public Client insertClientAndReturnClientID(User user,Client client);
	
	
	/**
	 * 通过传入的apply_ID,创建客户副版本并返回客户id
	 * @param apply_ID
	 * @return
	 */
	public String getNewClientIDByApplyID(String apply_ID);
	/**
	 * 更改风险等级记录
	 * 
	 * @param user
	 * @param riskLevel
	 * @return
	 */
	public Boolean updateRiskLevelByClient_ID(User user,Crm_riskLevelRec riskLevelRec);
	
	/**
	 * 将与主版本客户有关的信息copy到副版本客户中
	 * @param mainClientID
	 * @param newClientID
	 */
	public void copyMainClientToNewClient(User user, String mainClientID,String newClientID);
	
	/**
	 * 更新企业所属的关联主体名称
	 */
	public void updateRelationMainName(Client client);
	
	
	/**
	 * 将与主版本客户有关的信息更新到副版本客户中
	 * @param mainClientID
	 * @param newClientID
	 */
	public Integer updateMainClientToNewClient(User user, String mainClientID);
	
	/**
	 * @description  项目客户资料同步到客户库 （同步到项目库） ---> 客户资料主版本同步到副版本
	 * @author wuhn
	 * @date 2017年9月28日 下午3:51:47
	 */
	Boolean MainSyncSlaveClient(User user,String client_ID);
	
	/**
	 * @description  根据wheresql 获取 client列表 list
	 * @author wuhn
	 * @date 2017年9月29日 上午10:44:56
	 */
	List<Client> selectClientListByWheresql(String wheresql);	
	
	/**
	 * @description 根据客户id获取客户主版本信息
	 * @author wuhn
	 * @date 2017年9月29日 下午2:03:33
	 */
	Client selectMainClientByClient_ID(String client_ID);
	
	/**
	 * @description 更新全部客户信息
	 * @author wuhn
	 * @date 2017年9月29日 下午3:57:36
	 */
	Boolean updateAllClientInfo(Client client,User user);
	
	/**
	 * @description	  客户副版本同步到客户主版本
	 * @author wuhn
	 * @date 2017年10月13日 下午1:34:21
	 */
	Boolean  slaveSyncMainClient(User user,String client_ID);

	/**
	 * 更新国资委五级分类状态
	 * @param substring
	 * @param list2
	 * @param sysUser
	 * @param now
	 */
	public void updateClientRiskLevelExcel(String substring, List<Map> list2, User sysUser, Date now);
	
}

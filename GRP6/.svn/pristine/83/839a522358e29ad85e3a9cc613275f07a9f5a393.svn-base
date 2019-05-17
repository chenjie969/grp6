package com.zjm.crm.db.map;

import java.util.List;

import com.zjm.crm.db.model.Client;
import com.zjm.common.db.model.PageTable;

public interface Crm_clientMapper {

	/**
	 * 查询企业客户分页列表
	 * @param pageTable
	 * @author zhangkeyao
	 * @return
	 */
	public List<Client> selectCompanyClientPageTables(PageTable<Client> pageTable);
	
	/**
	 * 查询个人客户    分页列表
	 * @param pageTable
	 * @return
	 */
	public List<Client> selectPersonClientPageTables(PageTable<Client> pageTable);
	
	/**
	 * 查询个人客户    总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectClientPageTables_Count(PageTable<Client> pageTable);

	/**
	 * @description 根据客户名称查询客户信息
	 * @author wuhn
	 * @date 2017年5月4日 上午10:37:31
	 */
	public Integer selectOneClientInfoByPersonName(String personName);
	
	/* ************************企业客户信息********************************* */
	/**
	 * 查询企业客户分页列表  wuhn
	 * @param pageTable
	 * @author wuhn
	 * @return
	 */
	public List<Client> selectCompanysClientPageTables(PageTable<Client> pageTable);
	
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
	 * @date 2017年5月4日 上午10:09:08
	 */
	public Integer insertOneCompanyClientInfo(Client client);
	
	/**
	 * 更新 修改一个企业客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:13:46
	 */
	public Integer updateOneCompanyClientInfo(Client client);
	/**
	 * 删除 移除一个企业客户信息
	 * @description
	 * @author wuhn
	 * @date 2017年5月4日 上午10:14:02
	 */
	public Integer deleteOneCompanyClientInfo(Client client);
	
	/**
	 * @description 根据客户名称查询客户信息
	 * @author wuhn
	 * @date 2017年5月4日 上午10:37:31
	 */
	public Client selectOneClientInfoByClientName(String clientName);
	
	/**
	 * 
	 * @description  查询一个客户的信息,由客户id和客户类型查询客户信息  共用 公用
	 * @author wuhn
	 * @date 2017年5月4日 下午3:26:44
	 */
	public Client  selectOneClientInfo(Client  client) ;
    /**
     * 判断客户名是否存在;
     * @param wheresql
     * @return
     */
	public Integer selectClientNameIsExist(String wheresql);
	
     /**
      * 判断申请人姓名是否存在;
      * @param wheresql
      * @return
      */
 	public Integer selectPersonNameIsExist(String wheresql);
 	
 	/**
 	 * 根据客户ID查询客户名称
 	 */
 	public String selectNameById(String client_ID);

 	/**
	 * 关联查询企业客户分页列表  chenyang
	 * @param pageTable
	 * @return
	 */
	public List<Client> relationQueryClient(PageTable pageTable);
	/**
	 * 
	 * @param pageTable
	 * @return
	 */
	public Long relationQueryClientCount(PageTable pageTable);
	/**
	 * 关联查询企业客户分页列表  chenyang
	 * @param pageTable
	 * @return
	 */
	public List<Client> relationQueryPerson(PageTable pageTable);
	/**
	 * 
	 * @param pageTable
	 * @return
	 */
	public Long relationQueryPersonCount(PageTable pageTable);
	
	/**
	 * 根据条件查询单个客户信息  
	 * xuyz 
	 * 商机管理受理申请时用 
	 */
	public Client selectOneClientByWheresql(String wheresql);
	/**
	 * 更改风险等级记录
	 * @param client
	 * @return
	 */
	public Integer updateRiskLevelByClient_ID(Client client);
	/**
	 * 更新企业所属的关联主体名称
	 */
	public Integer updateRelationMainName(Client client);
	
	
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
	int updateAllClientInfo(Client client);
	
	
}

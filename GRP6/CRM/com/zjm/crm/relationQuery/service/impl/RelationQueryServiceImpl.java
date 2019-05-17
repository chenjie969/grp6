package com.zjm.crm.relationQuery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_clientMapper;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.relationQuery.service.RelationQueryService;
import com.zjm.sys.clientCode.service.ClientCodeService;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.sys.users.service.UsersService;
import com.zjm.sys.util.RolesDataAccreditUtil;

/**
 * 关联查询实现
 * @author LiKM add 20170613
 *  
 */
@Service("relationQueryService")
@Transactional
public class RelationQueryServiceImpl implements RelationQueryService {
	@Resource
	private Crm_clientMapper crm_clientMapper;
	@Resource
	private UsersService usersService;
	@Resource
	private DepartsService departsService;
	
	@Resource
	private ClientCodeService clientCodeService;
	
	@Resource
	private LogService logService;
	

	/**
	 * 关联查询企业客户列表
	 * @param pageTable
	 * @return
	 */
	@Override
	public PageTable relationQueryClient(PageTable pageTable) {
		try {
			//根据权限传入sql 
//			String sql = RolesDataAccreditUtil.appendClientSqlByRole(pageTable.getQueryCondition().getUser_uid(),"c.");
//			if(null != sql){
//				pageTable.setWheresql(sql);
//			}
			String queryContent = pageTable.getQueryCondition().getQueryContent();
			pageTable.getQueryCondition().setQueryContent("%"+queryContent+"%");
			List<Client> list = crm_clientMapper.relationQueryClient(pageTable);//企业客户列表;
			Long total = crm_clientMapper.relationQueryClientCount(pageTable);
			pageTable.setRows(list);
			pageTable.setTotal(total);
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 关联查询企业客户列表
	 * @param pageTable
	 * @return
	 */
	@Override
	public PageTable relationQueryPerson(PageTable pageTable) {
		try {
//			String sql = RolesDataAccreditUtil.appendClientSqlByRole(pageTable.getQueryCondition().getUser_uid(),"c.");
//			if(null != sql){
//				pageTable.setWheresql(sql);
//			}
			String queryContent = pageTable.getQueryCondition().getQueryContent();
			pageTable.getQueryCondition().setQueryContent("%"+queryContent+"%");
			List<Client> list = crm_clientMapper.relationQueryPerson(pageTable);//个人客户列表
			Long total = crm_clientMapper.relationQueryPersonCount(pageTable);
			pageTable.setRows(list);
			pageTable.setTotal(total);
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

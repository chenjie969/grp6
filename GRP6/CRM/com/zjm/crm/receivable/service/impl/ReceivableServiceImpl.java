package com.zjm.crm.receivable.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_receivableMapper;
import com.zjm.crm.db.model.Crm_receivable;
import com.zjm.crm.receivable.service.ReceivableService;
import com.zjm.util.Tool;

/**
 * 应收账款
 * @author chenYang
 *  
 */
@Service("receivableService")
@Transactional
public class ReceivableServiceImpl implements ReceivableService {
	@Resource
	private Crm_receivableMapper crm_receivableMapper;
	@Resource
	private LogService logService;
	@Resource
	private ClientService clientService;
	
	/**
	 * 查询应收账款分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_receivable> selectReceivablePageTables(Crm_receivable receivable) {
		List<Crm_receivable> list = crm_receivableMapper.selectReceivablePageTables(receivable);
		PageTable<Crm_receivable> pageTable = new PageTable<>();
		pageTable.setRows(list);
		pageTable.setTotal((long) list.size());
		return pageTable;
	}
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	@Override
	public List<Crm_receivable> selectReceivableList(Crm_receivable receivable) {
		return crm_receivableMapper.selectReceivablePageTables(receivable);
	}
	
	/**
	 * 新增应收账款
	 * @param Crm_receivable
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneReceivableInfo(User user,Crm_receivable receivable) {
		receivable.setUpdateUserName(user.getUser_name());
		receivable.setUnit_uid(user.getUnit_uid());
		receivable.setUnit_uidName(user.getUnit_uidName());
		receivable.setReceivable_ID(Tool.createUUID32());
		if(crm_receivableMapper.insertOneReceivableInfo(receivable)){
			logService.insertOneOperatorLogInfo(user,"应收账款", "新增", "新增应收账款");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个应收账款
	 * @param Crm_receivable
	 * @return
	 */
	@Override
	public boolean deleteOneReceivableInfo(User user,String receivable_id) {
		if(crm_receivableMapper.deleteOneReceivableInfo(receivable_id)){
			logService.insertOneOperatorLogInfo(user,"应收账款", "删除", "删除应收账款");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询应收账款
	 * @param Crm_receivable
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_receivable selectOneReceivableInfo(Crm_receivable receivable) {
		return crm_receivableMapper.selectOneReceivableInfo(receivable);
	}

	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	@Override
	public Boolean updateOneReceivableInfo(User user,Crm_receivable receivable) {
		receivable.setUpdateUserName(user.getUser_name());
		if(crm_receivableMapper.updateOneReceivableInfo(receivable)){
			logService.insertOneOperatorLogInfo(user,"应收账款", "修改", "修改应收账款");
			return true;			
		}else{
			return false;
		}
	}

	@Override
	public List<Crm_receivable> selectReceivableListByWhereSql(String whereSql) {
		return 	crm_receivableMapper.selectReceivableListByWhereSql(whereSql);
	}

	@Override
	public Boolean deleteReceivableListByWhereSql(String whereSql) {
		try {
			int info = crm_receivableMapper.deleteReceivableListByWhereSql(whereSql);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

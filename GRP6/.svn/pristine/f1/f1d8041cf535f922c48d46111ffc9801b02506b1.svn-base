package com.zjm.crm.otherReceivable.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_otherReceivableMapper;
import com.zjm.crm.db.model.Crm_otherReceivable;
import com.zjm.crm.otherReceivable.service.OtherReceivableService;
import com.zjm.util.Tool;

/**
 * 应收账款
 * @author chenYang
 *  
 */
@Service("otherReceivableService")
@Transactional
public class OtherReceivableServiceImpl implements OtherReceivableService {
	@Resource
	private Crm_otherReceivableMapper crm_otherReceivableMapper;
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
	public PageTable<Crm_otherReceivable> selectOtherReceivablePageTables(Crm_otherReceivable otherReceivable) {
		List<Crm_otherReceivable> list = crm_otherReceivableMapper.selectOtherReceivablePageTables(otherReceivable);
		PageTable<Crm_otherReceivable> pageTable = new PageTable<>();
		pageTable.setRows(list);
		pageTable.setTotal((long) list.size());
		return pageTable;
	}
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_otherReceivable> selectOtherReceivableList(Crm_otherReceivable otherReceivable){
		return crm_otherReceivableMapper.selectOtherReceivablePageTables(otherReceivable);
	}
	
	/**
	 * 新增应收账款
	 * @param Crm_otherReceivable
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneOtherReceivableInfo(User user,Crm_otherReceivable otherReceivable) {
		otherReceivable.setUpdateUserName(user.getUser_name());
		otherReceivable.setUnit_uid(user.getUnit_uid());
		otherReceivable.setUnit_uidName(user.getUnit_uidName());
		otherReceivable.setOtherReceivable_ID(Tool.createUUID32());
		if(crm_otherReceivableMapper.insertOneOtherReceivableInfo(otherReceivable)){
			logService.insertOneOperatorLogInfo(user,"应收账款", "新增", "新增应收账款");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个应收账款
	 * @param Crm_otherReceivable
	 * @return
	 */
	@Override
	public boolean deleteOneOtherReceivableInfo(User user,String relation_id) {
		if(crm_otherReceivableMapper.deleteOneOtherReceivableInfo(relation_id)){
			logService.insertOneOperatorLogInfo(user,"应收账款", "删除", "删除应收账款");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询应收账款
	 * @param Crm_otherReceivable
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_otherReceivable selectOneOtherReceivableInfo(Crm_otherReceivable otherReceivable) {
		return crm_otherReceivableMapper.selectOneOtherReceivableInfo(otherReceivable);
	}

	/**
	 * 
	 * @description 修改 更新应收账款信息  
	 * @author chenyang
	 */
	@Override
	public Boolean updateOneOtherReceivableInfo(User user,Crm_otherReceivable otherReceivable) {
		otherReceivable.setUpdateUserName(user.getUser_name());
		if(crm_otherReceivableMapper.updateOneOtherReceivableInfo(otherReceivable)){
			logService.insertOneOperatorLogInfo(user,"应收账款", "修改", "修改应收账款");
			return true;			
		}else{
			return false;
		}
	}

	@Override
	public Boolean deleteOtherReceivableByClient_ID(String client_ID) {
		try {
			int info = crm_otherReceivableMapper.deleteOtherReceivableByClient_ID(client_ID);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

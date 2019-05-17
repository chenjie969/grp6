package com.zjm.crm.guarantyRec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_guarantyRecMapper;
import com.zjm.crm.db.model.Crm_guarantyRec;
import com.zjm.crm.guarantyRec.service.GuarantyRecService;
import com.zjm.util.Tool;

@Service("guarantyRecService")
@Transactional
public class GuarantyRecServiceImpl implements GuarantyRecService {

	@Resource
	private Crm_guarantyRecMapper guarantyRecMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 查询对外担保列表
	 */
	@Override
	public PageTable<Crm_guarantyRec> selectGuarantyRecPageTable(PageTable<Crm_guarantyRec> pageTable) {
		/* 带分页
		 * Long guarantyRecTotal = guarantyRecMapper.selectGuarantyRecPageTable_Count(pageTable);
		pageTable.setTotal(guarantyRecTotal);
		List<Crm_guarantyRec> guarantyRecList = guarantyRecMapper.selectGuarantyRecPageTable(pageTable);*/
		
		List<Crm_guarantyRec> guarantyRecList = guarantyRecMapper.selectGuarantyRecList(pageTable);	//不分页
		pageTable.setRows(guarantyRecList);
		return pageTable;
	}
	
	/**
	 * 查询对外担保
	 */
	public List<Crm_guarantyRec> selectGuarantyRecList(String wheresql){
		try {
			return guarantyRecMapper.selectGuarantyRecListByWheresql(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  查询一条对外担保
	 */
	@Override
	public Crm_guarantyRec selectOneGuarantyRec(Crm_guarantyRec guarantyRec) {
		return guarantyRecMapper.selectOneGuarantyRec(guarantyRec);
	}
	
	/**
	 *  插入一条对外担保
	 */
	@Override
	public Boolean insertOneGuarantyRec(User user,Crm_guarantyRec guarantyRec) {
		guarantyRec.setGuarantyRec_ID(Tool.createUUID32());
		guarantyRec.setUnit_uid(user.getUnit_uid());
		guarantyRec.setUnit_uidName(user.getUnit_uidName());
		guarantyRec.setUpdateUserName(user.getUser_name());
		if(guarantyRecMapper.insertOneGuarantyRec(guarantyRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "添加", "添加对外担保-"+guarantyRec.getGuarantyUnit());
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  修改一条对外担保
	 */
	@Override
	public Boolean updateOneGuarantyRec(User user,Crm_guarantyRec guarantyRec) {
		guarantyRec.setUpdateUserName(user.getUser_name());
		if(guarantyRecMapper.updateOneGuarantyRec(guarantyRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "修改","修改对外担保-"+guarantyRec.getGuarantyUnit());
			return true;
		}else
			return false;
	}
	
	/**
	 *  删除一条对外担保
	 */
	@Override
	public Boolean deleteOneGuarantyRec(User user,Crm_guarantyRec guarantyRec) {
		guarantyRec = selectOneGuarantyRec(guarantyRec);
		if(guarantyRecMapper.deleteOneGuarantyRec(guarantyRec)==1){
			logService.insertOneOperatorLogInfo(user, "企业主要负债情况", "删除", "删除对外担保-"+guarantyRec.getGuarantyUnit());
			return true;
		}else
			return false;
	}

	@Override
	public Boolean deleteGuarantyRecByClient_ID(String client_ID) {
		try {
			int deleteGuarantyRecByClient_ID = guarantyRecMapper.deleteGuarantyRecByClient_ID(client_ID);
			if( deleteGuarantyRecByClient_ID > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

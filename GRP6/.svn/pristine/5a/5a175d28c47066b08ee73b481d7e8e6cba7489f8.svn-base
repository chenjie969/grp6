package com.zjm.crm.selfHouse.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.db.map.Crm_selfHouseMapper;
import com.zjm.crm.db.model.Crm_selfHouse;
import com.zjm.crm.selfHouse.service.SelfHouseService;
import com.zjm.util.Tool;

/**
 * 自有住房
 * @author chenyang add 20170505
 *  
 */
@Service("selfHouseService")
@Transactional
public class SelfHouseServiceImpl implements SelfHouseService {
	@Resource
	private Crm_selfHouseMapper crm_selfHouseMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 查询自有住房列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_selfHouse> selectSelfHouseInfoPageTables(Crm_selfHouse selfHouse) {
		List<Crm_selfHouse> cList = crm_selfHouseMapper.selectSelfHouseInfoPageTables(selfHouse);
		//Long total=crm_selfHouseMapper.selectClientPageTables_Count(pageTable);
		PageTable<Crm_selfHouse> pageTable = new PageTable<>();
		pageTable.setRows(cList);
		pageTable.setTotal((long) cList.size());
		return pageTable;
	}
	
	
	/**
	 * 新增自有住房
	 * @param Crm_selfHouse
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneSelfHouseInfo(User user,Crm_selfHouse selfHouse) {
		selfHouse.setUpdateUserName(user.getUser_name());
		selfHouse.setUnit_uid(user.getUnit_uid());
		selfHouse.setSelfHosuse_ID(Tool.createUUID32());
		if(crm_selfHouseMapper.insertOneSelfHouseInfo(selfHouse)){
			logService.insertOneOperatorLogInfo(user,"自有住房", "新增", "新增自有住房信息");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个自有住房
	 * @param Crm_selfHouse
	 * @return
	 */
	@Override
	public boolean deleteOneSelfHouseInfo(User user,Crm_selfHouse selfHouse) {
		if(crm_selfHouseMapper.deleteOneSelfHouseInfo(selfHouse)){
			logService.insertOneOperatorLogInfo(user,"自有住房", "删除", "删除自有住房信息");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询自有住房
	 * @param Crm_selfHouse
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_selfHouse selectOneSelfHouseInfo(Crm_selfHouse selfHouse) {
		return crm_selfHouseMapper.selectOneSelfHouseInfo(selfHouse);
	}

	/**
	 * 
	 * @description 修改 更新自有住房信息  
	 * @author chenyang
	 * @date 2017年5月5日 下午7:14:03
	 */
	
	@Override
	public Boolean updateOneSelfHouseInfo(User user,Crm_selfHouse selfHouse) {
		Crm_selfHouse selfHouse2 =new Crm_selfHouse();
		selfHouse2= this.selectOneSelfHouseInfo(selfHouse);
		if(selfHouse2!=null){
		selfHouse2.setUpdateUserName(user.getUser_name());
		
		if(crm_selfHouseMapper.updateOneSelfHouseInfo(selfHouse)){
			logService.insertOneOperatorLogInfo(user,"自有住房", "修改", "修改自有住房信息");
			return true;			
		}else{
			return false;
		}
		}
		return false;
	}


	@Override
	public List<Crm_selfHouse> selectSelfHouseListByClient_ID(String client_ID) {
		return crm_selfHouseMapper.selectSelfHouseListByClient_ID(client_ID);
	}


	@Override
	public Boolean deleteSelfHouseByClient_ID(String client_ID) {
		try {
			int deleteSelfHouseByClient_ID = crm_selfHouseMapper.deleteSelfHouseByClient_ID(client_ID);
			if(deleteSelfHouseByClient_ID > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

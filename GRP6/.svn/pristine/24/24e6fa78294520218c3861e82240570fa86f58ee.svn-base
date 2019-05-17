package com.zjm.crm.landHouse.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_landHouseMapper;
import com.zjm.crm.db.model.Crm_landHouse;
import com.zjm.crm.landHouse.service.LandHouseService;
import com.zjm.util.Tool;

/**
 * 住宅
 * @author chenYang
 *  
 */
@Service("landHouseService")
@Transactional
public class LandHouseServiceImpl implements LandHouseService {
	@Resource
	private Crm_landHouseMapper crm_landHouseMapper;
	@Resource
	private LogService logService;
	@Resource
	private ClientService clientService;
	
	/**
	 * 查询住宅分页列表
	 * @param pageTable
	 * @author chenyang
	 * @return
	 */
	public PageTable<Crm_landHouse> selectLandHousePageTables(Crm_landHouse landHouse) {
		List<Crm_landHouse> list = crm_landHouseMapper.selectLandHousePageTables(landHouse);
		PageTable<Crm_landHouse> pageTable = new PageTable<>();
		pageTable.setRows(list);
		pageTable.setTotal((long) list.size());
		return pageTable;
	}
	
	/**
	 * 查询应收账户列表  不分页
	 * @author xuyz
	 * @return
	 */
	public List<Crm_landHouse> selectLandHouseList(Crm_landHouse landHouse){
		return crm_landHouseMapper.selectLandHousePageTables(landHouse);
	}
	
	/**
	 * 新增住宅
	 * @param Crm_landHouse
	 * @author chenyang
	 * @return
	 */
	@Override
	public Boolean insertOneLandHouseInfo(User user,Crm_landHouse landHouse) {
		landHouse.setUpdateUserName(user.getUser_name());
		landHouse.setUnit_uid(user.getUnit_uid());
		landHouse.setUnit_uidName(user.getUnit_uidName());
		landHouse.setLandHouse_ID(Tool.createUUID32());
		if(crm_landHouseMapper.insertOneLandHouseInfo(landHouse)){
			logService.insertOneOperatorLogInfo(user,"住宅", "新增", "新增住宅");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *	删除一个住宅
	 * @param Crm_landHouse
	 * @return
	 */
	@Override
	public boolean deleteOneLandHouseInfo(User user,String landHouse_id) {
		if(crm_landHouseMapper.deleteOneLandHouseInfo(landHouse_id)){
			logService.insertOneOperatorLogInfo(user,"住宅", "删除", "删除住宅");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 *查询住宅
	 * @param Crm_landHouse
	 * @author chenyang
	 * @return
	 */
	@Override
	public Crm_landHouse selectOneLandHouseInfo(Crm_landHouse landHouse) {
		return crm_landHouseMapper.selectOneLandHouseInfo(landHouse);
	}

	/**
	 * 
	 * @description 修改 更新住宅信息  
	 * @author chenyang
	 */
	@Override
	public Boolean updateOneLandHouseInfo(User user,Crm_landHouse landHouse) {
		landHouse.setUpdateUserName(user.getUser_name());
		if(crm_landHouseMapper.updateOneLandHouseInfo(landHouse)){
			logService.insertOneOperatorLogInfo(user,"住宅", "修改", "修改住宅");
			return true;			
		}else{
			return false;
		}
	}

	@Override
	public Boolean deleteLandHouseByClient_ID(String client_ID) {
		try {
			int info = crm_landHouseMapper.deleteLandHouseByClient_ID(client_ID);
			if(info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

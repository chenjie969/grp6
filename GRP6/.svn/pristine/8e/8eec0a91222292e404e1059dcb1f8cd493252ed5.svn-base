package com.zjm.pro.projectPackage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.map.Pro_packageMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_package;
import com.zjm.pro.projectPackage.service.PackageService;
import com.zjm.util.Tool;

@Service("packageService")
@Transactional
public class PackageServiceImpl implements PackageService {

	@Resource
	private Pro_packageMapper pro_packageMapper;
	
	@Resource
	private ProjectApplyService projectApplyService;
	
	@Resource
	private LogService logService;

	/**
	 * 查询打包项目列表
	 */
	@Override
	public PageTable selectPackagePageTables(PageTable pageTable) {
		List<Pro_package> packageList = pro_packageMapper.selectPackagePageTables(pageTable);
		Long total = pro_packageMapper.selectPackagePageTables_Count(pageTable);
		pageTable.setRows(packageList);
		pageTable.setTotal(total);
		return pageTable;
	}

	public Boolean insertOnePackageInfo(User user, Pro_package pro_package) {
		try {
			pro_package.setPackage_ID(Tool.createUUID32());
			pro_package.setCreateManName(user.getUser_name());//设置更新人名称;
			pro_package.setCreateManID(user.getUser_id());//设置更新人ID;
			pro_package.setUnit_uid(user.getUnit_uid());//设置担保机构id
			pro_package.setUnit_uidName(user.getUnit_uidName());//设置担保机构名称;			
			if(pro_packageMapper.insertOnePackageInfo(pro_package) == 1){
				logService.insertOneOperatorLogInfo(user,"打包项目", "新增打包", "打包表信息");
				//更新申请表信息
			  	String[] applyIDArray = pro_package.getApplyIDS().split(",");
		        for (int i = 0; i < applyIDArray.length; i++) {
		        	String whereSql = " and apply_ID = \'"+applyIDArray[i]+"\'";
		    		//根据apply_ID查询Pro_apply表信息;	
		    		Pro_apply apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
		    		apply.setIsPackage(1);
		    		apply.setPackage_ID(pro_package.getPackage_ID());
		    		projectApplyService.updateOneApplyInfo(user, apply);
		        }
			  
			  return true;
		  }
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return false;
		
	}

	/*
	 * 获取一个打包信息
	 * 
	 * */
	public Pro_package selectOnePackageByWhereSql(String wheresql) {
		Pro_package pro_package = new Pro_package();
		try {
			pro_package = pro_packageMapper.selectOnePackageWhereSql(wheresql);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return pro_package;
	}
	
	/*
	 * 获取一个打包信息
	 * 
	 * */
	public List<Pro_apply> selectApplyListByPackageID(String wheresql) {
		List<Pro_apply> applyList = new ArrayList<>();
		try {
			applyList = projectApplyService.selectApplyListByPackageID(wheresql);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return applyList;
	}
	
	/**
	 * 修改
	 */
	public Boolean updateOnePackageInfo(User user, Pro_package pro_package) {
		return false;
	}

	public Boolean delOnePackageInfo(User user, String package_ID) {
		try {
			//根据包ID更新申请表信息
			pro_packageMapper.updateIsPackageInfo(package_ID);
			return pro_packageMapper.delOnePackageInfo(package_ID) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 上会审批--根据ID修改isArrangeMeeting
	@Override
	public int updateIsArrangeMeetingById(PageTable<Pro_package> pageTable) {
		return pro_packageMapper.updateIsArrangeMeetingById(pageTable);
	}

	// 上会审批--根据ID修改isArrangeMeeting
	@Override
	public int updateIsArrangeMeetingByIds(PageTable<Pro_package> pageTable) {
		return pro_packageMapper.updateIsArrangeMeetingByIds(pageTable);
	}
}

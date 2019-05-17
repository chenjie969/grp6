package com.zjm.pro.projectPackage.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_package;

public interface PackageService {
	/***
	 *  打包信息表 分页列表
	 * @param pageTable
	 * @return
	 */
	public PageTable selectPackagePageTables(PageTable pageTable);
	
	/**
	 * 插入一个打包表信息
	 * @param 
	 * @return
	 */
	public Boolean insertOnePackageInfo(User user,Pro_package pro_package);
	/**
	 * 根据wheresql查询一个打包表信息
	 * @param wheresql:
	 * @return
	 */
	public Pro_package selectOnePackageByWhereSql(String wheresql);
	/**
	 * 查询一个打包项目下子项目信息
	 * @param wheresql:
	 * @return
	 */
	public List<Pro_apply> selectApplyListByPackageID(String wheresql);
	/**
	 * 更新一个打包表信息
	 * @param Pro_package
	 * @return
	 */
	public Boolean updateOnePackageInfo(User user,Pro_package pro_package);
	/**
	 * 删除一个打包表信息
	 * @return
	 */
	public Boolean delOnePackageInfo(User user,String package_ID);
	//上会审批--修改
	public int updateIsArrangeMeetingById(PageTable<Pro_package> pageTable);
	//申请记录--撤销
	public int updateIsArrangeMeetingByIds(PageTable<Pro_package> pageTable);
	
	
}

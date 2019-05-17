package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_package;
/**
 * 打包表 映射mapper
 * @author chenYang
 * @time 2017-7-5;
 */
public interface Pro_packageMapper {

	/**
	 * 返回打包表分页列表
	 * @param pageTable
	 * @author chenYang
	 * @return
	 */
	public List<Pro_package> selectPackagePageTables(PageTable<Pro_package> pageTable);	
	
	/**
	 * 查询打包表分页列表   总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectPackagePageTables_Count(PageTable<Pro_package> pageTable);
	
	/**
	 * @description  打包
	 */
	public Integer insertOnePackageInfo(Pro_package pro_package);
	
	/**
	 * 更新 打包信息
	 * @description
	 */
	public Integer updateOnePackageInfo(Pro_package pro_package);
	
	/**
	 * 删除一个 打包信息
	 * @return
	 */
	public Integer delOnePackageInfo(String package_ID);
	
	/**
	 * 根据packgeID更新apply表信息
	 * @return
	 */
	public Integer updateIsPackageInfo(String package_ID);
	
	/**
	 * 根据wheresql查询一个打包信息
	 * @param wheresql:
	 * @return
	 */
	public Pro_package selectOnePackageWhereSql(String wheresql);
	//上会审批--根据ID修改isArrangeMeeting
	public int updateIsArrangeMeetingById(PageTable<Pro_package> pageTable);
	//上会审批--根据ID修改isArrangeMeeting
	public int updateIsArrangeMeetingByIds(PageTable<Pro_package> pageTable);
}

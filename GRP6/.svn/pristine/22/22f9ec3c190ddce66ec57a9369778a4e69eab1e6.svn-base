package com.zjm.sys.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_units;
/**
 * 机构设置
 * @author duanhuawei add 20170425
 */
public interface Sys_unitsMapper {
    /**
	 * 查询同级节点下共有多少机构
	 * @return
	 */
    public Integer selectUnitsOrderId(Sys_units sys_units);
	/**
	 * 插入一个担保机构
	 * @param sys_units
	 * @return
	 */
	public Integer insertOneUnitsInfo(Sys_units sys_units);
	/**
	 * 查询所有担保机构
	 * @param wheresql
	 * @return
	 */
	public List<Sys_units> selectAllUnitsList(String wheresql);
	/**
	 * 查询机构列表数据
	 * @param pageTable
	 * @return
	 */
	public List<Sys_units> selectUnitsPageTables(PageTable pageTable);
	/**
	 * 查询机构列表行数
	 * @param pageTable
	 * @return
	 */
	public Long selectUnitsPageTables_Count(PageTable pageTable);
	/**
	 * 查询一个担保机构
	 * @param sys_units
	 * @return
	 */
	public Sys_units selectOneUnitsInfo(Sys_units sys_units);
	/**
	 * 查询一个父机构
	 * @return
	 */
	public Sys_units selectPUnitsInfo(Sys_units sys_units);
	
	/**
	 * 更新一个担保机构
	 * @param sys_units
	 * @return
	 */
	public Integer updateOneUnitsInfo(Sys_units sys_units);
	/**
	 * 删除一个机构
	 * @param sys_units2
	 */
	public Integer deleteOneUnitsInfo(Sys_units sys_units2);
	/**
	 * 查看机构名称是否存在
	 * @param wheresql
	 * @return
	 */
	public Integer selectUnitsIsExist(String wheresql);
}
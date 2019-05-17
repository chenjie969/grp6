package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_arcMove;
/**
 * 档案移交表pro_arcMove映射mapper
 * @author zky
 *
 */
public interface Pro_arcMoveMapper {

	/**
	 * 
	 * @Title: insertOneArvMoveInfo   
	 * @Description:  新增 档案
	 * @param: @param arvMove
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer insertOneArcMoveInfo(Pro_arcMove arcMove);
	
	/**
	 * 
	 * @Title: updateOneArcMovetInfo   
	 * @Description: 更新 档案信息表
	 * @param: @param arcMove
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer updateOneArcMoveInfo(Pro_arcMove arcMove);
	/**
	 * @Title: selectOneArcMoveByWhereSql   
	 * @Description: 根据wheresql查询一个档案信息
	 * @param: @param wheresql
	 * @param: @return      
	 * @return: Pro_arcMove      
	 * @throws
	 */
	public Pro_arcMove selectOneArcMoveByWhereSql(String wheresql);
	/**
	 * 
	 * @Title: selectArcMoveListByWhereSql   
	 * @Description: 根据wheresql查询多个档案信息
	 * @param: @param wheresql
	 * @param: @return      
	 * @return: List<Pro_arcMove>      
	 * @throws
	 */
	public List<Pro_arcMove> selectArcMoveListByWhereSql(String wheresql);
	/**
	 * 
	 * @Title: deleteOneArcMoveByWhereSql   
	 * @Description:  删除单个档案信息
	 * @param: @param string
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer deleteOneArcMoveByWhereSql(String string);
    /**
     * 
     * @Title: selectArcMovePageTables   
     * @Description: 查询档案列表
     * @param: @param pageTable
     * @param: @return      
     * @return: List<Pro_arcMove>      
     * @throws
     */
	public List<Pro_arcMove> selectArcMovePageTables(PageTable pageTable);
    /**
     * 
     * @Title: selectArcMovePageTables_Count   
     * @Description: 查询档案列表 总条数
     * @param: @param pageTable
     * @param: @return      
     * @return: Long      
     * @throws
     */
	public Long selectArcMovePageTables_Count(PageTable pageTable);
}

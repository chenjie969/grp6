package com.zjm.pro.arcMove.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_arcMove;
/**
 * 档案移交表pro_arcMove service 
 * @author sky
 *
 */
public interface ArcMoveService {
	
	
	/**
	 * 
	 * @Title: selectArcMovePageTables   
	 * @Description: 查询档案table列表
	 * @param: @param pageTable
	 * @param: @return      
	 * @return: PageTable      
	 * @throws
	 */
	public PageTable selectArcMovePageTables(PageTable pageTable);
	/**
	 * @Title: insertOneArcMoveInfo   
	 * @Description: 插入一个档案信息
	 * @param: @param user
	 * @param: @param arcMove
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean insertOneArcMoveInfo(User user,Pro_arcMove arcMove);
	/**
	 * 
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
	 * @Title: updateOneArcMoveInfo   
	 * @Description: 更新一个档案信息
	 * @param: @param user
	 * @param: @param arcMove
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean updateOneArcMoveInfo(User user,Pro_arcMove arcMove);
	
	
	/**
	 * 
	 * @Title: selectArcMovetListByWhereSql   
	 * @Description: 根据wheresql查询档案信息list
	 * @param: @param wheresql
	 * @param: @return      
	 * @return: List<Pro_arcMove>      
	 * @throws
	 */
	public List<Pro_arcMove> selectArcMoveListByWhereSql(String wheresql);
	/**
	 * 
	 * @Title: deleteOneArcMoveInfo   
	 * @Description: 删除单个档案信息
	 * @param: @param user
	 * @param: @param arcMove
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public  Boolean deleteOneArcMoveInfo(User user,Pro_arcMove arcMove);
	/**
	 * 移交档案-更新新增档案状态为已移交
	 * @param userSession
	 * @param pro_arcMove
	 * @return
	 */
	public Boolean turnArcMove(User userSession, Pro_arcMove pro_arcMove);
	/**
	 * 确认接收
	 * @param userSession
	 * @param pro_arcMove
	 * @return
	 */
	public Boolean arcMoveAccept(User userSession, Pro_arcMove pro_arcMove);
	/**
	 * 批量新增档案
	 * @param userSession
	 * @param pro_arcMove
	 * @return
	 */
	public Boolean insertArcMoves(User userSession, Pro_arcMove pro_arcMove);
	
	
	
	
}

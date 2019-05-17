package com.zjm.pro.arcMoveRec.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_arcMoveRec;
/**
 * 档案移交记录表pro_arcMoveRec service 
 * @author sky
 *
 */
public interface ArcMoveRecService {
	
	
	/**
	 * 
	 * @Title: selectArcMoveRecPageTables   
	 * @Description: 查询档案记录table列表
	 * @param: @param pageTable
	 * @param: @return      
	 * @return: PageTable      
	 * @throws
	 */
	public PageTable selectArcMoveRecPageTables(PageTable pageTable);
	/**
	 * @Title: insertOneArcMoveRecInfo   
	 * @Description: 插入一个档案记录信息
	 * @param: @param user
	 * @param: @param arcMoveRec
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean insertOneArcMoveRecInfo(User user,Pro_arcMoveRec arcMoveRec);
	/**
	 * 
	 * @Title: selectOneArcMoveRecByWhereSql   
	 * @Description: 根据wheresql查询一个档案信息
	 * @param: @param wheresql
	 * @param: @return      
	 * @return: Pro_arcMoveRec     
	 * @throws
	 */
	public Pro_arcMoveRec selectOneArcMoveRecByWhereSql(String wheresql);
	/**
	 * 
	 * @Title: updateOneArcMoveRecInfo   
	 * @Description: 更新一个档案记录信息
	 * @param: @param user
	 * @param: @param arcMoveRec
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean updateOneArcMoveRecInfo(User user,Pro_arcMoveRec arcMoveRec);
	
	
	/**
	 * 
	 * @Title: selectArcMoveRecListByWhereSql   
	 * @Description: 根据wheresql查询档案记录信息list
	 * @param: @param wheresql
	 * @param: @return      
	 * @return: List<Pro_arcMoveRec>      
	 * @throws
	 */
	public List<Pro_arcMoveRec> selectArcMoveRecListByWhereSql(String wheresql);
	/**
	 * 
	 * @Title: deleteOneArcMoveRecInfo   
	 * @Description: 删除单个档案记录信息
	 * @param: @param user
	 * @param: @param arcMoveRec
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public  Boolean deleteOneArcMoveRecInfo(User user,Pro_arcMoveRec arcMoveRec);
	
	
	
	
}

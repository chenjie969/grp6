package com.zjm.pro.db.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_projectfiles;

/**
 * @description	项目附件表Pro_projectfilesMapper
 * @author wuhn
 * @date 2017年8月1日 10:46:44
 */
public interface Pro_projectfilesMapper {
	
	/**
	 * @description	 根据主键id执行删除 projectFiles_ID
	 * @author wuhn
	 * @date 2017年8月1日 上午10:41:10
	 */
    int deleteOneInfoByProFiles_ID(String projectFiles_ID);
    
    /**
     * @description	 根据实体id执行删除  entityID
     * @author wuhn
     * @date 2017年8月1日 上午10:42:57
     */
    int deleteProFilesInfoByEntityID(String entityID);
   
    /**
     * @description	添加一条项目附件
     * @author wuhn
     * @date 2017年8月1日 上午10:43:51
     */
    int insertOneProFilesInfo(Pro_projectfiles projectfiles);
    
    /**
     * @description	根据 项目 projectFiles_ID  获取项目附件信息
     * @author wuhn
     * @date 2017年8月1日 上午10:44:30
     */
    Pro_projectfiles selectOneProFilesInfo(String projectFiles_ID);
    
    /**
     * @description	根据 项目 entityID  获取项目附件信息
     * @author wuhn
     * @date 2017年8月1日 上午10:45:30
     */
    List<Pro_projectfiles> selectProFilesListByEntityID(String entityID);
    
    /**
     * 检查附件
     */
    List<Pro_projectfiles> selectProFilesListByCheckPlanID(String checkPlan_ID);
    
    /**
     * @description	  项目附件分页列表
     * @author wuhn
     * @date 2017年8月10日 下午2:44:15
     */
    List<Pro_projectfiles>  selectProjectFilesPageTables(PageTable<Pro_projectfiles>  pageTable);
    
    /**
     * @description	 项目附件 总记录数
     * @author wuhn
     * @date 2017年8月10日 下午2:45:08
     */
    int  selectProjectFilesPageTables_Count(PageTable<Pro_projectfiles>  pageTable);
    /**
     * @param whereSql
     * @return 删除附件
     */
    Integer deleteOneProFilesByEntityID(String whereSql);
	/**
	 * @param entityID
	 * @return 根据entityID查询一对一的附件信息
	 */
	Pro_projectfiles selectOneProFilesByEntityID(String whereSql);
	
	  /**
     * 根据 项目entityID 和 sql获取项目附件信息
     * @param entityID
     * @param wheresql
     * @return
     */
    List<Pro_projectfiles> selectProFilesListByEntityIDType(@Param("entityID") String entityID ,@Param("wheresql")String wheresql);

    /**
     * 根据sql查询列表
     * @param whereSql
     * @return
     */
	List<Pro_projectfiles> selectListProFilesByWhereSql(String whereSql);
}
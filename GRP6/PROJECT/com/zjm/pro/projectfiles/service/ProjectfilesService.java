package com.zjm.pro.projectfiles.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_projectfiles;

/**
 * @description    项目附件service
 * @company http://www.igit.com.cn/  
 * @author wuhn	
 * @date 2017年8月1日 上午10:54:50
*/
public interface ProjectfilesService {
	
	/**
	 * @description	 根据主键id执行删除 projectFiles_ID
	 * @author wuhn
	 * @date 2017年8月1日 上午10:41:10
	 */
    Boolean deleteOneInfoByProFiles_ID(User user,String projectFiles_ID);
    
    /**
     * @description	 根据实体id执行删除  entityID
     * @author wuhn
     * @date 2017年8月1日 上午10:42:57
     */
    Boolean deleteProFilesInfoByEntityID(User user,String entityID);
   
    /**
     * @description	添加一条项目附件
     * @author wuhn
     * @date 2017年8月1日 上午10:43:51
     */
    Boolean insertOneProFilesInfo(User user,Pro_projectfiles projectfiles);
    
    /**
     * @description	根据 项目 projectFiles_ID  获取项目附件信息
     * @author wuhn
     * @date 2017年8月1日 上午10:44:30
     */
    Pro_projectfiles selectOneProFilesInfo(User user,String projectFiles_ID);
    
    /**
     * @description	根据 项目 entityID  获取项目附件信息
     * @author wuhn
     * @date 2017年8月1日 上午10:45:30
     */
    List<Pro_projectfiles> selectProFilesListByEntityID(User user,String entityID);
    
    /**
     * @description	根据 项目 获取检查附件信息
     * @
     */
    
    List<Pro_projectfiles> selectProFilesListByCheckPlanID(User user,String checkPlan_ID);
    /**
     * @description	  项目附件分页列表
     * @author wuhn
     * @date 2017年8月10日 下午2:44:15
     */
    PageTable<Pro_projectfiles>  selectProjectFilesPageTables(PageTable<Pro_projectfiles>  pageTable);
    
    /**
     * @description	 项目附件 总记录数
     * @author wuhn
     * @date 2017年8月10日 下午2:45:08
     */
    int  selectProjectFilesPageTables_Count(PageTable<Pro_projectfiles>  pageTable);

	/**
	 * @param userSession
	 * @param entityID
	 * @return 根据entityID查询一对一的附件信息
	 */
	Pro_projectfiles selectOneProFilesByEntityID(String whereSql);
	
	/**
	 * 根据sql查询列表
	 * @param whereSql
	 * @return
	 */
	List<Pro_projectfiles> selectListProFilesByWhereSql(String whereSql);
	
}

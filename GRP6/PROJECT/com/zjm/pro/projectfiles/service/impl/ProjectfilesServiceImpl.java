package com.zjm.pro.projectfiles.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.projectfiles.service.ProjectfilesService;

/**
 * @description    
 * @company http://www.igit.com.cn/  
 * @author wuhn	
 * @date 2017年8月1日 上午10:56:50
*/
@Service(value="projectfilesService")
@Transactional
public class ProjectfilesServiceImpl implements ProjectfilesService {
	
	@Resource
	private Pro_projectfilesMapper  pro_projectfilesMapper ;
	
	@Resource
	private LogService  logService;

	@Override
	public Boolean deleteOneInfoByProFiles_ID(User user, String projectFiles_ID) {
		try {
				int info = pro_projectfilesMapper.deleteOneInfoByProFiles_ID(projectFiles_ID);
				if(info > 0){
					logService.insertOneOperatorLogInfo(user, "项目附件表", "删除", "删除项目附件");
					return true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteProFilesInfoByEntityID(User user, String entityID) {
		
		try {
			  int	info = pro_projectfilesMapper.deleteProFilesInfoByEntityID(entityID);
			  if(info > 0){
				  logService.insertOneOperatorLogInfo(user, "项目附件表", "删除", "删除项目附件");
				  return true;
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean insertOneProFilesInfo(User user, Pro_projectfiles projectfiles) {
		try {
				int info = pro_projectfilesMapper.insertOneProFilesInfo(projectfiles);
				if(info > 0){
					logService.insertOneOperatorLogInfo(user, "项目附件表", "添加", "添加项目附件");
					return true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public Pro_projectfiles selectOneProFilesInfo(User user, String projectFiles_ID) {
		return pro_projectfilesMapper.selectOneProFilesInfo(projectFiles_ID);
	}

	@Override
	public List<Pro_projectfiles> selectProFilesListByEntityID(User user, String entityID) {
		return pro_projectfilesMapper.selectProFilesListByEntityID(entityID);
	}
	@Override
	public List<Pro_projectfiles> selectProFilesListByCheckPlanID(User user, String checkPlan_ID) {
		return pro_projectfilesMapper.selectProFilesListByCheckPlanID(checkPlan_ID);
	}
	@Override
	public PageTable<Pro_projectfiles> selectProjectFilesPageTables(PageTable<Pro_projectfiles> pageTable) {
			List<Pro_projectfiles> list=null;
			int total=0;
			try {
				list = pro_projectfilesMapper.selectProjectFilesPageTables(pageTable);
				total = pro_projectfilesMapper.selectProjectFilesPageTables_Count(pageTable);
			} catch (Exception e) {
				e.printStackTrace();
			}
			pageTable.setRows(list);
			pageTable.setTotal(Long.valueOf(total));
			
			return pageTable;
	}

	@Override
	public int selectProjectFilesPageTables_Count(PageTable<Pro_projectfiles> pageTable) {
		return 0;
	}
	//根据entityID查询一对一的附件信息
	@Override
	public Pro_projectfiles selectOneProFilesByEntityID( String whereSql) {
		try {
			return pro_projectfilesMapper.selectOneProFilesByEntityID(whereSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Pro_projectfiles> selectListProFilesByWhereSql(String whereSql) {
		try {
			return pro_projectfilesMapper.selectListProFilesByWhereSql(whereSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}

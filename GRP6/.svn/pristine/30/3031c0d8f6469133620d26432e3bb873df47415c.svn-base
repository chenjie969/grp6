package com.zjm.oa.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.common.service.OaFileService;
import com.zjm.oa.db.map.Oa_filesMapper;
import com.zjm.oa.db.model.Oa_files;

@Service
@Transactional
public class OaFileServiceImpl implements OaFileService {
    @Resource
    private Oa_filesMapper mapper;

    @Override
    public boolean insert(Oa_files entity) {
        return new Integer(1).equals(mapper.insert(entity));
    }

    @Override
    public List<Oa_files> selectByRef(Oa_files example) {
        return mapper.selectByRef(example);
    }

    @Override
    public Boolean delete(String files_ID) {
        return new Integer(1).equals(mapper.delete(files_ID));
    }
    
    /**
     * 根据实体ID查询其下的附件列表 
     */
    @Override
    public PageTable<Oa_files> selectUploadedFilesPageTables(PageTable<Oa_files> pageTable){
    	try {
    		pageTable.setWheresql(" and entityID='"+pageTable.getUploadParam().getEntityID()+"'");
        	List<Oa_files> fileList = mapper.selectUploadedFilesPageTables(pageTable);
        	pageTable.setRows(fileList);
        	Long total = mapper.selectUploadedFiles_count(pageTable);
        	pageTable.setTotal(total);
        	return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 批量删除信息时,查询多个实体下的所有附件,用于物理删除文件
     */
    @Override
    public List<Oa_files> selectOaFilesList(String[] entityIDs) {
    	try {
    		List<Oa_files> oafileList = mapper.selectOaFilesByEntityIDs(entityIDs);
    		return oafileList;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 批量删除信息同时删除oafile表
     */
    @Override
    public Boolean deleteOaFilesForEntities(String[] entityIDs){
    	try {
			mapper.deleteOaFilesForEntities(entityIDs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }

	@Override
	public List<Oa_files> selectOaFileByEntityID(String entityID) {
		List<Oa_files> Oa_filesList= new ArrayList<Oa_files>();
		try {
			Oa_filesList= mapper.selectOaFileByEntityID(entityID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Oa_filesList;
	}
}

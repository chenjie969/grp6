package com.zjm.oa.common.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Oa_files;

public interface OaFileService {
    boolean insert(Oa_files entity);

    List<Oa_files> selectByRef(Oa_files example);

    Boolean delete(String files_ID);
    
    /**
     * 根据实体ID查询其下的附件列表 
     */
    public PageTable<Oa_files> selectUploadedFilesPageTables(PageTable<Oa_files> pageTable);
    
    /**
     * 根据实体ID查询其下的附件列表 
     */
    public List<Oa_files> selectOaFilesList(String[] entityIDs);
    /**
     * 批量删除信息同时删除oafile表
     */
    public Boolean deleteOaFilesForEntities(String[] entityIDs);

	public List<Oa_files> selectOaFileByEntityID(String entityID);
}

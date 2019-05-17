package com.zjm.oa.db.map;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Oa_files;

import java.util.List;

public interface Oa_filesMapper {
    /**
     * 插入一个客户附件
     *
     * @param file
     * @return
     */
    Integer insert(Oa_files file);

    /**
     * 客户附件List
     */
    List<Oa_files> selectByRef(Oa_files example);

    List<Oa_files> list(Oa_files param);

    Integer delete(String files_ID);
    
    /**
     * 根据实体ID查询其下的附件列表 
     */
    public List<Oa_files> selectUploadedFilesPageTables(PageTable pageTable);
    /**
     * 根据实体ID统计其下的附件个数 
     */
    public Long selectUploadedFiles_count(PageTable pageTable);
    /**
     * 查询多个实体下的所有附件
     */
    public List<Oa_files> selectOaFilesByEntityIDs(String[] entityIDs); 
    /**
     * 批量删除信息同时删除oafile表
     */
    public Integer deleteOaFilesForEntities(String[] entityIDs);

	public List<Oa_files> selectOaFileByEntityID(String entityID);
    
}

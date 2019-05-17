package com.zjm.pro.finish.service;

import java.util.List;
import java.util.Map;

import com.zjm.pro.db.model.Pro_finish;
import com.zjm.pro.db.model.Pro_projectfiles;

/**
* User:    bailf
* DateTime:2018-03-23 14:51:41
* details: 完结解保,Service接口层
*/
public interface Pro_finishService {

    /**
     * 完结解保表,插入数据
     * @param proFinish 完结解保类
     * @return           返回页面map
     * @throws Exception
     */
    public long insert(Pro_finish proFinish) throws Exception;

    /**
     * 完结解保表,修改数据
     * @param proFinish 完结解保类
     * @return           返回页面map
     * @throws Exception
     */
    public long update(Pro_finish proFinish) throws Exception;

	/**
     * 完结解保表,分页查询数据
     * @param data
     * @return
     * @throws Exception
     */
    public List<Pro_finish> getPageListByMap(Map<String , Object> data) throws Exception;
    
	/**
     * 完结解保表,根据id查询数据
     * @param id
     * @return
     * @throws Exception
     */
    public Pro_finish getItemInfoById(String id) throws Exception;
    
    /**
    * 完结解保表,删除数据
    * @param id 主键
    * @return   返回页面map
    * @throws Exception
    */
    public int deleteById(String id) throws Exception;
    
	/**
     * 完结解保表,根据map查询数据
     * @param map
     * @return
     * @throws Exception
     */
    public Pro_finish getOne(Map<String , Object> map) throws Exception;

    /**
     * 获取完结表关联的附件
     * @param entityID
     * @param wheresql fileType等其他搜索条件
     * @return
     */
	public List<Pro_projectfiles> getAttachments(String entityID, String wheresql);

	/**
	 * 根据文件id删除附件
	 * @param projectFiles_ID
	 * @return
	 */
	public Object deleteAttachment(String projectFiles_ID);
}

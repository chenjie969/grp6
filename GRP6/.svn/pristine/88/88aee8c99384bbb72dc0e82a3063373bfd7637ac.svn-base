package com.zjm.pro.db.map;

import java.util.List;
import java.util.Map;

import com.zjm.pro.db.model.Pro_finish;

/**
* User:    bailf
* DateTime:2018-03-23 14:51:41
* details: 完结解保,Dao接口层
* source:  代码生成器
*/
public interface Pro_finishMapper  {

    /**
     * 完结解保表,分页查询数据
     * @param map
     * @return List<ProFinish>
     */
    public List<Pro_finish> getPageListByMap(Map<String, Object> map);
    
    /**
     * 完结解保表,根据id查询数据
     * @param id
     * @return ProFinish
     */
    public Pro_finish getItemInfoById(String id);

    /**
    * 完结解保表,删除数据
    * @param id 主键
    * @return
    */
    public int deleteById(String id);
    
    /**
     * 完结解保表,新增数据
     * @param id 主键
     * @return
     */
	public long insert(Pro_finish proFinish);
	
    /**
     * 完结解保表,更新数据
     * @param id 主键
     * @return
     */
	public long update(Pro_finish proFinish);

	public Pro_finish getOne(Map<String, Object> map);
}

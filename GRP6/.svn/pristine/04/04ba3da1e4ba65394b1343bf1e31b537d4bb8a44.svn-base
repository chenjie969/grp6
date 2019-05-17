package com.zjm.pro.finish.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjm.pro.db.map.Pro_finishMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_finish;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.finish.service.Pro_finishService;

/**
* User:    bailf
* DateTime:2018-03-23 14:51:41
* details: 完结解保,Service实现层
*/
@Service(value = "proFinishServiceImpl")
public class Pro_finishServiceImpl implements Pro_finishService {
	/**
	 * 日志操作
	 */
    private static final Logger log = LoggerFactory.getLogger(Pro_finishServiceImpl.class);
    /**
	 * 完结解保dao层
	 */
    @Autowired
    private Pro_finishMapper pro_finishMapper;
    @Autowired
    private Pro_projectfilesMapper projectfilesMapper;
    

	/**
	 * 完结解保表,插入数据
	 * @param collateral 完结解保类
	 * @return           返回页面map
	 * @throws Exception
	 */
	@Override
	public long insert(Pro_finish proFinish) throws Exception {
		try {
			return pro_finishMapper.insert(proFinish);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage(),e);
		}
	}

	/**
	* 完结解保表,修改数据
	* @param collateral 完结解保类
	* @return           返回页面map
	* @throws Exception
	*/
	@Override
	public long update(Pro_finish proFinish) throws Exception {
		try {
			return pro_finishMapper.update(proFinish);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage(),e);
		}
	}
	
	/**
	 * 完结解保表,分页查询数据
	 * @param data
	 * @return           返回页面map
	 * @throws Exception
	 */
	@Override
	public List<Pro_finish> getPageListByMap(Map<String , Object> data) throws Exception {
		try {
			return pro_finishMapper.getPageListByMap(data);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage(),e);
		}
	}
	
	/**
	 * 完结解保表,根据id查询数据
	 * @param id
	 * @return           返回页面map
	 * @throws Exception
	 */
	@Override
	public Pro_finish getItemInfoById(String id) throws Exception {
		try {
			return pro_finishMapper.getItemInfoById(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage(),e);
		}
	}
	
	
	@Override
	public Pro_finish getOne(Map<String, Object> map) throws Exception {
		try {
			return pro_finishMapper.getOne(map);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage(),e);
		}
	}

	/**
	* 完结解保表,删除数据
	* @param id 主键
	* @return   返回页面map
	* @throws Exception
	*/
	@Override
	public int deleteById(String id) throws Exception {
		try {
			return pro_finishMapper.deleteById(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage(),e);
		}
	}
	
	// 查询附件
		@Override
		public List<Pro_projectfiles> getAttachments(String entityID, String wheresql) {
			List<Pro_projectfiles> listFiles = null;
			try {
				listFiles = projectfilesMapper.selectProFilesListByEntityIDType(entityID, wheresql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listFiles;
		}

		@Override
		public Boolean deleteAttachment(String projectFiles_ID) {
			int count = 0;
			Boolean isTrue = false;
			try {
				count = projectfilesMapper.deleteOneInfoByProFiles_ID(projectFiles_ID);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (count > 0) {
				isTrue = true;
			}
			return isTrue;
		}
}
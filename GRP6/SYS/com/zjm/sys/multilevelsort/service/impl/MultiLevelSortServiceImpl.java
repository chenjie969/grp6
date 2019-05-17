package com.zjm.sys.multilevelsort.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.C_multiLevelSortMapper;
import com.zjm.sys.db.model.C_multiLevelSort;
import com.zjm.sys.multilevelsort.service.MultiLevelSortService;

/**
*  @description  多级字典
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年4月26日 下午10:12:12
*/
@Service(value="multiLevelSortService")
@Transactional
public class MultiLevelSortServiceImpl implements MultiLevelSortService {

	
	@Resource
	private C_multiLevelSortMapper c_multiLevelSortMapper;
	
	@Resource
	private LogService  logService ;// 日志接口
	
	/**
	 * 查询所有多级字典
	 */
	@Override
	public List<C_multiLevelSort> selectAllmultilevelsortList(String wheresql) {

		return c_multiLevelSortMapper.selectAllmultiLevelSortList(wheresql);
	}
	
	
	/**
	 * 插入一个多级字典信息
	 */
	@Override
	public Boolean insertOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort,User user ) {
		
		try {
			Integer orderId = c_multiLevelSortMapper.selectmultiLevelSortOrderId(C_multiLevelSort); // 获取序号
			C_multiLevelSort.setOrderId(orderId);
			Integer info = c_multiLevelSortMapper.insertOnemultiLevelSortInfo(C_multiLevelSort);
			if(info > 0){
				logService.insertOneOperatorLogInfo(user,"多级字典", "添加", "添加"+C_multiLevelSort.getMultilevelsortname());
				return	true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}

	/**
	 * 查询一个多级字典信息
	 */
	@Override
	public C_multiLevelSort selectOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort) {
		return c_multiLevelSortMapper.selectOnemultiLevelSortInfo(C_multiLevelSort);
	}
	
	/**
	 * 更新一个多级字典信息
	 */
	@Override
	public Boolean updateOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort,User user ) {
		try {
			Integer updateOnemultiLevelSortInfo = c_multiLevelSortMapper.updateOnemultiLevelSortInfo(C_multiLevelSort);
			if( updateOnemultiLevelSortInfo > 0 ){
				logService.insertOneOperatorLogInfo(user,"多级字典", "修改", "修改"+C_multiLevelSort.getMultilevelsortname());
				return 	true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
	 * 删除  多级字典信息
	 */
	@Override
	public Boolean deleteOnemultilevelsortInfo(C_multiLevelSort C_multiLevelSort,User user ) {
		try {
			deletemultilevelsortDownInfo(C_multiLevelSort);
			Integer deleteOnemultiLevelSortInfo = c_multiLevelSortMapper.deleteOnemultiLevelSortInfo(C_multiLevelSort);
			if(deleteOnemultiLevelSortInfo >0 ){
				logService.insertOneOperatorLogInfo(user,"多级字典", "删除", "删除多级字典");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
	 * 删除当前菜单的子节点
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 下午10:19:28
	 */
	private void deletemultilevelsortDownInfo(C_multiLevelSort c_multiLevelSort) {
		//查询当前节点的子菜单 --->以当前对象id作为父id查询
		c_multiLevelSort.setPmultilevelsortid(c_multiLevelSort.getMultilevelsortid());
		List<C_multiLevelSort> list = c_multiLevelSortMapper.selectmultiLevelSortListByPmultiLevelSortid(c_multiLevelSort);
		if(list.size()>0){
			for (C_multiLevelSort c : list) {
				deletemultilevelsortDownInfo(c);
				//递归删除
				c_multiLevelSortMapper.deleteOnemultiLevelSortInfo(c);
			}
		}
	}	
	
	
	/**
	 * 查询多级字典列表--分页列表
	 */
	@Override
	public PageTable<C_multiLevelSort> selectmultilevelsortPageTables(PageTable<C_multiLevelSort> pageTable) {
		//获取分页列表
		List<C_multiLevelSort> list = c_multiLevelSortMapper.selectmultiLevelSortPageTables(pageTable);
		//计算总记录数
		Long count = c_multiLevelSortMapper.selectmultiLevelSortPageTables_Count(pageTable);
		pageTable.setRows(list);   
		pageTable.setTotal(count);
		return pageTable;
	}
	
	/**
	 * 判断是否存在
	 */
	@Override
	public Boolean selectmultilevelsortIsExist(String wheresql) {
		return c_multiLevelSortMapper.selectmultiLevelSortIsExist(wheresql)>0;
	}
	
	/**
	 * 由父类id查询子类 多级字典
	 */
	@Override
	public List<C_multiLevelSort> selectmultilevelsortListByPmultilevelsortid(C_multiLevelSort c_multiLevelSort) {
		
		return c_multiLevelSortMapper.selectmultiLevelSortListByPmultiLevelSortid(c_multiLevelSort);
	}


	@Override
	public C_multiLevelSort selectOnemultiLevelSortInfoByWheresql(String wheresql) {
		// TODO Auto-generated method stub
		return c_multiLevelSortMapper.selectOnemultiLevelSortInfoByWheresql(wheresql);
	}
	

}

package com.zjm.sys.busisort.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.busisort.service.BusiSortService;
import com.zjm.sys.db.map.C_busiSortMapper;
import com.zjm.sys.db.model.C_busiSort;

/**
*  @description 业务品种
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年4月25日 下午3:38:05
*/
@Service(value="busiSortService")
@Transactional
public class BusiSortServiceImpl implements BusiSortService {
	
	@Resource(name="c_busiSortMapper")
	private	C_busiSortMapper c_busiSortMapper;
	
	@Resource(name="logService")
	private LogService logService ;//添加日志接口各
	
	/**
	 * 查询所有 业务品种
	 */
	@Override
	public List<C_busiSort> selectAllBusiSortList(String wheresql) {
		return c_busiSortMapper.selectAllBusiSortList(wheresql);
	}
	
	/**
	 * 添加一个 业务品种
	 */
	@Override
	public Boolean insertOneBusiSortInfo(C_busiSort C_busiSort,User user) {
		Integer orderId = c_busiSortMapper.selectBusiSortOrderId(C_busiSort);
		C_busiSort.setOrderId(orderId);
		try {
			 Integer info = c_busiSortMapper.insertOneBusiSortInfo(C_busiSort);
			 if(info >0 ){
				 logService.insertOneOperatorLogInfo(user,"业务品种", "添加", "添加"+C_busiSort.getBusisortname());
				 return	true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
	 * 查询一个业务品种信息
	 */
	@Override
	public C_busiSort selectOneBusiSortInfo(C_busiSort C_busiSort) {
		
		return c_busiSortMapper.selectOneBusiSortInfo(C_busiSort);
	}
	
	/**
	 * 更新业务品种信息
	 */
	@Override
	public Boolean updateOneBusiSortInfo(C_busiSort C_busiSort,User user) {
		try {
			Integer updateOneBusiSortInfo = c_busiSortMapper.updateOneBusiSortInfo(C_busiSort);
			if( updateOneBusiSortInfo > 0){
				logService.insertOneOperatorLogInfo(user,"业务品种", "修改", "修改"+C_busiSort.getBusisortname()); 
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
	 * 删除一个业务品种信息
	 */
	@Override
	public Boolean deleteOneBusiSortInfo(C_busiSort c_busiSort ,User user) {
		//删掉下级业务品种
		try {
			deleteBusiSortDownInfo(c_busiSort);
			Integer deleteOneBusiSortInfo = c_busiSortMapper.deleteOneBusiSortInfo(c_busiSort);
			if(deleteOneBusiSortInfo > 0){
				logService.insertOneOperatorLogInfo(user,"业务品种", "删除", "删除"+c_busiSort.getBusisortname()); 
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
	 * 删除下级业务品种信息
	 * @description
	 * @author wuhn
	 * @date 2017年4月26日 下午1:15:16
	 */
	public void deleteBusiSortDownInfo(C_busiSort c_busiSort){
		//判断该节点是否有下级业务品种
		String sql=" and pbusisortid ='"+c_busiSort.getBusisortid()+"'";
		List<C_busiSort> list = c_busiSortMapper.selectAllBusiSortList(sql);
		for (C_busiSort c : list) {
			//递归删除，判断是否有下级业务品种
			deleteBusiSortDownInfo(c);
			//删除下级业务品种
			c_busiSortMapper.deleteOneBusiSortInfo(c);
		}
		
	}
	
	/**
	 * 查询业务品种 分页列表
	 */
	@Override
	public PageTable<C_busiSort> selectBusiSortPageTables(PageTable<C_busiSort> pageTable) {
		//查询业务品种列表 分页列表
		List<C_busiSort> list = c_busiSortMapper.selectBusiSortPageTables(pageTable);
		//查询业务品种列表 : 总记录数
		Long total = c_busiSortMapper.selectBusiSortPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	@Override
	public Boolean selectBusiSortIsExist(String wheresql) {
		//大于0,存在
		return c_busiSortMapper.selectBusiSortIsExist(wheresql)>0;
	}

	@Override
	public List<C_busiSort> selectBusiSortListByPbusisortid(String pBusiSortId) {
		return c_busiSortMapper.selectBusiSortListByPbusisortid(pBusiSortId);
	}

}

package com.zjm.sys.banksort.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.sys.banksort.service.BankSortService;
import com.zjm.sys.db.map.C_bankSortMapper;
import com.zjm.sys.db.model.C_bankSort;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;

/**
*  @description 
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年4月26日 下午8:00:20
*/
@Service(value="bankSortService")
@Transactional
public class BankSortServiceImpl implements BankSortService {
	
	@Resource(name="c_bankSortMapper")
	private C_bankSortMapper c_bankSortMapper;
	
	@Resource
	private LogService  logService ;// 日志接口
	
	
	/**
	 * 查询所有银行字典信息
	 */
	@Override
	public List<C_bankSort> selectAllbankSortList(String wheresql) {
		return c_bankSortMapper.selectAllbankSortList(wheresql);
	}
	
	/**
	 * 插入一个银行字典信息
	 */
	@Override
	public Boolean insertOnebankSortInfo(C_bankSort C_bankSort,User user) {
		try {
			Integer oderId = c_bankSortMapper.selectbankSortOrderId(C_bankSort);
			C_bankSort.setOrderId(oderId);
			Integer bankInfo = c_bankSortMapper.insertOnebankSortInfo(C_bankSort);
			if(bankInfo > 0){
				logService.insertOneOperatorLogInfo(user,"合作机构设置", "添加", "添加"+C_bankSort.getBanksortname());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}

	/**
	 * 查询一个银行字典信息
	 */
	@Override
	public C_bankSort selectOnebankSortInfo(C_bankSort C_bankSort) {
		return c_bankSortMapper.selectOnebankSortInfo(C_bankSort);
	}
	
	/**
	 * 更新一个银行字典信息
	 */
	@Override
	public Boolean updateOnebankSortInfo(C_bankSort C_bankSort,User user) {
		try {
			
			Integer updateOnebankSortInfo = c_bankSortMapper.updateOnebankSortInfo(C_bankSort);
			if(updateOnebankSortInfo > 0){
				logService.insertOneOperatorLogInfo(user,"合作机构设置", "修改", "修改"+C_bankSort.getBanksortname());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	/**
	 * 删除一个银行字典信息
	 */
	@Override
	public Boolean deleteOnebankSortInfo(C_bankSort C_bankSort,User user) {
		//删除当前菜单的子节点
		try {
			deleteBankSortDownInfo(C_bankSort);
			Integer deleteOnebankSortInfo = c_bankSortMapper.deleteOnebankSortInfo(C_bankSort);
			if(deleteOnebankSortInfo > 0){
				logService.insertOneOperatorLogInfo(user,"合作机构设置", "删除", "删除合作机构");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
	
	public void deleteBankSortDownInfo(C_bankSort C_bankSort){
		//查询当前银行是否有子节点、
		C_bankSort.setPbanksortid(C_bankSort.getBanksortid());
		List<C_bankSort> list = c_bankSortMapper.selectbankSortListByPbankSortid(C_bankSort);
		if(list.size()>0){
			for (C_bankSort c : list) {
				// 递归删除，判断当前节点是否有子节点
				deleteBankSortDownInfo(c);
				c_bankSortMapper.deleteOnebankSortInfo(c);
			}
		}
	}
	
	
	
	/**
	 * 查询银行字典分页列表
	 */
	@Override
	public PageTable<C_bankSort> selectbankSortPageTables(PageTable<C_bankSort> pageTable) {
		//分页列表数
		List<C_bankSort> list = c_bankSortMapper.selectbankSortPageTables(pageTable);
		pageTable.setRows(list);
		Long count = c_bankSortMapper.selectbankSortPageTables_Count(pageTable);
		pageTable.setTotal(count);
		/*boolean contains = pageTable.getWheresql().contains("4649d725753a4f00bd6bfe7c346b0dc5"); //初始化进入不进行处理
		if(contains){
			//总记录数
			Long count = c_bankSortMapper.selectbankSortPageTables_Count(pageTable);
			pageTable.setRows(list);
			pageTable.setTotal(count);
		}else{
			List<C_bankSort> allChildList=new ArrayList<>();
			allChildList = getBankSortChild(list,allChildList);
			pageTable.setRows(allChildList);
			pageTable.setTotal(new Long(allChildList.size()));
		}*/
		return pageTable;
	}
	
	/**
	 * 获取所有叶子节点
	 */
	private List<C_bankSort> getBankSortChild(List<C_bankSort> list,List<C_bankSort> allChildList) {
		Iterator<C_bankSort> it = list.iterator();
		while(it.hasNext()){
			C_bankSort bank = it.next();
			 C_bankSort childNode = isHaveChildNode(bank,allChildList);
			 if(childNode != null){
				 allChildList.add(childNode);
			 }
		}
		
		return allChildList;
	}

	private C_bankSort isHaveChildNode(C_bankSort bank,List<C_bankSort> allChildList) {
		//查询当前节点是否有子节点
		String wheresql=" and pbanksortid='"+bank.getBanksortid()+"'";
		List<C_bankSort> childList = c_bankSortMapper.selectAllbankSortList(wheresql);
		if(CollectionUtils.isNotEmpty(childList)){//包含子节点
			getBankSortChild(childList,allChildList);
			return null; 
		}
		return bank;
		
	}

	
	/**
	 * 查询额度使用情况,分页列表
	 */
	@Override
	public PageTable<C_bankSort> selectCreditConditionsPageTables(PageTable<C_bankSort> pageTable) {
		List<C_bankSort> list = c_bankSortMapper.selectbankSortPageTables(pageTable);//分页列表数
		List<C_bankSort>  newList=new ArrayList<>();
		for (C_bankSort c_bankSort : list) {
			String bankfullcode = c_bankSort.getBankfullcode();//获得节点完整编号
			if(bankfullcode.length() == 66){// 二级父节点
				String bankCategory = c_bankSort.getBanksortname(); //类别名称
				c_bankSort.setBankCategory(bankCategory);//设置 类别名称
				c_bankSort.getBanksortname();
				//获取该类别下面的子节点
				List<C_bankSort> childeNode = getChildeNode(bankfullcode,bankCategory,list);
				newList.addAll(childeNode);
			}
		}
		
		Long count = c_bankSortMapper.selectbankSortPageTables_Count(pageTable);//总记录数
		pageTable.setRows(newList);
		pageTable.setTotal(count);
		return pageTable;
	}
	
	/**
	 * @description	获取当前父节点下的子节点
	 * @author wuhn
	 * @date 2017年5月26日 下午5:29:08
	 */
	private List<C_bankSort> getChildeNode(String bankfullcode, String bankCategory,List<C_bankSort> list) {
		ArrayList<C_bankSort> bankList=new ArrayList<>();
		for (C_bankSort bankSort : list) {
			if(bankSort.getBankfullcode().contains(bankfullcode)){
				bankSort.setBankCategory(bankCategory);
				bankList.add(bankSort);
			}
		}
		return bankList;
	}

	/**
	 * 判断当前银行字典信息是否存在
	 */
	@Override
	public Boolean selectbankSortIsExist(String wheresql) {
		return c_bankSortMapper.selectbankSortIsExist(wheresql)>0;
	}
	
	/**
	 * 由父id查询资料id信息
	 */
	@Override
	public List<C_bankSort> selectbankSortListByPbankSortid(C_bankSort C_bankSort) {
		return c_bankSortMapper.selectbankSortListByPbankSortid(C_bankSort);
	}

}

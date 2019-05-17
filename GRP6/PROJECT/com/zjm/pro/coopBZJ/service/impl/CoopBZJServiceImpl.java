package com.zjm.pro.coopBZJ.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.coopBZJ.service.CoopBZJService;
import com.zjm.sys.db.map.C_bankSortMapper;
import com.zjm.sys.db.model.C_bankSort;

@Service("coopBZJService")
@Transactional
public class CoopBZJServiceImpl implements CoopBZJService{
	
	@Resource
	private C_bankSortMapper bankSortMapper;
	@Resource
	private LogService logService;

	/**
	 * 查询银行类合作机构 
	 */
	public PageTable<C_bankSort> selectbankSortPageTables(PageTable<C_bankSort> pageTable){
		try{
			List<C_bankSort> bankList = bankSortMapper.selectbankSortPageTables(pageTable);
			List<C_bankSort> result = new ArrayList<C_bankSort>(); 
			result = selectSubBankSort(result,pageTable.getQueryCondition().getUnit_uid(),bankList);
			//排除结果集中授信金额为0的银行
			/*for (C_bankSort bankSort : result) {		可能会抛出ConcurrentModificationException异常	
				Double creditSum = bankSort.getCreditSum();
				if(creditSum==null || creditSum==0){
					result.remove(bankSort);
				}
			}*/
			for(int i=result.size()-1; i>=0; i--){		//正序遍历删除元素后会跳过某些元素，必须倒序遍历删除集合元素
				Double creditSum = result.get(i).getCreditSum();
				if(creditSum==null || creditSum==0){
					result.remove(result.get(i));
				}
			}
			pageTable.setRows(result);
			pageTable.setTotal((long) result.size());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	
	/**
	 * 递归查询出所有叶子银行
	 */
	private List<C_bankSort> selectSubBankSort(List<C_bankSort> result, String unit_uid, List<C_bankSort> bankList){
		for (C_bankSort bankSort : bankList) {
			C_bankSort temp = new C_bankSort();
			temp.setPbanksortid(bankSort.getBanksortid());
			temp.setUnitUid(unit_uid);
			List<C_bankSort> subBankSortList = bankSortMapper.selectbankSortListByPbankSortid(temp);
			if(subBankSortList == null || subBankSortList.size()==0){
				result.add(bankSort);
			}else{
				selectSubBankSort(result,unit_uid,subBankSortList);
			}
		}
		return result;
	}
	
	/**
	 * 查询一个合作机构的信息
	 */
	public C_bankSort selectOneBankSort(C_bankSort bankSort){
		try {
			bankSort = bankSortMapper.selectOnebankSortInfo(bankSort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankSort;
	}
	
	/**
	 * 更新一个合作机构的信息
	 */
	public Boolean updateOneBankSort(User user,C_bankSort bankSort){
		try {
			C_bankSort temp = selectOneBankSort(bankSort);
			temp.setBzScale(bankSort.getBzScale());
			temp.setMustBzSum(bankSort.getMustBzSum());
			temp.setFactBzSum(bankSort.getFactBzSum());
			temp.setRemark(bankSort.getRemark());
			Integer updateCol = bankSortMapper.updateOnebankSortInfo(temp);
			if(updateCol==1){
				logService.insertOneOperatorLogInfo(user, "合作机构保证金", "修改", "修改"+temp.getBanksortname()+"保证金");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
/*	@Test
	private void test(){
		PageTable<C_bankSort> pageTable = new PageTable<>();
		QueryCondition qc = new QueryCondition();
		qc.setUnit_uid("cbeb758e3d824626a31aabb2a9587b0a");
		pageTable.setQueryCondition(qc);
		pageTable.setWheresql(" and unit_uid='cbeb758e3d824626a31aabb2a9587b0a' and pbankSortID='e7e282ee61b249eba0f64161fee6ff45'");
		pageTable.setPageNumber((long) 0);
		pageTable.setPageSize((long)10);
		pageTable = selectbankSortPageTables(pageTable);
	}*/
}

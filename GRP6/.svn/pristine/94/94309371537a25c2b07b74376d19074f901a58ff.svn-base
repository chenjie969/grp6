package com.zjm.pro.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_FinanceMapper;
import com.zjm.pro.db.model.Pro_FinanceForProVO;
import com.zjm.pro.finance.service.FinanceService;

@Service("financeService")
@Transactional
public class FinanceServiceImpl implements FinanceService{
	@Resource 
	private Pro_FinanceMapper financeMapper;
	@Resource
	private LogService logService;

	public PageTable<Pro_FinanceForProVO> selectMultiPageTable(PageTable<Pro_FinanceForProVO> pageTable) {
		try {
			List<Pro_FinanceForProVO> volist = financeMapper.selectMultiProFinancePageTable(pageTable);
			pageTable.setRows(volist);
			pageTable.setTotal((long) volist.size());
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

package com.zjm.pro.arcTransfer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Gbpm_dicNode;
import com.zjm.pro.arcTransfer.service.ArcTransferService;
import com.zjm.pro.db.map.Pro_arcTransferMapper;
import com.zjm.pro.db.model.Pro_arcTransfer;

@Service("arcTransferListService")
@Transactional
public class ArcTransferServiceImpl implements ArcTransferService {
	@Resource
	private Pro_arcTransferMapper arcTransferMapper;
	/**
	 * 分页查询档案移交列表
	 */
	@Override
	public PageTable<Pro_arcTransfer> selectTransferRecordsPageTable(PageTable<Pro_arcTransfer> pageTable) {
		List<Pro_arcTransfer> arcTransferListList = arcTransferMapper.selectTransferRecordsPageTable(pageTable);
		pageTable.setRows(arcTransferListList);
		Long arcTransferListTotal;
		try {
			//档案移交查询总数
			arcTransferListTotal = arcTransferMapper.selectTransferRecordsPageTable_Count(pageTable);
			pageTable.setTotal(arcTransferListTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
    

}

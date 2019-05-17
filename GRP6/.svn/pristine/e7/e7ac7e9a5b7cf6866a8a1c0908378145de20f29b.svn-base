package com.zjm.pro.lawsuitProgress.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_lawsuitProgressMapper;
import com.zjm.pro.db.model.Pro_lawsuitProgress;
import com.zjm.pro.lawsuitProgress.service.LawsuitProgressService;
import com.zjm.util.Tool;

@Service("lawsuitProgressService")
@Transactional
public class LawsuitProgressServiceImpl implements LawsuitProgressService {

	@Resource
	private Pro_lawsuitProgressMapper pro_lawsuitProgressMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 新增案件诉讼
	 */
	@Override
	public Boolean insertOneLawsuitProgressInfo(User userSession, Pro_lawsuitProgress pro_lawsuitProgress) {
		pro_lawsuitProgress.setLawsuitProgress_ID(Tool.createUUID32());
		pro_lawsuitProgress.setUnit_uid(userSession.getUnit_uid());
		pro_lawsuitProgress.setUpdateUserName(userSession.getUser_name());
		if (pro_lawsuitProgressMapper.insertOneLawsuitProgressInfo(pro_lawsuitProgress) > 0) {
			logService.insertOneOperatorLogInfo(userSession,"新增案件诉讼情况", "新增", "新增案件诉讼情况" + pro_lawsuitProgress.getLawsuitProgress_ID());
			return true;
		}
		return false;
	}
	
	/**
	 * 修改案件诉讼
	 */
	@Override
	public Boolean updateOneLawsuitProgressInfo(User userSession, Pro_lawsuitProgress pro_lawsuitProgress) {
		pro_lawsuitProgress.setUnit_uid(userSession.getUnit_uid());
		pro_lawsuitProgress.setUpdateUserName(userSession.getUser_name());
		if (pro_lawsuitProgressMapper.updateOneLawsuitProgressInfo(pro_lawsuitProgress) > 0) {
			logService.insertOneOperatorLogInfo(userSession,"修改案件诉讼情况", "修改", "修改案件诉讼情况" + pro_lawsuitProgress.getLawsuitProgress_ID());
			return true;
		}
		return false;
	}

	/**
	 * 查询案件诉讼分页列表
	 */
	@Override
	public PageTable<Pro_lawsuitProgress> selectLawsuitProgressPageTable(PageTable<Pro_lawsuitProgress> pageTable) {
		pageTable.setRows(pro_lawsuitProgressMapper.selectLawsuitProgressPageTable(pageTable));
		pageTable.setTotal(pro_lawsuitProgressMapper.selectLawsuitProgressPageTable_Count(pageTable));
		return pageTable;
	}

	/**
	 * 查询案件诉讼信息
	 */
	@Override
	public Pro_lawsuitProgress selectOneLawsuitProgressInfo(String wheresql) {
		return pro_lawsuitProgressMapper.selectOneLawsuitProgressInfo(wheresql);
	}
    /**
     * 删除一条案件诉讼
     * 
     */
	@Override
	public Boolean delOneLawsuitProgressInfo(User userSession, String wheresql) {
		if (pro_lawsuitProgressMapper.delOneLawsuitProgressInfo(wheresql) > 0) {
			logService.insertOneOperatorLogInfo(userSession,"删除案件诉讼情况", "删除", "删除案件诉讼情况wheresql" );
			return true;
		}
		return false;
	}

}

package com.zjm.pro.arcMoveRec.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.arcMoveRec.service.ArcMoveRecService;
import com.zjm.pro.db.map.Pro_arcMoveMapper;
import com.zjm.pro.db.map.Pro_arcMoveRecMapper;
import com.zjm.pro.db.model.Pro_arcMoveRec; 

@Service("arcMoveRecService")
@Transactional
public class ArcMoveRecServiceImpl implements ArcMoveRecService {
	@Resource
	private LogService logService;
	
	@Resource
	private Pro_arcMoveRecMapper pro_arcMoveRecMapper;
	@Resource
	private Pro_arcMoveMapper pro_arcMoveMapper;
	
	@Override
	public PageTable selectArcMoveRecPageTables(PageTable pageTable) {
		List<Pro_arcMoveRec> arcMoveRecList = null;
		try {
			arcMoveRecList = pro_arcMoveRecMapper.selectArcMoveRecPageTables(pageTable);
			Long total = pro_arcMoveRecMapper.selectArcMoveRecPageTables_Count(pageTable);
			pageTable.setRows(arcMoveRecList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	@Override
	public Boolean insertOneArcMoveRecInfo(User user, Pro_arcMoveRec arcMoveRec) {
		Integer returnInt  = 0;
		Boolean  b = false;
		arcMoveRec.setUnit_uid(user.getUnit_uid());
		arcMoveRec.setUpdateDateTime(new Date());
		arcMoveRec.setUpdateUserName(user.getUser_name());
		returnInt = pro_arcMoveRecMapper.insertOneArcMoveRecInfo(arcMoveRec);
		if(returnInt >0 ){
		     logService.insertOneOperatorLogInfo(user,"档案管理", "新增", "新增档案记录表信息ID"+arcMoveRec.getArcMoveRec_ID());
			b = true;
		}
		return b;
	}
	
	public Pro_arcMoveRec selectOneArcMoveRecByWhereSql(String wheresql) {
		Pro_arcMoveRec pro_arcMoveRec = pro_arcMoveRecMapper.selectOneArcMoveRecByWhereSql(wheresql);
		return pro_arcMoveRec;
	}

	@Override
	public Boolean updateOneArcMoveRecInfo(User user, Pro_arcMoveRec arcMoveRec) {
		Integer returnInt= 0 ; 
		Boolean  b = false;
		arcMoveRec.setUpdateUserName(user.getUser_name());
		returnInt  = pro_arcMoveRecMapper.updateOneArcMoveRecInfo(arcMoveRec);
		if(returnInt >0 ){
			logService.insertOneOperatorLogInfo(user,"档案管理", "修改", "修改档案记录表信息ID"+arcMoveRec.getArcMoveRec_ID());
			b = true;
		}
		return b;
	}

	@Override                
	public List<Pro_arcMoveRec> selectArcMoveRecListByWhereSql(String wheresql) {
		List<Pro_arcMoveRec> arcMoveRecList = pro_arcMoveRecMapper.selectArcMoveRecListByWhereSql(wheresql);
		return arcMoveRecList;
	}

	@Override
	public Boolean deleteOneArcMoveRecInfo(User user, Pro_arcMoveRec arcMoveRec) {
		Integer returnInt = 0 ;
		Integer returnInt2 = 0 ;
		Boolean  b = false;
		String whereSql = " and arcMoveRec_ID = \'"+arcMoveRec.getArcMoveRec_ID()+"\'";
		
		try {
			returnInt2 = pro_arcMoveMapper.deleteOneArcMoveByWhereSql(whereSql);
			returnInt  = pro_arcMoveRecMapper.deleteOneArcMoveRecByWhereSql(whereSql);
			if(returnInt2 >0 ){
				logService.insertOneOperatorLogInfo(user,"档案管理", "删除", "删除档案表信息arcMoveRec_ID"+arcMoveRec.getArcMoveRec_ID());
			
			}
			if(returnInt >0 ){
				logService.insertOneOperatorLogInfo(user,"档案管理", "删除", "删除档案记录表信息ID"+arcMoveRec.getArcMoveRec_ID());
			
			}
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
}

package com.zjm.pro.projectTransfer.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.map.UserMapper;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.map.Pro_applyDetailMapper;
import com.zjm.pro.db.map.Pro_applyMapper;
import com.zjm.pro.db.map.Pro_projChangeRecMapper;
import com.zjm.pro.db.map.Pro_projectMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_projChangeRec;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.projectTransfer.service.ProjChangeRecService;
import com.zjm.util.Tool;

@Transactional
@Service("projChangeRecService")
public class ProjChangeRecServiceImpl implements ProjChangeRecService {

	@Resource
	private Pro_projChangeRecMapper pro_projChangeRecMapper;
	@Resource
	private Pro_applyDetailMapper pro_applyDetailMapper;
	@Resource
	private Pro_applyMapper pro_applyMapper ;
	@Resource
	private Pro_projectMapper pro_projectMapper;
	@Resource
	private UserMapper userMapper;
	
	
	@Override
	public Boolean insertOneProjChangeRec(Pro_projChangeRec projChangeRec ,User user) {
		
		if(null != projChangeRec.getChangeManId()&& !"".equals(projChangeRec.getChangeManId())){//如果当前移交办理用户有值择取传来的移交用户值
			user = userMapper.selectUserByUserUid(projChangeRec.getChangeManId());
		}
		//更新pro_Detial表
		Pro_applyDetail applyDetail = pro_applyDetailMapper.selectOneApplyDetailWhereSql(" and  applyDetail_ID = \'"+projChangeRec.getApplyDetail_ID()+"\'");
		applyDetail.setAmanID(projChangeRec.getNewAmanId());
		applyDetail.setAmanName(projChangeRec.getNewAmanName());
		applyDetail.setBmanID(projChangeRec.getNewBmanId());
		applyDetail.setBmanName(projChangeRec.getNewBmanName());
//		applyDetail.setBeforeAManID(projChangeRec.getOldAmanId());
//		applyDetail.setBeforeBManID(projChangeRec.getOldBmanId());
		applyDetail.setUpdateUserName(user.getUser_name());
		applyDetail.setUpdateDateTime(new Date());
		int flagDetail = pro_applyDetailMapper.updateOneApplyDetailInfo(applyDetail);
		//更新pro_project表
		Pro_project project = pro_projectMapper.selectOneProjectWhereSql(" and project_ID = \'"+projChangeRec.getProject_ID()+"\'");
		project.setAmanID(projChangeRec.getNewAmanId());
		project.setAmanName(projChangeRec.getNewAmanName());
		project.setBmanID(projChangeRec.getNewBmanId());
		project.setBmanName(projChangeRec.getNewBmanName());
//		project.setBeforeAManID(projChangeRec.getOldAmanId());
//		project.setBeforeAManName(projChangeRec.getOldAmanName());
//		project.setBeforeBManID(projChangeRec.getOldBmanId());
//		project.setBeforeBManName(projChangeRec.getOldBmanName());
		project.setChangeDate(projChangeRec.getChangeDateTime());
		project.setChangeManID(user.getUser_uid());
		project.setChangeManName(user.getUser_name());
		int flagProject =pro_projectMapper.updateOneProjectInfo(project);
		//更新pro_apply表
		Pro_apply apply = pro_applyMapper.selectOneApplyWhereSql("and apply_ID = \'" + projChangeRec.getApply_ID() + "\'"); 
		apply.setAmanID(projChangeRec.getNewAmanId());
		apply.setAmanName(projChangeRec.getNewAmanName());;
		apply.setBmanID(projChangeRec.getNewBmanId());
		apply.setBmanName(projChangeRec.getNewBmanName());
//		apply.setBeforeAManID(projChangeRec.getOldAmanId());
//		apply.setBeforeBManID(projChangeRec.getOldBmanId());
		int flagApply = pro_applyMapper.updateOneApplyInfo(apply);
		projChangeRec.setProjChangeRec_ID(Tool.createUUID32());
		projChangeRec.setUnit_uid(user.getUnit_uid());
		projChangeRec.setChangeManId(user.getUser_uid());
		projChangeRec.setUpdateDateTime(new Date());
		projChangeRec.setUpdateUserName(user.getUser_name());
		int flag = pro_projChangeRecMapper.insertOneprojChangeRec(projChangeRec);
		if(flag == 1 && flagDetail == 1 && flagProject == 1 && flagApply ==1){
			return true;
		}
		return false;
	}

	@Override
	public PageTable<Pro_projChangeRec> selectProjChangeRecPageTable(PageTable<Pro_projChangeRec> pageTable) {
		
		List<Pro_projChangeRec> list = pro_projChangeRecMapper.selectProjChangeRecPageTable(pageTable);
		Long total = pro_projChangeRecMapper.selectProjChangeRecPageTableCount(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	@Override
	public Pro_projChangeRec selectOneProjChangeRec(String projChangeRec_ID) {
		Pro_projChangeRec rec = pro_projChangeRecMapper.selectOneProjChangeRecByID(projChangeRec_ID);
		return rec;
	}

	@Override
	public Boolean updateOneProjChangeRec(Pro_projChangeRec projChangeRec) {
		int flag = pro_projChangeRecMapper.updateOneProjChangeRec(projChangeRec);
		if(1 == flag){
			return true;
		}
		return false;
	}

}

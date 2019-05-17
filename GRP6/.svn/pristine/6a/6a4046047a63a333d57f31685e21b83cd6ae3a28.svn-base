package com.zjm.pro.arcMove.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.arcMove.service.ArcMoveService;
import com.zjm.pro.arcMoveRec.service.ArcMoveRecService;
import com.zjm.pro.db.map.Pro_arcMoveMapper;
import com.zjm.pro.db.model.Pro_arcMove;
import com.zjm.pro.db.model.Pro_arcMoveRec;
import com.zjm.util.Tool; 

@Service("arcMoveService")
@Transactional
public class ArcMoveServiceImpl implements ArcMoveService {
	@Resource
	private LogService logService;
	
	@Resource
	private Pro_arcMoveMapper pro_arcMoveMapper;
	@Resource
	private ArcMoveRecService arcMoveRecService;
	
	
	@Override
	public PageTable selectArcMovePageTables(PageTable pageTable) {
		List<Pro_arcMove> arcMoveList = null;
		try {
			arcMoveList = pro_arcMoveMapper.selectArcMovePageTables(pageTable);
			Long total = pro_arcMoveMapper.selectArcMovePageTables_Count(pageTable);
			pageTable.setRows(arcMoveList);
			pageTable.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	@Override
	public Boolean insertOneArcMoveInfo(User user, Pro_arcMove arcMove) {
		Integer returnInt  = 0;
		Boolean  b = false;
		arcMove.setArcMove_ID(Tool.createUUID32());
		arcMove.setUnit_uid(user.getUnit_uid());
		arcMove.setStatus("未移交");
		returnInt = pro_arcMoveMapper.insertOneArcMoveInfo(arcMove);
		if(returnInt >0 ){
		     logService.insertOneOperatorLogInfo(user,"档案管理", "新增", "新增档案表信息ID"+arcMove.getArcMove_ID());
			b = true;
		}
		return b;
	}
	
	public Pro_arcMove selectOneArcMoveByWhereSql(String wheresql) {
		Pro_arcMove pro_arcMove = pro_arcMoveMapper.selectOneArcMoveByWhereSql(wheresql);
		return pro_arcMove;
	}

	@Override
	public Boolean updateOneArcMoveInfo(User user, Pro_arcMove arcMove) {
		Integer returnInt= 0 ; 
		Boolean  b = false;
		returnInt  = pro_arcMoveMapper.updateOneArcMoveInfo(arcMove);
		if(returnInt >0 ){
			logService.insertOneOperatorLogInfo(user,"档案管理", "修改", "修改档案表信息ID"+arcMove.getArcMove_ID());
			b = true;
		}
		return b;
	}

	@Override                
	public List<Pro_arcMove> selectArcMoveListByWhereSql(String wheresql) {
		List<Pro_arcMove> arcMoveList = pro_arcMoveMapper.selectArcMoveListByWhereSql(wheresql);
		return arcMoveList;
	}

	@Override
	public Boolean deleteOneArcMoveInfo(User user, Pro_arcMove arcMove) {
		Integer returnInt = 0 ;
		Boolean  b = false;
		returnInt  = pro_arcMoveMapper.deleteOneArcMoveByWhereSql(" and arcMove_ID = \'"+arcMove.getArcMove_ID()+"\'");
		if(returnInt >0 ){
			logService.insertOneOperatorLogInfo(user,"档案管理", "删除", "删除档案表信息ID"+arcMove.getArcMove_ID());
			b = true;
		}
		return b;
	}

	@Override
	public Boolean turnArcMove(User user, Pro_arcMove pro_arcMove) {
		Integer returnInt = 0 ;
		Boolean  b = false;
		List<Pro_arcMove> arcMoveList = getArcMoveByArcMoveDetails(pro_arcMove.getArcMoveDetails());
		for (Pro_arcMove arcMove : arcMoveList) {
			arcMove.setIsMove(1);//是否已移交
			arcMove.setStatus("已移交");
			arcMove.setAcceptStatus("未接收");
			arcMove.setUpdateUserName(user.getUser_name());
			returnInt = pro_arcMoveMapper.updateOneArcMoveInfo(arcMove);
		}
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user,"档案管理", "修改", "修改档案表信息ID"+pro_arcMove.getArcMove_ID());
			
			b = true;
		}
		return b;
	}
	public List<Pro_arcMove> getArcMoveByArcMoveDetails(String arcMoveDetails){
		
		
		String[] strArr = arcMoveDetails.split(";");//获取前台拼接字符串;			
		List<String[]> stringList = new  ArrayList<>();			
		List<Pro_arcMove> arcMoveList = new  ArrayList<>();			
		for (int i = 0; i < strArr.length; i++) {
			stringList.add(strArr[i].split(",",-1)) ;//拆分业务明细.存放在list中;	
		}			
		for (String[] strings : stringList) {//遍历list,取值后放入相应属性中,存入数据库
			Pro_arcMove pro_arcMove = new Pro_arcMove();
			int	j=0;
			pro_arcMove.setArcMove_ID(strings[j++]);//设置ArcMove_ID
			pro_arcMove.setPageCount(Integer.parseInt(strings[j++]));//页数
			pro_arcMove.setPageNumber(Integer.parseInt(strings[j++]));//页码
			pro_arcMove.setPageNumberEnd(Integer.parseInt(strings[j++]));//页码
			pro_arcMove.setIsOriginal(Integer.parseInt(strings[j++]));//是否原件
			pro_arcMove.setIsAll(Integer.parseInt(strings[j++]));//是否全部提交
			pro_arcMove.setRemark(strings[j++]);
			arcMoveList.add(pro_arcMove);
		}
		return arcMoveList;
	}

	@Override
	public Boolean arcMoveAccept(User user, Pro_arcMove pro_arcMove) {
		//根据档案移交记录id获取档案
		List<Pro_arcMove> arcMoveList = pro_arcMoveMapper.selectArcMoveListByWhereSql("and arcMoveRec_ID = \'"+pro_arcMove.getArcMoveRec_ID()+"\'");
		Integer returnInt = 0;
		Boolean b = false;
		for (Pro_arcMove arcMove : arcMoveList) {//遍历查询出的档案信息,修改档案接收情况
	    	arcMove.setAcceptDate(pro_arcMove.getAcceptDate());//接收时间
	    	arcMove.setAcceptUserName(pro_arcMove.getAcceptUserName());//接收人
	    	arcMove.setAcceptStatus("已接收");
	    	returnInt  = pro_arcMoveMapper.updateOneArcMoveInfo(arcMove);
	    	if(returnInt > 0 ){
	    		logService.insertOneOperatorLogInfo(user,"档案管理", "修改", "修改档案表信息ID"+arcMove.getArcMove_ID());
				
			}
		}
		if(returnInt > 0){
			Pro_arcMoveRec arcMoveRec= new Pro_arcMoveRec();
			arcMoveRec.setArcMoveRec_ID(pro_arcMove.getArcMoveRec_ID());
			arcMoveRec.setAcceptDate(pro_arcMove.getAcceptDate());
			arcMoveRec.setAcceptUserName(pro_arcMove.getAcceptUserName());
			arcMoveRec.setStatus("已接收");
			arcMoveRecService.updateOneArcMoveRecInfo(user, arcMoveRec);
			b = true;
		}
		return b;
	}
    /**
     * 批量新增档案
     */
	@Override
	public Boolean insertArcMoves(User user, Pro_arcMove arcMove) {
		Integer returnInt  = 0;
		Boolean  b = false;
		/*arcMove.setArcMove_ID(Tool.createUUID32());
		arcMove.setUnit_uid(user.getUnit_uid());
		arcMove.setStatus("未移交");*/
		List<Pro_arcMove> arcMovesList = getArcMovesByTreeChecked(arcMove.getArcMoveDetails());
		for (Pro_arcMove pro_arcMove : arcMovesList) {
			arcMove.setArcMove_ID(Tool.createUUID32());
			arcMove.setUnit_uid(user.getUnit_uid());
			arcMove.setArcTypeID(pro_arcMove.getArcTypeID());
			arcMove.setArcTypeName(pro_arcMove.getArcTypeName());
			arcMove.setFileTitleID(pro_arcMove.getFileTitleName());
			arcMove.setFileTitleName(pro_arcMove.getFileTitleName());
			arcMove.setPageCount(0);
			arcMove.setPageNumber(0);
			arcMove.setPageNumberEnd(0);
			arcMove.setRemark("");
			arcMove.setStatus("未移交");
			returnInt = pro_arcMoveMapper.insertOneArcMoveInfo(arcMove);
			if(returnInt>0){
				 logService.insertOneOperatorLogInfo(user,"档案管理", "新增", "新增档案表信息ID"+arcMove.getArcMove_ID());
			}
		}
		if(returnInt >0 ){
			b = true;
		}
		return b;
	}
	/**
	 * 获取所选中的树节点
	 * @param arcMoveDetails
	 * @return
	 */
	public List<Pro_arcMove> getArcMovesByTreeChecked(String arcMoveDetails){
		String[] strArr = arcMoveDetails.split(";");//获取前台拼接字符串;			
		List<String[]> stringList = new  ArrayList<>();			
		List<Pro_arcMove> arcMoveList = new  ArrayList<>();			
		for (int i = 0; i < strArr.length; i++) {
			stringList.add(strArr[i].split(",",-1)) ;//拆分业务明细.存放在list中;	
		}			
		for (String[] strings : stringList) {//遍历list,取值后放入相应属性中,存入数据库
			Pro_arcMove pro_arcMove = new Pro_arcMove();
			int	j=0;
			pro_arcMove.setArcTypeName(strings[j++]);
			pro_arcMove.setArcTypeID(strings[j++]);
			pro_arcMove.setFileTitleName(strings[j++]);
			pro_arcMove.setFileTitleID(strings[j++]);
			arcMoveList.add(pro_arcMove);
		}
		return arcMoveList;
	}
}

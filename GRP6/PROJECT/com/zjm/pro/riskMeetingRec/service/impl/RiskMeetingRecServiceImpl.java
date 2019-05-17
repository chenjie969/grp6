package com.zjm.pro.riskMeetingRec.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.map.Pro_riskMeetingRecMapper;
import com.zjm.pro.db.map.Pro_riskSchemeMapper;
import com.zjm.pro.db.map.Pro_riskScheme_riskMeetingRecMapper;
import com.zjm.pro.db.model.Pro_riskMeetingRec;
import com.zjm.pro.db.model.Pro_riskScheme;
import com.zjm.pro.db.model.Pro_riskScheme_riskMeetingRec;
import com.zjm.pro.riskMeetingRec.serivce.RiskMeetingRecService;
import com.zjm.util.Tool;
@Service("riskMeetingRecService")
@Transactional
public class RiskMeetingRecServiceImpl implements RiskMeetingRecService {
    @Resource
	private Pro_riskMeetingRecMapper riskMeetingRecMapper;
    @Resource
    private Pro_riskSchemeMapper riskSchemeMapper;
    @Resource
    private Pro_riskScheme_riskMeetingRecMapper riskScheme_riskMeetingRecMapper;
    @Resource
	private LogService logService;
    @Resource
	private Pro_projectfilesMapper pro_projectfilesMapper;
	
    
    /**
     *查询待安排会议列表
     * 
     */
	@Override
	public PageTable<Pro_riskScheme> selectAwaitingMeetingPageTables(PageTable<Pro_riskScheme> pageTable) {
		List<Pro_riskScheme> riskSchemeList = riskSchemeMapper.selectAwaitingMeetingPageTables(pageTable);
		pageTable.setRows(riskSchemeList);
		Long riskSchemeListTotal;
		try {
			//待安排会议查询总数
			riskSchemeListTotal = riskSchemeMapper.selectAwaitingMeetingPageTables_count(pageTable);
			pageTable.setTotal(riskSchemeListTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

   /**
    * 查询一条待安排会议信息
    * 
    */
	@Override
	public Pro_riskScheme selectOneAwaitingMeeting(String whereSql) {
		try {
			Pro_riskScheme riskScheme = riskSchemeMapper.selectOneAwaitingMeeting(whereSql);
			return riskScheme;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

}
    
    /**
	 * 分页查询已安排会议列表
	 */
	@Override
	public PageTable<Pro_riskMeetingRec> selectAwaitedMeetingPageTables(PageTable<Pro_riskMeetingRec> pageTable) {
		List<Pro_riskMeetingRec> riskMeetingRecList = riskMeetingRecMapper.selectAwaitedMeetingPageTables(pageTable);
		pageTable.setRows(riskMeetingRecList);
		Long riskMeetingRecListTotal;
		try {
			//已安排会议查询总数
			riskMeetingRecListTotal = riskMeetingRecMapper.selectAwaitedMeetedPageTables_count(pageTable);
			pageTable.setTotal(riskMeetingRecListTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	
	/**
	 * 
	 *查询一条已安排会议 
	 */

	@Override
	public Pro_riskMeetingRec selectOneAwaitedMeeting(String whereSql) {
		try {
			Pro_riskMeetingRec riskMeetingRec = riskMeetingRecMapper.selectOneAwaitedMeeting(whereSql);
			return riskMeetingRec;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	  /**
	   * 
	   * 新增一条安排会议信息
	   * 
	   */
	@Override
	public Boolean insertOneArrangeMeeting(User user, Pro_riskMeetingRec riskMeetingRec) {
		Integer count = 0;
		Boolean isTrue = false;
		riskMeetingRec.setRiskMeetingRec_ID(Tool.createUUID32());
		riskMeetingRec.setUnit_uid(user.getUnit_uid());
		riskMeetingRec.setCreateUserID(Tool.createUUID32());
		riskMeetingRec.setMeetingTypeID(Tool.createUUID32());
		riskMeetingRec.setUpdateUserName(user.getUser_name());
		//处理会议时间的字段
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			String meetingDateTimeStr = riskMeetingRec.getMeetingDateTimeStr();
			Date meetingDateTime = sdf.parse(meetingDateTimeStr);
			riskMeetingRec.setMeetingDateTime(meetingDateTime);
			count = riskMeetingRecMapper.insertOneArrangeMeeting(riskMeetingRec);
			
			//  添加关联系数据
			String riskScheme_IDs = riskMeetingRec.getRiskScheme_IDs();
			if (riskScheme_IDs != null){
				riskScheme_IDs = riskScheme_IDs.replaceAll("'", "");
				String[] arr = riskScheme_IDs.split(",");
				for (String str : arr) {
					Pro_riskScheme_riskMeetingRec prr = new Pro_riskScheme_riskMeetingRec();
					prr.setRiskMeetingRec_ID(riskMeetingRec.getRiskMeetingRec_ID());
					prr.setRiskScheme_ID(str);
					riskScheme_riskMeetingRecMapper.insertOneRiskScheme_riskMeetingRec(prr);
					//修改上会状态
					Pro_riskScheme riskScheme = new Pro_riskScheme();
					riskScheme.setIsMeeting(1);
					riskScheme.setRiskScheme_ID(str);
					riskSchemeMapper.updateMeetingStatus(riskScheme);
				}
			}
			return true;
		} catch (Exception e){
			e.printStackTrace();
		}
		
		if(count>0){
			isTrue=true;
			logService.insertOneOperatorLogInfo(user, "新增一条安排会议信息", "新增", "Pro_riskMeetingRec");
		}
		return isTrue;
	}

	

	@Override
	public List<Pro_riskScheme> selectRiskSchemeList(String wheresql) {
		return riskSchemeMapper.selectRiskSchemeList(wheresql);
	}

	@Override
	public List<Pro_riskScheme> selectRiskSchemeListByRiskScheme_ID(String wheresql) {
		List<Pro_riskScheme> newList = new ArrayList<Pro_riskScheme>();
		List<Pro_riskScheme> list = riskSchemeMapper.selectRiskSchemeListByRiskScheme_ID(wheresql);
		if (list != null) {
			for (Pro_riskScheme riskScheme : list) {
				List fileList = new ArrayList<>();
				if(null !=riskScheme){
					PageTable pageTable=new PageTable<>();
					String sql= " and  fileType = '08' and entityID = '"+riskScheme.getRiskScheme_ID()+"'";
					pageTable.setWheresql(sql);
					fileList  = pro_projectfilesMapper.selectProjectFilesPageTables(pageTable);
				}
				riskScheme.setFilesList(fileList);
				newList.add(riskScheme);
			}
		}
		return newList;
	}
    /**
     * 修改安排上会状态
     * 
     */
	@Override
	public Boolean updateMeetingStatus(User user, Pro_riskScheme riskScheme) {
		try {
			if(1==riskSchemeMapper.updateMeetingStatus(riskScheme)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
  
	}

package com.zjm.pro.onManagement.service.impl;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.map.Pro_meetingApplyMapper;
import com.zjm.pro.db.map.Pro_meetingMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingApply;
import com.zjm.pro.db.model.Pro_package;
import com.zjm.pro.onManagement.service.ProMeetingService;
import com.zjm.pro.projectPackage.service.PackageService;
import com.zjm.util.SystemSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * 上会管理
 */
@Service("proMeetingService")
@Transactional
public class ProMeetingServiceImpl implements ProMeetingService {
	@Resource
	private Pro_meetingMapper pro_meetingMapper;
	@Resource
	private Pro_meetingApplyMapper pro_meetingApplyMapper;
	@Resource
	private PackageService packageService;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
    private LogService logService;
	
	//查询所有的会议室
	public List<Pro_meeting> selectAllMeetingRooms(PageTable<Pro_meeting> pageTable){
		return pro_meetingMapper.selectAllMeetingRooms(pageTable);
	}
	@Override
	public Object insertOneMeetingApply(Pro_meeting meeting) {
		return pro_meetingMapper.insertOneMeetingApply(meeting);
	}
	//通过会议室名或得评审信息
	@Override
	public List<Pro_meeting> listByDuration(PageTable<Pro_meeting> pageTable) {
		
		return pro_meetingMapper.listByDuration(pageTable);
	}
	@Override
	public Integer insertOneMeetingApplyApply(Pro_meetingApply meetingApply) {
		return pro_meetingApplyMapper.insertOneMeetingApplyApply(meetingApply);
	}
	@Override
	public PageTable<Pro_meeting> selectMyProMeetingPageTable(PageTable<Pro_meeting> pageTable) {
		List<Pro_meeting> pro_meetingList = pro_meetingMapper.selectMyProMeetingPageTable(pageTable);
		
		for (Pro_meeting pro_meeting : pro_meetingList) {
			String meetingid = pro_meeting.getMeeting_ID();
			
			Map<String,Object> ret = getProjectNameList(meetingid);
			
			List<Map<String,Object>> projectNameList = (List<Map<String, Object>>) ret.get("projectNameList");
			List<Map<String,Object>> packageProNameList = (List<Map<String, Object>>) ret.get("packageProNameList");
//			pro_meeting.setProjectNameList(projectNameList);
//			pro_meeting.setPackageProNameList(packageProNameList);
		}
		
		pageTable.setRows(pro_meetingList);
		Long dicNodeTotal;
		try {
			dicNodeTotal = pro_meetingMapper.selectMyProMeetingPageTable_Count(pageTable);
			pageTable.setTotal(dicNodeTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	//根据id删除会议信息
	@Override
	public Long deleteOneEvaluItems(Pro_meeting meeting) {
		logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "会议管理", "添加", "添加一条会议申请");
		Pro_meetingApply pro_meetingApply = new Pro_meetingApply();
		
		String meeting_ID = meeting.getMeeting_ID();
		//修改申请、打包项目状态
		updateIsArrangeMeetingFalse(meeting_ID);
		
		pro_meetingApply.setMeeting_ID(meeting_ID);
		try {
			pro_meetingApplyMapper.deleteOneEvaluItems(pro_meetingApply);
			pro_meetingMapper.deleteOneEvaluItems(meeting);
			return 1L;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Pro_meeting showOneEvaluItemsViewPage(Pro_meeting meeting) {
		String meeting_ID = meeting.getMeeting_ID();
		meeting = pro_meetingMapper.showOneEvaluItemsViewPage(meeting_ID);

		
		Map<String,Object> ret = getProjectNameList(meeting_ID);
		
		List<Map<String,Object>> projectNameList = (List<Map<String, Object>>) ret.get("projectNameList");
		List<Map<String,Object>> packageProNameList = (List<Map<String, Object>>) ret.get("packageProNameList");
//		meeting.setProjectNameList(projectNameList);
//		meeting.setPackageProNameList(packageProNameList);
		
		

		return meeting;
	}
	/**
	 *  判断节点名称是否已存在
	 */
	@Override
	public Boolean isExistMeetingCode(Pro_meeting meeting) {
		if(pro_meetingMapper.isExistMeetingCode(meeting) == 0){
			return true;
		}else{
			return false;
		}
	}
	//获取pro_meetingApply所有信息
	@Override
	public List<Pro_meeting> selectMeetingApprovalList(String approvalStatus, String keyword) {
		String wheresql = " 1=1 and meetingStatus = '" + approvalStatus + "'";
		// keyword为会议室名称
		if (StringUtils.isNotEmpty(keyword)) {
			wheresql += " and meetingRoomName like '%" + keyword + "%'";
		}
		PageTable<Pro_meeting> pageTable = new PageTable<Pro_meeting>();
		pageTable.setWheresql(wheresql);

		List<Pro_meeting> statusList = null;
		try {
			statusList = pro_meetingMapper.selectMeetingInfoByMeetingStatus(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Pro_meeting meet : statusList) {
			String meeting_ID = meet.getMeeting_ID();
			
			Map<String,Object> ret = getProjectNameList(meeting_ID);
			
			List<Map<String,Object>> projectNameList = (List<Map<String, Object>>) ret.get("projectNameList");
			List<Map<String,Object>> packageProNameList = (List<Map<String, Object>>) ret.get("packageProNameList");
//			meet.setProjectNameList(projectNameList);
//			meet.setPackageProNameList(packageProNameList);
			String proNames = "";  
			for (int i=0;i<projectNameList.size();i++) {
				Map<String, Object> map = projectNameList.get(i);
				String str = (String) map.get("projectName");
				if(projectNameList.size() !=0 && packageProNameList.size()!=0){
					proNames = proNames+str+",";
				}else if(packageProNameList.size()==0){
					if(i==projectNameList.size()-1){
						proNames = proNames+str+"";
					}else{
						proNames = proNames+str+",";
					}
				}
				
			}
			
			for (int i=0;i<packageProNameList.size();i++) {
				Map<String, Object> map = packageProNameList.get(i);
				String str = (String) map.get("packageProName");
				
				if(projectNameList.size()!=0  && packageProNameList.size()!=0){
					if(i==packageProNameList.size()-1){
						proNames = ","+proNames+str+"";
					}else{
						proNames = ","+proNames+str+",";
					}
					proNames = ","+proNames+str+",";
				}else if(projectNameList.size()==0){
					if(i==packageProNameList.size()-1){
						proNames = proNames+str+"";
					}else{
						proNames = proNames+str+",";
					}
				}
			}
			
//			meet.setProNames(proNames);
		}
		
		return statusList;
	}
	//通过ID获取一条审批信息
	@Override
	public Pro_meeting selectOneApprovalInfoById(String meeting_ID) {
		Pro_meeting meeting = pro_meetingMapper.showOneEvaluItemsViewPage(meeting_ID);

		Map<String,Object> ret = getProjectNameList(meeting_ID);
		
		List<Map<String,Object>> projectNameList = (List<Map<String, Object>>) ret.get("projectNameList");
		List<Map<String,Object>> packageProNameList = (List<Map<String, Object>>) ret.get("packageProNameList");
//		meeting.setProjectNameList(projectNameList);
//		meeting.setPackageProNameList(packageProNameList);
		return meeting;
	}
	//上会审批--同意
	@Override
	public Integer approveMeeting(Pro_meeting meeting) {
		logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "上会审批", "同意", "批准一条上会申请记录");
		String meeting_ID = meeting.getMeeting_ID();
		//修改会议状态
		Integer meetCount=0;
		try {
			meetCount = pro_meetingMapper.updateMeetingStatusById(meeting_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetCount;
	}
	//上会申请--拒绝
	@Override
	public Integer rejectApproval(Pro_meeting meeting) {
		logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "上会申请", "拒绝", "拒绝上会申请");
		
		String meeting_ID = meeting.getMeeting_ID();
		updateIsArrangeMeetingFalse(meeting_ID);
		
		
		Integer rejectApprovalNum = 0;
		try {
			rejectApprovalNum = pro_meetingMapper.updateRejectReasonAndMeetingStatusById(meeting);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rejectApprovalNum;
	}
	//查看申请记录
	@Override
	public List<Pro_meeting> selectApplyRecordList(String approvalStatus, String keyword) {
		User user = SystemSession.getUserSession();
		String username = user.getUser_name();
		String wheresql = " 1=1 and meetingStatus = '"+approvalStatus+"' and updateUserName='"+username+"'";
		// keyword为会议室名称
		if (StringUtils.isNotEmpty(keyword)) {
			wheresql += " and meetingRoomName like '%" + keyword + "%'";
		}
		
		PageTable<Pro_meeting> pageTable = new PageTable<Pro_meeting>();
		pageTable.setWheresql(wheresql);

		List<Pro_meeting> statusList=new ArrayList<Pro_meeting>();
		try {
			statusList = pro_meetingMapper.selectMeetingInfoByMeetingStatus(pageTable);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Pro_meeting meet : statusList) {
			String meeting_ID = meet.getMeeting_ID();
			
			Map<String,Object> ret = getProjectNameList(meeting_ID);
			
			List<Map<String,Object>> projectNameList = (List<Map<String, Object>>) ret.get("projectNameList");
			List<Map<String,Object>> packageProNameList = (List<Map<String, Object>>) ret.get("packageProNameList");
//			meet.setProjectNameList(projectNameList);
//			meet.setPackageProNameList(packageProNameList);
			
			String proNames = "";  
			for (int i=0;i<projectNameList.size();i++) {
				Map<String, Object> map = projectNameList.get(i);
				String str = (String) map.get("projectName");
				if(projectNameList.size() !=0 && packageProNameList.size()!=0){
					proNames = proNames+str+",";
				}else if(packageProNameList.size()==0){
					if(i==projectNameList.size()-1){
						proNames = proNames+str+"";
					}else{
						proNames = proNames+str+",";
					}
				}
				
			}
			for (int i=0;i<packageProNameList.size();i++) {
				Map<String, Object> map = packageProNameList.get(i);
				String str = (String) map.get("packageProName");
				
				if(projectNameList.size()!=0  && packageProNameList.size()!=0){
					if(i==packageProNameList.size()-1){
						proNames = ","+proNames+str+"";
					}else{
						proNames = ","+proNames+str+",";
					}
					proNames = ","+proNames+str+",";
				}else if(projectNameList.size()==0){
					if(i==packageProNameList.size()-1){
						proNames = proNames+str+"";
					}else{
						proNames = proNames+str+",";
					}
				}
			}
//			meet.setProNames(proNames);
			
		}
		return statusList;
	}
	//上会申请-申请记录-撤销
	@Override
	public Integer revokeApplyRecord(Pro_meeting meeting) {
		logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "申请记录", "撤销", "撤销一条上会申请");
		String meeting_ID = meeting.getMeeting_ID();
		updateIsArrangeMeetingFalse(meeting_ID);
		Integer revokeNum = 0;
		try {
			revokeNum = pro_meetingMapper.updateRevokeMeetingStatusById(meeting);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revokeNum;
	}
	
	//上会申请-根据会议室ID删除上会信息
	@Override
	public Integer delApplyRecordByMeetingRoomID(String meetingRoomID) {
		Integer revokeNum = 0;
		try {
			logService.insertOneOperatorLogInfo(SystemSession.getUserSession(), "申请记录", "撤销", "撤销一条上会申请");
			List<Pro_meeting> meetingIdList = pro_meetingMapper.selectMeetingIdById(meetingRoomID);
			for (Pro_meeting pro_meeting : meetingIdList) {
				String meeting_ID = pro_meeting.getMeeting_ID();
				updateIsArrangeMeetingFalse(meeting_ID);
				// 删除pro_meetingApply里面有关数据
				int count1 = pro_meetingApplyMapper.delMeetingApplyBymeeting_ID(meeting_ID);
			}

			// 删除pro_meeting数据
			revokeNum = pro_meetingMapper.delMeetingByMeetingRoomID(meetingRoomID);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return revokeNum;
	}
	//通过会议室ID查询 评审会
	@Override
	public List<Pro_meeting> selectMeetingIdById(String meetingRoomID) {
		try {
			return pro_meetingMapper.selectMeetingIdById(meetingRoomID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//通过ID获取项目名称
	public Map<String, Object> getProjectNameList(String meeting_ID){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> projectNameList = new ArrayList<Map<String, Object>>();
		
		List<Map<String, Object>> packageProNameList = new ArrayList<Map<String, Object>>();
		
		List<Pro_meetingApply> meetingApplyList = new ArrayList<Pro_meetingApply>();
		try {
			meetingApplyList = pro_meetingApplyMapper.selectOneMeetingApplyById(meeting_ID);

			for (Pro_meetingApply pro_meetingApply : meetingApplyList) {
				String entityID = pro_meetingApply.getEntityID();
				String entityType = pro_meetingApply.getEntityType();
				if ("01".equals(entityType)) {
					Map<String, Object> proNameMap = new HashMap<String, Object>();
					String whereSql = " and apply_ID = \'" + entityID + "\'";
					Pro_apply apply;
					String projectName;
					String	proEntityID;//申请项目ID
					
					apply = projectApplyService.selectOneApplyByWhereSql(whereSql);
					if (apply != null) {
						projectName = apply.getProjectName();
						proEntityID = apply.getApply_ID();
						proNameMap.put("projectName", projectName);
						proNameMap.put("proEntityID", proEntityID);
						projectNameList.add(proNameMap);
					}

				} else if ("02".equals(entityType)) {
					Map<String, Object> proNameMap = new HashMap<String, Object>();
					String whereSql = " and package_ID = \'" + entityID + "\'";
					Pro_package pro_package;
					String projectName;
					String	packEagentityID;//打包项目ID
					
					pro_package = packageService.selectOnePackageByWhereSql(whereSql);
					if (pro_package != null) {
						packEagentityID = pro_package.getPackage_ID();
						projectName = pro_package.getPackageName();
						proNameMap.put("packageProName", projectName);
						proNameMap.put("packEagentityID", packEagentityID);
						packageProNameList.add(proNameMap);
					}

				}
			}
			map.put("projectNameList", projectNameList);
			map.put("packageProNameList", packageProNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	//修改 业务申请信息表pro_apply、pro_package 中的isArrangeMeeting的值 为0即为false
	public void updateIsArrangeMeetingFalse(String meeting_ID) {
		List<Pro_meetingApply> meetingApplyList = pro_meetingApplyMapper.selectOneMeetingApplyById(meeting_ID);
		for (Pro_meetingApply pro_meetingApply : meetingApplyList) {
			String entityID = pro_meetingApply.getEntityID();
			String entityType = pro_meetingApply.getEntityType();
			if ("01".equals(entityType)) {
				PageTable<Pro_apply> pageTable = new PageTable<Pro_apply>();
				// 修改 业务申请信息表pro_apply 中的isArrangeMeeting的值 为0即为false
				String whereSql = " apply_ID = \'" + entityID + "\' limit 1 ";
				pageTable.setWheresql(whereSql);
				try {
					projectApplyService.updateIsArrangeMeetingByIds(pageTable);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if ("02".equals(entityType)) {
				// 修改 打包表pro_package 中的isArrangeMeeting的值 为1即为false
				PageTable<Pro_package> pageTable = new PageTable<Pro_package>();
				String whereSql = " package_ID = \'" + entityID + "\' limit 1 ";
				pageTable.setWheresql(whereSql);
				try {
					packageService.updateIsArrangeMeetingByIds(pageTable);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

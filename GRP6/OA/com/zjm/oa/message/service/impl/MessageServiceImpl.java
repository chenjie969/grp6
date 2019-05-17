package com.zjm.oa.message.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.common.service.OaFileService;
import com.zjm.oa.db.map.Oa_messageMapper;
import com.zjm.oa.db.model.Oa_files;
import com.zjm.oa.db.model.Oa_message;
import com.zjm.oa.message.service.MessageService;

@Service("messageService")
@Transactional
public  class MessageServiceImpl implements MessageService {

	@Resource
	private Oa_messageMapper announceMapper;
	@Resource
	private LogService logService;
	@Resource
	private OaFileService oaFileService;

	/**
	 * 查询消息分页列表 
	 */
	public PageTable<Oa_message> selectAnnouncePageTable(PageTable<Oa_message> pageTable) {
		List<Oa_message> announceList=null;
		try {
			announceList = announceMapper.selectAnnouncePageTable(pageTable);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Long announceTotal = announceMapper.selectAnnouncePageTable_Count(pageTable);
		pageTable.setRows(announceList);
		pageTable.setTotal(announceTotal);
		return pageTable;
	}

	@Override
	public Boolean insertOneAnnounce(User user, Oa_message message) {
		message.setApprovalStatus("01");//状态:草稿
		message.setUnitUid(user.getUnit_uid());
		message.setUnitUidName(user.getUnit_uidName());
		message.setCreateUserId(user.getUser_uid());
		message.setCreateUserName(user.getUser_name());
		message.setCreateDateTime(new Date());
		message.setUpdateUserName(user.getUser_name());
		message.setUpdateDateTime(new Date());
		
		Integer insertOneAnnounce=0;
		try {
			insertOneAnnounce = announceMapper.insertOneAnnounce(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(insertOneAnnounce==1){
			logService.insertOneOperatorLogInfo(user,"新增通知","添加", "");
			return true;
		}else{
			return false;
		}
	}

	
	/**
	 * 批量删除信息记录
	 */
	@Override
 	public Boolean deleteAnnounceByIds(String rootPath,User user,Oa_message message) {
		try {
			Integer idNum1 = message.getDeleteIds().length;		//页面传来的消息实体ID数量
			Integer idNum2 = announceMapper.batchDeleteAnnounceByIDs(message);  	//成功删除的条数
			List<Oa_files> oaFilesList = oaFileService.selectOaFilesList(message.getDeleteIds());
			//信息附件物理删除
			for (Oa_files oa_files : oaFilesList) {
				File file = new File(rootPath + oa_files.getPathFile());
				if (file.isFile() && file.exists()) {//路径为文件且不为空则进行删除
					file.delete();
				}
			}
			//删除实体在oafile表中的数据
			oaFileService.deleteOaFilesForEntities(message.getDeleteIds());
			if(idNum1==idNum2){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 更新一条信息记录
	 */
	@Override
	public Boolean updateOneAnnounce(User user, Oa_message message) {
		if(announceMapper.updateOneAnnounce(message)==1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 提交审核
	 */
	@Override
	public Boolean updateStatusToNoCheck(User user, Oa_message message) {
		message.setApprovalStatus("02");
		message.setUpdateUserName(user.getUser_name());
		message.setUnitUid(user.getUnit_uid());
		if(announceMapper.updateStatus(message)==1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 查询一条信息记录
	 */
	@Override
	public Oa_message selectOneAnnounce(Oa_message message) {
		return announceMapper.selectOneAnnounce(message);
	}
	/**
	 * 审核通过
	 */
	@Override
	public Boolean updateStatusToYesCheck(User user, Oa_message message) {
		message.setApprovalStatus("04");//审核通过
		message.setUpdateUserName(user.getUser_name());
		message.setUnitUid(user.getUnit_uid());
		message.setNoSignUserIdList(message.getReceiveUserIdList());
		message.setNoSignUserNameList(message.getReceiveUserNameList());
		message.setApprovalUserId(user.getUser_uid());
		message.setApprovalUserName(user.getUser_name());
		if(announceMapper.updateStatusToYesCheck(message)==1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 被退回
	 */
	@Override
	public Boolean updateStatusToBounced(User user, Oa_message message) {
		message.setApprovalStatus("03");//审核退回
		message.setUpdateUserName(user.getUser_name());
		message.setApprovalUserId(user.getUser_id());
		message.setApprovalUserName(user.getUser_name());
		message.setUnitUid(user.getUnit_uid());
		if(announceMapper.updateStatusBounced(message)==1){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 首页获取通知List
	 */
	@Override
	public List<Oa_message> selectMessageList(String wheresql) {
		return announceMapper.selectMessageList(wheresql);
	}
	
	
	/**
	 * 修改为"已签收"状态
	 * 	即 将当前登录用户的 ID&name 从未签收人员名单中删除, 并添加到已签收人员名单中
	 */
	@Override
	public Boolean updateStatusToYesSign(User user, Oa_message message) {
		//根据ID查询该条消息详情
		try {
			message = announceMapper.selectOneAnnounce(message);
			
			List<String> noSignUserIDList = new ArrayList<>(Arrays.asList(message.getNoSignUserIdList().split(",")));
			List<String> noSignUserNameList = new ArrayList<>(Arrays.asList(message.getNoSignUserNameList().split(",")));
			
			//遍历未签收者名单,找到当前用户并移除
			for(int i=0; i<noSignUserIDList.size(); i++ ){		
				if(noSignUserIDList.get(i).equals(user.getUser_uid())){	
					noSignUserIDList.remove(i);
					noSignUserNameList.remove(i);
					break;
				}
			}
			String noSignUserIDStr = org.apache.commons.lang.StringUtils.join(noSignUserIDList, ",");
			String noSignUserNameStr = org.apache.commons.lang.StringUtils.join(noSignUserNameList, ",");
			message.setNoSignUserIdList(noSignUserIDStr);
			message.setNoSignUserNameList(noSignUserNameStr);
			
			//在已签收者名单中加入当前用户
			String signedUserIdStr = message.getSignedUserIdList();
			String signedUserNameStr = message.getSignedUserNameList();
			if(signedUserIdStr==null || "".equalsIgnoreCase(signedUserIdStr)){
				message.setSignedUserIdList(user.getUser_uid());
				message.setSignedUserNameList(user.getUser_name());
			}else{
				message.setSignedUserIdList(signedUserIdStr+","+user.getUser_uid());
				message.setSignedUserNameList(signedUserNameStr+","+user.getUser_name());
			}
			
			if(announceMapper.updateStatusToYesSign(message)==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Long selectTable_Count(String whersql) {
		return announceMapper.selectTable_Count(whersql);
	}
}

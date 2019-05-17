package com.zjm.oa.message.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Oa_message;

public interface MessageService {

	/**
	 * 查询信息分页列表
	 */
	public PageTable<Oa_message> selectAnnouncePageTable(PageTable<Oa_message> pageTable);
	/**
	 * 查询一条信息记录
	 */
	public Oa_message selectOneAnnounce(Oa_message message);
	
	/**
	 * 插入一条信息记录
	 */
	public Boolean insertOneAnnounce(User user,Oa_message message);
	
	/**
	 * 更新一条信息记录
	 */
	public Boolean updateOneAnnounce(User user,Oa_message message);
	
	/**
	 * 申请审批,修改状态为"未审核"
	 * @param message
	 * @return
	 */
	public Boolean updateStatusToNoCheck(User user,Oa_message message);
	/**
	 * 申请审批,修改状态为"已审核"
	 * @param message
	 * @return
	 */
	public Boolean updateStatusToYesCheck(User user,Oa_message message);
	/**
	 * 申请审批,修改状态为"已退回"
	 * @param message
	 * @return
	 */
	public Boolean updateStatusToBounced(User user,Oa_message message);
	/**
	 * 申请审批,修改状态为"已签收"
	 * @param message
	 * @return
	 */
	public Boolean updateStatusToYesSign(User user,Oa_message message);
	/**
	 * 
	 * 删除一条申请记录
	 */ 
 	public Boolean deleteAnnounceByIds(String rootPath,User user,Oa_message announce);
 	
 	/**
 	 * 首页获取消息List
 	 */
	List<Oa_message> selectMessageList(String wheresql);
	/**
	 * 查询总记录数
	 */
	public Long selectTable_Count(String whersql);
}

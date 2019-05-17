package com.zjm.oa.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;

import com.zjm.crm.db.model.Crm_relationMain;
/*import com.zjm.oa.db.model.Oa_info;*/

import com.zjm.oa.db.model.Oa_message;

public interface Oa_messageMapper {

	/**
	 * 查询信息分页列表
	 */
	public List<Oa_message> selectAnnouncePageTable(PageTable<Oa_message> pageTable);
	
	/**
	 * 查询信息分页列表--查询总记录数
	 */
	public Long selectAnnouncePageTable_Count(PageTable<Oa_message> pageTable);
	
	/**
	 * 新增一条信息记录
	 */
	public Integer insertOneAnnounce(Oa_message message);
	
	
	/**
	 * 修改一条信息记录
	 */
	public Integer updateOneAnnounce(Oa_message message);
	/**
	 * 提交审核,修改状态为"未审核"
	 * @param message
	 * @return
	 */
	public Integer updateStatus(Oa_message message);
	/**
	 * 审核通过
	 * @param message
	 * @return
	 */
	public Integer updateStatusToYesCheck(Oa_message message);
	/**
	 * 申请审批,修改状态为"被退回"
	 * @param message
	 * @return
	 */
	public Integer updateStatusBounced(Oa_message message);
	/**
	 * 查看一条信息记录
	 */
	public Oa_message selectOneAnnounce(Oa_message message);
	
	/**
	 * 申请审批,修改状态为"已签收"
	 * @param message
	 * @return
	 */
	public Integer updateStatusToYesSign(Oa_message message);
	
	/**
	 * bdan
	 * 删除一条信息记录
	 */ 
	public Integer deleteOneAnnounce(Oa_message announce);
	/**
	 * 批量删除
	 */
	public Integer batchDeleteAnnounceByIDs(Oa_message announce);
	/**
	 * 根据主体ID查询主体名称
	 */
	public String selectAnnounceNameByID(String messageId);
	/**
	 * 获取登录List
	 */ 
	public List<Oa_message> selectMessageList(String wheresql);
	
	/**
	 * 查询信息分页列表--查询总记录数
	 */
	public Long selectTable_Count(String sql);
	 
}

package com.zjm.oa.db.map;


import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.gbpm.db.model.Act_re_actSort;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.sys.db.model.Sys_users;

public interface Hr_staffCaseMapper {
	/**
	 * 劳动合同、员工生日查询List
	 * @param staffCase
	 * @return
	 */
	public List<Hr_staffCase> selectContractBirthdayList(PageTable pageTable);
	/**
	 * 劳动合同、员工生日查询Count
	 * @param staffCase
	 * @return
	 */
	public Long selectContractBirthdayCount(PageTable pageTable);
	/**
	 * 查询用户列表    分页列表
	 */
	public List<Hr_staffCase> selectStaffCaseTables(PageTable pageTable);
	/**
	 * 查询用户列表    总记录数
	 */
	public Long selectStaffCaseTables_Count(PageTable pageTable);
	/**
	 * 根据员工id查出该员工
	 */	
	public Hr_staffCase selectOneStaffCaseInfo(Hr_staffCase hr_staffCase);	
	/**
	 * 判断case表是否有此名字
	 */
	public Integer selectStaffCaseNameIsExist(String wheresql);
	/**
	 * 更新	
	 */
	public Integer updateOneStaffCaseInfo(Hr_staffCase hr_staffCase);
	/**
	 * 更新离职信息
	 */
	public Integer updateOneDismissonInfo(Hr_staffCase hr_staffCase);
	/**
	 * 插入一条信息
	 */
	public Integer insertOneStaffCaseInfo(Hr_staffCase hr_staffCase);
	/**
	 * 根据职工表作为主表查询
	 */
	public Hr_staffCase selectOneStaffCaseInfo1(Hr_staffCase hr_staffCase);	
	/**
	 * 删除职工表的一条记录
	 */
	public Integer deleteOneStaffCaseInfo(Hr_staffCase hr_staffCase) ;
	
}

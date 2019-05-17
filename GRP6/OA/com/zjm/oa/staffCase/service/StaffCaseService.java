package com.zjm.oa.staffCase.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.sys.db.model.Sys_roles;

public interface StaffCaseService {
     /**
      * 
      * 查询员工合同、员工生日
      * @param pageTable
      * @return
      */
	public PageTable selectContractBirthdayPageTable(PageTable pageTable);

	/**
	 * 查询员工用户列表   
	 */	
	public PageTable<Hr_staffCase> selectStaffCaseTables(PageTable<Hr_staffCase> pageTable);	
	/**
	 * 根据员工id查出该员工
	 */	
	public Hr_staffCase selectOneStaffCaseInfo(Hr_staffCase hr_staffCase);	
	/**
	 * 判断此员工是否存在
	 */
	public Boolean selectStaffCaseNameIsExist(String wheresql) ;
	/**
	 * 更新	
	 */
	public Boolean updateOneStaffCaseInfo(Hr_staffCase hr_staffCase);
	/**
	 * 更新离职信息
	 */
	public Boolean updateOneDismissonInfo(Hr_staffCase hr_staffCase);
	/**
	 * 插入
	 */
	public Boolean insertOneStaffCaseInfo(Hr_staffCase hr_staffCase,User userSession);
	/**
	 * 员工表作为主表查询一条记录
	 */
	public Hr_staffCase selectOneStaffCaseInfo1(Hr_staffCase hr_staffCase);	
	/**
	 * 删除员工
	 */
	public Boolean deleteOneStaffCaseInfo(Hr_staffCase hr_staffCase);
	/**
	 * 员工离职
	 */
	public Boolean disMission(Hr_staffCase hrstaffCase);
}

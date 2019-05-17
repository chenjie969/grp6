package com.zjm.pro.project.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zjm.common.db.model.User;

public interface TestService {
	public  int updateDelayPerio();
	
	public int updateUnDelayPerio();

	/**
	 * 删除项目以及与项目有关的相关信息
	 * @return
	 */
	public Boolean deleteProjectAndRelationInfo(String projectId);

	/**
	 * 删除风险处置审批
	 * @return
	 */
	public Boolean deleteRiskInfo(String riskSchemeID);
	
	/**
	 * 修改资金方分类
	 * @param substring
	 * @param list2
	 * @param sysUser
	 * @param now
	 */
	public void updateFundExcel(String substring, List<Map> list2, User sysUser, Date now);
	
	/**
	 * 修改合作机构（资金方）分类--添加子级
	 * @param substring
	 * @param list2
	 * @param sysUser
	 * @param now
	 */
	public void updateBankExcel(String substring, List<Map> list2, User sysUser, Date now);

	/**
	 * 完结项目处理
	 * @param substring
	 * @param list2
	 * @param sysUser
	 * @param now
	 */
	public void updateFinishPro(String substring, List<Map> list2, User sysUser, Date now);

	/**
	 * 完结项目处理
	 * @param substring
	 * @param list2
	 * @param sysUser
	 * @param now
	 */
	public void updateFinishPro();

	/**
	 * 修改客户行业分类
	 * @param substring
	 * @param list2
	 * @param sysUser
	 * @param now
	 */
	public void updateClientFullTrade(String substring, List<Map> list2, User sysUser, Date now);

	public int updateProJectDelayDate();


}

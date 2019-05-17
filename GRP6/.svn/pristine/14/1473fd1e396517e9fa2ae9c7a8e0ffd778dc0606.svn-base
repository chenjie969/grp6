package com.zjm.oa.socialInsurance.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Hr_socialInsurance;

public interface SocialInsuranceService {
	/**
	 * 插入一条社会保险
	 * @param user
	 * @param socialInsurance
	 * @return
	 */
  public Boolean insertOneSocialInsurance(User user,Hr_socialInsurance socialInsurance);
  /**
   * 更改一条社会保险
   * @param user
   * @param socialInsurance
   * @return
   */
  public Boolean updateOneSocialInsurance(User user,Hr_socialInsurance socialInsurance);
 /**
  * 查询一条社会保险
  * @param socialInsuranceID
  * @return
  */
  public Hr_socialInsurance selectOneSocialInsurance(String socialInsuranceID);
  /**
   * 查询社会保险表
   * @param pageTable
   * @return
   */
  public PageTable<Hr_socialInsurance> selectSocialInsuranceTable(PageTable<Hr_socialInsurance> pageTable);
}

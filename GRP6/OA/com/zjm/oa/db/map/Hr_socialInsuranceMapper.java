package com.zjm.oa.db.map;

import java.util.List;
import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_socialInsurance;

public interface Hr_socialInsuranceMapper {
  /**
   * 插入一条社会保险
   * @param socialInsurance
   * @return
   */
	public Integer insertOneSocialInsurance(Hr_socialInsurance socialInsurance);
	
	/**
	 * 更新一条社会保险
	 * @param socialInsurance
	 * @return
	 */
	public Integer updateOneSocialInsurance(Hr_socialInsurance socialInsurance);
	/**
	 * 
	 * 查询社会保险表
	 * @param pageTable
	 * @return
	 */
	
	public List<Hr_socialInsurance> selectSocialInsuranceTable(PageTable pageTable);
	/**
	 * 查询一条社会保险险
	 * @param socialInsuranceID
	 * @return
	 */
	public Hr_socialInsurance selectOneSocialInsurance(String socialInsuranceID);
}

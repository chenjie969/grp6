package com.zjm.oa.socialInsurance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.db.map.Hr_socialInsuranceMapper;
import com.zjm.oa.db.model.Hr_socialInsurance;
import com.zjm.oa.socialInsurance.service.SocialInsuranceService;
import com.zjm.util.Tool;
@Service("socialInsuranceService")
@Transactional
public class SocialInsuranceServiceImpl implements SocialInsuranceService {
	@Resource
	private Hr_socialInsuranceMapper socialInsuranceMapper;
	@Resource
	private LogService logService;
    /**
     * 插入一条社会保险
     * 
     */
	@Override
	public Boolean insertOneSocialInsurance(User user, Hr_socialInsurance socialInsurance) {
		
		socialInsurance.setSocialInsuranceID(Tool.createUUID32());
		if (socialInsuranceMapper.insertOneSocialInsurance(socialInsurance)==1){
			logService.insertOneOperatorLogInfo(user, "社保缴纳", "添加 ", "添加社保缴纳"+socialInsurance.getSocialInsuranceID());
			return true;
		}else {
			return false;
		}
		
	}
     /**
      * 更改一条社会风险
      * 
      */
	@Override
	public Boolean updateOneSocialInsurance(User user, Hr_socialInsurance socialInsurance) {
		if(socialInsuranceMapper.updateOneSocialInsurance(socialInsurance)==1){
			logService.insertOneOperatorLogInfo(user, "社保缴纳", "修改", "修改社保缴纳"+socialInsurance.getSocialInsuranceID());
			return true;	
		}
		else{
		return false;
		}
	}
    /**
     * 查询一条社会保险
     */
	@Override
	public Hr_socialInsurance selectOneSocialInsurance(String socialInsuranceID) {
		return socialInsuranceMapper.selectOneSocialInsurance(socialInsuranceID);
	}
    /**
     * 查询社会保险表
     * 
     */
	@Override
	public PageTable<Hr_socialInsurance> selectSocialInsuranceTable(PageTable<Hr_socialInsurance> pageTable) {
		List <Hr_socialInsurance> list =socialInsuranceMapper.selectSocialInsuranceTable(pageTable);
		pageTable.setRows(list);
		return pageTable;
	}

}

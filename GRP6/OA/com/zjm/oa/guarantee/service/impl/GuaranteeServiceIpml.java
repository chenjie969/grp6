package com.zjm.oa.guarantee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.db.map.Hr_staffCaseMapper;
import com.zjm.oa.db.map.Hr_staffGuaranteeMapper;
import com.zjm.oa.db.model.Hr_staffCase;
import com.zjm.oa.db.model.Hr_staffGuarantee;
import com.zjm.oa.guarantee.service.GuaranteeService;
import com.zjm.util.Tool;
@Service("GuaranteeService")
@Transactional
public class GuaranteeServiceIpml implements GuaranteeService {
	@Resource
	private Hr_staffGuaranteeMapper guaranteeMapper;
	@Resource
	private Hr_staffCaseMapper hr_staffCaseMapper;
	@Resource
	private LogService logService;
        /**
         * 增加一个担保记录
         */
	@Override
	public Boolean insertOneGuarantee(User user, Hr_staffGuarantee guarantee) {
		if (guarantee.getStaffcase_Id() == null || "".equals(guarantee.getStaffcase_Id())) {
			
			Hr_staffCase hr_staffCase = new Hr_staffCase();
			hr_staffCase.setStaffcase_Id(Tool.createUUID32());
			hr_staffCase.setUnit_uid(user.getUnit_uid());
			hr_staffCase.setUser_uid(guarantee.getUser_uid());
			hr_staffCaseMapper.insertOneStaffCaseInfo(hr_staffCase);
		}
	    guarantee.setGuaranteeID(Tool.createUUID32());
		if( guaranteeMapper.insertOneGuarantee(guarantee)==1){
			
			logService.insertOneOperatorLogInfo(user, "担保记录", "添加", "添加担保记录"+guarantee.getGuaranteeID());
			return true;
		}
		else {
			return false;
		}
	}
      /**
       * 更新一个担保记录
       * 
       */
	@Override
	public Boolean updateOneGuarantee(User user, Hr_staffGuarantee guarantee) {
		Integer returnInt = 0;
		try {
			returnInt = guaranteeMapper.updateOneGuarantee(guarantee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "担保记录", "修改","修改担保记录"+guarantee.getGuaranteeID());
			return 	true;
		}else{
			return false;
		}
	}
    /**
     *查询一个担保记录
     */
	@Override
	public Hr_staffGuarantee selectOneGuarantee(String guaranteeID) {
	
		return guaranteeMapper.selectOneGuarantee(guaranteeID);
	
		
	}
      /**
       * 查询担保记录表
       * 
       */
	@Override
	public PageTable<Hr_staffGuarantee> selectGuaranteeTable(PageTable<Hr_staffGuarantee> pageTable) {
	     List<Hr_staffGuarantee> list= guaranteeMapper.selectGuaranteeTable(pageTable);
	     pageTable.setRows(list);
		return pageTable;
	}

}

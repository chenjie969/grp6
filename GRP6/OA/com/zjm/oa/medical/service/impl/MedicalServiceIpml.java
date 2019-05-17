package com.zjm.oa.medical.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.db.map.Hr_medicalMapper;
import com.zjm.oa.db.model.Hr_medical;
import com.zjm.oa.medical.service.MedicalService;
import com.zjm.util.Tool;
@Service("medicalService")
@Transactional
public class MedicalServiceIpml implements MedicalService {
	@Resource
	private Hr_medicalMapper hr_medicalMapper;
	@Resource
	private LogService logService;
      /**
       * 增加一条体检记录
       * 
       */
	@Override
	public Boolean insertOneMedical(User user, Hr_medical medical) {
		
         medical.setMedicalID(Tool.createUUID32());
		if( hr_medicalMapper.insertOneMedical(medical)==1){
			logService.insertOneOperatorLogInfo(user, "体检记录", "添加", "添加体检记录"+medical.getMedicalID());
			return true;
		}
		else{
			return false;
		}
	}
   /**
    * 
    * 更改一条体检记录
    */
	@Override
	public Boolean updateOneMedical(User user, Hr_medical medical) {
		Integer returnInt = 0;
		try {
			returnInt = hr_medicalMapper.updateOneMedical(medical);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "体检记录", "更改", "更改体检记录"+medical.getMedicalID());
			return 	true;
		}else{
			return false;
		}
	}
  /**
  *查询一条体检记录 
  * 
  * 
  */
	@Override
	public Hr_medical selectOneMedical(String medicalID) {
		
		return hr_medicalMapper.selectOneMedical(medicalID);
	}
     /**
      * 查询体检记录表
      * 
      */
	@Override
	public PageTable<Hr_medical> selectMedicalTable(PageTable<Hr_medical> pageTable) {
		List<Hr_medical> list = hr_medicalMapper.selectMedicalTable(pageTable);		
		pageTable.setRows(list);
		return pageTable;
	}

}

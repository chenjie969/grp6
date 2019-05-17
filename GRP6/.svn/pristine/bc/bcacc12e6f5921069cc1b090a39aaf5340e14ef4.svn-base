package com.zjm.oa.training.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.oa.db.map.Hr_trainingMapper;
import com.zjm.oa.db.model.Hr_training;
import com.zjm.oa.training.service.TrainingService;
import com.zjm.util.Tool;
@Service("TrainingService")
@Transactional
public class TrainingServiceImpl implements TrainingService {
	@Resource
     private Hr_trainingMapper trainingMapper;
	@Resource
	private LogService logService;
	/**
	 * 插入一条培训记录
	 * 
	 */
	@Override
	public Boolean insertOnetraining(User user, Hr_training training) {
		
		    training.setTrainingID(Tool.createUUID32());
		  if( trainingMapper.insertOneTraining(training)==1 ){
			logService.insertOneOperatorLogInfo(user, "培训记录", "添加", "添加培训记录"+training.getTrainingID());
			return true;
		    }
		 else {
			   return false;
		      }
	}
	/**
	 * 更改一条培训记录
	 * 
	 */
	@Override
	public Boolean updateOneTraining(User user, Hr_training training) {
	
		Integer returnInt = 0;
		try {
			returnInt = trainingMapper.updateOneTraining(training);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "培训记录", "修改", "修改培训记录"+training.getTrainingID());
			return 	true;
		}else{
			return false;
		}
	}
	/**
	 * 查询一条培训记录 
	 * 
	 */
	@Override
	public Hr_training selectOneTraining(String trainingID) {
	
		return trainingMapper.selectOneTraining(trainingID);
	}
	/**
	 * 查询培训列表
	 * 
	 */
	@Override
	public PageTable<Hr_training> selectTrainingTable(PageTable<Hr_training> pageTable) {
	     List<Hr_training> list =trainingMapper.selectTrainingTable(pageTable);
	     pageTable.setRows(list);
		return pageTable;
	}

	
}

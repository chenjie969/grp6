package com.zjm.oa.training.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Hr_training;

public interface TrainingService {
	/**
	 * 增加一条培训记录
	 * @param user
	 * @param training
	 * @return
	 */
 public Boolean insertOnetraining(User user ,Hr_training training);
 /**
  * 更新一条培训记录
  * @param user
  * @param training
  * @return
  */
 public Boolean updateOneTraining(User user,Hr_training training);
 /**
  * 查询一条培训记录
  * 
  */
 public Hr_training selectOneTraining(String TrainingID);
 /**
	 * 查询培训记录表
	 * @param pageTable
	 * @return
	 */
public PageTable<Hr_training>selectTrainingTable(PageTable<Hr_training> pageTable);
}

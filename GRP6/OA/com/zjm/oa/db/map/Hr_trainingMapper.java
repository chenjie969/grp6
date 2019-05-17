package com.zjm.oa.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.oa.db.model.Hr_training;

    public interface Hr_trainingMapper {
    	
	/**
	 * 插入一条培训记录
	 * @param training
	 * @return
	 */
	public  Integer insertOneTraining(Hr_training training);
	/**
	 * 增加一条培训记录
	 * @param training
	 * @return
	 */
	public Integer updateOneTraining(Hr_training training);
	/**
	 * 查询培训记录表
	 * @param pageTable
	 * @return
	 */
	public  List<Hr_training> selectTrainingTable(PageTable pageTable);
    /**
     * 查询一条培训记录
     * @param trainingID
     * @return
     */
	public  Hr_training selectOneTraining(String trainingID);

}

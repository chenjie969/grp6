package com.zjm.pro.analysis.service;

import java.util.ArrayList;

import com.zjm.pro.db.model.EChart;
import com.zjm.pro.db.model.Pro_project;

public interface AnalysisService {
	
	

	/**
	 *  1-12月统计金额(表格)
	 * @author zky 
	 * @time 2017-7-27
	 * @return
	 */
	public ArrayList<ArrayList<Double>>  analysisTableOfMonthSum(String whereSql);
	
	/**
	 *  1-12月统计金额(折线图)
	 * @param wheresql(年份)
	 * @return
	 */
	public EChart analysisOfMonthSum(String wheresql);
   /**
    *  1-12月统计笔数(表格)
    * @param wheresql
    * @return
    */
	public ArrayList<ArrayList<Integer>> analysisTableOfMonthCount(String wheresql);
    /**
     *  1-12月统计笔数(折线图)
     * @param wheresql
     * @return
     */
    public EChart analysisEchartsOfMonthCount(String wheresql);
    
    
    /**
     * 根据业务品种分类统计
     * @author zky
     * @time :2017-8-1
     * @return
     */
	public ArrayList<ArrayList<String>>  analysisByClassOfBusiType();
    /**
     * 根据业务部门分类统计
     * @author zky
     * @time :2017-8-2
     * @return
     */
	public ArrayList<ArrayList<String>> analysisByClassOfDepartMent();
	/**
     * 根据合作机构分类统计
     * @author zky
     * @time :2017-8-2
     * @return
     */
	public ArrayList<ArrayList<String>> analysisByClassOfBankName();
	/**
     * 根据部门经理统计
     * @author zky
     * @time :2017-8-2
     * @return
     */
	public ArrayList<ArrayList<String>> analysisByClassOfAMan();
	
    /**
     * 按年份统计金额(表格)
     * @author zky
     * @return
     */
	public ArrayList<Pro_project> analysisTableOfYearsSum();
	/**
     * 按年份统计笔数(表格)
     * @author zky
     * @return
     */
	public ArrayList<Pro_project> analysisTableOfYearsCount();
	/**
	 *  按年份统计金额(折线图)
	 * @author zky
	 * @return
	 */
	public EChart analysisOfYearsSum();
	/**
	 *  按年份统计笔数(折线图)
	  * @author zky
	 * @return
	 */
	public EChart analysisEchartsOfYearsCount();
    /**
     * 各公司清收清欠占比
     * @param wheresql
     * @return
     */
	public EChart analysisOfEachCompany();
   /**
    * 清收清欠费用占比
    * @param wheresql
    * @return
    */
	public EChart analysisOfCostCompare();
    /**
     * 2017年五级分类各担保余额压降比例
     * @return
     */
    public EChart analysisOfFiveClass();
    /**
     * 2017年担保压降额及预测
     * @return
     */
	public EChart analysisOfGuarantySumDrop();

	/**
	 * 按业务大类统计
	 */
	public EChart busiClassStatistics();

	/**
	 * 清收清欠费用占比2018
	 * @return
	 */
	public EChart analysisOfCostCompareF();

	/**
	 *  获取 当年委贷余额折线图
	 * @return
	 */
	public EChart analysisOfEntrustGuarantySumDrop();
    
	
	
	
}

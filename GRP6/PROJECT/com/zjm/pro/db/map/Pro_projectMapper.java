package com.zjm.pro.db.map;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.MapKey;

import com.google.gwt.i18n.client.Messages.Select;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_factPay;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.db.model.Pro_relationProjectVo;
/**
 * 保后（贷后）产品放款明细表pro_project   mapper
 */
public interface Pro_projectMapper {
	/**
	 * 根据wheresql查询一个保后（贷后）产品放款明细表信息
	 * @param wheresql:
	 * @return Pro_apply
	 */
	public Pro_project selectOneProjectWhereSql(String wheresql);
    
	/**
	 * 更新保后（贷后）产品放款明细表信息
	 * @param string
	 */
	public Integer updateOneProjectInfo(Pro_project project);
	
	/**
	 * @description		分页列表数
	 * @author wuhn
	 * @date 2017年8月25日 下午2:16:50
	 */
	List<Pro_project> selectProjectPageTables(PageTable<Pro_project>  pageTable);
	
	/**
	 * @description	总记录数
	 * @author wuhn
	 * @date 2017年8月25日 下午2:16:59
	 */
	Long  selectProjectPageTables_Count(PageTable<Pro_project>  pageTable);

	public List<Pro_project> selectCheckProjectPageTables(PageTable<Pro_project> pageTable);

	public Long selectCheckProjectPageTables_Count(PageTable<Pro_project> pageTable);
	
	/**
	 * 添加一条实际放款信息
	 */
	public Integer insertOneProjectInfo(Pro_project project);
	
	/**
	 * 更新提前到期信息
	 */
	public Integer updateBeforeEndInfo(Pro_project project);

	/**
	 * @description	 sql语句完全由service层传递
	 * @author xuyz
	 */
	@MapKey("relationMain_ID")
	public HashMap<String, HashMap<String, Object>> selectMapBySql(String sql);
	
	/**
	 * 查询关联系项目列表
	 * @author xuyz
	 */
	public List<Pro_relationProjectVo> selectRelationProjectTable(PageTable<Pro_relationProjectVo> pageTable);
	/**
	 * 查询关联系项目列表总数
	 * @author xuyz
	 */
	public Long selectRelationProjectTable_count(PageTable<Pro_relationProjectVo> pageTable);

    /**
     *  删除一个保后项目
     * @param whereSql
     * @return
     */
	public Integer deleteOneProjectAfterBySql(String whereSql);
   /**
    * 查询多个保后项目
    * @param whereSql
    * @return projectList
    */
	public List<Pro_project> selectProjectListByWheresql(String whereSql);
	
	/**
	 * 还款与代偿列表分页查询 
	 */
	List<Pro_project> selectDutyRemovePage(PageTable<Pro_project>  pageTable);
	/**
	 * @description	 还款与代偿列表分页查询   总记录数
	 * @author wzk
	 */
	Long  selectDutyRemovePage_Count(PageTable<Pro_project>  pageTable);

	public Integer updateDutyRemove(Pro_project project);

	public Pro_project selectProjectDataWhereSql(String wheresql);
   /**
    * 
    * @Title: selectRelationClientProTable   
    * @Description:  查询某关联系下的所有关联企业及项目信息
    * @param: @param pageTable
    * @param: @return      
    * @return: List<Pro_project>      
    * @throws
    */
	public List<Pro_project> selectRelationClientProTable(PageTable<Pro_project> pageTable);
    /**
     * 
     * @Title: selectRelationClientProTable_count   
     * @Description:  查询某关联系下的所有关联企业及项目信息 _总记录数
     * @param: @param pageTable
     * @param: @return      
     * @return: Long      
     * @throws
     */
    public Long selectRelationClientProTable_count(PageTable<Pro_project> pageTable);
	
    public List<Pro_project> selectDelay();
    
    public  List<Pro_project> selectUnDelay();
    
    public  int updatePeriod(Pro_project project);

	public List<Pro_project> selectProjectListForInterestByWheresql(String string);

	/**
	 * 根据还款时间统计在保余额
	 * @param dateStr
	 * @return
	 */
	public Pro_project countGuarantySumForFactDate(Pro_factPay pro_factPay);

	public List<Pro_project> selectProjectISLawsuitByWheresql(String string);

	public List<Pro_project> selectProjectNotLawsuitByWheresql(String string);

	public List<Pro_project> projectCostCount(String string);

	/**
	 * 修改项目名称与客户名称不一致
	 */
	public List<Pro_project> updateProjectName();

	public List<Pro_project> projectCostRiskLevel(String string);
	
	/**
	 * 根据关系名查询项目合计金额
	 */
	public BigDecimal findSumByRelationMainName(String relationMainName);
}

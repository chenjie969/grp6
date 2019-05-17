package com.zjm.pro.db.map;

import java.util.List;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_delay;
import com.zjm.pro.db.model.pro_manageRreviewModeExcel;
import com.zjm.pro.db.model.pro_meetingExportModeExcel;
import com.zjm.pro.db.model.pro_reviewCommitteeModeExcel;

/**
 * 业务展期信息表pro_delay   mapper
 */
public interface Pro_delayMapper {
	/**
	 * 
	 * @description 新增一条业务展期信息表pro_delay
	 */
	public Integer insertOneDelayInfo(Pro_delay delay);
	/**
	 * 返回展期信息表分页列表
	 * @param pageTable
	 * @author ZKY
	 * @return
	 */
	public List<Pro_delay> selectDelayTables(PageTable pageTable);
	/**
	 * 返回展期信息表分页列表   总记录数
	 * @param pageTable
	 * @author ZKY
	 * @return
	 */
	public Long selectDelayTables_Count(PageTable pageTable);
	/**
	 * 根据输入的条件删除一条展期表信息
	 * @param userSession
	 * @param whereSql delay_ID
	 * @return
	 */
	public Integer deleteDelayByWhereSql(String whereSql);
	/**
	 * 根据输入的条件查询单个展期信息
	 * @param whereSql
	 * @return
	 */
	public Pro_delay selectOneDelayByWhereSql(String whereSql);
	/**
	 * 修改展期登记
	 * @param pro_delay
	 * @return
	 */
	public Integer updateOneDelay(Pro_delay pro_delay);
	/**
	 * 根据业务id获取多个展期表信息
	 * @param whereSql2
	 * @return
	 */
	public List<Pro_delay> selectDelayListByWhereSql(String whereSql2);
	/**
	 * @param whereSql
	 * @return 查询一条展期信息
	 */
	public Pro_delay selectOneDelayInfoByID(String whereSql);
	/**
	 * @param delay
	 * @return 展期修改
	 */
	public Integer updateProDelay(Pro_delay delay);
	/**
	 * 查询**经理办公会评议项目情况简表（Ⅱ）数据
	 * @return
	 */
	public List<pro_manageRreviewModeExcel> manageReviewExport(String wheresql);
	/**
	 * 查询《拟推荐上会项目清单（Ⅰ/Ⅱ）》Excel数据
	 * @return
	 */
	public List<pro_meetingExportModeExcel> meetingExport(String string);
	/**
	 * 查询 项目评议委员会评审通过项目情况简表(Ⅰ)Excel数据
	 * @return
	 */
	public List<pro_reviewCommitteeModeExcel> committeeExport(String string);

}

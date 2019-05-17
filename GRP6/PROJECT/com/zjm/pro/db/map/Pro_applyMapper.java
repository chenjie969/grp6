package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_apply;
/**
 * 业务申请信息表 映射mapper
 * @author zky
 * @time 2017-6-30;
 */
public interface Pro_applyMapper {

	/**
	 * 返回业务申请信息表分页列表
	 * @param pageTable
	 * @author zhangkeyao
	 * @return
	 */
	public List<Pro_apply> selectApplyPageTables(PageTable<Pro_apply> pageTable);	
	/**
	 * 查询业务申请信息表分页列表   总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectApplyPageTables_Count(PageTable<Pro_apply> pageTable);
	/**
	 * @description  业务申请信息
	 */
	public Integer insertOneApplyInfo(Pro_apply apply);
	
	/**
	 * 更新 业务申请信息
	 * @description
	 */
	public Integer updateOneApplyInfo(Pro_apply apply);
	/**
	 * 更新项目结案评价
	 * 
	 */
	public Integer updateApplySetProjectJudge(Pro_apply apply);
	/**
	 * 根据wheresql删除一个 业务申请信息
	 * @param wheresql :
	 * @return
	 */
	public Integer delectApplyByWhereSql(String wheresql);
	/**
	 * 根据wheresql查询一个业务申请信息
	 * @param wheresql:
	 * @return
	 */
	public Pro_apply selectOneApplyWhereSql(String wheresql);
	/**
	 * 根查询一个打包项目下子项目信息
	 * @param wheresql:
	 * @return
	 */
	public List<Pro_apply> selectApplyListByWhereSql(String wheresql);
	/**
	 *	指定项目AB角 
	 */
	public Integer updateApplySetABMan(Pro_apply  apply);
	/**
	 *	指定项目风控复核人 
	 */
	public Integer updateApplySetReviewMan(Pro_apply  apply);
	/**
	 *	指定项目法务评审人 
	 */
	public Integer updateApplySetLegalMan(Pro_apply  apply);
	
	//上会审批--根据ID修改isArrangeMeeting
	public int updateIsArrangeMeetingById(PageTable<Pro_apply> pageTable);
	//上会申请-申请记录--根据ID修改isArrangeMeeting
	public int updateIsArrangeMeetingByIds(PageTable<Pro_apply> pageTable);
	public int updateIsArrangeMeetById(Pro_apply apply);
	
	/**
	 * 根据申请ID 修改上会状态
	 * @author xuyz
	 */
	public Integer updateApplyMeetingStatus(Pro_apply proApply);
	
	int updateApplyYesPackage(String  str);
	
	public List<Pro_apply> selectProjectStageList();
	
	public List<Pro_apply> selectRiskApplyPageTables(PageTable<Pro_apply> pageTable);
	
	public Long selectRiskApplyPageTables_Count(PageTable<Pro_apply> pageTable);
}

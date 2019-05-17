package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
/**
 * 业务申请产品信息表 映射mapper
 * @author zky
 * @time 2017-6-30;
 */
public interface Pro_applyDetailMapper {

	/**
	 * 返回业务申请产品信息表分页列表
	 * @param pageTable
	 * @author zhangkeyao
	 * @return
	 */
	public List<Pro_applyDetail> selectApplyDetailPageTables(PageTable<Pro_applyDetail> pageTable);	
	/**
	 * 查询业务申请产品信息表分页列表   总记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectApplyDetailPageTables_Count(PageTable<Pro_applyDetail> pageTable);
	/**
	 * @description  业务申请产品信息
	 */
	public Integer insertOneApplyDetailInfo(Pro_applyDetail applyDetail);
	
	/**
	 * 更新 业务申请产品信息
	 * @description
	 */
	public Integer updateOneApplyDetailInfo(Pro_applyDetail applyDetail);
	/**
	 * 根据wheresql删除一个 业务申请产品信息
	 * @param wheresql :
	 * @return
	 */
	public Integer deleteApplyDetailByWhereSql(String wheresql);
	/**
	 * 根据wheresql查询一个业务申请产品信息
	 * @param wheresql:
	 * @return
	 */
	public Pro_applyDetail selectOneApplyDetailWhereSql(String wheresql);
	/**
	 * 根据wheresql查询申请明细
	 * @param wheresql:
	 * @return
	 */
	public List<Pro_applyDetail> selectApplyDetailList(String wheresql);
	/**
	 *	指定项目AB角 
	 */
	public Integer updateApplySetABMan(Pro_applyDetail applyDetail);
	/**
	 *	指定项目风控复核人 
	 */
	public Integer updateApplySetReviewMan(Pro_applyDetail applyDetail);
	/**
	 *	指定项目法务评审人 
	 */
	public Integer updateApplySetLegalMan(Pro_applyDetail applyDetail);
	/**
	 * 更新产品评审会决议
	 * xuyz
	 */
	public Integer updateOneApproveGuarantee(Pro_applyDetail applyDetail);

}

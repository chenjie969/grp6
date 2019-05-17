package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_FinanceForProVO;

/**
 * 项目财务费用管理
 * @author Administrator
 *
 */

public interface Pro_FinanceMapper {
	public List<Pro_FinanceForProVO> selectMultiProFinancePageTable(PageTable<Pro_FinanceForProVO> pageTable);
}

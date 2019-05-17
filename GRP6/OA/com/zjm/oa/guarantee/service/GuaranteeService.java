package com.zjm.oa.guarantee.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.oa.db.model.Hr_staffGuarantee;

public interface GuaranteeService {
	/**
	 * 插入一条担保记录
	 * @param user
	 * @param guarantee
	 * @return
	 */
    public Boolean insertOneGuarantee(User user,Hr_staffGuarantee guarantee);
    /**
     * 更新一条担保记录
     * @param user
     * @param guarantee
     * @return
     */
    public Boolean updateOneGuarantee(User user,Hr_staffGuarantee guarantee);
    /**
     * 查询一条担保记录
     * @param guaranteeID
     * @return
     */
    public Hr_staffGuarantee selectOneGuarantee(String guaranteeID);
    /**
     * 查询担保记录表
     * @param pageTable
     * @return
     */
    public  PageTable<Hr_staffGuarantee> selectGuaranteeTable(PageTable<Hr_staffGuarantee> pageTable);
}

package com.zjm.sys.docMould.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.Sys_docMouldMapper;
import com.zjm.sys.db.model.Sys_docMould;
import com.zjm.sys.docMould.service.DocMouldService;
@Service("docMouldService")
@Transactional
public class DocMouldServiceImpl implements DocMouldService {
	@Resource
	private Sys_docMouldMapper sys_docMouldMapper;
	@Resource
	private LogService logService;
	/**
	 * 插入一个附件模板
	 * @param docMould
	 * @return
	 */
	public boolean insertOneDocMould(User user,Sys_docMould docMould) {
		try {
			if(sys_docMouldMapper.insertOneDocMould(docMould)==1){
				logService.insertOneOperatorLogInfo(user,"关联企业", "新增", "新增关联企业");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 附件模板pageTable
	 */
	public PageTable selectAllDocMouldList(PageTable pageTable) {
		try {
			List<Sys_docMould> list=sys_docMouldMapper.selectAllDocMouldPageTables(pageTable);
			Long total=sys_docMouldMapper.selectAllDocMouldPageTables_Count(pageTable);
			pageTable.setRows(list);
			pageTable.setTotal(total);
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 附件模板List
	 */
	public List<Sys_docMould> selectDocMouldListByWheresql(String wheresql) {
		try {
			List<Sys_docMould> list=sys_docMouldMapper.selectDocMouldListByWheresql(wheresql);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除一个附件模板信息
	 * @param docMould
	 * @return
	 */
	public Boolean delectOneDocMouldInfo(User user,Sys_docMould docMould) {
		try {
			if(sys_docMouldMapper.delectOneDocMouldInfo(docMould)==1){
				logService.insertOneOperatorLogInfo(user,"关联企业", "新增", "新增关联企业");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Sys_docMould selectOnefile(String filename, String filePath) {
		
		return sys_docMouldMapper.selectOnefile(filename, filePath);
	}

}

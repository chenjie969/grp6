package com.zjm.sys.dicType.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.db.map.C_dictypeMapper;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;

@Service("dicTypeService")
@Transactional
public class DicTypeServiceImpl implements DicTypeService {

	@Resource 
	private C_dictypeMapper c_dictypeMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 查询所有字典
	 * @return
	 */
	public List<C_dictype> selectAllDicTypeList(String wheresql) {
		return c_dictypeMapper.selectAllDicTypeList(wheresql);
	}
	/**
	 * 查询字典列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<C_dictype> selectDicTypePageTables(PageTable<C_dictype> pageTable) {
		List<C_dictype> list=c_dictypeMapper.selectDicTypePageTables(pageTable);
		Long total=c_dictypeMapper.selectDicTypePageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}
	/**
	 * 插入一个字典
	 */
	public Boolean insertOneDicTypeInfo(User user,C_dictype c_dictype) {
		//查询同级节点下共有多少字典
		c_dictype.setOrder_id(c_dictypeMapper.selectDicTypeOrderId(c_dictype));
		if(c_dictypeMapper.insertOneDicTypeInfo(c_dictype)==1){
			logService.insertOneOperatorLogInfo(user,"单级字典", "添加", c_dictype.getDicTypeName());
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 查询一个字典信息
	 * @return
	 */
	public C_dictype selectOneDicTypeInfo(C_dictype c_dictype) {
		return c_dictypeMapper.selectOneDicTypeInfo(c_dictype);
	}
	/**
	 * 更新一个字典信息
	 * @return
	 */
	public Boolean updateOneDicTypeInfo(User user,C_dictype c_dictype) {
		if(c_dictypeMapper.updateOneDicTypeInfo(c_dictype)==1){
			logService.insertOneOperatorLogInfo(user,"单级字典", "修改", c_dictype.getDicTypeName());
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除一个字典信息
	 * @return
	 */
	public Boolean deleteOneDicTypeInfo(User user,C_dictype c_dictype) {
		c_dictype = selectOneDicTypeInfo(c_dictype);
		//删除下级字典
		deleteOneDicTypeDownInfo(c_dictype);
		if(c_dictypeMapper.deleteOneDicTypeInfo(c_dictype)==1){
			logService.insertOneOperatorLogInfo(user,"单级字典", "删除", c_dictype.getDicTypeName());
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除一个字典项下的子项
	 * @return
	 */
	private void deleteOneDicTypeDownInfo(C_dictype c_dictype) {
		//判断是否有下级字典
		List<C_dictype> list=c_dictypeMapper.selectAllDicTypeList(" and dicTypePID = \'"+ c_dictype.getDicTypeID()+"\'");
		for (C_dictype c_dictype2 : list) {
			deleteOneDicTypeDownInfo(c_dictype2);
			c_dictypeMapper.deleteOneDicTypeInfo(c_dictype2);
		}
	}
	/**
	 * 判断字典名称是否存在（全部单级字典）
	 */
	@Override
	public Boolean isExistDictypeNameForALL(C_dictype c_dictype) {
		Integer exist = c_dictypeMapper.isExistDictypeNameForALL(c_dictype);
		if(exist==0){	//没查到，不重复
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断字典名称是否存在（同级目录字典）
	 */
	@Override
	public Boolean isExistDictypeNameForParent(C_dictype c_dictype) {
		Integer exist = c_dictypeMapper.isExistDictypeNameForParent(c_dictype);
		if(exist==0){	//没查到，不重复
			return true;
		}else{
			return false;
		}
	}
}

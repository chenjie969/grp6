package com.zjm.sys.modules.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.zjm.sys.db.map.Sys_modulesMapper;
import com.zjm.common.db.model.PageTable;
import com.zjm.sys.db.model.Sys_modules;
import com.zjm.sys.modules.service.ModulesService;
/**
 * 菜单设置
 * @author mashuo add 20170411
 */
@Service("modulesService")
@Transactional
public class ModulesServiceImpl implements ModulesService{
	@Resource 
	private Sys_modulesMapper  sys_modulesMapper;

	/**
	 * 查询所有菜单
	 * @return
	 */
	public List<Sys_modules> selectAllModulesList(String wheresql) {
		return sys_modulesMapper.selectAllModulesList(wheresql);
	}

	/**
	 * 插入一个菜单信息
	 * @return
	 */
	public Boolean insertOneModulesInfo(Sys_modules sys_modules) {
		//查询同级节点下共有多少菜单
		sys_modules.setOrder_id(sys_modulesMapper.selectModulesOrderId(sys_modules));
		if(sys_modulesMapper.insertOneModulesInfo(sys_modules)==1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 查询一个菜单信息
	 * @return
	 */
	public Sys_modules selectOneModulesInfo(Sys_modules sys_modules) {
		return sys_modulesMapper.selectOneModulesInfo(sys_modules);
	}
	/**
	 * 更新一个菜单信息
	 * @return
	 */
	public Boolean updateOneModulesInfo(Sys_modules sys_modules) {
		if(sys_modulesMapper.updateOneModulesInfo(sys_modules)==1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除一个菜单信息
	 * @return
	 */
	public Boolean deleteOneModulesInfo(Sys_modules sys_modules) {
		//删除下级菜单
		deleteOneModulesDownInfo(sys_modules);
		//删除该菜单的关联信息
		sys_modulesMapper.deleteOneModulesInfoRelevanceRoles(sys_modules);
		if(sys_modulesMapper.deleteOneModulesInfo(sys_modules)==1){
			return true;
		}else{
			return false;
		}
	}

	private void deleteOneModulesDownInfo(Sys_modules sys_modules) {
		//判断是否有下级菜单
		List<Sys_modules> list=sys_modulesMapper.selectAllModulesList(" and pmod_id = \'"+ sys_modules.getMod_uid()+"\'");
		for (Sys_modules sys_modules2 : list) {
			deleteOneModulesDownInfo(sys_modules2);
			//删除该菜单的角色授权信息
			sys_modulesMapper.deleteOneModulesInfoRelevanceRoles(sys_modules2);
			sys_modulesMapper.deleteOneModulesInfo(sys_modules2);
		}
	}

	/**
	 * 查询菜单列表   
	 * @param pageTable
	 * @return
	 */
	public PageTable<Sys_modules> selectModulesPageTables(PageTable<Sys_modules> pageTable) {
		List<Sys_modules> list=sys_modulesMapper.selectModulesPageTables(pageTable);
		Long total=sys_modulesMapper.selectModulesPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	/**
	 * 判断是否存在
	 * @param wheresql
	 * @return
	 */
	public Boolean selectModulesIsExist(String wheresql) {
		if(sys_modulesMapper.selectModulesIsExist(wheresql)==0){
			return true;
		}else{
			return false;
		}
	}

}

package com.zjm.pro.contractdoc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.contractdoc.service.ContractdocService;
import com.zjm.pro.db.map.Pro_contractDocMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_contractdoc;
import com.zjm.pro.db.model.Pro_projectfiles;

@Service("contractdocService")
@Transactional
public class ContractdocServiceImpl implements ContractdocService{
	
	@Resource
	private Pro_contractDocMapper pro_contractDocMapper;
	@Resource
	private Pro_projectfilesMapper pro_projectfilesMapper;
	@Resource
	private LogService logService;
	@Override
	public List<Pro_contractdoc> selectContractTable(String applyID) {
		List<Pro_contractdoc> list=pro_contractDocMapper.selectContractTable(applyID);
		
		return list;
	}
	@Override
	public Pro_contractdoc selectOneContractdocInfo(Pro_contractdoc Pro_contractdoc) {
		// TODO Auto-generated method stub
		return pro_contractDocMapper.selectOneContractdocInfo(Pro_contractdoc);
	}
	@Override
	public Boolean updateOneContractInfo(Pro_contractdoc Pro_contractdoc) {
		if(pro_contractDocMapper.updateOneContractInfo(Pro_contractdoc)==1){
			return true;
		}
		return false;
	}
	//修改合同信息的附件信息
	@Override
	public Boolean updateOneContractFilesInfo(Pro_contractdoc Pro_contractdoc) {
		if(pro_contractDocMapper.updateOneContractFilesInfo(Pro_contractdoc)==1){
			return true;
		}
		return false;
	}
	//根据ID修改合同信息
	@Override
	public Boolean updateOneContractByID(Pro_contractdoc contractdoc,User user) {
		try{
			if(pro_contractDocMapper.updateOneContractByID(contractdoc)==1){
				logService.insertOneOperatorLogInfo(user, "修改一条合同信息", "修改", "ContractDoc_ID:"+contractdoc.getContractDoc_ID());
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Boolean insertOneContractInfo(Pro_contractdoc contractdoc, User userSession) {
		if(pro_contractDocMapper.insertOneContractInfo(contractdoc)==1){
			logService.insertOneOperatorLogInfo(userSession, "添加一条合同信息", "添加", "ContractDoc_ID:"+contractdoc.getContractDoc_ID());
			return true;
		}
		return false;
	}
	@Override
	public Boolean contractDel(Pro_contractdoc Pro_contractdoc) {
		if (pro_contractDocMapper.contractDel(Pro_contractdoc) == 1)
			return true;
		return false;
	}
	//新增/修改合同时判断合同编号是否存在
	@Override
	public Boolean isExistContractCode(Pro_contractdoc contractdoc) {
		if(pro_contractDocMapper.isExistContractCode(contractdoc) == 0){
			return true;
		}else{
			return false;
		}
	}
	
	//查询附件
	@Override
	public List<Pro_projectfiles> getAttachments(String entityID) {
		List<Pro_projectfiles> listFiles = null;
		 try {
			 listFiles = pro_projectfilesMapper.selectProFilesListByEntityID(entityID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFiles;
	}
}

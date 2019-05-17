package com.zjm.sys.clientCode.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.sys.clientCode.service.ClientCodeService;
import com.zjm.sys.db.map.Sys_clientCodeMapper;
import com.zjm.sys.db.model.Sys_clientCode;
import com.zjm.util.SystemSession;
/**
 * 客户编号
 * @author chenyang   add 20170524
 */
@Service("clientCodeService")
@Transactional
public class ClientCodeServiceImpl implements ClientCodeService{
	@Resource(name="sys_clientCodeMapper")
	private	Sys_clientCodeMapper sys_clientCodeMapper;
	@Resource
	private	LogService logService;
	
	/**
	 * 查询一个客户编号信息
	 * @param sys_clientCode
	 * @return
	 */
	@Override
	public Sys_clientCode selectOneClientCodeInfo(Sys_clientCode clientCode) {
		return sys_clientCodeMapper.selectOneClientCodeInfo(clientCode);
	}

	/**
	 * 更新客户编号信息
	 * @param sys_clientCode
	 * @return
	 */
	@Override
	public Boolean updateOneClientCodeInfo(User user,Sys_clientCode clientCode) {
		if(clientCode.getRuleType().equals("01")){
			clientCode.setRuleName("共同生成规则");
		}else if (clientCode.getRuleType().equals("02")) {
			clientCode.setRuleName("各自生成规则");
		}else {
			clientCode.setRuleName("手工录入");
		}
		clientCode.setUnit_uid(user.getUnit_uid());
		clientCode.setUpdateUserName(user.getUser_name());
		Sys_clientCode sys_clientCode=this.selectOneClientCodeInfo(clientCode);
		clientCode.setCommonCode(sys_clientCode.getCommonCode());
		clientCode.setCompanyCode(sys_clientCode.getCompanyCode());
		clientCode.setOperateCode(sys_clientCode.getOperateCode());
		clientCode.setConsumeCode(sys_clientCode.getConsumeCode());
		
		if(sys_clientCodeMapper.updateOneClientCodeInfo(clientCode)){
			logService.insertOneOperatorLogInfo(user,"客户编号", "修改", "修改客户编号");
			return true;			
		}else{
			return false;
		}
	}

	/**
	 * 新增客户时获取编号当前值
	 * @return
	 */
	@Override
	public Sys_clientCode returnOneClientCode(User user,String clientTypeID) {
		Sys_clientCode clientCode=new Sys_clientCode();
		clientCode.setUnit_uid(user.getUnit_uid());
		clientCode=this.selectOneClientCodeInfo(clientCode);//查询客户编号当前值
		if(clientCode.getRuleType().equals("01")){
			clientCode.setCommonCode(clientCode.getCommonCode()+1);
			this.updateOneClientCodeInfo(user,clientCode);//回写客户编号当前值+1
			clientCode.setCommonCode(clientCode.getCommonCode()-1);
		}
		if (clientCode.getRuleType().equals("02")) {
			//根据不同的客户类型回写编号
			if (clientTypeID.equals("01")) {
				clientCode.setCompanyCode(clientCode.getCompanyCode()+1);
				this.updateOneClientCodeInfo(user,clientCode);//回写客户编号当前值+1
				clientCode.setCompanyCode(clientCode.getCompanyCode()-1);
			}else if (clientTypeID.equals("02")) {
				clientCode.setOperateCode(clientCode.getOperateCode()+1);
				this.updateOneClientCodeInfo(user,clientCode);//回写客户编号当前值+1
				clientCode.setOperateCode(clientCode.getOperateCode()-1);
			}else if (clientTypeID.equals("03")) {
				clientCode.setConsumeCode(clientCode.getConsumeCode()+1);
				this.updateOneClientCodeInfo(user,clientCode);//回写客户编号当前值+1
				clientCode.setConsumeCode(clientCode.getConsumeCode()-1);
			}
		}
		
		return clientCode;
	}
	
	
}

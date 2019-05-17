package com.zjm.pro.billManage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.billManage.service.BillManageService;
import com.zjm.pro.db.map.Pro_billMapper;
import com.zjm.pro.db.model.Pro_costBill;
import com.zjm.pro.db.model.Pro_billForProVO;
import com.zjm.util.Tool;

@Service("billManageService")
@Transactional
public class BillManageServiceImpl implements BillManageService {

	@Resource 
	private Pro_billMapper billMapper;
	@Resource
	private LogService logService;
	
	/**
	 * 查询所有收费项目的票据分页列表
	 */
	public PageTable<Pro_billForProVO> selectMultiProsBillPageTable(PageTable<Pro_billForProVO> pageTable){
		try {
			List<Pro_billForProVO> volist = billMapper.selectMultiProsBillPageTable(pageTable);
			pageTable.setRows(volist);
			pageTable.setTotal((long) volist.size());
			return pageTable;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询某一项目下的票据分页列表
	 */
	public PageTable<Pro_costBill> selectSglProBillPageTable(PageTable<Pro_costBill> pageTable){
		try{
			List<Pro_costBill> billList = billMapper.selectSglProBillPageTable(pageTable);
			pageTable.setRows(billList);
			return pageTable;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 新增一条票据记录
	 */
	public Boolean insertOneBill(User user,Pro_costBill bill){
		try{
			bill.setCostBill_ID(Tool.createUUID32());
			bill.setUnit_uid(user.getUnit_uid());
			bill.setUpdateUserName(user.getUser_name());
			Integer flag = billMapper.insertOneBill(bill);
			if(flag==1){
//				logService.insertOneOperatorLogInfo(user, "票据管理", "添加", bill.getProjectName()+" 项目添加 "+bill.getBillTypeName());
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 修改一条票据记录
	 */
	public Boolean updateOneBill(User user,Pro_costBill bill){
		try{
			bill.setUpdateUserName(user.getUser_name());
			Integer flag = billMapper.updateOneBill(bill);
			if(flag==1){
//				logService.insertOneOperatorLogInfo(user, "票据管理", "修改", bill.getProjectName()+" 项目修改 "+bill.getBillTypeName());
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查看一条票据记录
	 */
	public Pro_costBill selectOneBill(Pro_costBill bill){
		try{
			bill = billMapper.selectOneBill(bill);
			return bill;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 删除一条票据记录
	 */
	public Boolean deleteOneBill(User user,Pro_costBill bill){
		try{
			Integer flag = billMapper.deleteOneBill(bill);
			if(flag==1){
//				logService.insertOneOperatorLogInfo(user, "票据管理", "删除", bill.getProjectName()+" 项目删除 "+bill.getBillTypeName());
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

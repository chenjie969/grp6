package com.zjm.crm.badclient.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import  java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.crm.badclient.service.BadClientService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.map.Crm_badClientMapper;
import com.zjm.crm.db.map.Crm_clientMapper;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_badClient;
import com.zjm.sys.db.model.Sys_departs;
import com.zjm.sys.departs.service.DepartsService;
import com.zjm.util.Tool;

import test.Student;



@Service("badClientService")
@Transactional
public class BadClientServiceImpl implements BadClientService {

	@Resource
	private Crm_badClientMapper crm_badClientMapper;
	@Resource
	private DepartsService departsService;
	@Resource
	private LogService logService;
	@Resource
	private Crm_clientMapper clientMapper;
	@Resource
	private ClientService clientService;

	/**
	 * 查询黑名单分页列表
	 * @param pageTable
	 * @return
	 */
	@Override
	public PageTable<Crm_badClient> selectBadClientPageTables(PageTable<Crm_badClient> pageTable) {
		List<Crm_badClient> list = crm_badClientMapper.selectBadClientPageTables(pageTable);
		Long total=crm_badClientMapper.selectBadClientPageTables_Count(pageTable);
		pageTable.setRows(list);
		pageTable.setTotal(total);
		return pageTable;
	}

	/**
	 * 查询一条黑名单客户信息
	 */
	@Override
	public Crm_badClient selectOneBadClientInfo(Crm_badClient crm_badClient) {
		Crm_badClient badClient = crm_badClientMapper.selectOneBadClientInfo(crm_badClient);
		return badClient;
	}

	/**
	 * 更新一条黑名单客户
	 */
	@Override
	public Boolean updateOneBadClientInfo(User user,Crm_badClient crm_badClient) {
		String clientName = clientMapper.selectNameById(crm_badClient.getClient_ID());
		if(crm_badClientMapper.updateOneBadClientInfo(crm_badClient)==1){
			logService.insertOneOperatorLogInfo(user,"黑名单","修改", clientName);
			return true;
		}
		else
			return false;
	}

	/**
	 * @description  新增一个黑名单信息
	 */
	@Override
	public Boolean insertOneBadClientInfo(User user,Crm_badClient badClient) {
		//badClient中已有client_ID和operationDescription两项内容
		//设置主键ID
		badClient.setBadClient_ID(Tool.createUUID32());
		//设置拉黑经办部门完整代码和名称
		Sys_departs result = new Sys_departs();
		result.setDepart_uid(user.getDepart_uid());
		result = departsService.selectOneDepartsInfo(result);
		if(result!=null){
			badClient.setOperationDepartFullCode(result.getDepart_fullcode());
			badClient.setOperationDepartName(result.getDepart_name());
		}else{
			badClient.setOperationDepartFullCode("");
			badClient.setOperationDepartName("");
		}
		//设置经办人ID
		badClient.setOperatorID(user.getUser_id());
		//设置经办人名字
		badClient.setOperatorName(user.getUser_name());
		//设置担保机构ID
		badClient.setUnit_uid(user.getUnit_uid());
		//设置担保机构名称
		badClient.setUnit_uidName(user.getUnit_uidName());
		//设置最后修改人姓名
		badClient.setUpdateUserName(user.getUser_name());
		
		//向黑名单表中插入数据
		if(crm_badClientMapper.insertOneBadClientInfo(badClient)==1){
			return true;
		}else{
			return false;
		}
	}
	
	/**
     * 转入黑名单;
     * @return
     */
	@Override
	public Boolean returnBadClientByClientID(User user,Crm_badClient badClient) {
		
		//操作黑名单表
		Boolean badClientFlag = insertOneBadClientInfo(user, badClient);
		
		//操作客户表
		Client client = new Client();
		client.setClient_ID(badClient.getClient_ID());
		Client selectOneClientInfo = clientService.selectOneClientInfo(client);
		selectOneClientInfo.setIsBadClient(true);
		selectOneClientInfo.setUpdateUserName(user.getUser_name());
		Boolean clientFlag = clientService.updateOneCompanyClientInfo(user,selectOneClientInfo);
		
		if(badClientFlag && clientFlag){
			logService.insertOneOperatorLogInfo(user,"黑名单", "拉入黑名单", selectOneClientInfo.getClientName());
			return true;
		}else{
			return false;
		}
	}
	
	/**
     * 移出黑名单;
     * @return
     */
	@Override
	public Boolean removeBadClientByClientID(User user,Crm_badClient badClient) {
		
		//操作黑名单表
		Sys_departs result = new Sys_departs();
		result.setDepart_uid(user.getDepart_uid());
		result = departsService.selectOneDepartsInfo(result);
		if(result!=null){
			badClient.setCancelDepartFullCode(result.getDepart_fullcode());
			badClient.setCancelDepartName(result.getDepart_name());
		}else{
			badClient.setCancelDepartFullCode("");
			badClient.setCancelDepartName("");
		}
		badClient.setCancelOperatorID(user.getUser_id());
		badClient.setCancelOperatorName(user.getUser_name());
		badClient.setCancelDate(new Date());
		badClient.setUpdateUserName(user.getUser_name());
		badClient.setUnit_uid(user.getUnit_uid());
		Boolean badClientFlag = updateOneBadClientInfo(user,badClient);
		
		//操作客户表
		Client client = new Client();
		client.setClient_ID(badClient.getClient_ID());
		Client selectOneClientInfo = clientService.selectOneClientInfo(client);
		selectOneClientInfo.setIsBadClient(false);
		selectOneClientInfo.setUpdateUserName(user.getUser_name());
		Boolean clientFlag = clientService.updateOneCompanyClientInfo(user,selectOneClientInfo);
		
		if(badClientFlag && clientFlag){
			logService.insertOneOperatorLogInfo(user,"黑名单", "移出黑名单", selectOneClientInfo.getClientName());
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Crm_badClient> selectBadClientListByWhereSql(String wheresql) {
		return crm_badClientMapper.selectBadClientListByWhereSql(wheresql);
	}

	@Override
	public Boolean deleteBadClientByWhereSql(String wheresql) {
		try {
			int info = crm_badClientMapper.deleteBadClientByWhereSql(wheresql);
			if( info > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//test
	@Override
	public List<Crm_badClient> selectBadClientLists() {
		List<Crm_badClient> list = crm_badClientMapper.selectBadClientLists();
		return list;
	}

	public void expotExcel(HttpServletRequest request, HttpServletResponse response, List<Crm_badClient> list)
			throws IOException {
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("信息表");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("信息一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("客户编号");
		row2.createCell(1).setCellValue("客户名称");
		// 在sheet里创建第三行
		/*
		 * List<Crm_badClient> e = list; Iterator< Crm_badClient> it =
		 * e.iterator(); int i=2; while(it.hasNext()){ HSSFRow
		 * row3=sheet.createRow(i); Crm_badClient teacher = it.next();
		 * row3.createCell(0).setCellValue(teacher.getBadClient_ID());
		 * row3.createCell(1).setCellValue(teacher.getCancelDepartName());
		 * //...此处省略 }
		 */
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setCharacterEncoding("utf-8");
		String filename = "黑名单客户";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(filename.getBytes("gbk"), "iso8859-1") + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
	}
	/**
	 * 查询一条黑名单客户信息
	 */
	@Override
	public Crm_badClient selectOneBadClientInfoByclent_id( String client_id) {
		Crm_badClient badClient = crm_badClientMapper.selectOneBadClientInfoByclent_id(client_id);
		return badClient;
	}

}

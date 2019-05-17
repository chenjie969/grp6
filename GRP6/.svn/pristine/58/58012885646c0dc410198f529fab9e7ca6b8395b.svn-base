package com.zjm.crm.badclient.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.crm.badclient.service.BadClientService;
import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.Crm_badClient;
import com.zjm.gbpm.db.model.Act_re_actSort;
import com.zjm.sys.util.RolesDataAccreditUtil;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.SystemSession;
import com.zjm.util.Tool;

@Controller
public class BadClientAction {

	@Resource
	private BadClientService badClientService;
	@Resource
	private ClientService clientService;

	@RequestMapping(value = "/selectBlackManPage")
	public ModelAndView selectBlackManPage() {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.getModel().put("count", 0);
		mv.setViewName("/crm/blacklist/blacklist");
		return mv;
	}

	/**
	 * 查询黑名单分页列表
	 * 
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectBadClientPageTables")
	@ResponseBody
	public AjaxRes selectBadClientPageTables(@RequestBody PageTable pageTable) {
		pageTable.getQueryCondition().setUser_uid(SystemSession.getUserSession().getUser_uid());//设置用户id通过匹配用户权限来查询企业表
		pageTable.setWheresql(queryConditionSql(pageTable));
		pageTable = badClientService.selectBadClientPageTables(pageTable);
		pageTable.setWheresql("");
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}

	/**
	 * 黑名单分页列表查询条件
	 * 
	 * @param pageTable
	 * @return
	 */
	private String queryConditionSql(PageTable pageTable) {
		String wheresql = " and b.unit_uid = '" + SystemSession.getUserSession().getUnit_uid() + "'";
		if (pageTable == null) {
			return "";
		}
		
		//根据权限查看黑名单用户
		if(null != pageTable.getQueryCondition().getUser_uid() && !"".equals(pageTable.getQueryCondition().getUser_uid())){
			String sql = RolesDataAccreditUtil.appendClientSqlByRole(pageTable.getQueryCondition().getUser_uid(),"");
			if (null != sql){
				wheresql+= (" "+sql);
			}
		}
		
		// 搜索框功能
		// 当查询条件中包含中文时，get请求默认会使用ISO-8859-1编码请求参数，在服务端需要对其解码
		if (null != pageTable.getSearchText()) {
			if ("01".equals(pageTable.getQueryCondition().getClientTypeID())) {
				wheresql = wheresql + " and clientName like \'%" + pageTable.getSearchText().trim() + "%\'";
			} else {
				wheresql = wheresql + " and personName like \'%" + pageTable.getSearchText().trim() + "%\'";
			}
		}
		if (pageTable.getQueryCondition() != null) {
			if (pageTable.getQueryCondition().getClientTypeID() != null
					&& !"".equals(pageTable.getQueryCondition().getClientTypeID())) {
				wheresql = wheresql + " and clientTypeID in (" + pageTable.getQueryCondition().getClientTypeID().trim()
						+ ")";
			}
		}
		if (pageTable.getSortName() != null && !pageTable.getSortName().equals("") && pageTable.getSortOrder() != null
				&& !pageTable.getSortOrder().equals("")) {
			wheresql = wheresql + " order by " + pageTable.getSortName().trim() + "  " + pageTable.getSortOrder() + "";
		} else {
			// wheresql=wheresql+" ORDER BY CONVERT(clientName USING gbk) ";
			// //强制让MySQL按中文首字拼音来排序
			wheresql = wheresql + " ORDER BY b.updateDateTime DESC ";
		}
		return wheresql;
	}

	/**
	 * 查看单个黑名单客户的信息
	 * 
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/selectOneBadClientInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectOneBadClientInfo(@RequestBody Crm_badClient crm_badClient) {
		AjaxRes ar = new AjaxRes();
		crm_badClient.setUnit_uid(SystemSession.getUserSession().getUnit_uid());
		Crm_badClient badClient = badClientService.selectOneBadClientInfo(crm_badClient);
		ar.setSucceed(badClient);
		return ar;
	}

	/**
	 * 黑名单修改，只能修改加入黑名单的原因
	 * 
	 * @param pageTable
	 * @return
	 */
	@RequestMapping(value = "/updateOneBadClientInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneBadClientInfo(@RequestBody Crm_badClient crm_badClient) {
		AjaxRes ar = new AjaxRes();
		User user = SystemSession.getUserSession();
		crm_badClient.setUpdateUserName(user.getUser_name());
		crm_badClient.setUnit_uid(user.getUnit_uid());
		Boolean b = badClientService.updateOneBadClientInfo(user, crm_badClient);
		ar.setSucceed(b);
		return ar;
	}

	/**
	 * 
	 * @description 转入黑名单
	 * @date 2017年5月10日 下午7:14:03
	 */
	@RequestMapping(value = "/returnBadClientByClientID", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes returnBadClientByClientID(@RequestBody Crm_badClient badClient) { //
		Boolean bool = badClientService.returnBadClientByClientID(SystemSession.getUserSession(), badClient);
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}

	/**
	 * @description 移出黑名单
	 */
	@RequestMapping(value = "/removeBadClientByClientID", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes removeBadClientByClientID(@RequestBody Crm_badClient badClient) { //
		Boolean bool = badClientService.removeBadClientByClientID(SystemSession.getUserSession(), badClient);
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(bool);
		return ar;
	}

	// 生成黑名单表格
	@RequestMapping(value = "/addBadClientExcel")
	public void addBadClientExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Crm_badClient> list = badClientService.selectBadClientLists();
		badClientService.expotExcel(request, response, list);
	}

	// 导入表格插入数据
	@RequestMapping(value = "/uploadBadClientExcel", method = RequestMethod.POST)
	public ModelAndView uploadBadClientExcel(@RequestParam(value = "excelFile") MultipartFile file,
			HttpServletRequest request, HttpSession session) throws IOException {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		String filePath = file.getOriginalFilename();
		int count = 0;
		String errorMessage = null;
		List<Crm_badClient> list = new LinkedList<Crm_badClient>();
		// 判断是否为excel类型文件
		if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
			System.out.println("文件不是excel类型");
			errorMessage = "文件不是excel类型";
			mv.setViewName("/crm/blacklist/blacklist");
			System.out.println("errorMessage" + errorMessage);
			mv.getModel().put("errorMessage", errorMessage);
			return mv;
		}
		InputStream fis = null;
		Workbook wookbook = null;
		try {
			// 获取一个绝对地址的流
			fis = file.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// 2003版本的excel，用.xls结尾
			System.out.println("xls");
			wookbook = new HSSFWorkbook(fis);// 得到工作簿
		} catch (Exception ex) {
			try {
				System.out.println("xlsx");
				// 2007版本的excel，用.xlsx结尾
				wookbook = new XSSFWorkbook(fis);// 得到工作簿
			} catch (IOException e) {
			}
		}
		// 得到一个工作表
		Sheet sheet = wookbook.getSheetAt(0);
		// 获得表头
		Row rowHead = sheet.getRow(0);
		// 判断表头是否正确
		if (rowHead.getPhysicalNumberOfCells() != 4) {
			System.out.println("表头的数量不对!");
		}
		// 获得数据的总行数
		int totalRowNum = sheet.getLastRowNum();
		// 要获得属性
		try {
			String clientBH = null;
			String clientName = null;
			// 获得所有数据
			for (int i = 2; i <= totalRowNum; i++) {
				// 获得第i行对象
				Row row = sheet.getRow(i);
				// 获得获得第i行第0列的 String类型对象
				Cell cell = row.getCell((short) 0);	
				if(cell==null){
					clientBH="";
				}
				else{
				cell.setCellType(Cell.CELL_TYPE_STRING);			
				clientBH = cell.getStringCellValue().toString();
				}
				// 获得一个数字类型的数据
				cell = row.getCell((short) 1);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				clientName = cell.getStringCellValue().toString();
				//Crm_badClient badmanNew = new Crm_badClient();
				Client clientNew = clientService.selectOneClientInfoByClientName(clientName);
				if (clientNew == null) {
					clientNew = new Client();
					Boolean boolean1 = clientService.insertOneCompanyClientInfo(SystemSession.getUserSession(),
							clientNew);
					if (boolean1 == true) {
						clientNew.setClientBH(clientBH);
						clientNew.setClientName(clientName);
						clientNew.setIsBadClient(true);
						clientNew.setClientTypeID("01");
						clientService.updateOneCompanyClientInfo(SystemSession.getUserSession(), clientNew);
					}
				}
				clientNew.setIsBadClient(true);				
				clientService.updateOneCompanyClientInfo(SystemSession.getUserSession(), clientNew);				
				Crm_badClient badmanNew=badClientService.selectOneBadClientInfoByclent_id(clientNew.getClient_ID());
				if(badmanNew==null){
				badmanNew = new Crm_badClient();
				badmanNew.setBadClient_ID(Tool.createUUID32());
				badmanNew.setClient_ID(clientNew.getClient_ID());
				badmanNew.setUnit_uid(clientNew.getUnit_uid());
				Date date = new Date();
				badmanNew.setOperatorDate(date);
				badmanNew.setUnit_uidName(SystemSession.getUserSession().getUnit_uidName());
				badmanNew.setOperatorName(SystemSession.getUserSession().getUser_name());
				badClientService.insertOneBadClientInfo(SystemSession.getUserSession(), badmanNew);
				}
				list.add(badmanNew);
				count = list.size();
				mv.getModel().put("count", count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/crm/blacklist/blacklist");
		System.out.println("errorMessage" + errorMessage);
		mv.getModel().put("errorMessage", errorMessage);
		return mv;
	}

	@RequestMapping(value = "/blackMan")
	public ModelAndView blackMan() {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		mv.setViewName("/crm/blacklist/blackView");
		return mv;
	}
}

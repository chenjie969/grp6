package com.zjm.pro.project.web;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.project.service.ProjectService;
import com.zjm.pro.project.service.TestService;
import com.zjm.util.DateUtil;
import com.zjm.util.SystemSession;
import com.zjm.util.excel.ExcelUtilToMap;

@Controller
@RequestMapping(value="/project/test")
public class TestAction {
	
	@Resource
	private TestService testService;
	@Resource
	private ProjectService projectService;
	
	/**
	 * 查询已展期项目，更新项目期限
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/updateDelayPerio")
	@ResponseBody
	public AjaxRes updateDelayPerio(HttpServletRequest req ,HttpServletResponse res){
		int a = testService.updateDelayPerio();
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(a);
		return ar;
	}
	
	/**
	 * 查询所有为展期项目，更新项目期限
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/updateUnDelayPerio")
	@ResponseBody
	public AjaxRes updateUnDelayPerio(HttpServletRequest req ,HttpServletResponse res){
		int a = testService.updateUnDelayPerio();
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(a);
		return ar;
	}
	
	
	/**
	 * 展期表日期与项目表展期日期同步
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/updateProJectDelayDate")
	@ResponseBody
	public AjaxRes updateProJectDelayDate(HttpServletRequest req ,HttpServletResponse res){
		int a = testService.updateProJectDelayDate();
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(a);
		return ar;
	}
	
	/**
	 * 删除项目及关联信息（副版本，流程信息,项目详情。。）
	 * @param req
	 * @param res
	 * @param projectId 项目id
	 * @return
	 */
	@RequestMapping("/deleteProjectAndRelationInfo")
	@ResponseBody
	public AjaxRes deleteProjectAndRelationInfo(HttpServletRequest req ,HttpServletResponse res,String projectId){
		
		Boolean f = testService.deleteProjectAndRelationInfo(projectId);
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(f);
		return ar;
	}
	
	/**
	 * 
	 *重点项目审批流程
	 * @param req
	 * @param res
	 * @param riskSchemeID 审批记录id
	 * @return
	 */
	@RequestMapping("/deleteRiskInfo")
	@ResponseBody
	public AjaxRes deleteRiskInfo(HttpServletRequest req ,HttpServletResponse res,String riskSchemeID){
		Boolean f = testService.deleteRiskInfo(riskSchemeID);
		AjaxRes ar =new AjaxRes();
		ar.setSucceed(f);
		return ar;
	}
	
	/**
	 * 修改资金方分类(只针对非银行数据做处理)
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/updateFundExcel")
	public void updateFundExcel(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
//		try {
			File salaryFile = new File("D:\\河北融投文件\\资金方修改.xlsx");
			User sysUser = SystemSession.getUserSession();
	    	String fileName = salaryFile.getName();
	    	// 获取文件后缀
	        String prefix=fileName.substring(fileName.lastIndexOf("."));
	        //用uuid作为文件名，防止生成的临时文件重复
//	        File excelFile = File.createTempFile(UUIDGenerator.getUUID(), prefix);
//	        ((MultipartFile) salaryFile).transferTo(excelFile);//生成一个临时文件
	    	ExcelUtilToMap excelUtilToMap = new ExcelUtilToMap();
	    	List<Map> list2 = excelUtilToMap.readExcel(salaryFile);//[{员工姓名=陈杰, 岗位工资=2000, 绩效工资=1000}]
	    	testService.updateFundExcel(fileName.substring(0, fileName.indexOf(".xlsx")),list2,sysUser,DateUtil.getNow());
//	    	deleteFile(excelFile);//删除临时文件
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 合作机构(资金方)非银行数据添加子级-第三级（【非银行】->【p2p,私募，国企，资产，信托，其他】->【博泽资产管理有限公司....】）
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/updateBankExcel")
	public void updateBankExcel(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
//		try {
			File salaryFile = new File("D:\\河北融投文件\\资金方修改.xlsx");
			User sysUser = SystemSession.getUserSession();
	    	String fileName = salaryFile.getName();
	    	// 获取文件后缀
	        String prefix=fileName.substring(fileName.lastIndexOf("."));
	        //用uuid作为文件名，防止生成的临时文件重复
//	        File excelFile = File.createTempFile(UUIDGenerator.getUUID(), prefix);
//	        ((MultipartFile) salaryFile).transferTo(excelFile);//生成一个临时文件
	    	ExcelUtilToMap excelUtilToMap = new ExcelUtilToMap();
	    	List<Map> list2 = excelUtilToMap.readExcel(salaryFile);//[{员工姓名=陈杰, 岗位工资=2000, 绩效工资=1000}]
	    	testService.updateBankExcel(fileName.substring(0, fileName.indexOf(".xlsx")),list2,sysUser,DateUtil.getNow());
//	    	deleteFile(excelFile);//删除临时文件
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 客户行业类别修改
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/updateClientFullTrade")
	public void updateClientFullTrade(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
//		try {
			File salaryFile = new File("D:\\河北融投文件\\行业分类.xlsx");
			User sysUser = SystemSession.getUserSession();
	    	String fileName = salaryFile.getName();
	    	// 获取文件后缀
	        String prefix=fileName.substring(fileName.lastIndexOf("."));
	        //用uuid作为文件名，防止生成的临时文件重复
//	        File excelFile = File.createTempFile(UUIDGenerator.getUUID(), prefix);
//	        ((MultipartFile) salaryFile).transferTo(excelFile);//生成一个临时文件
	    	ExcelUtilToMap excelUtilToMap = new ExcelUtilToMap();
	    	List<Map> list2 = excelUtilToMap.readExcel(salaryFile);//[{员工姓名=陈杰, 岗位工资=2000, 绩效工资=1000}]
	    	testService.updateClientFullTrade(fileName.substring(0, fileName.indexOf(".xlsx")),list2,sysUser,DateUtil.getNow());
//	    	deleteFile(excelFile);//删除临时文件
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 项目完结处理
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/updateFinishPro")
	public void updateFinishPro(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
		testService.updateFinishPro();
	}
	
	
	/**
	 * 逾期前每笔还款数据
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/countInterest")
	public void countInterest(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
		projectService.insertOverDueInfo();
	}
	
	/**
	 * 计算逾期后每笔还款后的累计利息
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/payInterestSum")
	public void payInterestSum(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
		projectService.payInterestSum();
	}
	
	
	/**
	 * 设置还息方式ID为空
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/setInterestMethod")
	public void setInterestMethod(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
		projectService.setInterestMethod();
	}
	
	
	/**
	 * 客户名称与项目名称不一致问题
	 * @param repayFile
	 * @param type
     * @throws ServiceException 
	 */
	@RequestMapping(value = "/updateProjectName")
	public void updateProjectName(){//@RequestParam(value = "salaryFile") MultipartFile salaryFile
		projectService.updateProjectName();
	}
	
	/**
	 * 按已诉讼未诉讼，五级分类将担保余额分组（财务）
	 * @return
	 */
	@RequestMapping(value="/projectGuarantySumRiskLevel")//, method=RequestMethod.POST
	@ResponseBody
	public AjaxRes projectGuarantySumRiskLevel(){
		AjaxRes ar=new AjaxRes();
		//获取业务类型下拉框
		 Map<String, Object> projectTypeList = projectService.selectRiskLevelList("");
		ar.setSucceed(projectTypeList);
		return ar;
	}
	
	/**
	 *五级分类（ 应收代偿，委贷本金）
	 * @return
	 */
	@RequestMapping(value="/projectCostRiskLevel")//, method=RequestMethod.POST
	@ResponseBody
	public AjaxRes projectCostRiskLevel(){
		AjaxRes ar=new AjaxRes();
		//获取业务类型下拉框
		List<Pro_project> projectTypeList = projectService.projectCostRiskLevel("");
		ar.setSucceed(projectTypeList);
		return ar;
	}
	
	/**
	 * 费用统计（财务）
	 * 代偿本金，代偿利息，追偿本金，追偿利息，保证金，担保费，确认放款金额，未确认放款金额，评审费，还款金额，还款利息
	 * @return
	 */
	@RequestMapping(value="/projectCostCount")//, method=RequestMethod.POST
	@ResponseBody
	public AjaxRes projectCostCount(){
		AjaxRes ar=new AjaxRes();
		//获取业务类型下拉框
		List<Pro_project> projects = projectService.projectCostCount("");
		ar.setSucceed(projects);
		return ar;
	}
	
	public static void main(String[] args) {
		System.out.println("测试");
	}
}

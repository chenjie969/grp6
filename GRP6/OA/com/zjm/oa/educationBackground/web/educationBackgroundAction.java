package com.zjm.oa.educationBackground.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;
import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.oa.db.model.Hr_staffEducation;

import com.zjm.oa.staffEducation.service.StaffEducationService;
import com.zjm.sys.db.model.C_dictype;
import com.zjm.sys.dicType.service.DicTypeService;
import com.zjm.util.CustomDispatchServlet;
import com.zjm.util.Tool;

@Controller
@RequestMapping("/oa/educationBackground")
public class educationBackgroundAction {
	@Resource
	private StaffEducationService staffEducationService;
	@Resource
	private DicTypeService dicTypeService; // 单级字典
	@Resource
	private SysDicDataService sysDicDataService;

	// 加载页面表格
	@RequestMapping(value = "/loadPage")
	public ModelAndView loadpage(String staffcase_Id, String type) {
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.getModel().put("staffcase_Id", staffcase_Id);
		modeAndView.getModel().put("type", type);
		getDicTypeMapUp(modeAndView);
		modeAndView.setViewName("/oa/personfile/employeeInfo/basicInfo/educationBackground/index");
		return modeAndView;
	}
	  //查询信息 列表
	 
	@RequestMapping(value = "/selectEduListPageTables", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes selectEduListPageTables(@RequestBody PageTable<Hr_staffEducation> pageTable) {
		String queryCondition = queryCondition(pageTable);
		List<Hr_staffEducation> list = staffEducationService.selectEduListByCase_ID(queryCondition);
		pageTable.setRows(list);
		AjaxRes ar = new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	private String queryCondition(PageTable<Hr_staffEducation> pageTable) {
		String wheresql = "";
		if (null == pageTable) {
			return "";
		}
		String staffcase_Id = pageTable.getQueryCondition().getStaffcase_Id();
		if (staffcase_Id != null && !"".equals(staffcase_Id)) {
			wheresql = staffcase_Id;
		}
		return wheresql;
	}
	// 查看
	@RequestMapping(value = "/selectEducationViewPage")
	public ModelAndView selectEducationViewPage(String educationID) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		try {
			Hr_staffEducation hrstaffEdu = staffEducationService.selectOneByEducationId(educationID);
			mv.setViewName("/oa/personfile/employeeInfo/basicInfo/educationBackground/viewModal");
			getDicTypeMapUp(mv);
			mv.getModel().put("hrstaffEdu", hrstaffEdu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	private void getDicTypeMapUp(ModelAndView modeAndView) {
		// 学历
		Map<String, String> EducationMap = sysDicDataService.selectDicTypeDicNoEableMap("",
				"1d5c390cc0ac4a8ab77270ef0debe823");

		modeAndView.getModel().put("EducationMap", EducationMap);
	}
	// 添加信息页面
	@RequestMapping(value = "/educationBackgroundAddPage")
	public ModelAndView educationBackgroundAddPage(Hr_staffEducation hrstaffEdu) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		getDicTypeMapUp(mv);
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/educationBackground/addModal");
		mv.getModel().put("hrstaffEdu", hrstaffEdu);
		return mv;
	}
	//添加一条记录
	@RequestMapping(value = "/insertOneEducationInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes insertOneEducationInfo(@RequestBody Hr_staffEducation hrstaffEdu) {
		AjaxRes ar = new AjaxRes();
		try {
			hrstaffEdu.setEducationID(Tool.createUUID32());
			Boolean b = staffEducationService.insertOneEducationInfo(hrstaffEdu);
			ar.setSucceed(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;
	}

	// 修改信息页面
	@RequestMapping(value = "/selecteducationBackgroundEditPage")
	public ModelAndView selecteducationBackgroundEditPage(Hr_staffEducation hrstaffEdu) {
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		if (hrstaffEdu == null) {
			hrstaffEdu = new Hr_staffEducation();
		}
		hrstaffEdu = staffEducationService.selectOneByEducationId(hrstaffEdu.getEducationID());
		getDicTypeMapUp(mv);
		mv.setViewName("/oa/personfile/employeeInfo/basicInfo/educationBackground/upModal");
		mv.getModel().put("hrstaffEdu", hrstaffEdu);
		return mv;
	}

	// 更新一条数据
	@RequestMapping(value = "/updateOneEducationInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateOneEducationInfo(@RequestBody Hr_staffEducation hrstaffEdu) {
		Boolean result = true;
		Hr_staffEducation isExist = staffEducationService.selectOneByEducationId(hrstaffEdu.getEducationID());
		if (isExist != null) {
			result = staffEducationService.updateOneEducationInfo(hrstaffEdu);
		}
		AjaxRes ar = new AjaxRes();
		if (result) {
			ar.setSucceed("1");
		} else {
			ar.setSucceed("0");
		}
		return ar;
	}

}

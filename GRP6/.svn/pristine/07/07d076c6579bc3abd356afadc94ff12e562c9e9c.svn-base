package com.zjm.activiti.testdata.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.common.db.model.AjaxRes;
import com.zjm.common.db.model.PageTable;

@Controller
public class TestDataAction {

	
	
	@RequestMapping(value = "/testdata/processDesignTree")
	@ResponseBody
	public AjaxRes processDesignTree() {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1");
		map.put("pId", "-1");
		map.put("name", "融资类流程");
		map.put("open", true);
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "2");
		map.put("pId", "1");
		map.put("name", "保前流程");
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "3");
		map.put("pId", "1");
		map.put("name", "解保流程");
		mapList.add(map);
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(mapList);
		return ar;
	}
	@RequestMapping(value = "/testdata/processDesignList")
	@ResponseBody
	public AjaxRes processDesignList(@RequestBody PageTable pageTable) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "模板名称1");
		map.put("type", "融资保前流程");
		map.put("state", "已发布");
		map.put("date", "2017-07-04");
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "模板名称2");
		map.put("type", "财务收费流程");
		map.put("state", "已发布");
		map.put("date", "2017-07-04");
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("name", "模板名称3");
		map.put("type", "到期解保流程");
		map.put("state", "已发布");
		map.put("date", "2017-07-04");
		mapList.add(map);
		pageTable.setRows(mapList);
		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
	
	
	@RequestMapping(value = "/testdata/processInstanceList")
	@ResponseBody
	public AjaxRes processInstanceList(@RequestBody PageTable pageTable) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("processInstanceName", "流程名称1");
		map.put("processInstanceID", "1");
		map.put("processtemplateName", "流程模板名称1");
		map.put("createUserName", "马朔");
		map.put("currentTask", "尽职调查");
		map.put("currentUserName", "陈扬");
		map.put("beginDate", "2017-07-05 09:33:12");
		map.put("endDate", "-");
		map.put("timeConsuming", "-");
		map.put("processInstanceState", "正在运行");
		map.put("createDate", "2017-07-05 09:01:52");
		mapList.add(map);
		map.put("processInstanceName", "流程名称2");
		map.put("processInstanceID", "2");
		map.put("processtemplateName", "流程模板名称2");
		map.put("createUserName", "马朔");
		map.put("currentTask", "尽职调查");
		map.put("currentUserName", "陈扬");
		map.put("beginDate", "2017-07-05 09:33:12");
		map.put("endDate", "-");
		map.put("timeConsuming", "-");
		map.put("processInstanceState", "正在运行");
		map.put("createDate", "2017-07-05 09:01:52");
		mapList.add(map);
		map = new HashMap<String, Object>();
		map.put("processInstanceName", "流程名称3");
		map.put("processInstanceID", "3");
		map.put("processtemplateName", "流程模板名称3");
		map.put("createUserName", "马朔");
		map.put("currentTask", "尽职调查");
		map.put("currentUserName", "陈扬");
		map.put("beginDate", "2017-07-05 09:33:12");
		map.put("endDate", "-");
		map.put("timeConsuming", "-");
		map.put("processInstanceState", "正在运行");
		map.put("createDate", "2017-07-05 09:01:52");
		mapList.add(map);
		pageTable.setRows(mapList);
		
		AjaxRes ar=new AjaxRes();
		ar.setSucceed(pageTable);
		return ar;
	}
}

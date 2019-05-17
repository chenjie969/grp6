package com.zjm.sys.sort.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjm.common.db.model.AjaxRes;
import com.zjm.sys.sort.service.SortService;

/**
 * 公共排序
 * @author mashuo add 20170411
 */
@Controller
public class SortAction {
	@Resource
	private SortService sortService;
	/**
	 * 顺序调整
	 * @return
	 */
	@RequestMapping(value="/updateSortOrder", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes updateSortOrder(@RequestBody String sortObj){
		JSONObject sort=JSON.parseObject(sortObj);
		AjaxRes ar=new AjaxRes();
		Boolean b=sortService.updateSortOrder((String) sort.get("tableName"),(String) sort.get("tableFileName"),(String) sort.get("tableFileIds"));
		ar.setSucceed(b);
		return ar;
	} 
}

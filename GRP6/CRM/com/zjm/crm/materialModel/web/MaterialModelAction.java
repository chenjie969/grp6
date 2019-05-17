package com.zjm.crm.materialModel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.materialDetail.service.MaterialDetailService;
import com.zjm.crm.materialModel.service.MaterialModelService;
import com.zjm.crm.materialTree.service.MaterialTreeService;

@Controller  
@RequestMapping(value="/client/materialModel")
public class MaterialModelAction {

	@Resource
	private ClientService clientService;
	
	@Resource
	private MaterialTreeService materialTreeService;
	@Resource
	private MaterialModelService materialModelService;
	@Resource
	private MaterialDetailService materialDetailService;
		
		
	
	
}

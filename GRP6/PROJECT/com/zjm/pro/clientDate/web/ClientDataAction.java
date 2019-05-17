package com.zjm.pro.clientDate.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.crm.client.service.ClientService;
import com.zjm.crm.db.model.Client;
import com.zjm.crm.db.model.UploadParam;
import com.zjm.util.CustomDispatchServlet;

@Controller  
@RequestMapping(value="/project/clientData")
public class ClientDataAction {

	@Resource
	private ClientService clientService;
	
	
	@RequestMapping(value="/clientDataNeedSubmit")
	public ModelAndView returnClientDetailPage(UploadParam uploadParam){
		ModelAndView mv = CustomDispatchServlet.getModeAndView();
		
		Client client = new Client();
		if(null != uploadParam.getClientID()){
			client= clientService.selectOneClientByWheresql(" and client_ID = \'"+uploadParam.getClientID()+"\'");
			if("01".equals(client.getClientTypeID()) ){
				uploadParam.setClientFileType("dd8413aadf0945abb1ce600aa8fe45c8");//企业客户;
			}else{
				uploadParam.setClientFileType("dac960048cac4e44ac58ac574c07d125");//个人客户;
				
			}
		}
		mv.setViewName("/project/clientData/clientDataNeedSubmit");
		mv.getModelMap().put("client",client);
		return mv;
	}
	
	
	
}

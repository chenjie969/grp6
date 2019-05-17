package com.zjm.pro.expireMessage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjm.util.CustomDispatchServlet;

/**
 * @description 出具到期通知函
 * @company http://www.igit.com.cn/  
 * @author wuhn	
 * @date 2017年8月21日 下午3:10:08
*/
@Controller
@RequestMapping(value="/expireMessageAction")
public class ExpireMessageAction {
	
	
	/**
	 * @description	 出具到期/逾期催收通知函 页面
	 * @author wuhn
	 * @date 2017年8月21日 下午3:12:06
	 */
	@RequestMapping(value="/expireMessagePage")
	public ModelAndView expireMessagePage(){
		ModelAndView modeAndView = CustomDispatchServlet.getModeAndView();
		modeAndView.setViewName("/project/expireMessage/expireMessageList");
		return modeAndView;
	}
}


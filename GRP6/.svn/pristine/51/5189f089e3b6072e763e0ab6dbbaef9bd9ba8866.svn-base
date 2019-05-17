package com.zjm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class SimpleMappingExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,Exception arg3) {
		String header = ((HttpServletRequest) arg0).getHeader("X-Requested-With");
		arg3.printStackTrace();
		if(arg3 instanceof UnauthorizedException){//无权限返回错误提示页面
			if("XMLHttpRequest".equalsIgnoreCase(header)){//是否是ajax请求
				ModelAndView mv=new ModelAndView("/error404ajax");
				return mv;  
			}else{
				ModelAndView mv=new ModelAndView("/error404");
				return mv;  
			}
		}
		
		if("XMLHttpRequest".equalsIgnoreCase(header)){
			ModelAndView mv=new ModelAndView("/error500ajax");
			return mv;  
		}else{
			ModelAndView mv=new ModelAndView("/error500");
			return mv;  
		}
	}

}

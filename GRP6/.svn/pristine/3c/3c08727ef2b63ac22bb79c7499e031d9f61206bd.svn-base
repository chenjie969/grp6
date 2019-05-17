package com.zjm.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义DispatchServlet
 * @author mashuo add 20170512
 *
 */
public class CustomDispatchServlet extends DispatcherServlet{
	private static List<ModelAndView> modeAndViews = new ArrayList<ModelAndView>(20);   

	static{   
		for(int i = 0; i < 20; i++){   //缓存量为20   
			modeAndViews.add(new ModelAndView());   
		}   
	}   

	public void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response)   
			throws Exception{   
		super.render(mv, request, response);   
		releaseModelAndView(mv);   
	}   

	//回收ModelAndView   
	private void releaseModelAndView(ModelAndView mv){   
		mv.clear();   
		mv.getModelMap().clear();   
		synchronized(modeAndViews){   
			modeAndViews.add(mv);   
		}   
	}   

	//取ModelAndView   
	public static ModelAndView getModeAndView(){   
		synchronized(modeAndViews){   
			if(modeAndViews.size() > 0)   
				return modeAndViews.remove(0);   
			else   
				return new ModelAndView();   
		}   
	}   

}

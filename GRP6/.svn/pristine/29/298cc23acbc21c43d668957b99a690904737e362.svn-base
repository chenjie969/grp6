<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.baidu.ueditor.*"   pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	String path = request.getContextPath();
	String rootPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/* String rootPath = application.getRealPath( "/" ); */
	
	response.getWriter().write( new ActionEnter( request, rootPath ).exec() );
	 
%>
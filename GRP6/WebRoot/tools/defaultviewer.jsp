<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.io.*"%>
<%@ taglib uri="/WEB-INF/tlds/jatools.tld" prefix="jatools" %>
<%
String path  = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
java.util.Date currentTime = new java.util.Date();//得到当前系统时间
String vardate = formatter.format(currentTime); //将日期时间格式化 
String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式 
%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表控件</title>
<OBJECT ID="_jatoolsPrinter" style='display:none' CLASSID="CLSID:B43D3361-D075-4BE2-87FE-057188254255" codebase="tools/jatoolsPrinter.cab#version=8,6,1,0"></OBJECT>
	<!-- 核心  版本 jquery-1.8.3-->
	<script src="<%=path %>/js/jquery.js"></script>
	
	<script src="<%=path %>/js/toolsbar.js"></script>
	<link href="<%=path %>/report/report_display.css?v=<%=vardate%>" rel="stylesheet">
	
	
	<style type="text/css">
		.zjm-selectTreeWidgets{
			 margin-left: 47px;
		}
		.isshow_countIf{
			display:none;
		}
		.fold-filter {
		    height: 30px;
		    width: 100%;
		}
		.fold-filter-line {
		    background-color: #fff;
		    border-bottom: 1px solid #cccccc;
		    border-left: 1px solid #cccccc;
		    border-right: 1px solid #cccccc;
		    cursor: pointer;
		    display: inline-table;
		    float: right;
		    font-size: 14px;
		    font-weight: bold;
		    height: 25px;
		    line-height: 25px;
		    margin-right: 10px;
		    position: relative;
		    text-align: center;
		    width: 60px;
		}
	</style>
</head>
<body style='margin:0;padding:30px 0 5px 0;'><!-- overflow:hidden; -->
<%
String file = request.getParameter("file");
if(file != null)
{
 String tplRoot=getServletConfig().getServletContext().getRealPath("/");
  
 if(!tplRoot.endsWith(File.separator))
 {
 	tplRoot+= File.separator;
 }
 
 tplRoot+=file;
 file = tplRoot.replace('\\','/');
}
%>

<%-- <jatools:report id="_report1" template="D:\\workspaces_GRP6.0\\GRP6\\WebRoot\\reportXML\\clientDetail.xml" >
 --%><jatools:report id="_report1"  template="<%=file%>">
<%@ include file='toolsbar.jsp' %>
</jatools:report>
<!-- 统计条件 -->
<div id="reportCountIfPage"></div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <title>文档在线查看</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Office文档在线编辑">
	<link rel="stylesheet" href="<%=path %>/documentPreview/domViewHeaderInfo.css?v=<%=vardate%>" charset="UTF-8"/>
	<script src="<%=path %>/assets/js/jquery-2.0.3.min.js?v=<%=vardate%>"></script>
	<script type="text/javascript" src="<%=path %>/js/zjm_tool.js?v=<%=vardate%>"></script>
  </head>
  <body>
   <form action="/sys/documentPreview/saveFile.action" enctype="multipart/form-data" id="myForm">
   		<input type="hidden" name="domhref" value="${domhref}">
   		<input type="hidden" name="domextend" value="${domextend}" id="domextend" >
   		<table width=100% height=100% class="small" align="center">
	   		<tr width=100%>
				<td id="td_menu" valign=top width=1>
					<!--  -->
					<%@ include file="/documentPreview/domViewHeaderInfo.jsp" %>
					<script type="text/javascript" src="<%=path %>/documentPreview/officeToolBar.js?v=<%=vardate%>"></script>
				</td>
				<td valign="top">
					<script type="text/javascript" src="<%=path %>/documentPreview/ntkoOfficeTools.js?v=<%=vardate%>"></script>
					<script type="text/javascript" src="<%=path %>/documentPreview/ntkoOfficeMain.js?v=<%=vardate%>"></script>
				</td>
			</tr>
	   </table>
   </form>
   <script type="text/javascript">
   		window.onload = function(){
   			intializePage("${domhref}?v=<%=vardate%>","${sessionUser.user_name}","view");
   		};
   </script>
  </body>
</html>

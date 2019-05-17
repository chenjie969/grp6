<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <title>文档在线编辑</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="平台Office文档在线编辑">
	<meta http-equiv="description" content="Office文档在线编辑">
	<link rel="stylesheet" href="<%=path %>/documentPreview/domViewHeaderInfo.css?v=<%=vardate%>" charset="UTF-8"/>
	
	<script src="<%=path %>/assets/js/jquery-2.0.3.min.js?v=<%=vardate%>"></script>
	<script type="text/javascript" src="<%=path %>/js/zjm_tool.js?v=<%=vardate%>"></script>
  
 </head>
  <body onbeforeunload="onPageClose();">
   <form action="/sys/documentPreview/saveFile" enctype="multipart/form-data" id="myForm">
   		<input type="hidden" name="domhref" value="${domhref}" id="domhref">
   		<input type="hidden" name="domextend" value="${domextend}" id="domextend">
   		<table width=100% height=100% class="small" align="center">
	   		<tr width=100%>
				<td id="" valign=top width=1>
					<!--  -->
					<%@ include file="/documentPreview/domViewHeaderInfo.jsp" %>
					<%-- <c:if test="${oaMark == 'oa'}">
						<script type="text/javascript" src="<%=path %>/documentPreview/officeToolBarForOA.js?v=<%=vardate%>"></script>
					</c:if>
					<c:if test="${oaMark != 'oa'}"> --%>
						<script type="text/javascript" src="<%=path %>/documentPreview/officeToolBar.js?v=<%=vardate%>"></script>
					<%-- </c:if>
					<c:if test="${oaMark == 'otheroa'}">
						<script type="text/javascript" src="<%=path %>/documentPreview/officeToolBarForOtherOA.js?v=<%=vardate%>"></script>
					</c:if> --%>
				</td>
				<td valign="top">
					<script type="text/javascript" src="<%=path %>/documentPreview/ntkoOfficeTools.js?v=<%=vardate%>"></script>
					<script type="text/javascript" src="<%=path %>/documentPreview/ntkoOfficeMain.js?v=<%=vardate%>"></script>
					<!-- 菜单项的事件处理 -->
					<script language="JScript" for=TANGER_OCX event="OnFileCommand(TANGER_OCX_str,TANGER_OCX_obj)">
							if (TANGER_OCX_str == 3) //保存按纽
							{
							TANGER_OCX_OBJ.CancelLastCommand = true;
							if(!TANGER_OCX_OBJ.activeDocument.saved){
								var returnResault = saveFileToUrl();
								if(returnResault){
									alert("文档保存成功!");
								}else{
									alert("文档保存失败!");
								}
							}
								
								
							}
							if (TANGER_OCX_str == 2) //关闭时
							{
								//全屏状态时，关闭文档的话无法关闭控件的窗口，即窗口还是悬浮在jsp页面上方，所以的先设置空间的窗口为非全屏状态。	                   
			                    TANGER_OCX.FullScreenMode = false;	
			                    window.close();
							}
					</script>
				</td>
			</tr>
	   </table>
   </form>
   <script type="text/javascript">
   		window.onload = function(){
   			intializePage("${domhref}?v=<%=vardate%>","${sessionUser.user_name}","edit");
   		};
   		
   		window.onbeforeunload = function(){
   			if(!TANGER_OCX_OBJ.activeDocument.saved){
   				return "保存数据后再关闭!";
   				//if(confirm("您确定要关闭本页吗？")){
   				//	window.close();
   				//}
   			}else{
   				window.close();
   			}
   			
   		};
   </script>
   
   <%-- <!-- 基础样式    包含:表格样式-->
	<link href="<%=path %>/themes/default/stable.css?v=<%=vardate%>" rel="stylesheet">
   
   	<!-- jqueryui 组件 -->
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/default/jui/jquery-ui-1.10.4.custom.css"/>
	<script src="<%=path %>/themes/default/jui/jquery-ui-1.10.4.custom.js"></script>
	<script src="<%=path %>/themes/default/jui/jquery.ui.datepicker-zh-CN.js"></script> --%>
   
   	
   
   
   <%-- <script type="text/javascript" src="<%=path %>/documentPreview/ntkoGenObj.js?v=<%=vardate%>"></script>
   <script type="text/javascript" src="<%=path %>/documentPreview/NtkoAddSecSign.js?v=<%=vardate%>"></script>  --%>
  
   
  </body>
</html>

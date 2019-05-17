<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common_timestamp.jsp" %>
<html>
	<head>
		<meta charset="utf-8" />
		<title>担保综合业务管理系统</title>
		<!-- 在双核浏览器情况下,使用极速模式 webkit内核渲染-->
		<meta name="renderer" content="webkit"/>
		<!-- 以下三句搭配用清缓存-->
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="Expires" content="0"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@ include file="common_head.jsp" %>
		<link type="text/css" rel="stylesheet" href="<%=path %>/plugins/tabs/css/tab-control.min.css" />
	</head>
	
	<body>
		<%@ include file="top.jsp" %>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed');}catch(e){}
			</script>
			<div class="main-container-inner">
				<%@ include file="left.jsp" %>
				<!-- 右侧内容栏  begin -->
				<div class="main-content" id="maincontent">
					<div class="page-content ">	
						<div class="tab-control">		
							<div  class="tab simple">
								<form>
									<input class="prev" type="button" /> 
									<input class="next" type="button" /> 
									<input class="find" type="button" />
								</form>
								<ul class="tabul"></ul>
							</div>
							<!-- 标签查找 -->
							<div class="tab-find hidden ">
								<form><input class="text" type="text" />
									<input type="hidden" id="sessionIsHoldingGroup" class="sessionIsHoldingGroup" value="${sessionIsHoldingGroup}"/>
								</form>
								<ul></ul>
							</div>
							<!-- 主体 -->
							<div class="main">
							<%-- <shiro:authenticated>用户已经登录显示此内容</shiro:authenticated><br/>
							<shiro:hasRole name="manager">manager角色登录显示此内容</shiro:hasRole><br/>
							<shiro:hasRole name="admin">admin角色登录显示此内容</shiro:hasRole><br/>
							<shiro:hasAnyRoles name="manager,admin">manager or admin 角色用户登录显示此内容</shiro:hasAnyRoles><br/>
							<shiro:principal/>显示当前登录用户名<br/>
							<shiro:hasPermission name="useradd">useradd权限用户显示此内容</shiro:hasPermission><br/>
							<shiro:hasPermission name="add">add权限用户显示此内容</shiro:hasPermission><br/>
							<shiro:lacksPermission name="useradd"> 不具有useradd权限的用户显示此内容 </shiro:lacksPermission><br/>
							<shiro:lacksPermission name="del"> 不具有del权限的用户显示此内容 </shiro:lacksPermission><br/>
							
							
							<shiro:hasPermission name="admin:useradd2">admin:useradd2权限用户显示此内容</shiro:hasPermission><br/>
							<shiro:hasPermission name="user:useradd">user:useradd权限用户显示此内容</shiro:hasPermission><br/> --%>
							
							</div>			
						</div>	
					</div>
				</div>
				<%@ include file="right.jsp" %>
			</div>
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> 
				<i class="icon-double-angle-up icon-only bigger-110"></i> 
			</a>
		</div>
		<%@ include file="common_foot.jsp" %>
		<script src="<%=path %>/plugins/jquery/jquery.md5.js?v=<%=vardate%>"></script>
		<script src="<%=path %>/plugins/tabs/js/tab-control.min.js?v=<%=vardate%>"></script>
		<script src="<%=path %>/index.js?v=<%=vardate%>"></script>
		<div id="tabsMenurrr" class="hide" >
			<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close" style="display: block;">
				<li>
					<a class="btn_removeIframe" datav="one">关闭当前页面</a>
				</li>
				<li class="divider"></li>
				<li>
					<a class="btn_removeIframe" datav="left">关闭左侧所有页面</a>
				</li>
				<li>
					<a class="btn_removeIframe" datav="right">关闭右侧所有页面 </a>
				</li>
				<li>
					<a class="btn_removeIframe" datav="other">关闭其它页面 </a>
				</li>
				<li>
					<a class="btn_removeIframe" datav="all">关闭所有页面</a>
				</li>
				<li class="divider"></li>
				<li>
					<a class="btn_removeIframe" datav="close">关闭弹出窗口</a>
				</li>
			</ul>
		</div>
  <div id="userSet_page"></div>
  
  
	</body>
</html>

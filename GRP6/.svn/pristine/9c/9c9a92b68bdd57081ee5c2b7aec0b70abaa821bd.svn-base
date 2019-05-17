<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="navbar navbar-default" id="navbar" >
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed');}catch(e){};
		
		function full(){
			launchFullScreen(document.documentElement); 
 		}

		function launchFullScreen(element) {
			if(element.requestFullscreen) {
			 	element.requestFullscreen();
			} else if(element.mozRequestFullScreen) {
			 	element.mozRequestFullScreen();
			} else if(element.webkitRequestFullscreen) {
			 	element.webkitRequestFullscreen();
			} else if(element.msRequestFullscreen) {
			 	element.msRequestFullscreen();
			}
		}
	</script>
	<div class="navbar-container" id="navbar-container" >
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand"> 
				<small> 
					<img src="<%=path %>/assets/images/gallery/logo-rongtou.png" alt="logo"> 
                <%-- <img src="<%=path %>/assets/images/gallery/logo.png" alt="logo">  --%>
				</small> 
			</a>
			<!-- /.brand -->
		</div>
		<!-- /.navbar-header -->
		<div class="navbar-header pull-right" role="navigation" >
			<ul class="nav ace-nav" >
				<li class="light-blue" style="height:51px;cursor:pointer">
					<c:if test="${sessionIsHoldingGroup=='true'}">
						<a onclick="openMenu('menucb628a4aa341458685d695aa8c22de4b','menu0','首页','/project/riskDesktop/showRiskDesktopIndexPage')" style="height:51px;">
					</c:if>
					<c:if test="${sessionIsHoldingGroup=='false'}">
					<a onclick="openMenu('menucb628a4aa341458685d695aa8c22de4b','menu0','首页','/gbpm/index/indexPackage')" style="height:51px;">
					</c:if>
						<i class="icon-home"></i>
						首页
					</a>
				</li>
				<li class="light-blue" style="height:51px;cursor:pointer">
					<a onclick="full()" style="height:51px;">
						<i class="icon-fullscreen"></i>
						全屏
					</a>
				</li>
				<li class="light-blue" style="height:51px;">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle" style="height:51px;"> 
						<%-- <img class="nav-user-photo" src="<%=path %>/assets/avatars/avatar6.png" alt="Jason's Photo" />  --%>
						<i class="icon-user"></i>
						<span class="user-info"> 
						<input type="hidden" id="userpassword" class="" name="userpassword" value="${sessionUser.userpassword}">
							<small>您好！</small>${sessionUser.user_name}
						</span> 
						<i class="icon-caret-down"></i> 
					</a>

					<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<%-- <shiro:hasPermission name="user:personSet:edit"> --%>
						<li>
							<a href="#" onclick="editUserSet()"> 
								<i class="icon-cog"></i> 个人设置 
							</a>
						</li>
						<%-- </shiro:hasPermission> --%>
						<li>
							<a href="#"> 
								<i class="icon-exclamation-sign"></i> 帮助 
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="#" onclick="loginOut()"> 
								<i class="icon-off"></i> 退出 
							</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- /.ace-nav -->
		</div>
		<!-- /.navbar-header -->
	</div>
	<!-- /.container -->
</div>
<!--/.navbar-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springframework.web.util.WebUtils"%>
<%@ include file="/common_timestamp.jsp" %>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>担保综合业务管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!-- basic styles -->
	<link href="<%=path %>/assets/css/bootstrap.min.css?v=<%=vardate%>" rel="stylesheet" />
	<link rel="stylesheet" href="<%=path %>/assets/css/font-awesome.min.css?v=<%=vardate%>" />

	<!--[if IE 7]>
	  <link rel="stylesheet" href="<%=path %>/assets/css/font-awesome-ie7.min.css?v=<%=vardate%>" />
	<![endif]-->

	<!-- page specific plugin styles -->
	<!-- fonts -->
	<link rel="stylesheet" href="<%=path %>/assets/font/fonts-googleapis.css?v=<%=vardate%>" />
	<!-- ace styles -->

	<link rel="stylesheet" href="<%=path %>/assets/css/ace.min.css?v=<%=vardate%>" />
	<link rel="stylesheet" href="<%=path %>/assets/css/ace-rtl.min.css?v=<%=vardate%>" />

	<!--[if lte IE 8]>
	  <link rel="stylesheet" href="<%=path %>/assets/css/ace-ie.min.css?v=<%=vardate%>" />
	<![endif]-->

	<!-- inline styles related to this page -->

	<!-- ace settings handler -->

	<script src="<%=path %>/assets/js/ace-extra.min.js?v=<%=vardate%>"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

	<!--[if lt IE 9]>
	<script src="<%=path %>/assets/js/html5shiv.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/assets/js/respond.min.js?v=<%=vardate%>"></script>
	<![endif]-->
	<style media="screen" type="text/css">
		.check a:hover{text-decoration: none;}
	</style>
	<script src="<%=path %>/plugins/jquery/jquery.min.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/plugins/jquery/jquery.md5.js?v=<%=vardate%>"></script>
	<script src="<%=path %>/js/jquery.cookie.js"></script>
	
	<!-- jqueryui 组件 -->
<link rel="stylesheet" type="text/css" href="<%=path %>/plugins/jquery/jui/jquery-ui-1.10.4.custom.css"/>
<script src="<%=path %>/plugins/jquery/jui/jquery-ui-1.10.4.custom.js"></script>
<script src="<%=path %>/plugins/jquery/jui/jquery.ui.datepicker-zh-CN.js"></script>
	<script src="<%=path %>/assets/js/jquery.autosize.min.js"></script>
	
	<!-- 日历控件(只选择年月) -->
	<link href="<%=path %>/js/util/simpleCanleder.css" rel="stylesheet">
	<script type="text/javascript" src="<%=path %>/js/util/simpleCanleder.js"></script>
	
	
	<!-- 表单验证 -->
	<!-- css样式 -->
	<link type="text/css" rel="stylesheet" href="<%=path %>/plugins/validationEngine/validationEngine.jquery.css">
	<!-- 核心 -->
	<script type="text/javascript" src="<%=path %>/plugins/validationEngine/jquery.validationEngine.js?v=<%=vardate%>"></script>
	<!-- 中文包 -->
	<script type="text/javascript" src="<%=path %>/plugins/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	
	
	
	<script type="text/javascript" src="<%=path %>/js/zjm.js?v=<%=vardate%>"></script>


	<script src="<%=path %>/login.js?v=<%=vardate%>"></script>
	
	<script type="text/javascript">
		function  showImg(){
		document.getElementById("phoneImg").style.display='block';
		}
		function hideImg(){
		document.getElementById("phoneImg").style.display='none';
		}
	</script>
</head>
<body>
		<div class="main-container">
				<div style="padding:20px 0;">
	            <div class="container">
	                <img src="assets/images/logo1.png" alt="GRP" class="pull-left">
	                <!-- <img src="assets/images/gallery/phone.png" alt="phone" class="pull-right" onmouseover="showImg()" onMouseOut="hideImg()"  style="margin-left:3%;margin-top:16px"/>
	    			<img src="assets/images/gallery/logo_3.png" alt="logo" class="pull-right" /> -->
	            </div>
	            <div id="phoneImg" style="display:none;back-ground:#f00;position:absolute;right:30px;top:120px;">
	            	<img src="assets/images/gallery/qr.png" alt="qr"  style="width:150px;height:150px"/>
	            </div>
			</div>
			<div style="background-image:url(assets/images/bg2.png);background-color:#fff;background-repeat:no-repeat;background-position:center;padding:50px 0;height:730px;">
				<div style="width:1200px;height:730px;margin:0 auto;">
					<img src="assets/images/logo2.png" style="margin-top:290px;margin-left:5%;float:left;" />
					<div style="width:40%;margin:0 auto;padding:30px;padding-top:40px;margin-left:10%;float:left;background-color:#fff;box-shadow:0 0 20px #666666;height:360px;;margin-top:130px;">
						<form id="loginForm" method="post">
						<fieldset>
							<h4>用户登录</h4>
							<div class="space"></div>
							<label class="block clearfix">
								<span class="block input-icon input-icon-right">
									<input type="text" id="user_id" name="user_id" class="form-control validate[required,maxSize[30]]" placeholder="用户名" />
									<i class="icon-user"></i>
								</span>
							</label>

							<div class="space"></div>

							<label class="block clearfix">
								<span class="block input-icon input-icon-right">
									<input type="password" id="userpassword" name="userpassword" class="form-control validate[required,maxSize[32]]" placeholder="密码" />
									<i class="icon-lock"></i>
								</span>
							</label>
							<div class="clearfix">
								<label class="inline">
									<input type="checkbox" class="ace" id="cookie"/>
									<span class="lbl"> 记住密码</span>
								</label>
							</div>
							<div class="space"></div>
							<button type="button" id="btn_login" class="width-100 pull-right btn btn-sm btn-primary">
								<i class="icon-key"></i>
								登 录
							</button>
							<!-- <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link" >
								<i class="icon-arrow-left"></i>
								忘记密码
							</a> -->
						</fieldset>
						</form>
				
			</div>
				</div>
			</div>
			<div class="footer">
				<div style="margin-top:20px;text-align:center;">
					<a href="#">帮助中心</a>
					<img src="assets/images/gallery/lt_line.png" />
					<a href="#">技术支持</a>
					<img src="assets/images/gallery/lt_line.png" />
					<a href="#">用户反馈</a>
				</div>
				<div style="text-align:center;margin-top:20px;color:#999">建议使用IE 9.0以上版本或者谷歌内核的浏览器</div>
			</div>
		</div>
	</body>
</html>
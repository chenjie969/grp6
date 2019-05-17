<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.springframework.web.util.WebUtils"%>
<%@ include file="/common_timestamp.jsp" %>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>登录</title>
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


	<script src="<%=path %>/login_phone.js?v=<%=vardate%>"></script>
</head>
<body>
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<!-- <i class="icon-leaf green"></i> -->
									<span class="red">GRP</span>
									<span class="white" style="font-size:26px;">担保综合业务管理系统</span>
								</h1>
								<!-- <h4 class="blue">&copy; 中国投融资担保股份有限公司</h4> -->
							</div>
							<div class="space-6"></div>
							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请填写您的登录信息
											</h4>
											<div class="space-6"></div>
											<form id="loginForm">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="user_id" name="user_id" class="form-control validate[required,maxSize[30]]"placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="userpassword" name="userpassword" class="form-control validate[required,maxSize[32]]" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" id="cookie"/>
															<span class="lbl"> 记住密码</span>
														</label>
													</div>
                                                    <button type="button" id="btn_login" class="width-100 pull-right btn btn-sm btn-primary">
                                                        <i class="icon-key"></i>
                                                        登 录
                                                    </button>

													<div class="space-4"></div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div>
	</body>
</html>
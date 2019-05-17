<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/header.jsp"%> --%>
<%
	String path  = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 生成文件版本号 -->
<% 
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
	java.util.Date currentTime = new java.util.Date();//得到当前系统时间
	String vardate = formatter.format(currentTime); //将日期时间格式化 
%>
<html>
<head>
<!--这个是IE8的专用标记，是用来指定Internet Explorer 8 浏览器模拟某个特定版本IE浏览器的渲染方式，以此来解决IE浏览器的兼容问题。 -->
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">

<!-- 在双核浏览器情况下,使用极速模式 webkit内核渲染-->
<meta name="renderer" content="webkit">
<!-- 以下三句搭配用清缓存-->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Expires" content="0">

<title>平台登录</title>

	<!-- 如果是ie6加载此文件 -->
	<!--[if IE 6]>
		<script src="<%=path %>/js/ie6Error.js" language="javascript" type="text/javascript"></script>
	<![endif]-->
	
	<!-- 如果是ie8 加载此文件 -->
	<!--[if IE 8]> 
		<script src="<%=path %>/js/html5.js"></script>
	<![endif]-->


	<link href="css/images/logo.ico" rel="shortcut icon">
	<link href="images/favicon.ico" rel="shortcut icon">
	<link type="text/css" rel="stylesheet" href="css/login.css?v=<%=vardate%>">
	<link type="text/css" rel="stylesheet" href="css/login_hint.css?v=<%=vardate%>">

	<!-- jquery版本 jquery-1.8.3-->
	<script src="<%=path %>/js/jquery.js"></script>

	<!-- autoComboBox select自动检索 -->
	<script type="text/javascript" src="<%=path %>/js/combobox/jquery.ajaxComboBox.7.1.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=path %>/js/combobox/jquery.ajaxComboBox.css">

	<!-- jqueryui 组件 -->
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/default/jui/jquery-ui-1.10.4.custom.css"/>
	<script src="<%=path %>/themes/default/jui/jquery-ui-1.10.4.custom.js"></script>
	

	<script type="text/javascript" src="login.js?v=<%=vardate%>"></script>

<script type="text/javascript">

var openOffice = function(url,ext){
    var app_url,temp_url;
    switch (ext) {
        case 'doc':
        case 'docx':
        case 'docm':
        case 'dot':
            app_url ='http://sg1b-word-view.officeapps.live.com/wv/wordviewerframe.aspx?ui=zh-CN&rs=zh-CN&WOPISrc=';
            break;
        case 'ppt':
        case 'pptm':
        case 'pptx':
            app_url ='http://sg1b-powerpoint.officeapps.live.com/p/PowerPointFrame.aspx?PowerPointView=ReadingView&ui=zh-CN&rs=zh-CN&WOPISrc=';
            break;          
        case 'xls':
        case 'xlsb':
        case 'xlsm':
        case 'xlsx':
            app_url = 'http://sg1b-excel.officeapps.live.com/x/_layouts/xlviewerinternal.aspx?ui=zh-CN&rs=zh-CN&WOPISrc=';
            break;
        default:break;
    }
    temp_url = 'http://sg1b-15-view-wopi.wopi.live.net:808/oh/wopi/files/@/wFileId?wFileId=';
    temp_url += encodeURIComponent(url);
    return app_url+encodeURIComponent(temp_url)+'&access_token=1&access_token_ttl=0&type=png';
}

$(function(){
	$("#loadfile").click(function(){
 	    url = "http://babyls.duapp.com/file/test.doc";
 	    //url = "http://202.108.23.200/file/test.doc";
 	    //url = "http://122.224.242.235:9090/GWORK/doctemplate/optionDoc/9meetiing.doc";
		//221.218.181.133   202.108.23.200
		//url = "http://demo.kalcaddle.com/data/User/demo/home//14projcheck_complete.doc";
		//url = "http://202.108.23.200//file//test.doc";
		//url = "http://babyls.duapp.com//file//testppt.ppt";
		//url = "http://babyls.duapp.com/file/testexcel.xls";
		//url = "http://122.224.242.235:9090/GWORK/doctemplate/optionDoc/9meetiing.doc";
		//url = "http://babyls.duapp.com/test.doc";
		//url = "http://babyls.duapp.com/test.doc";
		//url = "http://babyls.duapp.com/test.doc";
		ext = "doc";
		alert(openOffice(url,ext));
		
		alert(url);
		
		$("#loadfile").attr("href",openOffice(url,ext));
	});
	
	//$(".kabulore-layer").css("height",$(document).height()+"px");
	//$(".box_container").css("height",$(document).height()+"px");
})

</script>

<style type="text/css">


	.kabulore-layer{
		/* background-image:url("bg.png");
	 	_filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='scale', src="bg.png");
	 	_background:none; */
		/* background-image: url("bg.png"); */
	    display: block !important;
	    left: 0;
	    position: absolute;
	    top: 0;
	    width: 100%;
	    z-index: 999999;
	    height : 1000px;
	}
	.box_container{
		  /*  background-image: url("bg.png"); */
   			 height: 100%;
    		text-align: center;
    		width: 100%;
	}
</style>




</head>

<body id="body_wrap">
	<div id="wrapper">
		<div class="bodyTop">
			<div class="headers">
				<!-- <img src="css/images/logo1.png" class="leftlogocss"> -->
				<img src="assets/images/logo1.png" class="leftlogocss">
			</div>
		</div>
		<div >

			<!-- 信息提示 -->
			<div class="layer bubbleLayer-show" id="bubbleLayer"
				style="top: 312px;">
				<div class="layer-hd"></div>
				<div class="layer-mid" id="bubbleLayerWrap"></div>
				<div class="layer-ft"></div>
				<div class="layer-arrow" id="layerArr" style="top: 25.5px;"></div>
			</div>
			<!-- 信息提示 end -->





			<div class="mainBody">
				<div id="layout-login">	
				<img src="assets/images/logo2.png" id="layout-logo2">
				<form method="post" action="login.action" class="layout-userinfo-css" id="loginform">
					<div id="layout-userinfo-one">
						<p id="layout-userinfo-user">用 户</p>
						 <input type="text" name="sys_users.user_id" id="user_id"
								 	class="login-input-username"
								 	placeholder="用户名／手机／邮箱" />
					</div>
					<div id="layout-userinfo-two">
						<p id="layout-userinfo-user">密码</p>
						<input type="password" name="sys_users.user_password"
										id="userpassword"
										class="layout-userinfo-txt2"
										placeholder="密码" />
					</div>
					<div id="layout-userinfo-password">
						 <input class="" id="layout-userinfo-password-box" type="checkbox">
						 	 <p id="layout-userinfo-password-remaccount">记住账号</p>
						 	<!--  <a id="layout-userinfo-password-changepw" href="javascript:void(0)">修改密码</a> -->
					</div>
					<input type="button" class="login-submitBut" id="loginbtn_id" 
							value="登&nbsp;&nbsp;&nbsp;录">
				</form
				<!-- 修改密码 模态窗 -->
				<div id="updateUserPasswordModel" style="display:none;"></div>
				</div>
				</div>
			</div>
		</div>
	<!-- 	<div class="phone_div">
			<a class="android" href="#" hidefocus="hidefocus">Android</a><i
				class="lineMid"></i> <a class="iphone" href="#"
				hidefocus="hidefocus">Iphone</a>
		</div> -->
	</div>
	<div id="footer" style="height:100px">
		<div class="footer_n">
			<p>
				<a href="http://www.igit.com.cn" hidefocus="hidefocus"
					style="font-size:16px;color:#999;font-family:Microsoft YaHei"
					target="_black">帮助中心
				</a>
				<i class="lineMid">|</i> 
				<a href="http://www.igit.com.cn"  hidefocus="hidefocus"
				style="font-size:16px;color:#999;font-family:Microsoft YaHei"
					target="_black">技术支持
				</a>
				<i class="lineMid">|</i> 
				<a href="http://www.igit.com.cn" hidefocus="hidefocus"
				style="font-size:16px;color:#999;font-family:Microsoft YaHei"
					target="_black">用户反馈
				</a>
			</p>
		</div>
		<div class="footer_m">
		<span style="font-size:14px;font-family:Microsoft YaHei;color:#999;line-height:40px">建议使用IE9.0以上版本或者谷歌内核的浏览器</span>
		</div>
	</div>
</body>
</html>
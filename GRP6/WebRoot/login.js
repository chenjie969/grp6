$(function () {
	var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if ((bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) ){
        window.location.href="/login_phone.jsp";
    }
	
	if ($.cookie("ztb_userid") != null && $.cookie("ztb_userid")!="null") {
		$("#user_id").attr("value", $.cookie("ztb_userid"));
		if ($.cookie("ztb_pd") != null) {
			$("#userpassword").attr("value", $.cookie("ztb_pd"));
		}
		$("#cookie").attr("checked", "checked");
	}

//点击登录按钮登录
	$("#btn_login").click(function (){
		login();
	});
//回车键登录
	$(document).keydown(function(event){
		if(event.keyCode == 13){
			login();
		}
	});
	
});

function loginAlert(msg) {
	if("moreusererror" == msg){//请退出当前账号，再登录新账号
		$("#loginForm").validationEngine("showPrompt","请退出当前账号，再登录新账号！","error");
	}else if("nullup" == msg){//用户名或密码不能为空
		$("#loginForm").validationEngine("showPrompt","用户名或密码不能为空！","error");
	}else if("nullcode" == msg){//验证码不能为空
		$("#loginForm").validationEngine("showPrompt","验证码不能为空！","error");
	}else if("usererror" == msg){//用户名或密码有误
		$("#loginForm").validationEngine("showPrompt","用户名或密码有误！","error");
	}else if("attemptserror" == msg){//错误次数过多
		$("#loginForm").validationEngine("showPrompt","错误次数过多！","error");
	}else if("error" == msg){//输入有误，验证未通过
		$("#loginForm").validationEngine("showPrompt","输入有误，验证未通过！","error");
	}else if("inactive" == msg){//当前账号已冻结，禁止登录！
		$("#loginForm").validationEngine("showPrompt","当前账号已冻结，禁止登录！","error");
	}
}

function login(){
	zjm.init();
	/**注册编辑验证引擎*/
	zjm.validata({
		formId:"loginForm"
	});
	
	if($("#loginForm").validationEngine("validate")){
		var user_id = $("#user_id").val();
		var userpassword = $("#userpassword").val();
		$.ajax({type:'POST',url:'/loginIn',data:JSON.stringify({"user_id":user_id,"userpassword":$.md5(userpassword)}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data, textStatus) {
	            	if ("success" != data.obj) {
	            		loginAlert(data.obj);
					}else{
					  	if ($("#cookie").attr("checked") == null || $("#cookie").attr("checked") == false) {
					  		$.cookie("ztb_userid",null);
					  		$.cookie("ztb_pd",null);
						} else {
							$.cookie("ztb_userid", user_id,{expires: 7});
							$.cookie("ztb_pd", userpassword,{expires: 7});
						}
						window.location.href="/index.jsp";
					}
	            }
	     });
	}
}
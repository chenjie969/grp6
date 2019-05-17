$(function () {
	if ($.cookie("ztb_userid")!=null && $.cookie("ztb_userid")!="null") {
		$("#user_id").attr("value", $.cookie("ztb_userid"));
		if ($.cookie("ztb_pd") != null) {
			$("#userpassword").attr("value", $.cookie("ztb_pd"));
		}
		$("#cookie").attr("checked", "checked");
	}
	
//登录
	$("#btn_login").click(function () {
		
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"loginForm"
		});
		
		if($("#loginForm").validationEngine("validate")){
			var user_id = $("#user_id").val();
			var userpassword = $("#userpassword").val();
			$.ajax({type:'POST',url:'/loginIn',data:JSON.stringify({
					"user_id":user_id,
					"userpassword":$.md5(userpassword)
					}),contentType:'application/json; charset=UTF-8',
		            dataType:'json',success:function(data, textStatus) {
		            	if ("success" != data.obj) {
		            		//$("#loginForm").validationEngine("showPrompt","账号或密码错误！","error");
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
});
$(function () {
	var sessionIsHoldingGroup = $("#sessionIsHoldingGroup").val();
	console.log("---1---->"+sessionIsHoldingGroup);
	if('202cb962ac59075b964b07152d234b70'==($("#userpassword").val())){//密码为123
		//editUserSet();
		$("#userSet_page").load(
				"/selectUserSetPage",{},function(response,status,xhr){
					$("#editmodule").modal({keyboard:true});
					$("#editmodule_pageClose").hide();
					$("#btn_editmodule_pageClose").hide();
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#edit_form").validationEngine("validate")){
							if($("#userSetOldPassword").val()!=$("#userSetPassword").val()){
								$("#userSetPassword").val($.md5($("#userSetPassword").val()));
								$("#userSetPassword2").val($.md5($("#userSetPassword2").val()));
							}
							var queryContainer_form = $("#edit_form");
								$.ajax({type:'POST',url:'/updateUserSetInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#editmodule").modal("hide");
											//加载菜单
											getMenu(3);
											openMenu('menucb628a4aa341458685d695aa8c22de4b','menu0','首页','/gbpm/index/indexPackage','','0');
										}else{
											alert("保存失败！");
										}
							        }
								});
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}else{
		console.log("---5---->"+sessionIsHoldingGroup);
		//加载菜单
		getMenu(1);
		if(sessionIsHoldingGroup=="true"){
			openMenu('menucb628a4aa341458685d695aa8c22de4b','menu0','首页','/project/riskDesktop/showRiskDesktopIndexPage','','0');
		}else{
			openMenu('menucb628a4aa341458685d695aa8c22de4b','menu0','首页','/gbpm/index/indexPackage','','0');
		}
	}
	
});
function getMenu(id){
	$("#menu_li_id").empty();
	$.ajax({type:'POST',url:'/selectLeftMenu',data:JSON.stringify({"mod_type":id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
        	$("#menu_li_id").html(data.obj); 
        }
	});
}

//打开菜单
function openMenu(id,parentId,menuName,resUrl,params,isReload){
	if("#"==resUrl){
		return;
	}else if('/'==resUrl.substring(0,1)){
		if(params==null || params==''){
			TabControlAppend(id,menuName,resUrl,isReload);
		}else{
			TabControlAppend(id,menuName,resUrl+"?menu="+id+params,isReload);
		}
	}else {
		TabControlAppend(id,menuName,resUrl,isReload);	
	}
}

//退出登录
function loginOut(){
	$.ajax({type:'POST',url:'/loginOut',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			if ("success" != data.obj) {
			}else{
				//window.location.href="/login.jsp";
				window.location.href="/login-rt.jsp";
			} 
	    }
	});
}

//关闭菜单
function closeMenu(id){
	if(null==id){
		return;
	}else{
		TabControlRemove(id);
	}
}
//禁止浏览器默认事件
$(document).delegate("div.tab-control div.tab ul li",'contextmenu', function (e) {
　　e.preventDefault();
});
//给选择器obj绑定右键事件
$(document).delegate("div.tab-control div.tab ul li",'mousedown', function (e) {
	if(3 == e.which){
		rightMenu(e);
	}
});

function rightMenu(event){
	$("#tabsMenurrr").attr("class","show");
	$("#tabsMenurrr").focus();
	 var e = event || window.event;
     var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
     var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
     var x = e.pageX || e.clientX + scrollX;
     var y = e.pageY || e.clientY + scrollY;
    $("#tabsMenurrr").css({"left":x+"px","top":y+"px","z-index":"99999","position":"absolute"});
    $(".btn_removeIframe").click(function(type){
    	type.preventDefault();
    	type.stopImmediatePropagation() ;
    	if($(type.target).attr("datav")=="one"){
    		TabControlRemove($(event.target).attr("index"));
    	}else if($(type.target).attr("datav")=="left"){
    		TabControlRemoveLeft($(event.target).attr("index"));
    	}else if($(type.target).attr("datav")=="right"){
    		TabControlRemoveRight($(event.target).attr("index"));
    	}else if($(type.target).attr("datav")=="other"){
    		TabControlRemoveOther($(event.target).attr("index"));
    	}else if($(type.target).attr("datav")=="all"){
    		TabControlRemoveAll($(event.target).attr("index"));
    	}else if($(type.target).attr("datav")=="close"){
    	}
    	$("#tabsMenurrr").attr("class","hide");
    	$(".btn_removeIframe").unbind("click");
    });
}



/**修改*/
function editUserSet(){
	$("#userSet_page").load(
			"/selectUserSetPage",{},function(response,status,xhr){
				$("#editmodule").modal({keyboard:true});
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#edit_form").validationEngine("validate")){
						if($("#userSetOldPassword").val()!=$("#userSetPassword").val()){
							$("#userSetPassword").val($.md5($("#userSetPassword").val()));
							$("#userSetPassword2").val($.md5($("#userSetPassword2").val()));
						}
						var queryContainer_form = $("#edit_form");
							$.ajax({type:'POST',url:'/updateUserSetInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						        	if(data.obj==1){
										$("#editmodule").modal("hide");
									}else{
										alert("保存失败！");
									}
						        }
							});
					}else{
						tool.undisabled(".btn_submit");
					}
				});
			}
	);
}



function oldPasswordvalidate(field, rules, i, options){
	if(field.val() == null){
		return "原密码不能为空！";
	}else if(field.val() == ""){
		return "原密码不能为空！";
	}else if($.md5(field.val()) != $("#userSetOldPassword").val()){
		return "原密码错误！";
	}
}
function newPasswordvalidate(field, rules, i, options){//新密码不能为123！
	if('123' == ($("#userSetPassword").val())){
		return "新密码不能为123！";//新密码不能为123！
	}else if(('202cb962ac59075b964b07152d234b70')==($("#userSetPassword").val())){
		return "与原密码重复！";//新密码不能为123！
	}
}
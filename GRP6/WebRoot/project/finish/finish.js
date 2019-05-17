(function($,z){
	$.zjm_finish = {
		generateRelieve:generateRelieve,//生成业务解除通知单
		finishSave:finishSave,  //保存保证金
		close:close,//关闭页面
		
	};
	
	function generateRelieve(){
		debugger
		var flowID = $("#flowID").val();
		var applyID = $("#apply_ID").val();
		$("#finish_page").load("/pro/finish/mouldType",{"flowID":flowID,"applyID":applyID},function(response,status,xhr){
			$("#mouldType").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_selectMouldType"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_selectMouldType");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/pro/finish/generateDocument",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#mouldType").modal("hide");
								window.location.reload();
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#mouldType").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	}
	
	//保存
	function finishSave(){
		zjm.validata({formId:"finishSave_form"});
		tool.disabled(".btn_finishSave");
		var queryContainer_form = $("#finishSave_form");
		if(queryContainer_form.validationEngine("validate")){
			console.log(JSON.stringify(queryContainer_form.serializeJson()));
			$.ajax({type:'POST',url:"/pro/finish/updateFinish",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj){
		        		window.location.reload();
					}else{
						alert(data.msg);
						tool.undisabled(".btn_finishSave");
					}
		        }
			});
		}else{
			tool.undisabled(".btn_finishSave");
		}
	}
	
	//关闭页面
	function close(){
		window.parent.closeMenu('osworkflow'+$("#project_ID").val());
		window.location.reload();
	}
})(jQuery, this);

$(function () {
	/**
	 * 生成业务解除通知单
	 */
	$(".btn_generateRelieve").click(function(){
		$.zjm_finish.generateRelieve();
	});
	
	$(".btn_finishSave").click(function(){
		$.zjm_finish.finishSave();
	});
	
	$(".btn_close").click(function(){
		$.zjm_finish.close();
	});
	
});


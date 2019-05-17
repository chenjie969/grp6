(function($,z){
	$.zjm_creditInfo = {
		initContent:initContent,
		initEdit:initEdit,
	};
	
	function initContent(){
		$.ajax({type:'POST',url:"/selectOneCreditInfo",data:JSON.stringify({"client_ID":$("#client_ID").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$.each(data.obj, function(key, value){ 
				if(key=="loanBalance"||key=="garantySum"){
					$("#creditInfo_"+key).html((value==null||value=="")?"（空）":value+"万元");
				}else{
					$("#creditInfo_"+key).text((value==null||value=="")?"（空）":value);
				}
				$("#creditInfoEdit_form [name='"+key+"']").val(value);
			});
	        }
		});
	}
	
	function initEdit(value){
		//先隐藏编辑表单中所有的div，然后根据点击按钮的value，显示对应的div
		$("#creditInfoEdit_form div.form-group").hide();	
		$("#creditInfoEdit_form div.edit_"+value).show();
		//弹出编辑模态窗
		$("#creditInfoEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		/**注册编辑验证引擎*/
		zjm.validata({formId:"creditInfoEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#creditInfoEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/updateOneCreditInfo",data:JSON.stringify($("#creditInfoEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==true){
						$("#creditInfoEdit").modal("hide");
						$.zjm_creditInfo.initContent();
					}else{
						alert("保存失败");
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#creditInfoEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
})(jQuery, this); 

$(function () {
	$("#mytab3 a[href='#six']").click(function(){
		$.zjm_creditInfo.initContent();
	});
	
	$(".creditInfo_edit").click(function(){
		$.ajax({type:'POST',url:"/selectOneCreditInfo",data:JSON.stringify({"client_ID":$("#client_ID").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$.each(data.obj, function(key, value){ 
				$("#creditInfoEdit_form [name='"+key+"']").val(value);
			});
	        }
		});
		$.zjm_creditInfo.initEdit($(this).attr("value"));
	});
});


(function($,z){
	$.zjm_development = {
		initContent:initContent,	
		developEvolutionEdit:developEvolutionEdit
	};
	
	/**初始化页面，同时初始化编辑弹窗页面**/
	function initContent(){
		$.ajax({type:'POST',url:"/selectOneManagerInfo",data:JSON.stringify({"client_ID":$("#client_ID").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$.each(data.obj, function(key, value){ 
        		if(key=="developevolution"){
        			$("#developEvolution").text((value==null||value=="")?"（空）":value);
        		}
        		$("#developEvolutionEdit_form input[name='"+key+"']").val(value);
			});
	        }
		});
	}

	/**发展沿革编辑窗口**/
	function developEvolutionEdit(){
		var l = $("#developEvolution").text();
		$("#developevolution_text").val(l=="（空）"?"":l);
		$("#developEvolutionEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"developEvolutionEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#developEvolutionEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/updateOneManagerInfo",data:JSON.stringify($("#developEvolutionEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#developEvolutionEdit").modal("hide");
						$.zjm_development.initContent();
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#developEvolutionEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
})(jQuery, this); 

$(function () {
	$("#mytab3 a[href='#four']").click(function(){
		$.zjm_development.initContent();
	});
	$("#btn_developEvolutionEdit").click(function(){
		$.zjm_development.developEvolutionEdit();
	});
});


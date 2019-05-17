(function($,z){
	$.zjm_profit = {
		loadProfitDesc:loadProfitDesc
	}
	
	/**初始化页面，同时初始化编辑弹窗页面**/
	function loadProfitDesc(client_ID){
		$.ajax({type:'POST',url:"/crm/financeDesc/selectOneFinanceDesc",data:JSON.stringify({"client_ID":client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {
				if(data.obj != null){
					var profitDesc = data.obj.profitDesc;
					$("#pre_profitDesc").text((profitDesc=="" || profitDesc == null)?"（空）":profitDesc);
				}
			}
		});
	}
	
})(jQuery, this); 

$(function () {
	
	$(".btn_profit").click(function(){
		$.zjm_profit.loadProfitDesc($("#client_ID").val());
	});
	
	$("#btn_profitEdit").click(function(){
		var l = $("#pre_profitDesc").text();
		$("#text_profitDesc").val(l=="（空）"?"":l);
		$("#profitDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#profitEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"profitDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#profitDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#profitDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#profitEdit").modal("hide");
						$.zjm_profit.loadProfitDesc($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#profitEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	});
});


(function($,z){
	$.zjm_liabilities = {
		loadLiabilities:loadLiabilities
	}
	
	function loadLiabilities(client_ID){
		$.ajax({type:'POST',url:'/crm/financeDesc/selectOneFinanceDesc',data:JSON.stringify({"client_ID":client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {
				if(data.obj != null){
					var loanChangeDesc = data.obj.loanChangeDesc;
					$("#pre_loanChangeDesc").text((loanChangeDesc=="" || loanChangeDesc == null)?"（空）":loanChangeDesc);
					var incurDebtDesc = data.obj.incurDebtDesc;
					$("#pre_incurDebtDesc").text((incurDebtDesc=="" || incurDebtDesc == null)?"（空）":incurDebtDesc);
				}
			}
		});
	}
	
})(jQuery, this);

$(function () {

	$(".btn_liabilities").click(function(){
		$.zjm_loanRec.initTable();
		$.zjm_billRec.initTable();
		$.zjm_guarantyRec.initTable();
		$.zjm_liabilities.loadLiabilities($("#client_ID").val());
	});
	
	/**近三年贷款及或有负债变动情况**/
	$("#btn_editLoanChangeDesc").click(function(){
		var l = $("#pre_loanChangeDesc").text();
		$("#text_loanChangeDesc").val(l=="（空）"?"":l);
		$("#loanChangeDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#loanChangeDescEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"loanChangeDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#loanChangeDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#loanChangeDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#loanChangeDescEdit").modal("hide");
						$.zjm_liabilities.loadLiabilities($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#loanChangeDescEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	});
	
	/**或有负债**/
	$("#btn_editIncurDebtDesc").click(function(){
		var l = $("#pre_incurDebtDesc").text();
		$("#text_incurDebtDesc").val(l=="（空）"?"":l);
		$("#incurDebtDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#incurDebtDescEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"incurDebtDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#incurDebtDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#incurDebtDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#incurDebtDescEdit").modal("hide");
						$.zjm_liabilities.loadLiabilities($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#incurDebtDescEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	});
	
});
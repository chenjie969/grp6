(function($,z){
	$.zjm_loanReview = {
		loanConfirm:loanConfirm , //已放款确认
		loanConfirmCancel:loanConfirmCancel //撤销放款
	};
	
	//var loanPlan_ID = $("#loanPlan_ID").val();
	//已放款确认
	function loanConfirm(loanPlan_ID){
		$("#loanConfirm_page").load("/project/loan/showLoanConfirmAddPage",{"loanPlan_ID":loanPlan_ID},function(response,status,xhr){
			$("#addLoanConfirm").modal({keyboard:true});
			//弹出第一个模态窗后,给他赋一个id,实现模态窗上弹出模态窗，前一个模态窗颜色变暗
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addLoanConfirm_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addLoanConfirm_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/loan/updateLoanConfirm',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addLoanConfirm").modal("hide");
										window.location.reload();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addLoanConfirm").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//撤销
	function loanConfirmCancel(loanPlan_ID){
		$("#loanConfirm_page").load("/project/loan/showLoanConfirmCancelPage",{},function(response,status,xhr){
			$("#cancelLoanConfirm").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/loan/loanConfirmCancel',data:JSON.stringify({"loanPlan_ID":loanPlan_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#cancelLoanConfirm").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#cancelLoanConfirm").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	
})(jQuery, this);

$(function () {
	//已放款确认按钮
	/*$("#btn_loanConfirm").click(function(){
		$.zjm_loanReview.loanConfirm();
	});*/
});

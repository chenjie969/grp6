(function($,z){
	$.zjm_jumpToConfirmPayment = {
		initTable:initTable,
	};
	
	/**
	 * 收费信息新增一行
	 */
	function initTable(selectContent){
		console.info(selectContent);
		for(var index in selectContent){
			$(".table_jumpToConfirmPayment tbody").append('	<tr>'+	
														  '		<td style="border:1px solid #ddd;">	'+selectContent[index].applySum+'</td>'+
														  '		<td style="border:1px solid #ddd;">	'+selectContent[index].applySum+'</td>'+
														  '		<td style="border:1px solid #ddd;">	'+selectContent[index].applySum+'</td>'+
														  '		<td style="border:1px solid #ddd;">	'+selectContent[index].applySum+'</td>'+
														  '	</tr>');
		}
	}
	
})(jQuery, this);

	$(".btn_submit").click(function(){
		tool.disabled(".btn_submit");
		var val=$('input:radio[name="isInvoice"]:checked').val();
		if(val==0){		//如果不需要开具发票，直接清空隐藏域，防止必填校验
			$("#div_isInvoice").empty();
		}
		
		/*注册编辑验证引擎*/
		zjm.validata({formId:"form_jumpToConfirmPayment"});
		if($("#form_jumpToConfirmPayment").validationEngine("validate")){
			$("#jumpToConfirmPayment").modal("hide");
		}else{
			tool.undisabled(".btn_submit");
		}
		
		$("#jumpToConfirmPayment").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	});

	//监视 是否开具发票  单选变化
	$('input:radio[name="isInvoice"]').change(function(){
		var val=$('input:radio[name="isInvoice"]:checked').val();
		if(val==1){
			$("#div_isInvoice").show();
		}else{
			$("#div_isInvoice").hide();
		}
	});
	

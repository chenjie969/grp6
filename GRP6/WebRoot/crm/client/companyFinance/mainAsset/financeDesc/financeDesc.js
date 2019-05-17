/**
 * 客户管理-企业客户--企业财务状况---主要资产情况分析---财务说明情况--
 * @atuhor: wuhn
 * @date: 2017年6月12日 15:40:25
 * 
 */

(function($,z){
	
	$.zim_financeDesc = {
			FinanceDescEdit:FinanceDescEdit,// 应收账款修改
	};
	
	//应收账款---近三年情况说明 修改
	function  FinanceDescEdit(row){
		console.log(row);
		$("#FinanceDescEdit").modal({ //开启模态窗
			keyborad:true,
		})
		$("#stockId").val(row.stockId); // 应收账款 id
		
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_Receivable"
		});
		// 显示 应收账款
	//	zjm.dataViewVal("edit_","/selectOneStockInfo",{"stockId":row.stockId},"");
		/** 保存修改** */
		tool.undisabled("#saveReceivableEdit");
		$("#saveReceivableEdit").click(function() {
			if ($("#edit_Receivable").validationEngine("validate")) {
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#edit_Receivable");
				$.ajax({
					type : 'POST',
					url : '/updateOneStockInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#ReceivableEdit").modal("hide");//隐藏模态窗
							$(".ztb_edit").val(""); // 页面清空
							$.zim_receivable.initReceivableTable(row.client_ID);
						} else {
							alert("保存失败！");
						}
					}
				});
			} else {
				tool.undisabled(".btn_submit");
			}
		});
		$("#FinanceDescEdit").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$(".btn_submit").unbind("click");
		});
	}
	
})(jQuery, this);

$(function () {
	
	//获取客户id
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	
	//修改 应收账款---近三年变动情况及原因
	$("#receivableRecentYear").click(function(){
		$.zim_financeDesc.FinanceDescEdit(client_ID);
	})
	
	
});


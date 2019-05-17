(function($,z){
	$.zjm_computeAndNotice = {
		
	};
	
	$.zjm_computeMustCharge = {
		initComputePage:initComputePage,	
	};
	
	$.zjm_paymentNotice = {
			
	};

	/****************zjm_computeAndNotice*****************/
	
	/****************zjm_computeMustCharge*****************/
	function initComputePage(){
		var agreeMonth = $("#hidden_agreeMonth").val();
		var times = Math.ceil(Number(agreeMonth)/12);
		for(var i=1; i<=times; i++){
			$(".select_payTimes").append("<option value='"+i+"'>"+i+"</option>");
		}
	}
	/****************zjm_paymentNotice*****************/
	
})(jQuery, this);

$(function () {
	
	$.zjm_computeMustCharge.initComputePage();
	
	/**
	 * 应收计算-收费类型全选框
	 */
	$("#checkAllCompute").click(function(){
		var status = $(this).is(':checked');
		$(".computeItem").prop("checked",status);
	});
	$(".computeItem").click(function(){
		var totalNum = $(".computeItem").length;
		var checkedNum = $(".computeItem:checked").length;
		if(totalNum==checkedNum){
			$("#checkAllCompute").prop("checked",true);
		}else{
			$("#checkAllCompute").prop("checked",false);
		}
	});
	/**注册日期控件点击事件*/
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	/**设置日期初始值，默认为当天*/
	$("#firstPayDate").attr("value",tool.parseDate(new Date().getTime()));
	/**
	 * 计算结果全选框
	 */
	$("#checkAllResult").click(function(){
		var status = $(this).is(':checked');
		$(".resultItem").prop("checked",status);
	});
	$(".resultItem").click(function(){
		var totalNum = $(".resultItem").length;
		var checkedNum = $(".resultItem:checked").length;
		if(totalNum==checkedNum){
			$("#checkAllResult").prop("checked",true);
		}else{
			$("#checkAllResult").prop("checked",false);
		}
	});
	/**
	 * 应收计算 要先看担保范围，根据本金/本息担保的不同，分别用同意金额/本息合计作为基础值计算费用
	 * 					如果担保范围不是100%，还要再乘以相应的百分比后，才能作为基础值
	 * 	应收费用 = 基础值*费率*同意期限（月）/12
	 */
	$("#btn_computePayment").click(function(){
		var sc = $("#tbody_compute").find("input:checkbox:checked");
		if(sc.length==0){
			$(".msgTr").show();
			$(".dataTr").hide();
			$(".resultButton").hide();
			return;
		}
		$(".msgTr").hide();
		$(".dataTr").hide();
		$(".resultButton").show();
		var agreeSum = Number($("#hidden_agreeSum").val());			//同意金额
		var agreeMonth = Number($("#hidden_agreeMonth").val());		//同意期限
		var firstPayDateStr = $("#firstPayDate").val();				//首次缴费时间
		var index = 0;
		$(sc).each(function(){
			var computeRowIndex = $(this).attr("rowIndex");
			var rate = Number($("#hidden_rate"+computeRowIndex).val());	//费率
			var payTimes = $("#select_payTimes"+computeRowIndex+" option:selected").val();	//每一项费用的缴费次数
			var paySum = agreeSum*agreeMonth/12*rate;
			if(payTimes==1){
				$("#tr"+index).show();
				$("#tr"+index+"td2").html($("#hidden_costType"+computeRowIndex).val());
				$("#tr"+index+"td3").html(Number($("#hidden_rate"+computeRowIndex).val())*100);
				$("#payDate"+index).val(firstPayDateStr);
				$("#paySum"+index).val(paySum.toFixed(2));	//收费金额单位是“元”，保留两位小数
				index++;
			}else{
				var payDate = new Date(firstPayDateStr);
				for(var i=0; i<payTimes; i++){
					var payDateStr = payDate.getFullYear()+"-"+(payDate.getMonth()<9?"0"+(payDate.getMonth()+1):(payDate.getMonth()+1))+"-"+(payDate.getDate()<10?"0"+payDate.getDate():payDate.getDate());
					$("#tr"+index).show();
					$("#tr"+index+"td2").html($("#hidden_costType"+computeRowIndex).val());
					$("#tr"+index+"td3").html(Number($("#hidden_rate"+computeRowIndex).val())*100);
					$("#payDate"+index).val(payDateStr);
					$("#paySum"+index).val((paySum/payTimes).toFixed(2));
					index++;
					payDate.setFullYear(payDate.getFullYear()+1); 
				}
			}
		});
	});
	/**
	 * 重置
	 */
	$("#btn_clearResult").click(function(){
		$(".msgTr").show();
		$(".dataTr").hide();
		$(".resultButton").hide();
	});
	
});


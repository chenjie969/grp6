(function($,z){
	$.zjm_costRecordIndex = {
		costMustToPre:costMustToPre,//到账确认--应收转预收
		costPreToCostMust:costPreToCostMust,//预收费用---撤销---预收转应收
		costFactToCostPre:costFactToCostPre,//实收费用---撤销--->实收转预收
		costPreToCostFact:costPreToCostFact,//预收费用---到账确认--->预收转实收
		costReturnToCostPre:costReturnToCostPre,//退费----退费确认--->退费转预收
		
	};
	
	/*var applyID = $("#hidden_applyID").val();
	
	var loanPlan_ID = $("#loanPlan_ID").val();//计划放款表id
	
*/
	
	
	//到账确认
	function costMustToPre(costMust_ID){
		
		$("#confirmModal").modal({keyboard:true});
		$("#confirmValue").text("是否确认已到账?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/costMust/costMustToPre',data:JSON.stringify({"costMust_ID":costMust_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$("#confirmModal").modal("hide");
						 window.location.reload();
					}else{
						alert("确认失败！");
					}
		        }
			});
		});
		
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	
	}
	
	//预收费用--撤销---预收转应收
	function costPreToCostMust(costPre_ID){
		$("#confirmModal").modal({keyboard:true});
		$("#confirmValue").text("是否撤销此预收费用?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/costPre/costPreToCostMust',data:JSON.stringify({"costPre_ID":costPre_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					$("#confirmModal").modal("hide");
					window.location.reload();
				}else{
					alert("确认失败！");
				}
			}
			});
		});
		
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
		
	}
	//预收费用--到账确认---预收转实收
	function costPreToCostFact(costPre_ID){
		$("#costRecordIndex_page").load("/project/costPre/returnCostPreToCostFactPage",{"costPre_ID":costPre_ID},function(response,status,xhr){				
			$("#costPreToFact").modal({keyboard:true});
			
		});
	
	}
	
	//实收费用-撤销--->实收转预收
	function costFactToCostPre(costFact_ID){
		$("#confirmModal").modal({keyboard:true});
		$("#confirmValue").text("是否撤销此实收费用?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/costFact/costFactToCostPre',data:JSON.stringify({"costFact_ID":costFact_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					$("#confirmModal").modal("hide");
					window.location.reload();
				}else{
					alert("确认失败！");
				}
			}
			});
		});
		
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
		
	}
	//退费列表---退费确认--->退费表转预收
	function costReturnToCostPre(costReturn_ID){
		alert(costReturn_ID);
		$("#confirmModal").modal({keyboard:true});
		$("#confirmValue").text("是否确认退费?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/costReturn/costReturnToCostPre',data:JSON.stringify({"costReturn_ID":costReturn_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$("#confirmModal").modal("hide");
						 window.location.reload();
					}else{
						alert("确认失败！");
					}
		        }
			});
		});
		
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	
	}
	
})(jQuery, this);
$(function () {
	 //到账确认--->应收转预收
	$(".btn_costMustToPre").click(function(){
		var  costMust_ID= $(this).attr("id");	
		$.zjm_costRecordIndex.costMustToPre(costMust_ID);
	});
	//撤销--->预收转应收
	$(".btn_costPreToCostMust").click(function(){
		var  costPre_ID= $(this).attr("id");	
		$.zjm_costRecordIndex.costPreToCostMust(costPre_ID);
	});
	//撤销--->实收转预收
	$(".btn_costFactToCostPre").click(function(){
		var  costFact_ID= $(this).attr("id");	
		$.zjm_costRecordIndex.costFactToCostPre(costFact_ID);
	});
	//预收费用---到账确认--->预收转实收
	$(".btn_costPreToCostFact").click(function(){
		var  costPre_ID= $(this).attr("id");	
		$.zjm_costRecordIndex.costPreToCostFact(costPre_ID);
	});
	//退费列表---退费确认--->退费表转预收
	$(".btn_costReturnToCostPre").click(function(){
		var  costReturn_ID= $(this).attr("id");	
		$.zjm_costRecordIndex.costReturnToCostPre(costReturn_ID);
	});
	
});


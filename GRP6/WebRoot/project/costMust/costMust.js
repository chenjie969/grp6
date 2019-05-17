(function($,z){
	$.zjm_costMust = {
		
	};
	
})(jQuery, this);

$(function () {
	
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		
	};
	
	/**
	 * 添加应收费用
	 */
	$(".btn_addCostMust").click(function(){
		var loanPlan_ID = $(this).attr("data-loanPlanID");
		var meetingDetail_ID = $(this).attr("data-meetingDetailID");
		if($("#table_planPay_"+loanPlan_ID).length==0){		//添加应收费用前需要先判断是否有还款计划
			$("#addMustCostConfirm").modal({keyboard:true});
			return false;
		}
		$("#page_costMust").load("/project/costMust/showCostMustAddPage",{"loanPlan_ID":loanPlan_ID,"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#costMustAdd").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_costMustAdd"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_costMustAdd");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/costMust/insertOneCostMust",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#costMustAdd").modal("hide");
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
			$("#costMustAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	});

	/**
	 * 修改应收费用
	 */
	$(".btn_editCostMust").click(function(){
		var costMust_ID = $(this).attr("data-costMustID");
		var meetingDetail_ID = $(this).attr("data-meetingDetailID");
		$("#page_costMust").load("/project/costMust/showCostMustEditPage",{"costMust_ID":costMust_ID,"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#costMustEdit").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_costMustEdit"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_costMustEdit");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/costMust/updateOneCostMust",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#costMustEdit").modal("hide");
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
			$("#costMustEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	});
	
	/**
	 * 删除应收费用
	 */
	$(".btn_delCostMust").click(function(){
		var costMust_ID = $(this).attr("data-costMustID");
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除应收费用");
		$("#delMessage").text("是否删除此应收费用信息？");
		tool.undisabled("#btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled("#btn_submit");
			$.ajax({type:'POST',url:"/project/costMust/deleteOneCostMust",data:JSON.stringify({"costMust_ID":costMust_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj){
						$("#costMustEdit").modal("hide");
						window.location.reload();
					}else{
						alert("删除失败！");
						tool.undisabled("#btn_submit");
					}
		        }
			});
		});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});
	
/*------------------------新增/修改应收费用页面用-----------------------------------------------------------------*/
	
});


(function($,z){
	$.zjm_planLoanAndPay = {
		autoAddPlanPay:autoAddPlanPay
	};
	
	/**
	 * 自动生成还款计划
	 */
	function autoAddPlanPay(loanPlan_ID){
		var apply_ID = $("#hidden_applyID").val();
		$("#page_planLoanAndPay").load("/project/loanPlan/showAutoAddPlanPayPage",{"loanPlan_ID":loanPlan_ID,"apply_ID":apply_ID},function(response,status,xhr){
			$("#planPayAutoAdd").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_planPayAutoAdd"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_planPayAutoAdd");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({
						type: "post", 
						url: "/project/loanPlan/autoAddValidata",	//自动添加还款计划时校验,如果通过,后台继续生成还款计划,不再继续发送请求
						contentType:'application/json; charset=UTF-8',
						dataType: 'json',
						data:JSON.stringify(queryContainer_form.serializeJson()),
						cache:false, 
						async:false, 
						success: function(resultdata){ 
							if(resultdata.obj.validata){	//验证通过, 继续判断是否保存成功
								if(resultdata.obj.save){
									$("#planPayAutoAdd").modal("hide");
									window.location.reload();
								}else{
									alert("保存失败！");
									tool.undisabled("#btn_submit");
								}
							}else{	//验证失败, 显示错误提示信息
								var fieldID = resultdata.obj.fieldID;
								var errorInfo = resultdata.obj.errorInfo;
								$("#"+fieldID).validationEngine("showPrompt",errorInfo,"error");
								tool.undisabled("#btn_submit");
							}
						} 
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#planPayAutoAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);

$(function () {
	
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		
	};
	
	/**
	 * 添加放款计划
	 */
	$(".btn_addLoanPlan").click(function(){
		var meetingDetail_ID = $(this).attr("data-meetingDetailID");
		$("#page_planLoanAndPay").load("/project/loanPlan/showLoanPlanAddPage",{"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#planLoanAdd").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_planLoanAdd"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_planLoanAdd");
				if(queryContainer_form.validationEngine("validate")){
					if(zjm.ajaxValidata("addLoanSum","/project/loanPlan/isMoreThanAgreeSum",JSON.stringify(queryContainer_form.serializeJson()),"计划放款总金额不能超过同意放款金额！")){	//同级目录字典检查
						$.ajax({type:'POST',url:"/project/loanPlan/insertOnePlanLoan",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj){
									$("#planLoanAdd").modal("hide");
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
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#planLoanAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	});
	
	/**
	 * 修改放款计划
	 */
	$(".btn_editLoanPlan").click(function(){
		var loanPlan_ID = $(this).attr("data-loanPlanID");
		$("#confirmModal").modal({keyboard:true});
		$("#confirmValue").html("修改放款计划可能会导致已有的还款计划及应收费用数据不准确，请手动调整相关数据。</br>是否继续修改放款计划？");
		$(".btn_submit").click(function(){
			$("#confirmModal").modal("hide");
			$("#page_planLoanAndPay").load("/project/loanPlan/showLoanPlanEditPage",{"loanPlan_ID":loanPlan_ID},function(response,status,xhr){
				$("#planLoanEdit").modal({keyboard:true});
				tool.undisabled("#btn_submit");
				$("#btn_submit").click(function(){
					/*注册编辑验证引擎*/
					zjm.validata({formId:"form_planLoanEdit"});
					tool.disabled("#btn_submit");
					var queryContainer_form = $("#form_planLoanEdit");
					if(queryContainer_form.validationEngine("validate")){
						if(zjm.ajaxValidata("editLoanSum","/project/loanPlan/isMoreThanAgreeSum",JSON.stringify(queryContainer_form.serializeJson()),"计划放款总金额不能超过同意放款金额！")){	//同级目录字典检查
							$.ajax({type:'POST',url:"/project/loanPlan/updateOnePlanLoan",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						        	if(data.obj){
										$("#planLoanEdit").modal("hide");
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
					}else{
						tool.undisabled("#btn_submit");
					}
				});
				$("#planLoanEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
					$("#btn_submit").unbind("click");
				});
			});
		});
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});
	
	/**
	 * 删除放款计划
	 */
	$(".btn_deleteLoanPlan").click(function(){
		var loanPlan_ID = $(this).attr("data-loanPlanID");
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除放款计划");
		$("#delMessage").html("删除放款计划后，相应的还款计划及应收费用也将一并删除！<br/>是否确定删除放款计划？");
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:"/project/loanPlan/deleteOnePlanLoan",data:JSON.stringify({"loanPlan_ID":loanPlan_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj){
						$("#common_del").modal("hide");
						window.location.reload();
					}else{
						alert("删除失败！");
						tool.undisabled(".btn_submit");
					}
		        }
			});
		});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});
	
	/**
	 * 添加还款计划
	 */
	$(".btn_addPlanPay").click(function(){
		var loanPlan_ID = $(this).attr("data-loanPlanID");
		var apply_ID = $("#hidden_applyID").val();
		$("#page_planLoanAndPay").load("/project/loanPlan/showPlanPayAddPage",{"loanPlan_ID":loanPlan_ID,"apply_ID":apply_ID},function(response,status,xhr){
			$("#planPayAdd").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_planPayAdd"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_planPayAdd");
				if(queryContainer_form.validationEngine("validate")){
					if(zjm.ajaxValidata("addPlanPayMonth","/project/loanPlan/isMoreThanPlanLoanPeriodMonth",JSON.stringify(queryContainer_form.serializeJson()),"还款月份不能超过计划放款的期限！")){
						if(zjm.ajaxValidata("addPlanPaySum","/project/loanPlan/isMoreThanPlanLoanSum",JSON.stringify(queryContainer_form.serializeJson()),"计划还款金额不能超过计划放款金额！")){	
							$.ajax({type:'POST',url:"/project/loanPlan/insertOnePlanPay",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						        	if(data.obj){
										$("#planLoanEdit").modal("hide");
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
					}else{
						tool.undisabled("#btn_submit");
					}
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#planPayAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	});
	
	/**
	 * 修改还款计划
	 */
	$(".btn_editPlanPay").click(function(){
		var planPay_ID = $(this).attr("data-planPayID");
		var apply_ID = $("#hidden_applyID").val();
		$("#page_planLoanAndPay").load("/project/loanPlan/showPlanPayEditPage",{"planPay_ID":planPay_ID,"apply_ID":apply_ID},function(response,status,xhr){
			$("#planPayEdit").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_planPayEdit"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_planPayEdit");
				if(queryContainer_form.validationEngine("validate")){
//					if(zjm.ajaxValidata("editPlanPayMonth","/project/loanPlan/isMoreThanPlanLoanPeriodMonth",JSON.stringify(queryContainer_form.serializeJson()),"还款月份不能超过计划放款的期限！")){
						if(zjm.ajaxValidata("editPlanPaySum","/project/loanPlan/isMoreThanPlanLoanSum",JSON.stringify(queryContainer_form.serializeJson()),"计划还款金额不能超过计划放款金额！")){	
							$.ajax({type:'POST',url:"/project/loanPlan/updateOnePlanPay",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						        	if(data.obj){
										$("#planLoanEdit").modal("hide");
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
//					}else{
//						tool.undisabled("#btn_submit");
//					}
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#planPayEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	});
	
	/**
	 * 删除还款计划
	 */
	$(".btn_delPlanPay").click(function(){
		var planPay_ID = $(this).attr("data-planPayID");
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除还款计划");
		$("#delMessage").html("删除还款计划后，相应的应收费用也将一并删除！<br/>是否确定删除还款计划？");
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:"/project/loanPlan/deleteOnePlanPay",data:JSON.stringify({"planPay_ID":planPay_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj){
						$("#common_del").modal("hide");
						window.location.reload();
					}else{
						alert("删除失败！");
						tool.undisabled(".btn_submit");
					}
		        }
			});
		});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	});
	
	/**
	 * 自动生成还款计划
	 */
	$(".btn_autoAddPlanPay").click(function(){
		//先判断是否已有还款计划, 如果有, 给出提示消息
		var loanPlan_ID = $(this).attr("data-loanPlanID");
		if($("#table_planPay_"+loanPlan_ID).length > 0){	//有对应的还款计划表格, 即还款计划不为空
			$("#page_planLoanAndPay").load("/project/loanPlan/showAutoAddConfirmPage",{},function(response,status,xhr){
				$("#autoAddConfrim").modal({keyboard:true});
				$("#btn_submit").click(function(){
					$("#autoAddConfrim").modal("hide");
					//加了延时函数,等待上一个模态框完全关闭后, 再弹出新的模态框, 否则上一个模态框的遮罩层有可能来不及隐藏,导致显示错误	
					setTimeout(function(){$.zjm_planLoanAndPay.autoAddPlanPay(loanPlan_ID); },100);	
				});
				$("#autoAddConfrim").on("hidden.bs.modal", function (e) {//解除事件绑定
					$("#btn_submit").unbind("click");
				});
			});
		}else{		//没有对应的还款计划表格
			$.zjm_planLoanAndPay.autoAddPlanPay(loanPlan_ID);
		}
	});
	
	/* ********************************************************************************* */
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
			tool.undisabled("#btn_submit_costMustAddForm");
			$("#btn_submit_costMustAddForm").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_costMustAdd"});
				tool.disabled("#btn_submit_costMustAddForm");
				var queryContainer_form = $("#form_costMustAdd");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/costMust/insertOneCostMust",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#costMustAdd").modal("hide");
								window.location.reload();
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit_costMustAddForm");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit_costMustAddForm");
				}
			});
			$("#costMustAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit_costMustAddForm").unbind("click");
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
			tool.undisabled("#btn_submit_costMustEditForm");
			$("#btn_submit_costMustEditForm").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_costMustEdit"});
				tool.disabled("#btn_submit_costMustEditForm");
				var queryContainer_form = $("#form_costMustEdit");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/costMust/updateOneCostMust",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#costMustEdit").modal("hide");
								window.location.reload();
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit_costMustEditForm");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit_costMustEditForm");
				}
			});
			$("#costMustEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit_costMustEditForm").unbind("click");
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
});


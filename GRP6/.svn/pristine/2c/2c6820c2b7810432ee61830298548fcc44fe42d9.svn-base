(function($,z){
	$.zjm_confirmFee = {
			addCostMust:addCostMust,//添加应收	
			addCostFact:addCostFact,//添加实收	
			addCostPre:addCostPre,//添加预收	
			addCostReturn:addCostReturn,//添加退费
			
			updateCostMust:updateCostMust,//修改应收	
			updateCostFact:updateCostFact,//修改实收	
			updateCostPre:updateCostPre,//修改预收	
			updateCostReturn:updateCostReturn,//修改退费
			
			delCostMust:delCostMust,//删除应收	
			delCostFact:delCostFact,//删除实收	
			delCostPre:delCostPre,//删除预收	
			delCostReturn:delCostReturn,//删除退费	
			mustTransPre:mustTransPre,//应收转预收	
			preTransFact:preTransFact,//预收转实收	
	};
	/****************************以下是添加*********************************/
	//添加应收
	function addCostMust(meetingDetail_ID){
		$("#confirmFee_page").load("/project/costMust/showAddCostMustPage",{"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#addCostMust").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addCostMust_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addCostMust_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/costMust/insertOneCostMust',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addCostMust").modal("hide");
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
			$("#addCostMust").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//添加实收
	function addCostFact(meetingDetail_ID){
		$("#confirmFee_page").load("/project/costFact/showAddCostFactPage",{"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#addCostFact").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addCostFact_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addCostFact_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/costFact/insertOneCostFact',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addCostFact").modal("hide");
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
			$("#addCostFact").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//添加预收
	function addCostPre(meetingDetail_ID){
		$("#confirmFee_page").load("/project/costPre/showAddCostPrePage",{"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#addCostPre").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addCostPre_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addCostPre_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/costPre/insertOneCostPre',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addCostPre").modal("hide");
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
			$("#addCostPre").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//添加退费
	function addCostReturn(meetingDetail_ID){
		$("#confirmFee_page").load("/project/costReturn/showAddCostReturnPage",{"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#addCostReturn").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addCostReturn_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addCostReturn_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/costReturn/insertOneCostReturn',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addCostReturn").modal("hide");
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
			$("#addCostReturn").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	/****************************以下是修改*********************************/
	//修改应收
	function updateCostMust(costMust_ID){
		$("#confirmFee_page").load("/project/costMust/showUpdateCostMustPage",{"costMust_ID":costMust_ID},function(response,status,xhr){
			$("#updateCostMust").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"updateCostMust_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateCostMust_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/costMust/updateOneCostMust',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
							if(data.obj){
								$("#updateCostMust").modal("hide");
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
			$("#updateCostMust").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	//修改实收
	function updateCostFact(costFact_ID){
		$("#confirmFee_page").load("/project/costFact/showUpdateCostFactPage",{"costFact_ID":costFact_ID},function(response,status,xhr){
			$("#updateCostFact").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"updateCostFact_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateCostFact_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/costFact/updateOneCostFacts',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
							if(data.obj){
								$("#updateCostFact").modal("hide");
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
			$("#updateCostFact").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	//修改预收
	function updateCostPre(costPre_ID){
		$("#confirmFee_page").load("/project/costPre/showUpdateCostPrePage",{"costPre_ID":costPre_ID},function(response,status,xhr){
			$("#updateCostPre").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"updateCostPre_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateCostPre_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/costPre/updateOneCostPre',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
							if(data.obj){
								$("#updateCostPre").modal("hide");
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
			$("#updateCostPre").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	//修改退费
	function updateCostReturn(costReturn_ID){
		$("#confirmFee_page").load("/project/costReturn/showUpdateCostReturnPage",{"costReturn_ID":costReturn_ID},function(response,status,xhr){
			$("#updateCostReturn").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"updateCostReturn_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateCostReturn_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/costReturn/updateOneCostReturn',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
							if(data.obj){
								$("#updateCostReturn").modal("hide");
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
			$("#updateCostReturn").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	/*********************以下是删除************************/
	//删除退费
	function delCostReturn(costReturn_ID){
		$("#confirmFee_page").load("/project/costReturn/showDelCostReturnPage",{},function(response,status,xhr){
			$("#delCostReturn").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/costReturn/delOneCostReturn',data:JSON.stringify({"costReturn_ID":costReturn_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delCostReturn").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delCostReturn").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//删除预收
	function delCostPre(costPre_ID){
		$("#confirmFee_page").load("/project/costPre/showDelCostPrePage",{},function(response,status,xhr){
			$("#delCostPre").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/costPre/deleteOneCostPre',data:JSON.stringify({"costPre_ID":costPre_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delCostPre").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delCostPre").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//删除应收
	function delCostMust(costMust_ID){
		$("#confirmFee_page").load("/project/costMust/showDelCostMustPage",{},function(response,status,xhr){
			$("#delCostMust").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/costMust/deleteOneCostMust',data:JSON.stringify({"costMust_ID":costMust_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delCostMust").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delCostMust").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//删除实收
	function delCostFact(costFact_ID){
		$("#confirmFee_page").load("/project/costFact/showDelCostFactPage",{},function(response,status,xhr){
			$("#delCostFact").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/costFact/deleteOneCostFact',data:JSON.stringify({"costFact_ID":costFact_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delCostFact").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delCostFact").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	//应收转预收	
	function mustTransPre(costMust_ID){
		$("#confirmFee_page").load("/project/costMust/showMustTransPre",{},function(response,status,xhr){
			$("#mustTransPre").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/costMust/costMustToPre',data:JSON.stringify({"costMust_ID":costMust_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#mustTransPre").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#mustTransPre").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//预收转实收
	function preTransFact(costPre_ID){
		$("#confirmFee_page").load("/project/costPre/showPreTransFact",{},function(response,status,xhr){
			$("#preTransFact").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/costPre/costPreToFact',data:JSON.stringify({"costPre_ID":costPre_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#preTransFact").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#preTransFact").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//判空
	function isOrNotNull(str){
		if(str==null ||typeof(str)==undefined || str==''){
			str=0;
		}
		return parseFloat(str).toFixed(4);
	}
	
})(jQuery, this);

$(function () {
	//添加应收
	/*$("#btn_addCostMust").click(function(){
		$.zjm_confirmFee.addCostMust();
	});
	//添加实收
	$("#btn_addCostFact").click(function(){
		$.zjm_confirmFee.addCostFact();
	});
	//添加预收
	$("#btn_addCostPre").click(function(){
		$.zjm_confirmFee.addCostPre();
	});
	//添加退费
	$("#btn_addCostReturn").click(function(){
		$.zjm_confirmFee.addCostReturn();
	});*/
});

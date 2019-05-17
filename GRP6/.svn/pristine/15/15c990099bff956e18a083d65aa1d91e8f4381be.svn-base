/**
 * 客户管理-企业客户--企业财务状况---主要资产情况分析---应收账款 js
 * @atuhor: wuhn
 * @date: 2017年6月12日 15:40:25
 * 
 */

(function($,z){
	$.zim_mainAssetList = {
			receivableDescEdit:receivableDescEdit,// 应收账款修改
			otherReceivableDescEdit:otherReceivableDescEdit,// 其它应收账款修改
			inventoryDescEdit:inventoryDescEdit,// 存货修改
			longtermInvestDescEdit:longtermInvestDescEdit,// 住宅修改
			fixedAssetsDescEdit:fixedAssetsDescEdit,// 机械修改
			loadData:loadData//修改后更新页面数据
		
			
	};
	
	//修改后更新页面数据
	function loadData(client_ID){
		$.ajax({type:'POST',url:'/crm/financeDesc/selectOneFinanceDesc',data:JSON.stringify({"client_ID":client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {
				if(data.obj != null){
					var receivableDesc = data.obj.receivableDesc;
					$("#pre_receivableDesc").text((receivableDesc=="" || receivableDesc == null)?"（空）":receivableDesc);
					var otherReceivableDesc = data.obj.otherReceivableDesc;
					$("#pre_otherReceivableDesc").text((otherReceivableDesc=="" || otherReceivableDesc == null)?"（空）":otherReceivableDesc);
					var inventoryDesc = data.obj.inventoryDesc;
					$("#pre_inventoryDesc").text((inventoryDesc=="" || inventoryDesc == null)?"（空）":inventoryDesc);
					var longtermInvestDesc = data.obj.longtermInvestDesc;
					$("#pre_longtermInvestDesc").text((longtermInvestDesc=="" || longtermInvestDesc == null)?"（空）":longtermInvestDesc);
					var fixedAssetsDesc = data.obj.fixedAssetsDesc;
					$("#pre_fixedAssetsDesc").text((fixedAssetsDesc=="" || fixedAssetsDesc == null)?"（空）":fixedAssetsDesc);
				}
			}
		});
	}
	
	//应收账款修改
	function  receivableDescEdit(){
		var l = $("#pre_receivableDesc").text();
		$("#text_receivableDesc").val(l=="（空）"?"":l);
		$("#receivableDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#receivableDescEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"receivableDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#receivableDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#receivableDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#receivableDescEdit").modal("hide");
						$.zim_mainAssetList.loadData($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#receivableDescEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	//应收账款修改
	function  otherReceivableDescEdit(){
		var l = $("#pre_otherReceivableDesc").text();
		$("#text_otherReceivableDesc").val(l=="（空）"?"":l);
		$("#otherReceivableDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#otherReceivableDescEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"otherReceivableDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#otherReceivableDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#otherReceivableDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#otherReceivableDescEdit").modal("hide");
						$.zim_mainAssetList.loadData($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#otherReceivableDescEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	};
	//应收账款修改
	function  inventoryDescEdit(){
		var l = $("#pre_inventoryDesc").text();
		$("#text_inventoryDesc").val(l=="（空）"?"":l);
		$("#inventoryDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#inventoryDescEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"inventoryDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#inventoryDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#inventoryDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#inventoryDescEdit").modal("hide");
						$.zim_mainAssetList.loadData($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#inventoryDescEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	};
	//住宅修改
	function  longtermInvestDescEdit(){
		var l = $("#pre_longtermInvestDesc").text();
		$("#text_longtermInvestDesc").val(l=="（空）"?"":l);
		$("#longtermInvestDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#longtermInvestDescEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"longtermInvestDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#longtermInvestDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#longtermInvestDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#longtermInvestDescEdit").modal("hide");
						$.zim_mainAssetList.loadData($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#longtermInvestDescEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	};
	//机械修改
	function  fixedAssetsDescEdit(){
		var l = $("#pre_fixedAssetsDesc").text();
		$("#text_fixedAssetsDesc").val(l=="（空）"?"":l);
		$("#fixedAssetsDescEdit_form input[name='client_ID']").val($("#client_ID").val());
		$("#fixedAssetsDescEdit").modal({keyboard:true});
		tool.undisabled(".btn_submit");	
		/**注册编辑验证引擎*/
		zjm.validata({formId:"fixedAssetsDescEdit_form"});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#fixedAssetsDescEdit_form").validationEngine("validate")){
				$.ajax({type:'POST',url:"/crm/financeDesc/updateOneFinanceDesc",data:JSON.stringify($("#fixedAssetsDescEdit_form").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){
					if(data.obj==true){
						$("#fixedAssetsDescEdit").modal("hide");
						$.zim_mainAssetList.loadData($("#client_ID").val());
					}else{
						//alert("baocunshibai");
						$("#savefailed").modal({keyboard:true});
					}
				}});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#fixedAssetsDescEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	};
	
})(jQuery, this);

$(function () {
	//获取客户id
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	var type = tool.getUrlParam('type');
	if(type == 'view'){
		$("#receivableDesc").hide();
		$("#otherReceivableDesc").hide();
		$("#inventoryDesc").hide();
		$("#longtermInvestDesc").hide();
		$("#fixedAssetsDesc").hide();
    }
	$.zim_mainAssetList.loadData(client_ID);
	
	//修改 应收账款
	$("#receivableDesc").click(function(){
		$.zim_mainAssetList.receivableDescEdit();
	});
	//修改 其它应收账款
	$("#otherReceivableDesc").click(function(){
		$.zim_mainAssetList.otherReceivableDescEdit();
	});
	//修改 存货
	$("#inventoryDesc").click(function(){
		$.zim_mainAssetList.inventoryDescEdit();
	});
	//修改住宅账款
	$("#longtermInvestDesc").click(function(){
		$.zim_mainAssetList.longtermInvestDescEdit();
	});
	//修改 机械
	$("#fixedAssetsDesc").click(function(){
		$.zim_mainAssetList.fixedAssetsDescEdit();
	});
	
	
});


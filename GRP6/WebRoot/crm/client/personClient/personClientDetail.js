(function($,z){
	$.zjm_personClientDetail = {
			initData:initData,//初始化数据
			editPersonClient:editPersonClient,//修改申请人基本信息
			companyDetail:companyDetail,//查看企业详情
			editSpouse:editSpouse,//修改配偶信息
			editSelfHouse:editSelfHouse,//修改住房信息
			editOtherAssets:editOtherAssets//修改自有资产
	};
	
	/**
	 * 初始化数据
	 * @param client_ID
	 * @returns
	 */
	function initData(client_ID){
		//加载一个 企业客户的基本信息 
		zjm.dataViewText("view_", "/selectOneCompanyClientInfo", {"client_ID" : client_ID},"");
		zjm.dataViewText("spouse_view_", "/selectOneSpouseInfo", {"client_ID" : client_ID},"");
		zjm.dataViewText("house_view_", "/selectOneSelfHouseInfo",{"client_ID" : client_ID},"");
	}
	
	
	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function companyDetail(){
		window.parent.openMenu($("#operate").val()+'_companyClient'+$("#client_ID").val(),'','企业客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+$("#client_ID").val()+'&type='+$("#operate").val(),1);
	}
	
	
	/**
	 * 修改申请人基本信息
	 * @returns
	 */
	function editPersonClient(){
		$("#editPersonClientModal").modal({keyboard:true});
		zjm.dataViewValSelect("select_house", "/selectDicTypeSelectJSON", {"dicTypePID" : '1fe88348f96c4cbfb33480860fa1b617'});//获取住房性质下拉框
		zjm.dataViewValSelect("select_education", "/selectDicTypeSelectJSON", {"dicTypePID" : 'a6ebbf73cbd44232a28c453a3d65ecd8'});//获取教育程度下拉框
		//加载一个 企业客户的基本信息 
		zjm.dataViewVal("edit_", "/selectOneCompanyClientInfo", {"client_ID" : $('#client_ID').val()},"");
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"edit_personClientForm"});
		//**提交 保存 修改关联信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#edit_personClientForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_personClientForm");
					if(zjm.ajaxValidata("edit_personNum","/selectEditPersonNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"申请人身份证号已存在！")){
						$.ajax({
							type : 'POST',
							url : '/updateOneCompanyClientInfo',
							data : JSON.stringify(queryContainer_form.serializeJson()),
							contentType : 'application/json; charset=UTF-8',
							dataType : 'json',
							success : function(data) {
								if (data.obj == 1) {
									$("#editPersonClientModal").modal("hide");
									$(".ztb_edit").val("");
									zjm.dataViewText("view_", "/selectOneCompanyClientInfo", {"client_ID" : $('#client_ID').val()},"");
								} else {
									alert("保存失败！");
								}
							}
						});
					}else{
						tool.undisabled(".btn_submit");
					}	
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editPersonClientModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**
	 * 修改配偶信息
	 * @returns
	 */
	function editSpouse(){
		$("#editSpouseModal").modal({keyboard:true});
		$('.client_ID').val($('#client_ID').val());
		//加载一个 配偶的基本信息 
		zjm.dataViewVal("edit_spouse_", "/selectOneSpouseInfo", {"client_ID" : $('#client_ID').val()},"");
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"edit_spouseForm"});
		//**提交 保存 修改关联信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#edit_spouseForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_spouseForm");
					$.ajax({
					type : 'POST',
					url : '/updateOneSpouseInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#editSpouseModal").modal("hide");
							$(".ztb_edit_spouse_").val("");
							zjm.dataViewText("spouse_view_", "/selectOneSpouseInfo", {"client_ID" : $('#client_ID').val()},"");
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editSpouseModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**
	 * 修改自有住房信息
	 * @returns
	 */
	function editSelfHouse(){
		$("#editSelfHouseModal").modal({keyboard:true});
		$('.client_ID').val($('#client_ID').val());
		zjm.dataViewValSelect("select_ownership", "/selectDicTypeSelectJSON", {"dicTypePID" : 'bc584b233eae4aeeaf3785fe9a7dfe03'});//获取权属类型下拉框
		//加载一个 企业客户的基本信息 
		zjm.dataViewVal("edit_house_", "/selectOneSelfHouseInfo", {"client_ID" : $('#client_ID').val()},"");
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"edit_selfHouseForm"});
		//**提交 保存 修改关联信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#edit_selfHouseForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_selfHouseForm");
					$.ajax({
					type : 'POST',
					url : '/updateOneSelfHouseInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#editSelfHouseModal").modal("hide");
							$(".ztb_edit_house_").val("");
							zjm.dataViewText("house_view_", "/selectOneSelfHouseInfo", {"client_ID" : $('#client_ID').val()},"");
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editSelfHouseModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**
	 * 修改其他家庭财产
	 * @returns
	 */
	function editOtherAssets(){
		$("#editOtherAssetsModal").modal({keyboard:true});
		//加载一个 企业客户的基本信息 
		zjm.dataViewVal("edit_", "/selectOneCompanyClientInfo", {"client_ID" : $('#client_ID').val()},"");
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"edit_otherAssetsForm"});
		//**提交 保存 修改关联信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#edit_otherAssetsForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_otherAssetsForm");
					$.ajax({
					type : 'POST',
					url : '/updateOneCompanyClientInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#editOtherAssetsModal").modal("hide");
							$(".ztb_edit").val("");
							zjm.dataViewText("view_", "/selectOneCompanyClientInfo", {"client_ID" : $('#client_ID').val()},"");
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editOtherAssetsModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
})(jQuery, this);

$(function () {
	var client_ID = tool.getUrlParam('client_ID');
	$('#client_ID').val(client_ID);
	var clientTypeID = tool.getUrlParam('clientTypeID');
	if(clientTypeID == '03'){
		$("#companyData").hide();
	}
	var type = tool.getUrlParam('type');
	if(type == 'view'){
		$("#btn_editPersonClient").hide();
		$("#btn_editSpouse").hide();
		$("#btn_editSelfHouse").hide();
		$("#btn_editOtherAssets").hide();
		$("#operate").val("view");
	}
	//window.parent.document.getElementById('view_personClient'+client_ID).contentWindow.editSelfHouse();
	$.zjm_personClientDetail.initData(client_ID)
	/**
	 * 修改申请人基本信息
	 */
	$("#btn_editPersonClient").click(function(){
		$.zjm_personClientDetail.editPersonClient();
	});
	/**
	 * 查看企业详情
	 */
	$("#btn_companyDetail").click(function(){
		$.zjm_personClientDetail.companyDetail();
	});
	/**
	 * 修改配偶信息
	 */
	$("#btn_editSpouse").click(function(){
		$.zjm_personClientDetail.editSpouse();
	});
	/**
	 * 修改自有住房信息
	 */
	$("#btn_editSelfHouse").click(function(){
		$.zjm_personClientDetail.editSelfHouse();
	});
	/**
	 * 修改其它家庭财产信息
	 */
	$("#btn_editOtherAssets").click(function(){
		$.zjm_personClientDetail.editOtherAssets();
	});
});

 
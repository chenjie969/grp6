(function($,z){
	window.companyClientDetails={
			initDatas:initDatas, //初始化数据	
	}
	function initDatas(client_ID){
		initData(client_ID);
	}
	$.zjm_companyClientDetail = {
			initData:initData,//初始化数据
			loadManagerMainInfo:loadManagerMainInfo,// 加载股东主要管理人员信息
			managerInfoEdit:managerInfoEdit ,// 修改 股权结构历史沿革
			managerMainInfoEdit:managerMainInfoEdit, //修改 股东背景及主要管理人员分析
	};
	
	/**
	 * 初始化数据
	 * @param client_ID
	 * @returns
	 */
	function initData(client_ID){
		$("#oldClientName").show();
		//加载一个 企业客户的基本信息 
		$.ajax({
			type:'post',
			url:'/selectOneCompanyClientInfo',
			data: JSON.stringify({"client_ID":client_ID}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_view_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('isHighTechnology') > 0){
							if(value == 1){ // =1 禁用，0启用
								$(".ztb_view_"+key).text("是");
							}else{
								$(".ztb_view_"+key).text("否");
							}
						}else if(rt.indexOf("createDate")>0 || rt.indexOf("highTechnologyDate")>0 ||rt.indexOf("createDateTime")>0 ){
								$(".ztb_view_"+key).text(tool.parseDate(value));
						}else{
							$(".ztb_view_"+key).text(tool.isNull(value,"（空）"));
						}
					}
				})
				if($(".ztb_view_oldClientName").text() === null || $(".ztb_view_oldClientName").text() === '（空）（空）（空）（空）（空）（空）（空）（空）'){
					$("#oldClientName").hide();
				}
			}
		})// 获取修改对象 信息  end 
		
		
		//加载开户信息
		zjm_clientBasicInfo.initOpenMessageTable(client_ID);
		
	}
	
	
	
	// 修改 -- 股权结构历史沿革  ---> 股东背景及主要管理人员情况
	function managerInfoEdit(client_ID){
		$("#managerInfoEdit").modal({keyboard:true});
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		$.ajax({
			type:'post',
			url:'/selectOneManagerInfo',
			data: JSON.stringify({"client_ID":client_ID}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					$(".ztb_edit_"+key).val(value);
				})
			}
		})// 获取修改对象 信息  end 
		
		//**提交***//*
		tool.undisabled(".btn_submit"); // 按钮调整为可用
		$(".btn_submit").click(function(){
			if($("#edit_form").validationEngine("validate")){
				var queryContainer_form = $("#edit_form");
				tool.disabled(".btn_submit"); //按钮调整为不可用
				$.ajax({
					type : 'POST',
					url : '/updateOneManagerInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#managerInfoEdit").modal("hide");
							$(".ztb_edit").val("");
							$.zjm_companyClientDetail.loadManagerMainInfo(client_ID);
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#managerInfoEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}// end managerInfoEdit .
	
	// 修改 -- 股东背景及主要管理人员分析  ---> 股东背景及主要管理人员情况
	function managerMainInfoEdit(client_ID,clas){
		$(".edit_stockinfo").hide();//隐藏所有div
		$(".edit_stockinfo").each(function(){
			var divname=$(this).attr("name"); //获取div name属性
			if(typeof divname != 'undefined'){
				if(clas.indexOf(divname)>-1){
					$("."+divname).show();
				}
			}
		})
		$("#managerMainInfoEdit").modal({keyboard:true});//打开模态窗
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_managerMainInfoEdit"
		});
		// 获取修改对象 信息
		$.ajax({
			type:'post',
			url:'/selectOneManagerInfo',
			data: JSON.stringify({"client_ID":client_ID}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
						$(".ztb_edit_"+key).val(value);
				})
			}
		})// 获取修改对象 信息  end 
		
		//**提交***//*
		tool.undisabled(".btn_submit"); // 按钮调整为可用
		$(".btn_submit").click(function(){
			if($("#edit_managerMainInfoEdit").validationEngine("validate")){
				var queryContainer_form = $("#edit_managerMainInfoEdit");
					tool.disabled(".btn_submit"); //按钮调整为不可用
					$.ajax({
						type : 'POST',
						url : '/updateOneManagerInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj == 1) {
								$("#managerMainInfoEdit").modal("hide");
								$(".ztb_edit").val("");
								$.zjm_companyClientDetail.loadManagerMainInfo(client_ID);
							} else {
								alert("保存失败！");
							}
						}
					});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#managerMainInfoEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}
	
	// 初始加载股东信息列表和 主要管理人员信息
	function loadManagerMainInfo(client_ID){
		//加载 管理人员信息表
		$.ajax({
			type : 'POST',
			url : "/selectOneManagerInfo",
			data : JSON.stringify({"client_ID":client_ID}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$.each(data.obj, function(key, value) {
					if(value == null || value ==''){
						$(".ztb_view_"+ key).text("（空）");
					}else{
						$(".ztb_view_"+ key).text(value);
					}	

				});
			}
		});
		
		// 加载股东信息列表
		stockMessage.refreshStockMessageTable(client_ID);
	}
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 列表信息
	 */
	 /*注册日期控件点击事件*/
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	$.zjm_companyClientDetail.initData(client_ID)

	
	var type = tool.getUrlParam('type');
	if(type == 'view'){
		$("#btn_updateBasicInfo").hide();
		$("#updateClientSource").hide();
		$("#history").hide();
		$("#mainManager").hide();
		$("#stockAdd").hide();		
		$("#addCompanyBankAccount").hide();
		$('#openMessage-table').bootstrapTable('hideColumn','bankaccountId');
		$("#btn_developEvolutionEdit").hide();
		$("#btn_addRelationClient").hide();
		$("#mainManager").hide();
		$("#history").hide();
		$("#btn_uploadfiles").hide();
		$(".creditInfo_edit").hide();
		$(".edit_manager").hide();
		$('#stockMessage-table').bootstrapTable('hideColumn','stockId');

	}
	//加载 股东主要管理人员信息
	$("#mangerInfo").click(function(){
		$.zjm_companyClientDetail.loadManagerMainInfo(client_ID);
	})
	// 修改 -- 股权结构历史沿革  ---> 股东背景及主要管理人员情况
	$("#history").click(function(){
		$.zjm_companyClientDetail.managerInfoEdit(client_ID);
	})
	
	// 修改 -- 股东背景及主要管理人员分析  ---> 股东背景及主要管理人员情况
	$(".edit_manager").click(function(){
		var clas = $(this).attr("class");//获取点击修改按钮的 class属性
		$.zjm_companyClientDetail.managerMainInfoEdit(client_ID,clas);
	})
	
	
	
});


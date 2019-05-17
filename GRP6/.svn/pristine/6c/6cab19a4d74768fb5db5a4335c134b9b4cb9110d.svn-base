/**
 * 基本信息 开户信息  客户来源 js
 * author:wuhn 
 * 2017年5月4日 13:56:46
 */

/**
 * 定义函数
 */
(function($,z){
	window.zjm_clientBasicInfo = {
		initCompanyClientInfos:initCompanyClientInfos,//加载一个企业客户基本信息	
		initOpenMessageTable:initOpenMessageTable,//加载 一个企业客户开户信息列表
	};
	$.zjm_clientBasicInfo = {
	     	initOpenMessageTable:initOpenMessageTable,//加载 一个企业客户开户信息列表
			updateCompanyClientBasicInfo:updateCompanyClientBasicInfo,//修改企业客户基本信息
			addBankAccountClientInfo:addBankAccountClientInfo,//添加企业开户信息
			deleteBankAccountClientInfo:deleteBankAccountClientInfo,//删除开户信息
			updateBankAccountClientInfo:updateBankAccountClientInfo, // 修改客户开户信息
			viewBankAccountClientInfo :viewBankAccountClientInfo,//查看企业客户信息;
			updateClientSourceInfo:updateClientSourceInfo,//修改开户来源信息
			refreshCompanyClientInfo:refreshCompanyClientInfo ,//企业客户详情页面
			initColumn:initColumn,
		};

	
	
	/**初始化列表项**/
	function initColumn(){
		var columns = [{field : "accounttype",title : '账户类别',align : 'center',sortable : "true",formatter : function(value, rows, index) {return rows.accounttype;}},
					   {field : "bankname",title : '开户行',align : 'center',sortable : "true",formatter : function(value, rows, index) {return rows.bankname;}},
					   {field : "accountnumber",title : '账号',align : 'center',sortable : "true",formatter : function(value, rows, index) {return rows.accountnumber;}},
					   {field : "accountsum",title : '账户余额（万元）',align : 'center',sortable : "true",formatter : function(value, rows, index) {return rows.accountsum;}},					   
					   ];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({title : '操作',align : 'center',formatter : function(value, rows, index) {
						return [
								'<button class="btn_client_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_client_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_client_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events : {
								'click .btn_client_view' : function(e, value, rows, index) {
									$.zjm_clientBasicInfo.viewBankAccountClientInfo(rows);
								},
								'click .btn_client_edit' : function(e, value, rows, index) {
									$.zjm_clientBasicInfo.updateBankAccountClientInfo(rows);
								},
								'click .btn_client_del' : function(e, value, rows, index) {
									$.zjm_clientBasicInfo.deleteBankAccountClientInfo(rows);
								}											
							}
						});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title : '操作',align : 'center',formatter : function(value, rows, index) {
				return ['<button class="btn_client_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_client_view': function(e, value, rows, index) {
									$.zjm_clientBasicInfo.viewBankAccountClientInfo(rows);
								}
							}
						});
		}
		return columns;
	};
	
	
	
	
	
	/**初始 化开户信息 列表***/
	function initOpenMessageTable(client_ID){
		//alert("初始 化开户信息 列表============"+row.client_ID);
		$("#openMessage-table").bootstrapTable('destroy');
		$('#openMessage-table').bootstrapTable({
			method: 'get',
			columns : initColumn(),
			detailView: true,
			detailFormatter:function(index, rows){
			    var html = [];
			        html.push('<p><b>账户类别:</b> ' + rows.accounttype + '</p>');
			        html.push('<p><b>开户行:</b> ' + rows.bankname + '</p>');
			        html.push('<p><b>账号:</b> ' + rows.accountnumber + '</p>');
			        html.push('<p><b>账户余额（万元）:</b> ' + rows.accountsum + '</p>');
			    return html;
			},
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		//	pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/selectCompanysCrm_bankAccountPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"client_ID":$(".client_ID").val()}});
				return params;
			},// queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			         
			});
		
		
		
	}// end initOpenMessageTable
	
	//加载企业客户信息 -- window对象定义，全局任意位置可用
	function initCompanyClientInfos(row){
	}
	
	/* 修改企业客户基本信息 更新企业客户基本信息*/
	function updateCompanyClientBasicInfo(){
		$("#updateBasicInfo").modal({keyboard:true});
		var client_ID=$("#client_ID").val();
		var clientTypeID=$("#clientTypeID").val();		
		zjm.init();
		
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_clientBasicInfo"
		});
		zjm.dataViewValSelect("select_Area", "/selectDicTypeListJSON", {"dicTypePID" : '10b0680b76b4412aab109d673f4724c8'});/*获取所属区域下拉框*/
		zjm.dataViewValSelect("select_EnterpriseType", "/selectDicTypeListJSON", {"dicTypePID" : '6e54bbcb394b4b6cb4d149b45c46188b'});/*获取企业类型下拉框*/
		zjm.dataViewValSelect("select_natureID", "/selectDicTypeListJSON", {"dicTypePID" : '857906f8b1d34b18b29fae5e3b998a25'});/*获取企业性质下拉框*/
		zjm.dataViewValSelect("select_currencyID", "/selectDicTypeListJSON", {"dicTypePID" : '22ce39c3443f4ca5be21a8351ce991e2'});/*获取币别下拉框*/
		zjm.dataViewValSelect("select_divisionType", "/selectDicTypeListJSON", {"dicTypePID" : 'cb2b7adef9c740daa4c43fda3d4d4d11'});/*获取分类处置划分下拉框*/
		zjm.dataViewValSelect("select_riskLevelName", "/selectDicTypeListJSON", {"dicTypePID" : '50f858be37284937af4e6a8d3c9bee4b'});/*获取分类处置划分下拉框*/
		
		
		// 显示  客户基本信息 更新企业客户基本信息
	//	zjm.dataViewVal("edit_", "/selectOneCompanyClientInfo", {"client_ID" : client_ID},"createDate,highTechnologyDate,createDateTime");
		// 获取修改对象 信息 ---客户基本信息 更新企业客户基本信息
		$.ajax({
			type:'post',
			url:'/selectOneCompanyClientInfo',
			data: JSON.stringify({"client_ID":client_ID}),
			async:false,
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_edit_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('isHighTechnology') > 0){
							if(value == 1){ // =1 禁用，0启用
								$("#isHighTechnology1").prop("checked","checked");
								$("#isHighTechnology0").prop("checked","");
							}else{
								$("#isHighTechnology0").prop("checked","checked");
								$("#isHighTechnology1").prop("checked","");
							}
						}else if(rt.indexOf("createDate")>0 || rt.indexOf("highTechnologyDate")>0){
								$(".ztb_edit_"+key).val(tool.parseDate(value));
						}else{
							$(".ztb_edit_"+key).val(value);
						}
					}
				})
			}
		})// 获取修改对象 信息  end 
		
		// 用于 行业类别---属性菜单 赋值
		$("#fullTradeCode").attr("value",$(".ztb_edit_fullTradeName").val());
		$("#fullTradeCode").attr("dataValue",$(".ztb_edit_fullTradeCode").val());
		//获取行业类别下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectMultiLevelSortDicTree',data:JSON.stringify({'id':'c9ee6e6d3b5a41faafb263b1baff7b2e'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {       
			$("#fullTradeCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
		
		// 用于 所属区域 类别---属性菜单 赋值
		$("#fullAreaCode").attr("value",$(".ztb_edit_fullAreaName").val());
		$("#fullAreaCode").attr("dataValue",$(".ztb_edit_fullAreaCode").val());
		//获取所属区域 下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectMultiLevelSortDicTree',data:JSON.stringify({'id':'66547f3187194ed884e81dcd83027c36'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {       
			$("#fullAreaCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
		}
		});
		
		
		
		
		
		/** 保存修改** */
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			if ($("#edit_clientBasicInfo").validationEngine("validate")) {
				var queryContainer_form = $("#edit_clientBasicInfo");	
			//alert(JSON.stringify(queryContainer_form.serializeJson()));
			$.ajax({type:'POST',url:'/updateOneCompanyClientInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if (data.obj == 1) {
							$("#updateBasicInfo").modal("hide");//隐藏模态窗
							$.zjm_clientBasicInfo.refreshCompanyClientInfo(client_ID,clientTypeID); //刷新页面
						} else {
							alert("保存失败！");
						}
					}
				});
			} else {
				tool.undisabled(".btn_submit");
			}
		});
		$("#editBusiSort").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_reset").unbind("click");
			$(".btn_submit").unbind("click");
		});
	}
	

	
	
	
	/* 添加 开户信息 */
	function  addBankAccountClientInfo(){
		$("#addCompanyBankAccountInfo").modal({keyboard:true});
		var client_ID=$(".client_ID").val();
		var clientTypeID=$(".clientTypeID").val();
		$("#bankAccount_client_ID").val(client_ID);
		$("#bankAccount_clientTypeID").val(clientTypeID);
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_BankAccountInfo"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled("#saveBankAccountInfo");
		$("#saveBankAccountInfo").click(function(){
			tool.disabled("#saveBankAccountInfo");
			if($("#add_BankAccountInfo").validationEngine("validate")){
			//	if(zjm.ajaxValidata("add_mod_name","/selectAddCompanyClientsNameIsExist",{"mod_name":$("#add_mod_name").val()},"菜单名称重复！")){
					var queryContainer_form = $("#add_BankAccountInfo");
				//	alert(JSON.stringify(queryContainer_form.serializeJson()));
					$.ajax({
					type : 'POST',
					url : '/insertOneCompanyCrm_bankAccountInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#addCompanyBankAccountInfo").modal("hide");
							$(".ztb_add").val("");
							$.zjm_clientBasicInfo.refreshCompanyClientInfo(client_ID,clientTypeID); //刷新页面
						} else {
							alert("保存失败！");
						}
					}
				});
				//}
			}else{
				tool.undisabled("#saveBankAccountInfo");
			}
		});
		$("#addCompanyBankAccountInfo").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
			 $("#saveBankAccountInfo").unbind("click");
		});
	}
	
	/*修改开户 信息*/
	function updateBankAccountClientInfo(rows){
		$("#editCompanyBankAccountInfo").modal({keyboard:true});
		var client_ID=$(".client_ID").val();
		var clientTypeID=$(".clientTypeID").val();
		$("#bankAccount_bankaccountId").val(rows.bankaccountId);
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_CompanyBankAccountInfo"
		});
		// 显示  客户基本信息 更新企业客户基本信息
		zjm.dataViewVal("edit_", "/selectOneBankAccountInfo", {
			"bankaccountId" : rows.bankaccountId,
		},"");
		/** 保存修改** */
		tool.undisabled("#saveEditCompanyBankAccount");
		$("#saveEditCompanyBankAccount").click(function() {
			tool.disabled("#saveEditCompanyBankAccount");
			if ($("#edit_CompanyBankAccountInfo").validationEngine("validate")) {
				var queryContainer_form = $("#edit_CompanyBankAccountInfo");
			//	alert(JSON.stringify(queryContainer_form.serializeJson()));
				$.ajax({
					type : 'POST',
					url : '/updateOneCompanyCrm_bankAccountInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#editCompanyBankAccountInfo").modal("hide");//隐藏模态窗
							$(".ztb_edit").val("");
							$.zjm_clientBasicInfo.refreshCompanyClientInfo(client_ID,clientTypeID); //刷新页面
						} else {
							alert("保存失败！");
						}
					}
				});
			} else {
				tool.undisabled("#saveEditCompanyBankAccount");
			}
		});
		$("#editCompanyBankAccountInfo").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn_reset").unbind("click");
			$("#saveEditCompanyBankAccount").unbind("click");
		});
		
	}
	/**查看企业客户开户信息**/
	function viewBankAccountClientInfo(row){
		$("#viewBankAccountClientInfo").modal({keyboard:true});
		//zjm.dataViewText("view_","/selectOneBankAccountInfo",{"bankaccountId":row.bankaccountId},'');
		$.ajax({
			type:'post',
			url:'/selectOneBankAccountInfo',
			data: JSON.stringify({"bankaccountId":row.bankaccountId}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){/*:此处中备注与企业详情中备注字段名一样,所以需要特殊处理*/
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_views_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('remark') > 0){
							$(".ztb_views_"+key).text(value);
						}else{
							$(".ztb_views_"+key).text(tool.isNull(value,"（空）"));
						}
					}
				})
			}
		})
	}
	
	/*删除开户 信息*/
	function deleteBankAccountClientInfo(rows){
	//	alert("rows：："+rows.bankaccountId);
		var client_ID=$(".client_ID").val();
		var clientTypeID=$(".clientTypeID").val();
		$("#delCompanyBankAccountInfo").modal({keyboard:true});
		tool.undisabled("#saveDelBankAccountInfo");//恢复按钮可用
		$("#saveDelBankAccountInfo").click(function(){
			tool.disabled("#saveDelBankAccountInfo");
			$.ajax({
				type : 'POST',
				url : '/deleteOneCompanyCrm_bankAccountInfo',
				data : JSON.stringify({
					"bankaccountId" : rows.bankaccountId
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$('#openMessage-table').bootstrapTable('remove', {
							field : 'bankaccountId',
							values : [ rows.bankaccountId ]
						});
						$("#delCompanyBankAccountInfo").modal("hide");
					} else {
						alert("删除失败！");
					}
				}
			});
		});
		$("#delCompanyBankAccountInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $("#saveDelBankAccountInfo").unbind("click");
		});
	};
	
	/*修改客户来源信息*/
	function updateClientSourceInfo(){
		$("#editCompanyClientSource").modal({keyboard:true});
		var client_ID=$(".client_ID").val();
		var clientTypeID=$(".clientTypeID").val();
	//	alert(client_ID+"======client_ID"+"clientTypeID=="+clientTypeID);
		zjm.init();
		
		zjm.dataViewValSelect("select_clientSource", "/selectDicTypeListJSON", {"dicTypePID" : '3fafef23e87a4b9c99807207f618883d'});/*获取客户来源下拉框*/
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"editClientSource_from"
		});
		// 显示修改 客户来源信息
		zjm.dataViewVal("edit_", "/selectOneCompanyClientInfo", {"client_ID" : client_ID,"clientTypeID":clientTypeID},'createDateTime');
		
		
		
		
		// 用于 创建人---属性菜单 赋值
		$("#createUserName").attr("value",$(".ztb_edit_createUserName").val());
		$("#createUserName").attr("dataValue",$(".ztb_edit_createUserID").val());
		//获取创建人下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#createUserName").selectTreeWidgets({
					width : "93%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
	        });
		
		 //用于 创建部门---属性菜单 赋值
		$("#fullDepartCode").attr("value",$(".ztb_edit_fullDepartName").val());
		$("#fullDepartCode").attr("dataValue",$(".ztb_edit_fullDepartCode").val());	
		//获取部门下拉树;
		$.ajax({type:'POST',url:'/selectAllDepartsListTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#fullDepartCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
		
		
		
		
		
		
		
		
		
		
		
		/** 保存修改** */
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			if ($("#editClientSource_from").validationEngine("validate")) {
				var queryContainer_form = $("#editClientSource_from");
				$.ajax({
					type : 'POST',
					url : '/updateOneCompanyClientInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#editCompanyClientSource").modal("hide");
							$.zjm_clientBasicInfo.refreshCompanyClientInfo(client_ID,clientTypeID);
						} else {
							alert("保存失败！");
						}
					}
				});
			} else {
				tool.undisabled(".btn_submit");
			}
		});
		$("#editBusiSort").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_reset").unbind("click");
			$(".btn_submit").unbind("click");
		});
	} // end 修改客户来源信息
	
	//刷新客户详情页面
	function refreshCompanyClientInfo(client_ID,clientTypeID){
		//刷新客户基本信息 和 客户来源
		companyClientDetails.initDatas(client_ID);
		//刷新开户基本信息
		initOpenMessageTable();
	}
	
})(jQuery, this); // 定义函数 end



$(function () {
	
	
	
	
	/**
	 * 企业客户详情--开户信息列表
	 * 初始化 开户信息列表  
	 */
	$.zjm_clientBasicInfo.initOpenMessageTable();
	var type = tool.getUrlParam('type');
	if(type == 'view'){
		$('#openMessage-table').bootstrapTable('hideColumn','bankaccountId');
	}
	/**
	 * 添加企业开户信息 新增开户信息
	 */
	$("#addCompanyBankAccount").click(function(){
		$.zjm_clientBasicInfo.addBankAccountClientInfo();
	})
	
	/*修改客户来源信息 */
	$("#updateClientSource").click(function(){
		$.zjm_clientBasicInfo.updateClientSourceInfo();
	})
	
	/**
	 * 修改 企业客户 基本信息 更新企业客户信息
	 */
	$("#btn_updateBasicInfo").click(function(){
		$.zjm_clientBasicInfo.updateCompanyClientBasicInfo()
	});
	
	
}); // end function 


(function($,z){
	$.zjm_relationClient = {
			initRelationClientTable:initRelationClientTable,//初始化关联企业列表
			initClientTable:initClientTable,//初始化企业列表
			delRelationClient:delRelationClient,//删除关联企业
			addRelationClient:addRelationClient,//添加一个关联企业
			editRelationClient:editRelationClient,//修改一个关联企业
			viewCompanyClient:viewCompanyClient//客户详情查看
	};
	

	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function viewCompanyClient(row){
		window.parent.openMenu('view_companyClient'+row.relationClientID,'','企业客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.relationClientID+'&type='+'view');
	}
	
	/**初始化关联企业列表***/
	function initRelationClientTable(){
		$("#relationClient-table").bootstrapTable('destroy');
		$('#relationClient-table').bootstrapTable({
			method: 'get', 
			columns: [
				{field:'index',title:'序号',align: 'center',sortable:"true",formatter: function (value, row, index) {return index+1;}},
				{field:"clientName",title: '企业名称',align: 'center',sortable:"true",formatter: function (value, row, index) { 
					return ['<a class="btn_client_view" href="javascript:void(0)">'+row.clientName+'</a>'].join('');
					},
					//企业名称绑定事件
					events : {
						'click .btn_client_view' : function(
								e, value, row, index) {
							$.zjm_relationClient.viewCompanyClient(row);
									
						},
					}
				},
				{field:"relationDesc",title: '关联关系',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.relationDesc;}},
				{field:"relationClientId",title:'操作',align: 'center',formatter:function(value,row,index){
					return [
						'<button class="btn_relationClient_edit btn btn-xs btn-info" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
						'<button class="btn_relationClient_del btn btn-xs btn-danger" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
				},
					events:{
						'click .btn_relationClient_edit': function(e, value, row, index) {
							$.zjm_relationClient.editRelationClient(row);
						},
						'click .btn_relationClient_del': function(e, value, row, index) {
							$.zjm_relationClient.delRelationClient(row);
						}
					}
				}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>企业名称:</b> ' + row.clientName + '</p>');
			        html.push('<p><b>关联关系:</b> ' + row.relationDesc + '</p>');
			    return html;
			},
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: false,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			//url: "/selectModulesPageTables?queryCondition.mod_uid="+nodeid,//这个接口需要处理bootstrap table传递的固定参数
			url: "/selectRelationClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"client_ID":$(".client_ID").val()});
				return params;
			},
			//queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			//search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			//rictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			//showColumns: true,     //是否显示所有的列
			//showRefresh: true,     //是否显示刷新按钮
			//minimumCountColumns: 2,    //最少允许的列数
			//clickToSelect: false,    //是否启用点击选中行
			//searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			//showToggle: true,//是否显示详细视图和列表视图的切换按钮
			//showPaginationSwitch:true,
            //showExport: true,                     //是否显示导出
            //exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	};
	
	
	/**初始化企业列表***/
	function initClientTable(){
		$("#client-table").bootstrapTable('destroy');
		$('#client-table').bootstrapTable({
			method: 'get', 
			columns : [
				{
					field : 'checked',
					checkbox : true,
					align : 'center',
					formatter : function(value, row, index) {
						return ;
					}
				},
				{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
				{
					field : "clientName",
					title : '企业名称',
					align : 'center',
					sortable : "true",
					formatter : function(value, row, index) {
						return row.clientName;
					},
				},
				{
					field : "fullAreaName",
					title : '所属区域',
					align : 'center',
					sortable : "true",
					formatter : function(value, row, index) {
						return row.fullAreaName;
					}
				},
				{
					field : "fullTradeName",
					title : '所属行业',
					align : 'center',
					sortable : "true",
					formatter : function(value, row, index) {
						return row.fullTradeName;
					}
				},
				{
					field : "natureName",
					title : '企业性质',
					align : 'center',
					sortable : "true",
					formatter : function(value, row, index) {
						return row.natureName;
					}
				},
				{
					field : "legalPerson",
					title : '法定代表人',
					align : 'center',
					sortable : "true",
					formatter : function(value, row, index) {
						return row.legalPerson;
					}
				},
			], //end columns
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>企业名称:</b> ' + row.clientName + '</p>');
			        html.push('<p><b>所属行业:</b> ' + tool.isNull(row.fullTradeName,"") + '</p>');
			        html.push('<p><b>所属区域:</b> ' +  tool.isNull(row.fullAreaName,"") + '</p>');
			        html.push('<p><b>成立日期:</b> ' + tool.parseDate(row.createDate) + '</p>');
			        html.push('<p><b>注册资金（万元）:</b> ' + tool.isNull(row.registerSum,"") + '</p>');
			        html.push('<p><b>法定代表人:</b> ' + tool.isNull(row.legalPerson,"") + '</p>');
			        html.push('<p><b>联系人:</b> ' + tool.isNull(row.contactOne,"")+ '</p>');
			        html.push('<p><b>联系方式:</b> ' + tool.isNull(row.phoneOne,"") + '</p>');
			        html.push('<p><b>创建部门:</b> ' + tool.isNull(row.fullDepartName,"") + '</p>');
			        html.push('<p><b>所属行业:</b> ' + tool.isNull(row.fullTradeName,"") + '</p>');
			        html.push('<p><b>所属区域:</b> ' + tool.isNull(row.fullAreaName,"") + '</p>');
			        html.push('<p><b>成立日期:</b> ' + tool.parseDate(row.createDate) + '</p>');
			        html.push('<p><b>注册资金（万元）:</b> ' +tool.isNull(row.registerSum,"")+ '</p>');
			        html.push('<p><b>法定代表人:</b> ' + tool.isNull(row.legalPerson,"")+ '</p>');
			        html.push('<p><b>联系人:</b> ' + tool.isNull(row.contactOne,"")+ '</p>');
			        html.push('<p><b>联系方式:</b> ' +tool.isNull(row.phoneOne,"") + '</p>');
			        html.push('<p><b>创建部门:</b> ' + tool.isNull(row.fullDepartName,"") + '</p>');
			        html.push('<p><b>创建人:</b> ' + tool.isNull(row.createUserName,"") + '</p>');
			        html.push('<p><b>创建日期:</b> ' + tool.parseDate( row.createDateTime) + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/selectCompanyClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientTypeID":"01"}});
				return params;
			},
			//queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			singleSelect : true,// 单选checkbox
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
	        showExport: false,                     //是否显示导出
	        exportDataType: "basic"              //basic', 'all', 'selected'
			});
	};
	
	/**删除关联企业 **/
	function delRelationClient(row){
		$("#delRelationClientmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");//回复按钮可用
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type : 'POST',url : '/deleteOneRelationClientInfo',data : row.relation_id,contentType : 'application/json; charset=UTF-8',dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$('#relationClient-table').bootstrapTable('remove', {
							field : 'relation_id',
							values : [ row.relation_id]
						});
						$.zjm_relationClient.initRelationClientTable();
						$("#delRelationClientmodule").modal("hide");
					} else {
						alert("删除失败！");
					}
				}
			});
		});
		$("#delRelationClientmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	
	/**添加一个关联企业 **/
	function addRelationClient(){
		$("#addRelationClientModal").modal({keyboard:true});
		initClientTable();
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_relationClientForm"});
		//**提交 保存 企业信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			var selectContent = $('#client-table').bootstrapTable('getSelections').length;
	        if(selectContent != 1){
	        	$("#pleaseSelectOne").modal({keyboard:true});
	        	return false;  
	        }else{
				tool.disabled(".btn_submit");
				if($("#add_relationClientForm").validationEngine("validate")){
					$.map($('#client-table').bootstrapTable('getSelections'), function(row) {
	     				$("#add_relation_clientID").val(row.client_ID);
	     				var queryContainer_form = $("#add_relationClientForm");
	     				$.ajax({type:'POST',url:'/insertOneRelationClientInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		     		        	if(data.obj==true){
		     						$("#addRelationClientModal").modal("hide");
		     						$(".ztb_add").val("");
									$.zjm_relationClient.initRelationClientTable();
		     					}else{
		     						alert("添加关联企业失败！");
		     					}
		     		        }
		     			});	
	     			});//多选
				}else{
					tool.undisabled(".btn_submit");
				}
	        }
		});
		$("#addRelationClientModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}; 
	
	/**修改一个关联企业 **/
	function editRelationClient(row){
		$("#editRelationClientModal").modal({keyboard:true});
		$(".relation_id").val(row.relation_id);
		//加载一个 关联客户的基本信息 
		zjm.dataViewVal("edit_", "/selectOneRelationClientInfo", {"relation_id" : row.relation_id},"");
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"edit_relationClientForm"});
		//**提交 保存 修改关联信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#edit_relationClientForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_relationClientForm");
					$.ajax({
					type : 'POST',
					url : '/updateOneRelationClientInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#editRelationClientModal").modal("hide");
							$(".ztb_edit").val("");
							$.zjm_relationClient.initRelationClientTable();
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#edit_relationClientForm").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	
})(jQuery, this);

$(function () {
	/*初始化关联客户列表*/
	$(".btn_relationClient").click(function(){
		$.zjm_relationClient.initRelationClientTable();
		
		var type = tool.getUrlParam('type');
		if(type == 'view'){//如果是查看页面则隐藏操作列;
			$('#relationClient-table').bootstrapTable('hideColumn','relationClientId');
	    }
		
	});
	/*添加一个关联企业*/
	$("#btn_addRelationClient").click(function(){
		$.zjm_relationClient.addRelationClient();
	});
});


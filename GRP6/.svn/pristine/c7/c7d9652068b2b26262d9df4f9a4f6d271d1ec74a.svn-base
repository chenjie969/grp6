/**
 * 客户管理--关联查询页面 js
 */

(function($,z){
	$.zjm_queryClient = {
			query:query,
			initCompanyTable:initCompanyTable,//初始化列表，默认企业
			initPersonTable:initPersonTable,
			viewCompanyClient:viewCompanyClient,
			viewPersonClient:viewPersonClient
	};
	
	/***查询***/
	function query(){
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"queryClientFrom"
		});
		if ($("#queryClientFrom").validationEngine("validate")) {
			$("#table").show();
			var condition = $("#queryClientFrom").serializeJson();
			$.zjm_queryClient.initCompanyTable(condition);
			$.zjm_queryClient.initPersonTable(condition);
		}
	}
	
	/**初始化企业列表***/
	function initCompanyTable(condition){
		$("#companyClient-table").bootstrapTable('destroy');
		$('#companyClient-table').bootstrapTable({
			method: 'get',
			columns : [
					{field : 'index',title : '序号',align : 'center',formatter : function(value, row, index) {return index + 1;}},
					{field : "clientBH",title : '客户编号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.clientBH;}},
					{field : "clientName",title : '客户名称',align : 'center',sortable : "true",formatter : function(value, row, index) {
							return [ '<a class="btn_client_view" href="javascript:void(0)">'
									+ row.clientName + '</a>' ]
									.join('');},
						//客户名称绑定事件
						events : {
							'click .btn_client_view' : function(
									e, value, row, index) {
								$.zjm_queryClient.viewCompanyClient(row);
										
							},
						}
					},
					{field : "createUserName",title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
					{field : "createDateTime",title : '创建日期',align : 'center',sortable : "true",formatter : function(value, row, index) {return tool.parseDate(row.createDateTime);}},
					{field : "relationQueryDesc",title : '关系说明',align : 'center',sortable : "true",formatter : function(value, row, index) {console.log(row); return row.relationQueryDesc;}},
					{title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_company_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_company_view': function(e, value, row, index) {
								$.zjm_queryClient.viewCompanyClient(row);
							}
						}
					}
					], 
			detailView: false,	
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
			url: "/crm/relationQuery/relationQueryClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={};
				$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	/**初始化个人列表***/
	function initPersonTable(condition){
		$("#personClient-table").bootstrapTable('destroy');
		$('#personClient-table').bootstrapTable({
			method: 'get',
			columns: [
					 {field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
					 {field : "clientBH",title : '客户编号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.clientBH;}},
					 {field:"personName",title: '申请人姓名',align:'center',sortable:"true",formatter: function (value, row, index) {
						return ['<a class="btn_client_view" href="javascript:void(0)">'+row.personName+'</a>'].join('');
						},
						events:{
							'click .btn_client_view': function(e, value, row, index) {
								$.zjm_queryClient.viewPersonClient(row);
							},
						}
					 },
					{field:"createUserName",title: '创建人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.createUserName;}},
					{field:"createDateTime",title: '创建日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.createDateTime);}},
					{field:"relationQueryDesc",title: '关系说明',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.relationQueryDesc;}},
					{title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_person_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_person_view': function(e, value, row, index) {
								$.zjm_queryClient.viewPersonClient(row);
							}
						}
					}
					],
			detailView: false,
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
			url: "/crm/relationQuery/relationQueryPersonPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={};
				$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
		});
	}
	
	function viewCompanyClient(row){
		window.parent.openMenu('view_companyClient'+row.client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&type=view&client_ID='+row.client_ID);
	}
	function viewPersonClient(row){
		window.parent.openMenu('view_personClient'+row.client_ID,'','客户详情','/crm/client/personClient/personClientDetail.jsp','&type=view&client_ID='+row.client_ID);
	}
})(jQuery, this);



$(function() {
	
	// 关联查询
	$(".btn-query").click(function(){
		$.zjm_queryClient.query();
	});
	
	 $("#queryContent").keydown(function (e) {
	      var curKey = e.which;
	      if (curKey == 13) {
	    	  $(".btn-query").trigger('click');
	    	  return false; 
	      }
	 });
	
}); 
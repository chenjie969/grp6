(function($,z){
	$.zjm_relationProject = {
			initTable:initTable,//初始化项目列表
			initRiskSchemeTable:initRiskSchemeTable,//初始化方案记录列表
			initprojectProgressTable:initprojectProgressTable,//初始化项目进展列表
			viewCompanyClient:viewCompanyClient,//客户详情查看
			viewProjectProgress:viewProjectProgress,//项目进展详情查看
	};

	/**加载项目列表***/
	function initTable(relationMain_ID){
		$('#table_relationProject').bootstrapTable('destroy');
		$('#table_relationProject').bootstrapTable({
			method: 'post',
			columns:[	{title: '序号',align: 'center',formatter: function (value, row, index) { return index+1;}},
//						{title: '报送机构',align: 'center',formatter: function (value, row, index) { return row.oprationCompanyName;}},
//						{title: '承保机构',align: 'center',formatter: function (value, row, index) { return row.guarantyOrgName;}},
//						{title: '属地划分',align: 'center',formatter: function (value, row, index) { return row.attributionName;}},
//						{title: '承办地区',align: 'center',formatter: function (value, row, index) { return row.hostAreaName;}},
//						{title: '关联系',align: 'center',formatter: function (value, row, index) { return row.relationMainName;}},
//						{title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode;}},
//						{title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.projectName;}},
//						{title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
//						{title: '合作机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						//{title: '企业名称',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.clientName;}},
						{field:"cc.clientName",title: '客户名称',align : 'center',sortable : "true",formatter : function(value, row, index) {
							return [ '<a class="btn_client_view" href="javascript:void(0)">'
									+ row.clientName + '</a>' ]
									.join('');},
						//客户名称绑定事件
						events : {
							'click .btn_client_view' : function(
									e, value, row, index) {
								$.zjm_relationProject.viewCompanyClient(row);
										
							},}
						},
						{field:"loadSum",title: '项目金额（亿元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.loadSum;}},
						{field:"guarantySum",title: '余额（亿元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.guarantySum;}},
						{field:"projCount",title: '笔数',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.projCount;}},
//						{title: '起始日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.delayBeginDate);}},
//						{title: '到期日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.delayEndDate);}},
//						{title: '期限',align: 'center',formatter: function (value, row, index) { return row.periodMonthDay;}},
//						{title: 'A角',align: 'center',formatter: function (value, row, index) { return row.amanName;}},
//						{title: 'B角',align: 'center',formatter: function (value, row, index) { return row.bmanName;}},
						{title: '操作',align: 'center',formatter: function (value, row, index) { 
							return ['<button class="btn_client_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'
								].join('');
							},
							events:{
								'click .btn_client_view': function(e, value, row, index) {
									$.zjm_relationProject.viewCompanyClient(row);
								}
								
						}}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			sortName: "loadSum",     //排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/project/selectRelationClientProTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"relationMain_ID":relationMain_ID}; 
				 $.extend(params, {"queryCondition":queryCondition});
				 return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			minimumCountColumns: 2,    //最少允许的列数
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	/**加载项目列表***/
	function initRiskSchemeTable(relationMain_ID){
		$('#table_riskScheme').bootstrapTable('destroy');
		$('#table_riskScheme').bootstrapTable({
			method: 'post',
			columns:[	
		        {title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
				{field:"title",title: '标题',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.title;}},
				{field:"createUserName",title: '创建人',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.createUserName;}},
				{field:"createDate",title: '创建日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.createDate);}},
				{field:"status",title: '状态',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.status;}},
				{field:"remark",title: '备注',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.remark;}},
				{title: '操作',align: 'center',formatter: function (value, row, index) { 
					return ['<button class="btn_riskScheme_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'
						].join('');
					},
					events:{
						'click .btn_riskScheme_view': function(e, value, row, index) {
							$.zjm_relationProject.viewProjectProgress(row);
						}
						
				}}
			],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			sortName: "createDate",     //排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/riskScheme/selectRiskSchemePageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"relationMain_ID":relationMain_ID,"reviewType":"方案"}; 
				 $.extend(params, {"queryCondition":queryCondition});
				 return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			minimumCountColumns: 2,    //最少允许的列数
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	/**加载项目列表***/
	function initprojectProgressTable(relationMain_ID){
		$('#table_projectProgress').bootstrapTable('destroy');
		$('#table_projectProgress').bootstrapTable({
			method: 'post',
			columns:[	
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
				{field:"title",title: '标题',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.title;}},
				{field:"workProgress",title: '工作进展',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.workProgress;}},
				{field:"reviewType",title: '审批类型',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.reviewType;}},
				{field:"createUserName",title: '创建人',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.createUserName;}},
				{field:"createDate",title: '创建日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.createDate);}},
				{field:"status",title: '状态',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.status;}},
				{field:"remark",title: '备注',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.remark;}},
				{title: '操作',align: 'center',formatter: function (value, row, index) { 
					return ['<button class="btn_projectProgress_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'
						].join('');
					},
					events:{
						'click .btn_projectProgress_view': function(e, value, row, index) {
							$.zjm_relationProject.viewProjectProgress(row);
						}
						
				}}
				],
				detailView: false,
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,     //设置为 true 会在表格底部显示分页条
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "desc",     //排序方式
				sortName: "createDate",     //排序字段
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
				url: "/project/riskScheme/selectRiskSchemePageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var queryCondition ={"relationMain_ID":relationMain_ID,"reviewType":"进度"}; 
					$.extend(params, {"queryCondition":queryCondition});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				minimumCountColumns: 2,    //最少允许的列数
				search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
				showColumns: true,     //是否显示所有的列
				showRefresh: true,     //是否显示刷新按钮
				minimumCountColumns: 2,    //最少允许的列数
				clickToSelect: false,    //是否启用点击选中行
				searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
				showToggle: false,//是否显示详细视图和列表视图的切换按钮
				showPaginationSwitch:true,
				showExport: true,                     //是否显示导出
				exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function viewCompanyClient(row){
		window.parent.openMenu('view_companyClient'+row.client_ID,'','企业客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type='+'view');
	}
	
	/**查看详情***/
	function viewProjectProgress(row){
		$("#projectView_Page").load("/project/riskScheme/selectOneRiskSchemeInfo",{"riskScheme_ID":row.riskScheme_ID},function(response,status,xhr){
			$("#riskSchemeWorkInfo").modal({keyboard:true});
		});
		
	}
	
	
})(jQuery, this);

$(function () {

	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		var relationMain_ID = tool.getUrlParam('relationMain_ID');
		$.zjm_relationProject.initTable(relationMain_ID);
		$.zjm_relationProject.initRiskSchemeTable(relationMain_ID);
		$.zjm_relationProject.initprojectProgressTable(relationMain_ID);
	}
	
});


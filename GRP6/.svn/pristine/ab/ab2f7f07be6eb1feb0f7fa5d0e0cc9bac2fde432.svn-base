(function($,z){
	$.zjm_trackingWorkFlow = {
			initTableTrackingActive:initTableTrackingActive,//初始化列表 流程跟踪 活动中
			initTableTrackingFinish:initTableTrackingFinish,//初始化列表 流程跟踪 已终止
			tranInfo:tranInfo,//任务办理
			viewInfo:viewInfo//流程查看
	};
	
	var whereSql = "and projectID='" + $('#entityID_flow').val() + "'";
	/**初始化列表 活动中实例***/
	function initTableTrackingActive(os_login_user_uid){
		$('#postTrackingActive-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
			//		{title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
					{title: '流程实例ID',align: 'center',formatter: function (value, row, index) { return row.flowID;}},
					{title: '流程模板名称',align: 'center',formatter: function (value, row, index) { return row.flowTemplateName;}},
					{title: '流程发起人',align: 'center',formatter: function (value, row, index) { return row.createFlowUserName;}},
					{title: '流程发起时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.create_date);}},
					{title: '当前任务',align: 'center',formatter: function (value, row, index) { return row.stepName;}},
					{title: '任务处理人',align: 'center',formatter: function (value, row, index) { return row.waitFlowUserName;}},
					{title: '任务开始时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.start_date);}},
					//{title: '截止时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.taskEndDate);}},
					//{title: '耗时',align: 'center',formatter: function (value, row, index) { return row.taskTotalDate;}},
					//{title: '状态',align: 'center',formatter: function (value, row, index) {if(row.suspensionState==1){return "流转中"}if(row.suspensionState==2){return "挂起"}}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							if(os_login_user_uid==row.waitFlowUserUid){
								return ['<button class="btn_modules_tran btn btn-xs btn-pink" title="处理""><i class="icon-edit bigger-120"></i></button>',
								'<button class="btn_modules_view btn btn-xs btn-warning" title="查看""><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							}else{
								return ['<button class="btn_modules_view btn btn-xs btn-warning" title="查看""><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							}
						},
						events:{
							'click .btn_modules_tran': function(e, value, row, index) {
								$.zjm_trackingWorkFlow.tranInfo(row);
							},
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_trackingWorkFlow.viewInfo(row);
							}
						}
					}],
			/*detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			    return html;
			},*/
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/pendingWorkFlow/returnMonitoringWorkFlowPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql3":"1", "wheresql": whereSql});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: true,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	};
	
	
	
	/**初始化列表 已结束实例***/
	function initTableTrackingFinish(os_login_user_uid){
		$('#postTrackingStop-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{title: '流程模板名称',align: 'center',formatter: function (value, row, index) { return row.flowTemplateName;}},
					//{title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
					//{title: '流程实例ID',align: 'center',formatter: function (value, row, index) { return row.flowID;}},
					{title: '流程发起人',align: 'center',formatter: function (value, row, index) { return row.createFlowUserName;}},
					{title: '流程发起时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.create_date);}},
					//{title: '当前任务',align: 'center',formatter: function (value, row, index) { return row.taskName;}},
					//{title: '当前任务处理人',align: 'center',formatter: function (value, row, index) { return row.transactorName;}},
					{title: '开始时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.taskBeginDate);}},
					{title: '结束时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.taskEndDate);}},
					//{title: '耗时',align: 'center',formatter: function (value, row, index) { return row.taskTotalDate;}},
					//{title: '状态',align: 'center',formatter: function (value, row, index) {if(row.suspensionState==1){return "流转中"}if(row.suspensionState==2){return "挂起"}}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							
						return ['<button class="btn_modules_view btn btn-xs btn-warning" title="查看""><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_trackingWorkFlow.viewInfo(row);
							}
						}
					}],
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/pendingWorkFlow/returnMonitoringWorkFlowPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql3":"4", "wheresql": whereSql});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: true,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	};
	
	
	
	
	/**办理*/
	function tranInfo(row){
		window.parent.openMenu('osworkflow'+row.projectID,'','项目办理','/gworkFlow/tranPendingWorkFlow?projectID='+row.projectID+'&entityName='+row.entityName+'&flowType='+row.flowType+'&historyID='+row.historyID+'&flowID='+row.flowID+'&stepID='+row.stepID+'&stepName='+row.stepName);
	}
	/**查看*/
	function viewInfo(row){
		//window.parent.openMenu('osworkflow'+row.projectID,'','项目办理','/gworkFlow/WorkFlow?&entityID='+row.projectID);
	}
	
	
	
	
})(jQuery, this);



$(function () {
	var os_login_user_uid=$("#os_login_user_uid").val();
		$.zjm_trackingWorkFlow.initTableTrackingActive(os_login_user_uid);
		$.zjm_trackingWorkFlow.initTableTrackingFinish(os_login_user_uid);
});


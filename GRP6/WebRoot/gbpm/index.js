(function($,z){
	$.zjm_index = {
			messageView:messageView,//首页信息查看
			initWaitTaskProjectTable:initWaitTaskProjectTable,//初始化业务待办列表
			initFinishProjectTable:initFinishProjectTable,//初始化业务已办待办列表
			initWaitTaskApproveTable:initWaitTaskApproveTable,//初始化审批待办列表
			initFinishTaskApproveTable:initFinishTaskApproveTable,//初始化审批已办待办列表
			initWaitTaskOATable:initWaitTaskOATable,//初始化OA待办列表
			initFinishTaskOATable:initFinishTaskOATable,//初始化OA已办待办列表
			tasktransact:tasktransact,//办理任务
			tasktransactGWork:tasktransactGWork,//办理子流程任务
			tasktransactProcess:tasktransactProcess,//办理OA流程任务
			
	};
	
	/**
	 * 首页 公司通知和信息中心 查看并签收
	 */
	function messageView(messageID){
		$("#info_page").load("/oa/announce/signAnnounceViewPage",{"messageId":messageID},function(response,status,xhr){
			$("#signAnnounceView").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/oa/announce/updateStatusToYesSign',data:JSON.stringify({"messageId":messageID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
			        		window.location.reload(); 
						}else{
							alert("签收失败！");
						}
			        }
				});
			});
		});
	};
	
	
	/**初始化业务待办列表***/
	function initWaitTaskProjectTable(){
		$("#waitProjectTask-table").bootstrapTable('destroy');
		$('#waitProjectTask-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
//				{field:"productName",title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.productName;}}, 
				{field:"entityName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
				{field:"nodeNames",title: '当前环节',align: 'center',formatter: function (value, row, index) {
						return ['<a class="btn_node_edit" href="javascript:void(0)">'+row.nodeNames+'</a>'].join('');
					},
					events:{
						'click .btn_node_edit': function(e, value, row, index) {
							$.zjm_index.tasktransact(row);
						},
					}
				},
				{field:"number",title: '任务事项',align: 'center',formatter: function (value, row, index) {
					return ['<a class="btn_task_edit" href="javascript:void(0)">'+row.number+'个'+'</a>'].join('');
				},
				events:{
					'click .btn_task_edit': function(e, value, row, index) {
						$.zjm_index.tasktransact(row);
					},
				}
			},
				{field:"createUserName",title: '发起人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
				],
				detailView: false,
//			detailFormatter:function(index, row){
//			    var html = [];
//			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
//			        html.push('<p><b>流程名称:</b> ' + row.userGroupName + '</p>');
//			        html.push('<p><b>项目组人员:</b> ' + row.user_names + '</p>');
//			    return html;
//			},
//			toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true ,     //是否启用排序
				sortName:"assignDateTime",
				sortOrder: "desc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 6,      //每页的记录行数（*）
//			pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
				url: "/gbpm/runTask/selectWaitTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"pageSize":6});
					$.extend(params,{"wheresql":" AND product.productTypeName = '普通业务主流程'"});
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
	};
	
	/**初始化已办业务列表***/
	function initFinishProjectTable(){
		$("#finishProjectTask-table").bootstrapTable('destroy');
		$('#finishProjectTask-table').bootstrapTable({
			method: 'get',
			columns: [
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
//					{field:"productName",title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.productName;}}, 
					{field:"entityName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
					{field:"nodeNames",title: '当前环节',align: 'center',formatter: function (value, row, index) {
							return ['<a class="btn_node_edit" href="javascript:void(0)">'+row.nodeNames+'</a>'].join('');	
						},
						events:{
							'click .btn_node_edit': function(e, value, row, index) {
								$.zjm_index.tasktransact(row);
							},
						}
					},
					{field:"taskName",title: '任务事项',align: 'center',formatter: function (value, row, index) {
						return ['<a class="btn_task_edit" href="javascript:void(0)">'+row.number+'</a>'].join('');	
					},
					events:{
						'click .btn_task_edit': function(e, value, row, index) {
							$.zjm_index.tasktransact(row);
						},
					}
				},
					{field:"createUserName",title: '发起人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
					],
			detailView: false,
	//		detailFormatter:function(index, row){
	//		    var html = [];
	//		        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
	//		        html.push('<p><b>流程名称:</b> ' + row.userGroupName + '</p>');
	//		        html.push('<p><b>项目组人员:</b> ' + row.user_names + '</p>');
	//		    return html;
	//		},
//			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true ,     //是否启用排序
			sortName:"handleDateTime",
			sortOrder: "desc",     //排序方式
//			pageNumber:1,      //初始化加载第一页，默认第一页
//			pageSize: 6,      //每页的记录行数（*）
	//		pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
			url: "/gbpm/finishTask/selectFinishTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"pageSize":6});
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
	};
	
	/**初始化审批待办任务列表***/
	function initWaitTaskApproveTable(){
		$("#waitTaskApprove-table").bootstrapTable('destroy');
		$('#waitTaskApprove-table').bootstrapTable({
			method: 'get',
			columns: [
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"flowTemplateName",title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.flowTemplateName;}}, 
					{field:"entityName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
					{field:"taskName",title: '当前任务',align: 'center',formatter: function (value, row, index) {
							return ['<a class="btn_task_edit" href="javascript:void(0)">'+row.stepName+'</a>'].join('');
						},
						events:{
							'click .btn_task_edit': function(e, value, row, index) {
								$.zjm_index.tasktransactGWork(row);
							},
						}
					},
					{field:"user_names",title: '发起人',align: 'center',formatter: function (value, row, index) { return row.createFlowUserName;}},
					],
					detailView: false,
//					detailFormatter:function(index, row){
//					    var html = [];
//					        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
//					        html.push('<p><b>流程名称:</b> ' + row.userGroupName + '</p>');
//					        html.push('<p><b>项目组人员:</b> ' + row.user_names + '</p>');
//					    return html;
//					},
//					toolbar: '#toolbar',    //工具按钮用哪个容器
						striped: true,      //是否显示行间隔色
						cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
						pagination: false,     //设置为 true 会在表格底部显示分页条
						paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
						sortable: true ,     //是否启用排序
						sortName:"assignDateTime",
						sortOrder: "desc",     //排序方式
						pageNumber:1,      //初始化加载第一页，默认第一页
						pageSize: 6,      //每页的记录行数（*）
//					pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
						url: "/pendingWorkFlow/waitTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
						queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
						// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
						queryParams: function(params) {
							 $.extend(params, {"pageSize":6});
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
	};
	
	/**初始化审批已完成任务列表***/
	function initFinishTaskApproveTable(){
		$("#finishTaskApprove-table").bootstrapTable('destroy');
		$('#finishTaskApprove-table').bootstrapTable({
			method: 'get',
			columns: [
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"userGroupName",title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.processTemplateName;}}, 
					{field:"userGroupName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
					{field:"taskName",title: '当前任务',align: 'center',formatter: function (value, row, index) {
							return ['<a class="btn_task_edit" href="javascript:void(0)">'+row.taskName+'</a>'].join('');
						},
						events:{
							'click .btn_task_edit': function(e, value, row, index) {
								$.zjm_index.tasktransactProcess(row);
							},
						}
					},
					{field:"user_names",title: '发起人',align: 'center',formatter: function (value, row, index) { return row.initiatorName;}},
					],
					detailView: false,
//					detailFormatter:function(index, row){
//					    var html = [];
//					        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
//					        html.push('<p><b>流程名称:</b> ' + row.userGroupName + '</p>');
//					        html.push('<p><b>项目组人员:</b> ' + row.user_names + '</p>');
//					    return html;
//					},
//					toolbar: '#toolbar',    //工具按钮用哪个容器
						striped: true,      //是否显示行间隔色
						cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
						pagination: false,     //设置为 true 会在表格底部显示分页条
						paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
						sortable: true ,     //是否启用排序
						sortName:"handleDateTime",
						sortOrder: "desc",     //排序方式
						pageNumber:1,      //初始化加载第一页，默认第一页
						pageSize: 6,      //每页的记录行数（*）
//					pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
						url: "/gbpm/processInstance/selectProcessTaskHistoryTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
						queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
						// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
						queryParams: function(params) {
							$.extend(params, {"pageSize":6,"wheresql":" and  entityType != '04'"});
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
	};
	
	
	/**初始化OA待办列表***/
	function initWaitTaskOATable(){
		$("#waitTaskOA-table").bootstrapTable('destroy');
		$('#waitTaskOA-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"userGroupName",title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.processTemplateName;}}, 
				{field:"userGroupName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
				{field:"taskName",title: '当前任务',align: 'center',formatter: function (value, row, index) {
						return ['<a class="btn_task_edit" href="javascript:void(0)">'+row.taskName+'</a>'].join('');
					},
					events:{
						'click .btn_task_edit': function(e, value, row, index) {
							$.zjm_index.tasktransactProcess(row);
						},
					}
				},
				{field:"user_names",title: '发起人',align: 'center',formatter: function (value, row, index) { return row.initiatorName;}},
				],
				detailView: false,
//					detailFormatter:function(index, row){
//					    var html = [];
//					        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
//					        html.push('<p><b>流程名称:</b> ' + row.userGroupName + '</p>');
//					        html.push('<p><b>项目组人员:</b> ' + row.user_names + '</p>');
//					    return html;
//					},
//					toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true ,     //是否启用排序
				sortName:"assignDateTime",
				sortOrder: "desc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 6,      //每页的记录行数（*）
//					pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
				url: "/gbpm/processInstance/selectProcessTaskWaitTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"pageSize":6,"wheresql":" and  entityType = '04'"});
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
	};
	
	/**初始化OA已办任务列表***/
	function initFinishTaskOATable(){
		$("#finishTaskOA-table").bootstrapTable('destroy');
		$('#finishTaskOA-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"userGroupName",title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.processTemplateName;}}, 
				{field:"userGroupName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
				{field:"taskName",title: '当前任务',align: 'center',formatter: function (value, row, index) {
						return ['<a class="btn_task_edit" href="javascript:void(0)">'+row.taskName+'</a>'].join('');
					},
					events:{
						'click .btn_task_edit': function(e, value, row, index) {
							$.zjm_index.tasktransactProcess(row);
						},
					}
				},
				{field:"user_names",title: '发起人',align: 'center',formatter: function (value, row, index) { return row.initiatorName;}},
				],
				detailView: false,
//					detailFormatter:function(index, row){
//					    var html = [];
//					        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
//					        html.push('<p><b>流程名称:</b> ' + row.userGroupName + '</p>');
//					        html.push('<p><b>项目组人员:</b> ' + row.user_names + '</p>');
//					    return html;
//					},
//					toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true ,     //是否启用排序
				sortName:"handleDateTime",
				sortOrder: "desc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 6,      //每页的记录行数（*）
//					pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
				url: "/gbpm/processInstance/selectProcessTaskHistoryTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"pageSize":6,"wheresql":" and  entityType = '04' "});
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
	};
	
	/**办理业务流任务*/
	function tasktransact(row){
		window.parent.openMenu('projectDeal'+row.entityID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+row.entityID,1);
	}
	
	/**办理子流程任务*/
	function tasktransactGWork(row){
		window.parent.openMenu('osworkflow'+row.projectID,'','项目办理','/gworkFlow/tranPendingWorkFlow?projectID='+row.projectID+'&entityName='+row.entityName+'&flowType='+row.flowType+'&flowID='+row.flowID+'&stepID='+row.stepID+'&stepName='+row.stepName+'&historyID='+row.historyID);
	}
	
	/**办理审批 OA流任务*/
	function tasktransactProcess(row){
		window.parent.openMenu('edit_transact'+row.entityID,'','项目办理','/gbpm/processInstance/selectProcessTaskPageTablePage?taskID='+row.taskID+'&instanceEntity_ID='+row.instanceEntity_ID+'&entityID='+row.entityID+'&entityType='+row.entityType+'&entityName='+row.entityName+'&procDefID='+row.procDefID+'&processInstanceID='+row.processInstanceID);
	}
	
})(jQuery, this);

$(function () {
	
	$.zjm_index.initWaitTaskProjectTable();
	$.zjm_index.initFinishProjectTable();
	$.zjm_index.initWaitTaskApproveTable();
	$.zjm_index.initFinishTaskApproveTable();
	$.zjm_index.initWaitTaskOATable();
	$.zjm_index.initFinishTaskOATable();
	
	$(".messageView").click(function(){
		var messageID = $(this).attr("id");
		$.zjm_index.messageView(messageID);
	});
	
	$(".proMessage").click(function(){
		var apply_ID = $(this).attr("id")+'';
		window.parent.openMenu('projectDeal'+apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+apply_ID,1);
	});
	
	
});

(function($,z){
	$.zjm_productInstance = {
			initTableActive:initTableActive,//初始化列表 活动中
			initTableStop:initTableStop//初始化列表 已完成
	};
	/**初始化列表 活动中***/
	function initTableActive(nodeid,isChild){
		$('#postActive-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"productName",title: '流程模板名称',align: 'center',formatter: function (value, row, index) { return row.productName;}}, 
				{field:"entityName",title: '流程实例名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
//				{title: '流程发起人',align: 'center',formatter: function (value, row, index) { return row.initiatorName;}},
//				{title: '当前环节',align: 'center',formatter: function (value, row, index) { return row.taskName;}},
//				{title: '限办天数',align: 'center',formatter: function (value, row, index) { return row.transactorName;}},
				{title: '状态',align: 'center',formatter: function (value, row, index) {return row.productStatus}},
				{title: '创建时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.createDateTime);}},
				{field:"",title: '操作',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
					},
					events:{
						'click .btn_modules_view': function(e, value, row, index) {
							$.zjm_finishTask.view(row);
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
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/gbpm/productInstance/selectProductMyJoinInstancePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				/*if(isChild || typeof isChild == 'undefined'){
					$.extend(params, {"queryCondition":{"parentPostID":nodeid}});
				}else{
					$.extend(params,{"queryCondition":{"post_ID":nodeid}});
				}*/
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
	
	
	/**初始化列表 已完成***/
	function initTableStop(nodeid,isChild){
		$('#postStop-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{title: '流程名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
					{title: '流程实例ID',align: 'center',formatter: function (value, row, index) { return row.productInstanceID;}},
					{title: '流程模板名称',align: 'center',formatter: function (value, row, index) { return row.productTemplateName;}},
					{title: '流程发起人',align: 'center',formatter: function (value, row, index) { return row.initiatorName;}},
					{title: '创建时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.createDate);}}/*,
					{title: '操作',align: 'center',formatter:function(value,row,index){
							
						return ['<div class="inline position-relative" >'+
	                            '<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">'+
	                                '<i class="icon-chevron-down icon-only bigger-110"></i>'+
	                            '</button>'+
	                            '<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close" style="width:440px;">'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-info"><span class="orange2"><i class="icon-zoom-in bigger-120"></i>查看</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-success"><span class="blue"><i class="icon-pause bigger-120"></i>中止</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-success"><span class="dark"><i class="icon-remove-sign bigger-120"></i>作废</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-success"><span class="green"><i class="icon-cog bigger-120"></i>变更当前办理人</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-error"><span class="red"><i class="icon-trash bigger-120"></i>删除</span></a></li>'+
	                            '</ul>'+
	                        '</div>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_productInstance.viewInfo(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_productInstance.editInfo(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_productInstance.delInfo(row);
							}
						}
					}*/],
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
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/gbpm/productInstance/selectProcessInstanceHistoryMyInPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				/*if(isChild || typeof isChild == 'undefined'){
					$.extend(params, {"queryCondition":{"parentPostID":nodeid}});
				}else{
					$.extend(params,{"queryCondition":{"post_ID":nodeid}});
				}*/
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
	
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 岗位信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_productInstance.initTableActive();
		$.zjm_productInstance.initTableStop();
	};
});


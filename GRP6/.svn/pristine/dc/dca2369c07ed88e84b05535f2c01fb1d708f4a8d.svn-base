(function($,z){
	$.zjm_riskSchemeInfo = {
			initCompanyNameTable:initCompanyNameTable,      //企业列表
			initProjectProgressTable:initProjectProgressTable, //项目进展列表
	};
	
	
	function initCompanyNameTable(relationMain_ID){
		$("#companyName-table").bootstrapTable('destroy');
		$('#companyName-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"name",title: '企业名称',align: 'center',formatter: function (value, row, index) { return row.clientName;}},
				{field:"trade",title: '行业',align: 'center',formatter: function (value, row, index) { return row.fullTradeName;}},
				{field:"fiveLevel",title: '五级分类',align: 'center',formatter: function (value, row, index) { return row.riskLevelName;}},
				{field:"five",title: '五个一批',align: 'center',formatter: function (value, row, index) { return "";}},
				],
				detailView: false,
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
				url: "/project/riskScheme/allCompany",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var queryCondition ={"relationMain_ID":relationMain_ID}; 
					$.extend(params, {"queryCondition":queryCondition});
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
	
	
	function initProjectProgressTable(relationMainName){
		$("#projectProgress-table").bootstrapTable('destroy');
		$('#projectProgress-table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"data",title: '日期',align: 'center',formatter: function (value, row, index) { return row.finishDate;}},
				{field:"progress",title: '项目进展',align: 'center',formatter: function (value, row, index) { return row.workProgress;}},
				],
				detailView: false,
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
				url: "/project/riskScheme/selectMoreRiskSchemeTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params, {"sortName":"prs.finishDate"});
					$.extend(params, {"sortOrder":"desc"});
					$.extend(params, {"pageNumber":1,"pageSize":6});
					$.extend(params, {"searchText":relationMainName});
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
	
	
})(jQuery, this);

$(function () {
	var relationMain_ID = $("#relationMain_ID").val();//获取实例id
	var relationMainName = $("#relationMainName").val();
	$.zjm_riskSchemeInfo.initCompanyNameTable(relationMain_ID);
	$.zjm_riskSchemeInfo.initProjectProgressTable(relationMainName);

	
});


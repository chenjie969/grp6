(function($,d) {
	$.zjm_viewMoreRiskScheme = {
		initMoreRiskSchemeTable:initMoreRiskSchemeTable,
		initWorkReminderTable:initWorkReminderTable
	};
	
	/** 初始化最新工作进度 ***/
	function initMoreRiskSchemeTable(){
		$("#table_viewMoreRiskScheme").bootstrapTable('destroy');
		$('#table_viewMoreRiskScheme').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',valign:"middle",formatter: function (value, row, index) {return index+1;}}, 
						{title: '项目类型',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.projectTypeName;}},
						{title: '所属区域',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.fullAreaName;}},
						{title: '关联系',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.relationMainName;}},
						{title: '日期',align: 'center',valign:"middle",formatter: function (value, row, index) { return tool.parseDate(row.finishDate);}},
						{title: '工作进度',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.workProgress;}},
					 ],
			detailView: false,
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true ,     //是否启用排序
			sortName:"prs.finishDate",	//创建日期
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页		pagination设置为false后, 这里的分页就失效了
			pageSize: 30,      //每页的记录行数（*）
			pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
			url: "/project/riskScheme/selectMoreRiskSchemeTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			/*queryParams: function(params) {
				$.extend(params, {"wheresql":" AND reviewType LIKE '%工作进度%'"});
				return params;
			},*///前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/** 工作进度提醒 ***/
	function initWorkReminderTable(type){
		$("#table_viewMoreRiskScheme").bootstrapTable('destroy');
		$('#table_viewMoreRiskScheme').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',valign:"middle",formatter: function (value, row, index) {return index+1;}}, 
						{title: '项目类型',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.projectTypeName;}},
						{title: '所属区域',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.fullAreaName;}},
						{title: '关联系',align: 'center',valign:"middle",formatter: function (value, row, index) { return row.relationMainName;}}, 
						{title: '上次提交日期',align: 'center',valign:"middle",formatter: function (value, row, index) { return tool.parseDate(row.finishDate);}},
					 ],
			detailView: false,
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true ,     //是否启用排序
			sortName:"prs.finishDate",	//创建日期
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页		pagination设置为false后, 这里的分页就失效了
			pageSize: 30,      //每页的记录行数（*）
			pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
			url: "/project/riskScheme/selectSchemeNoticeList",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {queryCondition:{"queryType":type}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
})(jQuery,this);


$(function(){
	
	var type = tool.getUrlParam('type');
	if(type=="more"){
		$.zjm_viewMoreRiskScheme.initMoreRiskSchemeTable();
	}else{
		$.zjm_viewMoreRiskScheme.initWorkReminderTable(type);
	}
	
});
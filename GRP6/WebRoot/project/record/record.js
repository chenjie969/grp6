(function($,z){
	$.zjm_record = {
			initFileTable:initFileTable,//初始化列表
			initAccessoryTable:initAccessoryTable,
		    del:del
	};

	/**文档初始化列表***/
	function initFileTable(){
		$('#file_table').bootstrapTable('destroy');
		$('#file_table').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"",title: '类别',align: 'center',formatter: function (value, row, index) { return "一级";}},
						{field:"",title: '文件名称',align: 'center',formatter: function (value, row, index) { return "担保意见书";}},
						{field:"",title: '份数',align: 'center',formatter: function (value, row, index) { return "5";}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
									'<button class="btn_record_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_record_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_record_edit': function(e, value, row, index) {
									$("#fileEdit").modal({keyboard:true});
								},
								'click .btn_record_del': function(e, value, row, index) {
									$.zjm_record.del();
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号：</b> ' + row.applyNum + '</p>');
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
			url: "/crm/apply/selectApplyPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"apply_clientType":"01","apply_approvalStatu":"01"}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
/*			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
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
*/		});
	}
	
	function del(){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");
		$("#delMessage").text("是否删除此信息?");
	}
	/* 档案附件初始化列表*/
	function initAccessoryTable(){
		$('#truthPostion1').bootstrapTable('destroy');
		$('#truthPostion1').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"",title: '名称',align: 'center',formatter: function (value, row, index) { return "合同";}},
						{field:"",title: '文件大小',align: 'center',formatter: function (value, row, index) { return "1MB";}},
						{field:"",title: '创建日期',align: 'center',formatter: function (value, row, index) { return "2017-08-05";}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
									'<button class="btn_accessory_view btn btn-xs btn-info" title="查看" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_accessory_download btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_accessory_view': function(e, value, row, index) {
									$("#acessoryView").modal({keyboard:true});
								},
								'click .btn_accessory_del': function(e, value, row, index) {
									$.zjm_record.download();
								}
							}
						}
					],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号：</b> ' + row.applyNum + '</p>');
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
			url: "/crm/apply/selectApplyPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"apply_clientType":"01","apply_approvalStatu":"01"}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
})(jQuery, this);

$(function () {
	$.zjm_record.initFileTable();
	$("#recordList").click(function(){
		$.zjm_record.initFileTable();
	});
	$("#recordAccessory").click(function(){
		$.zjm_record.initAccessoryTable();
	});
	
	
	
	$("#btn_addFile").click(function(){
		$("#fileAdd").modal({keyboard:true});
	});
	$("#btn_editTurnInfo").click(function(){
		$("#turnInfoEdit").modal({keyboard:true});
	});
	$("#btn_editApprove").click(function(){
		$("#approveInfoEdit").modal({keyboard:true});
	});
});


(function($,z){
	$.zjm_dimission = {
			viewDismission:viewDismission,//查看离职员工信息
			initTable:initTable//初始化列表
		
	};
	/**初始化列表***/
	function initTable(staffcase_Id){
		
		$("#personfileDimission").bootstrapTable('destroy');
		$('#personfileDimission').bootstrapTable({
			method: 'get',
			columns: [{field:"user_name",title: '姓名',align: 'center',formatter: function (value, row, index) {return row.user_name;}}, 
				{field:"sex",title: '性别',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.sex;}},
				{field:"mobilphone",title: '联系方式',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.mobilphone;}},
				{field:"borndate",title: '出生日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.borndate);}},
				{field:"joinWorkDate",title: '加入本单位日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.joinWorkDate);}},
				{field:"leavedate",title: '离职日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.leavedate);}},
				{field:"leavereason",title: '离职原因',align: 'center',formatter: function (value, row, index) { return row.leavereason;}},
				{
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						return [
								'<button title="查看" class="btn_Cooperations_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>' ]
								.join('');
					},
					// 事件绑定
					events : {
						'click .btn_Cooperations_view' : function(
								e, value, row, index) {
							$.zjm_dimission.viewDismission(row);
						}
						
					}
				}],
								
				detailView: true,
				detailFormatter:function(index, row){
					var mobilphone = row.mobilphone;
					if(mobilphone == null){	
						mobilphone="（空）";
					}
					var sex = row.sex;
					if(sex == null){	
						sex="（空）";
					}
					var borndate= tool.parseDate(tool.isNull(row.borndate,""));
					borndate=borndate==""?'（空）':borndate;
					var joinWorkDate= tool.parseDate(tool.isNull(row.joinWorkDate,""));
					joinWorkDate=joinWorkDate==""?'（空）':joinWorkDate;
					var leavedate= tool.parseDate(tool.isNull(row.leavedate,""));
					leavedate=leavedate==""?'（空）':leavedate;
					var leavereason = row.leavereason;
					if(leavereason == null){	
						leavereason="（空）";
					}
					var html = [];
					html.push('<p><b>姓名:</b> ' + row.user_name + '</p>');
					html.push('<p><b>性别:</b> ' + sex + '</p>');
					html.push('<p><b>联系方式:</b> ' + mobilphone + '</p>');
					html.push('<p><b>出生日期:</b> ' +  borndate + '</p>');
					html.push('<p><b>加入本单位日期:</b> ' + joinWorkDate + '</p>');
					html.push('<p><b>离职时间:</b> ' + leavedate + '</p>');
					html.push('<p><b>离职原因:</b> ' + leavereason + '</p>');
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
				pageList: [ 30, 50, 100,200, 500],  //可供选择的每页的行数（*）
				url: "/oa/disMiass/selectDisMissionTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"staffcase_Id":staffcase_Id}});
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
	/**查看*/
	
	function viewDismission(row){                                                    	
		window.parent.openMenu('editEmployee'+row.user_uid,'','查看离职员工信息','/oa/staffCase/employeeInfo','&id='+row.user_uid+'&user_name='+row.user_name);	
	}

})(jQuery, this);
	$(function () {
		var  staffcase_Id=$("#staffcase_Id").val();
			$.zjm_dimission.initTable(staffcase_Id);
		

	
	});


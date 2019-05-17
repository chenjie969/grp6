(function($,z){
	$.zjm_meetingApplyRecord = {
		initTable:initTable	
	};
	
	/**初始化列表***/
	function initTable(){
		$('#table_submitedApplyRecord').bootstrapTable('destroy');
		$('#table_submitedApplyRecord').bootstrapTable({
			method: 'post',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"applyMeetingDate",title: '申请上会日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.applyMeetingDate);}},
						{field:"busiCode",title: '项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
						{field:"projectName",title: '项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { 
							return [ '<a class="btn_proApply_view" href="javascript:void(0)">'+ row.projectName + '</a>' ].join('');},
							events:{
								'click .btn_proApply_view' : function(e, value, row, index) {
									$.zjm_meetingApplyIndex.viewApplyInfo(row);
								}
							}
						},
						{field:"",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeNameList.replace(",","<br/>");}},
						{field:"applySum",title: '申请金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applySum;}},
//						{field:"unit_uidName",title: '申请期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidName;}},
						{field:"operationDepartName",title: '申请部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operationDepartName;}},
						{field:"applyMeetingUserName",title: '申请人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applyMeetingUserName;}},
						{field:"meetingSubmitDate",title: '提交日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.meetingSubmitDate);}},
						{field:"meetingStatus",title: '状态',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.meetingStatus;}},
						{title:"操作",align: 'center',formatter:function(value,row,index){
								return '<button class="btn_proApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>';
							},
							events:{
								'click .btn_proApply_view': function(e, value, row, index) {
									$.zjm_meetingApplyIndex.viewApplyInfo(row);
								}
							}
						}],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName: "meetingSubmitDate",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/meetingApply/selectSubmitedApplyRecordPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
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
	
})(jQuery, this);

$(function () {
	
	$.zjm_meetingApplyRecord.initTable();
	
})


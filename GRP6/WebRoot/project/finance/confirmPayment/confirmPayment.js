(function($,z){
	$.zjm_confirmPayment = {
		initTable:initTable,	
		viewConfirmDetail:viewConfirmDetail,
		backToProjectCost:backToProjectCost,
	};
	

	/**初始化列表***/
	function initTable(tabName,data){
		if(tabName==undefined){
			tabName = "noConfirmPayment";
		}
		$("#table_"+tabName).bootstrapTable('destroy');
		$("#table_"+tabName).bootstrapTable({
			method: 'post',
			columns: initColumns(tabName),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>项目编号：</b> ' + row.applyNum + '</p>');
			        html.push('<p><b>项目名称：</b> ' + row.clientName + '</p>');
			        html.push('<p><b>业务品种：</b> ' + row.busiTypeName + '</p>');
			        html.push('<p><b>同意金额：</b> ' + row.applySum + '万元</p>');
			        html.push('<p><b>同意期限：</b> ' + tool.isNull(row.periodMonthDay,"（空）") + '</p>');
			        html.push('<p><b>发生金额：</b> ' + row.cooperationName + '元</p>');
			        html.push('<p><b>是否需要开具票据：</b> ' + row.clientSourceName + '</p>');
			        html.push('<p><b>发生日期：</b> ' + tool.parseDate(row.receiveDate) + '</p>');
			        html.push('<p><b>经办部门：</b> ' + row.receiveDeapartName + '</p>');
			        html.push('<p><b>经办人：</b> ' + row.receiveUserName + '</p>');
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
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"apply_clientType":"01","apply_approvalStatu":"01"}; 
				 $.extend(queryCondition,data);
				 $.extend(params, {"queryCondition":queryCondition});
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
	
	/**初始化列表项***/
	function initColumns(tabName){
		var columns = [	/*{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},*/
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"banksortname",title: '项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return "XMBH00001";}},
						{field:"banksortname",title: '项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return "A公司";}},
						{field:"banksortname",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index) { return "流动资金";}},
						{field:"banksortname",title: '同意金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2000";}},
						{field:"banksortname",title: '同意期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return "12个月";}},
						{field:"banksortname",title: '发生金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "20000";}},
						{field:"banksortname",title: '发生日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2017-07-20";}},
						{field:"banksortname",title: '是否需要开具票据',align: 'center',sortable:"true",formatter: function (value, row, index) { return "是";}},
						{field:"banksortname",title: '经办部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return "业务一部";}},
						{field:"banksortname",title: '经办人',align: 'center',sortable:"true",formatter: function (value, row, index) { return "赵强";}},
		];
		if(tabName=="noConfirmPayment"){
			columns.push({title: '操作',align: 'center',
				formatter:function(value,row,index){
					return '<a class="btn_confirmPayment" href="javascript:void(0)">收付确认</a>&nbsp;&nbsp;&nbsp;'+
							'<a class="btn_backToProjectCost" href="javascript:void(0)">退回</a>';
				},
				events:{
					'click .btn_confirmPayment': function(e, value, row, index) {
						$.zjm_confirmPayment.viewConfirmDetail(row);
					},
					'click .btn_backToProjectCost': function(e, value, row, index) {
						$.zjm_confirmPayment.backToProjectCost(row);
					}
				}
			});
		}else if(tabName=="confirmedPayment"){
			columns.push({field:"banksortname",title: '收付确认人',align: 'center',sortable:"true",formatter: function (value, row, index) { return "赵强";}},
						{field:"banksortname",title: '收付确认日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2017-07-24";}},
						{title: '操作',align: 'center',
							formatter:function(value,row,index){
								return '<a class="btn_viewPaymentDetail" href="javascript:void(0)">查看</a>&nbsp;&nbsp;&nbsp;'+
										'<a class="btn_backToNoConfirmPayment" href="javascript:void(0)">撤销收付确认</a>';
							},
							events:{
								'click .btn_viewPaymentDetail': function(e, value, row, index) {
									$.zjm_confirmPayment.viewPaymentDetail(row);
								},
								'click .btn_backToNoConfirmPayment': function(e, value, row, index) {
									$.zjm_confirmPayment.backToNoConfirmPayment(row);
								}
							}
						});
		}
		return columns;
	}
	
	/**初始化弹窗列表***/
	function initDetailTable(){
		$('#table_confirmPayment').bootstrapTable('destroy');
		$('#table_confirmPayment').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"banksortname",title: '费用类别',align: 'center',sortable:"true",formatter: function (value, row, index) { return " 预收评审费";}},
						{field:"banksortname",title: '费率（%）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "0.5";}},
						{field:"banksortname",title: '应收金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2000";}},
						{field:"banksortname",title: '实收金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2000";}},
						{field:"banksortname",title: '退费金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "";}},
						{field:"banksortname",title: '实际收费金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2000";}},
						{field:"banksortname",title: '经办部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return "业务一部";}},
						{field:"banksortname",title: '经办人',align: 'center',sortable:"true",formatter: function (value, row, index) { return "曾小贤";}},
						{field:"banksortname",title: '发生日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2017年7月22日";}},
					],
			detailView: false,
			url: "/project/apply/selectProjectApplyPageTable",//这个接口需要处理bootstrap table传递的固定参数
			sortName:"updateDateTime",	//默认排序字段
			sortOrder: "desc",     //排序方式
			striped: true,      //是否显示行间隔色
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**
	 * 收付确认信息详情
	 */
	function viewConfirmDetail(row){
		$("#confirmPayment_page").load("/project/finance/showConfirmPaymentPage",{},function(response,status,xhr){
			$("#paymentDetail").modal({keyboard:true});
			initDetailTable();
		});
	}
	
	/**
	 * 退回费用登记
	 */
	function backToProjectCost(row){
		$("#confirmPayment_page").load("/project/finance/showConfirmPaymentPage",{},function(response,status,xhr){
			$("#paymentDetail").modal({keyboard:true});
		});
	}
	
	/**
	 * 撤销收付确认
	 */
	function backToNoConfirmPayment(row){
		$("#confirmPayment_page").load("/project/finance/showBackToNoConfirmPage",{},function(response,status,xhr){
			$("#backToNoConfirm").modal({keyboard:true});
		});
	}
	
	/**
	 * 查看已确认收付的费用明细
	 */
	function backToNoConfirmPayment(row){
		$("#confirmPayment_page").load("/project/finance/showBackToNoConfirmPage",{},function(response,status,xhr){
			$("#backToNoConfirm").modal({keyboard:true});
		});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_confirmPayment.initTable();
	};
	
	/**
	 * 给标签设置点击事件
	 */
	$(".confirmPaymentTab").click(function(){
		var tabName = $(this).attr("data-value");
		$.zjm_confirmPayment.initTable(tabName);
	});
	
});


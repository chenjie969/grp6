(function($,z){
	$.zjm_oneProjectCost = {
		initTable:initTable,	//初始化列表
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#table_oneProjectCost').bootstrapTable('destroy');
		$('#table_oneProjectCost').bootstrapTable({
			method: 'post',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"banksortname",title: '费用类别',align: 'center',sortable:"true",formatter: function (value, row, index) { return " 预收评审费";}},
						{field:"banksortname",title: '费率（%）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "0.5";}},
						{field:"banksortname",title: '应收金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2000";}},
						{field:"banksortname",title: '实收金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2000";}},
						{field:"banksortname",title: '退费金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "";}},
						{field:"banksortname",title: '实际收费金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2000";}},
						{field:"banksortname",title: '经办部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return "业务一部";}},
						{field:"banksortname",title: '经办人',align: 'center',sortable:"true",formatter: function (value, row, index) { return "曾小贤";}},
						{field:"banksortname",title: '发生日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2017年7月22日";}},
						{field:"banksortname",title: '收付确认人',align: 'center',sortable:"true",formatter: function (value, row, index) { return "陈楠";}},
						{field:"banksortname",title: '收付确认日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2017年7月30日";}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_projectCost_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_projectCost_view': function(e, value, row, index) {
									$.zjm_oneProjectCost.viewCoopBZJManager(row);
								},
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>费用类别：</b> ' + "XMBH00001" + '</p>');
				    html.push('<p><b>费率：</b> ' + "0.5" + '%</p>');
				    html.push('<p><b>应收金额：</b> ' + "2000" + '元</p>');
				    html.push('<p><b>实收金额：</b> ' + "2000" + '元</p>');
				    html.push('<p><b>退费金额：</b> ' + "2000" + '元</p>');
				    html.push('<p><b>实际收费金额：</b> ' + "2000" + '元</p>');
				    html.push('<p><b>经办部门：</b> ' + "业务一部" + '</p>');
				    html.push('<p><b>经办人：</b> ' + "曾小贤" + '</p>');
				    html.push('<p><b>发生日期：</b> ' + "2017年7月22日" + '</p>');
				    html.push('<p><b>收付确认人：</b> ' + "陈楠" + '</p>');
				    html.push('<p><b>收付确认日期：</b> ' + "2017年7月30日" + '</p>');
		        return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",	//默认排序字段
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/apply/selectProjectApplyPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			/*queryParams: function(params) {
				var queryCondition = {"pbanksortid": "e7e282ee61b249eba0f64161fee6ff45"};
				$.extend(queryCondition,data);
				$.extend(params, {"queryCondition":queryCondition});
				return params;
			},*/  //前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
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
            showExport: true,                     //oneProjectCost_page是否显示导出
            exportDataType: "basic",              //basic', 'all', 'selected'
		});
	}
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_oneProjectCost.initTable();
	};
	
	/**
	 * 转收付确认
	 */
	$("#btn_jumpToConfirmPayment").click(function(){
		var selectContent = $("#table_oneProjectCost").bootstrapTable("getSelections");
		if(selectContent.length < 1){
			$("#pleaseSelectOne").modal({keyboard:true});
		}else{
			$("#oneProjectCost_page").load("/project/finance/showJumpToConfirmPaymentPage","",function(){
				$("#jumpToConfirmPayment").modal({keyboard:true});
				$.zjm_jumpToConfirmPayment.initTable(selectContent);
			});
		}
	});
	
	/**
	 * 收费管理
	 */
	$("#btn_chargeManage").click(function(){
		$("#oneProjectCost_page").load("/project/finance/showMustChargeAddPage","",function(){
			$("#mustChargeAdd").modal({keyboard:true});
			$.zjm_mustChargeAdd.addTableRow();
		});
	});
	
	/**
	 * 退费管理
	 */
	$("#btn_refundManage").click(function(){
		$("#oneProjectCost_page").load("/project/finance/showRefundAddPage","",function(){
			$("#refundAdd").modal({keyboard:true});
			$.zjm_refundAdd.addTableRow();
		});
	});

});


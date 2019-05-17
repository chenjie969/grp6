(function($,z){
	$.zjm_projectBillInfo = {
		initTable:initTable,	//初始化列表
		initSelectTree:initSelectTree,
		editProjectBillInfo:editProjectBillInfo,	//修改票据信息
		viewProjectBillInfo:viewProjectBillInfo,	//查看票据信息
		delProjectBillInfo:delProjectBillInfo,		//删除票据信息
	}
	
	/**初始化主体列表***/
	function initTable(data){
		$('#table_projectBillInfo').bootstrapTable('destroy');
		$('#table_projectBillInfo').bootstrapTable({
			method: 'post',
			singleSelect : true, 
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"banksortname",title: '票据类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return "增值税专用发票";}},
						{field:"banksortname",title: '票据编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return "1221312312";}},
						{field:"banksortname",title: '开具金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return "20000.00";}},
						{field:"banksortname",title: '开具人',align: 'center',sortable:"true",formatter: function (value, row, index) { return "王小刚";}},
						{field:"banksortname",title: '开具日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2017年7月12日";}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_projectBillInfo_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_projectBillInfo_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_projectBillInfo_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_projectBillInfo_view': function(e, value, row, index) {
									$.zjm_projectBillInfo.viewProjectBillInfo(row);
								},
								'click .btn_projectBillInfo_edit': function(e, value, row, index) {
									$.zjm_projectBillInfo.editProjectBillInfo(row);
								},
								'click .btn_projectBillInfo_del': function(e, value, row, index) {
									$.zjm_projectBillInfo.delProjectBillInfo(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>票据类型：</b> ' + "增值税专用发票" + '</p>');
				    html.push('<p><b>票据编号：</b> ' + "1221312312" + '</p>');
				    html.push('<p><b>开具金额：</b> ' + "20000.00" + '元</p>');
				    html.push('<p><b>开具人：</b> ' + "王小刚" + '</p>');
				    html.push('<p><b>开具日期：</b> ' + "2017年7月12日" + '</p>');
		        return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"createDate",	//默认排序字段
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
            exportDataType: "basic",              //basic', 'all', 'selected'
		});
	}
	
	function initSelectTree(){
		/*获取创建人下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#createUser").selectTreeWidgets({
					width : "89%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
		    }
		});
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		/*设置日期初始值，默认为当天*/
		$("#createDate").attr("value",tool.parseDate(new Date().getTime()));
	}
	
	/**
	 * 修改票据信息 
	 */
	function editProjectBillInfo(row){
		$("#projectBillInfo_page").load("/project/finance/showProjectBillInfoUpdatePage",{},function(response,status,xhr){
			$("#editProjectBillInfo").modal({keyboard:true});
			$.zjm_projectBillInfo.initSelectTree();
		});
	}
	
	/**
	 * 查看票据信息 
	 */
	function viewProjectBillInfo(row){
		$("#projectBillInfo_page").load("/project/finance/showProjectBillInfoViewPage",{},function(response,status,xhr){
			$("#viewProjectBillInfo").modal({keyboard:true});
		});
	}
	
	/**
	 * 删除票据信息 
	 */
	function delProjectBillInfo(row){
		$("#projectBillInfo_page").load("/project/finance/showProjectBillInfoDelPage",{},function(response,status,xhr){
			$("#delProjectBillInfo").modal({keyboard:true});
		});
	}
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_projectBillInfo.initTable();
	};
	
	/**
	 * 登记票据信息
	 */
	$("#btn_addProjectBillInfo").click(function(){
		$("#projectBillInfo_page").load("/project/finance/showProjectBillInfoAddPage",{},function(response,status,xhr){
			$("#addProjectBillInfo").modal({keyboard:true});
			$.zjm_projectBillInfo.initSelectTree();
		});
	});
	
});


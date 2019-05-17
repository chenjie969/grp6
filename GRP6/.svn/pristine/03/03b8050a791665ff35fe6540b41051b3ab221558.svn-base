(function($,z){
	$.zjm_financeAnalyze = {
			initData:initData,//初始化数据
			initReportZcfzTable:initReportZcfzTable,//初始化资产负债表
			openReportZcfzEditPage:openReportZcfzEditPage,//打开修改资产负债表页面;
			financeIndexCompare:financeIndexCompare // 财务指标对比分析
	};
	
	/**
	 * 初始化数据
	 * @param client_ID
	 * @returns
	 */
	function initData(client_ID){	
		zjm.init();	    
		$.zjm_financeAnalyze.initReportZcfzTable();
	};
	
	

	/**初始化列表项**/
	function initColumn(){
		var columns = [{field : 'checked',title:'reportZcfz_ID',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
						{field : 'index',title : '序号',align : 'center',formatter : function(value, row, index) {return index + 1;}},
						{field:'reportTypeName',title:'类别',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.reportTypeName;}},
						{field:'yearMonth',title:'年月',align: 'center',sortable:"true",formatter: function (value, row, index) {					
							return [ '<a class="btn_reportZcfz_view" href="javascript:void(0)">'
								+ row.yearMonth + '</a>' ].join('');
						},
						//年月绑定事件
						events : {
							'click .btn_reportZcfz_view' : function(
									e, value, row, index) {
								$.zjm_financeAnalyze.viewReportZcfz(row);
										
							},
						}
						}];
			columns.push({title : '操作',align : 'center',
						formatter : function(value, row, index) {
							return [
									'<button class="btn_reportZcfz_edit btn btn-xs btn-info" title="财务指标分析" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'
									].join('');
						},
						events : {
							'click .btn_reportZcfz_edit' : function(e, value, row, index) {
								
								$.zjm_financeAnalyze.financeIndexCompare(row);
							}
						}
			});
		return columns;
	}
	
	
	
	
	
	/**初始化资产负债列表***/
	function initReportZcfzTable(){		
		$("#reportZcfzs-table").bootstrapTable('destroy');
		$('#reportZcfzs-table').bootstrapTable({
			method: 'get',
			columns: initColumn() ,
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/reportZcfz/selectReportZcfzPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"client_ID":$(".client_ID").val()}});
				return params;
			},
			//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			rictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
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
	};
	

	
	/** 客户详情  资产负债列表 打开修改资产负债列表信息**/
	function openReportZcfzEditPage(row){
		console.info(row);
	//	window.parent.openMenu('openReportZcfzEditPage'+row.reportZcfz_ID,'',' 修改资产负债详情','/reportZcfz/openReportZcfzEditPage','&reportZcfz_ID='+row.reportZcfz_ID+'&type='+'edit',1);
		window.parent.openMenu('financeCompute'+row.reportZcfz_ID,'','主要财务指标分析','/financeAnayzeAcion/financeCompute','&client_ID='+$("#client_ID").val());

	};	
	
	
	/**
	 * 主要财务指标分析
	 */
	function financeIndexCompare(row){
		var reportZcfz_ID="";
		if( row.constructor.toString().indexOf("Array")>-1){
			for(xx in row){
				if(xx < row.length-1){
					reportZcfz_ID+=row[xx].reportZcfz_ID+",";
				}else{
					reportZcfz_ID+=row[xx].reportZcfz_ID;
				}
			}
		}else{
			reportZcfz_ID=row.reportZcfz_ID
		}
		window.parent.openMenu('financeCompute'+Math.random(),'','主要财务指标分析','/financeAnayzeAcion/financeCompute','&client_ID='+$("#client_ID").val()+'&reportZcfz_ID='+reportZcfz_ID);
	}
	
})(jQuery, this);

$(function () {

	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	$(".btn_Zcfz").click(function(){
			$.zjm_financeAnalyze.initData(client_ID);
			var type = tool.getUrlParam('type');//获取路径类型:查看/修改
			if(type == 'view'){
				$("#btn_openReportZcfzAddPage").hide();
			}
	});	
	
	/**
	 * 刷新财务指标列表 tab刷新
	 */
	$("#btn_financeAnalyze").click(function(){
		$.zjm_financeAnalyze.initData(client_ID);
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'view'){
			$("#btn_openReportZcfzAddPage").hide();
			$('#reportZcfzs-table').bootstrapTable('hideColumn','reportZcfzID');
		}
	});
	
	
	/**
	 * 财务指标分析
	 */
	$("#btn_financeComputed").click(function(){
		 var selectValue = $('#reportZcfzs-table').bootstrapTable('getSelections');//获取选中的列;
		 if(selectValue.length == 0 ){
			 $("#message").text('请选择一条数据，然后再操作!');
			 $("#pleaseSelectOne").modal({keyborad:true});
		 }else if(selectValue.length >3){
			 $("#message").text('财务指标分析数据不能超过3期!');
			 $("#pleaseSelectOne").modal({keyborad:true});
		 }else{
			 
			 $.zjm_financeAnalyze.financeIndexCompare(selectValue);
		 }
	});
	
	
	/**
	 * 刷新财务指标列表 按钮刷新
	 */
	$("#btn_refreshFinanceAnalyze").click(function(){
		$.zjm_financeAnalyze.initData(client_ID);
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'view'){
			$("#btn_openReportZcfzAddPage").hide();
			$('#reportZcfzs-table').bootstrapTable('hideColumn','reportZcfzID');
		}
	});
	
	
});


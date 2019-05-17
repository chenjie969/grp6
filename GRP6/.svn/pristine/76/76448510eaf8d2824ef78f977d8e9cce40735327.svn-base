(function($,z){
	$.zjm_projectFinish = {
			initColumns:initColumns,
			initProjectTalble:initProjectTalble,//初始化列表
	};
		
	function initColumns(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'projectName',title:'项目名称',align:'center',sortable : "true",formatter: function (value, row, index) {return row.projectName;}},
			{field:'fundSource',title:'资金来源',align:'center',sortable : "true",formatter: function (value, row, index) {return row.fundSource;}},
			{field:'fundType',title:'资金方类型',align:'center',sortable : "true",formatter: function (value, row, index) {return row.fundType;}},
			{field:'fundName',title:'资金方名称',align:'center',sortable : "true",formatter: function (value, row, index) {return row.fundName;}},
			{field:'creditorSum',title:'转让金额',align:'center',sortable : "true",formatter: function (value, row, index) {return row.creditorSum;}},
			{field:'creditorDate',title:'上报日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.creditorDate,'');}}
			/*{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_projectAfter_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'
					
					
					].join('');
				},
				events:{'click .btn_projectAfter_edit': function(e, value, row, index) {
						$.zjm_projectFinish.editProjectAfter(row);
					}
				}
			}*/
		];
		return columns;
		
	}	
	
	/**初始化列表***/
	function initProjectTalble(condition){
		$("#projectCreditor-table").bootstrapTable('destroy');
		$('#projectCreditor-table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			       // html.push('<p><b>序号:</b> ' + tool.isNull(row.clientBH,"") + '</p>');
			        html.push('<p><b>项目名称:</b> ' + tool.isNull(row.projectName,"") + '</p>');
			        html.push('<p><b>资金来源:</b> ' + tool.isNull(row.fundSource,"") + '</p>');
			        html.push('<p><b>资金方类型:</b> ' + tool.isNull(row.fundType,"") + '</p>');
			        html.push('<p><b>资金方名称:</b> ' + tool.isNull(row.fundName,"") + '</p>');
			        html.push('<p><b>转让金额:</b> ' + tool.isNull(row.creditorSum,"") + '</p>');
			        html.push('<p><b>上报日期:</b> ' + tool.parseDate(row.creditorDate,"") + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			singleSelect : true,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			sortName: "pp.finishDate",     //默认排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/project/selectProjectCreditorPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={};
				//var queryCondition={"clientTypeID":$(".clientTypeID").val()};
				$.extend(params,{"queryCondition":condition});
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
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_projectFinish.initProjectTalble();
	};
	//重置列表
	$("#btn_refresh").click(function(){
		$.zjm_projectFinish.initProjectTalble();
	});
});


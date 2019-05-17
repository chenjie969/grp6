(function($,z){
	$.zjm_projectDetail = {
			initProjectDetailTable:initProjectDetailTable//初始业务明细化列表
	};
	
	
	/**初始化业务明细列表***/
	function initProjectDetailTable(){
		$("#projectDetail-table").bootstrapTable('destroy');
		$('#projectDetail-table').bootstrapTable({
			method: 'get',
			columns: [{field:'',title:'项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) {return index+1;}},
				{field:"clientName",title: '客户名称',align: 'center',sortable:"true",formatter: function (value, row, index) {
					return ['<a class="btn_client_view" href="javascript:void(0)">row.clientName</a>'].join('');
					},
					events:{
						'click .btn_client_view': function(e, value, row, index) {
							//$.zjm_projectDetail.viewModule(row);
						},
					}
				},
				{field:"fullAreaName",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index) { return "委托贷款";}},
				{field:"fullTradeName",title: '申请金额(万)',align: 'center',sortable:"true",formatter: function (value, row, index) { return "1000";}},
				{field:"fullTradeName",title: '申请期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return "三个月";}},
				{field:"createDate",title: '创建部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return "业务部";}},
				{field:"legalPerson",title: '创建人',align: 'center',sortable:"true",formatter: function (value, row, index) { return "张三";}},
				{field:"registerSum",title: '创建日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return "2017-01-01";}},
				{title:'操作',align: 'center',formatter:function(value,row,index){
					return ['<button class="btn_client_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'
							].join('');
					},
					events:{
						'click .btn_client_view': function(e, value, row, index) {
							//$.zjm_projectDetail.viewModule(row);
						}
					}
				}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>客户名称:</b> ' + row.clientName + '</p>');
			        html.push('<p><b>业务品种:</b> ' + row.fullTradeName + '</p>');
			    return html;
			},
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			//url: "/selectModulesPageTables?queryCondition.mod_uid="+nodeid,//这个接口需要处理bootstrap table传递的固定参数
			url: "/selectCompanyClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			//queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server"   //分页方式：client客户端分页，server服务端分页（*）
			//search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			//rictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			//showColumns: true,     //是否显示所有的列
			//showRefresh: true,     //是否显示刷新按钮
			//minimumCountColumns: 2,    //最少允许的列数
			//clickToSelect: false,    //是否启用点击选中行
			//searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			//showToggle: true,//是否显示详细视图和列表视图的切换按钮
			//showPaginationSwitch:true,
            //showExport: true,                     //是否显示导出
            //exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 列表信息
	 */
	$.zjm_projectDetail.initProjectDetailTable();
	
});


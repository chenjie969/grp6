(function($,z){
	$.zjm_fundsDetail = {
		initTable:initTable,	//初始化列表
		viewFundsDetail:viewFundsDetail,
	};
	
	/**初始化主体列表***/
	function initTable(){
		$('#table_fundsDetail').bootstrapTable('destroy');
		$('#table_fundsDetail').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"clientBH",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.detailList[0].projectCode;}},
						{field:"clientBH",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.projectName;}},
						{field:"clientBH",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.detailList[0].busiTypeName;}},
						{field:"clientBH",title: '申请金额（万元）',align: 'center',formatter: function (value, row, index) { return row.detailList[0].applySum;}},
						{field:"clientBH",title: '申请期限',align: 'center',formatter: function (value, row, index) { return row.detailList[0].periodMonthDay;}},
						{field:"clientBH",title: '合作机构',align: 'center',formatter: function (value, row, index) { return row.detailList[0].bankName;}},
						{field:"clientBH",title: '经办部门',align: 'center',formatter: function (value, row, index) { return row.departName;}},
						{field:"clientBH",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.createManName;}},
						{field:"clientBH",title: '受理日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.createDate);}},
						{field:"clientBH",title: '业务阶段',align: 'center',formatter: function (value, row, index) { return row.detailList[0].projectStageName;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_fundsDetail_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
										'<button class="btn_fundsDetail_deal btn btn-xs btn-pink" title="项目办理"><i class="icon-edit bigger-120"></i></button>'
										].join(''); 
							},
							events:{
								'click .btn_fundsDetail_view': function(e, value, row, index) {
									$.zjm_fundsDetail.viewFundsDetail(row);
								},
								'click .btn_fundsDetail_deal': function(e, value, row, index) {
									
								}
							}
						}
					],
			detailView: false,
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			soreName: "updateDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/credit/selectFundsDetailPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"parentApply_ID":$("#hidden_applyID").val()};
				$.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server"   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**
	 * 查看一条用款明细详情
	 */
	function viewFundsDetail(row){
		$("#fundsDetail_page").load("/project/credit/showFundsApplyViewPage",{"apply_ID":row.apply_ID},function(){
			$("#fundsDetailView").modal({keyboard:true});
		});
	}
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_fundsDetail.initTable();
	};
});


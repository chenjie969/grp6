(function($,z){
	$.zjm_downClient = {
		initColumn:initColumn,//初始化列，主要为了在&type='view'时实现修改和删除按钮的隐藏
		initTable:initTable,//初始化列表
		addDownClient:addDownClient,//新增下游客户	
		viewDownClient:viewDownClient,//查看下游客户	
		editDownClient:editDownClient,//修改下游客户	
		delDownClient:delDownClient//删除下游客户	
	};
	
	/**初始化列表项**/
	function initColumn(){
		var columns = [/*{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},*/
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:"contractPeriod",title: '合同期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.contractPeriod;}},
						{field:"customerName",title: '客户名',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.customerName;}},
						{field:"productName",title: '产品',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.productName;}},
						{field:"currentSum",title: '金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.currentSum;}},
					];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_downClient_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_downClient_edit btn btn-xs btn-info hideWhenView" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_downClient_del btn btn-xs btn-danger hideWhenView" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_downClient_view': function(e, value, row, index) {
									$.zjm_downClient.viewDownClient(row);
								},
								'click .btn_downClient_edit': function(e, value, row, index) {
									$.zjm_downClient.editDownClient(row);
								},
								'click .btn_downClient_del': function(e, value, row, index) {
									$.zjm_downClient.delDownClient(row);
								}
							}
						});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_downClient_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_downClient_view': function(e, value, row, index) {
									$.zjm_downClient.viewDownClient(row);
								}
							}
						});
		}
		return columns;
	}
	
	/**初始化列表***/
	function initTable(){
		$('#table_downClient').bootstrapTable('destroy');
		$('#table_downClient').bootstrapTable({
			method: 'post',
			columns: initColumn(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>合同期限：</b> ' + row.contractPeriod + '</p>');
			        html.push('<p><b>客户名：</b> ' + row.customerName + '</p>');
			        html.push('<p><b>产品：</b> ' + row.productName + '</p>');
			        html.push('<p><b>金额：</b> ' + row.currentSum + '万元</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: false,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/crm/upDownClient/selectUpDownClientPageTable",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition ={"client_ID":$("#client_ID").val(),"upDownFlag":"02"}; 
				$.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			/*search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
			showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'*/
		});
	}
	
	/**新增下游客户*/
	function addDownClient(){
		$("#companyBusiness_page").load("/crm/upDownClient/showDownClientAddPage",{},function(response,status,xhr){
			$("#add_downClient_form input[name='client_ID']").val($("#client_ID").val());
			$("#addDownClient").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_downClient_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_downClient_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/crm/upDownClient/insertOneUpDownClient',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#addDownClient").modal("hide");
								$.zjm_downClient.initTable();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addDownClient").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**查看下游客户*/
	function viewDownClient(row){
		$("#companyBusiness_page").load("/crm/upDownClient/showDownClientViewPage",{"upDownClient_ID":row.upDownClient_ID},function(response,status,xhr){
			$("#viewDownClient").modal({keyboard:true});
		});
	}
	
	/**修改下游客户*/
	function editDownClient(row){
		$("#companyBusiness_page").load("/crm/upDownClient/showDownClientEditPage",{"upDownClient_ID":row.upDownClient_ID},function(response,status,xhr){
			$("#editDownClient").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_downClient_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#edit_downClient_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/crm/upDownClient/updateOneUpDownClient',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#editDownClient").modal("hide");
								$.zjm_downClient.initTable();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editDownClient").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**删除下游客户*/
	function delDownClient(row){
		$("#companyBusiness_page").load("/crm/upDownClient/showDownClientDelPage",{},function(response,status,xhr){
			$("#delDownClient").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/crm/upDownClient/deleteOneUpDownClient',data:JSON.stringify({"upDownClient_ID":row.upDownClient_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delDownClient").modal("hide");
							$.zjm_downClient.initTable();
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delDownClient").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
})(jQuery, this);

$(function () {
	/**点击 下游销售客户情况 时执行*/
	$("#tab_companyBusiness a[href='#downClient']").click(function(){
		$.zjm_downClient.initTable();
	});
	
	$("#btn_addDownClient").click(function(){
		$.zjm_downClient.addDownClient();
	});
	
	$("#btn_refreshDownClient").click(function(){
		$.zjm_downClient.initTable();
	});
});


(function($,z){
	$.zjm_sign = {
			initTable:initTable,//初始化列表
			signed:signed,//签收
			view:view
	};
	/**初始化列表***/
	function initTable(){
		$("#sign-table").bootstrapTable('destroy');
		$('#sign-table').bootstrapTable({
			method: 'get',
			columns: [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return (index+1);}},
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"userGroupName",title: '流程模板名称',align: 'center',formatter: function (value, row, index) { return row.processTemplateName;}}, 
				{field:"userGroupName",title: '流程实例名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
				{field:"user_names",title: '流程发起人',align: 'center',formatter: function (value, row, index) { return row.initiatorName;}},
				{field:"user_names",title: '当前任务',align: 'center',formatter: function (value, row, index) { return row.taskName;}},
				//{field:"user_names",title: '分派人',align: 'center',formatter: function (value, row, index) { return row.user_names;}},
				{field:"user_names",title: '分派时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.taskBeginDate);}},
				{field:"userGroup_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
					if(row.suspensionState==1){
						return ['<button class="btn_viewSign btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>查看</button>',
							'<button class="btn_signed btn btn-xs btn-info" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i>签收</button>'].join('');
					}
					if(row.suspensionState==2){
						return ['<button class="btn_viewSign btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i>查看</button>'].join('');
					}
				},
				events:{
					'click .btn_viewSign': function(e, value, row, index) {
						$.zjm_sign.view(row);
					},
					'click .btn_signed': function(e, value, row, index) {
						$.zjm_sign.signed(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
					html.push('<p><b>项目组名称:</b> ' + row.userGroupName + '</p>');
					html.push('<p><b>项目组人员:</b> ' + row.user_names + '</p>');
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
				url: "/gbpm/processInstance/selectProcessTaskSignPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					// $.extend(params, {"queryCondition":{"mod_uid":nodeid}});
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

	/**签收*/
	function signed(row){
		$("#sign_page").load(
				"/gbpm/busiProcess/sign/signAffirm.jsp",{},function(response,status,xhr){
					$("#processDefinitionSign").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/gbpm/processInstance/createProcessTaskSign',data:JSON.stringify({"taskID":row.taskID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#processDefinitionSign").modal("hide");
								$('#sign-table').bootstrapTable('refresh');
							}else{
								alert("签收失败！");
								tool.undisabled(".btn_submit");
							}
						}
						});
					});
				}
		);
	}

	/**查看*/
	function view(row){
		window.parent.openMenu('edit_transact'+row.entityID,'','项目查看','/gbpm/processInstance/selectProcessTaskPageTablePage?entityID='+row.entityID+'&entityType='+row.entityType+'&entityName='+row.entityName);
	}
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_sign.initTable();
	};

	$("#btn_signed").click(function(){
		var e = $("input[name='btSelectItem']:checked");
		if(e.size() > 0){
			alert(123);
		}else{
			$("#pleaseSelect").modal({keyboard:true});
		}
	});

	/*$("#btn_noSign").click(function(){
		var e = $("input[name='btSelectItem']:checked");
		if(e.size() > 0){
			alert(123);
		}else{
			$("#pleaseSelect").modal({keyboard:true});
		}
	});*/
});


(function($,z){
	$.zjm_waitTask = {
			initTable:initTable,//初始化列表
			tasktransact:tasktransact,//办理
			entrusted:entrusted//委托
	};
	/**初始化列表***/
	function initTable(){
		$("#waitTask-table").bootstrapTable('destroy');
		$('#waitTask-table').bootstrapTable({
			method: 'get',
			columns: [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return (index+1);}},
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"flowTemplateName",title: '流程模板名称',align: 'center',formatter: function (value, row, index) { return row.flowTemplateName;}}, 
					{field:"entityName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.entityName;}},
					{field:"createFlowUserName",title: '流程发起人',align: 'center',formatter: function (value, row, index) { return row.createFlowUserName;}},
					{field:"stepName",title: '当前任务',align: 'center',formatter: function (value, row, index) { return row.stepName;}},
					{field:"waitFlowUserName",title: '当前办理人',align: 'center',formatter: function (value, row, index) { return row.waitFlowUserName;}},
					{field:"start_date",title: '分派时间',align: 'center',formatter: function (value, row, index) { return tool.parseDateDetail(row.start_date);}},
					{field:"userGroup_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
							return [
								'<button class="btn_tasktransact btn btn-xs btn-info" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i>办理</button>'].join('');
						},
						events:{
							'click .btn_tasktransact': function(e, value, row, index) {
								$.zjm_waitTask.tasktransact(row);
							},
							'click .btn_entrusted': function(e, value, row, index) {
								$.zjm_waitTask.entrusted(row);
							},
							'click .btn_view': function(e, value, row, index) {
							}
						}
					}],
			detailView: false,
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
			url: "/pendingWorkFlow/waitTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
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
	
	/**办理*/
	function tasktransact(row){
		window.parent.openMenu('osworkflow'+row.projectID,'','项目办理','/gworkFlow/tranPendingWorkFlow?projectID='+row.projectID+'&entityName='+row.entityName+'&flowType='+row.flowType+'&flowID='+row.flowID+'&stepID='+row.stepID+'&stepName='+row.stepName+'&historyID='+row.historyID);
	}
	
	
	/**委托*/
	function entrusted(row){
		$("#waitTask_page").load(
				"/gbpm/busiProcess/waitTask/taskEntrusted.jsp",{},function(response,status,xhr){
					$("#processDefinitionTaskEntrusted").modal({keyboard:true});
					$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						$("#select_user_tree").selectTreeWidgets({
							width : "93%",//设置控件宽度
							multiple : false,//是否多选
							data : data.obj//数据源
						});
					}
					});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#taskEntrusted_form").validationEngine("validate")){
							$.ajax({type:'POST',url:'/gbpm/processInstance/createProcessTaskTaskEntrusted',data:JSON.stringify({"taskID":row.taskID,"transactorID":$("#entrustedUserUid").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
									$("#processDefinitionTaskEntrusted").modal("hide");
									$('#waitTask-table').bootstrapTable('refresh');
								}else{
									alert("委托他人办理失败！");
									tool.undisabled(".btn_submit");
								}
							}
							});
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_waitTask.initTable();
	};

	$("#btn_signed").click(function(){
		var e = $("input[name='btSelectItem']:checked");
		if(e.size() == 1){
			alert(123);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
	/*
	$("#btn_noSign").click(function(){
		var e = $("input[name='btSelectItem']:checked");
		if(e.size() > 0){
			alert(123);
		}else{
			$("#pleaseSelect").modal({keyboard:true});
		}
	});*/
});


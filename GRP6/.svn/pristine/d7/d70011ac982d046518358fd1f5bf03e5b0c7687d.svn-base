(function($,z){
	$.zjm_processDefinitionDeploy = {
			initTable:initTable,//初始化列表
			processStart:processStart//
	};
	/**初始化列表***/
	function initTable(){
		$('#deploy-table').bootstrapTable({
			method: 'get',
			columns: [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
					{title: '流程模板名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.name;}}
					],
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
			url: "/gbpm/processDefinition/selectProcessDefinitionDeployPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: true,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	};
	/**流程启动**/
	function processStart(param,entityType){
		$("#processDefinition_page").load(
				"/gbpm/processDefinition/selectProcessDefinitionDeployListPage",{},function(response,status,xhr){
					$.zjm_processDefinitionDeploy.initTable();
					$("#processDefinitionDeployList").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						var selectContent = $("#deploy-table").bootstrapTable('getSelections');
						if(selectContent.length == 1){
							$.ajax({type:'POST',url:'/gbpm/processDefinition/createProcessDefinitionStart',data:JSON.stringify({"modelKey":selectContent[0].key,"entityID":param.apply_ID,"entityName":param.projectName,"entityType":entityType}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
									$("#processDefinitionDeployList").modal("hide");
									$('#post-table').bootstrapTable('refresh');
								}else{
									alert("启动流程失败！");
									tool.undisabled(".btn_submit");
								}
							}
							});
						}else{
							alert("请选择一个需要启动的流程");
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	};
})(jQuery, this);



$(function () {
	
	$("#btn_deployList_add").click(function(){
		var selectContent = $("#projectBeforeTracking-table").bootstrapTable('getSelections');
		if(selectContent.length == 1){
			$.zjm_processDefinitionDeploy.processStart(selectContent[0],"03");
		}else{
			alert("请选择一个需要启动的流程");
		}
	});
});


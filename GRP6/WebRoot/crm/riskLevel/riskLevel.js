(function($,z){
	$.zjm_riskLevelRec = {
			initTable:initTable,//初始化列表
			delRiskLevel:delRiskLevel,//删除风险等级
			initColumn:initColumn,
			initTable:initTable,
			addRiskLevel:addRiskLevel//增加一个风险等级
		   
	};
	var applyID = tool.getUrlParam("entityID");
	/**初始化列表项**/
	function initColumn(){
		var columns = [{field : "riskLevelName",title : '风险等级',align : 'center',formatter : function(value, rows, index) {return rows.riskLevelName;}},
						{field : "divisionName",title : '项目分类处置划分',align : 'center',formatter : function(value, rows, index) {return rows.divisionName;}},
					   {field : "changeDateTime",title : '评定日期',align : 'center',formatter : function(value, rows, index) {return tool.parseDate(rows.changeDateTime);}},
					   {field : "riskLevelIDDesc",title : '评定说明',align : 'center',formatter : function(value, rows, index) {return rows.riskLevelIDDesc;}},
					   ];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示删除按钮
			columns.push({title : '操作',align : 'center',formatter : function(value, rows, index) {
						return ['<a class="btn_RiskLevelff_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></a>'].join('');
							},
							events : {
								'click .btn_RiskLevelff_del' : function(e, value, rows, index) {
									$.zjm_riskLevelRec.delRiskLevel(rows);
								}											
							}
						});
		}
		return columns;
	};
	/**初始化列表***/
	function initTable(apply_ID){
		//alert("初始 化开户信息 列表============"+row.client_ID);
		$("#riskLevelRec_table").bootstrapTable('destroy');
		$('#riskLevelRec_table').bootstrapTable({
			method: 'get',
			columns : initColumn(),
			/*detailView: false,
			detailFormatter:function(index, rows){
			    var html = [];
			        html.push('<p><b>风险等级:</b> ' + rows.riskLevelName + '</p>');
			        html.push('<p><b>评定日期:</b> ' + rows.changeDateTime + '</p>');
			        html.push('<p><b>风险等级变更说明:</b> ' + rows.riskLevelIDDesc + '</p>');
			    return html;
			},*/
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		//	pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/crm/riskLevel/selectRiskLevelPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"apply_ID":apply_ID}});
				return params;
			},// queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			         
			});
		
		
		
	}
/*	*//**初始化列表***//*
	function initTable(apply_ID){
		$('#riskLevelRec_table').bootstrapTable('destroy');
		$('#riskLevelRec_table').bootstrapTable({
			method: 'post',
			columns: [	
				        {field:"riskLevelName",title: '风险等级',align: 'center',formatter: function (value, row, index) { return row.riskLevelName;}},
						{field:"changeDateTime",title: '评定日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.changeDateTime);}},
						{field:"riskLevelIDDesc",title: '风险等级变更说明',align: 'center',formatter: function (value, row, index) { return row.riskLevelIDDesc;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
						 return	['<a class="btn_RiskLevelff_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></a>'].join('');
						},
						events:{
							'click .btn_RiskLevelff_del': function(e, value, row, index) {
								$.zjm_riskLevelRec.delRiskLevel(row);
							}
						}
					}],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"changeDateTime",
			sortOrder: "DESC",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/crm/riskLevel/selectRiskLevelPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":apply_ID}});
				return params;
			},
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			//showColumns: true,     //是否显示所有的列
		//search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			//strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			
			//showRefresh: true,     //是否显示刷新按钮
			//minimumCountColumns: 2,    //最少允许的列数
			//clickToSelect: false,    //是否启用点击选中行
			//searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			//showToggle: true,//是否显示详细视图和列表视图的切换按钮
			//showPaginationSwitch:true,
           // showExport: true,                     //是否显示导出
            //exportDataType: "basic"              //basic', 'all', 'selected'
	});
	}*/
	/*添加*/
	function addRiskLevel(apply_ID){
		$("#riskLevel_page").load("/crm/riskLevel/showRiskLevelAdd",{"apply_ID":apply_ID},function(response,status,xhr){
					$("#AddRiskLevel").modal({keyboard:true});
					/*注册编辑验证引擎*/
					zjm.validata({formId:"AddRiskLevel_Form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#AddRiskLevel_Form").validationEngine("validate")){
							var queryContainer_form = $("#AddRiskLevel_Form");
								$.ajax({type:'POST',url:'/crm/riskLevel/insertOneRiskLevelRec',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
									success:function(data) {
							        	if(data.obj){
											$("#AddRiskLevel").modal("hide");
											$.zjm_riskLevelRec.initTable(apply_ID);
										}else{
											alert("保存失败！");
											tool.undisabled(".btn_submit");
										}
							        }
								});
							}else{
								tool.undisabled(".btn_submit");
							}
						$("#AddRiskLevel").on("hidden.bs.modal", function (e) {
							 $(".btn_submit").unbind("click");
						});
					});
				});
			}
	
	
	/**删除*/
	function delRiskLevel(row){
		$("#riskLevelDel").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			$.ajax({type:'POST',url:'/crm/riskLevel/deleteOneRiskLevelByID',data:JSON.stringify({"riskLevelRec_ID":row.riskLevelRec_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
						$("#riskLevelDel").modal("hide");
						window.location.reload();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
	}
	
})(jQuery, this);

$(function () {
	var apply_ID = tool.getUrlParam('apply_ID');
	$.zjm_riskLevelRec.initTable(apply_ID);
	$("#btn_addRiskLevelRec").click(function(){
		$.zjm_riskLevelRec.addRiskLevel(apply_ID);
	});
});


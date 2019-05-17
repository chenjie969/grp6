

$(function () {
	/**
	 * 文档加载的时候 读取 操作日志信息
	 */
	window.onload = function floaddata() {
		$.zjm_LogOperator.initTable();
	};
	
	// 按日期时间段查询日志 
	$("#search").click(function(){
		var operatordatetime=$("#id-date-range-picker-1").val();
		if(operatordatetime == null || operatordatetime == ''){
			alert("请选择查询时间");
			return ;
		}
		$.zjm_LogOperator.initTable(operatordatetime);
	})
	//清空日志  清空操作日志
	$("#clearAll").click(function(){
		$.zjm_LogOperator.delAllLogOperator(); 
	})
	
	// 重置列表
	$("#refresh").click(function(){
		$.zjm_LogOperator.initTable();
	})
	
}); //end  $(function)




(function($,z){
	$.zjm_LogOperator = {
			initTable:initTable,//初始化列表
			viewLogOperator:viewLogOperator,//操作日志查看
			delLogOperator:delLogOperator, //操作日志删除
			delAllLogOperator:delAllLogOperator ,// 删除全部操作日志
	};
	
	
	/**初始化列表***/
	function initTable(operatordatetime){
		$("#test-table").bootstrapTable('destroy');
		$('#test-table').bootstrapTable({
			method: 'post',
							columns : [
									{
										title : '序号',
										align : 'center',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : "unit_uidName",
										title : '机构名称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.unit_uidName;
										}
										
									},
									{
										field : "operatordatetime",
										title : '操作时间',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return tool.parseDateDetail(row.operatordatetime);
										}
									},
									{
										field : "username",
										title : '上机人姓名',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.username;
										}
									},
									{
										field : "departname",
										title : '上机部门名称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.departname;
										}
									},
									{
										field : "modname",
										title : '操作功能模块',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.modname;
										}
									},
									{
										field : "openratortype",
										title : '操作类型',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.openratortype;
										}
									},
									{
										field : "logdescr",
										title : '操作描述',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.logdescr;
										}
									},
									{
										field : "loginaccount",
										title : '登录帐号',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.loginaccount;
										}
									},
									{
										field : "ipaddress",
										title : 'ip地址',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.ipaddress;
										}
									},
									{   
										field : "logoperatorid",
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											return [
													'<button class="btn_LogOperators_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button class="btn_LogOperators_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' 
												   ]
													.join('');
										},
										events : {
											'click .btn_LogOperators_view' : function(e, value, row, index) {
												$.zjm_LogOperator.viewLogOperator(row);
											},
											
											'click .btn_LogOperators_del' : function(e, value, row, index) {
												$.zjm_LogOperator.delLogOperator(row);
											}
										}
									} ], //end columns
			detailView: true,
			detailFormatter:function(index, row){
				var time=tool.parseDateDetail(row.operatordatetime);
				//左侧 加号显示区域
			    var html = [];
			        html.push('<p><b>机构名称:</b> ' + row.unit_uidName + '</p>');
			        html.push('<p><b>操作时间:</b> ' + time + '</p>');
			        html.push('<p><b>上机人姓名:</b> ' + row.username + '</p>');
			        html.push('<p><b>上机部门名称:</b> ' + row.departname + '</p>');
			        html.push('<p><b>操作功能模块:</b> ' + row.modname + '</p>');
			        html.push('<p><b>操作描述:</b> ' + row.logdescr + '</p>');
			        html.push('<p><b>操作类型:</b> ' + row.openratortype + '</p>');
			        html.push('<p><b>登录账号:</b> ' + row.loginaccount + '</p>');
			        html.push('<p><b>ip地址:</b> ' + row.ipaddress + '</p>');
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
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/selectLogOperatorPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"operatordatetime":operatordatetime}});
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

	
	/***操作日志查看***/
	function viewLogOperator(row){
		$("#viewLogOperator").modal({keyboard:true});
		// zjm.dataViewText("view_","/selectOneModulesInfo",{"mod_uid":row.mod_uid});
		$.ajax({
			type : 'POST',
			url : "/selectOneLogOperatorInfo",
			data : JSON.stringify({"logoperatorid":row.logoperatorid}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$.each(data.obj, function(key, value) {
					var rt = $(".ztb_view_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('operatordatetime') > 0){
							var time =tool.parseDateDetail(value);
							$("#operatordatetime").text(time);
						}else{
							$(".ztb_view_"+ key).text(value);
						}
					}
				});
			}
		});
	}
	

	
	/**操作日志删除***/
	function delLogOperator(row){
		$("#delLogOperator").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteOneLogOperatorInfo',
				data : JSON.stringify({
					"logoperatorid" : row.logoperatorid
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$('#test-table').bootstrapTable('remove', {
							field : 'logoperatorid',
							values : [ row.logoperatorid ]
						});
						// $.zjm_LogOperator.initTree(row.pmod_uid);
						$("#delLogOperator").modal("hide");
					} else {
						alert("删除失败！");
					}
				}
			});
		});
		$("#delLogOperator").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	// 清空 操作日志 
	function delAllLogOperator(){
		$("#delAllLogOperator").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteAllLogOperator',
				data : JSON.stringify({ }),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						/*$('#test-table').bootstrapTable('remove', {
							field : 'logoperatorid',
							values : [ row.logoperatorid ]
						});*/
						$.zjm_LogOperator.initTable();
						$("#delAllLogOperator").modal("hide");
					} else {
						$.zjm_LogOperator.initTable();
						$("#delAllLogOperator").modal("hide");
						
					}
				}
			});
		});
		$("#delAllLogOperator").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}

})(jQuery, this);



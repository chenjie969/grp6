

$(function () {
	/**
	 * 文档加载的时候 读取 上机日志信息
	 */
	window.onload = function floaddata() {
		$.zjm_loginLog.initTable();
	};
	// 查询上机日志 
	$("#search").click(function(){
		var logindatetime=	$("#id-date-range-picker-1").val();
		if(logindatetime == null || logindatetime == ''){
			alert("请选择查询时间");
			return ;
		}
		$.zjm_loginLog.initTable(logindatetime);
	})
	
	//清空上机日志
	$("#cleanAll").click(function(){
		$.zjm_loginLog.delAllLoginLog();
	})
	
	//重置列表
	$("#refresh").click(function(){
		$.zjm_loginLog.initTable();
	})
	
}); //end  $(function)




(function($,z){
	$.zjm_loginLog = {
			initTable:initTable,//初始化列表
			viewloginLog:viewloginLog,//上机日志查看
			delloginLog:delloginLog, //上机日志删除
			delAllLoginLog:delAllLoginLog //删除全部上机日志
	};
	

	/**初始化 登录日志 列表***/
	function initTable(logindatetime){
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
										field : "unit_Uid",
										title : '机构名称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.unit_uidName;
										}
										
									},
									{
										field : "logindatetime",
										title : '上机时间',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return tool.parseDateDetail(row.logindatetime);
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
										field : "logtype",
										title : '操作类型',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.logtype;
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
										field:"logloginid",
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											return [
													'<button class="btn_loginLogs_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button class="btn_loginLogs_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' 
												   ]
													.join('');
										},
										events : {
											'click .btn_loginLogs_view' : function(e, value, row, index) {
												$.zjm_loginLog.viewloginLog(row);
											},
											
											'click .btn_loginLogs_del' : function(e, value, row, index) {
												$.zjm_loginLog.delloginLog(row);
											}
										}
									} ], //end columns
			detailView: true,
			detailFormatter:function(index, row){
				var time=tool.parseDateDetail(row.logindatetime);
				//左侧 加号显示区域
			    var html = [];
			        html.push('<p><b>机构名称:</b> ' + row.unit_uidName + '</p>');
			        html.push('<p><b>上机时间:</b> ' +  time + '</p>');
			        html.push('<p><b>上机人姓名:</b> ' + row.username + '</p>');
			        html.push('<p><b>上机部门名称:</b> ' + row.departname + '</p>');
			        html.push('<p><b>操作类型:</b> ' + row.logtype + '</p>');
			        html.push('<p><b>操作描述:</b> ' + row.logdescr + '</p>');
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
			url: "/selectLogLoginPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"logindatetime":logindatetime}});
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


	
	/***上机日志查看***/
	function viewloginLog(row){
		$("#viewloginLog").modal({keyboard:true});
	//	zjm.dataViewText("view_","/selectOneLogLoginInfo",{"logloginid":row.logloginid});
		$.ajax({
			type : 'POST',
			url : "/selectOneLogLoginInfo",
			data : JSON.stringify({"logloginid":row.logloginid}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$.each(data.obj, function(key, value) {
					var rt = $(".ztb_view_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('logindatetime') > 0){
							var time =tool.parseDateDetail(value);
							$("#logindatetime").text(time);
						}else{
							$(".ztb_view_"+ key).text(value);
						}
					}
				});
			}
		});
	}
	
	/**上机日志删除***/
	function delloginLog(row){
		$("#delloginLog").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteOneLogLoginInfo',
				data : JSON.stringify({
					"logloginid" : row.logloginid
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$('#test-table').bootstrapTable('remove', {
							field : 'logloginid',
							values : [ row.logloginid ]
						});
						$("#delloginLog").modal("hide");
					} else {
						alert("删除失败！");
					}
				}
			});
		});
		$("#delloginLog").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	//清空日志 删除全部日志
	function delAllLoginLog(){
		$("#delloginLogAll").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteAllLogLogin',
				data : JSON.stringify({}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$("#delloginLogAll").modal("hide");
						$.zjm_loginLog.initTable();//刷新列表
					} else {
						$("#delloginLogAll").modal("hide");
						$.zjm_loginLog.initTable();//刷新列表
					}
				}
			});
		});
		$("#delloginLogAll").on("hidden.bs.modal", function (e) {//解除模态窗事件绑定
			 $(".btn_submit").unbind("click");
		});
	}

})(jQuery, this);



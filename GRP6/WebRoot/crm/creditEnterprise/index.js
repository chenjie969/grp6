

$(function () {
	/**
	 * 文档加载的时候 读取 授信企业信息
	 */
	window.onload = function floaddata(id) {
	//	alert(id+"文档加载成功-----");
		$.zjm_creditEnterprise.initTree();
	};
	
	$("#btn_addCreditEnterprise").click(function(){
		$.zjm_creditEnterprise.addcreditEnterprise();
	})
	
	
}); //end  $(function)




(function($,z){
	$.zjm_creditEnterprise = {
			initTree:initTree,//加载树结构 ==》左侧
			loadInfo:loadInfo,//加载列表
			initTable:initTable,//初始化列表
			addcreditEnterprise:addcreditEnterprise,//授信企业添加
			viewcreditEnterprise:viewcreditEnterprise,//授信企业查看
	//		editcreditEnterprise:editcreditEnterprise,//授信企业修改
			delcreditEnterprise:delcreditEnterprise//授信企业删除
	};
	
	/**加载树结构*/
	function initTree(mod_uid){
		if(mod_uid==null){mod_uid=1;}
		$.zjm_creditEnterprise.loadInfo("/sys/log/operationLog/list.jsp",mod_uid);
	}
	
	
	/**加载事件*/
	function loadInfo(url,nodeid){  //初始化列表
		$("#loadinfo").load(url,function(){$.zjm_creditEnterprise.initTable(nodeid);});
	}
	/**初始化列表***/
	function initTable(nodeid){
		$('#test-table').bootstrapTable({
			method: 'get',
							columns : [
									{  
										field:'checked',checkbox:true, // 设置复选框 checkbox 
										title : '序号',
										align : 'center',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										/*field : "mod_name",
										title : '授信企业名称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.mod_name;
										}*/
										field : "unitUid",
										title : '客户简称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
										//	return row.unitUid;
											return "北京农但公司"+index+1;
										}
										
									},
									{
										field : "logindatetime",
										title : '授信生效日期',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
										//	return row.logindatetime;
											return "2017-04-"+(index+1);
										}
									},
									{
										field : "username",
										title : '授信失效日期	',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return "2018-04-"+(index+1);
										}
									},
									{
										field : "departname",
										title : '授信额度.万',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
										//	return row.departname;
											return "1000";
										}
									},
									{
										field : "logtype",
										title : '已用授信额度.万',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
										//	return row.logtype;
											return "600";
										}
									},
									{
										field : "联系手机",
										title : '可用授信额度.万',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
										//	return row.logdescr;
											return "400";
										}
									},
									{
										field : "loginaccount",
										title : '有无业务品种限制',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
										//	return row.loginaccount;
											if(index%2==0){
												return "有";
											}else{
												return  "无";
											}
										}
									},
									
							/*		{
										field : "loginaccount",
										title : '状态',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
										//	return row.loginaccount;
											return "admin"+(index+1);
										}
									},*/
									
									{
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											return [
													'<button class="btn_creditEnterprises_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
													'<button class="btn_creditEnterprises_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' 
												   ]
													.join('');
										},
										events : {
											'click .btn_creditEnterprises_view' : function(e, value, row, index) {
												$.zjm_creditEnterprise.viewcreditEnterprise(row);
											},
											
											'click .btn_creditEnterprises_del' : function(e, value, row, index) {
												$.zjm_creditEnterprise.delcreditEnterprise(row);
											}
										}
									} ], //end columns
			detailView: true,
			detailFormatter:function(index, row){
				//左侧 加号显示区域
			    var html = [];
			        html.push('<p><b>序号:</b> ' + index+1 + '</p>');
			        html.push('<p><b>担保机构编号:</b> ' + row.unitUid + '</p>');
			        html.push('<p><b>上机时间:</b> ' + row.logindatetime + '</p>');
			        html.push('<p><b>上机人姓名:</b> ' + row.username + '</p>');
			        html.push('<p><b>上机部门名称:</b> ' + row.departname + '</p>');
			        html.push('<p><b>操作类型:</b> ' + row.logtype + '</p>');
			        html.push('<p><b>操作描述:</b> ' + row.logdescr + '</p>');
			        html.push('<p><b>登录账号:</b> ' + row.loginaccount + '</p>');
			     //   html.push('<p><b>ip地址:</b> ' + row.ipaddress + '</p>');
			        html.push('<p><b>ip地址:</b> ' +"192.168.1."+index+1 + '</p>');
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
			url: "/selectModulesPageTables",//这个接口需要处理bootstrap table传递的固定参数
			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"mod_uid":nodeid}});
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


	/*授信企业 添加插入 */
	function addcreditEnterprise(id,name,ppnode){
		$("#addcreditEnterprise").modal({
			keyboard : true
		});
		$(".ztb_add_pmod_id").val(id);
		$(".ztb_add_up_mod_name").text(name);
		$(".ztb_add_mod_type").val(ppnode);
		$(".icon-picker").iconPicker("add_wraper");
		zjm.init();
		/*注册编辑验证引擎*/
		zjm.validata({formId:"add_form"});
		/* 提交 保存授信企业 */
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#add_form").validationEngine("validate")){
				if(zjm.ajaxValidata("add_mod_name","/selectAddcreditEnterprisesNameIsExist",{"mod_name":$("#add_mod_name").val()},"授信企业名称重复！")){
					var queryContainer_form = $("#add_form");
					$.ajax({type:'POST',url:'/insertOnecreditEnterprisesInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#addcreditEnterprise").modal("hide");
								$(".ztb_add").val("");
							//	$.zjm_creditEnterprise.initTree(id);
							}else{
								alert("保存失败！");
							}
				        }
					});
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addcreditEnterprise").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	
	/***授信企业查看***/
	function viewcreditEnterprise(row){
		$("#viewcreditEnterprise").modal({keyboard:true});
		zjm.dataViewText("view_","/selectOneModulesInfo",{"mod_uid":row.mod_uid});
	}
	
	/**授信企业删除***/
	function delcreditEnterprise(row){
		$("#delcreditEnterprise").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/deleteOneModulesInfo',data:JSON.stringify({"mod_uid":row.mod_uid}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#test-table').bootstrapTable('remove', {
							field: 'mod_uid',
							values: [row.mod_uid]
						});
						//$.zjm_creditEnterprise.initTree(row.pmod_uid);
						$("#delcreditEnterprise").modal("hide");
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#delcreditEnterprise").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}

})(jQuery, this);



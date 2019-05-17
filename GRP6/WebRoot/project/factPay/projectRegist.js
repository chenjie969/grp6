(function($,z){
	$.zjm_projectPayDelayOver = {
		initLoadTable:initLoadTable,//初始化-放款-列表
		initPayTable:initPayTable,//初始化-还款-列表
		initDelayTable:initDelayTable,//初始化-展期-列表	
		initReplaceTable:initReplaceTable,//初始化-代偿-列表	
		viewModule:viewModule,//查看项目详情；
		projectPayRegister:projectPayRegister,//还款登记；
		projectDelay:projectDelay,//展期登记
		projectOver:projectOver,//逾期确认
		projectReplace:projectReplace,//代偿登记
		delOneDelay:delOneDelay,//展期列表-单个删除;
	};
//	window.parent.openMenu('loan','','查看企业咨询情况','/crm/apply/showCrmApplyViewPage','&apply_ID='+row.apply_ID+'&clientType=01',0);
	
	/**初始化-放款-列表***/
	function initLoadTable(){
		
		$('#projectLoad_table').bootstrapTable('destroy');
		$('#projectLoad_table').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"projectCode",title: '项目编号',align:'center',formatter: function (value, row, index) { return row.projectCode}},
						{field:"projectName",title: '项目名称',align:'center',formatter: function (value, row, index) { return row.projectName}},
						{field:"bankName",title: '放款机构',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.busiTypeName}},
						{field:"loadSum",title: '担保金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.loadSum;}},
						{field:"guarantySum",title: '在保余额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.guarantySum;}},
						{field:"periodMonthDay",title: '担保期限',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.periodMonthDay;}},
						{field:"loadBeginDate",title: '起始日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.loadBeginDate);}},
						{field:"loadEndDate",title: '到期日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.loadEndDate);}},
						{field:"notYetEndDate",title: '距离到期天数',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.notYetEndDate;}},
						//{field:"",title: '状态',align: 'center',formatter: function (value, row, index) { return "在保";}},
//						{title: '操作',align: 'center',formatter:function(value,row,index){
//								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
//									'<button class="btn_creditApply_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
//									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
//							},
//							events:{
//								'click .btn_creditApply_view': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.viewModule(row);
//								},
//								'click .btn_creditApply_edit': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.projectPayRegister(row);
//								},
//								'click .btn_creditApply_del': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.delCreditApply(row);
//								}
//							}
//						}
					],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:  "delayBeginDate",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition ={"apply_ID":$("#apply_ID").val()}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/**初始化-还款-列表***/
	function initPayTable(){
		
		$('#projectPay_table').bootstrapTable('destroy');
		$('#projectPay_table').bootstrapTable({
			method: 'post',
			columns: [	
				        //{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"projectCode",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode}},
						{field:"projectName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.projectName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"bankName",title: '放款机构',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.bankName;}},
						{field:"paySum",title: '还款金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.paySum;}},
						{field:"payDate",title: '还款日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.payDate);}},
						{field:"payCapitalSum",title: '还款本金（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.payCapitalSum;}},
						{field:"payInterestSum",title: '还款利息（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.payInterestSum;}},
						{field:"payOtherSum",title: '还款其他（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.payOtherSum;}},
						{field:"remark",title: '备注',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.remark;}},
						
//						{title: '操作',align: 'center',formatter:function(value,row,index){
//								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
//									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
//							},
//							events:{
//								'click .btn_creditApply_view': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.viewModule(row);
//								},
//								'click .btn_creditApply_del': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.viewModule(row);
//								}
//							}
//						}
					],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"busiCode",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/factPay/selectFactPayTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"apply_ID":$("#apply_ID").val()}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/**初始化-展期-列表***/
	function initDelayTable(){
		$('#projectDelay_table').bootstrapTable('destroy');
		$('#projectDelay_table').bootstrapTable({
			method: 'post',
			columns: [	
				//{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"projectCode",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode}},
						{field:"projectName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.projectName;}},
						{field:"loadSum",title: '担保金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.loadSum;}},
						{field:"bankName",title: '放款机构',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.bankName;}},					
						{field:"delayContractCode",title: '展期合同号',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayContractCode;}},
						{field:"delaySum",title: '展期金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delaySum;}},
						{field:"delayBeginDate",title: '展期起始日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.delayBeginDate);}},
						{field:"delayEndDate",title: '展期到期日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.delayEndDate);}},
						{field:"delayRate",title: '展期担保费率（%）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayRate;}},
						{field:"delayServiceRate",title: '展期服务费率（‰）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayServiceRate;}},
						{field:"delayReason",title: '展期原因',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayReason;}},
						{field:"delayState",title: '审批状态',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayState;}},
//						{title: '操作',align: 'center',formatter:function(value,row,index){
//								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
//									'<button class="btn_creditApply_edit btn btn-xs btn-info" title="展期" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
//									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
//							},
//							events:{
//								'click .btn_creditApply_view': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.viewModule(row);
//								},
//								'click .btn_creditApply_edit': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.projectDelay(row);
//								},
//								'click .btn_creditApply_del': function(e, value, row, index) {
//									$.zjm_projectPayDelayOver.delOneDelay(row);
//								}
//							}
//						}
					],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"busiCode",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/delay/selectDelayTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition ={"apply_ID":$("#apply_ID").val()}; 
//				 var queryCondition ={"project_ID":$("#project_ID").val()}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	/**初始化-代偿-列表***/
	function initReplaceTable(){
		
		$('#projectReplace_table').bootstrapTable('destroy');
		$('#projectReplace_table').bootstrapTable({
			method: 'post',
			columns: [	
				//{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"projectCode",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode}},
						{field:"projectName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.projectName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"replaceSum",title: '代偿金额（万元）',align: 'center',formatter: function (value, row, index) { return row.replaceSum;}},
						{field:"replaceDate",title: '代偿日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.replaceDate);}},
						{field:"replaceCapitalSum",title: '代偿本金（万元）',align: 'center',formatter: function (value, row, index) { return row.replaceCapitalSum;}},
						{field:"replaceInterestSum",title: '代偿利息',align: 'center',formatter: function (value, row, index) { return row.replaceInterestSum;}},
						{field:"replaceOtherSum",title: '代偿其他',align: 'center',formatter: function (value, row, index) { return row.replaceOtherSum;}},
						{field:"dangerReplaceSum",title: '准备金冲抵',align: 'center',formatter: function (value, row, index) { return row.dangerReplaceSum;}},
						{field:"selfReplaceSum",title: '自有资金代偿',align: 'center',formatter: function (value, row, index) { return row.selfReplaceSum;}},
						
						],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"busiCode",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/Replace/selectReplacePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={"apply_ID":$("#apply_ID").val()}; 
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	
	
	 /***查看***/
	function viewModule(row){
		//window.parent.openMenu('viewApplyInfo'+row.apply_ID,'','查看申请登记','/project/apply/projectApplyViewPage','&type='+'view',1);
		
		$("#projectApply_page").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
		});
	}
	
	/***还款登记***/
	function projectPayRegister(row){
		var selectContent = $('#projectLoad_table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#projectLoad_table').bootstrapTable('getSelections')[0].project_ID;
			var apply_ID = $("#apply_ID").val();
			$("#projectPayLoadDelay_page").load("/project/factPay/returnProjectPayPage",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){				
				$("#projectPayPage").modal({keyboard:true});
				zjm.init();
				$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//设置还款日期默认值
				$("#project_ID").val(project_ID);
				
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#projectPay_form").validationEngine("validate")){
						$("#projectPayPage").modal("hide");
							var queryContainer_form = $("#projectPay_form");
							$.ajax({type:'POST',url:'/project/factPay/insertOneFactPay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==true){
									$("#projectPayPage").modal("hide");
									$.zjm_projectPayDelayOver.initLoadTable();
									$.zjm_projectPayDelayOver.initPayTable();
									$.zjm_projectPayDelayOver.initDelayTable();
									$.zjm_projectPayDelayOver.initReplaceTable();
								}else{
									alert("还款登记失败！");
								}
							}
							});
							
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#projectPayPage").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			})
		} 
	
		
		
	}
	/**展期登记*/
	function projectDelay(row){
		var selectContent = $('#projectLoad_table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#projectLoad_table').bootstrapTable('getSelections')[0].project_ID;
			var apply_ID = $("#apply_ID").val();
			$("#projectPayLoadDelay_page").load("/project/delay/returnProjectDelayPage",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){				
				$("#projectDelay").modal({keyboard:true});
				zjm.init();
				$("#project_ID").val(project_ID);
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#projectDelay_form").validationEngine("validate")){
						$("#projectDelay").modal("hide");
							var queryContainer_form = $("#projectDelay_form");
							$.ajax({type:'POST',url:'/project/delay/insertOneDelay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==true){
									$("#projectDelay").modal("hide");
									$.zjm_projectPayDelayOver.initLoadTable();
									$.zjm_projectPayDelayOver.initPayTable();
									$.zjm_projectPayDelayOver.initDelayTable();
									$.zjm_projectPayDelayOver.initReplaceTable();
								}else{
									alert("展期登记失败！");
								}
							}
							});
							
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#projectDelay").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			})
		} 
	}
	/**逾期确认*/
	function projectOver(row){
		var selectContent = $('#projectLoad_table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#projectLoad_table').bootstrapTable('getSelections')[0].apply_ID;
			var apply_ID = $("#apply_ID").val();
			$("#projectPayLoadDelay_page").load("/project/project/returnProjectOverPage",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){				
				$("#projectOver").modal({keyboard:true});
				zjm.init();
				$("#project_ID").val(project_ID);
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#projectOver_form").validationEngine("validate")){
						$("#projectOver").modal("hide");
							var queryContainer_form = $("#projectOver_form");
							$.ajax({type:'POST',url:'/project/project/insertOneProjectOver',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==true){
									$("#projectOver").modal("hide");
									$.zjm_projectPayDelayOver.initLoadTable();
									$.zjm_projectPayDelayOver.initPayTable();
									$.zjm_projectPayDelayOver.initDelayTable();	
									$.zjm_projectPayDelayOver.initReplaceTable();
								}else{
									alert("逾期确认失败！");
								}
							}
							});
							
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#projectOver").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			})
		} 
	}
	
	/**代偿登记*/
	function projectReplace(row){
		

		var selectContent = $('#projectLoad_table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var project_ID = $('#projectLoad_table').bootstrapTable('getSelections')[0].project_ID;
			var apply_ID = $("#apply_ID").val();
			$("#projectPayLoadDelay_page").load("/project/Replace/returnProjectReplacePage",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){				
				$("#projectReplace").modal({keyboard:true});
				zjm.init();
				$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//设置还款日期默认值
				$("#project_ID").val(project_ID);
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#projectReplace_form").validationEngine("validate")){
						$("#projectReplace").modal("hide");
							var queryContainer_form = $("#projectReplace_form");
							$.ajax({type:'POST',url:'/project/Replace/insertOneReplace',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==true){
									$("#projectReplace").modal("hide");
									$.zjm_projectPayDelayOver.initLoadTable();
									$.zjm_projectPayDelayOver.initPayTable();
									$.zjm_projectPayDelayOver.initDelayTable();	
									$.zjm_projectPayDelayOver.initReplaceTable();
								}else{
									alert("代偿登记失败！");
								}
							}
							});
							
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#projectReplace").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			})
		} 
	
	}
	
	/*展期列表单个删除*/
	function delOneDelay(row){		
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");//标题;
		$("#delMessage").text("确定要删除所选数据吗?");//提示信息;		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/delay/delOneDelay',data:JSON.stringify({"delay_ID":row.delay_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#projectDelay_table').bootstrapTable('remove', {
							field: 'delay_ID',
							values: [row.delay_ID]
						});
						$("#common_del").modal("hide");
						$.zjm_projectPayDelayOver.initLoadTable();
						$.zjm_projectPayDelayOver.initPayTable();
						$.zjm_projectPayDelayOver.initDelayTable();
						$.zjm_projectPayDelayOver.initReplaceTable();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	
	
	
})(jQuery, this);

$(function () {
		$.zjm_projectPayDelayOver.initLoadTable();
		$.zjm_projectPayDelayOver.initPayTable();
		$.zjm_projectPayDelayOver.initDelayTable();
		$.zjm_projectPayDelayOver.initReplaceTable();
		
		
		//还款登记
		$("#btn_projectPay").click(function(){
			$.zjm_projectPayDelayOver.projectPayRegister();
		});
		//展期登记
		$("#btn_projectDelay").click(function(){
			$.zjm_projectPayDelayOver.projectDelay();
		});
		//逾期确认并转风险处置
		$("#btn_projectOverThenToRisk").click(function(){
			$.zjm_projectPayDelayOver.projectOver();
		});
		//代偿登记
		$("#btn_projectReplace").click(function(){
			$.zjm_projectPayDelayOver.projectReplace();
		});
});


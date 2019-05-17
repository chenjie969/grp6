(function($,z){
	$.zjm_projectPayDelay = {
		initPayTable:initPayTable,//初始化-还款-列表
		initDelayTable:initDelayTable,//初始化-展期-列表	
		viewModule:viewModule,//查看项目详情；
		factPayRegister:factPayRegister,//还款登记；
		colseFactPayRegister:colseFactPayRegister,//关闭还款登记页面
		insertOneDelay:insertOneDelay,//展期登记
		colseInsertOneDelay:colseInsertOneDelay,//关闭展期登记页面
		insertOneOver:insertOneOver,//逾期确认
		colseInsertOneOver:colseInsertOneOver,//关闭逾期确认
		insertOneProjectLawsuit:insertOneProjectLawsuit,//项目诉讼登记
		colseOneLawsuit:colseOneLawsuit,//关闭项目诉讼登记
		insertAssetSealUp:insertAssetSealUp,//资产查封信息表
		colseInsertAssetSealUp:colseInsertAssetSealUp,//关闭资产清查信息表
		projectPayEdit:projectPayEdit,//还款列表修改
		projectDelayEdit:projectDelayEdit,//展期列表修改
		projectPayDel:projectPayDel,//还款列表删除;
		projectDelayDel:projectDelayDel,//展期列表-单个删除;
		rules : rules//页面验证规则
		
	};
//	window.parent.openMenu('loan','','查看企业咨询情况','/crm/apply/showCrmApplyViewPage','&apply_ID='+row.apply_ID+'&clientType=01',0);
	
	//页面验证规则
	function rules(){
		var allRules = {
				//新增页面----判断还款金额与 还款本金和还款利息和还款其他 之和 是否相等
				"validatePaySum":{
					"func":function(field,rules,i,options){
						var paySum=Number($("#paySum").val()); //还款金额
						var payCapitalSum=Number($("#payCapitalSum").val());//还款本金
						var payInterestSum=Number($("#payInterestSum").val())//还款利息;
						var payOtherSum=Number($("#payOtherSum").val());//还款其他
						var paySum2= Number(payCapitalSum+payInterestSum+payOtherSum);
						if(paySum == paySum2){
							return true;
						}else{
							return false;
						}
					},
					"alertText": "还款金额与(还款本金,还款利息,还款其他)合计不相等",
				     "alertTextOk": "可以使用"
				},
				//修改页面---判断还款金额与 还款本金和还款利息和还款其他 之和 是否相等
				"validateEditPaySum":{
					"func":function(field,rules,i,options){
						var paySum=Number($("#editPaySum").val()); //还款金额
						var payCapitalSum=Number($("#editPayCapitalSum").val());//还款本金
						var payInterestSum=Number($("#editPayInterestSum").val())//还款利息;
						var payOtherSum=Number($("#editPayOtherSum").val());//还款其他
						var paySum2= (payCapitalSum+payInterestSum+payOtherSum);
						if(paySum == paySum2){
							return true;
						}else{
							return false;
						}
					},
					"alertText": "还款金额与(还款本金,还款利息,还款其他)合计不相等",
					"alertTextOk": "可以使用"
				},
		};
		return allRules;
	
	}
	/**初始化-还款-列表***/
	function initPayTable(){
		
		$('#projectPay_table').bootstrapTable('destroy');
		$('#projectPay_table').bootstrapTable({
			method: 'post',
			columns: [	
				        //{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
//						{field:"projectCode",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode}},
//						{field:"projectName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.projectName;}},
//						{field:"busiTypeName",title: '业务品种',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.busiTypeName;}},
//						{field:"bankName",title: '放款机构',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.bankName;}},
						{field:"paySum",title: '还款金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.paySum;}},
						{field:"payDate",title: '上报日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.payDate);}},
						{field:"factDate",title: '还款日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.factDate);}},
						{field:"payCapitalSum",title: '还款本金（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.payCapitalSum;}},
						{field:"payInterestSum",title: '还款利息（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.payInterestSum;}},
						{field:"payOtherSum",title: '还款其他（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.payOtherSum;}},
						{field:"remark",title: '备注',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.remark;}},
						
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
									   '<button class="btn_projectPay_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
//									    '<button class="btn_projectPay_edit btn btn-xs btn-info"    href="javascript:void(0)" title="修改"  data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
//									'<button class="btn_projectPay_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'
									   
									    ].join('');
							},
							events:{
//								'click .btn_projectPay_edit': function(e, value, row, index) {
//									$.zjm_projectPayDelay.projectPayEdit(row);
//								},
//								'click .btn_projectPay_del': function(e, value, row, index) {
//									$.zjm_projectPayDelay.projectPayDel(row);
//								}
							}
						}
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
			sortName:"payDate",
			sortOrder: "desc",     //排序方式
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
//						{field:"projectCode",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode}},
//						{field:"projectName",title: '项目名称',align: 'center',formatter: function (value, row, index) { return row.projectName;}},
//						{field:"loadSum",title: '担保金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.loadSum;}},
//						{field:"bankName",title: '放款机构',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.bankName;}},					
						{field:"delaySum",title: '展期金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delaySum;}},
						{field:"delayBeginDate",title: '上报日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.delayBeginDate);}},
						{field:"factBeginDate",title: '展期起始日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.factBeginDate);}},
						{field:"delayEndDate",title: '展期到期日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.delayEndDate);}},
						{field:"delayMonthDay",title: '展期期限',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayMonthDay;}},
						{field:"delayRate",title: '展期担保（委贷）费率（%）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayRate;}},
						{field:"delayServiceRate",title: '展期服务费率（‰）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayServiceRate;}},
						{field:"delayReason",title: '展期原因',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayReason;}},
						//{field:"delayState",title: '审批状态',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayState;}},
//						{title: '操作',align: 'center',formatter:function(value,row,index){
//								return [
//									'<button class="btn_projectDelay_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>',
//									'<button class="btn_projectDelay_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"  ><i class="icon-trash bigger-120"></i></button>'].join('');
//							},
//							events:{
//								'click .btn_projectDelay_edit': function(e, value, row, index) {
//									$.zjm_projectPayDelay.projectDelayEdit(row);
//								},
//								'click .btn_projectDelay_del': function(e, value, row, index) {
//									$.zjm_projectPayDelay.projectDelayDel(row);
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
			sortName:"delayEndDate",
			sortOrder: "desc",     //排序方式
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
	
	
	
	 /***查看***/
	function viewModule(row){
		$("#projectApply_page").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
		});
	}
	
	/***还款登记***/
	function factPayRegister(){
		zjm.validata({
			formId:"factPay_form"
		});
		$.zjm.rules = $.zjm_projectPayDelay.rules();
		if($("#factPay_form").validationEngine("validate")){
				var queryContainer_form = $("#factPay_form");
				$.ajax({type:'POST',url:'/project/factPay/insertOneFactPay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==true){
						$("input:visible").val("");
						$("textarea").val("");
						window.location.reload();
					}else{
						alert("还款登记失败！");
					}
				}
				});
				
		}else{
			tool.undisabled(".btn_factPayRegister");
		}
	}
	/***新增展期***/
	function insertOneDelay(){
		if($("#projectDelayRgister_form").validationEngine("validate")){
			var queryContainer_form = $("#projectDelayRgister_form");
			$.ajax({type:'POST',url:'/project/delay/insertOneDelay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					$("input:visible").val("");
					$("textarea").val("");
					window.location.reload();
				}else{
					alert("展期登记失败！");
				}
			}
			});
			
		}else{
			tool.undisabled(".btn_insertOneDelay");
		}
	}
	/***逾期确认***/
	function insertOneOver(){
		if($("#projectOverRgister_form").validationEngine("validate")){
			var queryContainer_form = $("#projectOverRgister_form");
			$.ajax({type:'POST',url:'/project/project/insertOneProjectOver',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					$.zjm_projectPayDelay.colseInsertOneOver();
				}else{
					alert("逾期确认失败！");
				}
			}
			});
			
		}else{
			tool.undisabled(".btn_insertOneOver");
		}
	}
	
	/***项目诉讼登记***/
	function insertOneProjectLawsuit(){
		if($("#projectLawsuit_form").validationEngine("validate")){
			var queryContainer_form = $("#projectLawsuit_form");
			$.ajax({type:'POST',url:'/project/projectLawsuit/insertOrUpdateProjectLawsuit',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					window.location.reload();
				}else{
					alert("项目诉讼操作失败！");
				}
			}
			});
			
		}else{
			tool.undisabled(".btn_insertOneLawsuit");
		}
	}
	

	/***资产清查登记***/
	function insertAssetSealUp(){
		if($("#asserSealUp_form").validationEngine("validate")){
			var queryContainer_form = $("#asserSealUp_form");
			$.ajax({type:'POST',url:'/project/assetSealUp/insertOrUpdateOneSealUpInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
					window.location.reload();
				}else{
					alert("资产清查信息操作失败！");
				}
			}
			});
			
		}else{
			tool.undisabled(".btn_insertAssetSealUp");
		}
	}
	
	
	//关闭还款登记页面
	function colseFactPayRegister(){
		var project_ID = $("#project_ID").val();
		window.parent.closeMenu('openFactPayRegister'+project_ID);
	}
	//关闭逾期确认页面  
	function colseInsertOneOver(){
		var project_ID = $("#project_ID").val();
		window.parent.closeMenu('openProjectOverRegister'+project_ID);
	}
	//关闭项目诉讼页面  
	function colseOneLawsuit(){
		var project_ID = $("#project_ID").val();
		window.parent.closeMenu('openProjectLawsuit'+project_ID);
	}
	//关闭资产清查登记页面  
	function colseInsertAssetSealUp(){
		var project_ID = $("#project_ID").val();
		window.parent.closeMenu('openAssetSealUp'+project_ID);
	}
	//关闭展期 登记页面
	function colseInsertOneDelay(){
		var project_ID = $("#project_ID").val();
		window.parent.closeMenu('openProjectDelay'+project_ID);
	}
	//还款列表修改
	function projectPayEdit(row){
		    $("#projectFactPay_page").load("/project/factPay/returnProjectPayEditPage",{"factPay_ID":row.factPay_ID},function(response,status,xhr){				
			$("#projectPayEditPage").modal({keyboard:true});
			zjm.init();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				zjm.validata({
					formId:"projectPayEdit_form"
				});
				
				$.zjm.rules = $.zjm_projectPayDelay.rules();
				
				if($("#projectPayEdit_form").validationEngine("validate")){
					$("#projectPayEditPage").modal("hide");
						var queryContainer_form = $("#projectPayEdit_form");
						$.ajax({type:'POST',url:'/project/factPay/updateOneFactPay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==true){
								$("#projectPayEditPage").modal("hide");
								window.location.reload();
								$.zjm_projectPayDelay.initPayTable();
								$.zjm_projectPayDelay.initDelayTable();
							}else{
								alert("还款登记修改失败！");
							}
						}
						});
						
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#projectPayEditPage").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		})
	}
	//展期列表修改
	function projectDelayEdit(row){
		$("#projectDelay_page").load("/project/delay/returnProjectDelayEditPage",{"delay_ID":row.delay_ID},function(response,status,xhr){				
			$("#projectDelayEditPage").modal({keyboard:true});
			zjm.init();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				zjm.validata({
					formId:"projectDelayEdit_form"
				});
				
				if($("#projectDelayEdit_form").validationEngine("validate")){
					//$("#projectDelayEditPage").modal("hide");
						var queryContainer_form = $("#projectDelayEdit_form");
						$.ajax({type:'POST',url:'/project/delay/updateOneDelay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==true){
								$("#projectDelayEditPage").modal("hide");
								window.location.reload();
								$.zjm_projectPayDelay.initPayTable();
								$.zjm_projectPayDelay.initDelayTable();
							}else{
								alert("展期登记修改失败！");
							}
						}
						});
						
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#projectDelayEditPage").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	
	}
	//还款登记列表删除
	function projectPayDel(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");//标题;
		$("#delMessage").text("确定要删除所选数据吗?");//提示信息;		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/factPay/delOneFactPay',data:JSON.stringify({"factPay_ID":row.factPay_ID,"project_ID":row.project_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#projectPay_table').bootstrapTable('remove', {
							field: 'factPay_ID',
							values: [row.factPay_ID]
						});
						$("#common_del").modal("hide");
						$.zjm_projectPayDelay.initPayTable();
						$.zjm_projectPayDelay.initDelayTable();
						
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	
	//展期列表-单个删除;
	function projectDelayDel(row){
		$("#projectDelay_page").load("/common_del.jsp",{},function(response,status,xhr){
			$("#common_del").modal({keyboard:true});
			$("#delModalLabel").text("删除");//标题;
			$("#delMessage").text("确定要删除所选数据吗?");//提示信息;		
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/delay/delOneDelayRT',data:JSON.stringify({"delay_ID":row.delay_ID,"project_ID":row.project_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==true){
							$('#projectDelay_table').bootstrapTable('remove', {
								field: 'delay_ID',
								values: [row.delay_ID]
							});
							$("#common_del").modal("hide");
							$.zjm_projectPayDelay.initPayTable();
							$.zjm_projectPayDelay.initDelayTable();
						}else{
							alert("删除失败！");
						}
			        }
				});
			});
			
			$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
		
		
	
	}
	
})(jQuery, this);

$(function () {
	
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		$('#payDate').attr("value",tool.parseDate(new Date().getTime()));//设置上报日期默认值
		$('#factDate').attr("value",tool.parseDate(new Date().getTime()));//设置还款日期默认值
		
	
		$.zjm_projectPayDelay.initPayTable();
		$.zjm_projectPayDelay.initDelayTable();
		//还款登记
		$("#btn_factPayRegister").click(function(){
			$.zjm_projectPayDelay.factPayRegister();
		});
		
		//新增展期
		$("#btn_insertOneDelay").click(function(){
			$.zjm_projectPayDelay.insertOneDelay();
		});
		//关闭新增展期页面
		$("#btn_closeOneDelay").click(function(){
			$.zjm_projectPayDelay.colseInsertOneDelay();
		});
		
		//关闭还款登记
		$(".btn_colse").click(function(){
			$.zjm_projectPayDelay.colseFactPayRegister();
		});
		//关闭逾期确认登记
		$("#btn_colseInsertOneOver").click(function(){
			$.zjm_projectPayDelay.colseInsertOneOver();
		});
		
		
		//逾期确认 
		$("#btn_insertOneOver").click(function(){
			$.zjm_projectPayDelay.insertOneOver();
		});
		//项目诉讼登记
		$("#btn_insertOneLawsuit").click(function(){
			$.zjm_projectPayDelay.insertOneProjectLawsuit();
		});
		
		//关闭项目诉讼登记
		$("#btn_colseOneLawsuit").click(function(){
			$.zjm_projectPayDelay.colseOneLawsuit();
		});
		//资产清查登记
		$("#btn_insertAssetSealUp").click(function(){
			$.zjm_projectPayDelay.insertAssetSealUp();
		});
		
		//关闭资产清查登记
		$("#btn_colseInsertAssetSealUp").click(function(){
			$.zjm_projectPayDelay.colseInsertAssetSealUp();
		});
		
		
		
});


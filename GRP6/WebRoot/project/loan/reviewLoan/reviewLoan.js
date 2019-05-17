(function($,z){
	$.zjm_reviewLoan = {
		initApproveGuaranteeTable:initApproveGuaranteeTable,//初始化评审会批准情况列表
		initPlanLoanTable:initPlanLoanTable,	//初始化放款计划列表
		initPlanPayTable:initPlanPayTable,	//初始化计划还款列表
		initMeetingCostTable:initMeetingCostTable,	//初始化评审会批准收费标准列表
		initCostMustTable:initCostMustTable,	//初始化应收费用列表
		initFactLoanTable:initFactLoanTable,	//实际放款情况
		
		confirmLoan:confirmLoan,	//确认放款
	};
//	window.parent.openMenu('loan','','查看企业咨询情况','/crm/apply/showCrmApplyViewPage','&apply_ID='+row.apply_ID+'&clientType=01',0);
	
	var applyID = $("#hidden_applyID").val();
	
	/**初始化评审会批准担保情况列表**/
	function initApproveGuaranteeTable(){
		$('#table_approveGuarantee').bootstrapTable('destroy');
		$('#table_approveGuarantee').bootstrapTable({
			method: 'post',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) {return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index){return row.busiTypeName;}},
						{field:"applySum",title: '申请金额（万元）',align: 'center',formatter: function (value, row, index){return row.applySum;}},
						{field:"agreeSum",title: '同意金额（万元）',align: 'center',formatter: function (value, row, index){return row.agreeSum;}},
						{field:"agreeMonthDay",title: '同意期限',align: 'center',formatter: function (value, row, index){return row.agreeMonthDay;}},
						{field:"guarantyScope",title: '担保责任范围',align: 'center',formatter: function (value, row, index){return row.guarantyScope;}},
						{field:"guarantyScale",title: '担保责任比例（%）',align: 'center',formatter: function (value, row, index){return row.guarantyScale;}}
					  ],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/apply/selectProApplyDetailList",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化计划放款列表**/
	function initPlanLoanTable(){
		$('#table_planLoan').bootstrapTable('destroy');
		$('#table_planLoan').bootstrapTable({
			method: 'post',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) {return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index){return row.busiTypeName;}},
						{field:"applySum",title: '计划放款日期',align: 'center',formatter: function (value, row, index){return tool.parseDate(row.loanDate);}},
						{field:"agreeSum",title: '计划放款金额（万元）',align: 'center',formatter: function (value, row, index){return row.loanSum;}},
						{field:"loanState",title: '放款状态',align: 'center',formatter: function (value, row, index){return row.loanState;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								if(row.loanState=="未放款" && $("#openType").val()=="edit"){
									return "<a href='#' class='btn_reviewLoan_confirm'>已放款确认</a>";
								}
							},
							events:{
								'click .btn_reviewLoan_confirm': function(e, value, row, index) {
									$.zjm_reviewLoan.confirmLoan(row);
								},
							}
						}
					 ],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/loan/selectPlanLoanPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化计划还款列表**/
	function initPlanPayTable(){
		$('#table_planPay').bootstrapTable('destroy');
		$('#table_planPay').bootstrapTable({
			method: 'post',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) {return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index){return row.busiTypeName;}},
						{field:"applySum",title: '计划还款日期',align: 'center',formatter: function (value, row, index){return tool.parseDate(row.planPayDate);}},
						{field:"agreeSum",title: '计划还款金额（万元）',align: 'center',formatter: function (value, row, index){return row.planPaySum;}},
						{field:"loanState",title: '还款状态',align: 'center',formatter: function (value, row, index){return row.payStatus;}},
						/*{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_planLoan_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_planLoan_delete btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_planLoan_edit': function(e, value, row, index) {
									$.zjm_planLoan.editPlanPay(row);
								},
								'click .btn_planLoan_delete': function(e, value, row, index) {
									$.zjm_planLoan.deletePlanPay(row);
								}
							}
						}*/
					 ],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/planPay/selectPlanPayPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化评审会批准收费标准列表***/
	function initMeetingCostTable(){
		$('#table_meetingCost').bootstrapTable('destroy');
		$('#table_meetingCost').bootstrapTable({
			method: 'post',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"costTypeName",title: '费用类型',align: 'center',formatter: function (value, row, index){return row.costTypeName;}},
						{field:"costRate",title: '费率',align: 'center',formatter: function (value, row, index) { return row.costRate+"&nbsp;"+row.costUnit;}},
						{field:"culate",title: '计算规则',align: 'center',formatter: function (value, row, index) { return row.culate;}},			
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index){return row.remark;}}
					 ],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/pro/meetingResolution/selectMeetingCostPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'',//默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化应收费用列表***/
	function initCostMustTable(){
		$('#table_costMust').bootstrapTable('destroy');
		$('#table_costMust').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"agreeSum",title: '担保金额（万元）',align: 'center',formatter: function (value, row, index) { return row.agreeSum;}},
						{field:"costTypeName",title: '费用类型',align: 'center',formatter: function (value, row, index) { return row.costStandard.costTypeName;}},
						{field:"calculateRate",title: '费率（%）',align: 'center',formatter: function (value, row, index) { return row.costStandard.costRate+row.costStandard.costUnit;}},
						{field:"mustCostSum",title: '应收费用（元）',align: 'center',formatter: function (value, row, index) { return row.mustCostSum;}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark;}},
						/*{title: '操作',align: 'center',formatter:function(value,row,index){
								return [//'<button class="btn_planLoan_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_costMust_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_costMust_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_costMust_edit': function(e, value, row, index) {
									$.zjm_planLoan.editCostMust(row);
								},
								'click .btn_costMust_del': function(e, value, row, index) {
									$.zjm_planLoan.delCostMust(row);
								}
							}
						}*/
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/cost/selectCostMustPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化实际放款列表***/
	function initFactLoanTable(){
		$('#table_factLoan').bootstrapTable('destroy');
		$('#table_factLoan').bootstrapTable({
			method: 'post',
			columns: [	//{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
//						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"projectCode",title: '项目编号',align: 'center',formatter: function (value, row, index) { return row.projectCode;}},
						{field:"",title: '笔',align: 'center',formatter: function (value, row, index) { return "第"+(index+1)+"笔";}},
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"loadSum",title: '放款金额（万元）',align: 'center',formatter: function (value, row, index) { return row.loadSum;}},
						{field:"loadBeginDate",title: '担保起始日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.loadBeginDate);}},
						{field:"loadEndDate",title: '担保到期日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.loadEndDate);}},
						{field:"billBeginDate",title: '借据起始日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.billBeginDate);}},
						{field:"billEndDate",title: '借据到期日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.billEndDate);}},
						{field:"",title: '状态',align: 'center',formatter: function (value, row, index) { return "在保中";}},
						/*{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_creditApply_del': function(e, value, row, index) {
									$.zjm_reviewLoan.delCreditApply(row.apply_ID);
								}
							}
						}*/
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:  "delayBeginDate",
			sortOrder: "asc",     //排序方式
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**
	 * 确认放款
	 */	
	function confirmLoan(row){
		$("#reviewLoan_page").load("/project/loan/showConfirmLoanPage",{"loanPlan_ID":row.loanPlan_ID},function(response,status,xhr){
			$("#confirmLoan").modal({keyboard:true});
			/*获取合作机构下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectBankSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectBank").selectTreeWidgets({
						width : "87%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_confirmLoan"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if(0==$('input:radio[name="isCreditor"]:checked').val()){
					$("#div_isCreditor").empty();
				}
				var queryContainer_form = $("#form_confirmLoan");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/project/insertOneProjectInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#confirmLoan").modal("hide");
								$.zjm_reviewLoan.initPlanLoanTable();
								$.zjm_reviewLoan.initFactLoanTable();
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
			$("#confirmLoan").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);

$(function () {
	$.zjm_reviewLoan.initApproveGuaranteeTable();
	$.zjm_reviewLoan.initPlanLoanTable();
	$.zjm_reviewLoan.initPlanPayTable();
	$.zjm_reviewLoan.initMeetingCostTable();
	$.zjm_reviewLoan.initCostMustTable();
	$.zjm_reviewLoan.initFactLoanTable();
});


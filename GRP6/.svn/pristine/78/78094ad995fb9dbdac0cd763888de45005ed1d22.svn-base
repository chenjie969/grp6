(function($,z){
	$.zjm_planLoan = {
		initApproveGuaranteeTable:initApproveGuaranteeTable,//初始化评审会批准担保情况列表
		initPlanLoanTable:initPlanLoanTable,//初始化计划放款列表
		initPlanPayTable:initPlanPayTable,	//初始化计划还款列表
		initMeetingCostTable:initMeetingCostTable,	//初始化评审会批准收费标准列表
		initCostMustTable:initCostMustTable,	//初始化应收费用列表
		
		addPlanLoan:addPlanLoan,	//计划放款
		editPlanLoan:editPlanLoan,
		deletePlanLoan:deletePlanLoan,
		
		addPlanPay:addPlanPay,		//计划还款
		editPlanPay:editPlanPay,
		deletePlanPay:deletePlanPay,
		
		autoCalcuCostMust:autoCalcuCostMust,	//自动计算应收费用
		editCostMust:editCostMust,
		delCostMust:delCostMust,
	};
	
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
						{field:"guarantyScale",title: '担保责任比例（%）',align: 'center',formatter: function (value, row, index){return row.guarantyScale;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								if($("#openType").val()=="edit"){
									return '<a href="JavaScript:void(0)" class="btn_mustCost_autoCalcu">自动计算并生成应收费用</a>';
								}
							},
							events:{
								'click .btn_mustCost_autoCalcu': function(e, value, row, index) {
									$.zjm_planLoan.autoCalcuCostMust(row);
								}
							}
						}
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
								if($("#openType").val()=="edit"){
									return ['<button class="btn_planLoan_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改"><i class="icon-pencil bigger-120"></i></button>',
										'<button class="btn_planLoan_delete btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
								}
							},
							events:{
								'click .btn_planLoan_edit': function(e, value, row, index) {
									$.zjm_planLoan.editPlanLoan(row);
								},
								'click .btn_planLoan_delete': function(e, value, row, index) {
									$.zjm_planLoan.deletePlanLoan(row);
								}
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
		$('#table_planRepay').bootstrapTable('destroy');
		$('#table_planRepay').bootstrapTable({
			method: 'post',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) {return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index){return row.busiTypeName;}},
						{field:"applySum",title: '计划还款日期',align: 'center',formatter: function (value, row, index){return tool.parseDate(row.planPayDate);}},
						{field:"agreeSum",title: '计划还款金额（万元）',align: 'center',formatter: function (value, row, index){return row.planPaySum;}},
						{field:"loanState",title: '还款状态',align: 'center',formatter: function (value, row, index){return row.payStatus;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								if($("#openType").val()=="edit"){
									return ['<button class="btn_planLoan_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改"><i class="icon-pencil bigger-120"></i></button>',
										'<button class="btn_planLoan_delete btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
								}
							},
							events:{
								'click .btn_planLoan_edit': function(e, value, row, index) {
									$.zjm_planLoan.editPlanPay(row);
								},
								'click .btn_planLoan_delete': function(e, value, row, index) {
									$.zjm_planLoan.deletePlanPay(row);
								}
							}
						}
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
						{title: '操作',align: 'center',formatter:function(value,row,index){
								if($("#openType").val()=="edit"){
									return [//'<button class="btn_planLoan_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
										'<button class="btn_costMust_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)"><i class="icon-pencil bigger-120"></i></button>',
										'<button class="btn_costMust_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
								}
							},
							events:{
								'click .btn_costMust_edit': function(e, value, row, index) {
									$.zjm_planLoan.editCostMust(row);
								},
								'click .btn_costMust_del': function(e, value, row, index) {
									$.zjm_planLoan.delCostMust(row);
								}
							}
						}
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
	
	/**
	 * 删除应收费用
	 */
	function delCostMust(row){
		$("#planLoan_page").load("/project/cost/showCostMustDelPage",{},function(response,status,xhr){
			$("#costMustDel").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/cost/deleteOneCostMust',data:JSON.stringify({"costMust_ID":row.costMust_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
			        	if(data.obj){
							$("#costMustDel").modal("hide");
							$.zjm_planLoan.initCostMustTable();
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#costMustDel").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 修改应收费用
	 */
	function editCostMust(row){
		$("#planLoan_page").load("/project/cost/showCostMustEditPage",{"costMust_ID":row.costMust_ID},function(response,status,xhr){
			$("#costMustEdit").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_costMustEdit"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_costMustEdit");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/cost/updateOneCostMust',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#costMustEdit").modal("hide");
								$.zjm_planLoan.initCostMustTable();
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
			$("#costMustEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 自动计算应收费用 
	 */
	function autoCalcuCostMust(row){
		var applyDetail = {
			"apply_ID":row.apply_ID,
			"applyDetail_ID":row.applyDetail_ID,
			"agreeSum":row.agreeSum,
			"agreeMonth":row.agreeMonth,
			"agreeDay":row.agreeDay,
			"agreeMonthDay":row.agreeMonthDay
		}
		$.ajax({type:'POST',url:'/project/cost/autoCalculateCostMust',data:JSON.stringify(applyDetail),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {
	        	if(data.obj){
	        		$("#succeedMessage").modal({keyboard:true});
					setTimeout(function(){
						$("#succeedMessage").modal("hide");
					},3000);
					$.zjm_planLoan.initCostMustTable();
				}else{
					alert("保存失败！");
					tool.undisabled(".btn_submit"); 
				}
			}
		});
	}
	
	/**
	 * 删除放款计划 
	 */
	function deletePlanLoan(row){
		$("#planLoan_page").load("/project/loan/showLoanPlanDelPage",{"loanPlan_ID":row.loanPlan_ID},function(response,status,xhr){
			$("#planLoanDel").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/loan/deleteOnePlanLoan',data:JSON.stringify({"loanPlan_ID":row.loanPlan_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
			        	if(data.obj){
							$("#planLoanDel").modal("hide");
							$.zjm_planLoan.initPlanLoanTable();
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#planLoanDel").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 修改放款计划 
	 */
	function editPlanLoan(row){
		$("#planLoan_page").load("/project/loan/showLoanPlanEditPage",{"loanPlan_ID":row.loanPlan_ID},function(response,status,xhr){
			$("#planLoanEdit").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_planLoanEdit"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_planLoanEdit");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("updateLoanSum","/project/loan/isMoreThanAgreeSum",JSON.stringify(queryContainer_form.serializeJson()),"放款总金额不能超过评审会同意金额")){
						$.ajax({type:'POST',url:'/project/loan/updateOnePlanLoan',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
							success:function(data) {
					        	if(data.obj){
									$("#planLoanEdit").modal("hide");
									$.zjm_planLoan.initPlanLoanTable();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
							}
						});
					}else{
						tool.undisabled(".btn_submit");
					}
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#planLoanEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 新增放款计划 
	 */
	function addPlanLoan(){
		$("#planLoan_page").load("/project/loan/showLoanPlanAddPage",{"applyID":applyID},function(response,status,xhr){
			$("#planLoanAdd").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_planLoanAdd"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_planLoanAdd");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("addLoanSum","/project/loan/isMoreThanAgreeSum",JSON.stringify(queryContainer_form.serializeJson()),"放款总金额不能超过评审会同意金额")){
						$.ajax({type:'POST',url:'/project/loan/insertOnePlanLoan',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
							success:function(data) {
					        	if(data.obj){
									$("#planLoanAdd").modal("hide");
									$.zjm_planLoan.initPlanLoanTable();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
							}
						});
					}else{
						tool.undisabled(".btn_submit");
					}	
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#planLoanAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 删除还款计划 
	 */
	function deletePlanPay(row){
		$("#planLoan_page").load("/project/planPay/showPlanPayDelPage",{"loanPlan_ID":row.loanPlan_ID},function(response,status,xhr){
			$("#planPayDel").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/planPay/deleteOnePlanPay',data:JSON.stringify({"planPay_ID":row.planPay_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
			        	if(data.obj){
							$("#planPayDel").modal("hide");
							$.zjm_planLoan.initPlanPayTable();
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#planPayDel").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 修改还款计划 
	 */
	function editPlanPay(row){
		$("#planLoan_page").load("/project/planPay/showPlanPayEditPage",{"planPay_ID":row.planPay_ID},function(response,status,xhr){
			$("#planPayEdit").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_planPayEdit"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_planPayEdit");
				if($(queryContainer_form).validationEngine("validate")){
//					if(zjm.ajaxValidata("updateLoanSum","/project/loan/isMoreThanAgreeSum",JSON.stringify(queryContainer_form.serializeJson()),"放款总金额不能超过评审会同意金额")){
						$.ajax({type:'POST',url:'/project/planPay/updateOnePlanPay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
							success:function(data) {
					        	if(data.obj){
									$("#planPayEdit").modal("hide");
									$.zjm_planLoan.initPlanPayTable();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
							}
						});
//					}else{
//						tool.undisabled(".btn_submit");
//					}
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#planPayEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 新增还款计划 
	 */
	function addPlanPay(){
		$("#planLoan_page").load("/project/planPay/showPlanPayAddPage",{"applyID":applyID},function(response,status,xhr){
			$("#planPayAdd").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_planPayAdd"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_planPayAdd");
				if($(queryContainer_form).validationEngine("validate")){
//					if(zjm.ajaxValidata("addLoanSum","/project/loan/isMoreThanAgreeSum",JSON.stringify(queryContainer_form.serializeJson()),"放款总金额不能超过评审会同意金额")){
						$.ajax({type:'POST',url:'/project/planPay/insertOnePlanPay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
							success:function(data) {
					        	if(data.obj){
									$("#planPayAdd").modal("hide");
									$.zjm_planLoan.initPlanPayTable();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
							}
						});
//					}else{
//						tool.undisabled(".btn_submit");
//					}	
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#planPayAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);

$(function () {
	
	var applyID = $("#hidden_applyID").val();
	
	$.zjm_planLoan.initApproveGuaranteeTable();
	$.zjm_planLoan.initPlanLoanTable();
	$.zjm_planLoan.initPlanPayTable();
	$.zjm_planLoan.initMeetingCostTable();
	$.zjm_planLoan.initCostMustTable();
	
	/**添加计划放款**/
	$("#btn_addPlanLoan").click(function(){
		$.zjm_planLoan.addPlanLoan();
	});

	/**添加计划还款**/
	$("#btn_addPlanRepay").click(function(){
		$.zjm_planLoan.addPlanPay();
	});
	
	$("#btn_addMustCost").click(function(){
		$("#mustCostAdd").modal({keyboard:true});
	});
	
});


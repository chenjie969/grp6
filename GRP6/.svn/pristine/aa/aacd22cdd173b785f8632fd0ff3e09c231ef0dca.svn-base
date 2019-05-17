(function($,z){
	$.zjm_costRecord = {
		initCostMustTable:initCostMustTable,	//初始化应收费用列表
		initCostDelayTable:initCostDelayTable,	//初始化缓收费用列表
		initCostPreTable:initCostPreTable,		//初始化预收费用列表
		initCostReturnTable:initCostReturnTable,//初始化退费列表
		initCostFactTable:initCostFactTable,	//初始化实收费用列表
		
		costRules:costRules,	
		//costMustToDelay:costMustToDelay,	//应收转缓收
		//costDelayToPre:costDelayToPre,		//缓收转预收	
		//costPreToFact:costPreToFact,		//预收转实收
		//costPreToReturn:costPreToReturn,	//预收转退费
		
		
		costMustToPre:costMustToPre,//到账确认--应收转预收
		
	};
	
	var applyID = $("#hidden_applyID").val();
	
	var loanPlan_ID = $("#loanPlan_ID").val();//计划放款表id
	
	
	/**初始化列表项**/
	function initCostMustColumn(){
		var columns = [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"costName",title: '费用类型',align: 'center',formatter: function (value, row, index) { return row.costName;}},
						{field:"costRate",title: '费率',align: 'center',formatter: function (value, row, index) { return row.costRate;}},
						{field:"mustCostSum",title: '应收金额（元）',align: 'center',formatter: function (value, row, index) { return row.mustCostSum;}},
						{field:"costMustState",title: '状态',align: 'center',formatter: function (value, row, index) { return row.costMustState;}},
						
					];
			//var type = tool.getUrlParam('type');//获取路径类型:查看/修改
			if("edit"==$("#openType").val()){		//&type='edit'显示查看、修改、删除按钮
				
				columns.push({title: '操作',align: 'center',formatter:function(value,row,index){
								
								if("未收到" == row.costMustState){
									return [
										'<a href="javascript:void(0) " class="btn_confirmationCostMust">到账确认</a>'].join('&nbsp;&nbsp;&nbsp;');
								}else{
									return [
										'<span  class="light-gery"  href="javascript:void(0) " class="">到账确认</span>'].join('&nbsp;&nbsp;&nbsp;');
								}
				             },
								events:{
									'click .btn_confirmationCostMust': function(e, value, row, index) {
										$.zjm_costRecord.costMustToPre(row);
									},
									
									/*'click .btn_costMust_toCostDelay': function(e, value, row, index) {
										$.zjm_costRecord.costMustToDelay(row);
									},
									'click .btn_costMust_toCostPre': function(e, value, row, index) {
										$.zjm_costRecord.costMustToPre(row);
									}*/
								}				
			 });
				
				
			}
			return columns;
		}
	/**
	 * 初始化应收费用列表
	 */
	function initCostMustTable(){
		$('#table_costMust').bootstrapTable('destroy');
		$('#table_costMust').bootstrapTable({
			method: 'post',
			columns: initCostMustColumn(),
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/costMust/selectCostMustPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				//$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				$.extend(params, {"queryCondition":{"loanPlan_ID":loanPlan_ID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	
	
	
/*	
	
	[	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
		{field:"costName",title: '费用类型',align: 'center',formatter: function (value, row, index) { return row.costName;}},
		{field:"costRate",title: '费率',align: 'center',formatter: function (value, row, index) { return row.costRate;}},
		{field:"mustCostSum",title: '应收金额（元）',align: 'center',formatter: function (value, row, index) { return row.mustCostSum;}},
		{field:"costMustState",title: '状态',align: 'center',formatter: function (value, row, index) { return row.costMustState;}},
		
		
		{title: '操作',align: 'center',formatter:function(value,row,index){
				return ['<a href="javascript:void(0)" class="btn_costMust_toCostDelay">转入缓收费用</a>',
					'<a href="javascript:void(0)" class="btn_costMust_toCostPre">转入预收费用</a>'].join('&nbsp;&nbsp;&nbsp;');
			
		},
		events:{
			'click .btn_costMust_toCostDelay': function(e, value, row, index) {
				$.zjm_costRecord.costMustToDelay(row);
			},
			'click .btn_costMust_toCostPre': function(e, value, row, index) {
				$.zjm_costRecord.costMustToPre(row);
			}
		}
	}
	
	]*/
	
	
	
	
	/**
	 * 初始化缓收费用列表
	 */
	function initCostDelayTable(){
		$('#table_costDelay').bootstrapTable('destroy');
		$('#table_costDelay').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}},
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"agreeSum",title: '担保金额（万元）',align: 'center',formatter: function (value, row, index) { return row.agreeSum;}},
						{field:"costTypeName",title: '费用类型',align: 'center',formatter: function (value, row, index) { return row.costStandard.costTypeName;}},
						{field:"calculateRate",title: '费率（%）',align: 'center',formatter: function (value, row, index) { return row.costStandard.costRate+row.costStandard.costUnit;}},
						{field:"delayCostSum",title: '缓收费用（元）',align: 'center',formatter: function (value, row, index) { return row.delayCostSum;}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								if($("#openType").val()=="edit"){
									return '<a href="javascript:void(0)" class="btn_costDelay_toCostPre">转入预收费用</a>';
								}
							},
							events:{
								'click .btn_costDelay_toCostPre': function(e, value, row, index) {
									$.zjm_costRecord.costDelayToPre(row);
								},
							}
						}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/cost/selectCostDelayPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化预收费用列表***/
	function initCostPreTable(){
		$('#table_costPre').bootstrapTable('destroy');
		$('#table_costPre').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"agreeSum",title: '担保金额（万元）',align: 'center',formatter: function (value, row, index) { return row.agreeSum;}},
						{field:"costTypeName",title: '费用类型',align: 'center',formatter: function (value, row, index) { return row.costStandard.costTypeName;}},
						{field:"calculateRate",title: '费率（%）',align: 'center',formatter: function (value, row, index) { return row.costStandard.costRate+row.costStandard.costUnit;}},
						{field:"preCostSum",title: '预收费用（元）',align: 'center',formatter: function (value, row, index) { return row.preCostSum;}},
						{field:"preToFactCostSum",title: '已转实收费用（元）',align: 'center',formatter: function (value, row, index) { return row.preToFactCostSum;}},
						{field:"preToReturnCostSum",title: '已退费费用（元）',align: 'center',formatter: function (value, row, index) { return row.preToReturnCostSum;}},
						{field:"remainedPreCostSum",title: '预收费用余额（元）',align: 'center',formatter: function (value, row, index) { return row.remainedPreCostSum;}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								if($("#openType").val()=="edit" && row.remainedPreCostSum != 0){
									return ['<a href="javascript:void(0)" class="btn_costPre_toCostFact">转入实收费用</a>',
											'<a href="javascript:void(0)" class="btn_costPre_toCostRetrun">转入退费</a>'].join('&nbsp;&nbsp;&nbsp;');
								}
							},
							events:{
								'click .btn_costPre_toCostFact': function(e, value, row, index) {
									$.zjm_costRecord.costPreToFact(row);
								},
								'click .btn_costPre_toCostRetrun': function(e, value, row, index) {
									$.zjm_costRecord.costPreToReturn(row);
								}
							}
						}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/cost/selectCostPrePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化退费列表***/
	function initCostReturnTable(){
		$('#table_costReturn').bootstrapTable('destroy');
		$('#table_costReturn').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"agreeSum",title: '担保金额（万元）',align: 'center',formatter: function (value, row, index) { return row.agreeSum;}},
						{field:"costTypeName",title: '费用类型',align: 'center',formatter: function (value, row, index) { return row.costStandard.costTypeName;}},
						{field:"calculateRate",title: '费率（%）',align: 'center',formatter: function (value, row, index) { return row.costStandard.costRate+row.costStandard.costUnit;}},
						{field:"returnCostSum",title: '退费金额（元）',align: 'center',formatter: function (value, row, index) { return row.returnCostSum;}},
						{field:"returnCostDate",title: '退费日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.returnCostDate);}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark;}},
						/*{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',,
									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_creditApply_view': function(e, value, row, index) {
									$.zjm_costRecord.viewCreditApply(row.apply_ID);
								},
							}
						}*/
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/cost/selectCostReturnPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**初始化实收费用列表***/
	function initCostFactTable(){
		$('#table_costFact').bootstrapTable('destroy');
		$('#table_costFact').bootstrapTable({
			method: 'post',
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
						{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"agreeSum",title: '担保金额（万元）',align: 'center',formatter: function (value, row, index) { return row.agreeSum;}},
						{field:"costTypeName",title: '费用类型',align: 'center',formatter: function (value, row, index) { return row.costStandard.costTypeName;}},
						{field:"calculateRate",title: '费率（%）',align: 'center',formatter: function (value, row, index) { return row.costStandard.costRate+row.costStandard.costUnit;}},
						{field:"factCostSum",title: '实收费用（元）',align: 'center',formatter: function (value, row, index) { return row.factCostSum;}},
						{field:"factCostDate",title: '实收日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.factCostDate);}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark;}},
						/*{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',,
									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_creditApply_view': function(e, value, row, index) {
									$.zjm_costRecord.viewCreditApply(row.apply_ID);
								},
							}
						}*/
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			url: "/project/cost/selectCostFactPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	function costRules (){
		var allRules = {
			"isMoreThanRemainedPre":{
				"func":function(field,rules,i,options){
					var costSum = Number($("#costSum").val());
					var remainedPreCostSum = Number($("#hidden_remainedPreCostSum").val());
					if(costSum > remainedPreCostSum){
						return false;
					}else{
						return true;
					}
				},
				"alertText": "不能超过剩余预收金额",
			}
		};
		return allRules;
	};
	
	/**
	 * 应收转缓收
	 */
	/*function costMustToDelay(row){
		$("#costRecord_page").load("/project/cost/showCostMustToDelayPage",{"costMust_ID":row.costMust_ID},function(response,status,xhr){
			$("#costMustToDelay").modal({keyboard:true});
			注册编辑验证引擎
			zjm.validata({formId:"form_costMustToDelay"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_costMustToDelay");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/cost/costMustToDelay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#costMustToDelay").modal("hide");
								window.location.reload();
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
			$("#costMustToDelay").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}*/
	
	/**
	 * 应收转预收
	 */
	/*function costMustToPre(row){
		$("#costRecord_page").load("/project/cost/showCostMustToPrePage",{"costMust_ID":row.costMust_ID},function(response,status,xhr){
			$("#costMustToPre").modal({keyboard:true});
			注册编辑验证引擎
			zjm.validata({formId:"form_costMustToPre"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_costMustToPre");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/cost/costMustToPre',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#costMustToPre").modal("hide");
								window.location.reload();
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
			$("#costMustToPre").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}*/
	
	/**
	 * 缓收转预收
	 */
	/*function costDelayToPre(row){
		$("#costRecord_page").load("/project/cost/showCostDelayToPrePage",{"costDelay_ID":row.costDelay_ID},function(response,status,xhr){
			$("#costDelayToPre").modal({keyboard:true});
			注册编辑验证引擎
			zjm.validata({formId:"form_costDelayToPre"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_costDelayToPre");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/cost/costMustToPre',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#costDelayToPre").modal("hide");
								window.location.reload();
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
			$("#costDelayToPre").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}*/
	
	/**
	 * 预收转实收
	 */
	/*function costPreToFact(row){
		$("#costRecord_page").load("/project/cost/showCostPreToFactPage",{"costPre_ID":row.costPre_ID},function(response,status,xhr){
			$("#costPreToFact").modal({keyboard:true});
			注册编辑验证引擎
			$.zjm.rules = $.zjm_costRecord.costRules();	
			zjm.validata({formId:"form_costPreToFact"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_costPreToFact");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/cost/costPreToFact',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#costPreToFact").modal("hide");
								window.location.reload();
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
			$("#costPreToFact").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	*/
	/**
	 * 预收转退费
	 */
	/*function costPreToReturn(row){
		$("#costRecord_page").load("/project/cost/showCostPreToReturnPage",{"costPre_ID":row.costPre_ID},function(response,status,xhr){
			$("#costPreToReturn").modal({keyboard:true});
			注册编辑验证引擎
			$.zjm.rules = $.zjm_costRecord.costRules();	
			zjm.validata({formId:"form_costPreToReturn"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_costPreToReturn");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/cost/costPreToReturn',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#costPreToReturn").modal("hide");
								window.location.reload();
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
			$("#costPreToReturn").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}*/
	
	
	//到账确认
	function costMustToPre(row){
		
		$("#confirmModal").modal({keyboard:true});
		$("#confirmValue").text("是否确认已到账?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/costMust/costMustToPre',data:JSON.stringify({"costMust_ID":row.costMust_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$("#confirmModal").modal("hide");
						$.zjm_costRecord.initCostMustTable();//初始化应收费用列表
					}else{
						alert("确认失败！");
					}
		        }
			});
		});
		
		$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	
	}
	
	
})(jQuery, this);

$(function () {
	
	$.zjm_costRecord.initCostMustTable();//初始化应收费用列表
//	$.zjm_costRecord.initCostDelayTable();//初始化缓收费用列表
//	$.zjm_costRecord.initCostPreTable();//初始化预收费用列表
//	$.zjm_costRecord.initCostReturnTable();//初始化退费列表
//	$.zjm_costRecord.initCostFactTable();//初始化实收费用列表
	
});


(function($,z){
	$.zjm_payCompen = {
		initPayTable:initPayTable, //初始化还款列表
		initCompenTable:initCompenTable, //初始化代偿列表
		dutyRemovePage:dutyRemovePage , //进入
		
		factPayCancel:factPayCancel ,  //撤销还款
		viewFactPay:viewFactPay ,  //查看还款
		viewCompen:viewCompen ,  //查看代偿
		replaceCancel:replaceCancel, //撤销代偿
		factPayAdd:factPayAdd,  //部分还款
		replaceAdd:replaceAdd //部分代偿
	};
	
	var project_ID = $("#project_ID").val();
	var apply_ID = $("#apply_ID").val();
	var isFree = $("#isFree-detail").val();
	var type = $("#type_input").val();
	var guarantySum = isOrNotNull($("#guarantySum-detail").val());//在保余额
	var guarantyDutyResSum = isOrNotNull($("#guarantyDutyResSum-detail").val());//责任余额
	/**初始化还款列表***/
	function initPayTable(){
		$("#partialPayment_table").bootstrapTable('destroy');
		$('#partialPayment_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"freeTypeName",title: '还款类型',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.freeTypeName;}},
				{field:"payDate",title: '还款日期',align: 'center',sortable:"true",formatter: function (value, row, index){ 
					var payDate = row.payDate;
					if(payDate==null || typeof(payDate)==undefined){
						payDate = "（空）";
					}else{
						payDate = moment(payDate).format("YYYY-MM-DD")
					}
					return payDate;
				
				}},
				{field:"paySum",title: '还款金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.paySum;}},
				{field:"payCapitalSum",title: '还款本金（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.payCapitalSum;}},
				{field:"payInterestSum",title: '还款利息（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.payInterestSum;}},
				
				{field:"dutyRemove_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
							if(type=='edit'){
								if(isFree==0){
									return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_modules_cancel btn btn-xs btn-purple" href="javascript:void(0)" title="撤销"><i class="icon-reply-all bigger-120"></i></button>'].join('');
								}else{
									return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'
										].join('');
								}
							}else{
								return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'
									].join('');
							}
							
							
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_payCompen.viewFactPay(row);
							},
							'click .btn_modules_cancel': function(e, value, row, index) {
								if(isFree==1){
									alert("担保责任已经解除，不能在进行此操作！");
									return;
								}
								$.zjm_payCompen.factPayCancel(row);
							}
						}
				}
				],
			detailView: true,
			detailFormatter:function(index, row){
				var payDate = row.payDate;
				if(payDate==null || typeof(payDate)==undefined){
					payDate = "（空）";
				}else{
					payDate = moment(payDate).format("YYYY-MM-DD")
				}
			    var html = [];
				    html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>还款类型:</b> ' + tool.isNull(row.freeTypeName,"（空）") + '</p>');
				    html.push('<p><b>还款日期:</b> ' + payDate + '</p>');
				    html.push('<p><b>还款金额（万元）:</b> ' + tool.isNull(row.paySum,"（空）") + '</p>');
				    html.push('<p><b>还款本金（万元）:</b> ' + tool.isNull(row.payCapitalSum,"（空）") + '</p>');
				    html.push('<p><b>还款利息（万元）:</b> ' + tool.isNull(row.payInterestSum,"（空）") + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"payDate",    //排序字段
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/factPay/selectPayTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql":" and project_ID=\'" +project_ID+"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server"   //分页方式：client客户端分页，server服务端分页（*）
			//search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			//strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			//showColumns: false,     //是否显示所有的列
			//showRefresh: false,     //是否显示刷新按钮
			//minimumCountColumns: 2,    //最少允许的列数
			//clickToSelect: false,    //是否启用点击选中行
			//searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			//showToggle: false,//是否显示详细视图和列表视图的切换按钮
			//showPaginationSwitch:false,
            //showExport: false,                     //是否显示导出
            //exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	}
	
	
	/**初始化代偿列表***/
	function initCompenTable(){
		$("#partialCompen_table").bootstrapTable('destroy');
		$('#partialCompen_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"replaceDate",title: '还款日期',align: 'center',sortable:"true",formatter: function (value, row, index){return moment(row.replaceDate).format("YYYY-MM-DD");}},
				{field:"replaceSum",title: '代偿金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.replaceSum;}},
				{field:"replaceCapitalSum",title: '代偿本金（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.replaceCapitalSum;}},
				{field:"replaceInterestSum",title: '代偿利息（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.replaceInterestSum;}},
				{field:"replaceOtherSum",title: '代偿其它（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.replaceOtherSum;}},
				{field:"selfReplaceSum",title: '自有资金代偿（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.selfReplaceSum;}},
				{field:"dangerReplaceSum",title: '准备金冲抵（万元）',align: 'center',sortable:"true",formatter: function (value, row, index){return row.dangerReplaceSum;}},
				
				{field:"dutyRemove_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
						if(type=='edit'){
							if(isFree==0){
								return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_modules_cancel btn btn-xs btn-purple" href="javascript:void(0)" title="撤销"><i class="icon-reply-all bigger-120"></i></button>'].join('');
							}else{
								return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							}
						}else{
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
						}
							
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_payCompen.viewCompen(row);
							},
							'click .btn_modules_cancel': function(e, value, row, index) {
								if(isFree==1){
									alert("担保责任已经解除，不能在进行此操作！");
									return;
								}
								$.zjm_payCompen.replaceCancel(row);
							}
						}
				}
				],
			detailView: true,
			detailFormatter:function(index, row){
				var replaceDate = row.replaceDate;
				if(replaceDate==null || typeof(replaceDate)==undefined){
					replaceDate = "（空）";
				}else{
					replaceDate = moment(replaceDate).format("YYYY-MM-DD")
				}
			    var html = [];
				    html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>还款日期:</b> ' + replaceDate + '</p>');
				    html.push('<p><b>代偿金额（万元）:</b> ' + tool.isNull(row.replaceSum,"（空）") + '</p>');
				    html.push('<p><b>代偿本金（万元）:</b> ' + tool.isNull(row.replaceCapitalSum,"（空）") + '</p>');
				    html.push('<p><b>代偿利息（万元）:</b> ' + tool.isNull(row.replaceInterestSum,"（空）") + '</p>');
				    html.push('<p><b>代偿其它（万元）:</b> ' + tool.isNull(row.replaceOtherSum,"（空）") + '</p>');
				    html.push('<p><b>自有资金代偿（万元）:</b> ' + tool.isNull(row.selfReplaceSum,"（空）") + '</p>');
				    html.push('<p><b>准备金冲抵（万元）:</b> ' + tool.isNull(row.dangerReplaceSum,"（空）") + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"replaceDate",    //排序字段
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/Replace/selectReplaceTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql":" and project_ID=\'" +project_ID+"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server"   //分页方式：client客户端分页，server服务端分页（*）
			//search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			//strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			//showColumns: true,     //是否显示所有的列
			//showRefresh: true,     //是否显示刷新按钮
			//minimumCountColumns: 2,    //最少允许的列数
			//clickToSelect: false,    //是否启用点击选中行
			//searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			//showToggle: true,//是否显示详细视图和列表视图的切换按钮
			//showPaginationSwitch:true,
            //showExport: true,                     //是否显示导出
            //exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	}
	if(isFree==1){
		//alert("担保责任已经解除，不能再进行责任解除、部分还款以及部分代偿操作！");
		//$("#btn_dutyRemove").attr("disabled","disabled");
		//$("#btn_partialPayment").attr("disabled","disabled");
		//$("#btn_partialCompen").attr("disabled","disabled");
		
		$("#btn_dutyRemove").hide();
		$("#btn_partialPayment").hide();
		$("#btn_partialCompen").hide();
	}
	
	/**责任解除确认*/
	function dutyRemovePage(){
		$("#dutyRemove_page").load("/project/project/dutyReleaseModal?project_ID="+project_ID,{},function(response,status,xhr){
			$("#dutyReleaseModal").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"dutyRelease_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				var freeMethodID = $('.freeMethodID').val();//
				if(parseFloat(guarantySum)!=0){
					
				
				if(freeMethodID =='3d08a203ab804ddf80e8d3c827bd98ae'){
					var normalFreeSum = isOrNotNull($("#normalFreeSum-input").val());//正常还款
					var normalCapitalSum = isOrNotNull($("#normalCapitalSum-input").val());//还款本金
					var normalInterestSum = isOrNotNull($("#normalInterestSum-input").val());//还款利息
					var totalMoney1 = (parseFloat(normalCapitalSum) + parseFloat(normalInterestSum)).toFixed(4);
					if(guarantySum - normalCapitalSum != 0){
						$("#pleaseSelectOne").modal({keyboard:true});
						$("#message").html("在保余额与还款本金不相等，不能进行担保责任确认！");
			        	return false;
						//alert("在保余额与还款本金不相等，不能进行担保责任确认！");
						//return;
					}
					if(normalFreeSum - totalMoney1 != 0){
						$("#pleaseSelectOne").modal({keyboard:true});
						$("#message").html("还款本金与还款利息之和不等于正常还款，不能进行担保责任确认！");
			        	return false;
						//alert("还款本金与还款利息之和不等于正常还款，不能进行担保责任确认！");
						//return;
					}
				}else{
					var replaceFreeSum = isOrNotNull($("#replaceFreeSum-input").val());//代偿金额
					var replaceCapitalSum = isOrNotNull($("#replaceCapitalSum-input").val());//代偿本金
					var replaceInterestSum = isOrNotNull($("#replaceInterestSum-input").val());//代偿利息
					var replaceOtherSum = isOrNotNull($("#replaceOtherSum-input").val());//代偿其他费用
					var selfReplaceSum = isOrNotNull($("#selfReplaceSum-input").val());//自有资金代偿
					var dangerReplaceSum = isOrNotNull($("#dangerReplaceSum-input").val());//准备金冲抵
					var totalMoney2 = (parseFloat(replaceCapitalSum) + parseFloat(replaceInterestSum) + parseFloat(replaceOtherSum)).toFixed(4);
					var totalMoney3 = (parseFloat(selfReplaceSum) + parseFloat(dangerReplaceSum)).toFixed(4);
					
					if(guarantySum-replaceCapitalSum != 0){
						$("#pleaseSelectOne").modal({keyboard:true});
						$("#message").html("在保余额与代偿本金不相等，不能进行担保责任确认！");
			        	return false;
						//alert("在保余额与代偿本金不相等，不能进行担保责任确认！");
						//return;
					}
					if(replaceFreeSum - totalMoney2 != 0){
						$("#pleaseSelectOne").modal({keyboard:true});
						$("#message").html("代偿本金、代偿利息以及代偿其他费用之和不等于代偿金额，不能进行担保责任确认！");
			        	return false;
						//alert("代偿本金、代偿利息以及代偿其他费用之和不等于代偿金额，不能进行担保责任确认！");
						//return;
					}
					if(replaceFreeSum - totalMoney3 != 0){
						$("#pleaseSelectOne").modal({keyboard:true});
						$("#message").html("自有资金代偿与准备金冲抵之和不等于代偿金额，不能进行担保责任确认！");
			        	return false;
						//alert("自有资金代偿与准备金冲抵之和不等于代偿金额，不能进行担保责任确认！");
						//return;
					}
				}
				
				}
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#dutyRelease_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/project/updateDutyRemove',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
						   if(data.obj){
								$("#dutyReleaseModal").modal("hide");
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
			$("#dutyReleaseModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**查看代偿*/
	function viewCompen(row){
		$("#compen_page").load("/project/Replace/showRepalceViewPage",{"replace_ID":row.replace_ID},function(response,status,xhr){
			$("#viewReplace").modal({keyboard:true});
		});
	}
	/**代偿撤销cancelCompen**/
	function replaceCancel(row){
		$("#compen_page").load("/project/Replace/showReplaceDelPage",{},function(response,status,xhr){
			$("#delReplace").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/Replace/cancelReplaceDel',data:JSON.stringify({"replace_ID":row.replace_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delReplace").modal("hide");
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delReplace").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	/**查看还款*/
	function viewFactPay(row){
		$("#payment_viewPage").load("/project/factPay/showFactPayViewPage",{"factPay_ID":row.factPay_ID},function(response,status,xhr){
			$("#viewFactPay").modal({keyboard:true});
		});
	}
	/**factPayCancel 撤销还款**/
	function factPayCancel(row){
		$("#payment_page").load("/project/factPay/showFactPayDelPage",{},function(response,status,xhr){
			$("#delFactPay").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/factPay/cancelOneFactPayDel',data:JSON.stringify({"factPay_ID":row.factPay_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delFactPay").modal("hide");
							//$.zjm_dicNode.initTable();
							window.location.reload();
						}else{
							alert("撤销失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delFactPay").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	
	/**部分还款*/
	function factPayAdd(){
		$("#payment_addPage").load("/project/factPay/showFactPayAddPage",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){
			$("#addFactPay").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_FactPay_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				var paySum = isOrNotNull($("#paySum-add").val());//正常还款
				var payCapitalSum = isOrNotNull($("#payCapitalSum-add").val());//还款本金
				var payInterestSum = isOrNotNull($("#payInterestSum-add").val());//还款利息
				var totalMoney4 = (parseFloat(payCapitalSum)+parseFloat(payInterestSum)).toFixed(4);
				if(guarantySum - payCapitalSum < 0){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("在保余额必须大于或者等于还款本金！");
		        	return false;
					//alert("在保余额必须大于或者等于还款本金！");
					//return;
				}
				if(paySum - totalMoney4 != 0){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("还款本金与还款利息之和不等于还款金额！");
		        	return false;
					//alert("还款本金与还款利息之和不等于还款金额！");
					//return;
				}
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_FactPay_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/factPay/addOneFactPay',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addFactPay").modal("hide");
									//	$.zjm_payCompen.initTable();
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
			$("#addFactPay").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	
	/**部分代偿*/
	function replaceAdd(){
		$("#compen_addPage").load("/project/Replace/showReplaceAddPage",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){
			$("#addReplace").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_Replace_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				var replaceSumAdd = isOrNotNull($("#replaceSum-add").val());//代偿金额
				var replaceCapitalSumAdd = isOrNotNull($("#replaceCapitalSum-add").val());//代偿本金
				var replaceInterestSumAdd = isOrNotNull($("#replaceInterestSum-add").val());//代偿利息
				var replaceOtherSumAdd = isOrNotNull($("#replaceOtherSum-add").val());//代偿其他费用
				var selfReplaceSumAdd = isOrNotNull($("#selfReplaceSum-add").val());//自有资金代偿
				var dangerReplaceSumAdd = isOrNotNull($("#dangerReplaceSum-add").val());//准备金冲抵
				var totalMoney5 = (parseFloat(replaceCapitalSumAdd) + parseFloat(replaceInterestSumAdd) + parseFloat(replaceOtherSumAdd)).toFixed(4);
				var totalMoney6 = (parseFloat(selfReplaceSumAdd) + parseFloat(dangerReplaceSumAdd)).toFixed(4);
				if(guarantyDutyResSum-replaceCapitalSumAdd < 0){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("责任余额必须大于或等于代偿本金！");
		        	return false;
					//alert("责任余额必须大于或等于代偿本金！");
					//return;
				}
				if(replaceSumAdd - totalMoney5 != 0){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("代偿本金、代偿利息以及代偿其他费用之和不等于代偿金额！");
		        	return false;
					//alert("代偿本金、代偿利息以及代偿其他费用之和不等于代偿金额！");
					//return;
				}
				if(replaceSumAdd - totalMoney6 != 0){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("自有资金代偿与准备金冲抵之和不等于代偿金额！");
		        	return false;
					//alert("自有资金代偿与准备金冲抵之和不等于代偿金额！");
					//return;
				}
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_Replace_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/Replace/addOneReplace',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addReplace").modal("hide");
									//	$.zjm_payCompen.initTable();
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
			$("#addReplace").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	function isOrNotNull(str){
		if(str==null ||typeof(str)==undefined || str==''){
			str=0;
		}
		return parseFloat(str).toFixed(4);
	}
	
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_payCompen.initPayTable();
	$.zjm_payCompen.initCompenTable();
	
	//担保责任解除按钮
	$("#btn_dutyRemove").click(function(){
		$.zjm_payCompen.dutyRemovePage();
	});
	//部分还款按钮
	$("#btn_partialPayment").click(function(){
		$.zjm_payCompen.factPayAdd();
	});
	//部分代偿按钮
	$("#btn_partialCompen").click(function(){
		$.zjm_payCompen.replaceAdd();
	});
});

(function($,z){
	$.zjm_meetingResolution = {
		initGuaranteeTable:initGuaranteeTable, //初始化批准担保情况列表
		initBusiCostStandardTable:initBusiCostStandardTable,	//初始化各业务批准收费标准列表
		initSysCostStandardTable:initSysCostStandardTable,		//初始化系统定义费用标准列表
		addMeetingResolution:addMeetingResolution,  //添加评审会决议
		addMeetingReso:addMeetingReso,
		updateMeetingResolution:updateMeetingResolution,//修改决议内容；
		updateUserName:updateUserName,//修改参会委员
		//xuyz
		editApproveGuarantee:editApproveGuarantee,	//编辑评审会批准情况
		editMeetingCost:editMeetingCost,	//修改评审会批准收费标准,只能修改备注
		deleteMeetingCost:deleteMeetingCost	//删除评审会批准收费标准
	};
	
	var applyID = $("#applyID").val();
	
	/**初始化批准担保列表***/
	function initGuaranteeTable(){
		$("#approveGuarantee_table").bootstrapTable('destroy');
		$('#approveGuarantee_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"bankName",title: '放款机构',align: 'center',formatter: function (value, row, index) {return row.bankName;}},
					{field:"busiTypeName",title: '业务品种',align: 'center',formatter: function (value, row, index){return row.busiTypeName;}},
					{field:"applySum",title: '申请金额（万元）',align: 'center',formatter: function (value, row, index){return row.applySum;}},
					{field:"agreeSum",title: '同意金额（万元）',align: 'center',formatter: function (value, row, index){return row.agreeSum;}},
					{field:"agreeMonthDay",title: '同意期限',align: 'center',formatter: function (value, row, index){return row.agreeMonthDay;}},
					{field:"guarantyScope",title: '担保责任范围',align: 'center',formatter: function (value, row, index){return row.guarantyScope;}},
					{field:"guarantyScale",title: '担保责任比例（%）',align: 'center',formatter: function (value, row, index){return row.guarantyScale;}},
//					{field:"guarantyDutySum",title: '担保责任金额（万元）',align: 'center',formatter: function (value, row, index){return row.guarantyDutySum;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return '<button class="btn_approveGuarantee_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改"><i class="icon-pencil bigger-120"></i></button>';
						},
						events:{
							'click .btn_approveGuarantee_edit': function(e, value, row, index) {
								$.zjm_meetingResolution.editApproveGuarantee(row);
							}
						}
					}],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
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
	
	/**
	 *  初始化各业务对应批准收费标准列表
	 */
	function initBusiCostStandardTable(){
		$("#busiCostStandard_table").bootstrapTable('destroy');
		$('#busiCostStandard_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"costTypeName",title: '费用类型',align: 'center',formatter: function (value, row, index){return row.costTypeName;}},
				{field:"costRate",title: '费率',align: 'center',formatter: function (value, row, index) { return row.costRate+"&nbsp;"+row.costUnit;}},
				{field:"culate",title: '计算规则',align: 'center',formatter: function (value, row, index) { return row.culate;}},			
				{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index){return row.remark;}},
				{field:"",title: '操作',align: 'center',formatter:function(value,row,index){
							return [/*'<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'*/
								'<button class="btn_meetingCost_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_meetingCost_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_meetingCost_edit': function(e, value, row, index) {
								$.zjm_meetingResolution.editMeetingCost(row);
							},
							'click .btn_meetingCost_del': function(e, value, row, index) {
								$.zjm_meetingResolution.deleteMeetingCost(row);
							}
						}
					}],
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
	
	/**
	 *  初始化系统定义费用标准列表
	 */
	function initSysCostStandardTable(){
		$("#sysCostStandard_table").bootstrapTable('destroy');
		$('#sysCostStandard_table').bootstrapTable({
			method: 'get',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}},
						{field:"costName",title: '费用名称',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.costName;}},
						{field:"costTypeName",title: '费用类型名',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.costTypeName;}},
						{field:"costRate",title: '费率',align: 'center',formatter: function (value, row, index) { return row.costRate+"&nbsp;"+row.costUnit;}},
						{field:"culate",title: '计算关系',align: 'center',formatter: function (value, row, index) { return row.culate;}}			
					 ],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
			url: "/sys/costStandard/selectCostStandardTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	

	//页面验证规则
	function customRules (){
		var allRules = {
				//判断同意金额不大于申请金额
				"isMoreThan":{
					"func":function(field,rules,i,options){
						var applySum = Number($("#applySum").val());
						var agreeSum = Number($("#agreeSum").val());
						if(agreeSum > applySum){
							return false;
						}else{
							return true;
						}
					},
					"alertText": "审批同意金额不能超过申请金额",
				},
		};
		return allRules;
	
	};
	
	//编辑批准担保情况
	function editApproveGuarantee(row){
		$("#meetingResolution_page").load("/pro/meetingResolution/showApproveGuaranteeEditPage",{"applyDetail_ID":row.applyDetail_ID},function(response,status,xhr){
			$("#approveGuaranteeEdti").modal({keyboard:true});
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
			tool.undisabled(".btn_submit");
			$.zjm.rules = customRules();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_approveGuaranteeEdit"});
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_approveGuaranteeEdit");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/pro/meetingResolution/updateOneProApplyDetail',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#approveGuaranteeEdti").modal("hide");
								$.zjm_meetingResolution.initGuaranteeTable();
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
			$("#approveGuaranteeEdti").on("hidden.bs.modal", function(e) {// 解除事件绑定
				$(".btn_submit").unbind("click");
			})
		});
	}
	
	/**
	 * 修改评审会批准收费标准,只能修改备注
	 */
	function editMeetingCost(row){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetingCostEditPage",{"meetingCost_ID":row.meetingCost_ID},function(response,status,xhr){
			$("#meetingCostEdit").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/pro/meetingResolution/updateOneMeetingCostRemark',data:JSON.stringify($("#form_meetingCostEdit").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
			        	if(data.obj){
							$("#meetingCostEdit").modal("hide");
							$.zjm_meetingResolution.initBusiCostStandardTable();
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#meetingCostEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 删除评审会批准收费标准 
	 */
	function deleteMeetingCost(row){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetingCostDelPage",{},function(response,status,xhr){
			$("#meetingCostDel").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/pro/meetingResolution/deleteOneMeetingCost',data:JSON.stringify({"meetingCost_ID":row.meetingCost_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
			        	if(data.obj){
							$("#meetingCostDel").modal("hide");
							$.zjm_meetingResolution.initBusiCostStandardTable();
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#meetingCostDel").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//添加评审会决议
	function addMeetingResolution(){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetResolutionAddPage?applyID="+applyID,{},function(response,status,xhr){
			$("#add_meetResolution").modal({keyboard:true});
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"meetResolution_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#meetResolution_form");
				if($(queryContainer_form).validationEngine("validate")){
						//if(zjm.ajaxValidata("add_add_meetReso","/gbpm/dicNode/isExistNodeNames",JSON.stringify(queryContainer_form.serializeJson()),"节点名称重复！")){
							$.ajax({type:'POST',url:'/pro/meetingResolution/insertOneMeetingResolution',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#add_meetResolution").modal("hide");
										$.zjm_meetingResolution.initGuaranteeTable();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
								}
							});
						/*}else{
							tool.undisabled(".btn_submit");
						}*/
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#add_meetResolution").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	//添加评审会决议
	function addMeetingReso(){
		$("#meetingResolution_page").load("/pro/meetingResolution/showMeetingResoAddPage?applyID="+applyID,{},function(response,status,xhr){
			$("#add_meetingReso").modal({keyboard:true});
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"meetResolution_form"});
			tool.undisabled(".btn_submit");
		});
	}
	
	//修改决议内容
	function updateMeetingResolution(){
		var meetingResolution_ID = $("#meetingResolution_ID").val();	
		$("#meetingResolution_page").load("/pro/meetingResolution/returnMeetingResolutionPage",{"meetingResolution_ID":meetingResolution_ID},function(response,status,xhr){
			$("#meetingResolutionEdit").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"updateMeetingResolution_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateMeetingResolution_form");
				if(queryContainer_form.validationEngine("validate")){
						$.ajax({type:'POST',url:'/pro/meetingResolution/updateMeetingResolution',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
					        			
									$("#meetingResolutionEdit").modal("hide");
									window.location.reload();
									
								}else{
									alert("保存失败！");
								}
					        }
						});
					}else{
						tool.undisabled(".btn_submit");
					}
			});
			$("#meetingResolutionEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	
	//修改参会委员
	function updateUserName(){
		
		var meeting_ID = $("#meeting_ID").val();
		$("#meetingResolution_page").load("/pro/meetingResolution/returnMeetingUserName",{"meeting_ID":meeting_ID},function(response,status,xhr){
			$("#meetingResolutionEdit2").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"updateMeetingUserName_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateMeetingUserName_form");
				if(queryContainer_form.validationEngine("validate")){
						$.ajax({type:'POST',url:'/pro/meetingResolution/updateMeetingUserName',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#meetingResolutionEdit2").modal("hide");
									
								}else{
									alert("保存失败！");
								}
					        }
						});
					}else{
						tool.undisabled(".btn_submit");
					}
			});
			$("#meetingResolutionEdit2").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}

})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_meetingResolution.initGuaranteeTable();
	$.zjm_meetingResolution.initBusiCostStandardTable();
	
	$("#btn_addMeetingResolution").click(function(){
		$.zjm_meetingResolution.addMeetingResolution();
	});
	$("#btn_addMeetingReso").click(function(){
		$.zjm_meetingResolution.addMeetingReso();
	});
	//修改决议内容
	$("#btn_updateMeetingResolution").click(function(){
		$.zjm_meetingResolution.updateMeetingResolution();
	});
	//修改参会委员
	$("#btn_updateUserName").click(function(){
		$.zjm_meetingResolution.updateUserName();
	});
	
	/**
	 * 选择收费标准 
	 */
	$("#btn_addBusiCostStandard").click(function(){
		$("#costStandardList").modal({keyboard:true});
		$.zjm_meetingResolution.initSysCostStandardTable();
		tool.undisabled(".btn_confirm");
		$(".btn_confirm").click(function(){
			tool.disabled(".btn_confirm");
			var selectContent = $("#sysCostStandard_table").bootstrapTable('getSelections');
			var costStdList = "";
			for(var i=0; i<selectContent.length; i++){
				costStdList += selectContent[i].costStandard_ID+",";
			}
			$("#costStandardIDList").val(costStdList);
			$.ajax({type:'POST',url:'/pro/meetingResolution/insertMeetingCostList',data:JSON.stringify($("#form_addMeetingCost").serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					$("#costStandardList").modal("hide");
					$.zjm_meetingResolution.initBusiCostStandardTable();
				}
			});
		});
		$("#costStandardList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_confirm").unbind("click");
		});
	});
	
});

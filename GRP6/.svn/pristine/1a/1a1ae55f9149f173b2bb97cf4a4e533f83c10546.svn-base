(function($,z){
	$.zjm_billManage = {
		initTable:initTable,	//初始化主体列表
		viewProjectBill:viewProjectBill,	//查看一个项目的已确认收付费用明细
	};
	
	$.zjm_sglProBillManage = {
		initSglProBillTable:initSglProBillTable,	//初始化弹窗列表
		initTreeAndDate:initTreeAndDate,	//初始化树结构和日期控件
		addSingleProjectBill:addSingleProjectBill,		//单个项目新增一条票据信息
		editSingleProjectBill:editSingleProjectBill,	//修改单个项目的一条票据信息 
		viewSingleProjectBill:viewSingleProjectBill,	//查看单个项目的一条票据信息 
		delSingleProjectBill:delSingleProjectBill,		//删除单个项目的一条票据信息 
	};
	
	/**初始化主体列表-所有项目的开票统计***/
	function initTable(){
		$('#table_multiProjectsBill').bootstrapTable('destroy');
		$('#table_multiProjectsBill').bootstrapTable({
			method: 'post',
			singleSelect : true, 
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"projectCode",title: '项目编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.projectCode;}},
						{field:"projectName",title: '项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.projectName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiTypeName;}},
						{field:"agreeSum",title: '同意金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.agreeSum;}},
						{field:"agreeMonthDay",title: '同意期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.agreeMonthDay;}},
						{field:"shoujuNum",title: '开具收据次数',align: 'center',formatter: function (value, row, index) { return row.shoujuNum;}},
						{field:"fapiaoNum",title: '开具发票次数',align: 'center',formatter: function (value, row, index) { return row.fapiaoNum;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_projectCost_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看项目票据"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_projectCost_view': function(e, value, row, index) {
									$.zjm_billManage.viewProjectBill(row);
								},
							}
						}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"projectCode",	//默认排序字段
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/billManage/selectMultiProsBillPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			/*queryParams: function(params) {
				var queryCondition = {"pbanksortid": "e7e282ee61b249eba0f64161fee6ff45"};
				$.extend(queryCondition,data);
				$.extend(params, {"queryCondition":queryCondition});
				return params;
			},*///前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
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
            exportDataType: "basic",              //basic', 'all', 'selected'
		});
	}
	
	/**初始化模态窗列表-单个项目的开票信息***/
	function initSglProBillTable(data){
		$('#table_singleProjectBill').bootstrapTable('destroy');
		$('#table_singleProjectBill').bootstrapTable({
			method: 'post',
			singleSelect : true, 
			columns: [	{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"billTypeName",title: '票据类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.billTypeName;}},
//						{field:"billCode",title: '票据编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.billCode;}},
						{field:"billSum",title: '开具金额（元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.billSum;}},
						{field:"billDate",title: '开具日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.billDate);}},
						{field:"billTitle",title: '开票名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.billTitle;}},
						{field:"taxCode",title: '纳税人识别号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.taxCode;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_singleProjectBill_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_singleProjectBill_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_singleProjectBill_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_singleProjectBill_view': function(e, value, row, index) {
									$.zjm_sglProBillManage.viewSingleProjectBill(row);
								},
								'click .btn_singleProjectBill_edit': function(e, value, row, index) {
									$.zjm_sglProBillManage.editSingleProjectBill(row);
								},
								'click .btn_singleProjectBill_del': function(e, value, row, index) {
									$.zjm_sglProBillManage.delSingleProjectBill(row);
								}
							}
						}
					],
			detailView: false,
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortName:"billDate",	//默认排序字段
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/billManage/selectSglProBillPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"applyDetail_ID":data.applyDetail_ID};
				$.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/**
	 *  初始化开票人下拉树和日期控件
	 */
	function initTreeAndDate(){
		/*获取开具人下拉选择树*/
		/*$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#createUser").selectTreeWidgets({
					width : "89%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
		    }
		});*/
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
	}
	
	/**
	 * 查看一个项目的所有票据信息
	 */
	function viewProjectBill(row){
		$("#multiProjectsBill_page").load("/project/billManage/showSglProBillPageTable",{"apply_ID":row.apply_ID,"applyDetail_ID":row.applyDetail_ID},function(response,status,xhr){
			$.zjm_sglProBillManage.initSglProBillTable(row);
			$("#singleProjectBill").modal({keyboard:true});
			$(".modal-backdrop").attr("id","singleProjectBill_backdrop");	//弹出第一个模态窗后，取其遮罩层，并赋一个ID值
			$("#btn_addSglProBillInfo").click(function(){
				addSingleProjectBill(row);
				
			});
		});
	}
	
	/**
	 * 给单个项目新增一个票据 
	 */
	function addSingleProjectBill(row){
		$("#singleProjectBill_page").load("/project/billManage/showSglProBillAddPage",{},function(response,status,xhr){
			$.zjm_sglProBillManage.initTreeAndDate();
			/*设置日期初始值，默认为当天*/
			$("#billDate").attr("value",tool.parseDate(new Date().getTime()));
			var zindex = parseInt($("#singleProjectBill").css("z-index"));	//获取第一个模态窗的z-index。bootstrap的默认值，模态窗：z-index=1050，遮罩层：z-index=1040
			$("#addProjectBillInfo").modal({keyboard:true});
			$("#addProjectBillInfo").css("z-index",zindex+50);	//设置第二个模态窗的z-index，值比第一个模态窗大一些。
			$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);	//获取第二个模态窗弹出时生成的遮罩层，并设置其z-index值，比第一个模态窗的z-index要大，比第二个模态窗的z-index要小
			$("#hidden_applyID_add").val(row.apply_ID);
			$("#hidden_applyDetailID_add").val(row.applyDetail_ID);
			selectChange();	//给票据类型下拉框绑定change事件，赋值billTypeName
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_addProjectBillInfo"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#form_addProjectBillInfo").validationEngine("validate")){
					var queryContainer_form = $("#form_addProjectBillInfo");
					$.ajax({type:'POST',url:"/project/billManage/insertOneBill",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#addProjectBillInfo").modal("hide");
								$.zjm_sglProBillManage.initSglProBillTable(row);
								$.zjm_billManage.initTable();
							}else{
								tool.undisabled(".btn_submit");
								$("#pleaseSelectOne").modal({keyboard:true});
								$("#message").text("保存失败");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addProjectBillInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 修改单个项目的一条票据信息 
	 */
	function editSingleProjectBill(row){
		$("#singleProjectBill_page").load("/project/billManage/showSglProBillEditPage",{"costBill_ID":row.costBill_ID},function(response,status,xhr){
			$.zjm_sglProBillManage.initTreeAndDate();
			var zindex = parseInt($("#singleProjectBill").css("z-index"));
			$("#editProjectBillInfo").modal({keyboard:true});
			$("#editProjectBillInfo").css("z-index",zindex+50);
			$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);
			selectChange();	//给票据类型下拉框绑定change事件，赋值billTypeName
			/*注册编辑验证引擎*/
			zjm.validata({formId:"form_editProjectBillInfo"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#form_editProjectBillInfo").validationEngine("validate")){
					var queryContainer_form = $("#form_editProjectBillInfo");
					$.ajax({type:'POST',url:"/project/billManage/updateOneBill",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#editProjectBillInfo").modal("hide");
								$.zjm_sglProBillManage.initSglProBillTable(row);
								$.zjm_billManage.initTable();
							}else{
								tool.undisabled(".btn_submit");
								$("#pleaseSelectOne").modal({keyboard:true});
								$("#message").text("保存失败");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editProjectBillInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 查看单个项目的一条票据信息 
	 */
	function viewSingleProjectBill(row){
		$("#singleProjectBill_page").load("/project/billManage/showSglProBillViewPage",{"costBill_ID":row.costBill_ID},function(response,status,xhr){
			var zindex = parseInt($("#singleProjectBill").css("z-index"));
			$("#viewProjectBillInfo").modal({keyboard:true});
			$("#viewProjectBillInfo").css("z-index",zindex+50);
			$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);
		});
	}
	
	/**
	 * 删除单个项目的一条票据信息 
	 */
	function delSingleProjectBill(row){
		$("#singleProjectBill_page").load("/project/billManage/showSglProBillDelPage",{},function(response,status,xhr){
			var zindex = parseInt($("#singleProjectBill").css("z-index"));
			$("#delProjectBillInfo").modal({keyboard:true});
			$("#delProjectBillInfo").css("z-index",zindex+50);
			$("#singleProjectBill_backdrop").nextAll(".modal-backdrop").css("z-index",zindex+40);
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:"/project/billManage/deleteOneBill",data:JSON.stringify({"costBill_ID":row.costBill_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#delProjectBillInfo").modal("hide");
							$.zjm_sglProBillManage.initSglProBillTable(row);
							$.zjm_billManage.initTable();
						}else{
							tool.undisabled(".btn_submit");
							$("#pleaseSelectOne").modal({keyboard:true});
							$("#message").text("删除失败");
						}
			        }
				});
			});
			$("#delProjectBillInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	function selectChange(){
		$("select[name='billTypeID']").change(function(){
			var billTypeName = $(this).children("option:selected").text();
			$(this).next().val(billTypeName);
		});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_billManage.initTable();
	};

});


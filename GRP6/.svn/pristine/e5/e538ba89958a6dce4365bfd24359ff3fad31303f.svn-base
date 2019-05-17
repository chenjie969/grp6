(function($,z){
	$.zjm_creditApply = {
		initTable:initTable,	//初始化列表
		viewCreditApply:viewCreditApply,//查看授信申请
		delCreditApply:delCreditApply,//删除授信申请
		agreeToCreditAccept:agreeToCreditAccept,//授信申请-同意立项;
		initProductTable:initProductTable,//初始化流程列表
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#creditApply_table').bootstrapTable('destroy');
		$('#creditApply_table').bootstrapTable({
			method: 'post',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"busiCode",title: '授信编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
						{field:"projectName",title: '授信项目名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.projectName;}},
						{field:"applySum",title: '授信额度（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applySum;}},
						{field:"creditBeginDate",title: '授信起始日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.creditBeginDate);}},
						{field:"creditEndDate",title: '授信结束日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.creditEndDate);}},
						{field:"departName",title: '经办部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.departName;}},
						{field:"createManName",title: '经办人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.createManName;}},
						{field:"createDate",title: '受理日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.createDate);}},
//						{field:"clientBH",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
//						{field:"clientBH",title: '授信额度（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
//						{field:"clientBH",title: '合作机构',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiCode;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
//									'<button class="btn_creditApply_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_creditApply_view': function(e, value, row, index) {
									$.zjm_creditApply.viewCreditApply(row.apply_ID);
								},
//								'click .btn_creditApply_edit': function(e, value, row, index) {
//									$.zjm_creditApply.editCreditApply(row);
//								},
								'click .btn_creditApply_del': function(e, value, row, index) {
									$.zjm_creditApply.delCreditApply(row.apply_ID);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>授信编号：</b> ' + row.busiCode + '</p>');
				    html.push('<p><b>授信项目名称：</b> ' + row.projectName + '</p>');
				    html.push('<p><b>授信额度：</b> ' + row.applySum + '万元</p>');
				    html.push('<p><b>授信起始日期：</b> ' + tool.parseDate(row.creditBeginDate) + '</p>');
				    html.push('<p><b>授信结束日期：</b> ' + tool.parseDate(row.creditEndDate) + '</p>');
				    html.push('<p><b>经办部门：</b> ' + row.departName + '</p>');
				    html.push('<p><b>经办人：</b> ' + row.createManName + '</p>');
				    html.push('<p><b>受理日期：</b> ' + tool.parseDate(row.createDate) + '</p>');
				    html.push("<p><b>操作：</b>" +
				    			"<button class='btn btn-xs btn-warning' href='javascript:void(0)' title='查看' onclick=\"$.zjm_creditApply.viewCreditApply('"+row.apply_ID+"');\"><i class='icon-zoom-in bigger-120'></i>查看</button>" +
				    			"&nbsp;&nbsp;&nbsp;"+
				    			"<button class='btn btn-xs btn-danger' href='javascript:void(0)' title='删除' onclick=\"$.zjm_creditApply.delCreditApply('"+row.apply_ID+"');\"><i class='icon-zoom-in bigger-120'></i>删除</button>"+
				    		  "</p>");
//				    html.push("<button class='btn btn-xs btn-warning' href='javascript:void(0)' title='查看' onclick=\"$.zjm_creditApply.viewCreditApply2('"+row.apply_ID+"');\"><i class='icon-zoom-in bigger-120'></i></button>");
//				    html.push("<p><a href='javascript:void(0)' onclick=\"$.zjm_creditApply.viewCreditApply2('"+row.apply_ID+"');\">查看</a></p>");
		        return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",	//默认排序字段
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/credit/selectCreditApplyPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {};
				$.extend(queryCondition,data);
				$.extend(params, {"queryCondition":queryCondition});
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
            exportDataType: "basic",              //basic', 'all', 'selected'
		});
	}
	
	/**
	 * 查看授信申请
	 */
	function viewCreditApply(id){
		/* 弹窗显示
		 * $("#creditApply_page").load("/project/credit/viewOneCreditApply",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#viewCreditApply").modal({keyboard:true});
		});*/
		window.parent.openMenu('view_creditApply_'+id,'','查看授信申请信息','/project/credit/viewOneCreditApply','&apply_ID='+id);
	}
	
	/**
	 * 删除授信申请
	 */
	function delCreditApply(id){
		$("#creditApply_page").load("/project/credit/showCreditApplyDelPage",{},function(response,status,xhr){
			$("#text_deleteWarning").text("是否删除此授信申请？");
			$("#delCreditApply").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/project/credit/deleteOneCreditApply',data:JSON.stringify({"apply_ID":id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj){
							$("#delCreditApply").modal("hide");
							$.zjm_creditApply.initTable();
						}else{
							alert("保存失败！");
						}
			        }
				});
			});
			$("#delCreditApply").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	
	
	//授信申请-同意立项;
	function agreeToCreditAccept(){
		
		var selectContent = $('#creditApply_table').bootstrapTable('getSelections');  
		
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var selectContent = $('#creditApply_table').bootstrapTable('getSelections')[0];
			var entityID = selectContent.apply_ID;
			var projectName = selectContent.projectName;
			
			$("#selectProductModal").modal({keyboard:true});
			$(".sProjectName").html(projectName);
			$.zjm_creditApply.initProductTable();
			$("#entityID").val(entityID);
			tool.undisabled(".btn_nextStep");
			$(".btn_nextStep").click(function(){
				var selectContent = $('#product-table').bootstrapTable('getSelections')[0];
		        if(typeof(selectContent) == 'undefined'){
		        	$("#pleaseSelectOne").modal({keyboard:true});
		        	return false;  
		        }else{
					tool.disabled(".btn_nextStep");
     				$("#selectProductModal").modal("hide");
     				//十个参数  1，产品ID 2，节点顺序 3，流程发起人ID 4，流程发起人名称 5，当前办理人ID 6，当前办理人名称 7.业务ID 8，业务类型：申请：01 打包：02 9.项目名称 显示用 10 实例化流程ID
     				$.zjm_nodeTaskModal.initNodeTaskModal(selectContent.product_ID,'0',$("#userID").val(),$("#userName").val(),$("#userID").val(),$("#userName").val(),entityID,'03',projectName,'');
		        }
			});
			$("#selectProductModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_nextStep").unbind("click");
			});
		} 
	}
	/**初始化列表***/
	function initProductTable(){
		$("#product-table").bootstrapTable('destroy');
		$('#product-table').bootstrapTable({
			method: 'get',
			columns: [
				{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
				{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
				{field:'productName',title:'产品流程名称',align:'center',formatter: function (value, row, index) {return row.productName;}},
				{field:'version',title:'版本号',align:'center',formatter: function (value, row, index) {return row.version;}},
				{field:'remark',title:'备注',align:'center',formatter: function (value, row, index) {return row.remark;}},
			],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>产品流程名称:</b> ' + row.productName + '</p>');
			        html.push('<p><b>版本号:</b> ' + row.version  + '</p>');
			        html.push('<p><b>备注:</b> ' + row.remark + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/gbpm/product/selectProductPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"isUsed":true};
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			singleSelect : true,// 单选checkbox
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
	};
	
})(jQuery, this);

$(function () {

	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_creditApply.initTable();
	};

	/**
	 * 新增授信申请
	 */
	$("#btn_addCreditApply").click(function(){
		window.parent.openMenu('add_creditApply','','授信申请登记','/project/credit/showCreditApplyAddPage','');
	});
	
	/**
	 * 同意立项
	 */
	$("#btn_agreeToCreditAccept").click(function(){
		$.zjm_creditApply.agreeToCreditAccept();
	});
	
	/**
	 * 不予立项
	 */
	$("#btn_disapproveApply").click(function(){
		var selectContent = $("#creditApply_table").bootstrapTable("getSelections");
		if(selectContent.length == 1){
			$("#creditApply_page").load("/project/credit/showDisapprovalPage",{},function(response,status,xhr){
				$("#disapprovalPage_applyID").val(selectContent[0].apply_ID);	//向不予立项页面的隐藏域设置值
				$("#disapprovalPage_projectName").html(selectContent[0].projectName);	//设置项目名称
				
				$("#disapprovalPage").modal({keyboard:true});
			});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
	
	/**
	 * 批量删除
	 */
	$("#btn_batchDeleteApply").click(function(){
		var selectContent = $("#creditApply_table").bootstrapTable("getSelections");
		if(selectContent.length == 0){
			$("#pleaseSelectOne").modal({keyboard:true});
		}else{
			$("#creditApply_page").load("/project/credit/showCreditApplyDelPage",{},function(response,status,xhr){
				$("#text_deleteWarning").text("是否删除下列授信申请？");
				$("#delCreditApply").modal({keyboard:true});
				$(".btn_submit").click(function(){
					$.map(selectContent, function(row,index) {//获取选中行;
						$.ajax({type:'POST',url:'/project/credit/deleteOneCreditApply',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj){
									$("#delCreditApply").modal("hide");
									$.zjm_creditApply.initTable();
								}else{
									alert("保存失败！");
								}
					        }
						});
					});
					/*var strIDs = "";
					for(var i=0; i<selectContent.length; i++){
						strIDs += selectContent[i].apply_ID+",";
					}
					console.info(strIDs);
					$.ajax({type:'POST',url:'/project/credit/batchDeleteApply',data:JSON.stringify(strIDs),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#delCreditApply").modal("hide");
								$.zjm_creditApply.initTable();
							}else{
								alert("保存失败！");
							}
				        }
					});*/
				});
				$("#delCreditApply").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			});
		}
	});
	
	/**
	 * 高级查询
	 */
	$("#btn_advancedQuery").click(function(){
		$("#creditApply_page").load("/project/credit/showCreditApplyAdQueryPage",{},function(){
			/*获取业务品种下拉选择树*/
			/*$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectBusiType").selectTreeWidgets({
						width : "87%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});*/
			/*获取合作机构下拉选择树*/
			/*$.ajax({type:'POST',url:'/sys/dic/selectBankSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectBank").selectTreeWidgets({
						width : "87%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});*/
			/*获取创建部门下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectAllDepartsTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectCreateDepart").selectTreeWidgets({
						width : "87%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			$("#creditApplyAdQuery").modal({keyboard:true});
			$(".btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_creditApplyAdQuery"});
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#form_creditApplyAdQuery");
				if(queryContainer_form.validationEngine("validate")){
					var data = queryContainer_form.serializeJson();
					$("#creditApplyAdQuery").modal("hide");
					$.zjm_creditApply.initTable(data);
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#creditApplyAdQuery").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	});
	
	/**
	 * 重置列表
	 */
	$("#btn_refreshTable").click(function(){
		$.zjm_creditApply.initTable();
	});
	
});


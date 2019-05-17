(function($,z){
	$.zjm_arcTransferList = {
			initFileTransferTable:initFileTransferTable,  //档案移交列表
			initTransferRecordsTable:initTransferRecordsTable, //移交记录列表
			newAddFileData:newAddFileData, //新增档案资料
			fileTransfer:fileTransfer, //档案移交
			oneFileTransfer:oneFileTransfer, //档案移交
			editArcTransfer:editArcTransfer, //修改档案资料信息
			delArcTransfer:delArcTransfer, //删除档案资料信息
	};
	var apply_ID = tool.getUrlParam('entityID');
	var type = tool.getUrlParam('type');
	initFileTransferTable();
	
	function initColumns(){
		var columns = [

			{field : 'checked', checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'arcTypeName',title:'档案类别',align:'center',formatter: function (value, row, index) {return row.arcTypeName;}},
			{field:'fileTitle',title:'文件标题（内容）',align:'center',formatter: function (value, row, index) {return row.fileTitle;}},
			{field:'pageCount',title:'页数',align:'center',formatter: function (value, row, index) {return row.pageCount;}},
			{field:'isOldArc',title:'是否原件',align:'center',formatter: function (value, row, index) {
				var isOldArc = row.isOldArc;
				if(isOldArc==null || typeof(isOldArc)==undefined){
					isOldArc = "-";
				}else{
					if(isOldArc==0){
						isOldArc = "否";
					}else{
						isOldArc = "是";
					}
				}
				return isOldArc;
			}},
			{field:'remark',title:'备注',align:'center',formatter: function (value, row, index) {return row.remark;}},
			
		];
		if(type=='edit'){
			columns.push({title: '操 作 ',align: 'center',formatter:function(value,row,index){//icon-mail-forward
				return ['<button class="btn_transact_view btn btn-xs btn-warning" title="移交""><i class="icon-mail-forward bigger-120"></i></button>',
					'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
					'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_transact_view': function(e, value, row, index) {//移交
						$.zjm_arcTransferList.oneFileTransfer(row);
					},
					'click .btn_modules_edit': function(e, value, row, index) {//修改
						$.zjm_arcTransferList.editArcTransfer(row);
					},
					'click .btn_modules_del': function(e, value, row, index) {//删除
						$.zjm_arcTransferList.delArcTransfer(row);
					}
					
				}
		});
		}
		return columns
	}
	/**初始化 档案移交 列表***/
	function initFileTransferTable(){
		$("#fileTransfer_table").bootstrapTable('destroy');
		$('#fileTransfer_table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			singleSelect:true,
			detailView: true,
			detailFormatter:function(index, row){
				var isOldArc = row.isOldArc;
				if(isOldArc==null || typeof(isOldArc)==undefined){
					isOldArc = "-";
				}else{
					if(isOldArc==0){
						isOldArc = "否";
					}else{
						isOldArc = "是";
					}
				}
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>档案类别:</b> ' +tool.isNull(row.arcTypeName,"（空）")+ '</p>');
			        html.push('<p><b>文件标题（内容）:</b> ' + tool.isNull(row.fileTitle,"（空）")  + '</p>');
			        html.push('<p><b>页数:</b> ' + tool.isNull(row.pageCount,"（空）")+ '</p>');
			        html.push('<p><b>是否原件:</b> ' + isOldArc + '</p>');
			        html.push('<p><b>备注:</b> ' + tool.isNull(row.remark,"（空）")+ '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			sortName:"updateDateTime",//排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 10,      //每页的记录行数（*）
			pageList: [10,30, 50, 100],  //可供选择的每页的行数（*）
			url: "/project/arcTransfer/selectFilesDataTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"queryCondition":{"apply_ID":apply_ID}});
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
	};
	
	/**初始化 移交记录 列表***/
	function initTransferRecordsTable(){
		$("#transferRecords_table").bootstrapTable('destroy');
		$('#transferRecords_table').bootstrapTable({
			method: 'get',
			columns: [
				{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
				{field:'arcTypeName',title:'档案类别',align:'center',formatter: function (value, row, index) {return row.arcTypeName;}},
				{field:'fileTitle',title:'文件标题（内容）',align:'center',formatter: function (value, row, index) {return row.fileTitle;}},
				{field:'pageCount',title:'页数',align:'center',formatter: function (value, row, index) {return row.pageCount;}},
				{field:'isOldArc',title:'是否原件',align:'center',formatter: function (value, row, index) {
					var isOldArc = row.isOldArc;
					if(isOldArc==null || typeof(isOldArc)==undefined){
						isOldArc = "-";
					}else{
						if(isOldArc==0){
							isOldArc = "否";
						}else{
							isOldArc = "是";
						}
					}
					return isOldArc;
				}},
				{field:'remark',title:'备注',align:'center',formatter: function (value, row, index) {return row.remark;}},
				{field:'transferDepart',title:'移交部门',align:'center',formatter: function (value, row, index) {return row.transferDepartName;}},
				{field:'transferUserName',title:'移交人',align:'center',formatter: function (value, row, index) {return row.transferUserName;}},
				{field:'receiveUserName',title:'接收人',align:'center',formatter: function (value, row, index) {return row.receiveUserName;}},
				{field:'transferDate',title:'移交日期',align:'center',formatter: function (value, row, index) {
					var transferDate = row.transferDate;
					if(transferDate==null || typeof(transferDate)==undefined){
						transferDate = "-";
					}else{
						transferDate = moment(transferDate).format("YYYY-MM-DD")
					}
					return transferDate;
					
				}}
			],
			detailView: true,
			detailFormatter:function(index, row){
				var isOldArc = row.isOldArc;
				if(isOldArc==null || typeof(isOldArc)==undefined){
					isOldArc = "-";
				}else{
					if(isOldArc==0){
						isOldArc = "否";
					}else{
						isOldArc = "是";
					}
				}
				var transferDate = row.transferDate;
				if(transferDate==null || typeof(transferDate)==undefined){
					transferDate = "-";
				}else{
					transferDate = moment(transferDate).format("YYYY-MM-DD")
				}
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>档案类别:</b> ' +tool.isNull(row.arcTypeName,"（空）")+ '</p>');
			        html.push('<p><b>文件标题（内容）:</b> ' + tool.isNull(row.fileTitle,"（空）")  + '</p>');
			        html.push('<p><b>页数:</b> ' + tool.isNull(row.pageCount,"（空）")+ '</p>');
			        html.push('<p><b>是否原件:</b> ' + isOldArc + '</p>');
			        html.push('<p><b>备注:</b> ' + tool.isNull(row.remark,"（空）")+ '</p>');
			        html.push('<p><b>移交部门:</b> ' + tool.isNull(row.transferDepartName,"（空）")+ '</p>');
			        html.push('<p><b>移交人:</b> ' + tool.isNull(row.transferUserName,"（空）")+ '</p>');
			        html.push('<p><b>接收人:</b> ' + tool.isNull(row.receiveUserName,"（空）")+ '</p>');
			        html.push('<p><b>移交日期:</b> ' + transferDate + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"transferDate",//排序字段
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 10,      //每页的记录行数（*）
			pageList: [10,30, 50, 100],  //可供选择的每页的行数（*）
			url: "/project/arcTransfer/selectTransferRecordsTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"queryCondition":{"apply_ID":apply_ID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			singleSelect : false,// 单选checkbox
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
	/**
	 * 新增档案资料
	 */
	function newAddFileData(){
		$("#newAddFileData_page").load("/project/arcTransfer/showNewAddFileDataPage",{"apply_ID":apply_ID},function(response,status,xhr){
			$("#newFileDataModal").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"newFileDataModal_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#newFileDataModal_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/arcTransfer/insertOneArcDirectory',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#newFileDataModal").modal("hide");
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
			$("#newFileDataModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 修改档案资料信息
	 */
	function editArcTransfer(row){
		$("#newAddFileData_page").load("/project/arcTransfer/showEditFileDataPage",{"arcDirectory_ID":row.arcDirectory_ID},function(response,status,xhr){
			$("#fileDataEditModal").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"fileDataEditModal_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#fileDataEditModal_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/arcTransfer/updateOneArcDirectory',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
							if(data.obj){
								$("#fileDataEditModal").modal("hide");
								initFileTransferTable();
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
			$("#fileDataEditModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	/**
	 * 删除档案资料信息
	 */
	function delArcTransfer(row){
		$("#newAddFileData_page").load("/project/arcTransfer/showDelFileDataPage",{},function(response,status,xhr){
			$("#delArcTransfers").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/arcTransfer/deleteOneArcDirectory',data:JSON.stringify({"arcDirectory_ID":row.arcDirectory_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delArcTransfers").modal("hide");
							initFileTransferTable();
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delArcTransfers").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 档案移交
	 */
	function oneFileTransfer(row){
		$("#fileTransfer_page").load("/project/arcTransfer/showFileTransferPage",{'arcDirectory_ID':row.arcDirectory_ID},function(response,status,xhr){
			$("#addFileTransfer").modal({keyboard:true});
			//注册编辑验证引擎
			zjm.validata({formId:"addFileTransfer_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addFileTransfer_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/arcTransfer/insertOneArcTransfer',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addFileTransfer").modal("hide");
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
			$("#addFileTransfer").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**
	 * 档案移交
	 */
	function fileTransfer(){
		
		var selectContent = $('#fileTransfer_table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') { 
        	$("#pleaseSelectOne").modal({keyboard:true});
        	return false;
            //alert("您还没选择一条记录，请您选择一条记录!");  
        }else{
        	var arcDirectory_ID = selectContent.arcDirectory_ID;
        	$("#fileTransfer_page").load("/project/arcTransfer/showFileTransferPage",{'arcDirectory_ID':arcDirectory_ID},function(response,status,xhr){
    			$("#addFileTransfer").modal({keyboard:true});
    			//注册编辑验证引擎
    			zjm.validata({formId:"addFileTransfer_form"});
    			tool.undisabled(".btn_submit");
    			$(".btn_submit").click(function(){
    				
    				tool.disabled(".btn_submit");
    				var queryContainer_form = $("#addFileTransfer_form");
    				if($(queryContainer_form).validationEngine("validate")){
    							$.ajax({type:'POST',url:'/project/arcTransfer/insertOneArcTransfer',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
    								success:function(data) {
    						        	if(data.obj){
    										$("#addFileTransfer").modal("hide");
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
    			$("#addFileTransfer").on("hidden.bs.modal", function (e) {//解除事件绑定
    				 $(".btn_submit").unbind("click");
    			});
    		});
        	
        }
	}
	
	
})(jQuery, this);

$(function() {
	/**
	 * 档案移交 列表
	 */
	$("#fileTransfer").click(function(){
		$.zjm_arcTransferList.initFileTransferTable();
	});
	
	/**
	 * 移交记录 列表
	 */
	$("#transferRecords").click(function(){
		$.zjm_arcTransferList.initTransferRecordsTable();
	});
	
	/**
	 * 新增档案资料
	 */
	$("#btn_newAddFileData").click(function(){
		$.zjm_arcTransferList.newAddFileData();
	});
	/**
	 * 档案移交
	 */
	$("#btn_fileTransfer").click(function(){
		$.zjm_arcTransferList.fileTransfer();
	});

});


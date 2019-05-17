(function($,z){
	$.zjm_projectPackage = {
			initColumns:initColumns,
			initNoPackageTable:initNoPackageTable,//初始化待打包项目列表
			initPackageTable:initPackageTable,//初始化已打包项目列表
			projectPackage:projectPackage,//项目打包
			delPackage:delPackage,//撤销打包
			delPackageBus:delPackageBus,//移出打包车
			packageViewModule:packageViewModule ,//打包项目查看
			noPackageViewProject:noPackageViewProject, // 未打包项目查看
			initProductTable :initProductTable, //初始化产品流程实例列表
			agreeProject:agreeProject // 同意立项
	};
		
	
	
	/**初始化 产品流程 列表***/
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
			pageSize: 10,      //每页的记录行数（*）
			pageList: [10,30, 50, 100],  //可供选择的每页的行数（*）
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
	
	
	function initColumns2(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return }},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'packageName',title:'打包项目名称',align:'center',formatter: function (value, row, index) {return row.packageName;}},
			{field:'createManName',title:'打包人',align:'center',formatter: function (value, row, index) {return row.createManName;}},
			{field:'createDateTime',title:'打包日期',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.createDateTime);}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_package_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_package_view': function(e, value, row, index) {
						$.zjm_projectPackage.packageViewModule(row);
					}
				}
			}
		];
		return columns;
	}	
	
	
	function initColumns(){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'proType',title:'类型',align:'center',formatter: function (value, row, index) {return row.projectType;}},
			{field:'clientName',title:'项目编号',align:'center',formatter: function (value, row, index) {return row.busiCode;}},
			{field:'projectName',title:'项目名称',align:'center',formatter: function (value, row, index) {
				return [ '<a class="btn_projectName_view" href="javascript:void(0)">'+ row.projectName + '</a>' ].join('');}
					,events : {
						'click .btn_projectName_view' : function(
								e, value, row, index) {
							$.zjm_projectPackage.noPackageViewProject(row);
						},
					}
				},
			{field:'departName',title:'经办部门',align:'center',formatter: function (value, row, index) {return row.departName;}},
			{field:'createManName',title:'经办人',align:'center',formatter: function (value, row, index) {return row.createManName;}},
			{field:'createDate',title:'受理日期',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.createDate);}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_noPackage_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'
					/*'<button class="btn_noPackage_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>'*/
					].join('');
				},
				events:{
					'click .btn_noPackage_view': function(e, value, row, index) {
						$.zjm_projectPackage.noPackageViewProject(row);
					}
				}
			}
		];
		return columns;
	};
	
	/**初始化列表***/
	function initNoPackageTable(condition){
		$("#package-table").bootstrapTable('destroy');
		$('#package-table').bootstrapTable({
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
				var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>类型：</b> ' + row.projectType + '</p>');
			        html.push('<p><b>项目编号：</b> ' + row.busiCode + '</p>');
			        html.push('<p><b>项目名称：</b> ' + row.projectName + '</p>');
			        html.push('<p><b>经办部门：</b> ' + row.departName + '</p>');
			        html.push('<p><b>经办人：</b> ' + row.createManName + '</p>');
			        html.push('<p><b>受理日期：</b> ' + tool.parseDate(row.createDate) + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			singleSelect : false,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"createDate",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50,100,200,500],  //可供选择的每页的行数（*）
			url: "/project/package/selectNoPackagePageTable",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			//queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
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
            exportDataType: "basic"              //basic', 'all', 'selected'
			});
	}
	
	/**初始化列表***/
	function initPackageTable(condition){
		$("#packageEnd-table").bootstrapTable('destroy');
		$('#packageEnd-table').bootstrapTable({
			method: 'get',
			columns: initColumns2(),
			detailView: true,
			detailFormatter:function(index, row){
				var html = [];
				html.push('<p><b>序号:</b> ' + tool.isNull((index+1),"") + '</p>');
		        html.push('<p><b>打包项目名称:</b> ' + tool.isNull(row.packageName,"（空）") + '</p>');
		        html.push('<p><b>打包人:</b> ' + tool.isNull(row.createManName,"（空）") + '</p>');
		        html.push('<p><b>打包日期:</b> ' + tool.isNull(tool.parseDate(row.createDateTime),"（空）") + '</p>');
				return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			singleSelect : true,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"createDate",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/package/selectPackagePageTable",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			//queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
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
			exportDataType: "basic"              //basic', 'all', 'selected'
				
		});
	};

	/***打包所选***/
	function projectPackage(){
		var selectContent = $('#package-table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{ 
        	var selectArray = $('#package-table').bootstrapTable('getSelections');
        	var applyIDS = $('#package-table').bootstrapTable('getSelections')[0].apply_ID;
        	for(var i=1;i<selectArray.length;i++){
        		applyIDS = applyIDS +','+ selectArray[i].apply_ID;
    		};
        	$("#projectPackage_page").load("/project/package/addPackagePage",{"applyIDS":applyIDS},function(response,status,xhr){
        		$("#packageAddModal").modal({keyboard:true});
        		zjm.init();
        		//**注册编辑验证引擎*//
        		zjm.validata({formId:"add_packageForm"});
        		//**提交 保存 新增企业信息*//*
        		tool.undisabled(".btn_submit");
        		$(".btn_submit").click(function(){
        			if($("#add_packageForm").validationEngine("validate")){
        				tool.disabled(".btn_submit");
        				var queryContainer_form = $("#add_packageForm");
        				$.ajax({
        					type : 'POST',
        					url : '/project/package/insertOnePackageInfo',
        					data : JSON.stringify(queryContainer_form.serializeJson()),
        					contentType : 'application/json; charset=UTF-8',
        					dataType : 'json',
        					success : function(data) {
        						if (data.obj == 1) {
        							$.zjm_projectPackage.initNoPackageTable(); //刷新待打包列表	
        							$("#packageAddModal").modal("hide"); //关闭 modal
        							$(".ztb_add").val(""); // 清空输入框
        						} else {
        							alert("保存失败！");
        						}
        					}
        				});
        			}else{
        				tool.undisabled(".btn_submit"); //解除按钮 可用
        			}
        		});
        		$("#packageAddModal").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
        			 $(".btn_submit").unbind("click");
        		});
        		
    		});
        	
        }
	};
	
	/***撤销打包***/
	function delPackage(){
		var selectContent = $('#packageEnd-table').bootstrapTable('getSelections')[0];  
		if(typeof(selectContent) == 'undefined') {  
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{ 
			$.map($('#packageEnd-table').bootstrapTable('getSelections'), function(row) {
	        	 $('#common_del').modal('show');  
	        	 $('#delModalLabel').text("撤销打包");
	        	 $('#delMessage').text("是否撤销所选打包项目？");
	             tool.undisabled(".btn_submit");
	     		$(".btn_submit").click(function(){
	     			tool.disabled(".btn_submit");
	     			$.ajax({type:'POST',url:'/project/package/delOnePackageInfo',data:row.package_ID,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	     		        	if(data.obj==true){
	     						$('#packageEnd-table').bootstrapTable('remove', {
	     							field: 'package_ID',
	     							values: [row.package_ID]
	     						});
	     						$.zjm_projectPackage.initPackageTable();
	     						$.zjm_projectPackage.initNoPackageTable();
	     						
	     						$("#common_del").modal("hide");
	     					}else{
	     						alert("删除失败！");
	     					}
	     		        }
	     			});
	     		});
	     		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
	     			 $(".btn_submit").unbind("click");
	     		});
	        });//多选
		}
	};
	
	/***移出打包车***/
	function delPackageBus(){
		var selectContent = $('#package-table').bootstrapTable('getSelections')[0];  
		if(typeof(selectContent) == 'undefined') {  
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{ 
			$.map($('#package-table').bootstrapTable('getSelections'), function(row) {
				$('#common_del').modal('show');  
				$('#delModalLabel').text("移出打包车");
				$('#delMessage').text("是否移出所选项目？");
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					$.ajax({type:'POST',url:'/project/package/delOnePackageBusInfo',data:row.apply_ID,contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==true){
							$('#package-table').bootstrapTable('remove', {
								field: 'apply_ID',
								values: [row.apply_ID]
							});
						//	$.zjm_projectPackage.initPackageTable();
							$("#common_del").modal("hide");
						}else{
							alert("删除失败！");
						}
					}
					});
				});
				$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			});//多选
		}
	};
	
	/***打包项目查看***/
	function packageViewModule(row){
		$("#projectPackage_page").load("/project/package/packageViewPage",{"package_ID":row.package_ID},function(response,status,xhr){
    		$("#packageViewModal").modal({keyboard:true});
		});
	};
	
	
	/**
	 * 	未打包项目查看
	 */
	function noPackageViewProject(row){
		$("#projectPackage_page").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
		});
	}
	
	/**
	 *  同意立项
	 */
	function  agreeProject(){
		var selectContent = $('#packageEnd-table').bootstrapTable('getSelections');  
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var selectContent = $('#packageEnd-table').bootstrapTable('getSelections')[0];
			var entityID = selectContent.package_ID;
			var projectName = selectContent.packageName;
			$("#selectProductModal").modal({keyboard:true});
			$(".sProjectName").html(projectName);
			$.zjm_projectPackage.initProductTable();
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
     				$.zjm_nodeTaskModal.initNodeTaskModal(selectContent.product_ID,'0',$("#userID").val(),$("#userName").val(),$("#userID").val(),$("#userName").val(),entityID,'02',projectName,'');
		        }
			});
			$("#selectProductModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_nextStep").unbind("click");
			});
		} 
	};
	
	
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		$.zjm_projectPackage.initNoPackageTable();
		$.zjm_projectPackage.initPackageTable();
	};
	
	/**
	 * 待打包项目
	 */
	$("#waitPackage").click(function(){
		$.zjm_projectPackage.initNoPackageTable();
	});
	
	/**
	 * 同意立项
	 */
	$("#btn_agreeProject").click(function(){
		$.zjm_projectPackage.agreeProject();
	});
	
	/**
	 * 已打包项目
	 */
	$("#alreadyPackage").click(function(){
		$.zjm_projectPackage.initPackageTable();
	});
	
	
	/**
	 * 项目打包
	 */
	$("#btn_projectPackage").click(function(){
		$.zjm_projectPackage.projectPackage();
	});
	
	/**
	 * 撤销打包
	 */
	$("#btn_delPackage").click(function(){
		$.zjm_projectPackage.delPackage();
	});
	
	/**
	 * 移出打包车
	 */
	$("#btn_delPackageBus").click(function(){
		$.zjm_projectPackage.delPackageBus();
	});

	/**
	 * 删除
	 */
	$("#btn_deleteOfSelected").click(function(){
		$.zjm_projectPackage.deleteOfSelected();
	});
	
	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_projectPackage.hightSelect();
	});
	
	$("#btn_refresh").click(function(){
		$.zjm_projectPackage.initNoPackageTable();
		$.zjm_projectPackage.initPackageTable();
	});
	
});


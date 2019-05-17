(function($,z){
	$.zjm_taskManager = {
		initTree:initTree,//加载树结构
		initTable:initTable,//初始化列表
		addTaskType:addTaskType,//添加任务事项类型
		editTaskType:editTaskType,//修改任务事项类型
		delTaskType:delTaskType,//删除任务事项类型
		addTaskManager:addTaskManager,//添加任务事项
		editTaskManager:editTaskManager,//修改任务事项
		viewTaskManager:viewTaskManager,//查看任务事项
		delTaskManager:delTaskManager//删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(taskType_ID){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/}};
		zTreeObj = tree.init({initID:"taskTypeTree",url:"/gbpm/taskType/selectAllTaskTypeListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_taskManager.initTable(treeNode.id);
		};
		if(taskType_ID==null){taskType_ID='ff467932922a4ccdad57b15d665cac6f';}
		$.zjm_taskManager.initTable(taskType_ID);
	}
	
	/**初始化列表***/
	function initTable(taskType_ID){
		$("#taskManager_table").bootstrapTable('destroy');
		$('#taskManager_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"taskCode",title: '任务事项编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.taskCode;}},
//					{field:"taskTypeID",title: '任务事项类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.taskTypeName;}},
					{field:"taskName",title: '任务事项名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.taskName;}}, 
					{field:"taskUrl",title: '任务事项办理URL',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.taskUrl;}},
					{field:"remark",title: '人工任务/系统任务',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.isPersonTask?"人工任务":"系统任务";}},
					{field:"taskManager_uuid",title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_taskManager.viewTaskManager(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_taskManager.editTaskManager(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_taskManager.delTaskManager(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
//				    html.push('<p><b>任务事项类型:</b> ' + row.taskTypeName + '</p>');
			        html.push('<p><b>任务事项编号:</b> ' + row.taskCode + '</p>');
			        html.push('<p><b>任务事项名称:</b> ' + row.taskName + '</p>');
			        html.push('<p><b>任务事项查看URL:</b> ' + row.viewTaskUrl + '</p>');
			        html.push('<p><b>任务事项办理URL:</b> ' + row.taskUrl + '</p>');
			        html.push('<p><b>人工任务/系统任务:</b> ' + (row.isPersonTask?'人工任务':'系统任务') + '</p>');
			        if (row.remark != null && typeof(row.remark)!= undefined && row.remark != '') { 
			        	html.push('<p><b>备注:</b> ' + row.remark + '</p>'); 
			        }else{
			        	html.push('<p><b>备注:</b> -</p>');
			        }
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"taskmanagerSort",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/gbpm/dicTaskManager/selectTaskManagerPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"taskType_ID":taskType_ID}});
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
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	}

	/**新增任务事项类型*/
	function addTaskType(id,name){
		$("#taskManager_page").load("/gbpm/taskType/addTaskTypePage",{},function(response,status,xhr){
			$("#addTaskType").modal({keyboard:true});
			$(".ztb_add_pTaskType_ID").val(id);
			$(".ztb_add_up_taskType_name").text(name);
			$(".icon-picker").iconPicker("add_wraper");
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_taskType_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_taskType_form");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("add_taskTypeName","/gbpm/taskType/selectTaskTypeNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"同级任务事项类型名称重复！")){
						$.ajax({type:'POST',url:'/gbpm/taskType/insertOneTaskType',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
							success:function(data) {
					        	if(data.obj){
									$("#addTaskType").modal("hide");
									$.zjm_taskManager.initTree();
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
			$("#addTaskType").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**任务事项类型修改**/
	function editTaskType(id,name,ppnode){
		$("#taskManager_page").load("/gbpm/taskType/editTaskTypePage",{},function(response,status,xhr){
			$("#editTaskType").modal({keyboard:true});
			$(".ztb_edit_taskType_ID").val(id);
			$("#edit_taskTypeName").val(name);
			$(".ztb_edit_pTaskType_ID").val(ppnode.id);
			$(".icon-picker").iconPicker("edit_wraper");
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_taskType_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#edit_taskType_form");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("edit_taskTypeName","/gbpm/taskType/selectTaskTypeNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"同级任务事项类型名称重复！")){
						$.ajax({type:'POST',url:'/gbpm/taskType/updateOneTaskType',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
							success:function(data) {
					        	if(data.obj){
									$("#editTaskType").modal("hide");
									$.zjm_taskManager.initTree();
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
			$("#editTaskType").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}

	/**任务事项类型删除***/
	function delTaskType(id,name,ppnode){
		//两个ID相等说明是根节点不可删除
		if(ppnode==id){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("根节点不能删除");
			return false;
		} else {
			$("#common_del").modal({keyboard:true});
			$("#delModalLabel").html("删除任务事项类型");
			$("#delMessage").html("是否删除此任务事项类型？");
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',
					url:'/gbpm/taskType/deleteOneTaskTypeInfo',
					data:JSON.stringify({"taskType_ID":id,"taskTypeName":name}),
					contentType:'application/json; charset=UTF-8',
					dataType:'json',
					success:function(data) {
			        	if(data.obj==true){
							$('#user-table').bootstrapTable('remove', {
								field: 'taskType_ID',
								values: [id]
							});
							$.zjm_taskManager.initTree(ppnode);
							$("#common_del").modal("hide");
						}else{
							tool.undisabled(".btn_submit");
//							$("#operateFailModule").modal({keyboard:true});
						}
		        }
			});
			});
			$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		}
	}
	
	/**新增任务事项*/
	function addTaskManager(id,name){
		$("#taskManager_page").load("/gbpm/dicTaskManager/showTaskManagerAddPage",{},function(response,status,xhr){
			$("#addTaskManager").modal({keyboard:true});
			
			$("#taskType_ID").val(id);
			$(".ztb_add_up_taskTypeName").text(name);
			$(".icon-picker").iconPicker("add_wraper");
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_taskManager_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_taskManager_form");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("add_taskCode","/gbpm/dicTaskManager/isExistTaskCode",JSON.stringify(queryContainer_form.serializeJson()),"任务事项编号重复！")){
						if(zjm.ajaxValidata("add_taskName","/gbpm/dicTaskManager/isExistTaskName",JSON.stringify(queryContainer_form.serializeJson()),"任务事项名称重复！")){
							$.ajax({type:'POST',url:'/gbpm/dicTaskManager/insertOneTaskManager',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
									if(data.obj){
										$("#addTaskManager").modal("hide");
										$.zjm_taskManager.initTable(id);
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
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addTaskManager").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	/**查看任务事项*/
	function viewTaskManager(row){
		$("#taskManager_page").load("/gbpm/dicTaskManager/showTaskManagerViewPage",{"taskManager_ID":row.taskManager_ID},function(response,status,xhr){
			$("#viewTaskManager").modal({keyboard:true});
		});
	}
	
	/**修改任务事项*/
	function editTaskManager(row){
		$("#taskManager_page").load("/gbpm/dicTaskManager/showTaskManagerEditPage",{"taskManager_ID":row.taskManager_ID},function(response,status,xhr){
			$("#edit_taskManagerID").val(row.taskManager_ID);
			$("#editTaskManager").modal({keyboard:true});
			zjm.init();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_taskManager_form"});
			
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectAllTaskTypeListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
				$("#tasktype_id").selectTreeWidgets({
					width : "90%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
		        }
		    });
			
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#edit_taskManager_form");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("add_taskCode","/gbpm/dicTaskManager/isExistTaskCode",JSON.stringify(queryContainer_form.serializeJson()),"任务事项编号重复！")){
						if(zjm.ajaxValidata("add_taskName","/gbpm/dicTaskManager/isExistTaskName",JSON.stringify(queryContainer_form.serializeJson()),"任务事项名称重复！")){
							$.ajax({type:'POST',url:'/gbpm/dicTaskManager/updateOneTaskManager',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#editTaskManager").modal("hide");
										var node = tree.getChecke();
										if(node != null){
											$.zjm_taskManager.initTable(node.id);
										}else{
											$.zjm_taskManager.initTable("ff467932922a4ccdad57b15d665cac6f");
										}
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
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editTaskManager").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**删除任务事项*/
	function delTaskManager(row){
		$("#taskManager_page").load("/gbpm/dicTaskManager/showTaskManagerDelPage",{},function(response,status,xhr){
			$("#delTaskManager").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/gbpm/dicTaskManager/deleteOneTaskManager',data:JSON.stringify({"taskManager_ID":row.taskManager_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delTaskManager").modal("hide");
							var node = tree.getChecke();
							if(node != null){
								$.zjm_taskManager.initTable(node.id);
							}else{
								$.zjm_taskManager.initTable("ff467932922a4ccdad57b15d665cac6f");
							}
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delTaskManager").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_taskManager.initTree();
		$(".form-control-ztb").attr("placeholder",'输入任务事项名称,按回车搜索');
	};
	
	//添加部门
	$("#btn_addTaskType").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选择一个任务事项类型，然后再操作!");
			return false;
		}
		//最多五级任务事项类型
		if(node.level >= 4){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("不能添加下级任务事项类型，做多五级!");
			return false;
		}
		$.zjm_taskManager.addTaskType(node.id,node.name);
	});
	
	//修改任务实现类型
	$("#btn_editTaskType").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;
		}
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		$.zjm_taskManager.editTaskType(node.id,node.name,ppnode);
	});
	
	//删除任务事项类型
	$("#btn_delTaskType").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选择一个任务事项类型，然后再操作!");
			return false;
		}
		var ppnode;
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		$.zjm_taskManager.delTaskType(node.id,node.name,ppnode);
	});
	
	
	//添加任务事项
	$("#btn_addTaskManager").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选择一个任务事项类型，然后再操作!");
			return false;
		}
		$.zjm_taskManager.addTaskManager(node.id,node.name);
	});
	
	
	//改变任务事项同级顺序
	$("#btn_taskManagerSort").click(function(){
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选择一个任务事项类型，然后再操作!");
			return false;
		}
		$("#taskManager_page").load("/gbpm/dicTaskManager/selectTaskManagerListPage",{"taskType_ID":node.id},function(response,status,xhr){
			$("#sortop").modal({keyboard:true});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				var obj = document.getElementById('OrderContent');
				var options = obj.options;
				for(var i=0,len=options.length;i<len;i++){
				    var opt = options[i];
				    $.ajax({type:'POST',url:'/gbpm/dicTaskManager/updateOneTaskManager',data:JSON.stringify({"taskManager_ID":opt.value,"taskmanagerSort":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#sortop").modal("hide");
						}else{
							alert("保存失败！");
						}
					}
					});
				}
				$("#sortop").modal("hide");
				$.zjm_taskManager.initTable(node.id);
				$("#sortop").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_reset").unbind("click");
					 $(".btn_submit").unbind("click");
					 $("#btn_moveUp").unbind("click");
					 $("#btn_moveDown").unbind("click");
					 $("#btn_moveTop").unbind("click");
					 $("#btn_moveBottom").unbind("click");
				});
			});
		});
	});
	
	//改变任务事项类型同级顺序
	$("#btn_sortTaskType").click(function(){
		var node = tree.getChecke();
		var ppnode;
		if(node.level == 0){
			ppnode=node.id
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("根节点无法排序!");
			return false;
		}else{
			ppnode=node.getParentNode().id
		}
		if(node == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选择一个任务事项类型，然后再操作!");
			return false;
		}
		$("#taskManager_page").load("/gbpm/taskType/sortNodeTaskPage",{"pTaskType_ID":ppnode},function(response,status,xhr){
			$("#sortop").modal({keyboard:true});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				var obj = document.getElementById('OrderContent');
				var options = obj.options;
				for(var i=0,len=options.length;i<len;i++){
				    var opt = options[i];
				    $.ajax({type:'POST',url:'/gbpm/taskType/updateOneTaskType',data:JSON.stringify({"taskType_ID":opt.value,"taskTypeName":opt.text,"taskTypeSort":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#sortop").modal("hide");
						}else{
							alert("保存失败！");
						}
					}
					});
				}
				$("#sortop").modal("hide");
				$.zjm_taskManager.initTree();
				$("#sortop").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_reset").unbind("click");
					 $(".btn_submit").unbind("click");
					 $("#btn_moveUp").unbind("click");
					 $("#btn_moveDown").unbind("click");
					 $("#btn_moveTop").unbind("click");
					 $("#btn_moveBottom").unbind("click");
				});
			});
		});
	});
	
});

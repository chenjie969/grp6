(function($,z){
	$.zjm_productNode = {
			initTree:initTree,//加载树结构
			initTable:initTable,//初始化任务事项列表
			addProductNode:addProductNode,//产品节点添加
			addMuchProductNode:addMuchProductNode,//产品节点批量添加
			editProductNode:editProductNode,//产品节点修改
			delProductNode:delProductNode,//产品节点删除
			addNodeTask:addNodeTask,//节点任务添加
			addMuchNodeTask:addMuchNodeTask,//节点任务添加
			editModule:editModule,//产品节点修改
			delModule:delModule//产品节点删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(productNodeID,lastIsParent){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/gbpm/productNode/selectProductNodeListByProductID?product_ID="+$("#product_ID").val()},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_productNode.initTable(treeNode.id,treeNode.isParent);
		};
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
			$.each(nodes,function(index,element){
				if(nodes[index].id == productNodeID){
					zTreeObj.selectNode(nodes[index]);
					zTreeObj.expandNode(nodes[index],true,false,true);
				}
			})
		};
		if(productNodeID==null){productNodeID=$("#product_ID").val();}
		if(lastIsParent||typeof lastIsParent == 'undefined'){
			$.zjm_productNode.initTable(productNodeID,true);
		}else{
			$.zjm_productNode.initTable(productNodeID,false);
		}
	}
	/**初始化列表***/
	function initTable(nodeid,isParent){
		$("#productNodeID").val(nodeid);
		$("#test-table").bootstrapTable('destroy');
		$('#test-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"dicTypeName",title: '任务事项',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.taskName;}}, 
					{field:"beforeTaskName",title: '前置任务',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.beforeTaskName;}},
					{field:"afterTaskNameList",title: '后置任务',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.afterTaskNameList;}},
					{field:"warnMethodIDList",title: '提醒方式',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.warnMethodNameList;}},
					{field:"operaterTypeName",title: '操作者类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operaterTypeName;}},
					{field:"operatorName",title: '操作者',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operatorName;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return [
								'<button class="btn_dicType_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_dicType_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
//							'<button class="btn_dicType_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
//							'click .btn_dicType_view': function(e, value, row, index) {
//								$.zjm_productNode.viewModule(row);
//							},
							'click .btn_dicType_edit': function(e, value, row, index) {
								$.zjm_productNode.editModule(row);
							},
							'click .btn_dicType_del': function(e, value, row, index) {
								$.zjm_productNode.delModule(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>任务事项:</b> ' + row.taskName + '</p>');
			        html.push('<p><b>前置任务:</b> ' + row.beforeTaskName + '</p>');
			        html.push('<p><b>后置任务:</b> ' + row.afterTaskNameList+ '</p>');
			        html.push('<p><b>提醒方式:</b> ' + row.warnMethodNameList + '</p>');
			        html.push('<p><b>操作者类型:</b> ' + row.operaterTypeName + '</p>');
			        html.push('<p><b>操作者:</b> ' + row.operatorName + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"taskSort",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/gbpm/nodeTask/selectNodeTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(isParent){
					$.extend(params, {"queryCondition":{"productID":nodeid}});
				}else{
					$.extend(params, {"queryCondition":{"productNodeID":nodeid}});
				}
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
	};


	/**节点添加*/
	function addProductNode(){
		if(zjm.ajaxValidata("add_prductName","/gbpm/productInstance/isExistProductInstance",JSON.stringify({"productID":$("#product_ID").val()}),"产品流程名称已存在！")){
			$("#loadPage").load("/gbpm/productNode/addProductNodePage",{"product_ID":$("#product_ID").val()},function(response,status,xhr){
				$("#addProductNodeModal").modal({keyboard:true});
				zjm.init();
				/**注册编辑验证引擎*/
				zjm.validata({formId:"add_productNode_form"});
				$('#nodeID').change(function(){ 
					var p1=$(this).children('option:selected').text();//这就是selected的值 
					$('#nodeNames').val(p1);
				});
				/**提交*/
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#add_productNode_form").validationEngine("validate")){
						var queryContainer_form = $("#add_productNode_form");
							$.ajax({type:'POST',url:'/gbpm/productNode/insertOneProductNode',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
										$("#addProductNodeModal").modal("hide");
										$.zjm_productNode.initTree();
									}else{
										alert("保存失败！");
										tool.undisabled(".btn_submit");
									}
						        }
							});
							tool.undisabled(".btn_submit");
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#addProductNodeModal").on("hidden.bs.modal", function (e) {//解除事件绑定
					 $(".btn_submit").unbind("click");
				});
			});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("产品流程已被实例化，请创建新版本再操作！")
		}
	};
	
	/**节点批量添加*/
	function addMuchProductNode(){
		if(zjm.ajaxValidata("add_prductName","/gbpm/productInstance/isExistProductInstance",JSON.stringify({"productID":$("#product_ID").val()}),"产品流程名称已存在！")){
			$("#loadPage").load("/gbpm/productNode/addMuchProductNodePage",{"product_ID":$("#product_ID").val()},function(response,status,xhr){
				$("#addProductNodeModal").modal({keyboard:true});
				zjm.init();
				$.ajax({type:'POST',
					url:'/gbpm/dicNode/selectNodeTree',	
					data:JSON.stringify({}),
					contentType:'application/json; charset=UTF-8',
					dataType:'json',
					success:function(data) {
					$("#nodeid").selectTreeWidgets({
						width : "90%",//设置控件宽度
						multiple : true,//是否多选
						data : data.obj//数据源
						});
			        }
			    });
				/**注册编辑验证引擎*/
				zjm.validata({formId:"add_productNode_form"});
				$('#nodeID').change(function(){ 
					var p1=$(this).children('option:selected').text();//这就是selected的值 
					$('#nodeNames').val(p1);
				});
				/**提交*/
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#add_productNode_form").validationEngine("validate")){
						var queryContainer_form = $("#add_productNode_form");
						$.ajax({type:'POST',url:'/gbpm/productNode/insertOneProductNode',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#addProductNodeModal").modal("hide");
								$.zjm_productNode.initTree();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
						});
						tool.undisabled(".btn_submit");
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#addProductNodeModal").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("产品流程已被实例化，请创建新版本再操作！")
		}
	};
	
	/**节点修改*/
	function editProductNode(){
		if(zjm.ajaxValidata("edit_prductName","/gbpm/productInstance/isExistProductInstance",JSON.stringify({"productID":$("#product_ID").val()}),"产品流程名称已存在！")){
			var node = tree.getChecke();
			if(node == null || node.pId == null){
				$("#pleaseSelectOne").modal({keyboard:true});
				$("#message").html("请选中一个节点再操作!");
				return false;
			};
			$("#loadPage").load("/gbpm/productNode/editProductNodePage",{"productNode_ID":node.id},function(response,status,xhr){
				$("#editProductNodeModal").modal({keyboard:true});
				zjm.init();
				/**注册编辑验证引擎*/
				zjm.validata({formId:"edit_productNode_form"});
				$('#nodeID').change(function(){ 
					var p1=$(this).children('option:selected').text();//这就是selected的值 
					$('#nodeNames').val(p1);
				});
				/**提交*/
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#edit_productNode_form").validationEngine("validate")){
						var queryContainer_form = $("#edit_productNode_form");
						$.ajax({type:'POST',url:'/gbpm/productNode/updateOneProductNodeInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#editProductNodeModal").modal("hide");
								$.zjm_productNode.initTree();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
						});
						tool.undisabled(".btn_submit");
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#editProductNodeModal").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("产品流程已被实例化，请创建新版本再操作！")
		}
	};
	
	
	/**节点任务添加*/
	function addNodeTask(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		}
		$("#loadPage").load("/gbpm/nodeTask/addNodeTaskPage",{"productNode_ID":node.id},function(response,status,xhr){
			$("#addNodeTaskModal").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"add_nodeTask_form"});
			
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectAllTaskTypeTaskListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
				$("#taskmanager_id").selectTreeWidgets({
					width : "90%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
		        }
		    });
			
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectBeforeTaskTypeTaskListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
					$("#beforetaskmanager_id").selectTreeWidgets({
						width : "90%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectAfterTaskTypeTaskListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
					$("#aftertaskmanager_id").selectTreeWidgets({
						width : "90%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			
			$('#warnMethod').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#warnMethodNameList').val(p1);
			});
			$('#process').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#processName').val(p1);
			});
			$('#operatorID').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#operatorName').val(p1);
			});
			$('#operaterTypeID').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#operaterTypeName').val(p1);
				if(p1 == "角色中任何人" || p1== "角色中某一人"){
					$("#operatorID").addClass("validate[required]");
					$("#operatorIDDiv").show();
				}else{
					$("#operatorID").removeClass("validate[required]");
					document.getElementById("operatorID").options[0].selected = true; 
					$('#operatorName').val('');
					$("#operatorIDDiv").hide();
				}
			});
			$('#isBeforeTask').change(function(){ 
				var isBeforeTask= $('input:radio[name="isBeforeTask"]:checked').val();
				if(isBeforeTask == "true"){
					$("#beforetaskmanager_id").addClass("validate[required]");
					$("#beforeTaskID").show();
				}else{
					$("#beforetaskmanager_id").removeClass("validate[required]");
					$("#beforeTaskID").hide();
				}
			});
			$('#isAfterTask').change(function(){ 
				var processID= $('input:radio[name="isAfterTask"]:checked').val();
				if(processID == "true"){
					$("#aftertaskmanager_id").addClass("validate[required]");
					$("#afterTaskIDList").show();
				}else{
					$("#aftertaskmanager_id").removeClass("validate[required]");
					$("#afterTaskIDList").hide();
				}
			});
			//zjm.dataViewValSelect("select_education", "/selectDicTypeSelectJSON", {"dicTypePID" : 'a6ebbf73cbd44232a28c453a3d65ecd8'});//获取教育程度下拉框
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#add_nodeTask_form").validationEngine("validate")){
					var queryContainer_form = $("#add_nodeTask_form");
					$.ajax({type:'POST',url:'/gbpm/nodeTask/insertOneNodeTask',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#addNodeTaskModal").modal("hide");
							$.zjm_productNode.initTable(node.id,false);
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
					});
					tool.undisabled(".btn_submit");
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addNodeTaskModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	/**批量添加节点任务*/
	function addMuchNodeTask(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		}
		$("#loadPage").load("/gbpm/nodeTask/addMuchNodeTaskPage",{"productNode_ID":node.id},function(response,status,xhr){
			$("#addMuchNodeTaskModal").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"add_much_nodeTask_form"});
			
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectAllTaskTypeTaskListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
					$("#taskmanager_id").selectTreeWidgets({
						width : "90%",//设置控件宽度
						multiple : true,//是否多选
						data : data.obj//数据源
					});
				}
			});
			
			$('#warnMethod').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#warnMethodNameList').val(p1);
			});
			$('#operatorID').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#operatorName').val(p1);
			});
			$('#operaterTypeID').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#operaterTypeName').val(p1);
				if(p1 == "角色中任何人" || p1== "角色中某一人"){
					$("#operatorID").addClass("validate[required]");
					$("#operatorIDDiv").show();
				}else{
					$("#operatorID").removeClass("validate[required]");
					document.getElementById("operatorID").options[0].selected = true; 
					$('#operatorName').val('');
					$("#operatorIDDiv").hide();
				}
			});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#add_much_nodeTask_form").validationEngine("validate")){
					var queryContainer_form = $("#add_much_nodeTask_form");
					$.ajax({type:'POST',url:'/gbpm/nodeTask/insertMuchNodeTask',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#addMuchNodeTaskModal").modal("hide");
							$.zjm_productNode.initTable(node.id,false);
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
					});
					tool.undisabled(".btn_submit");
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addMuchNodeTaskModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	/**节点删除*/
	function delProductNode(){
		if(zjm.ajaxValidata("add_prductName","/gbpm/productInstance/isExistProductInstance",JSON.stringify({"productID":$("#product_ID").val()}),"产品流程名称已存在！")){
			var node = tree.getChecke();
			if(node == null || node.pId == null){
				$("#pleaseSelectOne").modal({keyboard:true});
				$("#message").html("请选中一个节点再操作!");
				return false;
			};
			$("#common_del").modal({keyboard:true});
			$("#delModalLabel").html("删除产品节点");
			$("#delMessage").html("是否删除选中的产品节点？");
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/gbpm/productNode/deleteOneProductNode',data:JSON.stringify({"productNode_ID":node.id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==1){
						$("#common_del").modal("hide");
						$.zjm_productNode.initTree();
					}else{
						alert("删除失败！");
						tool.undisabled(".btn_submit");
					}
				}
				});
				tool.undisabled(".btn_submit");
			});
			$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("产品流程已被实例化，请创建新版本再操作！")
		}
	}
	
	/**节点任务事项修改**/
	function editModule(row){
		$("#loadPage").load("/gbpm/nodeTask/editNodeTaskPage",{"nodeTask_ID":row.nodeTask_ID},function(response,status,xhr){
			$("#editNodeTaskModal").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"edit_nodeTask_form"});
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectAllTaskTypeTaskListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
				$("#taskmanager_id").selectTreeWidgets({
					width : "90%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
		        }
		    });
			
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectAllTaskTypeTaskListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
					$("#beforetaskmanager_id").selectTreeWidgets({
						width : "90%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			
			$.ajax({type:'POST',
				url:'/gbpm/taskType/selectAllTaskTypeTaskListTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
					$("#aftertaskmanager_id").selectTreeWidgets({
						width : "90%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			/**提交*/
			tool.undisabled(".btn_submit");
			$('#taskManger').change(function(){ 
				var p=$(this).children('option:selected').text();//这就是selected的值 
				$('#taskName').val(p);
			});
			$('#warnMethod').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#warnMethodNameList').val(p1);
			});
			$('#process').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#processName').val(p1);
			});
			$('#operatorID').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#operatorName').val(p1);
			});
			$('#operaterTypeID').change(function(){ 
				var p1=$(this).children('option:selected').text();//这就是selected的值 
				$('#operaterTypeName').val(p1);
				if(p1 == "角色中任何人" || p1== "角色中某一人"){
					$("#operatorID").addClass("validate[required]");
					$("#operatorIDDiv").show();
				}else{
					$("#operatorID").removeClass("validate[required]");
					document.getElementById("operatorID").options[0].selected = true; 
					$('#operatorName').val('');
					$("#operatorIDDiv").hide();
				}
			});
			$('#isBeforeTask').change(function(){ 
				var isBeforeTask= $('input:radio[name="isBeforeTask"]:checked').val();
				if(isBeforeTask == "true"){
					$("#beforetaskmanager_id").addClass("validate[required]");
					$("#beforeTaskID").show();
				}else{
					$("#beforetaskmanager_id").removeClass("validate[required]");
					$("#beforeTaskID").hide();
				}
			});
			$('#isAfterTask').change(function(){ 
				var processID= $('input:radio[name="isAfterTask"]:checked').val();
				if(processID == "true"){
					$("#aftertaskmanager_id").addClass("validate[required]");
					$("#afterTaskIDList").show();
				}else{
					$("#aftertaskmanager_id").removeClass("validate[required]");
					$("#afterTaskIDList").hide();
				}
			});
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#edit_nodeTask_form").validationEngine("validate")){
					var queryContainer_form = $("#edit_nodeTask_form");
					$.ajax({type:'POST',url:'/gbpm/nodeTask/updateOneNodeTask',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#editNodeTaskModal").modal("hide");
							$.zjm_productNode.initTable(row.productNodeID,false);;
						}else{
							alert("保存失败！");
							tool.undisabled(".btn_submit");
						}
					}
					});
					tool.undisabled(".btn_submit");
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editNodeTaskModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	/**节点任务事项删除***/
	function delModule(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").html("删除节点任务事项");
		$("#delMessage").html("是否删除选中的节点任务事项？");
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/gbpm/nodeTask/deleteOneNodeTask',data:JSON.stringify({"nodeTask_ID":row.nodeTask_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					$("#common_del").modal("hide");
					var node = tree.getChecke();
					if(node == null || node.pId == null){
						$.zjm_productNode.initTable(row.productID,true);
						return false;
					}else{
						$.zjm_productNode.initTable(row.productNodeID,false);
					}
				}else{
					alert("删除失败！");
					tool.undisabled(".btn_submit");
				}
			}
			});
			tool.undisabled(".btn_submit");
		});
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			$(".btn_submit").unbind("click");
		});
	}

})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 产品节点信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_productNode.initTree();
	};
	//添加节点
	$("#btn_addProductNode").click(function(){
		$.zjm_productNode.addProductNode();
	});
	//批量添加节点
	$("#btn_addMuchProductNode").click(function(){
		$.zjm_productNode.addMuchProductNode();
	});
	//修改节点
	$("#btn_editProductNode").click(function(){
		$.zjm_productNode.editProductNode();
	});
	//删除节点
	$("#btn_delProductNode").click(function(){
		$.zjm_productNode.delProductNode();
	});
	//添加节点任务事项
	$("#btn_addNodeTask").click(function(){
		$.zjm_productNode.addNodeTask();
	});
	//批量添加节点任务事项
	$("#btn_addMuchNodeTask").click(function(){
		$.zjm_productNode.addMuchNodeTask();
	});
	
	//改变节点同级顺序
	$("#btn_sortProductNode").click(function(){
		if(zjm.ajaxValidata("add_prductName","/gbpm/productInstance/isExistProductInstance",JSON.stringify({"productID":$("#product_ID").val()}),"产品流程名称已存在！")){
			var node = tree.getChecke();
			$("#loadPage").load("/gbpm/productNode/sortProudctNode",{"product_ID":$("#product_ID").val()},function(response,status,xhr){
				$("#sortop").modal({keyboard:true});
				tool.sort();
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function () {
					tool.disabled(".btn_submit");
					var obj = document.getElementById('OrderContent');
					var options = obj.options;
					for(var i=0,len=options.length;i<len;i++){
					    var opt = options[i];
					    $.ajax({type:'POST',url:'/gbpm/productNode/updateSortProductNode',data:JSON.stringify({"productNode_ID":opt.value,"nodeSort":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#sortop").modal("hide");
							}else{
								alert("保存失败！");
							}
						}
						});
					}
					$("#sortop").modal("hide");
					$.zjm_productNode.initTree();
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
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("产品流程已被实例化，请创建新版本再操作！")
		}
	});
	
	//改变节点任务顺序
	$("#btn_nodeTaskSort").click(function(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		};
		$("#loadPage").load("/gbpm/nodeTask/sortNodeTask",{"productNodeID":node.id},function(response,status,xhr){
			$("#sortop").modal({keyboard:true});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				var obj = document.getElementById('OrderContent');
				var options = obj.options;
				for(var i=0,len=options.length;i<len;i++){
					var opt = options[i];
					$.ajax({type:'POST',url:'/gbpm/nodeTask/updateSortNodeTask',data:JSON.stringify({"nodeTask_ID":opt.value,"taskSort":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#sortop").modal("hide");
						}else{
							alert("保存失败！");
						}
					}
					});
				}
				$("#sortop").modal("hide");
				$.zjm_productNode.initTable(node.id,false);
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


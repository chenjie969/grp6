(function($,z){
	$.zjm_processDefinition = {
			initTree:initTree,//加载树结构
			initTable:initTable,//初始化列表
			config:config,//配置
			modelAdd:modelAdd,//新建
			deploy:deploy,//发布
			importAddxml:importAddxml,//更新导入
			del:del//删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(nodeId){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/gbpm/actSort/selectActSortListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_processDefinition.initTable(treeNode.id);
		};
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
				$.each(nodes,function(index,element){
					if(nodes[index].id == nodeId){
						zTreeObj.selectNode(nodes[index]);
						zTreeObj.expandNode(nodes[index],true,false,true);
					}
				})
		};
		if(nodeId==null){nodeId='';}
		$.zjm_processDefinition.initTable(nodeId);
	}
	/**初始化列表***/
	function initTable(nodeid){
		$("#definition-table").bootstrapTable('destroy');
		$('#definition-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{title: '流程模板名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.name;}}, 
					{title: '类别',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.actSortName;}}, 
					{title: '发布状态',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.deploymentId==null?"未发布":"已发布";}}, 
					{title: '创建时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDateDetail(row.createTime);}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							
						return ['<div class="inline position-relative" >'+
	                            '<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">'+
	                                '<i class="icon-chevron-down icon-only bigger-110"></i>'+
	                            '</button>'+
	                            '<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close" style="width:375px;">'+
	                               // '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-info"><span class="orange2"><i class="icon-zoom-in bigger-120"></i>查看</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" onclick="window.parent.open(\'/modeler.jsp?modelId='+row.modelID+'\')" class="tooltip-success"><span class="blue"><i class="icon-edit bigger-120"></i>设计</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-success btn_config"><span class="dark"><i class="icon-cog bigger-120"></i>配置</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-success btn_deploy"><span class="green"><i class="icon-share-alt bigger-120"></i>发布</span></a></li>'+
	                                //'<li class="pull-left"><a style="cursor:pointer;" class="tooltip-success"><span class="orange"><i class="icon-upload-alt bigger-120"></i>导入</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" onclick="window.parent.open(\'/gbpm/processDefinition/selectProcessDefinitionExport?modelId='+row.modelID+'\')" class="tooltip-success"><span class="purple"><i class="icon-download-alt bigger-120"></i>导出</span></a></li>'+
	                                '<li class="pull-left"><a style="cursor:pointer;" class="tooltip-error btn_del"><span class="red"><i class="icon-trash bigger-120"></i>删除</span></a></li>'+
	                            '</ul>'+
	                        '</div>'].join('');
						},
						events:{
							
							'click .btn_config': function(e, value, row, index) {
								$.zjm_processDefinition.config(row);
							},
							'click .btn_deploy': function(e, value, row, index) {
								$.zjm_processDefinition.deploy(row);
							},
							'click .btn_del': function(e, value, row, index) {
								$.zjm_processDefinition.del(row);
							}
						}
					}],
			/*detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			    return html;
			},*/
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/gbpm/processDefinition/selectProcessDefinitionPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params, {"queryCondition":{"actSortID":nodeid}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: true,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	};
	/**配置**/
	function config(row){
		$("#processDefinitionConfig").modal({keyboard:true});
	};
	/**新建流程模板**/
	function modelAdd(nodeid){
		$("#processDefinition_page").load(
				"/gbpm/processDefinition/selectProcessDefinitionModelAddPage",{"actSortID":nodeid},function(response,status,xhr){
					$("#processDefinitionModelAdd").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#add_model_form").validationEngine("validate")){
							var queryContainer_form = $("#add_model_form");
							$.ajax({type:'POST',url:'/gbpm/processDefinition/createProcessDefinitionModel',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==1){
									$("#processDefinitionModelAdd").modal("hide");
									$('#definition-table').bootstrapTable('refresh');
								}else{
									alert("新建失败！");
									tool.undisabled(".btn_submit");
								}
							}
							});
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	};
	/**发布**/
	function deploy(row){
		$("#processDefinition_page").load(
				"/gbpm/processDefinition/selectProcessDefinitionDeployAddPage",{},function(response,status,xhr){
					$("#processDefinitionDeployAdd").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/gbpm/processDefinition/createProcessDefinitionDeploy',data:JSON.stringify({"modelId":row.modelID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#processDefinitionDeployAdd").modal("hide");
								$('#definition-table').bootstrapTable('refresh');
							}else{
								alert("发布失败！");
								tool.undisabled(".btn_submit");
							}
						}
						});
					});
				}
		);
	};
	
	
	
	
	
	
	/**更新导入**/
	function importAddxml(nodeid){
		$("#processDefinition_page").load(
				"/gbpm/processDefinition/selectProcessDefinitionImportAddPage",{"actSortID":nodeid},function(response,status,xhr){
					$("#processDefinitionImportAdd").modal({keyboard:true});
					zjm.init();
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#add_model_form").validationEngine("validate")){
							var queryContainer_form = new FormData($("#add_model_form")[0]);
							$.ajax({type:'POST',url:'/gbpm/processDefinition/selectProcessDefinitionImportAdd',data:queryContainer_form,contentType:false,processData: false,dataType:'json',success:function(data) {
								if(data.obj==1){
									$("#processDefinitionImportAdd").modal("hide");
									$('#definition-table').bootstrapTable('refresh');
								}else{
									alert("导入失败！");
									tool.undisabled(".btn_submit");
								}
							}
							});
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	};
	/**删除流程模板**/
	function del(row){
		$("#processDefinition_page").load(
				"/gbpm/processDefinition/selectProcessDefinitionModelDelPage",{},function(response,status,xhr){
					$("#processDefinitionModelDel").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/gbpm/processDefinition/delectProcessDefinitionModel',data:JSON.stringify({"modelId":row.modelID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#processDefinitionModelDel").modal("hide");
								$('#definition-table').bootstrapTable('refresh');
							}else{
								alert("删除失败！");
								tool.undisabled(".btn_submit");
							}
						}
						});
					});
				}
		);
	};
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 岗位信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_processDefinition.initTree();
	};
	
	
	$("#btn_add").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个流程分类!");
			return false;
		}
		$.zjm_processDefinition.modelAdd(node.id);
	});
	$("#btn_importAdd").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个流程分类!");
			return false;
		}
		$.zjm_processDefinition.importAddxml(node.id);
	});
});


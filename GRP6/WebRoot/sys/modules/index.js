(function($,z){
	$.zjm_module = {
			initTree:initTree,//加载树结构
			initTable:initTable,//初始化列表
			addModule:addModule,//菜单添加
			viewModule:viewModule,//菜单查看
			editModule:editModule,//菜单修改
			delModule:delModule//菜单删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(mod_uid){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/selectAllModulesListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
		
			$.zjm_module.initTable(treeNode.id,isChild);
		};
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
				$.each(nodes,function(index,element){
					if(nodes[index].id == mod_uid){
						zTreeObj.selectNode(nodes[index]);
						zTreeObj.expandNode(nodes[index],true,false,true);
					}
				})
		};
		if(mod_uid==null){mod_uid='9cf65ae4911a4e7bac532be9e492af23';}
		$.zjm_module.initTable(mod_uid);
	}
	/**初始化列表***/
	function initTable(nodeid,isChild){
		$("#test-table").bootstrapTable('destroy');
		$('#test-table').bootstrapTable({
			method: 'get',
			columns: [
				    {title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"mod_name",title: '菜单名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.mod_name;}}, 
					{field:"url",title: 'URL地址',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.url;}},
					{field:"isReload",title: '是否自动刷新',align: 'center',sortable:"true",formatter: function (value, row, index) { if(row.isReload==1){return '是'}else{ return '否'};}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_module.viewModule(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_module.editModule(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_module.delModule(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>菜单名称:</b> ' + row.mod_name + '</p>');
			        html.push('<p><b>URL地址:</b> ' + row.url + '</p>');
			        if(row.isReload){
			        	 html.push('<p><b>是否自动刷新:</b> 是</p>');
		        	}else{
		        		 html.push('<p><b>是否自动刷新:</b> 否</p>');
	        		}
			    return html;
			},
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
			url: "/selectModulesPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(isChild || typeof isChild == 'undefined'){
					$.extend(params, {"queryCondition":{"pmod_id":nodeid}});
				}else{
					$.extend(params, {"queryCondition":{"mod_uid":nodeid}});
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
	}


	/**菜单添加*/
	function addModule(id,name,ppnode){
		$("#addmodule").modal({keyboard:true});
		$(".ztb_add_pmod_id").val(id);
		$(".ztb_add_up_mod_name").text(name);
		$(".ztb_add_mod_type").val(ppnode);
		$(".icon-picker").iconPicker("add_wraper");
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_form"});
		
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#add_form").validationEngine("validate")){
				var queryContainer_form = $("#add_form");
				//if(zjm.ajaxValidata("add_mod_name","/selectAddModulesNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"菜单名称重复！")){
					$.ajax({type:'POST',url:'/insertOneModulesInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#addmodule").modal("hide");
								$(".ztb_add").val("");
								$.zjm_module.initTree(id);
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
				        }
					});
				//}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/***菜单查看***/
	function viewModule(row){
		$("#viewmodule").modal({keyboard:true});
		zjm.dataViewText("view_","/selectOneModulesInfo",{"mod_uid":row.mod_uid},"");
	}
	/**菜单修改**/
	function editModule(row){
		$("#editmodule").modal({keyboard:true});
		$(".icon-picker").iconPicker("edit_wraper");
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		zjm.dataViewVal("edit_","/selectOneModulesInfo",{"mod_uid":row.mod_uid},"");
		/**重置 */
		$(".btn_reset").click(function(){
			zjm.dataViewVal("edit_","/selectOneModulesInfo",{"mod_uid":row.mod_uid},"");
		});
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#edit_form").validationEngine("validate")){
				/*if(zjm.ajaxValidata("edit_mod_name","/selectEditModulesNameIsExist",{"mod_name":$("#edit_mod_name").val(),"mod_uid":$("#edit_mod_uid").val()},"菜单名称重复！")){*/
					var queryContainer_form = $("#edit_form");
					$.ajax({type:'POST',url:'/updateOneModulesInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#editmodule").modal("hide");
								$.zjm_module.initTree(row.pmod_id);
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
				        }
					});
				/*}*/
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}
	/**菜单删除***/
	function delModule(row){
		$("#delmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/deleteOneModulesInfo',data:JSON.stringify({"mod_uid":row.mod_uid}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$.zjm_module.initTree(row.pmod_id);
						$("#delmodule").modal("hide");
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#delmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}

})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_module.initTree();
	};

	$("#btn_add").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个菜单!");
			return false;
		}
		
		if(node.level == 0){ppnode=node.mod_type}
		if(node.level == 1){ppnode=node.getParentNode().mod_type}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().mod_type}
		if(node.level == 3){ppnode=node.getParentNode().getParentNode().getParentNode().mod_type}
		if(node.level == 4){ppnode=node.getParentNode().getParentNode().getParentNode().getParentNode().mod_type}
		//最多5级菜单
		if(node.level >= 5){
			alert("不能添加下级菜单!");
			return false;
		}
		$.zjm_module.addModule(node.id,node.name,ppnode);
	});
	$("#btn_sort").click(function(){
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个菜单!");
			return false;
		}
		if(node.level == 0){
			alert("系统分类不允许排序!");
			return false;
		}
		$("#sortop").modal({keyboard:true});
		zjm.dataSortVal("/selectModulesListJSON",{"pmod_id":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/updateSortOrder',data:JSON.stringify({"tableName":"sys_modules","tableFileName":"mod_uid","tableFileIds":$("#tableFileIds").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					$("#sortop").modal("hide");
					$.zjm_module.initTree();
				}else{
					alert("保存失败！");
					$.zjm_module.initTree();
				}
		        }
			});
		});
		$(".btn_reset").click(function () {
			zjm.dataSortVal("/selectModulesListJSON",{"pmod_id":node.pId});
		});
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


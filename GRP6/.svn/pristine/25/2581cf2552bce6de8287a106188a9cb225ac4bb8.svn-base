(function($,z){
	$.zjm_materialTree = {
			initTree:initTree,//加载客户资料类型树结构
			initTable:initTable,//初始化任务事项列表
			addMaterialTree:addMaterialTree,//客户资料清单类型添加
			addMaterialDetail:addMaterialDetail,//客户资料添加
			editMaterialTree:editMaterialTree,//客户资料清单类型修改
			delMaterialTree:delMaterialTree,//客户资料清单类型删除
			
			editModule:editModule,//客户资料修改
			delModule:delModule,//客户资料删除
			viewModule:viewModule,//客户资料查询详情
			sortMaterialTree:sortMaterialTree,//客户资料类型同级顺序调整
			sortMaterialDetail:sortMaterialDetail,//客户资料名称同级顺序调整
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(materialTree_ID,lastIsParent){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/}};
		zTreeObj = tree.init({initID:"materialTree",url:"/client/materialTree/selectMaterialTreeByModelID?materialModel_ID="+$("#materialModel_ID").val()},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_materialTree.initTable(treeNode.id,treeNode.isParent);
		};
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
			$.each(nodes,function(index,element){
				if(nodes[index].id == materialTree_ID){
					zTreeObj.selectNode(nodes[index]);
					zTreeObj.expandNode(nodes[index],true,false,true);
				}
			})
		};
		if(materialTree_ID==null){materialTree_ID=$("#materialModel_ID").val();}
		if(lastIsParent||typeof lastIsParent == 'undefined'){
			$.zjm_materialTree.initTable(materialTree_ID,true);
		}else{
			$.zjm_materialTree.initTable(materialTree_ID,false);
		}
	}
	/**初始化列表***/
	function initTable(nodeid,isParent){
		$("#materialTree_ID").val(nodeid);
		$("#test-table").bootstrapTable('destroy');
		$('#test-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"materialTreeName",title: '客户资料类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.materialTreeName;}}, 
					{field:"materialName",title: '资料名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.materialName;}}, 
					{field:"materialType",title: '资料类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.materialType;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return [
								'<button class="btn_material_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_material_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_material_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_material_view': function(e, value, row, index) {
								$.zjm_materialTree.viewModule(row);
							},
							'click .btn_material_edit': function(e, value, row, index) {
								$.zjm_materialTree.editModule(row);
							},
							'click .btn_material_del': function(e, value, row, index) {
								$.zjm_materialTree.delModule(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>客户资料类型:</b> ' + row.materialTreeName + '</p>');
			        html.push('<p><b>资料名称:</b> ' + row.materialName + '</p>');
			        html.push('<p><b>资料类型:</b> ' + row.materialType + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"order_id",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/client/materialDetail/selectMaterialDetailPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(isParent){
					$.extend(params, {"queryCondition":{"materialTree_ID":nodeid}});
				}else{
					$.extend(params, {"queryCondition":{"materialTree_ID":nodeid}});
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


	/**客户资料清单添加*/
	function addMaterialTree(id,name,ppnode){
		$("#materialTreeSet_Page").load("/client/materialTree/returnMaterialTreeAddPage",{"materialModel_ID":$("#materialModel_ID").val()},function(response,status,xhr){
			$("#materialTreeAdd_page").modal({keyboard:true});
			$("#pmaterialTree_ID").val(id);
			$("#materialModelID").val(ppnode);
			$("#pmaterialTreeName").text(name);
			
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"materialTreeAdd_form"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				// 按钮置为不可用，防止重复提交
				if ($("#materialTreeAdd_form").validationEngine("validate")) {
					var materialTreeName =	$("#materialTreeName").val();
					var queryContainer_form = $("#materialTreeAdd_form");
					 if(zjm.ajaxValidata("materialTreeName","/client/materialTree/isExistMaterialTree",JSON.stringify(queryContainer_form.serializeJson()),"客户资料类型名称重复！")){
						tool.disabled(".btn_submit"); // 按钮变为不可用
						$.ajax({
							type : 'POST',
							url : '/client/materialTree/insertOneMaterialTree',
							data : JSON.stringify(queryContainer_form.serializeJson()),
							contentType : 'application/json; charset=UTF-8',
							dataType : 'json',
							success : function(data) {
								if (data.obj) { //新增的 业务品种不为null,则添加成功
									$("#materialTreeAdd_page").modal("hide");
									$.zjm_materialTree.initTree(id);
								} else {
									alert("保存失败！");
								}
							}
						});
					 } 
					 tool.undisabled(".btn_submit");
				} else {
					tool.undisabled(".btn_submit");
				}
				});
			$("#materialTreeAdd_page").on("hidden.bs.modal", function(e) {// 解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	};
	
	
	/**客户资料类型修改*/
	function editMaterialTree(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		};
		$("#materialTreeSet_Page").load("/client/materialTree/returnMaterialTreeEditPage",{"materialTree_ID":node.id},function(response,status,xhr){
			$("#materialTreeEdit_page").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"materialTreeEdit_form"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				// 按钮置为不可用，防止重复提交
				if ($("#materialTreeEdit_form").validationEngine("validate")) {
					var materialTreeName =	$("#materialTreeName").val();
					var queryContainer_form = $("#materialTreeEdit_form");
					 if(zjm.ajaxValidata("materialTreeName","/client/materialTree/isExistMaterialTree",JSON.stringify(queryContainer_form.serializeJson()),"客户资料类型名称重复！")){
						tool.disabled(".btn_submit"); // 按钮变为不可用
						$.ajax({
							type : 'POST',
							url : '/client/materialTree/updateOneaterialTree',
							data : JSON.stringify(queryContainer_form.serializeJson()),
							contentType : 'application/json; charset=UTF-8',
							dataType : 'json',
							success : function(data) {
								if (data.obj) { //新增的 业务品种不为null,则添加成功
									$("#materialTreeEdit_page").modal("hide");
									$.zjm_materialTree.initTree(node.id);
								} else {
									alert("保存失败！");
								}
							}
						});
					 } 
					 tool.undisabled(".btn_submit");
				} else {
					tool.undisabled(".btn_submit");
				}
			});
			$("#materialTreeEdit_page").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	
	};
	
	
	/**客户资料添加*/
	function addMaterialDetail(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		}
		$("#materialTreeSet_Page").load("/client/materialDetail/returnMaterialDetailAddPage",{"materialTree_ID":node.id},function(response,status,xhr){
			$("#materialDetailAdd_page").modal({keyboard:true});
		/*	$("#materialTree_ID").text(node.name);*/
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"materialDetailAdd_form"});
			
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#materialDetailAdd_form").validationEngine("validate")){
					var queryContainer_form = $("#materialDetailAdd_form");
					$.ajax({type:'POST',url:'/client/materialDetail/insertOneMaterialDetail',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#materialDetailAdd_page").modal("hide");
							$.zjm_materialTree.initTable(node.id,false);
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
			$("#materialDetailAdd_page").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	
	/**客户资料类型删除*/
	function delMaterialTree(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		};
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").html("提示");
		$("#delMessage").html("是否删除此客户资料类型？");
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/client/materialTree/deleteOneMaterialTree',data:JSON.stringify({"materialTree_ID":node.id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					$("#common_del").modal("hide");
					$.zjm_materialTree.initTree();
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
	
	/**客户资料修改**/
	function editModule(row){
		$("#materialTreeSet_Page").load("/client/materialDetail/returnMaterialDetailEditPage",{"materialDetail_ID":row.materialDetail_ID},function(response,status,xhr){
			$("#materialDetailEdit_page").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"materialDetailEdit_form"});
			
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#materialDetailEdit_form").validationEngine("validate")){
					var queryContainer_form = $("#materialDetailEdit_form");
					$.ajax({type:'POST',url:'/client/materialDetail/updateOneMaterialDetail',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#materialDetailEdit_page").modal("hide");
							$.zjm_materialTree.initTable(row.materialTree_ID,false);;
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
			$("#materialDetailEdit_page").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	//查看客户资料清单详情
	function viewModule(row){
		$("#materialTreeSet_Page").load("/client/materialDetail/materialDetailViewPage",{"materialDetail_ID":row.materialDetail_ID},function(response,status,xhr){
			$("#materialDetailInfo_page").modal({keyboard:true});
		});
	}
	/**客户资料删除***/
	function delModule(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").html("提示");
		$("#delMessage").html("是否删除选中的客户资料？");
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/client/materialDetail/deleteOneMaterialDetail',data:JSON.stringify({"materialDetail_ID":row.materialDetail_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					$("#common_del").modal("hide");
					var node = tree.getChecke();
					if(node == null || node.pId == null){
						$.zjm_materialTree.initTable(row.materialTree_ID,true);
						return false;
					}else{
						$.zjm_materialTree.initTable(row.materialTree_ID,false);
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
	//客户资料类型同级顺序调整
	function sortMaterialTree(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		};
		$("#materialTreeSet_Page").load("/client/materialTree/sortMaterialTree",{"pmaterialTree_ID":node.pId},function(response,status,xhr){
			$("#sortop").modal({keyboard:true});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				var obj = document.getElementById('OrderContent');
				var options = obj.options;
				for(var i=0,len=options.length;i<len;i++){
				    var opt = options[i];
				    $.ajax({type:'POST',url:'/client/materialTree/updateSortMaterialTree',data:JSON.stringify({"materialTree_ID":opt.value,"order_id":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#sortop").modal("hide");
							$.zjm_materialTree.initTree();
						}else{
							alert("保存失败！");
						}
					}
					});
				}
			});	
			$(".btn_reset").click(function () {
				$.ajax({type:'POST',url:"/client/materialTree/selectMaterialTreeListJSON",data:JSON.stringify({"pmaterialTree_ID":node.pId}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	$(".ztb_sort").empty();
		        	if(data.obj!=null)
					$.each(data.obj, function(key1, value1){
						$.each(value1, function(key2, value2){
						$(".ztb_sort").append("<option value='"+key2+"'>"+value2+"</option>");
						}); 
					}); 
		        }
			});
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
	
	
	}
	//客户资料名称同级顺序调整
	function  sortMaterialDetail(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选中一个节点再操作!");
			return false;
		};
		$("#materialTreeSet_Page").load("/client/materialDetail/sortMaterialDetail",{"materialTree_ID":node.id},function(response,status,xhr){
			$("#sortop").modal({keyboard:true});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				var obj = document.getElementById('OrderContent');
				var options = obj.options;
				for(var i=0,len=options.length;i<len;i++){
				    var opt = options[i];
				    $.ajax({type:'POST',url:'/client/materialDetail/updateSortMaterialDetail',data:JSON.stringify({"materialDetail_ID":opt.value,"order_id":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#sortop").modal("hide");
							$.zjm_materialTree.initTree(node.id);
						}else{
							alert("保存失败！");
						}
					}
					});
				}
			});	
			$(".btn_reset").click(function () {
				$.ajax({type:'POST',url:"/client/materialDetail/selectMaterialDetailListJSON",data:JSON.stringify({"materialTree_ID":node.id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	$(".ztb_sort").empty();
		        	if(data.obj!=null)
					$.each(data.obj, function(key1, value1){
						$.each(value1, function(key2, value2){
						$(".ztb_sort").append("<option value='"+key2+"'>"+value2+"</option>");
						}); 
					}); 
		        }
			});
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
	
	
	
	}

})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 产品节点信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_materialTree.initTree();
	};
	//添加客户资料类型
	$("#btn_addMaterialTree").click(function(){
		var ppnode;//新增
		var node = tree.getChecke();
		if (node == null) {
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("请选择一个客户资料类型!")
			return false;
		}
		//新增 ppnode
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		//if(node.level == 3){ppnode=node.getParentNode().getParentNode().getParentNode().id}
		
		// 最多两级业务品种
		if (node.level >=2) {
			$("#pleaseSelectOne").modal({keyboard:true});
			$("#message").html("不能添加下级客户资料类型!")
			return false;
		}	
		$.zjm_materialTree.addMaterialTree(node.id,node.name,ppnode);
	});
	//修改节点
	$("#btn_editMaterialTree").click(function(){
		$.zjm_materialTree.editMaterialTree();
	});
	//删除节点
	$("#btn_delMaterialTree").click(function(){
		$.zjm_materialTree.delMaterialTree();
	});
	//添加客户资料
	$("#btn_addMaterialDetail").click(function(){
		$.zjm_materialTree.addMaterialDetail();
	});
	
	//客户资料同级顺序
	$("#btn_sortMaterialTree").click(function(){
		$.zjm_materialTree.sortMaterialTree();
	});
	
	//客户资料名称同级顺序调整
	$("#btn_sortMaterialDetail").click(function(){
		$.zjm_materialTree.sortMaterialDetail();
	});
});


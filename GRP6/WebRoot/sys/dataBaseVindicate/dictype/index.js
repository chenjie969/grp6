(function($,z){
	$.zjm_dictype = {
			initTree:initTree,//加载树结构
			initTable:initTable,//初始化列表
			addModule:addModule,//字典添加
			viewModule:viewModule,//字典查看
			editModule:editModule,//字典修改
			delModule:delModule//字典删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(dicTypeID,lastIsParent){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/selectAllDicTypeListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_dictype.initTable(treeNode.id,treeNode.isParent);
		};
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
			$.each(nodes,function(index,element){
				if(nodes[index].id == dicTypeID){
					zTreeObj.selectNode(nodes[index]);
					zTreeObj.expandNode(nodes[index],true,false,true);
				}
			})
		};
		if(dicTypeID==null){dicTypeID='109db432755c4f7ba0610be16df3bea7';}
		if(lastIsParent||typeof lastIsParent == 'undefined'){
			$.zjm_dictype.initTable(dicTypeID,true);
		}else{
			$.zjm_dictype.initTable(dicTypeID,false);
		}
	}
	/**初始化列表***/
	function initTable(nodeid,isParent){
		$("#lastTableDictypeID").val(nodeid);
		$("#test-table").bootstrapTable('destroy');
		$('#test-table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"dicTypeName",title: '字典名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.dicTypeName;}}, 
					{field:"isDefault",title: '是否缺省',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.isDefault==0?"否":"是";}},
					{field:"isEable",title: '状态',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.isEable==0?"启用":"禁用";}},
					{field:"remark",title: '备注',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.remark;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							var arr = new Array();
							arr[0] = '<button class="btn_dicType_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>';
							arr[1] = '<button class="btn_dicType_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>';
							if(!row.isDefault){
								arr[2] = '<button class="btn_dicType_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>';
							}
							return arr.join('');
						},
						events:{
							'click .btn_dicType_view': function(e, value, row, index) {
								$.zjm_dictype.viewModule(row);
							},
							'click .btn_dicType_edit': function(e, value, row, index) {
								$.zjm_dictype.editModule(row);
							},
							'click .btn_dicType_del': function(e, value, row, index) {
								$.zjm_dictype.delModule(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>字典名称:</b> ' + row.dicTypeName + '</p>');
			        html.push('<p><b>是否缺省:</b> ' + (row.isDefault==0?"否":"是") + '</p>');
			        html.push('<p><b>状态:</b> ' + (row.isEable==0?"启用":"禁用") + '</p>');
			        html.push('<p><b>备注:</b> ' + row.remark + '</p>');
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
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/selectDicTypePageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(isParent){
					$.extend(params, {"queryCondition":{"dicTypePID":nodeid}});
				}else{
					$.extend(params, {"queryCondition":{"dicTypeID":nodeid}});
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


	/**字典添加*/
	function addModule(id,name,ppnode){
		$("#addmodule").modal({keyboard:true});
		$(".ztb_add_dicTypePID").val(id);
		$(".ztb_add_up_dicTypeName").text(name);
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_form"});
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#add_form");
			if(queryContainer_form.validationEngine("validate")){
			/*	if(zjm.ajaxValidata("add_dicTypeName","/isExistDictypeNameForALL",JSON.stringify({"dicTypeName":$("#add_dicTypeName").val()}),"字典名称重复！")){	//全部单级字典检查		*/
				if(zjm.ajaxValidata("add_dicTypeName","/isExistDictypeNameForParent",JSON.stringify(queryContainer_form.serializeJson()),"字典名称重复！")){	//同级目录字典检查
					$.ajax({type:'POST',url:'/insertOneDicTypeInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#addmodule").modal("hide");
								$(".ztb_add").val("");
								$.zjm_dictype.initTree(id);
							}else{
								alert("保存失败！");
							}
				        }
					});
				}
				else{
					tool.undisabled(".btn_submit");
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/***字典查看***/
	function viewModule(row){
		$("#viewmodule").modal({keyboard:true});
//		zjm.dataViewText("view_","/selectOneDicTypeInfo",{"dicTypeID":row.dicTypeID},"");
		$.ajax({type:'POST',url:"/selectOneDicTypeInfo",data:JSON.stringify({"dicTypeID":row.dicTypeID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				$.each(data.obj, function(key, value){ 
    				$(".ztb_view_"+key).text(value);
    				if(key=="isDefault"){
    					$(".ztb_view_isDefault").text(value==0?"否":"是");
    				}
    				if(key=="isEable"){
    					$(".ztb_view_isEable").text(value==0?"启用":"禁用");
    				}
				});
	        }
		});
	}
	/**字典修改**/
	function editModule(row){
		$("#editmodule").modal({keyboard:true});
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		zjm.dataViewVal("edit_","/selectOneDicTypeInfo",{"dicTypeID":row.dicTypeID},"");
		if(row.isEable==0){
			$("#edit_form input[name='isEable']").first().prop("checked","checked");
			$("#edit_form input[name='isEable']").last().prop("checked");
		}else{
			$("#edit_form input[name='isEable']").last().prop("checked","checked");
			$("#edit_form input[name='isEable']").first().prop("checked");
		}
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			var queryContainer_form = $("#edit_form");
			if(queryContainer_form.validationEngine("validate")){
			/*	if(zjm.ajaxValidata("edit_dicTypeName","/isExistDictypeNameForALL",JSON.stringify({"dicTypeName":$("#edit_dicTypeName").val()}),"字典名称重复！")){	//全部单级字典检查		*/
				if(zjm.ajaxValidata("edit_dicTypeName","/isExistDictypeNameForParent",JSON.stringify(queryContainer_form.serializeJson()),"字典名称重复！")){	//同级目录字典检查
					$.ajax({type:'POST',url:'/updateOneDicTypeInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#editmodule").modal("hide");
								$.ajax({type:'POST',url:'/selectDicTypePageTables',data:JSON.stringify({"queryCondition":{"dicTypePID":$("#lastTableDictypeID").val()}}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									//修改后刷新列表，取的是上一次查询列表的ID
										if(data.obj.rows.length==0){	//没有查到数据，说明是叶子节点	
											$.zjm_dictype.initTree($("#lastTableDictypeID").val(),false);
										}else{							
											$.zjm_dictype.initTree($("#lastTableDictypeID").val(),true);
										}
									}
								});
							}else{
								alert("保存失败！");
							}
				        }
					});
				}
				else{
					tool.undisabled(".btn_submit");
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}
	/**字典删除***/
	function delModule(row){
		$("#delmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/deleteOneDicTypeInfo',data:JSON.stringify({"dicTypeID":row.dicTypeID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#test-table').bootstrapTable('remove', {
							field: 'dicTypeID',
							values: [row.dicTypeID]
						});
						$.zjm_dictype.initTree(row.dicTypePID);
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
	 * 文档加载的时候 读取 字典信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_dictype.initTree();
	};

	$("#btn_add").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;
		}
		
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		//最多两级字典
		if(node.level >= 2){
			$("#stopAdd").modal({keyboard:true});
			return false;
		}
		$.zjm_dictype.addModule(node.id,node.name,ppnode);
	});
	//改变同级顺序
	$("#btn_sort").click(function(){
		var node = tree.getChecke();
		if(node == null || node.pId == null){
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;
		}
		$("#sortop").modal({keyboard:true});
		zjm.dataSortVal("/selectDicTypeListJSON",{"dicTypePID":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/updateSortOrder',data:JSON.stringify({"tableName":"c_dictype","tableFileName":"dicTypeID","tableFileIds":$("#tableFileIds").val()}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					$("#sortop").modal("hide");
					$.zjm_dictype.initTree();
				}else{
					alert("保存失败！");
					$.zjm_dictype.initTree();
				}
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
});


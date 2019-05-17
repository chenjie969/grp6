/**
 * 业务品种js代码
 */

(function($, z) {
	$.zjm_BusiSort = {
		initTree : initTree,// 加载树结构
		initTable : initTable,// 初始化列表
		addBusiSort : addBusiSort,// 业务品种 添加
		viewBusiSort : viewBusiSort,// 业务品种 查看
		editBusiSort : editBusiSort,// 业务品种 修改
		delBusiSort : delBusiSort, // 业务品种 删除
	
	};
	var zTreeObj; // ztree对象
	/** 加载树结构 */
	function initTree(busiSortID,isChild) {
		var setting = {
			callback : {
				onClick : zTreeOnMouseDown/** 捕获 zTree 上鼠标按键按下后的事件回调函数* */
				,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/
			}
		};
		// 初始化加载左侧树形结构
		zTreeObj = tree.init({
			initID : "menuSetTree",
			url : "/selectAllBusiSortListTree"
		}, setting);
		
		/** 单击 节点 触发的函数* */
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
			
			$.zjm_BusiSort.initTable(treeNode.id,isChild);
		};
		
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
				$.each(nodes,function(index,element){
					if(nodes[index].id == busiSortID){
						zTreeObj.selectNode(nodes[index]);
						zTreeObj.expandNode(nodes[index],true,false,true);
					}
				})
		};
		
		if (busiSortID == null) {
			busiSortID = '418f0975f373470581711826bf5b3711';
		}
		
		$.zjm_BusiSort.initTable(busiSortID,isChild);
	}

	/** 初始化列表** */
	function initTable(nodeid,isChild) {
		$("#lastTableDictypeID").val(nodeid);
		$("#test-table").bootstrapTable('destroy');
		$('#test-table')
				.bootstrapTable(
						{
							method : 'get',
							columns : [
									{
										title : '序号',
										align : 'center',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : "busisortname",
										title : '业务品种名称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.busisortname;
										}
									},
									{
										field : "unificationid",
										title : '对应监管机构业务品种编号',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.unificationid;
										}
									},
									{
										field : "isDefault",
										title : '是否缺省',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											// 系统自带还是用户自定义 -- 调整为   是否缺省 (是/否)
											if(row.isDefault == 1){
												return '是';
											}else{
												return '否';
											}
										}
									},
									{
										field : "iseable",
										title : '状态',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											// 是否禁用 -- 状态
											if(row.iseable == 1){
												return '禁用';
											}else{
												return '启用';
											}
											
										}
									},		
									{
										title : '操作',
										align : 'center',
										formatter : function(value, row, index) {
											return [
													'<button class="btn_BusiSorts_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button class="btn_BusiSorts_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
													'<button class="btn_BusiSorts_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
													.join('');
										},
										// 事件绑定
										events : {
											'click .btn_BusiSorts_view' : function(
													e, value, row, index) {
												$.zjm_BusiSort
														.viewBusiSort(row);
											},
											'click .btn_BusiSorts_edit' : function(
													e, value, row, index) {
												$.zjm_BusiSort
														.editBusiSort(row);
											},
											'click .btn_BusiSorts_del' : function(
													e, value, row, index) {
												$.zjm_BusiSort.delBusiSort(row);
											}
										}
									} ],
							detailView : true,
							detailFormatter : function(index, row) {
								var iseable="";
								if(row.iseable == 1){
									iseable="禁用";
								}else{
									iseable="启用";
								}
								var isDefault="";
								if(row.isDefault ==1){
									isDefault="是";
								}else{
									isDefault="否";
								}
								var html = [];
								html.push('<p><b>业务品种名称:</b> '+ row.busisortname + '</p>');
								html.push('<p><b>对应监管机构业务品种编号:</b> '+ row.unificationid + '</p>');
								html.push('<p><b>是否缺省:</b> '+ isDefault + '</p>');
								html.push('<p><b>状态:</b> ' +iseable+ '</p>');
										
								return html;
							},
							toolbar : '#toolbar', // 工具按钮用哪个容器
							striped : true, // 是否显示行间隔色
							cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
							pagination : true, // 设置为 true 会在表格底部显示分页条
							paginationLoop : true,// 设置为 true 启用分页条无限循环的功能。
							sortable : true, // 是否启用排序
							sortOrder : "asc", // 排序方式
							pageNumber : 1, // 初始化加载第一页，默认第一页
							pageSize : 30, // 每页的记录行数（*）
							pageList : [30,50,100,200,500], // 可供选择的每页的行数（*）
							// 该url是用于实现右侧列表显示的
							url : "/selectBusiSortsPageTables",// 这个接口需要处理bootstrap
							// //
							// table传递的固定参数
							// url 连接中的参数
							queryParamsType : '', // 默认值为 'limit' ,在默认情况下//
							// 传给服务端的参数为：offset,limit,sort
							// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
							queryParams: function(params) {
								if(isChild || typeof isChild == 'undefined'){
									$.extend(params, {"queryCondition":{"pbusisortid":nodeid}});
								}else{
									$.extend(params,{"queryCondition":{"busisortid":nodeid}});
								}
								return params;
							},// queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
							
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
							search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
							strictSearch : true,// 设置为 true启用 全匹配搜索，否则为模糊搜索
							showColumns : true, // 是否显示所有的列
							showRefresh : true, // 是否显示刷新按钮
							minimumCountColumns : 2, // 最少允许的列数
							clickToSelect : false, // 是否启用点击选中行
							searchOnEnterKey : true,// 设置为
							// true时，按回车触发搜索方法，否则自动触发搜索方法
							showToggle : true,// 是否显示详细视图和列表视图的切换按钮
							showPaginationSwitch : true,
							showExport : true, // 是否显示导出
							exportDataType : "basic" // basic', 'all',
						// 'selected'

						});
	}

	/** 业务品种添加 */
	function addBusiSort(id, name, ppnode,unificationid) {
		$("#addBusiSort").modal({
			keyboard : true
		});

		$(".ztb_add_pbusisortid").val(id);
		$(".ztb_add_up_busiSortName").text(name);
		
		zjm.init();
		/** 注册编辑验证引擎 */
		zjm.validata({
			formId : "add_form"
		});
		
		tool.undisabled(".btn_submit");// 按钮变为可用
		$(".btn_submit").click(function() {
			// 按钮置为不可用，防止重复提交
			if ($("#add_form").validationEngine("validate")) {
				var busisortname=	$("#add_busisortname").val();
				var queryContainer_form = $("#add_form");
				 if(zjm.ajaxValidata("add_busisortname","/selectAddBusiSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"业务品种名称重复！")){
					tool.disabled(".btn_submit"); // 按钮变为不可用
					$.ajax({
						type : 'POST',
						url : '/insertOneBusiSortInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj.busisortid != null) { //新增的 业务品种不为null,则添加成功
								$("#addBusiSort").modal("hide");
								$(".ztb_add").val("");
								$.zjm_BusiSort.initTree(id);
								
							} else {
								alert("保存失败！");
							}
						}
					});
				 } 
			} else {
				tool.undisabled(".btn_submit");
			}
		});
		$("#addBusiSort").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_submit").unbind("click");
		});
	}


	/** * 业务品种 查看** */
	function viewBusiSort(row) {
		$("#viewBusiSort").modal({
			keyboard : true
		});
		$.ajax({
			type : 'POST',
			url : '/selectOneBusiSortsInfo',
			data : JSON.stringify({"busisortid":row.busisortid,"unitUid":row.unitUid}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_view_"+key).attr("class");
					if(typeof  rt != 'undefined'){
						if( rt.indexOf('iseable') >0){ //判断是否包含isable  状态的
							if( value == 1 ){
								$(".ztb_view_"+key).text('禁用');
							}else{
								$(".ztb_view_"+key).text('启用');
							}
						}else if(rt.indexOf('isDefault')>0){
							if(value == 1){
								$(".ztb_view_"+key).text('是');
							}else{
								$(".ztb_view_"+key).text('否');
							}
						}else if(rt.indexOf('busiClass')>0){
							if(value == "01"){
								$(".ztb_view_"+key).text('担保');
							}else if(value == "02"){
								$(".ztb_view_"+key).text('委贷');
							}else{
								$(".ztb_view_"+key).text('');
							}
						}else{
							$(".ztb_view_"+key).text(value);
						}
					}
					
				})
				
			}
		});
	}

	/** 业务品种 修改* */
	function editBusiSort(row) {
		$("#editBusiSort").modal({
			keyboard : true
		});
		zjm.init();
		/** 注册编辑验证引擎 */
		zjm.validata({
			formId : "edit_form"
		});
		
		// 显示修改业务品种信息
		// 获取修改对象 信息
		$.ajax({
			type:'post',
			url:'/selectOneBusiSortsInfo',
			data: JSON.stringify({"busisortid":row.busisortid,"unitUid":row.unitUid}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_edit_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('iseable') > 0){
							if(value == 1){ // =1 禁用，0启用
								$("#edit_iseable1").prop("checked","checked");
								$("#edit_iseable0").prop("checked");
							}else{
								$("#edit_iseable0").prop("checked","checked");
								$("#edit_iseable1").prop("checked");
							}
						}else{
							$(".ztb_edit_"+key).val(value);
						}
						if(rt.indexOf('busiClasss') > 0){
							$("#busiClass"+value).prop("selected","selected");
						}
					}
				})
			}
		})// 获取修改对象 信息 end 
		
		/** 重置 */
		$(".btn_reset").click(function() {
			tool.undisabled(".btn_submit"); // 重置，保存按钮恢复可用
			zjm.dataViewVal("edit_", "/selectOneBusiSortsInfo", {
				"busisortid" : row.busisortid
			});
		});
		/** 保存修改** */
		tool.undisabled(".btn_submit"); //按钮调整为 可用
		$(".btn_submit").click(function() {
			if ($("#edit_form").validationEngine("validate")) {
				var queryContainer_form = $("#edit_form");
				var edit_busisortname=$("#edit_busisortname").val();
				if(zjm.ajaxValidata("edit_busisortname","/selectEditBusiSortNameIsExist",
						JSON.stringify(queryContainer_form.serializeJson()),"业务品种重复！")){
					tool.disabled(".btn_submit");// 按钮调整为 不可用
					$.ajax({
						type : 'POST',
						url : '/updateOneBusiSortsInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj == 1) {
								$("#editBusiSort").modal("hide");
								$.ajax({type:'POST',url:'/selectBusiSortsPageTables',data:JSON.stringify({"queryCondition":{"pbusisortid":$("#lastTableDictypeID").val()}}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									//修改后刷新列表，取的是上一次查询列表的ID
										if(data.obj.rows.length==0){	//没有查到数据，说明是叶子节点	
											$.zjm_BusiSort.initTree($("#lastTableDictypeID").val(),false);
										}else{							
											$.zjm_BusiSort.initTree($("#lastTableDictypeID").val(),true);
										}
									}
								});
							} else {
								alert("保存失败！");
							}
						}
					});
				} 
			} else {
				tool.undisabled(".btn_submit");
			}
		});
		$("#editBusiSort").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_reset").unbind("click");
			$(".btn_submit").unbind("click");
		});
	}
	/** 业务品种 删除** */
	function delBusiSort(row) {
		if(row.isDefault == 1){
			$("#isDefaults").modal({keyboard:true});
			return false ;
		}
		
		// 调用模态窗  //delBusiSort
		$("#delBusiSort").modal({
			keyboard : true
		});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteOneBusiSortsInfo',
				data : JSON.stringify({
					"busisortid" : row.busisortid,
					"unitUid":row.unitUid
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$("#delBusiSort").modal("hide");
						// 右侧列表移除
						$('#test-table').bootstrapTable('remove', {
							field : 'busisortid',
							values : [ row.busisortid ]
						});
						$.zjm_BusiSort.initTree(row.pbusisortid)
						
					} else {
						$("#failDel").modal({keyboard:true});
					}
				}
			});
		});
		$("#delBusiSort").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_submit").unbind("click");
		});
	}

})(jQuery, this);





$(function() {
	/**
	 * 文档加载的时候 读取 业务品种 信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_BusiSort.initTree();
	};
	

	// 添加下级业务品种
	$("#btn_add").click(function() {
		var ppnode;//新增
		var node = tree.getChecke();
		if (node == null) {
			alert("请选择一个业务品种!");
			return false;
		}
		//新增 ppnode
		if(node.level == 0){ppnode=node.id}
		if(node.level == 1){ppnode=node.getParentNode().id}
		if(node.level == 2){ppnode=node.getParentNode().getParentNode().id}
		
		// 最多两级业务品种
		if (node.level >= 2) {
			alert("不能添加下级业务品种!");
			return false;
		}

		$.zjm_BusiSort.addBusiSort(node.id, node.name,ppnode);
	});

	/** 同级顺序调整 */
	$("#btn_sort").click(function() {
		var node = tree.getChecke();
		if (node == null) {
			alert("请选择一个业务品种!");
			return false;
		}
		$("#sortop").modal({
			keyboard : true
		});
		if( node.pId == null){
			node.pId='418f0975f373470581711826bf5b3711';
		}
		
		zjm.dataSortVal("/selectBusiSortsListJSON", {
			"pbusisortid" : node.pId
		});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			// tableName:表名 tableFileName:字段名 tableFileIds:字段值
			$.ajax({
				type : 'POST',
				url : '/updateSortOrder',
				data : JSON.stringify({
					"tableName" : "c_busisort",
					"tableFileName" : "busisortid",
					"tableFileIds" : $("#tableFileIds").val()
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#sortop").modal("hide");
						$.zjm_BusiSort.initTree();
					} else {
						alert("保存失败！");
						$.zjm_BusiSort.initTree();
					}
				}
			});
			
		});

		// 排序页面重置 按钮
		$(".btn_reset").click(function() {
			zjm.dataSortVal("/selectBusiSortsListJSON", {
				"pbusisortid" : node.pId
			});
		});

		$("#sortop").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_reset").unbind("click");
			$(".btn_submit").unbind("click");
			$("#btn_moveUp").unbind("click");
			$("#btn_moveDown").unbind("click");
			$("#btn_moveTop").unbind("click");
			$("#btn_moveBottom").unbind("click");
		});

	}); // 同级顺序调整 end
	
	//重置列表
	$("#refresh").click(function(){
		$.zjm_BusiSort.initTree();
	})

}); // $(function) end


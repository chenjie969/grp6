/**
 * 多级字典的js,注意多级字典不能超过5级
 * 
 */



$(function () {
	/**
	 * 文档加载的时候 读取  多级字典信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_Multilevelsort.initTree();
	};
	
	//添加多级字典
	$("#btn_add").click(function(){
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个 多级字典!");
			return false;
		}
		//最多5级 多级字典
		if(node.level >= 5 ){
			alert("多级字典最多为5级");
			return false;
		}
		$.zjm_Multilevelsort.addMultilevelsort(node.id,node.name);
	});
		
	// 多级字典排序 同级顺序调整
	$("#btn_sort").click(function(){
		var node = tree.getChecke();
		if(node == null){
			alert("请选择一个 多级字典!");
			return false;
		}
		$("#sortop").modal({keyboard:true});
		if( node.pId == null){
			node.pId='f1ab5bf4aa3948e690e808d9127e7d6b';
		}
		zjm.dataSortVal("/selectMultilevelsortListJSON",{"pmultilevelsortid":node.pId});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/updateSortOrder',
				data : JSON.stringify({
					"tableName" : "c_multilevelsort",
					"tableFileName" : "multilevelsortid",
					"tableFileIds" : $("#tableFileIds").val()
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#sortop").modal("hide");
						$.zjm_Multilevelsort.initTree();
					} else {
						alert("保存失败！");
						$.zjm_Multilevelsort.initTree();
					}
				}
			});
			
		});
		$(".btn_reset").click(function () {
			zjm.dataSortVal("/selectMultilevelsortsListJSON",{"pmultilevelsortid":node.pId});
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
	
	//重置列表
	$("#refresh").click(function(){
		$.zjm_Multilevelsort.initTree();
	})
	
});// end function




(function($,z){
	$.zjm_Multilevelsort = {
			initTree:initTree,//加载树结构
			initTable:initTable,//初始化列表
			addMultilevelsort:addMultilevelsort,// 多级字典添加
			viewMultilevelsort:viewMultilevelsort,// 多级字典查看
			editMultilevelsort:editMultilevelsort,// 多级字典修改
			delMultilevelsort:delMultilevelsort// 多级字典删除
	};
	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(multilevelsortid,isChild){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/selectAllmultilevelsortListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			
			//判断当前节点是否有子节点
			var isChild=treeNode.isParent;
			$.zjm_Multilevelsort.initTable(treeNode.id,isChild);
		};
		
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
			$.each(nodes,function(index,element){
				if(nodes[index].id == multilevelsortid){
					zTreeObj.selectNode(nodes[index]);
					zTreeObj.expandNode(nodes[index],true,false,true);
				}
			})
		};
		
		if (multilevelsortid == null) {
			multilevelsortid = "f1ab5bf4aa3948e690e808d9127e7d6b"; //
		}
		
		$.zjm_Multilevelsort.initTable(multilevelsortid,isChild);
	}

	/**初始化列表***/
	function initTable(nodeid,isChild){
		$("#lastTableDictypeID").val(nodeid);
		$("#test-table").bootstrapTable('destroy');
		$('#test-table').bootstrapTable({
			method: 'get',
							columns : [
									{
										title : '序号',
										align : 'center',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : "multilevelsortname",
										title : '多级字典名称',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.multilevelsortname;
										}
									},
									/*{
										field : "unificationid",
										title : '对应监管机构多级字典编号',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											return row.unificationid;
										}
									},*/
									{
										field : "isDefault",
										title : '是否缺省',
										align : 'center',
										sortable : "true",
										formatter : function(value, row, index) {
											if(row.isDefault ==1 ){
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
											if(row.iseable ==1 ){
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
													'<button class="btn_Multilevelsorts_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button class="btn_Multilevelsorts_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
													'<button class="btn_Multilevelsorts_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
													.join('');
										},
										events : {
											'click .btn_Multilevelsorts_view' : function(
													e, value, row, index) {
												$.zjm_Multilevelsort
														.viewMultilevelsort(row);
											},
											'click .btn_Multilevelsorts_edit' : function(
													e, value, row, index) {
												$.zjm_Multilevelsort
														.editMultilevelsort(row);
											},
											'click .btn_Multilevelsorts_del' : function(
													e, value, row, index) {
												$.zjm_Multilevelsort
														.delMultilevelsort(row);
											}
										}
					}],
			detailView: true,
			detailFormatter:function(index, row){
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
			        html.push('<p><b>多级字典名称：</b> ' + row.multilevelsortname + '</p>');
			        /*html.push('<p><b>对应监管机构多级字典编号：</b> ' + row.unificationid + '</p>');*/
			        html.push('<p><b>是否缺省：</b> ' + isDefault + '</p>');
			        html.push('<p><b>状态：</b> ' + iseable + '</p>');
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
			url: "/selectAllmultilevelsortListPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(isChild || typeof isChild == 'undefined'){
					$.extend(params, {"queryCondition":{"pmultilevelsortid":nodeid}});
				}else{
					$.extend(params,{"queryCondition":{"multilevelsortid":nodeid}});
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


	/** 多级字典添加 插入 新增*/
	function addMultilevelsort(id,name){
		$("#addMultilevelsort").modal({keyboard:true});
		$(".ztb_add_pmultilevelsortid").val(id);
		$(".ztb_add_up_multilevelsortname").text(name);
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_form"});
		/**提交*/
		tool.undisabled(".btn_submit");// 按钮置为 可用
		$(".btn_submit").click(function(){
			if($("#add_form").validationEngine("validate")){
				var queryContainer_form = $("#add_form");
				var add_multilevelsortname =$("#add_multilevelsortname").val();
				if(zjm.ajaxValidata("add_multilevelsortname","/selectAddMmultilevelSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson())," 多级字典名称重复！")){
					tool.disabled(".btn_submit"); // 按钮置为 不可用
					$.ajax({
						type : 'POST',
						url : '/insertOneMultilevelsortInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj != null) {
								$("#addMultilevelsort").modal("hide");
								$(".ztb_add").val("");
								$.zjm_Multilevelsort.initTree(id);
							} else {
								alert("保存失败！");
							}
						}
					});
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addMultilevelsort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	/*** 多级字典查看***/
	function viewMultilevelsort(row){
		$("#viewMultilevelsort").modal({
			keyboard : true
		});
		
		$.ajax({
			type : 'POST',
			url : '/selectOneMultilevelsortInfo',
			data : JSON.stringify({"multilevelsortid":row.multilevelsortid ,"unitUid":row.unitUid }),
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
						}else{
							$(".ztb_view_"+key).text(value);
						}
					}
					
				})
				
			}
		});
		
	}
	/** 多级字典修改**/
	function editMultilevelsort(row){
		$("#editMultilevelsort").modal({keyboard:true});
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"edit_form"
		});
		// 获取修改对象
		$.ajax({
			type:'post',
			url:'/selectOneMultilevelsortInfo',
			data: JSON.stringify({"multilevelsortid":row.multilevelsortid ,"unitUid":row.unitUid }),
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
					}
				})
			}
		})// 获取修改对象 信息 end 
		
		/**重置 */
		$(".btn_reset").click(function(){
			zjm.dataViewVal("edit_","/selectOneMultilevelsortInfo",{"multilevelsortid":row.multilevelsortid});
		});
		/**提交  保存修改***/
		tool.undisabled(".btn_submit"); // 按钮调整为 可用
		$(".btn_submit").click(function(){
			if($("#edit_form").validationEngine("validate")){
				var queryContainer_form = $("#edit_form"); 
				var	edit_multilevelsortname=$("#edit_multilevelsortname").val();
				if(zjm.ajaxValidata("edit_multilevelsortname","/selectEditMmultilevelSortNameIsExist",JSON.stringify(queryContainer_form.serializeJson())," 多级字典名称重复！")){
					tool.disabled(".btn_submit"); // 按钮调整为 不可用
					$.ajax({
						type : 'POST',
						url : '/updateOneMultilevelsortInfo',
						data : JSON.stringify(queryContainer_form.serializeJson()),
						contentType : 'application/json; charset=UTF-8',
						dataType : 'json',
						success : function(data) {
							if (data.obj == 1) {
								$("#editMultilevelsort").modal("hide");
								$(".ztb_add").val("");
								
								$.ajax({type:'POST',url:'/selectAllmultilevelsortListPageTables',data:JSON.stringify({"queryCondition":{"pmultilevelsortid":$("#lastTableDictypeID").val()}}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
									//修改后刷新列表，取的是上一次查询列表的ID
										if(data.obj.rows.length==0){	//没有查到数据，说明是叶子节点	
											$.zjm_Multilevelsort.initTree($("#lastTableDictypeID").val(),false);
										}else{							
											$.zjm_Multilevelsort.initTree($("#lastTableDictypeID").val(),true);
										}
									}
								});
							} else {
								alert("保存失败！");
							}
						}
					});
				}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editMultilevelsort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
		});
	}// 多级字典修改 end
	
	/** 多级字典删除***/
	function delMultilevelsort(row){
		if(row.isDefault == 1){
			$("#isDefault").modal({keyboard:true});
			return false ;
		}
		$("#delMultilevelsort").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteOneMultilevelsortInfo',
				data : JSON.stringify({
					"multilevelsortid" : row.multilevelsortid,
					"unitUid":row.unitUid
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						//右侧列表移除
						$('#test-table').bootstrapTable('remove', {
							field : 'multilevelsortid',
							values : [ row.multilevelsortid ]
						});
						// 左侧列表移除
						$("#delMultilevelsort").modal("hide");
						$.zjm_Multilevelsort.initTree(row.pmultilevelsortid);		
					} else {
						alert("删除失败！");
					}
				}
			});
		});
		$("#delMultilevelsort").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}

})(jQuery, this);


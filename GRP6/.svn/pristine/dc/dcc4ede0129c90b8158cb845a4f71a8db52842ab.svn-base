(function($,z){
	$.zjm_dicNode = {
		initTable:initTable,//初始化列表
		addDicNode:addDicNode,//添加
		editDicNode:editDicNode,//修改
		viewDicNode:viewDicNode,//查看
		delDicNode:delDicNode     //删除
	};
	
	/**初始化列表***/
	function initTable(){
		$("#dicNode_table").bootstrapTable('destroy');
		$('#dicNode_table').bootstrapTable({
			method: 'get',
			columns: [{title: '序号',width:'8%',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"nodeCode",width:'12%',title: '节点编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.nodeCode;}},
					{field:"nodeNames",width:'20%',title: '节点名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.nodeNames;}},
					{field:"remark",width:'40%',title: '备注',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.remark;}},
					{field:"dicNode_uuid",width:'20%',title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_dicNode.viewDicNode(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_dicNode.editDicNode(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_dicNode.delDicNode(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
				    html.push('<p><b>节点名称:</b> ' + row.nodeNames + '</p>');
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
			sortName:"nodeSort",//排序字段
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/gbpm/dicNode/selectDicNodePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				// $.extend(params, {"queryCondition":{"mod_uid":nodeid}});
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

	/**新增节点信息*/
	function addDicNode(){
		$("#dicNode_page").load("/gbpm/dicNode/showDicNodeAddPage",{},function(response,status,xhr){
			$("#addDicNode").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_dicNode_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_dicNode_form");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("add_nodeCode","/gbpm/dicNode/isExistNodeCode",JSON.stringify(queryContainer_form.serializeJson()),"节点编号重复！")){
						if(zjm.ajaxValidata("add_nodeName","/gbpm/dicNode/isExistNodeNames",JSON.stringify(queryContainer_form.serializeJson()),"节点名称重复！")){
							$.ajax({type:'POST',url:'/gbpm/dicNode/insertOneDicNode',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addDicNode").modal("hide");
										$.zjm_dicNode.initTable();
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
			$("#addDicNode").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**查看节点信息*/
	function viewDicNode(row){
		$("#dicNode_page").load("/gbpm/dicNode/showDicNodeViewPage",{"node_ID":row.node_ID},function(response,status,xhr){
			$("#viewDicNode").modal({keyboard:true});
		});
	}
	
	/**修改节点信息*/
	function editDicNode(row){
		$("#dicNode_page").load("/gbpm/dicNode/showDicNodeEditPage",{"node_ID":row.node_ID},function(response,status,xhr){
			$("#edit_dicNodeID").val(row.node_ID);
			$("#editDicNode").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_dicNode_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#edit_dicNode_form");
				if($(queryContainer_form).validationEngine("validate")){
					if(zjm.ajaxValidata("add_nodeCode","/gbpm/dicNode/isExistNodeCode",JSON.stringify(queryContainer_form.serializeJson()),"节点编号重复！")){
						if(zjm.ajaxValidata("add_nodeName","/gbpm/dicNode/isExistNodeNames",JSON.stringify(queryContainer_form.serializeJson()),"节点名称重复！")){
							$.ajax({type:'POST',url:'/gbpm/dicNode/updateOneDicNode',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#editDicNode").modal("hide");
										$.zjm_dicNode.initTable();
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
			$("#editDicNode").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**删除节点信息*/
	function delDicNode(row){
		$("#dicNode_page").load("/gbpm/dicNode/showDicNodeDelPage",{},function(response,status,xhr){
			$("#delDicNode").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/gbpm/dicNode/deleteOneDicNodeDel',data:JSON.stringify({"node_ID":row.node_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delDicNode").modal("hide");
							$.zjm_dicNode.initTable();
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delDicNode").on("hidden.bs.modal", function (e) {//解除事件绑定
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
		$.zjm_dicNode.initTable();
		$(".form-control-ztb").attr("placeholder",'输入节点名称,按回车搜索');
	};
	
	$("#btn_addDicNode").click(function(){
		$.zjm_dicNode.addDicNode();
	});
	
	
	//改变节点同级顺序
	$("#btn_dicNodeSort").click(function(){
		$("#dicNode_page").load("/gbpm/dicNode/selectAllDicNode",{},function(response,status,xhr){
			$("#sortop").modal({keyboard:true});
			tool.sort();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function () {
				tool.disabled(".btn_submit");
				var obj = document.getElementById('OrderContent');
				var options = obj.options;
				for(var i=0,len=options.length;i<len;i++){
				    var opt = options[i];
				    $.ajax({type:'POST',url:'/gbpm/dicNode/updateOneDicNode',data:JSON.stringify({"node_ID":opt.value,"nodeSort":i+1}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#sortop").modal("hide");
						}else{
							alert("保存失败！");
						}
					}
					});
				}
				$("#sortop").modal("hide");
				$.zjm_dicNode.initTable();
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

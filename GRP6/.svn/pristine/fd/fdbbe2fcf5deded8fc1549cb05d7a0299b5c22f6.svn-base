/**
 * 客户管理-企业客户--企业财务状况---主要资产情况分析---应收账款 js
 * @atuhor: wuhn
 * @date: 2017年6月12日 15:40:25
 * 
 */

(function($,z){
	window.Receivable={
		refreshReceivableTable:refreshReceivableTable,// 刷新应收账款列表	
	};
	
	function refreshReceivableTable(client_ID){
		initReceivableTable(client_ID);
		var type = tool.getUrlParam('type');
		if(type == 'view'){
			$('#receivableAdd').hide();
	    }
	}
	$.zim_receivable = {
			initColumn:initColumn,
			initReceivableTable:initReceivableTable,//初始化应收账款列表
			ReceivableAdd:ReceivableAdd,// 应收账款添加
			ReceivableEdit:ReceivableEdit,// 应收账款修改
			ReceivableView:ReceivableView,// 应收账款查看
			ReceivableDel:ReceivableDel,// 应收账款删除
	};
	
	/**初始化列表项**/
	function initColumn(){
		var columns = [
			{
				title : '序号',
				align : 'center',
				formatter : function(value, row, index) {
					return index+1;
				}
			},
			{
				field : 'customerName',
				title : '应收客户名称',
				align : 'center',
				formatter : function(value, row, index) {
					return row.customerName;
				}
			},
			{
				field : "occurDate",
				title : '发生时间',
				align : 'center',
				formatter : function(value, row, index) {
					return tool.parseDate(row.occurDate);
				}
			},
			{
				field : "payDate",
				title : '实际应还款时间',
				align : 'center',
				formatter : function(value, row, index) {
					return tool.parseDate(row.payDate);
				}
			},
			{
				field : "taxSum",
				title : '应收金额',
				align : 'center',
				formatter : function(value, row, index) {
					return row.taxSum;
				}
			}
		 ];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({	
				field:"receivable_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_receivable_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_receivable_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page" title="修改"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_receivable_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>' ]
							.join('');
				},
				events : {
					'click .btn_receivable_view' : function(e, value, row, index) {
						$.zim_receivable.ReceivableView(row);
					},
					'click .btn_receivable_edit' : function(e, value, row, index) {
						$.zim_receivable.ReceivableEdit(row);
					},
					'click .btn_receivable_del':function(e,value,row,index){
						$.zim_receivable.ReceivableDel(row);
					}
				}
			});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({	
				field:"receivable_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_receivable_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>' ]
							.join('');
				},
				events : {
					'click .btn_receivable_view' : function(e, value, row, index) {
						$.zim_receivable.ReceivableView(row);
					}
				}
			} );
		}
		return columns;
	}
	
	/**初始化应收账款列表***/
	function initReceivableTable(client_ID){
		$("#receivable-table").bootstrapTable('destroy');
		$('#receivable-table').bootstrapTable({
			method: 'get',
			columns : initColumn(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
		        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
		        html.push('<p><b>应收客户名称:</b> ' + row.customerName + '</p>');
		        html.push('<p><b>发生时间:</b> ' + tool.parseDate(row.occurDate) + '</p>');
		        html.push('<p><b>实际应还款时间:</b> ' + tool.parseDate(row.payDate) + '</p>');
		        html.push('<p><b>应收金额:</b> ' + row.taxSum +"万元" + '</p>');
		    return html;
			    return html;
			},
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		//	pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
		//	sortable: true,      //是否启用排序
		//	sortOrder: "asc",     //排序方式
			//pageNumber:1,      //初始化加载第一页，默认第一页
			//pageSize: 10,      //每页的记录行数（*）
			//pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
			url: "/selectReceivablePageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams:  function(params) {
				 $.extend(params, {"client_ID":$(".client_ID").val()});
				 return params;
			}, //前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			});
	}
	
	//应收账款添加
	function ReceivableAdd(client_ID){
		$("#ReceivableAdd").modal({keyborad:true});
		var client_ID=$(".client_ID").val();
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_receivableFrom"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			if($("#add_receivableFrom").validationEngine("validate")){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_receivableFrom");
				$.ajax({
					type : 'POST',
					url : '/insertOneReceivableInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#ReceivableAdd").modal("hide"); //关闭 modal
							$(".ztb_add").val(""); // 清空输入框
							$.zim_receivable.initReceivableTable(client_ID); // 刷新应收账款列表	
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit"); //解除按钮 可用
			}
		});
		$("#ReceivableAdd").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
			 $(".btn_submit").unbind("click");
		});
		
	}
	
	//应收账款修改
	function  ReceivableEdit(row){
		$("#ReceivableEdit").modal({keyborad:true});
		$("#receivable_ID").val(row.receivable_ID); // 应收账款 id
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_receivableFrom"
		});
		// 显示 应收账款
		zjm.dataViewVal("edit_","/selectOneReceivableInfo",{"receivable_ID":row.receivable_ID},"occurDate,payDate");
		/** 保存修改** */
		tool.undisabled("#saveReceivableEdit");
		$("#saveReceivableEdit").click(function() {
			if ($("#edit_receivableFrom").validationEngine("validate")) {
				tool.disabled("#saveReceivableEdit");
				var queryContainer_form = $("#edit_receivableFrom");
				$.ajax({
					type : 'POST',
					url : '/updateOneReceivableInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#ReceivableEdit").modal("hide");//隐藏模态窗
							$(".ztb_edit").val(""); // 页面清空
							$.zim_receivable.initReceivableTable(row.client_ID);
						} else {
							alert("保存失败！");
							tool.undisabled("#saveReceivableEdit");
						}
					}
				});
			} else {
				tool.undisabled("#saveReceivableEdit");
			}
		});
		$("#ReceivableEdit").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$("#saveReceivableEdit").unbind("click");
		});
	}
	
	//应收账款查看
	function  ReceivableView(row){
		$("#ReceivableView").modal({keyborad:true});
		zjm.dataViewText("view_","/selectOneReceivableInfo",{"receivable_ID":row.receivable_ID},"occurDate,payDate");
		$("#ReceivableView").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
		});
	}
	
	//应收账款删除
	function ReceivableDel(row){
		$("#ReceivableDel").modal({keyborad:true});
		/** 确认删除 ** */
		tool.undisabled("#saveReceivableDel");
		$("#saveReceivableDel").click(function() {
			tool.disabled("#saveReceivableDel");
				$.ajax({
					type : 'POST',
					url : '/deleteOneReceivableInfo',
					data : row.receivable_ID,
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$('#receivable-table').bootstrapTable('remove', {
								field : 'receivable_ID',
								values : [ row.receivable_ID ]
							});
							$("#ReceivableDel").modal("hide");//隐藏模态窗
						} else {
							alert("保存失败！");
						}
					}
				});
		});
		$("#ReceivableDel").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$("#saveReceivableDel").unbind("click");
		});
	}
})(jQuery, this);

$(function () {
	
	//获取客户id
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	
	/**
	 *  加载主要资产情况分析: 应收账款,其他应收账款,存货,土地、厂房、名下房产, 机器设备及车辆等,财务情况说明。。
	 */
	$("#mainAssetList").click(function(){
		window.Receivable.refreshReceivableTable(client_ID );
		
	})

	//添加 应收账款
	$("#receivableAdd").click(function(){
		$.zim_receivable.ReceivableAdd(client_ID);
	})
	
	
});


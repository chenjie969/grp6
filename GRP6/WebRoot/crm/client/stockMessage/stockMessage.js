/**
 * 客户管理-企业客户--客户详情--股权信息 js
 * @atuhor: wuhn
 * @date: 2017年5月15日 16:32:13
 * 
 */

(function($,z){
	window.stockMessage={
		refreshStockMessageTable:refreshStockMessageTable,// 刷新股权信息列表	
	};
	
	function refreshStockMessageTable(client_ID){
		initStockMessageTable(client_ID);
		var type = tool.getUrlParam('type');
		
		if(type == 'view'){
			$('#stockMessage-table').bootstrapTable('hideColumn','stockId');
	    }
	}
	$.zjm_stockMessage = {
			initStockMessageTable:initStockMessageTable,//初始化股权信息列表
			stockMessageAdd:stockMessageAdd,// 股权信息添加
			stockMessageEdit:stockMessageEdit,// 股权信息修改
			stockMessageView:stockMessageView,// 股权信息查看
			stockMessageDel:stockMessageDel,// 股权信息删除
	};
	/**初始化列表项**/
	function initColumn(){
		var columns = [{title : '序号',align : 'center',formatter : function(value, row, index) {return index+1;}},
					   {field : 'stockname',title : '股东名称',align : 'center',formatter : function(value, row, index) {return row.stockname;}},
					   {field : "investtypetime",title : '出资时间与出资方式',align : 'center',formatter : function(value, row, index) {return row.investtypetime;}},
		               {field : "investsum",title : '出资金额（万元）',align : 'center',formatter : function(value, row, index) {return row.investsum;}},
					   {field : "investscale",title : '占比（%）',align : 'center',formatter : function(value, row, index) {return row.investscale;}},
					   ];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
	
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({title : '操作',align : 'center',formatter : function(value, row, index) {
							return [
					        '<button title="查看"  class="btn_client_view btn btn-xs btn-warning" href="javascript:void(0)" data-toggle="modal"><i class="icon-zoom-in bigger-120"></i></button>',
					        '<button title="修改" class="btn_client_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button title="删除" class="btn_client_del btn btn-xs btn-danger" href="javascript:void(0)" data-toggle="modal"><i class="icon-trash bigger-120"></i></button>' ]
							.join('');
								},
								events : {
									'click .btn_client_view' : function(e, value, row, index) {
										$.zjm_stockMessage.stockMessageView(row);
									},
									'click .btn_client_edit' : function(e, value, row, index) {
										$.zjm_stockMessage.stockMessageEdit(row);
									},
									'click .btn_client_del':function(e,value,row,index){
										$.zjm_stockMessage.stockMessageDel(row);
									}
								}
							});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button title="查看" class="btn_client_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_client_view': function(e, value, row, index) {
									$.zjm_stockMessage.stockMessageView(row);
								}
							}
						});
		}
		return columns;
	};
	
	/**初始化股权信息列表***/
	function initStockMessageTable(client_ID){
		$("#stockMessage-table").bootstrapTable('destroy');
		$('#stockMessage-table').bootstrapTable({
			method: 'get',
			columns : initColumn(),
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>股东名称:</b> ' + row.stockname + '</p>');
			        html.push('<p><b>出资时间与出资方式:</b> ' + row.investtypetime + '</p>');
			        html.push('<p><b>出资金额:</b> ' + row.investsum +"万元" + '</p>');
			        html.push('<p><b>占比:</b> ' + row.investscale+"%" + '</p>');
			    return html;
			},
			//toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		//	pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
		//	sortable: true,      //是否启用排序
		//	sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/selectStockListPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams:  function(params) {
				 $.extend(params, {"queryCondition":{"client_ID":client_ID}});
				 return params;
			}, //前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			});
	}
	
	//股权信息添加
	function stockMessageAdd(){
		$("#stockMessageAdd").modal({ //开启模态窗
			keyborad:true,
		})
		var client_ID=$(".client_ID").val();
		if(client_ID == "" || client_ID == null){
			client_ID=$("#clientIDText").text();
		}
		
		$(".ztb_add_client_ID").val(client_ID);
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_StockMessage"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled("#saveStockMessageAdd");
		$("#saveStockMessageAdd").click(function(){
			if($("#add_StockMessage").validationEngine("validate")){
				tool.disabled("#saveStockMessageAdd");
				var queryContainer_form = $("#add_StockMessage");
				$.ajax({
					type : 'POST',
					url : '/insertOneStockInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#stockMessageAdd").modal("hide"); //关闭 modal
							$(".ztb_add").val(""); // 清空输入框
							$.zjm_stockMessage.initStockMessageTable(client_ID); // 刷新股权信息列表	
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled("#saveStockMessageAdd"); //解除按钮 可用
			}
		});
		$("#StockMessageAdd").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
			 $("#saveStockMessageAdd").unbind("click");
			 $(".btn-default").unbind("click");
		});
		
	}
	
	//股权信息修改
	function  stockMessageEdit(row){
		$("#stockMessageEdit").modal({ //开启模态窗
			keyborad:true,
		})
		$("#stockId").val(row.stockId); // 股权信息 id
		
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_StockMessage"
		});
		// 显示 股权信息
		zjm.dataViewVal("edit_","/selectOneStockInfo",{"stockId":row.stockId},"");
		/** 保存修改** */
		tool.undisabled("#saveStockMessageEdit");
		$("#saveStockMessageEdit").click(function() {
			if ($("#edit_StockMessage").validationEngine("validate")) {
				tool.disabled("#saveStockMessageEdit");
				var queryContainer_form = $("#edit_StockMessage");
				$.ajax({
					type : 'POST',
					url : '/updateOneStockInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#stockMessageEdit").modal("hide");//隐藏模态窗
							$(".ztb_edit").val(""); // 页面清空
							$.zjm_stockMessage.initStockMessageTable(row.client_ID);
						} else {
							alert("保存失败！");
						}
					}
				});
			} else {
				tool.undisabled("#saveStockMessageEdit");
			}
		});
		$("#stockMessageEdit").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$("#saveStockMessageEdit").unbind("click");
		});
	}
	//查看股权信息;
	function stockMessageView (row) {
		$("#stockMessageinfo").modal({keyboard:true});
		//zjm.dataViewText("view_","/selectOneStockInfo",{"stockId":row.stockId},"");
		$.ajax({
			type:'post',
			url:'/selectOneStockInfo',
			data: JSON.stringify({"stockId":row.stockId}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){//:此处中备注与企业详情中备注字段名一样,所以需要特殊处理
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_viewss_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('remark') > 0){
							$(".ztb_viewss_"+key).text(value);
						}else{
							$(".ztb_viewss_"+key).text(tool.isNull(value,"（空）"));
						}
					}
				})
			}
		})
		
	}
	//股权信息删除
	function stockMessageDel(row){
		$("#stockMessageDel").modal({ //开启模态窗
			keyborad:true,
		})
		/** 确认删除 ** */
		tool.undisabled("#saveStockMessageDel");
		$("#saveStockMessageDel").click(function() {
			tool.disabled("#saveStockMessageDel");
				$.ajax({
					type : 'POST',
					url : '/deleteOneStockInfo',
					data : JSON.stringify({"stockId":row.stockId}),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$('#stockMessage-table').bootstrapTable('remove', {
								field : 'stockId',
								values : [ row.stockId ]
							});
							$("#stockMessageDel").modal("hide");//隐藏模态窗
						//	$.zjm_stockMessage.initStockMessageTable(row.client_ID);
						} else {
							alert("保存失败！");
						}
					}
				});
		});
		$("#stockMessageDel").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$("#saveStockMessageDel").unbind("click");
		});
		
	}
})(jQuery, this);

$(function () {
	
	//添加 股权信息
	$("#stockAdd").click(function(){
		
		$.zjm_stockMessage.stockMessageAdd();
	})
	
});


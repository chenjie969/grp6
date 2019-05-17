/**
 * 客户管理-企业客户--企业财务状况---主要资产情况分析---其它应收账款 js
 * @atuhor: wuhn
 * @date: 2017年6月12日 15:40:25
 * 
 */

(function($,z){
	window.OtherReceivable={
		refreshOtherReceivableTable:refreshOtherReceivableTable,// 刷新其它应收账款列表	
	};
	
	function refreshOtherReceivableTable(client_ID){
		initOtherReceivableTable(client_ID);
		var type = tool.getUrlParam('type');
		if(type == 'view'){
			$('#otherReceivableAdd').hide();
	    }
	}
	$.zim_otherReceivable = {
			initColumn:initColumn,
			initOtherReceivableTable:initOtherReceivableTable,//初始化其它应收账款列表
			OtherReceivableAdd:OtherReceivableAdd,// 其它应收账款添加
			OtherReceivableEdit:OtherReceivableEdit,// 其它应收账款修改
			OtherReceivableView:OtherReceivableView,// 其它应收账款查看
			OtherReceivableDel:OtherReceivableDel,// 其它应收账款删除
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
				field:"otherReceivable_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_otherReceivable_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_otherReceivable_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page" title="修改"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_otherReceivable_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>' ]
							.join('');
				},
				events : {
					'click .btn_otherReceivable_view' : function(e, value, row, index) {
						$.zim_otherReceivable.OtherReceivableView(row);
					},
					'click .btn_otherReceivable_edit' : function(e, value, row, index) {
						$.zim_otherReceivable.OtherReceivableEdit(row);
					},
					'click .btn_otherReceivable_del':function(e,value,row,index){
						$.zim_otherReceivable.OtherReceivableDel(row);
					}
				}
			});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({	
				field:"otherReceivable_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_otherReceivable_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>']
							.join('');
				},
				events : {
					'click .btn_otherReceivable_view' : function(e, value, row, index) {
						$.zim_otherReceivable.OtherReceivableView(row);
					}
				}
			});
		}
		return columns;
	}
	
	/**初始化其它应收账款列表***/
	function initOtherReceivableTable(client_ID){
		$("#otherReceivable-table").bootstrapTable('destroy');
		$('#otherReceivable-table').bootstrapTable({
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
			url: "/selectOtherReceivablePageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams:  function(params) {
				 $.extend(params, {"client_ID":$(".client_ID").val()});
				 return params;
			}, //前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			});
	}
	
	//其它应收账款添加
	function OtherReceivableAdd(client_ID){
		$("#OtherReceivableAdd").modal({keyborad:true});
		var client_ID=$(".client_ID").val();
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_otherReceivableFrom"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			if($("#add_otherReceivableFrom").validationEngine("validate")){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_otherReceivableFrom");
				$.ajax({
					type : 'POST',
					url : '/insertOneOtherReceivableInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#OtherReceivableAdd").modal("hide"); //关闭 modal
							$(".ztb_add").val(""); // 清空输入框
							$.zim_otherReceivable.initOtherReceivableTable(client_ID); // 刷新其它应收账款列表	
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit"); //解除按钮 可用
			}
		});
		$("#OtherReceivableAdd").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
			 $(".btn_submit").unbind("click");
		});
		
	}
	
	//其它应收账款修改
	function  OtherReceivableEdit(row){
		$("#OtherReceivableEdit").modal({keyborad:true});
		$("#otherReceivable_ID").val(row.otherReceivable_ID); // 其它应收账款 id
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_otherReceivableFrom"
		});
		// 显示 其它应收账款
		zjm.dataViewVal("edit_","/selectOneOtherReceivableInfo",{"otherReceivable_ID":row.otherReceivable_ID},"occurDate,payDate");
		/** 保存修改** */
		tool.undisabled("#saveOtherReceivableEdit");
		$("#saveOtherReceivableEdit").click(function() {
			if ($("#edit_otherReceivableFrom").validationEngine("validate")) {
				tool.disabled("#saveOtherReceivableEdit");
				var queryContainer_form = $("#edit_otherReceivableFrom");
				$.ajax({
					type : 'POST',
					url : '/updateOneOtherReceivableInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#OtherReceivableEdit").modal("hide");//隐藏模态窗
							$(".ztb_edit").val(""); // 页面清空
							$.zim_otherReceivable.initOtherReceivableTable(row.client_ID);
						} else {
							alert("保存失败！");
							tool.undisabled("#saveOtherReceivableEdit");
						}
					}
				});
			} else {
				tool.undisabled("#saveOtherReceivableEdit");
			}
		});
		$("#OtherReceivableEdit").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$("#saveOtherReceivableEdit").unbind("click");
		});
	}
	
	//其它应收账款查看
	function  OtherReceivableView(row){
		$("#OtherReceivableView").modal({keyborad:true});
		zjm.dataViewText("view_","/selectOneOtherReceivableInfo",{"otherReceivable_ID":row.otherReceivable_ID},"occurDate,payDate");
		$("#OtherReceivableView").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
		});
	}
	
	//其它应收账款删除
	function OtherReceivableDel(row){
		$("#OtherReceivableDel").modal({keyborad:true});
		/** 确认删除 ** */
		tool.undisabled("#saveOtherReceivableDel");
		$("#saveOtherReceivableDel").click(function() {
			tool.disabled("#saveOtherReceivableDel");
				$.ajax({
					type : 'POST',
					url : '/deleteOneOtherReceivableInfo',
					data : row.otherReceivable_ID,
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$('#otherReceivable-table').bootstrapTable('remove', {
								field : 'otherReceivable_ID',
								values : [ row.otherReceivable_ID ]
							});
							$("#OtherReceivableDel").modal("hide");//隐藏模态窗
						} else {
							alert("保存失败！");
						}
					}
				});
		});
		$("#OtherReceivableDel").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$("#saveOtherReceivableDel").unbind("click");
		});
	}
})(jQuery, this);

$(function () {
	
	//获取客户id
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	
	/**
	 *  加载主要资产情况分析: 其它应收账款,其他其它应收账款,存货,土地、厂房、名下房产, 机器设备及车辆等,财务情况说明。。
	 */
	$("#mainAssetList").click(function(){
		window.OtherReceivable.refreshOtherReceivableTable(client_ID );
		
	})

	//添加 其它应收账款
	$("#otherReceivableAdd").click(function(){
		$.zim_otherReceivable.OtherReceivableAdd(client_ID);
	})
	
	
});


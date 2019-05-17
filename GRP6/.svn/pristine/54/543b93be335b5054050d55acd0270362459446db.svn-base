/**
 * 客户管理-企业客户--企业财务状况---主要资产情况分析---存货 js
 * @atuhor: wuhn
 * @date: 2017年6月12日 15:40:25
 * 
 */

(function($,z){
	window.Inventory={
		refreshInventoryTable:refreshInventoryTable,// 刷新存货列表	
	};
	
	function refreshInventoryTable(client_ID){
		initInventoryTable(client_ID);
		var type = tool.getUrlParam('type');
		if(type == 'view'){
			$('#inventoryAdd').hide();
	    }
	}
	$.zim_inventory = {
			initColumn:initColumn,
			initInventoryTable:initInventoryTable,//初始化存货列表
			InventoryAdd:InventoryAdd,// 存货添加
			InventoryEdit:InventoryEdit,// 存货修改
			InventoryView:InventoryView,// 存货查看
			InventoryDel:InventoryDel,// 存货删除
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
				field : 'inventoryName',
				title : '存货名称',
				align : 'center',
				formatter : function(value, row, index) {
					return row.inventoryName;
				}
			},
			{
				field : "inventoryCount",
				title : '存货数量',
				align : 'center',
				formatter : function(value, row, index) {
					return row.inventoryCount;
				}
			},
			{
				field : "inventoryPrice",
				title : '目前市场价',
				align : 'center',
				formatter : function(value, row, index) {
					return row.inventoryPrice;
				}
			},
			{
				field : "inventorySum",
				title : '存货金额',
				align : 'center',
				formatter : function(value, row, index) {
					return row.inventorySum;
				}
			}
		 ];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({	
						field:"inventory_ID",
						title : '操作',
						align : 'center',
						formatter : function(value, row, index) {
							return ['<button class="btn_inventory_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_inventory_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_inventory_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
									.join('');
						},
						events : {
							'click .btn_inventory_view': function(e, value, row, index) {
								$.zim_inventory.InventoryView(row);
							},
							'click .btn_inventory_edit' : function(e, value, row, index) {
								$.zim_inventory.InventoryEdit(row);
							},
							'click .btn_inventory_del':function(e,value,row,index){
								$.zim_inventory.InventoryDel(row);
							}
						}
					});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({	
				field:"inventory_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_inventory_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>']
							.join('');
				},
				events : {
					'click .btn_inventory_view': function(e, value, row, index) {
						$.zim_inventory.InventoryView(row);
					}
				}
			});
		}
		return columns;
	}
	/**初始化存货列表***/
	function initInventoryTable(client_ID){
		$("#inventory-table").bootstrapTable('destroy');
		$('#inventory-table').bootstrapTable({
			method: 'get',
			columns : initColumn(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>存货名称:</b> ' + row.inventoryName + '</p>');
			        html.push('<p><b>存货数量:</b> ' + row.inventoryCount + '</p>');
			        html.push('<p><b>目前市场价:</b> ' + row.inventoryPrice +"万元" + '</p>');
			        html.push('<p><b>存货金额:</b> ' + row.inventorySum+"万元" + '</p>');
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
			url: "/selectInventoryPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams:  function(params) {
				 $.extend(params, {"client_ID":$(".client_ID").val()});
				 return params;
			}, //前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			});
	}
	
	//存货添加
	function InventoryAdd(client_ID){
		$("#InventoryAdd").modal({keyborad:true});
		var client_ID=$(".client_ID").val();
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_inventoryFrom"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			if($("#add_inventoryFrom").validationEngine("validate")){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_inventoryFrom");
				$.ajax({
					type : 'POST',
					url : '/insertOneInventoryInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#InventoryAdd").modal("hide"); //关闭 modal
							$(".ztb_add").val(""); // 清空输入框
							$.zim_inventory.initInventoryTable(client_ID); // 刷新存货列表	
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit"); //解除按钮 可用
			}
		});
		$("#InventoryAdd").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
			 $(".btn_submit").unbind("click");
		});
		
	}
	
	//存货修改
	function  InventoryEdit(row){
		$("#InventoryEdit").modal({keyborad:true});
		$("#inventory_ID").val(row.inventory_ID); // 存货 id
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_inventoryFrom"
		});
		// 显示 存货
		zjm.dataViewVal("edit_","/selectOneInventoryInfo",{"inventory_ID":row.inventory_ID},"");
		/** 保存修改** */
		tool.undisabled("#saveInventoryEdit");
		$("#saveInventoryEdit").click(function() {
			if ($("#edit_inventoryFrom").validationEngine("validate")) {
				tool.disabled("#saveInventoryEdit");
				var queryContainer_form = $("#edit_inventoryFrom");
				$.ajax({
					type : 'POST',
					url : '/updateOneInventoryInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#InventoryEdit").modal("hide");//隐藏模态窗
							$(".ztb_edit").val(""); // 页面清空
							$.zim_inventory.initInventoryTable(row.client_ID);
						} else {
							alert("保存失败！");
							tool.undisabled("#saveInventoryEdit");
						}
					}
				});
			} else {
				tool.undisabled("#saveInventoryEdit");
			}
		});
		$("#InventoryEdit").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$("#saveInventoryEdit").unbind("click");
		});
	}
	
	//存货查看
	function  InventoryView(row){
		$("#InventoryView").modal({keyborad:true});
		zjm.dataViewText("view_","/selectOneInventoryInfo",{"inventory_ID":row.inventory_ID},"");
		$("#InventoryView").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
		});
	}
	
	//存货删除
	function InventoryDel(row){
		$("#InventoryDel").modal({keyborad:true});
		/** 确认删除 ** */
		tool.undisabled("#saveInventoryDel");
		$("#saveInventoryDel").click(function() {
			tool.disabled("#saveInventoryDel");
				$.ajax({
					type : 'POST',
					url : '/deleteOneInventoryInfo',
					data : row.inventory_ID,
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$('#inventory-table').bootstrapTable('remove', {
								field : 'inventory_ID',
								values : [ row.inventory_ID ]
							});
							$("#InventoryDel").modal("hide");//隐藏模态窗
						} else {
							alert("保存失败！");
						}
					}
				});
		});
		$("#InventoryDel").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$("#saveInventoryDel").unbind("click");
		});
	}
})(jQuery, this);

$(function () {
	
	//获取客户id
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	
	/**
	 *  加载主要资产情况分析: 存货,其他存货,存货,土地、厂房、名下房产, 机器设备及车辆等,财务情况说明。。
	 */
	$("#mainAssetList").click(function(){
		window.Inventory.refreshInventoryTable(client_ID );
		
	})

	//添加 存货
	$("#inventoryAdd").click(function(){
		$.zim_inventory.InventoryAdd(client_ID);
	})
	
	
});


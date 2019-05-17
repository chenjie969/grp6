/**
 * 客户管理-企业客户--企业财务状况---主要资产情况分析---机械 js
 * @atuhor: wuhn
 * @date: 2017年6月12日 15:40:25
 * 
 */

(function($,z){
	window.Machine={
		refreshMachineTable:refreshMachineTable,// 刷新机械列表	
	};
	
	function refreshMachineTable(client_ID){
		initMachineTable(client_ID);
		var type = tool.getUrlParam('type');
		if(type == 'view'){
			$('#machineAdd').hide();
	    }
	}
	$.zim_machine = {
			initColumn:initColumn,
			initMachineTable:initMachineTable,//初始化机械列表
			MachineAdd:MachineAdd,// 机械添加
			MachineEdit:MachineEdit,// 机械修改
			MachineView:MachineView,// 机械修改
			MachineDel:MachineDel,// 机械删除
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
				field : 'assetsName',
				title : '财产名称',
				align : 'center',
				formatter : function(value, row, index) {
					return row.assetsName;
				}
			},
			{
				field : "buyDate",
				title : '购入时间',
				align : 'center',
				formatter : function(value, row, index) {
					return tool.parseDate(row.buyDate);
				}
			},
			{
				field : "isBill",
				title : '有无发票',
				align : 'center',
				formatter : function(value, row, index) {
					return row.isBill == 1 ? '有':'无' ;
				}
			},
			{
				field : "oldValue",
				title : '原价',
				align : 'center',
				formatter : function(value, row, index) {
					return row.oldValue;
				}
			},
			{
				field : "residualValue",
				title : '余值',
				align : 'center',
				formatter : function(value, row, index) {
					return row.residualValue;
				}
			},
			
			{
				field : "status",
				title : '状态',
				align : 'center',
				formatter : function(value, row, index) {
					return row.status;
				}
			},
			{
				field : "loanBank",
				title : '贷款行',
				align : 'center',
				formatter : function(value, row, index) {
					return row.loanBank;
				}
			},
			{
				field : "guarantySum",
				title : '抵押金额（万元）',
				align : 'center',
				formatter : function(value, row, index) {
					return row.guarantySum;
				}
			}
		 ];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({	
				field:"machine_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_machine_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_machine_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_machine_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
							.join('');
				},
				events : {
					'click .btn_machine_view' : function(e, value, row, index) {
						$.zim_machine.MachineView(row);
					},
					'click .btn_machine_edit' : function(e, value, row, index) {
						$.zim_machine.MachineEdit(row);
					},
					'click .btn_machine_del':function(e,value,row,index){
						$.zim_machine.MachineDel(row);
					}
				}
			});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({	
				field:"machine_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_machine_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>']
							.join('');
				},
				events : {
					'click .btn_machine_view' : function(e, value, row, index) {
						$.zim_machine.MachineView(row);
					}
				}
			} );
		}
		return columns;
	}
	
	/**初始化机械列表***/
	function initMachineTable(client_ID){
		$("#machine-table").bootstrapTable('destroy');
		$('#machine-table').bootstrapTable({
			method: 'get',
			columns :initColumn(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
					html.push('<p><b>财产名称:</b> ' + row.assetsName + '</p>');
			        html.push('<p><b>购入时间:</b> ' + tool.parseDate(row.buyDate) + '</p>');
			        html.push('<p><b>有无发票:</b> ' + (row.isBill == 1 ? '有':'无' ) + '</p>');
			        html.push('<p><b>原价:</b> ' + row.oldValue +"万元" + '</p>');
			        html.push('<p><b>余值:</b> ' + row.residualValue + '万元' + '</p>');
			        html.push('<p><b>状态:</b> ' + row.status + '</p>');
			        html.push('<p><b>贷款行:</b> ' + row.loanBank + '</p>');
			        html.push('<p><b>抵押金额:</b> ' + row.guarantySum + '万元' + '</p>');
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
			url: "/selectMachinePageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams:  function(params) {
				 $.extend(params, {"client_ID":$(".client_ID").val()});
				 return params;
			}, //前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			});
	}
	
	//机械添加
	function MachineAdd(client_ID){
		$("#MachineAdd").modal({keyborad:true});
		var client_ID=$(".client_ID").val();
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_machineFrom"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			if($("#add_machineFrom").validationEngine("validate")){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_machineFrom");
				$.ajax({
					type : 'POST',
					url : '/insertOneMachineInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#MachineAdd").modal("hide"); //关闭 modal
							$(".ztb_add").val(""); // 清空输入框
							$.zim_machine.initMachineTable(client_ID); // 刷新机械列表	
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit"); //解除按钮 可用
			}
		});
		$("#MachineAdd").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
			 $(".btn_submit").unbind("click");
		});
		
	}
	
	//机械修改
	function  MachineEdit(row){
		$("#MachineEdit").modal({keyborad:true});
		$("#machine_ID").val(row.machine_ID); // 机械 id
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_machineFrom"
		});
		// 显示 机械
		zjm.dataViewVal("edit_","/selectOneMachineInfo",{"machine_ID":row.machine_ID},"buyDate");
		/** 保存修改** */
		tool.undisabled("#saveMachineEdit");
		$("#saveMachineEdit").click(function() {
			if ($("#edit_machineFrom").validationEngine("validate")) {
				tool.disabled("#saveMachineEdit");
				var queryContainer_form = $("#edit_machineFrom");
				$.ajax({
					type : 'POST',
					url : '/updateOneMachineInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#MachineEdit").modal("hide");//隐藏模态窗
							$(".ztb_edit").val(""); // 页面清空
							$.zim_machine.initMachineTable(row.client_ID);
						} else {
							alert("保存失败！");
							tool.undisabled("#saveMachineEdit");
						}
					}
				});
			} else {
				tool.undisabled("#saveMachineEdit");
			}
		});
		$("#MachineEdit").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$("#saveMachineEdit").unbind("click");
		});
	}
	
	//机械查看
	function  MachineView(row){
		$("#MachineView").modal({keyborad:true});
		$.ajax({
			type:'post',
			url:'/selectOneMachineInfo',
			data: JSON.stringify({"machine_ID":row.machine_ID}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_view_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('isBill') > 0){
							if(value == 1){ // =1 禁用，0启用
								$(".ztb_view_"+key).text("有");
							}else{
								$(".ztb_view_"+key).text("无");
							}
						}else if(rt.indexOf("buyDate")>0){
								$(".ztb_view_"+key).text(tool.parseDate(value));
						}else{
							$(".ztb_view_"+key).text(tool.isNull(value,"（空）"));
						}
					}
				})
			}
		})
		
		$("#MachineView").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
		});
	}
	
	//机械删除
	function MachineDel(row){
		$("#MachineDel").modal({keyborad:true});
		/** 确认删除 ** */
		tool.undisabled("#saveMachineDel");
		$("#saveMachineDel").click(function() {
			tool.disabled("#saveMachineDel");
				$.ajax({
					type : 'POST',
					url : '/deleteOneMachineInfo',
					data : row.machine_ID,
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$('#machine-table').bootstrapTable('remove', {
								field : 'machine_ID',
								values : [ row.machine_ID ]
							});
							$("#MachineDel").modal("hide");//隐藏模态窗
						} else {
							alert("保存失败！");
						}
					}
				});
		});
		$("#MachineDel").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$("#saveMachineDel").unbind("click");
		});
	}
})(jQuery, this);

$(function () {
	
	//获取客户id
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	
	/**
	 *  加载主要资产情况分析: 机械,其他机械,存货,土地、厂房、名下房产, 机器设备及车辆等,财务情况说明。。
	 */
	$("#mainAssetList").click(function(){
		window.Machine.refreshMachineTable(client_ID );
		
	})

	//添加 机械
	$("#machineAdd").click(function(){
		$.zim_machine.MachineAdd(client_ID);
	})
	
	
});


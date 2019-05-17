/**
 * 客户管理-企业客户--企业财务状况---主要资产情况分析---住宅 js
 * @atuhor: wuhn
 * @date: 2017年6月12日 15:40:25
 * 
 */

(function($,z){
	window.LandHouse={
		refreshLandHouseTable:refreshLandHouseTable,// 刷新住宅列表	
	};
	
	function refreshLandHouseTable(client_ID){
		initLandHouseTable(client_ID);
		var type = tool.getUrlParam('type');
		if(type == 'view'){
			$('#landHouseAdd').hide();
	    }
	}
	$.zim_landHouse = {
			initColumn:initColumn,
			initLandHouseTable:initLandHouseTable,//初始化住宅列表
			LandHouseAdd:LandHouseAdd,// 住宅添加
			LandHouseEdit:LandHouseEdit,// 住宅修改
			LandHouseView:LandHouseView,// 住宅查看
			LandHouseDel:LandHouseDel,// 住宅删除
			
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
				field : 'landHouseName',
				title : '名称',
				align : 'center',
				formatter : function(value, row, index) {
					return row.landHouseName;
				}
			},
			{
				field : "landHousePosition",
				title : '位置',
				align : 'center',
				formatter : function(value, row, index) {
					return row.landHousePosition;
				}
			},
			{
				field : "landHouseArea",
				title : '面积',
				align : 'center',
				formatter : function(value, row, index) {
					return row.landHouseArea;
				}
			},
			{
				field : "buyPrice",
				title : '购买价',
				align : 'center',
				formatter : function(value, row, index) {
					return row.buyPrice;
				}
			},
			{
				field : "isCertificate",
				title : '是否有证',
				align : 'center',
				formatter : function(value, row, index) {
					return row.isCertificate == 1 ? '是':'否' ;
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
				field:"landHouse_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_landHouse_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_landHouse_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_landHouse_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
							.join('');
				},
				events : {
					'click .btn_landHouse_view': function(e, value, row, index) {
						$.zim_landHouse.LandHouseView(row);
					},
					'click .btn_landHouse_edit' : function(e, value, row, index) {
						$.zim_landHouse.LandHouseEdit(row);
					},
					'click .btn_landHouse_del':function(e,value,row,index){
						$.zim_landHouse.LandHouseDel(row);
					}
				}
			});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({	
				field:"landHouse_ID",
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					return ['<button class="btn_landHouse_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>' ]
							.join('');
				},
				events : {
					'click .btn_landHouse_view': function(e, value, row, index) {
						$.zim_landHouse.LandHouseView(row);
					}
				}
			});
		}
		return columns;
	}
	
	/**初始化住宅列表***/
	function initLandHouseTable(client_ID){
		$("#landHouse-table").bootstrapTable('destroy');
		$('#landHouse-table').bootstrapTable({
			method: 'get',
			columns : initColumn(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>名称:</b> ' + row.landHouseName + '</p>');
			        html.push('<p><b>位置:</b> ' + row.landHousePosition + '</p>');
			        html.push('<p><b>面积:</b> ' + row.landHouseArea + '㎡' + '</p>');
			        html.push('<p><b>购买价:</b> ' + row.buyPrice + '万元' + '</p>');
			        html.push('<p><b>是否有证:</b> ' + (row.isCertificate == 1 ? '是':'否') + '</p>');
			        html.push('<p><b>状态:</b> ' + row.status + '</p>');
			        html.push('<p><b>贷款行:</b> ' + row.loanBank + '</p>');
			        html.push('<p><b>抵押金额:</b> ' + row.guarantySum + '万元' +'</p>');
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
			url: "/selectLandHousePageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams:  function(params) {
				 $.extend(params, {"client_ID":$(".client_ID").val()});
				 return params;
			}, //前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			});
	}
	
	//住宅添加
	function LandHouseAdd(client_ID){
		$("#LandHouseAdd").modal({keyborad:true});
		var client_ID=$(".client_ID").val();
		zjm.init();
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_landHouseFrom"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			if($("#add_landHouseFrom").validationEngine("validate")){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_landHouseFrom");
				$.ajax({
					type : 'POST',
					url : '/insertOneLandHouseInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#LandHouseAdd").modal("hide"); //关闭 modal
							$(".ztb_add").val(""); // 清空输入框
							$.zim_landHouse.initLandHouseTable(client_ID); // 刷新住宅列表	
						} else {
							alert("保存失败！");
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit"); //解除按钮 可用
			}
		});
		$("#LandHouseAdd").on("hidden.bs.modal", function (e) {//解除模态窗的事件绑定
			 $(".btn_submit").unbind("click");
		});
		
	}
	
	//住宅修改
	function  LandHouseEdit(row){
		$("#LandHouseEdit").modal({keyborad:true});
		$("#landHouse_ID").val(row.landHouse_ID); // 住宅 id
		zjm.init();
		//**注册编辑验证引擎 表单id*//
		zjm.validata({
			formId:"edit_landHouseFrom"
		});
		// 显示 住宅
		zjm.dataViewVal("edit_","/selectOneLandHouseInfo",{"landHouse_ID":row.landHouse_ID},"");
		/** 保存修改** */
		tool.undisabled("#saveLandHouseEdit");
		$("#saveLandHouseEdit").click(function() {
			if ($("#edit_landHouseFrom").validationEngine("validate")) {
				tool.disabled("#saveLandHouseEdit");
				var queryContainer_form = $("#edit_landHouseFrom");
				$.ajax({
					type : 'POST',
					url : '/updateOneLandHouseInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#LandHouseEdit").modal("hide");//隐藏模态窗
							$(".ztb_edit").val(""); // 页面清空
							$.zim_landHouse.initLandHouseTable(row.client_ID);
						} else {
							alert("保存失败！");
							tool.undisabled("#saveLandHouseEdit");
						}
					}
				});
			} else {
				tool.undisabled("#saveLandHouseEdit");
			}
		});
		$("#LandHouseEdit").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
			$("#saveLandHouseEdit").unbind("click");
		});
	}
	
	//查看
	function  LandHouseView(row){
		$("#LandHouseView").modal({keyborad:true});
		$.ajax({
			type:'post',
			url:'/selectOneLandHouseInfo',
			data: JSON.stringify({"landHouse_ID":row.landHouse_ID}),
			contentType : 'application/json; charset=UTF-8',
			success:function(data){
				$.each(data.obj,function(key,value){
					var rt=	$(".ztb_view_"+key).attr("class");
					if(typeof rt != 'undefined'){
						if(rt.indexOf('isCertificate') > 0){
							if(value == 1){ // =1 禁用，0启用
								$(".ztb_view_"+key).text("是");
							}else{
								$(".ztb_view_"+key).text("否");
							}
						}else{
							$(".ztb_view_"+key).text(tool.isNull(value,"（空）"));
						}
					}
				})
			}
		});
		$("#LandHouseView").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$(".btn-default").unbind("click");
		});
	}
	
	//住宅删除
	function LandHouseDel(row){
		$("#LandHouseDel").modal({keyborad:true});
		/** 确认删除 ** */
		tool.undisabled("#saveLandHouseDel");
		$("#saveLandHouseDel").click(function() {
			tool.disabled("#saveLandHouseDel");
				$.ajax({
					type : 'POST',
					url : '/deleteOneLandHouseInfo',
					data : row.landHouse_ID,
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$('#landHouse-table').bootstrapTable('remove', {
								field : 'landHouse_ID',
								values : [ row.landHouse_ID ]
							});
							$("#LandHouseDel").modal("hide");//隐藏模态窗
						} else {
							alert("保存失败！");
						}
					}
				});
		});
		$("#LandHouseDel").on("hidden.bs.modal", function(e) {// 解除模态窗的事件绑定
			$("#saveLandHouseDel").unbind("click");
		});
	}
})(jQuery, this);

$(function () {
	
	//获取客户id
	var client_ID = tool.getUrlParam('client_ID');
	$('.client_ID').val(client_ID);
	
	/**
	 *  加载主要资产情况分析: 住宅,其他住宅,存货,土地、厂房、名下房产, 机器设备及车辆等,财务情况说明。。
	 */
	$("#mainAssetList").click(function(){
		window.LandHouse.refreshLandHouseTable(client_ID );
		
	})

	//添加 住宅
	$("#landHouseAdd").click(function(){
		$.zim_landHouse.LandHouseAdd(client_ID);
	})
	
	
});


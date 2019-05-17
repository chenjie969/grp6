(function($,z){
	$.zjm_lawsuit = {
		initlawsuitProgressTable:initlawsuitProgressTable,//初始化列表
		initColumn:initColumn,//初始化列表项
		delLawsuitModule:delLawsuitModule,//删除法律诉讼
		lawsuitAdd:lawsuitAdd,//增加法律诉讼
		editModule:editModule//修改法律诉讼
	};
	var applyID = tool.getUrlParam("entityID");
	
/*	*//**初始化列表项**/
	function initColumn(){
		var columns = [{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"workDate",title: '日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.workDate)}},
						{field:"workStatus",title: '案件阶段',align: 'center',formatter: function (value, row, index) { return row.workStatus}},
						{field:"workDesc",title: '描述',align: 'center',formatter: function (value, row, index) { return row.workDesc}},
						{field:"operationManName",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.operationManName;}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark}},
					   ];
				var type = tool.getUrlParam('type');//获取路径类型:查看/修改
				if(type == 'edit'){		//&type='edit'显示删除按钮
					columns.push({title : '操作',align : 'center',formatter : function(value, rows, index) {
						return [
							'<button class="btn_lawsuit_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_lawsuit_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events : {
								'click .btn_lawsuit_edit': function(e, value, row, index) {
									$.zjm_lawsuit.editModule(row);
								},
								'click .btn_lawsuit_del': function(e, value, row, index) {
									$.zjm_lawsuit.delLawsuitModule(row);
								}										
							}
						});
		}
		return columns;
	};
	/**初始化列表***/
	function initlawsuitProgressTable(apply_ID){
		$("#lawsuitPro_table").bootstrapTable('destroy');
		$('#lawsuitPro_table').bootstrapTable({
			method: 'get',
			columns : initColumn(),
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [ 30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/lawsuitProgress/selectLawsuitProgressPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}
	
	/*function initlawsuitProgressTable(){
		$('#lawsuitPro_table').bootstrapTable('destroy');
		$('#lawsuitPro_table').bootstrapTable({
			method: 'post',
			columns: [	//{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"workDate",title: '日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.workDate)}},
						{field:"workStatus",title: '案件阶段',align: 'center',formatter: function (value, row, index) { return row.workStatus}},
						{field:"workDesc",title: '描述',align: 'center',formatter: function (value, row, index) { return row.workDesc}},
						{field:"operationManName",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.operationManName;}},
						{field:"remark",title: '备注',align: 'center',formatter: function (value, row, index) { return row.remark}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
//									'<button class="btn_creditApply_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_creditApply_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
//								'click .btn_creditApply_view': function(e, value, row, index) {
//									$.zjm_lawsuit.viewModule(row);
//								},
								'click .btn_creditApply_edit': function(e, value, row, index) {
									$.zjm_lawsuit.editModule(row);
								},
								'click .btn_creditApply_del': function(e, value, row, index) {
									$.zjm_lawsuit.delLawsuitModule(row);
								}
							}
						}
					],
			//detailView: true,
//			detailFormatter:function(index, row){
//			    var html = [];
//			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
//			    return html;
//			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [ 30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/lawsuitProgress/selectLawsuitProgressPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"queryCondition":{"apply_ID":applyID}});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
	}*/
	
	 /***查看***/
	function viewModule(row){
		//window.parent.openMenu('viewApplyInfo'+row.apply_ID,'','查看申请登记','/project/apply/projectApplyViewPage','&type='+'view',1);
		$("#projectRegister").modal({keyboard:true});
//		$("#projectApply_page").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
//			$("#applyInfo").modal({keyboard:true});
//		});
	}
	
	/***修改***/
	function editModule(row){
		$("#lawsuitProgress_page").load("/project/lawsuitProgress/lawsuitProgressEditPage",{"lawsuitProgress_ID":row.lawsuitProgress_ID},function(response,status,xhr){
			$("#lawsuitProgressEdit").modal({keyboard:true});
			$("#applyID").val(applyID);
			zjm.init();
			$.ajax({type:'POST',
				url:'/sys/dic/selectDepartsUserTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
					$("#creatUser_id").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
		    });
			/**注册编辑验证引擎*/
			zjm.validata({formId:"edit_lawsuitProgressForm"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#edit_lawsuitProgressForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_lawsuitProgressForm");
						$.ajax({type:'POST',url:'/project/lawsuitProgress/updateOneLawsuitProgressInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj){
								$("#lawsuitProgressEdit").modal("hide");
								$.zjm_lawsuit.initlawsuitProgressTable();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#lawsuitProgressEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
		
	}
	
	/***添加***/
	function lawsuitAdd(){
		$("#lawsuitProgress_page").load("/project/lawsuitProgress/lawsuitProgressAddPage",{},function(response,status,xhr){
			$("#lawsuitAdd").modal({keyboard:true});
			$("#applyID").val(applyID);
			zjm.init();
			$.ajax({type:'POST',
				url:'/sys/dic/selectDepartsUserTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
					$("#creatUser_id").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
		    });
			/**注册编辑验证引擎*/
			zjm.validata({formId:"add_lawsuitProgressForm"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#add_lawsuitProgressForm").validationEngine("validate")){
					var queryContainer_form = $("#add_lawsuitProgressForm");
						$.ajax({type:'POST',url:'/project/lawsuitProgress/insertOneLawsuitProgressInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#lawsuitAdd").modal("hide");
								$.zjm_lawsuit.initlawsuitProgressTable();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#lawsuitAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
		
	}
	
	/***删除***/
	function delLawsuitModule(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").html("删除");
		$("#delMessage").html("是否删除所选数据？");
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/lawsuitProgress/delOneLawsuitProgressInfo',data:JSON.stringify({"lawsuitProgress_ID":row.lawsuitProgress_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==1){
					$("#common_del").modal("hide");
					$.zjm_lawsuit.initlawsuitProgressTable();
				}else{
					alert("保存失败！");
					tool.undisabled(".btn_submit");
				}
	        }});
			$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_lawsuit.initlawsuitProgressTable();
	
	$("#btn_lawsuitAdd").click(function(){
		$.zjm_lawsuit.lawsuitAdd();
	});
});


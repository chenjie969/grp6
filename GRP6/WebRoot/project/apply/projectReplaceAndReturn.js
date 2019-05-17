(function($,z){
	$.zjm_replace = {
		initReplaceTable:initReplaceTable,//初始化列表
		initReturnDetailTable:initReturnDetailTable,
		returnAdd:returnAdd,//追偿添加
		replaceAdd:replaceAdd,//代偿添加
		replaceEdit:replaceEdit,//代偿修改
		replaceDel:replaceDel,//代偿删除
		returnEdit:returnEdit,//追偿修改
		returnDel:returnDel,//追偿删除
	};
	var project_ID = tool.getUrlParam("project_ID");
	/**初始化列表***/
	function initReplaceTable(){
		$('#replacePro_table').bootstrapTable('destroy');
		$('#replacePro_table').bootstrapTable({
			method: 'post',
			columns: [	
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"replaceDate",title: '上报日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.replaceDate,"")}},
				{field:"replaceDate",title: '代偿日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.replaceFactDate,"")},
					footerFormatter:function(rows){ 
						return "小计";
					}
				},
				{field:"replaceSum",title: '代偿金额(万)',align: 'center',formatter: function (value, row, index) { return row.replaceSum},
					footerFormatter:function(rows){ 
						var count_replaceSum = 0
						for(var index in rows){
							count_replaceSum += rows[index].replaceSum;
						}
						return count_replaceSum;
					}
				},
				
				{field:"dangerReplaceSum",title: '其中:准备金冲抵(万)',align: 'center',formatter: function (value, row, index) { return row.dangerReplaceSum},
					footerFormatter:function(rows){ 
						var count_dangerReplaceSum = 0
						for(var index in rows){
							count_dangerReplaceSum += rows[index].dangerReplaceSum;
						}
						return count_dangerReplaceSum;
					}
				},
				{field:"selfReplaceSum",title: '其中:自有资金代偿(万)',align: 'center',formatter: function (value, row, index) { return row.selfReplaceSum;},
					footerFormatter:function(rows){ 
						var count_selfReplaceSum = 0
						for(var index in rows){
							count_selfReplaceSum += rows[index].selfReplaceSum;
						}
						return count_selfReplaceSum;
					}
				},
				{field:"replaceCapitalSum",title: '其中:代偿本金(万)',align: 'center',formatter: function (value, row, index) { return row.replaceCapitalSum;},
					footerFormatter:function(rows){ 
						var count_replaceCapitalSum = 0
						for(var index in rows){
							count_replaceCapitalSum += rows[index].replaceCapitalSum;
						}
						return count_replaceCapitalSum;
					}
				},
				{field:"replaceInterestSum",title: '其中:代偿利息(万)',align: 'center',formatter: function (value, row, index) { return row.replaceInterestSum;},
					footerFormatter:function(rows){ 
						var count_replaceInterestSum = 0
						for(var index in rows){
							count_replaceInterestSum += rows[index].replaceInterestSum;
						}
						return count_replaceInterestSum;
					}
				},
				{field:"replaceOtherSum",title: '其中:代偿其它(万)',align: 'center',formatter: function (value, row, index) { return row.replaceOtherSum;},
					footerFormatter:function(rows){ 
						var count_replaceOtherSum = 0
						for(var index in rows){
							count_replaceOtherSum += rows[index].replaceOtherSum;
						}
						return count_replaceOtherSum;
					}
				},
				{field:"updateUserName",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.updateUserName;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_replace_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>'
//							'<button class="btn_replace_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'
							].join('');
					},
					events:{
						'click .btn_replace_edit': function(e, value, row, index) {
							$.zjm_replace.replaceEdit(row);
						},
						'click .btn_replace_del': function(e, value, row, index) {
							$.zjm_replace.replaceDel(row);
						}
					}
				}
			],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/Replace/selectReplacePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql":" and pro_replace.project_ID=\'" +project_ID+"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索  
			showFooter: false, //合计  设置footer显示
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
			showExport: false,                     //是否显示导出
			exportDataType: "basic"              //basic', 'all', 'selected'
		});
	};
	
	/**初始化列表***/
	function initReturnDetailTable(){
		$('#returnDetailPro_table').bootstrapTable('destroy');
		$('#returnDetailPro_table').bootstrapTable({
			method: 'post',
			columns: [	
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"returnDate",title: '上报日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.returnDate,"")}},
						{field:"returnDate",title: '追偿日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.returnFactDate,"")},
							footerFormatter:function(rows){ 
								return "小计";
							}
						},
						{field:"returnSum",title: '追偿金额(万)',align: 'center',formatter: function (value, row, index) { return row.returnSum;},
							footerFormatter:function(rows){ 
								var count_returnSum = 0
								for(var index in rows){
									count_returnSum += rows[index].returnSum;
								}
								return count_returnSum;
							}
						},
						{field:"returnCapitalSum",title: '其中:追偿本金(万)',align: 'center',formatter: function (value, row, index) { return row.returnCapitalSum;},
							footerFormatter:function(rows){ 
								var count_returnCapitalSum = 0
								for(var index in rows){
									count_returnCapitalSum += rows[index].returnCapitalSum;
								}
								return count_returnCapitalSum;
							}
						},
						{field:"returnInterestSum",title: '其中:追偿利息(万)',align: 'center',formatter: function (value, row, index) { return row.returnInterestSum;},
							footerFormatter:function(rows){ 
								var count_returnInterestSum = 0
								for(var index in rows){
									count_returnInterestSum += rows[index].returnInterestSum;
								}
								return count_returnInterestSum;
							}
						},
						{field:"returnOtherSum",title: '其中:追偿其它(万)',align: 'center',formatter: function (value, row, index) { return row.returnOtherSum},
							footerFormatter:function(rows){ 
								var count_returnOtherSum = 0
								for(var index in rows){
									count_returnOtherSum += rows[index].returnOtherSum;
								}
								return count_returnOtherSum;
							}
						},
						{field:"operationManName",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.operationManName;}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_return_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>'
//									'<button class="btn_return_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'
									].join('');
							},
							events:{
								'click .btn_return_edit': function(e, value, row, index) {
									$.zjm_replace.returnEdit(row);
								},
								'click .btn_return_del': function(e, value, row, index) {
									$.zjm_replace.returnDel(row);
								}
							}
						}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/returnDetail/selectReturnDetailPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql":" and projectID=\'" +project_ID+"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showFooter: false, //合计  设置footer显示
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	};
	
	/***代偿删除***/
	function replaceDel(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").html("删除");
		$("#delMessage").html("是否删除所选代偿信息？");
	};
	
	/***追偿删除***/
	function returnDel(row){
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").html("删除");
		$("#delMessage").html("是否删除所选追偿信息？");
	};
	
	
	/***追偿添加***/
	function returnAdd(){
		$("#replace_page").load("/project/returnDetail/returnDetailAddPage",{},function(response,status,xhr){
			$("#returnDetailAdd").modal({keyboard:true});
			$("#projectID").val($("#project_ID").val());
			$("#apply_ID").val($("#applyID").val());
			
			zjm.init();
			$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//设置上报日期默认值
			$('#id-date-picker-2').attr("value",tool.parseDate(new Date().getTime()));//设置追偿日期默认值
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
			zjm.validata({formId:"add_returnDetailForm"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#add_returnDetailForm").validationEngine("validate")){
					var queryContainer_form = $("#add_returnDetailForm");
						$.ajax({type:'POST',url:'/project/returnDetail/insertOneReturnDetailInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$("#returnDetailAdd").modal("hide");
								$.zjm_replace.initReturnDetailTable();
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
			$("#returnDetailAdd").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	};
	
	/***追偿修改***/
	function returnEdit(row){
		$("#replace_page").load("/project/returnDetail/returnDetailEditPage",{"returnDetail_ID":row.returnDetail_ID},function(response,status,xhr){
			$("#returnDetailEdit").modal({keyboard:true});
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
			zjm.validata({formId:"edit_returnDetailForm"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#edit_returnDetailForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_returnDetailForm");
					$.ajax({type:'POST',url:'/project/returnDetail/updateOneReturnDetailInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#returnDetailEdit").modal("hide");
							$.zjm_replace.initReturnDetailTable();
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
			$("#returnDetailEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	};
	
	/**代偿添加*/
	function replaceAdd(){
		var apply_ID = $("#applyID").val();
		$("#replace_page").load("/project/Replace/returnProjectReplacePage",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){				
			$("#projectReplace").modal({keyboard:true});
			zjm.init();
			$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//设置上报日期默认值
			$('#id-date-picker-2').attr("value",tool.parseDate(new Date().getTime()));//设置代偿日期默认值
			$("#project_ID").val(project_ID);
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#projectReplace_form").validationEngine("validate")){
					$("#projectReplace").modal("hide");
						var queryContainer_form = $("#projectReplace_form");
						$.ajax({type:'POST',url:'/project/Replace/insertOneReplace',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==true){
								$("#projectReplace").modal("hide");
								$.zjm_replace.initReplaceTable();
							}else{
								alert("代偿登记失败！");
							}
						}
						});
						
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#projectReplace").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		})
	
	};
	
	/**代偿修改*/
	function replaceEdit(row){
		$("#replace_page").load("/project/Replace/projectReplaceEditPage",{"replace_ID":row.replace_ID},function(response,status,xhr){				
			$("#projectReplaceEdit").modal({keyboard:true});
			zjm.init();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#projectReplaceEdit_form").validationEngine("validate")){
					$("#projectReplaceEdit").modal("hide");
					var queryContainer_form = $("#projectReplaceEdit_form");
					$.ajax({type:'POST',url:'/project/Replace/updateOneReplace',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==true){
							$("#projectReplaceEdit").modal("hide");
							$.zjm_replace.initReplaceTable();
						}else{
							alert("修改代偿信息失败！");
						}
					}
					});
					
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#projectReplaceEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		})
		
	};
	
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_replace.initReplaceTable();
	$.zjm_replace.initReturnDetailTable();
	
	$("#btn_returnAdd").click(function(){
		$.zjm_replace.returnAdd();
	});
	$("#btn_replaceAdd").click(function(){
		$.zjm_replace.replaceAdd();
	});
	
});


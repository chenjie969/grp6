(function($,z){
	$.zjm_replace = {
		initReplaceTotalTable:initReplaceTotalTable,//初始化列表
		initReplaceTable:initReplaceTable,//初始化列表
		initReturnDetailTable:initReturnDetailTable,
		initBadTable:initBadTable,
		returnAdd:returnAdd,
		badProEdit:badProEdit
	};
	var apply_ID = tool.getUrlParam("entityID");
	if( apply_ID==null || apply_ID ==undefined || apply_ID==""){
		apply_ID = $("#entityID").val();
	}
	/**初始化列表***/
	function initReplaceTotalTable(){
		$('#replaceTotalPro_table').bootstrapTable('destroy');
		$('#replaceTotalPro_table').bootstrapTable({
			method: 'post',
			columns: [	
				{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
				{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
				{field:'projectCode',title:'项目编号',align:'center',formatter: function (value, row, index) {return row.projectCode;}},
				{field:'projectName',title:'项目名称',align:'center',formatter: function (value, row, index) {return row.projectName;}},
				{field:'bankName',title:'合作机构',align:'center',formatter: function (value, row, index) {return row.bankName;}},
				{field:'loadSum',title:'担保金额（万）',align:'center',formatter: function (value, row, index) {return row.loadSum;}},
				{field:'guarantySum',title:'在保余额（万）',align:'center',formatter: function (value, row, index) {return row.guarantySum;}},
//				{field:'normalCapitalSum',title:'还款金额（万元）',align:'center',formatter: function (value, row, index) {return row.normalCapitalSum;}},
				{field:'replaceFreeSum',title:'代偿金额（万）',align:'center',formatter: function (value, row, index) {return row.replaceFreeSum;}},
				{field:'returnSum',title:'追偿金额（万）',align:'center',formatter: function (value, row, index) {return row.returnSum;}},
//				{field:'amanName',title:'A角',align:'center',formatter: function (value, row, index) {return row.amanName;}},
//				{field:'bmanName',title:'B角',align:'center',formatter: function (value, row, index) {return row.bmanName;}},
//				{field:'reviewManName',title:'风控评审人',align:'center',formatter: function (value, row, index) {return row.reviewManName;}},
				{title: '操作',align: 'center',formatter:function(value,row,index){
					var s= '';	
					if( row.badSum == null){
						s = '<a class="btn_lose_add" href="javascript:void(0)">|&nbsp;核销</a>';
					}
					return [
						'<a class="btn_return_add" href="javascript:void(0)">追偿&nbsp;</a>'+s,
						].join('');
					},
					events:{
						'click .btn_return_add': function(e, value, row, index) {
							$.zjm_replace.returnAdd(row);
						},
						'click .btn_lose_add': function(e, value, row, index) {
							$.zjm_replace.badProEdit(row);
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
			pageList: [ 30, 50, 100,200,500],  //可供选择的每页的行数（*）
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql":" and replaceFreeSum > 0 and pp.apply_ID =\'" +apply_ID +"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索  
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
	}
	
	/**初始化列表***/
	function initReplaceTable(){
		$('#replacePro_table').bootstrapTable('destroy');
		$('#replacePro_table').bootstrapTable({
			method: 'post',
			columns: [	
				{field:"replaceDate",title: '代偿日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.replaceDate,"")},
					footerFormatter:function(rows){ 
						return "小计";
					}
				},
				{field:"replaceSum",title: '代偿金额(万元)',align: 'center',formatter: function (value, row, index) { return row.replaceSum},
					footerFormatter:function(rows){ 
						var count_replaceSum = 0
						for(var index in rows){
							count_replaceSum += rows[index].replaceSum;
						}
						return count_replaceSum;
					}
				},
				
				{field:"replaceCapitalSum",title: '其中:准备金冲抵(万元)',align: 'center',formatter: function (value, row, index) { return row.replaceCapitalSum},
					footerFormatter:function(rows){ 
						var count_replaceCapitalSum = 0
						for(var index in rows){
							count_replaceCapitalSum += rows[index].replaceCapitalSum;
						}
						return count_replaceCapitalSum;
					}
				},
				{field:"replaceInterestSum",title: '其中:自有资金代偿(万元)',align: 'center',formatter: function (value, row, index) { return row.replaceInterestSum;},
					footerFormatter:function(rows){ 
						var count_replaceInterestSum = 0
						for(var index in rows){
							count_replaceInterestSum += rows[index].replaceInterestSum;
						}
						return count_replaceInterestSum;
					}
				},
				{field:"replaceOtherSum",title: '其中:代偿其它(万元)',align: 'center',formatter: function (value, row, index) { return row.replaceOtherSum;},
					footerFormatter:function(rows){ 
						var count_replaceOtherSum = 0
						for(var index in rows){
							count_replaceOtherSum += rows[index].replaceOtherSum;
						}
						return count_replaceOtherSum;
					}
				},
				{field:"updateUserName",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.updateUserName;}},
				{field:"repalceState",title: '审批状态',align: 'center',formatter: function (value, row, index) { return row.repalceState;}},
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
				$.extend(params,{"wheresql":" and pa.apply_ID =\'" +apply_ID +"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索  
			showFooter: true, //合计  设置footer显示
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
	}
	
	/**初始化列表***/
	function initReturnDetailTable(){
		$('#returnDetailPro_table').bootstrapTable('destroy');
		$('#returnDetailPro_table').bootstrapTable({
			method: 'post',
			columns: [	
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"returnDate",title: '追偿日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.returnDate,"")},
							footerFormatter:function(rows){ 
								return "小计";
							}
						},
						{field:"returnSum",title: '追偿金额(万元)',align: 'center',formatter: function (value, row, index) { return row.returnSum;},
							footerFormatter:function(rows){ 
								var count_returnSum = 0
								for(var index in rows){
									count_returnSum += rows[index].returnSum;
								}
								return count_returnSum;
							}
						},
						{field:"returnCapitalSum",title: '其中:追偿本金(万元)',align: 'center',formatter: function (value, row, index) { return row.returnCapitalSum;},
							footerFormatter:function(rows){ 
								var count_returnCapitalSum = 0
								for(var index in rows){
									count_returnCapitalSum += rows[index].returnCapitalSum;
								}
								return count_returnCapitalSum;
							}
						},
						{field:"returnInterestSum",title: '其中:追偿利息(万元)',align: 'center',formatter: function (value, row, index) { return row.returnInterestSum;},
							footerFormatter:function(rows){ 
								var count_returnInterestSum = 0
								for(var index in rows){
									count_returnInterestSum += rows[index].returnInterestSum;
								}
								return count_returnInterestSum;
							}
						},
						{field:"returnOtherSum",title: '其中:追偿其它(万元)',align: 'center',formatter: function (value, row, index) { return row.returnOtherSum},
							footerFormatter:function(rows){ 
								var count_returnOtherSum = 0
								for(var index in rows){
									count_returnOtherSum += rows[index].returnOtherSum;
								}
								return count_returnOtherSum;
							}
						},
						{field:"operationManName",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.operationManName;}},
//						{title: '操作',align: 'center',formatter:function(value,row,index){
//								return ['<button class="btn_creditApply_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>',
//									'<button class="btn_creditApply_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
//							},
//							events:{
//								'click .btn_creditApply_edit': function(e, value, row, index) {
//									$.zjm_replace.returnEditModule(row);
//								},
//								'click .btn_creditApply_del': function(e, value, row, index) {
//									$.zjm_replace.delReturnModule(row);
//								}
//							}
//						}
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
				$.extend(params,{"wheresql":" and apply_ID =\'" +apply_ID +"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showFooter: true, //合计  设置footer显示
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
	}
	
	/**初始化核销损失列表***/
	function initBadTable(){
		$('#losePro_table').bootstrapTable('destroy');
		$('#losePro_table').bootstrapTable({
			method: 'post',
			columns: [
				{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
				{field:'projectCode',title:'项目编号',align:'center',formatter: function (value, row, index) {return row.projectCode;}},
				{field:'projectName',title:'项目名称',align:'center',formatter: function (value, row, index) {return row.projectName;}},
				{field:'bankName',title:'合作机构',align:'center',formatter: function (value, row, index) {return row.bankName;},
					footerFormatter:function(rows){ 
						return "小计";
					}
				},
				{field:'loadSum',title:'担保金额（万）',align:'center',formatter: function (value, row, index) {return row.loadSum;},
					footerFormatter:function(rows){ 
						var count_loadSum = 0
						for(var index in rows){
							count_loadSum += rows[index].loadSum;
						}
						return count_loadSum;
					}
				},
				{field:"replaceFreeSum",title: '代偿金额(万元)',align: 'center',formatter: function (value, row, index) { return row.replaceFreeSum},
					footerFormatter:function(rows){ 
						var count_replaceFreeSum = 0
						for(var index in rows){
							count_replaceFreeSum += rows[index].replaceFreeSum;
						}
						return count_replaceFreeSum;
					}
				},
				{field:"returnSum",title: '追偿金额(万元)',align: 'center',formatter: function (value, row, index) { return row.returnSum;},
					footerFormatter:function(rows){ 
						var count_returnSum = 0
						for(var index in rows){
							count_returnSum += rows[index].returnSum;
						}
						return count_returnSum;
					}
				},
				{field:"badDate",title: '核销日期',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.badDate)}},
				{field:"badSum",title: '损失金额(万元)',align: 'center',formatter: function (value, row, index) { return row.badSum;},
					footerFormatter:function(rows){ 
						var count_badSum = 0
						for(var index in rows){
							count_badSum += rows[index].badSum;
						}
						return count_badSum;
					}
				},
				{field:"badUserName",title: '经办人',align: 'center',formatter: function (value, row, index) { return row.badUserName;}},
				],
				detailView: false,
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortName:"busiCode",
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
				url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					$.extend(params,{"wheresql":" and replaceFreeSum > 0 "+" and pp.apply_ID =\'" +apply_ID +"\'"});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
				showFooter: true, //合计  设置footer显示
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
	}
	
//	/***追偿删除***/
//	function delLoseModule(row){
//		$("#common_del").modal({keyboard:true});
//		$("#delModalLabel").html("删除");
//		$("#delMessage").html("是否删除所选数据？");
//		
//	}
	
	
	/***追偿添加***/
	function returnAdd(row){
		$("#replace_page").load("/project/returnDetail/returnDetailAddPage",{},function(response,status,xhr){
			$("#returnDetailAdd").modal({keyboard:true});
			$("#projectID").val(row.project_ID);
			$("#apply_ID").val(row.apply_ID);
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
								$.zjm_replace.initReplaceTotalTable();
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
	}
	
	/***核销损失添加***/
	function badProEdit(row){
		$("#replace_page").load("/project/project/badProEditPage",{},function(response,status,xhr){
			$("#badProEdit").modal({keyboard:true});
			$("#project_ID").val(row.project_ID);
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
			zjm.validata({formId:"add_returnDetailForm"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#badProEditForm").validationEngine("validate")){
					var queryContainer_form = $("#badProEditForm");
						$.ajax({type:'POST',url:'/project/project/updateProjectBadInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data){
								$("#badProEdit").modal("hide");
								$.zjm_replace.initReplaceTotalTable();
								$.zjm_replace.initBadTable();
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
			$("#badProEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
		
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_replace.initReplaceTotalTable();
	$.zjm_replace.initReplaceTable();
	$.zjm_replace.initReturnDetailTable();
	$.zjm_replace.initBadTable();
	
});


(function($,z){
	$.zjm_sealUpLaw = {
			initLoadTable:initLoadTable,//初始化-放款-列表
			initTableSeau:initTableSeau,//初始化资产查封列表
			addSealUp:addSealUp,//资产查封登记
			viewSealUp:viewSealUp,//资产查封查看
			editSealUp:editSealUp,//资产查封修改
			delSealUp:delSealUp,//资产查封删除
			addLaw:addLaw,//项目诉讼登记
			editLaw:editLaw,//项目诉讼修改
			delLaw:delLaw,//项目诉讼删除
			viewLaw:viewLaw,//项目诉讼查看
			initTableLaw:initTableLaw//初始化项目诉讼列表			
	};	
	/**初始化-放款-列表***/
	function initLoadTable(){		
		$('#projectLoad_table').bootstrapTable('destroy');
		$('#projectLoad_table').bootstrapTable({
			method: 'post',
			columns: [						
						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
						{field:"projectCode",title: '项目编号',align:'center',formatter: function (value, row, index) { return row.projectCode}},
						{field:"projectName",title: '项目名称',align:'center',formatter: function (value, row, index) { return row.projectName}},
						{field:"bankName",title: '放款机构',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.bankName;}},
						{field:"busiTypeName",title: '业务品种',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.busiTypeName}},
						{field:"loadSum",title: '担保金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.loadSum;}},
						{field:"guarantySum",title: '在保余额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.guarantySum;}},
						{field:"periodMonthDay",title: '担保期限',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.periodMonthDay;}},
						{field:"loadBeginDate",title: '起始日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.loadBeginDate);}},
						{field:"loadEndDate",title: '到期日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.loadEndDate);}},
						{title: '操作',align: 'center',formatter:function(value,row,index){				
							return ['<a href="javascript:void(0)"  class="btn_truth_edit">资产查封登记&nbsp;&nbsp;|&nbsp;&nbsp;</a><a href="javascript:void(0)"  class="detail">项目诉讼登记</a>'].join('');				
					
								},
								events:{	
									'click .btn_truth_edit': function(e, value, row, index) {							
										$.zjm_sealUpLaw.addSealUp(row);
									},
								
									'click .detail': function(e, value, row, index) {							
										$.zjm_sealUpLaw.addLaw(row);
									}
								}
								}
					],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			//sortName:"busiCode",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）		
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition ={"apply_ID":tool.getUrlParam('apply_ID')}; 
				 $.extend(params, {"queryCondition":queryCondition});
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
	/**初始化资产查封列表***/
	function initTableSeau(){
		
		$("#assetSeaulUP_table").bootstrapTable('destroy');
		$('#assetSeaulUP_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"applyPerson",title: '申请人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applyPerson;}},
				{field:"serialNum",title: '案件序号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.propertyType;}},
				{field:"targetSum",title: '执行标的',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.propertyType;}},
				{field:"propertyType",title: '资产保全方式',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.propertyType;}},
				{field:"lawCourt",title: '受理法院',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.lawCourt;}},
				{field:"executeBasis",title: '执行依据',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.executeBasis;}},
				{field:"isRecordName",title: '是否立案',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.isRecordName;}},
				{field:"recordNum",title: '案号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.recordNum;}},			
				
				
				{
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						return [
								'<button title ="查看" class="btn_Cooperations_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button  title ="修改" class="btn_Cooperations_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_Cooperations_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
								.join('');
					},
					// 事件绑定
					events : {
						'click .btn_Cooperations_view' : function(
								e, value, row, index) {
							$.zjm_sealUpLaw.viewSealUp(row);
						},
						'click .btn_Cooperations_edit' : function(
								e, value, row, index) {
							$.zjm_sealUpLaw.editSealUp(row);
						},
						'click .btn_Cooperations_del' : function(
								e, value, row, index) {
							$.zjm_sealUpLaw.delSealUp(row);
							
						}
					}
				}
			],
								
				detailView: false,
				detailFormatter:function(index, row){
					
					var html = [];
					html.push('<p><b>序号:</b> ' +(index+1)  + '</p>');
					html.push('<p><b>申请人:</b> ' + row.applyPerson + '</p>');
					html.push('<p><b>资产保全方式:</b> ' + + '</p>');
					html.push('<p><b>受理法院:</b> ' + + '</p>');
					html.push('<p><b>执行依据:</b> ' + + '</p>');
					html.push('<p><b>负责法院或者其他备注信息:</b> ' + + '</p>');
					return html;
				},
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				//sortName:"busiCode",
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）		
				url: "/project/seaulUp/selectSeaulUpPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var queryCondition ={"apply_ID":tool.getUrlParam('apply_ID')}; 
					 $.extend(params, {"queryCondition":queryCondition});
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
	/**初始化项目诉讼列表***/
	function initTableLaw(){
		
		$("#lawsuit_table").bootstrapTable('destroy');
		$('#lawsuit_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"recordNum",title: '案号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.recordNum;}},
				{field:"plaintiff",title: '原告',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.plaintiff;}},
				{field:"defendant",title: '被告',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.defendant;}},
				{field:"lawsuitSum",title: '起诉金额',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.lawsuitSum;}},
				{field:"lawCourt",title: '管辖法院',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.lawCourt;}},
				{field:"caseInfo",title: '案件进展',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.caseInfo;}},
				{field:"lawsuitDate",title: '起诉时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.lawsuitDate);}},
				{
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						return [
								'<button title ="查看" class="btn_Cooperations_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button  title ="修改" class="btn_Cooperations_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_Cooperations_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
								.join('');
					},
					// 事件绑定
					events : {
						'click .btn_Cooperations_view' : function(
								e, value, row, index) {
							$.zjm_sealUpLaw.viewLaw(row);
						},
						'click .btn_Cooperations_edit' : function(
								e, value, row, index) {
							$.zjm_sealUpLaw.editLaw(row);
						},
						'click .btn_Cooperations_del' : function(
								e, value, row, index) {
							$.zjm_sealUpLaw.delLaw(row);
							
						}
					}
				}
				
			],
								
				detailView: false,
				detailFormatter:function(index, row){									
					var html = [];
					html.push('<p><b>序号:</b> ' +(index+1)  + '</p>');
					html.push('<p><b>原告:</b> ' +  + '</p>');
					html.push('<p><b>被告:</b> ' + + '</p>');
					html.push('<p><b>起诉金额:</b> ' + + '</p>');
					html.push('<p><b>管辖法院:</b> ' + + '</p>');
					html.push('<p><b>案件进展:</b> ' + + '</p>');
					return html;
				},
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				//sortName:"busiCode",
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）		
				url: "/project/lawSuit/selectLawSuitPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var queryCondition ={"apply_ID":tool.getUrlParam('apply_ID')}; 
					 $.extend(params, {"queryCondition":queryCondition});
					return params;
				},//前端调用服务
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
   //  添加资产查封
	function addSealUp(row){
		$("#SealUpLaw_page").load(
				"/project/seaulUp/selectSeaulUpAddPage",{"project_ID":row.project_ID},function(response,status,xhr){
					$("#addSeaulModal").modal({keyboard:true});				
					zjm.init();				
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#addSeaul_Form").validationEngine("validate")){
							var queryContainer_form = $("#addSeaul_Form");	
								$.ajax({type:'POST',url:'/project/seaulUp/insertOneSeaulUpInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {							        	
									if(data.obj==1){							        	
											$("#addSeaulModal").modal("hide");									
											$.zjm_sealUpLaw.initTableSeau();										
							        	}else{
											alert("保存失败！");
										}
							        }
								});
						
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	
	
	
	
	  
	/**查看资产查封*/
	function viewSealUp(row){
		$("#SealUpLaw_page").load(
				"/project/seaulUp/selectSeaulUpViewPage",{"assetSealUp_ID":row.assetSealUp_ID},function(response,status,xhr){
					$("#viewSeaulModal").modal({keyboard:true});
				}
		);
	}
	
	//  资产查封修改
	function editSealUp(row){
		$("#SealUpLaw_page").load(
				"/project/seaulUp/selectSeaulUpEditPage",{"assetSealUp_ID":row.assetSealUp_ID},function(response,status,xhr){
					$("#editSeaulModal").modal({keyboard:true});				
					zjm.init();				
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#editSeaul_Form").validationEngine("validate")){
							var queryContainer_form = $("#editSeaul_Form");	
						
								$.ajax({type:'POST',url:'/project/seaulUp/updateOneSeaulUpInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {							        	
									if(data.obj==1){							        	
											$("#editSeaulModal").modal("hide");									
											$.zjm_sealUpLaw.initTableSeau();						
							        	}else{
											alert("保存失败！");
										}
							        }
								});
						
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	//删除资产查封
	function delSealUp(row){
	$("#SealUpLaw_page").load(
			"/project/seaulUp/selectSeaulUpDelPage",{"assetSealUp_ID":row.assetSealUp_ID},function(response,status,xhr){
				$("#delSeaulmodule").modal({keyboard:true});
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					$.ajax({type:'POST',url:'/project/seaulUp/delectOneSeaulUpInfo',data:JSON.stringify({"assetSealUp_ID":row.assetSealUp_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$('#assetSeaulUP_table').bootstrapTable('remove', {
								field: 'assetSealUp_ID',
								values: [row.assetSealUp_ID]
							});
							$("#delSeaulmodule").modal("hide");
						}else{
							alert("删除失败！");
						}
					}
					});
				});
			}
	);
}	
	//  添加项目诉讼
	function addLaw(row){
		$("#SealUpLaw_page").load(
				"/project/lawSuit/selectLawSuitAddPage",{"project_ID":row.project_ID},function(response,status,xhr){
					$("#addLawsuitModal").modal({keyboard:true});				
					zjm.init();				
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#addLawsuit_Form").validationEngine("validate")){
							var queryContainer_form = $("#addLawsuit_Form");						
								$.ajax({type:'POST',url:'/project/lawSuit/insertOneLawSuitInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	
									if(data.obj==1){							        	
											$("#addLawsuitModal").modal("hide");
											$.zjm_sealUpLaw.initTableLaw();
							        	}else{
											alert("保存失败！");
										}
							        }
								});
						
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	  
	/**查看项目诉讼情况*/
	function viewLaw(row){
		$("#SealUpLaw_page").load(
				"/project/lawSuit/selectLawSuitViewPage",{"projectLawsuit_ID":row.projectLawsuit_ID},function(response,status,xhr){
					$("#viewLawSuitModal").modal({keyboard:true});
				}
		);
	}
	
	//  项目诉讼修改
	function editLaw(row){
		$("#SealUpLaw_page").load(
				"/project/lawSuit/selectLawSuitEditPage",{"projectLawsuit_ID":row.projectLawsuit_ID},function(response,status,xhr){
					$("#editLawSuitModal").modal({keyboard:true});				
					zjm.init();				
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#editLawSuit_Form").validationEngine("validate")){
							var queryContainer_form = $("#editLawSuit_Form");	
								$.ajax({type:'POST',url:'/project/lawSuit/updateOneLawSuitInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {							        	
									if(data.obj==1){							        	
											$("#editLawSuitModal").modal("hide");									
											$.zjm_sealUpLaw.initTableLaw();						
							        	}else{
											alert("保存失败！");
										}
							        }
								});
						
						}else{
							tool.undisabled(".btn_submit");
						}
					});
				}
		);
	}
	//删除项目诉讼
	function delLaw(row){
	$("#SealUpLaw_page").load(
			"/project/lawSuit/selectLawSuitDelPage",{"projectLawsuit_ID":row.projectLawsuit_ID},function(response,status,xhr){
				$("#delLawSuitmodule").modal({keyboard:true});
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					$.ajax({type:'POST',url:'/project/lawSuit/delectOneLawSuitInfo',data:JSON.stringify({"projectLawsuit_ID":row.projectLawsuit_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$('#lawsuit_table').bootstrapTable('remove', {
								field: 'projectLawsuit_ID',
								values: [row.projectLawsuit_ID]
							});
							$("#delLawSuitmodule").modal("hide");
							$.zjm_sealUpLaw.initTableLaw();	
						}else{
							alert("删除失败！");
						}
					}
					});
				});
			}
	);
}	
  
})(jQuery, this);
$(function () {	
	var apply_ID = tool.getUrlParam('apply_ID');//获取业务id
	$.zjm_sealUpLaw.initTableSeau();
	$.zjm_sealUpLaw.initTableLaw();
	$.zjm_sealUpLaw.initLoadTable();
});

 
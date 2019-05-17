(function($,z){
	$.zjm_projectState = {
			addDynamic:addDynamic,//添加项目动态	
			initTable:initTable,//初始化列表
			viewDynamic:viewDynamic,//查看项目动态
			delDynamic:delDynamic//删除项目动态
	};
	
	/**初始化列表***/
	function initTable(apply_ID){
		
		$("#dynamic_table").bootstrapTable('destroy');
		$('#dynamic_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"createUserName",title: '发布人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.createUserName;}},
				{field:"dynamicContentShort",title: '项目动态',align: 'center',sortable:"true",formatter: function (value, row, index) { 	
										
					return [
						'<a href="javascript:void(0)"  id="aid" class="dongtaiContent" title='+row.dynamicContent+'>'+row.dynamicContentShort+'</a>'
					].join('');
				},
				events : {
					'click #aid' : function(
							e, value, row, index) {
						$.zjm_projectState.viewDynamic(row);						
					},	
				}
				},						
				{field:"createDateTime",title: '发布时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDateDetail(row.createDateTime);}},
				
				{
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						return [		
							'<button title="查看" class="btn_Cooperations_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>' ]
						.join('');
					},
					// 事件绑定
					events : {
						'click .btn_Cooperations_view' : function(
								e, value, row, index) {
							$.zjm_projectState.viewDynamic(row);							
						},		
					}				
					
				}],
								
				detailView: true,
				detailFormatter:function(index, row){
					
					var html = [];
					html.push('<p><b>序号:</b> ' +(index+1)  + '</p>');
					html.push('<p><b>发布人:</b> ' + row.createUserName + '</p>');
					html.push('<p><b>发布内容:</b> ' + row.dynamicContent + '</p>');
					html.push('<p><b>发布时间:</b> ' + tool.parseDateDetail(row.createDateTime)  + '</p>');
					return html;
				},
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,     //设置为 true 会在表格底部显示分页条
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [ 30, 50, 100,200, 500],  //可供选择的每页的行数（*）
				url: "/project/projectTracking/selectDynamicListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams:  function(params) {
					 $.extend(params, {"queryCondition":{"apply_ID":apply_ID}});
					 return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
				showColumns: true,     //是否显示所有的列
				showRefresh: true,     //是否显示刷新按钮
				minimumCountColumns: 2,    //最少允许的列数
				clickToSelect: false,    //是否启用点击选中行
				searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
				showToggle: true,//是否显示详细视图和列表视图的切换按钮
				showPaginationSwitch:true,
				showExport: true,                     //是否显示导出
				exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}    
    /* 添加项目动态*/
	function addDynamic(apply_ID){
		$("#DynamicInfo_page").load(
				"/project/projectTracking/selectDynamicAddPage",{"apply_ID":apply_ID},function(response,status,xhr){
					$("#addDynamicModal").modal({keyboard:true});				
					zjm.init();				
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						if($("#addDynamic_Form").validationEngine("validate")){
							var queryContainer_form = $("#addDynamic_Form");						
								$.ajax({type:'POST',url:'/project/projectTracking/insertOneDynamicInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	
									if(data.obj==1){							        	
											$("#addDynamicModal").modal("hide");
											var apply_ID = tool.getUrlParam('apply_ID');
											$.zjm_projectState.initTable(apply_ID);
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
	/**查看项目动态*/
	function viewDynamic(row){
		$("#ViewdynamicInfo_page").load(
				"/project/projectTracking/selectDynamicViewPage",{"dynamic_ID":row.dynamic_ID},function(response,status,xhr){
					$("#viewdynamicModal").modal({keyboard:true});							
					$(".btn_Dynamic_del").click(function(){
						$("#viewdynamicModal").modal("hide");	
						$.zjm_projectState.delDynamic(row);					
					});
					
					
					
				}
		);
	}
	//删除一条项目动态
	function delDynamic(row){
	$("#DynamicInfo_page").load(
			"/project/projectTracking/selectDynamicDelPage",{"dynamic_ID":row.dynamic_ID},function(response,status,xhr){			
				$("#delDynamicmodule").modal({keyboard:true});
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");				
					$.ajax({type:'POST',url:'/project/projectTracking/delectOneDynamicInfo',data:JSON.stringify({"dynamic_ID":row.dynamic_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){						
							$("#delDynamicmodule").modal("hide");
							var apply_ID = tool.getUrlParam('apply_ID');
							$.zjm_projectState.initTable(apply_ID);
						
						}else if(data.obj=="error"){						
							$("#delDynamicmodule").modal("hide");
							$("#delDynamicmoduleLoser").modal({keyboard:true});							
						}
						else{
							alert("保存失败")
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

	$.zjm_projectState.initTable(apply_ID);
	// 添加项目动态 
	$("#btn_addDynamic").click(function(){			
		$.zjm_projectState.addDynamic(apply_ID);
	});	


});

 
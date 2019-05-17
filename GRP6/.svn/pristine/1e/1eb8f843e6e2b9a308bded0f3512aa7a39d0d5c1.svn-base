(function($,z){
	$.zjm_stopProject = {
			initTable:initTable,//初始化列表
			initColumns:initColumns,//初始化列表项
			viewModule:viewModule,//查看
			delOneProjectApply :delOneProjectApply,//列表单个删除;
			delSelectProjectApply:delSelectProjectApply,//列表删除多选;
	};
	
	/**初始化列表***/
	function initTable(data){
		$('#stopProject_table').bootstrapTable('destroy');
		$('#stopProject_table').bootstrapTable({
			method: 'post',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			       /* html.push('<p><b>序号:</b> ' + index+1 + '</p>');*/
			        html.push('<p><b>类型：</b> ' + tool.isNull(row.proType,"") + '</p>');
			        html.push('<p><b>项目编号: </b> ' + tool.isNull(row.busiCode,"（空）") + '</p>');				        
			        html.push('<p><b>项目名称：</b> ' + tool.isNull(row.projectName,"") + '</p>');
			        html.push('<p><b>经办部门：</b> ' + tool.isNull(row.departName,"") + '</p>');
			        html.push('<p><b>经办人：</b> ' + tool.isNull(row.createManName,"") + '</p>');
			        html.push('<p><b>否决日期：</b> ' + tool.parseDate(row.stopDate) + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"createDate",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/stop/selectStopProjectPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={}; 
				 $.extend(queryCondition,data);
				 $.extend(params, {"queryCondition":queryCondition});
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
	
	/**初始化列表项***/
	function initColumns(condition){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'proType',title:'类型',align:'center',formatter: function (value, row, index) {return row.proType;}},
			{field:'busiCode',title:'项目编号',align:'center',sortable : "true",formatter: function (value, row, index) {return row.busiCode;}},
			{field:'projectName',title:'项目名称',align:'center',sortable : "true",formatter: function (value, row, index) {
				
				return [ '<a class="btn_projectName_view" href="javascript:void(0)">'
					+ row.projectName + '</a>' ]
					.join('');},
				//项目名称绑定事件
					events : {
						'click .btn_client_view' : function(
								e, value, row, index) {
							//$.zjm_stopProject.viewCompanyClient(row);
									
						},
					}
				},
			{field:'busiTypeName',title:'业务品种',align:'center',formatter: function (value, row, index) {return row.busiTypeNameList;}},
			{field:'departName',title:'经办部门',align:'center',sortable : "true",formatter: function (value, row, index) {return row.departName;}},
			{field:'createManName',title:'经办人',align:'center',sortable : "true",formatter: function (value, row, index) {return row.createManName;}},
			{field:'createDate',title:'否决日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.stopDate);}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return ['<button class="btn_projectApply_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
					'<button class="btn_projectApply_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_projectApply_view': function(e, value, row, index) {
						$.zjm_stopProject.viewModule(row);
					},
					'click .btn_projectApply_del': function(e, value, row, index) {
						$.zjm_stopProject.delOneProjectApply(row);
					}
				}
			}
		];
		return columns;
		
	}
	
	
    
    /***查看***/
	function viewModule(row){
		$("#stopProjectTable_page").load("/project/stop/stopProjectViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#stopProjectInfo_page").modal({keyboard:true});
		});
	}
	/*列表单个删除*/
	function delOneProjectApply(row){		
		$("#common_del").modal({keyboard:true});
		$("#delModalLabel").text("删除");//标题;
		$("#delMessage").text("确定要删除所选数据吗?");//提示信息;
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/project/apply/delOneProjectApply',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#stopProject_table').bootstrapTable('remove', {
							field: 'apply_ID',
							values: [row.apply_ID]
						});
						$("#common_del").modal("hide");
						$.zjm_stopProject.initTable();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		
		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	//删除多选
	function delSelectProjectApply(){
		var selectContent = $('#stopProject_table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{         
        	 $.map($('#stopProject_table').bootstrapTable('getSelections'), function(row) {//获取选中行;
	        	 $('#common_del').modal('show');     // 项目立项面板  
	        	 $("#delModalLabel").text("删除");//标题;
	     		 $("#delMessage").text("确定要删除所选数据吗?");//提示信息;
	     		
	             tool.undisabled(".btn_submit");
	     		$(".btn_submit").click(function(){
	     			tool.disabled(".btn_submit");
	     			$.ajax({type:'POST',url:'/project/apply/delOneProjectApply',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	     		        	if(data.obj==true){
	     						$('#stopProject_table').bootstrapTable('remove', {
	     							field: 'apply_ID',
	     							values: [row.apply_ID]
	     						});
	     						$("#common_del").modal("hide");
	     						$.zjm_stopProject.initTable();
	     					}else{
	     						alert("删除失败！");
	     					}
	     		        }
	     			});
	     		});
	     		$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
	     			 $(".btn_submit").unbind("click");
	     		});
	        });//多选
           
        }  
		};
		
		
	
})(jQuery, this);

$(function () {
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
  		$.zjm_stopProject.initTable();
	};
	//重置申请列表;
	$("#btn_refreshApplyTable").click(function(){
		$.zjm_stopProject.initTable();
	});
	
	/**
	 * 删除多选
	 * 
	 */
	$("#btn_stopProjectsDel").click(function(){
		$.zjm_stopProject.delSelectProjectApply();
	});
});


$(function($,z){
	zjm_initSlaveClient={
		initSlaveClientTable:initSlaveClientTable ,//初始化 副版本客户列表
		MainSyncSlaveClient:MainSyncSlaveClient // 主版本同步到副版本
		
	};
	
	
	function initSlaveClientTable(guid){
		$("#companyProject-table").bootstrapTable('destroy');
		$('#companyProject-table').bootstrapTable({
			method: 'post',
//			singleSelect : true,// 单选checkbox
			columns : [{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return index+1;}},
					{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
					{field:'projectType',title:'类型',align:'center',formatter: function (value, row, index) {return row.projectType;}},
					{field:'busiCode',title:'项目编号',align:'center',sortable : "true",formatter: function (value, row, index) {return row.busiCode;}},
					{field:'projectName',title:'项目名称',align:'center',sortable : "true",formatter: function (value, row, index) {return row.projectName;}},
					{field:'departName',title:'经办部门',align:'center',sortable : "true",formatter: function (value, row, index) {return row.departName;}},
					{field:'createManName',title:'创建人',align:'center',sortable : "true",formatter: function (value, row, index) {return row.createManName;}},
					{field:'createDate',title:'登记日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.createDate);}},
					], //end columns
			detailView: false,
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
			url: "/selectProjectPageTableByClient",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientGUID":guid}});				
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
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
	        showExport: false,                     //是否显示导出
	        exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	
	
	/**
	 *  客户资料主版本同步到副版本
	 */
	function  MainSyncSlaveClient(){
		var selectContent = $('#companyProject-table').bootstrapTable('getSelections');  			
        if(selectContent.length < 1) {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }
        var clientIDS="";
        for(var i in selectContent){
        	if(i < selectContent.length-1 ){
        		clientIDS+=selectContent[i].client_ID+",";
        	}else{
        		clientIDS+=selectContent[i].client_ID;
        	}
        }
		
    
        $.ajax({
        	type:"post",
        	url:"/MainSyncSlaveClient",
        	data:{"client_ID":clientIDS},
        	contentType:"application/x-www-form-urlencoded",
        	dataType:"json",
        	success:function(data){
        		if(data.obj){
        			$("#synchroCompanyClientmodule").modal("hide");
        			$("#success").modal({keyboard:true});
        		}else{
        			alert("同步失败！");
        		}
        	},
        	
        });
        
        
		
	}
	
	
	
	
});

$(function(){
	/**
	 * 初始化执行
	 */
	var guid=$("#clientGUIDs").val();
	zjm_initSlaveClient.initSlaveClientTable(guid);
	
	/**
	 * 主版本同步到副版本项目
	 */
	$("#btn-commit").click(function(){
		zjm_initSlaveClient.MainSyncSlaveClient();
	});
	
});
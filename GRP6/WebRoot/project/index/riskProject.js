(function($,z){
	$.zjm_projectTracking = {
			initColumns:initColumns,
			initProjectTalble:initProjectTalble,//初始化列表
			transact:transact,//办理
			editModule:editModule,//客户列表修改
			delModule:delModule,//客户列表删除
			hightSelect:hightSelect,//高级查询
	};
		
	function initColumns(condition){
		var columns = [
//			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'projectType',title:'类型',align:'center',formatter: function (value, row, index) {return row.projectType;}},
			{field:'busiCode',title:'业务编号',align:'center',formatter: function (value, row, index) {return row.busiCode;}},
			{field:'projectName',title:'项目名称',align:'center',formatter: function (value, row, index) {
				return  row.projectName ;},
				/*[ '<a class="btn_projectName_view" title="项目办理" href="javascript:void(0)">'
					+ row.projectName + '</a>' ]
					.join('');
				},*/
				//项目名称绑定事件
					events : {
						'click .btn_projectName_view' : function(e, value, row, index) {
							$.zjm_projectTracking.projectDeal(row);
									
						},
					}
				},
				
//			{field:'departName',title:'经办部门',align:'center',formatter: function (value, row, index) {return row.departName;}},
			{field:'oprationCompanyName',title:'报送机构',align:'center',formatter: function (value, row, index) {return row.oprationCompanyName;}},
			{field:'createManName',title:'经办人',align:'center',formatter: function (value, row, index) {return row.createManName;}},
			{field:'createDate',title:'受理日期',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.createDate);}},
			{field:'projectStageName',title:'业务阶段',align:'center',formatter: function (value, row, index) {return row.projectStageName;}},
			{field:'riskLevelName',title:'风险等级',align:'center',formatter: function (value, row, index) {return row.riskLevelName;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button class="btn_modules_edit btn btn-xs btn-pink" title="项目办理" ><i class="icon-edit bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_modules_edit': function(e, value, row, index) {
						if(row.productInstance_ID != null ){
							$.zjm_projectTracking.projectDeal(row);
						}else {
							alert("该项目没有流程实例，不能进行操作");
						}
					}
				}
			}
		];
		$.zjm_projectTracking.initProjectTalble(columns);
		
	}	
	
	/**初始化列表***/
	function initProjectTalble(columns){
		$("#project-table").bootstrapTable('destroy');
		$('#project-table').bootstrapTable({
			method: 'get',
			columns: columns,
			detailView: false,
			detailFormatter:function(index, row){
				var html = [];
//			        html.push('<p><b>序号:</b> ' + index+1 + '</p>');
			        html.push('<p><b>类型：</b> ' + row.projectType + '</p>');
			        html.push('<p><b>业务编号：</b> ' + row.busiCode + '</p>');
			        html.push('<p><b>项目名称：</b> ' + row.projectName + '</p>');
			        html.push('<p><b>经办部门：</b> ' + row.departName + '</p>');
			        html.push('<p><b>经办人：</b> ' + row.createManName + '</p>');
			        html.push('<p><b>受理日期：</b> ' + tool.parseDate(row.createDate) + '</p>');
			        html.push('<p><b>业务阶段：</b> ' + row.projectStageName + '</p>');
			        html.push('<p><b>风险等级：</b> ' + row.riskLevelName + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			singleSelect : true,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			sortName: "busiCode",     //默认排序字段
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/apply/selectRiskApplyPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql":" and c.ristLevelName != '正常' "});
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

	/***办理***/
	function transact(){
		var selectContent = $('#project-table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{  
        	window.parent.openMenu('edit_transact'+selectContent.client_ID,'','项目办理','/project/apply/transact.jsp','&client_ID='+'client_ID');
        }
	}
	
	/***修改***/
	function editModule(row){
		window.parent.openMenu('projectDeal'+row.apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+row.apply_ID,1);
	}
	
	/**删除***/
	function delModule(row){
		$("#delPersonClientmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/deleteOneCompanyClientInfo',data:JSON.stringify({"client_ID":row.client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#project-table').bootstrapTable('remove', {
							field: 'client_ID',
							values: [row.client_ID]
						});
						$.zjm_projectTracking.initColumns();
						$("#delPersonClientmodule").modal("hide");
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#delPersonClientmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**高级查询**/
	function hightSelect(){
		$("#hightSelectPersonClient").modal({keyboard:true});
		zjm.init();
		//获取部门下拉树;
		$.ajax({type:'POST',url:'/selectAllDepartsListTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#fullDepartCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
		
		/**注册编辑验证引擎*/
		zjm.validata({formId:"hightSelect_personClientForm"});
		/**提交*/
		tool.undisabled(".btn_submit");
		
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#hightSelect_personClientForm").validationEngine("validate")){
					var queryContainer_form = $("#hightSelect_personClientForm");
					var condition = queryContainer_form.serializeJson();
					$("#hightSelectPersonClient").modal("hide");
					$(".ztb_hightSelect").val("");
					initColumns(condition);
					
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#hightSelectPersonClient").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
		$.zjm_projectTracking.initColumns();
	};
	/**
	 * 办理
	 */
	$("#btn_transact").click(function(){
		$.zjm_projectTracking.transact();
	});

	/**
	 * 删除
	 */
	$("#btn_deleteOfSelected").click(function(){
		$.zjm_projectTracking.deleteOfSelected();
	});
	
	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_projectTracking.hightSelect();
	});
	
	$("#btn_refresh").click(function(){
		$.zjm_projectTracking.initColumns();
	});
	
});


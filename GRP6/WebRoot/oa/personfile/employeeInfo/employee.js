(function($,z){
	$.zjm_personfileEmployee = {
			initTree:initTree,// 加载树结构	
			initTable:initTable,// 初始化列表
			viewEmployee:viewEmployee,// 员工列表查看
			editEmployee:editEmployee,// 员工列表修改
			//delEmployee:delEmployee,// 员工列表删除
//			hightSelect:hightSelect,// 高级查询		
			disMissionSelected:disMissionSelected// 离职
	};

	var zTreeObj; // ztree对象
	/**加载树结构*/
	function initTree(depart_uid){
		var setting = {callback :{onClick : zTreeOnMouseDown /** 捕获 zTree 上鼠标按键按下后的事件回调函数**/}};
		zTreeObj = tree.init({initID:"menuSetTree",url:"/selectAllDepartsListTree"},setting);
		/**单击 节点 触发的函数**/
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
			tree.expand();
			$.zjm_personfileEmployee.initTable(treeNode.id/*,null*/);
		};
		if(depart_uid==null){depart_uid='a129b9eea27a48be896697a39aa0aee7';}
		$.zjm_personfileEmployee.initTable(depart_uid/*,null*/);
	}

	/** 初始化列表** */
	function initTable(nodeid/*,condition*/){
		$("#employee-table").bootstrapTable('destroy');
		$('#employee-table').bootstrapTable({
			method: 'get',
			singleSelect : true,
			columns: [				
				    {field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {}},
				    {title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				    {field:"user_name",title: '姓名',align: 'center',formatter: function (value, row, index) {return  row.user_name;}}, 
					{field:"sex",title: '性别',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.sex;}}, 
					{field:"borndate",title: '出生日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.borndate);}}, 
					//修改了籍贯111111
					{title: '籍贯',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.staffBirthplace;}}, 
					{title: '民族',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.staffNationalNmae;}},
					{field:"staffEducation",title: '学历',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.staffEducationName;}},
					{field:"mobilphone",title: '手机号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.mobilphone;}},
					{
						title : '操作',
						align : 'center',
						formatter : function(value, row, index) {
							return [
									'<button title ="查看" class="btn_Cooperations_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button  title ="修改" class="btn_Cooperations_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
/*									'<button class="btn_Cooperations_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' */]
									.join('');
						},
						// 事件绑定
						events : {
							'click .btn_Cooperations_view' : function(
									e, value, row, index) {
								$.zjm_personfileEmployee.viewEmployee(row);
							},
							'click .btn_Cooperations_edit' : function(
									e, value, row, index) {
								$.zjm_personfileEmployee
										.editEmployee(row);
							}/*,
							'click .btn_Cooperations_del' : function(
									e, value, row, index) {
								$.zjm_personfileEmployee.delEmployee(row);
							}*/
						}
					}],

					detailView: true,
					detailFormatter:function(index, row){
						var staffBirthplace = row.staffBirthplace;
						if(staffBirthplace == null){
							
							staffBirthplace="（空）";
						}
						var staffNationalNmae = row.staffNationalNmae;
						if(staffNationalNmae == null){
							
							staffNationalNmae="（空）";
						}
						var staffEducationName = row.staffEducationName;
						if(staffEducationName == null){
							
							staffEducationName="（空）";
						}
						
						var mobilphone = row.mobilphone;
						if(mobilphone == null){							
							mobilphone="（空）";
						}
						var user_name = row.user_name;
						if(user_name == null){							
							user_name="（空）";
						}
						var sex = row.sex;
						if(sex == null){							
							sex="（空）";
						}
						var borndate= tool.parseDate(tool.isNull(row.borndate,""));
						borndate=borndate==""?'（空）':borndate;
						var html = [];
						html.push('<p><b>序号:</b> ' + (index+1) + '</p>');						
						html.push('<p><b>姓名:</b> ' + user_name + '</p>');
						html.push('<p><b>性别:</b> ' + sex + '</p>');
						html.push('<p><b>出生日期:</b> ' +  borndate + '</p>');
						html.push('<p><b>籍贯:</b> ' + staffBirthplace + '</p>');
						html.push('<p><b>民族:</b> ' + staffNationalNmae + '</p>');
						html.push('<p><b>学历:</b> ' + staffEducationName + '</p>');
						html.push('<p><b>手机号:</b> ' + mobilphone + '</p>');
						return html;
					},
			toolbar: '#toolbar',    // 工具按钮用哪个容器
			striped: true,      // 是否显示行间隔色
			cache: false,      // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     // 设置为 true 会在表格底部显示分页条
			paginationLoop: true,// 设置为 true 启用分页条无限循环的功能。
			sortable: true,      // 是否启用排序
			sortOrder: "asc",     // 排序方式
			pageNumber:1,      // 初始化加载第一页，默认第一页
			pageSize: 30,      // 每页的记录行数（*）
			pageList: [30, 50, 100, 200, 500],  // 可供选择的每页的行数（*）			
			url: "/oa/staffCase/selectEmployeeTable",// 这个接口需要处理bootstrap	
			ajaxOptions:{data:{"queryCondition.depart_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"depart_uid":nodeid}});
//				 $.extend(params, condition);
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数		
			sidePagination: "server",   // 分页方式：client客户端分页，server服务端分页（*）
			search: true,      // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,// 设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     // 是否显示所有的列
			showRefresh: true,     // 是否显示刷新按钮
			minimumCountColumns: 2,    // 最少允许的列数
			clickToSelect: true,    // 是否启用点击选中行
			searchOnEnterKey: true,// 设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,// 是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
            showExport: true,                     // 是否显示导出
            exportDataType: "basic"              // basic', 'all', 'selected'
			         
			});
	}
	function viewEmployee(row){
		window.parent.openMenu('viewEmployee'+row.user_uid,'','查看员工信息','/oa/staffCase/employeeInfo','&id='+row.user_uid+'&user_name='+row.user_name+'&type=view',2);
	}
	function editEmployee(row){                                                    	
		window.parent.openMenu('editEmployee'+row.user_uid,'','修改员工信息','/oa/staffCase/employeeInfo','&id='+row.user_uid+'&user_name='+row.user_name+'&type=edit',2);	
	}	
	//单行删除
	/*function delEmployee(row){
		$("#processDefinition_page").load(
				"/oa/staffCase/selectCaseDelPage",{"staffcase_Id":row.staffcase_Id},function(response,status,xhr){
					$("#delEmployeemodule").modal({keyboard:true});
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/oa/staffCase/delectOneCaseInfo',data:JSON.stringify({"staffcase_Id":row.staffcase_Id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
								$('#employee-table').bootstrapTable('remove', {
									field: 'staffcase_Id',
									values: [row.staffcase_Id]
								});
								$("#delEmployeemodule").modal("hide");
							}else{
								alert("删除失败！");
							}
						}
						});
					});
				}
		);
	}	*/
	
	/** 离职所选* */	
	function disMissionSelected(row){
		var selectContent = $('#employee-table').bootstrapTable('getSelections')[0]; 
	
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{  
     	$.map($('#employee-table').bootstrapTable('getSelections'), function(row) {        		 
        		$("#processDefinition_page").load(        				 
        				"/oa/disMiass/disMissionPage",{"user_uid":row.user_uid,"user_name":row.user_name},function(response,status,xhr){
        					$("#disMissionModal").modal({keyboard:true});  
        					zjm.init();
        					tool.undisabled(".btn_submit");
        					$(".btn_submit").click(function(){
        						tool.disabled(".btn_submit");
        						if($("#disMission_Form").validationEngine("validate")){
        							var queryContainer_form = $("#disMission_Form");
        						
        							$.ajax({type:'POST',url:'/oa/disMiass/disMissionEdit',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
        								if(data.obj==1){        								
        									$("#disMissionModal").modal("hide");
        									window.location.reload();
        								}else{
        									alert("离职失败！");
        								}
        							}
        							});
        						}else{						
        							tool.undisabled(".btn_submit");
        						}
        					});
        				});
        	});// 多选

           
        }  
	}	
      
	/**
	 * 打开高级查询页面	
	 */
//	function hightSelect(){		
//		$("#processDefinition_page").load("/oa/staffCase/openCaseSelectPage",'',function(response,status,xhr){
//			$("#hightSelectEmployee").modal({keyboard:true});
//			var node = tree.getChecke();
//			
//			zjm.init();
//			tool.undisabled(".btn_submit");
//			$(".btn_submit").click(function(){//点击查询按钮
//				if($("#hightSelectEmployee_Form").validationEngine("validate")){
//					var condition = $("#hightSelectEmployee_Form").serializeJson();					
//					$("#hightSelectEmployee").modal("hide");
//				initTable(node.id,condition);	
//				}
//			});
//			$("#hightSelectEmployee").on("hidden.bs.modal", function (e) {//解除事件绑定
//				 $(".btn_submit").unbind("click");
//			});	
//
//		});
//	};	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 岗位信息
	 */
	window.onload = floaddata;
	function floaddata() {
		/* 注册日期控件点击事件 */
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		$.zjm_personfileEmployee.initTree();
	};
	/**
	 * 离职
	 */
	$("#btn_delOneEmployee").click(function(){
		
		$.zjm_personfileEmployee.disMissionSelected();
	});

	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_personfileEmployee.hightSelect();
	});
	
	$("#btn_add").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			alert("");
			return false;
		}
		$.zjm_personfileEmployee.modelAdd(node.id);
	});
	$("#btn_importAdd").click(function(){
		var ppnode;
		var node = tree.getChecke();
		if(node == null){
			alert("");
			return false;
		}
		$.zjm_personfileEmployee.importAddxml(node.id);
	});
});


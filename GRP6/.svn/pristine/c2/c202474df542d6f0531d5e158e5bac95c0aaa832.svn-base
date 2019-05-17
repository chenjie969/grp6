(function($,z){
	$.zjm_projectApply = {
			initTable:initTable,//初始化列表
			initProductTable:initProductTable,//初始化流程列表
			initColumns:initColumns,//初始化列表项
			listSet:listSet,//自定义列表栏目
			openProjectApplyPage:openProjectApplyPage,//打开申请登记页面;
			viewModule:viewModule,//查看
			editModule :editModule,//修改
			delOneProjectApply :delOneProjectApply,//列表单个删除;
			delSelectProjectApply:delSelectProjectApply,//列表删除多选;
			openApplySelectPage:openApplySelectPage,//打开高级条件查询页面
			putProjectInPackage:putProjectInPackage,//放入打包车;
			agreeToAccept:agreeToAccept,//同意立项;
			disagreeToAccept:disagreeToAccept,//不予立项;
//			toSlaveClientList:toSlaveClientList //副版本客户列表		根据业务实际, 挪到了业务跟踪页面
	};
	
	/**初始化列表***/
	function initTable(data){
		$('#projectApply_table').bootstrapTable('destroy');
		$('#projectApply_table').bootstrapTable({
			method: 'post',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			       /* html.push('<p><b>序号:</b> ' + index+1 + '</p>');*/
			        html.push('<p><b>类型：</b> ' + tool.isNull(row.projectType,"") + '</p>');
			        html.push('<p><b>项目编号: </b> ' + tool.isNull(row.busiCode,"（空）") + '</p>');				        
			        html.push('<p><b>项目名称：</b> ' + tool.isNull(row.projectName,"") + '</p>');
			        html.push('<p><b>申请金额（万元）：</b> ' + tool.isNull(row.applySum,"") + '</p>');
			        html.push('<p><b>经办部门：</b> ' + tool.isNull(row.departName,"") + '</p>');
			        html.push('<p><b>经办人：</b> ' + tool.isNull(row.createManName,"") + '</p>');
			        html.push('<p><b>受理日期：</b> ' + tool.parseDate(row.createDate) + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"busiCode",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
			url: "/project/apply/selectProjectApplyPageTable",//这个接口需要处理bootstrap table传递的固定参数
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
			{field:'projectType',title:'类型',align:'center',formatter: function (value, row, index) {return row.projectType;}},
			{field:'busiCode',title:'项目编号',align:'center',sortable : "true",formatter: function (value, row, index) {return row.busiCode;}},
			{field:'projectName',title:'项目名称',align:'center',sortable : "true",formatter: function (value, row, index) {
				
				return [ '<a class="btn_projectApply_view" href="javascript:void(0)">'
					+ row.projectName + '</a>' ]
					.join('');},
				//项目名称绑定事件
					events : {
						'click .btn_projectApply_view' : function(
								e, value, row, index) {
							$.zjm_projectApply.viewModule(row);
									
						},
					}
				},
			{field:'busiTypeNameList',title:'业务种类',align:'center',sortable : "true",formatter: function (value, row, index) {return row.busiTypeNameList;}},
			{field:'applySum',title:'申请金额（万元）',align:'center',sortable : "true",formatter: function (value, row, index) {return row.applySum;}},
			{field:'departName',title:'经办部门',align:'center',sortable : "true",formatter: function (value, row, index) {return row.departName;}},
			{field:'createManName',title:'经办人',align:'center',sortable : "true",formatter: function (value, row, index) {return row.createManName;}},
			{field:'createDate',title:'受理日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.createDate);}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return ['<button class="btn_projectApply_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
					'<button class="btn_projectApply_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
					'<button class="btn_projectApply_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_projectApply_view': function(e, value, row, index) {
						$.zjm_projectApply.viewModule(row);
					},
					'click .btn_projectApply_edit': function(e, value, row, index) {
						$.zjm_projectApply.editModule(row);
					},
					'click .btn_projectApply_del': function(e, value, row, index) {
						$.zjm_projectApply.delOneProjectApply(row);
					}
				}
			}
		];
		return columns;
		
	}
	
	/**自定义列表栏目窗口**/
	function listSet(){
		$("#listSetColumnsModule").modal({keyboard:true});
		$("#listBH").val("006");
		zjm.dataColumnsVal("/selectChoosableColumnsJSON",{"listBH":'006'},"ztb_choosable");
		zjm.dataColumnsVal("/selectSelectedColumnsJSON",{"listBH":'006'},"ztb_selected");
		$.zjm_listSet.columnsSort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			tool.disabled(".btn_submit");
			var selectedColumns = $("#selectedColumns").val();
			if(selectedColumns != null && selectedColumns != ""){
				var queryContainer_form = $("#listSetColumnsForm");
				$.ajax({type:'POST',url:'/updateOneListSetInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#listSetColumnsModule").modal("hide");
							initTable();
						}else{
							alert("保存失败！");
							initTable();
						}
					}
				});
			}else{
				tool.undisabled(".btn_submit");
				$("#selectedColumnNotEmpty").modal({keyboard:true});
			}
		});
		$(".btn_reset").click(function () {
			zjm.dataColumnsVal("/selectChoosableColumnsJSON",{"listBH":'002'},"ztb_choosable");
			zjm.dataColumnsVal("/selectSelectedColumnsJSON",{"listBH":'002'},"ztb_selected");
		});
		$("#listSetColumnsModule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_reset").unbind("click");
			 $(".btn_submit").unbind("click");
			 $(".add").unbind("click");
			 $(".remove").unbind("click");
			 $("#btn_moveUp").unbind("click");
			 $("#btn_moveDown").unbind("click");
			 $("#btn_moveTop").unbind("click");
			 $("#btn_moveBottom").unbind("click");
		});
	};
	
	//打开申请登记页面;
    function  openProjectApplyPage(){
    	//window.parent.openMenu('view_personClient','','申请登记','/crm/client/personClient/personClientDetail.jsp','&client_ID='+row.client_ID+'&clientTypeID='+$('.clientTypeID').val()+'&type='+'view');
    	
    	window.parent.openMenu('view_projectApply','','申请登记','/project/apply/applyPageIndex.jsp');
    	
    };
    
    /***查看***/
	function viewModule(row){
		//window.parent.openMenu('viewApplyInfo'+row.apply_ID,'','查看申请登记','/project/apply/projectApplyViewPage','&type='+'view',1);
		
		$("#projectApply_page").load("/project/apply/projectApplyViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#applyInfo").modal({keyboard:true});
		});
	}
	/***修改***/
	function editModule(row){
		window.parent.openMenu("项目申请登记"+row.apply_ID,'','修改申请登记','/project/apply/projectApplyEditPage','&entityID='+row.apply_ID+'&type='+'edit',1);
		
		/*$("#projectApply_page").load("/project/apply/projectApplyEditPage",{},function(response,status,xhr){
			$("#applyEdit").modal({keyboard:true});
		});*/
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
						$('#projectApply_table').bootstrapTable('remove', {
							field: 'apply_ID',
							values: [row.apply_ID]
						});
						$("#common_del").modal("hide");
						$.zjm_projectApply.initTable();
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
		var selectContent = $('#projectApply_table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{         
        	 $.map($('#projectApply_table').bootstrapTable('getSelections'), function(row) {//获取选中行;
	        	 $('#common_del').modal('show');     // 项目立项面板  
	        	 $("#delModalLabel").text("删除");//标题;
	     		 $("#delMessage").text("确定要删除所选数据吗?");//提示信息;
	     		
	             tool.undisabled(".btn_submit");
	     		$(".btn_submit").click(function(){
	     			tool.disabled(".btn_submit");
	     			$.ajax({type:'POST',url:'/project/apply/delOneProjectApply',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	     		        	if(data.obj==true){
	     						$('#projectApply_table').bootstrapTable('remove', {
	     							field: 'client_ID',
	     							values: [row.client_ID]
	     						});
	     						$("#common_del").modal("hide");
	     						$.zjm_projectApply.initTable();
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
	/**
	 * 打开高级查询页面
	 * @returns
	 */
	function openApplySelectPage(){
		
		$("#projectApply_page").load("/project/apply/openApplySelectPage",'',function(response,status,xhr){
			$("#projectApplySelect").modal({keyboard:true});
			//获取业务品种下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){		
					$("#busiSortDicTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
					
				}
			});//获取业务品种下拉树end;
			//获取合作机构下拉树;
			$.ajax({type:'POST',url:'/crm/cooperation/selectAllCooperationListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data){	
					$("#cooperationTree").selectTreeWidgets({
						width : "46%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});//获取合作机构下拉树end;
			//获取创建部门下拉树;
			$.ajax({type:'POST',url:'/selectAllDepartsListTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data){		
				$("#allDepartsTree").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
				
	        }
	        });//获取创建部门下拉树end;
			
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){//点击查询按钮	
				if($("#projectApplySelect_form").validationEngine("validate")){
					var condition = $("#projectApplySelect_form").serializeJson();
					$("#projectApplySelect").modal("hide");
					initTable(condition);	
				}
			});
			$("#projectApplySelect").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
			
			

		});
	};
	/**
	 * 放入打包车;
	 * @returns
	 */
	function putProjectInPackage(){
		var selectContent = $('#projectApply_table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;
        }else{         
        	 $.map($('#projectApply_table').bootstrapTable('getSelections'), function(row) {//获取选中行;
        		 
	        	 $('#common_del').modal('show');     // 项目立项面板  
	        	 $("#delModalLabel").text("提示");//标题;
	     		 $("#delMessage").text("确定要放入打包车吗?");//提示信息;
	     		
	             tool.undisabled(".btn_submit");
	     		$(".btn_submit").click(function(){
	     			tool.disabled(".btn_submit");
	     			$.ajax({type:'POST',url:'/project/apply/putProjectInPackage',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	     		        	if(data.obj==true){
	     						/*$('#projectApply_table').bootstrapTable('remove', {
	     							field: 'client_ID',
	     							values: [row.client_ID]
	     						});*/
	     						$("#common_del").modal("hide");
	     						$.zjm_projectApply.initTable();
	     					}else{
	     						alert("放入失败！");
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
		
		/**
		 * 同意立项--启动流程--添加流程实例;
		 * @returns
		 */
		function agreeToAccept(){
			var selectContent = $('#projectApply_table').bootstrapTable('getSelections');  
			if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
				$("#pleaseSelectOne").modal({keyboard:true});
				return false;  
			}else{
				var selectContent = $('#projectApply_table').bootstrapTable('getSelections')[0];
				var entityID = selectContent.apply_ID;
				var projectName = selectContent.projectName;
				$("#selectProductModal").modal({keyboard:true});
				$(".sProjectName").html(projectName);
				$.zjm_projectApply.initProductTable();
				$("#entityID").val(entityID);
				tool.undisabled(".btn_nextStep");
				$(".btn_nextStep").click(function(){
					var selectContent = $('#product-table').bootstrapTable('getSelections')[0];
			        if(typeof(selectContent) == 'undefined'){
			        	$("#pleaseSelectOne").modal({keyboard:true});
			        	return false;  
			        }else{
						tool.disabled(".btn_nextStep");
	     				$("#selectProductModal").modal("hide");
	     				//十个参数  1，产品ID 2，节点顺序 3，流程发起人ID 4，流程发起人名称 5，当前办理人ID 6，当前办理人名称 7.业务ID 8，业务类型：申请：01 打包：02 9.项目名称 显示用 10 实例化流程ID
	     				$.zjm_nodeTaskModal.initNodeTaskModal(selectContent.product_ID,'0',$("#userID").val(),$("#userName").val(),$("#userID").val(),$("#userName").val(),entityID,'01',projectName,'');
			        }
				});
				$("#selectProductModal").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_nextStep").unbind("click");
				});
			} 
		};
		
		/**初始化列表***/
		function initProductTable(){
			$("#product-table").bootstrapTable('destroy');
			$('#product-table').bootstrapTable({
				method: 'get',
				columns: [
					{field : 'checked',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
					{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
					{field:'productName',title:'产品流程名称',align:'center',formatter: function (value, row, index) {return row.productName;}},
					{field:'version',title:'版本号',align:'center',formatter: function (value, row, index) {return row.version;}},
					{field:'remark',title:'备注',align:'center',formatter: function (value, row, index) {return row.remark;}},
				],
				detailView: false,
				detailFormatter:function(index, row){
				    var html = [];
				        html.push('<p><b>产品流程名称:</b> ' + row.productName + '</p>');
				        html.push('<p><b>版本号:</b> ' + row.version  + '</p>');
				        html.push('<p><b>备注:</b> ' + row.remark + '</p>');
				    return html;
				},
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: false,     //设置为 true 会在表格底部显示分页条
				paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
				url: "/gbpm/product/selectProductPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var queryCondition={"isUsed":true};
					$.extend(params,{"queryCondition":queryCondition});
					$.extend(params,{"wheresql":" AND productTypeName = '普通业务主流程'"});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				singleSelect : true,// 单选checkbox
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
		};
		
		/**
		 * 跳转到否决项目页面
		 */
		function disagreeToAccept(){
			var selectContent = $('#projectApply_table').bootstrapTable('getSelections');  
			if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
				$("#pleaseSelectOne").modal({keyboard:true});
				return false;  
			}else{
				var selectContent = $('#projectApply_table').bootstrapTable('getSelections')[0];
				var apply_ID = selectContent.apply_ID;
				$("#projectApply_page").load("/project/projectTracking/stopProcessPage",{"apply_ID":apply_ID},function(response,status,xhr){
					$("#stopProcess_page").modal({keyboard:true});
					/*注册编辑验证引擎*/
					zjm.validata({formId:"stopProcess_form"});
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						var queryContainer_form = $("#stopProcess_form");
						if(queryContainer_form.validationEngine("validate")){
								$.ajax({type:'POST',url:'/project/projectTracking/stopProcess',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							        	if(data.obj==1){
											$("#stopProcess_page").modal("hide");
											$.zjm_projectApply.initTable();
										}else{
											alert("保存失败！");
										}
							        }
								});
							}else{
								tool.undisabled(".btn_submit");
							}
					});
					$("#stopProcess_page").on("hidden.bs.modal", function (e) {//解除事件绑定
						 $(".btn_submit").unbind("click");
					});
				});
			}
		}
	
		
		
		/**
		 *  副版本客户列表
		 */
		/*	根据业务实际, 挪到了业务跟踪页面
		 * function toSlaveClientList(){
			var selectContent = $('#projectApply_table').bootstrapTable('getSelections');  			
	        if(selectContent.length != 1) {  
	        	$("#pleaseSelectOne").modal({keyboard:true});
	            return false;  
	        }
	        var client_ID=selectContent[0].client_ID;
	        $("#companyClientSynchroPage").load("/toSlaveClientPage",{"client_ID":client_ID},function(){
	        		$("#myModalLabel").text("同步到客户库");
	        	 $("#synchroCompanyClientmodule").modal({keyboard:true});
	        	 	
	        });
		}*/
		
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
  		$.zjm_projectApply.initTable();
	};
	//重置申请列表;
	$("#btn_refreshApplyTable").click(function(){
		$.zjm_projectApply.initTable();
	});
	
	$("#btn_projectApply").click(function(){
		$.zjm_projectApply.openProjectApplyPage();
		
	});
	/**
	 * 删除多选
	 * 
	 */
	$("#btn_delSelectProjectApply").click(function(){
		$.zjm_projectApply.delSelectProjectApply();
	});
	
	/**
	 * btn_projectApplySelect
	 * 高级条件查询:
	 */
	$("#btn_projectApplySelect").click(function(){
		$.zjm_projectApply.openApplySelectPage();;
	});
	
	/**
	 * btn_package
	 * 放入打包车:
	 */
	$("#btn_putProjectInPackage").click(function(){
		$.zjm_projectApply.putProjectInPackage();
	});
	
	/**
	 * 同意立项--启动流程，添加流程实例
	 */
	$("#btn_agreeToAccept").click(function(){
		$.zjm_projectApply.agreeToAccept();
	});
	
	/**
	 * 不予立项
	 */
	$("#btn_disagreeToAccept").click(function(){
		$.zjm_projectApply.disagreeToAccept();
	});
	
	/**
	 * 副版本客户列表
	 */
/*	根据业务实际, 挪到了业务跟踪页面
 * $("#btn_slaveSynchrMainClient").click(function(){
		$.zjm_projectApply.toSlaveClientList();
	});*/
	
	
});


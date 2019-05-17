(function($,z){
	$.zjm_projectTracking = {
			initColumns:initColumns,
			initTable:initTable,//初始化列表
			transact:transact,//办理
			projectDeal:projectDeal,//项目办理
			hightSelect:hightSelect,//高级查询
			delOneProjectApply:delOneProjectApply,//删除
			toSlaveClientList:toSlaveClientList //副版本客户列表
	};
	function initColumns(){
		var  isAdmin = $("#isAdmin").val();//判断当前登录人是否为管理员
		
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'projectType',title:'类型',align:'center',formatter: function (value, row, index) {return row.projectType;}},
			{field:'busiTypeName',title:'业务类型',align:'center',formatter: function (value, row, index) {return row.busiTypeNameList;}},
			{field:'busiCode',title:'业务编号',align:'center',formatter: function (value, row, index) {return row.busiCode;}},
			{field:'projectName',title:'项目名称',align:'center',formatter: function (value, row, index) {
			
			return [ '<a class="btn_projectName_view" title="项目办理" href="javascript:void(0)">'
					+ row.projectName + '</a>' ]
					.join('');},
				//项目名称绑定事件
					events : {
						'click .btn_projectName_view' : function(e, value, row, index) {
							$.zjm_projectTracking.projectDeal(row);
									
						},
					}
				},
				
			{field:'departName',title:'经办部门',align:'center',formatter: function (value, row, index) {return row.departName;}},
			{field:'createManName',title:'经办人',align:'center',formatter: function (value, row, index) {return row.createManName;}},
			{field:'createDate',title:'受理日期',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.createDate);}},
			{field:'projectStageName',title:'业务阶段',align:'center',formatter: function (value, row, index) {return row.projectStageName;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
		    if('1'==isAdmin){
		    	return [
					'<button class="btn_modules_edit btn btn-xs btn-info" title="项目办理"><i class="icon-pencil bigger-120"></i></button>',
		    		'<button class="btn_modules_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'
					].join('');
				
		    }else{
		    	return [
					'<button class="btn_modules_edit btn btn-xs btn-pink" title="项目办理"><i class="icon-edit bigger-120"></i></button>'
					].join('');
				
		    }
			},	
				
				events:{
					'click .btn_modules_edit': function(e, value, row, index) {
						$.zjm_projectTracking.projectDeal(row);
					},
					'click .btn_modules_del': function(e, value, row, index) {
						$.zjm_projectTracking.delOneProjectApply(row);
					},
					
				}
			}
		];
		return columns;
		
	}	
	
	/**初始化列表***/
	function initTable(projectStageID,condition){
		$("#projectBeforeTracking-table").bootstrapTable('destroy');
		$('#projectBeforeTracking-table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			detailView: true,
			detailFormatter:function(index, row){
				var html = [];
//			        html.push('<p><b>序号:</b> ' + index+1 + '</p>');
			        html.push('<p><b>类型：</b> ' + row.projectType + '</p>');
			        html.push('<p><b>业务类型：</b> ' + row.busiTypeNameList + '</p>');
			        html.push('<p><b>业务编号：</b> ' + row.busiCode + '</p>');
			        html.push('<p><b>项目名称：</b> ' + row.projectName + '</p>');
			        html.push('<p><b>经办部门：</b> ' + row.departName + '</p>');
			        html.push('<p><b>经办人：</b> ' + row.createManName + '</p>');
			        html.push('<p><b>受理日期：</b> ' + tool.parseDate(row.createDate) + '</p>');
			        html.push('<p><b>业务阶段：</b> ' + row.projectStageName + '</p>');
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
			url: "/project/projectTracking/selectProjectTrackingPageTable",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(projectStageID !=null && projectStageID!=''){
					$.extend(params,{"wheresql":"and projectStageID = \'" + projectStageID + "\'"});
				}
				var queryCondition={};
				$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
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
		var selectContent = $('#projectBeforeTracking-table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{  
		    window.parent.openMenu('projectDeal'+selectContent.apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+selectContent.apply_ID,1);
       
        }
	}
	
	/***项目办理***/
	function projectDeal(row){
		window.parent.openMenu('projectDeal'+row.apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+row.apply_ID,1);
	}
	
	
	/**高级查询**/
	function hightSelect(){
		$("#processDefinition_page").load("/project/projectTracking/openProBeforeApplySelectPage",'',function(response,status,xhr){
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
					initTable(projectStageID,condition);	
				}
			});
			$("#projectApplySelect").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
			
			

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
						$('#projectBeforeTracking_table').bootstrapTable('remove', {
							field: 'apply_ID',
							values: [row.apply_ID]
						});
						$("#common_del").modal("hide");
						$.zjm_projectTracking.initTable();
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
	
	/**
	 *  副版本客户列表
	 */
	function toSlaveClientList(){
		var selectContent = $('#projectBeforeTracking-table').bootstrapTable('getSelections');  			
        if(selectContent.length != 1) {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }
        var client_ID=selectContent[0].client_ID;
        $("#companyClientSynchroPage").load("/toSlaveClientPage",{"client_ID":client_ID},function(){
        		$("#myModalLabel").text("同步到客户库");
        	 $("#synchroCompanyClientmodule").modal({keyboard:true});
        	 	
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
		window.projectStageID = tool.getUrlParam('projectStageID');
		$.zjm_projectTracking.initTable(projectStageID);
	};
	/**
	 * 办理
	 */
	$("#btn_transact").click(function(){
		$.zjm_projectTracking.transact();
	});

	
	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_projectTracking.hightSelect();
	});
	
	$("#btn_refresh").click(function(){
		$.zjm_projectTracking.initTable(projectStageID,'');
	});
	
	/**
	 * 副版本客户列表
	 */
	$("#btn_slaveSynchrMainClient").click(function(){
		$.zjm_projectTracking.toSlaveClientList();
	});
	
});


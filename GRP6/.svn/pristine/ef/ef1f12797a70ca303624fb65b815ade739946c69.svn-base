(function($,z){
	$.zjm_transact = {
			initData:initData,//初始化数据
			initRunningNodeTaskTable:initRunningNodeTaskTable,//初始化正在运行节点的任务；
			initFinishNodeTaskTable:initFinishNodeTaskTable,//初始化已经完成节点的任务；
			initNotRunNodeTaskTable:initNotRunNodeTaskTable,//初始化未执行节点的任务；
			stopProcessPage:stopProcessPage,//跳转到否决项目页面
			getSelectText : getSelectText,//获取下拉框值;
			confirmFinish:confirmFinish,//确认是否完成此事项页面
			backStep:backStep,//退回
			returnNext:returnNext,//提交下一环节
			returnBackNode:returnBackNode,//重新提交退回环节
			isAllFinish:isAllFinish,//判断此节点下的事项是否全部完成
			viewClientInfo:viewClientInfo,//查看客户详情
			dealProcess:dealProcess, // 办理事项
			viewModule:viewModule,//查看事项
			projectState:projectState,//项目动态;
			selectNotActiveNodeLimitDay:selectNotActiveNodeLimitDay,//获取未执行节点限办天数;
			selectRunNodeLimitDay:selectRunNodeLimitDay,//获取正在运行节点限办天数
			selectFinishNodeLimitDay:selectFinishNodeLimitDay,//获取已完成节点限办天数;
			viewProjectInfo:viewProjectInfo,//查看项目详情
			changeHandleUser:changeHandleUser//重新指派
			
	};
	
	/**
	 * 初始化数据
	 * @param client_ID
	 * @returns
	 */
	function initData(productInstanceID,nodeSort,classType){
		var productNodeListLength = $("#productNodeListLength").val();//流程节点长度
		var userName = $("#userName").val();//获取当前登陆人
		if(productNodeListLength==nodeSort){//如果当前处理节点是最后一步，则隐藏提交下一步按钮
			$(".btn_returnNext").hide();//隐藏提交下一步按钮
		}else{
			$(".btn_returnNext").show();//显示提交下一步按钮
		}
		if('active'  == classType ){//正在运行
			initRunningNodeTaskTable(productInstanceID,nodeSort,userName);
		}else if('complete' == classType){//已经完成
			$(".btn_returnNext").hide();//隐藏提交下一步按钮
			initFinishNodeTaskTable(productInstanceID,nodeSort);
			
		}else if('notActive'  == classType){//未执行任务
			initNotRunNodeTaskTable(productInstanceID,nodeSort);
			
		}
	}
	
	function initColumns(userName){//正在执行
		var  isAdmin = $("#isAdmin").val();
		var  userID = $("#userID").val();
		var  role_uids = $("#role_uids").val();
		
		var columns = [
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field : 'index',title : '任务名称',align : 'center',formatter : function(value, row, index) {return row.taskName;}},
			{field:'assignUserName',title:'分派人',align:'center',formatter: function (value, row, index){return row.assignUserName;}},
			{field:'assignDateTime',title:'分派时间',align:'center',formatter: function (value, row, index){return tool.parseDate(row.assignDateTime);}},			
			{field:'beforeTaskName',title:'前置任务',align:'center',formatter: function (value, row, index){return row.beforeTaskName;}},
			{field:'handleUserName',title:'执行人',align:'center',formatter: function (value, row, index){return row.handleUserName;}},
			{field:'handleDateTime',title:'实际完成时间',align:'center',formatter: function (value, row, index){return tool.parseDate(row.handleDateTime);}},
			{field:'afterTaskNameList',title:'后置任务',align:'center',formatter: function (value, row, index) {return row.afterTaskNameList;}},
			{field:'operationType',title:'任务类型',align:'center',formatter: function (value, row, index) {return row.operationType;}},
			{field:'taskStatus',title:'完成状态',align:'center',class:'isAllFinish',formatter: function (value, row, index){return row.taskStatus;}},
			];
			columns.push({title: '操 作 ',align: 'center',formatter:function(value,row,index){
				if('已完成' != row.taskStatus){//未完成
					if('1'==isAdmin){
						return ['<button class="btn_transact_deal btn btn-xs btn-purple" title="处理""><i class="icon-edit bigger-120"></i></button>',
							'<button class="btn_transact_view btn btn-xs btn-warning" value="+index+" title="查看""><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_confirmFinish btn btn-xs btn-success" title="确认完成"><i class="icon-check bigger-120"></i></button>',
							'<button class="btn_change_handleUser btn btn-xs btn-pink" title="重新指派"><i class="icon-user bigger-120"></i></button>',
							'<button class="btn_transact_change btn btn-xs btn-info" title="变更"><i class="icon-random bigger-120"></i></button>'
							].join('');
						
					}else if((row.handleUserID.indexOf(userID)>-1) | (role_uids.indexOf(row.handleUserID)>-1)){//执行人为当前办理人
						return ['<button class="btn_transact_deal btn btn-xs btn-purple" title="处理""><i class="icon-edit bigger-120"></i></button>',
							'<button class="btn_transact_view btn btn-xs btn-warning" value="+index+" title="查看""><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_confirmFinish btn btn-xs btn-success" title="确认完成"><i class="icon-check bigger-120"></i></button>',
							'<button class="btn_change_handleUser btn btn-xs btn-pink" title="重新指派"><i class="icon-user bigger-120"></i></button>'
							].join('');
					}else{//执行人不是当前办理人，只能查看
						return ['<button class="btn_transact_view btn btn-xs btn-warning" value="+index+" title="查看""><i class="icon-zoom-in bigger-120"></i></button>',
							].join('');
					}
					
				}else{//已完成
					if('1'==isAdmin){
						return ['<button class="btn_transact_view btn btn-xs btn-warning" value="+index+" title="查看""><i class="icon-zoom-in bigger-120"></i></button>',
							   '<button class="btn_transact_change btn btn-xs btn-info" title="变更"><i class="icon-random bigger-120"></i></button>'
							].join('');
					}else{
						return ['<button class="btn_transact_view btn btn-xs btn-warning" value="+index+" title="查看""><i class="icon-zoom-in bigger-120"></i></button>',
							//'<button class="btn_transact_del btn btn-xs btn-purple" title="申请变更"><i class="icon-share bigger-120"></i></button>',
							].join('');
					}
					
				}
				},
				events:{//处理
					'click .btn_transact_deal': function(e, value, row, index) {
						$.zjm_transact.dealProcess(row);
					},//查看
					'click .btn_transact_view': function(e, value, row, index) {
						$.zjm_transact.viewModule(row);
					},//确认完成
					'click .btn_confirmFinish': function(e, value, row, index) {
						$.zjm_transact.confirmFinish(row);
					},//变更
					'click .btn_transact_change': function(e, value, row, index) {
						$.zjm_transact.dealProcess(row);
					},//重新指派
					'click .btn_change_handleUser': function(e, value, row, index) {
						$.zjm_transact.changeHandleUser(row);
					}
				}
			});
		return columns;
	}	
	
	function initColumns2(){//已完成
		var  isAdmin = $("#isAdmin").val();
		var columns = [
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'taskName',title:'任务名称',align:'center',formatter: function (value, row, index) {return row.taskName;}},
			{field:'assignUserName',title:'分派人',align:'center',formatter: function (value, row, index) {return row.assignUserName;}},
			{field:'assignDateTime',title:'分派时间',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.assignDateTime);}},
			{field:'beforeTaskName',title:'前置任务',align:'center',formatter: function (value, row, index) {return row.beforeTaskName;;}},
			{field:'handleUserName',title:'执行人',align:'center',formatter: function (value, row, index) {return row.handleUserName;}},
			{field:'handleDateTime',title:'实际完成时间',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.handleDateTime);}},
			{field:'operationType',title:'任务类型',align:'center',formatter: function (value, row, index) {return row.operationType;}},
			{field:'afterTaskNameList',title:'后置任务',align:'center',formatter: function (value, row, index) {return row.afterTaskNameList;}},
			{field:'taskStatus',title:'完成状态',align:'center',formatter: function (value, row, index) {return row.taskStatus;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				if('1'==isAdmin){
					return ['<button class="btn_transact_view btn btn-xs btn-warning" value="+index+" title="查看""><i class="icon-zoom-in bigger-120"></i></button>',
						   '<button class="btn_transact_change btn btn-xs btn-random" title="变更"><i class="icon-pencil bigger-120"></i></button>'
						].join('');
				}else{
					return [
						'<button class="btn_transact_view btn btn-xs btn-warning  "  title="查看""><i class="icon-zoom-in bigger-120"></i></button>'
						].join('');
				}
			},
			events:{
				'click .btn_transact_view': function(e, value, row, index) {
					$.zjm_transact.viewModule(row);
				},//变更
				'click .btn_transact_change': function(e, value, row, index) {
					$.zjm_transact.dealProcess(row);
				}
				
			}
			}
			];
		return columns;
	}	
	
	function initColumns3(){//未执行
		var columns = [
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'taskName',title:'任务名称',align:'center',formatter: function (value, row, index) {return row.taskName;}},
			{field:'assignUserName',title:'分派人',align:'center',formatter: function (value, row, index) {return row.assignUserName;}},
			{field:'assignDateTime',title:'分派时间',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.assignDateTime);}},
			{field:'beforeTaskName',title:'前置任务',align:'center',formatter: function (value, row, index) {return row.beforeTaskName;}},
			{field:'handleUserName',title:'执行人',align:'center',formatter: function (value, row, index) {return row.handleUserName;}},
			{field:'handleDateTime',title:'实际完成时间',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.handleDateTime);}},
			{field:'operationType',title:'任务类型',align:'center',formatter: function (value, row, index) {return row.operationType;}},
			{field:'afterTaskNameList',title:'后置任务',align:'center',formatter: function (value, row, index) {return row.afterTaskNameList;}},
			{field:'taskStatus',title:'完成状态',align:'center',formatter: function (value, row, index) {return row.taskStatus;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return ['<button class="btn_transact_view btn btn-xs btn-warning" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'
					].join('');
			},
			events:{
				'click .btn_transact_view': function(e, value, row, index) {
					$.zjm_transact.viewModule(row);
				}
			}
			}
			];
		return columns;
	}	
	
	
	
	/**初始正在运行节点任务列表***/
	function initRunningNodeTaskTable(productInstance_ID,nodeSort,userName){
		$("#transact-table").bootstrapTable('destroy');
		$('#transact-table').bootstrapTable({
			method: 'get',
			columns: initColumns(userName),
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			/*height: 480,*/
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			sortName:"taskSort",//排序字段
			sortOrder: "asc",     //排序方式
			url: "/project/projectTracking/selectRunningNodeTaskTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"productInstance_ID":productInstance_ID,"nodeSort":nodeSort};
				//$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			
		});
	}
	/**初始已经完成节点任务列表***/
	function initFinishNodeTaskTable(productInstance_ID,nodeSort){
		$("#transact-table").bootstrapTable('destroy');
		$('#transact-table').bootstrapTable({
			method: 'get',
			columns: initColumns2(),
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			/*height: 480,*/
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			sortName:"taskSort",//排序字段
			sortOrder: "asc",     //排序方式
			url: "/project/projectTracking/selectFinishNodeTaskTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"productInstance_ID":productInstance_ID,"nodeSort":nodeSort};
				//$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			
		});
	}
	
	/**初始未执行节点任务列表***/
	function initNotRunNodeTaskTable(productInstance_ID,nodeSort){
		$("#transact-table").bootstrapTable('destroy');
		$('#transact-table').bootstrapTable({
			method: 'get',
			columns: initColumns3(),
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			/*height: 480,*/
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			sortName:"taskSort",//排序字段
			sortOrder: "asc",     //排序方式
			url: "/project/projectTracking/selectNotRunNodeTaskTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"productID":productInstance_ID,"nodeSort":nodeSort};
				//$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			
		});
	}
	
	
	
	
	
	
	
	
	//拼接需要的参数
	function  getParamString (row){
		var apply_ID = $("#apply_ID").val();
		var uurl=row.taskUrl;
		if(uurl.indexOf("?") != -1){
			realUrl=uurl.substring(0,uurl.indexOf("?"));
		}else{
			realUrl=uurl;
		}
		uurl=uurl.substring(uurl.indexOf("?")+1);
		uurl=uurl.split("=");
		var apply_ID = $("#apply_ID").val();//业务id
		var client_ID = $("#client_ID").val();//客户id
		var clientTypeID = $("#clientTypeID").val();//客户类型：01企业，02个人
		var entityTypeID = $("#entityTypeID").val();//业务类型
		var runNode_ID = $("#runNode_ID").val();//运行节点id
		var productInstance_ID = $("#productInstance_ID").val();//运行节点id
		taskName = encodeURI(encodeURI(row.taskName));   
		if(undefined !=row.finishTask_ID){
			taskID = row.finishTask_ID;//已完成任务id
		}else if(undefined !=row.runTask_ID){
			taskID = row.runTask_ID;//正在执行任务id
		}else if(undefined !=row.nodeTask_ID){
			taskID = row.nodeTask_ID;//任务节点定义id
		}
		//paramString = '&entityID='+apply_ID+'&client_ID='+client_ID+'&apply_ID='+apply_ID+'&type='+'edit'+'&clientTypeID='+clientTypeID;
		paramString = '&entityID='+apply_ID
				    +'&client_ID='+client_ID
				    +'&apply_ID='+apply_ID
				    +'&clientTypeID='+clientTypeID
				    +'&entityType='+entityTypeID
				    +'&nodeID='+runNode_ID
				    +'&taskID='+taskID
				    +'&taskName='+taskName
				    +'&productInstanceID='+productInstance_ID
				    +"&"+uurl[0]+"="+uurl[1];
		return paramString;
	}
	
	
	
	/**
	 * 办理事项
	 */
	function dealProcess(row){	
		if(row.isBeforeTask){
			$.ajax({type:'POST',url:'/gbpm/runTask/selectBeforeTaskNoFinish',data:JSON.stringify(row),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	        	if(data.obj){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("请先完成前置任务");
				}else{
					var apply_ID = $("#apply_ID").val();//业务id
					var paramString = getParamString(row)+'&type='+'edit';
					window.parent.openMenu(row.taskName+apply_ID,'',row.taskName,'/gbpm/common.jsp','&taskFormUrl='+row.taskUrl+paramString,1);
				}
	        }});
		}else{
			var apply_ID = $("#apply_ID").val();//业务id
			var paramString = getParamString(row)+'&type='+'edit';
			window.parent.openMenu(row.taskName+apply_ID,'',row.taskName,'/gbpm/common.jsp','&taskFormUrl='+row.taskUrl+paramString,1);
		}
	}
	
	/**
	 * 查看事项
	 */
	function viewModule(row){
		var apply_ID = $("#apply_ID").val();//业务id
		var paramString = getParamString(row)+'&type='+'view';
		window.parent.openMenu(row.taskName+apply_ID,'',row.taskName,'/gbpm/common.jsp','&taskFormUrl='+row.viewTaskUrl+paramString,1);
		
		//window.parent.openMenu(row.taskName+apply_ID,'',row.taskName,row.viewTaskUrl,paramString,1);
		// window.parent.openMenu(row.taskName+apply_ID,'','出具意见','/project/suggest/selectProjectSuggestInfo',paramString);
		//window.parent.openMenu(row.taskName+apply_ID,'','申请登记','/project/apply/projectApplyViewPageGBPM',paramString);
		//window.parent.openMenu(row.taskName+apply_ID,'','出具意见','/project/suggest/suggest',paramString);
	}
	
    function getSelectText(selectID){
	    	 var type = document.getElementById(selectID);     	
		 	 var pindex  = type.selectedIndex;
		 	 // 获取选中的下拉框的值(value)
		　　	 var pValue  =  type.options[pindex].value;　
		　　	 // 获取选中的下拉框的值(key)
		　　	 var pText = type.options[pindex].text;
		　　	 var selectName = selectID.replace(/List/, "Name");
		　　    document.getElementById(selectName).value=pText;
	 }
    
	/**
	 * 跳转到否决项目页面
	 */
	function stopProcessPage(apply_ID){
			$("#projectBeforeDeal_page").load("/project/projectTracking/stopProcessPage",{"apply_ID":apply_ID},function(response,status,xhr){
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
										//$.zjm_transact.initTable();
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
	
	/**
	 * 跳转到重新指派操作人页面
	 */
	function changeHandleUser(row){
		var apply_ID = $("#apply_ID").val();//获取业务id
		$("#projectBeforeDeal_page").load("/project/projectTracking/changeHandleUserPage",{"runTask_ID":row.runTask_ID,"entityID":apply_ID},function(response,status,xhr){
			$("#changeHandleUser_page").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"changeHandleUser_form"});
			tool.undisabled(".btn_submit");
			
			$.ajax({type:'POST',
				url:'/sys/dic/selectDepartsUserTree',	
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
				$("#handleUserid").selectTreeWidgets({
					width : "93%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
					});
		        }
		    });
			
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#changeHandleUser_form");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:'/project/projectTracking/changeHandleUser',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#changeHandleUser_page").modal("hide");
							var productInstanceID = $("#productInstance_ID").val();//获取实例id
							var nodeSort = $(".wizard-steps .active").attr("id");//获取实例id
							$.zjm_transact.initData(productInstanceID,nodeSort,"active");	
						}else{
							alert("保存失败！");
						}
					}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#changeHandleUser_page").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		});
	}
	
	 //确认完成页面
    function confirmFinish(row){
    	if(row.isBeforeTask){
			$.ajax({type:'POST',url:'/gbpm/runTask/selectBeforeTaskNoFinish',data:JSON.stringify(row),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	        	if(data.obj){
					$("#pleaseSelectOne").modal({keyboard:true});
					$("#message").html("请先完成前置任务");
				}else{
					$("#common_del").modal({keyboard:true});
					$("#delModalLabel").text("提示");//标题;
					$("#delMessage").text("确认已完成此任务事项？");//提示信息;
					
					tool.undisabled(".btn_submit");
					$(".btn_submit").click(function(){
						tool.disabled(".btn_submit");
						$.ajax({type:'POST',url:'/project/projectTracking/confirmFinish',data:JSON.stringify({"runTask_ID":row.runTask_ID,"taskStatus":"已完成"}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==true){
									$("#common_del").modal("hide");
									var productInstanceID = $("#productInstance_ID").val();//获取实例id
									var nodeSort = $(".wizard-steps .active").attr("id");//获取实例id
									$.zjm_transact.initData(productInstanceID,nodeSort,"active");	
									//$.zjm_transact.initRunningNodeTaskTable(productInstanceID,nodeSort,'未完成');
								}else{
									alert("操作失败！");
								}
					        }
						});
					});
					
					$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
						 $(".btn_submit").unbind("click");
					});
				}
	        }});
		}else{
			$("#common_del").modal({keyboard:true});
			$("#delModalLabel").text("提示");//标题;
			$("#delMessage").text("确认已完成此任务事项？");//提示信息;
			
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/project/projectTracking/confirmFinish',data:JSON.stringify({"runTask_ID":row.runTask_ID,"taskStatus":"已完成"}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==true){
							$("#common_del").modal("hide");
							var productInstanceID = $("#productInstance_ID").val();//获取实例id
							var nodeSort = $(".wizard-steps .active").attr("id");//获取实例id
							$.zjm_transact.initData(productInstanceID,nodeSort,"active");	
							//$.zjm_transact.initRunningNodeTaskTable(productInstanceID,nodeSort,'未完成');
						}else{
							alert("操作失败！");
						}
			        }
				});
			});
			
			$("#common_del").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		}
	}
    /**
     * 判断此节点下的事项是否全部完成
     * @returns
     */
   function isAllFinish(){
	   
	   var isAllFinishList = $("td.isAllFinish");
	   
	   var bool=[];
	 	$.each(isAllFinishList,function(){
	 		($(this).text() != '已完成') ? bool.push(false) : bool.push(true);
	 	});
	 	return (bool.join("").indexOf("false")==-1) ?  true : false;
    }
    /**
     * 提交下一步
     * @returns
     */
    function returnNext(){
	    	 //var   isAllFinish = $.zjm_transact.isAllFinish();
	    	 var runNode_ID = $("#runNode_ID").val();//获取产品id
	    	 $.ajax({type:'POST',url:'/project/projectTracking/isAllFinish',data:JSON.stringify({"runNodeID":runNode_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj==true){
						 var productID = $("#productID_01").val();//获取产品id
				    		 var startProductID = $("#createUserID").val();//流程发起人ID
				    		 var startProductName = $("#createUserName").val();//流程发起人名称 
				    		 var entityID = $("#apply_ID").val();//申请id
				    		 var entityType = $("#entityTypeID").val();//业务类型：申请：01 打包：02
				    		 var projectName = $(".sprojectName").text();//项目名称 显示用
				    		 var nowUserID = $("#userID").val();//项目名称 显示用
				    		 var nowUserName = $("#userName").val();//项目名称 显示用
				    		 var productInstanceID = $("#productInstance_ID").val();//项目名称 显示用
				    		 var nodeSort = $(".wizard-steps .active").attr("id");//节点顺序
			    			/**
			    			 * 下一步，设置下一节点下任务事项办理人
			    			 * @returns
			    			 * 十个参数  1，产品ID 2，节点顺序 3，流程发起人ID 4，流程发起人名称 5，当前办理人ID 6，当前办理人名称 7.业务ID 8，业务类型：申请：01 打包：02 9.项目名称 显示用
			    			 */
				    		 $.zjm_nodeTaskModal.initNodeTaskModal(productID,nodeSort,startProductID,startProductName,nowUserID,nowUserName,entityID,entityType,projectName,productInstanceID);							
					}else{
						$('#pleaseSelectOne').modal('show');     // 项目立项面板  
						$("#myModalLabel").text("提示");//标题;
			        	 	$("#message").text("请完成所有事项后再提交！");//提示信息;
					}
				}
			});
	    
    	
    }
    
    /**
     * 重新提交到退回环节
     * @returns
     */
    function returnBackNode(){
    	var runNode_ID = $("#runNode_ID").val();//获取产品id
    	$.ajax({type:'POST',url:'/project/projectTracking/isAllFinish',data:JSON.stringify({"runNodeID":runNode_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
    		if(data.obj==true){
    			var productID = $("#productID_01").val();//获取产品id
    			var startProductID = $("#createUserID").val();//流程发起人ID
    			var startProductName = $("#createUserName").val();//流程发起人名称 
    			var entityID = $("#apply_ID").val();//申请id
    			var entityType = $("#entityTypeID").val();//业务类型：申请：01 打包：02
    			var projectName = $(".sprojectName").text();//项目名称 显示用
    			var nowUserID = $("#userID").val();//项目名称 显示用
    			var nowUserName = $("#userName").val();//项目名称 显示用
    			var productInstanceID = $("#productInstance_ID").val();//项目名称 显示用
    			var nodeSort = $(".wizard-steps .active").attr("id");//节点顺序
    			$('#confirmModal').modal('show');     // 项目立项面板  
    			$("#confirmValue").text("您确定要重新提交吗？");//提示信息;
    			tool.undisabled(".btn_submit");
    			$(".btn_submit").click(function(){
    				tool.disabled(".btn_submit");
					$.ajax({type:'POST',url:'/gbpm/productInstance/returnBackNode',data:JSON.stringify({"productInstance_ID":productInstanceID,"returnAfterNodeID":runNode_ID}),
						contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#confirmModal").modal("hide");
								window.parent.openMenu('projectDeal'+entityID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+entityID,'1');
							}else{
								alert("保存失败！");
							}
				        }
					});
    			});
    			$("#confirmModal").on("hidden.bs.modal", function (e) {//解除事件绑定
    				 $(".btn_submit").unbind("click");
    			});
    			
    		}else{
    			$('#pleaseSelectOne').modal('show');     // 项目立项面板  
    			$("#myModalLabel").text("提示");//标题;
    			$("#message").text("请完成所有事项后再提交！");//提示信息;
    		}
    	}
    	});
    	
    	
    }
    
    /**初始已经完成节点任务列表***/
	function initSelectFinishNodeTaskTable(finishNodeID){
		$("#finishTask-table").bootstrapTable('destroy');
		$('#finishTask-table').bootstrapTable({
			method: 'get',
			columns: [
				{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) { 
					return {
			            checked : true//设置选中
			        };
				}},
				{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
				{field:'taskName',title:'任务名称',align:'center',formatter: function (value, row, index) {return row.taskName;}},
				{field:'assignUserName',title:'分派人',align:'center',formatter: function (value, row, index) {return row.assignUserName;}},
				{field:'assignDateTime',title:'分派时间',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.assignDateTime);}},
				{field:'beforeTaskName',title:'前置任务',align:'center',formatter: function (value, row, index) {return row.beforeTaskName;;}},
				{field:'handleUserName',title:'执行人',align:'center',formatter: function (value, row, index) {return row.handleUserName;}},
				{field:'handleDateTime',title:'实际完成时间',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.handleDateTime);}},
				{field:'operationType',title:'任务类型',align:'center',formatter: function (value, row, index) {return row.operationType;}},
				{field:'afterTaskNameList',title:'后置任务',align:'center',formatter: function (value, row, index) {return row.afterTaskNameList;}},
//				{field:'taskStatus',title:'完成状态',align:'center',formatter: function (value, row, index) {return row.taskStatus;}},
//				{title: '操 作 ',align: 'center',formatter:function(value,row,index){
//					return [
//						'<button class="btn_transact_view btn btn-xs btn-warning  "  title="查看""><i class="icon-zoom-in bigger-120"></i></button>'
//						].join('')
//				},
//				events:{
//					'click .btn_transact_view': function(e, value, row, index) {
//						$.zjm_transact.viewModule(row);
//					}
//					
//				}
//				}
				],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			/*height: 480,*/
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			sortName:"taskSort",//排序字段
			sortOrder: "asc",     //排序方式
			url: "/gbpm/finishTask/selectBackFinishTaskPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				//$.extend(queryCondition,condition);
				$.extend(params,{"wheresql":" and runNodeID = \'" + finishNodeID + "\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			
		});
	}
    
    /**
     * 退回
     * @returns
     */
    function backStep(){
    	var productID = $("#productID_01").val();//获取产品id
		var startProductID = $("#createUserID").val();//流程发起人ID
		var startProductName = $("#createUserName").val();//流程发起人名称 
		var entityID = $("#apply_ID").val();//申请id
		var entityType = $("#entityTypeID").val();//业务类型：申请：01 打包：02
		var projectName = $(".sprojectName").text();//项目名称 显示用
		//var nowUserID = $("#userID").val();//
		//var nowUserName = $("#userName").val();//
		var productInstanceID = $("#productInstance_ID").val();//项目名称 显示用
		var nodeSort = $(".wizard-steps .active").attr("id");//节点顺序
    	$("#projectBeforeDeal_page").load("/gbpm/productInstance/backNodeTaskPage",{"productInstanceID":productInstanceID,"nodeSort":nodeSort},function(response,status,xhr){
			$("#backNodeTaskModal").modal({keyboard:true});
			var returnBeforeNodeID = $("#runNode_ID").val();
			$("#returnBeforeNodeID").val(returnBeforeNodeID);
			$("#productInstanceID_back").val(productInstanceID);
			initSelectFinishNodeTaskTable();
			$('#finishNodeList').change(function(){
				var finishNodeID=$(this).children('option:selected').val();//这就是selected的值
				initSelectFinishNodeTaskTable(finishNodeID);
			});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"backNodeTaskForm"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var selectContent = $('#finishTask-table').bootstrapTable('getSelections')[0]; 
				var finishTaskIDS = '';
		        if(typeof(selectContent) != 'undefined') {  
		        	$.map($('#finishTask-table').bootstrapTable('getSelections'), function(row) {
		        		finishTaskIDS = finishTaskIDS + row.finishTask_ID + ',';
		        	 });
		        	$("#finishTaskIDS").val(finishTaskIDS);
		        }
				var queryContainer_form = $("#backNodeTaskForm");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:'/gbpm/productInstance/backStep',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#backNodeTaskModal").modal("hide");
								window.parent.openMenu('projectDeal'+entityID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+entityID,'1');
							}else{
								alert("保存失败！");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#backNodeTaskModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
    	
	}
    	
    //查看客户详情
    function viewClientInfo(){
    			var client_ID = $("#client_ID").val();//获取客户id
    			var clientTypeID = $("#clientTypeID").val();//获取客户类型
    			if("01"==clientTypeID){
    				window.parent.openMenu('view_companyClient'+client_ID,'','企业客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+client_ID+'&type='+'view');
    			}else{
    				window.parent.openMenu('view_personClient'+client_ID,'','个人客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+client_ID+'&clientTypeID='+clientTypeID+'&type='+'view');
    			}
    }
    
  //查看项目详情
    function viewProjectInfo(){   	
			var apply_ID = $("#apply_ID").val();//获取项目id
			window.parent.openMenu('viewProjectInfo'+apply_ID,'','项目详情','/project/projectDetail/viewProjectInfo','&apply_ID='+apply_ID+'&type='+'view');
    }
    
    
    
    
    
    //项目动态;
    function projectState(){
    	var apply_ID = $("#apply_ID").val();//获取业务id 
    	//var user_uid= $("#user_uid").val();
    	
    	window.parent.openMenu('projectState'+apply_ID,'','项目动态','/project/projectTracking/selectDynamicListPage','&apply_ID='+apply_ID);
    	
    }
    //获取未执行节点限办天数
    function selectNotActiveNodeLimitDay(productNode_ID){ 
	    $.ajax({type:'POST',url:'/project/projectTracking/selectNotActiveNodeLimitDay',data:JSON.stringify({"productNode_ID":productNode_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj!=null){
					if(data.obj.limitDay==null){
						$("#nodeLimitDay").text("（空）");   
						$("#nodeOverDay").text(""); 
					}else{
						$("#nodeLimitDay").text(data.obj.limitDay);   
						$("#nodeOverDay").text("（剩余"+data.obj.limitDay+"天）"); 
					}
					  
				}else{
					$("#nodeLimitDay").innerText="";   
					$("#nodeOverDay").innerText="";   
				}
			}
			});
    }
    //获取正在执行节点限办天数
    function selectRunNodeLimitDay(runNode_ID){ 
    	$.ajax({type:'POST',url:'/project/projectTracking/selectRunNodeLimitDay',data:JSON.stringify({"runNode_ID":runNode_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
    		if(data.obj!=null){
    			if(data.obj.limitDay==null){
					$("#nodeLimitDay").text("（空）");   
					$("#nodeOverDay").text(""); 
				}else{
	    			$("#nodeLimitDay").text(data.obj.limitDay);   
	    			$("#nodeOverDay").text("（"+data.obj.overDay+"）");
				}
    		}else{
    			$("#nodeLimitDay").innerText="";   
    			$("#nodeOverDay").innerText="";   
    		}
    	}
    	});
    }
    //获取已完成节点限办天数
    function selectFinishNodeLimitDay(productInstance_ID,nodeSort){ 
    	$.ajax({type:'POST',url:'/project/projectTracking/selectFinishNodeLimitDay',data:JSON.stringify({"productInstanceID":productInstance_ID,"nodeSort":nodeSort}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
    		if(data.obj!=null){
    			if(data.obj.limitDay==null){
					$("#nodeLimitDay").text("（空）");   
					$("#nodeOverDay").text(""); 
				}else{
	    			$("#nodeLimitDay").text(data.obj.limitDay);   
	    			$("#nodeOverDay").text("（"+data.obj.overDay+"）");
				}
    		}else{
    			$("#nodeLimitDay").innerText="";   
    			$("#nodeOverDay").innerText="";   
    		}
    	}
    	});
    }

  
})(jQuery, this);
$(function () {


	var productInstanceID = $("#productInstance_ID").val();//获取实例id
	var nodeSort = $(".wizard-steps .active").attr("id");//获取实例id
	var productID = $("#productID_01").val();//获取产品id
	
	var runNode_ID = $("#runNode_ID").val();//获取正在运行节点id
	$.zjm_transact.initData(productInstanceID,nodeSort,'active');//正在运行
//	if(runNode_ID == nodeSort){
//		$.zjm_transact.initData(productInstanceID,nodeSort,'active');//正在运行
//	}else{
//		$.zjm_transact.initData(productInstanceID,nodeSort,'noactive');//正在运行
//	}
	
	$.zjm_transact.selectRunNodeLimitDay(runNode_ID);//获取正在执行节点限办天数
	
	$("li").click(function(){
		
		var productInstance_ID = $("#productInstance_ID").val();//获取实例id
		var productID_01 = $("#productID_01").val();//获取产品id
		$("#stateText").html($('#'+$(this).attr('id')).children("span").last().text());
		
		var classType = $(this).attr('class');//获取节点状态
		var nodeSort = $(this).attr('id');//获取节点顺序
		
		
		if('notActive' == classType){ //未执行节点
			$(".btn").attr("disabled", true); 
			$(".btn_transact_view").attr("disabled",true);
			$.zjm_transact.initData(productID_01,nodeSort,classType);	
			var productNode_ID = $(this).attr('value');//获取节点value
			$.zjm_transact.selectNotActiveNodeLimitDay(productNode_ID);//获取未执行节点限办天数
			
		}else if('complete' == classType){//已经完成节点
			//$(".btn").attr("disabled", true); 
			$(".btn").hide();
			$.zjm_transact.initData(productInstance_ID,nodeSort,classType);	
			$.zjm_transact.selectFinishNodeLimitDay(productInstance_ID,nodeSort);//获取已完成节点限办天数
		}else{//正在处理的节点
			$(".btn").show();
			$(".btn").attr("disabled", false); //按钮可用
			$.zjm_transact.initData(productInstance_ID,nodeSort,classType);	
			var runNode_ID = $("#runNode_ID").val();//获取正在运行节点id
			$.zjm_transact.selectRunNodeLimitDay(runNode_ID);//获取正在执行节点限办天数
			
			
		}
		
		
		
		
		
	});
	//退回
	$(".btn_returnBefore").click(function(){
		$.zjm_transact.backStep();
	});
	//提交到下一步
	$(".btn_returnNext").click(function(){
		$.zjm_transact.returnNext();
	});
	//重新提交到退回环节
	$("#btn_returnBackNode").click(function(){
		$.zjm_transact.returnBackNode();
	});
	//终止流程
	$(".btn_stopProcessPage").click(function(){
		var apply_ID = $("#apply_ID").val();//获取业务id
		$.zjm_transact.stopProcessPage(apply_ID);
	});
	//查看客户详情；
	$(".btn_client_view").click(function(){
			
		$.zjm_transact.viewClientInfo();		
	});
	//项目动态
	$(".btn_projectState").click(function(){
		
		$.zjm_transact.projectState();		
	});
	//查看客户详情；
	$(".btn_project_view").click(function(){
		$.zjm_transact.viewProjectInfo();		
	});
	

});

 
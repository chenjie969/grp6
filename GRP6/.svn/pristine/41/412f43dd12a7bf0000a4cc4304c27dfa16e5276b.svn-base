(function($,z){
	$.zjm_persionClient = {
			initColumns:initColumns,
			initPersonClientTalble:initPersonClientTalble,//初始化列表
			addOnePersonClient:addOnePersonClient,//新增个人
			viewModule:viewModule,//客户列表查看
			editModule:editModule,//客户列表修改
			deleteOfSelected:deleteOfSelected,//删除所选
			p_backList:p_backList,//从业务明细返回
			delModule:delModule,//客户列表删除
			projectDetaiil:projectDetaiil,//业务明细
			hightSelect:hightSelect,//高级查询
			listSet:listSet,//自定义列表			
			returnBlackList:returnBlackList,//转入黑名单
			synchro:synchro,//同步
			synchro2:synchro2,//确认是否同步
			initProjNameTable:initProjNameTable,//初始化该客户下项目
			clientShare:clientShare//授权共享人
	};
	var userIDs = "";
	var userNames = ""
		
	function initColumns(condition){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		];
		
		$.ajax({type:'POST',url:'/selectOneListSetInfo',data:JSON.stringify({"listBH":'002'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj!=null && data.obj.selectedColumns!=null &&　data.obj.selectedColumns!=''){
	        		var arr= data.obj.selectedColumns.split(",");
	        		var arrName= data.obj.selectedColumnNames.split(",");
	        		for(var i = 0;i<arr.length;i++) {
	        			var field = arr[i];
	        			var title  = arrName[i];
	        			var column = {
	        					"field" : field,
	        					"title" : title,
	        					"align" : "center",
	        					"sortable" : "true",
	        					"formatter" : function (value, row, index) {return  value}
			        			
	        			};
	        			if(field == "createDateTime" ){
	        				$.extend(column,{"formatter" : function (value, row, index) {return tool.parseDate(value)}})
						};
	        			if(field == "personName" ){
	        				$.extend(column,{"formatter" : function (value, row, index) {
	        						return ['<a class="btn_client_view" href="javascript:void(0)">'+row.personName+'</a>'].join('');
        						},
        						events:{
	        						'click .btn_client_view': function(e, value, row, index) {
	        							$.zjm_persionClient.viewModule(row);
	        						},
	        					}
        					})
	        			};
	        			columns.push(column);
	        		}
	        		columns.push({title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_modules_view btn btn-xs btn-warning" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_modules_edit btn btn-xs btn-info" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_modules_del btn btn-xs btn-danger" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_persionClient.viewModule(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_persionClient.editModule(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_persionClient.delModule(row);
							}
						}
					});
	        		$.zjm_persionClient.initPersonClientTalble(condition,columns);
				}else{
					columns.push({title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_modules_view btn btn-xs btn-warning" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_modules_edit btn btn-xs btn-info" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_modules_del btn btn-xs btn-danger" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_persionClient.viewModule(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_persionClient.editModule(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_persionClient.delModule(row);
							}
						}
					});
					$.zjm_persionClient.initPersonClientTalble(condition,columns);;
				}
	        }
		});
		
	}	
	
	/**初始化列表***/
	function initPersonClientTalble(condition,columns){
		$("#personClient-table").bootstrapTable('destroy');
		$('#personClient-table').bootstrapTable({
			method: 'get',
			columns: columns,
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>客户编号:</b> ' + tool.isNull(row.clientBH,"") + '</p>');
			        html.push('<p><b>申请人姓名:</b> ' + row.personName + '</p>');
			        html.push('<p><b>企业名称:</b> ' + tool.isNull(row.clientName,"") + '</p>');
			        html.push('<p><b>身份证号码:</b> ' + tool.isNull(row.personNum,"") + '</p>');
			        html.push('<p><b>性别:</b> ' + tool.isNull(row.sex,"") + '</p>');
			        html.push('<p><b>年龄:</b> ' + tool.isNull(row.age,"") + '（岁）' + '</p>');
			        html.push('<p><b>职位:</b> ' + tool.isNull(row.position,"") + '</p>');
			        html.push('<p><b>户口所在地:</b> ' + tool.isNull(row.domicile,"") + '</p>');
			        html.push('<p><b>联系方式:</b> ' + tool.isNull(row.phone,"") + '</p>');
			        html.push('<p><b>机构名称:</b> ' + tool.isNull(row.unit_uidName,"") + '</p>');
			        html.push('<p><b>创建部门:</b> ' + tool.isNull(row.fullDepartName,"") + '</p>');
			        html.push('<p><b>创建人:</b> ' + tool.isNull(row.createUserName,"") + '</p>');
			        html.push('<p><b>创建时间:</b> ' + tool.parseDate(row.createDateTime,"") + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）			
			url: "/selectPersonClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"clientTypeID":$(".clientTypeID").val()};
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


	/**添加个人*/
	function addOnePersonClient(){
		$("#addPersonClientModal").modal({keyboard:true});
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
		$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime())); 
		/**注册编辑验证引擎*/
		zjm.validata({formId:"add_personClientForm"});
		/**提交*/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#add_personClientForm").validationEngine("validate")){
					var queryContainer_form = $("#add_personClientForm");
					if(zjm.ajaxValidata("add_personNum","/selectPersonNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"申请人身份证号已存在！")){
						$.ajax({type:'POST',url:'/insertOnePersonClientInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
									$("#addPersonClientModal").modal("hide");
									$(".ztb_add").val("");
									$.zjm_persionClient.initColumns();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
					        }
						});
					}else{
						tool.undisabled(".btn_submit");
					}
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#addPersonClientModal").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	/***查看***/
	function viewModule(row){
		window.parent.openMenu('view_personClient'+row.client_ID,'','个人客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+row.client_ID+'&clientTypeID='+$('.clientTypeID').val()+'&type='+'view');
	}
	/***修改***/
	function editModule(row){
		window.parent.openMenu('edit_personClient'+row.client_ID,'','个人客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+row.client_ID+'&clientTypeID='+$('.clientTypeID').val()+'&type='+'edit');
	}
	
	/**删除***/
	function delModule(row){
		$("#delPersonClientmodule").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/deleteOneCompanyClientInfo',data:JSON.stringify({"client_ID":row.client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#personClient-table').bootstrapTable('remove', {
							field: 'client_ID',
							values: [row.client_ID]
						});
						$.zjm_persionClient.initColumns();
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
	/**转入黑名单***/
	function returnBlackList(){
		var selectContent = $('#personClient-table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{ 
        	$("#add_badClientModule").modal({keyboard:true});
        	tool.undisabled(".btn_submit");
     		$(".btn_submit").click(function(){
     			tool.disabled(".btn_submit");
     			if($("#addBadClientForm").validationEngine("validate")){
     				$.map($('#personClient-table').bootstrapTable('getSelections'), function(row) {
	     				$("#add_badClient_clientID").val(row.client_ID);
	     				var queryContainer_form = $("#addBadClientForm");
	     				$.ajax({type:'POST',url:'/returnBadClientByClientID',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		     		        	if(data.obj==true){
		     						$('#personClient-table').bootstrapTable('remove', {
		     							field: 'client_ID',
		     							values: [row.client_ID]
		     						});
		     						$("#add_badClientModule").modal("hide");
		     						$.zjm_persionClient.initColumns();
		     					}else{
		     						alert("转入黑名单失败！");
		     					}
		     		        }
		     			});
	     				
	     			});//多选
    			}else{
    				tool.undisabled(".btn_submit");
    			}
     		});
     		$("#add_badClientModule").on("hidden.bs.modal", function (e) {//解除事件绑定
    			 $(".btn_submit").unbind("click");
    		});
        } 
	}
	
	/**授权共享人***/
	function clientShare(){
		var selectContent = $('#personClient-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var client_ID = $('#personClient-table').bootstrapTable('getSelections')[0].client_ID;
			$("#shareClient_page").load("/crm/clientShare/selectClientSharePage",{"client_ID":client_ID},function(response,status,xhr){
				$("#add_shareClientModule").modal({keyboard:true});
				$("#clientID").val(client_ID);
				$.zjm_zTreeUser.initTree("userSetTree","userIDs","userNames","/sys/dic/selectDepartsUserTreeTwo");
				tool.undisabled(".btn_submit");
				$(".btn_submit").click(function(){
					tool.disabled(".btn_submit");
					if($("#add_ShareClientForm").validationEngine("validate")){
						$("#add_shareClientModule").modal("hide");
							var queryContainer_form = $("#add_ShareClientForm");
							$.ajax({type:'POST',url:'/crm/clientShare/insertOneClientShareInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
								if(data.obj==true){
									$("#add_shareClientModule").modal("hide");
									$.zjm_persionClient.initColumns();
								}else{
									alert("授权共享失败！");
								}
							}
							});
							
					}else{
						tool.undisabled(".btn_submit");
					}
				});
				$("#add_shareClientModule").on("hidden.bs.modal", function (e) {//解除事件绑定
					$(".btn_submit").unbind("click");
				});
			})
		} 
	}

	
	
	/**删除所选**/
	function deleteOfSelected(){
		var selectContent = $('#personClient-table').bootstrapTable('getSelections')[0]; 
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{  
      	 $.map($('#personClient-table').bootstrapTable('getSelections'), function(row) {        	
	        	 $('#delPersonClientmodule').modal('show');     // 项目立项面板  
	             tool.undisabled(".btn_submit");
	     		$(".btn_submit").click(function(){
//	     			 $.map($('#personClient-table').bootstrapTable('getSelections'), function(row) {
//	     				 alert("aaaa");
//	     				var selectContents = $('#personClient-table').bootstrapTable('getSelections'); 
//	     				alert(selectContents);
//		     			 var applyIDs = [];
//		     				//循环
//		     				for(var i=0;i<selectContents.length;i++){
//		     					alert("cccc");
//		     					client_ID=selectContent[i].client_ID
//		     					alert("capplyIDs"+client_ID);
//		     					applyIDs.push(selectContent[i].client_ID);
//		     					alert("applyIDs"+client_ID);
//		     				}
	     			tool.disabled(".btn_submit");
	     			$.ajax({type:'POST',url:'/deleteOneCompanyClientInfo',data:JSON.stringify({"client_ID":row.client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	     		        	if(data.obj==true){
	     						$('#personClient-table').bootstrapTable('remove', {
	     							field: 'client_ID',
	     							values: [row.client_ID]
	     						});
	     						$.zjm_persionClient.initColumns();
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
	        });//多选
           
        }  
	}
	
	/***业务明细***/
	function projectDetaiil(){
		$("#personClientPage").hide();
		$("#projectDetailPage").show();
		$('html, body').animate({scrollTop:0}, 'slow');
	}
	
	/***从业务明细返回列表***/
	function p_backList(row){
		$("#projectDetailPage").hide();
		$("#personClientPage").show();
		$('html, body').animate({scrollTop:0}, 'slow');
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
	
	function listSet(){
		$("#listSetColumnsModule").modal({keyboard:true});
		$("#listBH").val("002");
		zjm.dataColumnsVal("/selectChoosableColumnsJSON",{"listBH":'002'},"ztb_choosable");
		zjm.dataColumnsVal("/selectSelectedColumnsJSON",{"listBH":'002'},"ztb_selected");
		$.zjm_listSet.columnsSort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function () {
			if($("#selectedColumns").val()==""){
				$("#selectedColumnNotEmpty").modal({keyboard:true});
			}else{
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#listSetColumnsForm");
				$.ajax({type:'POST',url:'/updateOneListSetInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==1){
						$("#listSetColumnsModule").modal("hide");
						initColumns();
					}else{
						alert("保存失败！");
						initColumns();
					}
			        }
				});
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
	}
	/**********************************************同步***************************/
	//同步
	function synchro(){
			var selectContent = $('#personClient-table').bootstrapTable('getSelections');  
	        if(selectContent.length != 1) {  
	        	$("#pleaseSelectOne").modal({keyboard:true});
	            return false;  
	        }else{  
	        	$.map($('#personClient-table').bootstrapTable('getSelections'), function(row) {
	        		 $('#synchroPersonClientmodule').modal('show'); 
	        		 var guid=$('#personClient-table').bootstrapTable('getSelections')[0].clientGUID;
	        		 $.zjm_persionClient.initProjNameTable(guid);	
		             tool.undisabled(".btn_submit");		          
		     		$(".btn_submit").click(function(){	 
		    			var selectContent2 = $('#personProject-table').bootstrapTable('getSelections')[0];  
		    	        if(typeof(selectContent2) == 'undefined') {  
		    	        	$("#pleaseSelectOne").modal({keyboard:true});
		    	            return false;  
		    	        }else{		    	            		
		    		        	var selectContents = $('#personProject-table').bootstrapTable('getSelections'); 
		    	 				for(var i=0;i<selectContents.length;i++){	 			
		    	 					var clientIDS=selectContents[i].client_ID;
		    	 					
		    	 					$.ajax({
		    	 			        	type:"post",
		    	 			        	url:"/MainSyncSlaveClient",
		    	 			        	data:{"client_ID":clientIDS},
		    	 			        	contentType:"application/x-www-form-urlencoded",
		    	 			        	dataType:"json",
		    	 			        	success:function(data){
		    	 			        		if(data.obj){
		    	 			        			$("#synchroPersonClientmodule").modal("hide");
		    	 			        			$("#success").modal({keyboard:true});
		    	 			        		}else{
		    	 			        			alert("同步失败！");
		    	 			        		}
		    	 			        	},
		    	 			        	
		    	 			        });
		    	 					
		    	 				}
		    	        }
		     		});
		        });//多选	           
	        }  
		}
	//同步222222222222
	function synchro2(){
			var selectContent = $('#personProject-table').bootstrapTable('getSelections')[0];  
	        if(typeof(selectContent) == 'undefined') {  
	        	$("#pleaseSelectOne").modal({keyboard:true});
	            return false;  
	        }else{  
	        	$(".btn_submit").click(function(){	
	        		alert("cccczzzz");
		        	var selectContents = $('#personProject-table').bootstrapTable('getSelections'); 
	 				for(var i=0;i<selectContents.length;i++){
	 					console.info(selectContents[i].apply_ID);
	 					var apply_ID=selectContents[i].apply_ID;
	 					$.ajax({type:'POST',url:'/updateClientProject',data:JSON.stringify({"apply_ID":apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		     		        
		     				if(data.obj==1){
		     						$("#synchromodule").modal("hide");
		     					}else{
		     						alert("同步失败！");
		     					}		     		        
			     			}
		     			});
	 				}
	     		});
	        	/*$.map($('#personProject-table').bootstrapTable('getSelections'), function(row) {
	        		var selectContents = $('#personProject-table').bootstrapTable('getSelections'); 


	     				for(var i=0;i<selectContents.length;i++){
	     					alert("cccc");
	     					 var apply_ID=selectContent[i].apply_ID
	     					alert("capplyIDs"+apply_ID);
	     				}
	        		 $('#synchromodule').modal('show'); 
	        		
		             tool.undisabled(".btn_submit");
		     		$(".btn_submit").click(function(){	  
		     			alert(row.apply_ID);
		     			$.ajax({type:'POST',url:'/updateClientProject',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		     		        
		     				if(data.obj==1){
		     						$("#synchromodule").modal("hide");
		     					}else{
		     						alert("同步失败！");
		     					}		     		        
		     			}
		     			});
		     		});
		     		$("#synchromodule").on("hidden.bs.modal", function (e) {//解除事件绑定
		     			 $(".btn_submit").unbind("click");
		     		});
		        });//多选	           
*/	        }  
		}
	/**
	 * 初始化项目名称列表
	 */
	function initProjNameTable(row){
		$("#personProject-table").bootstrapTable('destroy');
		$('#personProject-table').bootstrapTable({
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
				 $.extend(params, {"queryCondition":{"clientGUID":row.clientGUID}});				
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
		
		$.zjm_persionClient.initColumns();
	};
	/**
	 * 新增
	 */
	$("#btn_addOnePersonClient").click(function(){
		$.zjm_persionClient.addOnePersonClient();
	});

	/**
	 * 删除
	 */
	$("#btn_deleteOfSelected").click(function(){
		$.zjm_persionClient.deleteOfSelected();
	});
	/**
	 * 转入黑名单
	 */
	$("#btn_returnBlackList").click(function(){
		$.zjm_persionClient.returnBlackList();
	});
	/**
	 * 授权共享人
	 */
	$("#btn_clientShare").click(function(){
		$.zjm_persionClient.clientShare();
	});
	
	/**
	 * 业务明细
	 */
	$("#btn_projectDetaiil").click(function(){
		$.zjm_persionClient.projectDetaiil();
	});
	
	/**
	 * 从业务明细返回
	 */
	$("#btn_p_backList").click(function(){
		$.zjm_persionClient.p_backList();
	});
	
	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_persionClient.hightSelect();
	});
	
	/**
	 * 自定义列表
	 */
	$("#btn_listSet").click(function(){
		$.zjm_persionClient.listSet();
	});
	
	$("#btn_refresh").click(function(){
		$.zjm_persionClient.initColumns();
	});
	/**
	 * 同步
	 */
	$("#btn_synchro").click(function(){
		$.zjm_persionClient.synchro();
	});
	$("#rtn_synchro").click(function(){
		$.zjm_persionClient.synchro2();
	});
	
	
});


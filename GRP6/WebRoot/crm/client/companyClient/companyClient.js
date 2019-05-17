(function($,z){
	var data;
	$.zjm_companyClient = {
			initColumns:initColumns,
			viewCompanyClient:viewCompanyClient,//客户详情查看
			editCompanyClient:editCompanyClient,//企业客户列表修改
			addOneCompanyClient:addOneCompanyClient,//新增客户
			deleteOfSelected:deleteOfSelected,//删除所选(单选或多选)
			updateBasicInfo:updateBasicInfo,//基本信息修改
			hightSelect:hightSelect,//高级查询
			initTable:initTable,//初始化列表
			p_backList:p_backList,//从业务明细返回
			deleteOneOfSelected :deleteOneOfSelected,//删除单选;
			returnBlackList:returnBlackList,//转入黑名单
			listSet :listSet,//自定义栏目
			compangyClientShare:compangyClientShare,//授权共享人;
			toSlaveClientList:toSlaveClientList ,// 打开副版本客户列表
			
			
	};
     
	var userIDs = "";
	var userNames = ""
		
	function initColumns(condition){
		var columns = [
			{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
		];
		
		$.ajax({type:'POST',url:'/selectOneListSetInfo',data:JSON.stringify({"listBH":'001'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
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
	        					"formatter" : function (value, row, index) {
	        						return  value
	        						
	        					}
	        			}
	        			if(field == "createDateTime" || field=="createDate"){
	        				$.extend(column,{"formatter" : function (value, row, index) {return tool.parseDate(value)}})
						};
						if(field == "clientName" ){
	        				$.extend(column,{"formatter" : function (value, row, index) {
	        						return ['<a class="btn_client_view" href="javascript:void(0)">'+row.clientName+'</a>'].join('');
        						},
        						events:{
        							'click .btn_client_view': function(e, value, row, index) {
        								$.zjm_companyClient.viewCompanyClient(row);
        							},
        						}
        					})
	        			};
	        			columns.push(column);
	        		}
	        		
	        		columns.push({title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_modules_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_modules_edit btn btn-xs btn-info" title="修改----" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_modules_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_companyClient.viewCompanyClient(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_companyClient.editCompanyClient(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_companyClient.deleteOneOfSelected(row);
							}
						}
					});
	        		$.zjm_companyClient.initTable(condition,columns);
				}else{
					columns.push({title: '操 作 ',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_modules_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_modules_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
							'<button class="btn_modules_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_companyClient.viewCompanyClient(row);
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_companyClient.editCompanyClient(row);
							},
							'click .btn_modules_del': function(e, value, row, index) {
								$.zjm_companyClient.deleteOneOfSelected(row);
							}
						}
					});
					$.zjm_companyClient.initTable(condition,columns);;
				}
	        }
		});
		
	};
	
	
	
	
	
	/**初始化 企业客户信息列表***/
	function initTable(condition,columns){
		$("#companyClient-table").bootstrapTable('destroy');
		$('#companyClient-table').bootstrapTable({
							method: 'get',
							
							/*columns : [{field : 'checked',title:'client_ID',checkbox : true,align : 'center',formatter : function(value, row, index) {return ;}},
									{field : 'index',title : '序号',align : 'center',formatter : function(value, row, index) {return index + 1;}},
									{field : "clientBH",title : '客户编号',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.clientBH;}},
									{field : "clientName",title : '客户名称',align : 'center',sortable : "true",formatter : function(value, row, index) {
											return [ '<a class="btn_client_view" href="javascript:void(0)">'
													+ row.clientName + '</a>' ]
													.join('');},
										//客户名称绑定事件
										events : {
											'click .btn_client_view' : function(
													e, value, row, index) {
												$.zjm_companyClient.viewCompanyClient(row);
														
											},
										}
									},
									
									{field : "fullAreaName",title : '所属区域',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.fullAreaName;}},
									{field : "fullTradeName",title : '所属行业',align : 'center',sortable : "true",formatter : function(value, row, index) {
											return tool.isNull(row.fullTradeName,"空");
											return row.fullTradeName;}},
									{field : "createDate",title : '成立日期',align : 'center',sortable : "true",formatter : function(value, row, index) {
											 //json日期格式转换为正常格式
												return tool.parseDate(row.createDate);
											//	return row.createDate;
										}},
									{field : "contactOne",title : '联系人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.contactOne;}},
									{field : "phoneOne",title : '联系方式',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.phoneOne;}},
									{field : "employeeSum",title : '员工人数（人）',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.employeeSum;}},
									{field : "unit_uidName",title : '机构名称',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.unit_uidName;}},
									{field : "fullDepartName",title : '创建部门',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.fullDepartName;}},
									{field : "createUserName",title : '创建人',align : 'center',sortable : "true",formatter : function(value, row, index) {return row.createUserName;}},
									{field : "createDateTime",title : '创建日期',align : 'center',sortable : "true",formatter : function(value, row, index) {return tool.parseDate(row.createDateTime);						}},
									
									
									{title : '操作',align : 'center',formatter : function(value, row, index) {
											return [
													'<button class="btn_client_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
													'<button class="btn_client_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
													'<button class="btn_client_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ]
													.join('');
										},
										events : {
											'click .btn_client_view' : function(
													e, value, row, index) {
												console.log(row);
												$.zjm_companyClient.viewCompanyClient(row);
														
											},
											'click .btn_client_edit' : function(
													e, value, row, index) {
												$.zjm_companyClient.editCompanyClient(row);
														
											},
											'click .btn_client_del' : function(
													e, value, row, index) {
												$.zjm_companyClient.deleteOneOfSelected(row);
														
											}
										}
				}],*/ //end columns
			columns: columns,
			detailView: true,	
			detailFormatter:function(index, row){	
			    var html = [];
			        html.push('<p><b>客户编号:</b> ' + tool.isNull(row.clientBH,"") + '</p>');
			        html.push('<p><b>客户名称:</b> ' + row.clientName + '</p>');
			        html.push('<p><b>所属区域:</b> ' +  tool.isNull(row.fullAreaName,"") + '</p>');
			        html.push('<p><b>所属行业:</b> ' + tool.isNull(row.fullTradeName,"") + '</p>');			       
			        html.push('<p><b>成立日期:</b> ' + tool.parseDate(row.createDate) + '</p>');
			        
			        /*html.push('<p><b>注册资金:</b> ' + tool.isNull(row.registerSum,"") + '万元</p>');*/
			        html.push('<p><b>联系人:</b> ' + tool.isNull(row.contactOne,"")+ '</p>');
			        html.push('<p><b>联系方式:</b> ' + tool.isNull(row.phoneOne,"") + '</p>');
			        html.push('<p><b>员工总数:</b> ' + tool.isNull(row.employeeSum,"") + '人</p>');
			        html.push('<p><b>机构名称:</b> ' + tool.isNull(row.unit_uidName,"") + '</p>');
			        html.push('<p><b>创建部门:</b> ' + tool.isNull(row.fullDepartName,"") + '</p>');
			        html.push('<p><b>创建人:</b> ' + tool.isNull(row.createUserName,"") + '</p>');
			        html.push('<p><b>创建日期:</b> ' + tool.parseDate( row.createDateTime) + '</p>');
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
			pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
			url: "/selectCompanyClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
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
	
	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function viewCompanyClient(row){
		window.parent.openMenu('view_companyClient'+row.client_ID,'','企业客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type='+'view');
	}
	/** 查看 企业客户信息 查看客户信息 客户详情**/
	function editCompanyClient(row){
		window.parent.openMenu('edit_companyClient'+row.client_ID,'','企业客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type='+'edit');
	}
	
	/**新增企业客户  添加企业客户 **/
	function addOneCompanyClient(id,name,ppnode){
		
		$("#addCompanyClient").modal({keyboard:true});
		zjm.init();
		$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//yyyy-mm-dd .fromat("yyyy-MM-dd")
		
		zjm.dataViewValSelect("select_clientSource", "/selectDicTypeListJSON", {"dicTypePID" : '3fafef23e87a4b9c99807207f618883d'});/*获取客户来源下拉框*/
		
		
		
	   $.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
		success:function(data) {		
			$("#txt_id").selectTreeWidgets({
				width : "90%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
	 //获取所属区域 下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectMultiLevelSortDicTree',data:JSON.stringify({'id':'66547f3187194ed884e81dcd83027c36'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {       
			$("#fullAreaCode").selectTreeWidgets({
				width : "90%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
		}
		});
	
	
		//**注册编辑验证引擎*//
		zjm.validata({formId:"add_companyClientForm"});
		//**提交 保存 新增企业信息*//*
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#add_companyClientForm").validationEngine("validate")){
				var queryContainer_form = $("#add_companyClientForm");
				if(zjm.ajaxValidata("add_clientName","/selectAddClientNameIsExist",JSON.stringify(queryContainer_form.serializeJson()),"客户名称重复！")){
							
					
					
					$.ajax({
					type : 'POST',
					url : '/insertOneCompanyClientInfo',
					data : JSON.stringify(queryContainer_form.serializeJson()),
					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						if (data.obj == 1) {
							$("#addCompanyClient").modal("hide");
							$(".ztb_add").val("");
							$.zjm_companyClient.initColumns();
						} else {
							alert("保存失败！");
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
		$("#add_companyClientForm").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	} // end 新增企业客户
	
	
	/**删除企业客户 **/
	function deleteOfSelected(row){
		var selectContent = $('#companyClient-table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{  
        	  
       	 /*$.map($('#personClient-table').bootstrapTable('getSelections'), function(row) {
	        	 $('#delPersonClientmodule').modal('show');     // 项目立项面板  
	             tool.undisabled(".btn_submit");
	     		$(".btn_submit").click(function(){
	     			tool.disabled(".btn_submit");
	     			$.ajax({type:'POST',url:'/deleteOneCompanyClientInfo',data:JSON.stringify({"client_ID":row.client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	     		        	if(data.obj==true){
	     						$('#personClient-table').bootstrapTable('remove', {
	     							field: 'client_ID',
	     							values: [row.client_ID]
	     						});
	     						$.zjm_persionClient.initTable();
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
*/          
       
        	
        	 $.map($('#companyClient-table').bootstrapTable('getSelections'), function(row) {
	        	 $('#delCompanyClientInfo').modal('show');     // 项目立项面板  
	             tool.undisabled(".btn_submit");
	     		$(".btn_submit").click(function(){
	     			tool.disabled(".btn_submit");
	     			$.ajax({type:'POST',url:'/deleteOneCompanyClientInfo',data:JSON.stringify({"client_ID":row.client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
	     		        	if(data.obj==true){
	     						$('#companyClient-table').bootstrapTable('remove', {
	     							field: 'client_ID',
	     							values: [row.client_ID]
	     						});
	     						$("#delCompanyClientInfo").modal("hide");
	     						$.zjm_companyClient.initColumns();
	     					}else{
	     						alert("删除失败！");
	     					}
	     		        }
	     			});
	     		});
	     		$("#delCompanyClientInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
	     			 $(".btn_submit").unbind("click");
	     		});
	        });//多选
           
        }  
	
		
		
		/*
		$("#delCompanyClientInfo").modal({keyboard:true});
		tool.undisabled(".btn_submit");//恢复按钮可用
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/deleteOneCompanyClientInfo',
				data : JSON.stringify({
					"client_ID" : row.client_ID
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$('#companyClient-table').bootstrapTable('remove', {
							field : 'client_ID',
							values : [ row.client_ID ]
						});
						$.zjm_companyClient.initTable();
						$("#delCompanyClientInfo").modal("hide");
					} else {
						alert("删除失败！");
					}
				}
			});
		});
		$("#delCompanyClientInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	*/} //删除企业客户 end 
	
/*	*/
	/**删除***/
	function deleteOneOfSelected(row){
		$("#delCompanyClientInfo").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/deleteOneCompanyClientInfo',data:JSON.stringify({"client_ID":row.client_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
						$('#companyClient-table').bootstrapTable('remove', {
							field: 'client_ID',
							values: [row.client_ID]
						});
						$("#delCompanyClientInfo").modal("hide");
						$.zjm_companyClient.initColumns();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#delCompanyClientInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	};
	/**转入黑名单***/
	function returnBlackList(){
		var selectContent = $('#companyClient-table').bootstrapTable('getSelections')[0];  
        if(typeof(selectContent) == 'undefined') {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }else{ 
        	$("#add_badClientModule").modal({keyboard:true});
        	tool.undisabled(".btn_submit");
     		$(".btn_submit").click(function(){
     			tool.disabled(".btn_submit");
     			if($("#addBadClientForm").validationEngine("validate")){
     				$.map($('#companyClient-table').bootstrapTable('getSelections'), function(row) {
	     				$("#add_badClient_clientID").val(row.client_ID);
	     				var queryContainer_form = $("#addBadClientForm");
	     				$.ajax({type:'POST',url:'/returnBadClientByClientID',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		     		        	if(data.obj==true){
		     						$('#companyClient-table').bootstrapTable('remove', {
		     							field: 'client_ID',
		     							values: [row.client_ID]
		     						});
		     						$("#add_badClientModule").modal("hide");
		     						$.zjm_companyClient.initColumns();
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
	};
	
	/**基本信息修改**/
	function updateBasicInfo(){
		//$("#backList").hide();//隐藏返回按钮
		$("#updateBasicInfo").modal({keyboard:true});
		/*zjm.init();
		*//**注册编辑验证引擎*//*
		zjm.validata({formId:"add_companyClientForm"});
		*//**提交*//*
		tool.undisabled(".btn_submit"); */
	}
	
	/**高级查询**/
	function hightSelect(){
		$("#hightSelectCompanyClient").modal({keyboard:true});
		zjm.init();
		
		zjm.dataViewValSelect("select_EnterpriseType", "/selectDicTypeListJSON", {"dicTypePID" : '6e54bbcb394b4b6cb4d149b45c46188b'});/*获取企业类型下拉框*/
		zjm.dataViewValSelect("select_natureID", "/selectDicTypeListJSON", {"dicTypePID" : '857906f8b1d34b18b29fae5e3b998a25'});/*获取企业性质下拉框*/
		zjm.dataViewValSelect("select_currencyID", "/selectDicTypeListJSON", {"dicTypePID" : '22ce39c3443f4ca5be21a8351ce991e2'});/*获取币别下拉框*/
		zjm.dataViewValSelect("select_clientSource", "/selectDicTypeListJSON", {"dicTypePID" : '3fafef23e87a4b9c99807207f618883d'});/*获取客户来源下拉框*/
		
		//获取部门下拉树;
		/*$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#fullDepartCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });*/
		//获取部门下拉树;
		$.ajax({type:'POST',url:'/selectAllDepartsListTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
			$("#fullDepartCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
		//获取所属行业下拉树
		$.ajax({type:'POST',url:'/sys/dic/selectMultiLevelSortDicTree',data:JSON.stringify({'id':'c9ee6e6d3b5a41faafb263b1baff7b2e'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {       
			$("#fullTradeCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
        }
        });
		
		//获取所属区域 下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectMultiLevelSortDicTree',data:JSON.stringify({'id':'66547f3187194ed884e81dcd83027c36'}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {       
			$("#fullAreaCode").selectTreeWidgets({
				width : "93%",//设置控件宽度
				multiple : false,//是否多选
				data : data.obj//数据源
			});
		}
		});
		
		
		
		
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){		
			//tool.disabled(".btn_submit");			
			if($("#hightSelectCompanyClient_Form").validationEngine("validate")){
				var queryContainer_form = $("#hightSelectCompanyClient_Form");
				var condition = queryContainer_form.serializeJson();
				$("#hightSelectCompanyClient").modal("hide");
				$(".ztb_add").val("");
				/*initTable(data);	*/
				initColumns(condition);
			}
			/*$.ajax({
				type : 'POST',
				url : '/selectCompanyClientPageTables',
				data : JSON.stringify(queryContainer_form.serializeJson()),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#hightSelectCompanyClient_Form").modal("hide");
						$(".ztb_add").val("");
						$.zjm_companyClient.initTable();
					} else {
						alert("保存失败！");
					}
				}
			});*/
		
		});
		$("#hightSelectCompanyClient").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
		
		
	}
	

	/***返回列表***/
	function p_backList(row){
		$("#projectDetailPage").hide();
		$("#companyClientListPage").show();
		$('html, body').animate({scrollTop:0}, 'slow');
	}
	
	
	
	function listSet(){		
		$("#listSetColumnsModule").modal({keyboard:true});
		$("#listBH").val("001");
		zjm.dataColumnsVal("/selectChoosableColumnsJSON",{"listBH":'001'},"ztb_choosable");
		zjm.dataColumnsVal("/selectSelectedColumnsJSON",{"listBH":'001'},"ztb_selected");
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
						$.zjm_companyClient.initColumns();
					}else{
						alert("保存失败！");
						$.zjm_companyClient.initColumns();
					}
			        }
				});
			}
		});
		$(".btn_reset").click(function () {
			zjm.dataColumnsVal("/selectChoosableColumnsJSON",{"listBH":'001'},"ztb_choosable");
			zjm.dataColumnsVal("/selectSelectedColumnsJSON",{"listBH":'001'},"ztb_selected");
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
	/**
	 * 授权共享人
	 * @returns
	 */
	function compangyClientShare(){		
		var selectContent = $('#companyClient-table').bootstrapTable('getSelections'); 
		if(typeof(selectContent) == 'undefined' || selectContent.length != 1) { 
			$("#pleaseSelectOne").modal({keyboard:true});
			return false;  
		}else{
			var client_ID = $('#companyClient-table').bootstrapTable('getSelections')[0].client_ID;
			
			$("#companyClientShare_Page").load("/crm/clientShare/selectClientSharePage",{"client_ID":client_ID},function(response,status,xhr){
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
									$.zjm_companyClient.initColumns();									
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
	
	
	/**
	 *  副版本客户列表
	 */
	function toSlaveClientList(){
		var selectContent = $('#companyClient-table').bootstrapTable('getSelections');  			
        if(selectContent.length < 1) {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }
        var clientGUIDs="";
        for(var i in selectContent){
        	if(i < selectContent.length-1 ){
        		clientGUIDs+=selectContent[i].clientGUID+",";
        	}else{
        		clientGUIDs+=selectContent[i].clientGUID;
        	}
        }
        
        $("#companyClientSynchroPage").load("/toSlaveClientPage",{"clientGUIDs":clientGUIDs},function(){
        	 $("#synchroCompanyClientmodule").modal({keyboard:true});
        	 	
        });
	}
	
	
	
})(jQuery, this); 



$(function () {
	/**
	 * 初始化进入加载企业客户信息 列表
	 */
	window.onload = floaddata;
	function floaddata() {
		 /*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		}); 
		$.zjm_companyClient.initColumns();
		 
		
		
	}; 
	/**
	 * 重置列表
	 */
	$("#btn_refreshCompanyClient").click(function(){
		$.zjm_companyClient.initColumns();
	});
	/**
	 * 新增企业
	 */
	$("#btn_addOneCompanyClient").click(function(){
		$.zjm_companyClient.addOneCompanyClient();
	});
	/**
	 * 删除所选
	 */
	$("#btn_deleteOfSelected").click(function(){
		$.zjm_companyClient.deleteOfSelected();
	});
	/**
	 * 从客户详情返回 
	 */
	$("#btn_backList").click(function(){
		$.zjm_companyClient.backList();
	});
	
	/**
	 * 高级查询
	 */
	$("#btn_hightSelect").click(function(){
		$.zjm_companyClient.hightSelect();
	});
	
	/**
	 * 从业务明细返回
	 */
	$("#btn_p_backList").click(function(){
		$.zjm_companyClient.p_backList();
	});
	/**
	 * 转入黑名单
	 */
	$("#btn_returnBlackList").click(function(){
		$.zjm_companyClient.returnBlackList();
	});
	/**
	 * 自定义列表
	 */
	$("#btn_listSet").click(function(){
		$.zjm_companyClient.listSet();
	});
	/**
	 * 授权共享人
	 */
	$("#btn_compangyClientShare").click(function(){
		$.zjm_companyClient.compangyClientShare();
	});
	
	/**
	 *  副版本客户列表
	 */
	$("#btn_sysnProject").click(function(){
		$.zjm_companyClient.toSlaveClientList();
	});
	
	
	
});


(function($,z){
	$.zjm_blacklist = {
			initCompanyTable:initCompanyTable,//初始化列表，默认企业黑名单
			loadCompanyInfo:loadCompanyInfo,//加载企业黑名单
			initPersonTable:initPersonTable,
			loadPersonInfo:loadPersonInfo,
			changeToNormal:changeToNormal,
			viewBlackList:viewBlackList,
			editBlackList:editBlackList,
			viewCompanyClient:viewCompanyClient,		
			daoru:daoru,//导入黑名单
			fanhui:fanhui,//
			viewPersonClient:viewPersonClient				
	};	
	/**加载事件*/
	function loadCompanyInfo(){
		$("#loadCompanyInfo").load("/crm/blacklist/badCompanyList.jsp",function(){
			location.hash = "badCompany";		//location.hash，可以获取或设置页面定位锚，此处为设置
			$.zjm_blacklist.initCompanyTable();
			$('#badCompany_table').bootstrapTable('hideColumn','badClient_ID'); //隐藏指定列
		});
	}
	/**上传导入黑名单*/
	function daoru(){
			$("#enterpriseBlack_page").load("/blackMan",function(response,status,xhr){
						$("#blackManView").modal({keyboard:true});					
						tool.undisabled(".btn_submit");			
						$(".btn_submit").click(function(){	
							$("#batchAdd").submit();			
							tool.disabled(".btn_submit");			
						});
		});
	}
	function fanhui(){
		$("#blackManView3").modal("hide");		
		window.location.href="/selectBlackManPage";	
	}
	function loadPersonInfo(){
		$("#loadPersonInfo").load("/crm/blacklist/badPersonList.jsp",function(){
			location.hash = "badPerson";
			$.zjm_blacklist.initPersonTable();
			$('#badPerson_table').bootstrapTable('hideColumn','badClient_ID'); //隐藏指定列
		});
	}	
	/**初始化企业黑名单列表***/
	function initCompanyTable(){
		$('#badCompany_table').bootstrapTable({
			method: 'get',
			url: "/selectBadClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			columns: [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"clientBH",title: '客户编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.clientBH;}},
					{field:"clientName",title: '企业名称',align: 'center',sortable:"true",formatter: function (value, row, index) { 
						return [ '<a class="btn_client_view" href="javascript:void(0)">'+ row.client.clientName + '</a>' ].join('');},
						//企业名称绑定事件
						events:{
							'click .btn_client_view' : function(e, value, row, index) {
								$.zjm_blacklist.viewCompanyClient(row.client_ID);
							}
						}
					},
//					{field:"fullAreaName",title: '所属区域',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.fullAreaName;}},
//					{field:"fullTradeName",title: '所属行业',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.fullTradeName;}},
//					{field:"natureName",title: '企业性质',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.natureName;}},
//					{field:"createDate",title: '成立日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.createDate;}},
//					{field:"currencyName",title: '注册币别',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.currencyName;}},
//					{field:"registerSum",title: '注册资金（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.registerSum;}},
//					{field:"employeeSum",title: '员工总数（人）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.employeeSum;}},
					{field:"unit_uidName",title: '机构名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidName;}},
					{field:"operationDepartName",title: '拉黑经办部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operationDepartName;}},
					{field:"operatorName",title: '拉黑经办人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operatorName;}},
					{field:"operatorDate",title: '拉黑日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.operatorDate);}},
					{field:"operationDescription",title: '拉黑原因',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operationDescription;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_blacklist.viewBlackList(row,"company");
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_blacklist.editBlackList(row,"company");
							},
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号：</b> ' + (index+1) + '</p>');
			        html.push('<p><b>客户编号：</b> ' + tool.isNull(row.client.clientBH,"") + '</p>');
			        html.push('<p><b>企业名称：</b> ' + tool.isNull(row.client.clientName,"") + '</p>');
			        html.push('<p><b>成立日期：</b> ' + tool.parseDate(row.client.createDate) + '</p>');
			        html.push('<p><b>注册币别：</b> ' + tool.isNull(row.client.currencyName,"") + '</p>');
			        html.push('<p><b>注册资金：</b> ' + tool.isNull(row.client.registerSum,"") + '万元</p>');
			        html.push('<p><b>机构名称：</b> ' + tool.isNull(row.unit_uidName,"") + '</p>');
			        html.push('<p><b>拉黑经办部门：</b> ' + tool.isNull(row.operationDepartName,"") + '</p>');
			        html.push('<p><b>拉黑经办人：</b> ' + tool.isNull(row.operatorName,"") + '</p>');
			        html.push('<p><b>拉黑日期：</b> ' + tool.parseDate(row.operatorDate) + '</p>');
			        html.push('<p><b>拉黑原因：</b> ' + tool.isNull(row.operationDescription,"") + '</p>');
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
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort；此处设置为 ''，在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientTypeID":"01"}});
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
	/**初始化个人黑名单列表***/
	function initPersonTable(){
		$('#badPerson_table').bootstrapTable({
			method: 'get',
			url: "/selectBadClientPageTables",//这个接口需要处理bootstrap table传递的固定参数
			columns: [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
					{field:"clientName",title: '申请人姓名',align: 'center',sortable:"true",formatter: function (value, row, index) { 
						return  '<a class="btn_client_view" href="javascript:void(0)">'+ row.client.personName + '</a>' ;},
						//企业名称绑定事件
						events:{
							'click .btn_client_view' : function(e, value, row, index) {
								$.zjm_blacklist.viewPersonClient(row.client_ID);
							}
						}
					},
					{field:"certificateCode",title: '身份证号码',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.certificateCode;}},
					{field:"sex",title: '性别',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.sex;}},
					{field:"age",title: '年龄',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.age;}},
//					{field:"position",title: '职位',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.position;}},
//					{field:"domicile",title: '户口所在地',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.domicile;}},
//					{field:"houseAddress",title: '住址',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.houseAddress;}},
					{field:"phone",title: '联系方式',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.client.phone;}},
					{field:"unit_uidName",title: '机构名称',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.unit_uidName;}},
					{field:"operationDepartName",title: '拉黑经办部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operationDepartName;}},
					{field:"operatorName",title: '拉黑经办人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operatorName;}},
					{field:"operatorDate",title: '拉黑日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.operatorDate);}},
					{field:"description",title: '拉黑原因',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.operationDescription;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_modules_view': function(e, value, row, index) {
								$.zjm_blacklist.viewBlackList(row,"person");
							},
							'click .btn_modules_edit': function(e, value, row, index) {
								$.zjm_blacklist.editBlackList(row,"person");
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
			        html.push('<p><b>申请人姓名:</b> ' + tool.isNull(row.client.clientName,"") + '</p>');
			        html.push('<p><b>身份证号码:</b> ' + tool.isNull(row.client.certificateCode,"") + '</p>');
			        html.push('<p><b>性别:</b> ' + tool.isNull(row.client.sex,"") + '</p>');
			        html.push('<p><b>年龄:</b> ' + tool.isNull(row.client.age,"") + '</p>');
			        html.push('<p><b>联系方式:</b> ' + tool.isNull(row.client.phone,"") + '</p>');
			        html.push('<p><b>机构名称：</b> ' + tool.isNull(row.unit_uidName,"") + '</p>');
			        html.push('<p><b>拉黑经办部门:</b> ' + tool.isNull(row.operationDepartName,"") + '</p>');
			        html.push('<p><b>拉黑经办人:</b> ' + tool.isNull(row.operatorName,"") + '</p>');
			        html.push('<p><b>拉黑日期:</b> ' + tool.parseDate(row.operatorDate) + '</p>');
			        html.push('<p><b>拉黑原因:</b> ' + tool.isNull(row.operationDescription,"") + '</p>');
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
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 $.extend(params, {"queryCondition":{"clientTypeID":"02,03"}});
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
	/**转为正常企业/个人时的弹窗**/
	function changeToNormal(bid,type){
		if(type=="badCompany"){		
			/**注册编辑验证引擎*/
			zjm.validata({formId:"changeCompanyform"});
			$("#changeCompanyform textarea[name='cancelDescription']").val("");
			$("#changeToNormalCompany").modal({keyboard:true});
			zjm.dataViewText("change_","/selectOneBadClientInfo",{"badClient_ID":bid},"operatorDate");
			zjm.dataViewVal("change_","/selectOneBadClientInfo",{"badClient_ID":bid},"operatorDate");
			/**提交***/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#changeCompanyform").validationEngine("validate")){
					var queryContainer_form = $("#changeCompanyform");
					$.ajax({type:'POST',url:'/removeBadClientByClientID',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#changeToNormalCompany").modal("hide");
							$.zjm_blacklist.loadCompanyInfo();
						}else{
							alert("保存失败！");
						}
			        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editBlackList").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		}
		if(type=="badPerson"){
			/**注册编辑验证引擎*/
			zjm.validata({
				formId:"changePersonform"
			});
			$("#changePersonform textarea[name='cancelDescription']").val("");
			$("#changeToNormalPerson").modal({keyboard:true});
			zjm.dataViewText("change_","/selectOneBadClientInfo",{"badClient_ID":bid},"operatorDate");
			zjm.dataViewVal("change_","/selectOneBadClientInfo",{"badClient_ID":bid},"operatorDate");
			/**提交***/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#changePersonform").validationEngine("validate")){
					var queryContainer_form = $("#changePersonform");
					$.ajax({type:'POST',url:'/removeBadClientByClientID',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==1){
							$("#changeToNormalPerson").modal("hide");
							$.zjm_blacklist.loadPersonInfo();
						}else{
							alert("保存失败！");
						}
			        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editBlackList").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		}
	}
	/**黑名单查看***/
	function viewBlackList(row,type){
		$("#viewBadClient").modal({keyboard:true});
		$("#viewBadClient h5."+type).show();
		$("#viewBadClient h5").not("."+type).hide();
		var formatdatas = "createDate,operatorDate";
		$.ajax({type:'POST',url:"/selectOneBadClientInfo",data:JSON.stringify({"badClient_ID":row.badClient_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$.each(data.obj, function(key, value){ 
        		if(typeof value == "object"){
        			for(var key2 in value){
        				if(formatdatas.indexOf(key2)>-1){
        					$(".ztb_view_"+key2).text((value[key2]!=null&&value[key2]!="")?tool.parseDate(value[key2]):"（空）");
        				}else{
        					$(".ztb_view_"+key2).text((value[key2]!=null&&value[key2]!="")?value[key2]:"（空）");
        				}
        			}
        		}else{
        			if(formatdatas.indexOf(key)>-1){
        				$(".ztb_view_"+key).text((value!=null&&value!="")?tool.parseDate(value):"（空）");
        			}else{
        				$(".ztb_view_"+key).text((value!=null&&value!="")?value:"（空）");
        			}
        		}
			});
	        }
		});
	}
	/**黑名单修改**/
	function editBlackList(row,type){
		$("#editblacklist").modal({keyboard:true});
		$("#editblacklist div."+type).show();
		$("#editblacklist div.form-group").not("."+type).hide();
		zjm.init();
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"editBadClientform"
		});
		zjm.dataViewVal("edit_","/selectOneBadClientInfo",{"badClient_ID":row.badClient_ID},"");
		zjm.dataViewText("edit_","/selectOneBadClientInfo",{"badClient_ID":row.badClient_ID},"");
		/**提交***/
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			if($("#editBadClientform").validationEngine("validate")){
				var queryContainer_form = $("#editBadClientform");
				$.ajax({type:'POST',url:'/updateOneBadClientInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					if(data.obj==1){
						$("#editblacklist").modal("hide");
						//保存成功后刷新页面，区分企业和个人分别加载  // alert(location.hash);
						var type = location.hash;
						if(type == "#badCompany"){
							$.zjm_blacklist.loadCompanyInfo();
						}
						if(type == "#badPerson"){
							$.zjm_blacklist.loadPersonInfo();
						}
					}else{
						alert("保存失败！");
					}
		        }
				});
			}else{
				tool.undisabled(".btn_submit");
			}
		});
		$("#editBlackList").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	function viewCompanyClient(client_ID){
		window.parent.openMenu('view_companyClient'+client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+client_ID+'&type=view');
	}
	function viewPersonClient(client_ID){
		window.parent.openMenu('view_personClient'+client_ID,'','客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+client_ID+'&type=view');
	}
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 列表信息
	 */
	window.onload = floaddata;
	function floaddata() {
		var count=$("#count").val();			
		var errorMessage=$("#errorMessage").val();
		if(count>0||errorMessage=='文件不是excel类型'){
			$.zjm_blacklist.loadCompanyInfo();
			$("#blackManView3").modal({keyboard:true});
			$("#queding").click(function(){
				$.zjm_blacklist.fanhui();
			});		
		}
		$.zjm_blacklist.loadCompanyInfo();	
	};	
	$("#btn_daoruinfos").click(function(){
		$.zjm_blacklist.daoru();
	});
	$("#blackPersonTab").click(function(){
		$.zjm_blacklist.loadPersonInfo();
	});
	$("#btn_refreshBadPersonTable").click(function(){
		$.zjm_blacklist.loadPersonInfo();
	});
	$("#blackCompanyTab").click(function(){
		$.zjm_blacklist.loadCompanyInfo();
	});
	$("#btn_refreshBadCompanyTable").click(function(){
		$.zjm_blacklist.loadCompanyInfo();
	});
	$(".changeToNormal").click(function(){
		var type = $(this).attr("value");	//判断按钮的value值，确定是个人还是企业
		var e = $("#"+type+"_table input[name='btSelectItem']:checked");
		if(e.size() == 1){
			var bid = $("#"+type+"_table").bootstrapTable('getSelections')[0].badClient_ID;
			$.zjm_blacklist.changeToNormal(bid,type);
		}else if(e.size() == 0){
			$("#pleaseSelectOne").modal({keyboard:true});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
	$(".viewInfo").click(function(){
		var type = $(this).attr("value");	//判断按钮的value值，确定是个人还是企业
		var e = $("#"+type+"_table input[name='btSelectItem']:checked");
		if(e.size() == 1){
			var bid = $("#"+type+"_table").bootstrapTable('getSelections')[0].client_ID;
			if(type=="badCompany"){
				$.zjm_blacklist.viewCompanyClient(bid);
			}else if(type=="badPerson"){
				$.zjm_blacklist.viewPersonClient(bid);
			}
		}else if(e.size() == 0){
			$("#pleaseSelectOne").modal({keyboard:true});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
});


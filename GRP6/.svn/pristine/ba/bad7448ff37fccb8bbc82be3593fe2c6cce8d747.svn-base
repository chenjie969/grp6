(function($,z){
	$.zjm_relationMain = {
			initTable:initTable,//初始化列表
			delRelationMain:delRelationMain, //删除关联主体，功能函数
			delBatchRelationMain:delBatchRelationMain, //批量删除关联主体
			delOneRelationMain:delOneRelationMain, //删除单个关联主体
			editRelationMain:editRelationMain,//修改关联主体
			viewRelationMain:viewRelationMain,//查看关联主体
			viewCompanyClient:viewCompanyClient,	//查看企业详情
			hightSelect:hightSelect //高级查询
	};
	
	/**初始化主体列表***/
	function initTable(condition){
		$('#relationMain-table').bootstrapTable('destroy');
		$('#relationMain-table').bootstrapTable({
			method: 'get',
			// valign:'middle' 垂直居中属性 
			columns: [{field:'checked',checkbox:true,align: 'center',valign:"middle",formatter: function (value, row, index) {return index+1;}},
					{title: '序号',align: 'center',valign:"middle",formatter: function (value, row, index) {return index+1;}}, 		
					{field:"relationMainName",title: '主体名称',align: 'center',valign:"middle",sortable:"true",formatter: function (value, row, index) { return row.relationMainName;}},
					{field:"relationTypeName",title: '关系类型',align: 'center',sortable:"true",valign:"middle",formatter: function (value, row, index) { return row.relationTypeName;}},
					{field:"clientName",title: '主体客户',align: 'center',sortable:"true",valign:"middle",formatter: function (value, row, index) { return row.clientName;}},
					{field:"clientList",title: '关联企业',align: 'center',valign:"middle",formatter: function (value, row, index) {
							var list = row.cmlist;
							var clientList = "";
							$(list).each(function(index,client){
								clientList += "<a class='btn_client_view' client_ID='"+client.client_ID+"' href='javascript:void(0)'>"+ client.clientName + ",</a><br/>";
							});
							return clientList;
						},
						//企业名称绑定事件
						events:{
							'click .btn_client_view' : function(e, value, row, index) {
								$.zjm_relationMain.viewCompanyClient($(this).attr("client_ID"));
							}
						}
					},
				{field:"unit_uidName",title: '项目类型',align: 'center',valign:"middle",sortable:"true",formatter: function (value, row, index) { return row.projectTypeName;}},
//					{field:"remark",title: '备注',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.remark;}},
					{title: '操作',align: 'center',valign:"middle",formatter:function(value,row,index){
							return ['<button class="btn_relationMain_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_relationMain_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_relationMain_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_relationMain_view': function(e, value, row, index) {
								$.zjm_relationMain.viewRelationMain(row);
							},
							'click .btn_relationMain_edit': function(e, value, row, index) {
								$.zjm_relationMain.editRelationMain(row);
							},
							'click .btn_relationMain_del': function(e, value, row, index) {
								$.zjm_relationMain.delOneRelationMain(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
				var clientList = "";
				$(row.cmlist).each(function(index,client){
					if(index==0){
						clientList = client.clientName;
					}else{
						clientList += "<br/>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+client.clientName;
					}
				});
			    var html = [];
//			        html.push('<p><b>序号：</b> ' + (index+1) + '</p>');
			        html.push('<p><b>主体名称：</b> ' + row.relationMainName + '</p>');
			        html.push('<p><b>关系类型：</b> ' + (row.relationType=="01"?"集团关系":"关联关系") + '</p>');
			        html.push('<p><b>主体客户：</b> ' + row.clientName + '</p>');
			        html.push('<p><b>关联企业：</b> ' + clientList + '</p>');	
			      /*  html.push('<p><b>机构名称：</b> ' + row.unit_uidName + '</p>');	*/
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
			url: "/selectRelationMainPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				if(params.searchText != undefined){
					condition = undefined;
				}
				var queryCondition={};
				$.extend(params,{"queryCondition":condition,"wheresql":" and finishDate is null "});
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
	
	/**点击“删除所选”时 批量删除关联主体***/
	function delBatchRelationMain(){
		//selectContent[0].unit_uid能获取到，说明$(table).bootstrapTable('getSelections')方法，获取的不是选中行的所有内容，而是要往行内填充数据的数据源对象
		var selectContent = $('#relationMain-table').bootstrapTable('getSelections');	
		var ids = [];
		for(var i=0;i<selectContent.length;i++){
			ids[i] = selectContent[i].relationMain_ID;
		}
		$.zjm_relationMain.delRelationMain(ids);
	}
	/**点击每一行后面的删除图标时 删除单个关联主体***/
	function delOneRelationMain(row){
		var ids = [row.relationMain_ID]
		$.zjm_relationMain.delRelationMain(ids);
	}
	
	/**删除关联主体 功能函数**/
	function delRelationMain(ids){
		$("#delRelationMain").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/batchDeleteRelationMainByIDs',data:JSON.stringify({"relationMainIDs":ids}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==true){
		        		$.zjm_relationMain.initTable();
						$("#delRelationMain").modal("hide");
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
		$("#delRelationMain").on("hidden.bs.modal", function (e) {	// 解除class="btn_submit"按钮的事件绑定，防止其他页面的按钮误动作
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**修改关联主体**/
	function editRelationMain(row){
		window.parent.openMenu('relationMainEdit'+row.relationMain_ID,'','修改关联主体','/crm/relationMain/relationMainAdd.jsp','&relationMain_ID='+row.relationMain_ID+'&type=edit');
	}
	
	/**查看关联主体**/
	function viewRelationMain(row){
	//	window.parent.openMenu('relationMainView'+row.relationMain_ID,'','查看关联主体','/crm/relationMain/relationMainView.jsp','&relationMain_ID='+row.relationMain_ID+'&type=view');
		$("#viewRelationMain").modal({keyboard:true});
		$.ajax({type:'POST',url:'/selectOneRelationMainById',data:JSON.stringify({"relationMain_ID":row.relationMain_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				var main = data.obj;
				$("#view_relationMainName").text(main.relationMainName);
				/*$("#view_guarantySum").text(main.guarantySum);
				$("#view_guarantyEntrustSum").text(main.guarantyEntrustSum);
				$("#view_entrustSum").text(main.entrustSum);*/
				$("#view_creditorSum").text(main.creditorSum);
				$("#view_projectType").text(main.projectTypeName);
				$("#view_relationType").text(main.relationTypeName);
				$("#view_clientName").text(main.clientName);
				$("#view_remark").text(main.remark);
				/*$("#view_unit_uidName").text(main.unit_uidName);*/
				if(main.cmlist.length!=0){
					var str = "";
					$(main.cmlist).each(function(index,company){
						if( index == main.cmlist.length-1 ){
							str += company.clientName;
						}else{
							str += company.clientName+"<br/><br/>";
						}
					});
					$("#view_relationCompany").html(str);
				}else{
					$("#view_relationCompany").html("&nbsp;");
				}
			}
		});
	}
	
	/**查看企业详情**/
	function viewCompanyClient(client_ID){
		window.parent.openMenu('view_companyClient'+client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+client_ID);
	}
	
	/**关联查询**/
	function relationQuery(){
		window.parent.openMenu('view_relationQuery','','关联查询','/crm/relationQuery/index.jsp','');
	}
	
	
	/**高级查询**/
	function hightSelect(){
		$("#relation_page").load("/relationSelectPage",'',function(response,status,xhr){
			$("#relationSelect").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){//点击查询按钮	
				if($("#relationSelect_form").validationEngine("validate")){
					var condition = $("#relationSelect_form").serializeJson();
					$("#relationSelect").modal("hide");
					initTable(condition);	
				}
			});
			$("#relationSelect").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 主体关联信息
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_relationMain.initTable();
	};
	$("#btn_refreshRelationMainTable").click(function(){
		$.zjm_relationMain.initTable();
	});
	
	//关联查询
	$("#btn_select").click(function(){
		$.zjm_relationMain.hightSelect();
	});
	
	
	$("#btn_add").click(function(){
		window.parent.openMenu('relationMainAdd','','新增关联主体','/crm/relationMain/relationMainAdd.jsp','&type=add');
	});
	$("#btn_del").click(function(){
		var e = $("input[name='btSelectItem']:checked");
		if(e.size() != 0){
			$.zjm_relationMain.delBatchRelationMain();
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
});


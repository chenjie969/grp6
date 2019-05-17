(function($,z){
	$.zjm_personDepot = {
		initTable:initTable,//初始化列表
		viewPersonDepot:viewPersonDepot,//查看个人咨询登记记录详情
		editPersonDepot:editPersonDepot,//修改一条个人咨询登记记录
		delPersonDepot:delPersonDepot,//删除一条个人咨询登记记录
		advancedQuery:advancedQuery,//高级查询
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#personDepot_table').bootstrapTable('destroy');
		$('#personDepot_table').bootstrapTable({
			method: 'get',
			columns: [{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
					{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 		
					{field:"applyNum",title: '申请编号',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applyNum;}},
					{field:"clientName",title: '申请人姓名',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.clientName;}},
					{field:"certificateCode",title: '身份证号码',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.certificateCode;}},
					{field:"busiTypeID",title: '业务品种',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.busiTypeName;}},
					{field:"applySum",title: '申请金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.applySum;}},
					{field:"periodMonthDay",title: '申请期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.periodMonthDay;}},
					{field:"cooperationID",title: '合作机构',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.cooperationName;}},
					{field:"clientSourceID",title: '客户来源',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.clientSourceName;}},
					{field:"phone",title: '手机',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.phone;}},
					{field:"receiveDate",title: '接待日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.receiveDate);}},
					{field:"receiveDeapartID",title: '接待部门',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.receiveDeapartName;}},
					{field:"receiveUserID",title: '接待人',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.receiveUserName;}},
					{title: '操作',align: 'center',formatter:function(value,row,index){
							return ['<button class="btn_personDepot_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
								'<button class="btn_personDepot_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
								'<button class="btn_personDepot_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
						},
						events:{
							'click .btn_personDepot_view': function(e, value, row, index) {
								$.zjm_personDepot.viewPersonDepot(row);
							},
							'click .btn_personDepot_edit': function(e, value, row, index) {
								$.zjm_personDepot.editPersonDepot(row);
							},
							'click .btn_personDepot_del': function(e, value, row, index) {
								$.zjm_personDepot.delPersonDepot(row);
							}
						}
					}],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
			        html.push('<p><b>申请人姓名：</b> ' + row.clientName + '</p>');
			        html.push('<p><b>身份证号码：</b> ' + row.certificateCode + '</p>');
			        html.push('<p><b>业务品种：</b> ' + row.busiTypeName + '</p>');
			        html.push('<p><b>申请金额：</b> ' + row.applySum + '万元</p>');
			        html.push('<p><b>申请期限：</b> ' + tool.isNull(row.periodMonthDay,"（空）") + '</p>');
			        html.push('<p><b>合作机构：</b> ' + row.cooperationName + '</p>');
			        html.push('<p><b>客户来源：</b> ' + row.clientSourceName + '</p>');
			        html.push('<p><b>手机：</b> ' + row.phone + '</p>');
			        html.push('<p><b>接待日期：</b> ' + tool.parseDate(row.receiveDate) + '</p>');
			        html.push('<p><b>接待部门：</b> ' + row.receiveDeapartName + '</p>');
			        html.push('<p><b>接待人：</b> ' + row.receiveUserName + '</p>');
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
			url: "/crm/apply/selectApplyPageTable",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition = {"apply_clientType":"02","apply_approvalStatu":"03"}; 
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
	
	/**查看一条个人咨询登记**/
	function viewPersonDepot(row){
		$("#personDepot_page").load("/crm/apply/personDepotViewPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#viewPersonDepot").modal({keyboard:true});
		});
	}
	
	/**修改一条个人咨询登记**/
	function editPersonDepot(row){
		$("#personDepot_page").load("/crm/apply/personDepotEditPage",{"apply_ID":row.apply_ID},function(response,status,xhr){
			$("#editPersonDepot").modal({keyboard:true});
			$.zjm_basicApply.initSelectTree();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_personDepot_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				var queryContainer_form = $("#edit_personDepot_form");
				tool.disabled(".btn_submit");
				if(queryContainer_form.validationEngine("validate")){
					if(zjm.ajaxValidata("edit_personDepotName","/crm/apply/isExistClientName",JSON.stringify(queryContainer_form.serializeJson()),"项目组名称重复！")){
						$.ajax({type:'POST',url:'/crm/apply/updateOneApply',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#editPersonDepot").modal("hide");
									$.zjm_personDepot.initTable();
								}else{
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
			$("#editPersonDepot").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**删除一条个人咨询登记**/
	function delPersonDepot(row){
		$("#personDepot_page").load("/crm/apply/personDepotDelPage",{},function(response,status,xhr){
			$("#delPersonDepot").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/crm/apply/deleteOneApply',data:JSON.stringify({"apply_ID":row.apply_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#delPersonDepot").modal("hide");
							$.zjm_personDepot.initTable();
						}else{
							alert("保存失败！");
						}
			        }
				});
			});
			$("#delPersonDepot").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**高级查询**/
	function advancedQuery(){
		$("#personDepot_page").load("/crm/apply/personDepotAdQuery",{},function(response,status,xhr){
			$("#personDepotAdQuery").modal({keyboard:true});
			/*初始化各个下拉选择树*/
			$.zjm_basicApply.initSelectTree();
			/*获取客户来源下拉框*/
			zjm.dataViewValSelect("select_clientSource", "/selectDicTypeListJSON", {"dicTypePID" : '3fafef23e87a4b9c99807207f618883d'});
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"personDepot_advancedQuery_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#personDepot_advancedQuery_form");
				if(queryContainer_form.validationEngine("validate")){
					$("#personDepotAdQuery").modal("hide");
					initTable($("#personDepot_advancedQuery_form").serializeJson());
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			
			$("#personDepotAdQuery").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
			
		});
	}
	
})(jQuery, this);

$(function () {
	$("#btn_personDepotAdQuery").click(function(){
		$.zjm_personDepot.advancedQuery();
	});
	$("#btn_refreshPersonDepotTable").click(function(){
		$.zjm_personDepot.initTable();
	});
	$("#btn_personDepot_agreeToAccept").click(function(){
		var selectContent = $("#personDepot_table").bootstrapTable('getSelections');
		if(selectContent.length == 1){
			$.zjm_basicApply.agreeToAccept("personDepot",selectContent);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
});


(function($,z){
	$.zjm_guarantyRec = {
		initColumn:initColumn,//初始化列，主要为了在&type='view'时实现修改和删除按钮的隐藏
		initTable:initTable,//初始化列表
		addGuarantyRec:addGuarantyRec,//新增对外担保	
		viewGuarantyRec:viewGuarantyRec,//查看对外担保	
		editGuarantyRec:editGuarantyRec,//修改对外担保	
		delGuarantyRec:delGuarantyRec//删除对外担保	
	};
	
	/**初始化列表项**/
	function initColumn(){
		var columns = [/*{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},*/
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:"guarantyUnit",title: '对外担保单位',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.guarantyUnit;}},
						{field:"guarantySum",title: '担保金额（万元）',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.guarantySum;}},
						{field:"period",title: '担保期限',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.period;}},
						{field:"begin&endDate",title: '起止日期',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.beginDate)+" 至 "+tool.parseDate(row.endDate);}},
//						{field:"eachOther",title: '互保企业',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.eachOther;}},
  					  ];
		var type = tool.getUrlParam('type');//获取路径类型:查看/修改
		if(type == 'edit'){		//&type='edit'显示查看、修改、删除按钮
			columns.push({title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_guarantyRec_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button class="btn_guarantyRec_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button class="btn_guarantyRec_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_guarantyRec_view': function(e, value, row, index) {
									$.zjm_guarantyRec.viewGuarantyRec(row);
								},
								'click .btn_guarantyRec_edit': function(e, value, row, index) {
									$.zjm_guarantyRec.editGuarantyRec(row);
								},
								'click .btn_guarantyRec_del': function(e, value, row, index) {
									$.zjm_guarantyRec.delGuarantyRec(row);
								}
							}
						});
		}else if(type == 'view'){	//&type='view' 只显示查看按钮
			columns.push({title: '操作',align: 'center',formatter:function(value,row,index){
								return ['<button class="btn_guarantyRec_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							},
							events:{
								'click .btn_guarantyRec_view': function(e, value, row, index) {
									$.zjm_guarantyRec.viewGuarantyRec(row);
								}
							}
						});
		}
		return columns;
	}
	
	/**初始化列表***/
	function initTable(){
		$('#table_guarantyRec').bootstrapTable('destroy');
		$('#table_guarantyRec').bootstrapTable({
			method: 'post',
			columns:initColumn() ,
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>对外担保单位：</b> ' + row.guarantyUnit + '</p>');
			        html.push('<p><b>担保金额：</b> ' + row.guarantySum + '万元</p>');
			        html.push('<p><b>担保期限：</b> ' + row.period + '</p>');
			        html.push('<p><b>起止日期：</b> ' + tool.parseDate(row.beginDate)+" 至 "+tool.parseDate(row.endDate) + '</p>');
//			        html.push('<p><b>互保企业：</b> ' + row.eachOther + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: false,      //是否启用排序
			sortGuarantyRec: "asc",     //排序方式
			/*pagination: true,     //设置为 true 会在表格底部显示分页条
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100, 200, 500],  //可供选择的每页的行数（*）*/			
			url: "/crm/guarantyRec/selectGuarantyRecPageTable",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition ={"client_ID":$("#client_ID").val()}; 
				$.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			/*search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: true,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:true,
			showExport: true,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'*/
		});
	}
	
	/**新增对外担保*/
	function addGuarantyRec(){
		$("#companyBusiness_page").load("/crm/guarantyRec/showGuarantyRecAddPage",{},function(response,status,xhr){
			/*注册日期控件点击事件*/
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			$("#add_guarantyRec_form input[name='client_ID']").val($("#client_ID").val());
			$("#addGuarantyRec").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_guarantyRec_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#add_guarantyRec_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/crm/guarantyRec/insertOneGuarantyRec',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#addGuarantyRec").modal("hide");
								$.zjm_guarantyRec.initTable();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#addGuarantyRec").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**查看对外担保*/
	function viewGuarantyRec(row){
		$("#companyBusiness_page").load("/crm/guarantyRec/showGuarantyRecViewPage",{"guarantyRec_ID":row.guarantyRec_ID},function(response,status,xhr){
			$("#viewGuarantyRec").modal({keyboard:true});
		});
	}
	
	/**修改对外担保*/
	function editGuarantyRec(row){
		$("#companyBusiness_page").load("/crm/guarantyRec/showGuarantyRecEditPage",{"guarantyRec_ID":row.guarantyRec_ID},function(response,status,xhr){
			/*注册日期控件点击事件*/
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			$("#editGuarantyRec").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_guarantyRec_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#edit_guarantyRec_form");
				if($(queryContainer_form).validationEngine("validate")){
					$.ajax({type:'POST',url:'/crm/guarantyRec/updateOneGuarantyRec',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
								$("#editGuarantyRec").modal("hide");
								$.zjm_guarantyRec.initTable();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#editGuarantyRec").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**删除对外担保*/
	function delGuarantyRec(row){
		$("#companyBusiness_page").load("/crm/guarantyRec/showGuarantyRecDelPage",{},function(response,status,xhr){
			$("#delGuarantyRec").modal({keyboard:true});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				$.ajax({type:'POST',url:'/crm/guarantyRec/deleteOneGuarantyRec',data:JSON.stringify({"guarantyRec_ID":row.guarantyRec_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',
					success:function(data) {
						if(data.obj){
							$("#delGuarantyRec").modal("hide");
							$.zjm_guarantyRec.initTable();
						}else{
							alert("删除失败！");
							tool.undisabled(".btn_submit");
						}
					}
				});
			});
			$("#delGuarantyRec").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
})(jQuery, this);

$(function () {	
	
	$("#btn_addGuarantyRec").click(function(){
		$.zjm_guarantyRec.addGuarantyRec();
	});
});


(function ($, z) {
    $.zjm_renewal = {
    		optGuarantyView:optGuarantyView,//查看一条保证措施
    		optGuarantyDel:optGuarantyDel,//删除一条保证措施
    		optGuarantyEdit:optGuarantyEdit,//编辑一条保证措施
    		initTable:initTable,//初始化反担保物数据
    		executeDel:executeDel,//具体执行删除操作
    		closeM:closeM,
    };
	/**初始化主体列表***/
	function initTable(data){
		$('#optManager_table').bootstrapTable('destroy');
		$('#optManager_table').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return }},
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'busiCode',title:'项目编号',sortable:"true",align:'center',formatter: function (value, row, index) {return row.busiCode;}},
						{field:'projectName',title:'项目名称',sortable:"true",align:'center',formatter: function (value, row, index) {return row.projectName;}},
						{field:'guarantyTypeName',title:'保证方式',sortable:"true",align:'center',formatter: function (value, row, index) {return row.guarantyTypeName;}},
						{field:'optTypeName',title:'反担保物类型',sortable:"true",align:'center',formatter: function (value, row, index) {return row.optTypeName;}},
						{field:'ownerName',title:'权属人',align:'center',formatter: function (value, row, index) {return row.ownerName;}},
						{field:'assessValue',title:'评估价值<br>（万元）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.assessValue;}},
						{field:'coverageRatio',title:'抵（质）押率<br>（%）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.coverageRatio==null?'-':row.coverageRatio.toFixed(2);}},
						{field:'optValue',title:'抵（质）押价值<br>（万元）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.optValue ;}},
						{
							field : 'isWorkable',
							title : '是否已落实',
							sortable : "true",
							align : 'center',
							formatter : function(value, row, index) {
								 if(row.isWorkable == 1){
									 return ['<a href=javascript:void(0) id="isWorkable" title="查看落实详情">是</a>'].join('');
								 }else{
									 return '否';
								 }
							},
							events:{
								'click #isWorkable':function(e, value, row, index){
									$.zjm_renewal.isWorkableView(row);
								}
							}
						},
						{title: '操作',align: 'center',formatter:function(value,row,index){
							if (type == 'edit') {
								return ['<button title="查看" class="btn_optGuaranty_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
									'<button title="修改"  class="btn_optGuaranty_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
									'<button title="删除"   class="btn_optGuaranty_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>' ].join('');
							}else{
								return ['<button title="查看" class="btn_optGuaranty_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'].join('');
							}
							},
							events:{
								'click .btn_optGuaranty_view': function(e, value, row, index) {
									$.zjm_renewal.optGuarantyView(row);
								},
								'click .btn_optGuaranty_edit': function(e,value, row , index){
									$.zjm_renewal.optGuarantyEdit(row);
								},
								'click .btn_optGuaranty_del' : function(e,value, row ,index ){
									$.zjm_renewal.optGuarantyDel(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>项目编号：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>项目名称：</b> ' + row.projectName + '</p>');
				    html.push('<p><b>保证方式：</b> ' + row.guarantyTypeName+ '</p>');
				    html.push('<p><b>反担保物类型：</b> ' + tool.isNull(row.optTypeName,'（空）')+ '</p>');
				    html.push('<p><b>权属人：</b> ' + row.ownerName + '</p>');
				    html.push('<p><b>评估价值：</b> ' + tool.isNull(row.assessValue,'（空）') +'万元'+ '</p>');
				    html.push('<p><b>抵（质）押率：</b> ' + tool.isNull(row.coverageRatio,'（空）') +'%'+ '</p>');
				    html.push('<p><b>抵（质）押价值：</b> ' + tool.isNull(row.optValue,'（空）') +'万元'+'</p>');
				    html.push('<p><b>是否已落实：</b> ' + (row.isWorkable==1?'是':'否') + '</p>');
		        return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/optGuarantyAction/selectOptGuarantyPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"isFree":0,"isDispose":0,"apply_ID":$("#apply_ID").val()};
			//	var queryCondition = {};
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
            exportDataType: "basic",              //basic', 'all', 'selected'
            	
        	onLoadSuccess: function () {
//        		$.zjm_creditApply.mergeCells();
        	}
		});
	}
	/**
	 * 查看 一条担保措施
	 */
	function optGuarantyView(row){
		window.parent.openMenu('view_OptGuaranty'+row.optGuaranty_ID,'','查看保证措施','/optGuarantyAction/selectOneOptGuarantyInfo',
				'&apply_ID='+row.apply_ID+'&guarantyTypeID='+row.guarantyTypeID+'&optTypeID='+row.optTypeID+
				'&optGuaranty_ID='+row.optGuaranty_ID+"&depositTypeId="+row.depositTypeId+'&pageFlag=view'
			);
		
	}
	
	/**
	 * 编辑 一条担保措施
	 */
	function optGuarantyEdit(row){
	//	window.parent.openMenu('view_creditApply_'+row.apply_ID,'','查看授信申请信息','/project/credit/viewOneCreditApply','&apply_ID='+row.apply_ID);
		window.parent.openMenu('update_OptGuaranty'+row.optGuaranty_ID,'','修改保证措施','/optGuarantyAction/updateOptGuarantyPage',
				'&apply_ID='+row.apply_ID+'&guarantyTypeID='+row.guarantyTypeID+'&optTypeID='+row.optTypeID+
				'&optGuaranty_ID='+row.optGuaranty_ID+'&pageFlag=edit'+'&type=edit'
				);
	}
	
	/**
	 * 删除 一条担保措施
	 */
	function optGuarantyDel(row){
		$("#optGuaranty_page").load("/optGuarantyAction/deleteOptGuarantyPage",{},function(response,status,xhr){
			$("#deleteOptGuarantyPage").modal({keyboard:true}); 
			$.zjm_renewal.executeDel(row);
		});
	}
	/**
	 * 具体执行删除操作的函数
	 */
	function executeDel(row){
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/optGuarantyAction/deleteOneOptGuarantyInfo',
				data: {'optGuaranty_ID':row.optGuaranty_ID},
//				contentType : 'application/json; charset=UTF-8',
				contentType : 'application/x-www-form-urlencoded',
				dataType : 'json',
				success : function(data) {
					if (data.obj == true) {
						$("#deleteOptGuarantyPage").modal("hide");
						$.zjm_optManager.initTable()
					} else {
						$("#failDel").modal({keyboard:true});
					}
				}
			});
		});
		$("#deleteOptGuarantyPage").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$(".btn_submit").unbind("click");
		});
	}
	
	function closeM(){
		window.parent.closeMenu($("#apply_ID").val());
		window.location.reload();
	}
})(jQuery, this);


$(function () {
	
	window.onload = function(){
		
	}
	$(".btn_close").click(function(){
		debugger
		window.parent.closeMenu($("#apply_ID").val());
		window.location.reload();
	});
})


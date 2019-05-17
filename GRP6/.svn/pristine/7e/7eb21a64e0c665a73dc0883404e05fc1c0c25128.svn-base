(function($,z){
	$.zjm_arcMoveList = {
			initTable:initTable,//初始化列表
			arcMoveAccept:arcMoveAccept,//确认接收
			initColumns:initColumns//初始化列表项
			
	};
	
	/**初始化列表***/
	function initTable(data){
		$('#arcMoveList_table').bootstrapTable('destroy');
		$('#arcMoveList_table').bootstrapTable({
			method: 'post',
			columns: initColumns(),
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/arcMove/selectArcMovePageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				 var queryCondition ={
						 "apply_ID":$("#apply_ID").val(),
						 "arcMoveRec_ID":$("#arcMoveRec_ID").val(),
						 "isMove":1
						 }; 
				 $.extend(queryCondition,data);
				 $.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
//			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
//			strictSearch: true,//设置为 true启用 全匹配搜索，否则为模糊搜索
//			showColumns: true,     //是否显示所有的列
//			showRefresh: true,     //是否显示刷新按钮
//			minimumCountColumns: 2,    //最少允许的列数
//			clickToSelect: false,    //是否启用点击选中行
//			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
//			showToggle: true,//是否显示详细视图和列表视图的切换按钮
//			showPaginationSwitch:true,
//            showExport: true,                     //是否显示导出
//            exportDataType: "basic"              //basic', 'all', 'selected'
		});
	}
	
	/**初始化列表项***/
	function initColumns(condition){
		var columns = [
			//{field:'checked',checkbox:true,align:'center',formatter: function (value, row, index) {return ;}},
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'arcTypeName',title:'档案类别 ',sortable : "true",align:'center',formatter: function (value, row, index) {return row.arcTypeName;}},
			{field:'fileTitleName',title:'文件标题（内容）',sortable : "true",align:'center',formatter: function (value, row, index) {return row.fileTitleName;}},
			//{field:'busiCode',title:'移交日期',align:'center',sortable : "true",formatter: function (value, row, index) {return tool.parseDate(row.stopDate);}},
			{field:'pageCount',title:'页数',align:'center',sortable : "true",formatter: function (value, row, index) {return row.pageCount;}},
			{field:'pageNumber',title:'页码',align:'center',sortable : "true",formatter: function (value, row, index) {return row.pageNumber+"至"+row.pageNumberEnd;}},
			{field:'isOriginal',title:'是否原件',align:'center',sortable : "true",formatter: function (value, row, index) { if(row.isOriginal){return "是"}else{return "否"};}},
			{field:'isAll',title:'是否全部移交',align:'center',sortable : "true",formatter: function (value, row, index) {if(row.isAll){return "是"}else{return "否"};}},
			{field:'remark',title:'备注',align:'center',sortable : "true",formatter: function (value, row, index) {return row.remark;}},							
			{field:'status',title:'移交状态',align:'center',sortable : "true",formatter: function (value, row, index) {return row.status;}},
			{field:'acceptStatus',title:'接收状态',align:'center',sortable : "true",formatter: function (value, row, index) {return row.acceptStatus;}}
		
			/*{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				
				return ['<button class="btn_projectApply_view btn btn-xs btn-warning" title="查看" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
					'<button class="btn_projectApply_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_projectApply_view': function(e, value, row, index) {
						$.zjm_arcMoveList.viewModule(row);
					},
					'click .btn_projectApply_del': function(e, value, row, index) {
						$.zjm_arcMoveList.delOneProjectApply(row);
					}
				}
			}*/
		];
		return columns;
	}
	//确认接收:
	function arcMoveAccept(){
		
		var arcMoveRec_ID = $("#arcMoveRec_ID").val();
		$("#arMoveIndex_page").load("/project/arcMove/returnArcMoveAcceptPage",{"arcMoveRec_ID":arcMoveRec_ID},function(response,status,xhr){
			$("#arcMoveAccept").modal({keyboard:true});
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {		
				$("#acceptUserName").selectTreeWidgets({
					width : "46%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	          }
	        });
			$('#acceptDate').attr("value",tool.parseDate(new Date().getTime()));//yyyy-mm-dd .fromat("yyyy-MM-dd")
			
			zjm.init();
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"arcMoveAccept_form"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#arcMoveAccept_form");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/arcMove/arcMoveAccept",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								$("#arcMoveAccept").modal("hide");
								$.zjm_arcMoveList.initTable();
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#arcMoveAccept").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	
	}
	
})(jQuery, this);

$(function () {
	var type = $("#type1").val();//获取实现办理路径类型:查看操作
	var operationType = $("#operationType").val();//获取实现办理类型:查看操作
	if('add' == operationType && 'edit' == type || ('view' == type)){
		$("#btn_arcMoveAccept").hide();//查看时隐藏接收按钮
	}
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_arcMoveList.initTable();
	//重置申请列表;
	$("#btn_refreshApplyTable").click(function(){
		$.zjm_arcMoveList.initTable();
	});
	$("#btn_arcMoveAccept").click(function(){
		$.zjm_arcMoveList.arcMoveAccept();
	});
});


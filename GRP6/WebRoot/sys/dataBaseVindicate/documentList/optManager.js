/**
 * 保证措施管理---js
 * author: wuhn
 * 2017年7月11日 15:25:25
 */

(function($,z){
	window.optManager={
		refreshTable:refreshTable,
	};
	
	function refreshTable(){
		$.zjm_optManager.initTable();
	}
	
	$.zjm_optManager = {
		initTable:initTable,	//初始化列表
		mergeCells:mergeCells,	//合并单元格
		addOptGuaranty:addOptGuaranty,	//保证措施管理 --- 新增 保证措施
		highOptQuery:highOptQuery //保证措施管理 -- 高级查询
	
		
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#optManager_table').bootstrapTable('destroy');
		$('#optManager_table').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'checked',checkbox:false,align:'center',formatter: function (value, row, index) {return }},
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
									{
										field : 'busiCode',
										title : '文档类型',
										sortable : "true",
										align : 'center',
										formatter : function(value, row, index) {
											var bb="";
											$.each(row,function(k,v){
												bb=k;
											});
											return bb;
										}
									},
									{
										field : 'projectName',
										title : '文档名称',
										sortable : "true",
										align : 'center',
										formatter : function(value, row, index) {
											var bb="";
											$.each(row,function(k,v){
												bb=v;
											});
											return bb;
										}
									},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
										'<button class="btn_optGuaranty_edit btn btn-xs btn-info" title="生成合同" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
										'<button class="btn_optGuaranty_view btn btn-xs btn-warning" title="查看合同" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
										'<button class="btn_optGuaranty_del btn btn-xs btn-warning" title="下载合同" href="javascript:void(0)"><i class="icon-download-alt bigger-120"></i></button>' ].join('');
							},
							events:{
								'click .btn_optGuaranty_view': function(e, value, row, index) {
									$.zjm_optManager.optGuarantyView(row);
								},
								'click .btn_optGuaranty_edit': function(e,value, row , index){
									$.zjm_optManager.optGuarantyEdit(row);
								},
								'click .btn_optGuaranty_del' : function(e,value, row ,index ){
									$.zjm_optManager.optGuarantyDel(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>项目编号：</b> ' + tool.isNull("",'（空）') + '</p>');
				    html.push('<p><b>项目名称：</b> ' +  + '</p>');
				    html.push('<p><b>保证方式：</b> ' + + '</p>');
				    html.push('<p><b>反担保物类型：</b> ' + tool.isNull("",'（空）')+ '</p>');
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
			url: "/documentAction/selectOptGuarantyPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
			
				console.info(params);
				
				var queryCondition = {"isFree":0,"isDispose":0};
				console.info(queryCondition);
				
				$.extend(queryCondition,data);
				console.info(data);
				
				$.extend(params, {"queryCondition":queryCondition});
				
				console.info(params);
				
				
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
	 * 合并单元格 
	 */
	function mergeCells(){
		$('#optManager_table').bootstrapTable('mergeCells', {
            index: 2,
            field: 'creditBH',
            rowspan: 2,
        });
	}
	
	/**
	 * 新增 担保措施
	 */
	function addOptGuaranty(){
		/*$("#optGuaranty_page").load("/optGuarantyAction/addOptGuarantyPage",{},function(response,status,xhr){
			$("#optGuarantyAddPage").modal({keyboard:true}); 
		});	*/
		
		var array = $("input[name='choose']:checked");
		var dd=[];
		$.each(array,function(k,v){
			// dd.push($(this).val());
			dd[k]=$(this).val();
		});
		var data={"choose":dd.join(",")};
	//	var data = $("#choose").serializeJson();
		initTable(data);
	}
	
	
	/**
	 * 保证措施管理 -- 高级查询
	 */
	function highOptQuery (){
		$("#optGuaranty_page").load("/optGuarantyAction/highOptQueryPage",{},function(response,status,xhr){
			$("#highOptQueryPage").modal({keyboard:true}); 
			
			/**获取创建人 下拉树 */
			$.ajax({
				type : 'POST',
				url : '/sys/dic/selectDepartsUserTree',
				data : JSON.stringify({}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					// 原档案接收人，下拉树
					$("#txt_id1").selectTreeWidgets({
						width : "26%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj
					//数据源
					});
				}
			});
			
			
			//经办部门下拉树
			$.ajax({
				type : 'POST',
				url : '/selectAllDepartsListTree',
				data : JSON.stringify({}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					$("#allDepartsTree1").selectTreeWidgets({
						width : "46%",// 设置控件宽度
						multiple : false,// 是否多选
						data : data.obj
					// 数据源
					});
				}
			});
			
			$("#btn_submit").click(function(){
				if($("#form_highOptQuery").validationEngine("validate")){
					var condition = $("#form_highOptQuery").serializeJson();
					$("#highOptQueryPage").modal("hide");
					$.zjm_optManager.initTable(condition);	
				}
			})
			
			
		});
	}
	
	
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	window.onload = floaddata;
	function floaddata() {
		$.zjm_optManager.initTable();
	};
	
	
	/**
	 * 新增担保措施
	 */
	$("#btn_addOptGuaranty").click(function(){
		// window.parent.openMenu('add_optManager','','授信申请登记','/project/credit/showCreditApplyAddPage','');
		$.zjm_optManager.addOptGuaranty();
	});
	
	
});


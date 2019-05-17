
(function($,z){
	$.putStock={
		initTable:initTable, //初始化列表
		putStockSubmit:putStockSubmit //保存列表
		
	};
	
	
	function initTable(){
		$('#opt_table').bootstrapTable('destroy');
		$('#opt_table').bootstrapTable({
			method: 'post',
			columns: [	
					{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
					{field:'projectName',title:'项目名称',sortable:"true",align:'center',formatter: function (value, row, index) {return row.projectName;}},
					{field:'pledgeDepart',title:'抵（质）物登记机关',sortable:"true",align:'center',formatter: function (value, row, index) {return row.pledgeDepart;}},
					{field:'realizeDate',title:'登记日期',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.realizeDate);}},
					{field:'pledgeFileCount',title:'份数',sortable:"true",align:'center',formatter: function (value, row, index) {return row.pledgeFileCount;}},
					{field:'guarantyTypeName',title:'经办人',sortable:"true",align:'center',formatter: function (value, row, index) {return row.realizeUserName;}},
					{field:'assessValue',title:'扫描件',sortable:"true",align:'center',formatter: function (value, row, index) {return '房产证';}},
					{field:'coverageRatio',title:'保管状态',sortable:"true",align:'center',formatter: function (value, row, index) {return row.custodyStatus;}},
				],
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号：</b> ' +(index+1)+ '</p>');
			    	html.push('<p><b>项目名称：</b> ' +(index+1)+ '</p>');
				    html.push('<p><b>抵（质）物登记机关：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>登记日期：</b> ' + row.guarantyTypeName+ '</p>');
				    html.push('<p><b>份数：</b> ' + tool.isNull(row.optTypeName,'（空）')+ '</p>');
				    html.push('<p><b>经办人：</b> ' + row.ownerName + '</p>');
				    html.push('<p><b>入库日期：</b> ' + tool.isNull(row.assessValue,'（空）') +'万元'+ '</p>');
				    html.push('<p><b>入库经办人：</b> ' + tool.isNull(row.coverageRatio,'（空）') +'%'+ '</p>');
				    html.push('<p><b>扫描件：</b> ' + tool.isNull(row.optValue,'（空）') +'万元'+'</p>');
				    html.push('<p><b>保管状态：</b> ' + (row.isWorkable==1?'是':'否') + '</p>');
		        return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "desc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/optGuarantyAction/selectOptGuarantyPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"isWorkable":1,"optGuaranty_ID":$("#optGuaranty_IDS").text()};
				$.extend(params, {"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		});
		
	}
	
	/**
	 * 保存
	 */
	function putStockSubmit(){
		var $form=$("#form_putStock");
		var formData=JSON.stringify($form.serializeJson());
		$.ajax({
			url:'/optGuarantyAction/putStockExecut',
			type:'POST',
			contentType:'application/json;charset=UTF-8',
			data:formData,
			dataType:'json',
			success: function(data){
				if(data.obj){
					$("#putStockPage").modal("hide");
					$.zjm_pledgeManager.zaikuInitTable();
				}
			}
		});
		$("#putStockPage").on("hidden.bs.modal", function(e) {// 解除事件绑定
			$("#btn_putStock").unbind("click");
		});
	}
	
})(jQuery,this);

	$(function(){
		/**
		 * 初始化列表
		 */
		$.putStock.initTable();
		
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
		$("#putStockDate").val(tool.parseDate(new Date().getTime()));
		
		/**获取创建人 下拉树 */
		$.ajax({
			type : 'POST',
			url : '/sys/dic/selectDepartsUserTree',
			data : JSON.stringify({}),
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				
				$("#txt_id2").selectTreeWidgets({
					width : "26%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj
				//数据源
				});
				
				// 原档案接收人，下拉树
				$("#txt_id1").selectTreeWidgets({
					width : "26%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj
				//数据源
				});
			}
		});
		
		
		
		/**
		 * 保存
		 */
		$("#btn_putStock").click(function(){
			$.putStock.putStockSubmit();
		});
		
		
		
	});
	
	
	
	
	
	
	
	
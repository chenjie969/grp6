/**
 * 抵（质）押物原件管理---js
 * author: wuhn
 * 2017年7月11日 15:25:25
 */

(function($,z){
	
	$.zjm_pledgeManager = {
		initTable:initTable,	//初始化列表
		mergeCells:mergeCells,	//合并单元格
		addOptGuaranty:addOptGuaranty,	//保证措施管理 --- 新增 保证措施
		deleteOptGuaranty:deleteOptGuaranty ,//保证措施管理 -- 删除所选
		highOptQuery:highOptQuery ,//保证措施管理 -- 高级查询
		optGuarantyView:optGuarantyView , // 查看 一条保证措施
		optGuarantyEdit:optGuarantyEdit , // 修改一条保证措施
		optGuarantyDel:optGuarantyDel ,  // 删除一条保证措施
		executeDel:executeDel, // 具体执行删除的函数
		common_Content:common_Content, //公共部分内部函数 
		
	};
	
	/**初始化主体列表***/
	function initTable(data){
		$('#expireMessage_table').bootstrapTable('destroy');
		$('#expireMessage_table').bootstrapTable({
			method: 'post',
			singleSelect:true,
			columns: [	
						{field:'checkbox',title:'',checkbox:true,align:'center',formatter:function(value,row,index){return ;}},
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'projCount',title:'项目编号',sortable:"true",align:'center',formatter: function (value, row, index) {return row.projectCode;}},
						{field:'guarantyTypeName',title:'笔',align:'center',formatter: function (value, row, index) {return row.projCount==null?'':'第'+(row.projCount)+'笔';}},
						{field:'updateUserName',title:'办理人',align:'center',formatter: function (value, row, index) {return row.updateUserName;}},
						{field:'subBankName',title:'放款机构',sortable:"true",align:'center',formatter: function (value, row, index) {return row.subBankName;}},
						{field:'busiTypeName',title:'业务品种',align:'center',formatter: function (value, row, index) {return row.busiTypeName;}},
						{field:'guarantyDutySum',title:'担保金额（万元）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.guarantyDutySum;}},
						{field:'guarantySum',title:'在保余额（万元）',sortable:"true",align:'center',formatter: function (value, row, index) {return row.guarantySum;}},
						{field:'periodMonthDay',title:'担保期限',sortable:"true",align:'center',formatter: function (value, row, index) {return row.periodMonthDay ;}},
						{field:'loadBeginDate',title:'起始日期',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.loadBeginDate) ;}},
						{field:'loadEndDate',title:'到期日期',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.loadEndDate) ;}},
						{title: '状态',align: 'center',formatter:function(value,row,index){
								return index%2==0?'在保中':'即将到期';
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号：</b> ' +(index+1)+ '</p>');
				    html.push('<p><b>项目编号：</b> ' + tool.isNull(row.projectCode,'（空）') + '</p>');
				    html.push('<p><b>笔：</b> ' +( row.projCount==null?'（空）':('第'+(row.projCount)+'笔'))+ '</p>');
				    html.push('<p><b>办理人：</b> ' + tool.isNull(row.updateUserName,'（空）')+ '</p>');
				    html.push('<p><b>放款机构：</b> ' + tool.isNull(row.subBankName,'（空）') + '</p>');
				    html.push('<p><b>业务品种：</b> ' + tool.isNull(row.busiTypeName,'（空）') + '</p>');
				    html.push('<p><b>担保金额：</b> ' + tool.isNull(row.guarantyDutySum,'（空）') +'万元'+ '</p>');
				    html.push('<p><b>在保余额：</b> ' + tool.isNull(row.guarantySum,'（空）')+'万元'+'</p>');
				    html.push('<p><b>担保期限：</b> ' + row.periodMonthDay + '</p>');
				    html.push('<p><b>起始日期：</b> ' + tool.parseDate(row.loadBeginDate) + '</p>');
				    html.push('<p><b>到期日期：</b> ' + tool.parseDate(row.loadEndDate) + '</p>');
				    html.push('<p><b>状态：</b> ' + (index%2==0?'在保中':'即将到期') + '</p>');
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
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/project/selectProjectPageTables",//这个接口需要处理bootstrap table传递的固定参数
//			ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition = {"isFree":0,"isDispose":0};
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
	 * 合并单元格 
	 */
	function mergeCells(){
		$('#expireMessage_table').bootstrapTable('mergeCells', {
            index: 2,
            field: 'creditBH',
            rowspan: 2,
        });
	}
	
	/**
	 * 新增 担保措施
	 */
	function addOptGuaranty(){
		window.parent.openMenu('add_OptGuaranty','','新增保证措施','/optGuarantyAction/addOptGuarantyPage','&type=edit');
	}
	
	/**
	 * 公共部分内部函数 
	 */
	function common_Content(selectValue){
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
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
		
		$("#optGuaranty_ID").val(selectValue[0].optGuaranty_ID);
		$("#busiCode").text(selectValue[0].busiCode == null?'（空）':selectValue[0].busiCode);
		$("#projectName").text(selectValue[0].projectName== null?'（空）':selectValue[0].projectName);
		$("#guarantyTypeName").text(selectValue[0].guarantyTypeName== null?'（空）':selectValue[0].guarantyTypeName);
		$("#optTypeName").text(selectValue[0].optTypeName== null?'（空）':selectValue[0].optTypeName);
		$("#ownerName").text(selectValue[0].ownerName== null?'（空）':selectValue[0].ownerName);
		$("#assessValue").text(selectValue[0].assessValue== null?'（空）':selectValue[0].assessValue);
		$("#coverageRatio").text(selectValue[0].coverageRatio== null?'（空）':selectValue[0].coverageRatio);
		$("#optValue").text(selectValue[0].optValue== null?'（空）':selectValue[0].optValue);
		$("#isWorkables").text(selectValue[0].isWorkable == 1?'是':'否');

		//保证措施落实部分字段赋值
		$("#pledgeDepart").text(selectValue[0].pledgeDepart== null?'（空）':selectValue[0].pledgeDepart);
		$("#pledgeFile").text(selectValue[0].pledgeFile== null?'（空）':selectValue[0].pledgeFile);
		$("#optBeginDate").text(selectValue[0].optBeginDate== null?'（空）':tool.parseDate(selectValue[0].optBeginDate));
		$("#optEndDate").text(selectValue[0].optEndDate== null?'（空）':tool.parseDate(selectValue[0].optEndDate));
		$("#pledgeFileCount").text(selectValue[0].pledgeFileCount== null?'（空）':selectValue[0].pledgeFileCount);
		$("#receivePerson").text(selectValue[0].receivePerson== null?'（空）':selectValue[0].receivePerson);
		$("#realizeUserName").text(selectValue[0].realizeUserName== null?'（空）':selectValue[0].realizeUserName);
		$("#realizeDate").text(selectValue[0].realizeDate== null?'（空）':tool.parseDate(selectValue[0].realizeDate));
		
	}
	
	
	/**
	 * 保证措施管理 -- 删除所选
	 */
	function deleteOptGuaranty(){
		var selectValue = $('#expireMessage_table').bootstrapTable('getSelections');
		if(selectValue.length < 1){
			$("#pleaseSelectOne").modal({keyboard:true});
			return ;
		}
		$("#optGuaranty_page").load("/optGuarantyAction/deleteOptGuarantyPage",{},function(response,status,xhr){
			$("#deleteOptGuarantyPage").modal({keyboard:true}); 
			$.each(selectValue,function(key,value){
				$.zjm_pledgeManager.executeDel(value);
			});
		});
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
					$.zjm_pledgeManager.initTable(condition);	
				}
			})
			
			
		});
	}
	
	/**
	 * 查看 一条担保措施
	 */
	function optGuarantyView(row){
		window.parent.openMenu('view_OptGuaranty'+row.optGuaranty_ID,'','查看保证措施','/optGuarantyAction/selectOneOptGuarantyInfo',
				'&apply_ID='+row.apply_ID+'&guarantyTypeID='+row.guarantyTypeID+'&optTypeID='+row.optTypeID+
				'&optGuaranty_ID='+row.optGuaranty_ID+'&pageFlag=view'
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
			$.zjm_pledgeManager.executeDel(row);
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
						$.zjm_pledgeManager.initTable()
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
	
	
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_pledgeManager.initTable();
	
	/**
	 * 新增担保措施
	 */
	$("#btn_addOptGuaranty").click(function(){
		alert('添加 抵（质）押物原件管理 ' );
		// window.parent.openMenu('add_optManager','','授信申请登记','/project/credit/showCreditApplyAddPage','');
	//	$.zjm_pledgeManager.addOptGuaranty();
	});
	
	
	
});


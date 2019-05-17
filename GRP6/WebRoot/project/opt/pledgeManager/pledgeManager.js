/**
 * 抵（质）押物原件管理---js
 * author: wuhn
 * 2017年8月28日 15:57:14
 */

(function($,z){
	
	$.zjm_pledgeManager = {
		zaikuInitTable:zaikuInitTable,	//初始化列表---在库记录
		jiechuInitTable:jiechuInitTable,	//初始化列表---借出记录
		chukuInitTable:chukuInitTable,	//初始化列表---出库记录
		mergeCells:mergeCells,	//合并单元格
		common_Content:common_Content, //公共部分内部函数 
		putStock:putStock, //在库记录---入库
		loanStock:loanStock, //在库记录---借出
		outStock:outStock, //在库记录---出库
		zaikuRefresh:zaikuRefresh ,//在库记录---重置列表
		returnStock:returnStock ,//借出记录---归还
		jiechuRefresh:jiechuRefresh,//借出记录---重置列表
		backoutStock:backoutStock,//出库记录---撤销
		chukuRefresh:chukuRefresh //出库记录---重置列表
		
	};
	
	/**初始化列表---在库记录***/
	function zaikuInitTable(data){
		$('#pledgeManager_table').bootstrapTable('destroy');
		$('#pledgeManager_table').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'index',title:'',checkbox:true,align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'projectName',title:'项目名称',sortable:"true",align:'center',formatter: function (value, row, index) {return row.projectName;}},
						{field:'pledgeDepart',title:'抵（质）物登记机关',sortable:"true",align:'center',formatter: function (value, row, index) {return row.pledgeDepart;}},
						{field:'realizeDate',title:'登记日期',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.realizeDate);}},
						{field:'pledgeFileCount',title:'份数',sortable:"true",align:'center',formatter: function (value, row, index) {return row.pledgeFileCount;}},
						{field:'guarantyTypeName',title:'经办人',sortable:"true",align:'center',formatter: function (value, row, index) {return row.realizeUserName;}},
						{field:'putStockDate',title:'入库日期',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.putStockDate);}},
						{field:'putStockUserName',title:'入库经办人',align:'center',formatter: function (value, row, index) {return row.putStockUserName;}},
 						{
								field : 'assessValue',
								title : '扫描件',
								align : 'center',
								formatter : function(value, row, index) {
									var arr=row.filesList;
									if(arr.length > 0){
										var elements="";
										var arrayElemets=[];
										$.each(arr,function(k,v){
											elements="<a target='_blank'  title='查看附件' href='"+v.pathFile+"'>"+v.sourceFileName+"</a> <br>"
											arrayElemets.push(elements);
										});
										return arrayElemets.join("");
									}else{
										return '-';
									}
								}
							},
						{field:'custodyStatus',title:'保管状态',sortable:"true",align:'center',formatter: function (value, row, index) {return row.custodyStatus;}},
						/*{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
										'<button title="查看"  class="btn_optGuaranty_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
										 ].join('');
							},
							events:{
								'click .btn_optGuaranty_edit': function(e,value, row , index){
								//	$.zjm_pledgeManager.optGuarantyEdit(row);
								},
							}
						}*/
					],
			detailView: true,
			detailFormatter:function(index, row){
				function  getScanFile(){
					var arr=row.filesList;
					if(arr.length > 0){
						var elements="";
						var arrayElemets=[];
						$.each(arr,function(k,v){
							elements="<a target='_blank' title='查看附件' href='"+v.pathFile+"'>"+v.sourceFileName+"</a> <br>"
							arrayElemets.push(elements);
						});
						return arrayElemets.join("");
					}else{
						return '-';
					}
				}
			    var html = [];
			    	html.push('<p><b>序号：</b> ' +(index+1)+ '</p>');
			    	html.push('<p><b>项目名称：</b> ' +(row.projectName)+ '</p>');
				    html.push('<p><b>抵（质）物登记机关：</b> ' +row.pledgeDepart + '</p>');
				    html.push('<p><b>登记日期：</b> ' + tool.parseDate(row.realizeDate) + '</p>');
				    html.push('<p><b>份数：</b> ' + row.pledgeFileCount + '</p>');
				    html.push('<p><b>经办人：</b> ' + row.realizeUserName + '</p>');
				    html.push('<p><b>入库日期：</b> ' + tool.isNull(tool.parseDate(row.putStockDate),'（空）')+ '</p>');
				    html.push('<p><b>入库经办人：</b> ' + tool.isNull(row.putStockUserName,'（空）') + '</p>');
				    html.push('<p><b>扫描件：</b> <br>' +getScanFile()+'</p>');
				    html.push('<p><b>保管状态：</b> ' + row.custodyStatus + '</p>');
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
				var queryCondition = {"isWorkable":1,"apply_ID":$("#apply_ID").val()};
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
	
	/**初始化借出记录列表*/
	function jiechuInitTable(data){
		$('#loanStock_table').bootstrapTable('destroy');
		$('#loanStock_table').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'index',title:'',checkbox:true,align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'busiCode',title:'借出人',sortable:"true",align:'center',formatter: function (value, row, index) {return '北京市城乡建设委员会';}},
						{field:'projectName',title:'借出原因',sortable:"true",align:'center',formatter: function (value, row, index) {return '2017-8-22';}},
						{field:'guarantyTypeName',title:'预计归还时间',sortable:"true",align:'center',formatter: function (value, row, index) {return '王安石';}},
						{field:'optTypeName',title:'借出经办人',sortable:"true",align:'center',formatter: function (value, row, index) {return '2017-8-23';}},
						{field:'ownerName',title:'借出日期',align:'center',formatter: function (value, row, index) {return '李三琦';}},
						{field:'assessValue',title:'归还入库经办人',sortable:"true",align:'center',formatter: function (value, row, index) {return '房产证';}},
						{field:'optValue',title:'归还日期',sortable:"true",align:'center',formatter: function (value, row, index) {return '（空）' ;}},
						{field:'coverageRatio',title:'保管状态',sortable:"true",align:'center',formatter: function (value, row, index) {return index%2==0?'外借中':'已归还';}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
										'<button title="修改"  class="btn_optGuaranty_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
										 ].join('');
							},
							events:{
								'click .btn_optGuaranty_edit': function(e,value, row , index){
								//	$.zjm_pledgeManager.optGuarantyEdit(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号：</b> ' +(index+1)+ '</p>');
				    html.push('<p><b>借出人：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>借出原因：</b> ' + row.projectName + '</p>');
				    html.push('<p><b>预计归还时间：</b> ' + row.guarantyTypeName+ '</p>');
				    html.push('<p><b>借出经办人：</b> ' + tool.isNull(row.optTypeName,'（空）')+ '</p>');
				    html.push('<p><b>借出日期：</b> ' + row.ownerName + '</p>');
				    html.push('<p><b>归还入库经办人：</b> ' + tool.isNull(row.assessValue,'（空）') +'万元'+ '</p>');
				    html.push('<p><b>归还日期：</b> ' + tool.isNull(row.coverageRatio,'（空）') +'%'+ '</p>');
				    html.push('<p><b>保管状态：</b> ' + (row.isWorkable==1?'外借中':'已归还') + '</p>');
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
				var queryCondition = {"isFree":0,"isDispose":0};
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
	
	/**初始化 出库记录列表 */
	function chukuInitTable(data){
		$('#out_table').bootstrapTable('destroy');
		$('#out_table').bootstrapTable({
			method: 'post',
			columns: [	
						{field:'index',title:'',checkbox:true,align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
						{field:'busiCode',title:'项目名称',sortable:"true",align:'center',formatter: function (value, row, index) {return '中投保信息技术有限公司';}},
						{field:'busiCode',title:'抵（质）物登记机关',sortable:"true",align:'center',formatter: function (value, row, index) {return '北京市城乡建设委员会';}},
						{field:'projectName',title:'登记日期',sortable:"true",align:'center',formatter: function (value, row, index) {return '2017-8-22';}},
						{field:'guarantyTypeName',title:'份数',sortable:"true",align:'center',formatter: function (value, row, index) {return '22';}},
						{field:'guarantyTypeName',title:'落实经办人',sortable:"true",align:'center',formatter: function (value, row, index) {return '王安石';}},
						{field:'optTypeName',title:'入库日期',sortable:"true",align:'center',formatter: function (value, row, index) {return '2017-8-23';}},
						{field:'ownerName',title:'入库经办人',align:'center',formatter: function (value, row, index) {return '李三琦';}},
						{field:'optTypeName',title:'出库日期',sortable:"true",align:'center',formatter: function (value, row, index) {return '2017-8-23';}},
						{field:'ownerName',title:'出库经办人',align:'center',formatter: function (value, row, index) {return '李三琦';}},
						{field:'ownerName',title:'出库交接人',align:'center',formatter: function (value, row, index) {return '李三琦';}},
						{field:'assessValue',title:'扫描件',sortable:"true",align:'center',formatter: function (value, row, index) {return '房产证';}},
						{title: '操作',align: 'center',formatter:function(value,row,index){
								return [
										'<button title="修改"  class="btn_optGuaranty_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button>',
										 ].join('');
							},
							events:{
								'click .btn_optGuaranty_edit': function(e,value, row , index){
								//	$.zjm_pledgeManager.optGuarantyEdit(row);
								}
							}
						}
					],
			detailView: true,
			detailFormatter:function(index, row){
			    var html = [];
			    	html.push('<p><b>序号：</b> ' +(index+1)+ '</p>');
			    	html.push('<p><b>项目名称：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>抵（质）物登记机关：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>登记日期：</b> ' + row.projectName + '</p>');
				    html.push('<p><b>份数：</b> ' + row.guarantyTypeName+ '</p>');
				    html.push('<p><b>落实经办人：</b> ' + tool.isNull(row.optTypeName,'（空）')+ '</p>');
				    html.push('<p><b>入库日期：</b> ' + row.ownerName + '</p>');
				    html.push('<p><b>入库经办人：</b> ' + tool.isNull(row.assessValue,'（空）') +'万元'+ '</p>');
				    html.push('<p><b>出库日期：</b> ' + tool.isNull(row.coverageRatio,'（空）') +'%'+ '</p>');
				    html.push('<p><b>出库经办人：</b> ' + tool.isNull(row.optValue,'（空）') +'万元'+'</p>');
				    html.push('<p><b>出库交接人：</b> ' + tool.isNull(row.optValue,'（空）') +'万元'+'</p>');
				    html.push('<p><b>扫描件：</b> ' + (row.isWorkable==1?'是':'否') + '</p>');
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
		$('#pledgeManager_table').bootstrapTable('mergeCells', {
            index: 2,
            field: 'creditBH',
            rowspan: 2,
        });
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
	}
	
	/**
	 * 获取列表选中的行数
	 */
	function getSelectValue(){
		var secVal=$('#pledgeManager_table').bootstrapTable("getSelections");
		if(secVal.length < 1){
			$("#pleaseSelectOne").modal({keyboard:true});
			return;
		}else{
			return secVal;
		}
	}
	
	/**
	 * 在库记录---入库
	 */
	function putStock(){
		var secVal=getSelectValue();
		if(secVal == undefined){
			return;
		}
		var arr=[];
		$.each(secVal,function(k,v){
			arr.push(v.optGuaranty_ID);
		});
		
		$("#pledgeManager_page").load("/optGuarantyAction/putStockPage",{"optGuaranty_IDS":arr.join(",")},function(){
			$("#putStockPage").modal({keyborad:true});
		});
	}
	
	
	/**
	 * 在库记录---借出
	 */
	function loanStock(){
		var secVal=getSelectValue();
		if(secVal == undefined){
			return;
		}
		$("#pledgeManager_page").load("/optGuarantyAction/loanStockPage",{},function(){
			
		});
	}
	
	
	/**
	 * 在库记录---出库
	 */
	function outStock(){
		var secVal=getSelectValue();
		if(secVal == undefined){
			return;
		}
		$("#pledgeManager_page").load("/optGuarantyAction/outStockPage",{},function(){
			
		});
	}
	
	
	/**
	 * 在库记录---重置列表
	 */
	function zaikuRefresh (){
		$.zjm_pledgeManager.zaikuInitTable();
	}
	
	
	/**
	 * 借出记录---归还
	 */
	function returnStock (){
		var secVal=getSelectValue();
		if(secVal == undefined){
			return;
		}
		$("#pledgeManager_page").load("/optGuarantyAction/returnStockPage",{},function(){
			
		});
	}
	
	
	/**
	 * 借出记录---重置列表
	 */
	function jiechuRefresh(){
		$.zjm_pledgeManager.jiechuInitTable();
	}
	
	
	/**
	 * 出库记录---撤销
	 */
	function backoutStock(){
		var secVal=getSelectValue();
		if(secVal == undefined){
			return;
		}
		$("#pledgeManager_page").load("/optGuarantyAction/backoutStockPage",{},function(){
			
		});
	}
	
	
	/**
	 * 出库记录---重置列表
	 */
	function chukuRefresh (){
		$.zjm_pledgeManager.chukuInitTable();
	}
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_pledgeManager.zaikuInitTable();
	
	/**
	 * 在库记录列表tab
	 */
	$("#zaiku").click(function(){
		$.zjm_pledgeManager.zaikuInitTable();
	});
	
	
	/**
	 * 借出记录列表tab
	 */
	$("#jiechu").click(function(){
		$.zjm_pledgeManager.jiechuInitTable();
	});
	
	
	/**
	 * 出库记录列表tab
	 */
	$("#chuku").click(function(){
		$.zjm_pledgeManager.chukuInitTable();
	});
	
	
	/**
	 * 在库记录---入库
	 */
	$("#btn_ruku").click(function(){
		$.zjm_pledgeManager.putStock();
	});
	
	/**
	 * 在库记录---借出
	 */
	$("#btn_jiechu").click(function(){
		$.zjm_pledgeManager.loanStock();
	});
	
	/**
	 * 在库记录---出库
	 */
	$("#btn_chuku").click(function(){
		$.zjm_pledgeManager.outStock();
	});
	
	/**
	 * 在库记录---重置列表
	 */
	$("#btn_zaiku_refresh").click(function(){
		$.zjm_pledgeManager.zaikuRefresh();
	});
	
	/**
	 * 借出记录---归还
	 */
	$("#btn_guihuan").click(function(){
		$.zjm_pledgeManager.returnStock();
	});
	
	/**
	 * 借出记录---重置列表
	 */
	$("#btn_jiechu_refresh").click(function(){
		$.zjm_pledgeManager.jiechuRefresh();
	});
	
	/**
	 * 出库记录---撤销
	 */
	$("#btn_chexiao").click(function(){
		$.zjm_pledgeManager.backoutStock();
	});
	
	/**
	 * 出库记录---重置列表
	 */
	$("#btn_chuku_refresh").click(function(){
		$.zjm_pledgeManager.chukuRefresh();
	});
	
	
});


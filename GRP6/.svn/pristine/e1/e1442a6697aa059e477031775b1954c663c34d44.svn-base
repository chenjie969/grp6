/**
 * 文档管理
 * @author : wuhn
 * 2017年8月8日 14:34:35
 */

(function($,z){
	$.zjm_documentManager = {
			initColumns:initColumns, // 定义列表 数据列
			initReleaseTalble:initReleaseTalble,//可选文档模板
			initDisposeTable:initDisposeTable,// 已生成文档
			relieveTable:relieveTable , //可选文档模板 初始化列表
			disposeTable:disposeTable, //已生成文档  初始化列表
			documentView:documentView,// 查看文档 ---已生成文档
			templateView:templateView, //查看 模板 --- 可选文档模板
			generateDocument:generateDocument, // 生成模板
			delFile:delFile, //删除模板
			delDocument:delDocument,  // 已生成文档-- 删除文档
			returnBack:returnBack,//返回
			
	};
		
	function initColumns(condition){
		var columns = [
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'mouldTypeName',title:'类型',sortable:"true",align:'center',formatter: function (value, row, index) {return row.mouldTypeName;}},
			{field:'mouldName',title:'文档编号',sortable:"true",align:'center',formatter: function (value, row, index) {return row.mouldName;}},
			{
				field : 'oldMouldName',
				title : '文档名称',
				sortable : "true",
				align : 'center',
				formatter : function(value, row, index) {
					return '<a href="javascript:void(0)" title="查看模板" id="templateView">'+ row.oldMouldName+ '</a>';
				},
				events:{
					'click #templateView': function(e,value,row,index){
						$.zjm_documentManager.templateView(row);
					}
				},
			},
			{field:'fileSize',title:'文件大小',sortable:"true",align:'center',formatter: function (value, row, index) {return (row.fileSize/1024).toFixed(2)+'KB';}},
			{field:'uploadDateTime',title:'上传时间',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.uploadDateTime);}},
			{title: '操作',align: 'center',formatter:function(value,row,index){
				if(row.extend == 'docx' || row.extend == 'doc' || row.extend == 'pdf' || row.extend == 'xlsx' || row.extend == 'xls' || row.extend == 'ppt' || row.extend == 'pptx'){
					return ['<button title="查看模板" class="btn btn-xs btn-warning" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.mouldPath+'&domextend='+row.extend+'\')"><i class="icon-zoom-in bigger-120"></i></button>',
						'<button title="下载模板" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.oldMouldName+'&filePath='+row.mouldPath+'\')"><i class="icon-download-alt bigger-120"></i></button>',
						'<button title="生成模板"  class="btn btn-xs btn-info" id="generateDoc" ><i class="icon-pencil bigger-120"></i></button>',
						//	'<button class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'
					].join('');
				}
			},
			events:{
				'click .btn_opfile_del': function(e, value, row, index) {
					$.zjm_documentManager.delFile(row);
				},
				'click #generateDoc': function(e, value, row, index) {
					$.zjm_documentManager.generateDocument(row);
				}
			}
		  } // end 操作
		];
		var columns2 = [
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'fileType',title:'类型',sortable:"true",align:'center',formatter: function (value, row, index) {return row.fileType;}},
			{
				field : 'sourceFileName',
				title : '文档名称',
				sortable : "true",
				align : 'center',
				formatter : function(value, row, index) {
					return '<a href="javascript:void(0)" title="查看文档" id="documentView">'+ row.sourceFileName+ '</a>';
				},
				events:{
					'click #documentView': function(e,value,row,index){
						$.zjm_documentManager.documentView(row);
					}
				},
			},
			{field:'fileSize',title:'文件大小',sortable:"true",align:'center',formatter: function (value, row, index) {return (row.fileSize/1024).toFixed(2)+'KB';}},
			{field:'uploadDateTime',title:'生成时间',sortable:"true",align:'center',formatter: function (value, row, index) {return tool.parseDate(row.uploadDateTime);}},
			{field:'updateUserName',title:'经办人',sortable:"true",align:'center',formatter: function (value, row, index) {return row.updateUserName;}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button title="查看文档" class="btn btn-xs btn-warning" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-zoom-in bigger-120"></i></button>',
					'<button title="下载文档" class="btn btn-xs btn-success" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></button>',
					'<button title="编辑文档" class="btn btn-xs btn-info" onclick="window.parent.open(\'/sys/documentPreview/selectDocumentEditPage?domhref='+row.pathFile+'&domextend='+row.extend+'\')"><i class="icon-pencil bigger-120"></i></button>',
					'<button title="删除文档" class="btn btn-xs btn-danger btn_opfile_del" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'
					
					].join('');
				},
				events:{
					'click .btn_opfile_del': function(e, value, row, index) {
						$.zjm_documentManager.delDocument(row);
					}
				}
			}
		];
		var obj={
				'columns':columns ,	
				'columns2':columns2 ,	
		}
		return obj;
	}	
	
	/**初始化列表 可选文档模板列表 ***/
	function initReleaseTalble(condition,columns){
		$("#release-table").bootstrapTable('destroy');
		$('#release-table').bootstrapTable({
			method: 'get',
			columns: columns,
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
				    html.push('<p><b>项目编号：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>项目名称：</b> ' + row.projectName + '</p>');
				    html.push('<p><b>保证方式：</b> ' + row.guarantyTypeName+ '</p>');
				    html.push('<p><b>反担保物类型：</b> ' + tool.isNull(row.optTypeName,'（空）')+ '</p>');
				    html.push('<p><b>权属人：</b> ' + row.ownerName + '</p>');
			        html.push('<p><b>解除日期：</b> ' + tool.parseDate(row.freeDate) + '</p>');
			    return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
	//		singleSelect : false,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/crm/filesUpload/selectAllDocMouldList",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"documentCode":$("#documentCode").val()};
				$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			placeholder:'这个是自定义的搜索内容',
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
	
	/**初始化列表 已生成文档 列表 ***/
	function initDisposeTable(condition,columns){
		$("#dispose-table").bootstrapTable('destroy');
		$('#dispose-table').bootstrapTable({
			method: 'get',
			columns: columns,
			detailView: false,
			detailFormatter:function(index, row){
				var html = [];
				 html.push('<p><b>项目编号：</b> ' + tool.isNull(row.busiCode,'（空）') + '</p>');
				    html.push('<p><b>项目名称：</b> ' + row.projectName + '</p>');
				    html.push('<p><b>保证方式：</b> ' + row.guarantyTypeName+ '</p>');
				    html.push('<p><b>反担保物类型：</b> ' + tool.isNull(row.optTypeName,'（空）')+ '</p>');
				    html.push('<p><b>抵（质）押率：</b> ' + tool.isNull(row.coverageRatio,'（空）') +'%'+ '</p>');
			        html.push('<p><b>经办人：</b> ' + tool.isNull(row.disposeUserName,"") + '</p>');
			        html.push('<p><b>处置日期：</b> ' + tool.parseDate(row.disposeDate)+ '</p>');
				return html;
			},
			toolbar: '#toolbar',    //工具按钮用哪个容器
			/*fixedColumns: true,
            fixedNumber: 5,*/
			singleSelect : true,// 单选checkbox
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
			url: "/documentAction/selectProjectFilesPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"flowID":$("#flowID").val(),"stepID":$("#stepID").val(),
						"taskID":$("#taskID").val(),"documentCode":$("#documentCode").val()};
				$.extend(queryCondition,condition);
				$.extend(params,{"queryCondition":queryCondition});
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
	
	
	/**
	 *	可选文档模板
	 */
	function  relieveTable(condition){
		var obj = $.zjm_documentManager.initColumns();
		
		$.zjm_documentManager.initReleaseTalble(condition,obj.columns);
	}
	
	/**
	 * 已生成文档
	 */
	function  disposeTable(condition){
		var obj = $.zjm_documentManager.initColumns();
		condition={"entityID":$("#entityID").val()}
		$.zjm_documentManager.initDisposeTable(condition,obj.columns2);
	}
	
	/**
	 * 查看模板
	 */
	function templateView(row){
		window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref='+row.mouldPath+'&domextend='+row.extend)
	}
	
	/**
	 * 生成文档
	 */
	function generateDocument(row){
		var entityID=$("#entityID").val();
		var argsObj={"flowID":$("#flowID").val(),"stepID":$("#stepID").val(),"taskID":$("#taskID").val(),
				"sourceFileName":row.oldMouldName,"fileType":row.mouldTypeName,"pathFile":row.mouldPath,
				 "entityID":entityID,"extend":row.extend
		};
		
		$.ajax({
			type:'POST',
			url:'/documentAction/generateDocument',
			contentType:'application/json;charset=UTF-8',
			data:JSON.stringify(argsObj),
			success:function(data){
				if(data.obj){
					$("#success").modal({keyboard:true});
					$.zjm_documentManager.disposeTable();
				}else{
					alert("生成失败。");
				}
			},
			error:function(){
				alert('消息来自error  出错了。。。');
			}
		
		});
	}
	
	/**删除模板*/
	function delFile(row){
		var datas;
		datas={"fileID":row.docMouldID,"filePath":row.mouldPath,"fileOneType":"docMould"};
		$("#delmodule").modal({keyboard:true});
		$(".btn_submit").click(function(){
			tool.disabled(".btn_submit");
			$.ajax({type:'POST',url:'/crm/filesUpload/delectOneFilesInfo',data:JSON.stringify(datas),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
		        		tool.undisabled(".btn_submit");
						$("#delmodule").modal("hide");
						$.zjm_documentManager.relieveTable();
					}else{
						alert("删除失败！");
						tool.undisabled(".btn_submit");
					}
		        }
			});
		});	
		$("#delmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	
	/**
	 * 查看已生成文档
	 */
	function documentView(row){
		window.parent.open('/sys/documentPreview/selectDocumentViewPage?domhref='+row.pathFile+'&domextend='+row.extend)
	}
	
	/**
	 * 删除已生成文档 
	 */
	function delDocument(row){
		$("#delmodule").modal({keyboard:true});
		$(".btn_submit").click(function(){
			$.ajax({
				type:'POST',
				url:'/documentAction/deleteDocument',
				data:JSON.stringify({'projectFiles_ID':row.projectFiles_ID,'pathFile':row.pathFile}),
				contentType:'application/json;charset=UTF-8',
				dataType:'json',
				success:function(data){
					if(data.obj){
						$("#delmodule").modal("hide");
						$("#dispose-table").bootstrapTable('remove',{
							field:'projectFiles_ID', //移除字段名
							values: [row.projectFiles_ID] //移除字段值
						});
					}else{
						$("#delmodule").modal("hide");
						alert("删除失败!");
					}
				}
			});
		});
		$("#delmodule").on("hidden.bs.modal", function (e) {//解除事件绑定
			 $(".btn_submit").unbind("click");
		});
	}
	//返回
	function returnBack(){
		var apply_ID =  $("#entityID").val();
		window.parent.openMenu('projectDeal'+apply_ID,'','项目办理','/project/projectTracking/projectBeforeDeal','&apply_ID='+apply_ID);
		window.parent.closeMenu('文档处理id'+apply_ID);
	}
	
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		$.zjm_documentManager.relieveTable(); // 可选文档模板 初始化列表
		$.zjm_documentManager.disposeTable(); // 已生成文档  初始化列表
		
	
	/**
	 * 可选文档模版 ---- 重置列表
	 */
	$("#relieve_refresh").click(function(){ // relieveList
		 $.zjm_documentManager.relieveTable();
		 // location.reload();
	});
	
	/**
	 * 已生成文档模版 ---- 重置列表
	 */
	$("#dispose_refresh").click(function(){ //disposeList
		$.zjm_documentManager.disposeTable();
	});

	//返回
	$(".btn_returnBack").click(function(){ //returnNext
		$.zjm_documentManager.returnBack();
	});
	
	/**
	 * 已生成文档--- 上传
	 */
	$("#document_upload").click(function(){
		$.zjm_documentManager.uploadDoc();
	});
	
	/**
	 * 关闭 页面
	 */
	$("#btn_close").click(function(){
		window.parent.closeMenu($("#taskName").text()+$("#entityID").val());
	});
		
});


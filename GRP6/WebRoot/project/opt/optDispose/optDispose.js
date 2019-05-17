/**
 * 保证措施管理---已解除/处置保证措施 js
 * @author : wuhn
 * 2017年7月4日 16:14:11
 */

(function($,z){
	$.zjm_optDispose = {
			initColumns:initColumns, // 定义列表 数据列
			initReleaseTalble:initReleaseTalble,//初始保证措施--已解除列表
			initDisposeTable:initDisposeTable,// 初始化保证措施--已处置列表
			unRelease:unRelease,// 保证措施--已解除--撤销解除
			hightSelect2:hightSelect2,// 保证措施--高级查询2
			viewRelease:viewRelease,// 保证措施--已解除 --- 查看记录
			viewDispose:viewDispose, // 保证措施-- 已处置 -- 查看
			unDispose:unDispose, // 保证措施-- 已处置 -- 撤销处置
			hightSelectDispose:hightSelectDispose, // 保证措施-- 已处置 -- 高级查询
			relieveTable:relieveTable , //保证措施---已解除
			disposeTable:disposeTable //保证措施---已处置
	};
		
	function initColumns(condition){
		var columns = [
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
			{field:'freeUserName',title:'经办人',align:'center',formatter: function (value, row, index) {return row.freeUserName;}},
			{field:'freeDate',title:'解除日期',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.freeDate);}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button title="查看" class="btn_modules_view btn btn-xs btn-warning" ><i class="icon-zoom-in bigger-120"></i></button>'
					].join('');
				},
				events:{
					'click .btn_modules_view': function(e, value, row, index) {
						$.zjm_optDispose.viewRelease(row);
					}
				}
			}
		];
		var columns2 = [
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
			{field:'104',title:'处置方式',align:'center',formatter: function (value, row, index) {return row.disposeTypeName;}},
			{field:'12',title:'经办人',align:'center',formatter: function (value, row, index) {return row.disposeUserName;}},
			{field:'12',title:'处置日期',align:'center',formatter: function (value, row, index) {return tool.parseDate(row.disposeDate);}},
			{title: '操 作 ',align: 'center',formatter:function(value,row,index){
				return [
					'<button title="查看" class="btn_modules_view btn btn-xs btn-warning""><i class="icon-zoom-in bigger-120"></i></button>',
					].join('');
				},
				events:{
					'click .btn_modules_view': function(e, value, row, index) {
						$.zjm_optDispose.viewDispose(row);
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
	
	/**初始化列表 保证措施-- 已解除 列表***/
	function initReleaseTalble(condition,columns){
		$("#release-table").bootstrapTable('destroy');
		$('#release-table').bootstrapTable({
			method: 'get',
			columns: columns,
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
				   html.push('<p><b>经办人：</b> ' + row.freeUserName + '</p>');
			        html.push('<p><b>解除日期：</b> ' + tool.parseDate(row.freeDate) + '</p>');
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
			url: "/optGuarantyAction/selectOptGuarantyPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"isFree":1};
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
	
	/**初始化列表 保证措施--已处置 列表 ***/
	function initDisposeTable(condition,columns){
		$("#dispose-table").bootstrapTable('destroy');
		$('#dispose-table').bootstrapTable({
			method: 'get',
			columns: columns,
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
				    html.push('<p><b>处置方式：</b> ' + tool.isNull(row.disposeTypeName,"") + '</p>');
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
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/optGuarantyAction/selectOptGuarantyPageTables",//这个接口需要处理bootstrap table传递的固定参数
			//ajaxOptions:{data:{"queryCondition.mod_uid":nodeid}},
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var queryCondition={"isDispose":1};
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

	/***保证措施--已解除--查看***/
	function viewRelease(row){
		window.parent.openMenu('view_OptGuaranty'+row.optGuaranty_ID,'','查看已解除保证措施','/optGuarantyAction/selectOneOptGuarantyInfo',
				'&guarantyTypeID='+row.guarantyTypeID+'&optTypeID='+row.optTypeID+'&optGuaranty_ID='+row.optGuaranty_ID
				+'&pageFlag=view'+'&relieveFlag=01');
	}
	
	/***保证措施--已解除--撤销解除***/
	function unRelease(){
		var selectContent = $('#release-table').bootstrapTable('getSelections');  
        if(selectContent.length != 1) {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }  
        
    	$("#delOptRelease").modal({keyboard:true});
    	tool.undisabled(".btn_submit");
    	$(".btn_submit").click(function(){
    		tool.disabled(".btn_submit");
    		var formData=JSON.stringify({"optGuaranty_ID":selectContent[0].optGuaranty_ID,"isFree":0});
    		$.ajax({
    			type:'POST',
				url:'/optGuarantyAction/updateOneOptGuarantyInfo',
				data:formData ,
				contentType: 'application/json; charset=UTF-8',
				dataType:'json' ,
				success : function(data) {
					if(data.obj){
						$("#delOptRelease").modal("hide");
						$.zjm_optDispose.relieveTable()
					}else{
						alert("撤销失败...");
						tool.undisabled(".btn_submit");
					}
				}
    		}) // end ajax.
    		
    		$("#delOptRelease").on("hidden.bs.modal", function(e) {// 解除事件绑定
    			$(".btn_submit").unbind("click");
    		});
    	})
	}
	
	
	
	/**
	 * 已解除-- 高级查询
	 */
	function hightSelect2(){
		$("#optDispose_page").load("/optGuarantyAction/optReleaseQuery",{},function(response,status,xhr){
			$("#optReleaseQuery").modal({keyboard:true}); 
			/*注册日期控件点击事件*/
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			/*获取经办人下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectCreateUser").selectTreeWidgets({
						width : "47%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			
			zjm.init();
			/** 注册编辑验证引擎 */
			zjm.validata({
				formId : "form_optRelease"
			});
			/** 保存修改** */
			tool.undisabled(".btn_submit"); //按钮调整为 可用
			$(".btn_submit").click(function() {
				if ($("#form_optRelease").validationEngine("validate")) {
					tool.disabled(".btn_submit");// 按钮调整为 不可用
					var condition = $("#form_optRelease").serializeJson();;
					var dd=	JSON.stringify(condition);
					$.zjm_optDispose.relieveTable(condition);
					$("#optReleaseQuery").modal("hide");
				} else {
					tool.undisabled(".btn_submit");
				}
			});
			$("#optReleaseQuery").on("hidden.bs.modal", function(e) {// 解除事件绑定
				$(".btn_reset").unbind("click");
				$(".btn_submit").unbind("click");
			});
		}); //end  load page
		
	}
	
	
	/**
	 * 保证措施-- 已处置 -- 撤销处置
	 */
	function unDispose(){
		var selectContent = $('#dispose-table').bootstrapTable('getSelections');  
        if(selectContent.length != 1) {  
        	$("#pleaseSelectOne").modal({keyboard:true});
            return false;  
        }  
        
    	$("#delOptDispose").modal({keyboard:true});
    	tool.undisabled(".btn_submit");
    	$(".btn_submit").click(function(){
    		tool.disabled(".btn_submit");
    		var formData=JSON.stringify({"optGuaranty_ID":selectContent[0].optGuaranty_ID,"isDispose":0});
    		$.ajax({
    			type:'POST',
				url:'/optGuarantyAction/updateOneOptGuarantyInfo',
				data:formData ,
				contentType: 'application/json; charset=UTF-8',
				dataType:'json' ,
				success : function(data) {
					if(data.obj){
						$("#delOptDispose").modal("hide");
						$.zjm_optDispose.disposeTable()
					}else{
						alert("撤销失败...");
						tool.undisabled(".btn_submit");
					}
				}
    		}) // end ajax.
    		
    		$("#delOptDispose").on("hidden.bs.modal", function(e) {// 解除事件绑定
    			$(".btn_submit").unbind("click");
    		});
    	})
	}
	
	
	/**
	 * 保证措施-- 已处置 -- 高级查询
	 */
	function hightSelectDispose(){
		$("#optDispose_page").load("/optGuarantyAction/optDisposeQuery",{},function(response,status,xhr){
			$("#optDisposeQuery").modal({keyboard:true}); 
			/*注册日期控件点击事件*/
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			
			/*获取经办人下拉选择树*/
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#selectCreateUser").selectTreeWidgets({
						width : "47%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
			});
			
			zjm.init();
			/** 注册编辑验证引擎 */
			zjm.validata({
				formId : "edit_form"
			});
			/** 保存修改** */
			tool.undisabled(".btn_submit"); //按钮调整为 可用
			$(".btn_submit").click(function() {
				if ($("#form_disposeQuery").validationEngine("validate")) {
					tool.disabled(".btn_submit");// 按钮调整为 不可用
					var condition = $("#form_disposeQuery").serializeJson();
					$.zjm_optDispose.disposeTable(condition);	
					$("#optDisposeQuery").modal("hide"); 
				} else {
					tool.undisabled(".btn_submit");
				}
			});
			$("#optDisposeQuery").on("hidden.bs.modal", function(e) {// 解除事件绑定
				$(".btn_reset").unbind("click");
				$(".btn_submit").unbind("click");
			});
		}); //end  load page
	}
	
	/**
	 * 保证措施-- 已处置 -- 查看
	 */
	function viewDispose(row){
		window.parent.openMenu('view_OptGuaranty'+row.optGuaranty_ID,'','查看已处置保证措施','/optGuarantyAction/selectOneOptGuarantyInfo',
				'&guarantyTypeID='+row.guarantyTypeID+'&optTypeID='+row.optTypeID+'&optGuaranty_ID='+row.optGuaranty_ID
				+'&pageFlag=view'+'&relieveFlag=02');
	}
	
	
	/**
	 * 保证措施---已解除
	 */
	function  relieveTable(condition){
		var obj = $.zjm_optDispose.initColumns();
		$.zjm_optDispose.initReleaseTalble(condition,obj.columns);
	}
	
	/**
	 * 保证措施---已处置
	 */
	function  disposeTable(condition){
		var obj = $.zjm_optDispose.initColumns();
		$.zjm_optDispose.initDisposeTable(condition,obj.columns2);
	}

})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	window.onload = floaddata;
	function floaddata() {
		/*注册日期控件点击事件*/
		$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		$.zjm_optDispose.relieveTable(); //默认加载已解除列表
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	};
	
	/**
	 * 保证措施---已解除
	 */
	$("#relieveList").click(function(){
		$.zjm_optDispose.relieveTable();
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	})
	
	/**
	 * 保证措施---已处置
	 */
	$("#disposeList").click(function(){
		$.zjm_optDispose.disposeTable();
		$(".form-control-ztb").attr("placeholder",'输入项目名称,回车搜索');
	})
	
	
	/**
	 * 保证措施--已解除--撤销解除
	 */
	$("#btn_release").click(function(){
		$.zjm_optDispose.unRelease();
	});
	
	/**
	 * 保证措施--已解除--高级查询
	 */
	$("#btn_hightSelectOpt").click(function(){
		$.zjm_optDispose.hightSelect2();
	});
	
	/**
	 * 保证措施--已解除--重置列表
	 */
	$("#relieve_refresh").click(function(){
		$.zjm_optDispose.relieveTable();
	});
	
	/**
	 * 保证措施--已处置--撤销处置
	 */
	$("#btn_dispose").click(function(){
		$.zjm_optDispose.unDispose();
	});
	
	/**
	 * 保证措施--已处置--重置列表
	 */
	$("#dispose_refresh").click(function(){
		$.zjm_optDispose.disposeTable();
	});
	
	/**
	 * 保证措施--已处置--高级查询
	 */
	$("#btn_hightSelectDispose").click(function(){
		$.zjm_optDispose.hightSelectDispose();
	});
});


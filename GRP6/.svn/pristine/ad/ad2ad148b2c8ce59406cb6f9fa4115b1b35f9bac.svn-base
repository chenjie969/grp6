(function($,z){
	$.zjm_syspara = {
			initColumns:initColumns,
			initSysparaTalble:initSysparaTalble,//初始化列表
			viewModule:viewModule,//客户列表查看
			editModule:editModule,//客户列表修改
	};
		
	function initColumns(){
		var columns = [
			
			{field:'index',title:'序号',align:'center',formatter: function (value, row, index) {return index+1;}},
			{field:'paraName',title:'参数名称',align:'center',formatter: function (value, row, index) {return row.paraName;}},
			{field:'paraValue',title:'参数值',align:'center',formatter: function (value, row, index) {return row.paraValue;}},
			{title: '操作',align: 'center',formatter:function(value,row,index){
				return ['<button class="btn_modules_view btn btn-xs btn-warning" title="查看"><i class="icon-zoom-in bigger-120"></i></button>',
					'<button class="btn_modules_edit btn btn-xs btn-info" title="修改"><i class="icon-pencil bigger-120"></i></button>'].join('');
				},
				events:{
					'click .btn_modules_view': function(e, value, row, index) {
						$.zjm_syspara.viewModule(row);
					},
					'click .btn_modules_edit': function(e, value, row, index) {
						$.zjm_syspara.editModule(row);
					}
				}
			}
		];
		return columns;
	}	
	
	/**初始化列表***/
	function initSysparaTalble(columns){
		$("#syspara-table").bootstrapTable('destroy');
		$('#syspara-table').bootstrapTable({
			method: 'get',
			columns: initColumns(),
			detailView: false,
			detailFormatter:function(index, row){
			    var html = [];
			        html.push('<p><b>参数名称:</b> ' + row.paraName + '</p>');
			        html.push('<p><b>参数值:</b> ' + tool.isNull(row.paraValue,"") + '</p>');
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
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/sys/syspara/selectSysparaPageTables",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			/*queryParams: function(params) {
				return params;
			},*///前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
            showExport: false,                     //是否显示导出
            exportDataType: "basic"              //basic', 'all', 'selected'
			         
			});
	}


	/***查看***/
	function viewModule(row){
		$("#sysparaModal").load("/syspara/syspara/sysparaViewPage",{"syspara_ID":row.syspara_ID},function(response,status,xhr){
			$("#sysparaViewModal").modal({keyboard:true});
		});
	}
	/***修改***/
	function editModule(row){
		$("#sysparaModal").load("/syspara/syspara/sysparaEditPage",{"syspara_ID":row.syspara_ID},function(response,status,xhr){
			$("#sysparaEditModal").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			zjm.validata({formId:"edit_sysparaForm"});
			/**提交*/
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#edit_sysparaForm").validationEngine("validate")){
					var queryContainer_form = $("#edit_sysparaForm");
						$.ajax({type:'POST',url:'/syspara/syspara/updateOneSysparaInfo',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==1){
									$("#sysparaEditModal").modal("hide");
									$.zjm_syspara.initSysparaTalble();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
					        }
						});
						tool.undisabled(".btn_submit");
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#sysparaEditModal").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
		
	}
	
})(jQuery, this);



$(function () {
	/**
	 * 文档加载的时候 读取 菜单信息
	 */
	$.zjm_syspara.initSysparaTalble();

	
});


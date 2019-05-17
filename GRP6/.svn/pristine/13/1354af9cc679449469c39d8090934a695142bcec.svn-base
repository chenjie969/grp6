(function($,z){
	$.zjm_transfer = {
		initProjChangeTable:initProjChangeTable,//初始化列表
		transferAdd:transferAdd,//移交记录新增
		proTransferEdit:proTransferEdit,//修改转移日志
	};
	var project_ID = tool.getUrlParam("project_ID");
	/**初始化列表***/
	function initProjChangeTable(){
		$('#transferPro_table').bootstrapTable('destroy');
		$('#transferPro_table').bootstrapTable({
			method: 'post',
			columns: [	
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"oldAmanName",title: '原项目经理A角',align: 'center',formatter: function (value, row, index) { return row.oldAmanName;}},
				{field:"oldBmanName",title: '原项目经理B角',align: 'center',formatter: function (value, row, index) { return row.oldBmanName;}},
				{field:"newAmanName",title: '当前项目经理A角',align: 'center',formatter: function (value, row, index) { return row.newAmanName;}},
				{field:"newBmanName",title: '当前项目经理B角',align: 'center',formatter: function (value, row, index) { return row.newBmanName;}},
				{field:"changeManName",title: '移交人',align: 'center',formatter: function (value, row, index) { return row.changeManName;}},
				{field:"changeDateTime",title: '移交时间',align: 'center',formatter: function (value, row, index) { return tool.parseDate(row.changeDateTime,"");}},
//				{title: '操作',align: 'center',formatter:function(value,row,index){
//						return ['<button class="btn_transfer_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>'
////							'<button class="btn_replace_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>'
//							].join('');
//					},
//					events:{
//						'click .btn_transfer_edit': function(e, value, row, index) {
//							$.zjm_transfer.proTransferEdit(row);
//						},
//						'click .btn_replace_del': function(e, value, row, index) {
//							$.zjm_transfer.replaceDel(row);
//						}
//					}
//				}
			],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: false,     //设置为 true 会在表格底部显示分页条
			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortName:"updateDateTime",
			sortOrder: "asc",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
			url: "/project/projChangeRec/selectProjChangeRecPageTable",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				$.extend(params,{"wheresql":" and project_ID=\'" +project_ID+"\'"});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索  
			showFooter: false, //合计  设置footer显示
			showColumns: false,     //是否显示所有的列
			showRefresh: false,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: false,    //是否启用点击选中行
			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
			showToggle: false,//是否显示详细视图和列表视图的切换按钮
			showPaginationSwitch:false,
			showExport: false,                     //是否显示导出
			exportDataType: "basic"              //basic', 'all', 'selected'
		});
	};
	
	
	/**移交记录添加*/
	function transferAdd(){
		var apply_ID = $("#applyID").val();
		$("#transferLog_page").load("/project/projChangeRec/openInsertProjectTransfer",{"project_ID":project_ID,"apply_ID":apply_ID},function(response,status,xhr){				
			$("#projectReplace").modal({keyboard:true});
			
			//获取新A角创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#newAmanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			//获取新B角创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#newBmanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			//获取项目办理人创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#changeManTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			zjm.init();
			$('#id-date-picker-1').attr("value",tool.parseDate(new Date().getTime()));//设置上报日期默认值
			$("#project_ID").val(project_ID);
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#projectReplaceEdit_form").validationEngine("validate")){
					$("#projectReplace").modal("hide");
						var queryContainer_form = $("#projectReplaceEdit_form");
						$.ajax({type:'POST',url:'/project/projChangeRec/insertOneProjChangRec',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
							if(data.obj==true){
								$("#projectReplace").modal("hide");
								$.zjm_transfer.initProjChangeTable();
							}else{
								alert("移交记录失败！");
							}
						}
						});
						
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#projectReplace").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		})
	
	};
	
	/**移交记录修改*/
	function proTransferEdit(row){
		$("#transferLog_page").load("/project/projChangeRec/editOneProjChangeRecPage",{"projChangeRec_ID":row.projChangeRec_ID},function(response,status,xhr){				
			$("#projectReplace").modal({keyboard:true});
			//获取创建人下拉树;s
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#oldAmanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			
			//获取创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#newAmanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			//获取创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#oldBmanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			//获取创建人下拉树;
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTree',async:false,data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#newBmanNameTree").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
				}
			});
			zjm.init();
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#projectReplaceEdit_form").validationEngine("validate")){
					$("#projectReplace").modal("hide");
					var queryContainer_form = $("#projectReplaceEdit_form");
					$.ajax({type:'POST',url:'/project/projChangeRec/updateOneProjChangeRec',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
						if(data.obj==true){
							$("#projectReplace").modal("hide");
							$.zjm_transfer.initProjChangeTable();
						}else{
							alert("修改代偿信息失败！");
						}
					}
					});
					
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#projectReplaceEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				$(".btn_submit").unbind("click");
			});
		})
		
	};
	
	
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	$.zjm_transfer.initProjChangeTable();
	
	$("#btn_transferAdd").click(function(){
		$.zjm_transfer.transferAdd();
	});
	
});


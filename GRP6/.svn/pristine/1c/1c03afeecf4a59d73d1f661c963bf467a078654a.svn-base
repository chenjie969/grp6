(function($,z){
	$.zjm_allAnnounce = {
			initTable:initTable,//初始化列表
			viewAnnounce:viewAnnounce,//查看记录详情
			delAnnounce:delAnnounce,//删除一条记录
			advancedQuery:advancedQuery,//高级查询
			delOneRelationAnnounce:delOneRelationAnnounce,
	};
	
	/**初始化列表***/
	function initTable(messageTypeId,treeLevel,data){
		$("#all_table").bootstrapTable('destroy');
		$('#all_table').bootstrapTable({
			method: 'get',
			columns: [
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"title",title: '标题',align: 'center',sortable:"true",
					formatter: function (value, row, index) {
						
					var titlestyle = "<a href='javascript:void(0)' class='btn_client_view' >"+row.title+"</a>";
					
					return titlestyle;},
					events : {
						'click .btn_client_view' : function(
								e, value, row, index) {
							$.zjm_yesSignAnnounce.viewAnnounce(row);
									
						},
					}
				},
				
				{field:"title",title: '类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.messageTypeName;}},
				{field:"createUserName",title: '发布人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
				{field:"createDateTime",title: '发布时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.createDateTime);}},
				{field:"userIsSignStatus",title: '状态',align: 'center',sortable:"true",formatter: function (value, row, index) {
				var st =	"<font color='#6fb3e0'>"+row.userIsSignStatus+"</font>";
					return  st; }},
				/*{field:"auditor",title: '已查看',align: 'center',formatter: function (value, row, index) { return row.readCount;}},
				{field:"auditTime",title: '已签收',align: 'center',formatter: function (value, row, index) { return row.signedCount;}},*/
				{field:"role_uid",title: '操作',align: 'center',formatter:function(value,row,index){
						return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>'
							].join('');
					},
					events:{
						'click .btn_modules_view': function(e, value, row, index) {
							$.zjm_allAnnounce.viewAnnounce(row);
						}
					}
					}],
					detailView: true,
					detailFormatter:function(index, row){
						var html = [];
						html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
						html.push('<p><b>标题:</b> ' + row.title + '</p>');
						html.push('<p><b>类型:</b> ' + row.messageTypeName + '</p>');
						html.push('<p><b>发布人:</b> ' + row.createUserName + '</p>');
						html.push('<p><b>发布时间:</b> ' + row.createDateTime + '</p>');
						html.push('<p><b>状态:</b> ' + row.userIsSignStatus + '</p>');
						html.push('<p><b>操作:</b><button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button></p>');
						/*html.push('<p><b>已查看:</b> ' + row.readCount + '</p>');
						html.push('<p><b>已签收:</b> ' + row.signedCount + '</p>');*/
						return html;
					},
				toolbar: '#toolbar',    //工具按钮用哪个容器
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination: true,     //设置为 true 会在表格底部显示分页条
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "updateDateTime",     //排序方式
				sortOrder: "desc",     //排序方式
				pageNumber:1,      //初始化加载第一页，默认第一页
				pageSize: 30,      //每页的记录行数（*）
				pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
				url: "/oa/announce/selectAnnounceSignPageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var	queryCondition ={"status":""}; 
					if(treeLevel=="2"){
						$.extend(queryCondition,{"messageTypePID":messageTypeId});
					}else if(treeLevel=="3"){
						$.extend(queryCondition,{"messageTypeId":messageTypeId});
					}
					 $.extend(params, {"queryCondition":queryCondition});
					 $.extend(queryCondition,data);
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

	
	
	
	/**查看一条企业咨询登记**/
	function viewAnnounce(row){
		$("#info_page").load("/oa/announce/signedAnnounceViewPage",
				{"messageId":row.messageId},
				 
				function(response,status,xhr){
					 $("#yesSignAnnounceView").modal({keyboard:true});
			});
	}
	
	/**点击每一行后面的删除图标时 删除单个关联主体***/
	function delOneRelationAnnounce(row){
		var ids = [row.messageId]
		$.zjm_allAnnounce.delAnnounce(ids);
	}
	/**删除记录**/
	function delAnnounce(ids){
		$("#info_page").load("/oa/announce/showAgreePage",{},function(response,status,xhr){
			$("#agreeToAccept").modal({keyboard:true});
			
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/oa/announce/deleteAnnounceByIds',data:JSON.stringify({"deleteIds":ids}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#agreeToAccept").modal("hide");
							$.zjm_allAnnounce.initTable();
						}else{
							alert("删除失败！");
						}
			        }
				});
			});
			$("#agreeToAccept").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**高级查询**/
	function advancedQuery(){
		$("#info_page").load("/oa/announce/yesSignAnnounceAdQuery",{},function(response,status,xhr){
			$("#announceAdQuery").modal({keyboard:true});
			$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTreeTwo',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
				success:function(data) {		
					$("#select_CreateName").selectTreeWidgets({
						width : "93%",//设置控件宽度
						multiple : false,//是否多选
						data : data.obj//数据源
					});
		        }
		        });
			$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"query_annouce_form"});
			tool.undisabled(".btn_submit");
			
			/*注册编辑验证引擎*/
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#query_annouce_form");
				if(queryContainer_form.validationEngine("validate")){
					$("#announceAdQuery").modal("hide");
					initTable($("#currentTreeId").val(),$("#query_annouce_form").serializeJson());	//传入高级查询条件后重新请求列表
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			
			$("#announceAdQuery").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
			$('#announceAdQuery').on('shown.bs.modal',function() {
				$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});  
			});
			
		});
	}
	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */

	$("#btn_agreeToAccept4").click(function(){
		var selectContent = $("#all_table").bootstrapTable('getSelections');
		if(selectContent.length >= 1){
			var ids = [];
			for(var i=0;i<selectContent.length;i++){
				ids[i] = selectContent[i].messageId;
			}
			$.zjm_allAnnounce.delAnnounce(ids);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
	$("#btn_advancedQuery1").click(function(){
		$.zjm_allAnnounce.advancedQuery();
	});
	
	$("#btn_refresh").click(function(){
		$.zjm_allAnnounce.initTable($("#currentTreeId").val(),"");
	});
});


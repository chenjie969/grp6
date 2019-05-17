(function($,z){
	$.zjm_auditBouncedAnnounce = {
			initTable:initTable,//初始化列表
			viewAnnounce:viewAnnounce,//查看记录详情
			delAnnounce:delAnnounce,//删除一条登记记录
			delOneRelationAnnounce:delOneRelationAnnounce,
	};
	var ue;
	/**初始化列表***/
	function initTable(messageTypeId,treeLevel){
		$("#audit_bounced_table").bootstrapTable('destroy');
		$('#audit_bounced_table').bootstrapTable({
			method: 'get',
			columns: [
				{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"messageTypeName",title: '类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.messageTypeName;}},
				{field:"title",title: '标题',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.title;}},
				{field:"createUserName",title: '发布人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
				{field:"createDateTime",title: '发布时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.createDateTime);}},
				{field:"approvalUserName",title: '审核人',align: 'center',formatter: function (value, row, index) { return row.approvalUserName;}},
				{field:"approvalDateTime",title: '退回时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.approvalDateTime);}},
				{field:"role_uid",title: '操作',align: 'center',formatter:function(value,row,index){
					return ['<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button>',
							'<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button>'].join('');
				},
				events:{
					'click .btn_modules_view': function(e, value, row, index) {
						$.zjm_auditBouncedAnnounce.viewAnnounce(row);
					},
					'click .btn_modules_del': function(e, value, row, index) {
						$.zjm_auditBouncedAnnounce.delOneRelationAnnounce(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
					html.push('<p><b>类型:</b> ' + row.messageTypeName + '</p>');
					html.push('<p><b>标题:</b> ' + row.title + '</p>');
					html.push('<p><b>发布人:</b> ' + row.createUserName + '</p>');
					html.push('<p><b>发布时间:</b> ' + tool.parseDate(row.createDateTime) + '</p>');
					html.push('<p><b>审核人:</b> ' + row.approvalUserName + '</p>');
					html.push('<p><b>退回时间:</b> ' + tool.parseDate(row.approvalDateTime) + '</p>');
					html.push('<p><b>退回原因:</b> ' + row.returnDesc + '</p>');
					html.push('<p><b>操作:</b><button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button><button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button></p>'); 
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
				pageList: [30,50,100,200,500],  //可供选择的每页的行数（*）
				url: "/oa/announce/selectAnnouncePageTable",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
				// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
				queryParams: function(params) {
					var	queryCondition ={"status":"03"}; 
					if(treeLevel=="2"){
						$.extend(queryCondition,{"messageTypePID":messageTypeId});
					}else if(treeLevel=="3"){
						$.extend(queryCondition,{"messageTypeId":messageTypeId});
					}
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
				exportDataType: "basic"              //basic', 'all', 'selected'

		});
	}
	

	
	/**查看一条企业咨询登记**/
	function viewAnnounce(row){
		$("#info_page").load("/oa/announce/bouncedAnnounceViewPage",{"messageId":row.messageId},function(response,status,xhr){
			$("#bouncedAnnounceView").modal({keyboard:true});
			var defParam = {
				"uploadParam" : {
					"fileOneType":"oaFiles",//附件表分类--> oa类附件
					"fileTwoType":"01",//附件上传入口分类 --> 01:信息附件;02：会议室附件;03：会议附件
					"entityID":row.messageId
				},//上传附加参数
				"fileList" : "fileList",//已上传的附件列表Table ID
				"fileListURL" : "/oa/announce/selectUploadedFilesPageTables",//加载附件列表数据地址
			};
			$.zjm_upload.initViewTable(defParam);
		});
	}
	
	/**点击每一行后面的删除图标时 删除单个关联主体***/
	function delOneRelationAnnounce(row){
		var ids = [row.messageId]
		$.zjm_auditBouncedAnnounce.delAnnounce(ids);
	}
	/**删除记录**/
	function delAnnounce(ids){
		$("#info_page").load("/oa/announce/showAgreePage",{},function(response,status,xhr){
			$("#agreeToAccept").modal({keyboard:true});
			
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/oa/announce/deleteAnnounceByIds',data:JSON.stringify({"deleteIds":ids}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#agreeToAccept").modal("hide");
							$.zjm_auditBouncedAnnounce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
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
	

	
})(jQuery, this);

$(function () {
	$("#btn_delAnnounce").click(function(){
		var selectContent = $("#bounced_table").bootstrapTable('getSelections');
		if(selectContent.length >= 1){
			var ids = [];
			for(var i=0;i<selectContent.length;i++){
				ids[i] = selectContent[i].messageId;
			}
			$.zjm_auditBouncedAnnounce.delAnnounce(ids);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
});


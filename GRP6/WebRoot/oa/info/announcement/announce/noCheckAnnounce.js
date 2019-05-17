(function($,z){
	$.zjm_noCheckAnnounce = {
			initTable:initTable,//初始化列表
			viewInfo:viewInfo,//查看消息
			delInfo:delInfo,//删除消息
			checkAnnounce:checkAnnounce,//审核
			auditReturn:auditReturn,//审核退回
			updateStatusToYesCheck:updateStatusToYesCheck,//确定"审核通过"
	};
	
	/**初始化列表***/
	function initTable(messageTypeId,treeLevel){
		$("#noCheck_table").bootstrapTable('destroy');
		$('#noCheck_table').bootstrapTable({
			method: 'get',
			singleSelect : true, // 单选checkbox 
			columns: [
				{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"title",title: '类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.messageTypeName;}},
				{field:"title",title: '标题',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.title;}},
				{field:"createUserName",title: '发布人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
				{field:"createDateTime",title: '发布时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.createDateTime);}},
				{field:"role_uid",title: '操作',align: 'center',formatter:function(value,row,index){
					return [
						'<button class="btn_modules_accredit btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-sitemap bigger-120">审核</i></button>'].join('');
				},
				events:{
					'click .btn_modules_accredit': function(e, value, row, index) {
						$.zjm_noCheckAnnounce.checkAnnounce(row);
					}
				}
				}],
				detailView: true,
				detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>序号:</b> ' + (index+1)+ '</p>');
					html.push('<p><b>标题:</b> ' + row.title + '</p>');
					html.push('<p><b>类型:</b> ' + row.messageTypeName + '</p>');
					html.push('<p><b>发布人:</b> ' + row.createUserName + '</p>');
					html.push('<p><b>发布时间:</b> ' + tool.parseDate(row.createDateTime) + '</p>');
					html.push('<p><b>操作:</b><button class="btn_modules_accredit btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-sitemap bigger-120">审核</i></button></p>');
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
					var	queryCondition ={"status":"02"}; 
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

	/**审核公告**/
	function checkAnnounce(row){
		$("#info_page").load("/oa/announce/announceAuditViewPage",{"messageId":row.messageId},function(response,status,xhr){
			
			$("#AuditAnnounce").modal({keyboard:true});
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
			
			$("#btn_pageAuditPass").click(function(){
				
				$.zjm_noCheckAnnounce.updateStatusToYesCheck(row)
				$("#AuditAnnounce").modal("hide");
			});
			$("#btn_pageAuditReturn").click(function(){
				
				$.zjm_noCheckAnnounce.auditReturn(row.messageId);
				 $(".modal-backdrop").remove();
			});
			$("#AuditAnnounce").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
			
		});
	}
	/**查看一条**/
	function viewInfo(row){
		$("#info_page").load("/oa/infoManage/infoViewPage",{"id":row.id},function(response,status,xhr){
			$("#viewInfo").modal({keyboard:true});
		});
	}
	/** 审核退回页面             **/
	function auditReturn(message_id){
		$("#info_page").load("/oa/announce/announceAuditReturnPage",{"messageId":message_id},function(response,status,xhr){
			$("#announceAuditReturn").modal({keyboard:true});
			$("#messageId").val(message_id);
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#audit_return_form");
				if(queryContainer_form.validationEngine("validate")){
						$.ajax({type:'POST',url:'/oa/announce/updateStatusToBounced',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#announceAuditReturn").modal("hide");
//									$.zjm_auditBouncedAnnounce.initTable($("#currentTreeId").val());
									$.zjm_noCheckAnnounce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
									$("#count").text(parseInt($("#count").text())-1); //设置提示count
								}else{
									alert("保存失败！");
								}
					        }
						});
					}else{
						tool.undisabled(".btn_submit");
					}
//				
			});
			$("#announceAuditReturn").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
		
	}
	
	
	/**删除一条企业咨询登记**/
	function delInfo(row){
		$("#info_page").load("/oa/infoManage/infoDelPage",{},function(response,status,xhr){
			$("#delInfo").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/oa/infoManage/deleteOneInfo',data:JSON.stringify({"id":row.id}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#delInfo").modal("hide");
							$.zjm_info.initTable();
						}else{
							alert("保存失败！");
						}
			        }
				});
			});
			$("#delInfo").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	/**更新为"yesCheck"状态**/
	function updateStatusToYesCheck(row){
		$.ajax({type:'POST',url:'/oa/announce/updateStatusToYesCheck',
			data:JSON.stringify({"messageId":row.messageId,
					"receiveUserNameList":row.receiveUserNameList,
					"receiveUserIdList":row.receiveUserIdList}
					),
			contentType:'application/json; charset=UTF-8',
			dataType:'json',
			success:function(data) {
	        	if(data.obj==1){
					$("#agreeToAcceptAudit").modal("hide");
					$.zjm_noCheckAnnounce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
//					$.zjm_yesCheckAnnounce.initTable($("#currentTreeId").val());
		//			$("#count").text(parseInt($("#count").text())-1); //设置提示count
				}else{
					alert("保存失败！");
				}
	        }
		});
	}

	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
	

	$("#btn_auditReturn").click(function(){
		
		var selectContent = $("#noCheck_table").bootstrapTable('getSelections');
		if(selectContent.length == 1){
			$.zjm_noCheckAnnounce.auditReturn(selectContent[0].messageId);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
		
	});
	
	
	$("#btn_checkToYes").click(function(){
		var selectContent = $("#noCheck_table").bootstrapTable('getSelections');
		if(selectContent.length == 1){
				$("#info_page").load("/oa/announce/showAgreeAuditPage",{},function(response,status,xhr){
						$("#agreeToAcceptAudit").modal({keyboard:true});
					
							$(".btn_submit").click(function(){
						
								$.zjm_noCheckAnnounce.updateStatusToYesCheck(selectContent[0]);
						
							});
						$("#agreeToAcceptAudit").on("hidden.bs.modal", function (e) {//解除事件绑定
							 $(".btn_submit").unbind("click");
						});
				});
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
});


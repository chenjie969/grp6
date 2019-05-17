(function($,z){
	$.zjm_noSignAnnounce = {
			initTable:initTable,//初始化列表
			announceSign:announceSign,//查看企业咨询登记记录详情
			delInfo:delInfo,//删除一条企业咨询登记记录
			updateToYesSign:updateToYesSign,//修改"签收"状态
	};
	
	/**初始化列表***/
	function initTable(messageTypeId,treeLevel){
		$("#noSign_table").bootstrapTable('destroy');
		$('#noSign_table').bootstrapTable({
			method: 'get',
			columns: [
				{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"title",title: '标题',align: 'center',sortable:"true",formatter: function (value, row, index) { 
					var titlestyle = "<a href='javascript:void(0)' class='btn_client_view' >"+row.title+"</a>";
					
					return titlestyle;},
					events : {
						'click .btn_client_view' : function(
								e, value, row, index) {
							$.zjm_noSignAnnounce.announceSign(row);
									
						},
					}
					},
				{field:"messageTypeName",title: '类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.messageTypeName;}},
				{field:"createUserName",title: '发布人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
				{field:"createDateTime",title: '发布时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.createDateTime);}},
				/*{field:"auditor",title: '已查看',align: 'center',formatter: function (value, row, index) { return row.readCount;}},
				{field:"auditTime",title: '已签收',align: 'center',formatter: function (value, row, index) { return row.signedCount;}},*/
				{field:"role_uid",title: '操作',align: 'center',formatter:function(value,row,index){
					return ['<button class="btn_modules_accredit btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120">查看并签收</i></button>'
						].join('');
				},
				events:{
					'click .btn_modules_accredit': function(e, value, row, index) {
						$.zjm_noSignAnnounce.announceSign(row);
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
					html.push('<p><b>发布时间:</b> ' + tool.parseDate(row.createDateTime) + '</p>');
					html.push('<p><b>操作:</b><button class="btn_modules_accredit btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120">立即签收</i></button></p>');
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
					var	queryCondition ={"status":"01"}; 
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


	
	/**立即签收**/
	function announceSign(row){
		$("#info_page").load("/oa/announce/signAnnounceViewPage",
			{"messageId":row.messageId},
			 
			function(response,status,xhr){
				 $("#signAnnounceView").modal({keyboard:true});
			
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
					
					
					$(".btn_submit").click(function(){
						$("#signAnnounceView").modal("hide");
						$.ajax({type:'POST',url:'/oa/announce/updateStatusToYesSign',data:JSON.stringify({"messageId":row.messageId}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
					        		$("#signAnnounceView").modal("hide");
									$.zjm_noSignAnnounce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
//									$.zjm_yesSignAnnounce.initTable($("#currentTreeId").val(),"");
//									$.zjm_allAnnounce.initTable($("#currentTreeId").val());
	//								$("#count").text(parseInt($("#count").text())-1); //设置提示count
								}else{
									alert("签收失败！");
								}
					        }
						});
					});
					$("#signAnnounceView").on("hidden.bs.modal", function (e) {//解除事件绑定
						 $(".btn_submit").unbind("click");
					});
		});
	}
	
	
	function updateToYesSign(row){
		$("#info_page").load("/oa/announce/showAgreeSignPage",{},function(response,status,xhr){
			$("#agreeToAcceptSign").modal({keyboard:true});
			
			$(".btn_sign").click(function(){
				$.ajax({type:'POST',url:'/oa/announce/updateStatusToYesSign',
					data:JSON.stringify({"messageId":row.messageId}),
					contentType:'application/json; charset=UTF-8',
					dataType:'json',
					success:function(data) {
				
		        	if(data.obj==1){
		        		$("#agreeToAcceptSign").modal("hide");
						$.zjm_noSignAnnounce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
//						$.zjm_yesSignAnnounce.initTable($("#currentTreeId").val(),"");
//						$.zjm_allAnnounce.initTable($("#currentTreeId").val());
//						$("#count").text(parseInt($("#count").text())-1); //设置提示count
					}else{
						alert("签收失败！");
					}
		        }
				});
			});
			$("#agreeToAcceptSign").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_sign").unbind("click");
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
	

	
})(jQuery, this);

$(function () {
	/**
	 * 文档加载的时候 读取 
	 */
//	$.zjm_noSignAnnounce.initTable();
	
	$("#btn_sign").click(function(){
		var selectContent = $("#noSign_table").bootstrapTable('getSelections');
		if(selectContent.length == 1){
//			$.zjm_noSignAnnounce.updateToYesSign(selectContent[0]);
			$.zjm_noSignAnnounce.announceSign(selectContent[0]);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
		
	});
	$("#btn_addInfo").click(function(){
		$.zjm_info.addInfo();
	});
});


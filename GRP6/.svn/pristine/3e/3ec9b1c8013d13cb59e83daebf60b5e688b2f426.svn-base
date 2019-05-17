(function($,z){
	
	$.zjm_announce = {
			initTree : initTree,// 加载树结构
			initSelectTree:initSelectTree,
			initTable:initTable,// 初始化列表
			addAnnounce:addAnnounce,
			viewInfo:viewInfo,
			editInfo:editInfo,
			delOneAnnounce:delOneAnnounce,
			delAnnounce:delAnnounce,
			checkInfo:checkInfo,
			updateStatusToNoCheck:updateStatusToNoCheck
	};
	

	var zTreeObj; // ztree对象
	/** 加载树结构 */
	function initTree(CooperationID,isChild) {
		var setting = {
			callback : {
				onClick : zTreeOnMouseDown	/** 捕获 zTree 上鼠标按键按下后的事件回调函数* */
				,onAsyncSuccess: zTreeOnAsyncSuccess/**用于捕获异步加载正常结束的事件回调函数**/
			}
		};
		// 初始化加载左侧树形结构
		zTreeObj = tree.init({
			initID : "menuSetTree",
			url : "/oa/announce/selectAllInfoListTree"
		}, setting);
		
		/** 单击 节点 触发的函数* */
		function zTreeOnMouseDown(event, treeId, treeNode, clickFlag) {
//			tree.expand();
			var treeLevel = "";
			if(treeNode.id=="b4cb8bf303974996ac4df5e87cf30ac0"){	//祖先节点
				treeLevel = "1";
			}else if(treeNode.isParent){	//判断当前节点是否有子节点
				treeLevel = "2";
			}else{
				treeLevel = "3";
			}
			
			$("#currentTreeId").val(treeNode.id);
			$("#treeLevel").val(treeLevel);
			
			//初始化右边的草稿箱
			$.zjm_announce.initTable(treeNode.id,treeLevel);
			$.zjm_bouncedAnnounce.initTable(treeNode.id,treeLevel);
		};
		
		/**用于捕获异步加载正常结束的事件回调函数**/
		function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
			var nodes = zTreeObj.transformToArray(zTreeObj.getNodes());
				$.each(nodes,function(index,element){
					if(nodes[index].id == CooperationID){
						zTreeObj.selectNode(nodes[index]);
						zTreeObj.expandNode(nodes[index],true,false,true);
					}
				})
		};
	//	$.zjm_announce.initTable(CooperationID,isChild);
	}
	
	/**初始化列表***/
	function initTable(messageTypeId,treeLevel){
		$("#announce_table").bootstrapTable('destroy');
		$('#announce_table').bootstrapTable({
			method: 'get',
			columns: [
				{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
				{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 
				{field:"title",title: '标题',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.title;}},
				{field:"messageTypeName",title: '类型',align: 'center',sortable:"true",formatter: function (value, row, index) { return row.messageTypeName;}},
				{field:"createUserName",title: '发布人',align: 'center',formatter: function (value, row, index) { return row.createUserName;}},
				{field:"createDateTime",title: '发布时间',align: 'center',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.createDateTime);}},
				{field:"approvalStatus",title: '状态',align: 'center',sortable:"true",formatter: function (value, row, index) { 
					var status;
					switch(row.approvalStatus){
						case "01":	status="草稿";
									break;
						case "02":	status="待审核";
									break;
						case "03":	status="被退回";
									break;
						case "04":	status="已通过";
									break;
						default:	status=""
					}
					return status;}},
				{field:"role_uid",title: '操作',align: 'center',formatter:function(value,row,index){
					var btnArr = new Array();
					btnArr[0]='<button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)" title="查看"><i class="icon-zoom-in bigger-120"></i></button>';
					if(row.approvalStatus=="01" || row.approvalStatus=="03"){
						btnArr[1]='<button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" title="修改"><i class="icon-pencil bigger-120"></i></button>';
						btnArr[2]='<button class="btn_modules_check btn btn-xs btn-pink" href="javascript:void(0)" title="提交审核"><i class="icon-sitemap bigger-120"></i></button>';
						btnArr[3]='<button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)" title="删除"><i class="icon-trash bigger-120"></i></button>';
					}
					return btnArr.join('');
				},
				events:{
					'click .btn_modules_view': function(e, value, row, index) {
						$.zjm_announce.viewInfo(row);
					},
					'click .btn_modules_edit': function(e, value, row, index) {
						$.zjm_announce.editInfo(row);
					},
					'click .btn_modules_check': function(e, value, row, index) {
						var ids=[];
						ids[0]=row.messageId;
						$.zjm_announce.checkInfo(ids);
					},
					'click .btn_modules_del': function(e, value, row, index) {
						$.zjm_announce.delOneAnnounce(row);
					}
				}
				}],
				detailView: false,
				/*detailFormatter:function(index, row){
					var html = [];
					html.push('<p><b>序号:</b> ' + (index+1) + '</p>');
					html.push('<p><b>标题:</b> ' + row.title + '</p>');
					html.push('<p><b>发布人:</b> ' + row.createUserName + '</p>');
					html.push('<p><b>发布时间:</b> ' + tool.parseDate(row.createDateTime) + '</p>');
					html.push('<p><b>操作:</b><button class="btn_modules_view btn btn-xs btn-warning" href="javascript:void(0)"><i class="icon-zoom-in bigger-120"></i></button><button class="btn_modules_edit btn btn-xs btn-info" href="javascript:void(0)" data-toggle="modal" data-target="#edit_Page"><i class="icon-pencil bigger-120"></i></button><button class="btn_modules_del btn btn-xs btn-danger" href="javascript:void(0)"><i class="icon-trash bigger-120"></i></button></p>');
					return html;
				},*/
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
					var	queryCondition ={}; 
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
	
	/**新增一条通知公告**/
	function addAnnounce(){
		$("#info_page").load("/oa/announce/announceAddPage",{},function(response,status,xhr){
			$("#addAnnounce").modal({keyboard:true}).addClass("fullfilled");
			/*获取下拉框*/
			zjm.dataViewValSelect("select_templet", "/selectDicTypeListJSON", {"dicTypePID" : 'e32e5c0892e44514bb0d80bec38e3e58'});
			initSelectTree();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"add_announce_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#add_annouce_form").validationEngine("validate")){
					$("#content").val(ue.getContent());
	//				alert(ue.getContentTxt());
					var queryContainer_form = $("#add_annouce_form");
					$.ajax({type:'POST',url:'/oa/announce/insertOneAnnounce',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#addAnnounce").modal("hide");
								$.zjm_announce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
							}else{
								alert("保存失败！");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$(".btn_submit_audit").click(function(){
				tool.disabled(".btn_submit");
				if($("#add_annouce_form").validationEngine("validate")){
					$("#content").val(ue.getContent());
					var queryContainer_form = $("#add_annouce_form");
					$.ajax({type:'POST',url:'/oa/announce/insertOneAnnounce',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj==1){
								$("#addAnnounce").modal("hide");
								var ids = [data.code]
								$.zjm_announce.updateStatusToNoCheck(ids);
								$("#addAnnounce").modal("hide");
							}else{
								alert("保存失败！");
							}
				        }
					});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			
			$("#addAnnounce").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
				 UE.getEditor('editor').destroy(); //销毁编辑器
			});
			$("#addAnnounce").on("shown.bs.modal", function (e) {//解除事件绑定
				 ue = UE.getEditor('editor');   //创建编辑器
			});
		});
	}
	
	/**查看一条信息**/
	function viewInfo(row){
		$("#info_page").load("/oa/announce/draftAnnounceViewPage",{"messageId":row.messageId},function(response,status,xhr){
			$("#draftAnnounceView").modal({keyboard:true});
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
	
	/**修改一条信息**/
	function editInfo(row){
		$("#info_page").load("/oa/announce/announceEditPage",{"messageId":row.messageId},function(response,status,xhr){
			$("#editAnnounce").modal({keyboard:true}).addClass("fullfilled");
			initSelectTree();
			var defParam = {
					"uploadFileList" : "uploadFileList",//待上传的附件列表div ID
					"uploadConsoleList" : "uploadConsoleList",//错误信息提示div ID
					"btn_PickID" : "pick",//选择附件按钮ID
					"btn_UploadID" : "upload",//上传按钮ID
					"uploadURL" : "/crm/filesUpload/insertOneFilesUpload",//上传的地址 
					"uploadParam" : {
						"fileOneType":"oaFiles",//附件表分类--> oa类附件
						"fileTwoType":"01",//附件上传入口分类 --> 01:信息附件;02：会议室附件;03：会议附件
						"entityID":row.messageId
					},//上传附加参数
					"fileList" : "fileList",//已上传的附件列表Table ID
					"fileListURL" : "/oa/announce/selectUploadedFilesPageTables",//加载附件列表数据地址
					"mimeTypes":""
						/* [
						{title : "图片", extensions : "image/jpg,image/gif,image/png,image/jpeg"},
						{title : "文档", extensions : "doc,docx,xls,xlsx,ppt,pptx,pdf,swf"},
						{title : "音频,视频", extensions : "f4v,wnv,wmv,mp3,rmvb,avi,mp4"},
						{title : "文本", extensions : "txt,xml"},
						{title : "压缩包", extensions : "rar,zip,7z"}
						]//限定上传附件类型 */
			};
			$.zjm_upload.initTable(defParam);
			$("#btn_uploadfiles").click(function(){
				$("#uploadfiles").modal({keyboard:true});
				var zindex = parseInt($("#editAnnounce").css("z-index"));
				$("#uploadfiles").css("z-index",zindex+50);
				$(".modal-backdrop:eq(1)").css("z-index",zindex+40);
				$.zjm_upload.initUpload(defParam);
				$("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
					$.zjm_upload.initTable(defParam);
					uploader.destroy();
				}); 
			});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_annouce_form"});
			tool.undisabled(".btn_submit");
			
			/*注册编辑验证引擎*/
			zjm.validata({formId:"edit_annouce_form"});
			tool.undisabled(".btn_submit");
			$("#btn_save").click(function(){
	//			tool.disabled(".btn_submit");
				var queryContainer_form = $("#edit_annouce_form");
			
			if(queryContainer_form.validationEngine("validate")){
				//	$("#content").val(ue.getContent());
//					 UE.getEditor('editor').destroy(); //销毁编辑器
				queryContainer_form = $("#edit_annouce_form");
//					if(zjm.ajaxValidata("edit_clientName","/crm/apply/isExistClientName",JSON.stringify(queryContainer_form.serializeJson()),"企业名称重复！")){
						
					var formdate=$("#edit_annouce_form").serialize();
		//			console.info(formdate);
																			
															$.ajax({
																type : 'POST',
																url : '/oa/announce/updateOneAnnounce',
																data : formdate,
																dataType : 'json',
																success : function(data) {
																		if(data.obj==1){
																			$("#editAnnounce").modal("hide");
																			$.zjm_announce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
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
			$(".btn_submit_audit").click(function(){
				var queryContainer_form = $("#edit_annouce_form");
				
				if(queryContainer_form.validationEngine("validate")){
					queryContainer_form = $("#edit_annouce_form");
							
						var formdate=$("#edit_annouce_form").serialize();
												
								$.ajax({
									type : 'POST',
									url : '/oa/announce/updateOneAnnounce',
									data : formdate,
									dataType : 'json',
									success : function(data) {
											if(data.obj==1){
												$("#editAnnounce").modal("hide");
												var ids = [data.code]
												$.zjm_announce.updateStatusToNoCheck(ids);
												$("#editAnnounce").modal("hide");
											//	$.zjm_announce.initTable();
											}else{
												alert("保存失败！");
											}
								        }
									});
				}else{
						tool.undisabled(".btn_submit");
				}
			});
			$("#editAnnounce").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
				 $(".btn_submit_audit").unbind("click");
				 UE.getEditor('editor').destroy(); //销毁编辑器
			});
			$("#editAnnounce").on("shown.bs.modal", function (e) {//解除事件绑定
				 ue = UE.getEditor('editor');   //创建编辑器
				 
			});
		});
	}
	
	/**点击每一行后面的删除图标时 删除单个消息***/
	function delOneAnnounce(row){
		var ids = [row.messageId]
		$.zjm_announce.delAnnounce(ids);
	}
	
	/**删除记录**/
	function delAnnounce(ids){
		$("#info_page").load("/oa/announce/showAgreePage",{},function(response,status,xhr){
			$("#agreeToAccept").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.ajax({type:'POST',url:'/oa/announce/deleteAnnounceByIds',data:JSON.stringify({"deleteIds":ids}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			        	if(data.obj==1){
							$("#agreeToAccept").modal("hide");
							$.zjm_announce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
							
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
	
	/**提交审核**/
	function checkInfo(ids){
		$("#info_page").load("/oa/announce/showAgreeCheckPage",{},function(response,status,xhr){
			$("#agreeToAcceptCheck").modal({keyboard:true});
			$(".btn_submit").click(function(){
				$.zjm_announce.updateStatusToNoCheck(ids);
			});
			$("#agreeToAcceptCheck").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	/**更新为"nocheck"状态**/
	function updateStatusToNoCheck(message_ids){
		$.ajax({type:'POST',url:'/oa/announce/updateStatusToNoCheck',data:JSON.stringify({"auditIds":message_ids}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
			$("#agreeToAcceptCheck").modal("hide");
			if(data.code==1){
					$.zjm_announce.initTable($("#currentTreeId").val(),$("#treeLevel").val());
				}else{
					alert("保存失败！");
				}
	        }
		});
	}
	
	/**初始化部门人员下拉选择树**/
	function initSelectTree(){
		$.ajax({type:'POST',url:'/sys/dic/selectDepartsUserTreeTwo',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#select_publicScope").selectTreeWidgets({
					width : "89%",//设置控件宽度
					multiple : true,//是否多选
					data : data.obj//数据源
				});
	        }
        });
		$.ajax({type:'POST',url:'/sys/dic/selectMultiLevelSortDicTree',data:JSON.stringify({'id':'f1ab5bf4aa3948e690e808d9127e7d6b/b4cb8bf303974996ac4df5e87cf30ac0'}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#select_messageType").selectTreeWidgets({
					width : "89%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
        });
		//下拉框触发事件,更换编辑器模板
		$("#select_templet").change(function(){
			 var vs = $(this).children('option:selected').val(); 
			 if(vs==""){
				 ue.setContent("");
			 }else{
				 $.ajax({type:'POST', url:'/selectOneDicTypeInfo',async:false,data:JSON.stringify({"dicTypeID":vs}),contentType:'application/json; charset=UTF-8',dataType:'json', success:function(data) {
						 var content = data.obj.remark;
						 ue.setContent(content, false);
					 }
				 });	
			 }
		});
	}
	
})(jQuery, this);

$(function () {
	
	$.zjm_announce.initTable();
	$.zjm_announce.initTree();
	
	/**新增通知公告**/
	$("#btn_addAnnounce").click(function(){
		$.zjm_announce.addAnnounce();
	});
	
	/** 删除所选**/
	$("#btn_batchDelete").click(function(){
		var selectContent = $("#announce_table").bootstrapTable('getSelections');
		if(selectContent.length >= 1){
			var ids = [];
			for(var i=0;i<selectContent.length;i++){
				ids[i] = selectContent[i].messageId;
			}
			$.zjm_announce.delAnnounce(ids);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});
	
	/** 提交审批,将状态修改为"待审核"**/
	$("#btn_submitCheck").click(function(){
		var selectContent = $("#announce_table").bootstrapTable('getSelections');
		if(selectContent.length >= 1){
			var ids = [];
			for(var i=0;i<selectContent.length;i++){
				ids[i] = selectContent[i].messageId;
			}
			$.zjm_announce.checkInfo(ids);
		}else{
			$("#pleaseSelectOne").modal({keyboard:true});
		}
	});

});

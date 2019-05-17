(function($,z){
	$.zjm_meetingResolution = {
		meetingDetailAdd:meetingDetailAdd,//添加评审会明细内容
		meetingDetailEdit:meetingDetailEdit,//修改评审会明细内容
		meetingDetailDel:meetingDetailDel,//删除评审会明细内容
		initTree:initTree,
		updateMeetingResolution_Meeting:updateMeetingResolution_Meeting,//修改会议内容
		updateMeetingResolution:updateMeetingResolution,//修改决议内容
		initMeetingResolution:initMeetingResolution,
		initFirstTrialTable:initFirstTrialTable, //初始化初审文件列表
		initSecondTrialTable:initSecondTrialTable, //初始化复审文件列表
	};
	
	/**
	 *  初始化初审档案
	 */
	function initFirstTrialTable(){
		var defParam = {
				"uploadFileList" : "",//待上传的附件列表div ID
				"uploadConsoleList" : "",//错误信息提示div ID
				"btn_PickID" : "pickfiles",//选择附件按钮ID
				"btn_UploadID" : "",//上传按钮ID
				"uploadURL" : "",//上传的地址 
				"uploadParam" : {
					"fileOneType":"projFiles",//附件表分类
					"fileTwoType":"",//附件上传入口分类
					"fileFlag":"projFiles",//
					"entityID":"",
					"taskID":"",
					"clientID":""//客户id
				},//上传附加参数
				"fileList" : "fileList",//已上传的附件列表Table ID
				"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载意见附件列表数据地址
				"mimeTypes":[]//限定上传附件类型
		};
		$("#firstTrial_table").bootstrapTable('destroy');
		$('#firstTrial_table').bootstrapTable({
			method: 'get',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}},
						{field:"uploadDateTime",title: '日期',align: 'center',sortable:"true",formatter: function (value, row, index) {return tool.parseDate(row.uploadDateTime);}},
						{field:"sourceFileName",title: '档案名称',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.sourceFileName;}},
						{title: '附件',align: 'center',formatter: function (value, row, index) {
								return [
									'<a onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')" href="javascript:void(0)">下载</a>'
									].join('');
							},
						}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
			url: "/crm/filesUpload/selectAllProjectFileList",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var whereSql = " and fileType in ('004', '020', '007') and entityID = '"+$("#apply_ID").val()+"'";
				$.extend(params, {"uploadParam":defParam.uploadParam, "wheresql":whereSql});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
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
	}
	
	/**
	 *  初始化复审档案
	 */
	function initSecondTrialTable(){
		var defParam = {
				"uploadFileList" : "",//待上传的附件列表div ID
				"uploadConsoleList" : "",//错误信息提示div ID
				"btn_PickID" : "pickfiles",//选择附件按钮ID
				"btn_UploadID" : "",//上传按钮ID
				"uploadURL" : "",//上传的地址 
				"uploadParam" : {
					"fileOneType":"projFiles",//附件表分类
					"fileTwoType":"",//附件上传入口分类
					"fileFlag":"projFiles",//
					"entityID":"",
					"taskID":"",
					"clientID":""//客户id
				},//上传附加参数
				"fileList" : "fileList",//已上传的附件列表Table ID
				"fileListURL" : "/crm/filesUpload/selectAllProjectFileList",//加载意见附件列表数据地址
				"mimeTypes":[]//限定上传附件类型
		};
		$("#secondTrial_table").bootstrapTable('destroy');
		$('#secondTrial_table').bootstrapTable({
			method: 'get',
			columns: [	{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return index+1;}},
						{title: '序号',align: 'center',formatter: function (value, row, index) {return (index+1);}},
						{field:"uploadDateTime",title: '日期',align: 'center',sortable:"true",formatter: function (value, row, index) {return tool.parseDate(row.uploadDateTime);}},
						{field:"sourceFileName",title: '档案名称',align: 'center',sortable:"true",formatter: function (value, row, index) {return row.sourceFileName;}},
						{title: '附件',align: 'center',formatter: function (value, row, index) {
								return [
									'<a onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+row.sourceFileName+'&filePath='+row.pathFile+'\')" href="javascript:void(0)">下载</a>'
									].join('');
							},
						}
					],
			detailView: false,
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //设置为 true 会在表格底部显示分页条
			paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
			sortable: true,      //是否启用排序
			sortOrder: "",     //排序方式
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 30,      //每页的记录行数（*）
			pageList: [30, 50, 100, 200,500],  //可供选择的每页的行数（*）
			url: "/crm/filesUpload/selectAllProjectFileList",//这个接口需要处理bootstrap table传递的固定参数
			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: function(params) {
				var whereSql = " and fileType in ('006') and entityID = '"+$("#apply_ID").val()+"'";
				$.extend(params, {"uploadParam":defParam.uploadParam, "wheresql":whereSql});
				return params;
			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
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
	}
	
	/*$(".btn_closese").unbind("click");*/
	//初始化页面数据
	function initMeetingResolution(){
		var meetingResolution_ID = $("#meetingResolution_ID").val();	
		$("#meetingResolution_page").load("/pro/meetResolution/meetingResolution/returnMeetingResolutionPage",{"meetingResolution_ID":meetingResolution_ID},function(response,status,xhr){
			$("#meetingResolutionEdit").modal({keyboard:true});
		});
	}
	/**添加评审会明细*/
	function meetingDetailAdd(){
		var meetingResolution_ID = $("#meetingResolution_ID").val();
		var apply_ID = $("#apply_ID").val();
		$("#meetingResolution_page").load("/pro/meetResolution/meetingResolution/showMeetingDetailAdd",{"meetingResolution_ID":meetingResolution_ID,"apply_ID":apply_ID},function(response,status,xhr){
			$("#meetDetailAdd").modal({keyboard:true});
			initTree();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"meetDetailAdd_form"});
			//tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#meetDetailAdd_form").validationEngine("validate")){
					var queryContainer_form = $("#meetDetailAdd_form");
					$.ajax({type:'POST',url:'/pro/meetResolution/meetingResolution/insertOneMeetingDetail',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
				        		$("#meetDetailAdd").modal("hide");
				        		window.location.reload();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
				$("#meetDetailAdd").on("hidden.bs.modal", function (e) {
					 $(".btn_submit").unbind("click");
				});
			});
		});
	}
	
	function initTree(){
		/*获取合作机构下拉选择树*/
		$.ajax({type:'POST',url:'/sys/dic/selectBankSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data) {		
				$("#selectBank").selectTreeWidgets({
					width : "87%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
	        }
		});
		//获取业务品种下拉树;
		$.ajax({type:'POST',url:'/sys/dic/selectBusiSortDicTree',data:JSON.stringify({}),contentType:'application/json; charset=UTF-8',dataType:'json',
			success:function(data){		
				$("#busiSortDicTree").selectTreeWidgets({
					width : "87%",//设置控件宽度
					multiple : false,//是否多选
					data : data.obj//数据源
				});
			}
		});
	}
	//修改评审会明细内容
	function meetingDetailEdit(meetingDetail_ID){
		$("#meetingResolution_page").load("/pro/meetResolution/meetingResolution/showMeetingDetailEdit",{"meetingDetail_ID":meetingDetail_ID},function(response,status,xhr){
			$("#meetDetailEdit").modal({keyboard:true});
			initTree();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"meetDetailEdit_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				if($("#meetDetailEdit_form").validationEngine("validate")){
					var queryContainer_form = $("#meetDetailEdit_form");
					$.ajax({type:'POST',url:'/pro/meetResolution/meetingResolution/updateOneMeetingDetail',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
						success:function(data) {
				        	if(data.obj){
				        		$("#meetDetailEdit").modal("hide");
				        		window.location.reload();
							}else{
								alert("保存失败！");
								tool.undisabled(".btn_submit");
							}
						}
					});
				}else{
					tool.undisabled(".btn_submit");
				}
				$("#meetDetailEdit").on("hidden.bs.modal", function (e) {
					 $(".btn_submit").unbind("click");
				});
			});
		});
	}
	/**删除*/
	function meetingDetailDel(meetingDetail_ID){
		$("#meetingDetailDel").modal({keyboard:true});
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function(){
			$.ajax({type:'POST',url:'/pro/meetResolution/meetingResolution/deleteOnemeetingDetail',data:JSON.stringify({"meetingDetail_ID":meetingDetail_ID}),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
		        	if(data.obj==1){
						$("#meetingDetailDel").modal("hide");
						window.location.reload();
					}else{
						alert("删除失败！");
					}
		        }
			});
		});
	}
	//修改评审基本信息
	function updateMeetingResolution_Meeting(){
		var meetingResolution_ID = $("#meetingResolution_ID").val();	
		$("#meetingResolution_page").load("/pro/meetResolution/meetingResolution/returnMeetingResolutionPage",{"meetingResolution_ID":meetingResolution_ID,"flag":"1"},function(response,status,xhr){
			$("#reviewInfoEdit").modal({keyboard:true});
			zjm.init();
			/**注册编辑验证引擎*/
			$.ajax({type:'POST',
				url:'/pro/meetResolution/meetingResolution/selectMeetingJuryList',
				data:JSON.stringify({}),
				contentType:'application/json; charset=UTF-8',
				dataType:'json',
				success:function(data) {
				$("#userid").selectTreeWidgets({
					width : "90%",//设置控件宽度
					multiple : true,//是否多选
					data : data.obj//数据源
					});
		        }
		    });
			zjm.validata({formId:"updateResolutionMeeting_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateResolutionMeeting_form");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:'/pro/meetResolution/meetingResolution/updateMeetingResolution',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
									$("#reviewInfoEdit").modal("hide");
									window.location.reload();
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
					        }
						});
				}else{
					tool.undisabled(".btn_submit");
				}
			});
			$("#reviewInfoEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	};
	
	//修改决议内容
	function updateMeetingResolution(){
		var meetingResolution_ID = $("#meetingResolution_ID").val();	
		$("#meetingResolution_page").load("/pro/meetResolution/meetingResolution/returnMeetingResolutionPage",{"meetingResolution_ID":meetingResolution_ID,"flag":"2"},function(response,status,xhr){
			$("#meetingResolutionEdit").modal({keyboard:true});
			zjm.init();
			/*注册编辑验证引擎*/
			zjm.validata({formId:"updateMeetingResolution_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#updateMeetingResolution_form");
				if(queryContainer_form.validationEngine("validate")){
						$.ajax({type:'POST',url:'/pro/meetResolution/meetingResolution/updateMeetingResolution',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
					        	if(data.obj==1){
					        			
									$("#meetingResolutionEdit").modal("hide");
									window.location.reload();
									
								}else{
									alert("保存失败！");
									tool.undisabled(".btn_submit");
								}
					        }
						});
					}else{
						tool.undisabled(".btn_submit");
					}
			});
			$("#meetingResolutionEdit").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	/*
	function closeMeetingResolutionPage(apply_ID){
		window.parent.closeMenu('录入评审会决议'+apply_ID);
	}*/
})(jQuery, this);

$(function () {
	$.zjm_meetingResolution.initFirstTrialTable();
	$.zjm_meetingResolution.initSecondTrialTable();
	
	//添加批准担保基本信息
	$("#btn_addMeetingDetail").click(function(){
		$.zjm_meetingResolution.meetingDetailAdd();
	});
	//修改批准担保基本信息
	$(".btn_editMeetingDetail").click(function(e){
		$.zjm_meetingResolution.meetingDetailEdit(e.target.id);
	});
	//删除批准担保基本信息
	$(".btn_delMeetingDetail").click(function(e){
		$.zjm_meetingResolution.meetingDetailDel(e.target.id);
	});
	//修改决议基本信息
	$("#btn_updateMeetingResolution_Meeting").click(function(){
		$.zjm_meetingResolution.updateMeetingResolution_Meeting();
	});
	
	//修改决议内容 
	$("#btn_updateMeetingResolution").click(function(){
		$.zjm_meetingResolution.updateMeetingResolution();
	});
	/*//关闭页面
	$("#btn_close").click(function(){
		var  apply_ID = $("#apply_ID").val();
		$.zjm_meetingResolution.closeMeetingResolutionPage(apply_ID);
	});
	*/
	
	
	
});

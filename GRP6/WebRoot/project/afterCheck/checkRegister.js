(function($,z){
	$.zjm_checkRegister = {
			initTablePlan:initTablePlan,//初始化检查计划列表				
			checkDetail:checkDetail,//检查详情
			uploadFiles:uploadFiles, //上传 附件
			haha:haha, //
			delFiles:delFiles, //删除附件
			addCheckRegister:addCheckRegister  //添加保后检查计划
	};
	var type = tool.getUrlParam('type');//获取路径类型:查看/修改

	function haha(obj,e){
		var path=	e.target.name;
		var extend=path.substring(path.lastIndexOf(".")+1);
		if(extend == 'docx' || extend == 'doc' || extend == 'pdf' || extend == 'xlsx' || extend == 'xls' || extend == 'ppt' || extend == 'pptx'){
			window.parent.open("/sys/documentPreview/selectDocumentViewPage?domhref="+path+"&domextend="+extend+"");
		}else{
			window.parent.open(path);
		}
	}
	
	function delFiles(obj,e){
		console.info(e.target);
		var projectFiles_ID=e.target.name;
		
		
	    $("#pictureFileDelModule").modal({keyboard: true});
	    $(".btn_submit").click(function () {
	        tool.disabled(".btn_submit");
	        $.ajax({
	            type: 'POST',
	            url: '/optGuarantyAction/deleteOneInfoByProFiles_ID',
	            data: {"projectFiles_ID":projectFiles_ID},
	            dataType: 'json',
	            success: function (data) {
	                if (data.obj) {
	                    tool.undisabled(".btn_submit");
	                    $("#pictureFileDelModule").modal("hide");
	                  
	                	window.location.reload();
	                } else {
	                    alert("删除失败！");
	                    tool.undisabled(".btn_submit");
	                }
	            }
	        });
	    });
	    $("#pictureFileDelModule").on("hidden.bs.modal", function (e) {//解除事件绑定
	        $(".btn_submit").unbind("click");
	    });
	
	}
	//初始化列
	function initColumns(){
		var columns=[	
			{field:'index',title:'序号',align:'center',valign:'middle',formatter: function (value, row, index) {return index+1;}},
			{title: '计划检查日期',align: 'center',valign:'middle',sortable:"true",formatter: function (value, row, index) { return tool.parseDate(row.planCheckDate);}},
			{title: '实际检查日期',align: 'center',valign:'middle',formatter: function (value, row, index) { return tool.parseDate(row.factCheckDate);}},
			{title: '检查人员',align: 'center',valign:'middle',formatter: function (value, row, index) { return row.operatorName;}},
			{title: '原风险等级',align: 'center',valign:'middle',formatter: function (value, row, index) { return row.riskLevelName;}},
			{title: '调整后风险等级',align: 'center',valign:'middle',formatter: function (value, row, index) { return row.newRiskLevelName;}},
			{title: '检查内容',align: 'center',row:'3',valign:'middle',formatter: function (value, row, index) { return row.checkContent;}},
			{title: '检查情况',align: 'center',valign:'middle',formatter: function (value, row, index) { 
				var isOrNotFinish = "";
				if(row.isFinish == 0){
					isOrNotFinish="未完成";
				}else{
					isOrNotFinish="完成";
				}
				return isOrNotFinish;
			}},	
			{title : '附件',align : 'center',valign:'middle',
				formatter : function(value, row, index) {
					var arr=row.filesList;
					if(arr.length > 0){
						var elements="";
						var arrayElemets=[];
						$.each(arr,function(k,v){
							if(type=='edit'){
								elements="<a target='_blank' style='display:inline' class='dd' id='chakan"+k+"' title='查看附件' name='"+v.pathFile+"' href='javascript:void(0)'>"+v.sourceFileName+"</a> " +
								'&nbsp;&nbsp;&nbsp;<a title="下载附件" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+v.sourceFileName+'&filePath='+v.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></a>'+
								"&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' class='shanchu' title='删除附件' name='"+v.projectFiles_ID+"'><i class='icon-trash bigger-120'></i></a>"+"<br>"
							}else{
								elements="<a target='_blank' style='display:inline' class='dd' id='chakan"+k+"' title='查看附件' name='"+v.pathFile+"' href='javascript:void(0)'>"+v.sourceFileName+"</a><br> "+
								'&nbsp;&nbsp;&nbsp;<a title="下载附件" onclick="window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName='+v.sourceFileName+'&filePath='+v.pathFile+'\')"><i class="icon-download-alt bigger-120"></i></a><br>'
							}
							arrayElemets.push(elements);
						});
						return arrayElemets.join("");
					}else{
						return '-';
					}
				},
				events:{
					'click .dd':function (e,value,row,index){
						$.zjm_checkRegister.haha(row,e);
					} ,
					'click .shanchu':function(e,value,row,index){
						$.zjm_checkRegister.delFiles(row,e);
					}
				}
			},
			
			];
		
		if(type=='edit'){
			columns.push({title: '操作',align: 'center',valign:'middle',
				formatter:function(value,row,index){				
					return ['<a href="javascript:void(0)"  class="btn_truth_edit">上传附件&nbsp;&nbsp;&nbsp;</a><a href="javascript:void(0)"  class="btn_truth_add">录入检查结果</a>'].join('');				
				},
				events:{	
					'click .btn_truth_edit': function(e, value, row, index) {							
						$.zjm_checkRegister.uploadFiles(row);
					},
				
					'click .btn_truth_add': function(e, value, row, index) {							
						$.zjm_checkRegister.checkDetail(row);
					}
				}
			});
		}
		
		return columns;
	}
	
	/**初始化检查计划列表***/
	function initTablePlan(applyID){
		$("#checkPlan-table").bootstrapTable('destroy');
		$('#checkPlan-table').bootstrapTable({
			method: 'get',
			columns:initColumns() ,
				detailView: true,
				detailFormatter:function(index, row){
					function  getScanFile(){
						var arr=row.filesList;
						if(arr.length > 0){
							var elements="";
							var arrayElemets=[];
							$.each(arr,function(k,v){
								elements="<a target='_blank' title='查看附件' href='"+v.pathFile+"'>"+v.sourceFileName+"</a> <br>"
								arrayElemets.push(elements);
							});
							return arrayElemets.join("");
						}else{
							return '-';
						}
					}		
					
					var isFinish = row.isFinish;
					var isOrNotFinish = "";
					if(isFinish == null || typeof(billBeginDate)==undefined){	
						isOrNotFinish="（空）";
					}else{
						if(isFinish == 0){
							isOrNotFinish="未完成";
						}else{
							isOrNotFinish="完成";
						}
					}
					var planCheckDate = row.planCheckDate;
					if(planCheckDate==null || typeof(planCheckDate)==undefined){
						planCheckDate = "（空）";
					}else{
						planCheckDate = tool.parseDate(row.planCheckDate );
					}
					var factCheckDate = row.factCheckDate;
					if(factCheckDate==null || typeof(factCheckDate)==undefined){
						factCheckDate = "（空）";
					}else{
						factCheckDate = tool.parseDate(row.factCheckDate );
					}
					
					var html = [];			
					html.push('<p><b>计划检查日期:</b> ' +planCheckDate + '</p>');
					html.push('<p><b>实际检查日期:</b> ' + factCheckDate + '</p>');					
					html.push('<p><b>检查人员:</b> ' + tool.isNull(row.operatorName,"（空）")  + '</p>');
					html.push('<p><b>原风险等级:</b> ' + tool.isNull(row.riskLevelName,"（空）")  + '</p>');
					html.push('<p><b>调整后风险等级:</b> ' + tool.isNull(row.newRiskLevelName,"（空）")  + '</p>');
					html.push('<p><b>检查内容:</b> ' +  tool.isNull(row.checkContent,"（空）") + '</p>');
					html.push('<p><b>检查情况:</b> ' +  isOrNotFinish + '</p>');
					html.push('<p><b>附件：</b> <br>' +  getScanFile()+'</p>');
								
					return html;
				},
				striped: true,      //是否显示行间隔色
				cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）				
				paginationLoop: true,//设置为 true 启用分页条无限循环的功能。
				sortable: true,      //是否启用排序
				sortOrder: "asc",     //排序方式
				pageList: [10, 30, 50, 100],  //可供选择的每页的行数（*）
				url: "/project/afterCheck/selectCheckPlanListPageTables",//这个接口需要处理bootstrap table传递的固定参数
				queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort			
				queryParams: function(params) {
					$.extend(params, {"queryCondition":{"apply_ID":applyID}});
					return params;
				},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
				sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
				
		});
	}
	
	function  uploadFiles(row){
		 var fileTypeID = $(this).attr("id");;//图片类型id;
		 var checkPlan_ID=row.checkPlan_ID;
	        var defParam = {
	            "uploadFileList": "uploadFileList",//待上传的附件列表div ID
	            "uploadConsoleList": "uploadConsoleList",//错误信息提示div ID
	            "btn_PickID": "pickfiles",//选择附件按钮ID
	            "btn_UploadID": "upload",//上传按钮ID
	            "uploadURL": "/crm/filesUpload/insertOneFilesUpload",//上传的地址
	            "uploadParam": {
	                "isFile": false,
	                "clientFileType": fileTypeID,
	                "fileOneType": "projFiles",//附件表分类 -->项目附件
	                "fileTwoType": "03",//附件上传入口分类
	                "clientID": "",//客户id
	                "projectID": "",//项目id
	                "entityID":checkPlan_ID,
	                "fileFlag":"optFlag" // 附件来源标记
	            },//上传附加参数
	            "fileList": "fileList",//已上传的附件列表Table ID
	            "fileListURL": "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
	            "mimeTypes": [{title: "图片", extensions: "*"}] /* //限定上传附件类型  */
	        };
	        $("#uploadfiles").modal({keyboard: true});
	        $.zjm_meetingRoomAdd.initUpload(defParam);
	        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
	            uploader.destroy();
	            $("#pickfiles").unbind("click");
	            window.location.reload();
	        });
	    	
	}
	
	
	
	//项目详情
	function  checkDetail(row){
		window.parent.openMenu('viewCheckPlanDetail'+row.applyID,'','检查报告详情','/project/afterCheck/selectCheckDetailPage','&applyID='+row.apply_ID+'&checkPlan_ID='+row.checkPlan_ID+'&project_ID='+row.project_ID,2);

	}
	
	/**添加保后检查计划*/
	function addCheckRegister(apply_ID){
		$("#checkRegister_page").load("/project/afterCheck/showCheckRegisterAddPage",{"apply_ID":apply_ID},function(response,status,xhr){
			$("#addCheckRegi").modal({keyboard:true});
			/*注册编辑验证引擎*/
			zjm.validata({formId:"addCheckRegi_form"});
			tool.undisabled(".btn_submit");
			$(".btn_submit").click(function(){
				
				tool.disabled(".btn_submit");
				var queryContainer_form = $("#addCheckRegi_form");
				if($(queryContainer_form).validationEngine("validate")){
							$.ajax({type:'POST',url:'/project/afterCheck/addOneCheckRegister',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',
								success:function(data) {
						        	if(data.obj){
										$("#addCheckRegi").modal("hide");
										$.zjm_checkRegister.initTablePlan(apply_ID);
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
			$("#addCheckRegi").on("hidden.bs.modal", function (e) {//解除事件绑定
				 $(".btn_submit").unbind("click");
			});
		});
	}
	
	
})(jQuery, this);

$(function() {
	$('.date-picker').datepicker({
		autoclose : true
	}).next().on(ace.click_event, function() {
		$(this).prev().focus();
	});
	var applyID = tool.getUrlParam('entityID');

	$.zjm_checkRegister.initTablePlan(applyID);
	$("#btn_sort").click(function() {
		$("#sortop").modal({
			keyboard : true
		});
		zjm.dataSortVal("/sys/roles/selectRolesListJSON", {});
		tool.sort();
		tool.undisabled(".btn_submit");
		$(".btn_submit").click(function() {
			tool.disabled(".btn_submit");
			$.ajax({
				type : 'POST',
				url : '/updateSortOrder',
				data : JSON.stringify({
					"tableName" : "pro_checkPlan",
					"tableFileName" : "apply_ID",
					"tableFileIds" : $("#tableFileIds").val()
				}),
				contentType : 'application/json; charset=UTF-8',
				dataType : 'json',
				success : function(data) {
					if (data.obj == 1) {
						$("#sortop").modal("hide");
						$.zjm_checkRegister.initTablePlan(applyID);
					} else {
						alert("保存失败！");
						$.zjm_checkRegister.initTablePlan(applyID);
					}
				}
			});
		});

	});
	
	//添加保后检查计划
	$("#btn_addCheckRegister").click(function() {
		$.zjm_checkRegister.addCheckRegister(applyID);
	});
	
});


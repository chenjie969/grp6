(function($,z){
	$.zjm_projectUrgeLetter = {
			initUpload: initUpload, //初始化上传功能
			closeprojectUrgeLetterAdd:closeprojectUrgeLetterAdd,//关闭新增页面
			projectUrgeLetterAdd:projectUrgeLetterAdd,
			filesUpdate:filesUpdate,
			activateUploadBuild:activateUploadBuild,
			
	};
	
	function projectUrgeLetterAdd(){
		/**注册编辑验证引擎*/
		zjm.validata({
			formId:"projectUrgeLetterPage_form"
		});
		tool.disabled(".btn_projectUrgeLetterAdd");
		if($("#projectUrgeLetterPage_form").validationEngine("validate")){
			var queryContainer_form = $("#projectUrgeLetterPage_form");
			$.ajax({type:'POST',url:'/project/project/updateOneProjectIsUrgeLetter',data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				if(data.obj){
					$.zjm_projectUrgeLetter.closeprojectUrgeLetterAdd();
				}else{
					alert("保存失败！");
				}
	        }
		});
		}else{
			tool.undisabled(".btn_projectUrgeLetterAdd");
		}	
	
	}
	
	/**初始化-债权-列表***/
//	function initDelayTable(){
//		$('#projectCreditor_table').bootstrapTable('destroy');
//		$('#projectCreditor_table').bootstrapTable({
//			method: 'post',
//			columns: [	
//				//{field:'checked',checkbox:true,align: 'center',formatter: function (value, row, index) {return ;}},
//						{title: '序号',align: 'center',formatter: function (value, row, index) {return index+1;}}, 	
//						{field:"fundSource",title: '资金来源',align: 'center',formatter: function (value, row, index) { return row.fundSource;}},
//						{field:"fundType",title: '资金方类型',align: 'center',formatter: function (value, row, index) { return row.fundType;}},
////						{field:"loadSum",title: '担保金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.loadSum;}},
////						{field:"bankName",title: '放款机构',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.bankName;}},					
//						{field:"delaySum",title: '展期金额（万元）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delaySum;}},
//						{field:"delayBeginDate",title: '上报日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.delayBeginDate);}},
//						{field:"factBeginDate",title: '展期起始日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.factBeginDate);}},
//						{field:"delayEndDate",title: '展期到期日期',align: 'center',sortable : "true",formatter: function (value, row, index) { return tool.parseDate(row.delayEndDate);}},
//						{field:"delayMonthDay",title: '展期期限',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayMonthDay;}},
//						{field:"delayRate",title: '展期担保费率（%）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayRate;}},
//						{field:"delayServiceRate",title: '展期服务费率（‰）',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayServiceRate;}},
//						{field:"delayReason",title: '展期原因',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayReason;}},
//						//{field:"delayState",title: '审批状态',align: 'center',sortable : "true",formatter: function (value, row, index) { return row.delayState;}},
//						{title: '操作',align: 'center',formatter:function(value,row,index){
//								return [
//									'<button class="btn_projectDelay_edit btn btn-xs btn-info" title="修改" href="javascript:void(0)" ><i class="icon-pencil bigger-120"></i></button>',
//									'<button class="btn_projectDelay_del btn btn-xs btn-danger" title="删除" href="javascript:void(0)"  ><i class="icon-trash bigger-120"></i></button>'].join('');
//							},
//							events:{
//								'click .btn_projectDelay_edit': function(e, value, row, index) {
//									$.zjm_projectPayDelay.projectDelayEdit(row);
//								},
//								'click .btn_projectDelay_del': function(e, value, row, index) {
//									$.zjm_projectPayDelay.projectDelayDel(row);
//								}
//							}
//						}
//					],
//			detailView: false,
//			detailFormatter:function(index, row){
//			    var html = [];
//			        html.push('<p><b>申请编号：</b> ' + row.applyNum + '</p>');
//			    return html;
//			},
//			toolbar: '#toolbar',    //工具按钮用哪个容器
//			striped: true,      //是否显示行间隔色
//			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
//			pagination: false,     //设置为 true 会在表格底部显示分页条
//			paginationLoop: false,//设置为 true 启用分页条无限循环的功能。
//			sortable: true,      //是否启用排序
//			sortName:"delayEndDate",
//			sortOrder: "desc",     //排序方式
//			pageNumber:1,      //初始化加载第一页，默认第一页
//			pageSize: 30,      //每页的记录行数（*）
//			pageList: [30,50, 100, 200, 500],  //可供选择的每页的行数（*）
//			url: "/project/delay/selectDelayTable",//这个接口需要处理bootstrap table传递的固定参数
//			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
//			// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
//			queryParams: function(params) {
//				var queryCondition ={"apply_ID":$("#apply_ID").val()}; 
////				 var queryCondition ={"project_ID":$("#project_ID").val()}; 
//				 $.extend(params, {"queryCondition":queryCondition});
//				return params;
//			},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
//			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
//			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
//			strictSearch: false,//设置为 true启用 全匹配搜索，否则为模糊搜索
//			showColumns: false,     //是否显示所有的列
//			showRefresh: false,     //是否显示刷新按钮
//			minimumCountColumns: 2,    //最少允许的列数
//			clickToSelect: false,    //是否启用点击选中行
//			searchOnEnterKey: false,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
//			showToggle: false,//是否显示详细视图和列表视图的切换按钮
//			showPaginationSwitch:false,
//            showExport: false,                     //是否显示导出
//            exportDataType: "basic"              //basic', 'all', 'selected'
//		});
//	}
//	
	
	function closeprojectUrgeLetterAdd(){
		window.parent.closeMenu('loanApproval_page');
	}
	
	function filesUpdate(apply_ID){
    	console.log("----------"+apply_ID);
		var defParam = {
	            "uploadFileList": "uploadFileList",//待上传的附件列表div ID
	            "uploadConsoleList": "uploadConsoleList",//错误信息提示div ID
	            "btn_PickID": "pickfiles",//选择附件按钮ID
	            "btn_UploadID": "upload",//上传按钮ID
	            "uploadURL": "/crm/filesUpload/insertOneFilesUpload",//上传的地址
	            "uploadParam": {
	                	"fileOneType":"projFiles",//附件表分类 项目文件
	    				"fileTwoType":"101",//附件上传入口分类
	    				"clientID":"",//客户id
	    				"projectID":"",//项目id
	    				"fileFlag":"projFiles",
	    				"entityID":apply_ID,
	    				"uuid":""//文件uuid
	            },//上传附加参数
	            "fileList": "fileList",//已上传的附件列表Table ID
	            "fileListURL": "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
	            "mimeTypes": [
	            	{title : "文档", extensions : "*"}
	            ] /* //限定上传附件类型  */
	        };
		
    	
    	$("#uploadfiles").modal({keyboard: true});
        
        $.zjm_projectUrgeLetter.initUpload(defParam);
        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
            uploader.destroy();
            $("#pickfiles").unbind("click");
            window.location.reload();
        });
	}
	
	
	 function initUpload(param) {
	    	//defParam.uploadParam.fileTwoType=$("#fileType").val();
	        var defParam = {
	            "uploadFileList": "",//待上传的附件列表ID
	            "uploadConsoleList": "",//错误信息提示div ID
	            "btn_PickID": "",//选择附件按钮ID
	            "btn_UploadID": "",//上传按钮ID
	            "uploadURL": "",//上传的地址
	            "uploadParam": {
	                "isFile": "",
	                "clientFileType": "",
	                "fileOneType": "",//附件表分类
	                "fileTwoType": "",//附件上传入口分类
	                "clientID": "",//客户id
	                "projectID": "",//项目id
	                "entityID": ""
	            },//上传附加参数
	            "fileList": "",//待上传的附件列表ID
	            "fileListURL": "",//加载附件列表数据地址
	            "mimeTypes": ""//限定上传附件类型
	        };
	        defParam = $.extend(true, defParam, param);
	        $.zjm_projectUrgeLetter.activateUploadBuild(defParam);
	    }
	
	/**
     * 激活上传组件  基本的basic
     */
    function activateUploadBuild(defParam) {
        uploader = new plupload.Uploader({
            runtimes: 'html5,flash,silverlight,html4',
            browse_button: defParam.btn_PickID, // you can pass in id...
            //container: document.getElementById('container'), // ... or DOM Element itself
            url: defParam.uploadURL,
            multi_selection: true, //是否开启多个文件上传
            filters: {
                max_file_size: '100mb',
                mime_types: defParam.mimeTypes
            },
            flash_swf_url: '/js/Moxie.swf',// Flash settings
            silverlight_xap_url: '/js/Moxie.xap',// Silverlight settings
            multipart_params: defParam.uploadParam,//参数
            init: {
                PostInit: function () { // 初始化附件上传
                    document.getElementById(defParam.uploadFileList).innerHTML = '';
                    document.getElementById(defParam.btn_UploadID).onclick = function () {
                        uploader.start();
                    };
                    $("#" + defParam.uploadConsoleList + 'Div').text(''); // 清空错误信息
                },
                FilesAdded: function (up, files) {
                    /* if (up.files.length > 1){
                         up.splice(0, 1);//文件替换
                     }*/
                    $("#" + defParam.uploadConsoleList + 'Div').text(''); // 清空错误信息
                    plupload.each(files, function (file) {// 选中文件后，加载待上传文件列表
                        var args = '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ') <b><button class="btn btn-xs btn-danger" onclick="uploader.removeFile(\'' + file.id + '\');" ><i class="icon-trash bigger-120"></i></button></b></div>';
                        $("#" + defParam.uploadFileList).append(args);
                    });
                },
                FilesRemoved: function (up, files) { // 移除待上传文件
                    plupload.each(files, function (file) {
                        $("#" + file.id).remove();
                    });
                },
                UploadProgress: function (up, file) { // 显示上传进度
                    $("#" + file.id + ' b').html('<span>' + file.percent + "%</span>");
                },
                UploadComplete: function (up, files) { //上传成功后，在页面进行显示
                	$("#uploadfiles").modal("hide");
                	reloadAttachment();

                },
                Error: function (up, err) { // 错误信息
                    var htmlContainer = ['<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 错误信息 </label>' +
                    '<div class="col-sm-9" id="' + defParam.uploadConsoleList + '">' +
                    '</div>'];

                    if ($("#" + defParam.uploadConsoleList).length <= 0) {
                        $("#" + defParam.uploadConsoleList + "Div").append(htmlContainer.join(''));
                    }
                    $("#" + defParam.uploadConsoleList).text("\n" + err.code + ": " + err.message);
                }
            }
        });
        uploader.init();

    }
    
  //加载续保续贷相关附件
    function reloadAttachment(){
    	var fileType="101";
    	console.log("data-"+fileType);
        $.get("/pro/finish/getAttachments?fileType="+fileType+"&entityID=" + $("#apply_ID").val(), function (data) {
            $("#attachmentsDIV").empty();
            if (data.obj) {
            	var i = 0;
            	var aHref;
                $.each(data.obj, function (k, v) {
                	i++;
//                	if ("docx" == v.extend || v.extend ==  'doc' || v.extend ==  'pdf' || v.extend ==  'xlsx' || v.extend ==  'xls' || v.extend ==  'ppt' || v.extend ==  'pptx') {
//                		aHref = ["<div id='" + v.projectFiles_ID + "DIV'>"
//                			+i+"、"+
//            				"<a href='javascript:void(0)' onclick='window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref=+"+v.pathFile+"&domextend="+v.extend+"\')'>" + v.sourceFileName + "</a>",
//        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
//        					"<a href='javascript:void(0)' onclick='window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName=+"+v.sourceFileName+"&filePath="+v.pathFile+"\')'></a>",
//        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
//        					"<a href='javascript:void(0)' onclick='$.zjm_renewalFiles.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
//                        "<br/><div>"].join('');
//					}else{
//						aHref = ["<div id='" + v.projectFiles_ID + "DIV'>"
//                			+i+"、"+
//        					"<a href='javascript:void(0)' onclick='window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName=+"+v.sourceFileName+"&filePath="+v.pathFile+"\')'>" + v.sourceFileName + "</a>",
//        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
//        					"<a href='javascript:void(0)' onclick='$.zjm_renewalFiles.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
//                        "<br/><div>"].join('');
//					}
                    $("#attachmentsDIV").append(aHref);
                    //window.location.reload();
                })
            
            }
        })
    }
	/** 查看 企业客户信息 查看客户信息 客户详情**/
//	function viewCompanyClient(row){
//		window.parent.openMenu('view_companyClient'+row.client_ID,'','客户详情','/crm/client/companyClient/companyClientDetail.jsp','&client_ID='+row.client_ID+'&type=view');
//	};
	/***查看 个人客户信息 ***/
//	function viewPersonClient(row){
//		window.parent.openMenu('view_personClient'+row.client_ID,'','个人客户详情','/crm/client/personClient/personClientDetail.jsp','&client_ID='+row.client_ID+'&clientTypeID='+row.clientTypeID+'&type='+'view');
//	}
//	
//})(jQuery, this);

	$(".btn_projectUrgeLetterAdd").click(function(){
		$.zjm_projectUrgeLetter.projectUrgeLetterAdd();
	});
	$("#btn_closeprojectUrgeLetterAdd").click(function(){
		$.zjm_projectUrgeLetter.closeprojectUrgeLetterAdd();
	});
	$("#btn_projectUrgeLetterFilesUpdate").click(function(){
		$.zjm_projectUrgeLetter.filesUpdate();
	});
})(jQuery, this);
$(function () {
})
var uploader;


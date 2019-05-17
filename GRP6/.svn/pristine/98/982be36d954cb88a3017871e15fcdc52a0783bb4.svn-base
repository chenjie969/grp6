(function ($, z) {
    $.zjm_renewalFiles = {
        initUpload: initUpload, //初始化上传功能
        activateUploadBuild: activateUploadBuild,//激活上传组件基本的
        deleteOnePictureFile: deleteOnePictureFile,
        filesUpdate:filesUpdate,
        reloadAttachment:reloadAttachment,
        generate:generate,
    };
    function generate(){
    	var flowID;
		var applyID = $("#apply_ID").val();
		$("#renewal_page").load("/project/delay/showMouldTypePage",{"flowID":flowID,"applyID":applyID},function(response,status,xhr){
			$("#selectMouldType").modal({keyboard:true});
			tool.undisabled("#btn_submit");
			$("#btn_submit").click(function(){
				/*注册编辑验证引擎*/
				zjm.validata({formId:"form_selectMouldType"});
				tool.disabled("#btn_submit");
				var queryContainer_form = $("#form_selectMouldType");
				if(queryContainer_form.validationEngine("validate")){
					$.ajax({type:'POST',url:"/project/delay/generateDocument",data:JSON.stringify(queryContainer_form.serializeJson()),contentType:'application/json; charset=UTF-8',dataType:'json',success:function(data) {
				        	if(data.obj){
								reloadAttachment();
							}else{
								alert("保存失败！");
								tool.undisabled("#btn_submit");
							}
				        }
					});
				}else{
					tool.undisabled("#btn_submit");
				}
			});
			$("#selectMouldType").on("hidden.bs.modal", function (e) {//解除事件绑定
				$("#btn_submit").unbind("click");
			});
		});
	}
    //加载续保续贷相关附件
    function reloadAttachment(){
    	var fileType=$("#fileType").val();
    	console.log("data-"+fileType);
        $.get("/pro/finish/getAttachments?fileType="+fileType+"&entityID=" + $("#apply_ID").val(), function (data) {
            $("#attachmentsDIV").empty();
            if (data.obj) {
            	var i = 0;
            	var aHref;
                $.each(data.obj, function (k, v) {
                	window.location.reload();
                	i++;
                	/*if ("docx" == v.extend || v.extend ==  'doc' || v.extend ==  'pdf' || v.extend ==  'xlsx' || v.extend ==  'xls' || v.extend ==  'ppt' || v.extend ==  'pptx') {
                		aHref = ["<div id='" + v.projectFiles_ID + "DIV'>"
                			+i+"、"+
            				"<a href='javascript:void(0)' onclick='window.parent.open(\'/sys/documentPreview/selectDocumentViewPage?domhref=+"+v.pathFile+"&domextend="+v.extend+"\')'>" + v.sourceFileName + "</a>",
        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        					"<a href='javascript:void(0)' onclick='window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName=+"+v.sourceFileName+"&filePath="+v.pathFile+"\')'></a>",
        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        					"<a href='javascript:void(0)' onclick='$.zjm_renewalFiles.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
                        "<br/><div>"].join('');
					}else{
						aHref = ["<div id='" + v.projectFiles_ID + "DIV'>"
                			+i+"、"+
        					"<a href='javascript:void(0)' onclick='window.parent.open(\'/crm/filesUpload/selectOneFilesDownload?fileName=+"+v.sourceFileName+"&filePath="+v.pathFile+"\')'>" + v.sourceFileName + "</a>",
        					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        					"<a href='javascript:void(0)' onclick='$.zjm_renewalFiles.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.projectFiles_ID + "'>" + '删除' + "</a>",
                        "<br/><div>"].join('');
					}*/
                	
            		
                    $("#attachmentsDIV").append(aHref);
                })
            
            }
        })
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
        $.zjm_renewalFiles.activateUploadBuild(defParam);
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

    //删除附件文件;
    function deleteOnePictureFile(projectFiles_ID, pathFile) {
        $.ajax({
                type: 'POST',
                url: '/pro/finish/deleteAttachment',
                data: {"projectFiles_ID": projectFiles_ID, "pathFile": pathFile},
                dataType: 'json',
                success: function (data) {
                    if (data.obj) {
                    	reloadAttachment();
                    } else {
                        console.log("删除失败！");
                    }
                }
            }
        )
    }
   
    function filesUpdate(apply_ID){
    	console.log("----------"+$("#fileType").val());
		var defParam = {
	            "uploadFileList": "uploadFileList",//待上传的附件列表div ID
	            "uploadConsoleList": "uploadConsoleList",//错误信息提示div ID
	            "btn_PickID": "pickfiles",//选择附件按钮ID
	            "btn_UploadID": "upload",//上传按钮ID
	            "uploadURL": "/crm/filesUpload/insertOneFilesUpload",//上传的地址
	            "uploadParam": {
	                	"fileOneType":"projFiles",//附件表分类 项目文件
	    				"fileTwoType":$("#fileType").val(),//附件上传入口分类
	    				"clientID":"",//客户id
	    				"projectID":"",//项目id
	    				"fileFlag":"06",
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
        
        $.zjm_renewalFiles.initUpload(defParam);
        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
            uploader.destroy();
            $("#pickfiles").unbind("click");
            window.location.reload();
        });
	}
    
})(jQuery, this);


$(function () {
	

})
var uploader;


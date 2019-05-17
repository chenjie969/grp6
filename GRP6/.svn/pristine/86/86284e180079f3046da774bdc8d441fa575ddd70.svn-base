(function ($, z) {
    $.zjm_meetingRoomAdd = {
        activateUploadBuild: activateUploadBuild,//激活上传组件基本的
        initUpload:initUpload // 初始化上传控件
    };
    
})(jQuery, this); // end zjm_meetingRoomAdd





$(function () {
	
	$("#avatar").click(function () {
        var fileTypeID = $(this).attr("id");;//图片类型id;
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
                "fileTwoType": "补充文档",//附件上传入口分类
                "flowID": $("#flowID").val(),//流程实例id
                "stepID": $("#stepID").val(),// 节点id
                "taskID": $("#taskID").val()// 事项id
            },//上传附加参数
            "fileList": "fileList",//已上传的附件列表Table ID
            "fileListURL": "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
            "mimeTypes": [{title: "文档", extensions: "doc,docx,pdf"}] /* //限定上传附件类型  */
        };
        
    	
    	$("#uploadfiles").modal({keyboard: true});
        
        $.zjm_meetingRoomAdd.initUpload(defParam);
        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
            uploader.destroy();
            $("#pickfiles").unbind("click");
        });
    });

	
	//模态窗关闭后执行的事件
	$("#btnClose").click(function(){
		$.zjm_documentManager.disposeTable(); 
	});
	//模态窗关闭后执行的事件
	$("#btnClose2").click(function(){
		$.zjm_documentManager.disposeTable(); 
	});
	
})
var uploader;

/**
 * 初始化上传按钮
 */
function initUpload(param) {
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
            "entityID": $("#entityID").val(),
            "fileFlag":"optFlag"  // 文件上传标记
        },//上传附加参数
        "fileList": "",//待上传的附件列表ID
        "fileListURL": "",//加载附件列表数据地址
        "mimeTypes": "" , //限定上传附件类型
    };
    defParam = $.extend(true, defParam, param);
    $.zjm_meetingRoomAdd.activateUploadBuild(defParam);
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
                $("#"+defParam.uploadConsoleList+'Div').text(''); // 清空错误信息
            },
            FilesAdded: function (up, files) {
               /* if (up.files.length > 1){ 
                	up.splice(0, 1);//文件替换
                }*/
            	 $("#"+defParam.uploadConsoleList+'Div').text(''); // 清空错误信息
                plupload.each(files, function (file) {// 选中文件后，加载待上传文件列表
                    var args= '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ') <b><button class="btn btn-xs btn-danger" onclick="uploader.removeFile(\'' + file.id + '\');" ><i class="icon-trash bigger-120"></i></button></b></div>';
                    $("#"+defParam.uploadFileList).append(args);
                });
            },
            FilesRemoved: function (up, files) { // 移除待上传文件
                plupload.each(files, function (file) {
                    $("#" + file.id).remove();
                });
            },
            UploadProgress: function (up, file) { // 显示上传进度
                $("#"+file.id+' b').html('<span>' + file.percent + "%</span>");
            },
            UploadComplete: function (up, files) { //上传成功后，在页面进行显示
            	
            },
            Error: function (up, err) { // 错误信息
                var htmlContainer = ['<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 错误信息 </label>' +
                '<div class="col-sm-9" id="' + defParam.uploadConsoleList + '">' +
                '</div>'];
                
                if ($("#" + defParam.uploadConsoleList).length <= 0) {
                    $("#" + defParam.uploadConsoleList + "Div").append(htmlContainer.join(''));
                }
                $("#"+defParam.uploadConsoleList).text("\n" + err.code + ": " + err.message);
            }
        }
    });
    uploader.init();

}


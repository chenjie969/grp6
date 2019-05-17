(function ($, z) {
    $.zjm_meetingApply = {
        initUpload: initUpload, //初始化上传功能
        activateUploadBuild: activateUploadBuild,//激活上传组件基本的
        deleteOnePictureFile: deleteOnePictureFile
    };

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
                "entityID": $("#optGuaranty_ID").val()
            },//上传附加参数
            "fileList": "",//待上传的附件列表ID
            "fileListURL": "",//加载附件列表数据地址
            "mimeTypes": ""//限定上传附件类型
        };
        defParam = $.extend(true, defParam, param);
        $.zjm_meetingApply.activateUploadBuild(defParam);
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
                    $.get("/oa/meeting/getAttachments?entityID=" + $("#meeting_ID").val(), function (data) {
                        $("#attachmentsDIV").empty();
                        if (data.obj) {
                            $.each(data.obj, function (k, v) {
                                var aHref = ["<div id='" + v.files_ID + "DIV'><a href='" + v.pathFile + "' target='_blank'>" + v.sourceFileName + "</a>",
                                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                                    "<a href='javascript:void(0)' onclick='$.zjm_meetingApply.deleteOnePictureFile(this.id,this.name)' name='" + v.pathFile + "' id='" + v.files_ID + "'>" + '删除' + "</a>",
                                    "<br/><div>"].join('');
                                $("#attachmentsDIV").append(aHref);
                            })
                        }
                    })

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

//删除图片文件;
    function deleteOnePictureFile(files_ID, pathFile) {
        $.ajax({
                type: 'POST',
                url: '/oa/meeting/deleteAttachment',
                data: {"files_ID": files_ID, "pathFile": pathFile},
                dataType: 'json',
                success: function (data) {
                    if (data.obj) {
                        $("#" + files_ID + "DIV").remove();
                    } else {
                        console.log("删除失败！");
                    }
                }
            }
        )

    }
})(jQuery, this);


$(function () {


    $("#attachment").click(function () {
        var defParam = {
            "uploadFileList": "uploadFileList",//待上传的附件列表div ID
            "uploadConsoleList": "uploadConsoleList",//错误信息提示div ID
            "btn_PickID": "pickfiles",//选择附件按钮ID
            "btn_UploadID": "upload",//上传按钮ID
            "uploadURL": "/crm/filesUpload/insertOneFilesUpload",//上传的地址
            "uploadParam": {
                "fileOneType": "oaFiles",//附件表分类 -->项目附件
                "fileTwoType": "03",//附件上传入口分类
                "entityID": $("#meeting_ID").val(),//客户id
                "fileFlag": "optFlag" // 附件来源标记
            },//上传附加参数
            "fileList": "fileList",//已上传的附件列表Table ID
            "fileListURL": "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
            "mimeTypes": [{title: "图片", extensions: "jpg,gif,png,jpeg"}] /* //限定上传附件类型  */
        };
        $("#uploadfiles").modal({keyboard: true});
        $.zjm_meetingApply.initUpload(defParam);
        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
            uploader.destroy();
            $("#pickfiles").unbind("click");
        });
    });


})
var uploader;


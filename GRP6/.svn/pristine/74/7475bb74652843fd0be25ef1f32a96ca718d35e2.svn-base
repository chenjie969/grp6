(function ($, z) {
    $.zjm_contractDocUpload = {
        initDate: initDate,//初始化函数
        initUpload: initUpload, //初始化上传功能
        activateUploadBuild: activateUploadBuild,//激活上传组件基本的
        deleteOnePictureFile: deleteOnePictureFile,
        initFileList:initFileList // 初始化文件列表
    };

    //初始化函数;
    function initDate() {
        var uploadParam = {
            "isFile": false,
            "clientFileType": "",
            "name": "",
            "fileOneType": "clientFiles",//客户附件
            "fileTwoType": "02",//附件上传入口分类
            "clientID": $("#client_ID").val(),//客户id
            "projectID": ""//项目id

        };
        $("#pictureFileIndex").load("/crm/filesUpload/selectPictureFileList", uploadParam, function () {
            }
        );
    };
    
    
    function initFileList (){
	  $.get("/optGuarantyAction/selectProFilesListByCheckPlanID?checkPlan_ID=" + $("#checkPlan_ID").val(), function (data) {
   /*   	$("#fujianDiv").empty();
      	if (data.obj) {
      		$.each(data.obj,function(k,v){
      			var aHref=["<div id='"+v.projectFiles_ID+"DIV'><a href='"+v.pathFile+"' target='_blank'>"+v.sourceFileName+"</a>",
      				'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
      				"<a href='javascript:void(0)' onclick='deleteOnePictureFile(this.id,this.name)' name='"+v.pathFile+"' id='"+v.projectFiles_ID+"'>"+'删除'+"</a>",
      				 "<br/><div>"].join('');	
      			$("#fujianDiv").append(aHref);
      		})
          }*/
      })
    }
    
    
})(jQuery, this); // end zjm_contractDocUpload





$(function () {
	/**
	 * 初始化加载列表
	 */
	$.zjm_contractDocUpload.initFileList();
	function avatar() {
        var fileTypeID = $(this).attr("id");;//图片类型id;
        var defParam = {
            "uploadFileList": "uploadFileList",//待上传的附件列表div ID
            "uploadConsoleList": "uploadConsoleList",//错误信息提示div ID
            "btn_PickID": "pickfiles",//选择附件按钮ID
            "btn_UploadID": "upload",//上传按钮ID
            "uploadURL": "/pro/contractdoc/insertOneFilesUpload",//上传的地址
            "uploadParam": {
                "isFile": false,
                "clientFileType": '',
                "fileOneType": "projFiles",//附件表分类 -->项目附件
                "fileTwoType": "02",//附件上传入口分类
                "clientID": "",//客户id
                "projectID": "",//项目id
                "fileFlag":"optFlag" // 附件来源标记
            },//上传附加参数
            "fileList": "fileList",//已上传的附件列表Table ID
            "fileListURL": "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
            "mimeTypes": [{title: "图片", extensions: "*"}] /* //限定上传附件类型  */
        };
        $("#uploadfiles").modal({keyboard: true});
        $.zjm_contractDocUpload.initUpload(defParam);
        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
            uploader.destroy();
            $("#pickfiles").unbind("click");
        });
    }

		
	
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
            "entityID": $("#applyID").val()
        },//上传附加参数
        "fileList": "",//待上传的附件列表ID
        "fileListURL": "",//加载附件列表数据地址
        "mimeTypes": ""//限定上传附件类型
    };
    defParam = $.extend(true, defParam, param);
    $.zjm_contractDocUpload.activateUploadBuild(defParam);
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
        multi_selection: false, //是否开启多个文件上传
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
                if (up.files.length > 1){ 
                	up.splice(0, 1);//文件替换
                }
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
/*            UploadComplete: function (up, files) { //上传成功后，在页面进行显示
                $.get("/optGuarantyAction/selectProFilesListByEntityID?entityID=" + $("#applyID").val(), function (data) {
                	$("#fujianDiv").empty();
                	if (data.obj) {
                		$.each(data.obj,function(k,v){
                			var aHref=["<div id='"+v.projectFiles_ID+"DIV'><a href='"+v.pathFile+"' target='_blank'>"+v.sourceFileName+"</a>",
                				'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
                				"<a href='javascript:void(0)' onclick='deleteOnePictureFile(this.id,this.name)' name='"+v.pathFile+"' id='"+v.projectFiles_ID+"'>"+'删除'+"</a>",
                				 "<br/><div>"].join('');	
                			$("#fujianDiv").append(aHref);
                		})
                    }
                })

            },*/
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

//删除图片文件;
function deleteOnePictureFile(projectFiles_ID,pathFile) {
    $("#pictureFileDelModule").modal({keyboard: true});
    $(".btn_submit").click(function () {
        tool.disabled(".btn_submit");
        $.ajax({
            type: 'POST',
            url: '/optGuarantyAction/deleteOneInfoByProFiles_ID',
            data: {"projectFiles_ID":projectFiles_ID,"pathFile":pathFile},
            dataType: 'json',
            success: function (data) {
                if (data.obj) {
                    tool.undisabled(".btn_submit");
                    $("#pictureFileDelModule").modal("hide");
                    $("#"+projectFiles_ID+"DIV").remove();

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

    

};
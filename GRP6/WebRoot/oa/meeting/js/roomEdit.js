(function ($, z) {
    $.zjm_meetingRoomAdd = {
        initDate: initDate,//初始化函数
        initUpload: initUpload, //初始化上传功能
        activateUploadBuild: activateUploadBuild,//激活上传组件基本的
        deleteOnePictureFile: deleteOnePictureFile,
    };

    //初始化函数;
    function initDate() {
        var uploadParam = {
            "isFile": false,
            "clientFileType": "",
            "name": "",
            "fileOneType": "oaFiles",//客户附件
            "fileTwoType": "02",//附件上传入口分类
            "clientID": $("#client_ID").val(),//客户id
            "projectID": ""//项目id

        };
        $("#pictureFileIndex").load("/crm/filesUpload/selectPictureFileList", uploadParam, function () {
            }
        );
    };
})(jQuery, this);
$(function () {
    $("#avatar").click(function () {
        var fileTypeID = "";//图片类型id;
        fileTypeID = $(this).attr("id");
        var defParam = {
            "uploadFileList": "uploadFileList",//待上传的附件列表div ID
            "uploadConsoleList": "uploadConsoleList",//错误信息提示div ID
            "btn_PickID": "pickfiles",//选择附件按钮ID
            "btn_UploadID": "upload",//上传按钮ID
            "uploadURL": "/crm/filesUpload/insertOneFilesUpload",//上传的地址
            "uploadParam": {
                "isFile": false,
                "clientFileType": fileTypeID,
                "fileOneType": "oaFiles",//附件表分类
                "fileTwoType": "02",//附件上传入口分类
                "clientID": $("#client_ID").val(),//客户id
                "projectID": ""//项目id
            },//上传附加参数
            "fileList": "fileList",//已上传的附件列表Table ID
            "fileListURL": "/crm/filesUpload/selectPictureFileList",//加载附件列表数据地址
            "mimeTypes": [{title: "图片", extensions: "jpg,gif,png,jpeg"}]
            /* //限定上传附件类型  */
        };
        $("#uploadfiles").modal({keyboard: true});
        $.zjm_meetingRoomAdd.initUpload(defParam);
        $("#uploadfiles").on("hidden.bs.modal", function (e) {//解除事件绑定
            uploader.destroy();
            $("#pickfiles").unbind("click");
        });
    });
    $("#close").on("click", function () {
        window.parent.closeMenu("meetingRoomEdit");
    });

    $.ajax({
        type: 'POST',
        url: '/sys/dic/selectDepartsUserTreeTwo',
        data: JSON.stringify({}),
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (data) {
            var selected = $("#managerNameList").attr("data-selected");
            if (!Array.isArray(selected)) {
                selected = [].push(selected);
            }

            $("#managerSelectScope").selectTreeWidgets({
                width: "93%",//设置控件宽度
                multiple: true,//是否多选
                data: data.obj//数据源
            });
        }
    });

    $("#meeting_room_edit").validationEngine();
    $("#meeting_room_edit").on("submit", function () {
        var $form = $("#meeting_room_edit");
        var data = $form.serializeJson();

        var equipmentIDList = [];
        var equipmentNameList = [];
        $("#equipments i.active").each(function (index, item) {
            equipmentIDList.push($(item).attr("id"));
            equipmentNameList.push($(item).attr("title"))
        });
        var openTime = [];
        $("[name='openDays']:checked").each(function (index, item) {
            openTime.push(item.value);
        })
        data["equipmentIDList"] = equipmentIDList.join(",");
        data["equipmentNameList"] = equipmentNameList.join(",");
        data["meetingRoomTypeName"] = $("#meetingRoomTypeID").find("option:selected").text().trim();
        data["openTime"] = openTime.join(",");

        if (zjm.ajaxValidata("meetingRoomName", "/oa/meetingRoom/meetingRoomNameExists", JSON.stringify({
                "meetingRoomName": $("#meetingRoomName").val(),
                "meetingRoom_ID": $("#meetingRoom_ID").val()
            }), "会议室名称重复！") && $form.validationEngine("validate")) {
            $.ajax({
                type: 'post',
                url: '/oa/meetingRoom/update',
                data: JSON.stringify(data),
                contentType: 'application/json; charset=UTF-8',
                dataType: 'json',
                success: function (result) {
                    
                    if (result.obj === 1) {
                        $("#pleaseSelectOne #message").text("保存成功！");
                        $("#pleaseSelectOne").modal({keyboard: true});
                        $('#pleaseSelectOne').on('hidden.bs.modal', function (e) {
                            window.parent.closeMenu("meetingRoomEdit");
                        })
                    } else {
                        $("#pleaseSelectOne #message").text("保存失败，请重试！");
                        $("#pleaseSelectOne").modal({keyboard: true});
                    }
                }
            })
        }
        return false;
    })
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
            "entityID": $("#meetingRoom_ID").val()
        },//上传附加参数
        "fileList": "",//待上传的附件列表ID
        "fileListURL": "",//加载附件列表数据地址
        "mimeTypes": ""//限定上传附件类型
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
        multi_selection: false,
        filters: {
            max_file_size: '100mb',
            mime_types: defParam.mimeTypes
        },
        flash_swf_url: '/js/Moxie.swf',// Flash settings
        silverlight_xap_url: '/js/Moxie.xap',// Silverlight settings
        multipart_params: defParam.uploadParam,//参数
        init: {
            PostInit: function () {
                document.getElementById(defParam.uploadFileList).innerHTML = '';
                document.getElementById(defParam.btn_UploadID).onclick = function () {
                    uploader.start();
                };
            },
            FilesAdded: function (up, files) {
                console.log(up.files)
                if (up.files.length > 1)
                    up.splice(0, 1)
                plupload.each(files, function (file) {
                    document.getElementById(defParam.uploadFileList).innerHTML = '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ') <b><button class="btn btn-xs btn-danger" onclick="uploader.removeFile(\'' + file.id + '\');" ><i class="icon-trash bigger-120"></i></button></b></div>';
                });
            },
            FilesRemoved: function (up, files) {
                plupload.each(files, function (file) {
                    $("#" + file.id).remove();
                });
            },
            UploadProgress: function (up, file) {
                document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
            },
            UploadComplete: function (up, files) {
                $.get("/oa//meetingRoom/getPicUrl?entityID=" + $("#meetingRoom_ID").val(), function (data) {
                    if (data.obj && data.obj.pathFile) {
                        $("#avatar").attr("src", data.obj.pathFile);
                    }
                    console.log(data);
                })

            },
            Error: function (up, err) {
                var htmlContainer = ['<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 错误信息 </label>' +
                '<div class="col-sm-9" id="' + defParam.uploadConsoleList + '">' +
                '</div>'];

                if ($("#" + defParam.uploadConsoleList).length <= 0) {
                    $("#" + defParam.uploadConsoleList + "Div").append(htmlContainer.join(''));
                }
                document.getElementById(defParam.uploadConsoleList).innerHTML += "\n" + err.code + ": " + err.message;
            }
        }
    });
    uploader.init();

}

//删除图片文件;
function deleteOnePictureFile(clientFiles_ID, pathFile, clientID) {
    var datas = {"fileID": clientFiles_ID, "filePath": pathFile, "clientID": clientID, "fileOneType": "clientFiles"};
    $("#pictureFileDelModule").modal({keyboard: true});
    $(".btn_submit").click(function () {
        tool.disabled(".btn_submit");
        $.ajax({
            type: 'POST',
            url: '/crm/filesUpload/delectOneFilesInfo',
            data: JSON.stringify(datas),
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (data) {
                if (data.obj) {
                    tool.undisabled(".btn_submit");
                    $("#pictureFileDelModule").modal("hide");
                    $.zjm_pictureFileIndex.initDate();
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
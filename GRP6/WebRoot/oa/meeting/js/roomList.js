/**
 * 保证措施管理---js
 * author: lancepro
 * 2017年7月11日 15:25:25
 */

(function ($, z) {
    window.optManager = {
        refreshTable: refreshTable,
    };

    function refreshTable() {
        $.zjm_optManager.initTable();
    }

    $.zjm_optManager = {
        initTable: initTable,	//初始化列表
        mergeCells: mergeCells,	//合并单元格
        addOptGuaranty: addOptGuaranty,	//保证措施管理 --- 新增 保证措施
        chooseProj: chooseProj,	//保证措施管理 --- 新增 --选择 项目名称
        choosePerson: choosePerson,	//保证措施管理 --- 新增 --选择 权属人
        addPerson: addPerson,	//保证措施管理 --- 新增 --新增 -- 权属人
        realizeOptGuaranty: realizeOptGuaranty,//保证措施管理 -- 落实 保证措施
        relieveOptGuaranty: relieveOptGuaranty,//保证措施管理 -- 解除 保证措施
        disposeOptGuaranty: disposeOptGuaranty,//保证措施管理 -- 处置 保证措施
        deleteOptGuaranty: deleteOptGuaranty,//保证措施管理 -- 删除所选
        highOptQuery: highOptQuery,//保证措施管理 -- 高级查询
        optGuarantyView: optGuarantyView, // 查看 一条保证措施
        optGuarantyEdit: optGuarantyEdit, // 修改一条保证措施
        optGuarantyDel: optGuarantyDel,  // 删除一条保证措施
        executeDel: executeDel // 具体执行删除的函数
    };

    /**初始化主体列表***/
    function initTable(data) {

    }

    /**
     * 合并单元格
     */
    function mergeCells() {
        $('#optManager_table').bootstrapTable('mergeCells', {
            index: 2,
            field: 'creditBH',
            rowspan: 2,
        });
    }

    /**
     * 新增 担保措施
     */
    function addOptGuaranty() {
        /*$("#optGuaranty_page").load("/optGuarantyAction/addOptGuarantyPage",{},function(response,status,xhr){
            $("#optGuarantyAddPage").modal({keyboard:true});
            注册日期控件点击事件
            $('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
                $(this).prev().focus();
            });
        });	*/

        window.parent.openMenu('add_OptGuaranty', '', '新增保证措施', '/optGuarantyAction/addOptGuarantyPage', '');

    }

    /**
     * 保证措施管理 -- 落实 保证措施
     */
    function realizeOptGuaranty() {
        $("#optGuaranty_page").load("/optGuarantyAction/realizeOptGuarantyPage", {}, function (response, status, xhr) {
            $("#realizeOptGuarantyPage").modal({keyboard: true});
            /*注册日期控件点击事件*/
            $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
                $(this).prev().focus();
            });


        });
    }

    /**
     * 保证措施管理 -- 解除 保证措施
     */
    function relieveOptGuaranty() {
        $("#optGuaranty_page").load("/optGuarantyAction/relieveOptGuarantyPage", {}, function (response, status, xhr) {
            $("#relieveOptGuarantyPage").modal({keyboard: true});
            /*注册日期控件点击事件*/
            $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
                $(this).prev().focus();
            });


        });
    }

    /**
     * 保证措施管理 -- 处置 保证措施
     */
    function disposeOptGuaranty() {
        $("#optGuaranty_page").load("/optGuarantyAction/disposeOptGuarantyPage", {}, function (response, status, xhr) {
            $("#disposeOptGuarantyPage").modal({keyboard: true});


        });
    }

    /**
     * 保证措施管理 -- 删除所选
     */
    function deleteOptGuaranty() {
        var selectValue = $('#optManager_table').bootstrapTable('getSelections');
        if (selectValue.length < 1) {
            $("#pleaseSelectOne").modal({keyboard: true});
            return;
        }
        $("#optGuaranty_page").load("/optGuarantyAction/deleteOptGuarantyPage", {}, function (response, status, xhr) {
            $("#deleteOptGuarantyPage").modal({keyboard: true});
            $.each(selectValue, function (key, value) {
                $.zjm_optManager.executeDel(value);
            });
        });
    }

    /**
     * 保证措施管理 -- 高级查询
     */
    function highOptQuery() {
        $("#optGuaranty_page").load("/optGuarantyAction/highOptQueryPage", {}, function (response, status, xhr) {
            $("#highOptQueryPage").modal({keyboard: true});


        });
    }

    /**
     * 查看 一条担保措施
     */
    function optGuarantyView(row) {
        alert("查看 一条担保措施" + row);
    }

    /**
     * 编辑 一条担保措施
     */
    function optGuarantyEdit(row) {
        //	window.parent.openMenu('view_creditApply_'+row.apply_ID,'','查看授信申请信息','/project/credit/viewOneCreditApply','&apply_ID='+row.apply_ID);
        console.info(row);
        window.parent.openMenu('update_OptGuaranty' + row.optGuaranty_ID, '', '修改保证措施', '/optGuarantyAction/updateOptGuarantyPage',
            '&apply_ID=' + row.apply_ID + '&guarantyTypeID=' + row.guarantyTypeID + '&optTypeID=' + row.optTypeID +
            '&optGuaranty_ID=' + row.optGuaranty_ID + '&pageFlag=edit'
        );
    }

    /**
     * 删除 一条担保措施
     */
    function optGuarantyDel(row) {
        $("#optGuaranty_page").load("/optGuarantyAction/deleteOptGuarantyPage", {}, function (response, status, xhr) {
            $("#deleteOptGuarantyPage").modal({keyboard: true});
            $.zjm_optManager.executeDel(row);
        });
    }

    /**
     * 保证措施管理 --- 新增 --选择 项目名称
     */
    function chooseProj() {
        alert("新增 --选择 项目名称");
    }

    /**
     * 保证措施管理 --- 新增 --选择 权属人
     */
    function choosePerson() {
        alert("新增 --选择 权属人");
    }

    /**
     * 保证措施管理 --- 新增 --新增 -- 权属人
     */
    function addPerson() {
        alert("新增 --新增 -- 权属人");
    }

    /**
     * 具体执行删除操作的函数
     */
    function executeDel(row) {
        tool.undisabled(".btn_submit");
        $(".btn_submit").click(function () {
            tool.disabled(".btn_submit");
            $.ajax({
                type: 'POST',
                url: '/optGuarantyAction/deleteOneOptGuarantyInfo',
                data: {'optGuaranty_ID': row.optGuaranty_ID},
//				contentType : 'application/json; charset=UTF-8',
                contentType: 'application/x-www-form-urlencoded',
                dataType: 'json',
                success: function (data) {
                    if (data.obj == true) {
                        $("#deleteOptGuarantyPage").modal("hide");
                        $.zjm_optManager.initTable()
                    } else {
                        $("#failDel").modal({keyboard: true});
                    }
                }
            });
        });
        $("#deleteOptGuarantyPage").on("hidden.bs.modal", function (e) {// 解除事件绑定
            $(".btn_submit").unbind("click");
        });
    }


})(jQuery, this);

$(function () {
    /**
     * 文档加载的时候 读取
     */
    window.onload = floaddata;
    window.equipmentClassMap = {
        "b2a1bcda926848c480ee1e5977182633": "labtop",
        "98499bb97a434d769c1f51511a48ab98": "banner",
        "bc6c8a8031d44a92b1a5779e31de5e89": "camera",
        "40cdf457a27348e6925cbfc657e2868d": "display",
        "029b8abd0f7e41ad8246d043b3557855": "microphone",
        "e18ed257e3ff43e4b1e307de91e51926": "fruit",
        "5b606feffb144619b09c66ecfb1b00b9": "seat-card",
        "7019f60de0c24382b6a0b62f915bdb44": "pen",
        "7c73c785819e4ed3a2e817226d9cbc80": "stationery",
        "244131e738b94548a2e2bcb816df178e": "projector",
        "5265ce98fb0c4dc3ac0bc492507f6bfa": "screen",
        "353b188731d44dd18db6a3b48f44bffc": "stereo",
        "898483b4a23349588ac422998be76c33": "vedio-camera",
        "e332651a868f4a599d3b7f90c182ac06": "whiteboard",
        "a10586b313bd4c25905d99d03441ccbc": "wifi",
        "a2f6d727f2f4432589a0d29bf47203fa": "wired-network",
        "9f0f785b0f7e400da4803be21c0e6d6c": "tea"
    };
    $(".equipments i").each(function (index, item) {
        $(item).addClass("icon-" + equipmentClassMap[$(item).attr("id")]);
    })

    function floaddata() {
        $.zjm_optManager.initTable();
    };

    /**
     * 新增担保措施
     */
    $("#btn_room_add").click(function () {
        window.parent.openMenu('meetingRoomAdd', '', '添加会议室', '/oa/meetingRoom/add', '');
    });

    $(".operate-group i").on("click", function () {
        var $this = $(this);
        var roomId = $this.parents(".meeting-room").attr("id");

        if ($this.is(".icon-pencil")) {
            window.parent.openMenu('meetingRoomEdit', '', '编辑会议室', '/oa/meetingRoom/edit?roomID=' + roomId, '');
        } else if ($this.is(".icon-trash")) {
            $("#delCooperation").modal({keyboard: true});
            $("#confirm").on("click", function () {
                $.ajax({
                    type: 'post',
                    url: '/oa//meetingRoom/delete',
                    data: JSON.stringify({meetingRoom_ID: roomId}),
                    contentType: 'application/json; charset=UTF-8',
                    dataType: 'json',
                    success: function (result) {
                        $("#delCooperation").modal("hide");
                        if (result.obj === 1) {
                            $this.parents(".meeting-room").remove();
                            floaddata();
                        } else {
                            $("#failDel").modal({keyboard: true});
                        }
                    }
                })
            })
        }
    })
});


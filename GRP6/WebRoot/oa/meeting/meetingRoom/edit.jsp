<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<style type="text/css">
    .cycle-btn-group .btn {
        padding: 4.5px 4.6px;
    }

    .cycle-btn-group .apply-day-input {
        display: none;
    }

    img#avatar {
        min-width: 80%;
    }

    #equipments i {
        cursor: hand;
    }

    #equipments i.active {
        background: #6fb3e0;
    }
</style>
<link href="/assets/css/iconfont.css" rel="stylesheet">
<div class="page-content"><!--begin页面内容  -->
    <form class="form-horizontal" id="meeting_room_edit">
        <br><br>
        <input type="hidden" name="meetingRoom_ID" id="meetingRoom_ID" value="${room.meetingRoom_ID}">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="meetingRoomName"><i
                            class="icon-asterisk orange"></i> 会议室名称： </label>

                    <div class="col-sm-9">
                        <input id="meetingRoomName" name="meetingRoomName" placeholder="会议室名称"
                               value="${room.meetingRoomName}"
                               class="col-xs-10 col-sm-5 validate[required,maxSize[25]]">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"> <i
                            class="icon-asterisk orange"></i>会议室管理员：</label>

                    <div class="col-sm-4 ">
                        <div class="managerSelectScope input-group">
                            <input type="hidden" name="managerIDList" id="managerIDList" value="${room.managerIDList}"/>
                            <input id="managerNameList"
                                   class="form-control validate[required]"
                                   autoField="managerIDList" value="${room.managerNameList}" dataValue="" readonly
                                   name="managerNameList" id="managerSelectScope"
                                   type="text"><span
                                class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
                        </div>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-sm-3 control-label no-padding-right" for="meetingRoomTypeID"><i
                            class="icon-asterisk orange"></i>会议室类型：</label>
                    <div class="col-sm-9 ">
                        <select class="col-xs-10 col-sm-5 validate[required]" id="meetingRoomTypeID"
                                name="meetingRoomTypeID">
                            <option value="">请选择</option>
                            <option value="72dcdd12337845308a114c4d2720f064"
                                    <c:if test="${room.meetingRoomTypeID eq '72dcdd12337845308a114c4d2720f064'}">selected</c:if>>
                                围桌型
                            </option>
                            <option value="0d9f29f0297f433fa9e77d8a4a597b20"
                                    <c:if test="${room.meetingRoomTypeID eq '0d9f29f0297f433fa9e77d8a4a597b20'}">selected</c:if>>
                                T型
                            </option>
                            <option value="4c4084d7ddad457683a0979d9974f48a"
                                    <c:if test="${room.meetingRoomTypeID eq '4c4084d7ddad457683a0979d9974f48a'}">selected</c:if>>
                                U型
                            </option>
                            <option value="6c9f096e584342c5b4480f43d292761e"
                                    <c:if test="${room.meetingRoomTypeID eq '6c9f096e584342c5b4480f43d292761e'}">selected</c:if>>
                                阶梯型
                            </option>
                            <option value="8ef10860207742ee8a4573a87c047595"
                                    <c:if test="${room.meetingRoomTypeID eq '8ef10860207742ee8a4573a87c047595'}">selected</c:if>>
                                接见式
                            </option>
                            <option value="8c4fd0925de3465d9ed04f5b8ed1c4d9"
                                    <c:if test="${room.meetingRoomTypeID eq '8c4fd0925de3465d9ed04f5b8ed1c4d9'}">selected</c:if>>
                                董事会型
                            </option>
                            <option value="d333b69db9a643c2b9ec921c4aa0f20f"
                                    <c:if test="${room.meetingRoomTypeID eq 'd333b69db9a643c2b9ec921c4aa0f20f'}">selected</c:if>>
                                宴会厅
                            </option>
                            <option value="070532d0a76049fca1bd5080bf81fea5"
                                    <c:if test="${room.meetingRoomTypeID eq '070532d0a76049fca1bd5080bf81fea5'}">selected</c:if>>
                                剧院
                            </option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="seating"><i
                            class="icon-asterisk orange"></i> 座位数：</label>

                    <div class="col-sm-9">
                        <input id="seating" name="seating" placeholder="座位数" type="number"
                               class="col-xs-10 col-sm-5 validate[required,,min[2]]"
                               value="${room.seating}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="openTime"> <i
                            class="icon-asterisk orange"></i>放开预约时间：</label>

                    <div class="col-sm-9">
                        <ul class="btn-group cycle-btn-group" id="openTime">
                            <li type="button"
                                class="btn 0th-of-week <c:if test="${fn:contains(room.openTime, '日')}">btn-success</c:if>"
                                data-action="applyDay">
                                <span>日</span>
                                <input
                                        type="checkbox" name="openDays" class="apply-day-input"
                                        <c:if test="${fn:contains(room.openTime, '日')}">checked</c:if>
                                        value="日"/>
                            </li>
                            <li type="button"
                                class="btn 1th-of-week <c:if test="${fn:contains(room.openTime, '一')}">btn-success</c:if>"
                                data-action="applyDay">
                                <span>一</span>
                                <input
                                        <c:if test="${fn:contains(room.openTime, '一')}">checked</c:if>
                                        type="checkbox" name="openDays" class="apply-day-input"
                                        value="一"/>
                            </li>
                            <li type="button"
                                class="btn  2th-of-week <c:if test="${fn:contains(room.openTime, '二')}">btn-success</c:if>"
                                data-action="applyDay">
                                <span>二</span>
                                <input
                                        <c:if test="${fn:contains(room.openTime, '二')}">checked</c:if>
                                        type="checkbox" name="openDays" class="apply-day-input"
                                        value="二"/>
                            </li>
                            <li type="button"
                                class="btn 3th-of-week <c:if test="${fn:contains(room.openTime, '三')}">btn-success</c:if>"
                                data-action="applyDay">
                                <span>三</span>
                                <input
                                        <c:if test="${fn:contains(room.openTime, '三')}">checked</c:if>
                                        type="checkbox" name="openDays" class="apply-day-input"
                                        value="三"/>
                            </li>
                            <li type="button"
                                class="btn 4th-of-week <c:if test="${fn:contains(room.openTime, '四')}">btn-success</c:if>"
                                data-action="applyDay">
                                <span>四</span>
                                <input
                                        <c:if test="${fn:contains(room.openTime, '四')}">checked</c:if>
                                        type="checkbox" name="openDays" class="apply-day-input"
                                        value="四"/>
                            </li>
                            <li type="button"
                                class="btn 5th-of-week <c:if test="${fn:contains(room.openTime, '五')}">btn-success</c:if>"
                                data-action="applyDay">
                                <span>五</span>
                                <input
                                        <c:if test="${fn:contains(room.openTime, '五')}">checked</c:if>
                                        type="checkbox" name="openDays" class="apply-day-input"
                                        value="五"/>
                            </li>
                            <li type="button"
                                class="btn 6th-of-week <c:if test="${fn:contains(room.openTime, '六')}">btn-success</c:if>"
                                data-action="applyDay">
                                <span>六</span>
                                <input
                                        <c:if test="${fn:contains(room.openTime, '六')}">checked</c:if>
                                        type="checkbox" name="openDays" class="apply-day-input"
                                        value="六"/>
                            </li>
                        </ul>

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="position"> <i
                            class="icon-asterisk orange"></i>位置：</label>

                    <div class="col-sm-9">
                        <input id="position" name="position" placeholder="位置"
                               class="col-xs-10 col-sm-5 validate[required,maxSize[50]]"
                               value="${room.position}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right"><i
                            class="icon-asterisk orange"></i>申请权限：</label>
                    <input type="hidden" name="userIDList" id="userIDList" value="${room.userIDList}"
                           class="validate[required]">
                    <input type="hidden" name="userNameList" id="userNameList" value="${room.userNameList}"
                           class="validate[required]">
                    <div class="col-sm-9">
                        <div class="widget-box col-sm-6" style="max-height:500px;OVERFLOW: auto; ">
                            <div class="widget-header">
                                <h4>选择人员</h4>
                            </div>
                            <div class="widget-body" style="min-height:200px;">
                                <div class="widget-main padding-8">
                                    <ul id="userSetTree" class="ztree"></ul>
                                </div>
                            </div>
                        </div>

                        <div class="widget-box col-sm-offset-1 col-sm-4" style="max-height:500px;OVERFLOW: auto; ">
                            <div class="widget-header">
                                <h4>已选人员</h4>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main padding-8" style="min-height:200px;">
                                    <div id="userName"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="remark"> 描述： </label>

                    <div class="col-sm-9">
                         <textarea id="remark" name="remark"
                                   class="autosize-transition form-control ztb_add_remark ztb_add validate[maxSize[250]]"
                                   placeholder="描述不要超过250个字符..."
                                   style="overflow: hidden; overflow-wrap: break-word; resize: horizontal; height: 52px;">${room.remark}</textarea>
                    </div>
                </div>

            </div>
            <div class="col-sm-4">
                <div class="control-group">
                    <label class="control-label">会议室配置：</label>
                    <div class="controls">
                        <img src="<%=path%>${room.picturePath}" class="img-responsive editable " id="avatar">
                    </div>
                </div>
                <div class="space-8"></div>
                <div class="control-group">
                    <label class="control-label">选用设备：</label>
                    <br><br>
                    <div class="controls" id="equipments">
                        <i class="iconfont icon-labtop well well-sm <c:if test="${fn:contains(room.equipmentIDList, 'b2a1bcda926848c480ee1e5977182633')}">active</c:if>"
                           id="b2a1bcda926848c480ee1e5977182633"
                           title="笔记本电脑"></i>
                        <i class="iconfont icon-banner well well-sm <c:if test="${fn:contains(room.equipmentIDList, '98499bb97a434d769c1f51511a48ab98')}">active</c:if>"
                           id="98499bb97a434d769c1f51511a48ab98"
                           title="横幅"></i>
                        <i class="iconfont icon-camera well well-sm <c:if test="${fn:contains(room.equipmentIDList, 'bc6c8a8031d44a92b1a5779e31de5e89')}">active</c:if>"
                           id="bc6c8a8031d44a92b1a5779e31de5e89"
                           title="相机"></i>
                        <i class="iconfont icon-display well well-sm <c:if test="${fn:contains(room.equipmentIDList, '40cdf457a27348e6925cbfc657e2868d')}">active</c:if>"
                           id="40cdf457a27348e6925cbfc657e2868d"
                           title="显示屏"></i>
                        <i class="iconfont icon-microphone well well-sm <c:if test="${fn:contains(room.equipmentIDList, '029b8abd0f7e41ad8246d043b3557855')}">active</c:if>"
                           id="029b8abd0f7e41ad8246d043b3557855"
                           title="麦克风"></i>
                        <i class="iconfont icon-fruit well well-sm <c:if test="${fn:contains(room.equipmentIDList, 'e18ed257e3ff43e4b1e307de91e51926')}">active</c:if>"
                           id="e18ed257e3ff43e4b1e307de91e51926"
                           title="水果"></i>
                        <i class="iconfont icon-seat-card well well-sm <c:if test="${fn:contains(room.equipmentIDList, '5b606feffb144619b09c66ecfb1b00b9')}">active</c:if>"
                           id="5b606feffb144619b09c66ecfb1b00b9"
                           title="座位卡"></i>
                        <i class="iconfont icon-recording-pen well well-sm <c:if test="${fn:contains(room.equipmentIDList, '7019f60de0c24382b6a0b62f915bdb44')}">active</c:if>"
                           id="7019f60de0c24382b6a0b62f915bdb44"
                           title="录音笔"></i>
                        <i class="iconfont icon-stationery well well-sm <c:if test="${fn:contains(room.equipmentIDList, '7c73c785819e4ed3a2e817226d9cbc80')}">active</c:if>"
                           id="7c73c785819e4ed3a2e817226d9cbc80"
                           title="文具"></i>
                        <i class="iconfont icon-projector well well-sm <c:if test="${fn:contains(room.equipmentIDList, '244131e738b94548a2e2bcb816df178e')}">active</c:if>"
                           id="244131e738b94548a2e2bcb816df178e"
                           title="投影仪"></i>
                        <i class="iconfont icon-screen well well-sm <c:if test="${fn:contains(room.equipmentIDList, '5265ce98fb0c4dc3ac0bc492507f6bfa')}">active</c:if>"
                           id="5265ce98fb0c4dc3ac0bc492507f6bfa"
                           title="投影幕"></i>
                        <i class="iconfont icon-stereo well well-sm <c:if test="${fn:contains(room.equipmentIDList, '353b188731d44dd18db6a3b48f44bffc')}">active</c:if>"
                           id="353b188731d44dd18db6a3b48f44bffc"
                           title="音响"></i>
                        <i class="iconfont icon-vedio-camera well well-sm <c:if test="${fn:contains(room.equipmentIDList, '898483b4a23349588ac422998be76c33')}">active</c:if> id="
                           898483b4a23349588ac422998be76c33"
                        title="摄像机"></i>
                        <i class="iconfont icon-whiteboard well well-sm <c:if test="${fn:contains(room.equipmentIDList, 'e332651a868f4a599d3b7f90c182ac06')}">active</c:if>"
                           id="e332651a868f4a599d3b7f90c182ac06"
                           title="白板"></i>
                        <i class="iconfont icon-wifi well well-sm <c:if test="${fn:contains(room.equipmentIDList, 'a10586b313bd4c25905d99d03441ccbc')}">active</c:if>"
                           id="a10586b313bd4c25905d99d03441ccbc"
                           title="无线网络"></i>
                        <i class="iconfont icon-wired-network well well-sm <c:if test="${fn:contains(room.equipmentIDList, 'a2f6d727f2f4432589a0d29bf47203fa')}">active</c:if>"
                           id="a2f6d727f2f4432589a0d29bf47203fa"
                           title="有线网络"></i>
                        <i class="iconfont icon-tea well well-sm <c:if test="${fn:contains(room.equipmentIDList, '9f0f785b0f7e400da4803be21c0e6d6c')}">active</c:if>"
                           id="9f0f785b0f7e400da4803be21c0e6d6c" title="茶水"></i>

                    </div>
                </div>

            </div>

        </div>
        <br>
        <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
                <button class="btn btn-info" type="submit" id="submit">
                    <i class="ace-icon fa fa-check bigger-110"></i>
                    保存
                </button>

                &nbsp; &nbsp; &nbsp;
                <button class="btn" type="button" id="close">
                    <i class="ace-icon fa fa-undo bigger-110"></i>
                    关闭
                </button>
            </div>
        </div>
    </form>
</div>
<!-- /.col --><!--end 响应式列 -->

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>
<%@ include file="/oa/meeting/pictureUpload.jsp" %>
<script src="<%=path%>/oa/meeting/js/roomEdit.js?v=<%=vardate%>"></script>
<script src="<%=path%>/oa/meeting/js/treeUser.js?v=<%=vardate%>"></script>
<script src="<%=path%>/assets/js/chosen.jquery.min.js"></script>
<script src="<%=path%>/assets/js/jquery.bootstrap-duallistbox.min.js"></script>
<link rel="stylesheet" href="<%=path %>/assets/css/iconfont.css?v=<%=vardate%>"/>
<script src="<%=path %>/plugins/plupload/plupload.full.min.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/plupload/i18n/zh_CN.js?v=<%=vardate%>"></script>
<script src="<%=path %>/plugins/viewer/viewer.min.js?v=<%=vardate%>"></script>
<script type="text/javascript">


    $("#equipments").on("click", "i", function () {
        $(this).toggleClass("active");
    })
    $("#openTime").on("click", ".btn", function () {
        var checkbox = $(this).find('input');
        $(this).toggleClass("btn-success");
        console.log(checkbox.is(":checked"))
        checkbox.prop("checked", !checkbox.is(":checked"));

    });
    $.zjm_zTreeUser.initTree("userSetTree", "userIDList", "userNameList", "/sys/dic/selectDepartsUserTreeTwo");

    $('.chosen-select').chosen({allow_single_deselect: true});
    //resize the chosen on window resize

    $(window)
        .off('resize.chosen')
        .on('resize.chosen', function () {
            $('.chosen-select').each(function () {
                var $this = $(this);
                $this.next().css({'width': $this.parent().width()});
            })
        }).trigger('resize.chosen');
    //resize chosen on sidebar collapse/expand
    $(document).on('settings.ace.chosen', function (e, event_name, event_val) {
        if (event_name != 'sidebar_collapsed') return;
        $('.chosen-select').each(function () {
            var $this = $(this);
            $this.next().css({'width': $this.parent().width()});
        })
    });


    $('#chosen-multiple-style .btn').on('click', function (e) {
        var target = $(this).find('input[type=radio]');
        var which = parseInt(target.val());
        if (which == 2) $('#form-field-select-4').addClass('tag-input-style');
        else $('#form-field-select-4').removeClass('tag-input-style');
    });
    var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox({infoTextFiltered: '<span class="label label-purple label-lg">过滤</span>'});
    var container1 = demo1.bootstrapDualListbox('getContainer');
    container1.find('.btn').addClass('btn-white btn-info btn-bold');
</script>
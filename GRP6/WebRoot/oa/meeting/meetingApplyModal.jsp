<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<style type="text/css">
    #equipments i.unavailable {
        display: none;
    }

    #add_meeting {
        overflow-y: scroll;
    }
</style>
<div class="modal fade" id="add_meeting" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">会议申请</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="form">
                    <div class="space-8"></div>
                    <input type="hidden" name="meeting_ID" value="${entityID}" id="meeting_ID">
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="meetingName"> <i
                                        class="icon-asterisk orange"></i>会议名称：</label>

                                <div class="col-sm-9">
                                    <input id="meetingName" name="meetingName" placeholder="会议名称" class="col-sm-10 validate[required, maxSize[25]]">
                                </div>
                            </div>


                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="meetingDate">
                                	<i class="icon-asterisk orange"></i> 会议日期：
                               	</label>
                               	<div class=" col-sm-9">
                               		<div class="input-group col-sm-8">
                                        <!-- <input class="form-control date-picker validate[required,funcCall[checkMeetingDate]] "
                                               id="meetingDate" data-date-format="yyyy-mm-dd"/> -->
                                               
                                        <input type="text" id="meetingDate" onfocus="WdatePicker({minDate:'%y-%M-%d'})" placeholder="会议日期"
                                        		class="Wdate form-control validate[required,funcCall[checkMeetingDate]]" />
                                        		
                                        <span class="input-group-addon">
                                        	<i class="icon-calendar bigger-110"></i> 
                                        </span>
                                    </div>
                               	</div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="beginTime"> <i
                                        class="icon-asterisk orange"></i>会议开始时间：</label>

                                <div class="col-sm-9">
                                	<div class="col-sm-8 input-group bootstrap-timepicker ">
                                        <!-- <input id="beginTime"
                                               class="form-control timepicker validate[required,funcCall[checkBeginTime]]"/> -->
                                        <input type="text" id="beginTime" onfocus="WdatePicker({dateFmt:'HH:mm:00',minDate:'9:30:00',maxDate:'11:30:00'})" placeholder=""
                                        		class="form-control Wdate minDate validate[required,funcCall[checkBeginTime]]"/>
                                        <span class="input-group-addon">
											<i class="icon-time bigger-110"></i>
										</span>
                                    </div>
                                    

                                </div>
                            </div>
                            

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="endTime"><i
                                        class="icon-asterisk orange"></i>会议结束时间：</label>

                                <div class="col-sm-9">
                                    <div class="col-sm-8 input-group bootstrap-timepicker ">
                                        <!-- <input id="endTime"
                                               class="form-control timepicker validate[required,funcCall[checkEndTime]]"/> -->
                                        <input type="text" id="endTime" onfocus="WdatePicker({dateFmt:'HH:mm:00',minDate:'9:30:00',maxDate:'11:30:00'})" placeholder=""
                                        		class="form-control Wdate validate[required,funcCall[checkEndTime]]"/>       
                                        <span class="input-group-addon">
											<i class="icon-time bigger-110"></i>
										</span>
                                    </div>

                                </div>
                            </div>

							<div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="compereName"><i
                                        class="icon-asterisk orange"></i>会议主持人：</label>
                                <div class="col-sm-9">
                                    <div class="compereName input-group col-sm-8">
                                        <input id="compereName" name="compereName" placeholder="" class="form-control validate[required]" autoField="compereID" dataValue="" readonly type="text"><span class="input-group-addon ">
									<i class="icon-caret-down bigger-110"></i>
								</span>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"><i
                                        class="icon-asterisk orange"></i>出席人员：</label>

                                <div class="col-sm-9">
                                    <input type="hidden" name="membersIDList" id="membersIDList"
                                           class="validate[required]">
                                    <input type="hidden" name="membersNameList" id="membersNameList"
                                           class="validate[required]">
                                    <div class="widget-box col-sm-6"><!-- style="max-height:500px;OVERFLOW: auto; -->
                                        <div class="widget-header">
                                            <h4>选择人员</h4>
                                        </div>
                                        <div class="widget-body" style="height:201px;OVERFLOW: auto;"><!-- min-height:200px; -->
                                            <div class="widget-main padding-8">
                                                <ul id="userSetTree" class="ztree"></ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="widget-box col-sm-offset-1 col-sm-4"
                                         ><!-- style="max-height:500px;OVERFLOW: auto; " -->
                                        <div class="widget-header">
                                            <h4>已选人员</h4>
                                        </div>
                                        <div class="widget-body">
                                            <div class="widget-main padding-8" style="height:200px;OVERFLOW: auto;"><!-- min-height:200px; -->
                                                <div id="userName"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="outMembers">外部出席人员</label>
                                <div class="col-sm-9">
			                        <textarea id="outMembers" name="outMembers"  class="autosize-transition form-control " placeholder="外部出席人员请以逗号隔开"></textarea>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="subject"><i
                                        class="icon-asterisk orange"></i>主要议题：</label>
                                <div class="col-sm-9">
		                        	<textarea id="subject" name="subject" class="autosize-transition form-control validate[required,maxSize[200]]" placeholder=""></textarea>
                                	<div class="col-sm-12 no-padding-right">
                                		<span class="light-grey" style="float:right;">限制250个字符</span>
                                	</div>
                                </div>
                                
                            </div>
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="remark">备注:</label>
                                <div class="col-sm-9">
		                             <textarea id="remark" name="remark" class="autosize-transition form-control validate[maxSize[200]]"  placeholder=" " ></textarea>
                                	<div class="col-sm-12 no-padding-right">
                                		<span class="light-grey" style="float:right;">限制250个字符</span>
                                	</div>
                                </div>
                            </div>
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="attachment">附件:</label>
                                <div class="col-sm-9">
                                    <button class="btn btn-sm btn-info" type="button" name="button" id="attachment">
                                        上传
                                    </button>
                                    <div id="attachmentsDIV" class=""></div>
                                    <%--<label><input type="file" multiple alt="附件"><span>附件大小不得超过20M</span></label>--%>
                                </div>
                            </div>

                        </div>
                        <div class="col-sm-4">

                            <div class="form-group">
                                <label class="col-sm-4 control-label no-padding-right" for="meetingRoomID"><i
                                        class="icon-asterisk orange"></i>会议室：</label>
                                <div class="col-sm-8 no-padding-right">
                                    <select class="col-xs-10 validate[required]" id="meetingRoomID"
                                            name="meetingRoomID">
                                        <!-- <option value="">--请选择--</option> -->
                                        <c:forEach var="room" items="${rooms}" varStatus="status">
                                            <option value="${room.meetingRoom_ID}">${room.meetingRoomName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="space-8"></div>
                            <div class="control-group">

                                <div class="controls">
                                    <img src="/oa/meeting/picture/room.png" class="img-responsive editable "
                                         id="avatar">
                                </div>
                            </div>
                            <div class="space-8"></div>
                            <div class="control-group">
                                <label class="control-label">可用设备：</label>
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
                        <div class="space-4"></div>

                    </div>

                </form>

            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-primary" id="submit"><i class='icon-ok bigger-110'></i> 保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><i
                        class='icon-remove bigger-110'></i>关闭
                </button>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/chosen.jquery.min.js"></script>
<script src="/assets/js/date-time/bootstrap-timepicker.min.js"></script>
<link rel="stylesheet" href="/assets/css/iconfont.css"/>
<script src="/plugins/plupload/plupload.full.min.js"></script>
<script src="/plugins/plupload/i18n/zh_CN.js"></script>
<script src="/plugins/viewer/viewer.min.js"></script>
<script src="/oa/meeting/js/treeUser.js"></script>

<script src="/assets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    function initModal() {
        $.zjm_zTreeUser.initTree("userSetTree", "membersIDList", "membersNameList", "/sys/dic/selectDepartsUserTreeTwo");
        $.ajax({
            type: 'POST',
            url: '/sys/dic/selectDepartsUserTreeTwo',
            data: JSON.stringify({}),
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (data) {
                $("#compereName").selectTreeWidgets({
                    width: "65%",//设置控件宽度
                    multiple: false,//是否多选
                    data: data.obj//数据源
                });
            }
        });
        $('.timepicker').timepicker({
            minuteStep: 60,
            showMeridian: false,
            disableFocus: true,
            icons: {
                up: 'fa fa-chevron-up',
                down: 'fa fa-chevron-down'
            }
        }).on('focus', function () {
            $(this).timepicker('showWidget');
        }).next().on(ace.click_event, function () {
            $(this).prev().focus();
        });
        
        $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
            $(this).prev().focus();
        });
        
        $('.input-group-addon').click(function (){
        	$('#meetingDate').focus();
        });
        
        
        $("#meetingRoomID").on("change", function () {
            var meetingRoomID = $(this).children('option:selected').val();
            $.get("/oa/meetingRoom/get", {id: meetingRoomID}, function (data) {
                var meetingRoom = data.obj;
                if (meetingRoom.picturePath) {
                    $("#avatar").attr("src", meetingRoom.picturePath);
                }
                if (meetingRoom.equipmentIDList) {
                    $("#equipments i").each(function (index, item) {
                        if (meetingRoom.equipmentIDList.indexOf($(item).attr("id")) < 0) {
                            $(item).addClass("unavailable");
                        } else {
                            $(item).removeClass("unavailable");
                        }
                    })
                }
            })
        })
        $("#submit").on("click", function () {
            $("#form").submit();
        })
        $("#form").validationEngine();
        $("#form").on("submit", function () {
            var $form = $("#form");
            var data = $form.serializeJson();

            var meetingDate = $("#meetingDate").val();
            var beginTime = $("#beginTime").val();
            var endTime = $("#endTime").val();
            data.meetingBeginDateTime = meetingDate + " " + beginTime;
            data.meetingEndDateTime = meetingDate + " " + endTime;
            data.meetingRoomName = $("#meetingRoomID option:selected").text().trim();
            delete  data.hour;
            delete  data.minute;
            delete  data.second;

            if ($form.validationEngine("validate")) {
                $.ajax({
                    type: 'post',
                    url: '/oa//meeting/save',
                    data: JSON.stringify(data),
                    contentType: 'application/json; charset=UTF-8',
                    dataType: 'json',
                    success: function (result) {
                        if (result.obj === 1) {
                            $("#add_meeting").modal("hide");
                            $("#pleaseSelectOne #message").text("操作成功！");
                            $("#pleaseSelectOne").modal({keyboard: true});

                        } else {
                            $("#pleaseSelectOne #message").text("操作失败，请重试！");
                            $("#pleaseSelectOne").modal({keyboard: true});
                        }

                    }
                })
            }
            return false;
        })
    }


    function checkMeetingDate(field, rules, i, options) {
        var meetingDate = new Date(field.val());
        var currentDate = new Date();
        if (meetingDate < currentDate) {
            return "会议时间不能晚于今天";
        }
    } 

    function checkBeginTime(field, rules, i, options) {
        if (field.val() < "09:30" || field.val() > "11:30") {
            return "会议时间只能设定在09：30到11：30之间！";
        }
    }

    function checkEndTime(field, rules, i, options) {
        if (field.val() < "09:30" || field.val() > "11:30") {
            return "会议时间只能设定在09：30到11：30之间！";
        }
        if (field.val() <= $("#beginTime").val()) {
            return "会议结束时间应大于开始时间！";
        }
    }

</script>
<script src="/oa/meeting/js/uploadAttachment.js"></script>
<%@ include file="/oa/meeting/uploadAttachments.jsp" %>
<%@ include file="/common_message.jsp" %>
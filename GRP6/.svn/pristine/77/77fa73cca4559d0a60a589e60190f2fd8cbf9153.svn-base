<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<style type="text/css">
    #equipments i:not(.active) {
        display: none;
    }

    #add_meeting {
        overflow-y: scroll;
    }
</style>
<div class="modal fade" id="view_meeting" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">会议详情</h4>
                 <input type="hidden" name="meeting_ID" value="${meeting.meeting_ID}" id="meeting_ID" readonly>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="form">
                    <div class="space-8"></div>                   
                   
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="meetingName"> 会议名称：</label>
                                <label class="col-sm-9 light-grey"> ${meeting.meetingName}</label>
                            </div>


                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="meetingDate">会议日期：</label>
								<label class="col-sm-9 light-grey"> 
									<fmt:formatDate pattern="YYYY年MM月dd日" value="${meeting.meetingBeginDateTime}"/>
								</label>
                              
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="beginTime"> 会议开始时间：</label>
	                            <label class="col-sm-9 light-grey"> 
	                            	<fmt:formatDate pattern="HH:mm" value="${meeting.meetingBeginDateTime}"/>
	                            </label>
                            </div>


                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="endTime"> 会议结束时间：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	<fmt:formatDate pattern="HH:mm"  value="${meeting.meetingEndDateTime}"/>
	                            </label>

                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">出席人员：</label>
                                 <label class="col-sm-9 light-grey"> 
	                            	${meeting.membersNameList}
	                            </label>
                            </div>
                            
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="compereName">会议主持人：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	${meeting.compereName}
	                            </label>
                               
                            </div>
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="outMembers">外部出席人员：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	${meeting.outMembers}
	                            </label>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="subject">主要议题：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	${meeting.subject}
	                            </label>
                            </div>
                            
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="subject">申请人：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	${meeting.createUserName}
	                            </label>
                            </div>
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="subject">申请时间：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	<fmt:formatDate pattern="YYYY年MM月dd日 HH:mm:ss" value="${meeting.createDateTime}"/>
	                            </label>
                            </div>
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="subject">审核状态：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	<c:choose>
	                            		<c:when test="${meeting.status eq '0'}">待审核</c:when>
	                            		<c:when test="${meeting.status eq '1'}">通过</c:when>
	                            		<c:when test="${meeting.status eq '3'}">未通过</c:when>
	                            		<c:otherwise>撤销</c:otherwise>
	                            	</c:choose>
	                            </label>
                            </div>
                            
                            <div class="space-4"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">会议室管理员：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	${room.managerNameList}
	                            </label>
                            </div>
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="remark">备注：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	${meeting.remark}
	                            </label>
                            </div>
                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">附件：</label>
                                <div class="col-sm-9">
                                    <div class="space-2"></div>
                                    <div id="attachmentsDIV" class="">
                                        <c:forEach var="attachment" items="${attachments}">
                                            <div id="${attachment.files_ID}">
                                                <a href="#">${attachment.sourceFileName}</a>
                                                <br>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <%--<label><input type="file" multiple alt="附件"><span>附件大小不得超过20M</span></label>--%>
                                </div>
                            </div>

                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="meetingRoomID">会议室：</label>
                                <label class="col-sm-9 light-grey"> 
	                            	${room.meetingRoomName}
	                            </label>
                            </div>
                            <div class="space-8"></div>
                            <div class="control-group">

                                <div class="controls">
                                    <img src="${room.picturePath}" class="img-responsive editable "
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
                                    <i class="iconfont icon-vedio-camera well well-sm <c:if test="${fn:contains(room.equipmentIDList, '898483b4a23349588ac422998be76c33')}">active</c:if>"
                                       id="898483b4a23349588ac422998be76c33" title="摄像机"></i>
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
                <button type="button" class="btn btn-default" data-dismiss="modal">
                <i class="icon-remove bigger-110"></i>关闭
                </button>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/assets/css/iconfont.css"/>
<script src="/plugins/viewer/viewer.min.js"></script>
<script src="/oa/meeting/js/treeUser.js"></script>
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
                    width: "93%",//设置控件宽度
                    multiple: false,//是否多选
                    data: data.obj//数据源
                });
            }
        });
    }

</script>

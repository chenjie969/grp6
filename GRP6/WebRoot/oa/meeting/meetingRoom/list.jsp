<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<link rel="stylesheet" href="<%=path %>/assets/css/iconfont.css?v=<%=vardate%>"/>
<style type="text/css">
    .operate-group i {
        cursor: pointer;
    }
</style>
<div class="page-content"><!--begin页面内容  -->
    <div id="meeting_room_list">
        <c:forEach var="room" items="${rooms}">
            <div class="row meeting-room" id="${room.meetingRoom_ID}">
                <div class="col-sm-4 well" style="height: 32rem;">
                    <div class="row">
                        <div class="col-sm-8"><h4>${room.meetingRoomName}</h4></div>

                        <div class="col-sm-offset-1 col-sm-3"><i
                                class="ace-icon glyphicon glyphicon-map-marker"></i>${room.position}
                        </div>
                    </div>
                    <div class="space-8"></div>
                    <div class="row">
                        <div class="col-sm-5"><h5>周${room.openTime}开放预约</h5></div>
                    </div>
                    <div class="space-8"></div>
                    <div class="row">
                        <div class="col-sm-7">
                            <h5>
                            <c:if test="${fn:length(room.remark)>'13'}">
                                ${fn:substring(room.remark,0,13)}...
                            </c:if>
                            <c:if test="${fn:length(room.remark)<='13'}">
                                ${room.remark}
                            </c:if>
                        </h5>
                        </div>
                    </div>
                    <div class="space-8"></div>
                    <div class="row">
                        <div class="col-sm-7 equipments">
                            <c:forEach var="eID" items="${room.equipmentIDList}">
                                <i class="iconfont" id="${eID}"></i>&nbsp;
                            </c:forEach>
                        </div>


                        <div class="col-sm-offset-3 col-sm-2 hidden operate-group">
                            <i class="icon-pencil blue bigger-150" title="编辑"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i
                                class="icon-trash red bigger-150" title="删除"></i></div>
                    </div>

                    <div class="row" style="bottom: 0;position: absolute;width: 100%;">
                        <div class="col-sm-4 btn">
                            <h6 class="text-center">${room.seating}</h6>
                            <div class="text-center">座位</div>
                        </div>
                        <div class="col-sm-4 btn">
                            <h6 class="text-center">${room.meetingRoomTypeName}</h6>
                            <div class="text-center">类型</div>
                        </div>
                        <div class="col-sm-4 btn">
                            <h6 class="text-center">
                                <c:forEach var="name" items="${room.managerNameList}" varStatus="status">
                                    <c:choose>
                                        <c:when test="${status.count <=3 &&status.last}">
                                            ${name}
                                        </c:when>
                                        <c:when test="${status.count <3 && !status.last}">
                                            ${name},
                                        </c:when>
                                        <c:when test="${status.count ==3 && !status.last}">
                                            ${name}
                                        </c:when>
                                        <c:when test="${status.count ==4}">
                                            ...
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </h6>
                            <div class="text-center">管理员</div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 well" style="height: 32rem;">
                    <img src="<%=path%>${room.picturePath}" class="img-responsive">
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col-sm-7">
            <button type="button" id="btn_room_add" class="btn btn-info btn-block">添加会议室</button>
        </div>
    </div>
</div>
<!-- /.col --><!--end 响应式列 -->

<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_succeed.jsp" %>
<script src="<%=path%>/oa/meeting/js/roomList.js?v=<%=vardate%>"></script>


<script type="text/javascript">
    $("#meeting_room_list").on("mouseenter", ".meeting-room", function () {
        $(this).find(".operate-group").removeClass("hidden")
    }).on("mouseleave", ".meeting-room", function () {
        $(this).find(".operate-group").addClass("hidden");
    })

    //    $(".meeting-room").mouseenter(function () {
    //        $(this).find(".edit-href").removeClass("hidden")
    //    }).mouseleave(function () {
    //        $(this).find(".edit-href").addClass("hidden");
    //    })
</script>
<%@ include file="/oa/meeting/meetingRoom/deleteModal.jsp" %>
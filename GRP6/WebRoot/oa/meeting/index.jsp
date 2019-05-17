<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common_timestamp.jsp" %>
<%@ include file="/common_head.jsp" %>
<link rel="stylesheet" href="<%=path %>/assets/css/fullcalendar.min.css?v=<%=vardate%>"/>
<link rel="stylesheet" href="<%=path %>/assets/css/jquery.qtip.min.css?v=<%=vardate%>"/>
<style type="text/css">
    .meeting-room {
        cursor: pointer;
    }

    .meeting-room.active {

    }
</style>
<div class="page-content"><!--begin页面内容  -->
    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                <div class="cos-sm-offset-1 col-sm-10">
                    <div class="page-header">
                        <button type="button" class="btn btn-sm btn-info" id="active_apply_modal">申请会议</button>&nbsp;
                    </div>
                </div>
            </div>
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->
    <div class="tabbable">
        <ul class="nav nav-tabs" id="myTab">
            <li class="active">
                <a data-toggle="tab" href="#tab_meeting_apply">
                    会议申请
                </a>
            </li>

            <li>
                <a data-toggle="tab" href="#tab_meeting_record">
                    申请记录

                </a>
            </li>


        </ul>

        <div class="tab-content">
            <div id="tab_meeting_apply" class="tab-pane in active">
                <div class="space-12"></div>
                <div class="row">
                    <div class="col-sm-9">
                        <div id="calendar"></div>
                    </div>
                    <div class="col-sm-3">
                        <div>
                            <div class="row">
                                <h3 class="">&nbsp;&nbsp;会议室</h3>
                            </div>
                            <div class="space-2"></div>

                            <div class="list-group">
                                <c:forEach var="room" items="${rooms}" varStatus="status">
                                    <a class="list-group-item meeting-room <c:if test="${status.first}">active</c:if>"
                                       id="${room.meetingRoom_ID}">${room.meetingRoomName}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div id="tab_meeting_record" class="tab-pane">

            </div>


        </div>
    </div>
</div>
<!-- /.col --><!--end 响应式列 -->
<div id="applyModal"></div>
<%@ include file="/common_foot.jsp" %>
<%@ include file="/common_message.jsp" %>

<script src="<%=path%>/oa/meeting/js/index.js?v=<%=vardate%>"></script>
<script src="<%=path%>/assets/js/fullcalendar/moment.min.js?v=<%=vardate%>"></script>
<script src="<%=path%>/assets/js/fullcalendar/fullcalendar.min.js?v=<%=vardate%>"></script>
<script src="<%=path%>/assets/js/fullcalendar/locale/zh-cn.js?v=<%=vardate%>"></script>
<script src="<%=path%>/assets/js/fullcalendar/jquery.qtip.min.js?v=<%=vardate%>"></script>
<script type="text/javascript">


</script>
<div id="meetingView">

</div>